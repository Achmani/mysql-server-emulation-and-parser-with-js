package id.mit.chrono.server.obj;

import com.google.common.base.Stopwatch;
import id.mit.chrono.server.iface.FileDownloader;
import id.mit.chrono.server.model.tables.records.CrcollectortaskfilesRecord;
import id.mit.chrono.server.model.tables.records.CrcollectortasksourcesRecord;
import id.mit.chrono.server.model.tables.records.CrdatasourceRecord;
import id.mit.chrono.server.model.tables.records.CrdatasourcecommandsRecord;
import id.mit.chrono.server.util.EpochUtils;
import id.mit.chrono.server.util.FileUtils;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.jooq.DSLContext;
import org.jooq.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.*;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import static id.mit.chrono.server.model.Tables.*;

public class DownloadWorker implements Runnable {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private DSLContext db;
    private CrdatasourceRecord ds;
    private ChronoContext context;

    private FileDownloader c;
    protected Stopwatch stopwatchRuntime;
    private boolean replace;

    private Thread myThread;

    private int totalFiles = 0;
    private int totalNewFiles = 0;

    private int collectorStatus = 0;
    private String collectorStatusReason = null;

    private Result<CrdatasourcecommandsRecord> commands;

    protected Connection con;
    protected Statement stmt;
    protected ResultSet rs;
    ResultSetMetaData rsmd;

    private String localDirPath;

    public DownloadWorker(DSLContext db, CrdatasourceRecord ds, ChronoContext context, boolean replace){

        this.db = db;
        this.ds = ds;
        this.context = context;
        this.replace = replace;

        this.stopwatchRuntime = Stopwatch.createStarted();

        this.myThread = new Thread(this, ds.getDatasourceName());
        this.myThread.start();
    }

    public void forceFinish(){

        if(this.myThread != null && this.myThread.isAlive()){

            if(c != null && c.isConnected()){
                c.disconnect();
            }

            this.myThread.interrupt();

            stopwatchRuntime.stop();
            logger.debug(this.ds.getDatasourceName() + " forced finished in " + stopwatchRuntime.elapsed(TimeUnit.MILLISECONDS) + " ms");
        }

        saveSourceLog();
    }

    public void join(){

        if(this.myThread != null && this.myThread.isAlive()){
            try {
                this.myThread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void run() {

        logger.debug(this.ds.getDatasourceName() + " started");

        this.getFile();
        this.performCommand();
        this.endTask();
    }

    private void getFile(){

        // select downloader type
        if(ds.getDatasourceProtocol().equals("SFTP")){

            c = new SFTPCl(ds.getDatasourceIpaddress(), ds.getDatasourcePort(), ds.getDatasourceUsername(), ds.getDatasourcePassword());
        }
        else if(ds.getDatasourceProtocol().equals("FTP")){

            c = new FTPCl(ds.getDatasourceIpaddress(), ds.getDatasourcePort(), ds.getDatasourceUsername(), ds.getDatasourcePassword());
        }
        else{

            logger.error(this.ds.getDatasourceName() + " unknown downloader type");

            collectorStatus = 3; //FAILED
            collectorStatusReason = " unknown downloader type";

            endTask();

            return;
        }

        c.connect();

        if(!c.isConnected()){

            logger.error(this.ds.getDatasourceName() + " connection failed");

            if(collectorStatus == 0){

                collectorStatus = 3; //FAILED
                collectorStatusReason = "connection failed";
            }

            endTask();

            return;
        }

        String[] dirs = new String[]{ds.getDatasourceLocationinfo()};
        String[] excludeDirs = new String[] {ds.getDatasourceExcludelocationinfo()};

        if(ds.getDatasourceLocationinfo().indexOf(";") != -1){
            dirs = ds.getDatasourceLocationinfo().split(";");
        }

        if (ds.getDatasourceExcludelocationinfo() != null && ds.getDatasourceExcludelocationinfo().contains(";")) {
            excludeDirs = ds.getDatasourceExcludelocationinfo().split(";");
        }

        ArrayList<RemoteFile> collectedRemoteFiles = new ArrayList<RemoteFile>();

        // loop for every remote dir
        for (int i = 0; i < dirs.length; i++) {

//            System.out.println("dir: " + dirs[i]);

            ArrayList<RemoteFile> remoteFiles = c.getListPath(dirs[i], excludeDirs, true);

//            remoteFiles.forEach(o -> System.out.println("added file: " + o.fileName));

            if(ds.getDatasourcePatterninfo() != null){

//                System.out.println("OKEEE");

                for (int j = 0; j < remoteFiles.size(); j++) {

                    if (remoteFiles.get(j).fileName.startsWith("nptq")) {
//                        System.out.println("-->> " + remoteFiles.get(j).fileName + " => " + ds.getDatasourcePatterninfo());
//                        System.out.println("-->> " + remoteFiles.get(j).fileName + " => " + remoteFiles.get(j).fileName.matches(ds.getDatasourcePatterninfo()));
                    }

//                    System.out.println("-->> " + remoteFiles.get(j).fileName + " => " + ds.getDatasourcePatterninfo());

                    if(remoteFiles.get(j).fileName.matches(ds.getDatasourcePatterninfo())){

//                        System.out.println("WAHHH");
                        collectedRemoteFiles.add(remoteFiles.get(j));
                    }
                }
            }
            else{

                collectedRemoteFiles.addAll(remoteFiles);
            }
        }

//        System.out.println("collectedRemoteFiles.size() -> " + collectedRemoteFiles.size());

        localDirPath = "data" + File.separator + "raw" + File.separator + context.getGROUP() + File.separator + context.getTIMEGROUP() + File.separator + ds.getDatasourceName();

        File localDir = new File(localDirPath);

        if(!localDir.exists()){
            localDir.mkdirs();
        }

        File check, dirCheck;
        String remoteDirCleaned;
        int epochTime;
        boolean dlStatus;
        boolean olderIsExist;
        long timestamp;

        FileInputStream fileInputStream = null;

        String md5;

        for (int i = 0; i < collectedRemoteFiles.size(); i++) {

            epochTime = collectedRemoteFiles.get(i).epochCreatedTime;

            // need to add: by file properties or by file name
            if(!EpochUtils.isSameDay(context.getGroupDate().getTime()/1000, epochTime)){
                continue;
            }

            // increase counter for total file
            totalFiles++;

            remoteDirCleaned = collectedRemoteFiles.get(i).dirPath;
            if(remoteDirCleaned.startsWith("/")){
                remoteDirCleaned = remoteDirCleaned.substring(1);
            }

            // check first for local folder, mimics the remote one
            dirCheck = new File(localDirPath + File.separator + remoteDirCleaned);

            if(!dirCheck.exists()){
                dirCheck.mkdirs();
            }

            // check for older file
            check = new File(dirCheck.getPath() + File.separator + collectedRemoteFiles.get(i).fileName);

            // if older file exist and the size are the same
            if(check.exists() && (collectedRemoteFiles.get(i).size == check.length())){

                // skip of not replace
                if(!replace){
                    logger.debug(this.ds.getDatasourceName() + " skipping: " + collectedRemoteFiles.get(i).dirPath + "/" + check.getName());
                    continue;
                }
            }

            // not exist of forced to replace
            // modify the old data first

            if(check.exists()){

                logger.debug(this.ds.getDatasourceName() + " replacing: " + check.getName() + " -> " + check.length() + " <> " + collectedRemoteFiles.get(i).size + " bytes");

                timestamp = System.currentTimeMillis();

                check.renameTo(new File(check.getAbsolutePath() + "." + timestamp));

                logger.debug(this.ds.getDatasourceName() + " move older file: " + check.getName() + " -> " + check.getName() + "." + timestamp);
            }

            // refresh
            check = new File(dirCheck.getPath() + File.separator + collectedRemoteFiles.get(i).fileName);

            // finally, get the file
            dlStatus = c.getRemoteFile(collectedRemoteFiles.get(i), check);

            if(!dlStatus){
                logger.debug(this.ds.getDatasourceName() + " download failed: " + check.getName());
                continue;
            }

            if(!check.exists()){
                logger.debug(this.ds.getDatasourceName() + " db file failed: " + check.getName());
                continue;
            }

            if(check.length() == 0){
                logger.debug(this.ds.getDatasourceName() + " zero length file: " + check.getName());
                check.delete();
                continue;
            }

            // finally
            md5 = FileUtils.getMd5(check);

            if(md5 != null){
                collectedRemoteFiles.get(i).checksum = md5;
            }

            collectedRemoteFiles.get(i).localDirPath = dirCheck.getPath();

            totalNewFiles ++;

            //save to db
            saveLog(collectedRemoteFiles.get(i));
        }

        c.disconnect();

    }

    private void performCommand(){

        this.commands = db.selectFrom(CRDATASOURCECOMMANDS)
                .where(CRDATASOURCECOMMANDS.DATASOURCECOMMANDS_DATASOURCE.eq(ds.getDatasourceId()))
                .fetch();

        if(this.commands.size() == 0){
            return;
        }

        if(this.ds.getDatasourceDbipaddress() == null){
            return;
        }

        logger.debug("found db configuration..");

        if(this.ds.getDatasourceDbtype().equals("Sybase")){

            try {
                Class.forName("com.sybase.jdbc4.jdbc.SybDriver");

                con = DriverManager.getConnection("jdbc:sybase:Tds:" + ds.getDatasourceDbipaddress() + ":" + ds.getDatasourceDbport() + "/" + ds.getDatasourceDbservicename(), ds.getDatasourceDbusername(), ds.getDatasourceDbpassword());

                logger.debug("db connection established to: " + this.ds.getDatasourceDbipaddress());
                stmt = con.createStatement();

                // prepare var for storing in output

                for (int i = 0; i < this.commands.size(); i++) {

                    int rowCount = 0;

                    logger.debug("executing: " + this.commands.get(i).getDatasourcecommandsCommand());
                    rs = stmt.executeQuery(this.commands.get(i).getDatasourcecommandsCommand());
                    rsmd = rs.getMetaData();

                    String[] headers = new String[rsmd.getColumnCount()];
                    String[] row = new String[rsmd.getColumnCount()];

                    for (int j = 1; j <= rsmd.getColumnCount(); j++) {
                        headers[j-1] = rsmd.getColumnName(j);
                    }

                    if(this.commands.get(i).getDatasourcecommandsOutputtarget().equals("FILE")){

                        File outputFile = new File(localDirPath + File.separator + this.commands.get(i).getDatasourcecommandsOutputlocation());

                        File originalOutputTarget = null;

                        logger.debug("command outputFile: " + outputFile.getPath());

                        if(outputFile.exists() && outputFile.isFile()){
                            originalOutputTarget = outputFile;
                            outputFile = new File(outputFile.getPath() + ".temp");
                            logger.debug("output file exist, renaming to: " + outputFile.getPath());
                        }

                        try {
                            BufferedWriter writer = Files.newBufferedWriter(Paths.get(outputFile.getPath()));

                            CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT
                                    .withHeader(headers));

                            while(rs.next()){

                                for (int j = 1; j <= rsmd.getColumnCount(); j++) {
                                    row[j-1] = (rs.getString(j) != null)?rs.getString(j).trim():null;
                                }

                                csvPrinter.printRecord((Object[]) row);
                            }

                            csvPrinter.flush();

                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                        if(originalOutputTarget != null){
                            logger.debug("rename temporary file to: " + originalOutputTarget.getPath());
                            outputFile.renameTo(originalOutputTarget);

                            outputFile = originalOutputTarget;
                        }

                        // only if no previous file
                        if(originalOutputTarget == null){

                            logger.debug("saving log: " + this.commands.get(i).getDatasourcecommandsOutputlocation());
                            RemoteFile f = new RemoteFile("", this.commands.get(i).getDatasourcecommandsOutputlocation(), (int) Instant.now().getEpochSecond(), outputFile.length());
                            // local directory
                            f.localDirPath = localDirPath;
                            //  get checksum
                            f.checksum = FileUtils.getMd5(outputFile);
                            saveLog(f);
                        }
                    }
                }

            } catch (ClassNotFoundException e) {
                e.printStackTrace();
                return;
            }
            catch (SQLException e) {
                logger.debug("found error on: " + this.ds.getDatasourceName());
                e.printStackTrace();
                return;
            }
        }
    }

    private void endTask(){

        stopwatchRuntime.stop();
        logger.debug(this.ds.getDatasourceName() + " finished in " + stopwatchRuntime.elapsed(TimeUnit.MILLISECONDS) + " ms");

        saveSourceLog();
    }

    private void saveLog(RemoteFile rf){

        String fileName = rf.fileName;

        CrcollectortaskfilesRecord cfr = db.newRecord(CRCOLLECTORTASKFILES);

        cfr.setCollectortaskfilesCollectortask(context.getCOLLECTORTASK_ID());
        cfr.setCrcollectortaskfilesDate(context.getEpochTime());
        cfr.setCollectortaskfilesDatasource(ds.getDatasourceId());
        cfr.setCollectortaskfilesRemotedir(rf.dirPath);
        cfr.setCollectortaskfilesRemotefilename(fileName);
        cfr.setCollectortaskfilesCreated(rf.epochCreatedTime);

        cfr.setCollectortaskfilesAdded((int)Instant.now().getEpochSecond());
        cfr.setCollectortaskfilesSize(rf.size);

        cfr.setCollectortaskfilesLocaldir(rf.localDirPath);
        cfr.setCollectortaskfilesLocalfilename(fileName);

        if(fileName.lastIndexOf(".") != -1){

            cfr.setCollectortaskfilesType(fileName.substring(fileName.lastIndexOf(".") + 1));
        }

        cfr.setCollectortaskfilesChecksum(rf.checksum);

        cfr.store();
    }

    private void saveSourceLog(){

        // summary for data source level: collectortask_sources
        CrcollectortasksourcesRecord ctsr = db.newRecord(CRCOLLECTORTASKSOURCES);

        ctsr.setCollectortasksourcesCollectortask(context.getCOLLECTORTASK_ID());
        ctsr.setCollectortasksourcesDatasource(ds.getDatasourceId());
        ctsr.setCollectortasksourcesTime((int)Instant.now().getEpochSecond());
        ctsr.setCollectortasksourcesTotalfile(totalFiles);
        ctsr.setCollectortasksourcesNewfile(totalNewFiles);

        if(collectorStatus == 0 && totalFiles == 0){

            collectorStatus = 3; //FAILED
            collectorStatusReason = "no file";
        }

        // need to add comparation with previous total for this instance

        // if still unset
        if(collectorStatus == 0){

            collectorStatus = 1; //NORMAL
            collectorStatusReason = "";
        }

        ctsr.setCollectortasksourcesCollectorstatus(collectorStatus);
        ctsr.setCollectortasksourcesStatusreason(collectorStatusReason);

        int result = ctsr.store();
        logger.debug(this.ds.getDatasourceName() + " history saved status: " + result);
    }
}

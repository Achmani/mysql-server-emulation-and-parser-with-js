package id.mit.chrono.server.base;

import id.mit.chrono.server.builder.DependencyFileBuilder;
import id.mit.chrono.server.database.DatabaseHelper;
import id.mit.chrono.server.factory.DaoFactory;
import id.mit.chrono.server.iface.Extractor;
import id.mit.chrono.server.iface.ExtractorCallback;
import id.mit.chrono.server.model.Tables;
import id.mit.chrono.server.model.tables.records.ColumnsetRecord;
import id.mit.chrono.server.model.tables.records.CrcollectortaskfilesRecord;
import id.mit.chrono.server.model.tables.records.CrprocessortaskfilesRecord;
import id.mit.chrono.server.model.tables.records.CrworkflowRecord;
import id.mit.chrono.server.obj.ChronoContext;
import id.mit.chrono.server.obj.HDFSCl;
import id.mit.chrono.server.provider.DatasourceProviderFactory;
import id.mit.chrono.server.util.ArchiveUtils;
import id.mit.chrono.server.util.FileUtils;
import id.mit.chrono.server.util.HDFSUtils;
import net.minidev.json.JSONUtil;
import org.apache.commons.lang3.StringUtils;
import org.apache.hadoop.fs.Path;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static id.mit.chrono.server.model.Tables.*;
import static id.mit.chrono.server.model.tables.Crcollectortaskfiles.CRCOLLECTORTASKFILES;

public abstract class BaseFileExtractor implements Extractor {

    protected static Logger logger = LoggerFactory.getLogger(BaseFileExtractor.class);

    protected ExtractorCallback callback;

    private File file;
    private List<File> filesToExtract = new ArrayList<>();
    protected Record rFile;
    protected ArrayList<File> files = new ArrayList<>();
    protected File tempDir;
    private boolean isInTemporary = false;

    private boolean reProcess = false;
    private CrworkflowRecord workflow;

    private Thread thread;
    protected ChronoContext context;

    private HDFSCl dfs;
    private String HDFS_BASE_DIR;
    public DSLContext db;

    @Override
    public void setFile(Record file) {
        this.rFile = file;

        String fileDir = rFile.get(CRCOLLECTORTASKFILES.COLLECTORTASKFILES_LOCALDIR);
        String fileName = rFile.get(CRCOLLECTORTASKFILES.COLLECTORTASKFILES_LOCALFILENAME);

        this.file = new File(fileDir + File.separator + fileName);
        filesToExtract.add(this.file);

        String currentDate = context.getTIMEGROUP().substring(0, context.getTIMEGROUP().length()-4);
        this.HDFS_BASE_DIR = DaoFactory.createSettingsDaoImpl()
                .getSingleSettings("HDFS", "HDFS_BASE_DIR")
                .getSettingsValue() + currentDate;
    }

    @Override
    public Record getFile() {
        return this.rFile;
    }

    @Override
    public void borrowDSLContext(DSLContext db) {
        this.db = db;
        this.dfs = HDFSUtils.getInstance(db);
    }

    @Override
    public void setReprocess(boolean reProcess) {
        this.reProcess = reProcess;
    }

    @Override
    public void setWorkflow(CrworkflowRecord workflow) {
        this.workflow = workflow;
    }

    @Override
    public void setCallback(ExtractorCallback callback) {
        this.callback = callback;
    }

    @Override
    public void setContext(ChronoContext context) {
        this.context = context;
    }

    @Override
    public void setHdfsClient(HDFSCl dfs) {
        this.dfs = dfs;
    }

    //    public BaseFileExtractor(ChronoContext context, ExtractorCallback callback, HDFSCl dfs) {
//        this.context = context;
//        this.callback = callback;
//        this.dfs = dfs;
//        this.db = DatabaseHelper.connectDB();
//    }


//    public void setFile(Record file) {
//
//        this.rFile = file;
//
//        String fileDir = rFile.get(CRCOLLECTORTASKFILES.COLLECTORTASKFILES_LOCALDIR);
//        String fileName = rFile.get(CRCOLLECTORTASKFILES.COLLECTORTASKFILES_LOCALFILENAME);
//
//        this.file = new File(fileDir + File.separator + fileName);
//
//        String currentDate = context.getTIMEGROUP().substring(0, context.getTIMEGROUP().length()-4);
//        this.HDFS_BASE_DIR = DaoFactory.createSettingsDaoImpl()
//                                        .getSingleSettings("HDFS", "HDFS_BASE_DIR")
//                                        .getSettingsValue() + currentDate;
//    }

    protected void prepareBase() {

        String fileName = rFile.get(CRCOLLECTORTASKFILES.COLLECTORTASKFILES_LOCALFILENAME);

        // prepare for get dependencies file
        Result<CrcollectortaskfilesRecord> depFiles = null;

        if (workflow.getWorkflowDependencies() != null) {

            String[] depsPattern = workflow.getWorkflowDependencies().split("\\|");

            // handle get key for each entity
            String entity = workflow.getWorkflowEntitygroup();

            if (entity.equals("hwbsc") || entity.equals("hwrnc")) {

                for (int i = 0; i < depsPattern.length; i++) {
                    // substring filename to replace key
                    String key = fileName.split("_")[2];

                    depsPattern[i] = depsPattern[i].replaceAll("%KEY", key);
                }

                // now get dependencies file
                depFiles = DatasourceProviderFactory.getFileDeps(
                        context,
                        depsPattern,
                        reProcess,
                        rFile.get(CRCOLLECTORTASKFILES.COLLECTORTASKFILES_LOCALFILENAME)
                );

            } else if (entity.equals("hwenodeb")) {
                for (int i = 0; i < depsPattern.length; i++) {
                    // substring filename to replace key
                    String key = fileName.split("_")[1] + "_" + fileName.split("_")[2];

                    depsPattern[i] = depsPattern[i].replaceAll("%KEY", key);
                    System.out.println("depsPattern: " + depsPattern[i]);
                }

                // now get dependencies file
                depFiles = DatasourceProviderFactory.getFileDeps(
                        context,
                        depsPattern,
                        reProcess,
                        rFile.get(CRCOLLECTORTASKFILES.COLLECTORTASKFILES_LOCALFILENAME)
                );
            } else if (entity.equals("erbsc") || entity.equals("errnc") || entity.equals("erenodeb")) {
                depFiles = DatasourceProviderFactory.getFileDeps(
                        context,
                        depsPattern,
                        reProcess,
                        rFile.get(Tables.CRCOLLECTORTASKFILES.COLLECTORTASKFILES_DATASOURCE),
                        rFile.get(Tables.CRCOLLECTORTASKFILES.COLLECTORTASKFILES_LOCALFILENAME)
                );
            } else if (entity.equals("ztebsc") || entity.equals("zternc")) {
                depFiles = DatasourceProviderFactory.getFileDeps(
                        context,
                        depsPattern,
                        reProcess,
                        rFile.get(Tables.CRCOLLECTORTASKFILES.COLLECTORTASKFILES_DATASOURCE),
                        rFile.get(Tables.CRCOLLECTORTASKFILES.COLLECTORTASKFILES_LOCALFILENAME)
                );
            } else if (entity.equals("zteenodeb")) {
                DependencyFileBuilder builder = new DependencyFileBuilder()
                        .setDepsPattern(depsPattern)
                        .setDatasourceId(rFile.get(Tables.CRCOLLECTORTASKFILES.COLLECTORTASKFILES_DATASOURCE))
                        .setReProcess(reProcess)
                        .setMasterFilename(rFile.get(Tables.CRCOLLECTORTASKFILES.COLLECTORTASKFILES_LOCALFILENAME))
                        .setLocaldir(workflow.getWorkflowLocaldir())
                        .build();

                depFiles = DatasourceProviderFactory.getFileDeps(context, builder);
            } else if (entity.equals("nokbsc")) {
                for (int i = 0; i < depsPattern.length; i++) {

                    // substring filename to replace key
                    String key = fileName.split("_")[3];
                    depsPattern[i] = depsPattern[i].replaceAll("%KEY", key);
                }

                DependencyFileBuilder builder = new DependencyFileBuilder()
                        .setDepsPattern(depsPattern)
                        .setDatasourceId(rFile.get(Tables.CRCOLLECTORTASKFILES.COLLECTORTASKFILES_DATASOURCE))
                        .setReProcess(reProcess)
                        .setMasterFilename(rFile.get(Tables.CRCOLLECTORTASKFILES.COLLECTORTASKFILES_LOCALFILENAME))
                        .setLocaldir(workflow.getWorkflowLocaldir())
                        .build();

                depFiles = DatasourceProviderFactory.getFileDeps(context, builder);
            } else if (entity.equals("nokrnc") || entity.equals("nokenodeb")) {
                DependencyFileBuilder builder = new DependencyFileBuilder()
                        .setDepsPattern(depsPattern)
                        .setDatasourceId(rFile.get(Tables.CRCOLLECTORTASKFILES.COLLECTORTASKFILES_DATASOURCE))
                        .setReProcess(reProcess)
                        .setMasterFilename(rFile.get(Tables.CRCOLLECTORTASKFILES.COLLECTORTASKFILES_LOCALFILENAME))
                        .setLocaldir(workflow.getWorkflowLocaldir())
                        .build();

                depFiles = DatasourceProviderFactory.getFileDeps(context, builder);
            }
        }


        // now add deps file to filesToExtract
        if (depFiles != null) {
            depFiles.forEach(item -> {
                String dir = item.get(CRCOLLECTORTASKFILES.COLLECTORTASKFILES_LOCALDIR);
                String name = item.get(CRCOLLECTORTASKFILES.COLLECTORTASKFILES_LOCALFILENAME);

                System.out.println("file to extract (deps): " + name);

                File file = new File(dir + File.separator + name);
                filesToExtract.add(file);
            });
        }

        filesToExtract.forEach(file -> {

            System.out.println("file to extract (final-all): " + file.getName());

            try {

                String fname = file.getName();

                ArrayList<String> temporary;

                tempDir = new File("data/tmp/" + fname);
                if (!tempDir.exists()) {
                    if (tempDir.mkdirs()) {
                        logger.debug("create new directory: " + tempDir.getAbsolutePath());
                    } else {
                        logger.debug("failed to create new directory: " + tempDir.getAbsolutePath());
                    }
                }

                // check extension first, just use endswith
                if(fname.endsWith(".zip")){
                    System.out.println("Extracting .zip file...");
                    temporary = ArchiveUtils.extractZip(new File(file.getAbsolutePath()), tempDir);

                    for (int i = 0; i < temporary.size(); i++) {
                        this.files.add(new File(temporary.get(i)));

                    }

                    fname = fname.substring(0, fname.length()-4);
                    isInTemporary = true;
                }
                else if(fname.endsWith(".tar.gz")){
                    System.out.println("Extracting .tar.gz file...");
                    temporary = ArchiveUtils.decompressGZIP(new File(file.getAbsolutePath()), tempDir);

                    for (int i = 0; i < temporary.size(); i++) {
                        this.files.add(new File(temporary.get(i)));

                    }

                    fname = fname.substring(0, fname.length()-7);
                    isInTemporary = true;
                }
                else if(fname.endsWith(".gz")){
                    System.out.println("Extracting .gz file...");
                    temporary = ArchiveUtils.decompressGZIP(new File(file.getAbsolutePath()), tempDir);

                    for (int i = 0; i < temporary.size(); i++) {
                        this.files.add(new File(temporary.get(i)));
                    }

                    fname = fname.substring(0, fname.length()-3);
                    isInTemporary = true;
                }
                else if(fname.endsWith(".csv")){
                    this.files.add(FileUtils.copyFile(new File(file.getAbsolutePath()), tempDir));

                }
                else if(fname.endsWith(".txt")){
                    this.files.add(FileUtils.copyFile(new File(file.getAbsolutePath()), tempDir));

                }
                else if(fname.endsWith(".xml")){
                    this.files.add(FileUtils.copyFile(new File(file.getAbsolutePath()), tempDir));

                }
                else{

                    this.files.add(new File(file.getAbsolutePath()));
                    // add validation later
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        });

    }

    @Override
    public void run() {
        prepareBase();
        extract();

        callback.onExtractFinished(db);
    }

    protected void finishExtract(ArrayList<String> filePaths) {

        filePaths.forEach(file -> {

            String fileName = file.substring(file.lastIndexOf("/")+1);
//            System.out.println("fileName: " + fileName);

            String fileExtension = file.substring(file.lastIndexOf(".")+1);
            if (file.contains("PLMN")) {
                fileExtension = "txt";
            }
//            System.out.println("fileExtension: " + fileExtension);

            if (StringUtils.isNumeric(fileExtension)) {
                fileName = fileName.substring(0, fileName.lastIndexOf("."));
            }

            // using lastIndexOf to handle case when directory and file has same name.
            String filePath = file.substring(file.indexOf("tmp/")+4, file.lastIndexOf(fileName)-1);
            String localFilePath = file.substring(0, file.lastIndexOf(fileName) - 1);
            System.out.println("localFilePath: " + localFilePath);

            String baseDir = HDFS_BASE_DIR + File.separator + filePath;
//            System.out.println("baseDir: " + baseDir);

//            if (!dfs.checkDir(baseDir)) {
//                dfs.createDir(baseDir);
//            }

            File fileToUpload = new File(file);

            Integer columnsetId = storeHeader(fileToUpload, rFile.get(CRVENDOR.VENDOR_ID));

//            System.out.println("uploading to hdfs...");
            logger.debug("uploading " + fileName + " to hdfs...");

            // turn off upload to hdfs
//            HashMap<String, Object> resultHDFS = dfs.writefile(baseDir, fileName, fileToUpload);

            System.out.println("Executed!");
//            System.out.println("resultHDFS: " + resultHDFS);
            System.out.println("\n\n");

            String md5 = FileUtils.getMd5(fileToUpload);

            // check if processortaskfiles exist
            CrprocessortaskfilesRecord record = DaoFactory.createProcessorTaskFilesDaoImpl().getProcessorTaskFiles(
                            rFile.get(CRCOLLECTORTASKFILES.CRCOLLECTORTASKFILES_DATE),
                            rFile.get(CRCOLLECTORTASKFILES.COLLECTORTASKFILES_ID),
                            baseDir,
                            fileName );

            if (record == null) {
                record = db.newRecord(CRPROCESSORTASKFILES);
            }

            // looks mess a bit, but more flexible (for now)
            record.setCrprocessortaskfilesDate(rFile.get(CRCOLLECTORTASKFILES.CRCOLLECTORTASKFILES_DATE));
            record.setProcessortaskfilesCollectortaskfiles(rFile.get(CRCOLLECTORTASKFILES.COLLECTORTASKFILES_ID));
            record.setProcessortaskfilesDatasource(rFile.get(CRCOLLECTORTASKFILES.COLLECTORTASKFILES_DATASOURCE));
            record.setProcessortaskfilesLocaldir(localFilePath);
            record.setProcessortaskfilesLocalfilename(fileName);
            record.setProcessortaskfilesRemotedir(baseDir);
            record.setProcessortaskfilesRemotefilename(fileName);
            record.setProcessortaskfilesCreated(rFile.get(CRCOLLECTORTASKFILES.COLLECTORTASKFILES_CREATED));
            record.setProcessortaskfilesAdded((int) Instant.now().getEpochSecond());
            record.setProcessortaskfilesSize(fileToUpload.length());
            record.setProcessortaskfilesType(fileExtension);
            record.setProcessortaskfilesChecksum(md5);
            record.setProcessortaskfilesColumnset(columnsetId);

//            // if process success
//            if ((int) resultHDFS.get("processStatus") == 1) {
//                record.setProcessortaskfilesProcesstime((int) Instant.now().getEpochSecond());
//            }
//            // if process failed
//            else {
//                record.setProcessortaskfilesProcessstatus((int) resultHDFS.get("processStatus"));
//                record.setProcessortaskfilesProcessstatusreason(String.valueOf(resultHDFS.get("failedReason")));
//            }

            if (record.getProcessortaskfilesId() == null) {
                DaoFactory.createProcessorTaskFilesDaoImpl().insertProcessorTaskFiles(record);
            } else {
                DaoFactory.createProcessorTaskFilesDaoImpl().updateProcessorTaskFiles(record);
            }

            // update collectortaskfiles processtime
            DaoFactory.createCollectorTaskFilesDaoImpl()
                    .updateCollectorTaskfiles(rFile.get(CRCOLLECTORTASKFILES.COLLECTORTASKFILES_ID), (int) Instant.now().getEpochSecond());

        });

//        finalizeBase();
    }

    private Integer storeHeader(File file, Integer vendorId) {

        String line;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));

            if ((line = reader.readLine()) != null) {

                // lookup csv header in db first
                ColumnsetRecord columnset = DaoFactory.createColumnDaoImpl().getColumnset(line, vendorId);

                if (columnset != null) {
                    return columnset.getColumnsetId();
                }

                // if header is new, then store it.
                columnset = DaoFactory.createColumnDaoImpl().insertColumnset(line, vendorId);
                return columnset.getColumnsetId();

            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    protected synchronized void finalizeBase() {

        if (tempDir != null) {

            // check if directory has file inside
            if (tempDir.listFiles() != null && tempDir.listFiles().length > 0) {

                // remove them
                Arrays.stream(tempDir.listFiles()).forEach(file -> {

                    // if directory, then remove using FileUtils.
                    if (file.isDirectory()) {
                        FileUtils.removeDirectory(file);
                    }

                    file.delete();
                });
            }

            // finally remove tempDir itself.
//            tempDir.delete();
            if (tempDir.listFiles() == null || tempDir.listFiles().length <= 0) {
                FileUtils.removeDirectory(tempDir);
            }

        }
    }

    @Override
    public void startExtract(DSLContext db) {

//        this.db = DatabaseHelper.connectDB();
        this.db = db;
        this.dfs = HDFSUtils.getInstance(db);

        this.thread = new Thread(this);
        this.thread.setName(this.getClass().getSimpleName() + ":" + this.file.getName());
        this.thread.start();
    }


    protected abstract void extract();



}

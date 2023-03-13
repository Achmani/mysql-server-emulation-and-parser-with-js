package id.mit.chrono.server.base;

import id.mit.chrono.server.factory.DaoFactory;
import id.mit.chrono.server.iface.FileParser;
import id.mit.chrono.server.iface.FileParserCallback;
import id.mit.chrono.server.iface.FileProcessor;
import id.mit.chrono.server.model.tables.records.CrcollectortaskfilesRecord;
import id.mit.chrono.server.model.tables.records.CrmapparserRecord;
import id.mit.chrono.server.obj.HuaweiBasicKeyParamsObj;
import id.mit.chrono.server.obj.SourceFile;
import id.mit.chrono.server.util.ArchiveUtils;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.TrueFileFilter;
import org.jooq.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.File;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class BaseFileParser implements FileParser {

    private FileParserCallback fpc;
    private Thread myThread;

    protected ArrayList<String> usedSourceGroups = new ArrayList<String>();
    protected ArrayList<File> files = new ArrayList<File>();
    protected boolean isInTemporary = false;
    protected Logger logger = LoggerFactory.getLogger(this.getClass());
    protected SourceFile sourceFile;
    protected String fileIdentity;
    protected String fileDependencies;
    protected File tempDir;

//    protected ArrayList<Object> result = new ArrayList<Object>();

    @Override
    public void setInitData(FileParserCallback fpc, SourceFile file, String fileIdentity, String fileDependencies){

        this.fpc = fpc;
        this.sourceFile = file;
        this.fileIdentity = fileIdentity;
        this.fileDependencies = fileDependencies;
    }

    @Override
    public void setUsedSourceGroups(ArrayList<String> sourceGroups){

        this.usedSourceGroups = sourceGroups;
    }

    @Override
    public SourceFile getSourceFile(){

        return this.sourceFile;
    }

    @Override
    public void freeSourceFile(){

        this.sourceFile.purgeResult();
    }

    protected void updateFileProcessTime(int processStatus, String reason){

        if(this.sourceFile != null){

            this.sourceFile.setProcessTime((int) Instant.now().getEpochSecond());
            this.sourceFile.setProcessStatus(processStatus);
            this.sourceFile.setProcessStatusReason(reason);
        }
    }

    protected void prepareBase(){

        File file = new File(this.sourceFile.getFilePath());

        try{

            String folderPath = this.sourceFile.getFilePath().substring(0, this.sourceFile.getFilePath().lastIndexOf('/'));
            String fileName = file.getName();

            ArrayList<String> temporary = new ArrayList<String>();
            tempDir = new File("data/tmp/" + this.sourceFile.getFileName());

            if(!tempDir.exists()){
                if (tempDir.mkdirs()) {
                    System.out.println("create new directory: " + tempDir.getAbsolutePath());
                } else {
                    System.out.println("failed to create new directory: " + tempDir.getAbsolutePath());
                }
//                tempDir.mkdir();
            }

            // check extension first, just use endswith
            if(fileName.endsWith(".zip")){

                temporary = ArchiveUtils.extractZip(new File(this.sourceFile.getFilePath()), tempDir);

                for (int i = 0; i < temporary.size(); i++) {

                    this.files.add(new File(temporary.get(i)));
                }

//                files.forEach(o -> {
//                    System.out.println(o.getAbsolutePath());
//                });

                fileName = fileName.substring(0, fileName.length()-4);
                isInTemporary = true;
            }
            else if(fileName.endsWith(".tar.gz")){

                temporary = ArchiveUtils.decompressGZIP(new File(this.sourceFile.getFilePath()), tempDir);

                for (int i = 0; i < temporary.size(); i++) {

                    this.files.add(new File(temporary.get(i)));
                }

                fileName = fileName.substring(0, fileName.length()-7);
                isInTemporary = true;
            }
            else if(fileName.endsWith(".gz")){

                temporary = ArchiveUtils.decompressGZIP(new File(this.sourceFile.getFilePath()), tempDir);

                for (int i = 0; i < temporary.size(); i++) {

                    this.files.add(new File(temporary.get(i)));
                }

                fileName = fileName.substring(0, fileName.length()-3);
                isInTemporary = true;
            }
            else if(fileName.endsWith(".csv")){

                this.files.add(new File(this.sourceFile.getFilePath()));
            }
            else if(fileName.endsWith(".txt")){

                this.files.add(new File(this.sourceFile.getFilePath()));
            }
            else if(fileName.endsWith(".xml")){

                this.files.add(new File(this.sourceFile.getFilePath()));
            }
            else{

                // add validation later
                this.files.add(new File(this.sourceFile.getFilePath()));
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    protected void checkDependencies(){

        if(this.fileDependencies == null){
            return;
        }

//        logger.debug("found deps. for \"" + sourceFile.getFileName() + "\" -> " + this.fileDependencies);

        String filePath = sourceFile.getFilePath();
        String fileDir = filePath.substring(0, filePath.lastIndexOf("/"));
        String fileName = filePath.substring(filePath.lastIndexOf("/")+1);

//        System.out.println("filePath: " + filePath);
//        System.out.println("fileDir: " + fileDir);

        // get file identity first



        // 20180701 shoud get this files by querying to the DB
        // rather than to lookup in storage directly

//        String[] deps = new String[]{this.fileDependencies};
        ArrayList<String> deps = new ArrayList<>();

        if(this.fileDependencies.indexOf(";") >= 0){
//            deps = this.fileDependencies.split(";");
            deps.addAll(Arrays.asList(this.fileDependencies.split(";")));
        }

        // check if file belongs to Huawei
        if (fileName.matches("^CMExport_(?!MBSC_)(?!RNC_).*_\\d{10}.csv.*$")) {

            String key = "GExport"+fileName.substring(fileName.indexOf("_"), fileName.lastIndexOf("_")+8);

            // get its dependencies (GExport) from db
            Result<CrcollectortaskfilesRecord> taskFiles = DaoFactory.createCollectorTaskFilesDaoImpl().
                    getCollectorTaskfiles(fpc.getContext().getEpochTime(), key);

            taskFiles.forEach(file -> {

                deps.add(file.getCollectortaskfilesLocaldir()+File.separator+file.getCollectortaskfilesLocalfilename());
            });
        }

        for (int i = 0; i < deps.size(); i++) {

            String dir = deps.get(i);

//            System.out.println("checking: " + dir);

            String targetDir = fileDir + "/" + dir.substring(0, dir.lastIndexOf("/"));
            String testFileDir = fileDir;

            if (!dir.startsWith(".")) {
                targetDir = dir.substring(0, dir.lastIndexOf("/"));
                testFileDir = ".";
            }

            // check for "regex" folder
            // ex: ../../ftirpuser/inventory/rc\d+vm8/full_upload/\d{8}0705_72/IM\d{12}[+]\d{6}[_]MRBTS[-]\d{6}[.]xml
            String[] targetDirEl = dir.substring(0, dir.lastIndexOf("/")).split("/");
//            System.out.println("targetDir: " + targetDir);
//            System.out.println("targetDirEl: " + Arrays.toString(targetDirEl));

            String testDir = "";
            String lastTestDir;
            File test;
            String testFilePathPattern;

            for (int j = 0; j < targetDirEl.length; j++) {

                lastTestDir = testDir;

                if(j!=0){

                    testDir += "/";
                }

                testDir += targetDirEl[j];

                test = new File(testFileDir + "/" + testDir);

//                System.out.println("test path: " + testFileDir + "/" + testDir);

                if(!test.exists()){

//                    System.out.println("Got scan directory: " + lastTestDir);

                    testFilePathPattern = testFileDir + "/" + deps.get(i);

//                    System.out.println("checkx: " + testFilePathPattern);

                    Iterator<File> files = FileUtils.iterateFiles(new File(testFileDir + "/" + lastTestDir),
                            TrueFileFilter.INSTANCE,
                            TrueFileFilter.INSTANCE);

                    while (files.hasNext()) {

                        File tempFile = files.next();

                        if(tempFile.getPath().matches(testFilePathPattern)){
                            // do something
                            targetDir = tempFile.getPath().substring(0, files.next().getPath().lastIndexOf("/"));
                            logger.debug("found valid deps. for \"" + sourceFile.getFileName() + "\" -> " + tempFile.getName());

                            break;
                        }
                    }

                    break;
                }
            }

            String targetFilePattern = dir.substring(dir.lastIndexOf("/")+1);

            String filter = null;

            // search for other data based on current file name
            if(this.fileIdentity != null){

                Pattern p = Pattern.compile(this.fileIdentity);
                Matcher m = p.matcher(this.sourceFile.getFileName());
                if(m.find()){

                    filter = m.group(1);
//                    logger.debug("File identity found: " + filter);

                    if(m.group(2) != null){

                        if(m.group(2).matches("\\d{8}")){

                            //replace yyyymmdd
                            targetDir = targetDir.replaceAll("%yyyymmdd%", m.group(2));
                        }
                    }
                }
            }
            else if(this.sourceFile.getFileName().startsWith("hirarki_lte_")){

                String[] el = this.sourceFile.getFileName().split("_");

                filter = el[2].toUpperCase() + "-" + el[4] + ".xml";
//                logger.debug("Set filter from file name: " + filter);
            }
            else if(this.sourceFile.getFileName().indexOf("CFGMML_") != -1){

                int index = this.sourceFile.getFileName().indexOf("CFGMML_");

                filter = this.sourceFile.getFileName().substring(index+7, this.sourceFile.getFileName().lastIndexOf("_")) + "_";
//                logger.debug("Set filter from file name: " + filter);
            }

            File targetDirFile = new File(targetDir);
//            logger.debug("targetDirFile: " + targetDirFile);

            if(targetDirFile.exists() && targetDirFile.isDirectory()){

                File[] files = targetDirFile.listFiles();

                for (int j = 0; j < files.length; j++) {

                    targetFilePattern = targetFilePattern.replaceAll("%\\_KEY\\_%", filter);

                    boolean b1 = targetFilePattern != null && files[j].getName().matches(targetFilePattern);
                    boolean b2 = files[j].getName().equals(this.sourceFile.getFileName());

//                    System.out.println("check dep1: " + files[j].getName() + " -> " + targetFilePattern + " -> " + b1 + " -> " + b2);

                    if(b1 && !b2){

                        // search for suitable map id.mit.chrono.server.parser
                        CrmapparserRecord mp = fpc.getSuitableMapParser(files[j].getName());

                        if(mp != null){

                            FileParser parser = fpc.getParserByClassName(mp.getMapparserClass());

                            if(parser != null){

                                parser.setInitData(null, new SourceFile(0, mp.getMapparserDatasourcetype(), files[j].getPath(), files[j].length(), null), null, null);

                                parser.setUsedSourceGroups(this.usedSourceGroups);

                                // parse and wait guys..
                                parser.parseAndWait();

                                // get result and add to existing result
                                logger.debug("deps processed: " + files[j].getName() + ", got " + parser.getSourceFile().getResult().size() + " new record(s)");

                                this.sourceFile.addAllResult(parser.getSourceFile().getResult());

                                // delete from memory
                                parser.getSourceFile().purgeResult();
                            }
                            else{
                                logger.debug("failed to initialize id.mit.chrono.server.parser: " + mp.getMapparserClass());
                            }
                        }
                    }
                }
            }
            else{
                logger.debug("failed to list deps. dir: " + targetDirFile.getPath());
            }
        }
    }

    protected void finalizeBase(){

        // if started with extraction, then delete from temporary folder
        if(isInTemporary){

            for (int i = 0; i < files.size(); i++) {

//                files.get(i).delete();
            }
        }

        // try to delete temporary folder
        if(tempDir != null){

//            tempDir.delete();
//            id.mit.chrono.server.util.FileUtils.removeDirectory(tempDir);
        }

        // trigger event on finished to upper layer
        if(this.fpc != null && this.sourceFile != null){

            this.fpc.onFileParserFinished(this);
        }
    }

    @Override
    public void parse() {

        this.myThread = new Thread(this);
        this.myThread.setName(this.getClass().getSimpleName() + ":" + this.sourceFile.getTaskFilesId());
        this.myThread.start();
    }

    @Override
    public void parseAndWait(){

        this.run();
    }

    @Override
    public void run() {

        parseLocal();
        checkDependencies();
        finalizeBase();

        this.myThread = null;
    }

    protected abstract void parseLocal();
}

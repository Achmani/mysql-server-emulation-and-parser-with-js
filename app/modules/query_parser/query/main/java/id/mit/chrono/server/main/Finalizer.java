package id.mit.chrono.server.main;

import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.SftpException;
import id.mit.chrono.server.base.BaseMain;
//import id.mit.chrono.server.model.Routines;
import id.mit.chrono.server.model.tables.Crfinalizertask;
import id.mit.chrono.server.model.tables.records.*;
import id.mit.chrono.server.obj.*;
import id.mit.chrono.server.util.CellUtils;
import id.mit.chrono.server.util.FileUtils;
import id.mit.chrono.server.util.SystemUtils;
import org.apache.commons.pool2.ObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPool;
import org.jooq.*;
import org.jooq.impl.DSL;
import org.jooq.types.ULong;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.apache.commons.cli.*;
import org.apache.commons.cli.ParseException;
import org.apache.commons.lang3.StringUtils;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.jooq.types.UInteger;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.*;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import java.util.*;
import java.util.stream.Collectors;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import javax.mail.*;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import static id.mit.chrono.server.model.Tables.*;

public class Finalizer extends BaseMain {

    // what to do on this
    // 1. check for the data completion for each vendor and entities (perform comparation to previous-day data)
    // 2. since this will runs on "nearly the production time", this will also send summary by an email to any system-pic(s)
    // 3. if the data is complete, then this will also generate the sumamry for rancontroller, ranbts, and rancell
    // 4. export file for daily sys. info, and lacima

    // runtime pre-checking
    // 1. if any other instance(s) of Processor is running
    // 2.

    private boolean cleanPreviousSummary = false;
    private boolean forced = false;
    private boolean copyFromPreviousData = false;
    private boolean generateNewData = false;
    private boolean export = false;
    private int adjustLabelFor = 0; // day
    private List<CrcellclassRecord> cellclasses;
    private HashMap<Integer, CrcellclassRecord> cellClassessById = new HashMap<>();

    String[] exportTypeCodes = null;
    String[] finalizerNames = null;

    private ObjectPool<DSLContext> dbPool;

    ScriptEngineManager mgr = new ScriptEngineManager();
    ScriptEngine engine;

    String exportTimeGroup = "00";

    List<CrsettingsRecord> settings;

    SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
    SimpleDateFormat formatter2 = new SimpleDateFormat("ddMMyy");

    public Finalizer(String[] args) {

        logger.info("new instance initiated with param: " + StringUtils.join(args, " "));

        boolean argIsOk = this.parseArguments(args);

        if (!argIsOk) {

            logger.debug("exiting with -1 status..");
            System.exit(-1);
        }

        dbPool = new GenericObjectPool<DSLContext>(new DSLContextFactory());
        ((GenericObjectPool<DSLContext>) dbPool).setMinIdle(5);
        ((GenericObjectPool<DSLContext>) dbPool).setMaxTotal(10);

        engine = mgr.getEngineByName("JavaScript");

        SystemUtils.logSystemInfo(logger);

        // mandatory
        getTask();

        doFinalize();
    }

    private boolean parseArguments(String[] args) {

        // sample arguments: -g CM_RAN -tg 201804300900

        // help
        options.addOption("h", "help", false, "show help.");

        // group
        options.addOption("g", "group", true, "groups: CM_RAN|CM_CORE|CM_TRANSPORT|INVENTORY_RAN");

        // time group
        options.addOption("tg", "time-group", true, "time group (yyyyMMddHHmm)");

        options.addOption("e", "export", false, "perform data export");

        options.addOption("c", "clean", false, "clean previous inserted data");

        options.addOption("n", "generate-new", false, "generate new data");

        options.addOption("cp", "copy", false, "copy from previous day");

        options.addOption("f", "force", false, "force to finish");

        options.addOption("et", "export-time", true, "tim group: 00|09|10|20");

        options.addOption("al", "adjust-label", true, "adjust label for: -1|1|2|n day");

        options.addOption("al", "adjust-label", true, "adjust label for: -1|1|2|n day");

        Option ecOption = new Option("ec", "export-code", true, "specified export code , ex: \"DAILY_LACIMA_CELL_2G DAILY_LACIMA_CELL_3G\"");
        ecOption.setArgs(5);
        options.addOption(ecOption);

        Option fnOption = new Option("fn", "finalizer-name", true, "specified finalizer name, ex: \"\"");
        fnOption.setArgs(5);
        options.addOption(fnOption);

        CommandLineParser parser = new GnuParser();

        try {

            CommandLine cmd = parser.parse(options, args);

            if (cmd.getOptions().length == 0) {
                showHelp();
            }

            if (cmd.hasOption("h")) {
                showHelp();
            }

            if (cmd.hasOption("g")) {

                logger.debug("found 'g': " + cmd.getOptionValue("g", null));
                context.setGROUP(cmd.getOptionValue("g", null));

                if (context.getGROUP() != null && !Arrays.asList(new String[]{"CM_RAN", "CM_CORE", "CM_TRANSPORT", "INVENTORY_RAN"}).contains(context.getGROUP())) {

                    throw new ParseException("invalid group: " + context.getGROUP());
                }
            }

            if (cmd.hasOption("tg")) {

                logger.debug("found 'tg': " + cmd.getOptionValue("tg", null));
                context.setTIMEGROUP(cmd.getOptionValue("tg", null));

                context.setGroupDate(dValidator.validate(context.getTIMEGROUP(), "yyyyMMddHHmm"));

                if (context.getGroupDate() == null) {
                    throw new ParseException("invalid yyyyMMddHHmm format: " + context.getTIMEGROUP());
                }
            }

            if (cmd.hasOption("c")) {
                cleanPreviousSummary = true;
            }

            if (cmd.hasOption("n")) {
                generateNewData = true;
            }

            if (cmd.hasOption("e")) {
                export = true;
            }

            if (cmd.hasOption("f")) {
                forced = true;
//                copyFromPreviousData = true;
            }

            if (cmd.hasOption("cp")) {
                copyFromPreviousData = true;
            }

            if (cmd.hasOption("et")) {

                logger.debug("found 'et': " + cmd.getOptionValue("et", "00"));

                String temp = cmd.getOptionValue("et", "00");

                if(temp.matches("^\\d{2}$")){
                    logger.debug("found valid 'et': " + temp);
                    exportTimeGroup = temp;
                }
            }

            if (cmd.hasOption("al")) {

                logger.debug("found 'al': " + cmd.getOptionValue("al", "0"));

                String temp = cmd.getOptionValue("al", "0");

                try{

                    adjustLabelFor = Integer.parseInt(temp);
                    logger.debug("adjustLabelFor: " + adjustLabelFor);

                }catch(Exception e){}
            }

            if(cmd.hasOption("ec")){

                String[] exportTypeCodesTemp = cmd.getOptionValues("ec");

                for (int i = 0; i < exportTypeCodesTemp.length; i++) {
                    logger.debug("found export code: " + exportTypeCodesTemp[i]);
                }

                this.exportTypeCodes = exportTypeCodesTemp;
            }

            if(cmd.hasOption("fn")){

                String[] finalizerNamesTemp = cmd.getOptionValues("fn");

                for (int i = 0; i < finalizerNamesTemp.length; i++) {
                    logger.debug("found finalizer name: " + finalizerNamesTemp[i]);
                }

                this.finalizerNames = finalizerNamesTemp;
            }


        } catch (ParseException e) {
            logger.error(e.getMessage());
            e.printStackTrace();
            return false;
        }

        if (context.getGROUP() == null || context.getTIMEGROUP() == null) {

            showHelp();

            return false;
        }

        return true;
    }

    private void doFinalize(){

        // check time catalogue first
        CrtimecatalogRecord tcr = db.selectFrom(CRTIMECATALOG)
                .where(CRTIMECATALOG.TIMECATALOG_DATAGROUP.eq(context.getDATAGROUP_ID()))
                .and(CRTIMECATALOG.TIMECATALOG_DATE.eq(context.getEpochTime()))
//                .and(CRTIMECATALOG.TIMECATALOG_ACTIVE.isFalse())
                .fetchOne();

        if(tcr == null){
            logger.debug("no time catalogue to active, exiting..");
            return;
        }

        // if already active && not forced, then return
        if(tcr.getTimecatalogActive() == 1 && !forced){

            logger.debug("time catalogue already activated: " + tcr.getTimecatalogDate());
            return;
        }

        settings = db.selectFrom(CRSETTINGS)
                .where(CRSETTINGS.SETTINGS_ENABLED.isTrue())
                .orderBy(CRSETTINGS.SETTINGS_ORDER.asc())
                .fetch();

        List<CrsettingsRecord> checks = settings.stream()
                .filter(o -> o.getSettingsCode().equals("FINALIZERCHECK"))
                .collect(Collectors.toList());

        CrsettingsRecord inadequateCells = settings.stream()
                .filter(o -> o.getSettingsCode().equals("FINALIZERINADEQUATECELL"))
                .collect(Collectors.toList())
                .get(0);

        if(checks.size() == 0){

            logger.debug("empty rules, exiting..");
            return;
        }

        CrsettingsRecord smtphost = settings.stream()
                .filter(o -> o.getSettingsCode().equals("SMTP") && o.getSettingsName().equals("SMTP_HOST"))
                .collect(Collectors.toList()).get(0);

        CrsettingsRecord smtpport = settings.stream()
                .filter(o -> o.getSettingsCode().equals("SMTP") && o.getSettingsName().equals("SMTP_PORT"))
                .collect(Collectors.toList()).get(0);

        CrsettingsRecord smtpfrom = settings.stream()
                .filter(o -> o.getSettingsCode().equals("SMTP") && o.getSettingsName().equals("SMTP_FROM"))
                .collect(Collectors.toList()).get(0);

        CrsettingsRecord emailTo = settings.stream()
                .filter(o -> o.getSettingsCode().equals("SYSADMIN"))
                .collect(Collectors.toList()).get(0);

        CrsettingsRecord emailTemplate = settings.stream()
                .filter(o -> o.getSettingsCode().equals("EMAILTEMPLATE") && o.getSettingsName().equals("FINALIZER"))
                .collect(Collectors.toList()).get(0);

        List<CrsettingsRecord> vendorData = settings.stream()
                .filter(o -> o.getSettingsCode().equals("FINALIZERVENDORDATA"))
                .collect(Collectors.toList());

        CrsettingsRecord sourceData = settings.stream()
                .filter(o -> o.getSettingsCode().equals("FINALIZERDATASSOURCEDATA"))
                .collect(Collectors.toList()).get(0);

        CrsettingsRecord backDateCopy = settings.stream()
                .filter(o -> o.getSettingsCode().equals("CRRANCELL") && o.getSettingsName().equals("BACKDATECOPY"))
                .collect(Collectors.toList()).get(0);

        cellclasses = db.selectFrom(CRCELLCLASS).fetch();

        for(CrcellclassRecord r: cellclasses){
            cellClassessById.put(r.getCellclassId().intValue(), r);
        }

        ArrayList<FinalizerTestResult> testResults = new ArrayList<FinalizerTestResult>();
        ArrayList<FinalizerInadequateCell> inadequateResults = new ArrayList<FinalizerInadequateCell>();
        ArrayList<FinalizerVendorData> vendorDatas = new ArrayList<FinalizerVendorData>();
        ArrayList<FinalizerDataSourceData> dataSourceDatas = new ArrayList<FinalizerDataSourceData>();

        // set db variable
        db.execute("SET @epoch=" + this.context.getEpochTime());

        // generate vendor data for out conveniences
        for (int i = 0; i < vendorData.size(); i++) {

            Record result = db.fetchOne(vendorData.get(i).getSettingsValue());

            vendorDatas.add(new FinalizerVendorData(result));
        }

        // determine whether data is complete
        boolean allResult = true;

        for (int i = 0; i < checks.size(); i++) {

            // execute test sql from test procedures
            Record result = db.fetchOne(checks.get(i).getSettingsValue());

            int resCount = Integer.parseInt(result.get(0).toString());

            allResult &= (resCount >= 0);

            logger.debug(checks.get(i).getSettingsName() + " -> " + resCount);

            testResults.add(new FinalizerTestResult(checks.get(i).getSettingsName(), checks.get(i).getSettingsDescription(), (resCount>0)?"+"+resCount:"" + resCount, (Integer.parseInt(result.get(0).toString()) >= 0)?"PASSED":"FAILED"));
        }

        // get inadequate cell list
        if(inadequateCells != null){

            // execute test sql from test procedures
            List<Record> result = db.fetch(inadequateCells.getSettingsValue());

            Record x;

            for (int i = 0; i < result.size(); i++) {

                x = result.get(i);

                String cellName = (x.getValue("cellName") != null)?x.getValue("cellName").toString():"";
                String cellClass = (x.getValue("cellClass") != null)?x.getValue("cellClass").toString():"";
                String cellIdentifier = (x.getValue("cellIdentifier") != null)?x.getValue("cellIdentifier").toString():"";

                FinalizerInadequateCell temp = new FinalizerInadequateCell(x.getValue("tableName").toString(),
                        x.getValue("id").toString(),
                        x.getValue("epoch").toString(),
                        x.getValue("fileId").toString(),
                        cellName,
                        cellClass,
                        cellIdentifier);

                inadequateResults.add(temp);
            }
        }

        //
        List<Record> dsDataResult = db.fetch(sourceData.getSettingsValue());

        for (int i = 0; i < dsDataResult.size(); i++) {

            int datasourceId = Integer.parseInt(dsDataResult.get(i).getValue("DATASOURCE_ID").toString());
            String datasourceName = dsDataResult.get(i).getValue("DATASOURCE").toString();
            int totalFileD = Integer.parseInt(dsDataResult.get(i).getValue("TOTALD").toString());
            int totalFileD2 = Integer.parseInt(dsDataResult.get(i).getValue("TOTALD1").toString());

            dataSourceDatas.add(new FinalizerDataSourceData(datasourceId, datasourceName, totalFileD, totalFileD2));
        }

        ArrayList<CrdataexportRecord> exports = new ArrayList<CrdataexportRecord>();

        if(allResult || forced){

            // steps:
            // 1. generate catalogue in crrancell, crranbts, and crrancontroller <-- delete if needed
            // 2. compare with previous day data, if needed, perform copy by using "datefrom" field
            // 3. disable previous time catalog, and activate the today's
            // 4. generate export file

            ArrayList<Integer> finalizerTaskIds = new ArrayList<Integer>();

            if(finalizerNames != null){

                Result<Record1<Integer>> finalizerIds = db.select(CRFINALIZERTASK.FINALIZERTASK_ID)
                        .from(CRFINALIZERTASK)
                        .where(CRFINALIZERTASK.FINALIZERTASK_NAME.in(finalizerNames))
                        .fetch();

                logger.debug("finalizerIds.size(): " + finalizerIds.size());

                for (int i = 0; i < finalizerIds.size(); i++) {

                    finalizerTaskIds.add(finalizerIds.get(i).value1());
                }
            }

            logger.debug("finalizerTaskIds: " + finalizerTaskIds.size());

            // 1. generating crran data
            if(cleanPreviousSummary){
                logger.debug("cleaning ran cell (" + context.getEpochTime() + ")..");

                // delete first
                DeleteConditionStep<CrrancellRecord> deleteStep =db.deleteFrom(CRRANCELL)
                        .where(CRRANCELL.RANCELL_DATE.equal(UInteger.valueOf(context.getEpochTime())));

                if(!finalizerTaskIds.isEmpty()){

                    deleteStep.and(CRRANCELL.RANCELL_CRFINALIZERTASK.in(finalizerTaskIds));
                }

                deleteStep.execute();

                logger.debug("cleaning ran bts (" + context.getEpochTime() + ")..");

                logger.debug("cleaning ran controller (" + context.getEpochTime() + ")..");
            }

            if(generateNewData){

                logger.debug("generating new ran cell (" + context.getEpochTime() + ")..");
                boolean generateResult = this.generateRanCell(finalizerTaskIds);
                logger.debug("generateRanCell: " + generateResult);
            }

//                db.deleteFrom(CRRANCELLTEMP).execute();
//                Routines.insertCrrancellfromcrancelltemp(db.configuration(), context.getEpochTime());

            // 2. perform data copy from D-1
            if(copyFromPreviousData){

                logger.debug("performing copy from previous time catalogue..");

                // default
                int oldestData = this.context.getEpochTime() - (5*86400);

                if(backDateCopy != null){

                    logger.debug("found BACKDATECOPY setting: " + backDateCopy.getSettingsValue());

                    try{

                        int x = Integer.parseInt(backDateCopy.getSettingsValue());
                        oldestData = this.context.getEpochTime() - (x*86400);
                    }
                    catch(Exception e){

                    }
                }

                logger.debug("get yesterday's data..");
                // select previous day's data
                List<CrrancellRecord> d1Data = db.selectFrom(CRRANCELL)
                        .where(CRRANCELL.RANCELL_DATE.eq(UInteger.valueOf(this.context.getEpochTime()-86400)))
                        .and(CRRANCELL.RANCELL_KEY.notIn(
                                db.select(CRRANCELL.RANCELL_KEY)
                                        .from(CRRANCELL)
                                        .where(CRRANCELL.RANCELL_DATE.equal(UInteger.valueOf(this.context.getEpochTime())))
                                )
                        )
                        .fetch();

                logger.debug("get yesterday's data complete: " + d1Data.size());
                int totalCopy = 0;

                for (int i = 0; i < d1Data.size(); i++) {

                    // if null, then set for the first time
                    if(d1Data.get(i).getRancellDatefrom() == null){

                        d1Data.get(i).setRancellDatefrom(d1Data.get(i).getRancellDate());
                    }

                    // then check for data age, if more than 3 days, then skip, the data is too old
                    if(d1Data.get(i).getRancellDatefrom().intValue() >= (this.context.getEpochTime() - (5*86400))){

                        d1Data.get(i).setRancellDate(UInteger.valueOf(this.context.getEpochTime()));

                        logger.debug("adding d-1 data: " + d1Data.get(i).getRancellKey());
                        d1Data.get(i).store();

                        totalCopy++;
                    }
                    else{
                        logger.debug("skipping too old d-1 data: " + d1Data.get(i).getRancellKey());
                    }
                }

                logger.debug("total copy from d-1: " + totalCopy);
            }

            // 3. disable previous active data
            CrtimecatalogRecord tcrActive = db.selectFrom(CRTIMECATALOG)
                    .where(CRTIMECATALOG.TIMECATALOG_DATAGROUP.eq(context.getDATAGROUP_ID()))
                    .and(CRTIMECATALOG.TIMECATALOG_ACTIVE.isTrue())
                    .fetchOne();

            if(tcrActive != null && tcrActive.getTimecatalogId() != tcr.getTimecatalogId()){
                logger.debug("deactivating time catalogue: " + tcrActive.getTimecatalogDate());
                tcrActive.setTimecatalogActive((byte) 0);
                tcrActive.update();
            }

            logger.debug("activating time catalogue: " + tcr.getTimecatalogDate());
            tcr.setTimecatalogActive((byte) 1);
            tcr.setTimecatalogAdminonly((byte) 0);
            tcr.update();

            if(export){

                // 4. export file

                long epoch = context.getEpochTime();
                Date epochTime = new Date(epoch * 1000 + (adjustLabelFor * 86400 * 1000));

                SelectConditionStep<CrdataexporttaskRecord> step = db.selectFrom(CRDATAEXPORTTASK)
                        .where(CRDATAEXPORTTASK.DATAEXPORTTASK_ENABLED.isTrue());

                if(exportTypeCodes != null){

                    step.and(CRDATAEXPORTTASK.DATAEXPORTTASK_DATAEXPORTTYPE.in(db.select(CRDATAEXPORTTYPE.DATAEXPORTTYPE_ID).from(CRDATAEXPORTTYPE).where(CRDATAEXPORTTYPE.DATAEXPORTTYPE_CODE.in(exportTypeCodes))));
                }

                List<CrdataexporttaskRecord> tasks = step.fetch();

                System.out.println("tasks.size(): " + tasks.size());

                int exportTime = (int) Instant.now().getEpochSecond();

                tasks.stream().forEach(o -> processExport(epochTime, exportTime, exports, o));
            }
            else{

                logger.debug("skipping export (" + context.getEpochTime() + ")..");
            }
        }

        // set email content template
        VelocityContext context = new VelocityContext();
        context.put("taskData", this.context);
        context.put("testList", testResults);
        context.put("inadequateData", inadequateResults);
        context.put("vendorDatas", vendorDatas);
        context.put("dataExports", exports);
        context.put("dataSourceDatas", dataSourceDatas);

        StringWriter swOut = new StringWriter();
        String templateStr = emailTemplate.getSettingsValue();

        /**
         * Merge data and template
         */
        Velocity.evaluate( context, swOut, "log tag name", templateStr);
//        System.out.println(swOut.toString());

        // Recipient's email ID needs to be mentioned.
        String to = emailTo.getSettingsValue();

        // Sender's email ID needs to be mentioned
        String from = smtpfrom.getSettingsValue();

        // Get system properties
        Properties properties = System.getProperties();

        // Setup mail server
        properties.setProperty("mail.smtp.host", smtphost.getSettingsValue());
        properties.setProperty("mail.smtp.port", smtpport.getSettingsValue());
        properties.put("mail.smtp.auth", "false");

        // Get the default Session object.
        Session session = Session.getDefaultInstance(properties);
        try {
            // Create a default MimeMessage object.
            MimeMessage message = new MimeMessage(session);

            // Set From: header field of the header.
            message.setFrom(new InternetAddress(from));

            Arrays.stream(to.split(",")).forEach(x-> {
                try {
                    message.addRecipient(Message.RecipientType.TO, new InternetAddress(x));
                } catch (MessagingException e) {
                    e.printStackTrace();
                }
            });

            // Set Subject: header field
            message.setSubject("Chrono Finalizer Summary " + this.context.getTIMEGROUP());

            message.setContent(swOut.toString(), "text/html");

            // Send message
            Transport.send(message);
            logger.debug("Chrono Finalizer Report Sent..");
            System.exit(0);
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }

    private void processExport(Date epochTime, int exportTime, ArrayList<CrdataexportRecord> exports, CrdataexporttaskRecord o){

        String yyyyMMdd = formatter.format(epochTime);
        String ddMMyy = formatter2.format(epochTime);

        DSLContext dbx = null;

        long start = System.currentTimeMillis();

        try {

            dbx = dbPool.borrowObject();

            dbx.execute("SET @epoch=" + this.context.getEpochTime());

            StringWriter swOut = new StringWriter();

            VelocityContext context = new VelocityContext();
            context.put("yyyyMMdd", yyyyMMdd);
            context.put("ddMMyy", ddMMyy);
            context.put("et", exportTimeGroup);

            String templateStr = o.getDataexporttaskFilename();
            Velocity.evaluate( context, swOut, "log tag name", templateStr);

            String fileName = swOut.toString();
            String filePath = o.getDataexporttaskLocation() + "/" + fileName;

            String compressedFileName = fileName + ".zip";
            String compressedFilePath = o.getDataexporttaskLocation() + "/" + compressedFileName;

            try {

                FileWriter writer = new FileWriter(filePath);

                logger.debug("generating file: " + filePath);

                Result<Record> result = dbx.fetch(o.getDataexporttaskSql());

                String[] columns = o.getDataexporttaskColumns().split(",");
                String[] data = new String[columns.length];

                char separator = o.getDataexporttaskDelimiter().charAt(0);

                // write header first
//                    CSVUtils.writeLine(writer, Arrays.asList(columns), separator, '"');
                CSVUtils.writeLine(writer, Arrays.asList(columns), separator);

                Object temp;

                for (int j = 0; j < result.size(); j++) {

                    // prepare data first
                    for (int k = 0; k < columns.length; k++) {

                        temp = result.get(j).getValue(columns[k].trim());

                        data[k] = (temp==null)?"":temp.toString();
                    }

                    // write data
//                        CSVUtils.writeLine(writer, Arrays.asList(data), separator, '"');
                    CSVUtils.writeLine(writer, Arrays.asList(data), separator);
                }

                writer.flush();
                writer.close();

                // upload before zipping
                if(o.getDataexporttaskSftphost() != null && o.getDataexporttaskCompress() == 0x00){

                    try{

                        // add routine to upload to SFTP
                        String host = o.getDataexporttaskSftphost();
                        int port = o.getDataexporttaskSftpport();
                        String userName = o.getDataexporttaskSftpuser();
                        String password = o.getDataexporttaskSftppassword();
                        String dir = o.getDataexporttaskSftpdir();

                        ChannelSftp channelSftp = setupJsch(host, port, userName, password);
                        channelSftp.connect();

                        String localFile = filePath;
                        String remoteDir = dir + "/";

                        logger.debug("localFile: " + localFile);
                        logger.debug("remoteDir + fileName: " + (remoteDir + fileName));

                        channelSftp.put(localFile, remoteDir + fileName);

                        channelSftp.exit();

                        channelSftp.disconnect();

                        logger.debug("uploaded plain: " + fileName);

                    } catch (JSchException e) {
                        e.printStackTrace();
                    } catch (SftpException e) {
                        e.printStackTrace();
                    }
                }

                // zip file and store to export data table
                FileOutputStream fos = new FileOutputStream(compressedFilePath);
                ZipOutputStream zipOut = new ZipOutputStream(fos);

                File fileToZip = new File(filePath);
                FileInputStream fis = new FileInputStream(fileToZip);
                ZipEntry zipEntry = new ZipEntry(fileToZip.getName());
                zipOut.putNextEntry(zipEntry);
                byte[] bytes = new byte[1024];
                int length;
                while((length = fis.read(bytes)) >= 0) {
                    zipOut.write(bytes, 0, length);
                }
                zipOut.close();
                fis.close();
                fos.close();

                // delete csv file
                File fRem = new File(filePath);
                fRem.delete();

                File f = new File(compressedFilePath);

                // upload after zipping
                if(o.getDataexporttaskSftphost() != null && o.getDataexporttaskCompress() == 0x01){

                    try{

                        // add routine to upload to SFTP
                        String host = o.getDataexporttaskSftphost();
                        int port = o.getDataexporttaskSftpport();
                        String userName = o.getDataexporttaskSftpuser();
                        String password = o.getDataexporttaskSftppassword();
                        String dir = o.getDataexporttaskSftpdir();

                        ChannelSftp channelSftp = setupJsch(host, port, userName, password);
                        channelSftp.connect();

                        String localFile = compressedFilePath;
                        String remoteDir = dir + "/";

                        String compressedFileName2 = compressedFileName.substring(0, compressedFileName.lastIndexOf("."));
                        compressedFileName2 = compressedFileName2.substring(0, compressedFileName2.lastIndexOf(".")) + ".zip";

                        System.out.println("compressedFileName2: " + compressedFileName2);

                        channelSftp.put(localFile, remoteDir + compressedFileName2);

                        channelSftp.exit();

                        channelSftp.disconnect();

                        logger.debug("uploaded compressed: " + compressedFileName2);

                    } catch (JSchException e) {
                        e.printStackTrace();
                    } catch (SftpException e) {
                        e.printStackTrace();
                    }
                }

                CrdataexportRecord dataExport = db.newRecord(CRDATAEXPORT);
                dataExport.setDataexportTotaldownload(0);

                dataExport.setDataexportDate(this.context.getEpochTime());
                dataExport.setDataexportDataexporttype(o.getDataexporttaskDataexporttype());
                dataExport.setDataexportFilename(compressedFileName);
                dataExport.setDataexportPath(compressedFilePath);
                dataExport.setDataexportSize((int)f.length());
                dataExport.setDataexportLastupdate(exportTime);
                dataExport.setDataexportTotaldata(result.size());
                dataExport.setDataexportExtension("zip");
                dataExport.setDataexportChecksum(FileUtils.getMd5(f));

                int res = dataExport.store();

                exports.add(dataExport);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        if(dbx != null){
            try {
                dbPool.returnObject(dbx);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private boolean generateRanCell(ArrayList<Integer> finalizerTaskIds){

        CrfinalizertaskRecord targetColumns = db.selectFrom(CRFINALIZERTASK)
                .where(CRFINALIZERTASK.FINALIZERTASK_CODE.equal("CRRANCELL_COLUMNS"))
                .and(CRFINALIZERTASK.FINALIZERTASK_TASKTYPE.equal("TARGET_COLUMNS"))
                .fetchOne();

        if(targetColumns == null){
            return false;
        }

        String[] targetCols1 = targetColumns.getFinalizertaskColumns().replaceAll("\n","").split(",");

        logger.debug("targetCols1.size(): " + targetCols1.length);

        SelectConditionStep<CrfinalizertaskRecord> step = db.selectFrom(CRFINALIZERTASK)
                .where(CRFINALIZERTASK.FINALIZERTASK_CODE.equal("CRRANCELL_SOURCE"))
                .and(CRFINALIZERTASK.FINALIZERTASK_TASKTYPE.equal("SOURCE_QUERY"))
                .and(CRFINALIZERTASK.FINALIZERTASK_ENABLED.isTrue());

        if(!finalizerTaskIds.isEmpty()){

            step.and(CRFINALIZERTASK.FINALIZERTASK_ID.in(finalizerTaskIds));
        }

        List<CrfinalizertaskRecord> tasks = step.fetch();

        logger.debug("tasks.size(): " + tasks.size());

        tasks.stream().forEach(obj -> executeFinalizer(obj.getFinalizertaskId(), targetCols1));

        return true;
    }

    private void executeFinalizer(int finalizerId, String[] targetCols1){

        System.out.println("HAHAHA");

        String columnForFreqCalculation = "rancell_cellclass";
        String columnForFreqCalculation2g = "ARFCN";
        String columnForFreqCalculation3g = "UARFCN";
        String columnForFreqCalculation4g = "EARFCN";

        String targetColumn2gC1 = "ULFREQ";
        String targetColumn2gC2 = "DLFREQ";

        String targetColumn3gC1 = "ULFREQ";
        String targetColumn3gC2 = "DLFREQ";

        String targetColumn4gC1 = "ULFREQ";
        String targetColumn4gC2 = "DLFREQ";

        String[] cols;

        DSLContext dbx = null;

        try {

            dbx = dbPool.borrowObject();

            dbx.execute("SET @epoch=" + this.context.getEpochTime());

            CrfinalizertaskRecord task = dbx.fetchOne(CRFINALIZERTASK, CRFINALIZERTASK.FINALIZERTASK_ID.eq(finalizerId));

            logger.debug("got task: " + task.getFinalizertaskName());

            String finalizerColumns = task.getFinalizertaskColumns();
            String finalizerCustomTargets = task.getFinalizertaskCustomtarget();
            String finalizerCustomFunc = task.getFinalizertaskCustomfunction();

//            logger.debug("finalizerColumns: " + finalizerColumns);
//            logger.debug("finalizerCustomTargets: " + finalizerCustomTargets);
//            logger.debug("finalizerCustomFunc: " + finalizerCustomFunc);

            // set default
            cols = targetCols1;

            if(task.getFinalizertaskColumnstarget() != null){

                try{
                    cols = task.getFinalizertaskColumnstarget().replaceAll("\n","").split(",");
                    logger.debug("targetCols2.size(): " + cols.length);
                }
                catch(Exception e){}
            }

            Result<Record> records = dbx.fetch(finalizerColumns);

            logger.debug("finalizerColumns got: " + records.size() + " record(s)");

            List<CrrancellRecord> newRecords = new ArrayList<CrrancellRecord>();

            for (int x = 0; x < records.size(); x++) {

                Record r = records.get(x);

//                CrrancelltempRecord newRecord = db.newRecord(CRRANCELLTEMP);
                CrrancellRecord newRecord = new CrrancellRecord();
                newRecord.setRancellCrfinalizertask(task.getFinalizertaskId());

                // fill default field value
                for (int y = 0; y < cols.length; y++) {

                    if(r.getValue(cols[y]) != null){

//                        System.out.println("SET " + targetCols[y] + ": " + r.getValue(targetCols[y]).toString());
                        newRecord.set(DSL.field(cols[y]), r.getValue(cols[y]).toString());
                    }
                }

                // fill custom field value
                try {

                    JSONObject customTargetsJson = new JSONObject(finalizerCustomTargets);
                    JSONArray names = customTargetsJson.names();

                    for (int j = 0; j < names.length(); j++) {

                        String resultText = "performing validation: " + names.getString(j) + " -> " + r.get("CELLNAME") + " => ";

                        JSONObject valObj = customTargetsJson.getJSONObject(names.getString(j));

                        String validator = valObj.getString("validator");

                        JSONObject columns = valObj.getJSONObject("columns");
                        JSONArray columnsNames = columns.names();

                        //get candidate's length from 1st object
                        int count = columns.getJSONArray(columnsNames.getString(0)).length();

//                        System.out.println("--------");

                        ArrayList<String> keys = new ArrayList<>();
                        ArrayList<String> vals = new ArrayList<>();

                        boolean found = false;
                        for (int k = 0; k < count && !found; k++) {

                            String toEval = "";

                            keys.clear();
                            vals.clear();

                            for (int l = 0; l < columnsNames.length(); l++) {

//                                System.out.println("set (" + (k) + "): " + columns.getJSONArray(columnsNames.getString(l)).getString(k));

                                String cName = columns.getJSONArray(columnsNames.getString(l)).getString(k);

                                toEval += "var " + columnsNames.getString(l) + "=" + r.getValue(cName) + ";\n";

                                keys.add(columnsNames.getString(l));
                                if(r.getValue(cName) != null){
                                    vals.add(r.getValue(cName).toString());
                                }
                                else{
                                    vals.add(null);
                                }
                            }

                            toEval += "\n" + finalizerCustomFunc + "\n";

                            toEval += validator + ";\n";

//                            System.out.println("xxxxxx");
//                            System.out.println("toEval: " + toEval);
//                            System.out.println("xxxxxx");

                            try {
                                if (engine.eval(toEval).toString().equals("true")) {

//                                    logger.debug("found valid data for: " + names.getString(j) + " -> " + r.get("CELLNAME"));

                                    for (int l = 0; l < keys.size(); l++) {
                                        if(vals.get(l) != null){
                                            newRecord.set(DSL.field(keys.get(l)), vals.get(l));
                                        }
                                    }
                                    found = true;
                                }
                            } catch (ScriptException e) {
                                e.printStackTrace();
                            }
                        }

                        resultText += found;

                        logger.debug(resultText);

                        if(!found){

                            for (int l = 0; l < keys.size(); l++) {
                                newRecord.set(DSL.field(keys.get(l)), null);
                            }
                        }

                        newRecords.add(newRecord);

//                        if(newRecords.size() > 10000){
//                            logger.debug("inserting to crrancell xx  (" + newRecords.size() + " item(s))");
//                            db.batchStore(newRecords).execute();
//                            newRecords.clear();
//                            logger.debug("done inserting to crrancell xx..");
//                        }


//                        try{
//                            newRecord.store();
//                        }
//                        catch(Exception e){}

//                        System.out.println("+++++++++");
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                // freq. calculation
//                String columnForFreqCalculation = "rancell_cellclass";
//                String columnForFreqCalculation3g = "UARFCN";
//                String columnForFreqCalculation4g = "EARFCN";
//
//                String targetColumn3gC1 = "FREQ1";
//                String targetColumn3gC2 = "FREQ2";
//
//                String targetColumn4gC1 = "FREQ1";
//                String targetColumn4gC2 = "FREQ2";

                Integer cellClassId = r.get(columnForFreqCalculation, Integer.class);

                if(cellClassId != null){

                    CrcellclassRecord cc = cellClassessById.get(cellClassId.intValue());

                    if(cc != null){

                        if(cc.getCellclassRat() != null)
                        {
                            if(cc.getCellclassRat().equals("2G")){

                                Double arfcn = r.get(columnForFreqCalculation2g, Double.class);

                                if(arfcn != null){

                                    CellFreqResult res = CellUtils.calc2gArfcn(arfcn.doubleValue());

                                    // use the c2
                                    if(res.c2 != -1){

                                        newRecord.set(DSL.field(targetColumn2gC1), String.valueOf(res.c1));
                                        newRecord.set(DSL.field(targetColumn2gC2), String.valueOf(res.c2));
                                    }
                                }
                            }
                            else if(cc.getCellclassRat().equals("3G")){

                                Double uarfcn = r.get(columnForFreqCalculation3g, Double.class);

                                if(uarfcn != null){

                                    CellFreqResult res = CellUtils.calc3gUarfcn(uarfcn.doubleValue());

                                    if(res.c1 != -1){

                                        newRecord.set(DSL.field(targetColumn3gC1), String.valueOf(res.c1));
                                    }
                                    if(res.c2 != -1){

                                        newRecord.set(DSL.field(targetColumn3gC2), String.valueOf(res.c2));
                                    }
                                }
                            }
                            else if(cc.getCellclassRat().equals("4G")){

                                Double earfcn = r.get(columnForFreqCalculation4g, Double.class);

                                if(earfcn != null){

                                    CellFreqResult res = CellUtils.calc4gEarfcn(earfcn.doubleValue());

//                                    System.out.printf("c1: " + res.c1 + " -> c2: " + res.c2);

                                    if(res.c1 != -1){

                                        newRecord.set(DSL.field(targetColumn4gC1), String.valueOf(res.c1));
                                    }
                                    if(res.c2 != -1){

                                        newRecord.set(DSL.field(targetColumn4gC2), String.valueOf(res.c2));
                                    }
                                }
                            }
                        }
                    }
                }
            }

            logger.debug("inserting to crrancell (" + newRecords.size() + " item(s))");
            dbx.batchStore(newRecords).execute();
            logger.debug("done inserting to crrancell..");



        } catch (Exception e) {
            e.printStackTrace();
        }
        if(dbx != null){
            try {
                dbPool.returnObject(dbx);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private boolean generateRanBts(){

        return true;
    }

    private ChannelSftp setupJsch(String host, int port, String user, String password) throws JSchException {

        JSch jsch = new JSch();
        jsch.setKnownHosts("~/.ssh/known_hosts");
        com.jcraft.jsch.Session jschSession = jsch.getSession(user, host, port);
        jschSession.setPassword(password);

        java.util.Properties config = new java.util.Properties();
        config.put("StrictHostKeyChecking", "no");
        jschSession.setConfig(config);

        jschSession.connect();

        return (ChannelSftp) jschSession.openChannel("sftp");
    }

    public static void main(String[] args) {
        new Finalizer(args);
    }
}

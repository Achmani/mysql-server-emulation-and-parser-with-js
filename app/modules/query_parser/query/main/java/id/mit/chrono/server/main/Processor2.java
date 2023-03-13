package id.mit.chrono.server.main;

import id.mit.chrono.server.base.BaseMain;
import id.mit.chrono.server.base.BaseParserGroup;
import id.mit.chrono.server.builder.DatasourceProcessorBuilder;
import id.mit.chrono.server.builder.TaskFilesTransformerBuilder;
import id.mit.chrono.server.database.DatabaseHelper;
import id.mit.chrono.server.factory.DaoFactory;
import id.mit.chrono.server.iface.ExtractorServiceCallback;
import id.mit.chrono.server.iface.ParserGroupCallback;
import id.mit.chrono.server.iface.TransformerServiceCallback;
import id.mit.chrono.server.obj.HuaweiBasicKeyParamsObj;
import id.mit.chrono.server.obj.PreparatorResultGroup;
import id.mit.chrono.server.service.ExtractorService;
import id.mit.chrono.server.model.tables.records.*;
import id.mit.chrono.server.provider.DatasourceProviderFactory;
import id.mit.chrono.server.service.LoaderService;
import id.mit.chrono.server.service.TransformerService;
import id.mit.chrono.server.util.SystemUtils;
import org.apache.commons.cli.*;
import org.apache.commons.lang3.StringUtils;
import org.jooq.Record;
import org.jooq.Result;
import org.xml.sax.SAXException;
import org.xml.sax.SAXNotRecognizedException;
import org.xml.sax.SAXNotSupportedException;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.xml.XMLConstants;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.StringReader;
import java.time.Instant;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static id.mit.chrono.server.model.Tables.*;
import static id.mit.chrono.server.model.Tables.CRSITE;

public class Processor2 extends BaseMain implements ExtractorServiceCallback, TransformerServiceCallback, ParserGroupCallback {

    private Result<Record> files;
    private Result<CrmapparserRecord> maps;

    private int maxParallelPerParser = 50;
    private int totalParserGroupDone = 0;
    private int fileCountLimit = 0;
    private String mode = "ETL";
    private boolean mapping = false;

    private boolean reProcess = false;
    // default poolSize = 10
    private int poolSize = 10;

    private String workflow = "";

    private HashMap<String, CrcellclassRecord> cellClassCache = new HashMap<>();

    ScriptEngineManager mgr = new ScriptEngineManager();
    ScriptEngine engine;

    private List<CrnodepatternRecord> nodePatterns;
    private List<CrcellclassRecord> cellclasses;
    private HashMap<Integer, CrcellclassRecord> cellClassessById = new HashMap<>();
    private List<CrcellstatusRecord> cellstatuses;
    private List<CrcellclassgroupRecord> cellclassgroups;
    private List<CrcellRecord> cells;
    private List<CrnodeRecord> nodes;
    private List<CrnodeRecord> nodeAlias;
    private List<CrnodecategoryRecord> nodeCategories;
    private List<CrnodestatusRecord> nodestatuses;
    private List<CrnodemapsRecord> nodemaps;
    private List<CrsettingsRecord> settings;
    private List<CrcellpatternRecord> cellPatterns;
    private List<CrcellnodeidRecord> cellnodeids;

    private Object lockObj = new Object();
    String siteIdPattern = "([A-Z]{3}[0-9]{3})";

    public Processor2(String[] args) {

        logger.info("new instance initiated with param: " + StringUtils.join(args, " "));

        boolean argIsOk = this.parseArguments(args);

        if (!argIsOk) {

            logger.debug("exiting with -1 status..");
            System.exit(-1);
        }

        SystemUtils.logSystemInfo(logger);

        engine = mgr.getEngineByName("JavaScript");

        db = DatabaseHelper.connectDB();

        getTask();

        getDataSources();

        getSupportData();

        if (files.size() > 0) {

            if (mode.equals("E") || mode.equals("ETL")) {
                extract();
            } else if (mode.equals("TL")) {
                transform();
            }

        }
    }

    public static void main(String[] args) {

        SAXParserFactory factory = SAXParserFactory.newInstance();
        factory.setValidating(false);

        new Processor2(args);
    }

    private boolean parseArguments(String[] args) {

        // sample arguments: -g CM_RAN -tg 201804300900 -r

        // help
        options.addOption("h", "help", false, "show help.");

        // group
        options.addOption("g", "group", true, "groups: CM_RAN|CM_CORE|CM_TRANSPORT|INVENTORY_RAN");

        // time group
        options.addOption("tg", "time-group", true, "time group (yyyyMMddHHmm)");

        options.addOption("t", "timeout", true, "timeout in ms");

        options.addOption("j", "job", true, "max paralel per vendor group");

        // re-process
        options.addOption("rp", "re-process", false, "re-process all processed files");

        // db pool
        options.addOption("ps", "poolsize", true, "set database pool size");

        // ETL mode
        options.addOption("m", "mode", true, "ETL Mode. (E: Extract Only, TL: Transform and Load, ETL: Full Operation");

        // workflow
        options.addOption("w", "workflow", true, "Choose workflow entity");

        // map nptq
        options.addOption("mp", "mapping nptq", false, "find all related NTPQ parameters in all file (if enabled)");

        Option dsOption = new Option("ds", "data-source", true, "specified data source name(s) , ex: \"OSSSVR1 OSSSVR2\"");
        dsOption.setArgs(10);
        options.addOption(dsOption);

        Option fnOption = new Option("fn", "file-name", true, "specified source file name(s) , ex: \"*_CFGMML_* GExport_*\"");
        fnOption.setArgs(10);
        options.addOption(fnOption);

        Option fidOption = new Option("fid", "file-id", true, "specified source file id(s) , ex: 7522747 7522742 7522741");
        fidOption.setArgs(10);
        options.addOption(fidOption);

        options.addOption("l", "limit", true, "limit on total file to process");

        Option entOption = new Option("e", "entity", true, "specified entity(es) , ex: hwbsc hwrnc nokbsc");
        entOption.setArgs(10);
        options.addOption(entOption);

        options.addOption("op", "only-parse", false, "only parse, no insert to db");

        options.addOption("nr", "no-routine", false, "no routine execution");

//        Option vendorOption = new Option("v", "vendor-code", true, "specified source file vendor(s) , ex: zte huawei nokia");
//        vendorOption.setArgs(4);
//        options.addOption(vendorOption);

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

            if (cmd.hasOption("t")) {

                logger.debug("found 't': " + cmd.getOptionValue("t", null));

                try {
                    int x = Integer.parseInt(cmd.getOptionValue("g", "0"));
                    TIMEOUT = x;
                } catch (Exception e) {

                }
            }

            if (cmd.hasOption("j")) {

                logger.debug("found 'j': " + cmd.getOptionValue("j", null));

                try {
                    maxParallelPerParser = Integer.parseInt(cmd.getOptionValue("j", "1"));
                } catch (Exception e) {

                }
            }

            if (cmd.hasOption("ds")) {
                dataSources = cmd.getOptionValues("ds");
                if (dataSources.length == 0) {
                    dataSources = null;
                }
            }

            if (cmd.hasOption("fn")) {
                fileNames = cmd.getOptionValues("fn");
                if (fileNames.length == 0) {
                    fileNames = null;
                }
            }

            if (cmd.hasOption("fid")) {

                String[] fileIdsString = cmd.getOptionValues("fid");

                ArrayList<Integer> tempFileIds = new ArrayList<Integer>();

                int temp;

                for(String s: fileIdsString){

                    try{

                        temp = Integer.parseInt(s);
                        tempFileIds.add(temp);
                    }
                    catch(Exception e){}
                }

                fileIds = null;

                if (tempFileIds.size() > 0) {

                    fileIds = tempFileIds.toArray(new Integer[tempFileIds.size()]);
                }
            }


            if (cmd.hasOption("l")) {

                logger.debug("found 'l': " + cmd.getOptionValue("l", null));

                try {
                    int x = Integer.parseInt(cmd.getOptionValue("l", "0"));
                    fileCountLimit = x;
                } catch (Exception e) {

                }
            }

            if (cmd.hasOption("e")) {
                entities = cmd.getOptionValues("e");
                if (entities.length == 0) {
                    entities = null;
                }
            }

            if (cmd.hasOption("op")) {

                context.setPARSE_ONLY(true);
            }

            if (cmd.hasOption("nr")) {

//                noRoutine = true;
            }

            if (cmd.hasOption("rp")) {
                logger.debug("found 'rp': re-processing all processed files.");
                this.reProcess = true;
            }

            if (cmd.hasOption("mp")) {
                logger.debug("found 'mp': find all related NTPQ parameters in all file");
                this.mapping = true;
            }

            if (cmd.hasOption("ps")) {
                logger.debug("found 'ps': set poolsize to " + cmd.getOptionValue("ps", null));

                try {
                    this.poolSize = Integer.parseInt(cmd.getOptionValue("ps", "10"));
                } catch (Exception e) {

                }
            }

            if (cmd.hasOption("m")) {
                try {

                    this.mode = cmd.getOptionValue("m");

                    switch (mode) {
                        case "E":
                            logger.debug("found 'm': ETL Mode -> Extract Only");
                            break;

                        case "TL":
                            logger.debug("found 'm': ETL Mode -> Transform and Load");
                            break;

                        case "ETL":
                            logger.debug("found 'm': ETL Mode -> Extract Transform Load");
                            break;
                    }

                } catch (Exception e) {

                }
            }

            if (cmd.hasOption("w")) {
                try {
                    logger.debug("found 'workflow': " + cmd.getOptionValue("w", null));
                    this.workflow = cmd.getOptionValue("w", null);
                } catch (Exception e) {

                }
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

    private void getDataSources() {

        stopwatch.start();

        files = DatasourceProviderFactory.getDatasourceProcessor(context,
                new DatasourceProcessorBuilder()
                        .setDataSources(dataSources)
                        .setFileNames(fileNames)
                        .setFileIds(fileIds)
                        .setEntities(entities)
                        .setReProcess(reProcess)
                        .setFileCountLimit(fileCountLimit)
                        .build());

        logger.debug("total file(s): " + files.size());

        stopwatch.stop();
        logger.debug("get data source in " + stopwatch.elapsed(TimeUnit.MILLISECONDS) + " ms");
    }

    private void getSupportData() {

        // id.mit.chrono.server.parser class mapping
        stopwatch.start();

        maps = DaoFactory.createMapParserDaoImpl().getMapParsers();

        stopwatch.stop();
        logger.debug("get id.mit.chrono.server.parser map in " + stopwatch.elapsed(TimeUnit.MILLISECONDS) + " ms for " + maps.size() + " item(s)");

        stopwatch.start();

        nodePatterns = DaoFactory.createNodePatternDaoImpl().getNodePatterns();

        stopwatch.stop();
        logger.debug("get node pattern in " + stopwatch.elapsed(TimeUnit.MILLISECONDS) + " ms for " + nodePatterns.size() + " item(s)");

        stopwatch.start();

        cellclasses = DaoFactory.createCellClassDao().getCellClasses();

        for(CrcellclassRecord r: cellclasses){
            cellClassessById.put(r.getCellclassId().intValue(), r);
        }


        cellclassgroups = DaoFactory.createCellClassGroupDao().getCellClassGroups();
        stopwatch.stop();
        logger.debug("get cell class in " + stopwatch.elapsed(TimeUnit.MILLISECONDS) + " ms for " + cellclasses.size() + " item(s)");

        stopwatch.start();
        // get all cell, prever to load first to prevent over time consume
        cells = DaoFactory.createCellDao().getCells();

        cellstatuses = DaoFactory.createCellStatusDaoImpl().getCellStatuses();

        stopwatch.stop();
        logger.debug("get cell in " + stopwatch.elapsed(TimeUnit.MILLISECONDS) + " ms for " + cells.size() + " item(s)");
        stopwatch.start();

        // get all node
        nodes = DaoFactory.createNodeDaoImpl().getNodes();
        nodeAlias = DaoFactory.createNodeDaoImpl().getNodeAliases();
        nodeCategories = DaoFactory.createNodeCategoryDaoImpl().getNodeCategories();

        nodestatuses = DaoFactory.createNodeStatusDaoImpl().getNodeStatuses();

        stopwatch.stop();
        logger.debug("get node in " + stopwatch.elapsed(TimeUnit.MILLISECONDS) + " ms for " + nodes.size() + " item(s)");

        stopwatch.start();
        // get all node
        nodemaps = DaoFactory.createNodeMapsDaoImpl().getNodeMaps();

        stopwatch.stop();
        logger.debug("get nodemaps in " + stopwatch.elapsed(TimeUnit.MILLISECONDS) + " ms for " + nodemaps.size() + " item(s)");// get all node

        stopwatch.start();
        siteIdPattern = DaoFactory.createSettingsDaoImpl().getSingleSettings("SITE_PATTERN", "SITE").getSettingsValue();

        stopwatch.stop();
        logger.debug("get site id pattern in " + stopwatch.elapsed(TimeUnit.MILLISECONDS) + " ms");

        stopwatch.start();
        cellPatterns = DaoFactory.createCellPatternDaoImpl().getCellPatterns();

        stopwatch.stop();
        logger.debug("get cellpatterns in " + stopwatch.elapsed(TimeUnit.MILLISECONDS) + " ms for " + cellPatterns.size() + " item(s)");

        stopwatch.start();
        cellnodeids = DaoFactory.createCellNodeIdDaoImpl().getCellNodeIds();
        stopwatch.stop();
        logger.debug("get cellnodeids in " + stopwatch.elapsed(TimeUnit.MILLISECONDS) + " ms for " + cellnodeids.size() + " item(s)");
    }

    private void extract() {

        stopwatch.start();

        if (files == null) {
            logger.debug("files is null, returning");
            return;
        }

        ExtractorService extractor = new ExtractorService(context, files, reProcess, this, dfs, maxParallelPerParser, poolSize);
        extractor.process();

    }

    private void transform() {

        files.forEach(file -> {
            System.out.println("######### collected file #########");
            System.out.println("file: " + file.getValue(CRCOLLECTORTASKFILES.COLLECTORTASKFILES_LOCALFILENAME) + " -> id: " + file.get(CRCOLLECTORTASKFILES.COLLECTORTASKFILES_ID));
        });

        // create builder first
        TaskFilesTransformerBuilder builder = new TaskFilesTransformerBuilder()
                                                    .setEntities(entities)
                                                    .setFileIds(fileIds)
                                                    .setReprocess(reProcess)
                                                    .setPoolsize(poolSize)
                                                    .setWorkflow(workflow)
                                                    .setMapping(mapping)
                                                    .build();

        TransformerService transformer = new TransformerService(context, files, reProcess, builder, this);
        transformer.preparator();

    }

    @Override
    public void onTransformSuccess(List<PreparatorResultGroup> resultGroups) {
        LoaderService service = new LoaderService(context, resultGroups, dfs, drillCl, this);
        service.process();
    }

    @Override
    public void onTransformFailed(String reason) {
        logger.debug("Transform Failed. Reason: " + reason);
        System.exit(-1);
    }

    @Override
    public void onExtractSuccess(String message) {
        logger.debug(message);

        if (this.mode.equals("ETL")) {
            transform();
        }
    }




    @Override
    public void onParserGroupFinished(BaseParserGroup pg) {

    }

    @Override
    public CrnodeRecord getNode(int vendorId, String nodeName, int defaultNeCategory) {
        // process Node ID first
        String nodeCode = null;
        CrnodemapsRecord tmp;
        CrnodeRecord crTmp = null;
        CrnodepatternRecord pr = null;
        Pattern pattern;
        Matcher matcher;

        if(nodeName == null || nodeName.trim().isEmpty()){
            return null;
        }

        nodeName = nodeName.toUpperCase();

        // check for pattern to get "ne id" part, ex.: JKW001MM1_XXX -> JKW001MM1
        for (int i = 0; i < nodePatterns.size(); i++) {

            pr = nodePatterns.get(i);

            if(pr.getNodepatternVendor().equals(vendorId) && pr.getNodepatternNodecategory().equals(defaultNeCategory)){

                pattern = Pattern.compile(pr.getNodepatternPattern());

                matcher = pattern.matcher(nodeName);

                if (matcher.find()) {

                    nodeCode = matcher.group(1);
                    break;
                }
            }
        }

        synchronized (lockObj){

            // 1st to fix everything, try to lookup from crnodemaps
            if (nodeCode == null) {

                CrnodemapsRecord crnodemaps = null;

                // tro to get from crnodemaps
                for (int i = 0; i < nodemaps.size(); i++) {

                    tmp = nodemaps.get(i);

                    if (tmp.getCrnodemapsEnabled() == 1 &&
                            tmp.getCrnodemapsNodecategory() == defaultNeCategory &&
                            tmp.getCrnodemapsNodename().equals(nodeName)) {

                        crnodemaps = tmp;
                        break;
                    }
                }

                // if found
                if (crnodemaps != null) {

                    for (int i = 0; nodeCode == null && i < nodes.size(); i++) {

                        crTmp = nodes.get(i);

                        if (crTmp.getNodeId() == crnodemaps.getCrnodemapsNode()) {

                            nodeCode = crTmp.getNodeCode();
                        }
                    }
                }
            }

            if (nodeCode != null) {

                CrnodeRecord crnode = null;

                for (int i = 0; crnode == null && i < nodes.size(); i++) {

                    crTmp = nodes.get(i);

                    if (crTmp.getNodeNodecategory().equals(defaultNeCategory) &&
                            crTmp.getNodeNodetype().equals(2) && // RAT
                            crTmp.getNodeCode().equals(nodeCode)) {

                        crnode = crTmp;
                    }
                }

                if (crnode == null) {

                    // try to insert to Crnode
                    crnode = db.newRecord(CRNODE);

                    crnode.setNodeCode(nodeCode);
                    crnode.setNodeNodecategory(defaultNeCategory);
                    crnode.setNodeRevenueclass(1); // lowest
                    crnode.setNodeNodetype(2); // RAT
                    crnode.setNodeLastupdate((int) Instant.now().getEpochSecond());

                    int result;
                    try{

                        result= crnode.store();
                    }
                    catch(Exception e){

                    }
                }

                // select again
                crnode = db.selectFrom(CRNODE)
                        .where(CRNODE.NODE_CODE.eq(nodeCode))
                        .and(CRNODE.NODE_NODECATEGORY.eq(defaultNeCategory))
                        .and(CRNODE.NODE_NODETYPE.eq(2))
                        .fetchOne();

                //select again
                if (crnode != null) {

                    synchronized (nodes){

                        nodes.add(crnode);
                    }
                }

                return crnode;
            }
        }

        return null;
    }

    @Override
    public int getNodeStatus(String nodeName) {
        for (int i = 0; nodeName != null && i < nodestatuses.size(); i++) {

            if(nodestatuses.get(i).getNodestatusPrefix().isEmpty()){
                continue;
            }

            if(nodeName.matches(nodestatuses.get(i).getNodestatusPrefix())){

                return nodestatuses.get(i).getNodestatusId();
            }
        }

        return 1;
    }

    @Override
    public CrcellRecord getCell(String lookup, String identifier, CrcellRecord cellProto, CrnodeRecord nodeData) {
        // lookup to cellClassCache;
        int cellClassId = -1;

        if(identifier == null){
            return null;
        }

        String key = lookup + ":" + identifier;

        // lock first
        synchronized (cellClassCache){

            if (cellClassCache.containsKey(key)) {

                cellClassId = cellClassCache.get(key).getCellclassId().intValue();
            } else {

                CrcellclassRecord crcellclass = db.selectFrom(CRCELLCLASS)
                        .where(CRCELLCLASS.CELLCLASS_LOOKUP.eq(lookup))
                        .fetchOne();

                if (crcellclass != null) {

                    // put back to the cache
                    cellClassCache.put(lookup, crcellclass);
                    cellClassId = crcellclass.getCellclassId().intValue();
                }
            }
        }

        // if found
        if (cellClassId != -1) {

            CrcellRecord crcell = null;
            CrcellRecord tmp;

            for (int i = 0; crcell == null && i < cells.size(); i++) {

                tmp = cells.get(i);

                if (tmp.getCellCellclass() == cellClassId && (identifier.equals(tmp.getCellCgi()) || identifier.equals(tmp.getCellEcgi()) || identifier.equals(tmp.getCellNcgi()))) {

                    crcell = tmp;
                }
            }

            // still not found, need to insert new data
            if (crcell == null) {

                // lock for insert first
//                synchronized (something){
//
//                }

                // insert new
                crcell = db.newRecord(CRCELL);

                if (lookup.startsWith("LTE")) {
                    crcell.setCellEcgi(identifier);
                } else if (lookup.startsWith("NR")) {
                    crcell.setCellNcgi(identifier);
                }
                else {
                    crcell.setCellCgi(identifier);
                }

                crcell.setCellCellclass(cellClassId);

                if (nodeData != null) {

                    crcell.setCellSite(nodeData.getNodeSite());
                    crcell.setCellNode(nodeData.getNodeId());
                    crcell.setCellRevenueclass(nodeData.getNodeRevenueclass());
                }

                if (crcell.getCellRevenueclass() == null) {
                    crcell.setCellRevenueclass(1); // lowest
                }

                try{
                    crcell.store();
                }
                catch(Exception e){}

                if(crcell.getCellId() == null){

                    crcell = db.selectFrom(CRCELL)
                            .where(CRCELL.CELL_CELLCLASS.eq(cellClassId))
                            .and(CRCELL.CELL_CGI.eq(identifier).or(CRCELL.CELL_ECGI.eq(identifier)))
                            .fetchOne();
                }

                if(crcell.getCellId() != null){

                    synchronized (cells){
                        cells.add(crcell);
                    }
                }
            }

            // check for mapping to crsite
            if(crcell != null && cellProto != null){

                logger.debug("found crcell: " + crcell.getCellId());

                boolean ok = crcell.getCellSite() == null;
                ok |= crcell.getCellSiteinfo() == null;
                ok |= crcell.getCellSiteinfolatitude() == null;
                ok |= crcell.getCellSiteinfolongitude() == null;
                ok |= crcell.getCellLatitude() == null;
                ok |= crcell.getCellLongitude() == null;

                if(ok){

                    // process for site info, lat, & lon
                    logger.debug("trying to complete crcell: " + crcell.getCellId());

                    String siteIdFromSiteInfo = null;

                    if(cellProto.getCellSiteinfo() != null){

                        ArrayList<String> getFromPattern = getFromPattern(siteIdPattern, cellProto.getCellSiteinfo());

                        if(getFromPattern.size() > 0){
                            siteIdFromSiteInfo = getFromPattern.get(0);
                        }
                    }

                    if(siteIdFromSiteInfo != null){

                        // connect to crsite
                        CrsiteRecord crsite = db.selectFrom(CRSITE)
                                .where(CRSITE.SITE_CODE.eq(siteIdFromSiteInfo))
                                .fetchOne();

                        // if not found, try to insert
                        if (crsite == null) {

                            crsite = db.newRecord(CRSITE);

                            crsite.setSiteCode(siteIdFromSiteInfo);

                            crsite.setSiteLatitude(cellProto.getCellLatitude());
                            crsite.setSiteLongitude(cellProto.getCellLongitude());

                            int result;
                            try{

                                result= crsite.store();
                            }
                            catch(Exception e){
                                logger.debug("error saving: " + siteIdFromSiteInfo);
                                e.printStackTrace();
                            }
                        }
                        else{

                            if(crsite.getSiteLatitude() == null){

                                crsite.setSiteLatitude(cellProto.getCellLatitude());
                                crsite.setSiteLongitude(cellProto.getCellLongitude());

                                int result;
                                try{

                                    result= crsite.update();
                                }
                                catch(Exception e){
                                    logger.debug("error saving: " + siteIdFromSiteInfo);
                                    e.printStackTrace();
                                }
                            }
                        }

                        // select again
                        crsite = db.selectFrom(CRSITE)
                                .where(CRSITE.SITE_CODE.eq(siteIdFromSiteInfo))
                                .fetchOne();

                        // update crcell -> crsite mapping
                        if(crsite != null){

                            // try to update crsite property also
                            // 1. map to site area
                            // 2. latitude & longitude
                            // 3. site name?

                            boolean updateCrsite = false;

                            if(crsite.getSiteLatitude() == null && cellProto.getCellLatitude() != null){

                                crsite.setSiteLatitude(cellProto.getCellLatitude());
                                crsite.setSiteLongitude(cellProto.getCellLongitude());

                                updateCrsite = true;
                            }

                            if(crsite.getSiteSitearea() == null){

                                // select for other site, based on lat on distance
                                String siteIdPrefix = crsite.getSiteCode().substring(0,3);

//                                System.out.println("siteIdPrefix: " + siteIdPrefix);

                                // select from crsite where site_code like 'xxx%' and site_sitearea is not null
                                Result<CrsiteRecord> crsiteCandidate = db.selectFrom(CRSITE)
                                        .where(CRSITE.SITE_CODE.startsWith(siteIdPrefix))
                                        .and(CRSITE.SITE_SITEAREA.isNotNull())
                                        .limit(5)
                                        .fetch();

                                // fetch last record of first 5 rows
                                CrsiteRecord crsiteCopy = crsiteCandidate.size() > 0 ? crsiteCandidate.get(crsiteCandidate.size()-1) : null;

                                if(crsiteCopy != null){

//                                    System.out.println("found to copy: " + crsiteCopy.getSiteCode());
                                    crsite.setSiteSitearea(crsiteCopy.getSiteSitearea());
                                    updateCrsite = true;
                                }
                            }

                            if(updateCrsite){

                                logger.debug("found update for crsite: " + crsite.getSiteCode());
                                crsite.update();
                            }

                            logger.debug("update crcell->crsite: " + crcell.getCellId() + " -> " + siteIdFromSiteInfo + " (" + crsite.getSiteId() + ")");

                            crcell.setCellSite(crsite.getSiteId());
                        }

                        if(crcell.getCellSiteinfo() == null){

                            crcell.setCellSiteinfo(siteIdFromSiteInfo);
                            crcell.setCellSiteinfolatitude(cellProto.getCellLatitude());
                            crcell.setCellSiteinfolongitude(cellProto.getCellLongitude());

                            crcell.setCellLastupdate((int) Instant.now().getEpochSecond());
                        }

                        if(crcell.getCellLatitude() == null){

                            crcell.setCellLatitude(cellProto.getCellLatitude());
                            crcell.setCellLongitude(cellProto.getCellLongitude());

                            crcell.setCellLastupdate((int) Instant.now().getEpochSecond());
                        }

                        crcell.update();
                    }
                }
            }

            return crcell;
        }

        return null;
    }

    private ArrayList<String> getFromPattern(String pattern, String data){

        Pattern p = Pattern.compile(pattern);
        Matcher matcher = p.matcher(data);

        ArrayList<String> result = new ArrayList<String>();

        while(matcher.find()){
            result.add(matcher.group(1));
        }

        return result;
    }

    @Override
    public CrnodeRecord getCellNodeAlias(Object cellNodeRefObj, Object cellNodeControllerRefObj, int cellClassId, Double arfcn, String cellName, CrnodeRecord nodeData) {
        return null;
    }

    @Override
    public CrnodeRecord getCellNodeAlias2(int vendorId, int cellClassId, String cellName, String nodeName) {
        // to be considered:
        // node_nodecategory -> 2G/3G/4G
        // node_nodetype -> 3 (ALIAS)
        // node_revenueclass -> default: 1

//        System.out.println("vendorId: " + vendorId);
//        System.out.println("cellName: " + cellName);
//        System.out.println("nodeName: " + nodeName);

        CrcellclassRecord cc = cellClassessById.get(cellClassId);

        // information from Cell
        ArrayList<String> sitePrefixes = new ArrayList<String>();
        ArrayList<String> siteNumbers = new ArrayList<String>();
        ArrayList<String> neParts = new ArrayList<String>();

        // information from NE
        String sitePrefix = null;
        String siteNumber = null;
        String nePart = null;
        Optional<CrcellpatternRecord> cp = cellPatterns.stream().filter(o -> o.getCellpatternVendor() == vendorId && o.getCellpatternCellclass() == cellClassId).findFirst();

        Optional<CrcellnodeidRecord> cx = cellnodeids.stream().filter(o -> o.getCellnodeidVendor() == vendorId && o.getCellnodeidCellname().equals(cellName)).findFirst();
        if(cx.isPresent()){

            nodeName = cx.get().getCellnodeidNodeid().toString();
            logger.debug("forcing neid usage: " + cellName  + " -> " + nodeName);
        }

        if(cp.isPresent() && cellName != null){

            Pattern p = Pattern.compile(cp.get().getCellpatternPattern());
            Matcher matcher;

            // find info for the site first
            if(nodeName != null){

                matcher = p.matcher(nodeName);

                if(matcher.find() && matcher.groupCount() > 0){

                    sitePrefix = matcher.group(2);
                    siteNumber = matcher.group(3);
                    nePart = matcher.group(4);
                }
            }

            // than find info from the cell
            matcher = p.matcher(cellName);

            while(matcher.find()){

                // initial if null
                if(sitePrefix == null){

                    sitePrefix = matcher.group(2);
                    siteNumber = matcher.group(3);
                    nePart = matcher.group(4);
                }

                if(sitePrefix.equals(matcher.group(2))){

                    sitePrefixes.add(matcher.group(2));
                    siteNumbers.add(matcher.group(3));
                    neParts.add(matcher.group(4));
                }
            }

            if(sitePrefixes.size() == 1){

                sitePrefix = sitePrefixes.get(0);
                siteNumber = siteNumbers.get(0);
                nePart = neParts.get(0);
            }
            else if(sitePrefixes.size() > 1){

                // looking for different site number
                if(siteNumbers.get(0) != null && !siteNumber.equals(siteNumbers.get(0))){
                    sitePrefix = sitePrefixes.get(0);
                    siteNumber = siteNumbers.get(0);
                    nePart = neParts.get(0);
                }
                else if(siteNumbers.get(1) != null){
                    sitePrefix = sitePrefixes.get(1);
                    siteNumber = siteNumbers.get(1);
                    nePart = neParts.get(1);
                }
            }

            if(sitePrefix != null && siteNumber != null){

                String finalNeId = sitePrefix + siteNumber;

                if(nePart != null){
                    finalNeId += nePart;
                }

                logger.debug("success process cell name (" + sitePrefixes.size() + "): " +  cellName + " + " + nodeName +  " => " + finalNeId);

                // get the crnode object based on several values

                CrnodecategoryRecord nc = null;

                for (int i = 0; i < nodeCategories.size(); i++) {

                    if(nodeCategories.get(i).getNodecategoryShortname().equals(cc.getCellclassRat())){

                        nc = nodeCategories.get(i);
                        break;
                    }
                }

                CrnodeRecord node = this.getNodeAliasByCode(finalNeId, cc, nc);

                return node;
            }
        }
        else{
            System.out.println("found null: " + cellName + " -> " + nodeName);
        }

        logger.debug("unable to process cell name: " + cellName + " + " + nodeName);

        return null;
    }

    private synchronized CrnodeRecord getNodeAliasByCode(String neCode, CrcellclassRecord cellClass, CrnodecategoryRecord nc){

        for (int i = 0; i < nodeAlias.size(); i++) {

            if(nodeAlias.get(i).getNodeCode().equals(neCode) && nodeAlias.get(i).getNodeNodecategory().intValue() == nc.getNodecategoryId()){

                return nodeAlias.get(i);
            }
        }

        // try to insert
        CrnodeRecord crnode = db.newRecord(CRNODE);

        crnode.setNodeCode(neCode);
        crnode.setNodeNodecategory(nc.getNodecategoryId());
        crnode.setNodeRevenueclass(1); // lowest
        crnode.setNodeNodetype(3); // ALIAS
        crnode.setNodeLastupdate((int) Instant.now().getEpochSecond());

        System.out.println("saving: " + neCode + "|" + nc.getNodecategoryId());

        int result;
        try{

            result= crnode.store();
        }
        catch(Exception e){
            logger.debug("error saving: " + neCode);
//            e.printStackTrace();
        }

        // select again
        crnode = db.selectFrom(CRNODE)
                .where(CRNODE.NODE_CODE.eq(neCode))
                .and(CRNODE.NODE_NODECATEGORY.eq(nc.getNodecategoryId()))
                .and(CRNODE.NODE_NODETYPE.eq(3)) // ALIAS
                .fetchOne();

        //select again
        if (crnode != null) {

            synchronized (nodeAlias){

                nodeAlias.add(crnode);
            }
        }

        return crnode;
    }

    @Override
    public CrcellRecord getCellByArfcn(String rat, double arfcn, String identifier, CrcellRecord cellProto, CrnodeRecord nodeData) {
        String valDef;

        for (int i = 0; i < cellclasses.size(); i++) {

            if (cellclasses.get(i).getCellclassVallookup().isEmpty()) {
                continue;
            }

            if (!cellclasses.get(i).getCellclassRattype().equals(rat)) {
                continue;
            }

            valDef = "val=" + arfcn + ";" + cellclasses.get(i).getCellclassVallookup();

            try {
                if (engine.eval(valDef).toString().equals("true")) {

                    return this.getCell(cellclasses.get(i).getCellclassLookup(), identifier, cellProto, nodeData);
                }
            } catch (ScriptException e) {
                e.printStackTrace();
            }
        }

        return null;
    }

    @Override
    public CrcellRecord getCellByFreq(String rat, double freq, String identifier, CrcellRecord cellProto, CrnodeRecord nodeData) {
        return null;
    }

    @Override
    public CrcellRecord getCellByBand(String rat, int band, String identifier, CrcellRecord cellProto, CrnodeRecord nodeData) {
        return null;
    }

    @Override
    public List<CrsettingsRecord> getSettings(String settingsCode) {
        return DaoFactory.createSettingsDaoImpl().getSettings(settingsCode);
    }

    @Override
    public int getCellStatus(String cellName) {
        for (int i = 0; cellName != null && i < cellstatuses.size(); i++) {

            if(cellstatuses.get(i).getCellstatusPrefix().isEmpty()){
                continue;
            }

            if(cellName.matches(cellstatuses.get(i).getCellstatusPrefix())){

                return cellstatuses.get(i).getCellstatusId();
            }
        }

        return 1;
    }

    @Override
    public String getSiteAreaDefinedPrefix1ByLatLon(double lat, double lon) {
        String sql = "SELECT " +
                "site.site_id, " +
                "site.site_code," +
                "sa.sitearea_definedprefix1," +
                "(" +
                "   3959 *" +
                "   acos(cos(radians(" + lon + ")) * " +
                "   cos(radians(site_latitude)) * " +
                "   cos(radians(site_longitude) - " +
                "   radians(" + lat + ")) + " +
                "   sin(radians(" + lon + ")) * " +
                "   sin(radians(site_latitude)))" +
                ") AS distance " +
                "FROM crsite site " +
                "JOIN crsitearea sa ON sa.sitearea_id=site.site_sitearea " +
                "WHERE site.site_code NOT LIKE 'CO%' " +
                "HAVING distance < 10 " +
                "ORDER BY distance ASC " +
                "LIMIT 1";

        Record result = db.fetchOne(sql);

        if(result != null){

            System.out.println(result.get("sitearea_definedprefix1").toString());

            return result.get("sitearea_definedprefix1").toString();
        }

        return null;
    }
}

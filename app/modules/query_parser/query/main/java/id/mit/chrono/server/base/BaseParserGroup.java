package id.mit.chrono.server.base;

import com.google.common.base.Stopwatch;
import id.mit.chrono.server.database.DatabaseHelper;
import id.mit.chrono.server.enm.PS;
import id.mit.chrono.server.factory.DaoFactory;
import id.mit.chrono.server.iface.*;
import id.mit.chrono.server.iface.Parser;
import id.mit.chrono.server.model.tables.records.CrmapparserRecord;
import id.mit.chrono.server.model.tables.records.CrmapentityRecord;
import id.mit.chrono.server.model.tables.records.CrmapfieldRecord;
import id.mit.chrono.server.obj.*;
import id.mit.chrono.server.var.Vars;
import org.apache.commons.lang3.math.NumberUtils;
import org.apache.commons.pool2.ObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPool;
import org.jooq.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.time.Instant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static id.mit.chrono.server.model.Tables.*;

public abstract class BaseParserGroup implements Parser, FileParserCallback {

    protected ArrayList<String> usedSourceGroups = new ArrayList<String>();
    protected ArrayList<FileParser> parsers = new ArrayList<FileParser>();
    protected List<CrmapparserRecord> maps;
    protected ChronoContext context;
    protected File tempFile;
    protected int maxParallel = Integer.MAX_VALUE;
    protected int vendorId;
    protected Integer parseIndex = 0;
    protected Integer totalParsed = 0;
    protected ParserGroupCallback pgc;
    private Stopwatch stopwatch;
    protected int poolSize = 10;

    protected List<FileProcessor> processors = new ArrayList<FileProcessor>();

    protected ArrayList<MapEntityObj> entityMaps = new ArrayList<MapEntityObj>();
    protected ArrayList<Integer> processingIndexes = new ArrayList<>();

    private static HashMap<PS, Integer> countMaps;
    private static Integer totalNotProcessed = 0;
    private static Integer totalProcessed = 0;

    protected DSLContext db;
    protected Logger logger = LoggerFactory.getLogger(this.getClass());

    protected static ObjectPool<DSLContext> dbPool = null;
    protected static Object lockObj = new Object();
    protected static DSLContextFactory dslCF;

    static{
        countMaps = new HashMap<PS, Integer>();
    }

    public BaseParserGroup(ChronoContext context, int vendorId, List<CrmapparserRecord> maps, int maxParallel, int poolSize) {

        this.db = DatabaseHelper.connectDB();
        this.context = context;
        this.vendorId = vendorId;
        this.maps = maps;
        this.maxParallel = maxParallel;
        this.poolSize = poolSize;

        this.dslCF = new DSLContextFactory();

        stopwatch = Stopwatch.createUnstarted();

        logger.debug("maps: " + this.maps.size());
        logger.debug("maxParallel: " + this.maxParallel);

        this.getVendorSchema();
    }

    private void getVendorSchema(){

        logger.debug("get vendor schema");

        // select map entityMaps per vendor
//        Result<CrmapentityRecord> entts = db.selectFrom(CRMAPENTITY)
//                .where(CRMAPENTITY.MAPENTITY_VENDOR.equal(this.vendorId))
//                .and(CRMAPENTITY.MAPENTITY_DATAGROUP.equal(context.getDATAGROUP_ID()))
//                .and(CRMAPENTITY.MAPENTITY_ENABLED.isTrue())
//                .orderBy(CRMAPENTITY.MAPENTITY_CODE.asc())
//                .fetch();

        Result<CrmapentityRecord> entts = DaoFactory.createMapEntityDaoImpl()
                .getMapEntitiesByVendorAndDatagroupId(this.vendorId, context.getDATAGROUP_ID());

        // loop to get each entity's field
        for (int i = 0; i < entts.size(); i++) {

            CrmapentityRecord mr = entts.get(i);

//            Result<CrmapfieldRecord> fields = db.selectFrom(CRMAPFIELD)
//                    .where(CRMAPFIELD.MAPFIELD_MAPENTITY.equal(mr.getMapentityId()))
//                    .and(CRMAPFIELD.MAPFIELD_ENABLED.isTrue())
//                    .fetch();

            Result<CrmapfieldRecord> fields = DaoFactory.createMapFieldDaoImpl()
                    .getMapFieldsByMapEntityId(mr.getMapentityId());

            if(context.getGROUP().equals("CM_RAN") && fields.size() > 0){

                for (int j = 0; j < fields.size(); j++) {

                    // add all used field/source group/command
                    this.addUsedSourceGroup(fields.get(j).getMapfieldSourcegroup());
                    this.addUsedSourceGroup(fields.get(j).getMapfieldSourcegroupbackup());
                    this.addUsedSourceGroup(fields.get(j).getMapfieldSourcegroupcheck());
                }

                MapEntityObj meo = new MapEntityObj(mr, fields);

                if(mr.getMapentityParent() == null){

                    this.entityMaps.add(meo);
                }
                else{

                    // loop to attach to parent

                    for (int j = 0; j < this.entityMaps.size(); j++) {

                        if(this.entityMaps.get(j).mr.getMapentityId() == meo.mr.getMapentityParent()){
                            this.entityMaps.get(j).childs.add(meo);
                        }
                    }
                }

                logger.debug("add entity: " + meo.mr.getMapentityTablename() + " with " + fields.size() + " field(s) and " + meo.childs.size()  + " child(s)");
            }
            else if(context.getGROUP().equals("INVENTORY_RAN")){

                for (int j = 0; j < fields.size(); j++) {

                    // add all used field/source group/command
                    this.addUsedSourceGroup(fields.get(j).getMapfieldSourcegroup());
                    this.addUsedSourceGroup(fields.get(j).getMapfieldSourcegroupbackup());
                    this.addUsedSourceGroup(fields.get(j).getMapfieldSourcegroupcheck());
                }

                MapEntityObj meo = new MapEntityObj(mr, fields);

                logger.debug("add entity: " + meo.mr.getMapentityTablename() + " with " + fields.size() + " field(s)");

                this.entityMaps.add(meo);
            }
        }
    }

    public void addUsedSourceGroup(String sourceGroup){

        if(!this.usedSourceGroups.contains(sourceGroup)){
            this.usedSourceGroups.add(sourceGroup);
        }
    }

    @Override
    public void addFile(long collectorTaskFilesId, String fileName,String filePath, long size, String checksum) {

        tempFile = new File(filePath);

        // validate only if exist and its a file
        if(!tempFile.exists() || !tempFile.isFile()){

            logger.debug("file not found: " + filePath);
            return;
        }

        // add validation by checksum
//        String checkmd5 = FileUtils.getMd5(tempFile);
//
//        if(checkmd5.equals(checksum)){
//
//            logger.debug("added: " + filePath);
//            this.files.add(new SourceFile(collectorTaskFilesId, filePath, size, checksum));
//        }

        if(size != tempFile.length()){
            System.out.println("size: " + size + " -> tempFile.length(): " + tempFile.length());
            logger.debug("invalid file size: " + filePath);
//            return;
        }

        boolean isUsed = false;
        MapEntityObj meo;

        logger.debug("file name to check: " + fileName);

        // check from map entity first
        for (int j = 0; !isUsed && j < entityMaps.size(); j++) {

            meo = entityMaps.get(j);

            boolean b1 = meo.mr.getMapentityDatagroup() == context.getDATAGROUP_ID();
            boolean b2 = fileName.matches(meo.mr.getMapentityFilepattern());

            isUsed = b1 && b2;

            logger.debug("meo.mr.getMapentityDatagroup(): " + meo.mr.getMapentityDatagroup() + " -> " + context.getDATAGROUP_ID());
            logger.debug("meo.mr.getMapentityFilepattern(): " + meo.mr.getMapentityFilepattern() + " -> " + fileName);
            logger.debug("b1 & b2: " + b1 + " & " + b2);
        }

        CrmapparserRecord mp = this.getSuitableMapParser(tempFile.getName());

        if(!isUsed){

            logger.debug("unused file: " + filePath);
            return;
        }

        if(mp == null){

            logger.debug("can't find compatible id.mit.chrono.server.parser: " + filePath);
            return;
        }

        if(mp != null){

            FileParser parser = this.getParserByClassName(mp.getMapparserClass());

            if(parser != null){

                parser.setInitData(this, new SourceFile(collectorTaskFilesId, mp.getMapparserDatasourcetype(), filePath, size, checksum), mp.getMapparserIdentitypattern(), mp.getMapparserDependencies());
                parser.setUsedSourceGroups(this.usedSourceGroups);

                this.parsers.add(parser);

                logger.debug("added: " + collectorTaskFilesId + "|" + filePath);
            }
            else{
                logger.debug("failed to initialize id.mit.chrono.server.parser: " + mp.getMapparserClass());
            }
        }
    }

    @Override
    public CrmapparserRecord getSuitableMapParser(String fileName){

        CrmapparserRecord temp;

        // check for id.mit.chrono.server.parser availability
        for (int i = 0; i < maps.size(); i++) {

            temp = maps.get(i);

            if(temp.getMapparserDatagroup() == context.getDATAGROUP_ID() &&  fileName.matches(temp.getMapparserPattern())){

                return maps.get(i);
            }
        }

        return null;
    }

    @Override
    public void startParse() {

        stopwatch.start();

        int setParallel = Math.min(maxParallel, parsers.size());

        synchronized (lockObj){

            if(BaseParserGroup.dbPool == null){

                String poolSize = Vars.prop.getProperty("id.mit.chrono.server.poolsize");
                int poolSizeInt = setParallel;

                try{

                    poolSizeInt = Integer.parseInt(poolSize);
                }catch (Exception e){
                    poolSizeInt = setParallel;
                }

                logger.debug("initializing db pool size: " + this.poolSize);

                // init db pool
                BaseParserGroup.dbPool = new GenericObjectPool<DSLContext>(BaseParserGroup.dslCF);
                ((GenericObjectPool<DSLContext>) BaseParserGroup.dbPool).setMaxTotal(this.poolSize);
            }
        }

        logger.debug("initializing parsing with (max) " + maxParallel + " thread -> " + setParallel + " actualized for " + parsers.size() + " id.mit.chrono.server.parser(s)");

        // set to be triggered by event
        parseIndex = setParallel;

        // initialize parsing process for n-first index
        for (int i = 0; i < setParallel; i++) {
            parsers.get(i).parse();
        }
    }

    public void onFileParserFinished(FileParser fp){

        // need to keep on track which id.mit.chrono.server.parser gave the results
        SourceFile sf = fp.getSourceFile();

        if(!context.isPARSE_ONLY()){

            this.processFinishedSourceFile(sf);

            logger.debug("updating file process time...");
            db.update(CRCOLLECTORTASKFILES)
                    .set(CRCOLLECTORTASKFILES.COLLECTORTASKFILES_PROCESSTIME, (int) Instant.now().getEpochSecond())
                    .where(CRCOLLECTORTASKFILES.COLLECTORTASKFILES_ID.eq(sf.getTaskFilesId()))
                    .execute();

        }

        synchronized (this.totalParsed) {

            // add total parsed
            totalParsed++;

            if(parseIndex < parsers.size()){

                // start another id.mit.chrono.server.parser
                parsers.get(parseIndex++).parse();

                logger.debug("parse finished -> vendorId: " + this.vendorId + ",fileId: " + sf.getTaskFilesId() + ",thread: " + this.maxParallel + ",total: " + parsers.size() + ",finished: " + totalParsed + ",starting: true");
            }
            else{

                logger.debug("parse finished -> vendorId: " + this.vendorId + ",fileId: " + sf.getTaskFilesId() + ",thread: " + this.maxParallel + ",total: " + parsers.size() + ",finished: " + totalParsed + ",starting: false");

                if(totalParsed == parsers.size()){

                    stopwatch.stop();

                    logger.debug("id.mit.chrono.server.parser group finished: " + stopwatch.elapsed(TimeUnit.MILLISECONDS) + " ms");

                    pgc.onParserGroupFinished(this);
                }
            }
        }

        fp.freeSourceFile();
    }

    @Override
    public ChronoContext getContext() {
        return this.context;
    }

    @Override
    public void setParserGroupCallback(ParserGroupCallback pgc){

        this.pgc = pgc;
    }

    @Override
    public FileParser getParserByClassName(String identifier) {
        try {
            Class cls = Class.forName(identifier);
            return (FileParser) cls.newInstance();
        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
        } catch (InstantiationException e) {
//            e.printStackTrace();
        } catch (IllegalAccessException e) {
//            e.printStackTrace();
        }
        return null;
    }

    protected abstract void prepareProcessWorkers();

    protected abstract void processFinishedSourceFile(SourceFile sf);

    protected abstract void getDataLocal();

    protected int allocateProcessor(PS state, PS[] deps){

        boolean eligible;

        synchronized (this.processors){

            int size = this.processors.size();

            for (int i = 0; i < size; i++) {

                eligible = true;

                for (int j = 0; eligible && deps != null && j < deps.length; j++) {

                    eligible &= processors.get(i).isFinished(deps[j]);
                }

                if(eligible){

                    if(processors.get(i).proposeProcess(state)){

                        return i;
                    }
                }
            }
        }

        return -1;
    }

    protected void addEmptyFile(){

        synchronized (totalNotProcessed){
            totalNotProcessed++;
        }
    }

    protected int gInt(String key, int def){

        return NumberUtils.toInt(Vars.prop.getProperty(key), def);
    }
}

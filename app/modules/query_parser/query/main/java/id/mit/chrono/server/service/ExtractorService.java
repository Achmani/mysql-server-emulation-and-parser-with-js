package id.mit.chrono.server.service;

import id.mit.chrono.server.base.BaseFileExtractor;
import id.mit.chrono.server.database.dao.timecatalog.TimeCatalogDaoImpl;
import id.mit.chrono.server.factory.DaoFactory;
import id.mit.chrono.server.factory.ExtractorFactory;
import id.mit.chrono.server.iface.Extractor;
import id.mit.chrono.server.iface.ExtractorCallback;
import id.mit.chrono.server.iface.ExtractorServiceCallback;
import id.mit.chrono.server.model.tables.records.CrworkflowRecord;
import id.mit.chrono.server.model.tables.records.CrtimecatalogRecord;
import id.mit.chrono.server.model.tables.records.Dailysysinfo2gRecord;
import id.mit.chrono.server.obj.ChronoContext;
import id.mit.chrono.server.obj.DSLContextFactory;
import id.mit.chrono.server.obj.HDFSCl;
import org.apache.commons.pool2.ObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPool;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

import static id.mit.chrono.server.model.Tables.CRCOLLECTORTASKFILES;

public class ExtractorService implements ExtractorCallback {

    private Logger logger = LoggerFactory.getLogger(ExtractorService.class);

    private ExtractorServiceCallback serviceCallback;

    private ChronoContext context;
    private Result<Record> files;
    private boolean reProcess;
    private HDFSCl dfs;
    private int totalThread = 0;
    private int threadFinished = 0;
    private int maxParallel = 0;
    private int poolSize = 10;

    private int extractorIndex = 0;

    private List<Extractor> extractors = new ArrayList<>();

//    private final Object lockObj = new Object();
    protected static ObjectPool<DSLContext> dbPool = null;
    protected static ObjectPool<HDFSCl> hdfsPool = null;
    protected static final Object lockObj = new Object();
    protected static DSLContextFactory dslCF;

    public ExtractorService(ChronoContext context, Result<Record> files, boolean reProcess, ExtractorServiceCallback serviceCallback, HDFSCl dfs, int maxParallel, int poolSize) {
        this.context = context;
        this.files = files;
        this.reProcess = reProcess;
        this.serviceCallback = serviceCallback;
        this.dfs = dfs;
        this.maxParallel = maxParallel;
        this.poolSize = poolSize;

        this.dslCF = new DSLContextFactory();

        synchronized (lockObj) {

            if (dbPool == null) {
                dbPool = new GenericObjectPool<>(dslCF);
                ((GenericObjectPool<DSLContext>) dbPool).setMaxTotal(this.poolSize);
            }
        }
    }

//    private BaseFileExtractor findExtractor(String vendorCode, HDFSCl dfs) {
//        return ExtractorFactory.createExtractor(context, vendorCode, this, dfs);
//    }

    public void process() {
        logger.debug("total file to process: " + files.size());
        setupTimeCatalog();

        int totalSkip = 0;

        Result<CrworkflowRecord> workflows = DaoFactory.getWorkflowDaoImpl().getWorkflowsByPhase(0);

        for (Record file : files) {
            if (!reProcess &&
                    file.getValue(CRCOLLECTORTASKFILES.COLLECTORTASKFILES_PROCESSTIME) != null &&
                    file.getValue(CRCOLLECTORTASKFILES.COLLECTORTASKFILES_PROCESSTIME, Integer.class) != 0 &&
                    file.getValue(CRCOLLECTORTASKFILES.COLLECTORTASKFILES_PROCESSSTATUS) != null) {

                totalSkip++;

                continue;
            }

//            logger.debug("total skipped file(s): " + totalSkip);
//
//            String vendorCode = file.getValue(CRVENDOR.VENDOR_CODE);
//
//            BaseFileExtractor fileExc = findExtractor(vendorCode, dfs);
//
//            if (fileExc == null) {
//                return;
//            }
//
//            logger.debug("found extractor: " + fileExc.getClass().getCanonicalName());
//
//            fileExc.setFile(file);
//            fileExc.startExtract();

            boolean foundWorkflow = false;
            for (CrworkflowRecord set: workflows) {
                if (file.getValue(CRCOLLECTORTASKFILES.COLLECTORTASKFILES_LOCALFILENAME).matches(set.getWorkflowIdentitypattern())) {

                    Extractor exist = extractors.stream().filter(o -> o.getFile().getValue(CRCOLLECTORTASKFILES.COLLECTORTASKFILES_LOCALFILENAME)
                            .equals(file.getValue(CRCOLLECTORTASKFILES.COLLECTORTASKFILES_LOCALFILENAME)))
                            .findFirst()
                            .orElse(null);

                    // make sure same file only extracted 1 time.
                    if (exist != null) {
                        continue;
                    }

                    Extractor extractor = ExtractorFactory.getExtractorByClassName(set.getWorkflowClass());
                    if (extractor != null) {

                        logger.debug("found workflow entity ("+ file.getValue(CRCOLLECTORTASKFILES.COLLECTORTASKFILES_ID) +"): " + set.getWorkflowEntitygroup());

                        foundWorkflow = true;

                        System.out.println("file to extract: " + file.getValue(CRCOLLECTORTASKFILES.COLLECTORTASKFILES_LOCALFILENAME));

                        // make sure to set workflow first then context before set the others
                        extractor.setWorkflow(set);
                        extractor.setContext(context);
                        extractor.setFile(file);
                        extractor.setCallback(this);
//                        extractor.setHdfsClient(dfs);
                        extractor.setReprocess(reProcess);

                        extractors.add(extractor);

                        totalThread++;

                    } else {
                        logger.debug("extractor is null");
                    }
                }
            }

            if (!foundWorkflow) {
                totalSkip++;
            }
        }

        logger.debug("total skipped file(s): " + totalSkip);
        logger.debug("total thread(s): " + extractors.size());
        logger.debug("max parallel(s): " + maxParallel);

        if (extractors.size() < maxParallel) {
            maxParallel = extractors.size();
        }

        extractorIndex = maxParallel;

        if (extractors.size() > 0) {
            for (int i = 0; i < maxParallel; i++) {
                try {
                    DSLContext dslContext = dbPool.borrowObject();
//                    extractors.get(i).borrowDSLContext(dslContext);
                    extractors.get(i).startExtract(dslContext);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }


    }

    private void setupTimeCatalog() {
        if(context.getDATAGROUP_ID() == 1){

            // store first for monitoring purpose (admin only item)
            TimeCatalogDaoImpl timeCatalogDao = DaoFactory.createTimeCatalogDaoImpl();

            CrtimecatalogRecord tcr = timeCatalogDao.getSingleTimeCatalog(context.getDATAGROUP_ID(), context.getEpochTime());

            if (tcr == null) {
                tcr = timeCatalogDao.insertTimeCatalog(context.getEpochTime(), context.getDATAGROUP_ID());
                logger.debug("preparing new time catalog: " + tcr.getTimecatalogId() + "|" + tcr.getTimecatalogDate());
            }
        }
    }

    @Override
    public synchronized void onExtractFinished(DSLContext db) {

//        synchronized (this.lockObj) {

        try {
            dbPool.returnObject(db);
        } catch (Exception e) {
            e.printStackTrace();
        }

        threadFinished++;

            logger.debug("extractor finished -> total: " + extractors.size() + ", finished: " + threadFinished);

            if (extractorIndex < extractors.size()) {

                // start another thread
                try {
                    DSLContext dslContext = dbPool.borrowObject();
//                    extractors.get(extractorIndex).borrowDSLContext(dslContext);
                    extractors.get(extractorIndex++).startExtract(dslContext);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {

                if (threadFinished == extractors.size()) {
                    serviceCallback.onExtractSuccess("Extract success.");
                }
            }
//        }


    }
}

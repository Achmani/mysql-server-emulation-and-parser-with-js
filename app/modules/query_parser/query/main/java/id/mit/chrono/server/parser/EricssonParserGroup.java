package id.mit.chrono.server.parser;

import id.mit.chrono.server.base.BaseParserGroup;
import id.mit.chrono.server.enm.PS;
import id.mit.chrono.server.iface.FileProcessor;
import id.mit.chrono.server.model.tables.records.CrmapparserRecord;
import id.mit.chrono.server.obj.*;
import org.jooq.DSLContext;

import java.util.ArrayList;
import java.util.List;

public class EricssonParserGroup extends BaseParserGroup {

    public EricssonParserGroup(ChronoContext context, int vendorId, List<CrmapparserRecord> maps, int maxParallel, int poolSize) {
        super(context, vendorId, maps, maxParallel, poolSize);
    }

    @Override
    protected void prepareProcessWorkers() {
    }

    @Override
    protected void processFinishedSourceFile(SourceFile sf) {

        MapEntityObj meo;

        for (int j = 0; j < entityMaps.size(); j++) {

            meo = entityMaps.get(j);

            if (sf.getFileName().matches(meo.mr.getMapentityFilepattern())) {

                FileProcessor newProcessor = null;

                if (meo.mr.getMapentityTablename().equals("erbsc")) {

                    logger.debug("add new Ericsson BSC");

                    newProcessor = new ErBscContainer(db, pgc, context, sf, meo);
                } else if (meo.mr.getMapentityTablename().equals("errnc")) {

                    logger.debug("add new Ericsson RNC");

                    newProcessor = new ErRncContainer(db, pgc, context, sf, meo);
                } else if (meo.mr.getMapentityTablename().equals("erenodeb")) {

                    logger.debug("add new Ericsson eNodeB");

                    newProcessor = new ErEnodebContainer(db, pgc, context, sf, meo);

                } else if (meo.mr.getMapentityTablename().equals("ergnodeb")) {

                    logger.debug("add new Erisson gNodeB");

                    newProcessor = new ErGnodebContainer(db, pgc, context, sf, meo);

                } else if (meo.mr.getMapentityTablename().equals("erinventory")) {

                    System.out.println(sf.getResult().size());

                    logger.debug("add new Ericsson Inventory");

                    if (sf.getKey() != null) {

                        newProcessor = new ErInventoryContainer(db, pgc, context, sf, meo);
                    }
                }

                // let the other consume also, no need to break
                // or just break if no "1 file for all"
//                break;

                if (newProcessor != null) {

                    try {

                        DSLContext dslC = dbPool.borrowObject();

                        newProcessor.processAll(dslC);

                        dbPool.returnObject(dslC);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        sf.purgeResult2();
    }

    @Override
    protected void getDataLocal() {

        // to process & collect & perform db activity per entity (BSC/RNC/

        // loop per source file
//        SourceFile sf;
//        MapEntityObj meo;
//
//        for (int i = 0; i < sourceFiles.size(); i++) {
//
//            sf = sourceFiles.get(i);
//
//            for (int j = 0; j < entityMaps.size(); j++) {
//
//                meo = entityMaps.get(j);
//
//                if (sf.getFileName().matches(meo.mr.getMapentityFilepattern())) {
//
//                    if (meo.mr.getMapentityTablename().equals("erbsc")) {
//
//                        logger.debug("add new Ericsson BSC");
//
//                        processors.add(new ErBscContainer(db, pgc, context, sf, meo));
//                    } else if (meo.mr.getMapentityTablename().equals("errnc")) {
//
//                        logger.debug("add new Ericsson RNC");
//
//                    } else if (meo.mr.getMapentityTablename().equals("erenodeb")) {
//
//                        logger.debug("add new Ericsson eNodeB");
//
//                    } else if (meo.mr.getMapentityTablename().equals("erinventory")) {
//
//                        logger.debug("add new Ericsson eNodeB");
//
//                    }
//
//                    break;
//                }
//            }
//        }
    }
}

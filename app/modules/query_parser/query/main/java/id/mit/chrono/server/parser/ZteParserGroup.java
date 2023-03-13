package id.mit.chrono.server.parser;

import id.mit.chrono.server.base.BaseParserGroup;
import id.mit.chrono.server.enm.PS;
import id.mit.chrono.server.iface.FileProcessor;
import id.mit.chrono.server.model.tables.records.CrmapparserRecord;
import id.mit.chrono.server.obj.*;
import org.jooq.DSLContext;

import java.util.ArrayList;
import java.util.List;

public class ZteParserGroup extends BaseParserGroup {

    public ZteParserGroup(ChronoContext context, int vendorId, List<CrmapparserRecord> maps, int maxParallel, int poolSize) {
        super(context, vendorId, maps, maxParallel, poolSize);
    }

    @Override
    protected void prepareProcessWorkers() {}

    @Override
    protected void processFinishedSourceFile(SourceFile sf) {

        MapEntityObj meo;

        for (int j = 0;  j < entityMaps.size(); j++) {

            meo = entityMaps.get(j);

            SourceFile sf2 = sf;

            if (sf.getFileName().matches(meo.mr.getMapentityFilepattern())) {

                FileProcessor newProcessor = null;

                if (meo.mr.getMapentityTablename().equals("ztebsc")) {

                    logger.debug("add new ZTE BSC");

                    newProcessor = new ZteBscContainer(db, pgc, context, sf2, meo);
                }
                if (meo.mr.getMapentityTablename().equals("zternc")) {

                    logger.debug("add new ZTE RNC");

                    newProcessor = new ZteRncContainer(db, pgc, context, sf2, meo);
                }
                if (meo.mr.getMapentityTablename().equals("zteenodeb")) {

                    logger.debug("add new ZTE eNodeB");

                    newProcessor = new ZteEnodebContainer(db, pgc, context, sf2, meo);
                }
                if (meo.mr.getMapentityTablename().equals("ztegnodeb")) {

                    logger.debug("add new ZTE gNodeB");

                    newProcessor = new ZteGnodebContainer(db, pgc, context, sf2, meo);
                }
                if (meo.mr.getMapentityTablename().equals("zteinventory")) {

                    System.out.println("ZTE Filename() >> " + sf2.getFileName());

                    if (sf.getKey() != null) {

                        logger.debug("add new ZTE Inventory Group: " + sf2.getKey());

                        newProcessor = new ZteInventoryContainer(db, pgc, context, sf2, meo);
                    }
                }

                if(newProcessor != null){

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
//                    if (meo.mr.getMapentityTablename().equals("ztebsc")) {
//
//                        logger.debug("add new ZTE BSC");
//
//                        processors.add(new ZteBscContainer(db, pgc, context, sf, meo));
//                    } else if (meo.mr.getMapentityTablename().equals("zternc")) {
//
//                        logger.debug("add new ZTE RNC");
//
//                        processors.add(new ZteRncContainer(db, pgc, context, sf, meo));
//                    } else if (meo.mr.getMapentityTablename().equals("zteenodeb")) {
//
//                        logger.debug("add new ZTE eNodeB");
//
//                        processors.add(new ZteEnodebContainer(db, pgc, context, sf, meo));
//                    }
//
//                    break;
//                }
//            }
//        }
//
//        workerGroups.add(new ProcessGroup(PS.PREPARE, gInt("id.mit.chrono.server.processor.ps.zte.prepare", 1), null));
//
//        workerGroups.add(new ProcessGroup(PS.BSC, gInt("id.mit.chrono.server.processor.ps.zte.bsc", 1), PS.PREPARE));
//
//        workerGroups.add(new ProcessGroup(PS.BSCBOARD, gInt("id.mit.chrono.server.processor.ps.zte.bscboard", 1), PS.BSC));
//        workerGroups.add(new ProcessGroup(PS.BSCPORT, gInt("id.mit.chrono.server.processor.ps.zte.bscport", 1), PS.BSCBOARD));
//
//        workerGroups.add(new ProcessGroup(PS.BTS, gInt("id.mit.chrono.server.processor.ps.zte.bts", 1), PS.BSC));
//        workerGroups.add(new ProcessGroup(PS.CELL2G, gInt("id.mit.chrono.server.processor.ps.zte.cell2g", 1), PS.BTS));
//        workerGroups.add(new ProcessGroup(PS.TRX, gInt("id.mit.chrono.server.processor.ps.zte.trx", 1), PS.CELL2G));
//        workerGroups.add(new ProcessGroup(PS.TIMESLOT, gInt("id.mit.chrono.server.processor.ps.zte.timeslot", 1), PS.TRX));
//
//        workerGroups.add(new ProcessGroup(PS.RNC, gInt("id.mit.chrono.server.processor.ps.zte.rnc", 1), PS.PREPARE));
//        workerGroups.add(new ProcessGroup(PS.RNCBOARD, gInt("id.mit.chrono.server.processor.ps.zte.rncboard", 1), PS.RNC));
//        workerGroups.add(new ProcessGroup(PS.RNCPORT, gInt("id.mit.chrono.server.processor.ps.zte.rncport", 1), PS.RNCBOARD));
//
//        workerGroups.add(new ProcessGroup(PS.NODEB, gInt("id.mit.chrono.server.processor.ps.zte.nodeb", 1), PS.RNCPORT));
//        workerGroups.add(new ProcessGroup(PS.CELL3G, gInt("id.mit.chrono.server.processor.ps.zte.cell3g", 1), PS.NODEB));
//
//        workerGroups.add(new ProcessGroup(PS.ENODEB, gInt("id.mit.chrono.server.processor.ps.zte.enodeb", 1), PS.PREPARE));
//        workerGroups.add(new ProcessGroup(PS.CELL4G, gInt("id.mit.chrono.server.processor.ps.zte.cell4g", 1), PS.ENODEB));
//
//        workerGroups.add(new ProcessGroup(PS.FINALIZE, gInt("id.mit.chrono.server.processor.ps.zte.finalize", 1), PS.BSCPORT, PS.TIMESLOT, PS.CELL3G, PS.CELL4G) {
//
//            @Override
//            public void onFinished() {
//
//                finishParserGroup();
//            }
//        });
    }
}

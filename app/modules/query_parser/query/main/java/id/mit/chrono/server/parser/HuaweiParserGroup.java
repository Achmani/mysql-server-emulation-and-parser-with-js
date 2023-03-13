package id.mit.chrono.server.parser;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import id.mit.chrono.server.enm.PS;
import id.mit.chrono.server.base.BaseParserGroup;
import id.mit.chrono.server.iface.FileProcessor;
import id.mit.chrono.server.model.tables.records.*;
import id.mit.chrono.server.obj.*;
import org.jooq.DSLContext;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import static id.mit.chrono.server.model.Tables.CRPROCESSORSTATISTIC;

public class HuaweiParserGroup extends BaseParserGroup {

    public HuaweiParserGroup(ChronoContext context, int vendorId, List<CrmapparserRecord> maps, int maxParallel, int poolSize) {
        super(context, vendorId, maps, maxParallel, poolSize);
    }

    @Override
    protected void prepareProcessWorkers(){ }

    @Override
    protected void processFinishedSourceFile(SourceFile sf){

        MapEntityObj meo;

        FileProcessor newProcessor = null;

        // CM RAN
//        for (int j = 0; newProcessor == null && j < entityMaps.size(); j++) {
        for (int j = 0; j < entityMaps.size(); j++) {

            meo = entityMaps.get(j);

            if(meo.mr.getMapentityDatagroup() == context.getDATAGROUP_ID() && sf.getFileName().matches(meo.mr.getMapentityFilepattern())){

                if(meo.mr.getMapentityTablename().equals("hwbsc")) {

                    if(sf.getKey() != null) {

                        logger.debug("add new Huawei MBSC: " + sf.getKey());

//                        newProcessor = new HwBscContainerCmExport(db, pgc, context, sf, meo);
                        startProcessor(new HwBscContainerCmExport(db, pgc, context, sf, meo));
                    }
                }
                else if(meo.mr.getMapentityTablename().equals("hwrnc")) {

                    if(sf.getKey() != null) {

                        logger.debug("add new Huawei RNC: " + sf.getKey());

//                        newProcessor = new HwRncContainerCmExport(db, pgc, context, sf, meo);
                        startProcessor(new HwRncContainerCmExport(db, pgc, context, sf, meo));
                    }
                }
                else if(meo.mr.getMapentityTablename().equals("hwenodeb")) {

                    System.out.println("xxx++" + sf.getFileName());

                    if(sf.getKey() != null){

                        logger.debug("add new Huawei eNodeB Group: " + sf.getKey());

//                        newProcessor = new HwEnodebContainer(db, pgc, context, sf, meo);
                        startProcessor(new HwEnodebContainer(db, pgc, context, sf, meo));
                    }
                }
                else if(meo.mr.getMapentityTablename().equals("hwgnodeb")) {

                    System.out.println("xxx++" + sf.getFileName());

                    if(sf.getKey() != null){

                        logger.debug("add new Huawei gNodeB Group: " + sf.getKey());

//                        newProcessor = new HwGnodebContainer(db, pgc, context, sf, meo);
                        startProcessor(new HwGnodebContainer(db, pgc, context, sf, meo));
                    }
                }
                else if(meo.mr.getMapentityTablename().equals("hwinventory")) {

                    System.out.println("xxx++" + sf.getFileName());

                    if(sf.getKey() != null){

                        logger.debug("add new Huawei Inventory Group: " + sf.getKey());

//                        newProcessor = new HwInventoryContainer(db, pgc, context, sf, meo);
                        startProcessor(new HwInventoryContainer(db, pgc, context, sf, meo));
                    }
                }
            }
        }

//        if(newProcessor != null){
//
//            try {
//
//                DSLContext dslC = dbPool.borrowObject();
//
//                newProcessor.processAll(dslC);
//
//                dbPool.returnObject(dslC);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
    }

    private void startProcessor(FileProcessor fileProcessor) {
        if(fileProcessor != null){

            try {

                DSLContext dslC = dbPool.borrowObject();

                fileProcessor.processAll(dslC);

                dbPool.returnObject(dslC);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    protected void getDataLocal(){
    }
}

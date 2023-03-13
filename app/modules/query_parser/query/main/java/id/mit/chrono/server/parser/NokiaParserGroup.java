package id.mit.chrono.server.parser;

import id.mit.chrono.server.base.BaseParserGroup;
import id.mit.chrono.server.enm.PS;
import id.mit.chrono.server.iface.FileProcessor;
import id.mit.chrono.server.model.tables.records.CrmapparserRecord;
import id.mit.chrono.server.obj.*;
import org.jooq.DSLContext;

import java.util.ArrayList;
import java.util.List;

public class NokiaParserGroup extends BaseParserGroup {

    public NokiaParserGroup(ChronoContext context, int vendorId, List<CrmapparserRecord> maps, int maxParallel, int poolSize) {
        super(context, vendorId, maps, maxParallel, poolSize);
    }

    @Override
    protected void prepareProcessWorkers() {}

    @Override
    protected void processFinishedSourceFile(SourceFile sf) {

        MapEntityObj meo;

        FileProcessor newProcessor = null;

        for (int j = 0; j < entityMaps.size(); j++) {

            meo = entityMaps.get(j);

            if (meo.mr.getMapentityDatagroup() == context.getDATAGROUP_ID() && sf.getFileName().matches(meo.mr.getMapentityFilepattern())) {

                if (meo.mr.getMapentityTablename().equals("nokbsc")) {

                    if (sf.getKey() != null) {

                        logger.debug("add new Nokia BSC");

                        newProcessor = new NokBscContainer(db, pgc, context, sf, meo);
                    }
                } else if (meo.mr.getMapentityTablename().equals("nokrnc")) {

                    if (sf.getKey() != null) {

                        logger.debug("add new Nokia RNC");

                        newProcessor = new NokRncContainer(db, pgc, context, sf, meo);
                    }

                } else if (meo.mr.getMapentityTablename().equals("nokenodeb")) {

                    if (sf.getKey() != null) {

                        logger.debug("add new Nokia eNodeB");

                        newProcessor = new NokEnodebContainer(db, pgc, context, sf, meo);
                    }
                } else if (meo.mr.getMapentityTablename().equals("nokinventory")) {

                    if (sf.getKey() != null) {

                        logger.debug("add new Nokia inventory: " + sf.getFileName());

                        newProcessor = new NokInventoryContainer(db, pgc, context, sf, meo);
                    }
                }

                break;
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

        sf.purgeResult2();
    }

    @Override
    protected void getDataLocal() {

    }
}

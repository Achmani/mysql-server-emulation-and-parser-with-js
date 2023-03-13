package id.mit.chrono.server.parser;

import id.mit.chrono.server.base.BaseParserGroup;
import id.mit.chrono.server.iface.FileProcessor;
import id.mit.chrono.server.model.tables.records.CrmapparserRecord;
import id.mit.chrono.server.obj.*;
import org.jooq.DSLContext;

import java.util.ArrayList;
import java.util.List;

public class GenericParserGroup extends BaseParserGroup {

    public GenericParserGroup(ChronoContext context, int vendorId, List<CrmapparserRecord> maps, int maxParallel, int poolSize) {
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

            if (sf.getFileName().matches(meo.mr.getMapentityFilepattern())) {

                if (meo.mr.getMapentityTablename().equals("stylo2g")) {

                    logger.debug("add new Stylo 2G");

                    newProcessor = new Stylo2gContainer(db, pgc, context, sf, meo);
                }
                else if (meo.mr.getMapentityTablename().equals("stylo3g")) {

                    logger.debug("add new Stylo 3G");

                    newProcessor = new Stylo3gContainer(db, pgc, context, sf, meo);
                }
                else if (meo.mr.getMapentityTablename().equals("stylo4g")) {

                    logger.debug("add new Stylo 4G");

                    newProcessor = new Stylo4gContainer(db, pgc, context, sf, meo);
                }
                else if (meo.mr.getMapentityTablename().equals("crenodebmme")) {

                    logger.debug("add new eNodeB MME");

                    newProcessor = new CrENodebMmeContainer(db, pgc, context, sf, meo);
                }
                else if (meo.mr.getMapentityTablename().equals("lacimareject")) {

                    logger.debug("add new Lacima Reject");

                    newProcessor = new LacimaRejectContainer(db, pgc, context, sf, meo);
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
    protected void getDataLocal() {}
}

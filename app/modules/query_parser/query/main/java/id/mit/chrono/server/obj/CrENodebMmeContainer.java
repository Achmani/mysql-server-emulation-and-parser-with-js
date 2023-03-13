package id.mit.chrono.server.obj;

import id.mit.chrono.server.base.GenericBaseContainer;
import id.mit.chrono.server.enm.PS;
import id.mit.chrono.server.iface.FileProcessor;
import id.mit.chrono.server.iface.ParserGroupCallback;
import id.mit.chrono.server.model.tables.records.CrenodebmmeRecord;
import id.mit.chrono.server.model.tables.records.CrmapfieldRecord;
import id.mit.chrono.server.model.tables.records.CrvendorRecord;
import id.mit.chrono.server.model.tables.records.StylolcellRecord;
import org.jooq.DSLContext;
import org.jooq.Result;
import org.jooq.impl.DSL;
import org.jooq.types.UInteger;
import org.jooq.types.ULong;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Set;

import static id.mit.chrono.server.model.Tables.*;

public class CrENodebMmeContainer extends GenericBaseContainer implements FileProcessor {

    Result<CrenodebmmeRecord> enodebs;
    CrvendorRecord vendorObj;

    public CrENodebMmeContainer(DSLContext db, ParserGroupCallback pgc, ChronoContext context, SourceFile sf, MapEntityObj meo) {
        super(db, pgc, context, sf, meo);
        logger = LoggerFactory.getLogger(this.getClass() + ":" + sf.getTaskFilesId());
    }

    @Override
    public boolean process(DSLContext adb, PS state){
        return updateWorkingState(state);
    }

    @Override
    public boolean processAll(DSLContext adb){

        resetStopwatch();

        this.prepareKeyParamsResult(adb);

        addMeasurement(PS.PREPARE, this.getKey(), true);

        this.prepareMmeData(adb);
        addMeasurement(PS.ENODEB_MME, this.getKey(), true);

        this.clearUnusedData(adb);
        addMeasurement(PS.FINALIZE, this.getKey(), true);

        saveStatistics(adb);

        return true;
    }

    private void prepareMmeData(DSLContext db){

        logger.debug("prepareMmeData()");

        logger.debug("this.result.size(): " + this.result.size());

        Set<String> keys = this.result.get(0).params.keySet();

        for(String s: keys){
            System.out.println("key: " + s);
            System.out.println("val: " + this.result.get(0).params.get(s));
        }

        String key = "MME_VENDOR";
        final String vendor = this.result.get(0).params.get(key);

        logger.debug("vendor information: " + vendor);

        vendorObj = db.selectFrom(CRVENDOR).where(CRVENDOR.VENDOR_CODE.eq(vendor)).fetchOne();

        if(vendorObj == null){
            logger.debug("failed to get vendor object, exiting..");
            return;
        }

        logger.debug("found valid vendor id " + vendor + " -> " + vendorObj.getVendorId());

        this.enodebs = db.selectFrom(CRENODEBMME)
                .where(
                        CRENODEBMME.ENODEBMME_VENDOR.eq(vendorObj.getVendorId())
                ).fetch();

        logger.debug("got existing enodeb mmes: " + vendor + " -> " + this.enodebs.size());

        this.result.stream().forEach(objx -> processENodebMme(db, meo, objx));

        logger.debug("prepareMmeData() done");
    }

    private void processENodebMme(DSLContext db, MapEntityObj me, StyloBasicKeyParamsObj obj){

        HuaweiBasicKeyParamsObj mml;
        CrmapfieldRecord mfr;

        String key = "ENODEB_ID";
        String keyVal = obj.params.get(key);

        CrenodebmmeRecord r = null;

        for (int i = 0; i < this.enodebs.size(); i++) {

            if(enodebs.get(i).getEnodebmmeEnodebid().toString().equals(keyVal)){

                r = enodebs.get(i);
                enodebs.remove(i);
                break;
            }
        }

        if(r != null){

            r.setEnodebmmeDate(context.getEpochTime());
            r.update();

            logger.debug("crenodebmme exist: " + keyVal);
            return;
        }

        r = db.newRecord(CRENODEBMME);

        ArrayList<String> filters = new ArrayList<>();
        filters.add(key);
        filters.add(keyVal);

        for (int l = 0; l < me.mft.size(); l++) {

            mfr = me.mft.get(l);

            // if need replace from chrono.context
            if(mfr.getMapfieldSourcegroup().equals("chrono.context")){

                String replaceVal = null;

                switch(mfr.getMapfieldSourceparam()){

                    case "DATE": replaceVal = String.valueOf(context.getEpochTime()); break;
                    default: break;
                }

                if(replaceVal != null){

                    r.set(DSL.field(mfr.getMapfieldFieldname()), replaceVal);
                }
            }
            else{

                r.set(DSL.field(mfr.getMapfieldFieldname()), obj.params.get(mfr.getMapfieldSourceparam()));
            }
        }

        r.setEnodebmmeCrcollectortaskfiles(ULong.valueOf(this.sf.getTaskFilesId()));
        r.setEnodebmmeVendor(vendorObj.getVendorId());

        int res = (r.getEnodebmmeId() == null)?r.store():r.update();
    }

    private void clearUnusedData(DSLContext db){

        logger.debug("clearUnusedData()");

        sf.purgeResult();

        logger.debug("clearUnusedData() done");
    }
}

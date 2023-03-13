package id.mit.chrono.server.obj;

import id.mit.chrono.server.base.GenericBaseContainer;
import id.mit.chrono.server.enm.PS;
import id.mit.chrono.server.iface.FileProcessor;
import id.mit.chrono.server.iface.ParserGroupCallback;
import id.mit.chrono.server.model.tables.records.CrenodebmmeRecord;
import id.mit.chrono.server.model.tables.records.CrmapfieldRecord;
import id.mit.chrono.server.model.tables.records.CrvendorRecord;
import id.mit.chrono.server.model.tables.records.LacimarejectRecord;
import org.jooq.DSLContext;
import org.jooq.Result;
import org.jooq.impl.DSL;
import org.jooq.types.UInteger;
import org.jooq.types.ULong;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Set;

import static id.mit.chrono.server.model.Tables.*;
import static id.mit.chrono.server.model.Tables.HWNODEB;

public class LacimaRejectContainer extends GenericBaseContainer implements FileProcessor {

    public LacimaRejectContainer(DSLContext db, ParserGroupCallback pgc, ChronoContext context, SourceFile sf, MapEntityObj meo) {
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

        this.prepareLacimaReject(adb);
        addMeasurement(PS.ENODEB_MME, this.getKey(), true);

        this.clearUnusedData(adb);
        addMeasurement(PS.FINALIZE, this.getKey(), true);

        saveStatistics(adb);

        return true;
    }

    private void prepareLacimaReject(DSLContext db){

        logger.debug("prepareLacimaReject()");

        logger.debug("this.result.size(): " + this.result.size());

        this.result.stream().forEach(objx -> processLacimaReject(db, meo, objx));

        logger.debug("prepareLacimaReject() done");
    }

    private void processLacimaReject(DSLContext db, MapEntityObj me, StyloBasicKeyParamsObj obj){

        HuaweiBasicKeyParamsObj mml;
        CrmapfieldRecord mfr;

        String key = "LAC";
        String keyVal = obj.params.get(key);
        String key2 = "CELL_ID";
        String key2Val = obj.params.get(key2);

        LacimarejectRecord reject = null;

        // select from DB, if not found, then create a new one
        reject = db.selectFrom(LACIMAREJECT)
                .where(LACIMAREJECT.LACIMAREJECT_DATE.eq(UInteger.valueOf(context.getEpochTime())))
                .and(LACIMAREJECT.LAC.eq(keyVal))
                .and(LACIMAREJECT.CELL_ID.eq(key2Val))
                .fetchOne();

        if(reject == null){

            reject = db.newRecord(LACIMAREJECT);

            reject.setLacimarejectDate(UInteger.valueOf(context.getEpochTime()));
            reject.setLac(keyVal);
            reject.setCellId(key2Val);
        }

        ArrayList<String> filters = new ArrayList<>();
        filters.add(key);
        filters.add(keyVal);
        filters.add(key2);
        filters.add(key2Val);

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

                    reject.set(DSL.field(mfr.getMapfieldFieldname()), replaceVal);
                }
            }
            else{

                reject.set(DSL.field(mfr.getMapfieldFieldname()), obj.params.get(mfr.getMapfieldSourceparam()));
            }
        }

        reject.setLacimarejectCrcollectortaskfiles(ULong.valueOf(this.sf.getTaskFilesId()));

        int res = (reject.getLacimarejectId() == null)?reject.store():reject.update();
    }

    private void clearUnusedData(DSLContext db){

        logger.debug("clearUnusedData()");

        sf.purgeResult();

        logger.debug("clearUnusedData() done");
    }
}

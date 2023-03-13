package id.mit.chrono.server.obj;

import id.mit.chrono.server.base.GenericBaseContainer;
import id.mit.chrono.server.enm.PS;
import id.mit.chrono.server.iface.FileProcessor;
import id.mit.chrono.server.iface.ParserGroupCallback;
import id.mit.chrono.server.model.tables.records.CrmapfieldRecord;
import id.mit.chrono.server.model.tables.records.CrnodeRecord;
import id.mit.chrono.server.model.tables.records.StylogcellRecord;
import id.mit.chrono.server.model.tables.records.StyloucellRecord;
import org.jooq.DSLContext;
import org.jooq.Result;
import org.jooq.impl.DSL;
import org.jooq.types.UInteger;
import org.jooq.types.ULong;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;

import static id.mit.chrono.server.model.Tables.STYLOGCELL;
import static id.mit.chrono.server.model.Tables.STYLOUCELL;

public class Stylo3gContainer extends GenericBaseContainer implements FileProcessor {

    Result<StyloucellRecord> cells;

    public Stylo3gContainer(DSLContext db, ParserGroupCallback pgc, ChronoContext context, SourceFile sf, MapEntityObj meo) {
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

        this.prepareUcell(adb);
        addMeasurement(PS.CELL3G, this.getKey(), true);

        this.clearUnusedData(adb);
        addMeasurement(PS.FINALIZE, this.getKey(), true);

        saveStatistics(adb);

        return true;
    }

    private void prepareUcell(DSLContext db){

        logger.debug("prepareUcell()");

        this.cells = db.selectFrom(STYLOUCELL)
                .where(
                        STYLOUCELL.STYLOUCELL_DATE.eq(UInteger.valueOf(context.getEpochTime()))
                ).fetch();

        logger.debug("got existing stylo ucell: " + this.cells.size());

        this.result.stream().forEach(objx -> processUcell(db, meo, objx));

        logger.debug("prepareUcell() done");
    }

    private void processUcell(DSLContext db, MapEntityObj me, StyloBasicKeyParamsObj obj){

        HuaweiBasicKeyParamsObj mml;
        CrmapfieldRecord mfr;

        String key = "RNCID LAC CI";
        String keyVal = obj.params.get(key);

        StyloucellRecord ucell = null;

        for (int i = 0; i < this.cells.size(); i++) {

            if(cells.get(i).getRncidLacCi().equals(keyVal)){

                ucell = cells.get(i);
                cells.remove(i);
                break;
            }
        }

        if(ucell != null){

            logger.debug("ucell exist: " + keyVal);
            return;
        }

//        StyloucellRecord ucell = db.selectFrom(STYLOUCELL)
//                .where(
//                        STYLOUCELL.STYLOUCELL_DATE.eq(UInteger.valueOf(context.getEpochTime()))
//                                .and(STYLOUCELL.RNCID_LAC_CI.eq(obj.params.get(key)))
//                )
//                .fetchOne();

//        System.out.println("TEST 2");

        if(ucell == null){

            ucell = db.newRecord(STYLOUCELL);

            ucell.setStyloucellCrcollectortaskfiles(ULong.valueOf(this.sf.getTaskFilesId()));
            ucell.setStyloucellDate(UInteger.valueOf(context.getEpochTime()));
            ucell.setRncidLacCi(obj.params.get(key));
        }

        ArrayList<String> filters = new ArrayList<>();
        filters.add(key);
        filters.add(obj.params.get(key));

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

                    ucell.set(DSL.field(mfr.getMapfieldFieldname()), replaceVal);
                }
            }
            else{

                ucell.set(DSL.field(mfr.getMapfieldFieldname()), obj.params.get(mfr.getMapfieldSourceparam()));
            }
        }

        ucell.setStyloucellCrcollectortaskfiles(ULong.valueOf(this.sf.getTaskFilesId()));

        int res = (ucell.getStyloucellId() == null)?ucell.store():ucell.update();
    }

    private void clearUnusedData(DSLContext db){

        logger.debug("clearUnusedData()");

        sf.purgeResult();

        logger.debug("clearUnusedData() done");
    }
}

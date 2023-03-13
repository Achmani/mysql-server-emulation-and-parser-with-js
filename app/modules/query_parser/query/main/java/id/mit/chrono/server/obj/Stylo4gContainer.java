package id.mit.chrono.server.obj;

import id.mit.chrono.server.base.GenericBaseContainer;
import id.mit.chrono.server.enm.PS;
import id.mit.chrono.server.iface.FileProcessor;
import id.mit.chrono.server.iface.ParserGroupCallback;
import id.mit.chrono.server.model.tables.records.CrmapfieldRecord;
import id.mit.chrono.server.model.tables.records.CrnodeRecord;
import id.mit.chrono.server.model.tables.records.StylogcellRecord;
import id.mit.chrono.server.model.tables.records.StylolcellRecord;
import org.jooq.DSLContext;
import org.jooq.Result;
import org.jooq.impl.DSL;
import org.jooq.types.UInteger;
import org.jooq.types.ULong;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;

import static id.mit.chrono.server.model.Tables.STYLOGCELL;
import static id.mit.chrono.server.model.Tables.STYLOLCELL;

public class Stylo4gContainer extends GenericBaseContainer implements FileProcessor {

    Result<StylolcellRecord> cells;

    public Stylo4gContainer(DSLContext db, ParserGroupCallback pgc, ChronoContext context, SourceFile sf, MapEntityObj meo) {
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

        this.prepareLcell(adb);
        addMeasurement(PS.CELL4G, this.getKey(), true);

        this.clearUnusedData(adb);
        addMeasurement(PS.FINALIZE, this.getKey(), true);

        saveStatistics(adb);

        return true;
    }

    private void prepareLcell(DSLContext db){

        logger.debug("prepareLcell()");

        this.cells = db.selectFrom(STYLOLCELL)
                .where(
                        STYLOLCELL.STYLOLCELL_DATE.eq(UInteger.valueOf(context.getEpochTime()))
                ).fetch();

        logger.debug("got existing stylo lcell: " + this.cells.size());


        this.result.stream().forEach(objx -> processLcell(db, meo, objx));

        logger.debug("prepareLcell() done");
    }

    private void processLcell(DSLContext db, MapEntityObj me, StyloBasicKeyParamsObj obj){

        HuaweiBasicKeyParamsObj mml;
        CrmapfieldRecord mfr;

        String key = "TAC ENODEBID CI";
        String keyVal = obj.params.get(key);

        StylolcellRecord lcell = null;

        for (int i = 0; i < this.cells.size(); i++) {

            if(cells.get(i).getTacEnodebidCi().equals(keyVal)){

                lcell = cells.get(i);
                cells.remove(i);
                break;
            }
        }

        if(lcell != null){

            logger.debug("lcell exist: " + keyVal);
            return;
        }

//        StylolcellRecord lcell = db.selectFrom(STYLOLCELL)
//                .where(
//                        STYLOLCELL.STYLOLCELL_DATE.eq(UInteger.valueOf(context.getEpochTime()))
//                                .and(STYLOLCELL.TAC_ENODEBID_CI.eq(obj.params.get(key)))
//                )
//                .fetchOne();

        if(lcell == null){

            lcell = db.newRecord(STYLOLCELL);

            lcell.setStylolcellCrcollectortaskfiles(ULong.valueOf(this.sf.getTaskFilesId()));
            lcell.setStylolcellDate(UInteger.valueOf(context.getEpochTime()));
            lcell.setTacEnodebidCi(obj.params.get(key));
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

                    lcell.set(DSL.field(mfr.getMapfieldFieldname()), replaceVal);
                }
            }
            else{

                lcell.set(DSL.field(mfr.getMapfieldFieldname()), obj.params.get(mfr.getMapfieldSourceparam()));
            }
        }

        lcell.setStylolcellCrcollectortaskfiles(ULong.valueOf(this.sf.getTaskFilesId()));

        int res = (lcell.getStylolcellId() == null)?lcell.store():lcell.update();
    }

    private void clearUnusedData(DSLContext db){

        logger.debug("clearUnusedData()");

        sf.purgeResult();

        logger.debug("clearUnusedData() done");
    }
}

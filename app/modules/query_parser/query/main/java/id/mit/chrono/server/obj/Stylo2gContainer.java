package id.mit.chrono.server.obj;

import id.mit.chrono.server.base.GenericBaseContainer;
import id.mit.chrono.server.base.HwBaseContainer;
import id.mit.chrono.server.enm.PS;
import id.mit.chrono.server.iface.FileProcessor;
import id.mit.chrono.server.iface.ParserGroupCallback;
import id.mit.chrono.server.model.tables.records.*;
import org.jooq.DSLContext;
import org.jooq.Result;
import org.jooq.impl.DSL;
import org.jooq.types.UInteger;
import org.jooq.types.ULong;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static id.mit.chrono.server.model.Tables.*;

public class Stylo2gContainer extends GenericBaseContainer implements FileProcessor {

    Result<StylogcellRecord> cells;

    public Stylo2gContainer(DSLContext db, ParserGroupCallback pgc, ChronoContext context, SourceFile sf, MapEntityObj meo) {
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

        this.prepareGcell(adb);
        addMeasurement(PS.CELL2G, this.getKey(), true);

        this.clearUnusedData(adb);
        addMeasurement(PS.FINALIZE, this.getKey(), true);

        saveStatistics(adb);

        return true;
    }

    private void prepareGcell(DSLContext db){

        logger.debug("prepareGcell()");

        this.cells = db.selectFrom(STYLOGCELL)
                .where(
                        STYLOGCELL.STYLOGCELL_DATE.eq(UInteger.valueOf(context.getEpochTime()))
                ).fetch();

        logger.debug("got existing stylo ucell: " + this.cells.size());

        this.result.stream().forEach(objx -> processGcell(db, meo, objx));

        logger.debug("prepareGcell() done");
    }

    private void processGcell(DSLContext db, MapEntityObj me, StyloBasicKeyParamsObj obj){

        HuaweiBasicKeyParamsObj mml;
        CrmapfieldRecord mfr;

        String key = "BSCID LAC CI";
        String keyVal = obj.params.get(key);

        StylogcellRecord gcell = null;

        for (int i = 0; i < this.cells.size(); i++) {

            if(cells.get(i).getBscidLacCi().equals(keyVal)){

                gcell = cells.get(i);
                cells.remove(i);
                break;
            }
        }

        if(gcell != null){

            logger.debug("gcell exist: " + keyVal);
            return;
        }

//        StylogcellRecord gcell = db.selectFrom(STYLOGCELL)
//                .where(
//                        STYLOGCELL.STYLOGCELL_DATE.eq(UInteger.valueOf(context.getEpochTime()))
//                                .and(STYLOGCELL.BSCID_LAC_CI.eq(obj.params.get(key)))
//                )
//                .fetchOne();

        if(gcell == null){

            gcell = db.newRecord(STYLOGCELL);

            gcell.setStylogcellCrcollectortaskfiles(ULong.valueOf(this.sf.getTaskFilesId()));
            gcell.setStylogcellDate(UInteger.valueOf(context.getEpochTime()));
            gcell.setBscidLacCi(obj.params.get(key));
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

                    gcell.set(DSL.field(mfr.getMapfieldFieldname()), replaceVal);
                }
            }
            else{

                gcell.set(DSL.field(mfr.getMapfieldFieldname()), obj.params.get(mfr.getMapfieldSourceparam()));
            }
        }

        gcell.setStylogcellCrcollectortaskfiles(ULong.valueOf(this.sf.getTaskFilesId()));

        int res = (gcell.getStylogcellId() == null)?gcell.store():gcell.update();
    }

    private void clearUnusedData(DSLContext db){

        logger.debug("clearUnusedData()");

        sf.purgeResult();

        logger.debug("clearUnusedData() done");
    }
}

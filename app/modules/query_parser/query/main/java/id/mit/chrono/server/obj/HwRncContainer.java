package id.mit.chrono.server.obj;

import com.google.common.base.Stopwatch;
import id.mit.chrono.server.base.BaseParserGroup;
import id.mit.chrono.server.enm.PS;
import id.mit.chrono.server.base.HwBaseContainer;
import id.mit.chrono.server.iface.FileProcessor;
import id.mit.chrono.server.iface.ParserGroupCallback;
import id.mit.chrono.server.model.tables.records.*;
import id.mit.chrono.server.util.CellUtils;
import id.mit.chrono.server.util.GeoUtil;
import org.jooq.DSLContext;
import org.jooq.impl.DSL;
import org.jooq.types.UInteger;
import org.jooq.types.ULong;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import static id.mit.chrono.server.model.Tables.*;

public class HwRncContainer extends HwBaseContainer implements FileProcessor {

    private HwrncRecord hwrnc;
    private List<HwnodebRecord> hwnodebs = new ArrayList<>();
    private List<HwucellRecord> ucells = new ArrayList<>();
    private HashMap<Long, CrnodeRecord> nodeCache = new HashMap();

    public HwRncContainer(DSLContext db, ParserGroupCallback pgc, ChronoContext context, SourceFile sf, MapEntityObj meo) {
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

        this.prepareRnc(adb);
        addMeasurement(PS.RNC, this.getKey(), true);

        this.prepareNodeB(adb);
        addMeasurement(PS.NODEB, this.getKey(), true);

        this.prepareUcell(adb);
        addMeasurement(PS.CELL3G, this.getKey(), true);

        this.updateHwrnc(adb);
        this.clearUnusedData(adb);
        addMeasurement(PS.FINALIZE, this.getKey(), true);

        saveStatistics(adb);

        return true;
    }

    private void prepareRnc(DSLContext db){

        HuaweiBasicKeyParamsObj mml;
        CrmapfieldRecord mfr;

        logger.debug("prepareRnc()");

        hwrnc = db.fetchOne(HWRNC, HWRNC.HWRNC_DATE.eq(UInteger.valueOf(context.getEpochTime()))
                .and(HWRNC.RNCNAME.eq(sf.getKey())));

        if(hwrnc == null){

            hwrnc = db.newRecord(HWRNC);
            hwrnc.setHwrncDate(UInteger.valueOf(context.getEpochTime()));
            hwrnc.setRncname(sf.getKey());

//            int result = hwrnc.store();

//            System.out.println("saved: " + result + " => " + hwrnc.getHwrncId());
        }

        for (int l = 0; l < meo.mft.size(); l++) {

            mfr = meo.mft.get(l);

            // if need replace from chrono.context
            if(mfr.getMapfieldSourcegroup().equals("chrono.context")){

                String replaceVal = null;

                switch(mfr.getMapfieldSourceparam()){

                    case "DATE": replaceVal = String.valueOf(context.getEpochTime()); break;
                    case "PARENTKEY": replaceVal = "XXX"; break;
                    default: break;
                }

                if(replaceVal != null){

                    hwrnc.set(DSL.field(mfr.getMapfieldFieldname()), replaceVal);
                }
            }
            else{

                hwrnc.set(DSL.field(mfr.getMapfieldFieldname()), getKeyParamsValue(mfr, null));
            }
        }

        hwrnc.setHwrncVendor(meo.mr.getMapentityVendor());

        hwrnc.setHwrncCrcollectortaskfiles(ULong.valueOf(this.sf.getTaskFilesId()));

        int res = (hwrnc.getHwrncId() == null)?hwrnc.store():hwrnc.update();

        logger.debug("prepareRnc() done");
    }

    private void prepareNodeB(DSLContext db){

        Stopwatch sw = Stopwatch.createUnstarted();

        HuaweiBasicKeyParamsObj mml;
        CrmapfieldRecord mfr;

        logger.debug("prepareNodeB()");

        // get field definition for hwbts

        MapEntityObj me = meo.getChildEntityByTableName("hwnodeb");

        // get Nodeb MML list
        List<HuaweiBasicKeyParamsObj> addUnodebs = result.stream()
                .filter(HuaweiBasicKeyParamsObj.class::isInstance)
                .map(HuaweiBasicKeyParamsObj.class::cast)
                .filter(p -> p.command.equals("ADD UNODEB"))
                .collect(Collectors.toList());

        // get CELL list
        List<HuaweiBasicKeyParamsObj> addUcellSetups = result.stream()
                .filter(HuaweiBasicKeyParamsObj.class::isInstance)
                .map(HuaweiBasicKeyParamsObj.class::cast)
                .filter(p -> p.command.equals("ADD UCELLSETUP"))
                .collect(Collectors.toList());

        HwnodebRecord unodeb;

        String key1;
        String keyLookup = "NODEBNAME";

        for (int i = 0; i < addUnodebs.size(); i++) {

//            unodeb = null;
            // select from DB, if not found, then create a new one
            unodeb = db.selectFrom(HWNODEB)
                    .where(HWNODEB.HWNODEB_DATE.eq(UInteger.valueOf(context.getEpochTime())))
                    .and(HWNODEB.HWNODEB_HWRNC.eq(hwrnc.getHwrncId()))
                    .and(HWNODEB.NODEBID.eq(addUnodebs.get(i).params.get("NODEBID")))
                    .fetchAny();

//            unodeb = null;

            if(unodeb == null){

                unodeb = db.newRecord(HWNODEB);

                unodeb.setHwnodebDate(UInteger.valueOf(context.getEpochTime()));
                unodeb.setHwnodebHwrnc(hwrnc.getHwrncId());
                unodeb.setNodebid(addUnodebs.get(i).params.get("NODEBID"));

//                unodeb.store();
            }

            key1 = "NODEBID";

            ArrayList<String> filters = new ArrayList<>();
            filters.add(key1);
            filters.add(addUnodebs.get(i).params.get(key1));
            String replaceVal;

            for (int l = 0; l < me.mft.size(); l++) {

                mfr = me.mft.get(l);

                // if need replace from chrono.context
                if(mfr.getMapfieldSourcegroup().equals("chrono.context")){

                    replaceVal = null;

                    switch(mfr.getMapfieldSourceparam()){

                        case "DATE": replaceVal = String.valueOf(context.getEpochTime()); break;
                        case "PARENTKEY": replaceVal = hwrnc.getHwrncId().toString(); break;
                        default: break;
                    }

                    if(replaceVal != null){

                        unodeb.set(DSL.field(mfr.getMapfieldFieldname()), replaceVal);
                    }
                }
                else{

                    String val = getKeyParamsValue(mfr, filters);

                    unodeb.set(DSL.field(mfr.getMapfieldFieldname()), val);
                }
            }

            // set relation to crnode
            CrnodeRecord node = pgc.getNode(meo.mr.getMapentityVendor(), unodeb.getNodebname(), meo.mr.getMapentityNodecategory());

            if(node != null){

                unodeb.setHwnodebNode(node.getNodeId());
                unodeb.setHwnodebRevenueclass(node.getNodeRevenueclass());
            }

            int total = 0;

            // get number of cell
            for (int j = 0; j < addUcellSetups.size(); j++) {

                if(unodeb.getNodebname().equals(addUcellSetups.get(j).params.get(keyLookup))){

                    total++;
                }
            }

            unodeb.setTotalcell(total);

            unodeb.setHwnodebVendor(meo.mr.getMapentityVendor());

            unodeb.setHwnodebCrcollectortaskfiles(ULong.valueOf(this.sf.getTaskFilesId()));

//            unodeb.store();

            int result = (unodeb.getHwnodebId() == null)?unodeb.store():unodeb.update();

            if(node != null){

                nodeCache.put(unodeb.getHwnodebId().longValue(), node);
            }

            hwnodebs.add(unodeb);
        }

        synchronized (hwrnc){
            hwrnc.setTotalnodeb(hwnodebs.size());
        }

        logger.debug("prepareNodeB() done");
    }

    private void prepareUcell(DSLContext db){

        logger.debug("prepareUcell()");

        HuaweiBasicKeyParamsObj mml;
        CrmapfieldRecord mfr;

        // get field definition for hwgcell
        MapEntityObj me = meo.getChildEntityByTableName("hwucell");

        // get BTS list
        List<HuaweiBasicKeyParamsObj> addUcellSetups = result.stream()
                .filter(HuaweiBasicKeyParamsObj.class::isInstance)
                .map(HuaweiBasicKeyParamsObj.class::cast)
                .filter(p -> p.command.equals("ADD UCELLSETUP"))
                .collect(Collectors.toList());

        for (int i = 0; i < addUcellSetups.size(); i++) {

            // select from DB, if not found, then create a new one

            HwucellRecord ucell = db.selectFrom(HWUCELL)
                    .where(HWUCELL.HWUCELL_DATE.eq(UInteger.valueOf(context.getEpochTime())))
                    .and(HWUCELL.HWUCELL_HWRNC.eq(hwrnc.getHwrncId()))
                    .and(HWUCELL.CELLID.eq(addUcellSetups.get(i).params.get("CELLID")))
                    .fetchAny();

            if(ucell == null){

                ucell = db.newRecord(HWUCELL);

                ucell.setHwucellDate(UInteger.valueOf(context.getEpochTime()));
                ucell.setHwucellHwrnc(hwrnc.getHwrncId());
                ucell.setCellid(addUcellSetups.get(i).params.get("CELLID"));
            }

            ArrayList<String> filters = new ArrayList<>();
            filters.add("CELLID");
            filters.add(addUcellSetups.get(i).params.get("CELLID"));

            for (int l = 0; l < me.mft.size(); l++) {

                mfr = me.mft.get(l);

                // if need replace from chrono.context
                if(mfr.getMapfieldSourcegroup().equals("chrono.context")){

                    String replaceVal = null;

                    switch(mfr.getMapfieldSourceparam()){

                        case "DATE": replaceVal = String.valueOf(context.getEpochTime()); break;
                        case "PARENTKEYRNC": replaceVal = hwrnc.getHwrncId().toString(); break;
                        default: break;
                    }

                    if(replaceVal != null){

                        ucell.set(DSL.field(mfr.getMapfieldFieldname()), replaceVal);
                    }
                }
                else{

                    ucell.set(DSL.field(mfr.getMapfieldFieldname()), getKeyParamsValue(mfr, filters));
                }
            }

            CrnodeRecord node = null;

            for (int j = 0; j < hwnodebs.size(); j++) {

                if(hwnodebs.get(j).getNodebname().equals(ucell.getNodebname())){

                    ucell.setHwucellHwnodeb(hwnodebs.get(j).getHwnodebId());
                    ucell.setHwucellRevenueclass(hwnodebs.get(j).getHwnodebRevenueclass());

                    node = nodeCache.get(hwnodebs.get(j).getHwnodebId().longValue());
                    break;
                }
            }

            String cgi = ucell.getMcc() + "-" + ucell.getMnc() + "-" + ucell.getLac() + "-" + ucell.getCellid();

            String bandLookup = "UMTS_" + ucell.getBandind();

            CrcellRecord cellProto = CellUtils.getCellProto(ucell, node);

            // set relation to crnode
            CrcellRecord cell = pgc.getCell(bandLookup, cgi, cellProto, node);

            if(cell != null){

                ucell.setHwucellCell(cell.getCellId());
                ucell.setHwucellCellclass(cell.getCellCellclass());
                ucell.setHwucellCellcoverage(cell.getCellCellcoverage());
                ucell.setHwucellRevenueclass(cell.getCellRevenueclass());
            }

            ucell.setCgi(cgi);

            ucell.setHwucellVendor(meo.mr.getMapentityVendor());
            ucell.setHwucellCrcollectortaskfiles(ULong.valueOf(this.sf.getTaskFilesId()));

            // set calculated lat lon decimal
//            ucell.setLatitude(GeoUtil.getHuawei3GLat(ucell.getAntennalatitudedegree()));
//            ucell.setLongitude(GeoUtil.getHuawei3GLon(ucell.getAntennalongitudedegree()));

//            ucell.store();

            int result = (ucell.getHwucellId() == null)?ucell.store():ucell.update();

            ucells.add(ucell);
        }

//        db.batchStore(ucells).execute();

        synchronized (hwrnc){
            hwrnc.setTotalcell(ucells.size());
        }

        logger.debug("prepareUcell() done");
    }

    private void updateHwrnc(DSLContext db){

        logger.debug("updateHwrnc() done");

        if(this.hwrnc.changed()){

            this.hwrnc.update();
        }

        logger.debug("updateHwrnc() done");
    }

    private void clearUnusedData(DSLContext db){

        sf.purgeResult();
        this.result.clear();
        this.hwnodebs.clear();
    }
}

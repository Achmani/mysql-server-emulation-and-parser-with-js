package id.mit.chrono.server.obj;

import id.mit.chrono.server.base.BaseParserGroup;
import id.mit.chrono.server.base.HwBaseContainer;
import id.mit.chrono.server.enm.PS;
import id.mit.chrono.server.iface.FileProcessor;
import id.mit.chrono.server.iface.ParserGroupCallback;
import id.mit.chrono.server.model.tables.records.*;
import id.mit.chrono.server.util.CellUtils;
import id.mit.chrono.server.util.GeoUtil;
import id.mit.chrono.server.util.GsmNetworkUtils;
import org.jooq.DSLContext;
import org.jooq.impl.DSL;
import org.jooq.types.UInteger;
import org.jooq.types.ULong;
import org.slf4j.LoggerFactory;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static id.mit.chrono.server.model.Tables.*;

public class HwEnodebContainer extends HwBaseContainer implements FileProcessor {

    private HwenodebRecord hwenodeb;
    private CrnodeRecord node;

    private List<HwlcellRecord> lcells = new ArrayList<>();

    private List<HuaweiBasicKeyParamsObj> BTS3900CELLs;
    private List<HuaweiBasicKeyParamsObj> BTS3900CNOPERATORTAs;
    private List<HuaweiBasicKeyParamsObj> BTS3900LOCATIONs;
    private List<HuaweiBasicKeyParamsObj> CELLLTEFLEXBW_BTS3900s;


    DecimalFormat df = new DecimalFormat("0.0000000");

    public HwEnodebContainer(DSLContext db, ParserGroupCallback pgc, ChronoContext context, SourceFile sf, MapEntityObj meo) {
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

//        result.forEach(item -> {
//            System.out.println("command: " + item.command);
//            System.out.println("params: " + item.params);
//        });

        // count of cell
        BTS3900CELLs = result.stream()
                .filter(HuaweiBasicKeyParamsObj.class::isInstance)
                .map(HuaweiBasicKeyParamsObj.class::cast)
                .filter(p -> p.command.equals("BTS3900CELL"))
                .collect(Collectors.toList());

        BTS3900CNOPERATORTAs = result.stream()
                .filter(HuaweiBasicKeyParamsObj.class::isInstance)
                .map(HuaweiBasicKeyParamsObj.class::cast)
                .filter(p -> p.command.equals("BTS3900CNOPERATORTA"))
                .collect(Collectors.toList());

        BTS3900LOCATIONs = result.stream()
                .filter(HuaweiBasicKeyParamsObj.class::isInstance)
                .map(HuaweiBasicKeyParamsObj.class::cast)
                .filter(p -> p.command.equals("BTS3900LOCATION"))
                .collect(Collectors.toList());

        CELLLTEFLEXBW_BTS3900s = result.stream()
                .filter(HuaweiBasicKeyParamsObj.class::isInstance)
                .map(HuaweiBasicKeyParamsObj.class::cast)
                .filter(p -> p.command.equals("CELLLTEFLEXBW_BTS3900") ||p.command.equals("CELLLTEFLEXBW_BTS5900"))
                .collect(Collectors.toList());

        System.out.println("LTEFLEXBW.size()" + CELLLTEFLEXBW_BTS3900s.size());
        CELLLTEFLEXBW_BTS3900s.forEach(item -> {
            System.out.println("command: " + item.command);
            System.out.println("params: " + item.params);
            System.out.println("\n");
        });

        addMeasurement(PS.PREPARE, this.getKey(), true);

        this.prepareENodeB(adb);
        addMeasurement(PS.ENODEB, this.getKey(), true);

        this.prepareENodeBCell(adb);
        addMeasurement(PS.CELL4G, this.getKey(), true);

        this.clearUnusedData(adb);
        addMeasurement(PS.FINALIZE, this.getKey(), true);

        saveStatistics(adb);

        return true;
    }

    private void prepareENodeB(DSLContext db){

        logger.debug("prepareENodeB()");

        HuaweiBasicKeyParamsObj mml;
        CrmapfieldRecord mfr;

        hwenodeb = db.selectFrom(HWENODEB)
                .where(HWENODEB.HWENODEB_DATE.eq(UInteger.valueOf(context.getEpochTime())))
                .and(HWENODEB.ENODEBID.eq(sf.getKey()))
                .fetchAny();

        if(hwenodeb == null){

            hwenodeb = db.newRecord(HWENODEB);
            hwenodeb.setHwenodebDate(UInteger.valueOf(context.getEpochTime()));
            hwenodeb.setEnodebid(sf.getKey());
            hwenodeb.setHwenodebCrcollectortaskfiles(ULong.valueOf(this.sf.getTaskFilesId()));
        }

        String key = "LOCATIONNAME";

        ArrayList<String> filters = new ArrayList<>();
        filters.add(key);
        filters.add("GPS");

        for (int l = 0; l < meo.mft.size(); l++) {

            mfr = meo.mft.get(l);

            // if need replace from chrono.context
            if(mfr.getMapfieldSourcegroup().equals("chrono.context")){

                String replaceVal = null;

                switch(mfr.getMapfieldSourceparam()){

                    case "DATE": replaceVal = String.valueOf(context.getEpochTime()); break;
                    default: break;
                }

                if(replaceVal != null){

                    hwenodeb.set(DSL.field(mfr.getMapfieldFieldname()), replaceVal);
                }
            }
            else if (mfr.getMapfieldSourcegroup().equals("BTS3900LOCATION")) {
                HuaweiBasicKeyParamsObj latlongObj = null;
                if (mfr.getMapfieldFieldname().endsWith("DEGFORMAT")) {
                     latlongObj = BTS3900LOCATIONs.stream()
                            .filter(obj -> !obj.params.get("LOCATIONNAME").equals("GPS"))
                            .findFirst()
                            .orElse(null);
                }

                else if (mfr.getMapfieldFieldname().endsWith("GPS")) {
                    latlongObj = BTS3900LOCATIONs.stream()
                            .filter(obj -> obj.params.get("LOCATIONNAME").equals("GPS"))
                            .findFirst()
                            .orElse(null);
                }

                if (latlongObj != null) {
                    hwenodeb.set(DSL.field(mfr.getMapfieldFieldname()), latlongObj.params.get(mfr.getMapfieldSourceparam()));
                }

            }
            else{

                String val = getKeyParamsValue(mfr, null);

                if(val != null){

                    hwenodeb.set(DSL.field(mfr.getMapfieldFieldname()), val);
                }
            }
        }

        // correlate to node
        node = pgc.getNode(meo.mr.getMapentityVendor(), hwenodeb.getEnodebfunctionname(), meo.mr.getMapentityNodecategory());

        if(node != null){

            hwenodeb.setHwenodebNode(node.getNodeId());
            hwenodeb.setHwenodebRevenueclass(node.getNodeRevenueclass());
        }

        hwenodeb.setHwenodebNodestatus(pgc.getNodeStatus(hwenodeb.getEnodebfunctionname()));

        hwenodeb.setTotalcell(BTS3900CELLs.size());

        hwenodeb.setHwenodebVendor(meo.mr.getMapentityVendor());

        hwenodeb.setHwenodebCrcollectortaskfiles(ULong.valueOf(this.sf.getTaskFilesId()));

        int res = (hwenodeb.getHwenodebId() == null)?hwenodeb.store():hwenodeb.update();

        logger.debug("prepareENodeB() done");
    }

    private void prepareENodeBCell(DSLContext db){

        logger.debug("prepareENodeBCell()");

        HuaweiBasicKeyParamsObj cme;
        CrmapfieldRecord mfr;

        // get field definition for hwgcell
        MapEntityObj me = meo.getChildEntityByTableName("hwlcell");

        String key = "CELLID";
        String key2 = "LOCATIONNAME";
        String key3 = "LOCALCELLID";
        String key4 = "TRACKINGAREAID";
        String key5 = "TAC";
        String key6 = "NBIOTTAFLAG";

        for (int i = 0; i < BTS3900CELLs.size(); i++) {

            // select from DB, if not found, then create a new one

            HwlcellRecord lcell = db.selectFrom(HWLCELL)
                    .where(HWLCELL.HWLCELL_DATE.eq(UInteger.valueOf(context.getEpochTime())))
                    .and(HWLCELL.ENODEBID.eq(hwenodeb.getEnodebid()))
                    .and(HWLCELL.CELLID.eq(BTS3900CELLs.get(i).params.get(key)))
                    .fetchAny();

            if(lcell == null){

                lcell = db.newRecord(HWLCELL);

                lcell.setHwlcellDate(UInteger.valueOf(context.getEpochTime()));
//                lcell.setEnodebid(hwenodeb.getEnodebid());
                lcell.setCellid(BTS3900CELLs.get(i).params.get(key));

//                lcell.setHwlcellHwenodeb(hwenodeb.getHwenodebId());
            }

            lcell.setEnodebid(hwenodeb.getEnodebid());
            lcell.setHwlcellHwenodeb(hwenodeb.getHwenodebId());

            ArrayList<String> filters = new ArrayList<>();
//            filters.add(key);
//            filters.add(BTS3900CELLs.get(i).params.get(key));
//            filters.add(key2);
//            filters.add(hwenodeb.getEnodebid());
            filters.add(key3);
            filters.add(BTS3900CELLs.get(i).params.get(key3));

            for (int l = 0; l < me.mft.size(); l++) {

                mfr = me.mft.get(l);

                // if need replace from chrono.context
                if(mfr.getMapfieldSourcegroup().equals("chrono.context")){

                    String replaceVal = null;

                    switch(mfr.getMapfieldSourceparam()){

                        case "DATE": replaceVal = String.valueOf(context.getEpochTime()); break;
                        //case "PARENTENODEB": replaceVal = hwenodeb.getHwenodebId().toString(); break;
                        default: break;
                    }

                    if(replaceVal != null){

                        lcell.set(DSL.field(mfr.getMapfieldFieldname()), replaceVal);
                    }
                }
                else if (mfr.getMapfieldSourcegroup().equals("CELLLTEFLEXBW_BTS3900")) {

                    for (HuaweiBasicKeyParamsObj hwKeyParams: CELLLTEFLEXBW_BTS3900s) {

                        String flexBwLocalCellId = hwKeyParams.params.get("LOCALCELLID");
                        if (lcell.getLocalcellid().equals(flexBwLocalCellId)) {
//                            System.out.println("CELLLTEFLEXBW!");
//                            System.out.println("LOCALCELLID: " + lcell.getLocalcellid());
                            lcell.set(DSL.field(mfr.getMapfieldFieldname()), hwKeyParams.params.get(mfr.getMapfieldSourceparam()));
                            break;
                        }

                    }

                }
                else{

                    String val = getKeyParamsValue(mfr, filters);

                    if(val != null){

                        lcell.set(DSL.field(mfr.getMapfieldFieldname()), val);
                    }
                }
            }

            // set TAC from BTS3900CNOPERATORTAs
            if(lcell.getTrackingareaid() != null){

                for (int j = 0; j < BTS3900CNOPERATORTAs.size(); j++) {

                    if(BTS3900CNOPERATORTAs.get(j).params.get(key4).equals(lcell.getTrackingareaid())){

                        lcell.setTac(BTS3900CNOPERATORTAs.get(j).params.get(key5));
                        lcell.setNbiottaflag(BTS3900CNOPERATORTAs.get(j).params.get(key6));
                        break;
                    }
                }
            }

            int eci = GsmNetworkUtils.getLteEci(lcell.getEnodebid(), lcell.getCellid());

            String ecgi = getECGI(hwenodeb.getMcc(), hwenodeb.getMnc(), String.valueOf(eci));

            if(ecgi != null){

                lcell.setEcgi(ecgi);

                lcell.setEci(String.valueOf(eci));

                String genodebid = hwenodeb.getMcc() + "-" + hwenodeb.getMnc() + "-" + hwenodeb.getEnodebid();
                lcell.setGenodebid(genodebid);


                long tai = GsmNetworkUtils.getLteTai(lcell.getMcc(), lcell.getMnc(), lcell.getTac());
                lcell.setTai(String.valueOf(tai));
            }

//            String latString = lcell.getLatitudedegformat();
//            String lonString = lcell.getLongitudedegformat();
//
//            if(latString != null && lonString != null){
//
//                lcell.setLatitude(GeoUtil.getHuawei3GLat(latString));
//                lcell.setLongitude(GeoUtil.getHuawei3GLon(lonString));
//            }

            // set relation to crnode

            // set lat-lon from eNodeB level

            boolean c1 = hwenodeb.getLatitudedegformat() != null && ! hwenodeb.getLatitudedegformat().isEmpty();
            boolean c2 = hwenodeb.getLongitudedegformat() != null && ! hwenodeb.getLongitudedegformat().isEmpty();

            if(c1 && c2){

                Double lat = Double.parseDouble(hwenodeb.getLatitudedegformat());
                Double lon = Double.parseDouble(hwenodeb.getLongitudedegformat());

                lat = lat/1000000;
                lon = lon/1000000;


                lcell.setLatitude(df.format(lat));
                lcell.setLongitude(df.format(lon));
            }

            if (hwenodeb.getLatitudegps() != null && !hwenodeb.getLatitudegps().isEmpty()) {
                double latGps = Double.parseDouble(hwenodeb.getLatitudegps());
                latGps /= 1000000;
                lcell.setLatitudegps(df.format(latGps));
            }

            if (hwenodeb.getLongitudegps() != null && !hwenodeb.getLongitudegps().isEmpty()) {
                double longGps = Double.parseDouble(hwenodeb.getLongitudegps());
                longGps /= 1000000;
                lcell.setLongitudegps(df.format(longGps));
            }


            if(!lcell.getDlearfcn().isEmpty()){

                CrcellRecord cellProto = CellUtils.getCellProto(lcell, node);

                CrcellRecord cell = pgc.getCellByArfcn("LTE", Double.parseDouble(lcell.getDlearfcn()), lcell.getEcgi(), cellProto, node);

                if(cell != null){
                    lcell.setHwlcellCell(cell.getCellId());
                    lcell.setHwlcellCellclass(cell.getCellCellclass());
                    lcell.setHwlcellCellcoverage(cell.getCellCellcoverage());
                    lcell.setHwlcellRevenueclass(cell.getCellRevenueclass());
                    lcell.setHwlcellLatitude(cell.getCellLatitude());
                    lcell.setHwlcellLongitude(cell.getCellLongitude());

                    Double earfcn = null;

                    if(lcell.getDlearfcn() != null && !lcell.getDlearfcn().isEmpty()){

                        try{

                            earfcn = Double.parseDouble(lcell.getDlearfcn());
                        }catch(Exception e){}
                    }

//                    CrnodeRecord nodeAlias = pgc.getCellNodeAlias(lcell, lcell,  cell.getCellCellclass(), earfcn, lcell.getCellname(), node);

                    String neName = (node != null)?node.getNodeCode(): null;

                    CrnodeRecord nodeAlias = pgc.getCellNodeAlias2(meo.mr.getMapentityVendor(), cell.getCellCellclass(), lcell.getCellname(), neName);

                    if(nodeAlias != null){
                        lcell.setHwlcellNodealias(nodeAlias.getNodeId());
                    }
                }
            }

            lcell.setHwlcellVendor(meo.mr.getMapentityVendor());
            lcell.setHwlcellCellstatus(pgc.getCellStatus(lcell.getCellname()));
            lcell.setHwlcellCrcollectortaskfiles(ULong.valueOf(this.sf.getTaskFilesId()));

            int res = (lcell.getHwlcellId() == null)?lcell.store():lcell.update();

            lcells.add(lcell);
        }

        logger.debug("prepareENodeBCell() done");
    }

    private void clearUnusedData(DSLContext db){

        this.sf.purgeResult();
        this.BTS3900CELLs.clear();
        this.hwenodeb = null;
        this.result.clear();
        this.lcells.clear();
    }
}

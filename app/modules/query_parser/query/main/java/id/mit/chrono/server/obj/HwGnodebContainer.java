package id.mit.chrono.server.obj;

import id.mit.chrono.server.base.HwBaseContainer;
import id.mit.chrono.server.enm.PS;
import id.mit.chrono.server.iface.FileProcessor;
import id.mit.chrono.server.iface.ParserGroupCallback;
import id.mit.chrono.server.model.tables.records.*;
import id.mit.chrono.server.util.CellUtils;
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

public class HwGnodebContainer extends HwBaseContainer implements FileProcessor {

    // hwgnodeb -> 5G
    private HwgnodebRecord hwgnodeb;
    private CrnodeRecord node;

    private List<HwncellRecord> ncells = new ArrayList<>();

    private List<HuaweiBasicKeyParamsObj> NRCELLs;
    private List<HuaweiBasicKeyParamsObj> GNBOPERATORs;
    private List<HuaweiBasicKeyParamsObj> NRDUCELLs;
    private List<HuaweiBasicKeyParamsObj> GNBTRACKINGAREAs;
    private List<HuaweiBasicKeyParamsObj> BTS3900LOCATIONs;

    DecimalFormat df = new DecimalFormat("0.0000000");

    public HwGnodebContainer(DSLContext db, ParserGroupCallback pgc, ChronoContext context, SourceFile sf, MapEntityObj meo) {
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

        BTS3900LOCATIONs = result.stream()
                .filter(HuaweiBasicKeyParamsObj.class::isInstance)
                .map(HuaweiBasicKeyParamsObj.class::cast)
                .filter(p -> p.command.equals("BTS3900LOCATION"))
                .collect(Collectors.toList());

        // gnodeb
        NRCELLs = result.stream()
                .filter(HuaweiBasicKeyParamsObj.class::isInstance)
                .map(HuaweiBasicKeyParamsObj.class::cast)
                .filter(p -> p.command.equals("NRCELL"))
                .collect(Collectors.toList());

        GNBOPERATORs = result.stream()
                .filter(HuaweiBasicKeyParamsObj.class::isInstance)
                .map(HuaweiBasicKeyParamsObj.class::cast)
                .filter(p -> p.command.equals("GNBOPERATOR"))
                .collect(Collectors.toList());

        GNBTRACKINGAREAs = result.stream()
                .filter(HuaweiBasicKeyParamsObj.class::isInstance)
                .map(HuaweiBasicKeyParamsObj.class::cast)
                .filter(p -> p.command.equals("GNBTRACKINGAREA"))
                .collect(Collectors.toList());

        NRDUCELLs = result.stream()
                .filter(HuaweiBasicKeyParamsObj.class::isInstance)
                .map(HuaweiBasicKeyParamsObj.class::cast)
                .filter(p -> p.command.equals("NRDUCELL"))
                .collect(Collectors.toList());

        addMeasurement(PS.PREPARE, this.getKey(), true);

        this.prepareGNodeB(adb);
        addMeasurement(PS.GNODEB, this.getKey(), true);

        this.prepareGNodeBCell(adb);
        addMeasurement(PS.CELL5G, this.getKey(), true);

        this.clearUnusedData(adb);
        addMeasurement(PS.FINALIZE, this.getKey(), true);

        saveStatistics(adb);

        return true;
    }

    private void prepareGNodeB(DSLContext db) {

        logger.debug("prepareGNodeB()");

        CrmapfieldRecord mfr;

        hwgnodeb = db.selectFrom(HWGNODEB)
                .where(HWGNODEB.HWGNODEB_DATE.eq(UInteger.valueOf(context.getEpochTime())))
                .and(HWGNODEB.GNODEBID.eq(sf.getKey()))
                .fetchAny();

        if (hwgnodeb == null) {

            hwgnodeb = db.newRecord(HWGNODEB);
            hwgnodeb.setHwgnodebDate(UInteger.valueOf(context.getEpochTime()));
            hwgnodeb.setGnodebid(sf.getKey());
            hwgnodeb.setHwgnodebCrcollectortaskfiles(ULong.valueOf(this.sf.getTaskFilesId()));
        }

        String key = "LOCATIONNAME";

        ArrayList<String> filters = new ArrayList<>();
        filters.add(key);
        filters.add("GPS");

        for (int i = 0; i < meo.mft.size(); i++) {

            mfr = meo.mft.get(i);

            if (mfr.getMapfieldSourcegroup().equals("chrono.context")) {

                String replaceVal = null;

                switch(mfr.getMapfieldSourceparam()){

                    case "DATE": replaceVal = String.valueOf(context.getEpochTime()); break;
                    default: break;
                }

                if(replaceVal != null){

                    hwgnodeb.set(DSL.field(mfr.getMapfieldFieldname()), replaceVal);
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
                    hwgnodeb.set(DSL.field(mfr.getMapfieldFieldname()), latlongObj.params.get(mfr.getMapfieldSourceparam()));
                }

            }
            else{

                String val = getKeyParamsValue(mfr, null);

                if(val != null){

                    hwgnodeb.set(DSL.field(mfr.getMapfieldFieldname()), val);
                }
            }
        }

        // correlate to node
        node = pgc.getNode(meo.mr.getMapentityVendor(), hwgnodeb.getGnodebfunctionname(), meo.mr.getMapentityNodecategory());

        if(node != null){

            hwgnodeb.setHwgnodebNode(node.getNodeId());
            hwgnodeb.setHwgnodebRevenueclass(node.getNodeRevenueclass());
        }

        hwgnodeb.setHwgnodebNodestatus(pgc.getNodeStatus(hwgnodeb.getGnodebfunctionname()));

        hwgnodeb.setTotalcell(NRCELLs.size());

        hwgnodeb.setHwgnodebVendor(meo.mr.getMapentityVendor());

        hwgnodeb.setHwgnodebCrcollectortaskfiles(ULong.valueOf(this.sf.getTaskFilesId()));

        int res = (hwgnodeb.getHwgnodebId() == null)?hwgnodeb.store():hwgnodeb.update();

        logger.debug("prepareGNodeB() done");

    }

    private void prepareGNodeBCell(DSLContext db) {

        logger.debug("prepareGnodeBCell()");

        CrmapfieldRecord mfr;

        // get field definition for hwncell
        MapEntityObj me = meo.getChildEntityByTableName("hwncell");

        String key = "CELLID";
        String key2 = "LOCATIONNAME";
        String key3 = "LOCALCELLID";
        String key4 = "TRACKINGAREAID";
        String key5 = "TAC";

        for (int i = 0; i < NRCELLs.size(); i++) {


            // select from DB, if not found, then create a new one
            HwncellRecord ncell = db.selectFrom(HWNCELL)
                    .where(HWNCELL.HWNCELL_DATE.eq(UInteger.valueOf(context.getEpochTime())))
                    .and(HWNCELL.GNODEBID.eq(hwgnodeb.getGnodebid()))
                    .and(HWNCELL.CELLID.eq(NRCELLs.get(i).params.get(key)))
                    .fetchAny();

            if(ncell == null){

                ncell = db.newRecord(HWNCELL);

                ncell.setHwncellDate(UInteger.valueOf(context.getEpochTime()));
                ncell.setGnodebid(hwgnodeb.getGnodebid());
                ncell.setCellid(NRCELLs.get(i).params.get(key));

                ncell.setHwncellHwgnodeb(hwgnodeb.getHwgnodebId());

            }

            ArrayList<String> filters = new ArrayList<>();
            filters.add(key);
            filters.add(NRCELLs.get(i).params.get(key));

            for (int j = 0; j < me.mft.size(); j++) {

                mfr = me.mft.get(j);

                // if need replace from chrono.context
                if(mfr.getMapfieldSourcegroup().equals("chrono.context")){

                    String replaceVal = null;

                    switch(mfr.getMapfieldSourceparam()){

                        case "DATE": replaceVal = String.valueOf(context.getEpochTime()); break;
                        //case "PARENTENODEB": replaceVal = hwenodeb.getHwenodebId().toString(); break;
                        default: break;
                    }

                    if(replaceVal != null){

                        ncell.set(DSL.field(mfr.getMapfieldFieldname()), replaceVal);
                    }
                }
                else {
                    String val = getKeyParamsValue(mfr, filters);

                    if(val != null){

                        ncell.set(DSL.field(mfr.getMapfieldFieldname()), val);
                    }
                }

            }

            // select TAC from GNBTRACKINGAREA
            if (ncell.getTrackingareaid() != null) {

                for (int j = 0; j < GNBTRACKINGAREAs.size(); j++) {

                    if (GNBTRACKINGAREAs.get(j).params.get(key4).equals(ncell.getTrackingareaid())) {

                        ncell.setTac(GNBTRACKINGAREAs.get(j).params.get(key5));
                        break;
                    }
                }
            }

            int nci = GsmNetworkUtils.getNrNci(ncell.getGnodebid(), ncell.getCellid());

            String ncgi = getNCGI(hwgnodeb.getMcc(), hwgnodeb.getMnc(), String.valueOf(nci));

            if (ncgi != null) {

                ncell.setNcgi(ncgi);

                ncell.setNci(String.valueOf(nci));

                String ggnodebid = hwgnodeb.getMcc() + "-" + hwgnodeb.getMnc() + "-" + hwgnodeb.getGnodebid();
                ncell.setGgnodebid(ggnodebid);

                // TODO: Add Tai value

            }

            // set lat-lon from gNodeB level
            boolean c1 = hwgnodeb.getLatitudedegformat() != null && ! hwgnodeb.getLatitudedegformat().isEmpty();
            boolean c2 = hwgnodeb.getLongitudedegformat() != null && ! hwgnodeb.getLongitudedegformat().isEmpty();

            if (c1 && c2) {

                Double lat = Double.parseDouble(hwgnodeb.getLatitudedegformat());
                Double lon = Double.parseDouble(hwgnodeb.getLongitudedegformat());

                lat = lat/1000000;
                lon = lon/1000000;


                ncell.setLatitude(df.format(lat));
                ncell.setLongitude(df.format(lon));
            }

            if (hwgnodeb.getLatitudegps() != null) {
                double latGps = Double.parseDouble(hwgnodeb.getLatitudegps());
                latGps /= 1000000;
                ncell.setLatitudegps(df.format(latGps));
            }

            if (hwgnodeb.getLongitudegps() != null) {
                double longGps = Double.parseDouble(hwgnodeb.getLongitudegps());
                longGps /= 1000000;
                ncell.setLongitudegps(df.format(longGps));
            }

            if (!ncell.getDlnarfcn().isEmpty()) {

                CrcellRecord cellProto = CellUtils.getCellProto(ncell, node);

                CrcellRecord cell = pgc.getCellByArfcn("NR", Double.parseDouble(ncell.getDlnarfcn()), ncell.getNcgi(), cellProto, node);

                if(cell != null){
                    ncell.setHwncellCell(cell.getCellId());
                    ncell.setHwncellCellclass(cell.getCellCellclass());
                    ncell.setHwncellCellcoverage(cell.getCellCellcoverage());
                    ncell.setHwncellRevenueclass(cell.getCellRevenueclass());
                    ncell.setHwncellLatitude(cell.getCellLatitude());
                    ncell.setHwncellLongitude(cell.getCellLongitude());

                    Double nrarfcn = null;

                    if(ncell.getDlnarfcn() != null && !ncell.getDlnarfcn().isEmpty()){

                        try{

                            nrarfcn = Double.parseDouble(ncell.getDlnarfcn());

                            CellFreqResult res = CellUtils.calc5gNRarfcn(nrarfcn);

                            // use the c2
                            if(res.c1 != -1){

                                ncell.setDlfreq(res.c1);
                            }

                        }catch(Exception e){}
                    }

//                    CrnodeRecord nodeAlias = pgc.getCellNodeAlias(ncell, ncell,  cell.getCellCellclass(), earfcn, ncell.getCellname(), node);

                    String neName = (node != null)?node.getNodeCode(): null;

                    CrnodeRecord nodeAlias = pgc.getCellNodeAlias2(meo.mr.getMapentityVendor(), cell.getCellCellclass(), ncell.getCellname(), neName);

                    if(nodeAlias != null){
                        ncell.setHwncellNodealias(nodeAlias.getNodeId());
                    }
                }
            }

            ncell.setHwncellVendor(meo.mr.getMapentityVendor());
            ncell.setHwncellCellstatus(pgc.getCellStatus(ncell.getCellname()));
            ncell.setHwncellCrcollectortaskfiles(ULong.valueOf(this.sf.getTaskFilesId()));

            int res = (ncell.getHwncellId() == null)?ncell.store():ncell.update();

            ncells.add(ncell);

        }

    }

    private void clearUnusedData(DSLContext db){

        this.sf.purgeResult();
        this.NRCELLs.clear();
        this.hwgnodeb = null;
        this.result.clear();
        this.ncells.clear();
    }
}

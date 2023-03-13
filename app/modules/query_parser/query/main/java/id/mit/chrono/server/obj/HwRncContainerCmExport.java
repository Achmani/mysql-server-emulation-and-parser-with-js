package id.mit.chrono.server.obj;

import id.mit.chrono.server.base.HwBaseContainer;
import id.mit.chrono.server.enm.PS;
import id.mit.chrono.server.iface.FileProcessor;
import id.mit.chrono.server.iface.ParserGroupCallback;
import id.mit.chrono.server.model.tables.Crcell;
import id.mit.chrono.server.model.tables.records.*;
import id.mit.chrono.server.util.CellUtils;
import id.mit.chrono.server.util.GeoUtil;
import org.jooq.DSLContext;
import org.jooq.impl.DSL;
import org.jooq.types.UInteger;
import org.jooq.types.ULong;
import org.slf4j.LoggerFactory;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static id.mit.chrono.server.model.Tables.*;

public class HwRncContainerCmExport extends HwBaseContainer implements FileProcessor {

    private HwrncRecord hwrnc;
    private List<HwnodebRecord> hwnodebs = new ArrayList<>();
    private List<HwucellRecord> ucells = new ArrayList<>();
    private HashMap<Long, CrnodeRecord> nodeCache = new HashMap();

    // get Nodeb MML list
    List<HuaweiBasicKeyParamsObj> BSCUMTSNODEs;
    List<HuaweiBasicKeyParamsObj> BSCUMTSRNCBASICs;
    List<HuaweiBasicKeyParamsObj> UMTSNODEBs;
    List<HuaweiBasicKeyParamsObj> UMTSNODEBIPs;
    List<HuaweiBasicKeyParamsObj> BTSNEs;
    List<HuaweiBasicKeyParamsObj> UMTSCells;
    List<HuaweiBasicKeyParamsObj> USMLCCELLs;

//    String LOGICRNCIDFILTER = "LOGICRNCID";
//    String RNCID = null;
    ArrayList<String> filters = new ArrayList<>();

    public HwRncContainerCmExport(DSLContext db, ParserGroupCallback pgc, ChronoContext context, SourceFile sf, MapEntityObj meo) {
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

//        BSCUMTSNODEs = result.stream()
//                .filter(HuaweiBasicKeyParamsObj.class::isInstance)
//                .map(HuaweiBasicKeyParamsObj.class::cast)
//                .filter(p -> p.command.matches("^BSC\\d+UMTSNODE"))
//                .collect(Collectors.toList());
//
//        logger.debug("BSCUMTSNODEs.size(): " + BSCUMTSNODEs.size());

//        BSCUMTSRNCBASICs = result.stream()
//                .filter(HuaweiBasicKeyParamsObj.class::isInstance)
//                .map(HuaweiBasicKeyParamsObj.class::cast)
//                .filter(p -> p.command.matches("^BSC\\d+UMTSRNCBASIC") && p.params.get("HOSTTYPE").equals("SINGLEHOST"))
//                .collect(Collectors.toList());

//        logger.debug("BSCUMTSRNCBASICs.size(): " + BSCUMTSRNCBASICs.size());

//        if(BSCUMTSRNCBASICs.size() == 1){
//            RNCID = BSCUMTSRNCBASICs.get(0).params.get("RNCID");
//            logger.debug(this.sf.getKey() + " using RNCID from 1 UMTSRNCBASIC: " + RNCID);
//        }
//        else if(BSCUMTSNODEs.size() > 0){
//
//            RNCID = BSCUMTSNODEs.get(0).params.get("NID");
//            logger.debug(this.sf.getKey() + " using RNCID from UMTSNODE: " + RNCID);
//        }
//        else if(BSCUMTSRNCBASICs.size() > 0){
//
//            RNCID = BSCUMTSRNCBASICs.get(0).params.get("RNCID");
//            logger.debug(this.sf.getKey() + " using RNCID from 1st UMTSRNCBASIC: " + RNCID);
//        }

        UMTSNODEBs = result.stream()
                .filter(HuaweiBasicKeyParamsObj.class::isInstance)
                .map(HuaweiBasicKeyParamsObj.class::cast)
                .filter(p -> p.command.matches("^BSC\\d+UMTSNODEB$"))
                .collect(Collectors.toList());

        logger.debug("UMTSNODEBs.size(): " + UMTSNODEBs.size());

        UMTSNODEBIPs = result.stream()
                .filter(HuaweiBasicKeyParamsObj.class::isInstance)
                .map(HuaweiBasicKeyParamsObj.class::cast)
                .filter(p -> p.command.matches("^BSC\\d+UMTSNODEBIP$"))
                .collect(Collectors.toList());

        logger.debug("UMTSNODEBIPs.size(): " + UMTSNODEBIPs.size());

        BTSNEs = result.stream()
                .filter(HuaweiBasicKeyParamsObj.class::isInstance)
                .map(HuaweiBasicKeyParamsObj.class::cast)
                .filter(p -> p.command.matches("^BTS\\d+NE$"))
                .collect(Collectors.toList());

        logger.debug("BTSNEs.size(): " + BTSNEs.size());

        UMTSCells = result.stream()
                .filter(HuaweiBasicKeyParamsObj.class::isInstance)
                .map(HuaweiBasicKeyParamsObj.class::cast)
                .filter(p -> (p.command.matches("^BSC\\d+UMTSUCELL$") || p.command.matches("^BSC\\d+UMTSCell$")))
                .collect(Collectors.toList());

        logger.debug("UMTSCells.size(): " + UMTSCells.size());

        USMLCCELLs = result.stream()
                .filter(HuaweiBasicKeyParamsObj.class::isInstance)
                .map(HuaweiBasicKeyParamsObj.class::cast)
                .filter(p -> p.command.equals("ADD USMLCCELL"))
                .collect(Collectors.toList());

        logger.debug("USMLCCELLs.size(): " + USMLCCELLs.size());

        String rncId = null;

        // reduce
//        for (int i = (UMTSNODEBs.size()-1); i >= 0; i--) {
//
//            rncId = UMTSNODEBs.get(i).params.get(LOGICRNCIDFILTER);
//
//            if(rncId != null && !rncId.equals(RNCID)){
//
//                UMTSNODEBs.remove(i);
//            }
//        }

//        for (int i = (UMTSCells.size()-1); i >= 0; i--) {
//
//            rncId = UMTSCells.get(i).params.get(LOGICRNCIDFILTER);
//
//            if(rncId != null && !rncId.equals(RNCID)){
//
//                UMTSCells.remove(i);
//            }
//        }

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

                String val = getKeyParamsValue(mfr, null);

                if(val != null){

                    hwrnc.set(DSL.field(mfr.getMapfieldFieldname()), val);
                }
            }
        }

        hwrnc.setTotalnodeb(UMTSNODEBs.size());
        hwrnc.setTotalcell(UMTSCells.size());
        hwrnc.setHwrncVendor(meo.mr.getMapentityVendor());

        CrnodeRecord node = pgc.getNode(meo.mr.getMapentityVendor(), hwrnc.getRncname(), meo.mr.getMapentityNodecategory());

        if(node != null){

            hwrnc.setHwrncNode(node.getNodeId());
        }

        hwrnc.setHwrncCrcollectortaskfiles(ULong.valueOf(this.sf.getTaskFilesId()));

        int res = (hwrnc.getHwrncId() == null)?hwrnc.store():hwrnc.update();

        logger.debug("prepareRnc() done");
    }

    private void prepareNodeB(DSLContext db){

        logger.debug("prepareNodeB()");

        // get field definition for hwnodeb
        MapEntityObj me = meo.getChildEntityByTableName("hwnodeb");

        UMTSNODEBs.parallelStream().forEach(objx -> processUnodeB(db, me, objx));

        synchronized (hwrnc){
            hwrnc.setTotalnodeb(hwnodebs.size());
            hwrnc.update();
        }

        logger.debug("prepareNodeB() done");
    }

    private void processUnodeB(DSLContext db, MapEntityObj me, HuaweiBasicKeyParamsObj obj){

        HuaweiBasicKeyParamsObj mml;
        CrmapfieldRecord mfr;

        HwnodebRecord unodeb;

        String key1 = "NODEBID";
        String key2 = "NODEBNAME";
        String key3 = "fdn";
        String key4 = "LOGICRNCID";

        String mapfieldFieldname;

        ArrayList<String> filters = new ArrayList<>();
        ArrayList<String> filters2 = new ArrayList<>();

        // select from DB, if not found, then create a new one
        unodeb = db.selectFrom(HWNODEB)
                .where(HWNODEB.HWNODEB_DATE.eq(UInteger.valueOf(context.getEpochTime())))
                .and(HWNODEB.HWNODEB_HWRNC.eq(hwrnc.getHwrncId()))
                .and(HWNODEB.FDN.eq(obj.params.get(key3)))
                .fetchOne();

        if(unodeb == null){

            unodeb = db.newRecord(HWNODEB);

            unodeb.setHwnodebDate(UInteger.valueOf(context.getEpochTime()));
            unodeb.setHwnodebHwrnc(hwrnc.getHwrncId());
            unodeb.setFdn(obj.params.get(key3));
        }

        filters.clear();
        filters.add(key3);
        filters.add(obj.params.get(key3));

        filters2.clear();
        filters2.add(key1);
        filters2.add(obj.params.get(key1));

        String replaceVal;

        for (int l = 0; l < me.mft.size(); l++) {

            mfr = me.mft.get(l);

            mapfieldFieldname = mfr.getMapfieldFieldname();

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

                if(val == null){
                    val = getKeyParamsValue(mfr, filters2);
                }

                if(val != null){

                    unodeb.set(DSL.field(mapfieldFieldname), val);
                }
            }
        }

        // get BTS Type
        final String k1 = "IP";
        final String k2 = "neType";

        if(unodeb.getNboamip() != null){

            final String search = unodeb.getNboamip();

            Optional<HuaweiBasicKeyParamsObj> btsData = BTSNEs.stream().filter(o -> search.equals(o.params.get(k1))).findFirst();

            if(btsData.isPresent()){

                HuaweiBasicKeyParamsObj x = btsData.get();

                System.out.println("SET FOR " + unodeb.getNodebname() + " -> " + x.params.get(k2));
                unodeb.setBtstype(x.params.get(k2));
            }
        }

        // set relation to crnode
        CrnodeRecord node = pgc.getNode(meo.mr.getMapentityVendor(), unodeb.getNodebname(), me.mr.getMapentityNodecategory());

        if(node != null){

            unodeb.setHwnodebNode(node.getNodeId());
            unodeb.setHwnodebRevenueclass(node.getNodeRevenueclass());
        }

        int total = 0;

        // get number of cell
        for (int j = 0; j < UMTSCells.size(); j++) {

            if(unodeb.getNodebname().equals(UMTSCells.get(j).params.get(key2))){

                total++;
            }
        }

        unodeb.setTotalcell(total);

        unodeb.setHwnodebNodestatus(pgc.getNodeStatus(unodeb.getNodebname()));

        unodeb.setHwnodebVendor(meo.mr.getMapentityVendor());

        unodeb.setHwnodebCrcollectortaskfiles(ULong.valueOf(this.sf.getTaskFilesId()));

        int result = (unodeb.getHwnodebId() == null)?unodeb.store():unodeb.update();

        if(node != null){

            nodeCache.put(unodeb.getHwnodebId().longValue(), node);
        }

        synchronized (hwnodebs){

            hwnodebs.add(unodeb);
        }
    }

    private void prepareUcell(DSLContext db){

        logger.debug("prepareUcell()");

        // get field definition for hwgcell
        MapEntityObj me = meo.getChildEntityByTableName("hwucell");


        System.out.println("HAHAHAHAHAH");

        UMTSCells.parallelStream().forEach(objx -> processUcell(db, me, objx));

        synchronized (hwrnc){
            hwrnc.setTotalcell(ucells.size());
            hwrnc.update();
        }

        logger.debug("prepareUcell() done");
    }

    private void processUcell(DSLContext db, MapEntityObj me, HuaweiBasicKeyParamsObj obj){

        HuaweiBasicKeyParamsObj mml;
        CrmapfieldRecord mfr;

        String key1 = "CELLID";
        String key2 = "fdn";

        String CELLID = obj.params.get(key1);
        String fdn = obj.params.get(key2);

        System.out.println("CELLID: " + CELLID + ", fdn: " + fdn);


        // select from DB, if not found, then create a new one
        HwucellRecord ucell = db.selectFrom(HWUCELL)
                .where(HWUCELL.HWUCELL_DATE.eq(UInteger.valueOf(context.getEpochTime())))
                .and(HWUCELL.HWUCELL_HWRNC.eq(hwrnc.getHwrncId()))
                .and(HWUCELL.FDN.eq(obj.params.get(key2)))
                .fetchOne();

        if(ucell == null){

            ucell = db.newRecord(HWUCELL);

            ucell.setHwucellDate(UInteger.valueOf(context.getEpochTime()));
            ucell.setHwucellHwrnc(hwrnc.getHwrncId());
            ucell.setFdn(obj.params.get(key2));
        }

        ArrayList<String> filters = new ArrayList<>();
        filters.add(key2);
        filters.add(obj.params.get(key2));

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

                String val = getKeyParamsValue(mfr, filters);
                if(val != null){

                    ucell.set(DSL.field(mfr.getMapfieldFieldname()), val);
                }
            }
        }

        // connect to hwnodeb
        CrnodeRecord node = null;

        for (int j = 0; j < hwnodebs.size(); j++) {

            if(hwnodebs.get(j).getNodebname().equals(ucell.getNodebname())){

                ucell.setHwucellHwnodeb(hwnodebs.get(j).getHwnodebId());
                ucell.setHwucellRevenueclass(hwnodebs.get(j).getHwnodebRevenueclass());

                node = nodeCache.get(hwnodebs.get(j).getHwnodebId().longValue());
                break;
            }
        }

        // ADD USMLCCELL:CELLID=11089, RNCID=385, LOGICRNCID=385, ANTENNALATITUDEDEGREE=-7298080,
        // ANTENNALONGITUDEDEGREE=108178220, ANTENNAALTITUDEMETER=0, MAXANTENNARANGE=1, ANTENNAORIENTATION=40,
        // ANTENNAOPENING=65, CELLAVERAGEHEIGHT=0, CELLHEIGHTSTD=50, CELLENVIRONMENT=MIXED_ENVIRONMENT,
        // TXCHANDELAY=0, RXTXCHANDELAY=0, CELLIDRTTACTIVATEFLAG=ACTIVE, OTDOAACTIVATEFLAG=ACTIVE,
        // AGPSACTIVATEFLAG=ACTIVE, CELLLOCCFGTYPE=CELL_ANTENNA, GCDF=DEG, MTRLGY=MET;

        String ANTENNALATITUDEDEGREE, ANTENNALONGITUDEDEGREE;

        final String cellIdLookup = ucell.get("CELLID").toString();
        final String rncIdLookup = ucell.get("LOGICRNCID").toString();

        // if cell id exist, loop for desired cell id
        if(cellIdLookup != null){

            Optional<HuaweiBasicKeyParamsObj> cellLcsObj = USMLCCELLs.stream()
                    .filter(p -> p.params.containsKey("CELLID") && p.params.get("CELLID").equals(cellIdLookup))
                    .filter(p -> p.params.containsKey("LOGICRNCID") && p.params.get("LOGICRNCID").equals(rncIdLookup))
                    .findAny();

            // try for old RNC with no rnc id definition
            if(!cellLcsObj.isPresent()){

                cellLcsObj = USMLCCELLs.stream()
                        .filter(p -> p.params.get("CELLID") != null && p.params.get("CELLID").equals(cellIdLookup))
                        .findFirst();
            }

            if(cellLcsObj.isPresent()){

                // get all cell properties, and calculate the latitude and longitude for the cell
                ANTENNALATITUDEDEGREE = cellLcsObj.get().params.get("ANTENNALATITUDEDEGREE");
                ANTENNALONGITUDEDEGREE = cellLcsObj.get().params.get("ANTENNALONGITUDEDEGREE");

                System.out.println(" -> ANTENNALATITUDEDEGREE: " + ANTENNALATITUDEDEGREE + ", ANTENNALONGITUDEDEGREE: " + ANTENNALONGITUDEDEGREE);

                if(ANTENNALATITUDEDEGREE != null && ANTENNALONGITUDEDEGREE != null){

                    Double latitude = Double.parseDouble(ANTENNALATITUDEDEGREE)/1000000;
                    Double longitude = Double.parseDouble(ANTENNALONGITUDEDEGREE)/1000000;

                    System.out.println(ucell.getCellname() + " -> LAT: " + latitude + ", LON: " + longitude);

                    ucell.setLatitude(latitude.toString());
                    ucell.setLongitude(longitude.toString());
                }
            }
        }

        String cgi = getCGI(ucell.getMcc(), ucell.getMnc(), ucell.getLac(), ucell.getCellid());

        if(cgi != null){

            ucell.setCgi(cgi);

            String bandLookup = "UMTS_" + ucell.getBandind();

            CrcellRecord cellProto = CellUtils.getCellProto(ucell, node);

            // set relation to crcell
            CrcellRecord cell = pgc.getCell(bandLookup, cgi, cellProto, node);

            if(cell != null){

                ucell.setHwucellCell(cell.getCellId());
                ucell.setHwucellCellclass(cell.getCellCellclass());
                ucell.setHwucellCellcoverage(cell.getCellCellcoverage());
                ucell.setHwucellRevenueclass(cell.getCellRevenueclass());
                ucell.setHwucellLatitude(cell.getCellLatitude());
                ucell.setHwucellLongitude(cell.getCellLongitude());

                Double uarfcn = null;

                if(ucell.getUarfcndownlink() != null && !ucell.getUarfcndownlink().isEmpty()){

                    try{
                        uarfcn = Double.parseDouble(ucell.getUarfcndownlink());
                    }catch(Exception e){}
                }

                //CrnodeRecord nodeAlias = pgc.getCellNodeAlias(ucell, ucell, cell.getCellCellclass(), uarfcn, ucell.getCellname(), node);

                String neName = (node != null)?node.getNodeCode(): null;

                CrnodeRecord nodeAlias = pgc.getCellNodeAlias2(meo.mr.getMapentityVendor(), cell.getCellCellclass(), ucell.getCellname(), neName);

                if(nodeAlias != null){
                    ucell.setHwucellNodealias(nodeAlias.getNodeId());
                }
            }
        }

        ucell.setHwucellVendor(me.mr.getMapentityVendor());
        ucell.setHwucellCellstatus(pgc.getCellStatus(ucell.getCellname()));

        ucell.setHwucellCrcollectortaskfiles(ULong.valueOf(this.sf.getTaskFilesId()));

        // set calculated lat lon decimal
//            ucell.setLatitude(GeoUtil.getHuawei3GLat(ucell.getAntennalatitudedegree()));
//            ucell.setLongitude(GeoUtil.getHuawei3GLon(ucell.getAntennalongitudedegree()));

        int result = (ucell.getHwucellId() == null)?ucell.store():ucell.update();

        synchronized (ucells){

            ucells.add(ucell);
        }
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

        this.hwnodebs.clear();
        this.ucells.clear();
        this.nodeCache.clear();

        this.UMTSNODEBs.clear();
        this.UMTSCells.clear();
        this.result.clear();
        this.hwnodebs.clear();
    }
}

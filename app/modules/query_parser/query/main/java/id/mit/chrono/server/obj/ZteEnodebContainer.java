package id.mit.chrono.server.obj;

import id.mit.chrono.server.base.BaseParserGroup;
import id.mit.chrono.server.base.HwBaseContainer;
import id.mit.chrono.server.base.ZteBaseContainer;
import id.mit.chrono.server.enm.PS;
import id.mit.chrono.server.iface.FileProcessor;
import id.mit.chrono.server.iface.ParserGroupCallback;
import id.mit.chrono.server.model.tables.Crnode;
import id.mit.chrono.server.model.tables.records.*;
import id.mit.chrono.server.util.CellUtils;
import id.mit.chrono.server.util.GeoUtil;
import id.mit.chrono.server.util.GsmNetworkUtils;
import org.jooq.DSLContext;
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

public class ZteEnodebContainer extends ZteBaseContainer implements FileProcessor {

    private ArrayList<ZteenodebRecord> zteenodebs = new ArrayList<>();
    private ArrayList<ZtelcellRecord> ztelcells = new ArrayList<>();

    private HashMap<Long, CrnodeRecord> nodeCache = new HashMap();

    List<ZteBasicKeyParamsObj> managedElements;
    List<ZteBasicKeyParamsObj> neManagedElements;
    List<ZteBasicKeyParamsObj> eNBCUCPFunctions;
    List<ZteBasicKeyParamsObj> eNBFunctions;
    List<ZteBasicKeyParamsObj> eUtranCells;
    List<ZteBasicKeyParamsObj> cueUtranCells;
    List<ZteBasicKeyParamsObj> plmns;

    public ZteEnodebContainer(DSLContext db, ParserGroupCallback pgc, ChronoContext context, SourceFile sf, MapEntityObj meo) {
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

        managedElements = result.stream()
                .filter(p -> p.group.equals("ManagedElement"))
                .collect(Collectors.toList());

        logger.debug("managedElements.size(): " + managedElements.size());

        neManagedElements = result.stream()
                .filter(p -> p.group.equals("NEManagedElement"))
                .collect(Collectors.toList());

        logger.debug("neManagedElements.size(): " + neManagedElements.size());

        eNBCUCPFunctions = result.stream()
                .filter(p -> p.group.equals("ENBCUCPFunction"))
                .collect(Collectors.toList());

        logger.debug("eNBCUCPFunctions.size(): " + eNBCUCPFunctions.size());

        eNBFunctions = result.stream()
                .filter(p -> p.group.matches("ENBFunction[A-Z]{3,5}"))
                .collect(Collectors.toList());

        logger.debug("eNBFunctions.size(): " + eNBFunctions.size());

        eUtranCells = result.stream()
                .filter(p -> p.group.matches("EUtranCell[A-Z]{3,5}"))
                .collect(Collectors.toList());

        logger.debug("eUtranCells.size(): " + eUtranCells.size());

        cueUtranCells = result.stream()
                .filter(p -> p.group.matches("CUEUtranCell(FDDLTE|TDDLTE|NBIoT)"))
                .collect(Collectors.toList());

        logger.debug("cueUtranCells.size(): " + cueUtranCells.size());

        plmns = result.stream()
                .filter(p -> p.group.equals("Plmn"))
                .collect(Collectors.toList());

        logger.debug("plmns.size(): " + plmns.size());

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

        eNBFunctions.stream().forEach(objx -> processENodeB(db, meo, objx));
        eNBCUCPFunctions.parallelStream().forEach(objx -> processENodeB2(db, meo, objx));

        logger.debug("prepareENodeB() done");
    }

    private void processENodeB(DSLContext db, MapEntityObj me, ZteBasicKeyParamsObj obj){

        CrmapfieldRecord mfr;

        String key = "MOI";

        String key2 = "SubNetwork";
        String key3 = "MEID";
        String key4 = "eNBId";
//        String key4 = obj.group;

        String key6 = "eNBId";
        String key7 = "mcc";
        String key8 = "mnc";
        String key9 = "userLabel";

        String refplmn;

        String MOI = obj.params.get(key);

        if(MOI == null){
            logger.debug("switched from " + key + " to ldn");
            key = "ldn";
            MOI = obj.params.get(key);
        }

        String SubNetwork = obj.params.get(key2);

        String MEID = obj.params.get(key3);
        if(MEID == null){
            logger.debug("switched from " + key3 + " to moId");
            key3 = "moId";
            MEID = obj.params.get(key3);
        }

        String eNBId = obj.params.get(key4);

        ZteenodebRecord zteenodeb = db.selectFrom(ZTEENODEB)
                .where(ZTEENODEB.ZTEENODEB_DATE.eq(UInteger.valueOf(context.getEpochTime())))
                .and(ZTEENODEB.SUBNETWORK.eq(SubNetwork))
                .and(ZTEENODEB.MEID.eq(MEID))
                .and(ZTEENODEB.ENBID.eq(eNBId))
                .fetchAny();

        if(zteenodeb == null){

            zteenodeb = db.newRecord(ZTEENODEB);

            zteenodeb.setZteenodebDate(UInteger.valueOf(context.getEpochTime()));
            zteenodeb.setSubnetwork(SubNetwork);
            zteenodeb.setMeid(MEID);
            zteenodeb.setEnbid(eNBId);
        }

        ArrayList<String> filters = new ArrayList<>();
        filters.add(key);
        filters.add(obj.params.get(key));

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

                    zteenodeb.set(DSL.field(mfr.getMapfieldFieldname()), replaceVal);
                }
            }
            else{

//                String val = getKeyParamsValue(mfr, filters);
                String val = obj.params.get(mfr.getMapfieldSourceparam());

                if(val == null){

                    String finalKey1 = key;
                    String finalMOI = MOI;
                    Optional<ZteBasicKeyParamsObj> objx = neManagedElements.parallelStream().filter(o -> o.params.get(finalKey1).equals(finalMOI)).findFirst();

                    if(objx.isPresent()){
                        val = objx.get().params.get(mfr.getMapfieldSourceparam());
                    }
                }

                if(val != null){

                    zteenodeb.set(DSL.field(mfr.getMapfieldFieldname()), val);
                }
            }
        }


        System.out.println("XC");
        // set relation to crnode
        CrnodeRecord node = pgc.getNode(meo.mr.getMapentityVendor(), zteenodeb.getUserlabel(), meo.mr.getMapentityNodecategory());
        System.out.println("XX");

        if(node == null){
            System.out.println("XC2");
            node = pgc.getNode(meo.mr.getMapentityVendor(), zteenodeb.getEnbname(), meo.mr.getMapentityNodecategory());
            System.out.println("XX2");
        }

        if(node == null){
            System.out.println("XC3");
            node = pgc.getNode(meo.mr.getMapentityVendor(), zteenodeb.getLocationname(), meo.mr.getMapentityNodecategory());
            System.out.println("XX3");
        }

        final String eNbMoi = zteenodeb.getMoi();

        // if still null, try from cell level
//        String finalKey = key;

//        List<ZteBasicKeyParamsObj> cells = eUtranCells.stream()
//                .filter(p -> p.params.containsKey(finalKey) && p.params.get(finalKey).startsWith(eNbMoi))
//                .collect(Collectors.toList());
//
//        for (int i = 0; node == null && i < cells.size(); i++) {
//            node = pgc.getNode(meo.mr.getMapentityVendor(), cells.get(i).params.get(key9), meo.mr.getMapentityNodecategory());
//        }

        if(node != null){

            zteenodeb.setZteenodebNode(node.getNodeId());
            zteenodeb.setZteenodebRevenueclass(node.getNodeRevenueclass());
        }

        System.out.println("XC4");
        // set PLMN
        for (int j = 0; j < plmns.size(); j++) {

            refplmn = zteenodeb.getRefplmn();

            if(refplmn != null && refplmn.equals(plmns.get(j).params.get(key))){

                zteenodeb.setMcc(plmns.get(j).params.get(key7));
                zteenodeb.setMnc(plmns.get(j).params.get(key8));
                break;
            }
        }

        System.out.println("XX4");

        int totalCell = 0;

//        String temp;
//
//        for (int j = 0; j < eUtranCells.size(); j++) {
//
//            temp = zteenodeb.getMoi() + ",";
//
//            if(eUtranCells.get(j).params.get(key).startsWith(temp)){
//
//                totalCell++;
//            }
//        }

//        zteenodeb.setTotalcell(cells.size());

        zteenodeb.setZteenodebNodestatus(pgc.getNodeStatus(zteenodeb.getUserlabel()));
        zteenodeb.setZteenodebCrcollectortaskfiles(ULong.valueOf(this.sf.getTaskFilesId()));

        System.out.println("XC5");
        int res = (zteenodeb.getZteenodebId() == null)?zteenodeb.store():zteenodeb.update();
        System.out.println("XX5");

        if(node != null){

            synchronized (nodeCache){

                nodeCache.put(zteenodeb.getZteenodebId().longValue(), node);
            }
        }
        synchronized (zteenodebs){

            zteenodebs.add(zteenodeb);
        }
    }

    private void processENodeB2(DSLContext db, MapEntityObj me, ZteBasicKeyParamsObj obj){

        CrmapfieldRecord mfr;

        String key = "ldn";

        String key2 = "SubNetwork";
        String key3 = "ManagedElement";
        String key4 = "eNBId";

        String key9 = "userLabel";

        String ldn = obj.params.get(key);
        String SubNetwork = obj.params.get(key2);
        String MEID = obj.params.get(key3);
        String eNBId = obj.params.get(key4);

        ZteenodebRecord zteenodeb = db.selectFrom(ZTEENODEB)
                .where(ZTEENODEB.ZTEENODEB_DATE.eq(UInteger.valueOf(context.getEpochTime())))
//                .and(ZTEENODEB.ZTEENODEB_CRCOLLECTORTASKFILES.eq(ULong.valueOf(this.sf.getTaskFilesId())))
                .and(ZTEENODEB.SUBNETWORK.eq(SubNetwork))
                .and(ZTEENODEB.MEID.eq(MEID))
                .and(ZTEENODEB.ENBID.eq(eNBId))
                .fetchAny();

        if(zteenodeb == null){

            zteenodeb = db.newRecord(ZTEENODEB);

            zteenodeb.setZteenodebDate(UInteger.valueOf(context.getEpochTime()));
            zteenodeb.setSubnetwork(SubNetwork);
            zteenodeb.setMeid(MEID);
            zteenodeb.setEnbid(eNBId);
        }

        ArrayList<String> filters = new ArrayList<>();
        filters.add(key);
        filters.add(ldn);

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

                    zteenodeb.set(DSL.field(mfr.getMapfieldFieldname()), replaceVal);
                }
            }
            else{

//                String val = getKeyParamsValue(mfr, filters);
                String val = obj.params.get(mfr.getMapfieldSourceparam());

                if(val == null){

                    Optional<ZteBasicKeyParamsObj> objx = managedElements.parallelStream().filter(o -> o.params.get(key).equals(ldn)).findFirst();

                    if(objx.isPresent()){
                        val = objx.get().params.get(mfr.getMapfieldSourceparam());
                    }
                }

                if(val != null){

                    zteenodeb.set(DSL.field(mfr.getMapfieldFieldname()), val);
                }
            }
        }

        // set relation to crnode
        CrnodeRecord node = pgc.getNode(meo.mr.getMapentityVendor(), zteenodeb.getUserlabel(), meo.mr.getMapentityNodecategory());

        if(node == null){
            node = pgc.getNode(meo.mr.getMapentityVendor(), zteenodeb.getEnbname(), meo.mr.getMapentityNodecategory());
        }

        if(node == null){
            node = pgc.getNode(meo.mr.getMapentityVendor(), zteenodeb.getLocationname(), meo.mr.getMapentityNodecategory());
        }

//        final String ldn = zteenodeb.getMoi();

        zteenodeb.setMoi(ldn);


        // if still null, try from cell level
        List<ZteBasicKeyParamsObj> cells = cueUtranCells.stream()
                .filter(p -> p.params.get(key).startsWith(ldn + ","))
                .collect(Collectors.toList());

        for (int i = 0; node == null && i < cells.size(); i++) {
            node = pgc.getNode(meo.mr.getMapentityVendor(), cells.get(i).params.get(key9), meo.mr.getMapentityNodecategory());
        }

        if(node != null){

            zteenodeb.setZteenodebNode(node.getNodeId());
            zteenodeb.setZteenodebRevenueclass(node.getNodeRevenueclass());
        }

        // set lat-lon from ManagedElement

        Optional<ZteBasicKeyParamsObj> meObj = managedElements.stream().filter(o -> o.params.get(key3).equals(MEID)).findFirst();

        if(meObj.isPresent()){

            ZteBasicKeyParamsObj objx = meObj.get();

            zteenodeb.setLongitude(objx.params.get("longitude"));
            zteenodeb.setLatitude(objx.params.get("latitude"));
        }

        zteenodeb.setTotalcell(cells.size());

        zteenodeb.setZteenodebNodestatus(pgc.getNodeStatus(zteenodeb.getUserlabel()));
        zteenodeb.setZteenodebCrcollectortaskfiles(ULong.valueOf(this.sf.getTaskFilesId()));

        int res = (zteenodeb.getZteenodebId() == null)?zteenodeb.store():zteenodeb.update();

        if(node != null){

            synchronized (nodeCache){

                nodeCache.put(zteenodeb.getZteenodebId().longValue(), node);
            }
        }
        synchronized (zteenodebs){

            zteenodebs.add(zteenodeb);
        }
    }

    private void prepareENodeBCell(DSLContext db){

        logger.debug("prepareENodeBCell()");

        // get field definition for hwbts
        MapEntityObj me = meo.getChildEntityByTableName("ztelcell");

        eUtranCells.parallelStream().forEach(obj -> processCell(db, me, obj));
        cueUtranCells.parallelStream().forEach(obj -> processCell2(db, me, obj));

        logger.debug("prepareENodeBCell() done");
    }

    private void processCell(DSLContext db, MapEntityObj me, ZteBasicKeyParamsObj obj){

        CrmapfieldRecord mfr;

        String key = "MOI";

        String key2 = "SubNetwork";
        String key3 = "MEID";

        // default: FDD
        String key4 = "ENBFunctionFDD";
        String key5 = "EUtranCellFDD";

        String key10 = "mcc";
        String key11 = "mnc";

        String temp;

        if(obj.group.equalsIgnoreCase("EUtranCellTDD")){

            key4 = "ENBFunctionTDD";
            key5 = "EUtranCellTDD";
        }
        else if(obj.group.equalsIgnoreCase("EUtranCellNBIoT")){

            key4 = "ENBFunctionNBIoT";
            key5 = "EUtranCellNBIoT";
        }

        String MOI = obj.params.get(key);

        if(MOI == null){

            key = "ldn";
            MOI = obj.params.get(key);
        }

        String SubNetwork = obj.params.get(key2);

        String MEID = obj.params.get(key3);
        if(MEID == null){
            key3 = "moId";
            MEID = obj.params.get(key3);
        }

        String ENBFunction = obj.params.get(key4);
        String EUtranCell = obj.params.get(key5);

        // set relation to eNodeB
        ZteenodebRecord enodeb = this.geteNodeB(MOI, SubNetwork, MEID, ENBFunction);

        if(enodeb == null){
            return;
        }

        ZtelcellRecord ztelcell = db.selectFrom(ZTELCELL)
                .where(ZTELCELL.ZTELCELL_DATE.eq(UInteger.valueOf(context.getEpochTime())))
                .and(ZTELCELL.ZTELCELL_ZTEENODEB.eq(enodeb.getZteenodebId()))
                .and(ZTELCELL.EUTRANCELL.eq(EUtranCell))
                .fetchOne();

        if(ztelcell == null){

            ztelcell = db.newRecord(ZTELCELL);

            ztelcell.setZtelcellDate(UInteger.valueOf(context.getEpochTime()));
            ztelcell.setZtelcellZteenodeb(enodeb.getZteenodebId());
            ztelcell.setEutrancell(EUtranCell);
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
                    case "PARENTKEY": replaceVal = "XXX"; break;
                    default: break;
                }

                if(replaceVal != null){

                    ztelcell.set(DSL.field(mfr.getMapfieldFieldname()), replaceVal);
                }
            }
            else{

//                String value = getKeyParamsValue(mfr, filters);
                String value = obj.params.get(mfr.getMapfieldSourceparam());

                if(value != null){

                    ztelcell.set(DSL.field(mfr.getMapfieldFieldname()), value);
                }
            }
        }

        // force enodeb id
        ztelcell.setEnbid(enodeb.getEnbid());

        // set plmn
        // set PLMN
        for (int j = 0; j < plmns.size(); j++) {

            if(ztelcell.getRefplmn().equals(plmns.get(j).params.get(key))){

                ztelcell.setMcc(plmns.get(j).params.get(key10));
                ztelcell.setMnc(plmns.get(j).params.get(key11));

                break;
            }
        }

        int eci = GsmNetworkUtils.getLteEci(ztelcell.getEnbid(), ztelcell.getCelllocalid());

        String ecgi = getECGI(ztelcell.getMcc(), ztelcell.getMnc(), String.valueOf(eci));

        if(ecgi != null){

            String genodebid = ztelcell.getMcc() + "-" + ztelcell.getMnc() + "-" + ztelcell.getEnbid();
            long tai = GsmNetworkUtils.getLteTai(ztelcell.getMcc(), ztelcell.getMnc(), ztelcell.getTac());

            ztelcell.setEci(String.valueOf(eci));
            ztelcell.setEcgi(ecgi);
            ztelcell.setGlobalenbid(genodebid);
            ztelcell.setTai(String.valueOf(tai));
        }

        if(ztelcell.getFreqbandind() != null && ztelcell.getFreqbandind().equals("40")){

            Double earfcnDl = (38650+10*(Double.parseDouble(ztelcell.get(DSL.field("earfcn")).toString())-2300));

            ztelcell.setEarfcndl(earfcnDl);
        }

        String lookup = "LTE_Band" + ztelcell.getFreqbandind();

        // set relation to crnode
        if(lookup != null){

            CrnodeRecord node = nodeCache.get(enodeb.getZteenodebId());

            CrcellRecord cellProto = CellUtils.getCellProto(ztelcell, node);

            // cellName, Object latitude, Object longitude,
            CrcellRecord cell = pgc.getCell(lookup, ztelcell.getEcgi(), cellProto, node);

            if(cell != null){
                ztelcell.setZtelcellCell(cell.getCellId());
                ztelcell.setZtelcellCellclass(cell.getCellCellclass());
                ztelcell.setZtelcellCellcoverage(cell.getCellCellcoverage());
                ztelcell.setZtelcellRevenueclass(cell.getCellRevenueclass());
                ztelcell.setZtelcellLatitude(cell.getCellLatitude());
                ztelcell.setZtelcellLongitude(cell.getCellLongitude());

                Double earfcn = null;

                if(ztelcell.get(DSL.field("earfcn")) != null){
                    earfcn = Double.parseDouble(ztelcell.get(DSL.field("earfcn")).toString());
                }

//                CrnodeRecord nodeAlias = pgc.getCellNodeAlias(ztelcell, ztelcell, cell.getCellCellclass(), earfcn, ztelcell.getUserlabel(), node);

                String neName = (node != null)?node.getNodeCode(): null;

                CrnodeRecord nodeAlias = pgc.getCellNodeAlias2(meo.mr.getMapentityVendor(), cell.getCellCellclass(), ztelcell.getUserlabel(), neName);

                if(nodeAlias != null){
                    ztelcell.setZtelcellNodealias(nodeAlias.getNodeId());
                }
            }
        }

        ztelcell.setZtelcellCrcollectortaskfiles(ULong.valueOf(this.sf.getTaskFilesId()));

        ztelcell.setZtelcellVendor(meo.mr.getMapentityVendor());
        ztelcell.setZtelcellCellstatus(pgc.getCellStatus(ztelcell.getUserlabel()));

        int res = (ztelcell.getZtelcellId() == null)?ztelcell.store():ztelcell.update();

        synchronized (ztelcells){
            ztelcells.add(ztelcell);
        }
    }

    private void processCell2(DSLContext db, MapEntityObj me, ZteBasicKeyParamsObj obj){

        CrmapfieldRecord mfr;

        String key = "ldn";

        String key2 = "SubNetwork";
        String key3 = "ManagedElement";
        String key4 = "moId";

        String key9 = "eNBId";
        String key10 = "mcc";
        String key11 = "mnc";

        String temp;

        String MOI = obj.params.get(key);
        String SubNetwork = obj.params.get(key2);
        String MEID = obj.params.get(key3);
        String moId = obj.params.get(key4);

        // set relation to eNodeB
        ZteenodebRecord enodeb = this.geteNodeB(MOI, SubNetwork, MEID, null);

        if(enodeb == null){
            return;
        }

        ZtelcellRecord ztelcell = db.selectFrom(ZTELCELL)
                .where(ZTELCELL.ZTELCELL_DATE.eq(UInteger.valueOf(context.getEpochTime())))
                .and(ZTELCELL.ZTELCELL_CRCOLLECTORTASKFILES.eq(ULong.valueOf(this.sf.getTaskFilesId())))
                .and(ZTELCELL.ZTELCELL_ZTEENODEB.eq(enodeb.getZteenodebId()))
                .and(ZTELCELL.EUTRANCELL.eq(moId))
                .fetchOne();

        if(ztelcell == null){

            ztelcell = db.newRecord(ZTELCELL);

            ztelcell.setZtelcellDate(UInteger.valueOf(context.getEpochTime()));
            ztelcell.setZtelcellZteenodeb(enodeb.getZteenodebId());
            ztelcell.setEutrancell(moId);
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
                    case "PARENTKEY": replaceVal = "XXX"; break;
                    default: break;
                }

                if(replaceVal != null){

                    ztelcell.set(DSL.field(mfr.getMapfieldFieldname()), replaceVal);
                }
            }
            else{

//                String value = getKeyParamsValue(mfr, filters);
                String value = obj.params.get(mfr.getMapfieldSourceparam());

                if(value != null){

                    ztelcell.set(DSL.field(mfr.getMapfieldFieldname()), value);
                }
            }
        }

        // force enodeb id
        ztelcell.setEnbid(enodeb.getEnbid());

        ztelcell.setMcc(enodeb.getMcc());
        ztelcell.setMnc(enodeb.getMnc());

        int eci = GsmNetworkUtils.getLteEci(ztelcell.getEnbid(), ztelcell.getCelllocalid());

        String ecgi = getECGI(ztelcell.getMcc(), ztelcell.getMnc(), String.valueOf(eci));

        if(ecgi != null){

            String genodebid = ztelcell.getMcc() + "-" + ztelcell.getMnc() + "-" + ztelcell.getEnbid();
            long tai = GsmNetworkUtils.getLteTai(ztelcell.getMcc(), ztelcell.getMnc(), ztelcell.getTac());

            ztelcell.setEci(String.valueOf(eci));
            ztelcell.setEcgi(ecgi);
            ztelcell.setGlobalenbid(genodebid);
            ztelcell.setTai(String.valueOf(tai));
        }

        if(ztelcell.getFreqbandind() != null && ztelcell.getFreqbandind().equals("40")){

            Double earfcnDl = (38650+10*(Double.parseDouble(ztelcell.get(DSL.field("earfcn")).toString())-2300));

            ztelcell.setEarfcndl(earfcnDl);
        }

        String lookup = "LTE_Band" + ztelcell.getFreqbandind();

        // set relation to crnode
        if(lookup != null){

            CrnodeRecord node = nodeCache.get(enodeb.getZteenodebId());

            CrcellRecord cellProto = CellUtils.getCellProto(ztelcell, node);

            // cellName, Object latitude, Object longitude,
            CrcellRecord cell = pgc.getCell(lookup, ztelcell.getEcgi(), cellProto, node);

            if(cell != null){
                ztelcell.setZtelcellCell(cell.getCellId());
                ztelcell.setZtelcellCellclass(cell.getCellCellclass());
                ztelcell.setZtelcellCellcoverage(cell.getCellCellcoverage());
                ztelcell.setZtelcellRevenueclass(cell.getCellRevenueclass());
                ztelcell.setZtelcellLatitude(cell.getCellLatitude());
                ztelcell.setZtelcellLongitude(cell.getCellLongitude());

                Double earfcn = null;

                if(ztelcell.get(DSL.field("earfcn")) != null){
                    earfcn = Double.parseDouble(ztelcell.get(DSL.field("earfcn")).toString());
                }

//                CrnodeRecord nodeAlias = pgc.getCellNodeAlias(ztelcell, ztelcell, cell.getCellCellclass(), earfcn, ztelcell.getUserlabel(), node);

                String neName = (node != null)?node.getNodeCode(): null;

                CrnodeRecord nodeAlias = pgc.getCellNodeAlias2(meo.mr.getMapentityVendor(), cell.getCellCellclass(), ztelcell.getUserlabel(), neName);

                if(nodeAlias != null){
                    ztelcell.setZtelcellNodealias(nodeAlias.getNodeId());
                }
            }
        }

        ztelcell.setZtelcellCrcollectortaskfiles(ULong.valueOf(this.sf.getTaskFilesId()));

        ztelcell.setZtelcellVendor(meo.mr.getMapentityVendor());
        ztelcell.setZtelcellCellstatus(pgc.getCellStatus(ztelcell.getUserlabel()));

        int res = (ztelcell.getZtelcellId() == null)?ztelcell.store():ztelcell.update();

        synchronized (ztelcells){
            ztelcells.add(ztelcell);
        }
    }

    private ZteenodebRecord geteNodeB(String MOI, String SubNetwork, String MEID, String ENBFunction){

        for (int i = 0; i < zteenodebs.size(); i++) {

            if(MOI.startsWith(zteenodebs.get(i).getMoi()+",")){
                return zteenodebs.get(i);
            }
//            if(zteenodebs.get(i).getSubnetwork().equals(SubNetwork) && zteenodebs.get(i).getMeid().equals(MEID) && zteenodebs.get(i).getEnbid().equals(ENBFunction)){
//
//                return zteenodebs.get(i);
//            }
        }

        return null;
    }

    private void clearUnusedData(DSLContext db){

        sf.purgeResult();
        this.result.clear();
    }
}

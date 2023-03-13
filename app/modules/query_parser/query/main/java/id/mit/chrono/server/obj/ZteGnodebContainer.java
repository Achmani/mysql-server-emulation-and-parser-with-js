package id.mit.chrono.server.obj;

import id.mit.chrono.server.base.ZteBaseContainer;
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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static id.mit.chrono.server.model.Tables.*;

public class ZteGnodebContainer extends ZteBaseContainer implements FileProcessor {

    private ArrayList<ZtegnodebRecord> ztegnodebs = new ArrayList<>();
    private ArrayList<ZtencellRecord> ztencells = new ArrayList<>();

    private HashMap<Long, CrnodeRecord> nodeCache = new HashMap();

    List<ZteBasicKeyParamsObj> managedElements;
    List<ZteBasicKeyParamsObj> neManagedElements;
    List<ZteBasicKeyParamsObj> gNBCUCPFunctions;
    List<ZteBasicKeyParamsObj> nrCellCus;
    List<ZteBasicKeyParamsObj> NRPhysicalCellDUs;
    List<ZteBasicKeyParamsObj> NRCarriers;
    List<ZteBasicKeyParamsObj> CarrierDLs;
    List<ZteBasicKeyParamsObj> CarrierULs;
    List<ZteBasicKeyParamsObj> plmns;

    public ZteGnodebContainer(DSLContext db, ParserGroupCallback pgc, ChronoContext context, SourceFile sf, MapEntityObj meo) {
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

        gNBCUCPFunctions = result.stream()
                .filter(p -> p.group.equals("GNBCUCPFunction"))
                .collect(Collectors.toList());

        logger.debug("gNBCUCPFunctions.size(): " + gNBCUCPFunctions.size());

        nrCellCus = result.stream()
                .filter(p -> p.group.equals("NRCellCU"))
                .collect(Collectors.toList());

        logger.debug("nrCellCus.size(): " + nrCellCus.size());

        NRPhysicalCellDUs = result.stream()
                .filter(p -> p.group.equals("NRPhysicalCellDU"))
                .collect(Collectors.toList());

        logger.debug("NRPhysicalCellDUs.size(): " + NRPhysicalCellDUs.size());

        NRCarriers = result.stream()
                .filter(p -> p.group.equals("NRCarrier"))
                .collect(Collectors.toList());

        logger.debug("NRCarriers.size(): " + NRCarriers.size());

        CarrierDLs = result.stream()
                .filter(p -> p.group.equals("CarrierDL"))
                .collect(Collectors.toList());

        logger.debug("CarrierDLs.size(): " + CarrierDLs.size());

        CarrierULs = result.stream()
                .filter(p -> p.group.equals("CarrierUL"))
                .collect(Collectors.toList());

        logger.debug("CarrierULs.size(): " + CarrierULs.size());

        plmns = result.stream()
                .filter(p -> p.group.equals("Plmn"))
                .collect(Collectors.toList());

        logger.debug("plmns.size(): " + plmns.size());

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

    private void prepareGNodeB(DSLContext db){

        logger.debug("prepareGNodeB()");

        gNBCUCPFunctions.parallelStream().forEach(objx -> processGNodeB(db, meo, objx));

        logger.debug("prepareGNodeB() done");
    }

    private void processGNodeB(DSLContext db, MapEntityObj me, ZteBasicKeyParamsObj obj){

        CrmapfieldRecord mfr;

        String key = "ldn";
        String key2 = "ManagedElement";
        String key3 = "userLabel";

        String refplmn;

        String ldn = obj.params.get(key);
        String managedElement = obj.params.get(key2);

        ZtegnodebRecord ztegnodeb = db.selectFrom(ZTEGNODEB)
                .where(ZTEGNODEB.ZTEGNODEB_DATE.eq(UInteger.valueOf(context.getEpochTime())))
                .and(ZTEGNODEB.LDN.eq(ldn))
                .fetchAny();

        if(ztegnodeb == null){

            ztegnodeb = db.newRecord(ZTEGNODEB);

            ztegnodeb.setZtegnodebDate(UInteger.valueOf(context.getEpochTime()));
            ztegnodeb.setLdn(ldn);
        }

        ArrayList<String> filters = new ArrayList<>();
        filters.add(key2);
        filters.add(obj.params.get(key2));

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

                    ztegnodeb.set(DSL.field(mfr.getMapfieldFieldname()), replaceVal);
                }
            }
            else{

                String val = getKeyParamsValue(mfr, filters);
//                String val = obj.params.get(mfr.getMapfieldFieldname());
//
//                if(val == null){
//
//                    Optional<ZteBasicKeyParamsObj> objx = neManagedElements.parallelStream().filter(o -> o.params.get(key).equals(MOI)).findFirst();
//
//                    if(objx.isPresent()){
//                        val = objx.get().params.get(mfr.getMapfieldFieldname());
//                    }
//                }

                if(val != null){

                    ztegnodeb.set(DSL.field(mfr.getMapfieldFieldname()), val);
                }
            }
        }

        // set relation to crnode
        CrnodeRecord node = pgc.getNode(meo.mr.getMapentityVendor(), ztegnodeb.getUserlabel(), meo.mr.getMapentityNodecategory());

        if(node == null){
            node = pgc.getNode(meo.mr.getMapentityVendor(), ztegnodeb.getUserlabel(), meo.mr.getMapentityNodecategory());
        }

        if(node == null){
            node = pgc.getNode(meo.mr.getMapentityVendor(), ztegnodeb.getUserlabel(), meo.mr.getMapentityNodecategory());
        }

        final String gNbLdn = ztegnodeb.getLdn();

        // if still null, try from cell level
        List<ZteBasicKeyParamsObj> cells = nrCellCus.stream()
                .filter(p -> p.params.get(key).startsWith(gNbLdn + ","))
                .collect(Collectors.toList());

        ztegnodeb.setTotalcell(cells.size());

        for (int i = 0; node == null && i < cells.size(); i++) {
            node = pgc.getNode(meo.mr.getMapentityVendor(), cells.get(i).params.get(key3), meo.mr.getMapentityNodecategory());
        }

        if(node != null){

            ztegnodeb.setZtegnodebNode(node.getNodeId());
            ztegnodeb.setZtegnodebRevenueclass(node.getNodeRevenueclass());
        }

        // set PLMN
//        for (int j = 0; j < plmns.size(); j++) {
//
//            refplmn = zteenodeb.getRefplmn();
//
//            if(refplmn != null && refplmn.equals(plmns.get(j).params.get(key))){
//
//                zteenodeb.setMcc(plmns.get(j).params.get(key7));
//                zteenodeb.setMnc(plmns.get(j).params.get(key8));
//                break;
//            }
//        }

//        zteenodeb.setZteenodebNodestatus(pgc.getNodeStatus(ztegnodeb.getUserlabel()));
        ztegnodeb.setZtegnodebCrcollectortaskfiles(ULong.valueOf(this.sf.getTaskFilesId()));
        ztegnodeb.setZtegnodebVendor(meo.mr.getMapentityVendor());


        int res = (ztegnodeb.getZtegnodebId() == null)?ztegnodeb.store():ztegnodeb.update();

        if(node != null){

            synchronized (nodeCache){

                nodeCache.put(Long.parseLong(ztegnodeb.getGnbid()), node);
            }
        }

        synchronized (ztegnodebs){

            ztegnodebs.add(ztegnodeb);
        }
    }

    private void prepareGNodeBCell(DSLContext db){

        logger.debug("prepareGNodeBCell()");

        // get field definition for hwbts
        MapEntityObj me = meo.getChildEntityByTableName("ztencell");

        nrCellCus.parallelStream().forEach(obj -> processCell(db, me, obj));

        logger.debug("prepareGNodeBCell() done");
    }

    private void processCell(DSLContext db, MapEntityObj me, ZteBasicKeyParamsObj obj){

        CrmapfieldRecord mfr;

        String key = "ldn";

        String key2 = "ManagedElement";

        String temp;

        String ldn = obj.params.get(key);
        String managedElement = obj.params.get(key2);

        // set relation to eNodeB
        ZtegnodebRecord gnodeb = this.getgNodeB(ldn);

        if(gnodeb == null){
            return;
        }

        ZtencellRecord ztencell = db.selectFrom(ZTENCELL)
                .where(ZTENCELL.ZTENCELL_DATE.eq(UInteger.valueOf(context.getEpochTime())))
                .and(ZTENCELL.ZTENCELL_ZTEGNODEB.eq(gnodeb.getZtegnodebId()))
                .and(ZTENCELL.LDN.eq(ldn))
                .fetchOne();

        if(ztencell == null){

            ztencell = db.newRecord(ZTENCELL);

            ztencell.setZtencellDate(UInteger.valueOf(context.getEpochTime()));
            ztencell.setZtencellZtegnodeb(gnodeb.getZtegnodebId());
            ztencell.setLdn(ldn);
        }

        ArrayList<String> filters = new ArrayList<>();
        filters.add(key2);
        filters.add(managedElement);

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

                    ztencell.set(DSL.field(mfr.getMapfieldFieldname()), replaceVal);
                }
            }
            else{

                String value = obj.params.get(mfr.getMapfieldSourceparam());

                if(value == null){
                    value = getKeyParamsValue(mfr, filters);
                }

                if(value != null){

                    ztencell.set(DSL.field(mfr.getMapfieldFieldname()), value);
                }
            }
        }

//        System.out.println("gnodeb.getGnbid(): " + gnodeb.getGnbid());
//        System.out.println("ztencell.getCelllocalid(): " + ztencell.getCelllocalid());
//        System.out.println("----------------");

        int nci = GsmNetworkUtils.getNrNci(gnodeb.getGnbid(), ztencell.getCelllocalid());

        String plmnIdList = ztencell.getPlmnidlist();
        String[] plmnIdListEls = plmnIdList.split("-");
        String mcc = plmnIdListEls[0];
        String mnc = plmnIdListEls[1];

        String ncgi = getNCGI(mcc, mnc, String.valueOf(nci));

        ztencell.setGnbid(gnodeb.getGnbid());
        ztencell.setMcc(mcc);
        ztencell.setMnc(mnc);

        if (ncgi != null) {

            ztencell.setNci(String.valueOf(nci));
            ztencell.setNcgi(ncgi);
        }

//        if(ztelcell.getFreqbandind() != null && ztelcell.getFreqbandind().equals("40")){
//
//            Double earfcnDl = (38650+10*(Double.parseDouble(ztelcell.get(DSL.field("earfcn")).toString())-2300));
//
//            ztelcell.setEarfcndl(earfcnDl);
//        }

        Optional<ZteBasicKeyParamsObj> NRPhysicalCellDU = NRPhysicalCellDUs.stream().filter(o -> o.params.get("nrPhysicalCellDUId").equals(obj.params.get("nrPhysicalCellDUId"))).findFirst();

        if(NRPhysicalCellDU.isPresent()){

            String refNRCarrier = NRPhysicalCellDU.get().params.get("refNRCarrier");

            Optional<ZteBasicKeyParamsObj> NRCarrier = NRCarriers.stream().filter(o -> o.params.get("ldn").equals(refNRCarrier)).findFirst();

            if(NRCarrier.isPresent()){

                // set carriertype
                ztencell.setNrcarriertype(NRCarrier.get().params.get("nrCarrierType"));

                Optional<ZteBasicKeyParamsObj> CarrierDL = CarrierDLs.stream().filter(o -> o.params.get("ldn").startsWith(refNRCarrier + ",")).findFirst();

                if(CarrierDL.isPresent()){

                    ztencell.setFrequency(CarrierDL.get().params.get("frequency"));
                    ztencell.setFrequencydl(CarrierDL.get().params.get("frequency"));
                    ztencell.setPointafrequencydl(CarrierDL.get().params.get("pointAfrequencyDL"));
                    ztencell.setNrbandwidth(CarrierDL.get().params.get("nrbandwidth"));
                    ztencell.setFrequencybandlist(CarrierDL.get().params.get("frequencyBandList"));
                }

                Optional<ZteBasicKeyParamsObj> CarrierUL = CarrierULs.stream().filter(o -> o.params.get("ldn").startsWith(refNRCarrier + ",")).findFirst();

                if(CarrierUL.isPresent()){

                    ztencell.setFrequencyul(CarrierUL.get().params.get("frequency"));
                    ztencell.setPointafrequencyul(CarrierUL.get().params.get("pointAfrequencyDL"));
                }
            }
        }

        String lookup = "NR_n" + ztencell.getFrequencybandlist();

        // set relation to crnode
        if(lookup != null){

            CrnodeRecord node = nodeCache.get(gnodeb.getGnbid());

            CrcellRecord cellProto = CellUtils.getCellProto(ztencell, node);

            // cellName, Object latitude, Object longitude,
            CrcellRecord cell = pgc.getCell(lookup, ztencell.getNcgi(), cellProto, node);

            if(cell != null){

                ztencell.setZtencellCell(cell.getCellId());
                ztencell.setZtencellCellclass(cell.getCellCellclass());
                ztencell.setZtencellCellcoverage(cell.getCellCellcoverage());
                ztencell.setZtencellRevenueclass(cell.getCellRevenueclass());
                ztencell.setZtencellLatitude(cell.getCellLatitude());
                ztencell.setZtencellLongitude(cell.getCellLongitude());

                Double nrarfcn = null;

                if(ztencell.get(DSL.field("NRARFCN")) != null){
                    nrarfcn = Double.parseDouble(ztencell.get(DSL.field("NRARFCN")).toString());
                }

                if(ztencell.get(DSL.field("NRARFCNDL")) != null){
                    nrarfcn = Double.parseDouble(ztencell.get(DSL.field("NRARFCNDL")).toString());
                }

                String neName = (node != null)?node.getNodeCode(): null;

                CrnodeRecord nodeAlias = pgc.getCellNodeAlias2(meo.mr.getMapentityVendor(), cell.getCellCellclass(), ztencell.getUserlabel(), neName);

                if(nodeAlias != null){
                    ztencell.setZtencellNodealias(nodeAlias.getNodeId());
                }
            }
        }

        ztencell.setZtencellCrcollectortaskfiles(ULong.valueOf(this.sf.getTaskFilesId()));
        ztencell.setZtencellVendor(meo.mr.getMapentityVendor());

//        ztencell.setZtencellCellstatus(pgc.getCellStatus(ztencell.stat));

        int res = (ztencell.getZtencellId() == null)?ztencell.store():ztencell.update();

        synchronized (ztencells){
            ztencells.add(ztencell);
        }
    }

    private ZtegnodebRecord getgNodeB(String ldn){

        for (int i = 0; i < ztegnodebs.size(); i++) {

            if(ldn.startsWith(ztegnodebs.get(i).getLdn() + ",")){
                return ztegnodebs.get(i);
            }
        }

        return null;
    }

    private void clearUnusedData(DSLContext db){

        sf.purgeResult();
        this.result.clear();
    }
}

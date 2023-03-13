package id.mit.chrono.server.obj;

import id.mit.chrono.server.base.ErBaseContainer;
import id.mit.chrono.server.enm.PS;
import id.mit.chrono.server.iface.FileProcessor;
import id.mit.chrono.server.iface.ParserGroupCallback;
import id.mit.chrono.server.model.tables.Crcell;
import id.mit.chrono.server.model.tables.records.*;
import id.mit.chrono.server.util.CellUtils;
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

public class ErRncContainer extends ErBaseContainer implements FileProcessor {

    private List<ErrncRecord> rncs = new ArrayList<>();
    private List<ErnodebRecord> nodebs = new ArrayList<>();
    private List<ErucellRecord> ucells = new ArrayList<>();
    private HashMap<Long, CrnodeRecord> nodeCache = new HashMap();

    List<ErBasicTagParamsObj> vsDataRncFunctions;
    List<ErBasicTagParamsObj> RncFunctions;
    List<ErBasicTagParamsObj> vsDataIubLinks;
    List<ErBasicTagParamsObj> vsDataUtranCells;
    List<ErBasicTagParamsObj> vsDataLocationAreas;
    List<ErBasicTagParamsObj> vsDataRoutingAreas;
    List<ErBasicTagParamsObj> vsDataServiceAreas;

    public ErRncContainer(DSLContext db, ParserGroupCallback pgc, ChronoContext context, SourceFile sf, MapEntityObj meo) {
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

        vsDataRncFunctions = result.stream()
                .filter(p -> p.tag.equals("vsDataRncFunction"))
                .collect(Collectors.toList());

        logger.debug("vsDataRncFunctions.size(): " + vsDataRncFunctions.size());

        RncFunctions = result.stream()
                .filter(p -> p.tag.equals("RncFunction"))
                .collect(Collectors.toList());

        logger.debug("RncFunctions.size(): " + RncFunctions.size());

        if(vsDataRncFunctions.size() == 0){
            vsDataRncFunctions = RncFunctions;
        }

        vsDataIubLinks = result.stream()
                .filter(p -> p.tag.equals("vsDataIubLink"))
                .collect(Collectors.toList());

        logger.debug("vsDataIubLinks.size(): " + vsDataIubLinks.size());

        vsDataUtranCells = result.stream()
                .filter(p -> p.tag.equals("vsDataUtranCell"))
                .collect(Collectors.toList());

        logger.debug("vsDataUtranCells.size(): " + vsDataUtranCells.size());


        vsDataLocationAreas = result.stream()
                .filter(p -> p.tag.equals("vsDataLocationArea"))
                .collect(Collectors.toList());

        logger.debug("vsDataLocationAreas.size(): " + vsDataLocationAreas.size());


        vsDataRoutingAreas = result.stream()
                .filter(p -> p.tag.equals("vsDataRoutingArea"))
                .collect(Collectors.toList());

        logger.debug("vsDataRoutingAreas.size(): " + vsDataRoutingAreas.size());


        vsDataServiceAreas = result.stream()
                .filter(p -> p.tag.equals("vsDataServiceArea"))
                .collect(Collectors.toList());

        logger.debug("vsDataServiceAreas.size(): " + vsDataServiceAreas.size());

        addMeasurement(PS.PREPARE, this.getKey(), true);

        this.prepareRnc(adb);
        addMeasurement(PS.RNC, this.getKey(), true);

        this.prepareNodeB(adb);
        addMeasurement(PS.NODEB, this.getKey(), true);

        this.prepareCell(adb);
        addMeasurement(PS.CELL3G, this.getKey(), true);

        this.updateRnc(adb);
        this.clearUnusedData(adb);
        addMeasurement(PS.FINALIZE, this.getKey(), true);

        saveStatistics(adb);

        return true;
    }

    private void prepareRnc(DSLContext db){

        logger.debug("prepareRnc()");

        ErBasicTagParamsObj mml;
        CrmapfieldRecord mfr;

        String key = "MeContext_id";

        for (int i = 0; i < vsDataRncFunctions.size(); i++) {

            String MeContext_id = vsDataRncFunctions.get(i).params.get(key);

            ErrncRecord errnc = db.selectFrom(ERRNC)
                    .where(ERRNC.ERRNC_DATE.eq(UInteger.valueOf(context.getEpochTime())))
                    .and(ERRNC.RNCNAME.eq(MeContext_id))
                    .fetchOne();

            if(errnc == null){

                errnc = db.newRecord(ERRNC);

                errnc.setErrncDate(UInteger.valueOf(context.getEpochTime()));
                errnc.setRncname(MeContext_id);
            }

            ArrayList<String> filters = new ArrayList<>();
            filters.add(key);
            filters.add(MeContext_id);

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

                        errnc.set(DSL.field(mfr.getMapfieldFieldname()), replaceVal);
                    }
                }
                else{

                    String value = getKeyParamsValue(mfr, filters);

                    if(value != null){

                        errnc.set(DSL.field(mfr.getMapfieldFieldname()), value);
                    }
                }
            }

            int totalCell = 0;


//            errnc.setTotalcell(vsDataUtranCells.size());
//            errnc.setTotalnodeb(vsDataIubLinks.size());


            CrnodeRecord node = pgc.getNode(meo.mr.getMapentityVendor(), errnc.getRncname(), meo.mr.getMapentityNodecategory());

            if(node != null){

                errnc.setErrncNode(node.getNodeId());
            }

            errnc.setErrncCrcollectortaskfiles(ULong.valueOf(this.sf.getTaskFilesId()));
            errnc.setErrncVendor(meo.mr.getMapentityVendor());

            int result = (errnc.getErrncId() == null)?errnc.store():errnc.update();

            rncs.add(errnc);
        }

        logger.debug("prepareRnc() done");
    }

    private void prepareNodeB(DSLContext db){

        logger.debug("prepareNodeb()");

        // get field definition for hwnodeb
        MapEntityObj me = meo.getChildEntityByTableName("ernodeb");

        ErBasicTagParamsObj mml;
        CrmapfieldRecord mfr;

        String key2 = "vsDataIubLink_id";
        String key3 = "SubNetwork_2_id";
        String key4 = "iubLinkRef";
        String key5 = "IubLink_id";

        for (int i = 0; i < vsDataIubLinks.size(); i++) {

            String IubLink_id = vsDataIubLinks.get(i).params.get(key2);
            String SubNetwork_2_id = vsDataIubLinks.get(i).params.get(key3);

            // search for RNC first using subNetwork

            Long erRncId = null;

            for (int j = 0; j < rncs.size(); j++) {

                if(rncs.get(j).getRncname().equals(SubNetwork_2_id)){

                    erRncId = rncs.get(j).getErrncId().longValue();
                }
            }

            // skip
            if(erRncId == null){
                continue;
            }

            ErnodebRecord ernodeb = db.selectFrom(ERNODEB)
                    .where(ERNODEB.ERNODEB_DATE.eq(UInteger.valueOf(context.getEpochTime())))
                    .and(ERNODEB.ERNODEB_ERRNC.eq(ULong.valueOf(erRncId)))
                    .and(ERNODEB.IUBID.eq(IubLink_id))
                    .limit(1)
                    .fetchOne();

            if(ernodeb == null){

                ernodeb = db.newRecord(ERNODEB);

                ernodeb.setErnodebDate(UInteger.valueOf(context.getEpochTime()));
                ernodeb.setErnodebErrnc(ULong.valueOf(erRncId));
                ernodeb.setIubid(IubLink_id);
            }

            ArrayList<String> filters = new ArrayList<>();
            filters.add(key5);
            filters.add(IubLink_id);

            ArrayList<String> filters2 = new ArrayList<>();
            filters2.add(key2);
            filters2.add(IubLink_id);

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

                        ernodeb.set(DSL.field(mfr.getMapfieldFieldname()), replaceVal);
                    }
                }
                else{

                    String value = getKeyParamsValue(mfr, filters);

                    if(value != null){

                        ernodeb.set(DSL.field(mfr.getMapfieldFieldname()), value);
                    }
                    else{

                        value = getKeyParamsValue(mfr, filters2);

                        if(value != null){

                            ernodeb.set(DSL.field(mfr.getMapfieldFieldname()), value);
                        }

                    }
                }
            }

            int totalCell = vsDataUtranCells.parallelStream().filter(o -> o.params.containsKey(key4) && o.params.get(key4).contains("IubLink=" + IubLink_id)).collect(Collectors.toList()).size();

            ernodeb.setTotalcell(totalCell);

            // set relation to crnode
            CrnodeRecord node = pgc.getNode(meo.mr.getMapentityVendor(), ernodeb.getNodebname(), me.mr.getMapentityNodecategory());

            if(node != null){

                ernodeb.setErnodebNode(node.getNodeId());
                ernodeb.setErnodebRevenueclass(node.getNodeRevenueclass());
            }

            ernodeb.setErnodebNodestatus(pgc.getNodeStatus(ernodeb.getNodebname()));

            ernodeb.setErnodebCrcollectortaskfiles(ULong.valueOf(this.sf.getTaskFilesId()));

            ernodeb.setErnodebVendor(meo.mr.getMapentityVendor());

            int result = (ernodeb.getErnodebId() == null)?ernodeb.store():ernodeb.update();

            nodebs.add(ernodeb);
        }

        logger.debug("prepareNodeb() done");
    }

    private void prepareCell(DSLContext db){

        logger.debug("prepareCell()");

        // get field definition for hwnodeb
        MapEntityObj me = meo.getChildEntityByTableName("erucell");

        vsDataUtranCells.parallelStream().forEach(objx -> processCell(db, me, objx));

        logger.debug("prepareCell() done");
    }

    private void processCell(DSLContext db, MapEntityObj me, ErBasicTagParamsObj obj){

        ErBasicTagParamsObj mml;
        CrmapfieldRecord mfr;

        String key = "vsDataUtranCell_id";
        String key2 = "SubNetwork_2_id";
        String key3 = "iubLinkRef";
        String key4 = "locationAreaRef";
        String key5 = "serviceAreaRef";
        String key6 = "routingAreaRef";
        String key7 = "UtranCell_id";

        //routingAreaRef -> "SubNetwork=ONRM_ROOT_MO,SubNetwork=RNNAD07,MeContext=RNNAD07,ManagedElement=1,vsDataRncFunction=1,vsDataLocationArea=5152,vsDataRoutingArea=2"
        //serviceAreaRef -> "SubNetwork=ONRM_ROOT_MO,SubNetwork=RNNAD07,MeContext=RNNAD07,ManagedElement=1,vsDataRncFunction=1,vsDataLocationArea=5152,vsDataServiceArea=10191"
        //locationAreaRef -> "SubNetwork=ONRM_ROOT_MO,SubNetwork=RNNAD07,MeContext=RNNAD07,ManagedElement=1,vsDataRncFunction=1,vsDataLocationArea=5152"
        //iubLinkRef -> "SubNetwork=ONRM_ROOT_MO,SubNetwork=RNNAD07,MeContext=RNNAD07,ManagedElement=1,vsDataRncFunction=1,vsDataIubLink=b1019NAD"

        String UtranCell_id = obj.params.get(key);
        String SubNetwork_2_id = obj.params.get(key2);
        String iubLinkRef = obj.params.get(key3);
        String locationAreaRef = obj.params.get(key4);
        String serviceAreaRef = obj.params.get(key5);
        String routingAreaRef = obj.params.get(key6);

        if(UtranCell_id == null){
            return;
        }

//            System.out.println("UtranCell_id: " + UtranCell_id);

        iubLinkRef = iubLinkRef.substring(iubLinkRef.lastIndexOf("=")+1, iubLinkRef.length()-1);

//            System.out.println("iubLinkRef: " + iubLinkRef);
//            System.out.println("locationAreaRef: " + locationAreaRef);
//            System.out.println("serviceAreaRef: " + serviceAreaRef);
//            System.out.println("routingAreaRef: " + routingAreaRef);

        // search for RNC first using subNetwork

        Long erRncId = null;
        String rncId = null;
        String mcc = null;
        String mnc = null;
        String nodebName = "";

        for (int j = 0; j < rncs.size(); j++) {

            if(rncs.get(j).getRncname().equals(SubNetwork_2_id)){

                erRncId = rncs.get(j).getErrncId().longValue();
                rncId = rncs.get(j).getRncid();
                mcc = rncs.get(j).getMcc();
                mnc = rncs.get(j).getMnc();

                break;
            }
        }

        // skip
        if(erRncId == null){
            return;
        }

//        System.out.println("check: " + context.getEpochTime() + "|" + erRncId + "|" + UtranCell_id);
        ErucellRecord erucell = db.selectFrom(ERUCELL)
                .where(ERUCELL.ERUCELL_DATE.eq(UInteger.valueOf(context.getEpochTime())))
                .and(ERUCELL.ERUCELL_ERRNC.eq(ULong.valueOf(erRncId)))
                .and(ERUCELL.CELLNAME.equal(UtranCell_id))
                .limit(1)
                .fetchOne();

        if(erucell == null){

            erucell = db.newRecord(ERUCELL);
            erucell.setErucellDate(UInteger.valueOf(context.getEpochTime()));
            erucell.setErucellErrnc(ULong.valueOf(erRncId));
            erucell.setCellname(UtranCell_id);
        }

        // set lac, sac, rac
        if(locationAreaRef != null){

            locationAreaRef = locationAreaRef.substring(locationAreaRef.lastIndexOf("=")+1, locationAreaRef.length()-1);

            final String lookup = locationAreaRef;

            ErBasicTagParamsObj vsDataLocationArea = vsDataLocationAreas.stream()
                    .filter(o -> o.params.containsKey("vsDataLocationArea_id") && o.params.get("vsDataLocationArea_id").equals(lookup))
                    .collect(Collectors.toList()).get(0);

            locationAreaRef = vsDataLocationArea.params.get("lac");
            erucell.setLac(locationAreaRef);
        }

        if(serviceAreaRef != null){

            serviceAreaRef = serviceAreaRef.substring(serviceAreaRef.lastIndexOf("=")+1, serviceAreaRef.length()-1);

            final String lookup = serviceAreaRef;

            ErBasicTagParamsObj vsDataServiceArea = vsDataServiceAreas.stream()
                    .filter(o -> o.params.containsKey("vsDataServiceArea_id") && o.params.get("vsDataServiceArea_id").equals(lookup))
                    .collect(Collectors.toList()).get(0);

            serviceAreaRef = vsDataServiceArea.params.get("sac");
            erucell.setSac(serviceAreaRef);
        }

        if(routingAreaRef != null){

            routingAreaRef = routingAreaRef.substring(routingAreaRef.lastIndexOf("=")+1, routingAreaRef.length()-1);

            final String lookup = routingAreaRef;

            ErBasicTagParamsObj vsDataRoutingArea = vsDataRoutingAreas.stream()
                    .filter(o -> o.params.containsKey("vsDataRoutingArea_id") && o.params.get("vsDataRoutingArea_id").equals(lookup))
                    .collect(Collectors.toList()).get(0);

            routingAreaRef = vsDataRoutingArea.params.get("rac");
            erucell.setRac(routingAreaRef);
        }

        ArrayList<String> filters = new ArrayList<>();
        filters.add(key);
        filters.add(UtranCell_id);

        ArrayList<String> filters2 = new ArrayList<>();
        filters2.add(key7);
        filters2.add(UtranCell_id);

        // connect to NodeB
        for (int j = 0; j < nodebs.size(); j++) {

            if(nodebs.get(j).getIubid().equals(iubLinkRef)){

                erucell.setErucellErnodeb(nodebs.get(j).getErnodebId());
                break;
            }
        }

        // try to connect to nodeb within same rnc
        if(erucell.getErucellErnodeb() == null && iubLinkRef!=null){

            ErnodebRecord ernodeb = db.selectFrom(ERNODEB)
                    .where(ERNODEB.ERNODEB_DATE.eq(UInteger.valueOf(context.getEpochTime())))
                    .and(ERNODEB.ERNODEB_ERRNC.eq(ULong.valueOf(erRncId)))
                    .and(ERNODEB.IUBID.eq(iubLinkRef))
                    .fetchOne();

            if(ernodeb != null){
                nodebName = ernodeb.getNodebname();
                erucell.setErucellErnodeb(ernodeb.getErnodebId());
            }
        }

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

                    erucell.set(DSL.field(mfr.getMapfieldFieldname()), replaceVal);
                }
            }
            else{

                String value = getKeyParamsValue(mfr, filters);

                if(value != null){

                    erucell.set(DSL.field(mfr.getMapfieldFieldname()), value);
                }
                else{

                    value = getKeyParamsValue(mfr, filters2);

                    if(value != null){

                        erucell.set(DSL.field(mfr.getMapfieldFieldname()), value);
                    }
                }
            }
        }

        // set connection & property from RNC level
        erucell.setRncid(rncId);
        erucell.setMcc(mcc);
        erucell.setMnc(mnc);

        // fix lat/lon format
        if(erucell.getAntennalatitudedegree() != null && erucell.getAntennalongitudedegree() != null){

            try{

                String lSign = erucell.get(DSL.field("ANTENNALATITUDESIGN"), String.class);

                int latSign = Integer.parseInt(lSign);

                double d = Double.parseDouble(erucell.getAntennalatitudedegree());
                d = (d * 90) / 8388608;

                if(latSign == 1){
                    d = d * -1;
                }

                erucell.setLatitude(d);

                d = Double.parseDouble(erucell.getAntennalongitudedegree());
                d = (d * 360) / 16777216;
                erucell.setLongitude(d);

            }catch(Exception e){}
        }

        CrnodeRecord node = null;

        if(nodebName != null){

            node = new CrnodeRecord();
            node.setNodeCode(nodebName);
        }

        String cgi = getCGI(erucell.getMcc(), erucell.getMnc(), erucell.getLac(), erucell.getCellid());

        if(cgi != null){

            erucell.setCgi(cgi);

            CrcellRecord cellProto = CellUtils.getCellProto(erucell, node);
            // set relation to crcell
            CrcellRecord cell = pgc.getCellByArfcn("UMTS", Double.parseDouble(erucell.getUarfcndownlink()), cgi,  cellProto, node);

            if(cell != null){

                erucell.setErucellCell(cell.getCellId());
                erucell.setErucellCellclass(cell.getCellCellclass());
                erucell.setErucellCellcoverage(cell.getCellCellcoverage());
                erucell.setErucellRevenueclass(cell.getCellRevenueclass());
                erucell.setErucellLatitude(cell.getCellLatitude());
                erucell.setErucellLongitude(cell.getCellLongitude());

                Double uarfcn = null;

                if(erucell.getUarfcndownlink() != null && !erucell.getUarfcndownlink().isEmpty()){

                    try{
                        uarfcn = Double.parseDouble(erucell.getUarfcndownlink());
                    }catch(Exception e){}
                }

//                CrnodeRecord nodeAlias = pgc.getCellNodeAlias(erucell, erucell, cell.getCellCellclass(), uarfcn, erucell.getCellname(), node);

                String fixedCellName = erucell.getCellname();

                try{

//                    System.out.println("fixedCellName: " + fixedCellName);
                    String test = fixedCellName.substring(fixedCellName.length()-1);
                    int x = Integer.parseInt(test);
                    fixedCellName = fixedCellName.substring(0, fixedCellName.length()-1);

//                    System.out.println("fixedCellName 2: " + fixedCellName);
                }
                catch(Exception e){

                }

                CrnodeRecord nodeAlias = pgc.getCellNodeAlias2(meo.mr.getMapentityVendor(), cell.getCellCellclass(), fixedCellName, nodebName);

                if(nodeAlias != null){
                    erucell.setErucellNodealias(nodeAlias.getNodeId());
                }
            }
        }

        erucell.setErucellCellstatus(pgc.getNodeStatus(erucell.getCellname()));

        erucell.setErucellCrcollectortaskfiles(ULong.valueOf(this.sf.getTaskFilesId()));

        erucell.setErucellVendor(meo.mr.getMapentityVendor());

        int result = (erucell.getErucellId() == null)?erucell.store():erucell.update();

        synchronized (ucells){
            ucells.add(erucell);
        }
    }

    private void updateRnc(DSLContext db){

        logger.debug("updateRnc()");




        logger.debug("updateRnc() done");
    }

    private void clearUnusedData(DSLContext db){

        sf.purgeResult();
        this.result.clear();

        this.rncs.clear();
        this.nodebs.clear();
        this.ucells.clear();
        this.nodeCache.clear();

        this.vsDataRncFunctions.clear();
        this.RncFunctions.clear();
        this.vsDataIubLinks.clear();
        this.vsDataUtranCells.clear();
        this.vsDataLocationAreas.clear();
        this.vsDataRoutingAreas.clear();
        this.vsDataServiceAreas.clear();
    }
}

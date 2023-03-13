package id.mit.chrono.server.obj;

import com.google.common.base.Stopwatch;
import id.mit.chrono.server.base.BaseParserGroup;
import id.mit.chrono.server.base.ZteBaseContainer;
import id.mit.chrono.server.enm.PS;
import id.mit.chrono.server.iface.FileProcessor;
import id.mit.chrono.server.iface.ParserGroupCallback;
import id.mit.chrono.server.model.tables.Crcell;
import id.mit.chrono.server.model.tables.records.*;
import id.mit.chrono.server.util.CellUtils;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.SelectConditionStep;
import org.jooq.impl.DSL;
import org.jooq.types.UInteger;
import org.jooq.types.ULong;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import static id.mit.chrono.server.model.Tables.*;

public class ZteRncContainer extends ZteBaseContainer implements FileProcessor {

    private ArrayList<ZterncRecord> zterncs = new ArrayList<>();
    private ArrayList<ZtenodebRecord> ztenodebs = new ArrayList<>();
    private ArrayList<ZteucellRecord> zteucells = new ArrayList<>();

    private HashMap<Long, CrnodeRecord> nodeCache = new HashMap();

    List<ZteBasicKeyParamsObj> managedElements;

    // get RNC list
    List<ZteBasicKeyParamsObj> uRncFunctions;

    List<ZteBasicKeyParamsObj> uIubLinks;

    List<ZteBasicKeyParamsObj> uUtranCellFDDs;

    List<ZteBasicKeyParamsObj> uLocationAreas;
    List<ZteBasicKeyParamsObj> uRoutingAreas;
    List<ZteBasicKeyParamsObj> uServiceAreas;

    HashMap<String, ZterncRecord> rncCache = new HashMap<String, ZterncRecord>();

    HashMap<String, String> uLocationAreasCache = new HashMap<String, String>();
    HashMap<String, String> uRoutingAreasCache = new HashMap<String, String>();
    HashMap<String, String> uServiceAreasCache = new HashMap<String, String>();

    public ZteRncContainer(DSLContext db, ParserGroupCallback pgc, ChronoContext context, SourceFile sf, MapEntityObj meo) {
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

        // get ManagedElement list
        managedElements = result.stream()
                .filter(p -> p.group.equals("ManagedElement"))
                .collect(Collectors.toList());

        logger.debug("managedElements.size() = " + managedElements.size());

        // get RNC list
        uRncFunctions = result.stream()
                .filter(p -> p.group.equals("URncFunction"))
                .collect(Collectors.toList());

        logger.debug("uRncFunctions.size() = " + uRncFunctions.size());

        uIubLinks = result.stream()
                .filter(p -> p.group.equals("UIubLink"))
                .collect(Collectors.toList());

        logger.debug("uIubLinks.size() = " + uIubLinks.size());

        uUtranCellFDDs = result.stream()
                .filter(p -> p.group.equals("UUtranCellFDD"))
                .collect(Collectors.toList());

        logger.debug("uUtranCellFDDs.size() = " + uUtranCellFDDs.size());

        // get Location list
        uLocationAreas = result.stream()
                .filter(p -> p.group.equals("ULocationArea"))
                .collect(Collectors.toList());

        logger.debug("uLocationAreas.size() = " + uLocationAreas.size());

        uRoutingAreas = result.stream()
                .filter(p -> p.group.equals("URoutingArea"))
                .collect(Collectors.toList());

        logger.debug("uRoutingAreas.size() = " + uRoutingAreas.size());

        uServiceAreas = result.stream()
                .filter(p -> p.group.equals("UServiceArea"))
                .collect(Collectors.toList());

        logger.debug("uServiceAreas.size() = " + uServiceAreas.size());

        addMeasurement(PS.PREPARE, this.getKey(), true);

        this.prepareRnc(adb);
        this.prepareRnc2(adb);
        addMeasurement(PS.RNC, this.getKey(), true);

        this.prepareNodeB(adb);
        addMeasurement(PS.NODEB, this.getKey(), true);

        this.prepareUmtsCell(adb);
        addMeasurement(PS.CELL3G, this.getKey(), true);

        this.updateRnc(adb);
        this.clearUnusedData(adb);
        addMeasurement(PS.FINALIZE, this.getKey(), true);

        saveStatistics(adb);

        return true;
    }

    private void prepareRnc(DSLContext db){

        ContainerStatistic cs = new ContainerStatistic(PS.RNC);

        logger.debug("prepareRnc()");

        CrmapfieldRecord mfr;

        String key = "MOI";
        String key2 = "SubNetwork";
        String key3 = "MEID";
        String key4 = "URncFunction";

        for (int i = 0; i < uRncFunctions.size(); i++) {

            String MOI = uRncFunctions.get(i).params.get(key);
            String SubNetwork = uRncFunctions.get(i).params.get(key2);
            String MEID = uRncFunctions.get(i).params.get(key3);
            String URncFunction = uRncFunctions.get(i).params.get(key4);

            if(MOI == null){
                continue;
            }

            cs.resetAndStartStopWatch();
            ZterncRecord zternc = db.selectFrom(ZTERNC)
                    .where(ZTERNC.ZTERNC_DATE.eq(UInteger.valueOf(context.getEpochTime())))
                    .and(ZTERNC.SUBNETWORK.eq(SubNetwork))
                    .and(ZTERNC.MEID.eq(MEID))
//                    .and(ZTERNC.URNCFUNCTION.eq(URncFunction))
                    .fetchAny();
            cs.captureSelect();

            if(zternc == null){

                zternc = db.newRecord(ZTERNC);

                zternc.setZterncDate(UInteger.valueOf(context.getEpochTime()));
                zternc.setSubnetwork(SubNetwork);
                zternc.setMeid(MEID);
//                zternc.setUrncfunction(URncFunction);
            }

            ArrayList<String> filters = new ArrayList<>();
            filters.add(key2);
            filters.add(SubNetwork);

            filters.add(key3);
            filters.add(MEID);

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

                        zternc.set(DSL.field(mfr.getMapfieldFieldname()), replaceVal);
                    }
                }
                else{


                    String val = getKeyParamsValue(mfr, filters);

                    if(val != null){

                        zternc.set(DSL.field(mfr.getMapfieldFieldname()), val.trim());
                    }
                }
            }

            int totalNodeb = 0;

            String sn, meid, urnc;

            ZteBasicKeyParamsObj temp;

            for (int j = 0; j < uIubLinks.size(); j++) {

                temp = uIubLinks.get(j);

                sn = temp.params.get(key2);
                meid = temp.params.get(key3);
                urnc = temp.params.get(key4);

                if(sn.equals(SubNetwork) &&
                        meid.equals(MEID) &&
                        urnc.equals(URncFunction)){

                    totalNodeb++;
                }
            }

            zternc.setTotalnodeb(totalNodeb);


            // set relation to crnode
            CrnodeRecord node = pgc.getNode(meo.mr.getMapentityVendor(), zternc.getRncname(), meo.mr.getMapentityNodecategory());

            if(node != null){

                zternc.setZterncNode(node.getNodeId());
            }

            int totalCell = 0;

            for (int j = 0; j < uUtranCellFDDs.size(); j++) {

                temp = uUtranCellFDDs.get(j);
                sn = temp.params.get(key2);
                meid = temp.params.get(key3);
                urnc = temp.params.get(key4);

                if(sn.equals(SubNetwork) &&
                        meid.equals(MEID) &&
                        urnc.equals(URncFunction)){

                    totalCell++;
                }
            }

            zternc.setTotalcell(totalCell);

            zternc.setZterncVendor(meo.mr.getMapentityVendor());

            zternc.setZterncCrcollectortaskfiles(ULong.valueOf(this.sf.getTaskFilesId()));

            cs.resetAndStartStopWatch();
            if(zternc.getZterncId() == null){
                zternc.store();
                cs.captureInsert();
            }
            else{
                zternc.update();
                cs.captureUpdate();
            }

            zterncs.add(zternc);
        }

        addMeasurement(this.getKey(), true, cs);

        logger.debug("prepareRnc() done");
    }

    private void prepareRnc2(DSLContext db){

        ContainerStatistic cs = new ContainerStatistic(PS.RNC);

        logger.debug("prepareRnc()");

        CrmapfieldRecord mfr;

        String key = "ldn";
        String key2 = "SubNetwork";
        String key3 = "moId";
        String key4 = "URncFunction";
        String key5 = "ManagedElement";

        for (int i = 0; i < uRncFunctions.size(); i++) {

            String ldn = uRncFunctions.get(i).params.get(key);

            if(ldn == null){
                continue;
            }

            final String ManagedElement = uRncFunctions.get(i).params.get(key5);

            // inject userLabel from ManagedElement
            Optional<ZteBasicKeyParamsObj> bscNameObj = managedElements.stream().filter(o -> o.params.get(key5).equals(ManagedElement)).findAny();
            if(bscNameObj.isPresent()){
                uRncFunctions.get(i).params.put(key5, bscNameObj.get().params.get(key5));
            }

            String SubNetwork = uRncFunctions.get(i).params.get(key2);
            String MOID = uRncFunctions.get(i).params.get(key3);
            String URncFunction = uRncFunctions.get(i).params.get(key4);

            cs.resetAndStartStopWatch();
            ZterncRecord zternc = db.selectFrom(ZTERNC)
                    .where(ZTERNC.ZTERNC_DATE.eq(UInteger.valueOf(context.getEpochTime())))
                    .and(ZTERNC.SUBNETWORK.eq(SubNetwork))
                    .and(ZTERNC.MEID.eq(MOID))
//                    .and(ZTERNC.URNCFUNCTION.eq(URncFunction))
                    .fetchAny();
            cs.captureSelect();

            if(zternc == null){

                zternc = db.newRecord(ZTERNC);

                zternc.setZterncDate(UInteger.valueOf(context.getEpochTime()));
                zternc.setSubnetwork(SubNetwork);
                zternc.setMeid(MOID);
//                zternc.setUrncfunction(URncFunction);
            }

            ArrayList<String> filters = new ArrayList<>();
            filters.add(key2);
            filters.add(SubNetwork);

            filters.add(key3);
            filters.add(MOID);

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

                        zternc.set(DSL.field(mfr.getMapfieldFieldname()), replaceVal);
                    }
                }
                else{


                    String val = getKeyParamsValue(mfr, filters);

                    if(val != null){

                        zternc.set(DSL.field(mfr.getMapfieldFieldname()), val.trim());
                    }
                }
            }

            int totalNodeb = (int) uIubLinks.stream().filter(o -> o.params.get(key).startsWith(ldn + ",")).count();
            zternc.setTotalnodeb(totalNodeb);

            // set relation to crnode
            CrnodeRecord node = pgc.getNode(meo.mr.getMapentityVendor(), zternc.getRncname(), meo.mr.getMapentityNodecategory());

            if(node != null){

                zternc.setZterncNode(node.getNodeId());
            }

            int totalCell = (int) uUtranCellFDDs.stream().filter(o -> o.params.get(key).startsWith(ldn + ",")).count();
            zternc.setTotalcell(totalCell);

            zternc.setZterncVendor(meo.mr.getMapentityVendor());

            zternc.setZterncCrcollectortaskfiles(ULong.valueOf(this.sf.getTaskFilesId()));

            cs.resetAndStartStopWatch();
            if(zternc.getZterncId() == null){
                zternc.store();
                cs.captureInsert();
            }
            else{
                zternc.update();
                cs.captureUpdate();
            }

            zterncs.add(zternc);
        }

        addMeasurement(this.getKey(), true, cs);

        logger.debug("prepareRnc() done");
    }

    private void prepareNodeB(DSLContext db){

        logger.debug("prepareNodeB()");

        // get field definition for hwbts
        MapEntityObj me = meo.getChildEntityByTableName("ztenodeb");

        uIubLinks.parallelStream().forEach(objx -> processNodeB(db, me, objx));
        uIubLinks.parallelStream().forEach(objx -> processNodeB2(db, me, objx));

        logger.debug("prepareNodeB() done");
    }

    private void processNodeB(DSLContext db, MapEntityObj me, ZteBasicKeyParamsObj obj){

        String key = "MOI";
        String key2 = "SubNetwork";
        String key3 = "MEID";
        String key4 = "URncFunction";
        String key5 = "UIubLink";
        String key6 = "refUIubLink";

        CrmapfieldRecord mfr;

        ZterncRecord rnc;

        int zteBscId = -1;

        String mapFieldName;
        String mapfieldSourcegroup;

        Integer vendor = meo.mr.getMapentityVendor();

        String MOI = obj.params.get(key);

        if(MOI == null){
            return;
        }

        String SubNetwork = obj.params.get(key2);
        String MEID = obj.params.get(key3);
        String URncFunction = obj.params.get(key4);
        String UIubLink = obj.params.get(key5);

        String rncKey = SubNetwork + "-" + MEID;

        synchronized (rncCache){

            rnc = rncCache.get(rncKey);

            if (rnc == null) {

                rnc = this.getRnc(SubNetwork, MEID);
                rncCache.put(rncKey, rnc);
            }
        }

        if(rnc == null){
            return;
        }

        if(UIubLink == null){
            return;
        }

//        System.out.println("last: " + context.getEpochTime() + ":" + rnc.getZterncId() + ":" + ULogicalIubLink);
        ZtenodebRecord ztenodeb = db.selectFrom(ZTENODEB)
                .where(ZTENODEB.ZTENODEB_DATE.eq(UInteger.valueOf(context.getEpochTime())))
                .and(ZTENODEB.ZTENODEB_ZTERNC.eq(rnc.getZterncId()))
                .and(ZTENODEB.UIUBLINK.eq(UIubLink))
                .fetchOne();

        if(ztenodeb == null){

            ztenodeb = db.newRecord(ZTENODEB);

            ztenodeb.setZtenodebDate(UInteger.valueOf(context.getEpochTime()));
            ztenodeb.setZtenodebZternc(rnc.getZterncId());
            ztenodeb.setUiublink(UIubLink);
        }

        ArrayList<String> filters = new ArrayList<>();
        filters.add(key);
        filters.add(obj.params.get(key));

        for (int l = 0; l < me.mft.size(); l++) {

            mfr = me.mft.get(l);

            mapFieldName = mfr.getMapfieldFieldname();
            mapfieldSourcegroup = mfr.getMapfieldSourcegroup();

            // if need replace from chrono.context
            if(mapfieldSourcegroup.equals("chrono.context")){

                String replaceVal = null;

                switch(mfr.getMapfieldSourceparam()){

                    case "DATE": replaceVal = String.valueOf(context.getEpochTime()); break;
                    case "PARENTKEY": replaceVal = "XXX"; break;
                    default: break;
                }

                if(replaceVal != null){

                    ztenodeb.set(DSL.field(mapFieldName), replaceVal);
                }
            }
            else{

                String val = getKeyParamsValue(mfr, filters);

                if(val != null){

                    ztenodeb.set(DSL.field(mapFieldName), val.trim());
                }
            }
        }

        ztenodeb.setZtenodebVendor(vendor);

        // set relation to crnode
        CrnodeRecord node = pgc.getNode(meo.mr.getMapentityVendor(), ztenodeb.getUserlabel(), me.mr.getMapentityNodecategory());

        if(node != null){

            ztenodeb.setZtenodebNode(node.getNodeId());
            ztenodeb.setZtenodebRevenueclass(node.getNodeRevenueclass());
        }

        String refUIubLink;
        String uiublink;

        // count cell per nodeb
        int totalCell = 0;

        for (int j = 0; j < uUtranCellFDDs.size(); j++) {

            refUIubLink = uUtranCellFDDs.get(j).params.get(key6);
            uiublink = ztenodeb.getRefuiublink();

            if(refUIubLink.equals(uiublink)){

                totalCell++;
            }
        }

        ztenodeb.setZtenodebNodestatus(pgc.getNodeStatus(ztenodeb.getUserlabel()));
        ztenodeb.setTotalcell(totalCell);

        ztenodeb.setZtenodebZternc(rnc.getZterncId());

        ztenodeb.setZtenodebCrcollectortaskfiles(ULong.valueOf(this.sf.getTaskFilesId()));


        int result = (ztenodeb.getZtenodebId() == null)?ztenodeb.store():ztenodeb.update();

        if(node != null){

            synchronized (nodeCache){

                nodeCache.put(ztenodeb.getZtenodebId().longValue(), node);
            }
        }

        synchronized (ztenodebs){

            ztenodebs.add(ztenodeb);
        }
    }

    private void processNodeB2(DSLContext db, MapEntityObj me, ZteBasicKeyParamsObj obj){

        String key = "ldn";
        String key2 = "SubNetwork";
        String key3 = "moId";
        String key4 = "URncFunction";
        String key5 = "nodeBNo";
        String key6 = "refUIubLink";

        CrmapfieldRecord mfr;

        ZterncRecord rnc;

        int zteBscId = -1;

        String mapFieldName;
        String mapfieldSourcegroup;

        Integer vendor = meo.mr.getMapentityVendor();

        String ldn = obj.params.get(key);

        if(ldn == null){
            return;
        }

        String SubNetwork = obj.params.get(key2);
        String MOID = obj.params.get(key3);
        String URncFunction = obj.params.get(key4);
        String UIubLink = obj.params.get(key5);

        String rncKey = SubNetwork + "-" + MOID;

        synchronized (rncCache){

            rnc = rncCache.get(rncKey);

            if (rnc == null) {

                rnc = this.getRnc2(ldn);
                rncCache.put(rncKey, rnc);
            }
        }

        if(rnc == null){
            return;
        }

        if(UIubLink == null){
            return;
        }

//        System.out.println("last: " + context.getEpochTime() + ":" + rnc.getZterncId() + ":" + ULogicalIubLink);
        ZtenodebRecord ztenodeb = db.selectFrom(ZTENODEB)
                .where(ZTENODEB.ZTENODEB_DATE.eq(UInteger.valueOf(context.getEpochTime())))
                .and(ZTENODEB.ZTENODEB_ZTERNC.eq(rnc.getZterncId()))
                .and(ZTENODEB.UIUBLINK.eq(UIubLink))
                .fetchOne();

        if(ztenodeb == null){

            ztenodeb = db.newRecord(ZTENODEB);

            ztenodeb.setZtenodebDate(UInteger.valueOf(context.getEpochTime()));
            ztenodeb.setZtenodebZternc(rnc.getZterncId());
            ztenodeb.setUiublink(UIubLink);
        }

        ArrayList<String> filters = new ArrayList<>();
        filters.add(key);
        filters.add(obj.params.get(key));

        for (int l = 0; l < me.mft.size(); l++) {

            mfr = me.mft.get(l);

            mapFieldName = mfr.getMapfieldFieldname();
            mapfieldSourcegroup = mfr.getMapfieldSourcegroup();

            // if need replace from chrono.context
            if(mapfieldSourcegroup.equals("chrono.context")){

                String replaceVal = null;

                switch(mfr.getMapfieldSourceparam()){

                    case "DATE": replaceVal = String.valueOf(context.getEpochTime()); break;
                    case "PARENTKEY": replaceVal = "XXX"; break;
                    default: break;
                }

                if(replaceVal != null){

                    ztenodeb.set(DSL.field(mapFieldName), replaceVal);
                }
            }
            else{

                String val = getKeyParamsValue(mfr, filters);

                if(val != null){

                    ztenodeb.set(DSL.field(mapFieldName), val.trim());
                }
            }
        }

        ztenodeb.setZtenodebVendor(vendor);

        // set relation to crnode
        CrnodeRecord node = pgc.getNode(meo.mr.getMapentityVendor(), ztenodeb.getUserlabel(), me.mr.getMapentityNodecategory());

        if(node != null){

            ztenodeb.setZtenodebNode(node.getNodeId());
            ztenodeb.setZtenodebRevenueclass(node.getNodeRevenueclass());
        }

        String refUIubLink;
        String uiublink;

        final String finalMoi = ztenodeb.getMoi();

        // count cell per nodeb
        int totalCell = (int) uUtranCellFDDs.stream().filter(o -> o.params.get(key6).equals(finalMoi)).count();

        ztenodeb.setZtenodebNodestatus(pgc.getNodeStatus(ztenodeb.getUserlabel()));
        ztenodeb.setTotalcell(totalCell);

        ztenodeb.setZtenodebZternc(rnc.getZterncId());

        ztenodeb.setZtenodebCrcollectortaskfiles(ULong.valueOf(this.sf.getTaskFilesId()));


        int result = (ztenodeb.getZtenodebId() == null)?ztenodeb.store():ztenodeb.update();

        if(node != null){

            synchronized (nodeCache){

                nodeCache.put(ztenodeb.getZtenodebId().longValue(), node);
            }
        }

        synchronized (ztenodebs){

            ztenodebs.add(ztenodeb);
        }
    }

    private void prepareUmtsCell(DSLContext db){

        logger.debug("prepareUmtsCell()");

        String keyX = "MOI";
        String keyX2 = "ldn";
        String keyLac = "lac";
        String keyRac = "rac";
        String keySa = "sac";

        // get field definition for hwbts
        MapEntityObj me = meo.getChildEntityByTableName("zteucell");

        // populating cache
        for (int j = 0; j < uLocationAreas.size(); j++) {

            uLocationAreasCache.put(uLocationAreas.get(j).params.get(keyX), uLocationAreas.get(j).params.get(keyLac));
            uLocationAreasCache.put(uLocationAreas.get(j).params.get(keyX2), uLocationAreas.get(j).params.get(keyLac));
        }

        for (int j = 0; j < uRoutingAreas.size(); j++) {

            uRoutingAreasCache.put(uRoutingAreas.get(j).params.get(keyX), uRoutingAreas.get(j).params.get(keyRac));
            uRoutingAreasCache.put(uRoutingAreas.get(j).params.get(keyX2), uRoutingAreas.get(j).params.get(keyRac));
        }

        for (int j = 0; j < uServiceAreas.size(); j++) {

            uServiceAreasCache.put(uServiceAreas.get(j).params.get(keyX), uServiceAreas.get(j).params.get(keySa));
            uServiceAreasCache.put(uServiceAreas.get(j).params.get(keyX2), uServiceAreas.get(j).params.get(keySa));
        }

        uUtranCellFDDs.parallelStream().forEach(objx -> processCell(db, me, objx));
        uUtranCellFDDs.parallelStream().forEach(objx -> processCell2(db, me, objx));

        logger.debug("prepareUmtsCell() done");
    }

    private void processCell(DSLContext db, MapEntityObj me, ZteBasicKeyParamsObj obj){

        String lac, rac, sac = null;

        ZteBasicKeyParamsObj temp;

        String mapFieldName;
        String mapfieldSourcegroup;

        Integer vendor = meo.mr.getMapentityVendor();

        CrmapfieldRecord mfr;

        ZterncRecord rnc;

        String key = "MOI";
        String key2 = "SubNetwork";
        String key3 = "MEID";
        String key4 = "URncFunction";
        String key5 = "UUtranCellFDD";

        String key8 = "lac";
        String key9 = "rac";
        String key10 = "sac";

        String MOI = obj.params.get(key);
        if(MOI == null){
            return;
        }
        String SubNetwork = obj.params.get(key2);
        String MEID = obj.params.get(key3);
        String URncFunction = obj.params.get(key4);
        String UUtranCellFDD = obj.params.get(key5);

        String rncKey = SubNetwork + "-" + MEID;

        synchronized (rncCache){

            rnc = rncCache.get(rncKey);

            if (rnc == null) {

                rnc = this.getRnc(SubNetwork, MEID);
                rncCache.put(rncKey, rnc);
            }
        }

        if(rnc == null){
            return;
        }

        if(UUtranCellFDD == null){
            return;
        }

//        System.out.println("last: " + UInteger.valueOf(context.getEpochTime()) + ":" + rnc.getZterncId() + ":" + UUtranCellFDD);
        ZteucellRecord zteucell = db.selectFrom(ZTEUCELL)
                .where(ZTEUCELL.ZTEUCELL_DATE.eq(UInteger.valueOf(context.getEpochTime())))
                .and(ZTEUCELL.ZTEUCELL_ZTERNC.eq(rnc.getZterncId()))
                .and(ZTEUCELL.UUTRANCELLFDD.eq(UUtranCellFDD))
                .fetchOne();

        if(zteucell == null){

            zteucell = db.newRecord(ZTEUCELL);

            zteucell.setZteucellDate(UInteger.valueOf(context.getEpochTime()));
            zteucell.setZteucellZternc(rnc.getZterncId());
            zteucell.setUutrancellfdd(UUtranCellFDD);
        }

        ArrayList<String> filters = new ArrayList<>();
        filters.add(key);
        filters.add(obj.params.get(key));

        for (int l = 0; l < me.mft.size(); l++) {

            mfr = me.mft.get(l);

            mapFieldName = mfr.getMapfieldFieldname();
            mapfieldSourcegroup = mfr.getMapfieldSourcegroup();

            // if need replace from chrono.context
            if(mapfieldSourcegroup.equals("chrono.context")){

                String replaceVal = null;

                switch(mfr.getMapfieldSourceparam()){

                    case "DATE": replaceVal = String.valueOf(context.getEpochTime()); break;
                    case "PARENTKEY": replaceVal = "XXX"; break;
                    default: break;
                }

                if(replaceVal != null){

                    zteucell.set(DSL.field(mapFieldName), replaceVal);
                }
            }
            else{

                String val = getKeyParamsValue(mfr, filters);

                if(val != null){

                    zteucell.set(DSL.field(mapFieldName), val.trim());
                }
            }
        }

        lac = uLocationAreasCache.get(zteucell.getRefulocationarea());
        zteucell.setLac(lac);

        rac = uRoutingAreasCache.get(zteucell.getRefuroutingarea());
        zteucell.setRac(rac);

        sac = uServiceAreasCache.get(zteucell.getRefuroutingarea());
        zteucell.setSac(sac);

        final String moi = zteucell.getRefuiublink();

        // set node
        Optional<ZtenodebRecord> test = ztenodebs.stream().filter(o -> o.getMoi() != null && o.getMoi().equals(moi)).findFirst();

        ZtenodebRecord nodeb = test.isPresent()?test.get():null;

        if(nodeb != null){

            zteucell.setZteucellZtenodeb(nodeb.getZtenodebId());
        }

        String cgi = getCGI(zteucell.getMcc(), zteucell.getMnc(), zteucell.getLac(), zteucell.getCid());

        if(cgi != null){

            zteucell.setCgi(cgi);

            String freqBandLookup = "";

            if(zteucell.getFreqbandind().equals("0")){
                freqBandLookup = "UMTS_Band1";
            }else if(zteucell.getFreqbandind().equals("7")){
                freqBandLookup = "UMTS_Band8";
            }

            // set relation to crcell
            if(nodeb != null){

                CrnodeRecord node = nodeCache.get(nodeb.getZtenodebId().longValue());

                CrcellRecord cellProto = CellUtils.getCellProto(zteucell, node);

                CrcellRecord cell = pgc.getCell(freqBandLookup, cgi, cellProto, node);

                if(cell != null){

                    zteucell.setZteucellCell(cell.getCellId());
                    zteucell.setZteucellCellclass(cell.getCellCellclass());
                    zteucell.setZteucellCellcoverage(cell.getCellCellcoverage());
                    zteucell.setZteucellRevenueclass(cell.getCellRevenueclass());
                    zteucell.setZteucellLatitude(cell.getCellLatitude());
                    zteucell.setZteucellLongitude(cell.getCellLongitude());

                    Double uarfcn = null;

                    if(zteucell.getUarfcndl() != null && !zteucell.getUarfcndl().isEmpty()){
                        try{

                            uarfcn = Double.parseDouble(zteucell.getUarfcndl());
                        }catch(Exception e){}
                    }

//                    CrnodeRecord nodeAlias = pgc.getCellNodeAlias(zteucell, zteucell, cell.getCellCellclass(), uarfcn, zteucell.getUserlabel(), node);

                    String neName = (node != null)?node.getNodeCode(): null;

                    CrnodeRecord nodeAlias = pgc.getCellNodeAlias2(meo.mr.getMapentityVendor(), cell.getCellCellclass(), zteucell.getUserlabel(), neName);

                    if(nodeAlias != null){
                        zteucell.setZteucellNodealias(nodeAlias.getNodeId());
                    }
                }
            }
        }

        zteucell.setZteucellCellstatus(pgc.getCellStatus(zteucell.getUserlabel()));
        zteucell.setZteucellVendor(meo.mr.getMapentityVendor());
        zteucell.setZteucellCrcollectortaskfiles(ULong.valueOf(this.sf.getTaskFilesId()));

        // adjust latitude based on latitudeSign

        String sign = zteucell.get(DSL.field("latitudeSign"), String.class);

        if(sign != null && sign.equals("1")){

            double latitude = Double.parseDouble(zteucell.get(DSL.field("latitude"), String.class));
            latitude *= -1;
            zteucell.setLatitude(latitude);
        }

        int result = (zteucell.getZteucellId() == null)?zteucell.store():zteucell.update();

        synchronized (zteucells){

            zteucells.add(zteucell);
        }
    }

    private void processCell2(DSLContext db, MapEntityObj me, ZteBasicKeyParamsObj obj){

        String lac, rac, sac = null;

        ZteBasicKeyParamsObj temp;

        String mapFieldName;
        String mapfieldSourcegroup;

        Integer vendor = meo.mr.getMapentityVendor();

        CrmapfieldRecord mfr;

        ZterncRecord rnc;

        String key = "ldn";
        String key2 = "SubNetwork";
        String key3 = "moId";
        String key4 = "URncFunction";
        String key5 = "cId";

        String key8 = "lac";
        String key9 = "rac";
        String key10 = "sac";

        String ldn = obj.params.get(key);
        if(ldn == null){
            return;
        }

        String SubNetwork = obj.params.get(key2);
        String MOID = obj.params.get(key3);
        String URncFunction = obj.params.get(key4);
        String CId = obj.params.get(key5);

        String rncKey = SubNetwork + "-" + SubNetwork;

        synchronized (rncCache){

            rnc = rncCache.get(rncKey);

            if (rnc == null) {

                rnc = this.getRnc2(ldn);
                rncCache.put(rncKey, rnc);
            }
        }

        if(rnc == null){
            return;
        }

        if(CId == null){
            return;
        }

//        System.out.println("last: " + UInteger.valueOf(context.getEpochTime()) + ":" + rnc.getZterncId() + ":" + UUtranCellFDD);
        ZteucellRecord zteucell = db.selectFrom(ZTEUCELL)
                .where(ZTEUCELL.ZTEUCELL_DATE.eq(UInteger.valueOf(context.getEpochTime())))
                .and(ZTEUCELL.ZTEUCELL_ZTERNC.eq(rnc.getZterncId()))
                .and(ZTEUCELL.UUTRANCELLFDD.eq(CId))
                .fetchOne();

        if(zteucell == null){

            zteucell = db.newRecord(ZTEUCELL);

            zteucell.setZteucellDate(UInteger.valueOf(context.getEpochTime()));
            zteucell.setZteucellZternc(rnc.getZterncId());
            zteucell.setUutrancellfdd(CId);
        }

        ArrayList<String> filters = new ArrayList<>();
        filters.add(key);
        filters.add(obj.params.get(key));

        for (int l = 0; l < me.mft.size(); l++) {

            mfr = me.mft.get(l);

            mapFieldName = mfr.getMapfieldFieldname();
            mapfieldSourcegroup = mfr.getMapfieldSourcegroup();

            // if need replace from chrono.context
            if(mapfieldSourcegroup.equals("chrono.context")){

                String replaceVal = null;

                switch(mfr.getMapfieldSourceparam()){

                    case "DATE": replaceVal = String.valueOf(context.getEpochTime()); break;
                    case "PARENTKEY": replaceVal = "XXX"; break;
                    default: break;
                }

                if(replaceVal != null){

                    zteucell.set(DSL.field(mapFieldName), replaceVal);
                }
            }
            else{

                String val = getKeyParamsValue(mfr, filters);

                if(val != null){

                    zteucell.set(DSL.field(mapFieldName), val.trim());
                }
            }
        }

        lac = uLocationAreasCache.get(zteucell.getRefulocationarea());
        zteucell.setLac(lac);

        rac = uRoutingAreasCache.get(zteucell.getRefuroutingarea());
        zteucell.setRac(rac);

        sac = uServiceAreasCache.get(zteucell.getRefuroutingarea());
        zteucell.setSac(sac);

        final String moi = zteucell.getRefuiublink();

        // set node
        Optional<ZtenodebRecord> test = ztenodebs.stream().filter(o -> o.getMoi() != null && o.getMoi().equals(moi)).findFirst();

        ZtenodebRecord nodeb = test.isPresent()?test.get():null;

        if(nodeb != null){

            zteucell.setZteucellZtenodeb(nodeb.getZtenodebId());
        }

        String cgi = getCGI(zteucell.getMcc(), zteucell.getMnc(), zteucell.getLac(), zteucell.getCid());

        if(cgi != null){

            zteucell.setCgi(cgi);

            String freqBandLookup = "";

            if(zteucell.getFreqbandind().equals("0")){
                freqBandLookup = "UMTS_Band1";
            }else if(zteucell.getFreqbandind().equals("7")){
                freqBandLookup = "UMTS_Band8";
            }

            // set relation to crcell
            if(nodeb != null){

                CrnodeRecord node = nodeCache.get(nodeb.getZtenodebId().longValue());

                CrcellRecord cellProto = CellUtils.getCellProto(zteucell, node);

                CrcellRecord cell = pgc.getCell(freqBandLookup, cgi, cellProto, node);

                if(cell != null){

                    zteucell.setZteucellCell(cell.getCellId());
                    zteucell.setZteucellCellclass(cell.getCellCellclass());
                    zteucell.setZteucellCellcoverage(cell.getCellCellcoverage());
                    zteucell.setZteucellRevenueclass(cell.getCellRevenueclass());
                    zteucell.setZteucellLatitude(cell.getCellLatitude());
                    zteucell.setZteucellLongitude(cell.getCellLongitude());

                    Double uarfcn = null;

                    if(zteucell.getUarfcndl() != null && !zteucell.getUarfcndl().isEmpty()){
                        try{

                            uarfcn = Double.parseDouble(zteucell.getUarfcndl());
                        }catch(Exception e){}
                    }

//                    CrnodeRecord nodeAlias = pgc.getCellNodeAlias(zteucell, zteucell, cell.getCellCellclass(), uarfcn, zteucell.getUserlabel(), node);

                    String neName = (node != null)?node.getNodeCode(): null;

                    CrnodeRecord nodeAlias = pgc.getCellNodeAlias2(meo.mr.getMapentityVendor(), cell.getCellCellclass(), zteucell.getUserlabel(), neName);

                    if(nodeAlias != null){
                        zteucell.setZteucellNodealias(nodeAlias.getNodeId());
                    }
                }
            }
        }

        zteucell.setZteucellCellstatus(pgc.getCellStatus(zteucell.getUserlabel()));
        zteucell.setZteucellVendor(meo.mr.getMapentityVendor());
        zteucell.setZteucellCrcollectortaskfiles(ULong.valueOf(this.sf.getTaskFilesId()));

        // adjust latitude based on latitudeSign

        String sign = zteucell.get(DSL.field("latitudeSign"), String.class);

        if(sign != null && sign.equals("1")){

            double latitude = Double.parseDouble(zteucell.get(DSL.field("latitude"), String.class));
            latitude *= -1;
            zteucell.setLatitude(latitude);
        }

        int result = (zteucell.getZteucellId() == null)?zteucell.store():zteucell.update();

        synchronized (zteucells){

            zteucells.add(zteucell);
        }
    }

    private ZterncRecord getRnc(String SubNetwork, String MEID){

        ZterncRecord zternc;

        for (int i = 0; i < zterncs.size(); i++) {

            zternc = zterncs.get(i);

            if(zternc.getSubnetwork().equals(SubNetwork) && zternc.getMeid().equals(MEID)){

                return zterncs.get(i);
            }
        }

        return null;
    }

    private ZterncRecord getRnc2(String MOI){

        ZterncRecord zternc;

        for (int i = 0; i < zterncs.size(); i++) {

            zternc = zterncs.get(i);

            if(MOI.startsWith(zternc.getMoi() + ",")){

                return zterncs.get(i);
            }
        }

        return null;
    }

    private void updateRnc(DSLContext db){

        logger.debug("updateRnc()");

        logger.debug("updateRnc() done");
    }

    private void clearUnusedData(DSLContext db){

        sf.purgeResult();
        this.result.clear();
        this.uLocationAreasCache.clear();
        this.uRoutingAreasCache.clear();
        this.uServiceAreasCache.clear();
    }
}

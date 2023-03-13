package id.mit.chrono.server.obj;

import id.mit.chrono.server.base.BaseParserGroup;
import id.mit.chrono.server.base.HwBaseContainer;
import id.mit.chrono.server.base.ZteBaseContainer;
import id.mit.chrono.server.enm.PS;
import id.mit.chrono.server.iface.FileProcessor;
import id.mit.chrono.server.iface.ParserGroupCallback;
import id.mit.chrono.server.model.tables.Crcell;
import id.mit.chrono.server.model.tables.Ztegcell;
import id.mit.chrono.server.model.tables.records.*;
import id.mit.chrono.server.util.CellUtils;
import id.mit.chrono.server.util.GeoUtil;
import jdk.nashorn.internal.runtime.options.Option;
import org.jooq.DSLContext;
import org.jooq.impl.DSL;
import org.jooq.types.UInteger;
import org.jooq.types.ULong;
import org.slf4j.LoggerFactory;

import java.util.*;
import java.util.stream.Collectors;

import static id.mit.chrono.server.model.Tables.*;

public class ZteBscContainer extends ZteBaseContainer implements FileProcessor {

    private ArrayList<ZtebscRecord> ztebscs = new ArrayList<>();
    private ArrayList<ZtebtsRecord> ztebtss = new ArrayList<>();
    private ArrayList<ZtegcellRecord> ztegcells = new ArrayList<>();
    private ArrayList<ZtegtrxRecord> ztegtrxs = new ArrayList<>();

    private HashMap<Long, CrnodeRecord> nodeCache = new HashMap();

    // get BSC list
    List<ZteBasicKeyParamsObj> managedElements;

    List<ZteBasicKeyParamsObj> gBssFunctions;

    List<ZteBasicKeyParamsObj> gBtsManagers;

    List<ZteBasicKeyParamsObj> gGsmCells;

    List<ZteBasicKeyParamsObj> usoManagedElements;

    List<ZteBasicKeyParamsObj> usoGeranSubNetworks;

    List<ZteBasicKeyParamsObj> usoSites;

    List<ZteBasicKeyParamsObj> usoCells;

    // get TRX
    List<ZteBasicKeyParamsObj> gTrxs;

    public ZteBscContainer(DSLContext db, ParserGroupCallback pgc, ChronoContext context, SourceFile sf, MapEntityObj meo) {
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

        // get BSC list
        gBssFunctions = result.stream()
                .filter(p -> p.group.equals("GBssFunction"))
                .collect(Collectors.toList());

        logger.debug("gBssFunctions.size() = " + gBssFunctions.size());

        gBtsManagers = result.stream()
                .filter(p -> p.group.equals("GBtsSiteManager"))
                .collect(Collectors.toList());

        logger.debug("gBtsManagers.size() = " + gBtsManagers.size());

        gGsmCells = result.stream()
                .filter(p -> p.group.equals("GGsmCell"))
                .collect(Collectors.toList());

        logger.debug("gGsmCells.size() = " + gGsmCells.size());

        // get TRX
        gTrxs = result.stream()
                .filter(p -> p.group.equals("GTrx"))
                .collect(Collectors.toList());

        logger.debug("gTrxs.size() = " + gTrxs.size());

        // uso's attributes
        usoManagedElements = result.stream()
                .filter(p -> p.group.matches("^[5|6][_]Managed_Element.*"))
                .collect(Collectors.toList());

        logger.debug("usoManagedElements.size() = " + usoManagedElements.size());

        usoGeranSubNetworks = result.stream()
                .filter(p -> p.group.matches("^[5|6][_]GERAN_Subnetwork.*"))
                .collect(Collectors.toList());

        logger.debug("usoGeranSubNetworks.size() = " + usoGeranSubNetworks.size());

        usoSites = result.stream()
                .filter(p -> p.group.matches("^[5|6][_]Site.*"))
                .collect(Collectors.toList());

        logger.debug("usoSites.size() = " + usoSites.size());

        usoCells = result.stream()
                .filter(p -> p.group.matches("^[5|6][_]Cell.*"))
                .collect(Collectors.toList());

        logger.debug("usoCells.size() = " + usoCells.size());

        addMeasurement(PS.PREPARE, this.getKey(), true);

        this.prepareBsc(adb);
        this.prepareBsc2(adb);
        this.prepareBscUso(adb);
        addMeasurement(PS.BSC, this.getKey(), true);

        this.prepareBts(adb);
        addMeasurement(PS.BTS, this.getKey(), true);

        this.prepareGsmCell(adb);
        addMeasurement(PS.CELL2G, this.getKey(), true);

//        this.prepareGtrx(adb);
//        addMeasurement(PS.TRX, this.getKey(), true);

        this.updateBsc(adb);
        this.clearUnusedData(adb);
        addMeasurement(PS.FINALIZE, this.getKey(), true);

        saveStatistics(adb);

        return true;
    }

    private void prepareBsc(DSLContext db){

        logger.debug("prepareBsc()");

        ZteBasicKeyParamsObj mml;
        CrmapfieldRecord mfr;

        String key = "MOI";
        String key2 = "SubNetwork";
        String key3 = "MEID";
        String key4 = "GBssFunction";

        for (int i = 0; i < gBssFunctions.size(); i++) {

            String MOI = gBssFunctions.get(i).params.get(key);

            if(MOI == null){
                continue;
            }

            String SubNetwork = gBssFunctions.get(i).params.get(key2);
            String MEID = gBssFunctions.get(i).params.get(key3);
            String GBssFunction = gBssFunctions.get(i).params.get(key4);

            ZtebscRecord ztebsc = db.selectFrom(ZTEBSC)
                    .where(ZTEBSC.ZTEBSC_DATE.eq(UInteger.valueOf(context.getEpochTime())))
                    .and(ZTEBSC.SUBNETWORK.eq(SubNetwork))
                    .and(ZTEBSC.MEID.eq(MEID))
//                    .and(ZTEBSC.GBSSFUNCTION.eq(GBssFunction))
                    .fetchOne();

            if(ztebsc == null){

                ztebsc = db.newRecord(ZTEBSC);

                ztebsc.setZtebscDate(UInteger.valueOf(context.getEpochTime()));
                ztebsc.setSubnetwork(SubNetwork);
                ztebsc.setMeid(MEID);
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

                        ztebsc.set(DSL.field(mfr.getMapfieldFieldname()), replaceVal);
                    }
                }
                else{

                    String val = getKeyParamsValue(mfr, filters);

                    if(val != null){

                        ztebsc.set(DSL.field(mfr.getMapfieldFieldname()), val.trim());
                    }
                }
            }

            int totalCell = 0;

            for (int j = 0; j < gGsmCells.size(); j++) {

                SubNetwork = gGsmCells.get(j).params.get(key2);
                MEID = gGsmCells.get(j).params.get(key3);
                GBssFunction = gGsmCells.get(j).params.get(key4);

                if(SubNetwork.equals(ztebsc.getSubnetwork()) &&
                        MEID.equals(ztebsc.getMeid()) &&
                        GBssFunction.equals(ztebsc.getGbssfunction())){

                    totalCell++;
                }
            }

            // get totalTrx
            int totalTrx = 0;

            for (int j = 0; j < gTrxs.size(); j++) {

                SubNetwork = gTrxs.get(j).params.get(key2);
                MEID = gTrxs.get(j).params.get(key3);
                GBssFunction = gTrxs.get(j).params.get(key4);

                if(SubNetwork.equals(ztebsc.getSubnetwork()) &&
                        MEID.equals(ztebsc.getMeid()) &&
                        GBssFunction.equals(ztebsc.getGbssfunction())){

                    totalTrx++;
                }
            }

            // get total BTS
            int totalBts = 0;

            for (int j = 0; j < gBtsManagers.size(); j++) {

                SubNetwork = gBtsManagers.get(j).params.get(key2);
                MEID = gBtsManagers.get(j).params.get(key3);
                GBssFunction = gBtsManagers.get(j).params.get(key4);

                if(SubNetwork.equals(ztebsc.getSubnetwork()) &&
                        MEID.equals(ztebsc.getMeid()) &&
                        GBssFunction.equals(ztebsc.getGbssfunction())){

                    totalBts++;
                }
            }

            CrnodeRecord node = pgc.getNode(meo.mr.getMapentityVendor(), ztebsc.getBscname(), meo.mr.getMapentityNodecategory());

            if(node != null){

                ztebsc.setZtebscNode(node.getNodeId());
            }

            ztebsc.setTotalbts(totalBts);

            ztebsc.setTotaltrx(totalTrx);

            ztebsc.setTotalcell(totalCell);

            ztebsc.setZtebscVendor(meo.mr.getMapentityVendor());

            ztebsc.setZtebscCrcollectortaskfiles(ULong.valueOf(this.sf.getTaskFilesId()));

            int result = (ztebsc.getZtebscId() == null)?ztebsc.store():ztebsc.update();

            ztebscs.add(ztebsc);
        }

        logger.debug("prepareBsc() done");
    }

    private void prepareBsc2(DSLContext db){

        logger.debug("prepareBsc()");

        ZteBasicKeyParamsObj mml;
        CrmapfieldRecord mfr;

        String key = "ldn";
        String key2 = "SubNetwork";
        String key3 = "moId";
        String key4 = "GBssFunctionSeq";
        String key5 = "ManagedElement";
        String key6 = "userLabel";

        for (int i = 0; i < gBssFunctions.size(); i++) {

            String Idn = gBssFunctions.get(i).params.get(key);

            if(Idn == null){
                continue;
            }

            final String ManagedElement = gBssFunctions.get(i).params.get(key5);

            // inject userLabel from ManagedElement
            Optional<ZteBasicKeyParamsObj> bscNameObj = managedElements.stream().filter(o -> o.params.get(key5).equals(ManagedElement)).findAny();
            if(bscNameObj.isPresent()){
                gBssFunctions.get(i).params.put(key5, bscNameObj.get().params.get(key5));
            }

            String SubNetwork = gBssFunctions.get(i).params.get(key2);
            String MOID = gBssFunctions.get(i).params.get(key3);
            String GBssFunction = gBssFunctions.get(i).params.get(key4);

            ZtebscRecord ztebsc = db.selectFrom(ZTEBSC)
                    .where(ZTEBSC.ZTEBSC_DATE.eq(UInteger.valueOf(context.getEpochTime())))
                    .and(ZTEBSC.SUBNETWORK.eq(SubNetwork))
                    .and(ZTEBSC.MEID.eq(MOID))
//                    .and(ZTEBSC.GBSSFUNCTION.eq(GBssFunction))
                    .limit(1)
                    .fetchOne();

            if(ztebsc == null){

                ztebsc = db.newRecord(ZTEBSC);

                ztebsc.setZtebscDate(UInteger.valueOf(context.getEpochTime()));
                ztebsc.setSubnetwork(SubNetwork);
                ztebsc.setMeid(MOID);
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

                        ztebsc.set(DSL.field(mfr.getMapfieldFieldname()), replaceVal);
                    }
                }
                else{

                    String val = getKeyParamsValue(mfr, filters);

                    if(val != null){

                        ztebsc.set(DSL.field(mfr.getMapfieldFieldname()), val.trim());
                    }
                }
            }

            int totalCell = 0;

            for (int j = 0; j < gGsmCells.size(); j++) {

                SubNetwork = gGsmCells.get(j).params.get(key2);

                if(SubNetwork.equals(ztebsc.getSubnetwork())){

                    totalCell++;
                }
            }

            // get totalTrx
            int totalTrx = 0;

            for (int j = 0; j < gTrxs.size(); j++) {

                SubNetwork = gTrxs.get(j).params.get(key2);

                if(SubNetwork.equals(ztebsc.getSubnetwork())){

                    totalTrx++;
                }
            }

            // get total BTS
            int totalBts = 0;

            for (int j = 0; j < gBtsManagers.size(); j++) {

                SubNetwork = gBtsManagers.get(j).params.get(key2);

                if(SubNetwork.equals(ztebsc.getSubnetwork())){

                    totalBts++;
                }
            }

            CrnodeRecord node = pgc.getNode(meo.mr.getMapentityVendor(), ztebsc.getBscname(), meo.mr.getMapentityNodecategory());

            if(node != null){

                ztebsc.setZtebscNode(node.getNodeId());
            }

            ztebsc.setTotalbts(totalBts);

            ztebsc.setTotaltrx(totalTrx);

            ztebsc.setTotalcell(totalCell);

            ztebsc.setZtebscVendor(meo.mr.getMapentityVendor());

            ztebsc.setZtebscCrcollectortaskfiles(ULong.valueOf(this.sf.getTaskFilesId()));

            int result = (ztebsc.getZtebscId() == null)?ztebsc.store():ztebsc.update();

            ztebscs.add(ztebsc);
        }

        logger.debug("prepareBsc() done");
    }

    private void prepareBscUso(DSLContext db) {

        logger.debug("prepareBscUso()");

        ZteBasicKeyParamsObj mml;
        CrmapfieldRecord mfr;

        String key = "USERLABEL";
        String key2 = "SUBNETWORKID";
        String key3 = "IBSCMEID";
        String key4 = "OMCBSCID";

        for (int i = 0; i < usoManagedElements.size(); i++) {

            String USERLABEL = usoManagedElements.get(i).params.get(key);
            String IBSCMEID = usoManagedElements.get(i).params.get(key3);

            String SUBNETWORKID = null;
            for (ZteBasicKeyParamsObj subnet: usoGeranSubNetworks){

                SUBNETWORKID = subnet.params.get(key2).equals(IBSCMEID) ? subnet.params.get(key2) : null;
            }

            if (SUBNETWORKID == null) {
                continue;
            }

            ZtebscRecord ztebsc = db.selectFrom(ZTEBSC)
                    .where(ZTEBSC.ZTEBSC_DATE.eq(UInteger.valueOf(context.getEpochTime())))
                    .and(ZTEBSC.SUBNETWORK.eq(SUBNETWORKID))
                    .and(ZTEBSC.MEID.eq(IBSCMEID))
                    .and(ZTEBSC.USERLABEL.eq(USERLABEL))
                    .fetchOne();

            if (ztebsc == null) {

                ztebsc = db.newRecord(ZTEBSC);

                ztebsc.setZtebscDate(UInteger.valueOf(context.getEpochTime()));
                ztebsc.setSubnetwork(SUBNETWORKID);
                ztebsc.setMeid(IBSCMEID);
            }

            ArrayList<String> filters = new ArrayList<>();
            filters.add(key2);
            filters.add(SUBNETWORKID);

            filters.add(key3);
            filters.add(IBSCMEID);

            for (int l = 0; l < meo.mft.size(); l++) {

                mfr = meo.mft.get(l);

                // if need replace from chrono.context
                if (mfr.getMapfieldSourcegroup().equals("chrono.context")) {

                    String replaceVal = null;

                    switch (mfr.getMapfieldSourceparam()) {

                        case "DATE":
                            replaceVal = String.valueOf(context.getEpochTime());
                            break;
                        case "PARENTKEY":
                            replaceVal = "XXX";
                            break;
                        default:
                            break;
                    }

                    if (replaceVal != null) {

                        ztebsc.set(DSL.field(mfr.getMapfieldFieldname()), replaceVal);
                    }
                }
                else{

                    String val = getKeyParamsValue(mfr, filters);

                    if(val != null){

                        ztebsc.set(DSL.field(mfr.getMapfieldFieldname()), val.trim());
                    }
                }
            }

            int totalCell = 0;
            int totalBts = 0;

            for (int j = 0; j < usoSites.size(); j++) {

                // filter related sites
                if (usoSites.get(j).params.get(key4).equals(IBSCMEID)) {

                    totalBts++;

                    ZteBasicKeyParamsObj usoSite = usoSites.get(j);

                    // filter related cells
                    totalCell += usoCells.stream()
                            .filter(p -> p.params.get("SITEID").equals(usoSite.params.get("SITEID")))
                            .count();
                }
            }

            CrnodeRecord node = pgc.getNode(meo.mr.getMapentityVendor(), ztebsc.getBscname(), meo.mr.getMapentityNodecategory());

            if(node != null){

                ztebsc.setZtebscNode(node.getNodeId());
            }

            ztebsc.setTotalbts(totalBts);

            ztebsc.setTotalcell(totalCell);

            ztebsc.setZtebscVendor(meo.mr.getMapentityVendor());

            ztebsc.setZtebscCrcollectortaskfiles(ULong.valueOf(this.sf.getTaskFilesId()));

            int result = (ztebsc.getZtebscId() == null)?ztebsc.store():ztebsc.update();

            ztebscs.add(ztebsc);

        }

        logger.debug("prepareUSOBsc() done");
    }

    private void prepareBts(DSLContext db){

        logger.debug("prepareBts()");

        // get field definition for hwbts
        MapEntityObj me = meo.getChildEntityByTableName("ztebts");

        gBtsManagers.parallelStream().forEach(objx -> processBts(db, me, objx));
        gBtsManagers.parallelStream().forEach(objx -> processBts2(db, me, objx));
        usoSites.parallelStream().forEach(objx -> processBtsUso(db, me, objx));

        logger.debug("prepareBts() done");
    }

    private void processBts(DSLContext db, MapEntityObj me, ZteBasicKeyParamsObj obj){

        CrmapfieldRecord mfr;

        String key = "MOI";
        String key2 = "SubNetwork";
        String key3 = "MEID";
        String key4 = "GBssFunction";
        String key5 = "GBtsSiteManager";

        String SubNetwork = obj.params.get(key2);
        String MEID = obj.params.get(key3);
        if(MEID == null){
            return;
        }
        String GBssFunction = obj.params.get(key4);
        String GBtsSiteManager = obj.params.get(key5);

        // set relation to bsc
        ZtebscRecord bsc = this.getBsc(SubNetwork, MEID, GBssFunction);

        if(bsc == null){
            return;
        }

        ZtebtsRecord ztebts = db.selectFrom(ZTEBTS)
                .where(ZTEBTS.ZTEBTS_DATE.eq(UInteger.valueOf(context.getEpochTime())))
                .and(ZTEBTS.ZTEBTS_ZTEBSC.eq(bsc.getZtebscId()))
                .and(ZTEBTS.GBTSSITEMANAGER.eq(GBtsSiteManager))
                .fetchAny();

        if(ztebts == null){

            ztebts = db.newRecord(ZTEBTS);

            ztebts.setZtebtsDate(UInteger.valueOf(context.getEpochTime()));
            ztebts.setZtebtsZtebsc(bsc.getZtebscId());
            ztebts.setGbtssitemanager(GBtsSiteManager);
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

                    ztebts.set(DSL.field(mfr.getMapfieldFieldname()), replaceVal);
                }
            }
            else{

                String val = getKeyParamsValue(mfr, filters);

                if(val != null){
                    ztebts.set(DSL.field(mfr.getMapfieldFieldname()), val.trim());
                }
            }
        }

        ztebts.setZtebtsVendor(meo.mr.getMapentityVendor());

        // set relation to crnode
        CrnodeRecord node = pgc.getNode(meo.mr.getMapentityVendor(), ztebts.getUserlabel(), me.mr.getMapentityNodecategory());

        if(node != null){

            ztebts.setZtebtsNode(node.getNodeId());
            ztebts.setZtebtsRevenueclass(node.getNodeRevenueclass());
        }

        // count cell per bts
        int totalCell = 0;

        String sn, meid, gbss, gbts;

        for (int j = 0; j < gGsmCells.size(); j++) {

            sn = gGsmCells.get(j).params.get(key2);
            meid = gGsmCells.get(j).params.get(key3);
            gbss = gGsmCells.get(j).params.get(key4);
            gbts = gGsmCells.get(j).params.get(key5);

            if(sn.equals(ztebts.getSubnetwork()) &&
                    meid.equals(ztebts.getMeid()) &&
                    gbss.equals(ztebts.getGbssfunction()) &&
                    gbts.equals(ztebts.getGbtssitemanager())){

                totalCell++;
            }
        }

        // get totalTrx
        int totalTrx = 0;

        for (int j = 0; j < gTrxs.size(); j++) {

            sn = gTrxs.get(j).params.get(key2);
            meid = gTrxs.get(j).params.get(key3);
            gbss = gTrxs.get(j).params.get(key4);
            gbts = gTrxs.get(j).params.get(key5);

            if(sn.equals(ztebts.getSubnetwork()) &&
                    meid.equals(ztebts.getMeid()) &&
                    gbss.equals(ztebts.getGbssfunction()) &&
                    gbts.equals(ztebts.getGbtssitemanager())){

                totalTrx++;
            }
        }

        ztebts.setTotaltrx(totalTrx);

        ztebts.setTotalcell(totalCell);

        ztebts.setZtebtsNodestatus(pgc.getNodeStatus(ztebts.getUserlabel()));

        ztebts.setZtebtsZtebsc(bsc.getZtebscId());

        ztebts.setZtebtsCrcollectortaskfiles(ULong.valueOf(this.sf.getTaskFilesId()));

        int result = (ztebts.getZtebtsId() == null)?ztebts.store():ztebts.update();

        if(node != null){

            nodeCache.put(ztebts.getZtebtsId().longValue(), node);
        }

        synchronized (ztebtss){

            ztebtss.add(ztebts);
        }
    }

    private void processBts2(DSLContext db, MapEntityObj me, ZteBasicKeyParamsObj obj){

        CrmapfieldRecord mfr;

        String key = "ldn";
        String key2 = "SubNetwork";
        String key3 = "moId";
        String key4 = "GBssFunction";
        String key5 = "moId";

        String ldn = obj.params.get(key);
        String SubNetwork = obj.params.get(key2);
        String MOID = obj.params.get(key3);
        if(MOID == null){
            return;
        }
        String GBssFunction = obj.params.get(key4);
        String GBtsSiteManager = obj.params.get(key5);

        // set relation to bsc
        ZtebscRecord bsc = this.getBsc2(SubNetwork);

        if(bsc == null){
            return;
        }

        ZtebtsRecord ztebts = db.selectFrom(ZTEBTS)
                .where(ZTEBTS.ZTEBTS_DATE.eq(UInteger.valueOf(context.getEpochTime())))
                .and(ZTEBTS.ZTEBTS_ZTEBSC.eq(bsc.getZtebscId()))
                .and(ZTEBTS.GBTSSITEMANAGER.eq(GBtsSiteManager))
                .fetchAny();

        if(ztebts == null){

            ztebts = db.newRecord(ZTEBTS);

            ztebts.setZtebtsDate(UInteger.valueOf(context.getEpochTime()));
            ztebts.setZtebtsZtebsc(bsc.getZtebscId());
            ztebts.setGbtssitemanager(GBtsSiteManager);
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

                    ztebts.set(DSL.field(mfr.getMapfieldFieldname()), replaceVal);
                }
            }
            else{

                String val = getKeyParamsValue(mfr, filters);

                if(val != null){

                    ztebts.set(DSL.field(mfr.getMapfieldFieldname()), val.trim());
                }
            }
        }

        ztebts.setZtebtsVendor(meo.mr.getMapentityVendor());

        // set relation to crnode
        CrnodeRecord node = pgc.getNode(meo.mr.getMapentityVendor(), ztebts.getUserlabel(), me.mr.getMapentityNodecategory());

        if(node != null){

            ztebts.setZtebtsNode(node.getNodeId());
            ztebts.setZtebtsRevenueclass(node.getNodeRevenueclass());
        }

        // count cell per bts
        int totalCell = 0;

        String cellLdn;

        List<ZteBasicKeyParamsObj> cells = gGsmCells.stream().filter(o -> o.params.containsKey(key) && o.params.get(key).startsWith(ldn + ",")).collect(Collectors.toList());

        ztebts.setTotalcell(cells.size());

        List<ZteBasicKeyParamsObj> trxs = gTrxs.stream().filter(o -> o.params.containsKey(key) && o.params.get(key).startsWith(ldn + ",")).collect(Collectors.toList());

        ztebts.setTotaltrx(trxs.size());

        ztebts.setZtebtsNodestatus(pgc.getNodeStatus(ztebts.getUserlabel()));

        ztebts.setZtebtsZtebsc(bsc.getZtebscId());

        ztebts.setZtebtsCrcollectortaskfiles(ULong.valueOf(this.sf.getTaskFilesId()));

        int result = (ztebts.getZtebtsId() == null)?ztebts.store():ztebts.update();

        if(node != null){

            nodeCache.put(ztebts.getZtebtsId().longValue(), node);
        }

        synchronized (ztebtss){

            ztebtss.add(ztebts);
        }
    }

    private void processBtsUso(DSLContext db, MapEntityObj me, ZteBasicKeyParamsObj obj){

        // objx -> usoSites

        CrmapfieldRecord mfr;

        String key = "OMCBSCID";
        String key2 = "SUBNETWORKID";
        String key3 = "IBSCMEID";
        String key4 = "USERLABEL";

        String OMCBSCID = obj.params.get(key);

        String MEID = null;
        String USERLABEL = null;
        for (ZteBasicKeyParamsObj managedElement: usoManagedElements) {

            if (managedElement.params.get(key3).equals(OMCBSCID)) {
                MEID = managedElement.params.get(key3);
                // set as bsc's userlabel first
                USERLABEL = managedElement.params.get(key4);
            }
        }

        if (MEID == null) {
            return;
        }

        String SUBNETWORK = null;
        for (ZteBasicKeyParamsObj subnet: usoGeranSubNetworks) {

            SUBNETWORK = subnet.params.get(key2).equals(MEID) ? subnet.params.get(key2) : null;
        }

        if (SUBNETWORK == null) {
            return;
        }

        // set relation to bsc
        ZtebscRecord bsc = this.getBsc3(SUBNETWORK, MEID, USERLABEL);

        if (bsc == null) {
            return;
        }

        // set as bts's userlabel
        USERLABEL = obj.params.get(key4);

        ZtebtsRecord ztebts = db.selectFrom(ZTEBTS)
                .where(ZTEBTS.ZTEBTS_DATE.eq(UInteger.valueOf(context.getEpochTime())))
                .and(ZTEBTS.ZTEBTS_ZTEBSC.eq(bsc.getZtebscId()))
                .and(ZTEBTS.MEID.eq(MEID))
                .and(ZTEBTS.SUBNETWORK.eq(SUBNETWORK))
                .and(ZTEBTS.USERLABEL.eq(USERLABEL))
                .fetchAny();

        if (ztebts == null) {

            ztebts = db.newRecord(ZTEBTS);

            ztebts.setZtebtsDate(UInteger.valueOf(context.getEpochTime()));
            ztebts.setZtebtsZtebsc(bsc.getZtebscId());
            ztebts.setMeid(MEID);
            ztebts.setSubnetwork(SUBNETWORK);
        }

        ArrayList<String> filters = new ArrayList<>();
        filters.add(key);
        filters.add(obj.params.get(key));
        filters.add(key4);
        filters.add(obj.params.get(key4));

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

                    ztebts.set(DSL.field(mfr.getMapfieldFieldname()), replaceVal);
                }
            }
            else{

                String val = getKeyParamsValue(mfr, filters);

                if(val != null){
                    ztebts.set(DSL.field(mfr.getMapfieldFieldname()), val.trim());
                }
            }
        }

        ztebts.setZtebtsVendor(meo.mr.getMapentityVendor());

        // set relation to crnode
        CrnodeRecord node = pgc.getNode(meo.mr.getMapentityVendor(), ztebts.getUserlabel(), me.mr.getMapentityNodecategory());

        if(node != null){

            ztebts.setZtebtsNode(node.getNodeId());
            ztebts.setZtebtsRevenueclass(node.getNodeRevenueclass());
        }

        // count cell per bts
        int totalCell = (int) usoCells.stream()
                .filter(p -> p.params.get("SITEID").equals(obj.params.get("SITEID")))
                .count();

        ztebts.setTotalcell(totalCell);

        ztebts.setZtebtsNodestatus(pgc.getNodeStatus(ztebts.getUserlabel()));

        ztebts.setZtebtsZtebsc(bsc.getZtebscId());

        ztebts.setZtebtsCrcollectortaskfiles(ULong.valueOf(this.sf.getTaskFilesId()));

        int result = (ztebts.getZtebtsId() == null)?ztebts.store():ztebts.update();

        if(node != null){

            nodeCache.put(ztebts.getZtebtsId().longValue(), node);
        }

        synchronized (ztebtss){

            ztebtss.add(ztebts);
        }
    }

    private void prepareGsmCell(DSLContext db){

        logger.debug("prepareGsmCell()");

        CrmapfieldRecord mfr;

        // get field definition for hwbts
        MapEntityObj me = meo.getChildEntityByTableName("ztegcell");

        // get Location list
        List<ZteBasicKeyParamsObj> gLocationAreas = result.stream()
                .filter(p -> p.group.equals("GLocationArea"))
                .collect(Collectors.toList());

        gGsmCells.parallelStream().forEach(objx -> processCell(db, me, gLocationAreas, objx));
        gGsmCells.parallelStream().forEach(objx -> processCell2(db, me, gLocationAreas, objx));
        usoCells.parallelStream().forEach(objx -> processCellUso(db, me, objx));

        logger.debug("prepareGsmCell() done");
    }

    private void processCell(DSLContext db, MapEntityObj me, List<ZteBasicKeyParamsObj> gLocationAreas, ZteBasicKeyParamsObj obj){

        CrmapfieldRecord mfr;

        String key = "MOI";
        String key2 = "SubNetwork";
        String key3 = "MEID";
        String key4 = "GBssFunction";
        String key5 = "GBtsSiteManager";
        String key6 = "GGsmCell";

        String key7 = "refGLocationArea";
        String key8 = "lac";
        String key9 = "arfcn";

        String MOI = obj.params.get(key);
        if(MOI == null){
            return;
        }
        String SubNetwork = obj.params.get(key2);
        String MEID = obj.params.get(key3);
        String GBssFunction = obj.params.get(key4);
        String GBtsSiteManager = obj.params.get(key5);
        String GGsmCell = obj.params.get(key6);

        // set relation to bsc
        ZtebscRecord bsc = this.getBsc(SubNetwork, MEID, GBssFunction);

        ZtebtsRecord bts = this.getBts(SubNetwork, MEID, GBssFunction, GBtsSiteManager);

        if(bsc == null || bts == null){

            return;
        }

        ZtegcellRecord ztegcell = db.selectFrom(ZTEGCELL)
                    .where(ZTEGCELL.ZTEGCELL_DATE.eq(UInteger.valueOf(context.getEpochTime())))
                    .and(ZTEGCELL.ZTEGCELL_ZTEBSC.eq(bsc.getZtebscId()))
                    .and(ZTEGCELL.ZTEGCELL_ZTEBTS.eq(bts.getZtebtsId()))
                    .and(ZTEGCELL.GGSMCELL.eq(GGsmCell))
                    .fetchOne();

        if(ztegcell == null){

            ztegcell = db.newRecord(ZTEGCELL);

            ztegcell.setZtegcellDate(UInteger.valueOf(context.getEpochTime()));
            ztegcell.setZtegcellZtebsc(bsc.getZtebscId());
            ztegcell.setZtegcellZtebts(bts.getZtebtsId());
            ztegcell.setGgsmcell(GGsmCell);
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

                    ztegcell.set(DSL.field(mfr.getMapfieldFieldname()), replaceVal);
                }
            }
            else{

                String val = getKeyParamsValue(mfr, filters);

                if(val != null){

                    ztegcell.set(DSL.field(mfr.getMapfieldFieldname()), val.trim());
                }
            }
        }

        // GET LAC
        for (int j = 0; j < gLocationAreas.size(); j++) {

            if(gLocationAreas.get(j).params.get(key).equals(ztegcell.getRefglocationarea())){

                ztegcell.setLac(gLocationAreas.get(j).params.get(key8));
                break;
            }
        }

        // get totalTrx
        int totalTrx = 0;

        String sn, meid, gbss, gbts, gcell;
        ZteBasicKeyParamsObj tempTrx;

//            temp = ztegcell.getSubnetwork() + "-" + ztegcell.getMeid() + "-" + ztegcell.getGbssfunction() + "-" + ztegcell.getGbtssitemanager() + "-" + ztegcell.getGgsmcell();

        ArrayList<Integer> trxFreqs = new ArrayList<>();
        int tempInt;
        String tempString;

        for (int j = 0; j < gTrxs.size(); j++) {

            tempTrx = gTrxs.get(j);

            sn = tempTrx.params.get(key2);
            meid = tempTrx.params.get(key3);
            gbss = tempTrx.params.get(key4);
            gbts = tempTrx.params.get(key5);
            gcell = tempTrx.params.get(key6);


//                temp2 = sn + "-" + sn + "-" + meid + "-" + gbss + "-" + gbts + "-" + gcell;

//                if(temp2.length() == temp.length() && temp2.equals(temp)){
//
//                    totalTrx++;
//                }

            if(sn.equals(ztegcell.getSubnetwork()) &&
                    meid.equals(ztegcell.getMeid()) &&
                    gbss.equals(ztegcell.getGbssfunction()) &&
                    gbts.equals(ztegcell.getGbtssitemanager()) &&
                    gcell.equals(ztegcell.getGgsmcell())){

                tempString = tempTrx.params.get(key9);

                try{

                    tempInt = Integer.parseInt(tempString);

                    if(!trxFreqs.contains(tempInt)){
                        trxFreqs.add(tempInt);
                    }
                }
                catch(Exception e){}

                totalTrx++;
            }
        }

        Collections.sort(trxFreqs);

        for (int i = 0; i < trxFreqs.size() && trxFreqs.size() < 24; i++) {

            ztegcell.set(DSL.field("FREQ" + (i+1)), trxFreqs.get(i));
        }

        // set lat lon from bts level
//        if(bts.getLatitude() != null && bts.getLongitude() != null){
//
//            System.out.println("Update...");
//
//            ztegcell.setLatitude(Double.parseDouble(bts.getLatitude()));
//            ztegcell.setLongitude(Double.parseDouble(bts.getLongitude()));
//        }

        String cellLat = ztegcell.get(DSL.field("Latitude"), String.class);
        String cellLon = ztegcell.get(DSL.field("Longitude"), String.class);

        if(cellLat != null && cellLon != null){

            double latitude = Double.parseDouble(cellLat);
            double longitude = Double.parseDouble(cellLon);

            ztegcell.setLatitude(latitude);
            ztegcell.setLongitude(longitude);
        }


        String cgi = getCGI(ztegcell.getMcc(), ztegcell.getMnc(), ztegcell.getLac(), ztegcell.getCellidentity());

        if(cgi != null){

            ztegcell.setCgi(cgi);

            String freqBandLookup = "";

            if(ztegcell.getFreqband().equals("0")){
                freqBandLookup = "GSM900";
            }else if(ztegcell.getFreqband().equals("1")){
                freqBandLookup = "GSM900";
            }else if(ztegcell.getFreqband().equals("2")){
                freqBandLookup = "DCS1800";
            }

            CrnodeRecord node = nodeCache.get(bts.getZtebtsId().longValue());

            CrcellRecord cellProto = CellUtils.getCellProto(ztegcell, node);
            // set relation to crcell
            CrcellRecord cell = pgc.getCell(freqBandLookup, cgi, cellProto, node);

            if(cell != null){

                ztegcell.setZtegcellCell(cell.getCellId());
                ztegcell.setZtegcellCellclass(cell.getCellCellclass());
                ztegcell.setZtegcellCellcoverage(cell.getCellCellcoverage());
                ztegcell.setZtegcellRevenueclass(cell.getCellRevenueclass());
                ztegcell.setZtegcellLatitude(cell.getCellLatitude());
                ztegcell.setZtegcellLongitude(cell.getCellLongitude());

//                CrnodeRecord nodeAlias = pgc.getCellNodeAlias(ztegcell, ztegcell, cell.getCellCellclass(), null, ztegcell.getUserlabel(), node);

                String neName = (node != null)?node.getNodeCode(): null;

                CrnodeRecord nodeAlias = pgc.getCellNodeAlias2(meo.mr.getMapentityVendor(), cell.getCellCellclass(), ztegcell.getUserlabel(), neName);

                if(nodeAlias != null){
                    ztegcell.setZtegcellNodealias(nodeAlias.getNodeId());
                }
            }
        }

        ztegcell.setZtegcellCellstatus(pgc.getCellStatus(ztegcell.getUserlabel()));
        ztegcell.setTotaltrx(totalTrx);

        ztegcell.setZtegcellVendor(meo.mr.getMapentityVendor());
        ztegcell.setZtegcellCrcollectortaskfiles(ULong.valueOf(this.sf.getTaskFilesId()));

        int result = (ztegcell.getZtegcellId() == null)?ztegcell.store():ztegcell.update();

        synchronized (ztegcells){

            ztegcells.add(ztegcell);
        }
    }

    private void processCell2(DSLContext db, MapEntityObj me, List<ZteBasicKeyParamsObj> gLocationAreas, ZteBasicKeyParamsObj obj){

        CrmapfieldRecord mfr;

        String key = "ldn";
        String key2 = "SubNetwork";
        String key3 = "moId";
        String key4 = "GBssFunction";
        String key5 = "GBtsSiteManager";
        String key6 = "GGsmCell";

        String key7 = "refGLocationArea";
        String key8 = "lac";
        String key9 = "arfcn";

        String MOI = obj.params.get(key);
        if(MOI == null){
            return;
        }
        String SubNetwork = obj.params.get(key2);
        String MOID = obj.params.get(key3);
        String GGsmCell = obj.params.get(key6);

        // set relation to bsc
        ZtebscRecord bsc = this.getBsc2(SubNetwork);

        ZtebtsRecord bts = this.getBts2(MOI);

        if(bsc == null || bts == null){

            return;
        }

        ZtegcellRecord ztegcell = db.selectFrom(ZTEGCELL)
                .where(ZTEGCELL.ZTEGCELL_DATE.eq(UInteger.valueOf(context.getEpochTime())))
                .and(ZTEGCELL.ZTEGCELL_ZTEBSC.eq(bsc.getZtebscId()))
                .and(ZTEGCELL.ZTEGCELL_ZTEBTS.eq(bts.getZtebtsId()))
                .and(ZTEGCELL.GGSMCELL.eq(MOID))
                .fetchOne();

        if(ztegcell == null){

            ztegcell = db.newRecord(ZTEGCELL);

            ztegcell.setZtegcellDate(UInteger.valueOf(context.getEpochTime()));
            ztegcell.setZtegcellZtebsc(bsc.getZtebscId());
            ztegcell.setZtegcellZtebts(bts.getZtebtsId());
            ztegcell.setGgsmcell(MOID);
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

                    ztegcell.set(DSL.field(mfr.getMapfieldFieldname()), replaceVal);
                }
            }
            else{

                String val = getKeyParamsValue(mfr, filters);

                if(val != null){

                    ztegcell.set(DSL.field(mfr.getMapfieldFieldname()), val.trim());
                }
            }
        }

        // GET LAC
        for (int j = 0; j < gLocationAreas.size(); j++) {

            if(gLocationAreas.get(j).params.get(key).equals(ztegcell.getRefglocationarea())){

                ztegcell.setLac(gLocationAreas.get(j).params.get(key8));
                break;
            }
        }

        // get totalTrx
        int totalTrx = 0;

        String sn, meid, gbss, gbts, gcell;
        ZteBasicKeyParamsObj tempTrx;

//            temp = ztegcell.getSubnetwork() + "-" + ztegcell.getMeid() + "-" + ztegcell.getGbssfunction() + "-" + ztegcell.getGbtssitemanager() + "-" + ztegcell.getGgsmcell();

        ArrayList<Integer> trxFreqs = new ArrayList<>();
        int tempInt;
        String tempString;

        for (int j = 0; j < gTrxs.size(); j++) {

            tempTrx = gTrxs.get(j);

            if(tempTrx.params.get(key).startsWith(MOI + ",")){

                tempString = tempTrx.params.get(key9);

                try{

                    tempInt = Integer.parseInt(tempString);

                    if(!trxFreqs.contains(tempInt)){
                        trxFreqs.add(tempInt);
                    }
                }
                catch(Exception e){}

                totalTrx++;
            }
        }

        Collections.sort(trxFreqs);

        for (int i = 0; i < trxFreqs.size() && trxFreqs.size() < 24; i++) {

            ztegcell.set(DSL.field("FREQ" + (i+1)), trxFreqs.get(i));
        }

        // set lat lon from bts level
//        if(bts.getLatitude() != null && bts.getLongitude() != null){
//
//            System.out.println("Update...");
//
//            ztegcell.setLatitude(Double.parseDouble(bts.getLatitude()));
//            ztegcell.setLongitude(Double.parseDouble(bts.getLongitude()));
//        }

        String cellLat = ztegcell.get(DSL.field("Latitude"), String.class);
        String cellLon = ztegcell.get(DSL.field("Longitude"), String.class);

        if(cellLat != null && cellLon != null){

            double latitude = Double.parseDouble(cellLat);
            double longitude = Double.parseDouble(cellLon);

            ztegcell.setLatitude(latitude);
            ztegcell.setLongitude(longitude);
        }


        String cgi = getCGI(ztegcell.getMcc(), ztegcell.getMnc(), ztegcell.getLac(), ztegcell.getCellidentity());

        if(cgi != null){

            ztegcell.setCgi(cgi);

            String freqBandLookup = "";

            if(ztegcell.getFreqband().equals("0")){
                freqBandLookup = "GSM900";
            }else if(ztegcell.getFreqband().equals("1")){
                freqBandLookup = "GSM900";
            }else if(ztegcell.getFreqband().equals("2")){
                freqBandLookup = "DCS1800";
            }

            CrnodeRecord node = nodeCache.get(bts.getZtebtsId().longValue());

            CrcellRecord cellProto = CellUtils.getCellProto(ztegcell, node);
            // set relation to crcell
            CrcellRecord cell = pgc.getCell(freqBandLookup, cgi, cellProto, node);

            if(cell != null){

                ztegcell.setZtegcellCell(cell.getCellId());
                ztegcell.setZtegcellCellclass(cell.getCellCellclass());
                ztegcell.setZtegcellCellcoverage(cell.getCellCellcoverage());
                ztegcell.setZtegcellRevenueclass(cell.getCellRevenueclass());
                ztegcell.setZtegcellLatitude(cell.getCellLatitude());
                ztegcell.setZtegcellLongitude(cell.getCellLongitude());

//                CrnodeRecord nodeAlias = pgc.getCellNodeAlias(ztegcell, ztegcell, cell.getCellCellclass(), null, ztegcell.getUserlabel(), node);

                String neName = (node != null)?node.getNodeCode(): null;

                CrnodeRecord nodeAlias = pgc.getCellNodeAlias2(meo.mr.getMapentityVendor(), cell.getCellCellclass(), ztegcell.getUserlabel(), neName);

                if(nodeAlias != null){
                    ztegcell.setZtegcellNodealias(nodeAlias.getNodeId());
                }
            }
        }

        ztegcell.setZtegcellCellstatus(pgc.getCellStatus(ztegcell.getUserlabel()));
        ztegcell.setTotaltrx(totalTrx);

        ztegcell.setZtegcellVendor(meo.mr.getMapentityVendor());
        ztegcell.setZtegcellCrcollectortaskfiles(ULong.valueOf(this.sf.getTaskFilesId()));

        int result = (ztegcell.getZtegcellId() == null)?ztegcell.store():ztegcell.update();

        synchronized (ztegcells){

            ztegcells.add(ztegcell);
        }
    }

    private void processCellUso(DSLContext db, MapEntityObj me, ZteBasicKeyParamsObj obj){

        CrmapfieldRecord mfr;

        String key = "OMCBSCID";
        String key2 = "SUBNETWORKID";
        String key3 = "IBSCMEID";
        String key4 = "USERLABEL";
        String key5 = "SITEID";

        String OMCBSCID = obj.params.get(key);
        String SITEID = obj.params.get(key5);

        String MEID = null;
        String USERLABEL = null;
        for (ZteBasicKeyParamsObj managedElement: usoManagedElements) {

            if (managedElement.params.get(key3).equals(OMCBSCID)) {
                MEID = managedElement.params.get(key3);
                // set as bsc's userlabel first
                USERLABEL = managedElement.params.get(key4);
            }
        }

        if (MEID == null) {
            return;
        }

        String SUBNETWORK = null;
        for (ZteBasicKeyParamsObj subnet: usoGeranSubNetworks) {

            if (subnet.params.get(key2).equals(MEID)) {
                SUBNETWORK = subnet.params.get(key2);
            }
        }

        if (SUBNETWORK == null) {
            return;
        }

        // set relation to bsc
        ZtebscRecord bsc = this.getBsc3(SUBNETWORK, MEID, USERLABEL);

        String SITE = null;
        for (ZteBasicKeyParamsObj site: usoSites) {

            if (site.params.get(key5).equals(SITEID)) {
                SITE = site.params.get(key5);
                // set as bts's userlabel
                USERLABEL = site.params.get(key4);
            }
        }

        if (SITE == null) {
            return;
        }

        // set relation to bts
        ZtebtsRecord bts = this.getBts3(SUBNETWORK, MEID, USERLABEL);

        if(bsc == null || bts == null){

            return;
        }

        // set as cell's userlabel
        USERLABEL = obj.params.get(key4);

        ZtegcellRecord ztegcell = db.selectFrom(ZTEGCELL)
                .where(ZTEGCELL.ZTEGCELL_DATE.eq(UInteger.valueOf(context.getEpochTime())))
                .and(ZTEGCELL.ZTEGCELL_ZTEBSC.eq(bsc.getZtebscId()))
                .and(ZTEGCELL.ZTEGCELL_ZTEBTS.eq(bts.getZtebtsId()))
                .and(ZTEGCELL.USERLABEL.eq(USERLABEL))
                .fetchOne();

        if(ztegcell == null){

            ztegcell = db.newRecord(ZTEGCELL);

            ztegcell.setZtegcellDate(UInteger.valueOf(context.getEpochTime()));
            ztegcell.setZtegcellZtebsc(bsc.getZtebscId());
            ztegcell.setZtegcellZtebts(bts.getZtebtsId());
            ztegcell.setMeid(MEID);
            ztegcell.setSubnetwork(SUBNETWORK);
            ztegcell.setUserlabel(USERLABEL);
        }

        ArrayList<String> filters = new ArrayList<>();
        filters.add(key);
        filters.add(obj.params.get(key));
        filters.add(key4);
        filters.add(obj.params.get(key4));
        filters.add(key5);
        filters.add(obj.params.get(key5));

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

                    ztegcell.set(DSL.field(mfr.getMapfieldFieldname()), replaceVal);
                }
            }
            else{

                String val = getKeyParamsValue(mfr, filters);

                if(val != null){

                    ztegcell.set(DSL.field(mfr.getMapfieldFieldname()), val.trim());
                }
            }
        }

        // set lat lon from bts level
        if(bts.getLatitude() != null && bts.getLongitude() != null){

//            System.out.println("Update...");

            ztegcell.setLatitude(Double.parseDouble(bts.getLatitude()));
            ztegcell.setLongitude(Double.parseDouble(bts.getLongitude()));
        }

        String cellLat = ztegcell.get(DSL.field("Latitude"), String.class);
        String cellLon = ztegcell.get(DSL.field("Longitude"), String.class);

        if(cellLat != null && cellLon != null){

            double latitude = Double.parseDouble(cellLat);
            double longitude = Double.parseDouble(cellLon);

            ztegcell.setLatitude(latitude);
            ztegcell.setLongitude(longitude);
        }


        String cgi = getCGI(ztegcell.getMcc(), ztegcell.getMnc(), ztegcell.getLac(), ztegcell.getCellidentity());

        if(cgi != null){

            ztegcell.setCgi(cgi);

            String freqBandLookup = "";

            if(ztegcell.getFreqband().equals("0")){
                freqBandLookup = "GSM900";
            }else if(ztegcell.getFreqband().equals("1")){
                freqBandLookup = "GSM900";
            }else if(ztegcell.getFreqband().equals("2")){
                freqBandLookup = "DCS1800";
            }

            CrnodeRecord node = nodeCache.get(bts.getZtebtsId().longValue());

            CrcellRecord cellProto = CellUtils.getCellProto(ztegcell, node);
            // set relation to crcell
            CrcellRecord cell = pgc.getCell(freqBandLookup, cgi, cellProto, node);

            if(cell != null){

                ztegcell.setZtegcellCell(cell.getCellId());
                ztegcell.setZtegcellCellclass(cell.getCellCellclass());
                ztegcell.setZtegcellCellcoverage(cell.getCellCellcoverage());
                ztegcell.setZtegcellRevenueclass(cell.getCellRevenueclass());
                ztegcell.setZtegcellLatitude(cell.getCellLatitude());
                ztegcell.setZtegcellLongitude(cell.getCellLongitude());

//                CrnodeRecord nodeAlias = pgc.getCellNodeAlias(ztegcell, ztegcell, cell.getCellCellclass(), null, ztegcell.getUserlabel(), node);

                String neName = (node != null)?node.getNodeCode(): null;

                CrnodeRecord nodeAlias = pgc.getCellNodeAlias2(meo.mr.getMapentityVendor(), cell.getCellCellclass(), ztegcell.getUserlabel(), neName);

                if(nodeAlias != null){
                    ztegcell.setZtegcellNodealias(nodeAlias.getNodeId());
                }
            }
        }

        ztegcell.setZtegcellCellstatus(pgc.getCellStatus(ztegcell.getUserlabel()));
//        ztegcell.setTotaltrx(totalTrx);

        ztegcell.setZtegcellVendor(meo.mr.getMapentityVendor());
        ztegcell.setZtegcellCrcollectortaskfiles(ULong.valueOf(this.sf.getTaskFilesId()));

        int result = (ztegcell.getZtegcellId() == null)?ztegcell.store():ztegcell.update();

        synchronized (ztegcells){

            ztegcells.add(ztegcell);
        }
    }

    private void prepareGtrx(DSLContext db){

        logger.debug("prepareGtrx()");

        CrmapfieldRecord mfr;

        // get field definition for hwbts
        MapEntityObj me = meo.getChildEntityByTableName("ztegtrx");

        String key = "MOI";
        String key2 = "SubNetwork";
        String key3 = "MEID";
        String key4 = "GBssFunction";
        String key5 = "GBtsSiteManager";
        String key6 = "GGsmCell";
        String key7 = "GTrx";

        int zteBscId = -1;

        for (int i = 0; i < gTrxs.size(); i++) {

            String SubNetwork = gTrxs.get(i).params.get(key2);
            String MEID = gTrxs.get(i).params.get(key3);
            String GBssFunction = gTrxs.get(i).params.get(key4);
            String GBtsSiteManager = gTrxs.get(i).params.get(key5);
            String GGsmCell = gTrxs.get(i).params.get(key6);
            String GTrx = gTrxs.get(i).params.get(key7);

            // set relation to bsc
            ZtebscRecord bsc = this.getBsc(SubNetwork, MEID, GBssFunction);

            ZtebtsRecord bts = this.getBts(SubNetwork, MEID, GBssFunction, GBtsSiteManager);

            ZtegcellRecord gcell = this.getGcell(SubNetwork, MEID, GBssFunction, GBtsSiteManager, GGsmCell);

            if(bsc == null || bts == null || gcell == null){
                continue;
            }

            ZtegtrxRecord ztegtrx = db.selectFrom(ZTEGTRX)
                    .where(ZTEGTRX.ZTEGTRX_DATE.eq(UInteger.valueOf(context.getEpochTime())))
                    .and(ZTEGTRX.ZTEGTRX_ZTEBSC.eq(bsc.getZtebscId()))
                    .and(ZTEGTRX.ZTEGTRX_ZTEBTS.eq(bts.getZtebtsId()))
                    .and(ZTEGTRX.ZTEGTRX_ZTEGCELL.eq(gcell.getZtegcellId()))
                    .and(ZTEGTRX.GTRX.eq(GTrx))
                    .fetchAny();

            if(ztegtrx == null){

                ztegtrx = db.newRecord(ZTEGTRX);

                ztegtrx.setZtegtrxDate(UInteger.valueOf(context.getEpochTime()));
                ztegtrx.setZtegtrxZtebsc(bsc.getZtebscId());
                ztegtrx.setZtegtrxZtebts(bts.getZtebtsId());
                ztegtrx.setZtegtrxZtegcell(gcell.getZtegcellId());
                ztegtrx.setGtrx(GTrx);
            }

            ArrayList<String> filters = new ArrayList<>();
            filters.add(key);
            filters.add(gTrxs.get(i).params.get(key));

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

                        ztegtrx.set(DSL.field(mfr.getMapfieldFieldname()), replaceVal);
                    }
                }
                else{

                    ztegtrx.set(DSL.field(mfr.getMapfieldFieldname()), getKeyParamsValue(mfr, filters));
                }
            }

            ztegtrx.setZtegtrxCrcollectortaskfiles(ULong.valueOf(this.sf.getTaskFilesId()));

            int result = (ztegtrx.getZtegtrxId() == null)?ztegtrx.store():ztegtrx.update();

            ztegtrxs.add(ztegtrx);
        }

        logger.debug("prepareGtrx() done");
    }

    private ZtebscRecord getBsc(String SubNetwork, String MEID, String GBssFunction){

        for (int i = 0; i < ztebscs.size(); i++) {

            if(ztebscs.get(i).getSubnetwork().equals(SubNetwork) && ztebscs.get(i).getMeid().equals(MEID) && ztebscs.get(i).getGbssfunction().equals(GBssFunction)){

                return ztebscs.get(i);
            }
        }

        return null;
    }

    private ZtebscRecord getBsc2(String SubNetwork){

        for (int i = 0; i < ztebscs.size(); i++) {

            if(ztebscs.get(i).getSubnetwork().equals(SubNetwork)){

                return ztebscs.get(i);
            }
        }

        return null;
    }

    private ZtebscRecord getBsc3(String SubNetwork, String MEID, String userLabel){

        for (int i = 0; i < ztebscs.size(); i++) {

            if(ztebscs.get(i).getSubnetwork().equals(SubNetwork) && ztebscs.get(i).getMeid().equals(MEID) && ztebscs.get(i).getUserlabel().equals(userLabel)){

                return ztebscs.get(i);
            }
        }

        return null;
    }

    private ZtebtsRecord getBts(String SubNetwork, String MEID, String GBssFunction, String GBtsSiteManager){

        for (int i = 0; i < ztebtss.size(); i++) {

            if(ztebtss.get(i).getSubnetwork().equals(SubNetwork) && ztebtss.get(i).getMeid().equals(MEID) && ztebtss.get(i).getGbssfunction().equals(GBssFunction) && ztebtss.get(i).getGbtssitemanager().equals(GBtsSiteManager)){

                return ztebtss.get(i);
            }
        }

        return null;
    }

    private ZtebtsRecord getBts2(String MOID){

        for (int i = 0; i < ztebtss.size(); i++) {

            if(MOID.startsWith(ztebtss.get(i).getMoi() + ",")){

                return ztebtss.get(i);
            }
        }

        return null;
    }

    private ZtebtsRecord getBts3(String SubNetwork, String MEID, String userLabel){

        for (int i = 0; i < ztebtss.size(); i++) {

            if(ztebtss.get(i).getSubnetwork().equals(SubNetwork) && ztebtss.get(i).getMeid().equals(MEID) && ztebtss.get(i).getUserlabel().equals(userLabel)){

                return ztebtss.get(i);
            }
        }

        return null;
    }

    private ZtegcellRecord getGcell(String SubNetwork, String MEID, String GBssFunction, String GBtsSiteManager, String GGsmCell){

        for (int i = 0; i < ztegcells.size(); i++) {

            if(ztegcells.get(i).getSubnetwork().equals(SubNetwork) && ztegcells.get(i).getMeid().equals(MEID) && ztegcells.get(i).getGbssfunction().equals(GBssFunction) && ztegcells.get(i).getGbtssitemanager().equals(GBtsSiteManager) && ztegcells.get(i).getGgsmcell().equals(GGsmCell)){

                return ztegcells.get(i);
            }
        }

        return null;
    }

    private void updateBsc(DSLContext db){

        logger.debug("updateBsc()");

        logger.debug("updateBsc() done");
    }

    private void clearUnusedData(DSLContext db){

        sf.purgeResult();
        this.result.clear();

        ztebscs.clear();
        gBssFunctions.clear();
        gBtsManagers.clear();
        gGsmCells.clear();
        gTrxs.clear();
    }
}

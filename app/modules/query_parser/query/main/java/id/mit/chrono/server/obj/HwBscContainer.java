package id.mit.chrono.server.obj;

import com.google.common.base.Stopwatch;
import id.mit.chrono.server.base.BaseParserGroup;
import id.mit.chrono.server.enm.PS;
import id.mit.chrono.server.base.HwBaseContainer;
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

import java.time.Instant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import static id.mit.chrono.server.model.Tables.*;

public class HwBscContainer extends HwBaseContainer implements FileProcessor {

    private HwbscRecord hwbsc;
    private List<HwbscbrdRecord> brds = new ArrayList<>();
    private List<HwbscethportRecord> ports = new ArrayList<>();
    private List<Hwbsce1t1Record> e1t1s = new ArrayList<>();
    private List<HwbtsRecord> btss = new ArrayList<>();
    private List<HwgcellRecord> gcells = new ArrayList<>();
    private List<HwgtrxRecord> gtrxs = new ArrayList<>();
    private List<HwgtrxchanRecord> gtrxchans = new ArrayList<>();
    private HashMap<Long, CrnodeRecord> nodeCache = new HashMap();

    public HwBscContainer(DSLContext db, ParserGroupCallback pgc, ChronoContext context, SourceFile sf, MapEntityObj meo) {
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

        this.prepareMbsc(adb);
        addMeasurement(PS.BSC, this.getKey(), true);

        this.prepareMbscBrd(adb);
        addMeasurement(PS.BSCBOARD, this.getKey(), true);

        this.prepareMbscEthPort(adb);
        this.prepareMbscE1T1(adb);
        addMeasurement(PS.BSCPORT, this.getKey(), true);

        this.prepareBts(adb);
        addMeasurement(PS.BTS, this.getKey(), true);

        this.prepareGcell(adb);
        addMeasurement(PS.CELL2G, this.getKey(), true);

//            this.prepareGtrx(adb);
//        addMeasurement(PS.TRX, this.getKey(), true);
//            this.prepareGtrxChan(adb);
//        addMeasurement(PS.TIMESLOT, this.getKey(), true);

        this.updateHwbsc(adb);
        this.clearUnusedData(adb);
        addMeasurement(PS.FINALIZE, this.getKey(), true);

        saveStatistics(adb);

        return true;
    }

    private void prepareMbsc(DSLContext db){

        logger.debug("prepareMbsc()");

        HuaweiBasicKeyParamsObj mml;
        CrmapfieldRecord mfr;

//        hwbsc = db.selectFrom(HWBSC)
//                .where(
//                        HWBSC.HWBSC_DATE.eq(UInteger.valueOf(context.getEpochTime()))
//                        .and(HWBSC.SYSOBJECTID.eq(sf.getKey()))
//                )
//                .fetchOne();

        hwbsc = db.fetchOne(HWBSC, HWBSC.HWBSC_DATE.eq(UInteger.valueOf(context.getEpochTime()))
                .and(HWBSC.BSCNAME.eq(sf.getKey())));

        if(hwbsc == null){

            hwbsc = db.newRecord(HWBSC);

            hwbsc.setHwbscDate(UInteger.valueOf(context.getEpochTime()));
            hwbsc.setBscname(sf.getKey());

//            int result = hwbsc.store();
//            System.out.println("saved: " + result + " => " + hwbsc.getHwbscId() + " => " + sf.getFileName());
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

                    hwbsc.set(DSL.field(mfr.getMapfieldFieldname()), replaceVal);
                }
            }
            else{

                hwbsc.set(DSL.field(mfr.getMapfieldFieldname()), getKeyParamsValue(mfr, null));
            }
        }

        // set mandatory field //
        hwbsc.setHwbscCrcollectortaskfiles(ULong.valueOf(this.sf.getTaskFilesId()));
        hwbsc.setHwbscVendor(meo.mr.getMapentityVendor());

        int res = (hwbsc.getHwbscId() == null)?hwbsc.store():hwbsc.update();

        logger.debug("prepareMbsc() done");
    }

    private void prepareMbscBrd(DSLContext db){

        logger.debug("prepareMbscBrd()");

        // get field definition for hwbts
        MapEntityObj me = meo.getChildEntityByTableName("hwbscbrd");

        // get BTS list
        List<HuaweiBasicKeyParamsObj> addBrds = result.stream()
                .filter(HuaweiBasicKeyParamsObj.class::isInstance)
                .map(HuaweiBasicKeyParamsObj.class::cast)
                .filter(p -> p.command.equals("ADD BRD"))
                .collect(Collectors.toList());

        logger.debug("addBrds.size(): " + addBrds.size());

        addBrds.parallelStream().forEach(objx -> processBrd(db, me, objx));

        // xcheck brds with "MOD BRD"
        List<HuaweiBasicKeyParamsObj> modBrds = result.stream()
                .filter(HuaweiBasicKeyParamsObj.class::isInstance)
                .map(HuaweiBasicKeyParamsObj.class::cast)
                .filter(p -> p.command.equals("MOD BRD"))
                .collect(Collectors.toList());

        CrmapfieldRecord mfr;

        Optional<CrmapfieldRecord> optional = meo.mft.stream().filter(p -> p.getMapfieldSourcegroup().equals("Export start time")).findFirst();
        mfr = optional.get();

        modBrds.parallelStream().forEach(objx -> processModBrd(db, me, objx, mfr));

        // loop to get total subrack and board
        int totalXPU = 0;
        int totalEGPU = 0;
        ArrayList<String> totalSrn = new ArrayList<>();

        for (int i = 0; i < brds.size(); i++) {

            if(brds.get(i).getBrdclass().equals("XPU")){
                totalXPU++;
            }
            else if(brds.get(i).getBrdclass().equals("GPU")){
                totalEGPU++;
            }

            // subrack
            if(!totalSrn.contains(brds.get(i).getSrn())){

                totalSrn.add(brds.get(i).getSrn());
            }
        }

        synchronized (hwbsc){

            hwbsc.setTotalsubrack(totalSrn.size());
            hwbsc.setTotalbrd(brds.size());
            hwbsc.update();
        }

        logger.debug("prepareMbscBrd() done");
    }

    private void processBrd(DSLContext db, MapEntityObj me, HuaweiBasicKeyParamsObj obj){

        HuaweiBasicKeyParamsObj mml;
        CrmapfieldRecord mfr;

        String key = "SRN";
        String key2 = "SN";

        // select from DB, if not found, then create a new one
        HwbscbrdRecord brd = db.selectFrom(HWBSCBRD)
                .where(
                        HWBSCBRD.HWBSCBRD_DATE.eq(UInteger.valueOf(context.getEpochTime()))
                                .and(HWBSCBRD.HWBSCBRD_HWBSC.eq(hwbsc.getHwbscId()))
                                .and(HWBSCBRD.SRN.eq(obj.params.get(key)))
                                .and(HWBSCBRD.SN.eq(obj.params.get(key2)))
                )
                .fetchOne();

        if(brd == null){

            brd = db.newRecord(HWBSCBRD);

            brd.setHwbscbrdDate(UInteger.valueOf(context.getEpochTime()));
            brd.setHwbscbrdHwbsc(hwbsc.getHwbscId());
            brd.setSrn(obj.params.get(key));
            brd.setSn(obj.params.get(key2));
        }

        ArrayList<String> filters = new ArrayList<>();
        filters.add(key);
        filters.add(obj.params.get(key));
        filters.add(key2);
        filters.add(obj.params.get(key2));

        for (int l = 0; l < me.mft.size(); l++) {

            mfr = me.mft.get(l);

            // if need replace from chrono.context
            if(mfr.getMapfieldSourcegroup().equals("chrono.context")){

                String replaceVal = null;

                switch(mfr.getMapfieldSourceparam()){

                    case "DATE": replaceVal = String.valueOf(context.getEpochTime()); break;
                    case "PARENTKEY": replaceVal = hwbsc.getHwbscId().toString(); break;
                    default: break;
                }

                if(replaceVal != null){

                    brd.set(DSL.field(mfr.getMapfieldFieldname()), replaceVal);
                }
            }
            else{

                String val = getKeyParamsValue(mfr, filters);
                if(val != null){

                    brd.set(DSL.field(mfr.getMapfieldFieldname()), val);
                }
            }
        }

        brd.setHwbscbrdCrcollectortaskfiles(ULong.valueOf(this.sf.getTaskFilesId()));

        int res = (brd.getHwbscbrdId() == null)?brd.store():brd.update();

        synchronized (brds){

            brds.add(brd);
        }
    }


    private void processModBrd(DSLContext db, MapEntityObj me, HuaweiBasicKeyParamsObj obj, CrmapfieldRecord mfr){

        HuaweiBasicKeyParamsObj mml;

        String key = "SRN";
        String key2 = "SN";

        boolean found = false;

        // search in brds
        for (int j = 0; !found && j < brds.size(); j++) {

            if(brds.get(j).getSrn().equals(obj.params.get(key)) &&
                    brds.get(j).getSn().equals(obj.params.get(key2)) ){

                found = true;
            }
        }

        if(!found){

            // select from DB, if not found, then create a new one
            HwbscbrdRecord brd = db.selectFrom(HWBSCBRD)
                    .where(
                            HWBSCBRD.HWBSCBRD_DATE.eq(UInteger.valueOf(context.getEpochTime()))
                                    .and(HWBSCBRD.HWBSCBRD_HWBSC.eq(hwbsc.getHwbscId()))
                                    .and(HWBSCBRD.SRN.eq(obj.params.get(key)))
                                    .and(HWBSCBRD.SN.eq(obj.params.get(key2)))
                    )
                    .fetchOne();

            if(brd == null){

                brd = db.newRecord(HWBSCBRD);

                brd.setHwbscbrdDate(UInteger.valueOf(context.getEpochTime()));
                brd.setHwbscbrdHwbsc(hwbsc.getHwbscId());
                brd.setSrn(obj.params.get(key));
                brd.setSn(obj.params.get(key2));
            }

            ArrayList<String> filters = new ArrayList<>();
            filters.add(key);
            filters.add(obj.params.get(key));
            filters.add(key2);
            filters.add(obj.params.get(key2));

            brd.setHwbscbrdDate(UInteger.valueOf(context.getEpochTime()));
            brd.setHwbscbrdHwbsc(hwbsc.getHwbscId());

            brd.set(DSL.field(mfr.getMapfieldFieldname()), getKeyParamsValue(mfr, filters));

            brd.setBrdclass(obj.params.get("BRDCLASS"));
            brd.setBrdtype(obj.params.get("BRDTYPE"));

            brd.setHwbscbrdCrcollectortaskfiles(ULong.valueOf(this.sf.getTaskFilesId()));

            int res = (brd.getHwbscbrdId() == null)?brd.store():brd.update();

            synchronized (brds){

                brds.add(brd);
            }
        }
    }


    private void prepareMbscEthPort(DSLContext db){

        logger.debug("prepareMbscEthPort()");

        HuaweiBasicKeyParamsObj mml;
        CrmapfieldRecord mfr;

        // get field definition for hwbts
        MapEntityObj me = meo.getChildEntityByTableName("hwbscethport");

        String key = "SRN";
        String key2 = "SN";
        String key3 = "PN";

        // get BTS list
        List<HuaweiBasicKeyParamsObj> setEthPorts = result.stream()
                .filter(HuaweiBasicKeyParamsObj.class::isInstance)
                .map(HuaweiBasicKeyParamsObj.class::cast)
                .filter(p -> p.command.equals("SET ETHPORT"))
                .collect(Collectors.toList());

        for (int i = 0; i < setEthPorts.size(); i++) {

            // select from DB, if not found, then create a new one
            HwbscethportRecord port = db.selectFrom(HWBSCETHPORT)
                    .where(
                            HWBSCETHPORT.HWBSCETHPORT_DATE.eq(UInteger.valueOf(context.getEpochTime()))
                            .and(HWBSCETHPORT.HWBSCETHPORT_HWBSC.eq(hwbsc.getHwbscId()))
                            .and(HWBSCETHPORT.SRN.eq(setEthPorts.get(i).params.get(key)))
                            .and(HWBSCETHPORT.SN.eq(setEthPorts.get(i).params.get(key2)))
                            .and(HWBSCETHPORT.PN.eq(setEthPorts.get(i).params.get(key3)))
                    )
                    .fetchOne();

            if(port == null){

                port = db.newRecord(HWBSCETHPORT);

                port.setHwbscethportDate(UInteger.valueOf(context.getEpochTime()));
                port.setHwbscethportHwbsc(hwbsc.getHwbscId());
                port.setSrn(setEthPorts.get(i).params.get(key));
                port.setSn(setEthPorts.get(i).params.get(key2));
                port.setPn(setEthPorts.get(i).params.get(key3));

//                port.store();
            }

            ArrayList<String> filters = new ArrayList<>();
            filters.add(key);
            filters.add(setEthPorts.get(i).params.get(key));
            filters.add(key2);
            filters.add(setEthPorts.get(i).params.get(key2));
            filters.add(key3);
            filters.add(setEthPorts.get(i).params.get(key3));

            for (int l = 0; l < me.mft.size(); l++) {

                mfr = me.mft.get(l);

                // if need replace from chrono.context
                if(mfr.getMapfieldSourcegroup().equals("chrono.context")){

                    String replaceVal = null;

                    switch(mfr.getMapfieldSourceparam()){

                        case "DATE": replaceVal = String.valueOf(context.getEpochTime()); break;
                        case "PARENTKEY": replaceVal = hwbsc.getHwbscId().toString(); break;
                        default: break;
                    }

                    if(replaceVal != null){

                        port.set(DSL.field(mfr.getMapfieldFieldname()), replaceVal);
                    }
                }
                else{

                    port.set(DSL.field(mfr.getMapfieldFieldname()), getKeyParamsValue(mfr, filters));
                }
            }

            // set relation to brd
            for (int j = 0; j < brds.size(); j++) {

                if(brds.get(j).getSrn().equals(port.getSrn()) &&
                        brds.get(j).getSn().equals(port.getSn())){

                    port.setHwbscethportHwbscbrd(brds.get(j).getHwbscbrdId());
                    break;
                }
            }

            port.setHwbscethportCrcollectortaskfiles(ULong.valueOf(this.sf.getTaskFilesId()));
            int res = (port.getHwbscethportId() == null)?port.store():port.update();

            ports.add(port);
        }

        logger.debug("prepareMbscEthPort() done");
    }

    private void prepareMbscE1T1(DSLContext db){

        logger.debug("prepareMbscE1T1()");

        HuaweiBasicKeyParamsObj mml;
        CrmapfieldRecord mfr;

        // get field definition for hwbts
        MapEntityObj me = meo.getChildEntityByTableName("hwbsce1t1");

        String key = "SRN";
        String key2 = "SN";
        String key3 = "PN";

        // get BTS list
        List<HuaweiBasicKeyParamsObj> set1t1s = result.stream()
                .filter(HuaweiBasicKeyParamsObj.class::isInstance)
                .map(HuaweiBasicKeyParamsObj.class::cast)
                .filter(p -> p.command.equals("SET E1T1"))
                .collect(Collectors.toList());

        for (int i = 0; i < set1t1s.size(); i++) {

            // if not contains key3, then skip for today
            if(!set1t1s.get(i).params.containsKey(key3)){
                continue;
            }

            // select from DB, if not found, then create a new one
            Hwbsce1t1Record e1t1 = db.selectFrom(HWBSCE1T1)
                    .where(
                            HWBSCE1T1.HWBSCE1T1_DATE.eq(UInteger.valueOf(context.getEpochTime()))
                            .and(HWBSCE1T1.HWBSCE1T1_HWBSC.eq(hwbsc.getHwbscId()))
                            .and(HWBSCE1T1.SRN.eq(set1t1s.get(i).params.get(key)))
                            .and(HWBSCE1T1.SN.eq(set1t1s.get(i).params.get(key2)))
                            .and(HWBSCE1T1.PN.eq(set1t1s.get(i).params.get(key3)))
                    )
                    .fetchOne();

            if(e1t1 == null){

                e1t1 = db.newRecord(HWBSCE1T1);

                e1t1.setHwbsce1t1Date(UInteger.valueOf(context.getEpochTime()));
                e1t1.setHwbsce1t1Hwbsc(hwbsc.getHwbscId());
                e1t1.setSrn(set1t1s.get(i).params.get(key));
                e1t1.setSn(set1t1s.get(i).params.get(key2));
                e1t1.setPn(set1t1s.get(i).params.get(key3));

            }

            ArrayList<String> filters = new ArrayList<>();
            filters.add(key);
            filters.add(set1t1s.get(i).params.get(key));
            filters.add(key2);
            filters.add(set1t1s.get(i).params.get(key2));
            filters.add(key3);
            filters.add(set1t1s.get(i).params.get(key3));

            for (int l = 0; l < me.mft.size(); l++) {

                mfr = me.mft.get(l);

                // if need replace from chrono.context
                if(mfr.getMapfieldSourcegroup().equals("chrono.context")){

                    String replaceVal = null;

                    switch(mfr.getMapfieldSourceparam()){

                        case "DATE": replaceVal = String.valueOf(context.getEpochTime()); break;
                        case "PARENTKEY": replaceVal = hwbsc.getHwbscId().toString(); break;
                        default: break;
                    }

                    if(replaceVal != null){

                        e1t1.set(DSL.field(mfr.getMapfieldFieldname()), replaceVal);
                    }
                }
                else{

                    e1t1.set(DSL.field(mfr.getMapfieldFieldname()), getKeyParamsValue(mfr, filters));
                }
            }

            // set relation to brd
            for (int j = 0; j < brds.size(); j++) {

                if(brds.get(j).getSrn().equals(e1t1.getSrn()) &&
                        brds.get(j).getSn().equals(e1t1.getSn())){

                    e1t1.setHwbsce1t1Hwbscbrd(brds.get(j).getHwbscbrdId());
                    break;
                }
            }

            e1t1.setHwbsce1t1Crcollectortaskfiles(ULong.valueOf(this.sf.getTaskFilesId()));
            int res = (e1t1.getHwbsce1t1Id() == null)?e1t1.store():e1t1.update();

            e1t1s.add(e1t1);
        }

        logger.debug("prepareMbscE1T1() done");
    }

    private void prepareBts(DSLContext db){

        logger.debug("prepareBts()");

        HuaweiBasicKeyParamsObj mml;
        CrmapfieldRecord mfr;

        // get field definition for hwbts
        MapEntityObj me = meo.getChildEntityByTableName("hwbts");

        // get BTS list
        List<HuaweiBasicKeyParamsObj> addBtss = result.stream()
                .filter(HuaweiBasicKeyParamsObj.class::isInstance)
                .map(HuaweiBasicKeyParamsObj.class::cast)
                .filter(p -> p.command.equals("ADD BTS"))
                .collect(Collectors.toList());

        // get GCELL for BTS list
        List<HuaweiBasicKeyParamsObj> addCellbind2BTS = result.stream()
                .filter(HuaweiBasicKeyParamsObj.class::isInstance)
                .map(HuaweiBasicKeyParamsObj.class::cast)
                .filter(p -> p.command.equals("ADD CELLBIND2BTS"))
                .collect(Collectors.toList());

        // get BTS list
        List<HuaweiBasicKeyParamsObj> addGtrxs = result.stream()
                .filter(HuaweiBasicKeyParamsObj.class::isInstance)
                .map(HuaweiBasicKeyParamsObj.class::cast)
                .filter(p -> p.command.equals("ADD GTRX"))
                .collect(Collectors.toList());

        String key = "BTSID";
        String key2 = "CELLID";

        for (int i = 0; i < addBtss.size(); i++) {

            // select from DB, if not found, then create a new one

            HwbtsRecord bts = db.selectFrom(HWBTS)
                    .where(HWBTS.HWBTS_DATE.eq(UInteger.valueOf(context.getEpochTime()))
                        .and(HWBTS.HWBTS_HWBSC.eq(hwbsc.getHwbscId()))
                        .and(HWBTS.BTSID.eq(addBtss.get(i).params.get("BTSID")))
                    )
                    .fetchOne();

            if(bts == null){

                bts = db.newRecord(HWBTS);

                bts.setHwbtsCrcollectortaskfiles(ULong.valueOf(this.sf.getTaskFilesId()));
                bts.setHwbtsDate(UInteger.valueOf(context.getEpochTime()));
                bts.setHwbtsHwbsc(hwbsc.getHwbscId());
                bts.setBtsid(addBtss.get(i).params.get("BTSID"));
            }

            ArrayList<String> filters = new ArrayList<>();
            filters.add("BTSID");
            filters.add(addBtss.get(i).params.get("BTSID"));

            for (int l = 0; l < me.mft.size(); l++) {

                mfr = me.mft.get(l);

                // if need replace from chrono.context
                if(mfr.getMapfieldSourcegroup().equals("chrono.context")){

                    String replaceVal = null;

                    switch(mfr.getMapfieldSourceparam()){

                        case "DATE": replaceVal = String.valueOf(context.getEpochTime()); break;
                        case "PARENTKEY": replaceVal = hwbsc.getHwbscId().toString(); break;
                        default: break;
                    }

                    if(replaceVal != null){

                        bts.set(DSL.field(mfr.getMapfieldFieldname()), replaceVal);
                    }
                }
                else{

                    bts.set(DSL.field(mfr.getMapfieldFieldname()), getKeyParamsValue(mfr, filters));
                }
            }

            // set relation to crnode
            CrnodeRecord node = pgc.getNode(meo.mr.getMapentityVendor(), bts.getBtsname(), meo.mr.getMapentityNodecategory());

            if(node != null){

                bts.setHwbtsNode(node.getNodeId());
                bts.setHwbtsRevenueclass(node.getNodeRevenueclass());
            }

            // update count of cell
            int totalCell = 0;
            int totalTrx = 0;

            for (int j = 0; j < addCellbind2BTS.size(); j++) {

                if(addCellbind2BTS.get(j).params.get(key).equals(bts.getBtsid())){
                    totalCell++;

                    // get associated TRX
                    for (int k = 0; k < addGtrxs.size(); k++) {

                        if(addCellbind2BTS.get(j).params.get(key2).equals(addGtrxs.get(k).params.get(key2))){

                            totalTrx++;
                        }
                    }
                }
            }

            bts.setTotalcell(totalCell);
            bts.setTotaltrx(totalTrx);

            bts.setHwbtsVendor(meo.mr.getMapentityVendor());

            int res = (bts.getHwbtsId() == null)?bts.store():bts.update();

            if(node != null){

                nodeCache.put(bts.getHwbtsId().longValue(), node);
            }

            btss.add(bts);
        }

        synchronized (hwbsc){

            hwbsc.setTotalbts(btss.size());
            hwbsc.setTotaltrx(addGtrxs.size());
            hwbsc.update();
        }

        logger.debug("prepareBts() done");
    }

    private void prepareGcell(DSLContext db){

        logger.debug("prepareGcell()");

        HuaweiBasicKeyParamsObj mml;
        CrmapfieldRecord mfr;

        // get field definition for hwgcell
        MapEntityObj me = meo.getChildEntityByTableName("hwgcell");

        // get BTS list
        List<HuaweiBasicKeyParamsObj> addGcells = result.stream()
                .filter(HuaweiBasicKeyParamsObj.class::isInstance)
                .map(HuaweiBasicKeyParamsObj.class::cast)
                .filter(p -> p.command.equals("ADD GCELL"))
                .collect(Collectors.toList());

        List<HuaweiBasicKeyParamsObj> addGtrxs = result.stream()
                .filter(HuaweiBasicKeyParamsObj.class::isInstance)
                .map(HuaweiBasicKeyParamsObj.class::cast)
                .filter(p -> p.command.equals("ADD GTRX"))
                .collect(Collectors.toList());

        String key = "CELLID";

        for (int i = 0; i < addGcells.size(); i++) {

            // select from DB, if not found, then create a new one

            HwgcellRecord gcell = db.selectFrom(HWGCELL)
                    .where(
                            HWGCELL.HWGCELL_DATE.eq(UInteger.valueOf(context.getEpochTime()))
                            .and(HWGCELL.HWGCELL_HWBSC.eq(hwbsc.getHwbscId()))
                            .and(HWGCELL.CELLID.eq(addGcells.get(i).params.get("CELLID")))
                    )
                    .fetchOne();

//            HwgcellRecord gcell = null;

            if(gcell == null){

                gcell = db.newRecord(HWGCELL);

                gcell.setHwgcellCrcollectortaskfiles(ULong.valueOf(this.sf.getTaskFilesId()));
                gcell.setHwgcellDate(UInteger.valueOf(context.getEpochTime()));
                gcell.setHwgcellHwbsc(hwbsc.getHwbscId());
                gcell.setCellid(addGcells.get(i).params.get("CELLID"));

            }

            ArrayList<String> filters = new ArrayList<>();
            filters.add("CELLID");
            filters.add(addGcells.get(i).params.get("CELLID"));

            for (int l = 0; l < me.mft.size(); l++) {

                mfr = me.mft.get(l);

                // if need replace from chrono.context
                if(mfr.getMapfieldSourcegroup().equals("chrono.context")){

                    String replaceVal = null;

                    switch(mfr.getMapfieldSourceparam()){

                        case "DATE": replaceVal = String.valueOf(context.getEpochTime()); break;
                        case "PARENTKEYBSC": replaceVal = hwbsc.getHwbscId().toString(); break;
                        default: break;
                    }

                    if(replaceVal != null){

                        gcell.set(DSL.field(mfr.getMapfieldFieldname()), replaceVal);
                    }
                }
                else{

                    gcell.set(DSL.field(mfr.getMapfieldFieldname()), getKeyParamsValue(mfr, filters));
                }
            }

            CrnodeRecord node = null;

            for (int j = 0; j < btss.size(); j++) {

                if(btss.get(j).getBtsid().equals(gcell.getBtsid())){

                    gcell.setHwgcellHwbts(btss.get(j).getHwbtsId());
                    gcell.setHwgcellRevenueclass(btss.get(j).getHwbtsRevenueclass());

                    node = nodeCache.get(btss.get(j).getHwbtsId().longValue());

                    break;
                }
            }

            int totalTrx = 0;

            // get associated TRX
            for (int k = 0; k < addGtrxs.size(); k++) {

                if(gcell.getCellid().equals(addGtrxs.get(k).params.get(key))){

                    totalTrx++;
                }
            }

            gcell.setTotaltrx(totalTrx);

            String cgi = gcell.getMcc() + "-" + gcell.getMnc() + "-" + gcell.getLac() + "-" + gcell.getCi();

            CrcellRecord cellProto = CellUtils.getCellProto(gcell, node);

            // set relation to crcell
            CrcellRecord cell = pgc.getCell(gcell.getType(), cgi, cellProto, node);

            if(cell != null){

                gcell.setHwgcellCell(cell.getCellId());
                gcell.setHwgcellCellclass(cell.getCellCellclass());
                gcell.setHwgcellCellcoverage(cell.getCellCellcoverage());
                gcell.setHwgcellRevenueclass(cell.getCellRevenueclass());
            }

            // set calculated lat lon decimal
//            gcell.setLatitude(GeoUtil.getHuawei2GLat(gcell.getNslati(), gcell.getLatiint(), gcell.getLatideci()));
//            gcell.setLongitude(GeoUtil.getHuawei2GLon(gcell.getWelongi(), gcell.getLongiint(), gcell.getLongideci()));

            gcell.setCgi(cgi);
            gcell.setBsic(Integer.parseInt(gcell.getNcc())*8 + Integer.parseInt(gcell.getBcc()));

            int res = (gcell.getHwgcellId() == null)?gcell.store():gcell.update();
            gcells.add(gcell);
        }

//        db.batchStore(gcells).execute();

        synchronized (hwbsc){

            hwbsc.setTotalcell(gcells.size());
        }

        logger.debug("prepareGcell() done");
    }

    private void prepareGtrx(DSLContext db){

        logger.debug("prepareGtrx()");

        HuaweiBasicKeyParamsObj mml;
        CrmapfieldRecord mfr;

        // get field definition for hwgcell
        MapEntityObj me = meo.getChildEntityByTableName("hwgtrx");

        String key = "TRXID";

        // get TRX list
        List<HuaweiBasicKeyParamsObj> addGtrxs = result.stream()
                .filter(HuaweiBasicKeyParamsObj.class::isInstance)
                .map(HuaweiBasicKeyParamsObj.class::cast)
                .filter(p -> p.command.equals("ADD GTRX"))
                .collect(Collectors.toList());

        for (int i = 0; i < addGtrxs.size(); i++) {

            // select from DB, if not found, then create a new one

            HwgtrxRecord gtrx = db.selectFrom(HWGTRX)
                    .where(
                            HWGTRX.HWGTRX_DATE.eq(UInteger.valueOf(context.getEpochTime()))
                            .and(HWGTRX.HWGTRX_HWBSC.eq(hwbsc.getHwbscId()))
                            .and(HWGTRX.TRXID.eq(addGtrxs.get(i).params.get(key)))
                    )
                    .fetchOne();

            if(gtrx == null){

                gtrx = db.newRecord(HWGTRX);

                gtrx.setHwgtrxCrcollectortaskfiles(ULong.valueOf(this.sf.getTaskFilesId()));
                gtrx.setHwgtrxDate(UInteger.valueOf(context.getEpochTime()));
                gtrx.setHwgtrxHwbsc(hwbsc.getHwbscId());
                gtrx.setTrxid(addGtrxs.get(i).params.get(key));

            }

            ArrayList<String> filters = new ArrayList<>();
            filters.add(key);
            filters.add(addGtrxs.get(i).params.get(key));

            for (int l = 0; l < me.mft.size(); l++) {

                mfr = me.mft.get(l);

                // if need replace from chrono.context
                if(mfr.getMapfieldSourcegroup().equals("chrono.context")){

                    String replaceVal = null;

                    switch(mfr.getMapfieldSourceparam()){

                        case "DATE": replaceVal = String.valueOf(context.getEpochTime()); break;
                        case "PARENTKEYBSC": replaceVal = hwbsc.getHwbscId().toString(); break;
                        default: break;
                    }

                    if(replaceVal != null){

                        gtrx.set(DSL.field(mfr.getMapfieldFieldname()), replaceVal);
                    }
                }
                else{

                    gtrx.set(DSL.field(mfr.getMapfieldFieldname()), getKeyParamsValue(mfr, filters));
                }
            }

            for (int j = 0; j < gcells.size(); j++) {

                if(gcells.get(j).getCellid().equals(gtrx.getCellid())){

                    gtrx.setHwgtrxHwgcell(gcells.get(j).getHwgcellId());

                    if(gcells.get(j).getHwgcellHwbts() != null){
                        gtrx.setHwgtrxHwbts(gcells.get(j).getHwgcellHwbts());
                    }
                    break;
                }
            }

            int res = (gtrx.getHwgtrxId() == null)?gtrx.store():gtrx.update();
            gtrxs.add(gtrx);
        }

        synchronized (hwbsc){

            hwbsc.setTotaltrx(gtrxs.size());
        }

        logger.debug("prepareGtrx() done");
    }

    private void prepareGtrxChan(DSLContext db){

        logger.debug("prepareGtrxChan()");

        HuaweiBasicKeyParamsObj mml;
        CrmapfieldRecord mfr;

        // get field definition for hwgcell
        MapEntityObj me = meo.getChildEntityByTableName("hwgtrxchan");

        String key = "TRXID";
        String key2 = "CHNO";

        // get BTS list
        List<HuaweiBasicKeyParamsObj> addGtrxChans = result.stream()
                .filter(HuaweiBasicKeyParamsObj.class::isInstance)
                .map(HuaweiBasicKeyParamsObj.class::cast)
                .filter(p -> p.command.equals("SET GTRXCHAN"))
                .collect(Collectors.toList());

        HwgtrxchanRecord gtrxchan = null;

        for (int i = 0; i < addGtrxChans.size(); i++) {

            // select from DB, if not found, then create a new one

            gtrxchan = db.selectFrom(HWGTRXCHAN)
                    .where(
                            HWGTRXCHAN.HWGTRXCHAN_DATE.eq(UInteger.valueOf(context.getEpochTime()))
                            .and(HWGTRXCHAN.HWGTRXCHAN_HWBSC.eq(hwbsc.getHwbscId()))
                            .and(HWGTRXCHAN.TRXID.eq(addGtrxChans.get(i).params.get(key)))
                            .and(HWGTRXCHAN.CHNO.eq(addGtrxChans.get(i).params.get(key2)))
                    )
                    .fetchOne();

            if(gtrxchan == null){

                gtrxchan = db.newRecord(HWGTRXCHAN);

                gtrxchan.setHwgtrxchanCrcollectortaskfiles(ULong.valueOf(this.sf.getTaskFilesId()));
                gtrxchan.setHwgtrxchanDate(UInteger.valueOf(context.getEpochTime()));
                gtrxchan.setHwgtrxchanHwbsc(hwbsc.getHwbscId());
                gtrxchan.setTrxid(addGtrxChans.get(i).params.get(key));
                gtrxchan.setChno(addGtrxChans.get(i).params.get(key2));

            }

            ArrayList<String> filters = new ArrayList<>();
            filters.add(key);
            filters.add(addGtrxChans.get(i).params.get(key));
            filters.add(key2);
            filters.add(addGtrxChans.get(i).params.get(key2));

            for (int l = 0; l < me.mft.size(); l++) {

                mfr = me.mft.get(l);

                // if need replace from chrono.context
                if(mfr.getMapfieldSourcegroup().equals("chrono.context")){

                    String replaceVal = null;

                    switch(mfr.getMapfieldSourceparam()){

                        case "DATE": replaceVal = String.valueOf(context.getEpochTime()); break;
                        case "PARENTKEYBSC": replaceVal = hwbsc.getHwbscId().toString(); break;
                        default: break;
                    }

                    if(replaceVal != null){

                        gtrxchan.set(DSL.field(mfr.getMapfieldFieldname()), replaceVal);
                    }
                }
                else{

                    gtrxchan.set(DSL.field(mfr.getMapfieldFieldname()), getKeyParamsValue(mfr, filters));
                }
            }

            for (int j = 0; j < gtrxs.size(); j++) {

                if(gtrxs.get(j).getTrxid().equals(gtrxchan.getTrxid())){

                    gtrxchan.setHwgtrxchanHwgtrx(gtrxs.get(j).getHwgtrxId());

                    if(gtrxs.get(j).getHwgtrxHwgcell() != null){
                        gtrxchan.setHwgtrxchanHwgcell(gtrxs.get(j).getHwgtrxHwgcell());
                    }

                    if(gtrxs.get(j).getHwgtrxHwbts() != null){
                        gtrxchan.setHwgtrxchanHwbts(gtrxs.get(j).getHwgtrxHwbts());
                    }

                    break;
                }
            }

            int res = (gtrxchan.getHwgtrxchanId() == null)?gtrxchan.store():gtrxchan.update();
            gtrxchans.add(gtrxchan);
        }

        logger.debug("prepareGtrxChan() done: ");
    }

    private void updateHwbsc(DSLContext db){

        logger.debug("updateHwbsc()");
        if(hwbsc.changed()){
            hwbsc.update();
        }
        logger.debug("updateHwbsc() done");
    }

    private void clearUnusedData(DSLContext db){

        logger.debug("clearUnusedData()");

        sf.purgeResult();
        this.result = null;
        this.brds = null;
        this.ports = null;
        this.e1t1s = null;
        this.btss = null;
        this.gcells = null;
        this.gtrxs = null;
        this.gtrxchans = null;
    }
}

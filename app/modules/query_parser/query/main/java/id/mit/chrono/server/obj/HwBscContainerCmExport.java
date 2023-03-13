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

import java.util.*;
import java.util.stream.Collectors;

import static id.mit.chrono.server.model.Tables.*;

public class HwBscContainerCmExport extends HwBaseContainer implements FileProcessor {

    private HwbscRecord hwbsc;
    private List<HwbscbrdRecord> brds = new ArrayList<>();
    private List<HwbscethportRecord> ports = new ArrayList<>();
    private List<Hwbsce1t1Record> e1t1s = new ArrayList<>();
    private List<HwbtsRecord> btss = new ArrayList<>();
    private List<HwgcellRecord> gcells = new ArrayList<>();
    private List<HwgtrxRecord> gtrxs = new ArrayList<>();
    private List<HwgtrxchanRecord> gtrxchans = new ArrayList<>();
    private HashMap<Long, CrnodeRecord> nodeCache = new HashMap();

    List<HuaweiBasicKeyParamsObj> GSMBTSs;
    List<HuaweiBasicKeyParamsObj> GSMGCELLs;
    List<HuaweiBasicKeyParamsObj> GSMTRXs;
    List<HuaweiBasicKeyParamsObj> GCELLLCSs;

    public HwBscContainerCmExport(DSLContext db, ParserGroupCallback pgc, ChronoContext context, SourceFile sf, MapEntityObj meo) {
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

        // get BTS list
        GSMBTSs = result.stream()
                .filter(HuaweiBasicKeyParamsObj.class::isInstance)
                .map(HuaweiBasicKeyParamsObj.class::cast)
                .filter(p -> p.command.matches("^BSC\\d+GSMBTS$"))
                .collect(Collectors.toList());

        logger.debug("GSMBTSs.size(): " + GSMBTSs.size());

        GSMGCELLs = result.stream()
                .filter(HuaweiBasicKeyParamsObj.class::isInstance)
                .map(HuaweiBasicKeyParamsObj.class::cast)
                .filter(p -> p.command.matches("^BSC\\d+GSMGCELL$") || p.command.matches("^BSC\\d+GSMCell$"))
                .collect(Collectors.toList());

        logger.debug("GSMGCELLs.size(): " + GSMGCELLs.size());

        GSMTRXs = result.stream()
                .filter(HuaweiBasicKeyParamsObj.class::isInstance)
                .map(HuaweiBasicKeyParamsObj.class::cast)
                .filter(p -> p.command.matches("^BSC\\d+GSMGTRX$"))
                .collect(Collectors.toList());

        logger.debug("GSMTRXs.size(): " + GSMTRXs.size());

        GCELLLCSs = result.stream()
                .filter(HuaweiBasicKeyParamsObj.class::isInstance)
                .map(HuaweiBasicKeyParamsObj.class::cast)
                .filter(p -> p.command.matches("^BSC\\d+GSMGCELLLCS$"))
                .collect(Collectors.toList());

        logger.debug("GCELLLCSs.size(): " + GCELLLCSs.size());

        addMeasurement(PS.PREPARE, this.getKey(), true);

        this.prepareMbsc(adb);
        addMeasurement(PS.BSC, this.getKey(), true);

//        this.prepareMbscBrd(adb);
//        addMeasurement(PS.BSCBOARD, this.getKey(), true);
//
//        this.prepareMbscEthPort(adb);
//        this.prepareMbscE1T1(adb);
//        addMeasurement(PS.BSCPORT, this.getKey(), true);

        this.prepareBts(adb);
        addMeasurement(PS.BTS, this.getKey(), true);
//
        this.prepareGcell(adb);
        addMeasurement(PS.CELL2G, this.getKey(), true);

//        this.prepareGtrx(adb);
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

                String val = getKeyParamsValue(mfr, null);

                if(val != null){

                    hwbsc.set(DSL.field(mfr.getMapfieldFieldname()), val);
                }
            }
        }

        hwbsc.setTotalbts(GSMBTSs.size());
        hwbsc.setTotalcell(GSMGCELLs.size());
        hwbsc.setTotaltrx(GSMTRXs.size());
        hwbsc.setHwbscVendor(meo.mr.getMapentityVendor());

        CrnodeRecord node = pgc.getNode(meo.mr.getMapentityVendor(), hwbsc.getBscname(), meo.mr.getMapentityNodecategory());

        if(node != null){

            hwbsc.setHwbscNode(node.getNodeId());
        }

        // set mandatory field //
        hwbsc.setHwbscCrcollectortaskfiles(ULong.valueOf(this.sf.getTaskFilesId()));
        hwbsc.setHwbscVendor(meo.mr.getMapentityVendor());

        System.out.println("log:" + this.sf.getTaskFilesId());
        int res = (hwbsc.getHwbscId() == null)?hwbsc.store():hwbsc.update();

        logger.debug("prepareMbsc() done");
    }

    private void prepareMbscBrd(DSLContext db){

        logger.debug("prepareMbscBrd()");

        HuaweiBasicKeyParamsObj mml;
        CrmapfieldRecord mfr;

        // get field definition for hwbts
        MapEntityObj me = meo.getChildEntityByTableName("hwbscbrd");

        String key = "SRN";
        String key2 = "SN";

        // get BTS list
        List<HuaweiBasicKeyParamsObj> addBrds = result.stream()
                .filter(HuaweiBasicKeyParamsObj.class::isInstance)
                .map(HuaweiBasicKeyParamsObj.class::cast)
                .filter(p -> p.command.equals("ADD BRD"))
                .collect(Collectors.toList());

        System.out.println("addBrds.size(): " + addBrds.size());

        for (int i = 0; i < addBrds.size(); i++) {

            // select from DB, if not found, then create a new one
            HwbscbrdRecord brd = db.selectFrom(HWBSCBRD)
                    .where(
                            HWBSCBRD.HWBSCBRD_DATE.eq(UInteger.valueOf(context.getEpochTime()))
                                .and(HWBSCBRD.HWBSCBRD_HWBSC.eq(hwbsc.getHwbscId()))
                                .and(HWBSCBRD.SRN.eq(addBrds.get(i).params.get(key)))
                                .and(HWBSCBRD.SN.eq(addBrds.get(i).params.get(key2)))
                    )
                    .fetchOne();

            if(brd == null){

                brd = db.newRecord(HWBSCBRD);

                brd.setHwbscbrdDate(UInteger.valueOf(context.getEpochTime()));
                brd.setHwbscbrdHwbsc(hwbsc.getHwbscId());
                brd.setSrn(addBrds.get(i).params.get(key));
                brd.setSn(addBrds.get(i).params.get(key2));

//                brd.store();
            }

            ArrayList<String> filters = new ArrayList<>();
            filters.add(key);
            filters.add(addBrds.get(i).params.get(key));
            filters.add(key2);
            filters.add(addBrds.get(i).params.get(key2));

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

                    brd.set(DSL.field(mfr.getMapfieldFieldname()), getKeyParamsValue(mfr, filters));
                }
            }

            brd.setHwbscbrdCrcollectortaskfiles(ULong.valueOf(this.sf.getTaskFilesId()));

            int res = (brd.getHwbscbrdId() == null)?brd.store():brd.update();

            brds.add(brd);
        }

        // xcheck brds with "MOD BRD"
        List<HuaweiBasicKeyParamsObj> modBrds = result.stream()
                .filter(HuaweiBasicKeyParamsObj.class::isInstance)
                .map(HuaweiBasicKeyParamsObj.class::cast)
                .filter(p -> p.command.equals("MOD BRD"))
                .collect(Collectors.toList());

        Optional<CrmapfieldRecord> optional = meo.mft.stream().filter(p -> p.getMapfieldSourcegroup().equals("Export start time")).findFirst();
        mfr = optional.get();

        for (int i = 0; i < modBrds.size(); i++) {

            boolean found = false;

            // search in brds
            for (int j = 0; !found && j < brds.size(); j++) {

                if(brds.get(j).getSrn().equals(modBrds.get(i).params.get(key)) &&
                        brds.get(j).getSn().equals(modBrds.get(i).params.get(key2)) ){

                    found = true;
                }
            }

            if(!found){

                // select from DB, if not found, then create a new one
                HwbscbrdRecord brd = db.selectFrom(HWBSCBRD)
                        .where(
                                HWBSCBRD.HWBSCBRD_DATE.eq(UInteger.valueOf(context.getEpochTime()))
                                        .and(HWBSCBRD.HWBSCBRD_HWBSC.eq(hwbsc.getHwbscId()))
                                        .and(HWBSCBRD.SRN.eq(modBrds.get(i).params.get(key)))
                                        .and(HWBSCBRD.SN.eq(modBrds.get(i).params.get(key2)))
                        )
                        .fetchOne();

                if(brd == null){

                    brd = db.newRecord(HWBSCBRD);

                    brd.setHwbscbrdDate(UInteger.valueOf(context.getEpochTime()));
                    brd.setHwbscbrdHwbsc(hwbsc.getHwbscId());
                    brd.setSrn(modBrds.get(i).params.get(key));
                    brd.setSn(modBrds.get(i).params.get(key2));

//                brd.store();
                }

                ArrayList<String> filters = new ArrayList<>();
                filters.add(key);
                filters.add(modBrds.get(i).params.get(key));
                filters.add(key2);
                filters.add(modBrds.get(i).params.get(key2));

                brd.setHwbscbrdDate(UInteger.valueOf(context.getEpochTime()));
                brd.setHwbscbrdHwbsc(hwbsc.getHwbscId());

                brd.set(DSL.field(mfr.getMapfieldFieldname()), getKeyParamsValue(mfr, filters));

                brd.setBrdclass(modBrds.get(i).params.get("BRDCLASS"));
                brd.setBrdtype(modBrds.get(i).params.get("BRDTYPE"));

                brd.setHwbscbrdCrcollectortaskfiles(ULong.valueOf(this.sf.getTaskFilesId()));

                int res = (brd.getHwbscbrdId() == null)?brd.store():brd.update();

                brds.add(brd);
            }
        }

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

        // get field definition for hwbts
        MapEntityObj me = meo.getChildEntityByTableName("hwbts");

        GSMBTSs.parallelStream().forEach(objx -> processGbts(db, me, objx));

        logger.debug("prepareBts() done");
    }

    private void processGbts(DSLContext db, MapEntityObj me, HuaweiBasicKeyParamsObj obj){

        HuaweiBasicKeyParamsObj mml;
        CrmapfieldRecord mfr;

        String key = "BTSID";
        String key2 = "CELLID";
        String key3 = "CELLNAME";

        HwbtsRecord bts = db.selectFrom(HWBTS)
                .where(HWBTS.HWBTS_DATE.eq(UInteger.valueOf(context.getEpochTime()))
                        .and(HWBTS.HWBTS_HWBSC.eq(hwbsc.getHwbscId()))
                        .and(HWBTS.BTSID.eq(obj.params.get(key)))
                )
                .fetchOne();

        if(bts == null){

            bts = db.newRecord(HWBTS);

            bts.setHwbtsCrcollectortaskfiles(ULong.valueOf(this.sf.getTaskFilesId()));
            bts.setHwbtsDate(UInteger.valueOf(context.getEpochTime()));
            bts.setHwbtsHwbsc(hwbsc.getHwbscId());
            bts.setBtsid(obj.params.get(key));
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
                    case "PARENTKEY": replaceVal = hwbsc.getHwbscId().toString(); break;
                    default: break;
                }

                if(replaceVal != null){

                    bts.set(DSL.field(mfr.getMapfieldFieldname()), replaceVal);
                }
            }
            else{

                String val = getKeyParamsValue(mfr, filters);

                if(val != null){

                    bts.set(DSL.field(mfr.getMapfieldFieldname()), val);
                }
            }
        }

        // set relation to crnode
        CrnodeRecord node = pgc.getNode(meo.mr.getMapentityVendor(), bts.getBtsname(), me.mr.getMapentityNodecategory());

        String btsId = bts.getBtsid();

        // if still null, try from cell level
        if(node == null){

            List<HuaweiBasicKeyParamsObj> cells = GSMGCELLs.stream()
                    .filter(p -> p.params.get(key).equals(btsId))
                    .collect(Collectors.toList());

            for (int i = 0; node == null && i < cells.size(); i++) {

                node = pgc.getNode(meo.mr.getMapentityVendor(), cells.get(i).params.get(key3) , me.mr.getMapentityNodecategory());
            }
        }

        if(node != null){

            bts.setHwbtsNode(node.getNodeId());
            bts.setHwbtsRevenueclass(node.getNodeRevenueclass());
        }

        bts.setHwbtsNodestatus(pgc.getNodeStatus(bts.getBtsname()));

        // update count of cell
        int totalCell = 0;
        int totalTrx = 0;

        for (int j = 0; j < GSMGCELLs.size(); j++) {

            if(GSMGCELLs.get(j).params.get(key).equals(bts.getBtsid())){

                totalCell++;

                // get associated TRX
                for (int k = 0; k < GSMTRXs.size(); k++) {

                    if(GSMGCELLs.get(j).params.get(key2).equals(GSMTRXs.get(k).params.get(key2))){

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

        synchronized (btss){

            btss.add(bts);
        }
    }

    private void prepareGcell(DSLContext db){

        logger.debug("prepareGcell()");

        // get field definition for hwgcell
        MapEntityObj me = meo.getChildEntityByTableName("hwgcell");

        GSMGCELLs.parallelStream().forEach(objx -> processGcell(db, me, objx));

        synchronized (hwbsc){

            hwbsc.setTotalcell(gcells.size());
            hwbsc.update();
        }

        logger.debug("prepareGcell() done");
    }

    private void processGcell(DSLContext db, MapEntityObj me, HuaweiBasicKeyParamsObj obj){

        HuaweiBasicKeyParamsObj mml;
        CrmapfieldRecord mfr;

        String key = "CELLID";
        String key2 = "TRXNO";
        String key3 = "FREQ";

        HwgcellRecord hwgcell = db.selectFrom(HWGCELL)
                .where(
                        HWGCELL.HWGCELL_DATE.eq(UInteger.valueOf(context.getEpochTime()))
                                .and(HWGCELL.HWGCELL_HWBSC.eq(hwbsc.getHwbscId()))
                                .and(HWGCELL.CELLID.eq(obj.params.get(key)))
                )
                .fetchOne();

        if(hwgcell == null){

            hwgcell = db.newRecord(HWGCELL);

            hwgcell.setHwgcellCrcollectortaskfiles(ULong.valueOf(this.sf.getTaskFilesId()));
            hwgcell.setHwgcellDate(UInteger.valueOf(context.getEpochTime()));
            hwgcell.setHwgcellHwbsc(hwbsc.getHwbscId());
            hwgcell.setCellid(obj.params.get(key));
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
                    case "PARENTKEYBSC": replaceVal = hwbsc.getHwbscId().toString(); break;
                    default: break;
                }

                if(replaceVal != null){

                    hwgcell.set(DSL.field(mfr.getMapfieldFieldname()), replaceVal);
                }
            }
            else{

                String val = getKeyParamsValue(mfr, filters);

                if(val != null){

                    hwgcell.set(DSL.field(mfr.getMapfieldFieldname()), val);
                }
            }
        }

        CrnodeRecord node = null;
        HwbtsRecord bts = null;

        for (int j = 0; j < btss.size(); j++) {

            if(btss.get(j).getBtsid().equals(hwgcell.getBtsid())){

                bts = btss.get(j);
                hwgcell.setHwgcellHwbts(bts.getHwbtsId());
                hwgcell.setHwgcellRevenueclass(btss.get(j).getHwbtsRevenueclass());

                // set cell lat-lon

                node = nodeCache.get(btss.get(j).getHwbtsId().longValue());

                break;
            }
        }

        int totalTrx = 0;

        Integer temp;
        String freqPrefix = "FREQ";

        ArrayList<Integer> trxFreq = new ArrayList<Integer>();

        // get associated TRX
        for (int k = 0; k < GSMTRXs.size(); k++) {

            if(hwgcell.getCellid().equals(GSMTRXs.get(k).params.get(key))){

                try{

                    temp = Integer.parseInt(GSMTRXs.get(k).params.get(key3));

                    if(!trxFreq.contains(temp)){

                        trxFreq.add(temp);
                    }
                }
                catch(Exception e){}

//                    gcell.set(DSL.field(freqPrefix + (Integer.parseInt(GSMTRXs.get(k).params.get(key2)) + 1)), GSMTRXs.get(k).params.get(key3));

                totalTrx++;
            }
        }

        hwgcell.setTotaltrx(totalTrx);

        Collections.sort(trxFreq);

        for (int i = 0; i < trxFreq.size() && trxFreq.size() < 64; i++) {

            hwgcell.set(DSL.field("FREQ" + (i+1)), trxFreq.get(i));
        }

        // tweak for location using GCELLLCSs data
        // SET GCELLLCS:CELLID=5, IDTYPE=BYID, INPUTMD=Degree, NSLATI=South_latitude,
        // LATIINT=7, LATIDECI="00360", WELONGI=East_Longitude, LONGIINT=107, LONGIDECI="63080",
        // ANTAANGLE=360, INCLUDEANG=360, ALTITUDE=40, ALTIDECI=0;

        String CELLID, IDTYPE, INPUTMD, NSLATI, LATIINT, LATIDECI, WELONGI, LONGIINT, LONGIDECI;
        String ANTAANGLE, INCLUDEANG, ALTITUDE, ALTIDECI;

        final String cellIdLookup = hwgcell.get("CELLID").toString();

        // if cell id exist, loop for desired cell id
        if(cellIdLookup != null){

            Optional<HuaweiBasicKeyParamsObj> cellLcsObj = GCELLLCSs.stream()
                    .filter(p -> p.params.get("CELLID") != null && p.params.get("CELLID").equals(cellIdLookup))
                    .findFirst();

            if(cellLcsObj.isPresent()){

                // get all cell properties, and calculate the latitude and longitude for the cell
                INPUTMD = cellLcsObj.get().params.get("INPUTMD");
                NSLATI = cellLcsObj.get().params.get("NSLATI");
                LATIINT = cellLcsObj.get().params.get("LATIINT");
                LATIDECI = cellLcsObj.get().params.get("LATIDECI");
                WELONGI = cellLcsObj.get().params.get("WELONGI");
                LONGIINT = cellLcsObj.get().params.get("LONGIINT");
                LONGIDECI = cellLcsObj.get().params.get("LONGIDECI");
                ANTAANGLE = cellLcsObj.get().params.get("ANTAANGLE");
                INCLUDEANG = cellLcsObj.get().params.get("INCLUDEANG");
                ALTITUDE = cellLcsObj.get().params.get("ALTITUDE");
                ALTIDECI = cellLcsObj.get().params.get("ALTIDECI");

                // SET GCELLLCS:CELLID=5, IDTYPE=BYID, INPUTMD=Degree, NSLATI=South_latitude,
                // LATIINT=7, LATIDECI="00360", WELONGI=East_Longitude, LONGIINT=107, LONGIDECI="63080",
                // ANTAANGLE=360, INCLUDEANG=360, ALTITUDE=40, ALTIDECI=0;

                if(LATIINT != null && LATIDECI != null && LONGIINT != null && LONGIDECI != null ){

                    Double latitude = Double.parseDouble(LATIINT + "." + LATIDECI);
                    Double longitude = Double.parseDouble(LONGIINT + "." + LONGIDECI);

                    if(NSLATI.toLowerCase().contains("south")){
                        latitude = latitude * -1;
                    }

                    if(NSLATI.toLowerCase().contains("west")){
                        longitude = longitude * -1;
                    }

//                    System.out.println(gcell.getCellname() + " -> LAT: " + latitude + ", LON: " + longitude);

                    hwgcell.setLatitude(latitude.toString());
                    hwgcell.setLongitude(longitude.toString());
                }
            }
        }

        String cgi = getCGI(hwgcell.getMcc(), hwgcell.getMnc(), hwgcell.getLac(), hwgcell.getCi());

        if(cgi != null){

            hwgcell.setCgi(cgi);

            CrcellRecord cellProto = CellUtils.getCellProto(hwgcell, node);

            // set relation to crcell
            CrcellRecord cell = pgc.getCell(hwgcell.getType(), cgi, cellProto, node);

            if(cell != null){

                hwgcell.setHwgcellCell(cell.getCellId());
                hwgcell.setHwgcellCellclass(cell.getCellCellclass());
                hwgcell.setHwgcellCellcoverage(cell.getCellCellcoverage());
                hwgcell.setHwgcellRevenueclass(cell.getCellRevenueclass());
                hwgcell.setHwgcellLatitude(cell.getCellLatitude());
                hwgcell.setHwgcellLongitude(cell.getCellLongitude());

//                CrnodeRecord nodeAlias = pgc.getCellNodeAlias(hwgcell, hwgcell, cell.getCellCellclass(), null, hwgcell.getCellname(), node);

                try{

                    String neName = (node != null)?node.getNodeCode(): null;

                    CrnodeRecord nodeAlias = pgc.getCellNodeAlias2(meo.mr.getMapentityVendor(), cell.getCellCellclass(), hwgcell.getCellname(), neName);

                    if(nodeAlias != null){
                        hwgcell.setHwgcellNodealias(nodeAlias.getNodeId());
                    }
                }
                catch(Exception e){

                    e.printStackTrace();

                    System.out.println("meo.mr.getMapentityVendor(): " + meo.mr.getMapentityVendor());
                    System.out.println("cell.getCellCellclass(): " + cell.getCellCellclass());
                    System.out.println("hwgcell.getCellname(): " + hwgcell.getCellname());

                    System.out.println("node.getNodeCode(): " + node.getNodeCode());

                }
            }
        }

        // set calculated lat lon decimal
//            gcell.setLatitude(GeoUtil.getHuawei2GLat(gcell.getNslati(), gcell.getLatiint(), gcell.getLatideci()));
//            gcell.setLongitude(GeoUtil.getHuawei2GLon(gcell.getWelongi(), gcell.getLongiint(), gcell.getLongideci()));


        hwgcell.setBsic(Integer.parseInt(hwgcell.getNcc())*8 + Integer.parseInt(hwgcell.getBcc()));

        hwgcell.setHwgcellCellstatus(pgc.getCellStatus(hwgcell.getCellname()));
        hwgcell.setHwgcellVendor(meo.mr.getMapentityVendor());

        int res = (hwgcell.getHwgcellId() == null)?hwgcell.store():hwgcell.update();

        synchronized (gcells){
            gcells.add(hwgcell);
        }
    }

    private void prepareGtrx(DSLContext db){

        logger.debug("prepareGtrx()");

        // get field definition for hwgtrx
        MapEntityObj me = meo.getChildEntityByTableName("hwgtrx");

        GSMTRXs.parallelStream().forEach(objx -> processGtrx(db, me, objx));

        logger.debug("prepareGtrx() done");
    }

    private void processGtrx(DSLContext db, MapEntityObj me, HuaweiBasicKeyParamsObj obj){

        HuaweiBasicKeyParamsObj mml;
        CrmapfieldRecord mfr;

        String key = "TRXID";

        HwgtrxRecord gtrx = db.selectFrom(HWGTRX)
                .where(
                        HWGTRX.HWGTRX_DATE.eq(UInteger.valueOf(context.getEpochTime()))
                                .and(HWGTRX.HWGTRX_HWBSC.eq(hwbsc.getHwbscId()))
                                .and(HWGTRX.TRXID.eq(obj.params.get(key)))
                )
                .fetchOne();

        if(gtrx == null){

            gtrx = db.newRecord(HWGTRX);

            gtrx.setHwgtrxCrcollectortaskfiles(ULong.valueOf(this.sf.getTaskFilesId()));
            gtrx.setHwgtrxDate(UInteger.valueOf(context.getEpochTime()));
            gtrx.setHwgtrxHwbsc(hwbsc.getHwbscId());
            gtrx.setTrxid(obj.params.get(key));

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
                    case "PARENTKEYBSC": replaceVal = hwbsc.getHwbscId().toString(); break;
                    default: break;
                }

                if(replaceVal != null){

                    gtrx.set(DSL.field(mfr.getMapfieldFieldname()), replaceVal);
                }
            }
            else{

                String val = getKeyParamsValue(mfr, filters);

                if(val != null){

                    gtrx.set(DSL.field(mfr.getMapfieldFieldname()), val);
                }
            }
        }

        for (int j = 0; j < gcells.size(); j++) {

            // build ref to hwbts
            if(gcells.get(j).getCellid().equals(gtrx.getCellid())){

                gtrx.setHwgtrxHwgcell(gcells.get(j).getHwgcellId());

                // also copy ref to hwbts
                if(gcells.get(j).getHwgcellHwbts() != null){
                    gtrx.setHwgtrxHwbts(gcells.get(j).getHwgcellHwbts());
                }
                break;
            }
        }

        int res = (gtrx.getHwgtrxId() == null)?gtrx.store():gtrx.update();

        synchronized (gtrxs){

            gtrxs.add(gtrx);
        }
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
        GSMBTSs.clear();
        GSMGCELLs.clear();
        GSMTRXs.clear();
        this.result = null;
        this.brds = null;
        this.ports = null;
        this.e1t1s = null;
        this.btss = null;
        this.gcells = null;
        this.gtrxs = null;
        this.gtrxchans = null;

        logger.debug("clearUnusedData() done");
    }
}

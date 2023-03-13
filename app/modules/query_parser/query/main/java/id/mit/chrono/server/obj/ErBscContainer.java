package id.mit.chrono.server.obj;

import id.mit.chrono.server.base.ErBaseContainer;
import id.mit.chrono.server.enm.PS;
import id.mit.chrono.server.iface.FileProcessor;
import id.mit.chrono.server.iface.ParserGroupCallback;
import id.mit.chrono.server.model.tables.Crcell;
import id.mit.chrono.server.model.tables.records.*;
import id.mit.chrono.server.util.CellUtils;
import id.mit.chrono.server.var.Vars;
import org.jooq.DSLContext;
import org.jooq.impl.DSL;
import org.jooq.types.UInteger;
import org.jooq.types.ULong;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static id.mit.chrono.server.model.Tables.*;

public class ErBscContainer extends ErBaseContainer implements FileProcessor {

    private List<ErbscRecord> bscs = new ArrayList<>();
    private List<ErbtsRecord> btss = new ArrayList<>();
    private List<ErgcellRecord> gcells = new ArrayList<>();
    private List<ErgcellRecord> gcellsUnmapped = new ArrayList<>();
    private HashMap<Long, CrnodeRecord> nodeCache = new HashMap();

    List<ErBasicTagParamsObj> OSSRC_2G_BSC;
    List<ErBasicTagParamsObj> vsDataBscs;
    List<ErBasicTagParamsObj> OSSRC_2G_RSITE;
    List<ErBasicTagParamsObj> vsDataG31Scfs;
    List<ErBasicTagParamsObj> OSSRC_2G_TG;
    List<ErBasicTagParamsObj> vsDataTgs;
    List<ErBasicTagParamsObj> OSSRC_2G_CELL;
    List<ErBasicTagParamsObj> vsDataGeranCells;
    List<ErBasicTagParamsObj> OSSRC_2G_CHGROUP;
    List<ErBasicTagParamsObj> vsDataChannelGroups;

    List<CrsettingsRecord> sitePattern;

    String cellPattern = null;
    Pattern cellPatternPattern = null;

    List<ErgcellmapRecord> ergcellmaps;

    public ErBscContainer(DSLContext db, ParserGroupCallback pgc, ChronoContext context, SourceFile sf, MapEntityObj meo) {
        super(db, pgc, context, sf, meo);
    }

    @Override
    public boolean process(DSLContext adb, PS state){
        return updateWorkingState(state);
    }

    @Override
    public boolean processAll(DSLContext adb){

        resetStopwatch();

        // get all map for Ericsson 2G Cell
        ergcellmaps = adb.selectFrom(ERGCELLMAP).orderBy(ERGCELLMAP.ERGCELLMAP_ID.asc()).fetch();
        logger.debug("ergcellmaps.size(): " + ergcellmaps.size());

        if(ergcellmaps.size() > 0){

            cellPattern = ergcellmaps.get(0).getErgcellmapCode();
            logger.debug("cellPattern: " + cellPattern);

            cellPatternPattern = Pattern.compile(cellPattern);

            // remove from main list
            ergcellmaps.remove(0);
        }

        this.prepareKeyParamsResult(adb);

        logger.debug("result.size(): " + result.size());
//
//        result.forEach(res -> {
//            System.out.println(res.tag + " -> " + res.params);
//        });

//        for(ErBasicTagParamsObj temp: result){
//
//            System.out.println("tag: " + temp.tag);
//            for(String key: temp.params.keySet()){
//
//                System.out.print(key + ": " + temp.params.get(key) + ",");
//
//            }
//
//            System.out.println("");
//        }

        OSSRC_2G_BSC = result.stream()
                .filter(p -> p.tag.equals("OSSRC_2G_BSC"))
                .collect(Collectors.toList());

        logger.debug("OSSRC_2G_BSC.size(): " + OSSRC_2G_BSC.size());

        vsDataBscs = result.stream()
                .filter(p -> p.tag.equals("vsDataBsc"))
                .collect(Collectors.toList());

        logger.debug("vsDataBscs.size(): " + vsDataBscs.size());

        OSSRC_2G_RSITE = result.stream()
                .filter(p -> p.tag.equals("OSSRC_2G_RSITE"))
                .collect(Collectors.toList());

        logger.debug("OSSRC_2G_RSITE.size(): " + OSSRC_2G_RSITE.size());

        vsDataG31Scfs = result.stream()
                .filter(p -> p.tag.equals("vsDataG31Scf"))
                .collect(Collectors.toList());

        logger.debug("vsDataG31Scfs.size(): " + vsDataG31Scfs.size());

        vsDataTgs = result.stream()
                .filter(p -> p.tag.matches("vsDataG\\d{2}Tg"))
                .collect(Collectors.toList());

        logger.debug("vsDataTgs.size(): " + vsDataTgs.size());

        OSSRC_2G_TG = result.stream()
                .filter(p -> p.tag.equals("OSSRC_2G_TG"))
                .collect(Collectors.toList());

        logger.debug("OSSRC_2G_TG.size(): " + OSSRC_2G_TG.size());

        OSSRC_2G_CHGROUP = result.stream()
                .filter(p -> p.tag.equals("OSSRC_2G_CHGROUP"))
                .collect(Collectors.toList());

        logger.debug("OSSRC_2G_CHGROUP.size(): " + OSSRC_2G_CHGROUP.size());

        vsDataChannelGroups = result.stream()
                .filter(p -> p.tag.equals("vsDataChannelGroup"))
                .collect(Collectors.toList());

        logger.debug("vsDataChannelGroups.size(): " + vsDataChannelGroups.size());

        OSSRC_2G_CELL = result.stream()
                .filter(p -> p.tag.equals("OSSRC_2G_CELL"))
                .collect(Collectors.toList());

        logger.debug("OSSRC_2G_CELL.size(): " + OSSRC_2G_CELL.size());

        vsDataGeranCells = result.stream()
                .filter(p -> p.tag.equals("vsDataGeranCell"))
                .collect(Collectors.toList());

        logger.debug("vsDataGeranCells.size(): " + vsDataGeranCells.size());
        
        // prepare mapping from OSSRC_2G_CELL to OSSRC_2G_CHGROUP

        String key = "bsc";
        String key2 = "cell";
        String key3 = "tg";

        String bscName1;
        String bscName2;
        String cell1;
        String cell2;
        String tg1;

        sitePattern = pgc.getSettings("SITE_PATTERN");

        addMeasurement(PS.PREPARE, this.getKey(), true);

        this.prepareBsc(adb);
        this.prepareBsc2(adb);
        addMeasurement(PS.BSC, this.getKey(), true);

        this.prepareBts(adb);
        addMeasurement(PS.BTS, this.getKey(), true);

        this.prepareCell(adb);
        addMeasurement(PS.CELL2G, this.getKey(), true);

        this.fixBts(adb);
        addMeasurement(PS.BTS, this.getKey(), true);

        this.updateBsc(adb);
        this.clearUnusedData(adb);
        addMeasurement(PS.FINALIZE, this.getKey(), true);

        saveStatistics(adb);

        return true;
    }

    private void prepareBsc(DSLContext db){

        logger.debug("prepareBsc()");

        ErBasicTagParamsObj mml;
        CrmapfieldRecord mfr;

        String key = "bsc";

        for (int i = 0; i < OSSRC_2G_BSC.size(); i++) {

            String bsc = OSSRC_2G_BSC.get(i).params.get(key);
//
//            System.out.println("BSC: " + bsc);

            ErbscRecord erbsc = db.selectFrom(ERBSC)
                    .where(ERBSC.ERBSC_DATE.eq(UInteger.valueOf(context.getEpochTime())))
                    .and(ERBSC.BSCNAME.eq(bsc))
                    .fetchOne();

            if(erbsc == null){

                erbsc = db.newRecord(ERBSC);

                erbsc.setErbscDate(UInteger.valueOf(context.getEpochTime()));
                erbsc.setBscname(bsc);
            }

            ArrayList<String> filters = new ArrayList<>();
            filters.add(key);
            filters.add(bsc);

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

                        erbsc.set(DSL.field(mfr.getMapfieldFieldname()), replaceVal);
                    }
                }
                else{

                    String val = getKeyParamsValue(mfr, filters);

                    if(val != null){

                        erbsc.set(DSL.field(mfr.getMapfieldFieldname()), val);
                    }
                }
            }

            int totalBts = OSSRC_2G_RSITE.stream()
                    .filter(p -> p.params.get(key).equals(bsc))
                    .collect(Collectors.toList()).size();

            int totalCell = OSSRC_2G_CELL.stream()
                    .filter(p -> p.params.get(key).equals(bsc))
                    .collect(Collectors.toList()).size();

            erbsc.setTotalbts(totalBts);
            erbsc.setTotalcell(totalCell);

            CrnodeRecord node = pgc.getNode(meo.mr.getMapentityVendor(), erbsc.getBscname(), meo.mr.getMapentityNodecategory());

            if(node != null){

                erbsc.setErbscNode(node.getNodeId());
            }

            erbsc.setErbscVendor(meo.mr.getMapentityVendor());

            erbsc.setErbscCrcollectortaskfiles(ULong.valueOf(this.sf.getTaskFilesId()));

            int result = (erbsc.getErbscId() == null)?erbsc.store():erbsc.update();

            synchronized (bscs){

                bscs.add(erbsc);
            }
        }

        logger.debug("prepareBsc() done");
    }

    private void prepareBsc2(DSLContext db){

        logger.debug("prepareBsc2()");

        ErBasicTagParamsObj mml;
        CrmapfieldRecord mfr;

        String key = "ManagedElement_id";

        for (int i = 0; i < vsDataBscs.size(); i++) {

            String bsc = vsDataBscs.get(i).params.get(key);

            ErbscRecord erbsc = db.selectFrom(ERBSC)
                    .where(ERBSC.ERBSC_DATE.eq(UInteger.valueOf(context.getEpochTime())))
                    .and(ERBSC.BSCNAME.eq(bsc))
                    .fetchOne();

            if(erbsc == null){

                erbsc = db.newRecord(ERBSC);

                erbsc.setErbscDate(UInteger.valueOf(context.getEpochTime()));
                erbsc.setBscname(bsc);
            }

            ArrayList<String> filters = new ArrayList<>();
            filters.add(key);
            filters.add(bsc);

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

                        erbsc.set(DSL.field(mfr.getMapfieldFieldname()), replaceVal);
                    }
                }
                else{

                    String val = getKeyParamsValue(mfr, filters);

                    if(val != null){

                        erbsc.set(DSL.field(mfr.getMapfieldFieldname()), val);
                    }
                }
            }

            int totalBts = OSSRC_2G_RSITE.stream()
                    .filter(p -> p.params.get(key).equals(bsc))
                    .collect(Collectors.toList()).size();

            int totalCell = OSSRC_2G_CELL.stream()
                    .filter(p -> p.params.get(key).equals(bsc))
                    .collect(Collectors.toList()).size();

            erbsc.setTotalbts(totalBts);
            erbsc.setTotalcell(totalCell);

            CrnodeRecord node = pgc.getNode(meo.mr.getMapentityVendor(), erbsc.getBscname(), meo.mr.getMapentityNodecategory());

            if(node != null){

                erbsc.setErbscNode(node.getNodeId());
            }

            erbsc.setErbscVendor(meo.mr.getMapentityVendor());

            erbsc.setErbscCrcollectortaskfiles(ULong.valueOf(this.sf.getTaskFilesId()));

            int result = (erbsc.getErbscId() == null)?erbsc.store():erbsc.update();

            synchronized (bscs){

                bscs.add(erbsc);
            }
        }

        logger.debug("prepareBsc2() done");
    }

    private void prepareBts(DSLContext db){

        logger.debug("prepareBts()");

        // get field definition for hwbts
        MapEntityObj me = meo.getChildEntityByTableName("erbts");

        OSSRC_2G_TG.parallelStream().forEach(objx -> processBts(db, me, objx));
        vsDataTgs.parallelStream().forEach(objx -> processBts2(db, me, objx));

        logger.debug("prepareBts() done");
    }

    private void processBts(DSLContext db, MapEntityObj me, ErBasicTagParamsObj obj){

        ErBasicTagParamsObj mml;
        CrmapfieldRecord mfr;

        String key = "bsc";
        String key2 = "tg";
        String key3 = "site";
        String key4 = "note";
        String key5 = "latitude";
        String key6 = "longitude";
        String key7 = "cell";
        String key8 = "chgr";

        String bsc = obj.params.get(key);
        String tg = obj.params.get(key2);

        Long bscId = null;

        for (int i = 0; i < bscs.size(); i++) {

            if(bscs.get(i).getBscname().equals(bsc)){

                bscId = bscs.get(i).getErbscId().longValue();
                break;
            }
        }

        if(bscId == null){
            return;
        }

        ErbtsRecord erbts = db.selectFrom(ERBTS)
                .where(ERBTS.ERBTS_DATE.eq(UInteger.valueOf(context.getEpochTime())))
                .and(ERBTS.ERBTS_ERBSC.eq(ULong.valueOf(bscId)))
                .and(ERBTS.TG.eq(tg))
                .fetchAny();

        if(erbts == null){

            erbts = db.newRecord(ERBTS);

            erbts.setErbtsDate(UInteger.valueOf(context.getEpochTime()));
            erbts.setErbtsErbsc(ULong.valueOf(bscId));
            erbts.setTg(tg);
        }

        ArrayList<String> filters = new ArrayList<>();
        filters.add(key);
        filters.add(bsc);
        filters.add(key2);
        filters.add(tg);

        for (int l = 0; l < me.mft.size(); l++) {

            mfr = me.mft.get(l);

            // if need replace from chrono.context
            if(mfr.getMapfieldSourcegroup().equals("chrono.context")){

                String replaceVal = null;

                switch(mfr.getMapfieldSourceparam()){

                    case "DATE": replaceVal = String.valueOf(context.getEpochTime()); break;
//                        case "PARENTKEY": replaceVal = hwbsc.getHwbscId().toString(); break;
                    default: break;
                }

                if(replaceVal != null){

                    erbts.set(DSL.field(mfr.getMapfieldFieldname()), replaceVal);
                }
            }
            else{

                String val = getKeyParamsValue(mfr, filters);

                if(val != null){

                    erbts.set(DSL.field(mfr.getMapfieldFieldname()), val);
                }
            }
        }

        // set NEID from OSSRC_2G_RSITE
        for (int j = 0; j < OSSRC_2G_RSITE.size(); j++) {

            if(OSSRC_2G_RSITE.get(j).params.get(key).equals(bsc) &&
                    OSSRC_2G_RSITE.get(j).params.get(key3).equals(erbts.getSite())){

                erbts.setNeid(OSSRC_2G_RSITE.get(j).params.get(key4));
                erbts.setLatitude(OSSRC_2G_RSITE.get(j).params.get(key5));
                erbts.setLongitude(OSSRC_2G_RSITE.get(j).params.get(key6));
                break;
            }
        }

        // calculate total cell
        ArrayList<String> cellNames = new ArrayList<String>();

        List<ErBasicTagParamsObj> chGroupData = OSSRC_2G_CHGROUP.stream()
                .filter(p -> p.params.get(key) != null && p.params.get(key).equals(bsc) && p.params.get(key2) != null && p.params.get(key2).equals(tg))
                .collect(Collectors.toList());

        for (int i = 0; i < chGroupData.size(); i++) {

            if(!cellNames.contains(chGroupData.get(i).params.get(key7))){

                //search for class

                cellNames.add(chGroupData.get(i).params.get(key7));
            }
        }

        erbts.setTotalcell(cellNames.size());


        // set BTSNAME
        if(erbts.getNeid() != null){

            erbts.setBtsname(erbts.getNeid() + "_" + erbts.getSite());
        }
        else{
            erbts.setBtsname(erbts.getSite());
        }

        // set relation to crnode
        CrnodeRecord node = pgc.getNode(meo.mr.getMapentityVendor(), erbts.getBtsname(), me.mr.getMapentityNodecategory());

        if(node != null){

            erbts.setErbtsNode(node.getNodeId());
            erbts.setErbtsRevenueclass(node.getNodeRevenueclass());
        }

        erbts.setErbtsNodestatus(pgc.getNodeStatus(erbts.getSite()));

        erbts.setErbtsVendor(meo.mr.getMapentityVendor());

        erbts.setErbtsCrcollectortaskfiles(ULong.valueOf(this.sf.getTaskFilesId()));

        int result = (erbts.getErbtsId() == null)?erbts.store():erbts.update();

        synchronized (btss){

            btss.add(erbts);

            if(node != null){
                nodeCache.put(erbts.getErbtsId().longValue(), node);
            }
        }
    }

    private void processBts2(DSLContext db, MapEntityObj me, ErBasicTagParamsObj obj){

        ErBasicTagParamsObj mml;
        CrmapfieldRecord mfr;

        String keyBsc = "ManagedElement_id";
        String keyRxstg = "g31TgId";
        String keyRxotg = "g12TgId";
        String keyRsite = "rSite";

        String bscName = obj.params.get(keyBsc);
        String rxstg = obj.params.get(keyRxstg);
        String rxotg = obj.params.get(keyRxotg);
        String rsite = obj.params.get(keyRsite);

        String tg = null;

        if(rxstg != null){
            tg = "RXSTG-" + rxstg;
//            System.out.println(String.format("%s:%s -> %s", bscName, tg, rsite));
        }
        else if(rxotg != null){
            tg = "RXOTG-" + rxotg;
//            System.out.println(String.format("%s:%s -> %s", bscName, tg, rsite));
        }

        if(tg == null){
            return;
        }

        Long bscId = null;

        for (int i = 0; i < bscs.size(); i++) {

            if(bscs.get(i).getBscname().equals(bscName)){

                bscId = bscs.get(i).getErbscId().longValue();
                break;
            }
        }

        if(bscId == null){
            return;
        }

        ErbtsRecord erbts = db.selectFrom(ERBTS)
                .where(ERBTS.ERBTS_DATE.eq(UInteger.valueOf(context.getEpochTime())))
                .and(ERBTS.ERBTS_ERBSC.eq(ULong.valueOf(bscId)))
                .and(ERBTS.TG.eq(tg))
                .fetchAny();

        if(erbts == null){

            erbts = db.newRecord(ERBTS);

            erbts.setErbtsDate(UInteger.valueOf(context.getEpochTime()));
            erbts.setErbtsErbsc(ULong.valueOf(bscId));
            erbts.setTg(tg);
        }

        erbts.setSite(rsite);

        ArrayList<String> filters = new ArrayList<>();
        filters.add("ManagedElement_id");
        filters.add(bscName);
        filters.add("vsG31Tg_id");
        filters.add(tg.split("-")[1]);


//        System.out.println("ManagedElement_id: " + bscName);
//        System.out.println("tg: " + tg.split("-")[1]);

        for (int l = 0; l < me.mft.size(); l++) {

            mfr = me.mft.get(l);

            // if need replace from chrono.context
            if(mfr.getMapfieldSourcegroup().equals("chrono.context")){

                String replaceVal = null;

                switch(mfr.getMapfieldSourceparam()){

                    case "DATE": replaceVal = String.valueOf(context.getEpochTime()); break;
//                        case "PARENTKEY": replaceVal = hwbsc.getHwbscId().toString(); break;
                    default: break;
                }

                if(replaceVal != null){

                    erbts.set(DSL.field(mfr.getMapfieldFieldname()), replaceVal);
                }
            }
            else{

                String val = getKeyParamsValue(mfr, filters);

                if(val != null){

//                    System.out.println("SET: " + mfr.getMapfieldFieldname() + " -> " + val);

                    erbts.set(DSL.field(mfr.getMapfieldFieldname()), val);
                }
            }
        }

//        // set NEID from OSSRC_2G_RSITE
//        for (int j = 0; j < OSSRC_2G_RSITE.size(); j++) {
//
//            if(OSSRC_2G_RSITE.get(j).params.get(key).equals(bsc) &&
//                    OSSRC_2G_RSITE.get(j).params.get(key3).equals(erbts.getSite())){
//
//                erbts.setNeid(OSSRC_2G_RSITE.get(j).params.get(key4));
//                erbts.setLatitude(OSSRC_2G_RSITE.get(j).params.get(key5));
//                erbts.setLongitude(OSSRC_2G_RSITE.get(j).params.get(key6));
//                break;
//            }
//        }
//
//        // calculate total cell
//        ArrayList<String> cellNames = new ArrayList<String>();
//
//        List<ErBasicTagParamsObj> chGroupData = OSSRC_2G_CHGROUP.stream()
//                .filter(p -> p.params.get(key) != null && p.params.get(key).equals(bsc) && p.params.get(key2) != null && p.params.get(key2).equals(tg))
//                .collect(Collectors.toList());
//
//        for (int i = 0; i < chGroupData.size(); i++) {
//
//            if(!cellNames.contains(chGroupData.get(i).params.get(key7))){
//
//                //search for class
//
//                cellNames.add(chGroupData.get(i).params.get(key7));
//            }
//        }
//
//        erbts.setTotalcell(cellNames.size());


        // set BTSNAME
        if(erbts.getNeid() != null){

            erbts.setBtsname(erbts.getNeid() + "_" + erbts.getSite());
        }
        else{
            erbts.setBtsname(erbts.getSite());
        }

        // set relation to crnode
        CrnodeRecord node = pgc.getNode(meo.mr.getMapentityVendor(), erbts.getBtsname(), me.mr.getMapentityNodecategory());

        if(node != null){

            erbts.setErbtsNode(node.getNodeId());
            erbts.setErbtsRevenueclass(node.getNodeRevenueclass());
        }

        erbts.setErbtsNodestatus(pgc.getNodeStatus(erbts.getSite()));

        erbts.setErbtsVendor(meo.mr.getMapentityVendor());

        erbts.setErbtsCrcollectortaskfiles(ULong.valueOf(this.sf.getTaskFilesId()));

        int result = (erbts.getErbtsId() == null)?erbts.store():erbts.update();

        synchronized (btss){

            btss.add(erbts);

            if(node != null){
                nodeCache.put(erbts.getErbtsId().longValue(), node);
            }
        }
    }

    private void prepareCell(DSLContext db){

        logger.debug("prepareCell()");

        // get field definition for ergcell
        MapEntityObj me = meo.getChildEntityByTableName("ergcell");

        OSSRC_2G_CELL.parallelStream().forEach(objx -> processCell(db, me, objx));
        vsDataGeranCells.parallelStream().forEach(objx -> processCell2(db, me, objx));

        logger.debug("prepareCell() done");
    }

    private void processCell(DSLContext db, MapEntityObj me, ErBasicTagParamsObj obj){

        ErBasicTagParamsObj mml;
        CrmapfieldRecord mfr;

        String key = "bsc";
        String key2 = "cell";
        String key3 = "tg";
        String key4 = "chgr";
        String key5 = "dchno";

        String bscName = obj.params.get(key);
        String cellName = obj.params.get(key2);
//        String mo = obj.params.get(key3);

        CrcellRecord cell = null;

        ErbscRecord bsc = null;

        for (int i = 0; i < bscs.size(); i++) {

            if(bscs.get(i).getBscname().equals(bscName)){

                bsc = bscs.get(i);
                break;
            }
        }

        if(bsc == null){
            return;
        }

        final ULong erbsc_id = bsc.getErbscId();

        ErgcellRecord ergcell = db.selectFrom(ERGCELL)
                .where(ERGCELL.ERGCELL_DATE.eq(UInteger.valueOf(context.getEpochTime())))
                .and(ERGCELL.ERGCELL_ERBSC.eq(erbsc_id))
                .and(ERGCELL.CELL.eq(cellName))
                .fetchAny();

        if(ergcell == null){

            ergcell = db.newRecord(ERGCELL);

            ergcell.setErgcellDate(UInteger.valueOf(context.getEpochTime()));
            ergcell.setErgcellErbsc(erbsc_id);
            ergcell.setCell(cellName);
        }

        ArrayList<String> filters = new ArrayList<>();
        filters.add(key);
        filters.add(bscName);
        filters.add(key2);
        filters.add(cellName);

        for (int l = 0; l < me.mft.size(); l++) {

            mfr = me.mft.get(l);

            // if need replace from chrono.context
            if(mfr.getMapfieldSourcegroup().equals("chrono.context")){

                String replaceVal = null;

                switch(mfr.getMapfieldSourceparam()){

                    case "DATE": replaceVal = String.valueOf(context.getEpochTime()); break;
//                        case "PARENTKEY": replaceVal = hwbsc.getHwbscId().toString(); break;
                    default: break;
                }

                if(replaceVal != null){

                    ergcell.set(DSL.field(mfr.getMapfieldFieldname()), replaceVal);
                }
            }
            else{

                String val = getKeyParamsValue(mfr, filters);

                if(val != null){

                    ergcell.set(DSL.field(mfr.getMapfieldFieldname()), val);
                }
            }
        }

        try{

            ergcell.setBsic(Integer.parseInt(ergcell.getNcc())*8 + Integer.parseInt(ergcell.getBcc()));
        }
        catch(Exception e){}

        CrnodeRecord node = null;

        String rsite = null;
        String neid = null;

        // search chgroup

        OSSRC_2G_BSC = result.stream()
                .filter(p -> p.tag.equals("OSSRC_2G_BSC"))
                .collect(Collectors.toList());

        for (int i = 0; i < OSSRC_2G_CHGROUP.size(); i++) {


            if(OSSRC_2G_CHGROUP.get(i).params.get(key).equals(bscName) &&
                    OSSRC_2G_CHGROUP.get(i).params.get(key2).equals(cellName) &&
                    OSSRC_2G_CHGROUP.get(i).params.get(key4).equals("0")){

                ergcell.setMo(OSSRC_2G_CHGROUP.get(i).params.get(key3));

                // map to erbts
                for (int j = 0; j < btss.size(); j++) {

                    if(btss.get(j).getErbtsErbsc().equals(erbsc_id) && btss.get(j).getTg().equals(ergcell.getMo())){

                        ergcell.setErgcellErbts(btss.get(j).getErbtsId());

                        rsite = btss.get(j).getBtsname();
                        neid = btss.get(j).getNeid();
                        break;
                    }
                }

                break;
            }
        }

        if(ergcell.getErgcellErbts() != null){

            node = nodeCache.get(ergcell.getErgcellErbts().longValue());
        }

        String neIdSuffix = "";
        String bandLookup = ergcell.getCsystype();

        if(bandLookup == null){
            bandLookup = "GSM900";
        }

        if(ergcell.getCi() != null && ergcell.getLac() != null){

            try{

                String cgi = ergcell.getMcc() + "-" + ergcell.getMnc() + "-" + ergcell.getLac() + "-" + ergcell.getCi();
                String fixedCellName = null;
                String fixedNeId = null;

                ergcell.setCgi(cgi);

                Matcher m = null;

                // only for matches cell: i.e. TB1234D
                if(cellPattern != null && ergcell.getCell().matches(cellPattern)){

                    m = cellPatternPattern.matcher(ergcell.getCell());

                    if(m.find()){

                        String s1 = m.group(1);
                        String s2 = m.group(2);
                        String s3 = m.group(3);

                        if(bandLookup.equals("GSM900")){
                            neIdSuffix = "G1";
                        }
                        else{
                            neIdSuffix = "D1";
                        }

                        Optional<ErgcellmapRecord> rec = ergcellmaps.stream().filter(o -> o.getErgcellmapKey().equals(s1)).findFirst();

//                        System.out.println("s1: " + s1);

                        if(rec.isPresent()){

                            fixedNeId = rec.get().getErgcellmapValue() + s2 + neIdSuffix;
                            fixedCellName = rec.get().getErgcellmapValue() + s2 + s3;

//                            System.out.println("fixedNeId 1: " + fixedNeId);
//                            System.out.println("fixedCellName 1: " + fixedCellName);
                        }

                        // only for combat starts with CO
                        if(ergcell.getCell().startsWith("CO")){

                            if(ergcell.getLatitude() != null && ergcell.getLongitude() != null){

                                logger.debug("trying to get site area defined prefix 1 : " + ergcell.getCell());

                                try{

                                    double lat = Double.parseDouble(ergcell.getLatitude());
                                    double lon = Double.parseDouble(ergcell.getLongitude());

                                    String prefix1 = pgc.getSiteAreaDefinedPrefix1ByLatLon(lat, lon);

                                    if(prefix1 != null){

                                        fixedNeId = prefix1 + s2 + neIdSuffix;

                                        logger.debug("set new ne id for cell: " + ergcell.getCell() + " -> " + fixedNeId);

                                        node = new CrnodeRecord();
                                        node.setNodeCode(fixedNeId);
                                        rsite = fixedNeId;
                                    }
                                }
                                catch(Exception e) {

                                }
                            }
                        }
                    }
                }
                else{

                    // normal pattern: JKP001
                    String pattern = "([A-Z]{3})([0-9]{3})([A-Z]{1})";
                    Pattern px = Pattern.compile(pattern);
                    Matcher mx = px.matcher(ergcell.getCell());

                    if(mx.find()){

                        String s1 = mx.group(1);
                        String s2 = mx.group(2);
                        String s3 = mx.group(3);

                        if(bandLookup.equals("GSM900")){
                            neIdSuffix = "G1";
                        }
                        else{
                            neIdSuffix = "D1";
                        }

                        fixedNeId = s1 + s2 + neIdSuffix;
                        fixedCellName = s1 + s2 + s3;
                    }
                }

                if(fixedNeId == null){
                    fixedNeId = rsite;
                }
                else{
                    // replace anyway
                    node = new CrnodeRecord();
                    node.setNodeCode(fixedNeId);
                }

                if(fixedCellName == null){
                    fixedCellName = ergcell.getCell();
                }

                CrcellRecord cellProto = CellUtils.getCellProto(ergcell, node);

                // set relation to crnode
                cell = pgc.getCell(bandLookup, cgi, cellProto, node);

                if(cell != null){

                    ergcell.setErgcellCell(cell.getCellId());
                    ergcell.setErgcellCellclass(cell.getCellCellclass());
                    ergcell.setErgcellCellcoverage(cell.getCellCellcoverage());
                    ergcell.setErgcellRevenueclass(cell.getCellRevenueclass());
                    ergcell.setErgcellLatitude(cell.getCellLatitude());
                    ergcell.setErgcellLongitude(cell.getCellLongitude());

//                    CrnodeRecord nodeAlias = pgc.getCellNodeAlias(ergcell, ergcell, ergcell.getErgcellCellclass(), null, ergcell.getCell(), node);

//                    String cName = ergcell.getCell();

//                    System.out.println("send: " + fixedCellName + " -> " + rsite);

//                    if(neid == null){
//                        neid = fixedNeId;
//                    }

                    CrnodeRecord nodeAlias = pgc.getCellNodeAlias2(meo.mr.getMapentityVendor(), cell.getCellCellclass(), fixedNeId, fixedNeId);

//                    System.out.println("result: " + nodeAlias);

                    if(nodeAlias != null){
                        ergcell.setErgcellNodealias(nodeAlias.getNodeId());
                    }
                }
                else{

                    logger.debug("failed to get crcell data: " + ergcell.getCell());
                }
            }
            catch(Exception e){

                e.printStackTrace();
            }
        }

        // complete FREQ1-12 data
        List<ErBasicTagParamsObj> chGroupData = OSSRC_2G_CHGROUP.stream()
                .filter(p -> p.params.get(key) != null && p.params.get(key).equals(bscName) && p.params.get(key2) != null && p.params.get(key2).equals(cellName))
                .collect(Collectors.toList());

        ArrayList<Integer> dchNos = new ArrayList<>();
        String temp;
        String[] tempArr;
        int tempInt;

        for (int i = 0; i < chGroupData.size(); i++) {

            temp = chGroupData.get(i).params.get(key5);

            if(temp != null){

                temp = temp.substring(1, temp.length()-1);
                tempArr = temp.split(",");

                for (int j = 0; j < tempArr.length; j++) {

                    try{
                        tempInt = Integer.parseInt(tempArr[j]);

                        if(!dchNos.contains(tempInt)){
                            dchNos.add(tempInt);
                        }
                    }catch(Exception e){}
                }
            }
        }

        Collections.sort(dchNos);

        for (int i = 0; i < dchNos.size() && dchNos.size() < 32; i++) {

            ergcell.set(DSL.field("FREQ" + (i+1)), dchNos.get(i));
        }

        ergcell.set(DSL.field("TOTALTRX"), dchNos.size());

        ergcell.setErgcellCrcollectortaskfiles(ULong.valueOf(this.sf.getTaskFilesId()));
        ergcell.setErgcellVendor(me.mr.getMapentityVendor());

        ergcell.setErgcellCrcollectortaskfiles(ULong.valueOf(this.sf.getTaskFilesId()));

        ergcell.setErgcellVendor(meo.mr.getMapentityVendor());

//        int result = (ergcell.getErgcellId() == null)?ergcell.store():ergcell.update();
        if (ergcell.getErgcellId() == null) {
            System.out.println("ERGCELL STORE");
            ergcell.store();
        } else {
            System.out.println("ERGCELL UPDATE");
            ergcell.update();
        }

        synchronized (gcells){

            gcells.add(ergcell);
        }
    }

    private void processCell2(DSLContext db, MapEntityObj me, ErBasicTagParamsObj obj){

        ErBasicTagParamsObj mml;
        CrmapfieldRecord mfr;

        String key = "ManagedElement_id";
        String key2 = "vsDataGeranCell_id";
        String key3 = "connectedChannelGroup";
        String key4 = "rSite";
        String key5 = "sector";
        String key6 = "baListActive";

        String bscName = obj.params.get(key);
        String cellName = obj.params.get(key2);

//        System.out.println(Arrays.toString(obj.params.keySet().toArray()));

//        System.out.println("xx bscName: " + bscName);
//        System.out.println("xx cellName: " + cellName);

        CrcellRecord cell = null;

        ErbscRecord bsc = null;

        for (int i = 0; i < bscs.size(); i++) {

            if(bscs.get(i).getBscname().equals(bscName)){

                bsc = bscs.get(i);
                break;
            }
        }

        if(bsc == null){
            return;
        }

        final ULong erbsc_id = bsc.getErbscId();

        ErgcellRecord ergcell = db.selectFrom(ERGCELL)
                .where(ERGCELL.ERGCELL_DATE.eq(UInteger.valueOf(context.getEpochTime())))
                .and(ERGCELL.ERGCELL_ERBSC.eq(erbsc_id))
                .and(ERGCELL.CELL.eq(cellName))
                .fetchAny();

        if(ergcell == null){

            ergcell = db.newRecord(ERGCELL);

            ergcell.setErgcellDate(UInteger.valueOf(context.getEpochTime()));
            ergcell.setErgcellErbsc(erbsc_id);
            ergcell.setCell(cellName);

            System.out.println("set cellName: " + cellName);
        }

        // get relation to erbts through vsDataTgs
        Optional<ErBasicTagParamsObj> tg = vsDataTgs.stream().filter(o -> o.params.get(key3).contains("vsDataGeranCell=" + cellName + ",")).findFirst();

        if(tg.isPresent()){
            ErBasicTagParamsObj tgx = tg.get();

            String rSite = tgx.params.get(key4);

//            System.out.println("cellName: " + cellName + " -> " + rSite);

            for (int i = 0; i < btss.size(); i++) {

                if(btss.get(i).getBtsname() != null && btss.get(i).getBtsname().equals(rSite)){

                    ergcell.setErgcellErbts(btss.get(i).getErbtsId());
                    break;
                }
            }
        }

        ArrayList<String> filters = new ArrayList<>();
//        filters.add(key);
//        filters.add(bscName);
        filters.add(key2);
        filters.add(cellName);

        for (int l = 0; l < me.mft.size(); l++) {

            mfr = me.mft.get(l);

            // if need replace from chrono.context
            if(mfr.getMapfieldSourcegroup().equals("chrono.context")){

                String replaceVal = null;

                switch(mfr.getMapfieldSourceparam()){

                    case "DATE": replaceVal = String.valueOf(context.getEpochTime()); break;
//                        case "PARENTKEY": replaceVal = hwbsc.getHwbscId().toString(); break;
                    default: break;
                }

                if(replaceVal != null){

                    ergcell.set(DSL.field(mfr.getMapfieldFieldname()), replaceVal);
                }
            }
            else{

                String val = getKeyParamsValue(mfr, filters);
//                String val = obj.params.get(mfr.getMapfieldSourceparam());

                if(val != null){

                    ergcell.set(DSL.field(mfr.getMapfieldFieldname()), val);
                }
            }
        }

        // tweak for MCC, MNC, LAC, and CI
        if(ergcell.getCgi() != null){

            String[] el = ergcell.getCgi().split("-");

            ergcell.setMcc(el[0]);
            ergcell.setMnc(el[1]);
            ergcell.setLac(el[2]);
            ergcell.setCi(el[3]);
        }

        try{

            ergcell.setBsic(Integer.parseInt(ergcell.getNcc())*8 + Integer.parseInt(ergcell.getBcc()));
        }
        catch(Exception e){}

        CrnodeRecord node = null;

        String rsite = null;
        String neid = null;

        if(ergcell.getErgcellErbts() != null){

            node = nodeCache.get(ergcell.getErgcellErbts().longValue());
        }

        String neIdSuffix = "";
        String bandLookup = ergcell.getCsystype();

        if(bandLookup == null){
            bandLookup = "GSM900";
        }

        if(ergcell.getCi() != null && ergcell.getLac() != null){

            try{

                String cgi = ergcell.getCgi();
                String fixedCellName = null;
                String fixedNeId = null;

                Matcher m = null;

                // only for matches cell: i.e. TB1234D
                if(cellPattern != null && ergcell.getCell().matches(cellPattern)){

                    m = cellPatternPattern.matcher(ergcell.getCell());

                    if(m.find()){

                        System.out.println("cellName -> " + cellName);

                        String s1 = m.group(1);
                        String s2 = m.group(2);
                        String s3 = m.group(3);

                        if(bandLookup.equals("GSM900")){
                            neIdSuffix = "G1";
                        }
                        else{
                            neIdSuffix = "D1";
                        }

                        Optional<ErgcellmapRecord> rec = ergcellmaps.stream().filter(o -> o.getErgcellmapKey().equals(s1)).findFirst();

//                        System.out.println("s1: " + s1);

                        if(rec.isPresent()){

                            fixedNeId = rec.get().getErgcellmapValue() + s2 + neIdSuffix;
                            fixedCellName = rec.get().getErgcellmapValue() + s2 + s3;

//                            System.out.println("fixedNeId 1: " + fixedNeId);
//                            System.out.println("fixedCellName 1: " + fixedCellName);
                        }

                        // only for combat starts with CO
                        if(ergcell.getCell().startsWith("CO")){

                            if(ergcell.getLatitude() != null && ergcell.getLongitude() != null){

                                logger.debug("trying to get site area defined prefix 1 : " + ergcell.getCell());

                                try{

                                    double lat = Double.parseDouble(ergcell.getLatitude());
                                    double lon = Double.parseDouble(ergcell.getLongitude());

                                    String prefix1 = pgc.getSiteAreaDefinedPrefix1ByLatLon(lat, lon);

                                    if(prefix1 != null){

                                        fixedNeId = prefix1 + s2 + neIdSuffix;

                                        logger.debug("set new ne id for cell: " + ergcell.getCell() + " -> " + fixedNeId);

                                        node = new CrnodeRecord();
                                        node.setNodeCode(fixedNeId);
                                        rsite = fixedNeId;
                                    }
                                }
                                catch(Exception e) {

                                }
                            }
                        }
                    }
                }
                else{

                    // normal pattern: JKP001
                    String pattern = "([A-Z]{3})([0-9]{3})([A-Z]{1})";
                    Pattern px = Pattern.compile(pattern);
                    Matcher mx = px.matcher(ergcell.getCell());

                    if(mx.find()){

                        System.out.println("cellName2 -> " + cellName);

                        String s1 = mx.group(1);
                        String s2 = mx.group(2);
                        String s3 = mx.group(3);

                        if(bandLookup.equals("GSM900")){
                            neIdSuffix = "G1";
                        }
                        else{
                            neIdSuffix = "D1";
                        }

                        fixedNeId = s1 + s2 + neIdSuffix;
                        fixedCellName = s1 + s2 + s3;
                    }
                }

                if(fixedNeId == null){
                    fixedNeId = rsite;
                }
                else{
                    // replace anyway
                    node = new CrnodeRecord();
                    node.setNodeCode(fixedNeId);
                }

                if(fixedCellName == null){
                    fixedCellName = ergcell.getCell();
                }

                CrcellRecord cellProto = CellUtils.getCellProto(ergcell, node);

                // set relation to crcell
                cell = pgc.getCell(bandLookup, cgi, cellProto, node);

                if(cell != null){

                    ergcell.setErgcellCell(cell.getCellId());
                    ergcell.setErgcellCellclass(cell.getCellCellclass());
                    ergcell.setErgcellCellcoverage(cell.getCellCellcoverage());
                    ergcell.setErgcellRevenueclass(cell.getCellRevenueclass());
                    ergcell.setErgcellLatitude(cell.getCellLatitude());
                    ergcell.setErgcellLongitude(cell.getCellLongitude());

//                    CrnodeRecord nodeAlias = pgc.getCellNodeAlias(ergcell, ergcell, ergcell.getErgcellCellclass(), null, ergcell.getCell(), node);

//                    String cName = ergcell.getCell();

//                    System.out.println("send: " + fixedCellName + " -> " + rsite);

//                    if(neid == null){
//                        neid = fixedNeId;
//                    }

                    CrnodeRecord nodeAlias = pgc.getCellNodeAlias2(meo.mr.getMapentityVendor(), cell.getCellCellclass(), fixedNeId, fixedNeId);

//                    System.out.println("result: " + nodeAlias);

                    if(nodeAlias != null){
                        ergcell.setErgcellNodealias(nodeAlias.getNodeId());
                    }
                }
                else{
                    logger.debug("failed to get crcell data 2: " + ergcell.getCell());
                }
            }
            catch(Exception e){

                e.printStackTrace();
            }
        }

        // complete FREQ1-12 data
        String[] baListActives = obj.params.get(key6).split(";");
        ArrayList<Integer> dchNos = new ArrayList<>();
        String temp;
        String[] tempArr;
        int tempInt;

        for (int i = 0; i < baListActives.length; i++) {

            try{
                tempInt = Integer.parseInt(baListActives[i]);

                if(!dchNos.contains(tempInt)){
                    dchNos.add(tempInt);
                }
            }catch(Exception e){}
        }

        Collections.sort(dchNos);

        for (int i = 0; i < dchNos.size() && dchNos.size() < 32; i++) {

            ergcell.set(DSL.field("FREQ" + (i+1)), dchNos.get(i));
        }

        ergcell.set(DSL.field("TOTALTRX"), dchNos.size());

        ergcell.setErgcellCrcollectortaskfiles(ULong.valueOf(this.sf.getTaskFilesId()));
        ergcell.setErgcellVendor(me.mr.getMapentityVendor());

        ergcell.setErgcellCrcollectortaskfiles(ULong.valueOf(this.sf.getTaskFilesId()));

        ergcell.setErgcellVendor(meo.mr.getMapentityVendor());

//        int result = (ergcell.getErgcellId() == null)?ergcell.store():ergcell.update();
        if (ergcell.getErgcellId() == null) {
            ergcell.store();
        } else {
            ergcell.update();
        }

        synchronized (gcells){

            gcells.add(ergcell);
        }
    }

    private void fixBts(DSLContext db){

        List<CrcellclassRecord> cellClasses = db.fetch(CRCELLCLASS);
        Pattern pattern = Pattern.compile(sitePattern.get(0).getSettingsValue());
        Matcher matcher;

        // get field definition for hwbts
        MapEntityObj me = meo.getChildEntityByTableName("erbts");

        for (int i = 0; i < btss.size(); i++) {

            // only search for problem
            if(btss.get(i).getErbtsNode() != null){
                continue;
            }

            ArrayList<Integer> cellClass = new ArrayList<Integer>();
            String siteCode = null;

            for (int j = 0; j < gcells.size(); j++) {

                if(btss.get(i).getErbtsId().equals(gcells.get(j).getErgcellErbts())){

                    if(gcells.get(j).getErgcellCellclass() != null && !cellClass.contains(gcells.get(j).getErgcellCellclass())){

                        cellClass.add(gcells.get(j).getErgcellCellclass());
                    }

                    // get site id pattern
                    if(siteCode == null){

                        matcher = pattern.matcher(gcells.get(j).getCell());

                        if(matcher.find()){

                            siteCode = matcher.group(0);
                        }
                    }
                }
            }

            if(cellClass.size() > 0 && siteCode != null){

                String suffix = null;

                // determine suffix for ne id
                for (int j = 0; j < cellClasses.size(); j++) {

                    if(cellClasses.get(j).getCellclassId().intValue() == cellClass.get(0)){

                        if(cellClass.size() == 1){

                            suffix = cellClasses.get(j).getCellclassNecodesuffix();
                        }
                        else{
                            suffix = cellClasses.get(j).getCellclassNecodesuffixmixed();
                        }

                        break;
                    }
                }


                if(suffix != null){

                    siteCode += suffix;

//                    System.out.println(btss.get(i).getSite() + " -> " + siteCode);

                    btss.get(i).setBtsname(siteCode + "_" + btss.get(i).getSite());
                    btss.get(i).setNeid(siteCode);

                    CrnodeRecord node = pgc.getNode(meo.mr.getMapentityVendor(), btss.get(i).getBtsname(), me.mr.getMapentityNodecategory());

                    if(node != null){

                        btss.get(i).setErbtsNode(node.getNodeId());
                        btss.get(i).setErbtsRevenueclass(node.getNodeRevenueclass());

                        db.executeUpdate(btss.get(i));
                    }
                }
            }
        }
    }

    private void updateBsc(DSLContext db){

        logger.debug("updateBsc()");

        logger.debug("updateBsc() done");
    }

    private void clearUnusedData(DSLContext db){

        sf.purgeResult();
        this.result.clear();
    }
}

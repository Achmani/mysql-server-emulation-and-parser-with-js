package id.mit.chrono.server.obj;

import id.mit.chrono.server.base.BaseParserGroup;
import id.mit.chrono.server.base.NokBaseContainer;
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

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import static id.mit.chrono.server.model.Tables.*;

public class NokBscContainer extends NokBaseContainer implements FileProcessor {

    private NokbscRecord nokbsc;
    private ArrayList<NokbtsRecord> nokbcfs = new ArrayList<>();
    private ArrayList<NokgcellRecord> nokbtss = new ArrayList<>();
    private HashMap<Long, CrnodeRecord> nodeCache = new HashMap();

    private List<NokBasicTagParamsObj> bcfs;
    private List<NokBasicTagParamsObj> btss;
    private List<NokBasicTagParamsObj> sites;
    private List<NokBasicTagParamsObj> trxs;

    public NokBscContainer(DSLContext db, ParserGroupCallback pgc, ChronoContext context, SourceFile sf, MapEntityObj meo) {
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

        // get BCFlist
        bcfs = result.stream()
                .filter(p -> p.className.equals("BCF"))
                .collect(Collectors.toList());

        logger.debug("bcfs: " + bcfs.size());

        btss = result.stream()
                .filter(p -> p.className.equals("BTS"))
                .collect(Collectors.toList());

        logger.debug("btss: " + btss.size());

        sites = result.stream()
                .filter(p -> p.className.equals("SITE"))
                .collect(Collectors.toList());

        logger.debug("sites: " + sites.size());

        trxs = result.stream()
                .filter(p -> p.className.equals("TRX"))
                .collect(Collectors.toList());

        logger.debug("trxs: " + trxs.size());
        addMeasurement(PS.PREPARE, this.getKey(), true);

        this.prepareBsc(adb);
        addMeasurement(PS.BSC, this.getKey(), true);

        this.prepareBcf(adb);
        addMeasurement(PS.BTS, this.getKey(), true);

        this.prepareBts(adb);
        addMeasurement(PS.CELL2G, this.getKey(), true);

        this.prepareTrx(adb);
        addMeasurement(PS.TRX, this.getKey(), true);

        this.updateBsc(adb);
        this.clearUnusedData(adb);
        addMeasurement(PS.FINALIZE, this.getKey(), true);

        saveStatistics(adb);

        return true;
    }

    private void prepareBsc(DSLContext db){

        logger.debug("prepareBsc()");

        NokBasicTagParamsObj mml;
        CrmapfieldRecord mfr;

        System.out.println("sf.getKey(): " + sf.getKey());

        nokbsc = db.selectFrom(NOKBSC)
                .where(NOKBSC.NOKBSC_DATE.eq(UInteger.valueOf(context.getEpochTime())))
                .and(NOKBSC.DISTNAME.eq(sf.getKey()))
                .fetchOne();

        if(nokbsc == null){

            nokbsc = db.newRecord(NOKBSC);
            nokbsc.setNokbscDate(UInteger.valueOf(context.getEpochTime()));
            nokbsc.setDistname(sf.getKey());
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

                    nokbsc.set(DSL.field(mfr.getMapfieldFieldname()), replaceVal);
                }
            }
            else{

                nokbsc.set(DSL.field(mfr.getMapfieldFieldname()), getKeyParamsValue(mfr, null, null));
            }
        }

        nokbsc.setNokbscVendor(meo.mr.getMapentityVendor());

        nokbsc.setNokbscCrcollectortaskfiles(ULong.valueOf(this.sf.getTaskFilesId()));

        nokbsc.setTotalbts(bcfs.size());
        nokbsc.setTotalcell(btss.size());
        nokbsc.setTotaltrx(trxs.size());

        CrnodeRecord node = pgc.getNode(meo.mr.getMapentityVendor(), nokbsc.getBscname(), meo.mr.getMapentityNodecategory());

        if(node != null){

            nokbsc.setNokbscNode(node.getNodeId());
        }

        int res = (nokbsc.getNokbscId() == null)?nokbsc.store():nokbsc.update();

        logger.debug("prepareBsc() done");
    }

    private void prepareBcf(DSLContext db){

        logger.debug("prepareBcf()");

        bcfs.forEach(item -> {
            System.out.println(item.className + " -> " + item.params);
        });

        // get field definition for hwbts
        MapEntityObj me = meo.getChildEntityByTableName("nokbts");

        bcfs.stream().forEach(objx -> processBcf(db, me, objx));

        logger.debug("prepareBcf() done");
    }

    private void processBcf(DSLContext db, MapEntityObj me, NokBasicTagParamsObj obj){

        CrmapfieldRecord mfr;

        String key = "distName";
        String key2 = "siteId";
        String key3 = "longitude";
        String key4 = "latitude";
        String key5 = "streetAddress";

        String distName = obj.params.get(key);
        String siteId = obj.params.get(key2);

        NokbtsRecord nokbcf = db.selectFrom(NOKBTS)
                .where(NOKBTS.NOKBTS_DATE.eq(UInteger.valueOf(context.getEpochTime())))
                .and(NOKBTS.NOKBTS_NOKBSC.eq(nokbsc.getNokbscId()))
                .and(NOKBTS.DISTNAME.eq(distName))
                .fetchOne();

        if(nokbcf == null){

            nokbcf = db.newRecord(NOKBTS);

            nokbcf.setNokbtsDate(UInteger.valueOf(context.getEpochTime()));
            nokbcf.setNokbtsNokbsc(nokbsc.getNokbscId());
            nokbcf.setDistname(distName);
        }

        ArrayList<String> filters = new ArrayList<>();
        filters.add(key);
        filters.add(distName);

        NokBasicTagParamsObj bcfSiteData = null;

        for (int j = 0; siteId != null && bcfSiteData == null && j < sites.size(); j++) {

            if(siteId.equals(sites.get(j).params.get(key2))){

                bcfSiteData = sites.get(j);
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

                    nokbcf.set(DSL.field(mfr.getMapfieldFieldname()), replaceVal);
                }
            }
            else{

                String val = getKeyParamsValue(mfr, filters, null);

                if(val != null){

                    nokbcf.set(DSL.field(mfr.getMapfieldFieldname()), val);
                }
            }
        }

        nokbcf.setNokbtsVendor(meo.mr.getMapentityVendor());

        // set relation to crnode
        CrnodeRecord node = pgc.getNode(meo.mr.getMapentityVendor(), nokbcf.getName(), me.mr.getMapentityNodecategory());

        if(node != null){

            nokbcf.setNokbtsNode(node.getNodeId());
            nokbcf.setNokbtsRevenueclass(node.getNodeRevenueclass());
        }

        nokbcf.setNokbtsNodestatus(pgc.getNodeStatus(nokbcf.getName()));

        nokbcf.setNokbtsCrcollectortaskfiles(ULong.valueOf(this.sf.getTaskFilesId()));

        for (int j = 0; j < sites.size(); j++) {

            if(sites.get(j).params.get(key2).equals(nokbcf.getSiteid())){

                nokbcf.setLongitude(sites.get(j).params.get(key3));
                nokbcf.setLatitude(sites.get(j).params.get(key4));
//                    nokbcf.setStreetaddress(sites.get(j).params.get(key5));

                break;
            }
        }

        int totalTrx = 0;

        for (int j = 0; j < trxs.size(); j++) {

            if(trxs.get(j).params.get(key).startsWith(nokbcf.getDistname() + "/")){

                totalTrx++;
            }
        }

        nokbcf.setTotaltrx(totalTrx);

        int totalCell = 0;

        for (int j = 0; j < btss.size(); j++) {

            if(btss.get(j).params.get(key).startsWith(nokbcf.getDistname() + "/")){

                // collect trx and freq number;

                totalCell++;
            }
        }

        nokbcf.setTotalcell(totalCell);

        nokbcf.setLat(GeoUtil.getNokia2GLat(nokbcf.getLatitude()));
        nokbcf.setLon(GeoUtil.getNokia2GLon(nokbcf.getLongitude()));

        int res = (nokbcf.getNokbtsId() == null)?nokbcf.store():nokbcf.update();

        synchronized (nokbcfs){

            nokbcfs.add(nokbcf);

            if(node != null){

                nodeCache.put(nokbcf.getNokbtsId().longValue(), node);
            }
        }
    }

    private void prepareBts(DSLContext db){

        logger.debug("prepareBts()");

        // get field definition for hwgcell
        MapEntityObj me = meo.getChildEntityByTableName("nokgcell");

        btss.parallelStream().forEach(objx -> processBts(db, me, objx));

        logger.debug("prepareBts() done");
    }

    private void processBts(DSLContext db, MapEntityObj me, NokBasicTagParamsObj obj){

        CrmapfieldRecord mfr;

        String key = "distName";
        String key2 = "initialFrequency";
        String key3 = "preferredBcchMark";

        String distName = obj.params.get(key);

        // select from DB, if not found, then create a new one

        NokgcellRecord gcell = db.selectFrom(NOKGCELL)
                .where(NOKGCELL.NOKGCELL_DATE.eq(UInteger.valueOf(context.getEpochTime())))
                .and(NOKGCELL.NOKGCELL_NOKBSC.eq(nokbsc.getNokbscId()))
                .and(NOKGCELL.DISTNAME.eq(distName))
                .fetchAny();

        if(gcell == null){

            gcell = db.newRecord(NOKGCELL);

            gcell.setNokgcellDate(UInteger.valueOf(context.getEpochTime()));
            gcell.setNokgcellNokbsc(nokbsc.getNokbscId());
            gcell.setDistname(distName);
        }

        ArrayList<String> filters = new ArrayList<>();
        filters.add(key);
        filters.add(distName);

        for (int l = 0; l < me.mft.size(); l++) {

            mfr = me.mft.get(l);

            // if need replace from chrono.context
            if(mfr.getMapfieldSourcegroup().equals("chrono.context")){

                String replaceVal = null;

                switch(mfr.getMapfieldSourceparam()){

                    case "DATE": replaceVal = String.valueOf(context.getEpochTime()); break;
                    default: break;
                }

                if(replaceVal != null){

                    gcell.set(DSL.field(mfr.getMapfieldFieldname()), replaceVal);
                }
            }
            else{

                String val = getKeyParamsValue(mfr, filters, null);
                if(val != null){

                    gcell.set(DSL.field(mfr.getMapfieldFieldname()), val);
                }
            }
        }

        int totalTrx = 0;
        ArrayList<Integer> freqs = new ArrayList<>();
//        ArrayList<Integer> freqKeys = new ArrayList<>();
//        HashMap<Integer, String> freqs = new HashMap<>();
        String temp;
        int tempInt, tempInt2;

        for (int j = 0; j < trxs.size(); j++) {

            temp = trxs.get(j).params.get(key);

            if(temp.startsWith(gcell.getDistname() + "/")){

                temp = temp.substring(temp.lastIndexOf("-"));

                tempInt = Integer.parseInt(temp);
//                freqKeys.add(tempInt);
//                freqs.put(tempInt, trxs.get(j).params.get(key2));


                // check for bcchno
                try{

                    tempInt = Integer.parseInt(trxs.get(j).params.get(key2));

                    if(!freqs.contains(tempInt)){

                        freqs.add(tempInt);
                    }

                    tempInt2 = Integer.parseInt(trxs.get(j).params.get(key3));

                    if(tempInt2 == 1){

                        gcell.set(DSL.field("BCCHNO"), trxs.get(j).params.get(key2));
                    }
                }
                catch(Exception e){}

                totalTrx++;
            }
        }

        Collections.sort(freqs);

        gcell.setTotaltrx(freqs.size());

        String prefix = "FREQ";

        for (int j = 0; j < freqs.size() && freqs.size() < 24; j++) {

            if(j==0 && gcell.get(DSL.field("BCCHNO"), String.class) == null){
                gcell.set(DSL.field("BCCHNO"), freqs.get(j));
            }

            gcell.set(DSL.field(prefix + (j+1)), freqs.get(j));
        }

        for (int j = 0; j < nokbcfs.size(); j++) {

            if(gcell.getDistname().startsWith(nokbcfs.get(j).getDistname() + "/")){

                gcell.setNokgcellNokbsc(nokbcfs.get(j).getNokbtsNokbsc());
                gcell.setNokgcellNokbts(nokbcfs.get(j).getNokbtsId());

                // set lat-lon
                gcell.setLatitude(nokbcfs.get(j).getLat());
                gcell.setLongitude(nokbcfs.get(j).getLon());

                break;
            }
        }

        String lookup = gcell.getFrequencybandinuse();

        if(lookup.equals("0")){
            lookup = "GSM900";
        }
        else if(lookup.equals("1")){
            lookup = "DCS1800";
        }

        String cgi = getCGI(gcell.getLocationareaidmcc(), gcell.getLocationareaidmnc(), gcell.getLocationareaidlac(), gcell.getCellid());

        if(cgi != null){

            CrnodeRecord node = nodeCache.get(gcell.getNokgcellNokbts().longValue());

            CrcellRecord cellProto = CellUtils.getCellProto(gcell, node);

            //set relation to crcell
            CrcellRecord cell = pgc.getCell(lookup, cgi, cellProto, node);

            if(cell != null){

                gcell.setNokgcellCell(cell.getCellId());
                gcell.setNokgcellCellclass(cell.getCellCellclass());
                gcell.setNokgcellCellcoverage(cell.getCellCellcoverage());
                gcell.setNokgcellRevenueclass(cell.getCellRevenueclass());
                gcell.setNokgcellLatitude(cell.getCellLatitude());
                gcell.setNokgcellLongitude(cell.getCellLongitude());

//                CrnodeRecord nodeAlias = pgc.getCellNodeAlias(gcell, gcell, cell.getCellCellclass(), null, gcell.getName(), node);

                String neName = (node != null)?node.getNodeCode(): null;

                CrnodeRecord nodeAlias = pgc.getCellNodeAlias2(meo.mr.getMapentityVendor(), cell.getCellCellclass(), gcell.getName(), neName);

                if(nodeAlias != null){
                    gcell.setNokgcellNodealias(nodeAlias.getNodeId());
                }
            }
        }

        // set calculated lat lon decimal
//            gcell.setLatitude(GeoUtil.getHuawei2GLat(gcell.getNslati(), gcell.getLatiint(), gcell.getLatideci()));
//            gcell.setLongitude(GeoUtil.getHuawei2GLon(gcell.getWelongi(), gcell.getLongiint(), gcell.getLongideci()));


        if(gcell.getName() == null){
            gcell.setName(gcell.getDistname());
        }

        gcell.setCgi(cgi);
        gcell.setBsic(Integer.parseInt(gcell.getBsidentitycodencc())*8 + Integer.parseInt(gcell.getBsidentitycodebcc()));

        gcell.setNokgcellVendor(me.mr.getMapentityVendor());

        gcell.setNokgcellCellstatus(pgc.getCellStatus(gcell.getName()));

        gcell.setNokgcellCrcollectortaskfiles(ULong.valueOf(this.sf.getTaskFilesId()));

        int res = (gcell.getNokgcellId() == null)?gcell.store():gcell.update();

        synchronized (nokbtss){

            nokbtss.add(gcell);
        }
    }

    private void prepareTrx(DSLContext db){

        logger.debug("prepareTrx()");

        HuaweiBasicKeyParamsObj mml;
        CrmapfieldRecord mfr;

        // get field definition for hwgcell
        MapEntityObj me = meo.getChildEntityByTableName("nokgtrx");

        String key = "distName";

        for (int i = 0; i < trxs.size(); i++) {

            String distName = trxs.get(i).params.get(key);

            // select from DB, if not found, then create a new one

            NokgtrxRecord trx = db.selectFrom(NOKGTRX)
                    .where(NOKGTRX.NOKGTRX_DATE.eq(UInteger.valueOf(context.getEpochTime())))
                    .and(NOKGTRX.NOKGTRX_NOKBSC.eq(nokbsc.getNokbscId()))
                    .and(NOKGTRX.DISTNAME.eq(distName))
                    .fetchAny();

            if(trx == null){

                trx = db.newRecord(NOKGTRX);

                trx.setNokgtrxDate(UInteger.valueOf(context.getEpochTime()));
                trx.setNokgtrxNokbsc(nokbsc.getNokbscId());
                trx.setDistname(distName);
            }

            ArrayList<String> filters = new ArrayList<>();
            filters.add(key);
            filters.add(distName);

            for (int l = 0; l < me.mft.size(); l++) {

                mfr = me.mft.get(l);

                // if need replace from chrono.context
                if(mfr.getMapfieldSourcegroup().equals("chrono.context")){

                    String replaceVal = null;

                    switch(mfr.getMapfieldSourceparam()){

                        case "DATE": replaceVal = String.valueOf(context.getEpochTime()); break;
                        default: break;
                    }

                    if(replaceVal != null){

                        trx.set(DSL.field(mfr.getMapfieldFieldname()), replaceVal);
                    }
                }
                else{

                    trx.set(DSL.field(mfr.getMapfieldFieldname()), getKeyParamsValue(mfr, filters, null));
                }
            }

            // correlate to cell and bts

            for (int j = 0; j < nokbtss.size(); j++) {

                if(trx.getDistname().startsWith(nokbtss.get(j).getDistname() + "/")){

                    trx.setNokgtrxNokgcell(nokbtss.get(j).getNokgcellId());
                    trx.setNokgtrxNokbts(nokbtss.get(j).getNokgcellNokbts());

                    break;
                }
            }

            trx.setNokgtrxCrcollectortaskfiles(ULong.valueOf(this.sf.getTaskFilesId()));

            int res = (trx.getNokgtrxId() == null)?trx.store():trx.update();
        }

        logger.debug("prepareTrx() done");
    }

    private void updateBsc(DSLContext db){

        logger.debug("updateBsc()");


        logger.debug("updateBsc() done");
    }

    private void clearUnusedData(DSLContext db){

        sf.purgeResult();

        bcfs.clear();
        btss.clear();
        sites.clear();
        trxs.clear();

        this.result.clear();
    }
}

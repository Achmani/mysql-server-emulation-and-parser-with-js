package id.mit.chrono.server.obj;

import id.mit.chrono.server.base.BaseParserGroup;
import id.mit.chrono.server.base.NokBaseContainer;
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

public class NokRncContainer extends NokBaseContainer implements FileProcessor {

    private NokrncRecord nokrnc;
    private ArrayList<NoknodebRecord> noknodebs = new ArrayList<>();
    private ArrayList<NokucellRecord> nokucells = new ArrayList<>();
    private HashMap<Long, CrnodeRecord> nodeCache = new HashMap();

    private List<NokBasicTagParamsObj> wbtss;
    private List<NokBasicTagParamsObj> wcels;
    private List<NokBasicTagParamsObj> sites;

    public NokRncContainer(DSLContext db, ParserGroupCallback pgc, ChronoContext context, SourceFile sf, MapEntityObj meo) {
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
        wbtss = result.stream()
                .filter(p -> p.className.equals("WBTS"))
                .collect(Collectors.toList());

        logger.debug("wbtss: " + wbtss.size());

        wcels = result.stream()
                .filter(p -> p.className.equals("WCEL"))
                .collect(Collectors.toList());

        logger.debug("wcels: " + wcels.size());

        sites = result.stream()
                .filter(p -> p.className.equals("SITE"))
                .collect(Collectors.toList());

        logger.debug("sites: " + sites.size());

        this.prepareRnc(adb);
        addMeasurement(PS.RNC, this.getKey(), true);

        this.prepareWbts(adb);
        addMeasurement(PS.NODEB, this.getKey(), true);

        this.prepareWcel(adb);
        addMeasurement(PS.CELL3G, this.getKey(), true);

        this.updateRnc(adb);
        this.clearUnusedData(adb);

        addMeasurement(PS.FINALIZE, this.getKey(), true);

        saveStatistics(adb);
        return true;
    }

    private void prepareRnc(DSLContext db){

        logger.debug("prepareRnc()");

        NokBasicTagParamsObj mml;
        CrmapfieldRecord mfr;

        nokrnc = db.selectFrom(NOKRNC)
                .where(NOKRNC.NOKRNC_DATE.eq(UInteger.valueOf(context.getEpochTime())))
                .and(NOKRNC.DISTNAME.eq(sf.getKey()))
                .fetchAny();

        if(nokrnc == null){

            nokrnc = db.newRecord(NOKRNC);
            nokrnc.setNokrncDate(UInteger.valueOf(context.getEpochTime()));
            nokrnc.setDistname(sf.getKey());
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

                    nokrnc.set(DSL.field(mfr.getMapfieldFieldname()), replaceVal);
                }
            }
            else{

                String val = getKeyParamsValue(mfr, null, null);

                if(val != null){

                    nokrnc.set(DSL.field(mfr.getMapfieldFieldname()), val);
                }
            }
        }

        CrnodeRecord node = pgc.getNode(meo.mr.getMapentityVendor(), nokrnc.getRncname(), meo.mr.getMapentityNodecategory());

        if(node != null){

            nokrnc.setNokrncNode(node.getNodeId());
        }

        nokrnc.setNokrncCrcollectortaskfiles(ULong.valueOf(this.sf.getTaskFilesId()));

        nokrnc.setNokrncVendor(meo.mr.getMapentityVendor());

        nokrnc.setTotalnodeb(wbtss.size());
        nokrnc.setTotalcell(wcels.size());

        int res = (nokrnc.getNokrncId() == null)?nokrnc.store():nokrnc.update();

        logger.debug("prepareRnc() done");
    }

    private void prepareWbts(DSLContext db){

        logger.debug("prepareWbts()");

        // get field definition for hwbts
        MapEntityObj me = meo.getChildEntityByTableName("noknodeb");

        wbtss.parallelStream().forEach(objx -> processWbts(db, me, objx));

        logger.debug("prepareWbts() done");
    }

    private void processWbts(DSLContext db, MapEntityObj me, NokBasicTagParamsObj obj){

        CrmapfieldRecord mfr;

        String key = "distName";

        String distName = obj.params.get(key);

        NoknodebRecord noknodeb = db.selectFrom(NOKNODEB)
                .where(NOKNODEB.NOKNODEB_DATE.eq(UInteger.valueOf(context.getEpochTime())))
                .and(NOKNODEB.NOKNODEB_NOKRNC.eq(nokrnc.getNokrncId()))
                .and(NOKNODEB.DISTNAME.eq(distName))
                .fetchAny();

        if(noknodeb == null){

            noknodeb = db.newRecord(NOKNODEB);

            noknodeb.setNoknodebDate(UInteger.valueOf(context.getEpochTime()));
            noknodeb.setNoknodebNokrnc(nokrnc.getNokrncId());
            noknodeb.setDistname(distName);
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
                    case "PARENTKEY": replaceVal = "XXX"; break;
                    default: break;
                }

                if(replaceVal != null){

                    noknodeb.set(DSL.field(mfr.getMapfieldFieldname()), replaceVal);
                }
            }
            else{

                String val = getKeyParamsValue(mfr, filters, null);

                if(val != null){

                    noknodeb.set(DSL.field(mfr.getMapfieldFieldname()), val);
                }
            }
        }

        // set lat lon from SITE
        // wildan

        NokBasicTagParamsObj temp;

        Double test;

        for (int i = 0; i < sites.size(); i++) {

            temp = sites.get(i);

            // check based on matching fields
            if(noknodeb.getSiteid() != null && noknodeb.getSiteid().equals(temp.params.get("siteId"))){

//                System.out.println("found -> " + noknodeb.getName());

                if(temp.params.get("latitude") != null){

                    test = Double.parseDouble(temp.params.get("latitude"));
                    test = test/10000000;

                    noknodeb.setLatitude(String.valueOf(test));

                    test = Double.parseDouble(temp.params.get("longitude"));
                    test = test/10000000;

                    noknodeb.setLongitude(String.valueOf(test));
                }

//                noknodeb.setLatitude(temp.params.get("latitude"));
//                noknodeb.setLongitude(temp.params.get("longitude"));
            }
        }


        noknodeb.setNoknodebVendor(meo.mr.getMapentityVendor());

        // set relation to crnode
        CrnodeRecord node = pgc.getNode(meo.mr.getMapentityVendor(), noknodeb.getWbtsname(), me.mr.getMapentityNodecategory());

        if(node != null){

            noknodeb.setNoknodebNode(node.getNodeId());
            noknodeb.setNoknodebRevenueclass(node.getNodeRevenueclass());
        }

        int totalCell = 0;

        // calculate total cell
        for (int j = 0; j < wcels.size(); j++) {

            if(wcels.get(j).params.get(key).startsWith(noknodeb.getDistname() + "/")){

                totalCell++;
            }
        }

        if(noknodeb.getNodebname() == null){
            noknodeb.setNodebname(noknodeb.getWbtsname());
        }

        noknodeb.setTotalcell(totalCell);

        noknodeb.setNoknodebNodestatus(pgc.getNodeStatus(noknodeb.getName()));

        noknodeb.setNoknodebCrcollectortaskfiles(ULong.valueOf(this.sf.getTaskFilesId()));

        int res = (noknodeb.getNoknodebId() == null)?noknodeb.store():noknodeb.update();

        if(node != null){

            synchronized (nodeCache){

                nodeCache.put(noknodeb.getNoknodebId().longValue(), node);
            }
        }

        synchronized (noknodebs){

            noknodebs.add(noknodeb);
        }
    }

    private void prepareWcel(DSLContext db){

        logger.debug("prepareWcel()");

        MapEntityObj me = meo.getChildEntityByTableName("nokucell");

        wcels.parallelStream().forEach(objx -> processWcel(db, me, objx));

        logger.debug("prepareWcel() done");
    }

    private void processWcel(DSLContext db, MapEntityObj me, NokBasicTagParamsObj obj){

        NokBasicTagParamsObj mml;
        CrmapfieldRecord mfr;

        String key = "distName";

        String distName = obj.params.get(key);

        NokucellRecord nokucell = db.selectFrom(NOKUCELL)
                .where(NOKUCELL.NOKUCELL_DATE.eq(UInteger.valueOf(context.getEpochTime())))
                .and(NOKUCELL.NOKUCELL_NOKRNC.eq(nokrnc.getNokrncId()))
                .and(NOKUCELL.DISTNAME.eq(distName))
                .fetchAny();

        if(nokucell == null){

            nokucell = db.newRecord(NOKUCELL);

            nokucell.setNokucellDate(UInteger.valueOf(context.getEpochTime()));
            nokucell.setNokucellNokrnc(nokrnc.getNokrncId());
            nokucell.setDistname(distName);
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
                    case "PARENTKEY": replaceVal = "XXX"; break;
                    default: break;
                }

                if(replaceVal != null){

                    nokucell.set(DSL.field(mfr.getMapfieldFieldname()), replaceVal);
                }
            }
            else{

                String val = getKeyParamsValue(mfr, filters, null);

                if(val != null){

                    nokucell.set(DSL.field(mfr.getMapfieldFieldname()), val);
                }
            }
        }
        nokucell.setRncid(nokrnc.getActiveprnc());

        // connect to nodeb
        for (int j = 0; j < noknodebs.size(); j++) {

            if(nokucell.getDistname().startsWith(noknodebs.get(j).getDistname() + "/")){

                nokucell.setNokucellNoknodeb(noknodebs.get(j).getNoknodebId());

                // copy latitude longitude from wbts level
                nokucell.setLatitude(noknodebs.get(j).getLatitude());
                nokucell.setLongitude(noknodebs.get(j).getLongitude());

                break;
            }
        }

        String cgi = getCGI(nokucell.getWcelmcc(), nokucell.getWcelmnc(), nokucell.getLac(), nokucell.getCid());

        if(cgi != null){

            nokucell.setCgi(cgi);

            CrnodeRecord node = nodeCache.get(nokucell.getNokucellNoknodeb().longValue());

            CrcellRecord cellProto = CellUtils.getCellProto(nokucell, node);

            Double uarfcn = Double.parseDouble((String) nokucell.get(DSL.field("UARFCN")));

            CrcellRecord cell = pgc.getCellByArfcn("UMTS", uarfcn, cgi, cellProto, node);

            if(cell != null){

                nokucell.setNokucellCell(cell.getCellId());
                nokucell.setNokucellCellclass(cell.getCellCellclass());
                nokucell.setNokucellCellcoverage(cell.getCellCellcoverage());
                nokucell.setNokucellRevenueclass(cell.getCellRevenueclass());
                nokucell.setNokucellLatitude(cell.getCellLatitude());
                nokucell.setNokucellLongitude(cell.getCellLongitude());

//                Double uarfcn = null;

                if(uarfcn != null){

//                    uarfcn = Double.parseDouble(nokucell.get(DSL.field("UARFCN")).toString());

//                    CrnodeRecord nodeAlias = pgc.getCellNodeAlias(nokucell, nokucell, cell.getCellCellclass(), uarfcn, nokucell.getName(), node);
                    String neName = (node != null)?node.getNodeCode(): null;
                    String cellName = nokucell.getName() != null? nokucell.getName() : "";

                    CrnodeRecord nodeAlias = pgc.getCellNodeAlias2(meo.mr.getMapentityVendor(), cell.getCellCellclass(), cellName, neName);

                    if(nodeAlias != null){
                        nokucell.setNokucellNodealias(nodeAlias.getNodeId());
                    }
                }
            }
        }

        // set name
        if(nokucell.getName() == null){
            nokucell.setName(nokucell.getDistname());
        }

        nokucell.setNokucellCellstatus(pgc.getCellStatus(nokucell.getName()));
        nokucell.setNokucellVendor(meo.mr.getMapentityVendor());
        nokucell.setNokucellCrcollectortaskfiles(ULong.valueOf(this.sf.getTaskFilesId()));

        int res = (nokucell.getNokucellId() == null)?nokucell.store():nokucell.update();

        synchronized (nokucells){

            nokucells.add(nokucell);
        }
    }

    private void updateRnc(DSLContext db){

        logger.debug("updateRnc()");


        logger.debug("updateRnc() done");
    }

    private void clearUnusedData(DSLContext db){

        sf.purgeResult();
        wbtss.clear();
        wcels.clear();
        this.result.clear();
    }
}

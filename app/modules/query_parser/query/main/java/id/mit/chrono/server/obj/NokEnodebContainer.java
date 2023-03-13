package id.mit.chrono.server.obj;

import id.mit.chrono.server.base.BaseParserGroup;
import id.mit.chrono.server.base.NokBaseContainer;
import id.mit.chrono.server.enm.PS;
import id.mit.chrono.server.iface.FileProcessor;
import id.mit.chrono.server.iface.ParserGroupCallback;
import id.mit.chrono.server.model.tables.Crcell;
import id.mit.chrono.server.model.tables.records.*;
import id.mit.chrono.server.util.CellUtils;
import id.mit.chrono.server.util.GsmNetworkUtils;
import org.apache.xmlbeans.impl.regex.Match;
import org.jooq.DSLContext;
import org.jooq.impl.DSL;
import org.jooq.types.UInteger;
import org.jooq.types.ULong;
import org.slf4j.LoggerFactory;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static id.mit.chrono.server.model.Tables.*;
import static id.mit.chrono.server.model.Tables.HWLCELL;

public class NokEnodebContainer extends NokBaseContainer implements FileProcessor {

    private NokenodebRecord nokenodeb;
    private HashMap<Long, CrnodeRecord> nodeCache = new HashMap();
    private ArrayList<NoklcellRecord> noklcells = new ArrayList<>();

    private List<NokBasicTagParamsObj> lnbtss;
    private List<NokBasicTagParamsObj> lncells;
    private List<NokBasicTagParamsObj> lncellfddtddss;
    private List<NokBasicTagParamsObj> sitess;

    DecimalFormat df = new DecimalFormat("####.########");

    public NokEnodebContainer(DSLContext db, ParserGroupCallback pgc, ChronoContext context, SourceFile sf, MapEntityObj meo) {
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

        // get LNBTS
        lnbtss = result.stream()
                .filter(p -> p.className.equals("LNBTS"))
                .collect(Collectors.toList());

        logger.debug("lnbtss: " + lnbtss.size());

        lncells = result.stream()
                .filter(p -> p.className.equals("LNCEL"))
                .collect(Collectors.toList());

        logger.debug("lncells: " + lncells.size());

        lncellfddtddss = result.stream()
                .filter(p -> p.className.equals("LNCEL_FDD") || p.className.equals("LNCEL_TDD"))
                .collect(Collectors.toList());

        logger.debug("lncellfddtddss: " + lncellfddtddss.size());

        sitess = result.stream()
                .filter(p -> p.className.equals("SITE"))
                .collect(Collectors.toList());

        logger.debug("sitess: " + sitess.size());

        this.prepareLnBts(adb);
        addMeasurement(PS.ENODEB, this.getKey(), true);

        this.prepareLnCell(adb);
        addMeasurement(PS.CELL4G, this.getKey(), true);

        this.updateEnodeB(adb);
        this.clearUnusedData(adb);

        addMeasurement(PS.FINALIZE, this.getKey(), true);

        saveStatistics(adb);

        return true;
    }

    private void prepareLnBts(DSLContext db){

        logger.debug("prepareLnBts()");

        NokBasicTagParamsObj mml;
        CrmapfieldRecord mfr;

        nokenodeb = db.selectFrom(NOKENODEB)
                .where(NOKENODEB.NOKENODEB_DATE.eq(UInteger.valueOf(context.getEpochTime())))
                .and(NOKENODEB.DISTNAME.eq(sf.getKey()))
                .fetchAny();

        if(nokenodeb == null){

            nokenodeb = db.newRecord(NOKENODEB);
            nokenodeb.setNokenodebDate(UInteger.valueOf(context.getEpochTime()));
            nokenodeb.setDistname(sf.getKey());

            nokenodeb.setNokenodebCrcollectortaskfiles(ULong.valueOf(this.sf.getTaskFilesId()));
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

                    nokenodeb.set(DSL.field(mfr.getMapfieldFieldname()), replaceVal);
                }
            }
            else{

                String val = getKeyParamsValue(mfr, null, null);

                if(val != null){

                    nokenodeb.set(DSL.field(mfr.getMapfieldFieldname()), val);
                }
            }
        }

        // fix lat lon

        // fix lat/lon format
        if(nokenodeb.getLatitude() != null && nokenodeb.getLongitude() != null){

            double d = Double.parseDouble(nokenodeb.getLatitude());
            d = d/10000000;
            nokenodeb.setLatitude(String.valueOf(df.format(d)));

            d = Double.parseDouble(nokenodeb.getLongitude());
            d = d/10000000;
            nokenodeb.setLongitude(String.valueOf(df.format(d)));
        }

        nokenodeb.setNokenodebVendor(meo.mr.getMapentityVendor());

        // set relation to crnode
        CrnodeRecord node = pgc.getNode(meo.mr.getMapentityVendor(), nokenodeb.getEnbname(), meo.mr.getMapentityNodecategory());

        if(node != null){

            nokenodeb.setNokenodebNode(node.getNodeId());
            nokenodeb.setNokenodebRevenueclass(node.getNodeRevenueclass());
        }

        nokenodeb.setNokenodebNodestatus(pgc.getNodeStatus(nokenodeb.getEnbname()));

        if(nokenodeb.getEnodebfunctionname() == null){
            nokenodeb.setEnodebfunctionname(nokenodeb.getDistname());
        }

        // set total cell
        nokenodeb.setTotalcell(lncells.size());

        nokenodeb.setNokenodebCrcollectortaskfiles(ULong.valueOf(this.sf.getTaskFilesId()));

        int res = (nokenodeb.getNokenodebId() == null)?nokenodeb.store():nokenodeb.update();

        if(node != null){

            nodeCache.put(nokenodeb.getNokenodebId().longValue(), node);
        }

        logger.debug("prepareLnBts() done");
    }

    private void prepareLnCell(DSLContext db){

        logger.debug("prepareLnCell()");

        MapEntityObj me = meo.getChildEntityByTableName("noklcell");

        NokBasicTagParamsObj mml;
        CrmapfieldRecord mfr;

        String key = "distName";
        String key2 = "lcrId";

        String cellIdPattern = "^.*[/]LNCEL-(\\d+).*$";
        Pattern p = Pattern.compile(cellIdPattern);
        Matcher matcher;

//        NokBasicTagParamsObj supplement;

        for (int i = 0; i < lncells.size(); i++) {

            String distName = lncells.get(i).params.get(key);
            String lcrId = lncells.get(i).params.get(key2);

            matcher = p.matcher(distName);
            if(!matcher.find()){

                System.out.printf("not found..");
                continue;
            }

            String cellId = matcher.group(1).trim();

            System.out.println("cellId: " + cellId);

            ArrayList<String> filters = new ArrayList<>();
            filters.add(key);
            filters.add(distName);

            NoklcellRecord lcell = db.selectFrom(NOKLCELL)
                    .where(NOKLCELL.NOKLCELL_DATE.eq(UInteger.valueOf(context.getEpochTime())))
                    .and(NOKLCELL.NOKLCELL_NOKENODEB.eq(nokenodeb.getNokenodebId()))
                    .and(NOKLCELL.CELLID.eq(cellId).or(NOKLCELL.LCRID.eq(lcrId)))
                    .fetchAny();

            if(lcell == null){

                lcell = db.newRecord(NOKLCELL);

                lcell.setNoklcellDate(UInteger.valueOf(context.getEpochTime()));
                lcell.setNoklcellNokenodeb(nokenodeb.getNokenodebId());
                lcell.setCellid(cellId);
                lcell.setLcrid(lcrId);
            }

            if(lcell.getCellid() == null){
                lcell.setCellid(cellId);
            }

//            supplement = null;

//            for (int j = 0; supplement == null && j < lncellfddtddss.size(); j++) {
            for (int j = 0; j < lncellfddtddss.size(); j++) {

                if(lncellfddtddss.get(j).params.get(key).startsWith(distName + "/")){

//                    supplement = lncellfddtddss.get(j);

                    lncells.get(i).params.putAll(lncellfddtddss.get(j).params);
                    break;

//                    System.out.println("found: " + lncellfddtddss.get(i).params.get(key));
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

                        lcell.set(DSL.field(mfr.getMapfieldFieldname()), replaceVal);
                    }
                }
                else{

//                    String val = getKeyParamsValue(mfr, filters, null);

                    if(mfr.getMapfieldIskey() != 1){

                        String val = lncells.get(i).params.get(mfr.getMapfieldSourceparam());

                        if(val != null){

                            lcell.set(DSL.field(mfr.getMapfieldFieldname()), val);
                        }
                    }
//                    else{
//
//                        //additional from supplement
//                        if(supplement != null){
//
//                            lcell.set(DSL.field(mfr.getMapfieldFieldname()), getKeyParamsValue(mfr, null, supplement));
//                        }
//                    }
                }
            }

            // set enodebid, mcc, and mnc
            lcell.setEnodebid(nokenodeb.getEnodebid());
            if(lcell.getMnc() == null){

                lcell.setMnc(nokenodeb.getMnc());
            }
            if(lcell.getMcc() == null){

                lcell.setMcc(nokenodeb.getMcc());
            }

            // copy lat/lon from enodeb level
            if(nokenodeb.getLatitude() != null && nokenodeb.getLongitude() != null){

                lcell.setLatitude(nokenodeb.getLatitude());
                lcell.setLongitude(nokenodeb.getLongitude());
            }

            if(lcell.getEnodebid() != null && lcell.getCellid() != null){

                int eci = GsmNetworkUtils.getLteEci(lcell.getEnodebid(), lcell.getCellid());

                String ecgi = getECGI(lcell.getMcc(), lcell.getMnc(), String.valueOf(eci));

                if(ecgi != null){

                    String genodebid = lcell.getMcc() + "-" + lcell.getMnc() + "-" + lcell.getEnodebid();

                    long tai = GsmNetworkUtils.getLteTai(lcell.getMcc(), lcell.getMnc(), lcell.getTac());

                    lcell.setEci(String.valueOf(eci));
                    lcell.setEcgi(ecgi);
                    lcell.setGenodebid(genodebid);
                    lcell.setTai(String.valueOf(tai));

                    CrnodeRecord node = nodeCache.get(nokenodeb.getNokenodebId().longValue());

                    CrcellRecord cell = null;
                    Double earfcn = null;

                    if(lcell.get(DSL.field("earfcnDL")) != null){

                        try{
                            earfcn = Double.parseDouble(lcell.get(DSL.field("earfcnDL"), String.class));
                        }
                        catch(Exception e){}
                    }
                    else if(lcell.get(DSL.field("earfcn")) != null){
                        try{
                            earfcn = Double.parseDouble(lcell.get(DSL.field("earfcn"), String.class));
                        }
                        catch(Exception e){}
                    }

                    System.out.println("xxx: " + earfcn + "->" + ecgi);

                    if(earfcn != null){

                        System.out.println("lookup: " + earfcn + "->" + ecgi);

                        CrcellRecord cellProto = CellUtils.getCellProto(lcell, node);

                        cell = pgc.getCellByArfcn("LTE", earfcn, ecgi, cellProto, node);

                        System.out.println("result: " + (cell != null));
                    }

                    if(cell != null){

                        lcell.setNoklcellCell(cell.getCellId());
                        lcell.setNoklcellCellclass(cell.getCellCellclass());
                        lcell.setNoklcellCellcoverage(cell.getCellCellcoverage());
                        lcell.setNoklcellRevenueclass(cell.getCellRevenueclass());
                        lcell.setNoklcellLatitude(cell.getCellLatitude());
                        lcell.setNoklcellLongitude(cell.getCellLongitude());

//                        CrnodeRecord nodeAlias = pgc.getCellNodeAlias(lcell, lcell, cell.getCellCellclass(), earfcn, lcell.getName(), node);

                        String neName = (node != null)?node.getNodeCode(): null;
                        String cellName = lcell.getName() ==  null? "": lcell.getName();

                        System.out.println("check lcell: " + (lcell == null));
                        CrnodeRecord nodeAlias = pgc.getCellNodeAlias2(meo.mr.getMapentityVendor(), cell.getCellCellclass(), cellName, neName);

                        if(nodeAlias != null){
                            lcell.setNoklcellNodealias(nodeAlias.getNodeId());
                        }
                    }
                }
            }

            if(lcell.getName() == null){
                lcell.setName(lcell.getDistname());
            }
            if(lcell.getCellname() == null){
                lcell.setCellname(lcell.getDistname());
            }

            lcell.setNoklcellCellstatus(pgc.getCellStatus(lcell.getName()));
            lcell.setNoklcellVendor(meo.mr.getMapentityVendor());

            lcell.setNoklcellCrcollectortaskfiles(ULong.valueOf(this.sf.getTaskFilesId()));

            int res = (lcell.getNoklcellId() == null)?lcell.store():lcell.update();
        }

        logger.debug("prepareLnCell() done");
    }

    private void updateEnodeB(DSLContext db){

        logger.debug("updateEnodeB()");


        logger.debug("updateEnodeB() done");
    }

    private void clearUnusedData(DSLContext db){

        sf.purgeResult();
        lnbtss.clear();
        lncells.clear();
        lncellfddtddss.clear();
        this.result.clear();
    }
}

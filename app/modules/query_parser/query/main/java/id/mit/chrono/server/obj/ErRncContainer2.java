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

public class ErRncContainer2 extends ErBaseContainer implements FileProcessor {

    private List<ErrncRecord> rncs = new ArrayList<>();
    private List<ErnodebRecord> nodebs = new ArrayList<>();
    private List<ErucellRecord> ucells = new ArrayList<>();
    private HashMap<Long, CrnodeRecord> nodeCache = new HashMap();

    List<ErBasicTagParamsObj> meContextRncs;
    List<ErBasicTagParamsObj> IuBLinks;
    List<ErBasicTagParamsObj> utranCells;

    public ErRncContainer2(DSLContext db, ParserGroupCallback pgc, ChronoContext context, SourceFile sf, MapEntityObj meo) {
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

        meContextRncs = result.stream()
                .filter(p -> p.tag.equals("xn:MeContext") && "RNC".equals(p.params.get("xn:managedElementType")))
                .collect(Collectors.toList());

        logger.debug("vsDataRncFunctions.size(): " + meContextRncs.size());

        IuBLinks = result.stream()
                .filter(p -> p.tag.equals("un:IubLink"))
                .collect(Collectors.toList());

        logger.debug("vsDataIubLinks.size(): " + IuBLinks.size());

        utranCells = result.stream()
                .filter(p -> p.tag.equals("un:UtranCell") && p.params.containsKey("un:creationTime"))
                .collect(Collectors.toList());

        logger.debug("vsDataUtranCells.size(): " + utranCells.size());

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

        String key = "xn:MeContext";

        for (int i = 0; i < meContextRncs.size(); i++) {

            String userLabel = meContextRncs.get(i).params.get(key);

            ErrncRecord errnc = db.selectFrom(ERRNC)
                    .where(ERRNC.ERRNC_DATE.eq(UInteger.valueOf(context.getEpochTime())))
                    .and(ERRNC.RNCNAME.eq(userLabel))
                    .fetchOne();

            if(errnc == null){

                errnc = db.newRecord(ERRNC);

                errnc.setErrncDate(UInteger.valueOf(context.getEpochTime()));
                errnc.setRncname(userLabel);
            }

            ArrayList<String> filters = new ArrayList<>();
            filters.add(key);
            filters.add(userLabel);
            filters.add("xn:managedElementType");
            filters.add("RNC");

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


            errnc.setTotalcell(0);
            errnc.setTotalnodeb(0);


            CrnodeRecord node = pgc.getNode(meo.mr.getMapentityVendor(), errnc.getRncname(), meo.mr.getMapentityNodecategory());

            if(node != null){

                errnc.setErrncNode(node.getNodeId());
            }


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

        String key2 = "xn:SubNetwork";
        String key3 = "es:rbsId";


        ArrayList<String> processedRbsIds = new ArrayList<String>();

        for (int i = 0; i < IuBLinks.size(); i++) {

            String subNetwork = IuBLinks.get(i).params.get(key2);
            String rbsId = IuBLinks.get(i).params.get(key3);

            if(rbsId == null || processedRbsIds.contains(rbsId)){
                continue;
            }

            // search for RNC first using subNetwork

            Long erRncId = null;

            for (int j = 0; j < rncs.size(); j++) {

                if(rncs.get(j).getRncname().equals(subNetwork)){

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
                    .and(ERNODEB.RBSID.eq(rbsId))
                    .fetchOne();

            if(ernodeb == null){

                ernodeb = db.newRecord(ERNODEB);

                ernodeb.setErnodebDate(UInteger.valueOf(context.getEpochTime()));
                ernodeb.setErnodebErrnc(ULong.valueOf(erRncId));
                ernodeb.setRbsid(rbsId);
            }

            ArrayList<String> filters = new ArrayList<>();
            filters.add(key3);
            filters.add(rbsId);

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
                }
            }

            int totalCell = 0;

            ernodeb.setTotalcell(0);

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

        ErBasicTagParamsObj mml;
        CrmapfieldRecord mfr;

        String key = "un:UtranCell";
        String key2 = "xn:SubNetwork";
        String key3 = "un:utranCellIubLink";

        ArrayList<String> processedCells = new ArrayList<String>();

        for (int i = 0; i < utranCells.size(); i++) {

            String cellName = utranCells.get(i).params.get(key);
            String subNetwork = utranCells.get(i).params.get(key2);
            String iUbLink = utranCells.get(i).params.get(key3);

            if(cellName == null || processedCells.contains(cellName)){
                continue;
            }

            iUbLink = iUbLink.substring(iUbLink.lastIndexOf("=")+1);

//            System.out.println("iUbLink: " + iUbLink);

            // search for RNC first using subNetwork

            Long erRncId = null;
            String rncId = null;

            for (int j = 0; j < rncs.size(); j++) {

                if(rncs.get(j).getRncname().equals(subNetwork)){

                    erRncId = rncs.get(j).getErrncId().longValue();
                    rncId = rncs.get(j).getRncid();
                    break;
                }
            }

            // skip
            if(erRncId == null){
                continue;
            }

            ErucellRecord erucell = db.selectFrom(ERUCELL)
                    .where(ERUCELL.ERUCELL_DATE.eq(UInteger.valueOf(context.getEpochTime())))
                    .and(ERUCELL.ERUCELL_ERRNC.eq(ULong.valueOf(erRncId)))
                    .and(ERUCELL.CELLNAME.eq(cellName))
                    .fetchOne();

            if(erucell == null){

                erucell = db.newRecord(ERUCELL);

                erucell.setErucellDate(UInteger.valueOf(context.getEpochTime()));
                erucell.setErucellErrnc(ULong.valueOf(erRncId));
                erucell.setCellname(cellName);
            }

            ArrayList<String> filters = new ArrayList<>();
            filters.add(key);
            filters.add(cellName);
//            filters.add(key2);
//            filters.add(subNetwork);

            // connect to NodeB

            for (int j = 0; j < nodebs.size(); j++) {

                if(nodebs.get(j).getIubid().equals(iUbLink)){

                    erucell.setErucellErnodeb(nodebs.get(j).getErnodebId());
                    break;
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
                }
            }

            CrnodeRecord node = null;

            String cgi = erucell.getMcc() + "-" + erucell.getMnc() + "-" + erucell.getLac() + "-" + erucell.getCellid();

            erucell.setCgi(cgi);

            erucell.setRncid(rncId);

            CrcellRecord cellProto = CellUtils.getCellProto(erucell, node);

            // set relation to crcell
            CrcellRecord cell = pgc.getCellByArfcn("UMTS", Double.parseDouble(erucell.getUarfcndownlink()), cgi, cellProto,  node);

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

                CrnodeRecord nodeAlias = pgc.getCellNodeAlias(erucell, erucell, cell.getCellCellclass(), uarfcn, erucell.getCellname(), node);

                if(nodeAlias != null){
                    erucell.setErucellNodealias(nodeAlias.getNodeId());
                }
            }

            erucell.setErucellCellstatus(pgc.getNodeStatus(erucell.getCellname()));

            erucell.setErucellCrcollectortaskfiles(ULong.valueOf(this.sf.getTaskFilesId()));

            erucell.setErucellVendor(meo.mr.getMapentityVendor());

            int result = (erucell.getErucellId() == null)?erucell.store():erucell.update();

            ucells.add(erucell);

            processedCells.add(cellName);
        }

        logger.debug("prepareCell() done");
    }

    private void updateRnc(DSLContext db){

        logger.debug("updateRnc()");




        logger.debug("updateRnc() done");
    }

    private void clearUnusedData(DSLContext db){

        sf.purgeResult();
        this.result.clear();
    }
}

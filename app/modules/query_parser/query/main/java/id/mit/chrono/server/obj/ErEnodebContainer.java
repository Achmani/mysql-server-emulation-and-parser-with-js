package id.mit.chrono.server.obj;

import id.mit.chrono.server.base.BaseContainer;
import id.mit.chrono.server.base.ErBaseContainer;
import id.mit.chrono.server.base.HwBaseContainer;
import id.mit.chrono.server.enm.PS;
import id.mit.chrono.server.iface.FileProcessor;
import id.mit.chrono.server.iface.ParserGroupCallback;
import id.mit.chrono.server.model.tables.Crcell;
import id.mit.chrono.server.model.tables.Erenodeb;
import id.mit.chrono.server.model.tables.records.*;
import id.mit.chrono.server.util.CellUtils;
import id.mit.chrono.server.util.GsmNetworkUtils;
import org.jooq.DSLContext;
import org.jooq.impl.DSL;
import org.jooq.types.UInteger;
import org.jooq.types.ULong;
import org.slf4j.LoggerFactory;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import static id.mit.chrono.server.model.Tables.*;

public class ErEnodebContainer extends ErBaseContainer implements FileProcessor {

    private List<ErenodebRecord> enodebs = new ArrayList<>();
    private List<ErlcellRecord> lcells = new ArrayList<>();

    private HashMap<Long, CrnodeRecord> nodeCache = new HashMap();

    List<ErBasicTagParamsObj> vsDataENodeBFunctions;
    List<ErBasicTagParamsObj> vsDataEUtranCells;
    List<ErBasicTagParamsObj> userPlaneGbrAdmBandWidthDl;
    List<ErBasicTagParamsObj> getUserPlaneGbrAdmBandWidthUl;

    DecimalFormat df = new DecimalFormat("####.########");

    public ErEnodebContainer(DSLContext db, ParserGroupCallback pgc, ChronoContext context, SourceFile sf, MapEntityObj meo) {
        super(db, pgc, context, sf, meo);
        logger = LoggerFactory.getLogger(this.getClass() + ":" + sf.getTaskFilesId());
    }

    @Override
    public boolean process(DSLContext db, PS state) {
        return false;
    }

    @Override
    public boolean processAll(DSLContext adb) {

        resetStopwatch();

        this.prepareKeyParamsResult(adb);

        vsDataENodeBFunctions = result.stream()
                .filter(ErBasicTagParamsObj.class::isInstance)
                .map(ErBasicTagParamsObj.class::cast)
                .filter(p -> p.tag.equals("vsDataENodeBFunction"))
                .collect(Collectors.toList());

        logger.debug("vsDataENodeBFunctions.size(): " + vsDataENodeBFunctions.size());

        vsDataEUtranCells = result.stream()
                .filter(ErBasicTagParamsObj.class::isInstance)
                .map(ErBasicTagParamsObj.class::cast)
                .filter(p -> p.tag.matches("^vsDataEUtranCell(TDD|FDD)$") || p.tag.equals("vsDataNbIotCell"))
                .collect(Collectors.toList());

        logger.debug("vsDataEUtranCells.size(): " + vsDataEUtranCells.size());

        addMeasurement(PS.PREPARE, this.getKey(), true);

        this.prepareENodeB(adb);
        addMeasurement(PS.ENODEB, this.getKey(), true);

        this.prepareENodeBCell(adb);
        addMeasurement(PS.CELL4G, this.getKey(), true);

        this.clearUnusedData(adb);
        addMeasurement(PS.FINALIZE, this.getKey(), true);

        saveStatistics(adb);

        return true;
    }

    private void prepareENodeB(DSLContext db){

        logger.debug("prepareENodeB()");

        vsDataENodeBFunctions.parallelStream().forEach(objx -> prosesENodeB(db, meo, objx));

        logger.debug("prepareENodeB() done");
    }

    private void prosesENodeB(DSLContext db, MapEntityObj me, ErBasicTagParamsObj obj){

        ErBasicTagParamsObj mml;
        CrmapfieldRecord mfr;

        String key = "eNBId";
        String key2 = "SubNetwork_2_id";
        String key3 = "MeContext_id";
        String key4 = "SubNetwork_id";

        String eNBId = obj.params.get(key);
        String SubNetwork = obj.params.get(key2) != null ? obj.params.get(key2) : obj.params.get(key4);
        String MeContext = obj.params.get(key3);


//        System.out.println("MeContext: " + MeContext);

        ErenodebRecord erenodeb = db.selectFrom(ERENODEB)
                .where(ERENODEB.ERENODEB_DATE.eq(UInteger.valueOf(context.getEpochTime())))
                .and(ERENODEB.ENODEBID.eq(eNBId))
                .and(ERENODEB.ENODEBFUNCTIONNAME.eq(MeContext))
                .fetchAny();

        if(erenodeb == null){
            erenodeb = db.newRecord(ERENODEB);
            erenodeb.setErenodebDate(UInteger.valueOf(context.getEpochTime()));
            erenodeb.setEnodebid(eNBId);
            erenodeb.setErenodebCrcollectortaskfiles(ULong.valueOf(this.sf.getTaskFilesId()));
        }

        ArrayList<String> filters = new ArrayList<>();
        filters.add(obj.params.get(key2) != null ? key2 : key4);
        filters.add(SubNetwork);
        filters.add(key3);
        filters.add(MeContext);

        for (int l = 0; l < meo.mft.size(); l++) {

            mfr = meo.mft.get(l);

            // if need replace from chrono.context
            if(mfr.getMapfieldSourcegroup().equals("chrono.context")){

                String replaceVal = null;

                switch(mfr.getMapfieldSourceparam()){

                    case "DATE": replaceVal = String.valueOf(context.getEpochTime()); break;
                    default: break;
                }

                if(replaceVal != null){

                    erenodeb.set(DSL.field(mfr.getMapfieldFieldname()), replaceVal);
                }
            }
            else{

                String val = getKeyParamsValue(mfr, filters);

                if(val != null){

                    erenodeb.set(DSL.field(mfr.getMapfieldFieldname()), val);
                }

                if (mfr.getMapfieldFieldname().equals("SUBNETWORK") && val == null) {
                    if (obj.params.get(key4) != null) {
                        erenodeb.set(DSL.field(mfr.getMapfieldFieldname()), obj.params.get(key4));
                    }
                }
            }
        }

        // correlate to node
        CrnodeRecord node = pgc.getNode(meo.mr.getMapentityVendor(), erenodeb.getEnodebfunctionname(), meo.mr.getMapentityNodecategory());

        if(node != null){

            erenodeb.setErenodebNode(node.getNodeId());
            erenodeb.setErenodebRevenueclass(node.getNodeRevenueclass());
        }

        erenodeb.setErenodebNodestatus(pgc.getNodeStatus(erenodeb.getEnodebfunctionname()));

        // count of cell

        ErBasicTagParamsObj temp;
        int totalCell = 0;
        for (int i = 0; i < vsDataEUtranCells.size(); i++) {

            temp = vsDataEUtranCells.get(i);

            if((SubNetwork.equals(temp.params.get(key2)) || SubNetwork.equals(temp.params.get(key4))) && MeContext.equals(temp.params.get(key3))){
                totalCell++;
            }
        }
        erenodeb.setTotalcell(totalCell);

        erenodeb.setErenodebVendor(meo.mr.getMapentityVendor());

        erenodeb.setErenodebCrcollectortaskfiles(ULong.valueOf(this.sf.getTaskFilesId()));

        int res = (erenodeb.getErenodebId() == null)?erenodeb.store():erenodeb.update();

        synchronized (enodebs){

            enodebs.add(erenodeb);

            if(node != null){

                nodeCache.put(erenodeb.getErenodebId().longValue(), node);
            }
        }
    }

    private void prepareENodeBCell(DSLContext db){

        logger.debug("prepareENodeBCell()");

        // get field definition for hwgcell
        MapEntityObj me = meo.getChildEntityByTableName("erlcell");

        vsDataEUtranCells.stream().forEach(objx -> processENodeBCell(db, me, objx));

        logger.debug("prepareENodeBCell() done");
    }

    private void processENodeBCell(DSLContext db, MapEntityObj me, ErBasicTagParamsObj obj){

        HuaweiBasicKeyParamsObj cme;
        CrmapfieldRecord mfr;
        //es:tac
        //es:cellId
        //es:freqBand
        //es:physicalLayerCellIdGroup

        String key2 = "SubNetwork_2_id";
        String key3 = "MeContext_id";
        String key4 = "physicalLayerCellIdGroup";
        String key5 = "cellId";
        String key6 = "SubNetwork_id";

        String SubNetwork = obj.params.get(key2) != null ? obj.params.get(key2) : obj.params.get(key6);
        String MeContext = obj.params.get(key3);
        String Pci = obj.params.get(key4);
        String Cid = obj.params.get(key5);

//        System.out.println("MeContext: " + MeContext);
//        System.out.println("Pci: " + Pci);
//        System.out.println("Cid: " + Cid);

        ErenodebRecord enodeb = null;

        for (int i = 0; i < enodebs.size(); i++) {

            if(enodebs.get(i).getSubnetwork().equals(SubNetwork) && enodebs.get(i).getEnodebfunctionname().equals(MeContext)){

                enodeb = enodebs.get(i);
                break;
            }
        }

        if(enodeb == null){
            return;
        }

        ErlcellRecord lcell = db.selectFrom(ERLCELL)
                .where(ERLCELL.ERLCELL_DATE.eq(UInteger.valueOf(context.getEpochTime())))
                .and(ERLCELL.ERLCELL_ERENODEB.eq(enodeb.getErenodebId()))
                .and(ERLCELL.CELLID.eq(Cid))
                .fetchAny();

        if(lcell == null){

            lcell = db.newRecord(ERLCELL);

            lcell.setErlcellDate(UInteger.valueOf(context.getEpochTime()));
            lcell.setErlcellErenodeb(enodeb.getErenodebId());
            lcell.setCellid(Cid);
        }

        lcell.setEnodebid(enodeb.getEnodebid());

        for (int l = 0; l < me.mft.size(); l++) {

            mfr = me.mft.get(l);

            // if need replace from chrono.context
            if(mfr.getMapfieldSourcegroup().equals("chrono.context")){

                String replaceVal = null;

                switch(mfr.getMapfieldSourceparam()){

                    case "DATE": replaceVal = String.valueOf(context.getEpochTime()); break;
                    //case "PARENTENODEB": replaceVal = hwenodeb.getHwenodebId().toString(); break;
                    default: break;
                }

                if(replaceVal != null){

                    lcell.set(DSL.field(mfr.getMapfieldFieldname()), replaceVal);
                }
            }
            else{

                String val = obj.params.get(mfr.getMapfieldSourceparam());

                if(val != null && !val.isEmpty()){

                    lcell.set(DSL.field(mfr.getMapfieldFieldname()), val);
                }
            }
        }

        // clean the cell name
        if(lcell.getCellname() != null && lcell.getCellname().startsWith("EUtranCell=")){
            lcell.setCellname(lcell.getCellname().substring("EUtranCell=".length()));
        }

        // just in case
        if(lcell.getEnodebid() == null){

            lcell.setEnodebid(enodeb.getEnodebid());
        }

        if(lcell.getMcc() != null && lcell.getMcc().contains(";")){
            lcell.setMcc(lcell.getMcc().split(";")[0]);
        }

        if(lcell.getMnc() != null && lcell.getMnc().contains(";")){
            lcell.setMnc(lcell.getMnc().split(";")[0]);
        }

        if(lcell.getTac() != null && lcell.getTac().contains(";")){
            lcell.setTac(lcell.getTac().split(";")[0]);
        }

        if(lcell.getEnodebid() == null){
            lcell.setEnodebid(enodeb.getEnodebid());
        }

        if(lcell.getMcc() == null || lcell.getMnc() == null){

            lcell.setMcc(enodeb.getMcc());
            lcell.setMnc(enodeb.getMnc());
        }

        int eci = GsmNetworkUtils.getLteEci(lcell.getEnodebid(), lcell.getCellid());

        String ecgi = getECGI(lcell.getMcc(), lcell.getMnc(), String.valueOf(eci));

        if(ecgi != null){

            lcell.setEcgi(ecgi);

            lcell.setEci(String.valueOf(eci));

            String genodebid = lcell.getMcc() + "-" + lcell.getMnc() + "-" + enodeb.getEnodebid();
            lcell.setGenodebid(genodebid);

//            try{

                long tai = GsmNetworkUtils.getLteTai(lcell.getMcc(), lcell.getMnc(), lcell.getTac());
                lcell.setTai(String.valueOf(tai));
//            }catch(Exception e){
//
//                System.out.println("error: " + this.sf.getTaskFilesId() + " " + lcell.getMcc() + " " + lcell.getMnc() + " " + lcell.getTac());
//            }
        }

        // fix lat/lon format
        try{
            double d;

            String lat = lcell.get(DSL.field("ANTLATITUDE"), String.class);
            d = Double.parseDouble(lat);
            d = (d * 90) / 8388608;
            lcell.setLatitude(String.valueOf(df.format(d)));

            String lon = lcell.get(DSL.field("ANTLONGITUDE"), String.class);
            d = Double.parseDouble(lon);
            d = (d * 360) / 16777216;
            lcell.setLongitude(String.valueOf(df.format(d)));

        }catch(Exception e){}

        // prepare mandatory data to map to cell class
        Double earfcn = null;

        if(lcell.getDlearfcn() != null && !lcell.getDlearfcn().isEmpty()){

            try{
                earfcn = Double.parseDouble(lcell.getDlearfcn());
            }catch(Exception e){}
        }

        if(lcell.getEarfcn() != null && !lcell.getEarfcn().isEmpty()){

            try{
                earfcn = Double.parseDouble(lcell.getEarfcn());
            }catch(Exception e){}
        }

        if(earfcn != null && lcell.getEcgi() != null){

            CrnodeRecord node = nodeCache.get(enodeb.getErenodebId());

            CrcellRecord cellProto = CellUtils.getCellProto(lcell, node);

            CrcellRecord cell = pgc.getCellByArfcn("LTE", earfcn, lcell.getEcgi(), cellProto, node);

            if(cell != null){
                lcell.setErlcellCell(cell.getCellId());
                lcell.setErlcellCellclass(cell.getCellCellclass());
                lcell.setErlcellCellcoverage(cell.getCellCellcoverage());
                lcell.setErlcellRevenueclass(cell.getCellRevenueclass());
                lcell.setErlcellLatitude(cell.getCellLatitude());
                lcell.setErlcellLongitude(cell.getCellLongitude());

//                CrnodeRecord nodeAlias = pgc.getCellNodeAlias(cell, cell, cell.getCellCellclass(), earfcn, lcell.getCellname(), node);

                String fixedCellName = lcell.getCellname();

                try{

//                    System.out.println("fixedCellName: " + fixedCellName);
//                    String test = fixedCellName.substring(fixedCellName.length()-1);
//                    int x = Integer.parseInt(test);
//                    fixedCellName = fixedCellName.substring(0, fixedCellName.length()-1);
//
//                    System.out.println("fixedCellName 2: " + fixedCellName);
                }
                catch(Exception e){

                }

                CrnodeRecord nodeAlias = pgc.getCellNodeAlias2(meo.mr.getMapentityVendor(), cell.getCellCellclass(), fixedCellName, enodeb.getEnodebfunctionname());

                if(nodeAlias != null){
                    lcell.setErlcellNodealias(nodeAlias.getNodeId());
                }
            }
        }

        lcell.setErlcellVendor(meo.mr.getMapentityVendor());
        lcell.setErlcellCellstatus(pgc.getCellStatus(lcell.getCellname()));
        lcell.setErlcellCrcollectortaskfiles(ULong.valueOf(this.sf.getTaskFilesId()));

        int res = (lcell.getErlcellId() == null)?lcell.store():lcell.update();

        synchronized (lcells){

//            System.out.println(">> " + lcell.getCellname());

            lcells.add(lcell);
        }
    }
    private void clearUnusedData(DSLContext db){

        this.sf.purgeResult();
        this.enodebs.clear();
        this.lcells.clear();

        this.nodeCache.clear();

        this.vsDataENodeBFunctions.clear();
        this.vsDataEUtranCells.clear();

        this.result.clear();
    }
}

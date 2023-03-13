package id.mit.chrono.server.obj;

import id.mit.chrono.server.base.ErBaseContainer;
import id.mit.chrono.server.enm.PS;
import id.mit.chrono.server.iface.FileProcessor;
import id.mit.chrono.server.iface.ParserGroupCallback;
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

import static id.mit.chrono.server.model.Tables.ERGNODEB;
import static id.mit.chrono.server.model.Tables.ERNCELL;

public class ErGnodebContainer extends ErBaseContainer implements FileProcessor {

    private List<ErgnodebRecord> gnodebs = new ArrayList<>();
    private List<ErncellRecord> ncells = new ArrayList<>();

    private HashMap<Long, CrnodeRecord> nodeCache = new HashMap<>();

    List<ErBasicTagParamsObj> vsDataGNBCUCPFunctions;
    List<ErBasicTagParamsObj> vsDataNRCells;

    DecimalFormat df = new DecimalFormat("####.########");

    public ErGnodebContainer(DSLContext db, ParserGroupCallback pgc, ChronoContext context, SourceFile sf, MapEntityObj meo) {
        super(db, pgc, context, sf, meo);
        logger = LoggerFactory.getLogger(this.getClass() + ":" + sf.getTaskFilesId());
    }

    @Override
    public boolean process(DSLContext db, PS state) {
        return false;
    }

    @Override
    public boolean processAll(DSLContext db) {

        resetStopwatch();

        this.prepareKeyParamsResult(db);

        vsDataGNBCUCPFunctions = result.stream()
                .filter(ErBasicTagParamsObj.class::isInstance)
                .map(ErBasicTagParamsObj.class::cast)
                .filter(p -> p.tag.equals("vsDataGNBCUCPFunction"))
                .collect(Collectors.toList());

        logger.debug("vsDataGNBCUCPFunction.size(): " + vsDataGNBCUCPFunctions.size());

        vsDataNRCells = result.stream()
                .filter(ErBasicTagParamsObj.class::isInstance)
                .map(ErBasicTagParamsObj.class::cast)
                .filter(p -> p.tag.matches("^vsDataNRCell(CU|DU)$"))
                .collect(Collectors.toList());

        logger.debug("vsDataNRCells.size(): " + vsDataNRCells.size());

        addMeasurement(PS.PREPARE, this.getKey(), true);

        this.prepareGNodeB(db);
        addMeasurement(PS.GNODEB, this.getKey(), true);

        this.prepareGNodeBCell(db);
        addMeasurement(PS.CELL5G, this.getKey(), true);

        this.clearUnusedData(db);
        addMeasurement(PS.FINALIZE, this.getKey(), true);

        saveStatistics(db);

        return true;
    }

    private void prepareGNodeB(DSLContext db) {

        logger.debug("prepareGNodeB()");

        vsDataGNBCUCPFunctions.parallelStream().forEach(objx -> processGNodeB(db, meo, objx));

        logger.debug("prepareGNodeB() done");

    }

    private void processGNodeB(DSLContext db, MapEntityObj me, ErBasicTagParamsObj obj) {

        ErBasicTagParamsObj mml;
        CrmapfieldRecord mfr;

        String key = "gNBId";
        String key2 = "SubNetwork_id";
        String key3 = "MeContext_id";

        String gNBId = obj.params.get(key);
        String SubNetwork = obj.params.get(key2);
        String MeContext = obj.params.get(key3);

        System.out.println("gNBId: " + gNBId + ", SubNetwork: " + SubNetwork + ", MeContext: " + MeContext);

        if (gNBId == null || SubNetwork == null || MeContext == null) {
            return;
        }

        ErgnodebRecord ergnodeb = db.selectFrom(ERGNODEB)
                .where(ERGNODEB.ERGNODEB_DATE.eq(UInteger.valueOf(context.getEpochTime())))
                .and(ERGNODEB.GNODEBID.eq(gNBId))
                .and(ERGNODEB.GNODEBFUNCTIONNAME.eq(MeContext))
                .fetchAny();

        if (ergnodeb == null) {

            ergnodeb = db.newRecord(ERGNODEB);
            ergnodeb.setErgnodebDate(UInteger.valueOf(context.getEpochTime()));
            ergnodeb.setGnodebid(gNBId);
            ergnodeb.setErgnodebCrcollectortaskfiles(ULong.valueOf(this.sf.getTaskFilesId()));
        }

        ArrayList<String> filters = new ArrayList<>();
        filters.add(key2);
        filters.add(SubNetwork);
        filters.add(key3);
        filters.add(MeContext);

        for (int l = 0; l < meo.mft.size(); l++) {
            mfr = meo.mft.get(l);

            if (mfr.getMapfieldSourcegroup().equals("chrono.context")) {

                String replaceVal = null;

                switch (mfr.getMapfieldSourceparam()) {
                    case "DATE": replaceVal = String.valueOf(context.getEpochTime()); break;
                    default: break;
                }

                if (replaceVal != null) {

                    ergnodeb.set(DSL.field(mfr.getMapfieldFieldname()), replaceVal);

                }
            } else {

                String val = getKeyParamsValue(mfr, filters);

                if (val != null) {

                    ergnodeb.set(DSL.field(mfr.getMapfieldFieldname()), val);
                }
            }
        }

        CrnodeRecord node = pgc.getNode(meo.mr.getMapentityVendor(), ergnodeb.getGnodebfunctionname(), meo.mr.getMapentityNodecategory());

        if (node != null) {

            ergnodeb.setErgnodebNode(node.getNodeId());
            ergnodeb.setErgnodebRevenueclass(node.getNodeRevenueclass());
        }

        ergnodeb.setErgnodebNodestatus(pgc.getNodeStatus(ergnodeb.getGnodebfunctionname()));

        ErBasicTagParamsObj temp;
        int totalCell = 0;
        for (int i = 0; i < vsDataNRCells.size(); i++) {

            temp = vsDataNRCells.get(i);

            if (SubNetwork.equals(temp.params.get(key2)) && MeContext.equals(temp.params.get(key3))) {
                totalCell++;
            }
        }

        ergnodeb.setTotalcell(totalCell);

        ergnodeb.setErgnodebVendor(meo.mr.getMapentityVendor());

        ergnodeb.setErgnodebCrcollectortaskfiles(ULong.valueOf(this.sf.getTaskFilesId()));

        int res = (ergnodeb.getErgnodebId() == null) ? ergnodeb.store() : ergnodeb.update();

        synchronized (gnodebs) {
            gnodebs.add(ergnodeb);

            if (node != null) {
                nodeCache.put(ergnodeb.getErgnodebId().longValue(), node);
            }
        }

    }

    private void prepareGNodeBCell(DSLContext db) {

        logger.debug("prepareGNodeBCell()");

        MapEntityObj me = meo.getChildEntityByTableName("erncell");

        vsDataNRCells.stream().forEach(objx -> processGNodeBCell(db, me, objx));

        logger.debug("prepareGNodeBCell() done");
    }

    private void processGNodeBCell(DSLContext db, MapEntityObj me, ErBasicTagParamsObj obj) {

        CrmapfieldRecord mfr;

        String key2 = "SubNetwork_id";
        String key3 = "MeContext_id";
        String key4 = "cellLocalId";

        String SubNetwork = obj.params.get(key2);
        String MeContext = obj.params.get(key3);
        String Cid = obj.params.get(key4);

        ErgnodebRecord gnodeb = null;

        for (int i = 0; i < gnodebs.size(); i++) {

            if (gnodebs.get(i).getSubnetwork().equals(SubNetwork) && gnodebs.get(i).getGnodebfunctionname().equals(MeContext)) {

                gnodeb = gnodebs.get(i);
                break;
            }
        }

        if (gnodeb == null) {
            return;
        }

        ErncellRecord ncell = db.selectFrom(ERNCELL)
                .where(ERNCELL.ERNCELL_DATE.eq(UInteger.valueOf(context.getEpochTime())))
                .and(ERNCELL.ERNCELL_ERGNODEB.eq(gnodeb.getErgnodebId()))
                .and(ERNCELL.CELLID.eq(Cid))
                .fetchAny();

        if (ncell == null) {

            ncell = db.newRecord(ERNCELL);

            ncell.setErncellDate(UInteger.valueOf(context.getEpochTime()));
            ncell.setErncellErgnodeb(gnodeb.getErgnodebId());
            ncell.setCellid(Cid);
        }

        ncell.setGnodebid(gnodeb.getGnodebid());

        ArrayList<String> filters = new ArrayList<>();

        for (int l = 0; l < me.mft.size(); l++) {

            mfr = me.mft.get(l);

            if (mfr.getMapfieldSourcegroup().equals("chrono.context")) {

                String replaceVal = null;

                switch (mfr.getMapfieldSourceparam()) {

                    case "DATE": replaceVal = String.valueOf(context.getEpochTime()); break;
                    default: break;
                }

                if (replaceVal != null) {

                    ncell.set(DSL.field(mfr.getMapfieldFieldname()), replaceVal);
                }
            }
            else {

                String val = obj.params.get(mfr.getMapfieldSourceparam());

//                if(val == null){
//                    val = getKeyParamsValue(mfr, filters);
//                }

                if (val != null && !val.isEmpty()) {

                    ncell.set(DSL.field(mfr.getMapfieldFieldname()), val);
                }
            }
        }

        if (ncell.getGgnodebid() == null) {
            ncell.setGnodebid(gnodeb.getGnodebid());
        }

        if (ncell.getMcc() != null && ncell.getMcc().contains(";")) {
            ncell.setMcc(ncell.getMcc().split(";")[0]);
        }

        if(ncell.getMnc() != null && ncell.getMnc().contains(";")){
            ncell.setMnc(ncell.getMnc().split(";")[0]);
        }

        if(ncell.getTac() != null && ncell.getTac().contains(";")){
            ncell.setTac(ncell.getTac().split(";")[0]);
        }

        if(ncell.getGnodebid() == null){
            ncell.setGnodebid(gnodeb.getGnodebid());
        }

        if(ncell.getMcc() == null || ncell.getMnc() == null){

            ncell.setMcc(gnodeb.getMcc());
            ncell.setMnc(gnodeb.getMnc());
        }

        int eci = GsmNetworkUtils.getNrNci(ncell.getGnodebid(), ncell.getCellid());

        String ncgi = getECGI(ncell.getMcc(), ncell.getMnc(), String.valueOf(eci));

        if (ncgi != null) {

            ncell.setNcgi(ncgi);

            ncell.setEci(String.valueOf(eci));

            String ggnodebid = ncell.getMcc() + "-" + ncell.getMnc() + "-" + gnodeb.getGnodebid();
            ncell.setGgnodebid(ggnodebid);

            // TODO: Add Tai
        }

        try {
            double d;

            String lat = ncell.get(DSL.field("ANTLATITUDE"), String.class);
            d = Double.parseDouble(lat);
            d = (d * 90) / 8388608;
            ncell.setLatitude(String.valueOf(df.format(d)));

            String lon = ncell.get(DSL.field("ANTLONGITUDE"), String.class);
            d = Double.parseDouble(lon);
            d = (d * 360) / 16777216;
            ncell.setLongitude(String.valueOf(df.format(d)));

        } catch (Exception e) {

        }

        Double narfcn = null;

        if (ncell.getDlnarfcn() != null && !ncell.getDlnarfcn().isEmpty()) {

            try {
                narfcn = Double.parseDouble(ncell.getDlnarfcn());
            } catch (Exception e) {

            }
        }

        if (narfcn != null && ncell.getNcgi() != null) {

            CrnodeRecord node = nodeCache.get(gnodeb.getErgnodebId());

            CrcellRecord cellProto = CellUtils.getCellProto(ncell, node);

            CrcellRecord cell = pgc.getCellByArfcn("NR", narfcn, ncell.getNcgi(), cellProto, node);

            if (cell != null) {
                ncell.setErncellCell(cell.getCellId());
                ncell.setErncellCellclass(cell.getCellCellclass());
                ncell.setErncellCellcoverage(cell.getCellCellcoverage());
                ncell.setErncellRevenueclass(cell.getCellRevenueclass());
                ncell.setErncellLatitude(cell.getCellLatitude());
                ncell.setErncellLongitude(cell.getCellLongitude());

                String fixedCellName = ncell.getCellname();

                CrnodeRecord nodeAlias = pgc.getCellNodeAlias2(meo.mr.getMapentityVendor(), cell.getCellCellclass(), fixedCellName, gnodeb.getGnodebfunctionname());

                if (nodeAlias != null) {
                    ncell.setErncellNodealias(nodeAlias.getNodeId());
                }
            }
        }

        ncell.setErncellVendor(meo.mr.getMapentityVendor());
        ncell.setErncellCellstatus(pgc.getCellStatus(ncell.getCellname()));
        ncell.setErncellCrcollectortaskfiles(ULong.valueOf(this.sf.getTaskFilesId()));

        int res = (ncell.getErncellId() == null) ? ncell.store() : ncell.update();

        synchronized (ncells) {
            ncells.add(ncell);
        }

    }

    private void clearUnusedData(DSLContext db) {

        this.sf.purgeResult();
        this.gnodebs.clear();
        this.ncells.clear();

        this.nodeCache.clear();

        this.vsDataGNBCUCPFunctions.clear();
        this.vsDataNRCells.clear();

        this.result.clear();

    }
}

package id.mit.chrono.server.loader;

import id.mit.chrono.server.base.BaseLoader;
import id.mit.chrono.server.database.DatabaseHelper;
import id.mit.chrono.server.factory.DaoFactory;
import id.mit.chrono.server.model.tables.records.*;
import id.mit.chrono.server.obj.DrillCl;
import id.mit.chrono.server.util.CellUtils;
import id.mit.chrono.server.util.DrillUtils;
import org.jooq.impl.DSL;
import org.jooq.types.UInteger;
import org.jooq.types.ULong;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import static id.mit.chrono.server.model.Tables.*;

public class ZteRncLoader extends BaseLoader {

    private ArrayList<ZterncRecord> zterncs = new ArrayList<>();
    private ArrayList<ZtenodebRecord> ztenodebs = new ArrayList<>();
    private ArrayList<ZteucellRecord> zteucells = new ArrayList<>();

    private HashMap<Long, CrnodeRecord> nodeCache = new HashMap();

    @Override
    protected void load(HashMap<String, String> queryResult) {

        // process zternc
        CrquerysetRecord rncQueryset = DaoFactory.getQuerysetDaoImpl().getSingleQuerysetByTableTarget("zternc");
        processRnc(queryResult.get("zternc"), rncQueryset);

        // process ztenodeb
        CrquerysetRecord nodeQueryset = DaoFactory.getQuerysetDaoImpl().getSingleQuerysetByTableTarget("ztenodeb");
        processNodeB(queryResult.get("ztenodeb"), nodeQueryset);

        // process zteucell
        CrquerysetRecord cellQueryset = DaoFactory.getQuerysetDaoImpl().getSingleQuerysetByTableTarget("zteucell");
        processUcell(queryResult.get("zteucell"), cellQueryset);

    }

    private void processRnc(String query, CrquerysetRecord queryset) {

        logger.debug("processing RNC...");

        DrillCl client = DrillUtils.getInstance(DatabaseHelper.connectDB());

        int totalInsert = 0;
        int totalUpdate = 0;

        try {
            ResultSet rs = client.execQuery(query);
            ResultSetMetaData meta = rs.getMetaData();

            int totalRow = 0;

            while (rs.next()) {

                String MOI = null;
                String SubNetwork = null;
                String MEID = null;
                String URncFunction = null;

                if (rs.getString("MOI") != null) {
                    MOI = rs.getString("MOI");
                }

                if (rs.getString("SubNetwork") != null) {
                    SubNetwork = rs.getString("SubNetwork");
                }

                if (rs.getString("MEID") != null) {
                    MEID = rs.getString("MEID");
                }

                if (rs.getString("URncFunction") != null) {
                    URncFunction = rs.getString("URncFunction");
                }

                ZterncRecord zternc = db.selectFrom(ZTERNC)
                        .where(ZTERNC.ZTERNC_DATE.eq(UInteger.valueOf(context.getEpochTime())))
                        .and(ZTERNC.SUBNETWORK.eq(SubNetwork))
                        .and(ZTERNC.MEID.eq(MEID))
                        .limit(1)
                        .fetchAny();

                if (zternc == null) {
                    zternc = db.newRecord(ZTERNC);

                    zternc.setZterncDate(UInteger.valueOf(context.getEpochTime()));
                    zternc.setSubnetwork(SubNetwork);
                    zternc.setMeid(MEID);
                }

                List<String> targetColumns = new ArrayList<>();

                for (int i = 0; i < ZTERNC.fields().length; i++) {
                    String column = ZTERNC.fields()[i].toString().split("\\.")[2].replace("\"", "");
                    targetColumns.add(column);
                }

                zternc.set(ZTERNC.ZTERNC_CRCOLLECTORTASKFILES, ULong.valueOf(resultGroup.getTaskFileId()));
                zternc.set(ZTERNC.ZTERNC_DATE, UInteger.valueOf(context.getEpochTime()));

                for (int j = 1; j <= meta.getColumnCount(); j++) {

                    if (targetColumns.contains(meta.getColumnName(j))) {
                        zternc.set(DSL.field(meta.getColumnName(j)), rs.getString(meta.getColumnName(j)));
//                        System.out.println("got " + meta.getColumnName(j) + " -> " + rs.getString(meta.getColumnName(j)));
                    }
                }
//                System.out.println("\n");

                CrnodeRecord node = pgc.getNode(resultGroup.getVendor(), zternc.getRncname(), queryset.getQuerysetNodecategory());

                if (node != null) {
                    zternc.setZterncNode(node.getNodeId());
                }

                zternc.setZterncVendor(queryset.getQuerysetVendor());
                zternc.setZterncCrcollectortaskfiles(ULong.valueOf(resultGroup.getTaskFileId()));

                if (zternc.getZterncId() == null) {
                    zternc.store();
                    totalInsert++;
                } else {
                    zternc.update();
                    totalUpdate++;
                }

                zterncs.add(zternc);
                totalRow ++;
            }

            System.out.println("fetched total " + totalRow + " row.");
            System.out.println("total inserted: " + totalInsert + ", total update: " + totalUpdate + ".");
            logger.debug("processRnc() done.");

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    private void processNodeB(String query, CrquerysetRecord queryset) {

        logger.debug("processing NodeB...");

        DrillCl client = DrillUtils.getInstance(DatabaseHelper.connectDB());

        int totalInsert = 0;
        int totalUpdate = 0;

        try {
            ResultSet rs = client.execQuery(query);
            ResultSetMetaData meta = rs.getMetaData();

            int totalRow = 0;

            while (rs.next()) {

                String MOI = null;
                String SubNetwork = null;
                String MEID = null;
                String URncFunction = null;
                String UIubLink = null;

                if (rs.getString("MOI") != null) {
                    MOI = rs.getString("MOI");
                }

                if (rs.getString("SubNetwork") != null) {
                    SubNetwork = rs.getString("SubNetwork");
                }

                if (rs.getString("MEID") != null) {
                    MEID = rs.getString("MEID");
                }

                if (rs.getString("URncFunction") != null) {
                    URncFunction = rs.getString("URncFunction");
                }

                if (rs.getString("UIubLink") != null) {
                    UIubLink = rs.getString("UIubLink");
                }

                if (URncFunction == null) {
                    return;
                }

                if (UIubLink == null) {
                    return;
                }


                ZterncRecord rnc = this.getRnc(SubNetwork, MEID);

                if (rnc == null) {
                    return;
                }

                ZtenodebRecord ztenodeb = db.selectFrom(ZTENODEB)
                        .where(ZTENODEB.ZTENODEB_DATE.eq(UInteger.valueOf(context.getEpochTime())))
                        .and(ZTENODEB.ZTENODEB_ZTERNC.eq(rnc.getZterncId()))
                        .and(ZTENODEB.URNCFUNCTION.eq(URncFunction))
                        .and(ZTENODEB.UIUBLINK.eq(UIubLink))
                        .limit(1)
                        .fetchOne();

                if (ztenodeb == null) {

                    ztenodeb = db.newRecord(ZTENODEB);

                    ztenodeb.setZtenodebDate(UInteger.valueOf(context.getEpochTime()));
                    ztenodeb.setZtenodebZternc(rnc.getZterncId());
                    ztenodeb.setUiublink(UIubLink);
                }

                List<String> targetColumns = new ArrayList<>();

                for (int i = 0; i < ZTENODEB.fields().length; i++) {
                    String column = ZTENODEB.fields()[i].toString().split("\\.")[2].replace("\"", "");
                    targetColumns.add(column);
                }

                ztenodeb.set(ZTENODEB.ZTENODEB_CRCOLLECTORTASKFILES, ULong.valueOf(resultGroup.getTaskFileId()));
                ztenodeb.set(ZTENODEB.ZTENODEB_DATE, UInteger.valueOf(context.getEpochTime()));
                ztenodeb.set(ZTENODEB.ZTENODEB_VENDOR, queryset.getQuerysetVendor());

                for (int j = 1; j <= meta.getColumnCount(); j++) {

                    if (targetColumns.contains(meta.getColumnName(j))) {
                        ztenodeb.set(DSL.field(meta.getColumnName(j)), rs.getString(meta.getColumnName(j)));
//                        System.out.println("got " + meta.getColumnName(j) + " -> " + rs.getString(meta.getColumnName(j)));
                    }
                }
//                System.out.println("\n");

                CrnodeRecord node = pgc.getNode(resultGroup.getVendor(), ztenodeb.getNodebname(), queryset.getQuerysetNodecategory());

                if (node != null) {
                    ztenodeb.setZtenodebNode(node.getNodeId());
                    ztenodeb.setZtenodebRevenueclass(node.getNodeRevenueclass());
                }

                if (ztenodeb.getZtenodebId() == null) {
                    ztenodeb.store();
                    totalInsert++;
                } else {
                    ztenodeb.update();
                    totalUpdate++;
                }

                if (node != null) {
                    synchronized (nodeCache) {
                        nodeCache.put(ztenodeb.getZtenodebId().longValue(), node);
                    }
                }

                synchronized (ztenodebs) {
                    ztenodebs.add(ztenodeb);
                }

                totalRow++;
            }

            System.out.println("fetched total " + totalRow + " row.");
            System.out.println("total inserted: " + totalInsert + ", total update: " + totalUpdate + ".");
            logger.debug("processNodeB() done.");

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    private void processUcell(String query, CrquerysetRecord queryset) {

        logger.debug("processing UCell...");

        DrillCl client = DrillUtils.getInstance(DatabaseHelper.connectDB());

        int totalInsert = 0;
        int totalUpdate = 0;

        try {
            ResultSet rs = client.execQuery(query);
            ResultSetMetaData meta = rs.getMetaData();

            int totalRow = 0;

            while (rs.next()) {

                String MOI = null;
                String SubNetwork = null;
                String MEID = null;
                String URncFunction = null;
                String UUtranCellFDD = null;

                if (rs.getString("MOI") != null) {
                    MOI = rs.getString("MOI");
                }

                if (rs.getString("SubNetwork") != null) {
                    SubNetwork = rs.getString("SubNetwork");
                }

                if (rs.getString("MEID") != null) {
                    MEID = rs.getString("MEID");
                }

                if (rs.getString("URncFunction") != null) {
                    URncFunction = rs.getString("URncFunction");
                }

                if (rs.getString("UUtranCellFDD") != null) {
                    UUtranCellFDD = rs.getString("UUtranCellFDD");
                }

                if (URncFunction == null) {
                    return;
                }


                ZterncRecord rnc = this.getRnc(SubNetwork, MEID);

                if (rnc == null) {
                    return;
                }

                if (UUtranCellFDD == null) {
                    return;
                }

                ZteucellRecord zteucell = db.selectFrom(ZTEUCELL)
                        .where(ZTEUCELL.ZTEUCELL_DATE.eq(UInteger.valueOf(context.getEpochTime())))
                        .and(ZTEUCELL.ZTEUCELL_ZTERNC.eq(rnc.getZterncId()))
                        .and(ZTEUCELL.UUTRANCELLFDD.eq(UUtranCellFDD))
                        .limit(1)
                        .fetchOne();

                if (zteucell == null) {

                    zteucell = db.newRecord(ZTEUCELL);

                    zteucell.setZteucellDate(UInteger.valueOf(context.getEpochTime()));
                    zteucell.setZteucellZternc(rnc.getZterncId());
                    zteucell.setUutrancellfdd(UUtranCellFDD);
                }

                List<String> targetColumns = new ArrayList<>();

                for (int i = 0; i < ZTEUCELL.fields().length; i++) {
                    String column = ZTEUCELL.fields()[i].toString().split("\\.")[2].replace("\"", "");
                    targetColumns.add(column);
                }

                zteucell.set(ZTEUCELL.ZTEUCELL_CRCOLLECTORTASKFILES, ULong.valueOf(resultGroup.getTaskFileId()));
                zteucell.set(ZTEUCELL.ZTEUCELL_DATE, UInteger.valueOf(context.getEpochTime()));
                zteucell.set(ZTEUCELL.ZTEUCELL_VENDOR, queryset.getQuerysetVendor());

                for (int j = 1; j <= meta.getColumnCount(); j++) {

                    if (targetColumns.contains(meta.getColumnName(j))) {
                        zteucell.set(DSL.field(meta.getColumnName(j)), rs.getString(meta.getColumnName(j)));
//                        System.out.println("got " + meta.getColumnName(j) + " -> " + rs.getString(meta.getColumnName(j)));
                    }
                }
//                System.out.println("\n");

                final String refUIubLink = zteucell.getRefuiublink();
                Optional<ZtenodebRecord> testNodeb = ztenodebs.stream().filter(o -> o.getMoi() != null && o.getMoi().equals(refUIubLink)).findFirst();

                ZtenodebRecord nodeb = testNodeb.isPresent() ? testNodeb.get() : null;

                if (nodeb != null) {
                    zteucell.setZteucellZtenodeb(nodeb.getZtenodebId());
                }

                String cgi = getCGI(zteucell.getMcc(), zteucell.getMnc(), zteucell.getLac(), zteucell.getCid());

                if (cgi != null) {
                    zteucell.setCgi(cgi);

                    String freqBandLookup = "";

                    if (zteucell.getFreqbandind().equals("0")) {
                        freqBandLookup = "UMTS_Band1";
                    } else if (zteucell.getFreqbandind().equals("7")) {
                        freqBandLookup = "UMTS_Band8";
                    }

                    if (nodeb != null) {

                        CrnodeRecord node = nodeCache.get(nodeb.getZtenodebId().longValue());

                        CrcellRecord cellProto = CellUtils.getCellProto(zteucell, node);

                        CrcellRecord cell = pgc.getCell(freqBandLookup, cgi, cellProto, node);

                        if (cell != null) {

                            zteucell.setZteucellCell(cell.getCellId());
                            zteucell.setZteucellCellclass(cell.getCellCellclass());
                            zteucell.setZteucellCellcoverage(cell.getCellCellcoverage());
                            zteucell.setZteucellRevenueclass(cell.getCellRevenueclass());
                            zteucell.setZteucellLatitude(cell.getCellLatitude());
                            zteucell.setZteucellLongitude(cell.getCellLongitude());

                            Double uarfcn = null;

                            if(zteucell.getUarfcndl() != null && !zteucell.getUarfcndl().isEmpty()){
                                try{

                                    uarfcn = Double.parseDouble(zteucell.getUarfcndl());
                                }catch(Exception e){}
                            }

                            String neName = (node != null)?node.getNodeCode(): null;

                            CrnodeRecord nodeAlias = pgc.getCellNodeAlias2(queryset.getQuerysetVendor(), cell.getCellCellclass(), zteucell.getUserlabel(), neName);

                            if(nodeAlias != null){
                                zteucell.setZteucellNodealias(nodeAlias.getNodeId());
                            }
                        }
                    }
                }

                zteucell.setZteucellCellstatus(pgc.getCellStatus(zteucell.getUserlabel()));

                // adjust latitude based on latitudeSign

                String sign = zteucell.get(DSL.field("latitudeSign"), String.class);

                if(sign != null && sign.equals("1")){

                    double latitude = Double.parseDouble(zteucell.get(DSL.field("latitude"), String.class));
                    latitude *= -1;
                    zteucell.setLatitude(latitude);
                }

                if (zteucell.getZteucellId() == null) {
                    zteucell.store();
                    totalInsert++;
                } else {
                    zteucell.update();
                    totalUpdate++;
                }

                synchronized (zteucells) {
                    zteucells.add(zteucell);
                }

                totalRow ++;
            }

            System.out.println("fetched total " + totalRow + " row.");
            System.out.println("total inserted: " + totalInsert + ", total update: " + totalUpdate + ".");
            logger.debug("processUCell() done.");

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    private ZterncRecord getRnc(String SubNetwork, String MEID){

        ZterncRecord zternc;

        for (int i = 0; i < zterncs.size(); i++) {

            zternc = zterncs.get(i);

            if(zternc.getSubnetwork().equals(SubNetwork) && zternc.getMeid().equals(MEID)){

                return zterncs.get(i);
            }
        }

        return null;
    }

    private ZterncRecord getRnc2(String MOI){

        ZterncRecord zternc;

        for (int i = 0; i < zterncs.size(); i++) {

            zternc = zterncs.get(i);

            if(MOI.startsWith(zternc.getMoi() + ",")){

                return zterncs.get(i);
            }
        }

        return null;
    }

//    private ZtenodebRecord getNodeB(String SubNetwork, String MEID, String UIubLink) {
//
//    }

//    private ZtebscRecord getBsc(String SubNetwork, String MEID, String GBssFunction){
//
//        for (int i = 0; i < ztebscs.size(); i++) {
//
//            if(ztebscs.get(i).getSubnetwork().equals(SubNetwork) && ztebscs.get(i).getMeid().equals(MEID) && ztebscs.get(i).getGbssfunction().equals(GBssFunction)){
//
//                return ztebscs.get(i);
//            }
//        }
//
//        return null;
//    }
//
//    private ZtebscRecord getBsc2(String SubNetwork){
//
//        for (int i = 0; i < ztebscs.size(); i++) {
//
//            if(ztebscs.get(i).getSubnetwork().equals(SubNetwork)){
//
//                return ztebscs.get(i);
//            }
//        }
//
//        return null;
//    }
//
//    private ZtebscRecord getBsc3(String SubNetwork, String MEID, String userLabel){
//
//        for (int i = 0; i < ztebscs.size(); i++) {
//
//            if(ztebscs.get(i).getSubnetwork().equals(SubNetwork) && ztebscs.get(i).getMeid().equals(MEID) && ztebscs.get(i).getUserlabel().equals(userLabel)){
//
//                return ztebscs.get(i);
//            }
//        }
//
//        return null;
//    }
//
//    private ZtebtsRecord getBts(String SubNetwork, String MEID, String GBssFunction, String GBtsSiteManager){
//
//        for (int i = 0; i < ztebtss.size(); i++) {
//
//            if(ztebtss.get(i).getSubnetwork().equals(SubNetwork) && ztebtss.get(i).getMeid().equals(MEID) && ztebtss.get(i).getGbssfunction().equals(GBssFunction) && ztebtss.get(i).getGbtssitemanager().equals(GBtsSiteManager)){
//
//                return ztebtss.get(i);
//            }
//        }
//
//        return null;
//    }
//
//    private ZtebtsRecord getBts2(String MOID){
//
//        for (int i = 0; i < ztebtss.size(); i++) {
//
//            if(MOID.startsWith(ztebtss.get(i).getMoi() + ",")){
//
//                return ztebtss.get(i);
//            }
//        }
//
//        return null;
//    }
//
//    private ZtebtsRecord getBts3(String SubNetwork, String MEID, String userLabel){
//
//        for (int i = 0; i < ztebtss.size(); i++) {
//
//            if(ztebtss.get(i).getSubnetwork().equals(SubNetwork) && ztebtss.get(i).getMeid().equals(MEID) && ztebtss.get(i).getUserlabel().equals(userLabel)){
//
//                return ztebtss.get(i);
//            }
//        }
//
//        return null;
//    }
//
//    private ZtegcellRecord getGcell(String SubNetwork, String MEID, String GBssFunction, String GBtsSiteManager, String GGsmCell){
//
//        for (int i = 0; i < ztegcells.size(); i++) {
//
//            if(ztegcells.get(i).getSubnetwork().equals(SubNetwork) && ztegcells.get(i).getMeid().equals(MEID) && ztegcells.get(i).getGbssfunction().equals(GBssFunction) && ztegcells.get(i).getGbtssitemanager().equals(GBtsSiteManager) && ztegcells.get(i).getGgsmcell().equals(GGsmCell)){
//
//                return ztegcells.get(i);
//            }
//        }
//
//        return null;
//    }
//
//    private ZtegtrxRecord getGtrx(String SubNetwork, String MEID, String GBssFunction, String GBtsSiteManager, String GGsmCell, String GTrx) {
//
//        for (int i = 0; i < ztegtrxs.size(); i++) {
//
//            if (ztegtrxs.get(i).getSubnetwork().equals(SubNetwork) && ztegtrxs.get(i).getMeid().equals(MEID) && ztegtrxs.get(i).getGbssfunction().equals(GBssFunction) && ztegtrxs.get(i).getGbtssitemanager().equals(GBtsSiteManager) && ztegtrxs.get(i).getGgsmcell().equals(GGsmCell) && ztegtrxs.get(i).getGtrx().equals(GTrx)) {
//
//                return ztegtrxs.get(i);
//            }
//        }
//
//        return null;
//    }
}

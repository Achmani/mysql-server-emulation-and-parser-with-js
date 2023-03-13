package id.mit.chrono.server.loader;

import id.mit.chrono.server.base.BaseLoader;
import id.mit.chrono.server.database.DatabaseHelper;
import id.mit.chrono.server.factory.DaoFactory;
import id.mit.chrono.server.model.tables.Crqueryset;
import id.mit.chrono.server.model.tables.Ztebsclocarea;
import id.mit.chrono.server.model.tables.Ztegts;
import id.mit.chrono.server.model.tables.records.*;
import id.mit.chrono.server.obj.DrillCl;
import id.mit.chrono.server.util.CellUtils;
import id.mit.chrono.server.util.DrillUtils;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.jooq.Field;
import org.jooq.Record;
import org.jooq.Result;
import org.jooq.ResultQuery;
import org.jooq.impl.DSL;
import org.jooq.types.UInteger;
import org.jooq.types.ULong;

import java.io.StringWriter;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static id.mit.chrono.server.model.Tables.*;

public class ZteBscLoader extends BaseLoader {

    private ArrayList<ZtebscRecord> ztebscs = new ArrayList<>();
    private ArrayList<ZtebtsRecord> ztebtss = new ArrayList<>();
    private ArrayList<ZtegcellRecord> ztegcells = new ArrayList<>();
    private ArrayList<ZtegtrxRecord> ztegtrxs = new ArrayList<>();
    private ArrayList<ZtegtrxRecord> ztegtss = new ArrayList<>();

    private HashMap<Long, CrnodeRecord> nodeCache = new HashMap();

    @Override
    protected void load(HashMap<String, String> queryResult) {

        // process ztebsc
        CrquerysetRecord bscQueryset = DaoFactory.getQuerysetDaoImpl().getSingleQuerysetByTableTarget("ztebsc");
        processBsc(queryResult.get("ztebsc"), bscQueryset);

        // process ztebts
        CrquerysetRecord btsQueryset = DaoFactory.getQuerysetDaoImpl().getSingleQuerysetByTableTarget("ztebts");
        processBts(queryResult.get("ztebts"), btsQueryset);

        // process ztegcell
        CrquerysetRecord cellQueryset = DaoFactory.getQuerysetDaoImpl().getSingleQuerysetByTableTarget("ztegcell");
        processGcell(queryResult.get("ztegcell"), cellQueryset);

        // process ztegcell_ext1
//        CrquerysetRecord cellExtQueryset = DaoFactory.getQuerysetDaoImpl().getSingleQuerysetByTableTarget("ztegcell_ext1");
//        processGcellExt1(queryResult.get("ztegcell_ext1"), cellExtQueryset);

        // process ztegtrx
        CrquerysetRecord trxQueryset = DaoFactory.getQuerysetDaoImpl().getSingleQuerysetByEntity("ztegtrx");
        processGTrx(queryResult.get("ztegtrx"), trxQueryset);

        // process ztegts
        CrquerysetRecord tsQueryset = DaoFactory.getQuerysetDaoImpl().getSingleQuerysetByEntity("ztegts");
        processGTs(queryResult.get("ztegts"), tsQueryset);

    }

    private void processBsc(String query, CrquerysetRecord queryset) {

        logger.debug("processing BSC...");

        DrillCl client = DrillUtils.getInstance(DatabaseHelper.connectDB());

        int totalInsert = 0;
        int totalUpdate = 0;

        try {
            ResultSet rs = client.execQuery(query);
            ResultSetMetaData meta = rs.getMetaData();

            int totalRow = 0;

            while (rs.next()) {

                String GBssFunction = null;
                String SubNetwork = null;
                String MEID = null;

                if (rs.getString("GBssFunction") != null) {
                    GBssFunction = rs.getString("GBssFunction");
                }

                if (rs.getString("SubNetwork") != null) {
                    SubNetwork = rs.getString("SubNetwork");
                }

                if (rs.getString("MEID") != null) {
                    MEID = rs.getString("MEID");
                }

                ZtebscRecord ztebsc = db.selectFrom(ZTEBSC)
                        .where(ZTEBSC.ZTEBSC_DATE.eq(UInteger.valueOf(context.getEpochTime())))
                        .and(ZTEBSC.SUBNETWORK.eq(SubNetwork))
                        .and(ZTEBSC.MEID.eq(MEID))
                        .fetchOne();

                if (ztebsc == null) {

                    ztebsc = db.newRecord(ZTEBSC);

                    ztebsc.setZtebscDate(UInteger.valueOf(context.getEpochTime()));
                    ztebsc.setSubnetwork(SubNetwork);
                    ztebsc.setMeid(MEID);
                }

                List<String> targetColumns = new ArrayList<>();

                for (int i = 0; i < ZTEBSC.fields().length; i++) {
                    String column = ZTEBSC.fields()[i].toString().split("\\.")[2].replace("\"", "");
                    targetColumns.add(column);
                }

                ztebsc.set(ZTEBSC.ZTEBSC_CRCOLLECTORTASKFILES, ULong.valueOf(resultGroup.getTaskFileId()));
                ztebsc.set(ZTEBSC.ZTEBSC_DATE, UInteger.valueOf(context.getEpochTime()));

                for (int j = 1; j <= meta.getColumnCount(); j++) {

                    if (targetColumns.contains(meta.getColumnName(j))) {
                        ztebsc.set(DSL.field(meta.getColumnName(j)), rs.getString(meta.getColumnName(j)));
//                        System.out.println("got " + meta.getColumnName(j) + " -> " + rs.getString(meta.getColumnName(j)));
                    }
                }

                CrnodeRecord node = pgc.getNode(resultGroup.getVendor(), ztebsc.getBscname(), queryset.getQuerysetNodecategory());

                if (node != null) {

                    ztebsc.setZtebscNode(node.getNodeId());
                }

                ztebsc.setZtebscVendor(queryset.getQuerysetVendor());
                ztebsc.setZtebscCrcollectortaskfiles(ULong.valueOf(resultGroup.getTaskFileId()));

//                int result = (ztebsc.getZtebscId() == null) ? ztebsc.store() : ztebsc.update();
                if (ztebsc.getZtebscId() == null) {
                    ztebsc.store();
                    totalInsert++;
                } else {
                    ztebsc.update();
                    totalUpdate++;
                }
                ztebscs.add(ztebsc);

                totalRow ++;

            }

            System.out.println("fetched total " + totalRow + " row.");
            System.out.println("total inserted: " + totalInsert + ", total update: " + totalUpdate + ".");
            logger.debug("processBsc() done.");

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    private void processBts(String query, CrquerysetRecord queryset) {

        logger.debug("processing BTS...");

        DrillCl client = DrillUtils.getInstance(DatabaseHelper.connectDB());

        int totalInsert = 0;
        int totalUpdate = 0;

        try {

            ResultSet rs = client.execQuery(query);
            ResultSetMetaData meta = rs.getMetaData();

            int totalRow = 0;

            while (rs.next()) {

                String GBssFunction = null;
                String SubNetwork = null;
                String MEID = null;
                String GBtsSiteManager = null;

                if (rs.getString("GBssFunction") != null) {
                    GBssFunction = rs.getString("GBssFunction");
                }

                if (rs.getString("SubNetwork") != null) {
                    SubNetwork = rs.getString("SubNetwork");
                }

                if (rs.getString("MEID") != null) {
                    MEID = rs.getString("MEID");
                }

                if (rs.getString("GBtsSiteManager") != null) {
                    GBtsSiteManager = rs.getString("GBtsSiteManager");
                }


                ZtebscRecord bsc = this.getBsc(SubNetwork, MEID, GBssFunction);

                if (bsc == null) {
                    return;
                }

                ZtebtsRecord ztebts = db.selectFrom(ZTEBTS)
                        .where(ZTEBTS.ZTEBTS_DATE.eq(UInteger.valueOf(context.getEpochTime())))
                        .and(ZTEBTS.ZTEBTS_ZTEBSC.eq(bsc.getZtebscId()))
                        .and(ZTEBTS.GBTSSITEMANAGER.eq(GBtsSiteManager))
                        .fetchAny();

                if (ztebts == null) {

                    ztebts = db.newRecord(ZTEBTS);

                    ztebts.setZtebtsDate(UInteger.valueOf(context.getEpochTime()));
                    ztebts.setZtebtsZtebsc(bsc.getZtebscId());
                    ztebts.setGbtssitemanager(GBtsSiteManager);
                }

                List<String> targetColumns = new ArrayList<>();

                for (int i = 0; i < ZTEBTS.fields().length; i++) {
                    String column = ZTEBTS.fields()[i].toString().split("\\.")[2].replace("\"", "");
                    targetColumns.add(column);
                }

                ztebts.set(ZTEBTS.ZTEBTS_CRCOLLECTORTASKFILES, ULong.valueOf(resultGroup.getTaskFileId()));
                ztebts.set(ZTEBTS.ZTEBTS_DATE, UInteger.valueOf(context.getEpochTime()));

                for (int i = 1; i <= meta.getColumnCount(); i++) {

                    if (targetColumns.contains(meta.getColumnName(i))) {
                        ztebts.set(DSL.field(meta.getColumnName(i)), rs.getString(meta.getColumnName(i)));
//                        System.out.println("got " + meta.getColumnName(i) + " -> " + rs.getString(meta.getColumnName(i)));
                    }
                }

                ztebts.setZtebtsVendor(queryset.getQuerysetVendor());

                CrnodeRecord node = pgc.getNode(resultGroup.getVendor(), ztebts.getUserlabel(), queryset.getQuerysetNodecategory());

                if (node != null) {

                    ztebts.setZtebtsNode(node.getNodeId());
                    ztebts.setZtebtsRevenueclass(node.getNodeRevenueclass());
                }

                ztebts.setZtebtsNodestatus(pgc.getNodeStatus(ztebts.getUserlabel()));

                ztebts.setZtebtsZtebsc(bsc.getZtebscId());

                ztebts.setZtebtsCrcollectortaskfiles(ULong.valueOf(resultGroup.getTaskFileId()));

                if (ztebts.getZtebtsId() == null) {
                    ztebts.store();
                    totalInsert++;

                } else {
                    ztebts.update();
                    totalUpdate++;
                }

                if (node != null) {

                    nodeCache.put(ztebts.getZtebtsId().longValue(), node);
                }

                synchronized (ztebtss) {
                    ztebtss.add(ztebts);
                }

                totalRow ++;
            }

            System.out.println("fetched total " + totalRow + " row.");
            System.out.println("total inserted: " + totalInsert + ", total update: " + totalUpdate + ".");
            logger.debug("processBts() done.");

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    private void processGcell(String query, CrquerysetRecord queryset) {

        logger.debug("processing GCELL...");

        DrillCl client = DrillUtils.getInstance(DatabaseHelper.connectDB());

        int totalInsert = 0;
        int totalUpdate = 0;

        try {

            ResultSet rs = client.execQuery(query);
            ResultSetMetaData meta = rs.getMetaData();

            int totalRow = 0;

            while (rs.next()) {

                String GBssFunction = null;
                String SubNetwork = null;
                String MEID = null;
                String GBtsSiteManager = null;
                String GGsmCell = null;

                if (rs.getString("GBssFunction") != null) {
                    GBssFunction = rs.getString("GBssFunction");
                }

                if (rs.getString("SubNetwork") != null) {
                    SubNetwork = rs.getString("SubNetwork");
                }

                if (rs.getString("MEID") != null) {
                    MEID = rs.getString("MEID");
                }

                if (rs.getString("GBtsSiteManager") != null) {
                    GBtsSiteManager = rs.getString("GBtsSiteManager");
                }

                if (rs.getString("GGsmCell") != null) {
                    GGsmCell = rs.getString("GGsmCell");
                }

                ZtebscRecord bsc = this.getBsc(SubNetwork, MEID, GBssFunction);
                ZtebtsRecord bts = this.getBts(SubNetwork, MEID, GBssFunction, GBtsSiteManager);

                if (bsc == null || bts == null) {
                    return;
                }

                ZtegcellRecord ztegcell = db.selectFrom(ZTEGCELL)
                        .where(ZTEGCELL.ZTEGCELL_DATE.eq(UInteger.valueOf(context.getEpochTime())))
                        .and(ZTEGCELL.ZTEGCELL_ZTEBSC.eq(bsc.getZtebscId()))
                        .and(ZTEGCELL.ZTEGCELL_ZTEBTS.eq(bts.getZtebtsId()))
                        .and(ZTEGCELL.GGSMCELL.eq(GGsmCell))
                        .fetchAny();

                if (ztegcell == null) {
                    ztegcell = db.newRecord(ZTEGCELL);

                    ztegcell.setZtegcellDate(UInteger.valueOf(context.getEpochTime()));
                    ztegcell.set(ZTEGCELL.ZTEGCELL_CRCOLLECTORTASKFILES, ULong.valueOf(resultGroup.getTaskFileId()));
                    ztegcell.setZtegcellZtebsc(bsc.getZtebscId());
                    ztegcell.setZtegcellZtebts(bts.getZtebtsId());
                    ztegcell.setGgsmcell(GGsmCell);
                }

                List<String> targetColumns = new ArrayList<>();

                for (int i = 0; i < ZTEGCELL.fields().length; i++) {
                    String column = ZTEGCELL.fields()[i].toString().split("\\.")[2].replace("\"", "");
                    targetColumns.add(column);
                }

                for (int i = 1; i <= meta.getColumnCount(); i++) {

                    if (targetColumns.contains(meta.getColumnName(i))) {
                        ztegcell.set(DSL.field(meta.getColumnName(i)), rs.getString(meta.getColumnName(i)));
                    }
                }

                String cellLat = ztegcell.get(DSL.field("Latitude"), String.class);
                String cellLong = ztegcell.get(DSL.field("Longitude"), String.class);

                if (cellLat != null && cellLong != null) {

                    double latitude = Double.parseDouble(cellLat);
                    double longitude = Double.parseDouble(cellLong);

                    ztegcell.setLatitude(latitude);
                    ztegcell.setLongitude(longitude);
                }

                String cgi = getCGI(ztegcell.getMcc(), ztegcell.getMnc(), ztegcell.getLac(), ztegcell.getCellidentity());

                if (cgi != null) {

                    ztegcell.setCgi(cgi);

                    String freqBandLookup = "";

                    if(ztegcell.getFreqband().equals("0")){
                        freqBandLookup = "GSM900";
                    }else if(ztegcell.getFreqband().equals("1")){
                        freqBandLookup = "GSM900";
                    }else if(ztegcell.getFreqband().equals("2")){
                        freqBandLookup = "DCS1800";
                    }

                    CrnodeRecord node = nodeCache.get(bts.getZtebtsId().longValue());

                    CrcellRecord cellProto = CellUtils.getCellProto(ztegcell, node);
                    // set relation to crcell
                    CrcellRecord cell = pgc.getCell(freqBandLookup, cgi, cellProto, node);

                    if (cell != null) {

                        ztegcell.setZtegcellCell(cell.getCellId());
                        ztegcell.setZtegcellCellclass(cell.getCellCellclass());
                        ztegcell.setZtegcellCellcoverage(cell.getCellCellcoverage());
                        ztegcell.setZtegcellRevenueclass(cell.getCellRevenueclass());
                        ztegcell.setZtegcellLatitude(cell.getCellLatitude());
                        ztegcell.setZtegcellLongitude(cell.getCellLongitude());

                        String neName = (node != null) ? node.getNodeCode() : null;

                        CrnodeRecord nodeAlias = pgc.getCellNodeAlias2(queryset.getQuerysetVendor(), cell.getCellCellclass(), ztegcell.getUserlabel(), neName);

                        if (nodeAlias != null) {
                            ztegcell.setZtegcellNodealias(nodeAlias.getNodeId());
                        }
                    }
                }

                ztegcell.setZtegcellCellstatus(pgc.getCellStatus(ztegcell.getUserlabel()));
                ztegcell.setZtegcellVendor(queryset.getQuerysetVendor());
                ztegcell.setZtegcellCrcollectortaskfiles(ULong.valueOf(resultGroup.getTaskFileId()));

                if (ztegcell.getZtegcellId() == null) {
                    ztegcell.store();
                    totalInsert++;
                } else {
                    ztegcell.update();
                    totalUpdate++;
                }

                synchronized (ztegcells) {
                    ztegcells.add(ztegcell);
                }

                totalRow++;

            }

            System.out.println("fetched total " + totalRow + " row.");
            System.out.println("total inserted: " + totalInsert + ", total update: " + totalUpdate + ".");
            logger.debug("processGcell() done.");

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

//    private void processGcellExt1(String query, CrquerysetRecord queryset) {
//
//        logger.debug("processing GCELL EXT...");
//
//        DrillCl client = DrillUtils.getInstance(DatabaseHelper.connectDB());
//
//        int totalInsert = 0;
//        int totalUpdate = 0;
//
//        try {
//
//            ResultSet rs = client.execQuery(query);
//            ResultSetMetaData meta = rs.getMetaData();
//
//            int totalRow = 0;
//
//            while (rs.next()) {
//
//                String GBssFunction = null;
//                String SubNetwork = null;
//                String MEID = null;
//                String GBtsSiteManager = null;
//                String GGsmCell = null;
//
//                if (rs.getString("GBssFunction") != null) {
//                    GBssFunction = rs.getString("GBssFunction");
//                }
//
//                if (rs.getString("SubNetwork") != null) {
//                    SubNetwork = rs.getString("SubNetwork");
//                }
//
//                if (rs.getString("MEID") != null) {
//                    MEID = rs.getString("MEID");
//                }
//
//                if (rs.getString("GBtsSiteManager") != null) {
//                    GBtsSiteManager = rs.getString("GBtsSiteManager");
//                }
//
//                if (rs.getString("GGsmCell") != null) {
//                    GGsmCell = rs.getString("GGsmCell");
//                }
//
//                ZtegcellRecord cell = this.getGcell(SubNetwork, MEID, GBssFunction, GBtsSiteManager, GGsmCell);
//
//                if (cell == null) {
//                    return;
//                }
//
//                ZtegcellExt1Record ztegcell_ext1 = db.selectFrom(ZTEGCELL_EXT1)
//                        .where(ZTEGCELL_EXT1.ZTEGCELL_DATE.eq(UInteger.valueOf(context.getEpochTime())))
//                        .and(ZTEGCELL_EXT1.ZTEGCELL_ZTEGCELL.eq(cell.getZtegcellId()))
//                        .fetchAny();
//
//                if (ztegcell_ext1 == null) {
//
//                    ztegcell_ext1 = db.newRecord(ZTEGCELL_EXT1);
//
//                    ztegcell_ext1.setZtegcellDate(UInteger.valueOf(context.getEpochTime()));
//                    ztegcell_ext1.setZtegcellZtegcell(cell.getZtegcellId());
//                }
//
//                List<String> targetColumns = new ArrayList<>();
//
//                for (int i = 0; i < ZTEGCELL_EXT1.fields().length; i++) {
//                    String column = ZTEGCELL_EXT1.fields()[i].toString().split("\\.")[2].replace("\"", "");
//                    targetColumns.add(column);
//                }
//
//                for (int i = 1; i < meta.getColumnCount(); i++) {
//                    ztegcell_ext1.set(DSL.field(meta.getColumnName(i)), rs.getString(meta.getColumnName(i)));
//                    System.out.println("got " + meta.getColumnName(i) + " -> " + rs.getString(meta.getColumnName(i)));
//                }
//
//                if (ztegcell_ext1.getZtegcellId() == null) {
//                    ztegcell_ext1.store();
//                    totalInsert++;
//                } else {
//                    ztegcell_ext1.update();
//                    totalUpdate++;
//                }
//
//                totalRow++;
//
//            }
//
//            System.out.println("fetched total " + totalRow + " row.");
//            System.out.println("total inserted: " + totalInsert + ", total update: " + totalUpdate + ".");
//            logger.debug("processGcellExt1() done.");
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//    }

    private void processGTrx(String query, CrquerysetRecord queryset) {

        logger.debug("processing GTrx...");

        DrillCl client = DrillUtils.getInstance(DatabaseHelper.connectDB());

        int totalInsert = 0;
        int totalUpdate = 0;

        try {

            ResultSet rs = client.execQuery(query);
            ResultSetMetaData meta = rs.getMetaData();

            int totalRow = 0;

            while (rs.next()) {

                String GBssFunction = null;
                String SubNetwork = null;
                String MEID = null;
                String GBtsSiteManager = null;
                String GGsmCell = null;
                String GTrx = null;

                if (rs.getString("GBssFunction") != null) {
                    GBssFunction = rs.getString("GBssFunction");
                }

                if (rs.getString("SubNetwork") != null) {
                    SubNetwork = rs.getString("SubNetwork");
                }

                if (rs.getString("MEID") != null) {
                    MEID = rs.getString("MEID");
                }

                if (rs.getString("GBtsSiteManager") != null) {
                    GBtsSiteManager = rs.getString("GBtsSiteManager");
                }

                if (rs.getString("GGsmCell") != null) {
                    GGsmCell = rs.getString("GGsmCell");
                }

                if (rs.getString("GTrx") != null) {
                    GTrx = rs.getString("GTrx");
                }

                ZtebscRecord bsc = this.getBsc(SubNetwork, MEID, GBssFunction);
                ZtebtsRecord bts = this.getBts(SubNetwork, MEID, GBssFunction, GBtsSiteManager);
                ZtegcellRecord gcell = this.getGcell(SubNetwork, MEID, GBssFunction, GBtsSiteManager, GGsmCell);

                if (bsc == null) {
                    return;
                }

                if (bts == null) {
                    return;
                }

                if (gcell == null) {
                    return;
                }

                ZtegtrxRecord ztegtrx = db.selectFrom(ZTEGTRX)
                        .where(ZTEGTRX.ZTEGTRX_DATE.eq(UInteger.valueOf(context.getEpochTime())))
                        .and(ZTEGTRX.ZTEGTRX_ZTEBSC.eq(bsc.getZtebscId()))
                        .and(ZTEGTRX.ZTEGTRX_ZTEBTS.eq(bts.getZtebtsId()))
                        .and(ZTEGTRX.ZTEGTRX_ZTEGCELL.eq(gcell.getZtegcellId()))
                        .and(ZTEGTRX.GTRX.eq(GTrx))
                        .fetchAny();

                if (ztegtrx == null) {

                    ztegtrx = db.newRecord(ZTEGTRX);

                    ztegtrx.setZtegtrxDate(UInteger.valueOf(context.getEpochTime()));
                    ztegtrx.setZtegtrxZtebsc(bsc.getZtebscId());
                    ztegtrx.setZtegtrxZtebts(bts.getZtebtsId());
                    ztegtrx.setZtegtrxZtegcell(gcell.getZtegcellId());
                    ztegtrx.setGtrx(GTrx);
                }

                List<String> targetColumns = new ArrayList<>();

                for (int i = 0; i < ZTEGTRX.fields().length; i++) {
                    String column = ZTEGTRX.fields()[i].toString().split("\\.")[2].replace("\"", "");
                    targetColumns.add(column);
                }

                ztegtrx.set(ZTEGTRX.ZTEGTRX_CRCOLLECTORTASKFILES, ULong.valueOf(resultGroup.getTaskFileId()));
                ztegtrx.set(ZTEGTRX.ZTEGTRX_DATE, UInteger.valueOf(context.getEpochTime()));

                for (int i = 1; i <= meta.getColumnCount(); i++) {
                    if (targetColumns.contains(meta.getColumnName(i))) {
                        ztegtrx.set(DSL.field(meta.getColumnName(i)), rs.getString(meta.getColumnName(i)));
                        System.out.println("got " + meta.getColumnName(i) + " -> " + rs.getString(meta.getColumnName(i)));
                    }
                }

                if (ztegtrx.getZtegtrxId() == null) {
                    ztegtrx.store();
                    totalInsert++;
                } else {
                    ztegtrx.update();
                    totalUpdate++;
                }

                synchronized (ztegtrxs) {
                    ztegtrxs.add(ztegtrx);
                }

                totalRow++;
            }

            System.out.println("fetched total " + totalRow + " row.");
            System.out.println("total inserted: " + totalInsert + ", total update: " + totalUpdate + ".");
            logger.debug("processGTrx() done.");

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    private void processGTs(String query, CrquerysetRecord queryset) {

        logger.debug("processing GTS...");

        DrillCl client = DrillUtils.getInstance(DatabaseHelper.connectDB());

        int totalInsert = 0;
        int totalUpdate = 0;

        try {

            ResultSet rs = client.execQuery(query);
            ResultSetMetaData meta = rs.getMetaData();

            int totalRow = 0;

            while (rs.next()) {

                String GBssFunction = null;
                String SubNetwork = null;
                String MEID = null;
                String GBtsSiteManager = null;
                String GGsmCell = null;
                String GTrx = null;
                String GTs = null;

                if (rs.getString("GBssFunction") != null) {
                    GBssFunction = rs.getString("GBssFunction");
                }

                if (rs.getString("SubNetwork") != null) {
                    SubNetwork = rs.getString("SubNetwork");
                }

                if (rs.getString("MEID") != null) {
                    MEID = rs.getString("MEID");
                }

                if (rs.getString("GBtsSiteManager") != null) {
                    GBtsSiteManager = rs.getString("GBtsSiteManager");
                }

                if (rs.getString("GGsmCell") != null) {
                    GGsmCell = rs.getString("GGsmCell");
                }

                if (rs.getString("GTrx") != null) {
                    GTrx = rs.getString("GTrx");
                }

                if (rs.getString("GTs") != null) {
                    GTs = rs.getString("GTs");
                }

                ZtebscRecord bsc = this.getBsc(SubNetwork, MEID, GBssFunction);
                ZtebtsRecord bts = this.getBts(SubNetwork, MEID, GBssFunction, GBtsSiteManager);
                ZtegcellRecord gcell = this.getGcell(SubNetwork, MEID, GBssFunction, GBtsSiteManager, GGsmCell);
                ZtegtrxRecord trx = this.getGtrx(SubNetwork, MEID, GBssFunction, GBtsSiteManager, GGsmCell, GTrx);

                if (bsc == null) {
                    return;
                }

                if (bts == null) {
                    return;
                }

                if (gcell == null) {
                    return;
                }

                if (trx == null) {
                    return;
                }

                ZtegtsRecord ztegts = db.selectFrom(ZTEGTS)
                        .where(ZTEGTS.ZTEGTS_DATE.eq(UInteger.valueOf(context.getEpochTime())))
                        .and(ZTEGTS.ZTEGTS_ZTEBSC.eq(bsc.getZtebscId()))
                        .and(ZTEGTS.ZTEGTS_ZTEBTS.eq(bts.getZtebtsId()))
                        .and(ZTEGTS.ZTEGTS_ZTEGCELL.eq(gcell.getZtegcellId()))
                        .and(ZTEGTS.ZTEGTS_ZTEGTRX.eq(trx.getZtegtrxId()))
                        .and(ZTEGTS.GTS.eq(GTs))
                        .fetchAny();

                if (ztegts == null) {
                    ztegts = db.newRecord(ZTEGTS);

                    ztegts.setZtegtsDate(UInteger.valueOf(context.getEpochTime()));
                    ztegts.setZtegtsZtebsc(bsc.getZtebscId());
                    ztegts.setZtegtsZtebts(bts.getZtebtsId());
                    ztegts.setZtegtsZtegcell(gcell.getZtegcellId());
                    ztegts.setZtegtsZtegtrx(trx.getZtegtrxId());
                    ztegts.setGts(GTs);
                }

                List<String> targetColumns = new ArrayList<>();

                for (int i = 0; i < ZTEGTS.fields().length; i++) {
                    String column = ZTEGTS.fields()[i].toString().split("\\.")[2].replace("\"", "");
                    targetColumns.add(column);
                }


                for (int i = 1; i <= meta.getColumnCount(); i++) {
                    if (targetColumns.contains(meta.getColumnName(i))) {
                        ztegts.set(DSL.field(meta.getColumnName(i)), rs.getString(meta.getColumnName(i)));
                        System.out.println("got " + meta.getColumnName(i) + " -> " + rs.getString(meta.getColumnName(i)));
                    }
                }


                if (ztegts.getZtegtsId() == null) {
                    ztegts.store();
                    totalInsert++;
                } else {
                    ztegts.update();
                    totalUpdate++;
                }

                totalRow++;

            }

            System.out.println("fetched total " + totalRow + " rows.");
            System.out.println("total inserted: " + totalInsert + ", total update: " + totalUpdate + ".");
            logger.debug("processGTs() done.");

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    private void processBscLocArea(String query, CrquerysetRecord queryset) {

        logger.debug("processing BSCLOCAREA...");

        DrillCl client = DrillUtils.getInstance(DatabaseHelper.connectDB());

        int totalInsert = 0;
        int totalUpdate = 0;

        try {

            ResultSet rs = client.execQuery(query);
            ResultSetMetaData meta = rs.getMetaData();

            int totalRow = 0;

            while (rs.next()) {

                String GBssFunction = null;
                String SubNetwork = null;
                String MEID = null;

                if (rs.getString("GBssFunction") != null) {
                    GBssFunction = rs.getString("GBssFunction");
                }

                if (rs.getString("SubNetwork") != null) {
                    SubNetwork = rs.getString("SubNetwork");
                }

                if (rs.getString("MEID") != null) {
                    MEID = rs.getString("MEID");
                }

                ZtebscRecord bsc = this.getBsc(SubNetwork, MEID, GBssFunction);

                if (bsc == null) {
                    return;
                }

                ZtebsclocareaRecord ztebscLocarea = db.selectFrom(ZTEBSCLOCAREA)
                        .where(ZTEBSCLOCAREA.ZTEBSCLOCAREA_DATE.eq(UInteger.valueOf(context.getEpochTime())))
                        .and(ZTEBSCLOCAREA.ZTEBSCLOCAREA_ZTEBSC.eq(bsc.getZtebscId()))
                        .fetchAny();

                if (ztebscLocarea == null) {

                }

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    private void processBscRoutingArea(String query, CrquerysetRecord queryset) {

    }

    private void processBscEmlppUserPriority(String query, CrquerysetRecord queryset) {

    }

    private void processBscExtGcell(String query, CrquerysetRecord queryset) {

    }

    private void processBscExtUcell(String query, CrquerysetRecord queryset) {

    }

    private void processBscExtLcell(String query, CrquerysetRecord queryset) {

    }

    private void processGcellBvc(String query, CrquerysetRecord queryset) {

    }

    private void processGcellPsUsrAndType(String query, CrquerysetRecord queryset) {

    }

    private void processGcellRelGcell(String query, CrquerysetRecord queryset) {

    }

    private void processGcellRelUcell(String query, CrquerysetRecord queryset) {

    }

    private void processGcellRelLcell(String query, CrquerysetRecord queryset) {

    }

    private ZtebscRecord getBsc(String SubNetwork, String MEID, String GBssFunction){

        for (int i = 0; i < ztebscs.size(); i++) {

            if(ztebscs.get(i).getSubnetwork().equals(SubNetwork) && ztebscs.get(i).getMeid().equals(MEID) && ztebscs.get(i).getGbssfunction().equals(GBssFunction)){

                return ztebscs.get(i);
            }
        }

        return null;
    }

    private ZtebscRecord getBsc2(String SubNetwork){

        for (int i = 0; i < ztebscs.size(); i++) {

            if(ztebscs.get(i).getSubnetwork().equals(SubNetwork)){

                return ztebscs.get(i);
            }
        }

        return null;
    }

    private ZtebscRecord getBsc3(String SubNetwork, String MEID, String userLabel){

        for (int i = 0; i < ztebscs.size(); i++) {

            if(ztebscs.get(i).getSubnetwork().equals(SubNetwork) && ztebscs.get(i).getMeid().equals(MEID) && ztebscs.get(i).getUserlabel().equals(userLabel)){

                return ztebscs.get(i);
            }
        }

        return null;
    }

    private ZtebtsRecord getBts(String SubNetwork, String MEID, String GBssFunction, String GBtsSiteManager){

        for (int i = 0; i < ztebtss.size(); i++) {

            if(ztebtss.get(i).getSubnetwork().equals(SubNetwork) && ztebtss.get(i).getMeid().equals(MEID) && ztebtss.get(i).getGbssfunction().equals(GBssFunction) && ztebtss.get(i).getGbtssitemanager().equals(GBtsSiteManager)){

                return ztebtss.get(i);
            }
        }

        return null;
    }

    private ZtebtsRecord getBts2(String MOID){

        for (int i = 0; i < ztebtss.size(); i++) {

            if(MOID.startsWith(ztebtss.get(i).getMoi() + ",")){

                return ztebtss.get(i);
            }
        }

        return null;
    }

    private ZtebtsRecord getBts3(String SubNetwork, String MEID, String userLabel){

        for (int i = 0; i < ztebtss.size(); i++) {

            if(ztebtss.get(i).getSubnetwork().equals(SubNetwork) && ztebtss.get(i).getMeid().equals(MEID) && ztebtss.get(i).getUserlabel().equals(userLabel)){

                return ztebtss.get(i);
            }
        }

        return null;
    }

    private ZtegcellRecord getGcell(String SubNetwork, String MEID, String GBssFunction, String GBtsSiteManager, String GGsmCell){

        for (int i = 0; i < ztegcells.size(); i++) {

            if(ztegcells.get(i).getSubnetwork().equals(SubNetwork) && ztegcells.get(i).getMeid().equals(MEID) && ztegcells.get(i).getGbssfunction().equals(GBssFunction) && ztegcells.get(i).getGbtssitemanager().equals(GBtsSiteManager) && ztegcells.get(i).getGgsmcell().equals(GGsmCell)){

                return ztegcells.get(i);
            }
        }

        return null;
    }

    private ZtegtrxRecord getGtrx(String SubNetwork, String MEID, String GBssFunction, String GBtsSiteManager, String GGsmCell, String GTrx) {

        for (int i = 0; i < ztegtrxs.size(); i++) {

            if (ztegtrxs.get(i).getSubnetwork().equals(SubNetwork) && ztegtrxs.get(i).getMeid().equals(MEID) && ztegtrxs.get(i).getGbssfunction().equals(GBssFunction) && ztegtrxs.get(i).getGbtssitemanager().equals(GBtsSiteManager) && ztegtrxs.get(i).getGgsmcell().equals(GGsmCell) && ztegtrxs.get(i).getGtrx().equals(GTrx)) {

                return ztegtrxs.get(i);
            }
        }

        return null;
    }
}

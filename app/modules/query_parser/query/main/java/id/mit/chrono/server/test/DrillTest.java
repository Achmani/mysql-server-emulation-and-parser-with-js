package id.mit.chrono.server.test;

import id.mit.chrono.server.database.DatabaseHelper;
import id.mit.chrono.server.obj.DrillCl;
import id.mit.chrono.server.util.DrillUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class DrillTest {

    public static void main(String[] args) {
//        try {
//            Class.forName("org.apache.drill.jdbc.Driver");
//
//            Connection connection = DriverManager.getConnection("jdbc:drill:drillbit=10.53.193.108:31010");
//            Statement st = connection.createStatement();
////            ResultSet rs = st.executeQuery("SELECT * FROM TABLE(dfs.`/drill_data/LACIMA/2020121109_DataOSS_3G.csv`(type => 'text', fieldDelimiter => ';'))");
////            ResultSet rs = st.executeQuery("SELECT * FROM dfs.`/chrono/CM_RAN/20210218/UMEID_ITBBU_ZTE_20210218010000.zip/gsm-V2.0-20210218010000-732/AbisLink.csv`");
////            ResultSet rs = st.executeQuery("select * from table(dfs.`/test-data/2021051920_DataOSS_5G.csv`(type => 'text', fieldDelimiter => ';')) LIMIT 3");
//
//            Scanner scanner = new Scanner(System.in);
//            System.out.print("query: ");
//            String query = scanner.nextLine();
//
//            System.out.println();
//
//            ResultSet rs = st.executeQuery(query);
//
//            ResultSetMetaData metaData = rs.getMetaData();
//            int columnSize = metaData.getColumnCount();
//
//            System.out.println("columnSize: " + columnSize);
//
//            int showColumn = 0;
//
//            while(rs.next()){
//
//                // make sure print column header first
//                if (showColumn != 1) {
//                    for (int i = 1; i <= columnSize; i++) {
//                        System.out.print(metaData.getColumnName(i));
//                        System.out.print("\t");
//                    }
//                }
//
//                System.out.println();
//                showColumn = 1;
//
//                for (int i = 1; i <= columnSize; i++) {
//                    System.out.print(rs.getString(i));
//                    System.out.print("\t");
//                }
//
//
//                System.out.println();
//
////                System.out.println(rs.getString("CELLNAME"));
//            }
//
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }

        String query  = "SELECT\n" +
                "  `GExternalUtranCellFDD`.GExternalUtranCellFDD AS GExternalUtranCellFDDId, \n" +
                "  `GExternalUtranCellFDD`.ci AS ci, \n" +
                "  `GExternalUtranCellFDD`.rnc_id AS rnc_id, \n" +
                "  `GExternalUtranCellFDD`.arfcn3g AS arfcn3g, \n" +
                "  `GExternalUtranCellFDD`.scCode AS scCode, \n" +
                "  `GExternalUtranCellFDD`.diversity AS diversity, \n" +
                "  `GExternalUtranCellFDD`.inner3GNcell AS inner3GNcell, \n" +
                "  `GCrrmNCellLdFDD`.GCrrmNCellLdFDD AS GCrrmNCellLdFDDId, \n" +
                "  `GCrrmNCellLdFDD`.csRemUserLowThs AS csRemUserLowThs, \n" +
                "  `GCrrmNCellLdFDD`.psRemUserLowThs AS psRemUserLowThs, \n" +
                "  `GCrrmNCellLdFDD`.csRemUserMidThs AS csRemUserMidThs, \n" +
                "  `GCrrmNCellLdFDD`.psRemUserMidThs AS psRemUserMidThs, \n" +
                "  `GCrrmNCellLdFDD`.ulLoadLowThs AS ulLoadLowThs, \n" +
                "  `GCrrmNCellLdFDD`.ulLoadMidThs AS ulLoadMidThs, \n" +
                "  `GCrrmNCellLdFDD`.ulLoadHighThs AS ulLoadHighThs, \n" +
                "  `GCrrmNCellLdFDD`.dlLoadLowThs AS dlLoadLowThs, \n" +
                "  `GCrrmNCellLdFDD`.dlLoadMidThs AS dlLoadMidThs, \n" +
                "  `GCrrmNCellLdFDD`.dlLoadHighThs AS dlLoadHighThs, \n" +
                "  `GCrrmNCellLdFDD`.ulRtLoadLowThs AS ulRtLoadLowThs, \n" +
                "  `GCrrmNCellLdFDD`.ulRtLoadMidThs AS ulRtLoadMidThs, \n" +
                "  `GCrrmNCellLdFDD`.ulRtLoadHighThs AS ulRtLoadHighThs, \n" +
                "  `GCrrmNCellLdFDD`.dlRtLoadLowThs AS dlRtLoadLowThs, \n" +
                "  `GCrrmNCellLdFDD`.dlRtLoadMidThs AS dlRtLoadMidThs, \n" +
                "  `GCrrmNCellLdFDD`.dlRtLoadHighThs AS dlRtLoadHighThs, \n" +
                "  `GCrrmNCellLdFDD`.ulNRtLoadLowThs AS ulNRtLoadLowThs, \n" +
                "  `GCrrmNCellLdFDD`.ulNRtLoadMidThs AS ulNRtLoadMidThs, \n" +
                "  `GCrrmNCellLdFDD`.ulNRtLoadHighThs AS ulNRtLoadHighThs, \n" +
                "  `GCrrmNCellLdFDD`.dlNRtLoadLowThs AS dlNRtLoadLowThs, \n" +
                "  `GCrrmNCellLdFDD`.dlNRtLoadMidThs AS dlNRtLoadMidThs, \n" +
                "  `GCrrmNCellLdFDD`.dlNRtLoadHighThs AS dlNRtLoadHighThs\n" +
                "FROM dfs.`/storage/chrono/app/collector/development/data/tmp/Controller-gsm_radio-R4V12.18.41P02-20210602012902-220.zip/GExternalUtranCellFDD.csv` `GExternalUtranCellFDD`\n" +
                "LEFT JOIN dfs.`/storage/chrono/app/collector/development/data/tmp/Controller-gsm_radio-R4V12.18.41P02-20210602012902-220.zip/GCrrmNCellLdFDD.csv` `GCrrmNCellLdFDD`\n" +
                "  ON CONCAT(`GCrrmNCellLdFDD`.GBssFunction, `GCrrmNCellLdFDD`.GBtsSiteManager, `GCrrmNCellLdFDD`.GExternalUtranCellFDD) = CONCAT(`GExternalUtranCellFDD`.GBssFunction, `GExternalUtranCellFDD`.GBtsSiteManager, `GExternalUtranCellFDD`.GExternalUtranCellFDD)\n";

        DrillCl client = DrillUtils.getInstance(DatabaseHelper.connectDB());
        ResultSet rs = client.execQuery(query);

        if (rs != null) {

            int totalRow = 0;

            try {

                ResultSetMetaData meta = rs.getMetaData();

                for (int i = 1; i <= meta.getColumnCount(); i++) {
                    System.out.print(meta.getColumnName(i)+"\t");
                }
                System.out.println();

                // iterate through rows
                while (rs.next()) {
                    System.out.println("loop");
                    // iterate through columns
                    for (int j = 1; j <= meta.getColumnCount(); j++) {
                        System.out.print(rs.getString(meta.getColumnName(j)));
                        System.out.print("\t");
                    }
                    System.out.println();

                    totalRow ++;
                }

                System.out.println("fetched total " + totalRow + " rows.");

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    public void execute(String query) {

        DrillCl client = DrillUtils.getInstance(DatabaseHelper.connectDB());
        ResultSet rs = client.execQuery(query);

        if (rs != null) {

            int totalRow = 0;

            try {

                ResultSetMetaData meta = rs.getMetaData();

                for (int i = 1; i <= meta.getColumnCount(); i++) {
                    System.out.print(meta.getColumnName(i)+"\t");
                }
                System.out.println();

                // iterate through rows
                while (rs.next()) {
                    System.out.println("loop");
                    // iterate through columns
                    for (int j = 1; j <= meta.getColumnCount(); j++) {
                        System.out.print(rs.getString(meta.getColumnName(j)));
                        System.out.print("\t");
                    }
                    System.out.println();

                    totalRow ++;
                }

                System.out.println("fetched total " + totalRow + " rows.");

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
}

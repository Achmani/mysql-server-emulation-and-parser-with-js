package id.mit.chrono.server.test;

import id.mit.chrono.server.parser.EricssonCnaExportParser;
import id.mit.chrono.server.parser.EricssonNodeExportParser;

import java.io.File;

public class EricssonNodeExportParserTest {

    public static void main(String[] args) {

        System.out.println("parsing...");

        EricssonNodeExportParser nodeExportParser = new EricssonNodeExportParser();
        System.out.println(nodeExportParser.parse(new File("/storage/chrono/app/collector/development/data/raw/CM_RAN/202104190900/CM_RAN_ER_10.54.50.23/ericsson/batch/data/export/3gpp_export/nptq_ran7_3g_AntennaBranch_20210418.txt")));
        System.out.println(nodeExportParser.parse(new File("/storage/chrono/app/collector/development/data/raw/CM_RAN/202104190900/CM_RAN_ER_10.54.50.23/ericsson/batch/data/export/3gpp_export/nptq_ran7_3g_Handover_20210418.txt")));
        System.out.println(nodeExportParser.parse(new File("/storage/chrono/app/collector/development/data/raw/CM_RAN/202104190900/CM_RAN_ER_10.54.50.23/ericsson/batch/data/export/3gpp_export/nptq_ran7_3g_NodeBFunction_20210418.txt")));
        System.out.println(nodeExportParser.parse(new File("/storage/chrono/app/collector/development/data/raw/CM_RAN/202104190900/CM_RAN_ER_10.54.50.23/ericsson/batch/data/export/3gpp_export/nptq_ran7_3g_RncRealtimeIndicators_20210418.txt")));
        System.out.println(nodeExportParser.parse(new File("/storage/chrono/app/collector/development/data/raw/CM_RAN/202104190900/CM_RAN_ER_10.54.50.23/ericsson/batch/data/export/3gpp_export/nptq_ran7_4g_EUtranCellFDD_20210418.txt")));
        System.out.println(nodeExportParser.parse(new File("/storage/chrono/app/collector/development/data/raw/CM_RAN/202104190900/CM_RAN_ER_10.54.50.23/ericsson/batch/data/export/3gpp_export/nptq_ran7_4g_EUtranCellTDD_20210418.txt")));
        System.out.println(nodeExportParser.parse(new File("/storage/chrono/app/collector/development/data/raw/CM_RAN/202104190900/CM_RAN_ER_10.54.50.23/ericsson/batch/data/export/3gpp_export/nptq_ran7_4g_SwM_20210418.txt")));
    }
}

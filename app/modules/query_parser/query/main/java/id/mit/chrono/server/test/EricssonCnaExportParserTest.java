package id.mit.chrono.server.test;

import id.mit.chrono.server.parser.EricssonCnaExportParser;

import java.io.File;

public class EricssonCnaExportParserTest {

    public static void main(String[] args) {

        System.out.println("parsing...");

        EricssonCnaExportParser cnaParser = new EricssonCnaExportParser();
        cnaParser.parse(new File("/storage/chrono/app/collector/development/nptq_cna_export_ran2.txt"));
    }
}

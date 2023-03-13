package id.mit.chrono.server.test;

import id.mit.chrono.server.obj.BodaHwCfgmmlParser;
import id.mit.chrono.server.util.ArchiveUtils;
import id.mit.chrono.server.util.FileUtils;

import java.io.File;
import java.io.IOException;

public class BodaHwCfgmmlTest {

    public static void main(String[] args) {

        try {

            File outputDir = FileUtils.createTmpDir("../development", "boda-output");
            File tempDir = FileUtils.createTmpDir("../development/boda-output", "tmp");

            String filePath = "data/raw/CM_RAN/202104300900/CM_RAN_HW_10.212.83.57/export/home/sysm/ftproot/TimerTask/CFGMML/Regional_10_CFGMML_MBSC_TTCKenanga1_20210430.zip";
            String tmpOutputPath = ArchiveUtils.extractZip(new File(filePath), tempDir).get(0);

            BodaHwCfgmmlParser bodaParser = new BodaHwCfgmmlParser();
            bodaParser.setDataSource(tmpOutputPath);
            bodaParser.setOutputDirectory(outputDir.getAbsolutePath());
            bodaParser.parse();
            bodaParser.closeMOPWMap();
            bodaParser = null;

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

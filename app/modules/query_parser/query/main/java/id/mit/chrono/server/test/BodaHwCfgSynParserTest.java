package id.mit.chrono.server.test;

import id.mit.chrono.server.obj.BodaBulkCMParser2;
import id.mit.chrono.server.obj.BodaHwCfgSynParser;
import id.mit.chrono.server.util.ArchiveUtils;
import id.mit.chrono.server.util.FileUtils;

import javax.xml.stream.XMLStreamException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

public class BodaHwCfgSynParserTest {

    public static void main(String[] args) {

        try {

            File outputDir = FileUtils.createTmpDir("../development", "boda-output");
            File tempDir = FileUtils.createTmpDir("../development/boda-output", "tmp");

            String filePath = "data/raw/CM_RAN/202104280900/CM_RAN_HW_10.212.82.7/export/home/sysm/ftproot/BTS3900/Data/14311194/BAKDATA20210428011757/CFGDATA.XML.gz_x_E_DPR351_RSSanglah.XML.gz";
            String tmpOutputPath = ArchiveUtils.decompressGZIP(new File(filePath), tempDir).get(0);

            BodaHwCfgSynParser bodaParser = new BodaHwCfgSynParser();
            bodaParser.setDataSource(tmpOutputPath);
            bodaParser.setOutputDirectory(outputDir.getAbsolutePath());
            bodaParser.parse();
            bodaParser.closeMOPWMap();
            bodaParser = null;

        } catch (XMLStreamException | FileNotFoundException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

}

package id.mit.chrono.server.extractor;

import id.mit.chrono.server.base.BaseFileExtractor;
import id.mit.chrono.server.iface.ExtractorCallback;
import id.mit.chrono.server.obj.BodaBulkCMParser;
import id.mit.chrono.server.obj.BodaBulkCMParser2;
import id.mit.chrono.server.obj.ChronoContext;
import id.mit.chrono.server.obj.HDFSCl;
import id.mit.chrono.server.parser.EricssonCnaExportParser;
import id.mit.chrono.server.parser.EricssonNodeExportParser;
import id.mit.chrono.server.util.FileUtils;

import javax.xml.stream.XMLStreamException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class EricssonExtractor extends BaseFileExtractor {

    @Override
    protected void extract() {

        ArrayList<String> outputPath = new ArrayList<>();

        files.forEach(file -> {

            String path = file.getAbsolutePath();
            System.out.println("path: " + path);
            System.out.println("name: " + file.getName() + ", match pattern: " + file.getName().matches("^nptq_cna_export_ran\\d.txt"));

            String fileName = path.substring(path.lastIndexOf("/") + 1);


            if (FileUtils.extensionDetector(fileName).equals("csv")) {

                // if file is csv (ex: OSSRC_2G_XXX)
                outputPath.add(path);
            }
            else if (FileUtils.extensionDetector(fileName).equals("xml")) {

                File outputDir = FileUtils.createTmpDir(path.substring(0, path.lastIndexOf("/") + 1), "boda-output");

                if (outputDir != null) {

                    // call boda parser
                    try {

                        BodaBulkCMParser2 bodaParser = new BodaBulkCMParser2();
                        bodaParser.setDataSource(path);
                        bodaParser.setOutputDirectory(outputDir.getAbsolutePath());
                        bodaParser.parse();
                        bodaParser.closeMOPWMap();
                        bodaParser = null;

                        if (outputDir.listFiles() != null && outputDir.listFiles().length > 0) {

                            // add all parsed file path to outputPath
                            outputPath.addAll(

                                    // iterate through parsed file
                                    Arrays.stream(outputDir.listFiles()).map(extractedFile -> {

                                        // move file from boda-output to parent dir (just try to make file path shorter)
                                        File movedFile = FileUtils.moveFile(extractedFile, new File(path.substring(0, path.lastIndexOf("/") + 1)));
                                        return movedFile.getAbsolutePath();

                                    }).collect(Collectors.toCollection(ArrayList::new))
                            );

                        }

                    } catch (UnsupportedEncodingException | XMLStreamException | FileNotFoundException e) {
                        e.printStackTrace();
                    }
                } else {
                    logger.debug("Failed to parse. Cannot create output directory for boda-parser");
                }

            }
            else if (file.getName().matches("^nptq_cna_export_ran\\d.txt")) {

                EricssonCnaExportParser cnaParser = new EricssonCnaExportParser();
                outputPath.add(cnaParser.parse(file));
            }
            else if (file.getName().matches("^nptq_.*[.]txt")) {

                EricssonNodeExportParser nodeExportParser = new EricssonNodeExportParser();
                outputPath.add(nodeExportParser.parse(file));
            }

        });

        finishExtract(outputPath);

    }
}

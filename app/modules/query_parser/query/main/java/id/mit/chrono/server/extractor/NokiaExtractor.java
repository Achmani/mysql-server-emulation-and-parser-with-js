package id.mit.chrono.server.extractor;

import id.mit.chrono.server.base.BaseFileExtractor;
import id.mit.chrono.server.iface.ExtractorCallback;
import id.mit.chrono.server.obj.BodaBulkCMNokiaParser;
import id.mit.chrono.server.obj.ChronoContext;
import id.mit.chrono.server.obj.HDFSCl;
import id.mit.chrono.server.util.FileUtils;

import javax.xml.stream.XMLStreamException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class NokiaExtractor extends BaseFileExtractor {

    @Override
    protected void extract() {

        ArrayList<String> outputPath = new ArrayList<>();

        files.forEach(file -> {

            String path = file.getAbsolutePath();
            System.out.println("Path: " + path);

            String fileName = path.substring(path.lastIndexOf("/") + 1);

            // perform extension validation (make sure the extension is xml)
            if (FileUtils.extensionDetector(fileName).equals("xml")) {

//                File outputDir = new File(path.substring(0, path.lastIndexOf("/") + 1) + File.separator + "boda-output");
//                System.out.println("outputPath: " + outputDir.getAbsolutePath());
//
//                if (!outputDir.exists()) {
//
//                    if (outputDir.mkdirs()) {
//                        logger.debug("created tmp directory: " + outputDir.getAbsolutePath());
//                    } else {
//                        logger.debug("failed to create tmp directory: " + outputDir.getAbsolutePath());
//                    }
//                }

                File outputDir = FileUtils.createTmpDir(path.substring(0, path.lastIndexOf("/") + 1), "boda-output");

                if (outputDir != null) {

                    // call boda parser
                    try {

                        BodaBulkCMNokiaParser bodaParser = new BodaBulkCMNokiaParser();
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

                    } catch (IOException | XMLStreamException e) {
                        e.printStackTrace();
                    }
                } else {
                    logger.debug("Failed to parse. Cannot create output directory for boda-parser");
                }

            } else {
                outputPath.add(file.getAbsolutePath());
            }

        });

        finishExtract(outputPath);

    }
}

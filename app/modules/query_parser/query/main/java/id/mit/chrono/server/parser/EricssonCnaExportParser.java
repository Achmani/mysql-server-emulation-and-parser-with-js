package id.mit.chrono.server.parser;


import id.mit.chrono.server.obj.CSVUtils;
import id.mit.chrono.server.util.FileUtils;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class EricssonCnaExportParser {

    protected Logger logger = LoggerFactory.getLogger(this.getClass());

    public String parse(File inputFile) {

        logger.debug("parsing file: " + inputFile.getName());

        String outputPath = null;

        try {

            InputStream inputStream = new FileInputStream(inputFile);
            BufferedReader buffer = new BufferedReader(new InputStreamReader(inputStream));

            Stream<String> lineStream = buffer.lines();

//            List<String> csvBuilder = new ArrayList<>();
//
//            lineStream.forEach(line -> {
//                if (!line.startsWith("----------")) {
//                    csvBuilder.add(line.replace(" ", ","));
//                }
//            });

            // now create output directory
            String basePath = inputFile.getAbsolutePath();
            File outputDir = FileUtils.createTmpDir(basePath.substring(0, basePath.lastIndexOf("/") + 1), "output");

            if (outputDir != null) {

                outputPath = outputDir.getAbsolutePath() + File.separator + "cna_export.csv";
                System.out.println("output path: " + outputPath);

                // write new csv file
                FileWriter writer = new FileWriter(outputPath);
                PrintWriter pWriter = new PrintWriter(new BufferedWriter(writer));

                lineStream.forEach(line -> {
                    if (!line.startsWith("----------")) {
//                        csvBuilder.add(line.replace(" ", ","));
                        try {
                            CSVUtils.writeLine(pWriter, Arrays.asList(line.split(" ")), ',');
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                });

                // verify our output
                File outputFile = new File(outputPath);
                // if the creation of file is failed, return null
                if (outputFile == null) {
                    return null;
                }

                pWriter.flush();
                pWriter.close();

                System.out.println("parse finished.");
            } else {
                System.out.println("failed to create output directory.");
                return null;
            }



        } catch (Exception e) {
            logger.debug("failed to parse: " + e.getMessage());
            e.printStackTrace();
        }

        return outputPath;

    }
}

package id.mit.chrono.server.parser;

import id.mit.chrono.server.obj.CSVUtils;
import id.mit.chrono.server.util.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.Arrays;
import java.util.stream.Stream;

public class EricssonNodeExportParser {

    protected Logger logger = LoggerFactory.getLogger(this.getClass());

    public String parse(File inputFile) {

        logger.debug("parsing file: " + inputFile.getName());

        String outputPath = null;

        try {

            InputStream inputStream = new FileInputStream(inputFile);
            BufferedReader buffer = new BufferedReader(new InputStreamReader(inputStream));

            Stream<String> lineStream = buffer.lines();

            String basePath = inputFile.getAbsolutePath();
            File outputDir = FileUtils.createTmpDir(basePath.substring(0, basePath.lastIndexOf("/") + 1), "");

            if (outputDir != null) {

                String outputFileName = inputFile.getName().split("_")[2] + "_" +inputFile.getName().split("_")[3] + ".csv";
                outputPath = outputDir.getAbsolutePath() + File.separator + outputFileName;
                System.out.println("output path: " + outputPath);

                FileWriter writer = new FileWriter(outputPath);
                PrintWriter pWriter = new PrintWriter(new BufferedWriter(writer));


                lineStream.skip(1).forEach(line -> {
                    try {
                        CSVUtils.writeLine(pWriter, Arrays.asList(line.split("\t")));
                    } catch (IOException e) {
                        e.printStackTrace();
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

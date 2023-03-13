package id.mit.chrono.server.extractor;

import id.mit.chrono.server.base.BaseFileExtractor;
import id.mit.chrono.server.obj.*;
import id.mit.chrono.server.parser.HuaweiCmExportParser2;
import id.mit.chrono.server.parser.HuaweiGExportParser2;
import id.mit.chrono.server.util.FileUtils;

import javax.xml.stream.XMLStreamException;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class HuaweiExtractor extends BaseFileExtractor {

    @Override
    protected void extract() {

        ArrayList<String> outputPath = new ArrayList<>();

        files.forEach(file -> {
            String path = file.getAbsolutePath();
            System.out.println("path: " + path);

            String fileName = path.substring(path.lastIndexOf("/") + 1);

            System.out.println("extension is txt: " + FileUtils.extensionDetector(fileName).equals("txt"));

            if (FileUtils.extensionDetector(fileName).equals("csv")) {

                HuaweiCmExportParser2 hwCMParser = new HuaweiCmExportParser2(file);
                Map<String, List<HuaweiBasicKeyParamsObj>> outParse = hwCMParser.parse();

                outputPath.addAll(exportToCSV(path, outParse));

            }
            else if (FileUtils.extensionDetector(fileName).equals("xml") && fileName.startsWith("GExport")) {

                HuaweiGExportParser2 hwGParser = new HuaweiGExportParser2(file);
                Map<String, List<HuaweiBasicKeyParamsObj>> outParse = hwGParser.parse();

                outputPath.addAll(exportToCSV(path, outParse));
//                outputPath.forEach(System.out::println);
            }
            else if (FileUtils.extensionDetector(fileName).equalsIgnoreCase("xml") && fileName.startsWith("CFGDATA")) {

                File outputDir = FileUtils.createTmpDir(path.substring(0, path.lastIndexOf("/") + 1), "boda-output");

                if (outputDir != null) {

                    try {

//                        logger.debug("parsing file: " + file.getName());

                        BodaHwCfgSynParser hwCfgParser = new BodaHwCfgSynParser();
                        hwCfgParser.setDataSource(path);
                        hwCfgParser.setOutputDirectory(outputDir.getAbsolutePath());
                        hwCfgParser.parse();
                        hwCfgParser.closeMOPWMap();
                        hwCfgParser = null;

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

                }


            }
            else if (FileUtils.extensionDetector(fileName).equals("txt")) {

                File outputDir = FileUtils.createTmpDir(path.substring(0, path.lastIndexOf("/") + 1), "boda-output");

                if (outputDir != null) {

                    try {

                        BodaHwCfgmmlParser hwCfgmmlParser = new BodaHwCfgmmlParser();
                        hwCfgmmlParser.setDataSource(path);
                        hwCfgmmlParser.setOutputDirectory(outputDir.getAbsolutePath());
                        hwCfgmmlParser.parse();
                        hwCfgmmlParser.closeMOPWMap();
                        hwCfgmmlParser = null;

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

                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }

            }
        });

        outputPath.forEach(System.out::println);

        finishExtract(outputPath);

    }

    private List<String> exportToCSV(String basePath, Map<String, List<HuaweiBasicKeyParamsObj>> groupHwKeyParams) {

        List<String> outputs = new ArrayList<>();

        File outputDir = FileUtils.createTmpDir(basePath.substring(0, basePath.lastIndexOf("/") + 1), "output");

        if (outputDir != null) {

            System.out.println("target total file(s): " + groupHwKeyParams.size());

            // start export to csv per className
            groupHwKeyParams.forEach((key, items) -> {

                char separator = ';';

//                System.out.println("########\t KEY: " + key + "\t########");

                String outputName = key + ".csv";
//                System.out.println("target outputName: " + outputName);

                String outputPath = outputDir.getAbsolutePath() + File.separator + outputName;
//                System.out.println("output path: " + outputPath);

                List<String> header = new ArrayList<>(items.get(0).params.keySet());
//                System.out.println(Arrays.toString(header.toArray()));

//                System.out.println("target total row(s): " + items.size());

                try {

                    FileWriter writer = new FileWriter(outputPath);

//                    logger.debug("start export to csv: " + outputName);

                    // write header first
                    CSVUtils.writeLine(writer, header, separator);

                    for (HuaweiBasicKeyParamsObj item : items) {

                        // get params value
                        List<String> value = new ArrayList<>(item.params.values());

                        // write to csv
                        CSVUtils.writeLine(writer, value, separator);
                    }

                    writer.flush();
                    writer.close();

//                    outputs.add(outputPath);

                } catch (IOException e) {

                    logger.debug("failed to export: " + e.getMessage());
                    e.printStackTrace();

                }

            });

            if (outputDir.listFiles() != null && outputDir.listFiles().length > 0) {

                // add all parsed file path to outputs
                outputs.addAll(

                        Arrays.stream(outputDir.listFiles()).map(file -> {

                            // move file from output to parent dir (just try to make file path shorter)
                            File movedFile = FileUtils.moveFile(file, new File(basePath.substring(0, basePath.lastIndexOf("/") + 1)));
                            return movedFile.getAbsolutePath();

                        }).collect(Collectors.toCollection(ArrayList::new))
                );

            }

        }

        return outputs;
    }

}

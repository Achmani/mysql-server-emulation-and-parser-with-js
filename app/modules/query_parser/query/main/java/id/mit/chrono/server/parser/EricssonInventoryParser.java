package id.mit.chrono.server.parser;

import id.mit.chrono.server.base.BaseFileParser;
import id.mit.chrono.server.iface.FileParser;
import id.mit.chrono.server.obj.ErBasicTagParamsObj;
import id.mit.chrono.server.obj.NokBasicTagParamsObj;
import id.mit.chrono.server.util.StringUtils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class EricssonInventoryParser extends BaseFileParser implements FileParser {


    @Override
    protected void parseLocal() {


        prepareBase();

        logger.debug("files size: " + files.size());

        String commandPattern = "^[<](.*[;])$";
        Pattern p = Pattern.compile(commandPattern);

        String text;


        int countField = 0;

        if (files.size() == 1) {
            this.sourceFile.setKey("ER_INVT");

            try (BufferedReader br = new BufferedReader(new FileReader(files.get(0)))) {

                while ((text = br.readLine()) != null) {
                    int col = 0;

                    HashMap<String, String> rawData = new HashMap<>();

                    int position = text.lastIndexOf("\"") + 1;

                    String temp2nd = text.substring(position, text.length() - 1).trim();

                    String temp[] = temp2nd.split("[\\t]|( ){3,}");

                    String temp1nd = text.substring(0, position);

                    rawData.put("col" + (++col), temp1nd);


                    for (int i = 0; i < temp.length; i++) {
                        rawData.put("col" + (++col), temp[i]);
                    }

                    Pattern pattern = Pattern.compile("(?<=subnetwork=\")([A-Za-z0-9-_+ ]+)");
                    Matcher matcher = pattern.matcher(temp1nd);

                    if (matcher.find()) {
                        rawData.put("subnetwork", matcher.group(0));
                    }

                    Pattern pattern2 = Pattern.compile("(?<=bsc=\")([A-Za-z0-9-_+ ]+)");
                    Matcher matcher2 = pattern2.matcher(temp1nd);

                    if (matcher2.find()) {
                        rawData.put("bsc", matcher2.group(0));
                    }

                    Pattern pattern3 = Pattern.compile("(?<=site=\")([A-Za-z0-9-_+# ]+)");
                    Matcher matcher3 = pattern3.matcher(temp1nd);

                    if (matcher3.find()) {
                        rawData.put("site", matcher3.group(0));
                    }

                    Pattern pattern4 = Pattern.compile("(?<=ru=\")([A-Za-z0-9-_+ ]+)");
                    Matcher matcher4 = pattern4.matcher(temp1nd);

                    int ruTrigger = 1;
                    while (matcher4.find()) {
                        rawData.put("ru" + (ruTrigger++), matcher4.group());
                    }

//                    System.out.println("=================================");

//                    System.out.println(">>>>>>>>>>>>>>>>>>>>>>>");
                    sourceFile.addResult(new ErBasicTagParamsObj("ER_INVT", rawData));


//                    for (int i = 0; i < rawData.size(); i++) {
//                        System.out.println("--------" + rawData.get("col1"));
//                    }
//                    break;

                }
//                List<ErBasicTagParamsObj> test = sourceFile.getResult().stream()
//                        .filter(ErBasicTagParamsObj.class::isInstance)
//                        .map(ErBasicTagParamsObj.class::cast)
//                        .filter(tag -> tag.tag.equals("tes"))
//                        .filter(params -> params.params.containsKey("col1"))
//                        .collect(Collectors.toList());
//
//                for (int i = 0; i < test.size(); i++) {
//                    System.out.println("<<<<<<<<<<<<<<>>>>>>>>>>>>>>");
//                    for (int j = 0; j < test.get(i).params.size(); j++) {
//                        System.out.println("======" + test.get(i).params.get("col" + (j + 1)));
//                    }
//
//                }


                System.out.println(">>>>>>>>>>count: " + countField);
                updateFileProcessTime(1, null);
            } catch (Exception e) {
                updateFileProcessTime(3, e.getMessage());
                logger.debug("parse failed: " + e.getMessage() + ": " + sourceFile.getFilePath());
                e.printStackTrace();
            }

        }
    }
}

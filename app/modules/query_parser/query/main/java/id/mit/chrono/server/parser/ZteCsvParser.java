package id.mit.chrono.server.parser;

import id.mit.chrono.server.base.BaseFileParser;
import id.mit.chrono.server.iface.FileParser;
import id.mit.chrono.server.obj.HuaweiBasicKeyParamsObj;
import id.mit.chrono.server.obj.ZteBasicKeyParamsObj;
import id.mit.chrono.server.var.Vars;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ZteCsvParser extends BaseFileParser implements FileParser {

    @Override
    protected void parseLocal(){

        prepareBase();

//        logger.debug("files size: " + files.size());

        String group;
        String fileName;

        for (int i = 0; i < files.size(); i++) {

            fileName = files.get(i).getName();

            if (fileName.contains(".csv")) {

                group = fileName.substring(0, fileName.indexOf(".csv"));

//                System.out.println("group: " + group);

                boolean used = false;

                for (int j = 0; !used && j < usedSourceGroups.size(); j++) {

                    used = group.matches(usedSourceGroups.get(j));
//                    System.out.println("used -> "+used);
                }

//                System.out.println("\n\n\r");

                if (used) {

                    try {

                        Reader reader = Files.newBufferedReader(Paths.get(files.get(i).getPath()));

                        CSVParser parser = new CSVParser(reader, CSVFormat.RFC4180.withFirstRecordAsHeader());

                        Map<String, Integer> headerMap = parser.getHeaderMap();

                        for (CSVRecord csvRecord : parser) {

                            HashMap<String, String> params = new HashMap<String, String>();

                            for(String key: headerMap.keySet()){

                                if(key.isEmpty()){
                                    continue;
                                }

//                                System.out.println("k: " + key + " -> " + headerMap.get(key) + " => " + csvRecord.get(key));

                                try{
                                    params.put(key, csvRecord.get(key));
                                }
                                catch(Exception e){
//                                    System.out.println("WKWKWK -> " + files.get(i).getPath());
                                    e.printStackTrace();
                                }
                            }

//                            System.out.println("Add: " + group + " +++ " + params.size());
                            sourceFile.addResult(new ZteBasicKeyParamsObj(group, params));
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

//        System.out.println("OKE, total result: " + result.size());
    }
}

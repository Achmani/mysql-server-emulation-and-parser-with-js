package id.mit.chrono.server.parser;

import id.mit.chrono.server.base.BaseFileParser;
import id.mit.chrono.server.iface.FileParser;
import id.mit.chrono.server.obj.ErBasicTagParamsObj;
import id.mit.chrono.server.obj.ZteBasicKeyParamsObj;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class EricssonCnaiParser extends BaseFileParser implements FileParser {

    @Override
    protected void parseLocal(){

        prepareBase();

        logger.debug("files size: " + files.size());

        String tag;
        String fileName;
        String val;

        for (int i = 0; i < files.size(); i++) {

            fileName = files.get(i).getName();

            System.out.println("fileName: " + fileName);

            if (fileName.endsWith(".csv")) {

//                group = fileName.substring(0, fileName.indexOf(".csv."));

                tag = "cnai";

                if(usedSourceGroups.contains(tag)){

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

                                val = csvRecord.get(key);

                                if(val.isEmpty() || val.equals("NULL")){
                                    val = null;
                                }

//                                System.out.println("k: " + key + " -> " + headerMap.get(key) + " => " + csvRecord.get(key));
                                params.put(key, val);
                            }

//                            System.out.println("Add: " + tag + " +++ " + params.size());
                            sourceFile.addResult(new ErBasicTagParamsObj(tag, params));
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

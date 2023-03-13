package id.mit.chrono.server.parser;

import id.mit.chrono.server.base.BaseFileParser;
import id.mit.chrono.server.iface.FileParser;
import id.mit.chrono.server.obj.HuaweiBasicKeyParamsObj;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class HuaweiCmExportParser2 {

    private File inputFile;
    protected Logger logger = LoggerFactory.getLogger(this.getClass());
    private Map<String, List<HuaweiBasicKeyParamsObj>> groupHwKeyParams;

    public HuaweiCmExportParser2(File inputFile) {
        this.inputFile = inputFile;
    }

    public Map<String, List<HuaweiBasicKeyParamsObj>> parse() {

        List<HuaweiBasicKeyParamsObj> hwKeyParams = new ArrayList<>();

        logger.debug("parsing file: " + inputFile.getName());

        String line, line2, lineTmp;
        String className;

        ArrayList<String> headers = new ArrayList<>();
        ArrayList<String> data = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(this.inputFile))) {

            while ((line = br.readLine()) != null) {

                if (line.isEmpty() || !line.startsWith("className")) {
                    continue;
                }

                line2 = br.readLine();
                if (line2 == null || line2.isEmpty()) {
                    continue;
                }

                while((lineTmp = br.readLine()) != null && !lineTmp.isEmpty()) {
                    line2 += lineTmp;
                }

                CSVParser csvFileParser = new CSVParser(new StringReader(line + "\n" + line2), CSVFormat.RFC4180);
                List<CSVRecord> csvRecords = csvFileParser.getRecords();

                headers.clear();
                data.clear();

                for (CSVRecord record : csvRecords) {

                    // this is the header, just make sure everything is flawless
                    if(record.getRecordNumber() == 1){

                        try{

                            for (int i = 0; i < Integer.MAX_VALUE; i++) {
                                headers.add(record.get(i));
                            }
                        }
                        catch(Exception e){
//                                e.printStackTrace();
                        }
                    }
                    else{

                        for (int i = 0; i < headers.size(); i++) {
                            data.add(record.get(i));
                        }
                    }
                }

                className = null;
                HashMap<String, String> params = new HashMap<>();

                for (int i = 0; i < headers.size(); i++) {

                    if(headers.get(i).isEmpty()){
                        continue;
                    }

                    if(headers.get(i).equals("className")){
                        className = data.get(i);
                        continue;
                    }

                    params.put(headers.get(i), data.get(i));
                }

                if(className != null && params.size() > 0){

                    hwKeyParams.add(new HuaweiBasicKeyParamsObj(className, params));

                }

            }

            this.groupHwKeyParams = hwKeyParams.stream().collect(Collectors.groupingBy(o -> o.command));
//            this.groupHwKeyParams.forEach((key,params) -> {
//                System.out.println("========= KEY: " + key + " =========");
//                params.forEach(item -> {
//                    System.out.println("command: " + item.command);
//                    System.out.println(item.params);
//                    item.params.keySet().toArray();
//                    item.params.values();
//                });
//                System.out.println("=========");
//            });


        } catch (IOException e) {

            logger.debug("parse failed: " + e.getMessage() + inputFile.getName());

            e.printStackTrace();
        }

        return this.groupHwKeyParams;

    }

}

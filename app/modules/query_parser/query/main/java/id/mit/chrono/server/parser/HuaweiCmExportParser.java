package id.mit.chrono.server.parser;

import id.mit.chrono.server.base.BaseFileParser;
import id.mit.chrono.server.iface.FileParser;
import id.mit.chrono.server.obj.HuaweiBasicKeyParamsObj;
import id.mit.chrono.server.obj.SourceFile;
import id.mit.chrono.server.var.Vars;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HuaweiCmExportParser extends BaseFileParser implements FileParser {

    @Override
    protected void parseLocal(){

        prepareBase();

//        this.files.add(new File("/Users/wildan/Projects/Chrono/Test Data/HUAWEI/CMExport_MBSC_Serang_10.173.32.49_2019030104.csv"));
//        this.files.add(new File("/Users/wildan/Projects/Chrono/Test Data/HUAWEI/CMExport_RNC_BuaranMetro1_10.170.3.1_2019030104.csv"));
//        this.files.add(new File("/Users/wildan/Projects/Chrono/Test Data/HUAWEI/CMExport_PBR593IM_LIVINGWORLDPEKANBARUTEL_10.146.247.14_2019031004.csv"));

        if(files.size() == 1){

            String file = this.files.get(0).getAbsolutePath();

            logger.debug("processing: " + file);

//            Pattern cmfMmlPattern = Pattern.compile(Vars.prop.getProperty("id.mit.chrono.server.parser.huawei.cfgmml.patterncmd"));
//            Pattern cfgMmlParamPattern = Pattern.compile(Vars.prop.getProperty("id.mit.chrono.server.parser.huawei.cfgmml.patternparam"));
//            Matcher matcher;

            String line, line2, lineTmp;
            String className;

            ArrayList<String> headers = new ArrayList<String>();
            ArrayList<String> data = new ArrayList<String>();

            try (BufferedReader br = new BufferedReader(new FileReader(new File(file)))) {

                while ((line = br.readLine()) != null) {

//                    System.out.println(line);

                    if(line.isEmpty() || !line.startsWith("className")) {
                        continue;
                    }

                    // try to get next line
                    line2 = br.readLine();
//                    System.out.println(line2);

                    if(line2 == null || line2.isEmpty()){
                        continue;
                    }

                    while ((lineTmp = br.readLine()) != null && !lineTmp.isEmpty()) {
//                        System.out.println(lineTmp);
//                        line2 += "\n" + lineTmp;
                        line2 += lineTmp;
                    }

                    // have to parse manually
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

                    // add to main array
                    HashMap<String, String> params = new HashMap<String, String>();

                    for (int i = 0; i < headers.size(); i++) {

                        if(headers.get(i).isEmpty()){
                            continue;
                        }

                        if(headers.get(i).equals("className")){
                            className = data.get(i);
                            continue;
                        }

                        if(this.sourceFile != null && this.sourceFile.getKey() == null){

                            if(className.matches("^BSC.*(GSM|UMTS)NE$") && headers.get(i).equals("SYSOBJECTID")){
//                                System.out.println("masuk 1");
                                String key = data.get(i);
//                                logger.debug("found key: " + key);
//                                System.out.println("found key: " + key);
                                this.sourceFile.setKey(key);
                            }
                            else if(className.matches("^BTS\\d+NE$") && headers.get(i).equals("IP")){
//                                System.out.println("masuk 2");
                                String key = data.get(i);
//                                logger.debug("found key: " + key);
//                                System.out.println("found key: " + key);
                                this.sourceFile.setKey(key);

                                // add to param also
                                params.put("_KEY_", key);
                            }
                            else if(className.matches("^BSC.*(GSM|UMTS)NE$") && headers.get(i).equals("name")){
//                                System.out.println("masuk 3");
                                String key = data.get(i);
//                                logger.debug("found key: " + key);
//                                System.out.println("found key: " + key);
                                this.sourceFile.setKey(key);
                            }
                            else if(headers.get(i).equals("ENODEBID")){
//                                System.out.println("masuk 4");
                                String key = data.get(i);
//                                logger.debug("found key: " + key);
//                                System.out.println("found key: " + key);
                                this.sourceFile.setKey(key);
                            }
                        }

                        params.put(headers.get(i), data.get(i));
                    }

                    if(className != null && params.size() > 0){

//                        System.out.println("className: " + className);

                        if(this.sourceFile != null && usedSourceGroups.contains(className)){

                            if(className.matches("^BSC\\d+UMTSNODEBIP$")){

                                String filter = null;

                                // first search
                                if(params.containsKey("NBATMOAMIP")){
                                    filter = params.get("NBATMOAMIP").trim();
                                }

                                // second search
                                if(filter.isEmpty() && params.containsKey("NBIPOAMIP")){
                                    filter = params.get("NBIPOAMIP").trim();
                                }

                                if(filter != null && !filter.isEmpty()){
//                                    logger.debug("found new NBOAMIP: "  + filter);


                                    if(this.fileDependencies == null){
                                        this.fileDependencies = "";
                                    }

                                    if(!this.fileDependencies.isEmpty()){
                                        this.fileDependencies += ";";
                                    }

                                    this.fileDependencies += "./^CMExport_.*_" + filter + "_\\d{10}.csv.gz$";
                                }
                            }

                            this.sourceFile.addResult(new HuaweiBasicKeyParamsObj(className, params));
                        }
                    }
                }

                updateFileProcessTime(1, null);
            } catch (Exception e) {
                updateFileProcessTime(3, e.getMessage());
                if(this.sourceFile != null){

                    logger.debug("parse failed: "  + e.getMessage() + ": " + sourceFile.getFilePath());
                }
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args){
        new HuaweiCmExportParser().parseLocal();
    }
}

package id.mit.chrono.server.test;

import id.mit.chrono.server.base.BaseMain;
import id.mit.chrono.server.obj.HuaweiBasicKeyParamsObj;
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

public class WildanTestHuaweiCmExport extends BaseMain {

    String file = "/Users/wildan/Projects/Chrono/Chrono-Server/data/raw/CM_RAN/201805130900/CM_RAN_HW_10.2.160.52/export/home/sysm/opt/oss/server/var/fileint/cm/autoExport/CMExport_JKB519IM_ROXYSQUARE_10.174.14.108_2018051305.csv";

    public WildanTestHuaweiCmExport(){

//        ArrayList<String> files = ArchiveUtils.decompressGZIP(new File(file), new File("data/tmp"));

        ArrayList<String> files = new ArrayList<>();
        if(files.size() == 0){

//            String file = files.get(0);

            Pattern cmfMmlPattern = Pattern.compile(Vars.prop.getProperty("id.mit.chrono.server.parser.huawei.cfgmml.patterncmd"));
            Pattern cfgMmlParamPattern = Pattern.compile(Vars.prop.getProperty("id.mit.chrono.server.parser.huawei.cfgmml.patternparam"));
            Matcher matcher;

            String line, line2, lineTmp;
            String className;

            ArrayList<HuaweiBasicKeyParamsObj> cmExports = new ArrayList<HuaweiBasicKeyParamsObj>();

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

                    if(line2 == null || line2.isEmpty()){
                        continue;
                    }

                    while ((lineTmp = br.readLine()) != null && !lineTmp.isEmpty()) {

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

                                System.out.println("h: " + headers.get(i));
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

                        params.put(headers.get(i), data.get(i));
                    }

                    if(className != null && params.size() > 0){
                        cmExports.add(new HuaweiBasicKeyParamsObj(className, params));
                    }
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            for(HuaweiBasicKeyParamsObj o: cmExports){
                System.out.println(o.command + " -> " + o.params.size());
            }
        }
    }
    public static void main(String[] args){
        new WildanTestHuaweiCmExport();
    }
}

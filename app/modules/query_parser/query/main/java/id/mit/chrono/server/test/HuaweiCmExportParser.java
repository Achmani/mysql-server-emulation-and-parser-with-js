package id.mit.chrono.server.test;

import id.mit.chrono.server.base.BaseFileParser;
import id.mit.chrono.server.obj.HuaweiBasicKeyParamsObj;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class HuaweiCmExportParser extends BaseFileParser {

    protected void parseLocal()  {

        String filePath = this.files.get(0).getPath();

        try {

            File f = new File(filePath);

            BufferedReader b = new BufferedReader(new FileReader(f));

            String readLine = "";

            ArrayList<HuaweiBasicKeyParamsObj> cmExportObj = new ArrayList<HuaweiBasicKeyParamsObj>();

            String prefixHeader = "className";

            String headerAndData = null;

            while ((readLine = b.readLine()) != null) {

                headerAndData = null;

                if(readLine != null && readLine.startsWith(prefixHeader)){

                    //System.out.println("Key ===> " + readLine);
                    headerAndData = readLine;

                    readLine = b.readLine();

                    if(readLine != null && !readLine.isEmpty()){

                        //System.out.println("Values ===> " + readLine);
                        headerAndData += "\n" + readLine;

                        // parse header and row
                        CSVParser parser = CSVParser.parse(headerAndData, CSVFormat.RFC4180.withFirstRecordAsHeader());

                        Map<String, Integer> headerMap = parser.getHeaderMap();

                        HashMap<String, String> params = new HashMap<String, String>();

                        for (CSVRecord csvRecord : parser) {

                            for(String key: headerMap.keySet()){

                                if(key.isEmpty()){
                                    continue;
                                }

//                                System.out.println("k: " + key + " -> " + headerMap.get(key) + " => " + csvRecord.get(key));
                                params.put(key, csvRecord.get(key));

                                cmExportObj.add(new HuaweiBasicKeyParamsObj(prefixHeader, params) );
                            }
                        }

//                        for (int i = 0; i < cmExportObj.size(); i++) {
//                            System.out.println(cmExportObj.get(i));
//                        }

                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
//    public static void main(String [] args){
        
//        new HuaweiCmExportParser("/Users/heru/Projects/Chrono/CFG_MML_HUAWEI/CMExport_BKS058MM_KLABANGILIR_10.168.92.170_2018050205_edit.csv");

//    }

}

    



package id.mit.chrono.server.parser;

import id.mit.chrono.server.base.BaseFileParser;
import id.mit.chrono.server.iface.FileParser;
import id.mit.chrono.server.obj.HuaweiBasicKeyParamsObj;
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
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HuaweiInventoryBoardParser extends BaseFileParser implements FileParser {

    @Override
    protected void parseLocal(){

        prepareBase();

        if(files.size() == 1){

            String file = this.files.get(0).getAbsolutePath();

            logger.debug("processing: " + file);

            this.sourceFile.setKey("DIM_BTS3900_Board.csv");

            try {
                Reader reader = Files.newBufferedReader(Paths.get(file));
                CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT
                        .withFirstRecordAsHeader()
                        .withIgnoreHeaderCase()
                        .withTrim());

                Set<String> headers = csvParser.getHeaderMap().keySet();

                for (CSVRecord csvRecord : csvParser) {
                    // Accessing values by the names assigned to each column
//                    String NEType = csvRecord.get("NEType");
//                    String NEFdn = csvRecord.get("NEFdn");
//                    String NEName = csvRecord.get("NEName");
//                    String Name = csvRecord.get("Board Name");


//                    System.out.println("Record No - " + csvRecord.getRecordNumber());
//                    System.out.println("---------------");
//                    System.out.println("NEType : " + NEType);
//                    System.out.println("NEFdn : " + NEFdn);
//                    System.out.println("NEName : " + NEName);
//                    System.out.println("Name : " + Name);
//                    System.out.println("---------------\n\n");

                    HashMap<String, String> params = new HashMap<String, String>();

                    for(String header: headers){
                        params.put(header, csvRecord.get(header));
                    }

                    this.sourceFile.addResult(new HuaweiBasicKeyParamsObj("Inventory_Board", params));
                }

                updateFileProcessTime(1, null);
            }
            catch (IOException e) {
             e.printStackTrace();
            }
        }
    }
}

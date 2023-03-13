package id.mit.chrono.server.parser;

import id.mit.chrono.server.base.BaseFileParser;
import id.mit.chrono.server.iface.FileParser;
import id.mit.chrono.server.obj.HuaweiBasicKeyParamsObj;
import id.mit.chrono.server.obj.SourceFile;
import id.mit.chrono.server.obj.StyloBasicKeyParamsObj;
import id.mit.chrono.server.var.Vars;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.jooq.tools.csv.CSVReader;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StyloCsvParser extends BaseFileParser implements FileParser {

    @Override
    protected void parseLocal(){

        prepareBase();

//        this.sourceFile = new SourceFile(0L, 0, null, 0, null);
//        this.files.add(new File("/Users/wildan/Projects/Chrono/Compare_Data/Stylo20190320/DAILYSYSINFO/20190403/DailySysinfo2G_030419.csv"));

        if(files.size() == 1){

            String file = this.files.get(0).getAbsolutePath();

            logger.debug("processing: " + file);

            Pattern cmfMmlPattern = Pattern.compile(Vars.prop.getProperty("id.mit.chrono.server.parser.huawei.cfgmml.patterncmd"));
            Pattern cfgMmlParamPattern = Pattern.compile(Vars.prop.getProperty("id.mit.chrono.server.parser.huawei.cfgmml.patternparam"));
            Matcher matcher;

            ArrayList<String> headers = new ArrayList<String>();
            ArrayList<String> data = new ArrayList<String>();

            try {
                Reader reader = Files.newBufferedReader(Paths.get(file));
                CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT
                        .withFirstRecordAsHeader()
                        .withIgnoreHeaderCase()
                        .withTrim());

                Object[] heads  = csvParser.getHeaderMap().keySet().toArray();

//                System.out.println("heads.length: " + heads.length);
                for(Object s: heads){

                    if(s.toString().equals("BSCID LAC CI")){

                        this.sourceFile.setKey("STYLO_2G");
                        break;
                    }
                    else if(s.toString().equals("RNCID LAC CI")){

                        this.sourceFile.setKey("STYLO_3G");
                        break;
                    }
                    else if(s.toString().equals("RNCID LAC CI")){

                        this.sourceFile.setKey("STYLO_4G");
                        break;
                    }
                }

                for (CSVRecord csvRecord : csvParser) {

                    HashMap<String, String> params = new HashMap<String, String>();

                    for (int i = 0; i < heads.length; i++) {
                        params.put(heads[i].toString(), csvRecord.get(heads[i].toString()));
                    }

                    updateFileProcessTime(1, null);

                    this.sourceFile.addResult(new StyloBasicKeyParamsObj("STYLO_ROW", params));
                }
            }
            catch(IOException e){

                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args){
        new StyloCsvParser().parseLocal();
    }
}

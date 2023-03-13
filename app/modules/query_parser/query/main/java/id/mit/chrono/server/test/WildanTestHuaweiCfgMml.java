package id.mit.chrono.server.test;

import id.mit.chrono.server.base.BaseMain;
import id.mit.chrono.server.obj.HuaweiBasicKeyParamsObj;
import id.mit.chrono.server.util.ArchiveUtils;
import id.mit.chrono.server.var.Vars;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WildanTestHuaweiCfgMml extends BaseMain {

    String file = "/Users/wildan/Projects/Chrono/Chrono-Server/data/raw/CM_RAN/201805120900/CM_RAN_HW_10.2.160.182/export/home/webapp/log/20180512_CFGMML/Regional_1_CFGMML_MBSC_Binjai_20180512.zip";

    public WildanTestHuaweiCfgMml(){

        ArrayList<String> files = ArchiveUtils.extractZip(new File(file), new File("data/tmp"));
        if(files.size() == 1){

            String file = files.get(0);

            Pattern cmfMmlPattern = Pattern.compile(Vars.prop.getProperty("id.mit.chrono.server.parser.huawei.cfgmml.patterncmd"));
            Pattern cfgMmlParamPattern = Pattern.compile(Vars.prop.getProperty("id.mit.chrono.server.parser.huawei.cfgmml.patternparam"));
            Matcher matcher;

            String line;
            String command, params;
            String paramName, paramVal;

            ArrayList<HuaweiBasicKeyParamsObj> mmls = new ArrayList<HuaweiBasicKeyParamsObj>();

            try (BufferedReader br = new BufferedReader(new FileReader(new File(file)))) {

                while ((line = br.readLine()) != null) {

//                    System.out.println(line);

                    matcher = cmfMmlPattern.matcher(line);

                    if(matcher.find()){

                        command = matcher.group(1);
                        params = matcher.group(2);

                        matcher = cfgMmlParamPattern.matcher(params);

                        HashMap<String, String> tempParam = new HashMap<>();

                        while(matcher.find()){

                            paramName = matcher.group(1);
                            paramVal = matcher.group(2);

                            tempParam.put(paramName, paramVal);
                        }

                        HuaweiBasicKeyParamsObj o = new HuaweiBasicKeyParamsObj(command, tempParam);

                        mmls.add(o);
                    }
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            ArrayList<String> printedMmls = new ArrayList<String>();

            ArrayList<HuaweiBasicKeyParamsObj> mmlBsc = new ArrayList<HuaweiBasicKeyParamsObj>();
            ArrayList<HuaweiBasicKeyParamsObj> mmlBts = new ArrayList<HuaweiBasicKeyParamsObj>();
            ArrayList<HuaweiBasicKeyParamsObj> mmlCell = new ArrayList<HuaweiBasicKeyParamsObj>();
            ArrayList<HuaweiBasicKeyParamsObj> mmlGtrx = new ArrayList<HuaweiBasicKeyParamsObj>();
            ArrayList<HuaweiBasicKeyParamsObj> mmlGtrxChan = new ArrayList<HuaweiBasicKeyParamsObj>();
            ArrayList<HuaweiBasicKeyParamsObj> mmlElse = new ArrayList<HuaweiBasicKeyParamsObj>();

            for(HuaweiBasicKeyParamsObj o: mmls){

                if(printedMmls.contains(o.command)){
                    continue;
                }

                // BSC
                if(!o.params.containsKey("BTSID") && !o.params.containsKey("CELLID") && !o.params.containsKey("TRXID") && !o.params.containsKey("CHNO")){
                    mmlBsc.add(o);
                }
                else if(o.params.containsKey("BTSID") && !o.params.containsKey("CELLID")){
                    mmlBts.add(o);
                }
                else if(o.params.containsKey("CELLID") && !o.params.containsKey("TRXID")){
                    mmlCell.add(o);
                }
                else if(o.params.containsKey("TRXID") && !o.params.containsKey("CHNO")){
                    mmlGtrx.add(o);
                }
                else if(o.params.containsKey("CHNO")){
                    mmlGtrxChan.add(o);
                }else{
                    mmlElse.add(o);
                }

                printedMmls.add(o.command);
            }

            // print BSC related
            System.out.println("\nBSC Level");
            for(HuaweiBasicKeyParamsObj o: mmlBsc){
                System.out.println(o.command);
            }

            // print bts related
            System.out.println("\nBTS Level");
            for(HuaweiBasicKeyParamsObj o: mmlBts){
                System.out.println(o.command);
            }

            // print cell related
            System.out.println("\nCell Level");
            for(HuaweiBasicKeyParamsObj o: mmlCell){
                System.out.println(o.command);
            }

            // print trx related
            System.out.println("\nTRX Level");
            for(HuaweiBasicKeyParamsObj o: mmlGtrx){
                System.out.println(o.command);
            }

            // TS/Channel related
            System.out.println("\nTS Level");
            for(HuaweiBasicKeyParamsObj o: mmlGtrxChan){
                System.out.println(o.command);
            }

            // Else
            System.out.println("\nElse");
            for(HuaweiBasicKeyParamsObj o: mmlElse){
                System.out.println(o.command);
            }

        }
    }
    public static void main(String[] args){
        new WildanTestHuaweiCfgMml();
    }
}

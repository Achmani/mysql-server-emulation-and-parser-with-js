package id.mit.chrono.server.test;

import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;

import java.io.StringWriter;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class StringTest {

    public static void main(String[] args) {


//        String a = "10;10";
//
//        System.out.println(a.split(";")[0]);


//        System.out.println("TI2526B".matches(".*([A-Z]{2})[0-9]{1}([0-9]{3}).*"));

        String data = "{2}";
        data = data.substring(1, data.length()-1);
        System.out.println(data);

        String s = "nptq_cna_export_ran1.zip";
        System.out.println(s.matches("^nptq_cna_export_ran\\d.zip"));

//
//        HashMap<String, String> fields = new HashMap<>();
//        int col = 0;
//
//        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
//        Date epochTime = new Date();
//
//        String yyyyMMdd = formatter.format(epochTime);
//        System.out.println("yyyyMMdd: " + yyyyMMdd);
//
//        StringWriter swOut = new StringWriter();
//
//        VelocityContext context = new VelocityContext();
//        context.put("yyyyMMdd", yyyyMMdd);
//
//        String templateStr = "DailySysinfo_${yyyyMMdd}_2G.csv";
//        Velocity.evaluate( context, swOut, "log tag name", templateStr);
//
//        System.out.println("generating file: " + swOut.toString());

//        System.out.println("SDR-nb_radio-v12.18.30-Subnetwork_2006&2005-20190319042751-228.zip".matches("^SDR-fdd_radio.*[.]zip$|^SDR-tdd_radio.*[.]zip$|^SDR-nb_radio.*[.]zip$"));

//        String s1 = "bulkCmConfigDataFile.configData.xn:SubNetwork.xn:SubNetwork.xn:MeContext.xn:VsDataContainer.xn:attributes.es:vsDataMeContext.xxxx";
//        String s2 = "bulkCmConfigDataFile.configData.xn:SubNetwork.xn:SubNetwork.xn:MeContext.xn:VsDataContainer.xn:attributes.es:vsDataMeContext.";
//
//        System.out.println(s1.startsWith(s2));


//        String text = "subnetwork=\"AXE\",bsc=\"BVBKG1\",site=\"E_BKG137GPASATI\",ru=\"G12-TG-12\",ru=\"MCTR RUS 01 B0                0\"        RU2     MCTR RUS 01 B0                0 CB4N398430      KRC 118 63/1          R2A       C:0 R:- SH:-- SL:---    G12     RXOCF-12              MCTR RUS 01 B0                0";
//        System.out.println(text.substring(0, (text.lastIndexOf("\"") + 1)));

//        fields.put("col" + (col++), text.substring(0, (text.lastIndexOf("\"") + 1)));
//        fields.put("col" + (col++), text.substring((text.lastIndexOf("\"") + 1), text.length() - 1));
//
//        String temp []= (text.substring((text.lastIndexOf("\"") + 1), text.length() - 1)).split("( ){2,}");
////        String temp []= text.split("( ){2,}");
//
//        for (int i = 0; i < temp.length; i++) {
//            System.out.println(temp[i]);
//        }


//        Pattern pattern = Pattern.compile("(?<=subnetwork=\"|bsc=\"|site=\"|ru=\")([A-Za-z0-9-_ ]+)");
//        Pattern pattern2 = Pattern.compile("(?<=site=\")([A-Za-z0-9-_ ]+)");
//        Matcher matcher = pattern.matcher(text);
//        Matcher matcher2 = pattern2.matcher(text);
////                    System.out.println("==== "+matcher.group(0));
////                    System.out.println("==== "+matcher.group(1));
////                    System.out.println("==== "+matcher.group(2));
//        if (matcher.find()) {
//            System.out.println(matcher.group(0));
//        }
//
//        while(matcher.find()) {
//            System.out.println(matcher.group());
//
//
//
//        }


//        System.out.println(Integer.parseInt("01"));
//        System.out.println(Integer.valueOf("0001"));


//        String inventoriesUnit = "PLMN-PLMN/BSC-244141/BCF-101/HW-1/SUBRACK-1/UNIT-FXEB_0_2";
//
//        String tempDistName = inventoriesUnit.substring(0,inventoriesUnit.lastIndexOf("/"));
//
//        String[] splitTempDistName = tempDistName.split("/");
//
//        for (int j = 0; j < splitTempDistName.length - 1; j++) {
//
//            int posLi = tempDistName.lastIndexOf("/");
//
//            String filterClass = tempDistName.substring(0, posLi);
//
//            int posStrip = tempDistName.lastIndexOf("-");
//
//            String filterKey = tempDistName.substring(posLi + 1, posStrip);
//
//            System.out.println("distName : " + tempDistName);
//            System.out.println("filterKey : " + filterKey);
//
//            tempDistName = filterClass;
//
//        }
//
//        System.out.println(test.matches("Regional_\\d+_CFGMML_.*_\\d{8}.zip"));
//
//        System.out.println(Integer.parseInt("0001111111100000000010100000010000001111", 10));


//        System.out.println("SBTS-267116.xml.gz".matches("^SBTS[-]\\d+[.]xml[.]gz$"));

//        String neName = "N_WNG713MM_GUNUNGANWONOGIRI";
////        System.out.println(neName.substring(1,2));
//
//        if (neName.substring(1,2).equalsIgnoreCase("_")) {
//            System.out.println("masuk");
//            neName = neName.substring(2);
////            System.out.println(neName.substring(2));
//        }
//
//
//        neName =  neName.substring(0,6);
////        System.out.printlneNamea.charAt(1));
////        System.out.println(neName);
//
////        System.out.println(new Date());
//
//        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
//        System.out.println(timestamp);

//
//        HashMap<String, Integer> cobaHashMap = new HashMap<String, Integer>();
//
//
//        cobaHashMap.put("test1", 1);
//        cobaHashMap.put("test2", 2);
//        cobaHashMap.put("test3", 3);
//        cobaHashMap.put("test4", 4);
//        cobaHashMap.put("test5", 5);


//        System.out.println(cobaHashMap.get("testsdf5"));


//        for ( Map.Entry r : cobaHashMap.entrySet()) {
//            System.out.println(r.getValue());
//        }


    }
}

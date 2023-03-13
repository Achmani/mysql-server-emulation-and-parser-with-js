package id.mit.chrono.server.test;

import id.mit.chrono.server.database.DatabaseHelper;
import id.mit.chrono.server.factory.DaoFactory;
import id.mit.chrono.server.obj.CosineSimilarity;
import id.mit.chrono.server.util.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.jooq.DSLContext;
import oshi.SystemInfo;
import oshi.hardware.HardwareAbstractionLayer;
import oshi.software.os.OperatingSystem;
import oshi.util.FormatUtil;

import java.io.*;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.regex.Pattern;

public class Test {

    public static void main(String[] args){

        SystemInfo si = new SystemInfo();
        OperatingSystem os = si.getOperatingSystem();
        System.out.println(os);
        HardwareAbstractionLayer hal = si.getHardware();
        System.out.println(hal.getProcessor().getPhysicalProcessorCount() + " CPU(s):");
//        for(Processor cpu : hal.getProcessor().get) {
//            System.out.println(" " + cpu);
//        }
        System.out.println("Memory: " +
                FormatUtil.formatBytes(hal.getMemory().getAvailable()) + "/" +
                FormatUtil.formatBytes(hal.getMemory().getTotal()));

        long currentTime = System.currentTimeMillis() / 1000;

        String tg = "202102150900";
        System.out.println(tg.substring(0, tg.length()-4));


        String fileName = "/storage/hahaha/AbisLink.csv.1613471333820";
        System.out.println(fileName);

        String fileNameTrim = fileName.substring(fileName.lastIndexOf("/")+1);
        System.out.println(fileNameTrim);

        String cut = fileNameTrim.substring(fileNameTrim.lastIndexOf(".")+1);
        System.out.println(StringUtils.isNumeric(cut));
        System.out.println(cut);

        if (StringUtils.isNumeric(cut)) {
            fileNameTrim = fileNameTrim.substring(0, fileNameTrim.lastIndexOf("."));
        }

        System.out.println(fileNameTrim);

        System.out.println(System.getProperty("java.ext.dirs"));

        double t = -0.00082;
        String ts = String.valueOf(t);
        System.out.println(ts);

        Object s = "-2.5486237";
        BigDecimal bd = new BigDecimal(s.toString());

        System.out.println(String.format("%.6f", Double.parseDouble(s.toString())));
        System.out.println("bd: " + bd.toPlainString());

        CosineSimilarity cosine = new CosineSimilarity();
        System.out.println("score: " + cosine.score("ECellEquipmentFunction", "ECellEquipmentFunctionId"));
        System.out.println("score: " + cosine.score("ECellEquipmentFunction", "ECellEquipFuncTDDLTE"));
        System.out.println("score: " + cosine.score("ECellEquipmentFunction", "AdjacentUtranFreqFDD"));
        System.out.println("score: " + cosine.score("ECellEquipmentFunction", "CA"));
        System.out.println("score: " + cosine.score("ECellEquipmentFunction", "CDMA2000Reselection"));

//        String[] cols = "ManagedElementType,SubNetwork,ManagedElement,ldn,moId,userLabel,interRatCfgNo,filterCoeff,gsmFilterCoeff,eventNum,eventId,thresh,w,threshSys,hysteresis,trigTime".toLowerCase().split(",");
//        System.out.println(Arrays.asList(cols).contains("subnetwork"));

//        File[] files = {
//          new File("../production/data/tmp"),
//          new File("../production/data/tmp2"),
//          new File("../production/data/tmp3")
//        };
//
//        for (int i = 0; i < files.length; i++) {
//            rmdir2(files[i]);
//        }

//        File baseFile = new File("../production/data/tmp/");
//        rmdir2(baseFile);

//        File file = new File("/storage/chrono/app/collector/development/baseline_update.txt");

//        String line;
//        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
//
//            while ((line = br.readLine()) != null) {
//
//                System.out.println("Executing: " + line);
//
////                DaoFactory.createSiteDaoImpl().up
//                DaoFactory.createSiteDaoImpl().runSQL(line);
//
//            }
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        String strExclude = "AUTOBAKDATA;SYSAUTOBAKDATA";
        String fName = "/export/home/sysm/ftproot/BTS3900/Data/14308993/AUTOBAKDATA20210407030008";
        String c = fName.replaceAll("[^A-z]", "");

        System.out.println(fName.replaceAll("[^A-z]", ""));
        System.out.println(fName.substring(fName.lastIndexOf("/")));
        System.out.println(c);

        if (strExclude.contains(fName.replaceAll("[^A-z]", ""))) {
            System.out.println("contains!");
        }

        String sTest = "LogicalNodeName=KIS493ML,ProductName=RBS6601L";
        Pattern p = Pattern.compile("ProductName=.*");

        File file = new File(System.getProperty("user.dir"));
        System.out.println(file.getAbsolutePath());

    }

    protected void rmdir(File toDelete) {

        if (toDelete != null) {

            // check if directory has file inside
            if (toDelete.listFiles() != null && toDelete.listFiles().length > 0) {

                // remove them
                Arrays.stream(toDelete.listFiles()).forEach(file -> {

                    // if directory, then remove using FileUtils.
                    if (file.isDirectory()) {
                        FileUtils.removeDirectory(file);
                    }

                    file.delete();
                });
            }

            // finally remove tempDir itself.
            toDelete.delete();

        }
    }

    private static void rmdir2(File toDelete) {

        System.out.println("removing: "+toDelete.getAbsolutePath());

        if (toDelete != null) {

            File[] allContent = toDelete.listFiles();
            if (allContent != null) {

                for (File file: allContent) {
                    rmdir2(file);
                }

            }

            if (toDelete.isDirectory()) {
                FileUtils.removeDirectory(toDelete);
            } else {
                toDelete.delete();
            }

        }

    }
}

package id.mit.chrono.server.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import oshi.hardware.HardwareAbstractionLayer;
import oshi.software.os.OperatingSystem;
import oshi.util.FormatUtil;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.DecimalFormat;

public class SystemUtils {

    protected Logger logger = LoggerFactory.getLogger(this.getClass());

    public static void logSystemInfo(Logger logger){

        oshi.SystemInfo si = new oshi.SystemInfo();

        try{

            OperatingSystem os = si.getOperatingSystem();
            logger.info("OS: " + os);
        }
        catch(Exception e){
            logger.debug("failed to get os info");
//            e.printStackTrace();
        }

        try{

            HardwareAbstractionLayer hal = si.getHardware();
            logger.info("CPU: " + hal.getProcessor().getPhysicalPackageCount() + " x " + hal.getProcessor().getName());
            logger.info("CPU Load: " + new DecimalFormat(".##").format(hal.getProcessor().getSystemLoadAverage()) + " %");

            logger.info("Memory: " +
                    FormatUtil.formatBytes(hal.getMemory().getAvailable()) + " free of " +
                    FormatUtil.formatBytes(hal.getMemory().getTotal()) + " total");
        }
        catch(Exception e){
            logger.debug("failed to hardware info");
//            e.printStackTrace();
        }
    }

    public static String executeCli(String command){

        StringBuffer output = new StringBuffer();

        Process p;
        try {

            p = Runtime.getRuntime().exec(command);
            p.waitFor();
            BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));

            String line = "";
            while ((line = reader.readLine())!= null) {

                if(output.length() != 0){
                    output.append("\n");
                }

                output.append(line);
            }

            return output.toString();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}

package id.mit.chrono.server.util;

import com.google.common.base.Stopwatch;
import org.apache.commons.lang3.StringUtils;

public class FaultUtils {


    public static void main(String[] args) {

        Stopwatch stopwatch = Stopwatch.createStarted();

        long neId = 352530;
        long logSerialNumber = 37806326;

        System.out.println("neId: " + neId);
        System.out.println("neId: " + StringUtils.leftPad(Long.toBinaryString(neId), 64, '0'));

        System.out.println("logSerialNumber: " + logSerialNumber);
        System.out.println("logSerialNumber: " + StringUtils.leftPad(Long.toBinaryString(logSerialNumber), 64, '0'));

        long faultId = 0L;

        faultId = neId << 40 ;
        faultId |= logSerialNumber;

        System.out.println("faultId: " + faultId);
        System.out.println("faultId: " + StringUtils.leftPad(Long.toBinaryString(faultId), 64, '0'));

        // try to retrieve back
        long faultIdRetrieve = faultId >> 40;
        long logSerialNumberRetrieve = faultId << 24 >> 24;

        System.out.println("faultIdRetrieve: " + faultIdRetrieve);
        System.out.println("logSerialNumberRetrieve: " + logSerialNumberRetrieve);

        System.out.println("End: " + stopwatch.elapsed().getNano() + " ns");
        System.out.println("End: " + stopwatch.elapsed().getSeconds() + " s");
    }

}

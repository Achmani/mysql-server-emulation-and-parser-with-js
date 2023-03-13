package id.mit.chrono.server.util;

import java.util.Calendar;

public class EpochUtils {

    public static boolean isSameDay(long epoch1, long epoch2){
        Calendar cal1 = Calendar.getInstance();
        Calendar cal2 = Calendar.getInstance();
        cal1.setTimeInMillis(epoch1 * 1000);
        cal2.setTimeInMillis(epoch2 * 1000);
        return cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR) && cal1.get(Calendar.DAY_OF_YEAR) == cal2.get(Calendar.DAY_OF_YEAR);
    }
}

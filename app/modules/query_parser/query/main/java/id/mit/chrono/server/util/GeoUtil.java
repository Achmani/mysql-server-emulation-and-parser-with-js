package id.mit.chrono.server.util;

import org.apache.commons.lang3.StringUtils;

import java.text.DecimalFormat;

public class GeoUtil {

    static{

        DecimalFormat numberFormat = new DecimalFormat("#.000000");
    }

	public static double getHuawei2GLat(String ns, String latInt, String latDec){

		String str = "";

		if(ns.equals("S") || ns.contains("South")){
			str += "-";
		}

		str += latInt;
		str += "." + latDec;

		return Double.parseDouble(str);
	}

	public static double getHuawei2GLon(String ns, String lonInt, String lonDec){

		String str = "";

		if(ns.equals("W") || ns.contains("West")){
			str += "-";
		}

		str += lonInt;
		str += "." + lonDec;

		return Double.parseDouble(str);
	}

	public static double getHuawei3GLat(String lat){

        String data = lat;

//        if(lat.length() < 7){
//
//            System.out.println("lat >> " + lat);
//
//            data = StringUtils.rightPad(lat, 7, '0');
//        }

		double res;

		try{
			res = Math.round(Double.parseDouble(data) * 0.000001 * 1000000.0)/1000000.0;
		}
		catch(Exception e){
			res = 0d;
//			e.printStackTrace();
		}

		return res;
	}

	public static double getHuawei3GLon(String lon){

        String data = lon;

//        if(lon.length() < 9){
//
//            System.out.println("lon >> " + lon);
//
//            data = StringUtils.rightPad(lon, 9, '0');
//        }

		double res;

		try{
			res = Math.round(Double.parseDouble(data) * 0.000001 * 1000000.0)/1000000.0;
		}
		catch(Exception e){
			res = 0d;
//			e.printStackTrace();
		}

		return res;
	}

	public static double getNokia2GLat(String lat){

		String data = lat;

		double res;

		try{
			res = Math.round(Double.parseDouble(data) * 0.0000001 * 1000000.0)/1000000.0;
		}
		catch(Exception e){
			res = 0d;
		}

		return res;
	}

	public static double getNokia2GLon(String lon){

		String data = lon;

		double res;

		try{
			res = Math.round(Double.parseDouble(data) * 0.0000001 * 1000000.0)/1000000.0;
		}
		catch(Exception e){
			res = 0d;
		}

		return res;
	}

	public static double getDecimalCoordinate(int hour, int minute, double second){
		return new Double(hour+((minute*60)+second)/3600);
	}
	
	public static double getDistance(double lat1, double lon1, double lat2, double lon2,char unit) {
		double theta = lon1 - lon2;
		double dist = Math.sin(deg2rad(lat1)) * Math.sin(deg2rad(lat2))
				+ Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2))
				* Math.cos(deg2rad(theta));
		dist = Math.acos(dist);
		dist = rad2deg(dist);
		dist = dist * 60 * 1.1515;
		if (unit == 'K') {
			dist = dist * 1.609344;
		} else if (unit == 'N') {
			dist = dist * 0.8684;
		}
		return (dist);
	}

	/* ::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::: */
	/* :: This function converts decimal degrees to radians : */
	/* ::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::: */
	private static double deg2rad(double deg) {
		return (deg * Math.PI / 180.0);
	}

	/* ::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::: */
	/* :: This function converts radians to decimal degrees : */
	/* ::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::: */
	private static double rad2deg(double rad) {
		return (rad * 180.0 / Math.PI);
	}
	
	public static double[] getRotatedPoint(double x, double y, double deg){
		double[] ret = new double[2];
		
		double xResult = x*Math.cos(deg) - y*Math.sin(deg);
		double yResult = x*Math.sin(deg) + y*Math.cos(deg);
		
		
		ret[0] = yResult;
		ret[1] = xResult;
		
		return ret;
	}
	
	public static void main(String args[]){
//		System.out.println(GeoUtil.getDistance(-7.285339, 112.664018, -7.2883871062110215, 112.71449387019585, 'K'));
		
		double[] result = GeoUtil.getRotatedPoint(5, 0, 90);
		System.out.println("" + result[0] + ", " + result[1]);
		System.out.println("" + Math.cos(deg2rad(180)));
	}
	
}

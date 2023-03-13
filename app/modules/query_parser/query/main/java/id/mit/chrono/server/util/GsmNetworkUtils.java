package id.mit.chrono.server.util;

import org.apache.commons.lang3.StringUtils;

public class GsmNetworkUtils {

    public static final int getNrNci(String gnodebId, String cellId){

        return GsmNetworkUtils.getNrNci(Integer.parseInt(gnodebId), Integer.parseInt(cellId));
    }

    public static final int getNrNci(int gnodebId, int cellId){

        int eci = 0;

        System.out.println("gnodebId: " + gnodebId);
        System.out.println("cellId: " + cellId);

        String gnodebIdBinString = StringUtils.leftPad(Integer.toBinaryString(gnodebId), 20, '0');
        String cellIdBinString = StringUtils.leftPad(Integer.toBinaryString(cellId), 8, '0');
        String eciBinString = gnodebIdBinString + cellIdBinString;

        eci = Integer.parseInt(eciBinString, 2);

        return eci;
    }

    public static final int getLteEci(String enodebId, String cellId){

        return GsmNetworkUtils.getLteEci(Integer.parseInt(enodebId), Integer.parseInt(cellId));
    }

    public static final int getLteEci(int enodebId, int cellId){

        int eci = 0;

        String enodebIdBinString = StringUtils.leftPad(Integer.toBinaryString(enodebId), 20, '0');
        String cellIdBinString = StringUtils.leftPad(Integer.toBinaryString(cellId), 8, '0');
        String eciBinString = enodebIdBinString + cellIdBinString;

        eci = Integer.parseInt(eciBinString, 2);

//        System.out.println("enodeId: " + enodebId);
//        System.out.println("enodebIdBinString: " + enodebIdBinString);
//
//        System.out.println("cellId: " + cellId);
//        System.out.println("cellIdBinString: " + cellIdBinString);

//        System.out.println("eciBiniString: " + eciBiniString);
//        System.out.println("eci: " + eci);

        return eci;
    }

    public static final long getLteTai(String mcc, String mnc, String tac){

        if(mcc == null || mnc == null || tac == null){
            return 0L;
        }

        return GsmNetworkUtils.getLteTai(Integer.parseInt(mcc), Integer.parseInt(mnc), Integer.parseInt(tac));
    }

    public static final long getLteTai(int mcc, int mnc, int tac){

        long tai = 0;

        String mccBinString = StringUtils.leftPad(Integer.toBinaryString(mcc), 12, '0');
        String mncBinString = StringUtils.leftPad(Integer.toBinaryString(mnc), 12, '0');

        String tacBinString = StringUtils.leftPad(Integer.toBinaryString(tac), 16, '0');
        String taiBinString = mccBinString + mncBinString + tacBinString;

        tai = Long.parseLong(taiBinString, 2);

//        System.out.println("mcc: " + mcc);
//        System.out.println("mcc: " + mccBinString);

//        System.out.println("mnc: " + mnc);
//        System.out.println("mncBinString: " + mncBinString);

//        System.out.println("tac: " + tac);
//        System.out.println("tacBinString: " + tacBinString);

//        System.out.println("taiBinString: " + taiBinString);
//        System.out.println("tai: " + tai);

        return tai;
    }


    public static void main(String[] args){

        new GsmNetworkUtils().getLteEci(162015, 14);

        new GsmNetworkUtils().getLteEci(126015, 14);
    }

}

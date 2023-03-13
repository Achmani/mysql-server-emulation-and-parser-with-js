package id.mit.chrono.server.util;

import id.mit.chrono.server.model.tables.Crcell;
import id.mit.chrono.server.model.tables.Crnode;
import id.mit.chrono.server.model.tables.Hwucell;
import id.mit.chrono.server.model.tables.Nokgcell;
import id.mit.chrono.server.model.tables.records.*;
import id.mit.chrono.server.obj.CellFreqResult;

public class CellUtils {

    public static CrcellRecord getCellProto(Object cellObj, CrnodeRecord node, String helper){

        return null;
    }

    public static CrcellRecord getCellProto(Object cellObj, CrnodeRecord node){

        if(cellObj instanceof HwgcellRecord){

            HwgcellRecord cell = (HwgcellRecord) cellObj;

            CrcellRecord cr = new CrcellRecord();

            cr.setCellSiteinfo(cell.getCellname());

            // replace with information from node
            if(node != null){
                cr.setCellSiteinfo(node.getNodeCode());
            }

            if(cell.getLatitude() != null){
                cr.setCellLatitude(Double.parseDouble(cell.getLatitude()));
            }

            if(cell.getLongitude() != null){
                cr.setCellLongitude(Double.parseDouble(cell.getLongitude()));
            }

            return cr;
        }
        else if(cellObj instanceof NokgcellRecord){

            NokgcellRecord cell = (NokgcellRecord) cellObj;

            CrcellRecord cr = new CrcellRecord();

            cr.setCellSiteinfo(cell.getName());

            // replace with information from node
            if(node != null){
                cr.setCellSiteinfo(node.getNodeCode());
            }

            if(cell.getLatitude() != null){
                cr.setCellLatitude(Double.parseDouble(cell.getLatitude().toString()));
            }

            if(cell.getLongitude() != null){
                cr.setCellLongitude(Double.parseDouble(cell.getLongitude().toString()));
            }

            return cr;

        }
        else if(cellObj instanceof NokucellRecord){

            NokucellRecord cell = (NokucellRecord) cellObj;

            CrcellRecord cr = new CrcellRecord();

            cr.setCellSiteinfo(cell.getName());

            // replace with information from node
            if(node != null){
                cr.setCellSiteinfo(node.getNodeCode());
            }

            if(cell.getLatitude() != null){
                cr.setCellLatitude(Double.parseDouble(cell.getLatitude().toString()));
            }

            if(cell.getLongitude() != null){
                cr.setCellLongitude(Double.parseDouble(cell.getLongitude().toString()));
            }

            return cr;

        }
        else if(cellObj instanceof NoklcellRecord){

            NoklcellRecord cell = (NoklcellRecord) cellObj;

            CrcellRecord cr = new CrcellRecord();

            cr.setCellSiteinfo(cell.getName());

            // replace with information from node
            if(node != null){
                cr.setCellSiteinfo(node.getNodeCode());
            }

            if(cell.getLatitude() != null){
                cr.setCellLatitude(Double.parseDouble(cell.getLatitude().toString()));
            }

            if(cell.getLongitude() != null){
                cr.setCellLongitude(Double.parseDouble(cell.getLongitude().toString()));
            }

            return cr;
        }
        else if(cellObj instanceof ZtegcellRecord){

            ZtegcellRecord cell = (ZtegcellRecord) cellObj;

            CrcellRecord cr = new CrcellRecord();

            cr.setCellSiteinfo(cell.getUserlabel());

            // replace with information from node
            if(node != null){
                cr.setCellSiteinfo(node.getNodeCode());
            }

            if(cell.getLatitude() != null){
                cr.setCellLatitude(cell.getLatitude());
            }

            if(cell.getLongitude() != null){
                cr.setCellLongitude(cell.getLongitude());
            }

            return cr;

        }
        else if(cellObj instanceof ZteucellRecord){

            ZteucellRecord cell = (ZteucellRecord) cellObj;

            CrcellRecord cr = new CrcellRecord();

            cr.setCellSiteinfo(cell.getUserlabel());

            // replace with information from node
            if(node != null){
                cr.setCellSiteinfo(node.getNodeCode());
            }

            if(cell.get("anteLatitude") != null){
                cr.setCellLatitude(Double.parseDouble(cell.get("anteLatitude").toString()));
            }

            if(cell.get("anteLongitude") != null){
                cr.setCellLongitude(Double.parseDouble(cell.get("anteLongitude").toString()));
            }

            return cr;

        }
        else if(cellObj instanceof ZtelcellRecord){

            ZtelcellRecord cell = (ZtelcellRecord) cellObj;

            CrcellRecord cr = new CrcellRecord();

            cr.setCellSiteinfo(cell.getUserlabel());

            // replace with information from node
            if(node != null){
                cr.setCellSiteinfo(node.getNodeCode());
            }

            if(cell.get("latitude") != null){
                cr.setCellLatitude(Double.parseDouble(cell.get("latitude").toString()));
            }

            if(cell.get("longitude") != null){
                cr.setCellLongitude(Double.parseDouble(cell.get("longitude").toString()));
            }

            return cr;

        }
        else if(cellObj instanceof ErgcellRecord){

            ErgcellRecord cell = (ErgcellRecord) cellObj;

            CrcellRecord cr = new CrcellRecord();

            cr.setCellSiteinfo(cell.getCell());

            // replace with information from node
            if(node != null){
                cr.setCellSiteinfo(node.getNodeCode());
            }

            if(cell.getLatitude() != null){

                try{
                    cr.setCellLatitude(Double.parseDouble(cell.getLatitude()));
                }catch(Exception e){
                    cr.setCellLatitude(null);
                }
            }

            if(cell.getLongitude() != null){

                try{
                    cr.setCellLongitude(Double.parseDouble(cell.getLongitude()));
                }catch(Exception e){
                    cr.setCellLongitude(null);
                }
            }

            return cr;


        }
        else if(cellObj instanceof ErucellRecord){

            ErucellRecord cell = (ErucellRecord) cellObj;

            CrcellRecord cr = new CrcellRecord();

            cr.setCellSiteinfo(cell.getCellname());

            // replace with information from node
            if(node != null){
                cr.setCellSiteinfo(node.getNodeCode());
            }

            if(cell.get("LATITUDE") != null){
                cr.setCellLatitude(Double.parseDouble(cell.get("LATITUDE").toString()));
            }

            if(cell.get("LONGITUDE") != null){
                cr.setCellLongitude(Double.parseDouble(cell.get("LONGITUDE").toString()));
            }

            return cr;
        }
        else if(cellObj instanceof ErlcellRecord){

            ErlcellRecord cell = (ErlcellRecord) cellObj;

            CrcellRecord cr = new CrcellRecord();

            cr.setCellSiteinfo(cell.getCellname());

            // replace with information from node
            if(node != null){
                cr.setCellSiteinfo(node.getNodeCode());
            }

            if(cell.get("LATITUDE") != null){
                cr.setCellLatitude(Double.parseDouble(cell.get("LATITUDE").toString()));
            }

            if(cell.get("LONGITUDE") != null){
                cr.setCellLongitude(Double.parseDouble(cell.get("LONGITUDE").toString()));
            }

            return cr;
        }
        else if (cellObj instanceof ErncellRecord) {

            ErncellRecord cell = (ErncellRecord) cellObj;

            CrcellRecord cr = new CrcellRecord();

            cr.setCellSiteinfo(cell.getCellname());

            if (node != null) {
                cr.setCellSiteinfo(node.getNodeCode());
            }

            if (cell.get("LATITUDE") != null) {
                cr.setCellLatitude(Double.parseDouble(cell.get("LATITUDE").toString()));
            }

            if (cell.get("LONGITUDE") != null) {
                cr.setCellLongitude(Double.parseDouble(cell.get("LONGITUDE").toString()));
            }

            return cr;

        }
        else if(cellObj instanceof HwucellRecord){

            HwucellRecord cell = (HwucellRecord) cellObj;

            CrcellRecord cr = new CrcellRecord();

            cr.setCellSiteinfo(cell.getCellname());

            // replace with information from node
            if(node != null){
                cr.setCellSiteinfo(node.getNodeCode());
            }

            if(cell.getLatitude() != null){
                cr.setCellLatitude(Double.parseDouble(cell.getLatitude()));
            }

            if(cell.getLongitude() != null){
                cr.setCellLongitude(Double.parseDouble(cell.getLongitude()));
            }

            return cr;
        }
        else if(cellObj instanceof HwlcellRecord){

            HwlcellRecord cell = (HwlcellRecord) cellObj;

            CrcellRecord cr = new CrcellRecord();

            cr.setCellSiteinfo(cell.getCellname());

            // replace with information from node
            if(node != null){
                cr.setCellSiteinfo(node.getNodeCode());
            }

            if(cell.getLatitude() != null){
                cr.setCellLatitude(Double.parseDouble(cell.getLatitude()));
            }

            if(cell.getLongitude() != null){
                cr.setCellLongitude(Double.parseDouble(cell.getLongitude()));
            }

            return cr;
        }
        else if(cellObj instanceof HwncellRecord){

            HwncellRecord cell = (HwncellRecord) cellObj;

            CrcellRecord cr = new CrcellRecord();

            cr.setCellSiteinfo(cell.getCellname());

            // replace with information from node
            if(node != null){
                cr.setCellSiteinfo(node.getNodeCode());
            }

            if(cell.getLatitude() != null){
                cr.setCellLatitude(Double.parseDouble(cell.getLatitude()));
            }

            if(cell.getLongitude() != null){
                cr.setCellLongitude(Double.parseDouble(cell.getLongitude()));
            }

            return cr;
        }

        return null;
    }

    public static final CellFreqResult calc3gUarfcn(double Ndl) {

        double FDL_offset,  FUL_offset, diff, Nul;

        if (((Ndl >= 10562) && (Ndl <= 10838))) {
            FDL_offset = 0;
            FUL_offset = 0;
            diff = Ndl - 10562;
            Nul = 9612 + diff;  // 9713
        }
        else if (((Ndl >= 9662) && (Ndl <= 9938))) {
            FDL_offset = 0;
            FUL_offset = 0;
            diff = Ndl - 9662;
            Nul = 9262 + diff;
        }
        else if (((Ndl >= 1162) && (Ndl <= 1513))) {
            FDL_offset = 1575;
            FUL_offset = 1525;
            diff = Ndl - 1162;
            Nul = 937 + diff;
        }
        else if (((Ndl >= 1537) && (Ndl <= 1738))) {
            FDL_offset = 1805;
            FUL_offset = 1450;
            diff = Ndl - 1537;
            Nul = 1312 + diff;
        }
        else if (((Ndl >= 4357) && (Ndl <= 4458))) {
            FDL_offset = 0;
            FUL_offset = 0;
            diff = Ndl - 4357;
            Nul = 4132 + diff;
        }
        else if (((Ndl >= 4387) && (Ndl <= 4413))) {
            FDL_offset = 0;
            FUL_offset = 0;
            diff = Ndl - 4387;
            Nul = 4162 + diff;
        }
        else if (((Ndl >= 2237) && (Ndl <= 2563))) {
            FDL_offset = 2175;
            FUL_offset = 2100;
            diff = Ndl - 2237;
            Nul = 2012 + diff;
        }
        else if (((Ndl >= 2937) && (Ndl <= 3088))) {
            FDL_offset = 340;
            FUL_offset = 340;
            diff = Ndl - 2937;
            Nul = 2712 + diff;
        }
        else if (((Ndl >= 9237) && (Ndl <= 9387))) {
            FDL_offset = 0;
            FUL_offset = 0;
            diff = Ndl - 9237;
            Nul = 8762 + diff;
        }
        else if (((Ndl >= 3112) && (Ndl <= 3388))) {
            FDL_offset = 1490;
            FUL_offset = 1135;
            diff = Ndl - 3112;
            Nul = 2887 + diff;
        }
        else if (((Ndl >= 3712) && (Ndl <= 3787))) {
            FDL_offset = 736;
            FUL_offset = 733;
            diff = Ndl - 3712;
            Nul = 3487 + diff;
        }
        else if (((Ndl >= 3842) && (Ndl <= 3903))) {
            FDL_offset = -37;
            FUL_offset = -22;
            diff = Ndl - 3842;
            Nul = 3617 + diff;
        }
        else if (((Ndl >= 4017) && (Ndl <= 4043))) {
            FDL_offset = -55;
            FUL_offset = 21;
            diff = Ndl - 4017;
            Nul = 3792 + diff;
        }
        else if (((Ndl >= 4117) && (Ndl <= 4143))) {
            FDL_offset = -63;
            FUL_offset = 12;
            diff = Ndl - 4117;
            Nul = 3892 + diff;
        }
        else if (((Ndl >= 712) && (Ndl <= 763))) {
            FDL_offset = 735;
            FUL_offset = 770;
            diff = Ndl - 712;
            Nul = 312 + diff;
        }
        else if (((Ndl >= 4512) && (Ndl <= 4638))) {
            FDL_offset = -109;
            FUL_offset = -23;
            diff = Ndl - 4512;
            Nul = 4287 + diff;
        }
        else if (((Ndl >= 862) && (Ndl <= 912))) {
            FDL_offset = 1326;
            FUL_offset = 1358;
            diff = Ndl - 862;
            Nul = 462 + diff;
        }
        else if (((Ndl >= 4662) && (Ndl <= 5038))) {
            FDL_offset = 2580;
            FUL_offset = 2525;
            diff = Ndl - 4662;
            Nul = 4437 + diff;
        }
        else if (((Ndl >= 5112) && (Ndl <= 5413))) {
            FDL_offset = 910;
            FUL_offset = 875;
            diff = Ndl - 5112;
            Nul = 4887 + diff;
        }
        else if (((Ndl >= 5762) && (Ndl <= 5913))) {
            FDL_offset = -291;
            FUL_offset = -291;
            diff = Ndl - 5762;
            Nul = 5537 + diff;
        }
        else {
            FDL_offset = 0;
            FUL_offset = 0;
            diff = 0;
            Nul = 0;
        }

        // Ndl = 10663, Nul = 9713
        double c1 = (FDL_offset + (0.2 * Ndl)); // 21326
        double c2 = (FUL_offset + (0.2 * Nul)); // 19426
        double c3 = Nul;  // 9713

        c1 = Math.round(c1 * 100.0) / 100.0;
        c2 = Math.round(c2 * 100.0) / 100.0;
        c3 = Math.round(c3 * 100.0) / 100.0;


        final double Ndl2 = Ndl;
        final double c12 = c1;
        final double c22 = c2;
        final double c32 = c3;

//        return { "c0": Ndl, "c1": c1, "c2": c2, "c3": c3 };

        return new CellFreqResult(Ndl2, c12, c22, c32);
    }

    public static final CellFreqResult calc4gEarfcn(double N) {

        double FDL_Low, NDL_Offset, FUL_Low, NUL_Offset;
        double N1, NUL, c1, c2;

        if (((N >= 0) && (N <= 599))) {
            FDL_Low = 2110;
            NDL_Offset = 0;
            FUL_Low = 1920;
            NUL_Offset = 18000;
            N1 = N - 0;
            NUL = 18000 + N1;
            c1 = (FDL_Low + (0.1 * (N - NDL_Offset)));
            c2 = (FUL_Low + (0.1 * (NUL - NUL_Offset)));
        }
        else if (((N >= 600) && (N <= 1199))) {
            FDL_Low = 1930;
            NDL_Offset = 600;
            FUL_Low = 1850;
            NUL_Offset = 18600;
            N1 = N - 600;
            NUL = 18600 + N1;
            c1 = (FDL_Low + (0.1 * (N - NDL_Offset)));
            c2 = (FUL_Low + (0.1 * (NUL - NUL_Offset)));
        }
        else if (((N >= 1200) && (N <= 1949))) {
            FDL_Low = 1805;
            NDL_Offset = 1200;
            FUL_Low = 1710;
            NUL_Offset = 19200;
            N1 = N - 1200;
            NUL = 19200 + N1;
            c1 = (FDL_Low + (0.1 * (N - NDL_Offset)));
            c2 = (FUL_Low + (0.1 * (NUL - NUL_Offset)));
        }
        else if (((N >= 1950) && (N <= 2399))) {
            FDL_Low = 2110;
            NDL_Offset = 1950;
            FUL_Low = 1710;
            NUL_Offset = 19950;
            N1 = N - 1950;
            NUL = 19950 + N1;
            c1 = (FDL_Low + (0.1 * (N - NDL_Offset)));
            c2 = (FUL_Low + (0.1 * (NUL - NUL_Offset)));
        }
        else if (((N >= 2400) && (N <= 2649))) {
            FDL_Low = 869;
            NDL_Offset = 2400;
            FUL_Low = 824;
            NUL_Offset = 20400;
            N1 = N - 2400;
            NUL = 20400 + N1;
            c1 = (FDL_Low + (0.1 * (N - NDL_Offset)));
            c2 = (FUL_Low + (0.1 * (NUL - NUL_Offset)));
        }
        else if (((N >= 2650) && (N <= 2749))) {
            FDL_Low = 875;
            NDL_Offset = 2650;
            FUL_Low = 830;
            NUL_Offset = 20650;
            N1 = N - 2650;
            NUL = 20650 + N1;
            c1 = (FDL_Low + (0.1 * (N - NDL_Offset)));
            c2 = (FUL_Low + (0.1 * (NUL - NUL_Offset)));
        }
        else if (((N >= 2750) && (N <= 3449))) {
            FDL_Low = 2620;
            NDL_Offset = 2750;
            FUL_Low = 2500;
            NUL_Offset = 20750;
            N1 = N - 2750;
            NUL = 20750 + N1;
            c1 = (FDL_Low + (0.1 * (N - NDL_Offset)));
            c2 = (FUL_Low + (0.1 * (NUL - NUL_Offset)));
        }
        else if (((N >= 3450) && (N <= 3799))) {
            FDL_Low = 925;
            NDL_Offset = 3450;
            FUL_Low = 880;
            NUL_Offset = 21450;
            N1 = N - 3450;
            NUL = 21450 + N1;
            c1 = (FDL_Low + (0.1 * (N - NDL_Offset)));
            c2 = (FUL_Low + (0.1 * (NUL - NUL_Offset)));
        }
        else if (((N >= 3800) && (N <= 4149))) {
            FDL_Low = 1844.9;
            NDL_Offset = 3800;
            FUL_Low = 1749.9;
            NUL_Offset = 21800;
            N1 = N - 3800;
            NUL = 21800 + N1;
            c1 = (FDL_Low + (0.1 * (N - NDL_Offset)));
            c2 = (FUL_Low + (0.1 * (NUL - NUL_Offset)));
        }
        else if (((N >= 4150) && (N <= 4749))) {
            FDL_Low = 2110;
            NDL_Offset = 4150;
            FUL_Low = 1710;
            NUL_Offset = 22150;
            N1 = N - 4150;
            NUL = 22150 + N1;
            c1 = (FDL_Low + (0.1 * (N - NDL_Offset)));
            c2 = (FUL_Low + (0.1 * (NUL - NUL_Offset)));
        }
        else if (((N >= 4750) && (N <= 4999))) {
            FDL_Low = 1475.9;
            NDL_Offset = 4750;
            FUL_Low = 1427.9;
            NUL_Offset = 22750;
            N1 = N - 4750;
            NUL = 22750 + N1;
            c1 = (FDL_Low + (0.1 * (N - NDL_Offset)));
            c2 = (FUL_Low + (0.1 * (NUL - NUL_Offset)));
        }
        else if (((N >= 5000) && (N <= 5179))) {
            FDL_Low = 728;
            NDL_Offset = 5000;
            FUL_Low = 698;
            NUL_Offset = 23000;
            N1 = N - 5000;
            NUL = 23000 + N1;
            c1 = (FDL_Low + (0.1 * (N - NDL_Offset)));
            c2 = (FUL_Low + (0.1 * (NUL - NUL_Offset)));
        }
        else if (((N >= 5180) && (N <= 5279))) {
            FDL_Low = 746;
            NDL_Offset = 5180;
            FUL_Low = 777;
            NUL_Offset = 23180;
            N1 = N - 5180;
            NUL = 23180 + N1;
            c1 = (FDL_Low + (0.1 * (N - NDL_Offset)));
            c2 = (FUL_Low + (0.1 * (NUL - NUL_Offset)));
        }
        else if (((N >= 5280) && (N <= 5379))) {
            FDL_Low = 758;
            NDL_Offset = 5280;
            FUL_Low = 788;
            NUL_Offset = 23280;
            N1 = N - 5280;
            NUL = 23280 + N1;
            c1 = (FDL_Low + (0.1 * (N - NDL_Offset)));
            c2 = (FUL_Low + (0.1 * (NUL - NUL_Offset)));
        }
        else if (((N >= 38650) && (N <= 39649))) {
            FDL_Low = 2300;
            NDL_Offset = 38650;
            FUL_Low = 2300;
            NUL_Offset = 38650;
            N1 = N - 38650;
            NUL = 38650 + N1;
            c1 = (FDL_Low + (0.1 * (N - NDL_Offset)));
            c2 = (FUL_Low + (0.1 * (NUL - NUL_Offset)));
        }
        else {
            FDL_Low = 0;
            NDL_Offset = 0;
            FUL_Low = 0;
            NUL_Offset = 0;
            N1 = 0;
            NUL = N1;
            c1 = -1;
            c2 = -1;
        }

//        return { "c0": N, "c1": c1, "c2": c2};

        c1 = Math.round(c1 * 100.0) / 100.0;
        c2 = Math.round(c2 * 100.0) / 100.0;

        return new CellFreqResult(N, c1, c2, 0);
    }

    public static final CellFreqResult calc5gNRarfcn(double Nref) {

        double Fglobal;
        double Frefoffs, Nrefoffs;
        double c1;

        if (((Nref >= 0) && (Nref <=599999)))
        {
            Fglobal = 5*Math.pow(10,3) ;
            Frefoffs = 0;
            Nrefoffs= 0 ;
            c1 = (Frefoffs + (Fglobal *(Nref - Nrefoffs)));
        }
        else if (((Nref >= 600000) && (Nref <=2016666)))
        {
            Fglobal = 15*Math.pow(10,3) ;
            Frefoffs = 3000*Math.pow(10,6);
            Nrefoffs= 600000 ;
            c1 = (Frefoffs + (Fglobal *(Nref - Nrefoffs)));
        }
        else if (((Nref >= 2016667) && (Nref <=3279165)))
        {
            Fglobal = 60*Math.pow(10,3) ;
            Frefoffs = 24250.08*Math.pow(10,6);
            Nrefoffs= 2016667;
            c1 = (Frefoffs + (Fglobal *(Nref - Nrefoffs)));
        }
        else
        {
            c1 = -1;
        }

        if(c1 != -1){
            c1=c1*Math.pow(10,-6);
        }
        return new CellFreqResult(Nref, c1, 0, 0);
    }

    public static final CellFreqResult calc2gArfcn(double N) {

        // N = Number(document.calculator.number1.value);

        double c1,c2,c3,c4;
//        String str1, str4;

        if (((N >= 259) && (N <= 293))) {
            c1 = 450.6 + 0.2 * (N - 259);
            c2 = c1 + 10;
            // document.calculator.Ful.value = c1;
            // document.calculator.Fdl.value = c2;
        }
        else if (((N >= 306) && (N <= 340))) {
            c1 = 479 + 0.2 * (N - 306);
            c2 = c1 + 10;
            // document.calculator.Ful.value = c1;
            // document.calculator.Fdl.value = c2;
        }
        else if (((N >= 438) && (N <= 511))) {
            c1 = 747.2 + 0.2 * (N - 438);
            c2 = c1 + 30;
            // document.calculator.Ful.value = c1;
            // document.calculator.Fdl.value = c2;
        }
        else if (((N >= 128) && (N <= 251))) {
            c1 = 824.2 + 0.2 * (N - 128);
            c2 = c1 + 45;
            // document.calculator.Ful.value = c1;
            // document.calculator.Fdl.value = c2;
        }
        else if (((N >= 1) && (N <= 124))) {
            c1 = 890 + 0.2 * N;
            c2 = c1 + 45;
            // document.calculator.Ful.value = c1;
            // document.calculator.Fdl.value = c2;
        }
        else if (((N >= 975) && (N <= 1023))) {
            c1 = 890 + 0.2 * (N - 1024);
            c2 = c1 + 45;
            // document.calculator.Ful.value = c1;
            // document.calculator.Fdl.value = c2;
        }
        else if (((N >= 940) && (N <= 974))) {
            c1 = 890 + 0.2 * (N - 1024);
            c2 = c1 + 45;
            // document.calculator.Ful.value = c1;
            // document.calculator.Fdl.value = c2;
        }
        else if (((N >= 512) && (N <= 810))) {
            //i=1;
            c1 = 1710.2 + 0.2 * (N - 512);
            c2 = c1 + 95;
//            str2 = " for DCS1800;";
//            str3 = " for PCS1900";
            c3 = 1850.2 + 0.2 * (N - 512);
            c4 = c1 + 80;
//            str1 = c1 + str2 + c3 + str3;
//            str4 = c2 + str2 + c4 + str3
            // document.calculator.Ful.value = str1;
            // document.calculator.Fdl.value = str4;
        }
        else if (((N >= 811) && (N <= 885))) {
            c1 = 1710.2 + 0.2 * (N - 512);
            c2 = c1 + 95;
            // document.calculator.Ful.value = c1;
            // document.calculator.Fdl.value = c2;
        }
        else {
            c1 = -1;
            c2 = -1;
        }

        c1 = Math.round(c1 * 100.0) / 100.0;
        c2 = Math.round(c2 * 100.0) / 100.0;

        return new CellFreqResult(N, c1, c2, 0);
    }

    public static void main(String[] args) {

        CellFreqResult res = CellUtils.calc3gUarfcn(10613);

        System.out.println("c0 3G (UARFCN DL): " + res.Ndl);
        System.out.println("c1 3G Downlink Freq. (MHz): " + res.c1);
        System.out.println("c2 3G Uplink Freq. (MHz): " + res.c2);
        System.out.println("c3 3G(UARFCN UL): " + res.c3);

        System.out.println("\n\n");

        res = CellUtils.calc3gUarfcn(2725);

        System.out.println("c0 3G (UARFCN DL): " + res.Ndl);
        System.out.println("c1 3G Downlink Freq. (MHz): " + res.c1);
        System.out.println("c2 3G Uplink Freq. (MHz): " + res.c2);
        System.out.println("c3 3G(UARFCN UL): " + res.c3);

        System.out.println("\n\n");

        res = CellUtils.calc4gEarfcn(700);
        System.out.println("c0 4G (EARFCN DL): " + res.Ndl);
        System.out.println("c1 4G Downlink Freq. (MHz): " + res.c1);
        System.out.println("c2 4G Uplink Freq. (MHz): " + res.c2);

        System.out.println("\n\n");

        res = CellUtils.calc4gEarfcn(38725);
        System.out.println("c0 4G (EARFCN DL): " + res.Ndl);
        System.out.println("c1 4G Downlink Freq. (MHz): " + res.c1);
        System.out.println("c2 4G Uplink Freq. (MHz): " + res.c2);

        System.out.println("\n\n");

        res = CellUtils.calc4gEarfcn(19850);
        System.out.println("c0 4G (EARFCN DL): " + res.Ndl);
        System.out.println("c1 4G Downlink Freq. (MHz): " + res.c1);
        System.out.println("c2 4G Uplink Freq. (MHz): " + res.c2);

        System.out.println("\n\n");

        res = CellUtils.calc4gEarfcn(21500);
        System.out.println("c0 4G (EARFCN DL): " + res.Ndl);
        System.out.println("c1 4G Downlink Freq. (MHz): " + res.c1);
        System.out.println("c2 4G Uplink Freq. (MHz): " + res.c2);

        System.out.println("\n\n");

        res = CellUtils.calc2gArfcn(2);
        System.out.println("c0 2G (ARFCN): " + res.Ndl);
        System.out.println("c1 2G Downlink Freq. (MHz): " + res.c1);
        System.out.println("c2 2G Uplink Freq. (MHz): " + res.c2);
    }
}

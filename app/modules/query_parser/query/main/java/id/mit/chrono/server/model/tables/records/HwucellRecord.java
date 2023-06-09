/*
 * This file is generated by jOOQ.
*/
package id.mit.chrono.server.model.tables.records;


import id.mit.chrono.server.model.tables.Hwucell;

import javax.annotation.Generated;

import org.jooq.Record2;
import org.jooq.impl.UpdatableRecordImpl;
import org.jooq.types.UInteger;
import org.jooq.types.ULong;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.10.6"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class HwucellRecord extends UpdatableRecordImpl<HwucellRecord> {

    private static final long serialVersionUID = 1725875571;

    /**
     * Setter for <code>chrono.hwucell.hwucell_id</code>.
     */
    public void setHwucellId(ULong value) {
        set(0, value);
    }

    /**
     * Getter for <code>chrono.hwucell.hwucell_id</code>.
     */
    public ULong getHwucellId() {
        return (ULong) get(0);
    }

    /**
     * Setter for <code>chrono.hwucell.hwucell_crcollectortaskfiles</code>.
     */
    public void setHwucellCrcollectortaskfiles(ULong value) {
        set(1, value);
    }

    /**
     * Getter for <code>chrono.hwucell.hwucell_crcollectortaskfiles</code>.
     */
    public ULong getHwucellCrcollectortaskfiles() {
        return (ULong) get(1);
    }

    /**
     * Setter for <code>chrono.hwucell.hwucell_date</code>.
     */
    public void setHwucellDate(UInteger value) {
        set(2, value);
    }

    /**
     * Getter for <code>chrono.hwucell.hwucell_date</code>.
     */
    public UInteger getHwucellDate() {
        return (UInteger) get(2);
    }

    /**
     * Setter for <code>chrono.hwucell.hwucell_datefrom</code>.
     */
    public void setHwucellDatefrom(Integer value) {
        set(3, value);
    }

    /**
     * Getter for <code>chrono.hwucell.hwucell_datefrom</code>.
     */
    public Integer getHwucellDatefrom() {
        return (Integer) get(3);
    }

    /**
     * Setter for <code>chrono.hwucell.hwucell_hwrnc</code>.
     */
    public void setHwucellHwrnc(ULong value) {
        set(4, value);
    }

    /**
     * Getter for <code>chrono.hwucell.hwucell_hwrnc</code>.
     */
    public ULong getHwucellHwrnc() {
        return (ULong) get(4);
    }

    /**
     * Setter for <code>chrono.hwucell.hwucell_hwnodeb</code>.
     */
    public void setHwucellHwnodeb(ULong value) {
        set(5, value);
    }

    /**
     * Getter for <code>chrono.hwucell.hwucell_hwnodeb</code>.
     */
    public ULong getHwucellHwnodeb() {
        return (ULong) get(5);
    }

    /**
     * Setter for <code>chrono.hwucell.hwucell_nodealias</code>.
     */
    public void setHwucellNodealias(Integer value) {
        set(6, value);
    }

    /**
     * Getter for <code>chrono.hwucell.hwucell_nodealias</code>.
     */
    public Integer getHwucellNodealias() {
        return (Integer) get(6);
    }

    /**
     * Setter for <code>chrono.hwucell.hwucell_cell</code>.
     */
    public void setHwucellCell(Integer value) {
        set(7, value);
    }

    /**
     * Getter for <code>chrono.hwucell.hwucell_cell</code>.
     */
    public Integer getHwucellCell() {
        return (Integer) get(7);
    }

    /**
     * Setter for <code>chrono.hwucell.hwucell_cellclass</code>.
     */
    public void setHwucellCellclass(Integer value) {
        set(8, value);
    }

    /**
     * Getter for <code>chrono.hwucell.hwucell_cellclass</code>.
     */
    public Integer getHwucellCellclass() {
        return (Integer) get(8);
    }

    /**
     * Setter for <code>chrono.hwucell.hwucell_cellclassgroup</code>.
     */
    public void setHwucellCellclassgroup(Integer value) {
        set(9, value);
    }

    /**
     * Getter for <code>chrono.hwucell.hwucell_cellclassgroup</code>.
     */
    public Integer getHwucellCellclassgroup() {
        return (Integer) get(9);
    }

    /**
     * Setter for <code>chrono.hwucell.hwucell_cellcoverage</code>.
     */
    public void setHwucellCellcoverage(Integer value) {
        set(10, value);
    }

    /**
     * Getter for <code>chrono.hwucell.hwucell_cellcoverage</code>.
     */
    public Integer getHwucellCellcoverage() {
        return (Integer) get(10);
    }

    /**
     * Setter for <code>chrono.hwucell.hwucell_revenueclass</code>.
     */
    public void setHwucellRevenueclass(Integer value) {
        set(11, value);
    }

    /**
     * Getter for <code>chrono.hwucell.hwucell_revenueclass</code>.
     */
    public Integer getHwucellRevenueclass() {
        return (Integer) get(11);
    }

    /**
     * Setter for <code>chrono.hwucell.hwucell_cellstatus</code>.
     */
    public void setHwucellCellstatus(Integer value) {
        set(12, value);
    }

    /**
     * Getter for <code>chrono.hwucell.hwucell_cellstatus</code>.
     */
    public Integer getHwucellCellstatus() {
        return (Integer) get(12);
    }

    /**
     * Setter for <code>chrono.hwucell.hwucell_vendor</code>.
     */
    public void setHwucellVendor(Integer value) {
        set(13, value);
    }

    /**
     * Getter for <code>chrono.hwucell.hwucell_vendor</code>.
     */
    public Integer getHwucellVendor() {
        return (Integer) get(13);
    }

    /**
     * Setter for <code>chrono.hwucell.hwucell_latitude</code>.
     */
    public void setHwucellLatitude(Double value) {
        set(14, value);
    }

    /**
     * Getter for <code>chrono.hwucell.hwucell_latitude</code>.
     */
    public Double getHwucellLatitude() {
        return (Double) get(14);
    }

    /**
     * Setter for <code>chrono.hwucell.hwucell_longitude</code>.
     */
    public void setHwucellLongitude(Double value) {
        set(15, value);
    }

    /**
     * Getter for <code>chrono.hwucell.hwucell_longitude</code>.
     */
    public Double getHwucellLongitude() {
        return (Double) get(15);
    }

    /**
     * Setter for <code>chrono.hwucell.hwucell_namingvalid</code>.
     */
    public void setHwucellNamingvalid(Byte value) {
        set(16, value);
    }

    /**
     * Getter for <code>chrono.hwucell.hwucell_namingvalid</code>.
     */
    public Byte getHwucellNamingvalid() {
        return (Byte) get(16);
    }

    /**
     * Setter for <code>chrono.hwucell.CELLNAME</code>.
     */
    public void setCellname(String value) {
        set(17, value);
    }

    /**
     * Getter for <code>chrono.hwucell.CELLNAME</code>.
     */
    public String getCellname() {
        return (String) get(17);
    }

    /**
     * Setter for <code>chrono.hwucell.CELLID</code>.
     */
    public void setCellid(String value) {
        set(18, value);
    }

    /**
     * Getter for <code>chrono.hwucell.CELLID</code>.
     */
    public String getCellid() {
        return (String) get(18);
    }

    /**
     * Setter for <code>chrono.hwucell.LOGICRNCID</code>.
     */
    public void setLogicrncid(Integer value) {
        set(19, value);
    }

    /**
     * Getter for <code>chrono.hwucell.LOGICRNCID</code>.
     */
    public Integer getLogicrncid() {
        return (Integer) get(19);
    }

    /**
     * Setter for <code>chrono.hwucell.FDN</code>.
     */
    public void setFdn(String value) {
        set(20, value);
    }

    /**
     * Getter for <code>chrono.hwucell.FDN</code>.
     */
    public String getFdn() {
        return (String) get(20);
    }

    /**
     * Setter for <code>chrono.hwucell.LOCELL</code>.
     */
    public void setLocell(String value) {
        set(21, value);
    }

    /**
     * Getter for <code>chrono.hwucell.LOCELL</code>.
     */
    public String getLocell() {
        return (String) get(21);
    }

    /**
     * Setter for <code>chrono.hwucell.BANDIND</code>.
     */
    public void setBandind(String value) {
        set(22, value);
    }

    /**
     * Getter for <code>chrono.hwucell.BANDIND</code>.
     */
    public String getBandind() {
        return (String) get(22);
    }

    /**
     * Setter for <code>chrono.hwucell.NODEBNAME</code>.
     */
    public void setNodebname(String value) {
        set(23, value);
    }

    /**
     * Getter for <code>chrono.hwucell.NODEBNAME</code>.
     */
    public String getNodebname() {
        return (String) get(23);
    }

    /**
     * Setter for <code>chrono.hwucell.UARFCNUPLINK</code>.
     */
    public void setUarfcnuplink(String value) {
        set(24, value);
    }

    /**
     * Getter for <code>chrono.hwucell.UARFCNUPLINK</code>.
     */
    public String getUarfcnuplink() {
        return (String) get(24);
    }

    /**
     * Setter for <code>chrono.hwucell.UARFCNDOWNLINK</code>.
     */
    public void setUarfcndownlink(String value) {
        set(25, value);
    }

    /**
     * Getter for <code>chrono.hwucell.UARFCNDOWNLINK</code>.
     */
    public String getUarfcndownlink() {
        return (String) get(25);
    }

    /**
     * Setter for <code>chrono.hwucell.RAC</code>.
     */
    public void setRac(String value) {
        set(26, value);
    }

    /**
     * Getter for <code>chrono.hwucell.RAC</code>.
     */
    public String getRac() {
        return (String) get(26);
    }

    /**
     * Setter for <code>chrono.hwucell.MAXTXPOWER</code>.
     */
    public void setMaxtxpower(String value) {
        set(27, value);
    }

    /**
     * Getter for <code>chrono.hwucell.MAXTXPOWER</code>.
     */
    public String getMaxtxpower() {
        return (String) get(27);
    }

    /**
     * Setter for <code>chrono.hwucell.PSCRAMBCODE</code>.
     */
    public void setPscrambcode(String value) {
        set(28, value);
    }

    /**
     * Getter for <code>chrono.hwucell.PSCRAMBCODE</code>.
     */
    public String getPscrambcode() {
        return (String) get(28);
    }

    /**
     * Setter for <code>chrono.hwucell.MCC</code>.
     */
    public void setMcc(String value) {
        set(29, value);
    }

    /**
     * Getter for <code>chrono.hwucell.MCC</code>.
     */
    public String getMcc() {
        return (String) get(29);
    }

    /**
     * Setter for <code>chrono.hwucell.MNC</code>.
     */
    public void setMnc(String value) {
        set(30, value);
    }

    /**
     * Getter for <code>chrono.hwucell.MNC</code>.
     */
    public String getMnc() {
        return (String) get(30);
    }

    /**
     * Setter for <code>chrono.hwucell.LAC</code>.
     */
    public void setLac(String value) {
        set(31, value);
    }

    /**
     * Getter for <code>chrono.hwucell.LAC</code>.
     */
    public String getLac() {
        return (String) get(31);
    }

    /**
     * Setter for <code>chrono.hwucell.CGI</code>.
     */
    public void setCgi(String value) {
        set(32, value);
    }

    /**
     * Getter for <code>chrono.hwucell.CGI</code>.
     */
    public String getCgi() {
        return (String) get(32);
    }

    /**
     * Setter for <code>chrono.hwucell.SAC</code>.
     */
    public void setSac(String value) {
        set(33, value);
    }

    /**
     * Getter for <code>chrono.hwucell.SAC</code>.
     */
    public String getSac() {
        return (String) get(33);
    }

    /**
     * Setter for <code>chrono.hwucell.ACTSTATUS</code>.
     */
    public void setActstatus(String value) {
        set(34, value);
    }

    /**
     * Getter for <code>chrono.hwucell.ACTSTATUS</code>.
     */
    public String getActstatus() {
        return (String) get(34);
    }

    /**
     * Setter for <code>chrono.hwucell.BLKSTATUS</code>.
     */
    public void setBlkstatus(String value) {
        set(35, value);
    }

    /**
     * Getter for <code>chrono.hwucell.BLKSTATUS</code>.
     */
    public String getBlkstatus() {
        return (String) get(35);
    }

    /**
     * Setter for <code>chrono.hwucell.MBMSACTFLG</code>.
     */
    public void setMbmsactflg(String value) {
        set(36, value);
    }

    /**
     * Getter for <code>chrono.hwucell.MBMSACTFLG</code>.
     */
    public String getMbmsactflg() {
        return (String) get(36);
    }

    /**
     * Setter for <code>chrono.hwucell.MIMOACTFLAG</code>.
     */
    public void setMimoactflag(String value) {
        set(37, value);
    }

    /**
     * Getter for <code>chrono.hwucell.MIMOACTFLAG</code>.
     */
    public String getMimoactflag() {
        return (String) get(37);
    }

    /**
     * Setter for <code>chrono.hwucell.MOINDEX</code>.
     */
    public void setMoindex(String value) {
        set(38, value);
    }

    /**
     * Getter for <code>chrono.hwucell.MOINDEX</code>.
     */
    public String getMoindex() {
        return (String) get(38);
    }

    /**
     * Setter for <code>chrono.hwucell.NINSYNCIND</code>.
     */
    public void setNinsyncind(Integer value) {
        set(39, value);
    }

    /**
     * Getter for <code>chrono.hwucell.NINSYNCIND</code>.
     */
    public Integer getNinsyncind() {
        return (Integer) get(39);
    }

    /**
     * Setter for <code>chrono.hwucell.LATITUDE</code>.
     */
    public void setLatitude(String value) {
        set(40, value);
    }

    /**
     * Getter for <code>chrono.hwucell.LATITUDE</code>.
     */
    public String getLatitude() {
        return (String) get(40);
    }

    /**
     * Setter for <code>chrono.hwucell.LONGITUDE</code>.
     */
    public void setLongitude(String value) {
        set(41, value);
    }

    /**
     * Getter for <code>chrono.hwucell.LONGITUDE</code>.
     */
    public String getLongitude() {
        return (String) get(41);
    }

    /**
     * Setter for <code>chrono.hwucell.hwucell_remark</code>.
     */
    public void setHwucellRemark(String value) {
        set(42, value);
    }

    /**
     * Getter for <code>chrono.hwucell.hwucell_remark</code>.
     */
    public String getHwucellRemark() {
        return (String) get(42);
    }

    /**
     * Setter for <code>chrono.hwucell.MAXHSDPAUSERNUM</code>.
     */
    public void setMaxhsdpausernum(String value) {
        set(43, value);
    }

    /**
     * Getter for <code>chrono.hwucell.MAXHSDPAUSERNUM</code>.
     */
    public String getMaxhsdpausernum() {
        return (String) get(43);
    }

    /**
     * Setter for <code>chrono.hwucell.MAXHSUPAUSERNUM</code>.
     */
    public void setMaxhsupausernum(String value) {
        set(44, value);
    }

    /**
     * Getter for <code>chrono.hwucell.MAXHSUPAUSERNUM</code>.
     */
    public String getMaxhsupausernum() {
        return (String) get(44);
    }

    /**
     * Setter for <code>chrono.hwucell.EXTPROP1</code>.
     */
    public void setExtprop1(Integer value) {
        set(45, value);
    }

    /**
     * Getter for <code>chrono.hwucell.EXTPROP1</code>.
     */
    public Integer getExtprop1() {
        return (Integer) get(45);
    }

    /**
     * Setter for <code>chrono.hwucell.EXTPROP2</code>.
     */
    public void setExtprop2(String value) {
        set(46, value);
    }

    /**
     * Getter for <code>chrono.hwucell.EXTPROP2</code>.
     */
    public String getExtprop2() {
        return (String) get(46);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Record2<ULong, ULong> key() {
        return (Record2) super.key();
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached HwucellRecord
     */
    public HwucellRecord() {
        super(Hwucell.HWUCELL);
    }

    /**
     * Create a detached, initialised HwucellRecord
     */
    public HwucellRecord(ULong hwucellId, ULong hwucellCrcollectortaskfiles, UInteger hwucellDate, Integer hwucellDatefrom, ULong hwucellHwrnc, ULong hwucellHwnodeb, Integer hwucellNodealias, Integer hwucellCell, Integer hwucellCellclass, Integer hwucellCellclassgroup, Integer hwucellCellcoverage, Integer hwucellRevenueclass, Integer hwucellCellstatus, Integer hwucellVendor, Double hwucellLatitude, Double hwucellLongitude, Byte hwucellNamingvalid, String cellname, String cellid, Integer logicrncid, String fdn, String locell, String bandind, String nodebname, String uarfcnuplink, String uarfcndownlink, String rac, String maxtxpower, String pscrambcode, String mcc, String mnc, String lac, String cgi, String sac, String actstatus, String blkstatus, String mbmsactflg, String mimoactflag, String moindex, Integer ninsyncind, String latitude, String longitude, String hwucellRemark, String maxhsdpausernum, String maxhsupausernum, Integer extprop1, String extprop2) {
        super(Hwucell.HWUCELL);

        set(0, hwucellId);
        set(1, hwucellCrcollectortaskfiles);
        set(2, hwucellDate);
        set(3, hwucellDatefrom);
        set(4, hwucellHwrnc);
        set(5, hwucellHwnodeb);
        set(6, hwucellNodealias);
        set(7, hwucellCell);
        set(8, hwucellCellclass);
        set(9, hwucellCellclassgroup);
        set(10, hwucellCellcoverage);
        set(11, hwucellRevenueclass);
        set(12, hwucellCellstatus);
        set(13, hwucellVendor);
        set(14, hwucellLatitude);
        set(15, hwucellLongitude);
        set(16, hwucellNamingvalid);
        set(17, cellname);
        set(18, cellid);
        set(19, logicrncid);
        set(20, fdn);
        set(21, locell);
        set(22, bandind);
        set(23, nodebname);
        set(24, uarfcnuplink);
        set(25, uarfcndownlink);
        set(26, rac);
        set(27, maxtxpower);
        set(28, pscrambcode);
        set(29, mcc);
        set(30, mnc);
        set(31, lac);
        set(32, cgi);
        set(33, sac);
        set(34, actstatus);
        set(35, blkstatus);
        set(36, mbmsactflg);
        set(37, mimoactflag);
        set(38, moindex);
        set(39, ninsyncind);
        set(40, latitude);
        set(41, longitude);
        set(42, hwucellRemark);
        set(43, maxhsdpausernum);
        set(44, maxhsupausernum);
        set(45, extprop1);
        set(46, extprop2);
    }
}

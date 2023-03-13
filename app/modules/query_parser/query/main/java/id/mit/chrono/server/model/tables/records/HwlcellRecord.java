/*
 * This file is generated by jOOQ.
*/
package id.mit.chrono.server.model.tables.records;


import id.mit.chrono.server.model.tables.Hwlcell;

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
public class HwlcellRecord extends UpdatableRecordImpl<HwlcellRecord> {

    private static final long serialVersionUID = -958872697;

    /**
     * Setter for <code>chrono.hwlcell.hwlcell_id</code>.
     */
    public void setHwlcellId(ULong value) {
        set(0, value);
    }

    /**
     * Getter for <code>chrono.hwlcell.hwlcell_id</code>.
     */
    public ULong getHwlcellId() {
        return (ULong) get(0);
    }

    /**
     * Setter for <code>chrono.hwlcell.hwlcell_crcollectortaskfiles</code>.
     */
    public void setHwlcellCrcollectortaskfiles(ULong value) {
        set(1, value);
    }

    /**
     * Getter for <code>chrono.hwlcell.hwlcell_crcollectortaskfiles</code>.
     */
    public ULong getHwlcellCrcollectortaskfiles() {
        return (ULong) get(1);
    }

    /**
     * Setter for <code>chrono.hwlcell.hwlcell_date</code>.
     */
    public void setHwlcellDate(UInteger value) {
        set(2, value);
    }

    /**
     * Getter for <code>chrono.hwlcell.hwlcell_date</code>.
     */
    public UInteger getHwlcellDate() {
        return (UInteger) get(2);
    }

    /**
     * Setter for <code>chrono.hwlcell.hwlcell_datefrom</code>.
     */
    public void setHwlcellDatefrom(Integer value) {
        set(3, value);
    }

    /**
     * Getter for <code>chrono.hwlcell.hwlcell_datefrom</code>.
     */
    public Integer getHwlcellDatefrom() {
        return (Integer) get(3);
    }

    /**
     * Setter for <code>chrono.hwlcell.hwlcell_hwenodeb</code>.
     */
    public void setHwlcellHwenodeb(ULong value) {
        set(4, value);
    }

    /**
     * Getter for <code>chrono.hwlcell.hwlcell_hwenodeb</code>.
     */
    public ULong getHwlcellHwenodeb() {
        return (ULong) get(4);
    }

    /**
     * Setter for <code>chrono.hwlcell.hwlcell_nodealias</code>.
     */
    public void setHwlcellNodealias(Integer value) {
        set(5, value);
    }

    /**
     * Getter for <code>chrono.hwlcell.hwlcell_nodealias</code>.
     */
    public Integer getHwlcellNodealias() {
        return (Integer) get(5);
    }

    /**
     * Setter for <code>chrono.hwlcell.hwlcell_cell</code>.
     */
    public void setHwlcellCell(Integer value) {
        set(6, value);
    }

    /**
     * Getter for <code>chrono.hwlcell.hwlcell_cell</code>.
     */
    public Integer getHwlcellCell() {
        return (Integer) get(6);
    }

    /**
     * Setter for <code>chrono.hwlcell.hwlcell_cellclass</code>.
     */
    public void setHwlcellCellclass(Integer value) {
        set(7, value);
    }

    /**
     * Getter for <code>chrono.hwlcell.hwlcell_cellclass</code>.
     */
    public Integer getHwlcellCellclass() {
        return (Integer) get(7);
    }

    /**
     * Setter for <code>chrono.hwlcell.hwlcell_cellclassgroup</code>.
     */
    public void setHwlcellCellclassgroup(Integer value) {
        set(8, value);
    }

    /**
     * Getter for <code>chrono.hwlcell.hwlcell_cellclassgroup</code>.
     */
    public Integer getHwlcellCellclassgroup() {
        return (Integer) get(8);
    }

    /**
     * Setter for <code>chrono.hwlcell.hwlcell_cellcoverage</code>.
     */
    public void setHwlcellCellcoverage(Integer value) {
        set(9, value);
    }

    /**
     * Getter for <code>chrono.hwlcell.hwlcell_cellcoverage</code>.
     */
    public Integer getHwlcellCellcoverage() {
        return (Integer) get(9);
    }

    /**
     * Setter for <code>chrono.hwlcell.hwlcell_revenueclass</code>.
     */
    public void setHwlcellRevenueclass(Integer value) {
        set(10, value);
    }

    /**
     * Getter for <code>chrono.hwlcell.hwlcell_revenueclass</code>.
     */
    public Integer getHwlcellRevenueclass() {
        return (Integer) get(10);
    }

    /**
     * Setter for <code>chrono.hwlcell.hwlcell_cellstatus</code>.
     */
    public void setHwlcellCellstatus(Integer value) {
        set(11, value);
    }

    /**
     * Getter for <code>chrono.hwlcell.hwlcell_cellstatus</code>.
     */
    public Integer getHwlcellCellstatus() {
        return (Integer) get(11);
    }

    /**
     * Setter for <code>chrono.hwlcell.hwlcell_vendor</code>.
     */
    public void setHwlcellVendor(Integer value) {
        set(12, value);
    }

    /**
     * Getter for <code>chrono.hwlcell.hwlcell_vendor</code>.
     */
    public Integer getHwlcellVendor() {
        return (Integer) get(12);
    }

    /**
     * Setter for <code>chrono.hwlcell.hwlcell_latitude</code>.
     */
    public void setHwlcellLatitude(Double value) {
        set(13, value);
    }

    /**
     * Getter for <code>chrono.hwlcell.hwlcell_latitude</code>.
     */
    public Double getHwlcellLatitude() {
        return (Double) get(13);
    }

    /**
     * Setter for <code>chrono.hwlcell.hwlcell_longitude</code>.
     */
    public void setHwlcellLongitude(Double value) {
        set(14, value);
    }

    /**
     * Getter for <code>chrono.hwlcell.hwlcell_longitude</code>.
     */
    public Double getHwlcellLongitude() {
        return (Double) get(14);
    }

    /**
     * Setter for <code>chrono.hwlcell.hwlcell_namingvalid</code>.
     */
    public void setHwlcellNamingvalid(Byte value) {
        set(15, value);
    }

    /**
     * Getter for <code>chrono.hwlcell.hwlcell_namingvalid</code>.
     */
    public Byte getHwlcellNamingvalid() {
        return (Byte) get(15);
    }

    /**
     * Setter for <code>chrono.hwlcell.CELLID</code>.
     */
    public void setCellid(String value) {
        set(16, value);
    }

    /**
     * Getter for <code>chrono.hwlcell.CELLID</code>.
     */
    public String getCellid() {
        return (String) get(16);
    }

    /**
     * Setter for <code>chrono.hwlcell.FDN</code>.
     */
    public void setFdn(String value) {
        set(17, value);
    }

    /**
     * Getter for <code>chrono.hwlcell.FDN</code>.
     */
    public String getFdn() {
        return (String) get(17);
    }

    /**
     * Setter for <code>chrono.hwlcell.CELLACTIVESTATE</code>.
     */
    public void setCellactivestate(String value) {
        set(18, value);
    }

    /**
     * Getter for <code>chrono.hwlcell.CELLACTIVESTATE</code>.
     */
    public String getCellactivestate() {
        return (String) get(18);
    }

    /**
     * Setter for <code>chrono.hwlcell.CELLNAME</code>.
     */
    public void setCellname(String value) {
        set(19, value);
    }

    /**
     * Getter for <code>chrono.hwlcell.CELLNAME</code>.
     */
    public String getCellname() {
        return (String) get(19);
    }

    /**
     * Setter for <code>chrono.hwlcell.DLEARFCN</code>.
     */
    public void setDlearfcn(String value) {
        set(20, value);
    }

    /**
     * Getter for <code>chrono.hwlcell.DLEARFCN</code>.
     */
    public String getDlearfcn() {
        return (String) get(20);
    }

    /**
     * Setter for <code>chrono.hwlcell.ULEARFCN</code>.
     */
    public void setUlearfcn(String value) {
        set(21, value);
    }

    /**
     * Getter for <code>chrono.hwlcell.ULEARFCN</code>.
     */
    public String getUlearfcn() {
        return (String) get(21);
    }

    /**
     * Setter for <code>chrono.hwlcell.DLFREQ</code>.
     */
    public void setDlfreq(Double value) {
        set(22, value);
    }

    /**
     * Getter for <code>chrono.hwlcell.DLFREQ</code>.
     */
    public Double getDlfreq() {
        return (Double) get(22);
    }

    /**
     * Setter for <code>chrono.hwlcell.ULFREQ</code>.
     */
    public void setUlfreq(Double value) {
        set(23, value);
    }

    /**
     * Getter for <code>chrono.hwlcell.ULFREQ</code>.
     */
    public Double getUlfreq() {
        return (Double) get(23);
    }

    /**
     * Setter for <code>chrono.hwlcell.ENODEBFUNCTIONNAME</code>.
     */
    public void setEnodebfunctionname(String value) {
        set(24, value);
    }

    /**
     * Getter for <code>chrono.hwlcell.ENODEBFUNCTIONNAME</code>.
     */
    public String getEnodebfunctionname() {
        return (String) get(24);
    }

    /**
     * Setter for <code>chrono.hwlcell.FDDTDDIND</code>.
     */
    public void setFddtddind(String value) {
        set(25, value);
    }

    /**
     * Getter for <code>chrono.hwlcell.FDDTDDIND</code>.
     */
    public String getFddtddind() {
        return (String) get(25);
    }

    /**
     * Setter for <code>chrono.hwlcell.LOCALCELLID</code>.
     */
    public void setLocalcellid(String value) {
        set(26, value);
    }

    /**
     * Getter for <code>chrono.hwlcell.LOCALCELLID</code>.
     */
    public String getLocalcellid() {
        return (String) get(26);
    }

    /**
     * Setter for <code>chrono.hwlcell.MOINDEX</code>.
     */
    public void setMoindex(String value) {
        set(27, value);
    }

    /**
     * Getter for <code>chrono.hwlcell.MOINDEX</code>.
     */
    public String getMoindex() {
        return (String) get(27);
    }

    /**
     * Setter for <code>chrono.hwlcell.PHYCELLID</code>.
     */
    public void setPhycellid(String value) {
        set(28, value);
    }

    /**
     * Getter for <code>chrono.hwlcell.PHYCELLID</code>.
     */
    public String getPhycellid() {
        return (String) get(28);
    }

    /**
     * Setter for <code>chrono.hwlcell.TXRXMODE</code>.
     */
    public void setTxrxmode(String value) {
        set(29, value);
    }

    /**
     * Getter for <code>chrono.hwlcell.TXRXMODE</code>.
     */
    public String getTxrxmode() {
        return (String) get(29);
    }

    /**
     * Setter for <code>chrono.hwlcell.ULBANDWIDTH</code>.
     */
    public void setUlbandwidth(String value) {
        set(30, value);
    }

    /**
     * Getter for <code>chrono.hwlcell.ULBANDWIDTH</code>.
     */
    public String getUlbandwidth() {
        return (String) get(30);
    }

    /**
     * Setter for <code>chrono.hwlcell.ULCYCLICPREFIX</code>.
     */
    public void setUlcyclicprefix(String value) {
        set(31, value);
    }

    /**
     * Getter for <code>chrono.hwlcell.ULCYCLICPREFIX</code>.
     */
    public String getUlcyclicprefix() {
        return (String) get(31);
    }

    /**
     * Setter for <code>chrono.hwlcell.CNOPERATORNAME</code>.
     */
    public void setCnoperatorname(String value) {
        set(32, value);
    }

    /**
     * Getter for <code>chrono.hwlcell.CNOPERATORNAME</code>.
     */
    public String getCnoperatorname() {
        return (String) get(32);
    }

    /**
     * Setter for <code>chrono.hwlcell.MCC</code>.
     */
    public void setMcc(String value) {
        set(33, value);
    }

    /**
     * Getter for <code>chrono.hwlcell.MCC</code>.
     */
    public String getMcc() {
        return (String) get(33);
    }

    /**
     * Setter for <code>chrono.hwlcell.MNC</code>.
     */
    public void setMnc(String value) {
        set(34, value);
    }

    /**
     * Getter for <code>chrono.hwlcell.MNC</code>.
     */
    public String getMnc() {
        return (String) get(34);
    }

    /**
     * Setter for <code>chrono.hwlcell.NBIOTTAFLAG</code>.
     */
    public void setNbiottaflag(String value) {
        set(35, value);
    }

    /**
     * Getter for <code>chrono.hwlcell.NBIOTTAFLAG</code>.
     */
    public String getNbiottaflag() {
        return (String) get(35);
    }

    /**
     * Setter for <code>chrono.hwlcell.ENODEBID</code>.
     */
    public void setEnodebid(String value) {
        set(36, value);
    }

    /**
     * Getter for <code>chrono.hwlcell.ENODEBID</code>.
     */
    public String getEnodebid() {
        return (String) get(36);
    }

    /**
     * Setter for <code>chrono.hwlcell.GENODEBID</code>.
     */
    public void setGenodebid(String value) {
        set(37, value);
    }

    /**
     * Getter for <code>chrono.hwlcell.GENODEBID</code>.
     */
    public String getGenodebid() {
        return (String) get(37);
    }

    /**
     * Setter for <code>chrono.hwlcell.TAC</code>.
     */
    public void setTac(String value) {
        set(38, value);
    }

    /**
     * Getter for <code>chrono.hwlcell.TAC</code>.
     */
    public String getTac() {
        return (String) get(38);
    }

    /**
     * Setter for <code>chrono.hwlcell.TAI</code>.
     */
    public void setTai(String value) {
        set(39, value);
    }

    /**
     * Getter for <code>chrono.hwlcell.TAI</code>.
     */
    public String getTai() {
        return (String) get(39);
    }

    /**
     * Setter for <code>chrono.hwlcell.ECI</code>.
     */
    public void setEci(String value) {
        set(40, value);
    }

    /**
     * Getter for <code>chrono.hwlcell.ECI</code>.
     */
    public String getEci() {
        return (String) get(40);
    }

    /**
     * Setter for <code>chrono.hwlcell.ECGI</code>.
     */
    public void setEcgi(String value) {
        set(41, value);
    }

    /**
     * Getter for <code>chrono.hwlcell.ECGI</code>.
     */
    public String getEcgi() {
        return (String) get(41);
    }

    /**
     * Setter for <code>chrono.hwlcell.TRACKINGAREAID</code>.
     */
    public void setTrackingareaid(String value) {
        set(42, value);
    }

    /**
     * Getter for <code>chrono.hwlcell.TRACKINGAREAID</code>.
     */
    public String getTrackingareaid() {
        return (String) get(42);
    }

    /**
     * Setter for <code>chrono.hwlcell.LATITUDE</code>.
     */
    public void setLatitude(String value) {
        set(43, value);
    }

    /**
     * Getter for <code>chrono.hwlcell.LATITUDE</code>.
     */
    public String getLatitude() {
        return (String) get(43);
    }

    /**
     * Setter for <code>chrono.hwlcell.LONGITUDE</code>.
     */
    public void setLongitude(String value) {
        set(44, value);
    }

    /**
     * Getter for <code>chrono.hwlcell.LONGITUDE</code>.
     */
    public String getLongitude() {
        return (String) get(44);
    }

    /**
     * Setter for <code>chrono.hwlcell.hwucell_remark</code>.
     */
    public void setHwucellRemark(String value) {
        set(45, value);
    }

    /**
     * Getter for <code>chrono.hwlcell.hwucell_remark</code>.
     */
    public String getHwucellRemark() {
        return (String) get(45);
    }

    /**
     * Setter for <code>chrono.hwlcell.DLBANDWIDTH</code>.
     */
    public void setDlbandwidth(String value) {
        set(46, value);
    }

    /**
     * Getter for <code>chrono.hwlcell.DLBANDWIDTH</code>.
     */
    public String getDlbandwidth() {
        return (String) get(46);
    }

    /**
     * Setter for <code>chrono.hwlcell.FREQBAND</code>.
     */
    public void setFreqband(String value) {
        set(47, value);
    }

    /**
     * Getter for <code>chrono.hwlcell.FREQBAND</code>.
     */
    public String getFreqband() {
        return (String) get(47);
    }

    /**
     * Setter for <code>chrono.hwlcell.LATITUDEGPS</code>.
     */
    public void setLatitudegps(String value) {
        set(48, value);
    }

    /**
     * Getter for <code>chrono.hwlcell.LATITUDEGPS</code>.
     */
    public String getLatitudegps() {
        return (String) get(48);
    }

    /**
     * Setter for <code>chrono.hwlcell.LONGITUDEGPS</code>.
     */
    public void setLongitudegps(String value) {
        set(49, value);
    }

    /**
     * Getter for <code>chrono.hwlcell.LONGITUDEGPS</code>.
     */
    public String getLongitudegps() {
        return (String) get(49);
    }

    /**
     * Setter for <code>chrono.hwlcell.DLCUSTSTARTPRBINDEX</code>.
     */
    public void setDlcuststartprbindex(String value) {
        set(50, value);
    }

    /**
     * Getter for <code>chrono.hwlcell.DLCUSTSTARTPRBINDEX</code>.
     */
    public String getDlcuststartprbindex() {
        return (String) get(50);
    }

    /**
     * Setter for <code>chrono.hwlcell.DLCUSTENDPRBINDEX</code>.
     */
    public void setDlcustendprbindex(String value) {
        set(51, value);
    }

    /**
     * Getter for <code>chrono.hwlcell.DLCUSTENDPRBINDEX</code>.
     */
    public String getDlcustendprbindex() {
        return (String) get(51);
    }

    /**
     * Setter for <code>chrono.hwlcell.EXTPROP1</code>.
     */
    public void setExtprop1(Integer value) {
        set(52, value);
    }

    /**
     * Getter for <code>chrono.hwlcell.EXTPROP1</code>.
     */
    public Integer getExtprop1() {
        return (Integer) get(52);
    }

    /**
     * Setter for <code>chrono.hwlcell.EXTPROP2</code>.
     */
    public void setExtprop2(String value) {
        set(53, value);
    }

    /**
     * Getter for <code>chrono.hwlcell.EXTPROP2</code>.
     */
    public String getExtprop2() {
        return (String) get(53);
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
     * Create a detached HwlcellRecord
     */
    public HwlcellRecord() {
        super(Hwlcell.HWLCELL);
    }

    /**
     * Create a detached, initialised HwlcellRecord
     */
    public HwlcellRecord(ULong hwlcellId, ULong hwlcellCrcollectortaskfiles, UInteger hwlcellDate, Integer hwlcellDatefrom, ULong hwlcellHwenodeb, Integer hwlcellNodealias, Integer hwlcellCell, Integer hwlcellCellclass, Integer hwlcellCellclassgroup, Integer hwlcellCellcoverage, Integer hwlcellRevenueclass, Integer hwlcellCellstatus, Integer hwlcellVendor, Double hwlcellLatitude, Double hwlcellLongitude, Byte hwlcellNamingvalid, String cellid, String fdn, String cellactivestate, String cellname, String dlearfcn, String ulearfcn, Double dlfreq, Double ulfreq, String enodebfunctionname, String fddtddind, String localcellid, String moindex, String phycellid, String txrxmode, String ulbandwidth, String ulcyclicprefix, String cnoperatorname, String mcc, String mnc, String nbiottaflag, String enodebid, String genodebid, String tac, String tai, String eci, String ecgi, String trackingareaid, String latitude, String longitude, String hwucellRemark, String dlbandwidth, String freqband, String latitudegps, String longitudegps, String dlcuststartprbindex, String dlcustendprbindex, Integer extprop1, String extprop2) {
        super(Hwlcell.HWLCELL);

        set(0, hwlcellId);
        set(1, hwlcellCrcollectortaskfiles);
        set(2, hwlcellDate);
        set(3, hwlcellDatefrom);
        set(4, hwlcellHwenodeb);
        set(5, hwlcellNodealias);
        set(6, hwlcellCell);
        set(7, hwlcellCellclass);
        set(8, hwlcellCellclassgroup);
        set(9, hwlcellCellcoverage);
        set(10, hwlcellRevenueclass);
        set(11, hwlcellCellstatus);
        set(12, hwlcellVendor);
        set(13, hwlcellLatitude);
        set(14, hwlcellLongitude);
        set(15, hwlcellNamingvalid);
        set(16, cellid);
        set(17, fdn);
        set(18, cellactivestate);
        set(19, cellname);
        set(20, dlearfcn);
        set(21, ulearfcn);
        set(22, dlfreq);
        set(23, ulfreq);
        set(24, enodebfunctionname);
        set(25, fddtddind);
        set(26, localcellid);
        set(27, moindex);
        set(28, phycellid);
        set(29, txrxmode);
        set(30, ulbandwidth);
        set(31, ulcyclicprefix);
        set(32, cnoperatorname);
        set(33, mcc);
        set(34, mnc);
        set(35, nbiottaflag);
        set(36, enodebid);
        set(37, genodebid);
        set(38, tac);
        set(39, tai);
        set(40, eci);
        set(41, ecgi);
        set(42, trackingareaid);
        set(43, latitude);
        set(44, longitude);
        set(45, hwucellRemark);
        set(46, dlbandwidth);
        set(47, freqband);
        set(48, latitudegps);
        set(49, longitudegps);
        set(50, dlcuststartprbindex);
        set(51, dlcustendprbindex);
        set(52, extprop1);
        set(53, extprop2);
    }
}
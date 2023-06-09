/*
 * This file is generated by jOOQ.
*/
package id.mit.chrono.server.model.tables.records;


import id.mit.chrono.server.model.tables.Hwncell;

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
public class HwncellRecord extends UpdatableRecordImpl<HwncellRecord> {

    private static final long serialVersionUID = -1730705662;

    /**
     * Setter for <code>chrono.hwncell.hwncell_id</code>.
     */
    public void setHwncellId(ULong value) {
        set(0, value);
    }

    /**
     * Getter for <code>chrono.hwncell.hwncell_id</code>.
     */
    public ULong getHwncellId() {
        return (ULong) get(0);
    }

    /**
     * Setter for <code>chrono.hwncell.hwncell_crcollectortaskfiles</code>.
     */
    public void setHwncellCrcollectortaskfiles(ULong value) {
        set(1, value);
    }

    /**
     * Getter for <code>chrono.hwncell.hwncell_crcollectortaskfiles</code>.
     */
    public ULong getHwncellCrcollectortaskfiles() {
        return (ULong) get(1);
    }

    /**
     * Setter for <code>chrono.hwncell.hwncell_date</code>.
     */
    public void setHwncellDate(UInteger value) {
        set(2, value);
    }

    /**
     * Getter for <code>chrono.hwncell.hwncell_date</code>.
     */
    public UInteger getHwncellDate() {
        return (UInteger) get(2);
    }

    /**
     * Setter for <code>chrono.hwncell.hwncell_datefrom</code>.
     */
    public void setHwncellDatefrom(Integer value) {
        set(3, value);
    }

    /**
     * Getter for <code>chrono.hwncell.hwncell_datefrom</code>.
     */
    public Integer getHwncellDatefrom() {
        return (Integer) get(3);
    }

    /**
     * Setter for <code>chrono.hwncell.hwncell_hwgnodeb</code>.
     */
    public void setHwncellHwgnodeb(ULong value) {
        set(4, value);
    }

    /**
     * Getter for <code>chrono.hwncell.hwncell_hwgnodeb</code>.
     */
    public ULong getHwncellHwgnodeb() {
        return (ULong) get(4);
    }

    /**
     * Setter for <code>chrono.hwncell.hwncell_nodealias</code>.
     */
    public void setHwncellNodealias(Integer value) {
        set(5, value);
    }

    /**
     * Getter for <code>chrono.hwncell.hwncell_nodealias</code>.
     */
    public Integer getHwncellNodealias() {
        return (Integer) get(5);
    }

    /**
     * Setter for <code>chrono.hwncell.hwncell_cell</code>.
     */
    public void setHwncellCell(Integer value) {
        set(6, value);
    }

    /**
     * Getter for <code>chrono.hwncell.hwncell_cell</code>.
     */
    public Integer getHwncellCell() {
        return (Integer) get(6);
    }

    /**
     * Setter for <code>chrono.hwncell.hwncell_cellclass</code>.
     */
    public void setHwncellCellclass(Integer value) {
        set(7, value);
    }

    /**
     * Getter for <code>chrono.hwncell.hwncell_cellclass</code>.
     */
    public Integer getHwncellCellclass() {
        return (Integer) get(7);
    }

    /**
     * Setter for <code>chrono.hwncell.hwncell_cellclassgroup</code>.
     */
    public void setHwncellCellclassgroup(Integer value) {
        set(8, value);
    }

    /**
     * Getter for <code>chrono.hwncell.hwncell_cellclassgroup</code>.
     */
    public Integer getHwncellCellclassgroup() {
        return (Integer) get(8);
    }

    /**
     * Setter for <code>chrono.hwncell.hwncell_cellcoverage</code>.
     */
    public void setHwncellCellcoverage(Integer value) {
        set(9, value);
    }

    /**
     * Getter for <code>chrono.hwncell.hwncell_cellcoverage</code>.
     */
    public Integer getHwncellCellcoverage() {
        return (Integer) get(9);
    }

    /**
     * Setter for <code>chrono.hwncell.hwncell_revenueclass</code>.
     */
    public void setHwncellRevenueclass(Integer value) {
        set(10, value);
    }

    /**
     * Getter for <code>chrono.hwncell.hwncell_revenueclass</code>.
     */
    public Integer getHwncellRevenueclass() {
        return (Integer) get(10);
    }

    /**
     * Setter for <code>chrono.hwncell.hwncell_cellstatus</code>.
     */
    public void setHwncellCellstatus(Integer value) {
        set(11, value);
    }

    /**
     * Getter for <code>chrono.hwncell.hwncell_cellstatus</code>.
     */
    public Integer getHwncellCellstatus() {
        return (Integer) get(11);
    }

    /**
     * Setter for <code>chrono.hwncell.hwncell_vendor</code>.
     */
    public void setHwncellVendor(Integer value) {
        set(12, value);
    }

    /**
     * Getter for <code>chrono.hwncell.hwncell_vendor</code>.
     */
    public Integer getHwncellVendor() {
        return (Integer) get(12);
    }

    /**
     * Setter for <code>chrono.hwncell.hwncell_latitude</code>.
     */
    public void setHwncellLatitude(Double value) {
        set(13, value);
    }

    /**
     * Getter for <code>chrono.hwncell.hwncell_latitude</code>.
     */
    public Double getHwncellLatitude() {
        return (Double) get(13);
    }

    /**
     * Setter for <code>chrono.hwncell.hwncell_longitude</code>.
     */
    public void setHwncellLongitude(Double value) {
        set(14, value);
    }

    /**
     * Getter for <code>chrono.hwncell.hwncell_longitude</code>.
     */
    public Double getHwncellLongitude() {
        return (Double) get(14);
    }

    /**
     * Setter for <code>chrono.hwncell.hwncell_namingvalid</code>.
     */
    public void setHwncellNamingvalid(Byte value) {
        set(15, value);
    }

    /**
     * Getter for <code>chrono.hwncell.hwncell_namingvalid</code>.
     */
    public Byte getHwncellNamingvalid() {
        return (Byte) get(15);
    }

    /**
     * Setter for <code>chrono.hwncell.CELLID</code>.
     */
    public void setCellid(String value) {
        set(16, value);
    }

    /**
     * Getter for <code>chrono.hwncell.CELLID</code>.
     */
    public String getCellid() {
        return (String) get(16);
    }

    /**
     * Setter for <code>chrono.hwncell.FDN</code>.
     */
    public void setFdn(String value) {
        set(17, value);
    }

    /**
     * Getter for <code>chrono.hwncell.FDN</code>.
     */
    public String getFdn() {
        return (String) get(17);
    }

    /**
     * Setter for <code>chrono.hwncell.CELLACTIVESTATE</code>.
     */
    public void setCellactivestate(String value) {
        set(18, value);
    }

    /**
     * Getter for <code>chrono.hwncell.CELLACTIVESTATE</code>.
     */
    public String getCellactivestate() {
        return (String) get(18);
    }

    /**
     * Setter for <code>chrono.hwncell.CELLNAME</code>.
     */
    public void setCellname(String value) {
        set(19, value);
    }

    /**
     * Getter for <code>chrono.hwncell.CELLNAME</code>.
     */
    public String getCellname() {
        return (String) get(19);
    }

    /**
     * Setter for <code>chrono.hwncell.DLNARFCN</code>.
     */
    public void setDlnarfcn(String value) {
        set(20, value);
    }

    /**
     * Getter for <code>chrono.hwncell.DLNARFCN</code>.
     */
    public String getDlnarfcn() {
        return (String) get(20);
    }

    /**
     * Setter for <code>chrono.hwncell.ULNARFCN</code>.
     */
    public void setUlnarfcn(String value) {
        set(21, value);
    }

    /**
     * Getter for <code>chrono.hwncell.ULNARFCN</code>.
     */
    public String getUlnarfcn() {
        return (String) get(21);
    }

    /**
     * Setter for <code>chrono.hwncell.DLFREQ</code>.
     */
    public void setDlfreq(Double value) {
        set(22, value);
    }

    /**
     * Getter for <code>chrono.hwncell.DLFREQ</code>.
     */
    public Double getDlfreq() {
        return (Double) get(22);
    }

    /**
     * Setter for <code>chrono.hwncell.ULFREQ</code>.
     */
    public void setUlfreq(Double value) {
        set(23, value);
    }

    /**
     * Getter for <code>chrono.hwncell.ULFREQ</code>.
     */
    public Double getUlfreq() {
        return (Double) get(23);
    }

    /**
     * Setter for <code>chrono.hwncell.GNODEBFUNCTIONNAME</code>.
     */
    public void setGnodebfunctionname(String value) {
        set(24, value);
    }

    /**
     * Getter for <code>chrono.hwncell.GNODEBFUNCTIONNAME</code>.
     */
    public String getGnodebfunctionname() {
        return (String) get(24);
    }

    /**
     * Setter for <code>chrono.hwncell.DUPLEXMODE</code>.
     */
    public void setDuplexmode(String value) {
        set(25, value);
    }

    /**
     * Getter for <code>chrono.hwncell.DUPLEXMODE</code>.
     */
    public String getDuplexmode() {
        return (String) get(25);
    }

    /**
     * Setter for <code>chrono.hwncell.LOCALCELLID</code>.
     */
    public void setLocalcellid(String value) {
        set(26, value);
    }

    /**
     * Getter for <code>chrono.hwncell.LOCALCELLID</code>.
     */
    public String getLocalcellid() {
        return (String) get(26);
    }

    /**
     * Setter for <code>chrono.hwncell.MOINDEX</code>.
     */
    public void setMoindex(String value) {
        set(27, value);
    }

    /**
     * Getter for <code>chrono.hwncell.MOINDEX</code>.
     */
    public String getMoindex() {
        return (String) get(27);
    }

    /**
     * Setter for <code>chrono.hwncell.PHYSICALCELLID</code>.
     */
    public void setPhysicalcellid(String value) {
        set(28, value);
    }

    /**
     * Getter for <code>chrono.hwncell.PHYSICALCELLID</code>.
     */
    public String getPhysicalcellid() {
        return (String) get(28);
    }

    /**
     * Setter for <code>chrono.hwncell.TXRXMODE</code>.
     */
    public void setTxrxmode(String value) {
        set(29, value);
    }

    /**
     * Getter for <code>chrono.hwncell.TXRXMODE</code>.
     */
    public String getTxrxmode() {
        return (String) get(29);
    }

    /**
     * Setter for <code>chrono.hwncell.ULBANDWIDTH</code>.
     */
    public void setUlbandwidth(String value) {
        set(30, value);
    }

    /**
     * Getter for <code>chrono.hwncell.ULBANDWIDTH</code>.
     */
    public String getUlbandwidth() {
        return (String) get(30);
    }

    /**
     * Setter for <code>chrono.hwncell.ULCYCLICPREFIX</code>.
     */
    public void setUlcyclicprefix(String value) {
        set(31, value);
    }

    /**
     * Getter for <code>chrono.hwncell.ULCYCLICPREFIX</code>.
     */
    public String getUlcyclicprefix() {
        return (String) get(31);
    }

    /**
     * Setter for <code>chrono.hwncell.CNOPERATORNAME</code>.
     */
    public void setCnoperatorname(String value) {
        set(32, value);
    }

    /**
     * Getter for <code>chrono.hwncell.CNOPERATORNAME</code>.
     */
    public String getCnoperatorname() {
        return (String) get(32);
    }

    /**
     * Setter for <code>chrono.hwncell.MCC</code>.
     */
    public void setMcc(String value) {
        set(33, value);
    }

    /**
     * Getter for <code>chrono.hwncell.MCC</code>.
     */
    public String getMcc() {
        return (String) get(33);
    }

    /**
     * Setter for <code>chrono.hwncell.MNC</code>.
     */
    public void setMnc(String value) {
        set(34, value);
    }

    /**
     * Getter for <code>chrono.hwncell.MNC</code>.
     */
    public String getMnc() {
        return (String) get(34);
    }

    /**
     * Setter for <code>chrono.hwncell.NBIOTTAFLAG</code>.
     */
    public void setNbiottaflag(String value) {
        set(35, value);
    }

    /**
     * Getter for <code>chrono.hwncell.NBIOTTAFLAG</code>.
     */
    public String getNbiottaflag() {
        return (String) get(35);
    }

    /**
     * Setter for <code>chrono.hwncell.GNODEBID</code>.
     */
    public void setGnodebid(String value) {
        set(36, value);
    }

    /**
     * Getter for <code>chrono.hwncell.GNODEBID</code>.
     */
    public String getGnodebid() {
        return (String) get(36);
    }

    /**
     * Setter for <code>chrono.hwncell.GGNODEBID</code>.
     */
    public void setGgnodebid(String value) {
        set(37, value);
    }

    /**
     * Getter for <code>chrono.hwncell.GGNODEBID</code>.
     */
    public String getGgnodebid() {
        return (String) get(37);
    }

    /**
     * Setter for <code>chrono.hwncell.TAC</code>.
     */
    public void setTac(String value) {
        set(38, value);
    }

    /**
     * Getter for <code>chrono.hwncell.TAC</code>.
     */
    public String getTac() {
        return (String) get(38);
    }

    /**
     * Setter for <code>chrono.hwncell.TAI</code>.
     */
    public void setTai(String value) {
        set(39, value);
    }

    /**
     * Getter for <code>chrono.hwncell.TAI</code>.
     */
    public String getTai() {
        return (String) get(39);
    }

    /**
     * Setter for <code>chrono.hwncell.NCI</code>.
     */
    public void setNci(String value) {
        set(40, value);
    }

    /**
     * Getter for <code>chrono.hwncell.NCI</code>.
     */
    public String getNci() {
        return (String) get(40);
    }

    /**
     * Setter for <code>chrono.hwncell.NCGI</code>.
     */
    public void setNcgi(String value) {
        set(41, value);
    }

    /**
     * Getter for <code>chrono.hwncell.NCGI</code>.
     */
    public String getNcgi() {
        return (String) get(41);
    }

    /**
     * Setter for <code>chrono.hwncell.TRACKINGAREAID</code>.
     */
    public void setTrackingareaid(String value) {
        set(42, value);
    }

    /**
     * Getter for <code>chrono.hwncell.TRACKINGAREAID</code>.
     */
    public String getTrackingareaid() {
        return (String) get(42);
    }

    /**
     * Setter for <code>chrono.hwncell.LATITUDE</code>.
     */
    public void setLatitude(String value) {
        set(43, value);
    }

    /**
     * Getter for <code>chrono.hwncell.LATITUDE</code>.
     */
    public String getLatitude() {
        return (String) get(43);
    }

    /**
     * Setter for <code>chrono.hwncell.LONGITUDE</code>.
     */
    public void setLongitude(String value) {
        set(44, value);
    }

    /**
     * Getter for <code>chrono.hwncell.LONGITUDE</code>.
     */
    public String getLongitude() {
        return (String) get(44);
    }

    /**
     * Setter for <code>chrono.hwncell.hwucell_remark</code>.
     */
    public void setHwucellRemark(String value) {
        set(45, value);
    }

    /**
     * Getter for <code>chrono.hwncell.hwucell_remark</code>.
     */
    public String getHwucellRemark() {
        return (String) get(45);
    }

    /**
     * Setter for <code>chrono.hwncell.DLBANDWIDTH</code>.
     */
    public void setDlbandwidth(String value) {
        set(46, value);
    }

    /**
     * Getter for <code>chrono.hwncell.DLBANDWIDTH</code>.
     */
    public String getDlbandwidth() {
        return (String) get(46);
    }

    /**
     * Setter for <code>chrono.hwncell.FREQUENCYBAND</code>.
     */
    public void setFrequencyband(String value) {
        set(47, value);
    }

    /**
     * Getter for <code>chrono.hwncell.FREQUENCYBAND</code>.
     */
    public String getFrequencyband() {
        return (String) get(47);
    }

    /**
     * Setter for <code>chrono.hwncell.LATITUDEGPS</code>.
     */
    public void setLatitudegps(String value) {
        set(48, value);
    }

    /**
     * Getter for <code>chrono.hwncell.LATITUDEGPS</code>.
     */
    public String getLatitudegps() {
        return (String) get(48);
    }

    /**
     * Setter for <code>chrono.hwncell.LONGITUDEGPS</code>.
     */
    public void setLongitudegps(String value) {
        set(49, value);
    }

    /**
     * Getter for <code>chrono.hwncell.LONGITUDEGPS</code>.
     */
    public String getLongitudegps() {
        return (String) get(49);
    }

    /**
     * Setter for <code>chrono.hwncell.DLCUSTSTARTPRBINDEX</code>.
     */
    public void setDlcuststartprbindex(String value) {
        set(50, value);
    }

    /**
     * Getter for <code>chrono.hwncell.DLCUSTSTARTPRBINDEX</code>.
     */
    public String getDlcuststartprbindex() {
        return (String) get(50);
    }

    /**
     * Setter for <code>chrono.hwncell.DLCUSTENDPRBINDEX</code>.
     */
    public void setDlcustendprbindex(String value) {
        set(51, value);
    }

    /**
     * Getter for <code>chrono.hwncell.DLCUSTENDPRBINDEX</code>.
     */
    public String getDlcustendprbindex() {
        return (String) get(51);
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
     * Create a detached HwncellRecord
     */
    public HwncellRecord() {
        super(Hwncell.HWNCELL);
    }

    /**
     * Create a detached, initialised HwncellRecord
     */
    public HwncellRecord(ULong hwncellId, ULong hwncellCrcollectortaskfiles, UInteger hwncellDate, Integer hwncellDatefrom, ULong hwncellHwgnodeb, Integer hwncellNodealias, Integer hwncellCell, Integer hwncellCellclass, Integer hwncellCellclassgroup, Integer hwncellCellcoverage, Integer hwncellRevenueclass, Integer hwncellCellstatus, Integer hwncellVendor, Double hwncellLatitude, Double hwncellLongitude, Byte hwncellNamingvalid, String cellid, String fdn, String cellactivestate, String cellname, String dlnarfcn, String ulnarfcn, Double dlfreq, Double ulfreq, String gnodebfunctionname, String duplexmode, String localcellid, String moindex, String physicalcellid, String txrxmode, String ulbandwidth, String ulcyclicprefix, String cnoperatorname, String mcc, String mnc, String nbiottaflag, String gnodebid, String ggnodebid, String tac, String tai, String nci, String ncgi, String trackingareaid, String latitude, String longitude, String hwucellRemark, String dlbandwidth, String frequencyband, String latitudegps, String longitudegps, String dlcuststartprbindex, String dlcustendprbindex) {
        super(Hwncell.HWNCELL);

        set(0, hwncellId);
        set(1, hwncellCrcollectortaskfiles);
        set(2, hwncellDate);
        set(3, hwncellDatefrom);
        set(4, hwncellHwgnodeb);
        set(5, hwncellNodealias);
        set(6, hwncellCell);
        set(7, hwncellCellclass);
        set(8, hwncellCellclassgroup);
        set(9, hwncellCellcoverage);
        set(10, hwncellRevenueclass);
        set(11, hwncellCellstatus);
        set(12, hwncellVendor);
        set(13, hwncellLatitude);
        set(14, hwncellLongitude);
        set(15, hwncellNamingvalid);
        set(16, cellid);
        set(17, fdn);
        set(18, cellactivestate);
        set(19, cellname);
        set(20, dlnarfcn);
        set(21, ulnarfcn);
        set(22, dlfreq);
        set(23, ulfreq);
        set(24, gnodebfunctionname);
        set(25, duplexmode);
        set(26, localcellid);
        set(27, moindex);
        set(28, physicalcellid);
        set(29, txrxmode);
        set(30, ulbandwidth);
        set(31, ulcyclicprefix);
        set(32, cnoperatorname);
        set(33, mcc);
        set(34, mnc);
        set(35, nbiottaflag);
        set(36, gnodebid);
        set(37, ggnodebid);
        set(38, tac);
        set(39, tai);
        set(40, nci);
        set(41, ncgi);
        set(42, trackingareaid);
        set(43, latitude);
        set(44, longitude);
        set(45, hwucellRemark);
        set(46, dlbandwidth);
        set(47, frequencyband);
        set(48, latitudegps);
        set(49, longitudegps);
        set(50, dlcuststartprbindex);
        set(51, dlcustendprbindex);
    }
}

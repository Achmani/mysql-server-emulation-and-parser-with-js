/*
 * This file is generated by jOOQ.
*/
package id.mit.chrono.server.model.tables.records;


import id.mit.chrono.server.model.tables.Hwenodeb;

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
public class HwenodebRecord extends UpdatableRecordImpl<HwenodebRecord> {

    private static final long serialVersionUID = -737220188;

    /**
     * Setter for <code>chrono.hwenodeb.hwenodeb_id</code>.
     */
    public void setHwenodebId(ULong value) {
        set(0, value);
    }

    /**
     * Getter for <code>chrono.hwenodeb.hwenodeb_id</code>.
     */
    public ULong getHwenodebId() {
        return (ULong) get(0);
    }

    /**
     * Setter for <code>chrono.hwenodeb.hwenodeb_crcollectortaskfiles</code>.
     */
    public void setHwenodebCrcollectortaskfiles(ULong value) {
        set(1, value);
    }

    /**
     * Getter for <code>chrono.hwenodeb.hwenodeb_crcollectortaskfiles</code>.
     */
    public ULong getHwenodebCrcollectortaskfiles() {
        return (ULong) get(1);
    }

    /**
     * Setter for <code>chrono.hwenodeb.hwenodeb_date</code>.
     */
    public void setHwenodebDate(UInteger value) {
        set(2, value);
    }

    /**
     * Getter for <code>chrono.hwenodeb.hwenodeb_date</code>.
     */
    public UInteger getHwenodebDate() {
        return (UInteger) get(2);
    }

    /**
     * Setter for <code>chrono.hwenodeb.hwenodeb_datefrom</code>.
     */
    public void setHwenodebDatefrom(Integer value) {
        set(3, value);
    }

    /**
     * Getter for <code>chrono.hwenodeb.hwenodeb_datefrom</code>.
     */
    public Integer getHwenodebDatefrom() {
        return (Integer) get(3);
    }

    /**
     * Setter for <code>chrono.hwenodeb.hwenodeb_node</code>.
     */
    public void setHwenodebNode(Integer value) {
        set(4, value);
    }

    /**
     * Getter for <code>chrono.hwenodeb.hwenodeb_node</code>.
     */
    public Integer getHwenodebNode() {
        return (Integer) get(4);
    }

    /**
     * Setter for <code>chrono.hwenodeb.hwenodeb_nodephysical</code>.
     */
    public void setHwenodebNodephysical(Integer value) {
        set(5, value);
    }

    /**
     * Getter for <code>chrono.hwenodeb.hwenodeb_nodephysical</code>.
     */
    public Integer getHwenodebNodephysical() {
        return (Integer) get(5);
    }

    /**
     * Setter for <code>chrono.hwenodeb.hwenodeb_nodestatus</code>.
     */
    public void setHwenodebNodestatus(Integer value) {
        set(6, value);
    }

    /**
     * Getter for <code>chrono.hwenodeb.hwenodeb_nodestatus</code>.
     */
    public Integer getHwenodebNodestatus() {
        return (Integer) get(6);
    }

    /**
     * Setter for <code>chrono.hwenodeb.hwenodeb_revenueclass</code>.
     */
    public void setHwenodebRevenueclass(Integer value) {
        set(7, value);
    }

    /**
     * Getter for <code>chrono.hwenodeb.hwenodeb_revenueclass</code>.
     */
    public Integer getHwenodebRevenueclass() {
        return (Integer) get(7);
    }

    /**
     * Setter for <code>chrono.hwenodeb.hwenodeb_vendor</code>.
     */
    public void setHwenodebVendor(Integer value) {
        set(8, value);
    }

    /**
     * Getter for <code>chrono.hwenodeb.hwenodeb_vendor</code>.
     */
    public Integer getHwenodebVendor() {
        return (Integer) get(8);
    }

    /**
     * Setter for <code>chrono.hwenodeb.hwenodeb_namingvalid</code>.
     */
    public void setHwenodebNamingvalid(Byte value) {
        set(9, value);
    }

    /**
     * Getter for <code>chrono.hwenodeb.hwenodeb_namingvalid</code>.
     */
    public Byte getHwenodebNamingvalid() {
        return (Byte) get(9);
    }

    /**
     * Setter for <code>chrono.hwenodeb.TOTALCELL</code>.
     */
    public void setTotalcell(Integer value) {
        set(10, value);
    }

    /**
     * Getter for <code>chrono.hwenodeb.TOTALCELL</code>.
     */
    public Integer getTotalcell() {
        return (Integer) get(10);
    }

    /**
     * Setter for <code>chrono.hwenodeb.ENODEBID</code>.
     */
    public void setEnodebid(String value) {
        set(11, value);
    }

    /**
     * Getter for <code>chrono.hwenodeb.ENODEBID</code>.
     */
    public String getEnodebid() {
        return (String) get(11);
    }

    /**
     * Setter for <code>chrono.hwenodeb.ENODEBFUNCTIONNAME</code>.
     */
    public void setEnodebfunctionname(String value) {
        set(12, value);
    }

    /**
     * Getter for <code>chrono.hwenodeb.ENODEBFUNCTIONNAME</code>.
     */
    public String getEnodebfunctionname() {
        return (String) get(12);
    }

    /**
     * Setter for <code>chrono.hwenodeb.FDN</code>.
     */
    public void setFdn(String value) {
        set(13, value);
    }

    /**
     * Getter for <code>chrono.hwenodeb.FDN</code>.
     */
    public String getFdn() {
        return (String) get(13);
    }

    /**
     * Setter for <code>chrono.hwenodeb.MOINDEX</code>.
     */
    public void setMoindex(String value) {
        set(14, value);
    }

    /**
     * Getter for <code>chrono.hwenodeb.MOINDEX</code>.
     */
    public String getMoindex() {
        return (String) get(14);
    }

    /**
     * Setter for <code>chrono.hwenodeb.USERLABEL</code>.
     */
    public void setUserlabel(String value) {
        set(15, value);
    }

    /**
     * Getter for <code>chrono.hwenodeb.USERLABEL</code>.
     */
    public String getUserlabel() {
        return (String) get(15);
    }

    /**
     * Setter for <code>chrono.hwenodeb.NAME</code>.
     */
    public void setName(String value) {
        set(16, value);
    }

    /**
     * Getter for <code>chrono.hwenodeb.NAME</code>.
     */
    public String getName() {
        return (String) get(16);
    }

    /**
     * Setter for <code>chrono.hwenodeb.NEID</code>.
     */
    public void setNeid(String value) {
        set(17, value);
    }

    /**
     * Getter for <code>chrono.hwenodeb.NEID</code>.
     */
    public String getNeid() {
        return (String) get(17);
    }

    /**
     * Setter for <code>chrono.hwenodeb.IP</code>.
     */
    public void setIp(String value) {
        set(18, value);
    }

    /**
     * Getter for <code>chrono.hwenodeb.IP</code>.
     */
    public String getIp() {
        return (String) get(18);
    }

    /**
     * Setter for <code>chrono.hwenodeb.MATCHVERSION</code>.
     */
    public void setMatchversion(String value) {
        set(19, value);
    }

    /**
     * Getter for <code>chrono.hwenodeb.MATCHVERSION</code>.
     */
    public String getMatchversion() {
        return (String) get(19);
    }

    /**
     * Setter for <code>chrono.hwenodeb.NETYPE</code>.
     */
    public void setNetype(String value) {
        set(20, value);
    }

    /**
     * Getter for <code>chrono.hwenodeb.NETYPE</code>.
     */
    public String getNetype() {
        return (String) get(20);
    }

    /**
     * Setter for <code>chrono.hwenodeb.NEVERSION</code>.
     */
    public void setNeversion(String value) {
        set(21, value);
    }

    /**
     * Getter for <code>chrono.hwenodeb.NEVERSION</code>.
     */
    public String getNeversion() {
        return (String) get(21);
    }

    /**
     * Setter for <code>chrono.hwenodeb.GBTSVERSION</code>.
     */
    public void setGbtsversion(String value) {
        set(22, value);
    }

    /**
     * Getter for <code>chrono.hwenodeb.GBTSVERSION</code>.
     */
    public String getGbtsversion() {
        return (String) get(22);
    }

    /**
     * Setter for <code>chrono.hwenodeb.NODEVERSION</code>.
     */
    public void setNodeversion(String value) {
        set(23, value);
    }

    /**
     * Getter for <code>chrono.hwenodeb.NODEVERSION</code>.
     */
    public String getNodeversion() {
        return (String) get(23);
    }

    /**
     * Setter for <code>chrono.hwenodeb.ENODEBVERSION</code>.
     */
    public void setEnodebversion(String value) {
        set(24, value);
    }

    /**
     * Getter for <code>chrono.hwenodeb.ENODEBVERSION</code>.
     */
    public String getEnodebversion() {
        return (String) get(24);
    }

    /**
     * Setter for <code>chrono.hwenodeb.TIMEZONE</code>.
     */
    public void setTimezone(String value) {
        set(25, value);
    }

    /**
     * Getter for <code>chrono.hwenodeb.TIMEZONE</code>.
     */
    public String getTimezone() {
        return (String) get(25);
    }

    /**
     * Setter for <code>chrono.hwenodeb.CNOPERATORNAME</code>.
     */
    public void setCnoperatorname(String value) {
        set(26, value);
    }

    /**
     * Getter for <code>chrono.hwenodeb.CNOPERATORNAME</code>.
     */
    public String getCnoperatorname() {
        return (String) get(26);
    }

    /**
     * Setter for <code>chrono.hwenodeb.MCC</code>.
     */
    public void setMcc(String value) {
        set(27, value);
    }

    /**
     * Getter for <code>chrono.hwenodeb.MCC</code>.
     */
    public String getMcc() {
        return (String) get(27);
    }

    /**
     * Setter for <code>chrono.hwenodeb.MNC</code>.
     */
    public void setMnc(String value) {
        set(28, value);
    }

    /**
     * Getter for <code>chrono.hwenodeb.MNC</code>.
     */
    public String getMnc() {
        return (String) get(28);
    }

    /**
     * Setter for <code>chrono.hwenodeb.NBIOTTAFLAG</code>.
     */
    public void setNbiottaflag(String value) {
        set(29, value);
    }

    /**
     * Getter for <code>chrono.hwenodeb.NBIOTTAFLAG</code>.
     */
    public String getNbiottaflag() {
        return (String) get(29);
    }

    /**
     * Setter for <code>chrono.hwenodeb.TAC</code>.
     */
    public void setTac(String value) {
        set(30, value);
    }

    /**
     * Getter for <code>chrono.hwenodeb.TAC</code>.
     */
    public String getTac() {
        return (String) get(30);
    }

    /**
     * Setter for <code>chrono.hwenodeb.TRACKINGAREAID</code>.
     */
    public void setTrackingareaid(String value) {
        set(31, value);
    }

    /**
     * Getter for <code>chrono.hwenodeb.TRACKINGAREAID</code>.
     */
    public String getTrackingareaid() {
        return (String) get(31);
    }

    /**
     * Setter for <code>chrono.hwenodeb.GENODEBID</code>.
     */
    public void setGenodebid(String value) {
        set(32, value);
    }

    /**
     * Getter for <code>chrono.hwenodeb.GENODEBID</code>.
     */
    public String getGenodebid() {
        return (String) get(32);
    }

    /**
     * Setter for <code>chrono.hwenodeb.ADJNODEID</code>.
     */
    public void setAdjnodeid(String value) {
        set(33, value);
    }

    /**
     * Getter for <code>chrono.hwenodeb.ADJNODEID</code>.
     */
    public String getAdjnodeid() {
        return (String) get(33);
    }

    /**
     * Setter for <code>chrono.hwenodeb.LATITUDEDEGFORMAT</code>.
     */
    public void setLatitudedegformat(String value) {
        set(34, value);
    }

    /**
     * Getter for <code>chrono.hwenodeb.LATITUDEDEGFORMAT</code>.
     */
    public String getLatitudedegformat() {
        return (String) get(34);
    }

    /**
     * Setter for <code>chrono.hwenodeb.LONGITUDEDEGFORMAT</code>.
     */
    public void setLongitudedegformat(String value) {
        set(35, value);
    }

    /**
     * Getter for <code>chrono.hwenodeb.LONGITUDEDEGFORMAT</code>.
     */
    public String getLongitudedegformat() {
        return (String) get(35);
    }

    /**
     * Setter for <code>chrono.hwenodeb.hwenodeb_remark</code>.
     */
    public void setHwenodebRemark(String value) {
        set(36, value);
    }

    /**
     * Getter for <code>chrono.hwenodeb.hwenodeb_remark</code>.
     */
    public String getHwenodebRemark() {
        return (String) get(36);
    }

    /**
     * Setter for <code>chrono.hwenodeb.LATITUDEGPS</code>.
     */
    public void setLatitudegps(String value) {
        set(37, value);
    }

    /**
     * Getter for <code>chrono.hwenodeb.LATITUDEGPS</code>.
     */
    public String getLatitudegps() {
        return (String) get(37);
    }

    /**
     * Setter for <code>chrono.hwenodeb.LONGITUDEGPS</code>.
     */
    public void setLongitudegps(String value) {
        set(38, value);
    }

    /**
     * Getter for <code>chrono.hwenodeb.LONGITUDEGPS</code>.
     */
    public String getLongitudegps() {
        return (String) get(38);
    }

    /**
     * Setter for <code>chrono.hwenodeb.EXTPROP1</code>.
     */
    public void setExtprop1(Integer value) {
        set(39, value);
    }

    /**
     * Getter for <code>chrono.hwenodeb.EXTPROP1</code>.
     */
    public Integer getExtprop1() {
        return (Integer) get(39);
    }

    /**
     * Setter for <code>chrono.hwenodeb.EXTPROP2</code>.
     */
    public void setExtprop2(String value) {
        set(40, value);
    }

    /**
     * Getter for <code>chrono.hwenodeb.EXTPROP2</code>.
     */
    public String getExtprop2() {
        return (String) get(40);
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
     * Create a detached HwenodebRecord
     */
    public HwenodebRecord() {
        super(Hwenodeb.HWENODEB);
    }

    /**
     * Create a detached, initialised HwenodebRecord
     */
    public HwenodebRecord(ULong hwenodebId, ULong hwenodebCrcollectortaskfiles, UInteger hwenodebDate, Integer hwenodebDatefrom, Integer hwenodebNode, Integer hwenodebNodephysical, Integer hwenodebNodestatus, Integer hwenodebRevenueclass, Integer hwenodebVendor, Byte hwenodebNamingvalid, Integer totalcell, String enodebid, String enodebfunctionname, String fdn, String moindex, String userlabel, String name, String neid, String ip, String matchversion, String netype, String neversion, String gbtsversion, String nodeversion, String enodebversion, String timezone, String cnoperatorname, String mcc, String mnc, String nbiottaflag, String tac, String trackingareaid, String genodebid, String adjnodeid, String latitudedegformat, String longitudedegformat, String hwenodebRemark, String latitudegps, String longitudegps, Integer extprop1, String extprop2) {
        super(Hwenodeb.HWENODEB);

        set(0, hwenodebId);
        set(1, hwenodebCrcollectortaskfiles);
        set(2, hwenodebDate);
        set(3, hwenodebDatefrom);
        set(4, hwenodebNode);
        set(5, hwenodebNodephysical);
        set(6, hwenodebNodestatus);
        set(7, hwenodebRevenueclass);
        set(8, hwenodebVendor);
        set(9, hwenodebNamingvalid);
        set(10, totalcell);
        set(11, enodebid);
        set(12, enodebfunctionname);
        set(13, fdn);
        set(14, moindex);
        set(15, userlabel);
        set(16, name);
        set(17, neid);
        set(18, ip);
        set(19, matchversion);
        set(20, netype);
        set(21, neversion);
        set(22, gbtsversion);
        set(23, nodeversion);
        set(24, enodebversion);
        set(25, timezone);
        set(26, cnoperatorname);
        set(27, mcc);
        set(28, mnc);
        set(29, nbiottaflag);
        set(30, tac);
        set(31, trackingareaid);
        set(32, genodebid);
        set(33, adjnodeid);
        set(34, latitudedegformat);
        set(35, longitudedegformat);
        set(36, hwenodebRemark);
        set(37, latitudegps);
        set(38, longitudegps);
        set(39, extprop1);
        set(40, extprop2);
    }
}

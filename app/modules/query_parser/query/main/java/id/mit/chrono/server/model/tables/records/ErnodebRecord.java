/*
 * This file is generated by jOOQ.
*/
package id.mit.chrono.server.model.tables.records;


import id.mit.chrono.server.model.tables.Ernodeb;

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
public class ErnodebRecord extends UpdatableRecordImpl<ErnodebRecord> {

    private static final long serialVersionUID = 397708619;

    /**
     * Setter for <code>chrono.ernodeb.ernodeb_id</code>.
     */
    public void setErnodebId(ULong value) {
        set(0, value);
    }

    /**
     * Getter for <code>chrono.ernodeb.ernodeb_id</code>.
     */
    public ULong getErnodebId() {
        return (ULong) get(0);
    }

    /**
     * Setter for <code>chrono.ernodeb.ernodeb_crcollectortaskfiles</code>.
     */
    public void setErnodebCrcollectortaskfiles(ULong value) {
        set(1, value);
    }

    /**
     * Getter for <code>chrono.ernodeb.ernodeb_crcollectortaskfiles</code>.
     */
    public ULong getErnodebCrcollectortaskfiles() {
        return (ULong) get(1);
    }

    /**
     * Setter for <code>chrono.ernodeb.ernodeb_date</code>.
     */
    public void setErnodebDate(UInteger value) {
        set(2, value);
    }

    /**
     * Getter for <code>chrono.ernodeb.ernodeb_date</code>.
     */
    public UInteger getErnodebDate() {
        return (UInteger) get(2);
    }

    /**
     * Setter for <code>chrono.ernodeb.ernodeb_datefrom</code>.
     */
    public void setErnodebDatefrom(Integer value) {
        set(3, value);
    }

    /**
     * Getter for <code>chrono.ernodeb.ernodeb_datefrom</code>.
     */
    public Integer getErnodebDatefrom() {
        return (Integer) get(3);
    }

    /**
     * Setter for <code>chrono.ernodeb.ernodeb_errnc</code>.
     */
    public void setErnodebErrnc(ULong value) {
        set(4, value);
    }

    /**
     * Getter for <code>chrono.ernodeb.ernodeb_errnc</code>.
     */
    public ULong getErnodebErrnc() {
        return (ULong) get(4);
    }

    /**
     * Setter for <code>chrono.ernodeb.ernodeb_node</code>.
     */
    public void setErnodebNode(Integer value) {
        set(5, value);
    }

    /**
     * Getter for <code>chrono.ernodeb.ernodeb_node</code>.
     */
    public Integer getErnodebNode() {
        return (Integer) get(5);
    }

    /**
     * Setter for <code>chrono.ernodeb.ernodeb_nodephysical</code>.
     */
    public void setErnodebNodephysical(Integer value) {
        set(6, value);
    }

    /**
     * Getter for <code>chrono.ernodeb.ernodeb_nodephysical</code>.
     */
    public Integer getErnodebNodephysical() {
        return (Integer) get(6);
    }

    /**
     * Setter for <code>chrono.ernodeb.ernodeb_nodestatus</code>.
     */
    public void setErnodebNodestatus(Integer value) {
        set(7, value);
    }

    /**
     * Getter for <code>chrono.ernodeb.ernodeb_nodestatus</code>.
     */
    public Integer getErnodebNodestatus() {
        return (Integer) get(7);
    }

    /**
     * Setter for <code>chrono.ernodeb.ernodeb_revenueclass</code>.
     */
    public void setErnodebRevenueclass(Integer value) {
        set(8, value);
    }

    /**
     * Getter for <code>chrono.ernodeb.ernodeb_revenueclass</code>.
     */
    public Integer getErnodebRevenueclass() {
        return (Integer) get(8);
    }

    /**
     * Setter for <code>chrono.ernodeb.ernodeb_vendor</code>.
     */
    public void setErnodebVendor(Integer value) {
        set(9, value);
    }

    /**
     * Getter for <code>chrono.ernodeb.ernodeb_vendor</code>.
     */
    public Integer getErnodebVendor() {
        return (Integer) get(9);
    }

    /**
     * Setter for <code>chrono.ernodeb.ernodeb_namingvalid</code>.
     */
    public void setErnodebNamingvalid(Byte value) {
        set(10, value);
    }

    /**
     * Getter for <code>chrono.ernodeb.ernodeb_namingvalid</code>.
     */
    public Byte getErnodebNamingvalid() {
        return (Byte) get(10);
    }

    /**
     * Setter for <code>chrono.ernodeb.TOTALCELL</code>.
     */
    public void setTotalcell(Integer value) {
        set(11, value);
    }

    /**
     * Getter for <code>chrono.ernodeb.TOTALCELL</code>.
     */
    public Integer getTotalcell() {
        return (Integer) get(11);
    }

    /**
     * Setter for <code>chrono.ernodeb.EXPORTTIME</code>.
     */
    public void setExporttime(String value) {
        set(12, value);
    }

    /**
     * Getter for <code>chrono.ernodeb.EXPORTTIME</code>.
     */
    public String getExporttime() {
        return (String) get(12);
    }

    /**
     * Setter for <code>chrono.ernodeb.NODEBID</code>.
     */
    public void setNodebid(String value) {
        set(13, value);
    }

    /**
     * Getter for <code>chrono.ernodeb.NODEBID</code>.
     */
    public String getNodebid() {
        return (String) get(13);
    }

    /**
     * Setter for <code>chrono.ernodeb.IUBID</code>.
     */
    public void setIubid(String value) {
        set(14, value);
    }

    /**
     * Getter for <code>chrono.ernodeb.IUBID</code>.
     */
    public String getIubid() {
        return (String) get(14);
    }

    /**
     * Setter for <code>chrono.ernodeb.RBSID</code>.
     */
    public void setRbsid(String value) {
        set(15, value);
    }

    /**
     * Getter for <code>chrono.ernodeb.RBSID</code>.
     */
    public String getRbsid() {
        return (String) get(15);
    }

    /**
     * Setter for <code>chrono.ernodeb.NODEBNAME</code>.
     */
    public void setNodebname(String value) {
        set(16, value);
    }

    /**
     * Getter for <code>chrono.ernodeb.NODEBNAME</code>.
     */
    public String getNodebname() {
        return (String) get(16);
    }

    /**
     * Setter for <code>chrono.ernodeb.IUBLINK</code>.
     */
    public void setIublink(String value) {
        set(17, value);
    }

    /**
     * Getter for <code>chrono.ernodeb.IUBLINK</code>.
     */
    public String getIublink() {
        return (String) get(17);
    }

    /**
     * Setter for <code>chrono.ernodeb.TNLBEARERTYPE</code>.
     */
    public void setTnlbearertype(String value) {
        set(18, value);
    }

    /**
     * Getter for <code>chrono.ernodeb.TNLBEARERTYPE</code>.
     */
    public String getTnlbearertype() {
        return (String) get(18);
    }

    /**
     * Setter for <code>chrono.ernodeb.TRANSDELAY</code>.
     */
    public void setTransdelay(String value) {
        set(19, value);
    }

    /**
     * Getter for <code>chrono.ernodeb.TRANSDELAY</code>.
     */
    public String getTransdelay() {
        return (String) get(19);
    }

    /**
     * Setter for <code>chrono.ernodeb.NODEBPROTCLVER</code>.
     */
    public void setNodebprotclver(String value) {
        set(20, value);
    }

    /**
     * Getter for <code>chrono.ernodeb.NODEBPROTCLVER</code>.
     */
    public String getNodebprotclver() {
        return (String) get(20);
    }

    /**
     * Setter for <code>chrono.ernodeb.SHARINGTYPE</code>.
     */
    public void setSharingtype(String value) {
        set(21, value);
    }

    /**
     * Getter for <code>chrono.ernodeb.SHARINGTYPE</code>.
     */
    public String getSharingtype() {
        return (String) get(21);
    }

    /**
     * Setter for <code>chrono.ernodeb.HOSTTYPE</code>.
     */
    public void setHosttype(String value) {
        set(22, value);
    }

    /**
     * Getter for <code>chrono.ernodeb.HOSTTYPE</code>.
     */
    public String getHosttype() {
        return (String) get(22);
    }

    /**
     * Setter for <code>chrono.ernodeb.SIGNALCREATETYPE</code>.
     */
    public void setSignalcreatetype(String value) {
        set(23, value);
    }

    /**
     * Getter for <code>chrono.ernodeb.SIGNALCREATETYPE</code>.
     */
    public String getSignalcreatetype() {
        return (String) get(23);
    }

    /**
     * Setter for <code>chrono.ernodeb.NBTRANTP</code>.
     */
    public void setNbtrantp(String value) {
        set(24, value);
    }

    /**
     * Getter for <code>chrono.ernodeb.NBTRANTP</code>.
     */
    public String getNbtrantp() {
        return (String) get(24);
    }

    /**
     * Setter for <code>chrono.ernodeb.NBIPOAMIP</code>.
     */
    public void setNbipoamip(String value) {
        set(25, value);
    }

    /**
     * Getter for <code>chrono.ernodeb.NBIPOAMIP</code>.
     */
    public String getNbipoamip() {
        return (String) get(25);
    }

    /**
     * Setter for <code>chrono.ernodeb.NBIPOAMMASK</code>.
     */
    public void setNbipoammask(String value) {
        set(26, value);
    }

    /**
     * Getter for <code>chrono.ernodeb.NBIPOAMMASK</code>.
     */
    public String getNbipoammask() {
        return (String) get(26);
    }

    /**
     * Setter for <code>chrono.ernodeb.IPSRN</code>.
     */
    public void setIpsrn(String value) {
        set(27, value);
    }

    /**
     * Getter for <code>chrono.ernodeb.IPSRN</code>.
     */
    public String getIpsrn() {
        return (String) get(27);
    }

    /**
     * Setter for <code>chrono.ernodeb.IPSN</code>.
     */
    public void setIpsn(String value) {
        set(28, value);
    }

    /**
     * Getter for <code>chrono.ernodeb.IPSN</code>.
     */
    public String getIpsn() {
        return (String) get(28);
    }

    /**
     * Setter for <code>chrono.ernodeb.VLANFLAG</code>.
     */
    public void setVlanflag(String value) {
        set(29, value);
    }

    /**
     * Getter for <code>chrono.ernodeb.VLANFLAG</code>.
     */
    public String getVlanflag() {
        return (String) get(29);
    }

    /**
     * Setter for <code>chrono.ernodeb.SLAVENBIPOAMIP</code>.
     */
    public void setSlavenbipoamip(String value) {
        set(30, value);
    }

    /**
     * Getter for <code>chrono.ernodeb.SLAVENBIPOAMIP</code>.
     */
    public String getSlavenbipoamip() {
        return (String) get(30);
    }

    /**
     * Setter for <code>chrono.ernodeb.SLAVENBIPOAMMASK</code>.
     */
    public void setSlavenbipoammask(String value) {
        set(31, value);
    }

    /**
     * Getter for <code>chrono.ernodeb.SLAVENBIPOAMMASK</code>.
     */
    public String getSlavenbipoammask() {
        return (String) get(31);
    }

    /**
     * Setter for <code>chrono.ernodeb.ADMSTATE</code>.
     */
    public void setAdmstate(String value) {
        set(32, value);
    }

    /**
     * Getter for <code>chrono.ernodeb.ADMSTATE</code>.
     */
    public String getAdmstate() {
        return (String) get(32);
    }

    /**
     * Setter for <code>chrono.ernodeb.STATE</code>.
     */
    public void setState(String value) {
        set(33, value);
    }

    /**
     * Getter for <code>chrono.ernodeb.STATE</code>.
     */
    public String getState() {
        return (String) get(33);
    }

    /**
     * Setter for <code>chrono.ernodeb.hwnodeb_remark</code>.
     */
    public void setHwnodebRemark(String value) {
        set(34, value);
    }

    /**
     * Getter for <code>chrono.ernodeb.hwnodeb_remark</code>.
     */
    public String getHwnodebRemark() {
        return (String) get(34);
    }

    /**
     * Setter for <code>chrono.ernodeb.userPlaneGbrAdmBandwidthDl</code>.
     */
    public void setUserplanegbradmbandwidthdl(String value) {
        set(35, value);
    }

    /**
     * Getter for <code>chrono.ernodeb.userPlaneGbrAdmBandwidthDl</code>.
     */
    public String getUserplanegbradmbandwidthdl() {
        return (String) get(35);
    }

    /**
     * Setter for <code>chrono.ernodeb.userPlaneGbrAdmBandwidthUl</code>.
     */
    public void setUserplanegbradmbandwidthul(String value) {
        set(36, value);
    }

    /**
     * Getter for <code>chrono.ernodeb.userPlaneGbrAdmBandwidthUl</code>.
     */
    public String getUserplanegbradmbandwidthul() {
        return (String) get(36);
    }

    /**
     * Setter for <code>chrono.ernodeb.EXTPROP1</code>.
     */
    public void setExtprop1(Integer value) {
        set(37, value);
    }

    /**
     * Getter for <code>chrono.ernodeb.EXTPROP1</code>.
     */
    public Integer getExtprop1() {
        return (Integer) get(37);
    }

    /**
     * Setter for <code>chrono.ernodeb.EXTPROP2</code>.
     */
    public void setExtprop2(String value) {
        set(38, value);
    }

    /**
     * Getter for <code>chrono.ernodeb.EXTPROP2</code>.
     */
    public String getExtprop2() {
        return (String) get(38);
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
     * Create a detached ErnodebRecord
     */
    public ErnodebRecord() {
        super(Ernodeb.ERNODEB);
    }

    /**
     * Create a detached, initialised ErnodebRecord
     */
    public ErnodebRecord(ULong ernodebId, ULong ernodebCrcollectortaskfiles, UInteger ernodebDate, Integer ernodebDatefrom, ULong ernodebErrnc, Integer ernodebNode, Integer ernodebNodephysical, Integer ernodebNodestatus, Integer ernodebRevenueclass, Integer ernodebVendor, Byte ernodebNamingvalid, Integer totalcell, String exporttime, String nodebid, String iubid, String rbsid, String nodebname, String iublink, String tnlbearertype, String transdelay, String nodebprotclver, String sharingtype, String hosttype, String signalcreatetype, String nbtrantp, String nbipoamip, String nbipoammask, String ipsrn, String ipsn, String vlanflag, String slavenbipoamip, String slavenbipoammask, String admstate, String state, String hwnodebRemark, String userplanegbradmbandwidthdl, String userplanegbradmbandwidthul, Integer extprop1, String extprop2) {
        super(Ernodeb.ERNODEB);

        set(0, ernodebId);
        set(1, ernodebCrcollectortaskfiles);
        set(2, ernodebDate);
        set(3, ernodebDatefrom);
        set(4, ernodebErrnc);
        set(5, ernodebNode);
        set(6, ernodebNodephysical);
        set(7, ernodebNodestatus);
        set(8, ernodebRevenueclass);
        set(9, ernodebVendor);
        set(10, ernodebNamingvalid);
        set(11, totalcell);
        set(12, exporttime);
        set(13, nodebid);
        set(14, iubid);
        set(15, rbsid);
        set(16, nodebname);
        set(17, iublink);
        set(18, tnlbearertype);
        set(19, transdelay);
        set(20, nodebprotclver);
        set(21, sharingtype);
        set(22, hosttype);
        set(23, signalcreatetype);
        set(24, nbtrantp);
        set(25, nbipoamip);
        set(26, nbipoammask);
        set(27, ipsrn);
        set(28, ipsn);
        set(29, vlanflag);
        set(30, slavenbipoamip);
        set(31, slavenbipoammask);
        set(32, admstate);
        set(33, state);
        set(34, hwnodebRemark);
        set(35, userplanegbradmbandwidthdl);
        set(36, userplanegbradmbandwidthul);
        set(37, extprop1);
        set(38, extprop2);
    }
}

/*
 * This file is generated by jOOQ.
*/
package id.mit.chrono.server.model.tables.records;


import id.mit.chrono.server.model.tables.Erenodeb;

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
public class ErenodebRecord extends UpdatableRecordImpl<ErenodebRecord> {

    private static final long serialVersionUID = 1785930084;

    /**
     * Setter for <code>chrono.erenodeb.erenodeb_id</code>.
     */
    public void setErenodebId(ULong value) {
        set(0, value);
    }

    /**
     * Getter for <code>chrono.erenodeb.erenodeb_id</code>.
     */
    public ULong getErenodebId() {
        return (ULong) get(0);
    }

    /**
     * Setter for <code>chrono.erenodeb.erenodeb_crcollectortaskfiles</code>.
     */
    public void setErenodebCrcollectortaskfiles(ULong value) {
        set(1, value);
    }

    /**
     * Getter for <code>chrono.erenodeb.erenodeb_crcollectortaskfiles</code>.
     */
    public ULong getErenodebCrcollectortaskfiles() {
        return (ULong) get(1);
    }

    /**
     * Setter for <code>chrono.erenodeb.erenodeb_date</code>.
     */
    public void setErenodebDate(UInteger value) {
        set(2, value);
    }

    /**
     * Getter for <code>chrono.erenodeb.erenodeb_date</code>.
     */
    public UInteger getErenodebDate() {
        return (UInteger) get(2);
    }

    /**
     * Setter for <code>chrono.erenodeb.erenodeb_datefrom</code>.
     */
    public void setErenodebDatefrom(Integer value) {
        set(3, value);
    }

    /**
     * Getter for <code>chrono.erenodeb.erenodeb_datefrom</code>.
     */
    public Integer getErenodebDatefrom() {
        return (Integer) get(3);
    }

    /**
     * Setter for <code>chrono.erenodeb.erenodeb_node</code>.
     */
    public void setErenodebNode(Integer value) {
        set(4, value);
    }

    /**
     * Getter for <code>chrono.erenodeb.erenodeb_node</code>.
     */
    public Integer getErenodebNode() {
        return (Integer) get(4);
    }

    /**
     * Setter for <code>chrono.erenodeb.erenodeb_nodephysical</code>.
     */
    public void setErenodebNodephysical(Integer value) {
        set(5, value);
    }

    /**
     * Getter for <code>chrono.erenodeb.erenodeb_nodephysical</code>.
     */
    public Integer getErenodebNodephysical() {
        return (Integer) get(5);
    }

    /**
     * Setter for <code>chrono.erenodeb.erenodeb_nodestatus</code>.
     */
    public void setErenodebNodestatus(Integer value) {
        set(6, value);
    }

    /**
     * Getter for <code>chrono.erenodeb.erenodeb_nodestatus</code>.
     */
    public Integer getErenodebNodestatus() {
        return (Integer) get(6);
    }

    /**
     * Setter for <code>chrono.erenodeb.erenodeb_revenueclass</code>.
     */
    public void setErenodebRevenueclass(Integer value) {
        set(7, value);
    }

    /**
     * Getter for <code>chrono.erenodeb.erenodeb_revenueclass</code>.
     */
    public Integer getErenodebRevenueclass() {
        return (Integer) get(7);
    }

    /**
     * Setter for <code>chrono.erenodeb.erenodeb_vendor</code>.
     */
    public void setErenodebVendor(Integer value) {
        set(8, value);
    }

    /**
     * Getter for <code>chrono.erenodeb.erenodeb_vendor</code>.
     */
    public Integer getErenodebVendor() {
        return (Integer) get(8);
    }

    /**
     * Setter for <code>chrono.erenodeb.erenodeb_namingvalid</code>.
     */
    public void setErenodebNamingvalid(Byte value) {
        set(9, value);
    }

    /**
     * Getter for <code>chrono.erenodeb.erenodeb_namingvalid</code>.
     */
    public Byte getErenodebNamingvalid() {
        return (Byte) get(9);
    }

    /**
     * Setter for <code>chrono.erenodeb.TOTALCELL</code>.
     */
    public void setTotalcell(Integer value) {
        set(10, value);
    }

    /**
     * Getter for <code>chrono.erenodeb.TOTALCELL</code>.
     */
    public Integer getTotalcell() {
        return (Integer) get(10);
    }

    /**
     * Setter for <code>chrono.erenodeb.ENODEBID</code>.
     */
    public void setEnodebid(String value) {
        set(11, value);
    }

    /**
     * Getter for <code>chrono.erenodeb.ENODEBID</code>.
     */
    public String getEnodebid() {
        return (String) get(11);
    }

    /**
     * Setter for <code>chrono.erenodeb.ENODEBFUNCTIONNAME</code>.
     */
    public void setEnodebfunctionname(String value) {
        set(12, value);
    }

    /**
     * Getter for <code>chrono.erenodeb.ENODEBFUNCTIONNAME</code>.
     */
    public String getEnodebfunctionname() {
        return (String) get(12);
    }

    /**
     * Setter for <code>chrono.erenodeb.MANAGEDELEMENTTYPE</code>.
     */
    public void setManagedelementtype(String value) {
        set(13, value);
    }

    /**
     * Getter for <code>chrono.erenodeb.MANAGEDELEMENTTYPE</code>.
     */
    public String getManagedelementtype() {
        return (String) get(13);
    }

    /**
     * Setter for <code>chrono.erenodeb.SWVERSION</code>.
     */
    public void setSwversion(String value) {
        set(14, value);
    }

    /**
     * Getter for <code>chrono.erenodeb.SWVERSION</code>.
     */
    public String getSwversion() {
        return (String) get(14);
    }

    /**
     * Setter for <code>chrono.erenodeb.SUBNETWORK</code>.
     */
    public void setSubnetwork(String value) {
        set(15, value);
    }

    /**
     * Getter for <code>chrono.erenodeb.SUBNETWORK</code>.
     */
    public String getSubnetwork() {
        return (String) get(15);
    }

    /**
     * Setter for <code>chrono.erenodeb.SITEREF</code>.
     */
    public void setSiteref(String value) {
        set(16, value);
    }

    /**
     * Getter for <code>chrono.erenodeb.SITEREF</code>.
     */
    public String getSiteref() {
        return (String) get(16);
    }

    /**
     * Setter for <code>chrono.erenodeb.PRODUCTTYPE</code>.
     */
    public void setProducttype(String value) {
        set(17, value);
    }

    /**
     * Getter for <code>chrono.erenodeb.PRODUCTTYPE</code>.
     */
    public String getProducttype() {
        return (String) get(17);
    }

    /**
     * Setter for <code>chrono.erenodeb.PRODUCTNAME</code>.
     */
    public void setProductname(String value) {
        set(18, value);
    }

    /**
     * Getter for <code>chrono.erenodeb.PRODUCTNAME</code>.
     */
    public String getProductname() {
        return (String) get(18);
    }

    /**
     * Setter for <code>chrono.erenodeb.CABINETINFO</code>.
     */
    public void setCabinetinfo(String value) {
        set(19, value);
    }

    /**
     * Getter for <code>chrono.erenodeb.CABINETINFO</code>.
     */
    public String getCabinetinfo() {
        return (String) get(19);
    }

    /**
     * Setter for <code>chrono.erenodeb.MCC</code>.
     */
    public void setMcc(String value) {
        set(20, value);
    }

    /**
     * Getter for <code>chrono.erenodeb.MCC</code>.
     */
    public String getMcc() {
        return (String) get(20);
    }

    /**
     * Setter for <code>chrono.erenodeb.MNC</code>.
     */
    public void setMnc(String value) {
        set(21, value);
    }

    /**
     * Getter for <code>chrono.erenodeb.MNC</code>.
     */
    public String getMnc() {
        return (String) get(21);
    }

    /**
     * Setter for <code>chrono.erenodeb.GENODEBID</code>.
     */
    public void setGenodebid(String value) {
        set(22, value);
    }

    /**
     * Getter for <code>chrono.erenodeb.GENODEBID</code>.
     */
    public String getGenodebid() {
        return (String) get(22);
    }

    /**
     * Setter for <code>chrono.erenodeb.TIMEZONE</code>.
     */
    public void setTimezone(String value) {
        set(23, value);
    }

    /**
     * Getter for <code>chrono.erenodeb.TIMEZONE</code>.
     */
    public String getTimezone() {
        return (String) get(23);
    }

    /**
     * Setter for <code>chrono.erenodeb.NODEIPADDRESS</code>.
     */
    public void setNodeipaddress(String value) {
        set(24, value);
    }

    /**
     * Getter for <code>chrono.erenodeb.NODEIPADDRESS</code>.
     */
    public String getNodeipaddress() {
        return (String) get(24);
    }

    /**
     * Setter for <code>chrono.erenodeb.ADMSTATE</code>.
     */
    public void setAdmstate(String value) {
        set(25, value);
    }

    /**
     * Getter for <code>chrono.erenodeb.ADMSTATE</code>.
     */
    public String getAdmstate() {
        return (String) get(25);
    }

    /**
     * Setter for <code>chrono.erenodeb.hwenodeb_remark</code>.
     */
    public void setHwenodebRemark(String value) {
        set(26, value);
    }

    /**
     * Getter for <code>chrono.erenodeb.hwenodeb_remark</code>.
     */
    public String getHwenodebRemark() {
        return (String) get(26);
    }

    /**
     * Setter for <code>chrono.erenodeb.EXTPROP1</code>.
     */
    public void setExtprop1(Integer value) {
        set(27, value);
    }

    /**
     * Getter for <code>chrono.erenodeb.EXTPROP1</code>.
     */
    public Integer getExtprop1() {
        return (Integer) get(27);
    }

    /**
     * Setter for <code>chrono.erenodeb.EXTPROP2</code>.
     */
    public void setExtprop2(String value) {
        set(28, value);
    }

    /**
     * Getter for <code>chrono.erenodeb.EXTPROP2</code>.
     */
    public String getExtprop2() {
        return (String) get(28);
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
     * Create a detached ErenodebRecord
     */
    public ErenodebRecord() {
        super(Erenodeb.ERENODEB);
    }

    /**
     * Create a detached, initialised ErenodebRecord
     */
    public ErenodebRecord(ULong erenodebId, ULong erenodebCrcollectortaskfiles, UInteger erenodebDate, Integer erenodebDatefrom, Integer erenodebNode, Integer erenodebNodephysical, Integer erenodebNodestatus, Integer erenodebRevenueclass, Integer erenodebVendor, Byte erenodebNamingvalid, Integer totalcell, String enodebid, String enodebfunctionname, String managedelementtype, String swversion, String subnetwork, String siteref, String producttype, String productname, String cabinetinfo, String mcc, String mnc, String genodebid, String timezone, String nodeipaddress, String admstate, String hwenodebRemark, Integer extprop1, String extprop2) {
        super(Erenodeb.ERENODEB);

        set(0, erenodebId);
        set(1, erenodebCrcollectortaskfiles);
        set(2, erenodebDate);
        set(3, erenodebDatefrom);
        set(4, erenodebNode);
        set(5, erenodebNodephysical);
        set(6, erenodebNodestatus);
        set(7, erenodebRevenueclass);
        set(8, erenodebVendor);
        set(9, erenodebNamingvalid);
        set(10, totalcell);
        set(11, enodebid);
        set(12, enodebfunctionname);
        set(13, managedelementtype);
        set(14, swversion);
        set(15, subnetwork);
        set(16, siteref);
        set(17, producttype);
        set(18, productname);
        set(19, cabinetinfo);
        set(20, mcc);
        set(21, mnc);
        set(22, genodebid);
        set(23, timezone);
        set(24, nodeipaddress);
        set(25, admstate);
        set(26, hwenodebRemark);
        set(27, extprop1);
        set(28, extprop2);
    }
}

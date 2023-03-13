/*
 * This file is generated by jOOQ.
*/
package id.mit.chrono.server.model.tables.records;


import id.mit.chrono.server.model.tables.Ztegnodeb;

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
public class ZtegnodebRecord extends UpdatableRecordImpl<ZtegnodebRecord> {

    private static final long serialVersionUID = 204658828;

    /**
     * Setter for <code>chrono.ztegnodeb.ztegnodeb_id</code>.
     */
    public void setZtegnodebId(ULong value) {
        set(0, value);
    }

    /**
     * Getter for <code>chrono.ztegnodeb.ztegnodeb_id</code>.
     */
    public ULong getZtegnodebId() {
        return (ULong) get(0);
    }

    /**
     * Setter for <code>chrono.ztegnodeb.ztegnodeb_crcollectortaskfiles</code>.
     */
    public void setZtegnodebCrcollectortaskfiles(ULong value) {
        set(1, value);
    }

    /**
     * Getter for <code>chrono.ztegnodeb.ztegnodeb_crcollectortaskfiles</code>.
     */
    public ULong getZtegnodebCrcollectortaskfiles() {
        return (ULong) get(1);
    }

    /**
     * Setter for <code>chrono.ztegnodeb.ztegnodeb_date</code>.
     */
    public void setZtegnodebDate(UInteger value) {
        set(2, value);
    }

    /**
     * Getter for <code>chrono.ztegnodeb.ztegnodeb_date</code>.
     */
    public UInteger getZtegnodebDate() {
        return (UInteger) get(2);
    }

    /**
     * Setter for <code>chrono.ztegnodeb.ztegnodeb_datefrom</code>.
     */
    public void setZtegnodebDatefrom(Integer value) {
        set(3, value);
    }

    /**
     * Getter for <code>chrono.ztegnodeb.ztegnodeb_datefrom</code>.
     */
    public Integer getZtegnodebDatefrom() {
        return (Integer) get(3);
    }

    /**
     * Setter for <code>chrono.ztegnodeb.ztegnodeb_node</code>.
     */
    public void setZtegnodebNode(Integer value) {
        set(4, value);
    }

    /**
     * Getter for <code>chrono.ztegnodeb.ztegnodeb_node</code>.
     */
    public Integer getZtegnodebNode() {
        return (Integer) get(4);
    }

    /**
     * Setter for <code>chrono.ztegnodeb.ztegnodeb_nodephysical</code>.
     */
    public void setZtegnodebNodephysical(Integer value) {
        set(5, value);
    }

    /**
     * Getter for <code>chrono.ztegnodeb.ztegnodeb_nodephysical</code>.
     */
    public Integer getZtegnodebNodephysical() {
        return (Integer) get(5);
    }

    /**
     * Setter for <code>chrono.ztegnodeb.ztegnodeb_nodestatus</code>.
     */
    public void setZtegnodebNodestatus(Integer value) {
        set(6, value);
    }

    /**
     * Getter for <code>chrono.ztegnodeb.ztegnodeb_nodestatus</code>.
     */
    public Integer getZtegnodebNodestatus() {
        return (Integer) get(6);
    }

    /**
     * Setter for <code>chrono.ztegnodeb.ztegnodeb_revenueclass</code>.
     */
    public void setZtegnodebRevenueclass(Integer value) {
        set(7, value);
    }

    /**
     * Getter for <code>chrono.ztegnodeb.ztegnodeb_revenueclass</code>.
     */
    public Integer getZtegnodebRevenueclass() {
        return (Integer) get(7);
    }

    /**
     * Setter for <code>chrono.ztegnodeb.ztegnodeb_vendor</code>.
     */
    public void setZtegnodebVendor(Integer value) {
        set(8, value);
    }

    /**
     * Getter for <code>chrono.ztegnodeb.ztegnodeb_vendor</code>.
     */
    public Integer getZtegnodebVendor() {
        return (Integer) get(8);
    }

    /**
     * Setter for <code>chrono.ztegnodeb.ztegnodeb_namingvalid</code>.
     */
    public void setZtegnodebNamingvalid(Byte value) {
        set(9, value);
    }

    /**
     * Getter for <code>chrono.ztegnodeb.ztegnodeb_namingvalid</code>.
     */
    public Byte getZtegnodebNamingvalid() {
        return (Byte) get(9);
    }

    /**
     * Setter for <code>chrono.ztegnodeb.TOTALCELL</code>.
     */
    public void setTotalcell(Integer value) {
        set(10, value);
    }

    /**
     * Getter for <code>chrono.ztegnodeb.TOTALCELL</code>.
     */
    public Integer getTotalcell() {
        return (Integer) get(10);
    }

    /**
     * Setter for <code>chrono.ztegnodeb.MANAGEDELEMENTTYPE</code>.
     */
    public void setManagedelementtype(String value) {
        set(11, value);
    }

    /**
     * Getter for <code>chrono.ztegnodeb.MANAGEDELEMENTTYPE</code>.
     */
    public String getManagedelementtype() {
        return (String) get(11);
    }

    /**
     * Setter for <code>chrono.ztegnodeb.SUBNETWORK</code>.
     */
    public void setSubnetwork(String value) {
        set(12, value);
    }

    /**
     * Getter for <code>chrono.ztegnodeb.SUBNETWORK</code>.
     */
    public String getSubnetwork() {
        return (String) get(12);
    }

    /**
     * Setter for <code>chrono.ztegnodeb.MANAGEDELEMENT</code>.
     */
    public void setManagedelement(String value) {
        set(13, value);
    }

    /**
     * Getter for <code>chrono.ztegnodeb.MANAGEDELEMENT</code>.
     */
    public String getManagedelement() {
        return (String) get(13);
    }

    /**
     * Setter for <code>chrono.ztegnodeb.LDN</code>.
     */
    public void setLdn(String value) {
        set(14, value);
    }

    /**
     * Getter for <code>chrono.ztegnodeb.LDN</code>.
     */
    public String getLdn() {
        return (String) get(14);
    }

    /**
     * Setter for <code>chrono.ztegnodeb.MOID</code>.
     */
    public void setMoid(String value) {
        set(15, value);
    }

    /**
     * Getter for <code>chrono.ztegnodeb.MOID</code>.
     */
    public String getMoid() {
        return (String) get(15);
    }

    /**
     * Setter for <code>chrono.ztegnodeb.RRCVERSION</code>.
     */
    public void setRrcversion(String value) {
        set(16, value);
    }

    /**
     * Getter for <code>chrono.ztegnodeb.RRCVERSION</code>.
     */
    public String getRrcversion() {
        return (String) get(16);
    }

    /**
     * Setter for <code>chrono.ztegnodeb.NGVERSION</code>.
     */
    public void setNgversion(String value) {
        set(17, value);
    }

    /**
     * Getter for <code>chrono.ztegnodeb.NGVERSION</code>.
     */
    public String getNgversion() {
        return (String) get(17);
    }

    /**
     * Setter for <code>chrono.ztegnodeb.GNBIDLENGTH</code>.
     */
    public void setGnbidlength(String value) {
        set(18, value);
    }

    /**
     * Getter for <code>chrono.ztegnodeb.GNBIDLENGTH</code>.
     */
    public String getGnbidlength() {
        return (String) get(18);
    }

    /**
     * Setter for <code>chrono.ztegnodeb.USERLABEL</code>.
     */
    public void setUserlabel(String value) {
        set(19, value);
    }

    /**
     * Getter for <code>chrono.ztegnodeb.USERLABEL</code>.
     */
    public String getUserlabel() {
        return (String) get(19);
    }

    /**
     * Setter for <code>chrono.ztegnodeb.GNBID</code>.
     */
    public void setGnbid(String value) {
        set(20, value);
    }

    /**
     * Getter for <code>chrono.ztegnodeb.GNBID</code>.
     */
    public String getGnbid() {
        return (String) get(20);
    }

    /**
     * Setter for <code>chrono.ztegnodeb.GNBCUNAME</code>.
     */
    public void setGnbcuname(String value) {
        set(21, value);
    }

    /**
     * Getter for <code>chrono.ztegnodeb.GNBCUNAME</code>.
     */
    public String getGnbcuname() {
        return (String) get(21);
    }

    /**
     * Setter for <code>chrono.ztegnodeb.GNBCUUPID</code>.
     */
    public void setGnbcuupid(String value) {
        set(22, value);
    }

    /**
     * Getter for <code>chrono.ztegnodeb.GNBCUUPID</code>.
     */
    public String getGnbcuupid() {
        return (String) get(22);
    }

    /**
     * Setter for <code>chrono.ztegnodeb.PLMNID</code>.
     */
    public void setPlmnid(String value) {
        set(23, value);
    }

    /**
     * Getter for <code>chrono.ztegnodeb.PLMNID</code>.
     */
    public String getPlmnid() {
        return (String) get(23);
    }

    /**
     * Setter for <code>chrono.ztegnodeb.PLMNIDLIST</code>.
     */
    public void setPlmnidlist(String value) {
        set(24, value);
    }

    /**
     * Getter for <code>chrono.ztegnodeb.PLMNIDLIST</code>.
     */
    public String getPlmnidlist() {
        return (String) get(24);
    }

    /**
     * Setter for <code>chrono.ztegnodeb.LATITUDEDEGFORMAT</code>.
     */
    public void setLatitudedegformat(String value) {
        set(25, value);
    }

    /**
     * Getter for <code>chrono.ztegnodeb.LATITUDEDEGFORMAT</code>.
     */
    public String getLatitudedegformat() {
        return (String) get(25);
    }

    /**
     * Setter for <code>chrono.ztegnodeb.LONGITUDEDEGFORMAT</code>.
     */
    public void setLongitudedegformat(String value) {
        set(26, value);
    }

    /**
     * Getter for <code>chrono.ztegnodeb.LONGITUDEDEGFORMAT</code>.
     */
    public String getLongitudedegformat() {
        return (String) get(26);
    }

    /**
     * Setter for <code>chrono.ztegnodeb.LATITUDEGPS</code>.
     */
    public void setLatitudegps(String value) {
        set(27, value);
    }

    /**
     * Getter for <code>chrono.ztegnodeb.LATITUDEGPS</code>.
     */
    public String getLatitudegps() {
        return (String) get(27);
    }

    /**
     * Setter for <code>chrono.ztegnodeb.LONGITUDEGPS</code>.
     */
    public void setLongitudegps(String value) {
        set(28, value);
    }

    /**
     * Getter for <code>chrono.ztegnodeb.LONGITUDEGPS</code>.
     */
    public String getLongitudegps() {
        return (String) get(28);
    }

    /**
     * Setter for <code>chrono.ztegnodeb.ztegnodeb_remark</code>.
     */
    public void setZtegnodebRemark(String value) {
        set(29, value);
    }

    /**
     * Getter for <code>chrono.ztegnodeb.ztegnodeb_remark</code>.
     */
    public String getZtegnodebRemark() {
        return (String) get(29);
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
     * Create a detached ZtegnodebRecord
     */
    public ZtegnodebRecord() {
        super(Ztegnodeb.ZTEGNODEB);
    }

    /**
     * Create a detached, initialised ZtegnodebRecord
     */
    public ZtegnodebRecord(ULong ztegnodebId, ULong ztegnodebCrcollectortaskfiles, UInteger ztegnodebDate, Integer ztegnodebDatefrom, Integer ztegnodebNode, Integer ztegnodebNodephysical, Integer ztegnodebNodestatus, Integer ztegnodebRevenueclass, Integer ztegnodebVendor, Byte ztegnodebNamingvalid, Integer totalcell, String managedelementtype, String subnetwork, String managedelement, String ldn, String moid, String rrcversion, String ngversion, String gnbidlength, String userlabel, String gnbid, String gnbcuname, String gnbcuupid, String plmnid, String plmnidlist, String latitudedegformat, String longitudedegformat, String latitudegps, String longitudegps, String ztegnodebRemark) {
        super(Ztegnodeb.ZTEGNODEB);

        set(0, ztegnodebId);
        set(1, ztegnodebCrcollectortaskfiles);
        set(2, ztegnodebDate);
        set(3, ztegnodebDatefrom);
        set(4, ztegnodebNode);
        set(5, ztegnodebNodephysical);
        set(6, ztegnodebNodestatus);
        set(7, ztegnodebRevenueclass);
        set(8, ztegnodebVendor);
        set(9, ztegnodebNamingvalid);
        set(10, totalcell);
        set(11, managedelementtype);
        set(12, subnetwork);
        set(13, managedelement);
        set(14, ldn);
        set(15, moid);
        set(16, rrcversion);
        set(17, ngversion);
        set(18, gnbidlength);
        set(19, userlabel);
        set(20, gnbid);
        set(21, gnbcuname);
        set(22, gnbcuupid);
        set(23, plmnid);
        set(24, plmnidlist);
        set(25, latitudedegformat);
        set(26, longitudedegformat);
        set(27, latitudegps);
        set(28, longitudegps);
        set(29, ztegnodebRemark);
    }
}

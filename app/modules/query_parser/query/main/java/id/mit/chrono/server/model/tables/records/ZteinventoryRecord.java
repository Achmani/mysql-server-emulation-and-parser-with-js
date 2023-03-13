/*
 * This file is generated by jOOQ.
*/
package id.mit.chrono.server.model.tables.records;


import id.mit.chrono.server.model.tables.Zteinventory;

import java.sql.Timestamp;

import javax.annotation.Generated;

import org.jooq.Record2;
import org.jooq.impl.UpdatableRecordImpl;
import org.jooq.types.UInteger;


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
public class ZteinventoryRecord extends UpdatableRecordImpl<ZteinventoryRecord> {

    private static final long serialVersionUID = -1997285409;

    /**
     * Setter for <code>chrono.zteinventory.zteinventory_id</code>.
     */
    public void setZteinventoryId(UInteger value) {
        set(0, value);
    }

    /**
     * Getter for <code>chrono.zteinventory.zteinventory_id</code>.
     */
    public UInteger getZteinventoryId() {
        return (UInteger) get(0);
    }

    /**
     * Setter for <code>chrono.zteinventory.zteinventory_date</code>.
     */
    public void setZteinventoryDate(Integer value) {
        set(1, value);
    }

    /**
     * Getter for <code>chrono.zteinventory.zteinventory_date</code>.
     */
    public Integer getZteinventoryDate() {
        return (Integer) get(1);
    }

    /**
     * Setter for <code>chrono.zteinventory.zteinventory_datatype</code>.
     */
    public void setZteinventoryDatatype(Integer value) {
        set(2, value);
    }

    /**
     * Getter for <code>chrono.zteinventory.zteinventory_datatype</code>.
     */
    public Integer getZteinventoryDatatype() {
        return (Integer) get(2);
    }

    /**
     * Setter for <code>chrono.zteinventory.zteinventory_collectortaskfiles</code>.
     */
    public void setZteinventoryCollectortaskfiles(Long value) {
        set(3, value);
    }

    /**
     * Getter for <code>chrono.zteinventory.zteinventory_collectortaskfiles</code>.
     */
    public Long getZteinventoryCollectortaskfiles() {
        return (Long) get(3);
    }

    /**
     * Setter for <code>chrono.zteinventory.zteinventory_vendor</code>.
     */
    public void setZteinventoryVendor(Integer value) {
        set(4, value);
    }

    /**
     * Getter for <code>chrono.zteinventory.zteinventory_vendor</code>.
     */
    public Integer getZteinventoryVendor() {
        return (Integer) get(4);
    }

    /**
     * Setter for <code>chrono.zteinventory.zteinventory_site</code>.
     */
    public void setZteinventorySite(Integer value) {
        set(5, value);
    }

    /**
     * Getter for <code>chrono.zteinventory.zteinventory_site</code>.
     */
    public Integer getZteinventorySite() {
        return (Integer) get(5);
    }

    /**
     * Setter for <code>chrono.zteinventory.zteinventory_siteId</code>.
     */
    public void setZteinventorySiteid(String value) {
        set(6, value);
    }

    /**
     * Getter for <code>chrono.zteinventory.zteinventory_siteId</code>.
     */
    public String getZteinventorySiteid() {
        return (String) get(6);
    }

    /**
     * Setter for <code>chrono.zteinventory.zteinventory_nename</code>.
     */
    public void setZteinventoryNename(String value) {
        set(7, value);
    }

    /**
     * Getter for <code>chrono.zteinventory.zteinventory_nename</code>.
     */
    public String getZteinventoryNename() {
        return (String) get(7);
    }

    /**
     * Setter for <code>chrono.zteinventory.zteinventory_inventoryunittype</code>.
     */
    public void setZteinventoryInventoryunittype(String value) {
        set(8, value);
    }

    /**
     * Getter for <code>chrono.zteinventory.zteinventory_inventoryunittype</code>.
     */
    public String getZteinventoryInventoryunittype() {
        return (String) get(8);
    }

    /**
     * Setter for <code>chrono.zteinventory.zteinventory_vendorunitfamilytype</code>.
     */
    public void setZteinventoryVendorunitfamilytype(String value) {
        set(9, value);
    }

    /**
     * Getter for <code>chrono.zteinventory.zteinventory_vendorunitfamilytype</code>.
     */
    public String getZteinventoryVendorunitfamilytype() {
        return (String) get(9);
    }

    /**
     * Setter for <code>chrono.zteinventory.zteinventory_vendorname</code>.
     */
    public void setZteinventoryVendorname(String value) {
        set(10, value);
    }

    /**
     * Getter for <code>chrono.zteinventory.zteinventory_vendorname</code>.
     */
    public String getZteinventoryVendorname() {
        return (String) get(10);
    }

    /**
     * Setter for <code>chrono.zteinventory.zteinventory_serialnumber</code>.
     */
    public void setZteinventorySerialnumber(String value) {
        set(11, value);
    }

    /**
     * Getter for <code>chrono.zteinventory.zteinventory_serialnumber</code>.
     */
    public String getZteinventorySerialnumber() {
        return (String) get(11);
    }

    /**
     * Setter for <code>chrono.zteinventory.zteinventory_versionnumber</code>.
     */
    public void setZteinventoryVersionnumber(String value) {
        set(12, value);
    }

    /**
     * Getter for <code>chrono.zteinventory.zteinventory_versionnumber</code>.
     */
    public String getZteinventoryVersionnumber() {
        return (String) get(12);
    }

    /**
     * Setter for <code>chrono.zteinventory.zteinventory_dateofmanufacture</code>.
     */
    public void setZteinventoryDateofmanufacture(String value) {
        set(13, value);
    }

    /**
     * Getter for <code>chrono.zteinventory.zteinventory_dateofmanufacture</code>.
     */
    public String getZteinventoryDateofmanufacture() {
        return (String) get(13);
    }

    /**
     * Setter for <code>chrono.zteinventory.zteinventory_unitposition</code>.
     */
    public void setZteinventoryUnitposition(String value) {
        set(14, value);
    }

    /**
     * Getter for <code>chrono.zteinventory.zteinventory_unitposition</code>.
     */
    public String getZteinventoryUnitposition() {
        return (String) get(14);
    }

    /**
     * Setter for <code>chrono.zteinventory.zteinventory_manufacturedata</code>.
     */
    public void setZteinventoryManufacturedata(String value) {
        set(15, value);
    }

    /**
     * Getter for <code>chrono.zteinventory.zteinventory_manufacturedata</code>.
     */
    public String getZteinventoryManufacturedata() {
        return (String) get(15);
    }

    /**
     * Setter for <code>chrono.zteinventory.zteinventory_packsilkscreen</code>.
     */
    public void setZteinventoryPacksilkscreen(String value) {
        set(16, value);
    }

    /**
     * Getter for <code>chrono.zteinventory.zteinventory_packsilkscreen</code>.
     */
    public String getZteinventoryPacksilkscreen() {
        return (String) get(16);
    }

    /**
     * Setter for <code>chrono.zteinventory.zteinventory_packfunction</code>.
     */
    public void setZteinventoryPackfunction(String value) {
        set(17, value);
    }

    /**
     * Getter for <code>chrono.zteinventory.zteinventory_packfunction</code>.
     */
    public String getZteinventoryPackfunction() {
        return (String) get(17);
    }

    /**
     * Setter for <code>chrono.zteinventory.zteinventory_ne</code>.
     */
    public void setZteinventoryNe(String value) {
        set(18, value);
    }

    /**
     * Getter for <code>chrono.zteinventory.zteinventory_ne</code>.
     */
    public String getZteinventoryNe() {
        return (String) get(18);
    }

    /**
     * Setter for <code>chrono.zteinventory.zteinventory_netype</code>.
     */
    public void setZteinventoryNetype(String value) {
        set(19, value);
    }

    /**
     * Getter for <code>chrono.zteinventory.zteinventory_netype</code>.
     */
    public String getZteinventoryNetype() {
        return (String) get(19);
    }

    /**
     * Setter for <code>chrono.zteinventory.zteinventory_updatetime</code>.
     */
    public void setZteinventoryUpdatetime(String value) {
        set(20, value);
    }

    /**
     * Getter for <code>chrono.zteinventory.zteinventory_updatetime</code>.
     */
    public String getZteinventoryUpdatetime() {
        return (String) get(20);
    }

    /**
     * Setter for <code>chrono.zteinventory.zteinventory_source</code>.
     */
    public void setZteinventorySource(String value) {
        set(21, value);
    }

    /**
     * Getter for <code>chrono.zteinventory.zteinventory_source</code>.
     */
    public String getZteinventorySource() {
        return (String) get(21);
    }

    /**
     * Setter for <code>chrono.zteinventory.zteinventory_state</code>.
     */
    public void setZteinventoryState(String value) {
        set(22, value);
    }

    /**
     * Getter for <code>chrono.zteinventory.zteinventory_state</code>.
     */
    public String getZteinventoryState() {
        return (String) get(22);
    }

    /**
     * Setter for <code>chrono.zteinventory.zteinventory_reserve1</code>.
     */
    public void setZteinventoryReserve1(String value) {
        set(23, value);
    }

    /**
     * Getter for <code>chrono.zteinventory.zteinventory_reserve1</code>.
     */
    public String getZteinventoryReserve1() {
        return (String) get(23);
    }

    /**
     * Setter for <code>chrono.zteinventory.zteinventory_reserve2</code>.
     */
    public void setZteinventoryReserve2(String value) {
        set(24, value);
    }

    /**
     * Getter for <code>chrono.zteinventory.zteinventory_reserve2</code>.
     */
    public String getZteinventoryReserve2() {
        return (String) get(24);
    }

    /**
     * Setter for <code>chrono.zteinventory.zteinventory_reserve11</code>.
     */
    public void setZteinventoryReserve11(String value) {
        set(25, value);
    }

    /**
     * Getter for <code>chrono.zteinventory.zteinventory_reserve11</code>.
     */
    public String getZteinventoryReserve11() {
        return (String) get(25);
    }

    /**
     * Setter for <code>chrono.zteinventory.zteinventory_productcode</code>.
     */
    public void setZteinventoryProductcode(String value) {
        set(26, value);
    }

    /**
     * Getter for <code>chrono.zteinventory.zteinventory_productcode</code>.
     */
    public String getZteinventoryProductcode() {
        return (String) get(26);
    }

    /**
     * Setter for <code>chrono.zteinventory.zteinventory_isfirst</code>.
     */
    public void setZteinventoryIsfirst(Integer value) {
        set(27, value);
    }

    /**
     * Getter for <code>chrono.zteinventory.zteinventory_isfirst</code>.
     */
    public Integer getZteinventoryIsfirst() {
        return (Integer) get(27);
    }

    /**
     * Setter for <code>chrono.zteinventory.zteinventory_inserttime</code>.
     */
    public void setZteinventoryInserttime(Timestamp value) {
        set(28, value);
    }

    /**
     * Getter for <code>chrono.zteinventory.zteinventory_inserttime</code>.
     */
    public Timestamp getZteinventoryInserttime() {
        return (Timestamp) get(28);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Record2<Integer, UInteger> key() {
        return (Record2) super.key();
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached ZteinventoryRecord
     */
    public ZteinventoryRecord() {
        super(Zteinventory.ZTEINVENTORY);
    }

    /**
     * Create a detached, initialised ZteinventoryRecord
     */
    public ZteinventoryRecord(UInteger zteinventoryId, Integer zteinventoryDate, Integer zteinventoryDatatype, Long zteinventoryCollectortaskfiles, Integer zteinventoryVendor, Integer zteinventorySite, String zteinventorySiteid, String zteinventoryNename, String zteinventoryInventoryunittype, String zteinventoryVendorunitfamilytype, String zteinventoryVendorname, String zteinventorySerialnumber, String zteinventoryVersionnumber, String zteinventoryDateofmanufacture, String zteinventoryUnitposition, String zteinventoryManufacturedata, String zteinventoryPacksilkscreen, String zteinventoryPackfunction, String zteinventoryNe, String zteinventoryNetype, String zteinventoryUpdatetime, String zteinventorySource, String zteinventoryState, String zteinventoryReserve1, String zteinventoryReserve2, String zteinventoryReserve11, String zteinventoryProductcode, Integer zteinventoryIsfirst, Timestamp zteinventoryInserttime) {
        super(Zteinventory.ZTEINVENTORY);

        set(0, zteinventoryId);
        set(1, zteinventoryDate);
        set(2, zteinventoryDatatype);
        set(3, zteinventoryCollectortaskfiles);
        set(4, zteinventoryVendor);
        set(5, zteinventorySite);
        set(6, zteinventorySiteid);
        set(7, zteinventoryNename);
        set(8, zteinventoryInventoryunittype);
        set(9, zteinventoryVendorunitfamilytype);
        set(10, zteinventoryVendorname);
        set(11, zteinventorySerialnumber);
        set(12, zteinventoryVersionnumber);
        set(13, zteinventoryDateofmanufacture);
        set(14, zteinventoryUnitposition);
        set(15, zteinventoryManufacturedata);
        set(16, zteinventoryPacksilkscreen);
        set(17, zteinventoryPackfunction);
        set(18, zteinventoryNe);
        set(19, zteinventoryNetype);
        set(20, zteinventoryUpdatetime);
        set(21, zteinventorySource);
        set(22, zteinventoryState);
        set(23, zteinventoryReserve1);
        set(24, zteinventoryReserve2);
        set(25, zteinventoryReserve11);
        set(26, zteinventoryProductcode);
        set(27, zteinventoryIsfirst);
        set(28, zteinventoryInserttime);
    }
}

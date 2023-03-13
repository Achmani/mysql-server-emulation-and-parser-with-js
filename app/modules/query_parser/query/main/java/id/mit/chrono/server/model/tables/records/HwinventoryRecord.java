/*
 * This file is generated by jOOQ.
*/
package id.mit.chrono.server.model.tables.records;


import id.mit.chrono.server.model.tables.Hwinventory;

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
public class HwinventoryRecord extends UpdatableRecordImpl<HwinventoryRecord> {

    private static final long serialVersionUID = 349172766;

    /**
     * Setter for <code>chrono.hwinventory.hwinventory_id</code>.
     */
    public void setHwinventoryId(UInteger value) {
        set(0, value);
    }

    /**
     * Getter for <code>chrono.hwinventory.hwinventory_id</code>.
     */
    public UInteger getHwinventoryId() {
        return (UInteger) get(0);
    }

    /**
     * Setter for <code>chrono.hwinventory.hwinventory_date</code>.
     */
    public void setHwinventoryDate(Integer value) {
        set(1, value);
    }

    /**
     * Getter for <code>chrono.hwinventory.hwinventory_date</code>.
     */
    public Integer getHwinventoryDate() {
        return (Integer) get(1);
    }

    /**
     * Setter for <code>chrono.hwinventory.hwinventory_datatype</code>.
     */
    public void setHwinventoryDatatype(Integer value) {
        set(2, value);
    }

    /**
     * Getter for <code>chrono.hwinventory.hwinventory_datatype</code>.
     */
    public Integer getHwinventoryDatatype() {
        return (Integer) get(2);
    }

    /**
     * Setter for <code>chrono.hwinventory.hwinventory_collectortaskfiles</code>.
     */
    public void setHwinventoryCollectortaskfiles(Long value) {
        set(3, value);
    }

    /**
     * Getter for <code>chrono.hwinventory.hwinventory_collectortaskfiles</code>.
     */
    public Long getHwinventoryCollectortaskfiles() {
        return (Long) get(3);
    }

    /**
     * Setter for <code>chrono.hwinventory.hwinventory_vendor</code>.
     */
    public void setHwinventoryVendor(Integer value) {
        set(4, value);
    }

    /**
     * Getter for <code>chrono.hwinventory.hwinventory_vendor</code>.
     */
    public Integer getHwinventoryVendor() {
        return (Integer) get(4);
    }

    /**
     * Setter for <code>chrono.hwinventory.hwinventory_site</code>.
     */
    public void setHwinventorySite(Integer value) {
        set(5, value);
    }

    /**
     * Getter for <code>chrono.hwinventory.hwinventory_site</code>.
     */
    public Integer getHwinventorySite() {
        return (Integer) get(5);
    }

    /**
     * Setter for <code>chrono.hwinventory.hwinventory_siteId</code>.
     */
    public void setHwinventorySiteid(String value) {
        set(6, value);
    }

    /**
     * Getter for <code>chrono.hwinventory.hwinventory_siteId</code>.
     */
    public String getHwinventorySiteid() {
        return (String) get(6);
    }

    /**
     * Setter for <code>chrono.hwinventory.hwinventory_nefdn</code>.
     */
    public void setHwinventoryNefdn(String value) {
        set(7, value);
    }

    /**
     * Getter for <code>chrono.hwinventory.hwinventory_nefdn</code>.
     */
    public String getHwinventoryNefdn() {
        return (String) get(7);
    }

    /**
     * Setter for <code>chrono.hwinventory.hwinventory_neType</code>.
     */
    public void setHwinventoryNetype(String value) {
        set(8, value);
    }

    /**
     * Getter for <code>chrono.hwinventory.hwinventory_neType</code>.
     */
    public String getHwinventoryNetype() {
        return (String) get(8);
    }

    /**
     * Setter for <code>chrono.hwinventory.hwinventory_serialnumber</code>.
     */
    public void setHwinventorySerialnumber(String value) {
        set(9, value);
    }

    /**
     * Getter for <code>chrono.hwinventory.hwinventory_serialnumber</code>.
     */
    public String getHwinventorySerialnumber() {
        return (String) get(9);
    }

    /**
     * Setter for <code>chrono.hwinventory.hwinventory_nename</code>.
     */
    public void setHwinventoryNename(String value) {
        set(10, value);
    }

    /**
     * Getter for <code>chrono.hwinventory.hwinventory_nename</code>.
     */
    public String getHwinventoryNename() {
        return (String) get(10);
    }

    /**
     * Setter for <code>chrono.hwinventory.hwinventory_boardname</code>.
     */
    public void setHwinventoryBoardname(String value) {
        set(11, value);
    }

    /**
     * Getter for <code>chrono.hwinventory.hwinventory_boardname</code>.
     */
    public String getHwinventoryBoardname() {
        return (String) get(11);
    }

    /**
     * Setter for <code>chrono.hwinventory.hwinventory_boardtype</code>.
     */
    public void setHwinventoryBoardtype(String value) {
        set(12, value);
    }

    /**
     * Getter for <code>chrono.hwinventory.hwinventory_boardtype</code>.
     */
    public String getHwinventoryBoardtype() {
        return (String) get(12);
    }

    /**
     * Setter for <code>chrono.hwinventory.hwinventory_bomcode</code>.
     */
    public void setHwinventoryBomcode(String value) {
        set(13, value);
    }

    /**
     * Getter for <code>chrono.hwinventory.hwinventory_bomcode</code>.
     */
    public String getHwinventoryBomcode() {
        return (String) get(13);
    }

    /**
     * Setter for <code>chrono.hwinventory.hwinventory_unitposition</code>.
     */
    public void setHwinventoryUnitposition(String value) {
        set(14, value);
    }

    /**
     * Getter for <code>chrono.hwinventory.hwinventory_unitposition</code>.
     */
    public String getHwinventoryUnitposition() {
        return (String) get(14);
    }

    /**
     * Setter for <code>chrono.hwinventory.hwinventory_dateofmanufacture</code>.
     */
    public void setHwinventoryDateofmanufacture(String value) {
        set(15, value);
    }

    /**
     * Getter for <code>chrono.hwinventory.hwinventory_dateofmanufacture</code>.
     */
    public String getHwinventoryDateofmanufacture() {
        return (String) get(15);
    }

    /**
     * Setter for <code>chrono.hwinventory.hwinventory_manufacturerdata</code>.
     */
    public void setHwinventoryManufacturerdata(String value) {
        set(16, value);
    }

    /**
     * Getter for <code>chrono.hwinventory.hwinventory_manufacturerdata</code>.
     */
    public String getHwinventoryManufacturerdata() {
        return (String) get(16);
    }

    /**
     * Setter for <code>chrono.hwinventory.hwinventory_cabinetno</code>.
     */
    public void setHwinventoryCabinetno(String value) {
        set(17, value);
    }

    /**
     * Getter for <code>chrono.hwinventory.hwinventory_cabinetno</code>.
     */
    public String getHwinventoryCabinetno() {
        return (String) get(17);
    }

    /**
     * Setter for <code>chrono.hwinventory.hwinventory_subrackno</code>.
     */
    public void setHwinventorySubrackno(String value) {
        set(18, value);
    }

    /**
     * Getter for <code>chrono.hwinventory.hwinventory_subrackno</code>.
     */
    public String getHwinventorySubrackno() {
        return (String) get(18);
    }

    /**
     * Setter for <code>chrono.hwinventory.hwinventory_slotno</code>.
     */
    public void setHwinventorySlotno(String value) {
        set(19, value);
    }

    /**
     * Getter for <code>chrono.hwinventory.hwinventory_slotno</code>.
     */
    public String getHwinventorySlotno() {
        return (String) get(19);
    }

    /**
     * Setter for <code>chrono.hwinventory.hwinventory_subslotno</code>.
     */
    public void setHwinventorySubslotno(String value) {
        set(20, value);
    }

    /**
     * Getter for <code>chrono.hwinventory.hwinventory_subslotno</code>.
     */
    public String getHwinventorySubslotno() {
        return (String) get(20);
    }

    /**
     * Setter for <code>chrono.hwinventory.hwinventory_portno</code>.
     */
    public void setHwinventoryPortno(String value) {
        set(21, value);
    }

    /**
     * Getter for <code>chrono.hwinventory.hwinventory_portno</code>.
     */
    public String getHwinventoryPortno() {
        return (String) get(21);
    }

    /**
     * Setter for <code>chrono.hwinventory.hwinventory_inventoryunitid</code>.
     */
    public void setHwinventoryInventoryunitid(String value) {
        set(22, value);
    }

    /**
     * Getter for <code>chrono.hwinventory.hwinventory_inventoryunitid</code>.
     */
    public String getHwinventoryInventoryunitid() {
        return (String) get(22);
    }

    /**
     * Setter for <code>chrono.hwinventory.hwinventory_inventoryunittype</code>.
     */
    public void setHwinventoryInventoryunittype(String value) {
        set(23, value);
    }

    /**
     * Getter for <code>chrono.hwinventory.hwinventory_inventoryunittype</code>.
     */
    public String getHwinventoryInventoryunittype() {
        return (String) get(23);
    }

    /**
     * Setter for <code>chrono.hwinventory.hwinventory_softwareversion</code>.
     */
    public void setHwinventorySoftwareversion(String value) {
        set(24, value);
    }

    /**
     * Getter for <code>chrono.hwinventory.hwinventory_softwareversion</code>.
     */
    public String getHwinventorySoftwareversion() {
        return (String) get(24);
    }

    /**
     * Setter for <code>chrono.hwinventory.hwinventory_hardwareversion</code>.
     */
    public void setHwinventoryHardwareversion(String value) {
        set(25, value);
    }

    /**
     * Getter for <code>chrono.hwinventory.hwinventory_hardwareversion</code>.
     */
    public String getHwinventoryHardwareversion() {
        return (String) get(25);
    }

    /**
     * Setter for <code>chrono.hwinventory.hwinverntory_isfirst</code>.
     */
    public void setHwinverntoryIsfirst(Integer value) {
        set(26, value);
    }

    /**
     * Getter for <code>chrono.hwinventory.hwinverntory_isfirst</code>.
     */
    public Integer getHwinverntoryIsfirst() {
        return (Integer) get(26);
    }

    /**
     * Setter for <code>chrono.hwinventory.hwinventory_inserttime</code>.
     */
    public void setHwinventoryInserttime(Timestamp value) {
        set(27, value);
    }

    /**
     * Getter for <code>chrono.hwinventory.hwinventory_inserttime</code>.
     */
    public Timestamp getHwinventoryInserttime() {
        return (Timestamp) get(27);
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
     * Create a detached HwinventoryRecord
     */
    public HwinventoryRecord() {
        super(Hwinventory.HWINVENTORY);
    }

    /**
     * Create a detached, initialised HwinventoryRecord
     */
    public HwinventoryRecord(UInteger hwinventoryId, Integer hwinventoryDate, Integer hwinventoryDatatype, Long hwinventoryCollectortaskfiles, Integer hwinventoryVendor, Integer hwinventorySite, String hwinventorySiteid, String hwinventoryNefdn, String hwinventoryNetype, String hwinventorySerialnumber, String hwinventoryNename, String hwinventoryBoardname, String hwinventoryBoardtype, String hwinventoryBomcode, String hwinventoryUnitposition, String hwinventoryDateofmanufacture, String hwinventoryManufacturerdata, String hwinventoryCabinetno, String hwinventorySubrackno, String hwinventorySlotno, String hwinventorySubslotno, String hwinventoryPortno, String hwinventoryInventoryunitid, String hwinventoryInventoryunittype, String hwinventorySoftwareversion, String hwinventoryHardwareversion, Integer hwinverntoryIsfirst, Timestamp hwinventoryInserttime) {
        super(Hwinventory.HWINVENTORY);

        set(0, hwinventoryId);
        set(1, hwinventoryDate);
        set(2, hwinventoryDatatype);
        set(3, hwinventoryCollectortaskfiles);
        set(4, hwinventoryVendor);
        set(5, hwinventorySite);
        set(6, hwinventorySiteid);
        set(7, hwinventoryNefdn);
        set(8, hwinventoryNetype);
        set(9, hwinventorySerialnumber);
        set(10, hwinventoryNename);
        set(11, hwinventoryBoardname);
        set(12, hwinventoryBoardtype);
        set(13, hwinventoryBomcode);
        set(14, hwinventoryUnitposition);
        set(15, hwinventoryDateofmanufacture);
        set(16, hwinventoryManufacturerdata);
        set(17, hwinventoryCabinetno);
        set(18, hwinventorySubrackno);
        set(19, hwinventorySlotno);
        set(20, hwinventorySubslotno);
        set(21, hwinventoryPortno);
        set(22, hwinventoryInventoryunitid);
        set(23, hwinventoryInventoryunittype);
        set(24, hwinventorySoftwareversion);
        set(25, hwinventoryHardwareversion);
        set(26, hwinverntoryIsfirst);
        set(27, hwinventoryInserttime);
    }
}
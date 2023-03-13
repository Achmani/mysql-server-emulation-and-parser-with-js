/*
 * This file is generated by jOOQ.
*/
package id.mit.chrono.server.model.tables.records;


import id.mit.chrono.server.model.tables.Inventory;

import java.sql.Timestamp;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record17;
import org.jooq.Row17;
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
public class InventoryRecord extends UpdatableRecordImpl<InventoryRecord> implements Record17<UInteger, Integer, Integer, Integer, Integer, String, String, String, String, String, String, String, String, String, String, String, Timestamp> {

    private static final long serialVersionUID = 1611980962;

    /**
     * Setter for <code>chrono.inventory.inventory_id</code>.
     */
    public void setInventoryId(UInteger value) {
        set(0, value);
    }

    /**
     * Getter for <code>chrono.inventory.inventory_id</code>.
     */
    public UInteger getInventoryId() {
        return (UInteger) get(0);
    }

    /**
     * Setter for <code>chrono.inventory.inventory_collectortaskfiles</code>.
     */
    public void setInventoryCollectortaskfiles(Integer value) {
        set(1, value);
    }

    /**
     * Getter for <code>chrono.inventory.inventory_collectortaskfiles</code>.
     */
    public Integer getInventoryCollectortaskfiles() {
        return (Integer) get(1);
    }

    /**
     * Setter for <code>chrono.inventory.inventory_inventorytype</code>.
     */
    public void setInventoryInventorytype(Integer value) {
        set(2, value);
    }

    /**
     * Getter for <code>chrono.inventory.inventory_inventorytype</code>.
     */
    public Integer getInventoryInventorytype() {
        return (Integer) get(2);
    }

    /**
     * Setter for <code>chrono.inventory.inventory_site</code>.
     */
    public void setInventorySite(Integer value) {
        set(3, value);
    }

    /**
     * Getter for <code>chrono.inventory.inventory_site</code>.
     */
    public Integer getInventorySite() {
        return (Integer) get(3);
    }

    /**
     * Setter for <code>chrono.inventory.inventory_brand</code>.
     */
    public void setInventoryBrand(Integer value) {
        set(4, value);
    }

    /**
     * Getter for <code>chrono.inventory.inventory_brand</code>.
     */
    public Integer getInventoryBrand() {
        return (Integer) get(4);
    }

    /**
     * Setter for <code>chrono.inventory.inventory_serialnumber</code>.
     */
    public void setInventorySerialnumber(String value) {
        set(5, value);
    }

    /**
     * Getter for <code>chrono.inventory.inventory_serialnumber</code>.
     */
    public String getInventorySerialnumber() {
        return (String) get(5);
    }

    /**
     * Setter for <code>chrono.inventory.inventory_sitename</code>.
     */
    public void setInventorySitename(String value) {
        set(6, value);
    }

    /**
     * Getter for <code>chrono.inventory.inventory_sitename</code>.
     */
    public String getInventorySitename() {
        return (String) get(6);
    }

    /**
     * Setter for <code>chrono.inventory.inventory_siteid</code>.
     */
    public void setInventorySiteid(String value) {
        set(7, value);
    }

    /**
     * Getter for <code>chrono.inventory.inventory_siteid</code>.
     */
    public String getInventorySiteid() {
        return (String) get(7);
    }

    /**
     * Setter for <code>chrono.inventory.inventory_devicename</code>.
     */
    public void setInventoryDevicename(String value) {
        set(8, value);
    }

    /**
     * Getter for <code>chrono.inventory.inventory_devicename</code>.
     */
    public String getInventoryDevicename() {
        return (String) get(8);
    }

    /**
     * Setter for <code>chrono.inventory.inventory_module</code>.
     */
    public void setInventoryModule(String value) {
        set(9, value);
    }

    /**
     * Getter for <code>chrono.inventory.inventory_module</code>.
     */
    public String getInventoryModule() {
        return (String) get(9);
    }

    /**
     * Setter for <code>chrono.inventory.inventory_region</code>.
     */
    public void setInventoryRegion(String value) {
        set(10, value);
    }

    /**
     * Getter for <code>chrono.inventory.inventory_region</code>.
     */
    public String getInventoryRegion() {
        return (String) get(10);
    }

    /**
     * Setter for <code>chrono.inventory.inventory_pid</code>.
     */
    public void setInventoryPid(String value) {
        set(11, value);
    }

    /**
     * Getter for <code>chrono.inventory.inventory_pid</code>.
     */
    public String getInventoryPid() {
        return (String) get(11);
    }

    /**
     * Setter for <code>chrono.inventory.inventory_vid</code>.
     */
    public void setInventoryVid(String value) {
        set(12, value);
    }

    /**
     * Getter for <code>chrono.inventory.inventory_vid</code>.
     */
    public String getInventoryVid() {
        return (String) get(12);
    }

    /**
     * Setter for <code>chrono.inventory.inventory_latitude</code>.
     */
    public void setInventoryLatitude(String value) {
        set(13, value);
    }

    /**
     * Getter for <code>chrono.inventory.inventory_latitude</code>.
     */
    public String getInventoryLatitude() {
        return (String) get(13);
    }

    /**
     * Setter for <code>chrono.inventory.inventory_longitude</code>.
     */
    public void setInventoryLongitude(String value) {
        set(14, value);
    }

    /**
     * Getter for <code>chrono.inventory.inventory_longitude</code>.
     */
    public String getInventoryLongitude() {
        return (String) get(14);
    }

    /**
     * Setter for <code>chrono.inventory.inventory_description</code>.
     */
    public void setInventoryDescription(String value) {
        set(15, value);
    }

    /**
     * Getter for <code>chrono.inventory.inventory_description</code>.
     */
    public String getInventoryDescription() {
        return (String) get(15);
    }

    /**
     * Setter for <code>chrono.inventory.inventory_inserttime</code>.
     */
    public void setInventoryInserttime(Timestamp value) {
        set(16, value);
    }

    /**
     * Getter for <code>chrono.inventory.inventory_inserttime</code>.
     */
    public Timestamp getInventoryInserttime() {
        return (Timestamp) get(16);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Record1<UInteger> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record17 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row17<UInteger, Integer, Integer, Integer, Integer, String, String, String, String, String, String, String, String, String, String, String, Timestamp> fieldsRow() {
        return (Row17) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row17<UInteger, Integer, Integer, Integer, Integer, String, String, String, String, String, String, String, String, String, String, String, Timestamp> valuesRow() {
        return (Row17) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<UInteger> field1() {
        return Inventory.INVENTORY.INVENTORY_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field2() {
        return Inventory.INVENTORY.INVENTORY_COLLECTORTASKFILES;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field3() {
        return Inventory.INVENTORY.INVENTORY_INVENTORYTYPE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field4() {
        return Inventory.INVENTORY.INVENTORY_SITE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field5() {
        return Inventory.INVENTORY.INVENTORY_BRAND;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field6() {
        return Inventory.INVENTORY.INVENTORY_SERIALNUMBER;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field7() {
        return Inventory.INVENTORY.INVENTORY_SITENAME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field8() {
        return Inventory.INVENTORY.INVENTORY_SITEID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field9() {
        return Inventory.INVENTORY.INVENTORY_DEVICENAME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field10() {
        return Inventory.INVENTORY.INVENTORY_MODULE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field11() {
        return Inventory.INVENTORY.INVENTORY_REGION;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field12() {
        return Inventory.INVENTORY.INVENTORY_PID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field13() {
        return Inventory.INVENTORY.INVENTORY_VID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field14() {
        return Inventory.INVENTORY.INVENTORY_LATITUDE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field15() {
        return Inventory.INVENTORY.INVENTORY_LONGITUDE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field16() {
        return Inventory.INVENTORY.INVENTORY_DESCRIPTION;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Timestamp> field17() {
        return Inventory.INVENTORY.INVENTORY_INSERTTIME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UInteger component1() {
        return getInventoryId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component2() {
        return getInventoryCollectortaskfiles();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component3() {
        return getInventoryInventorytype();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component4() {
        return getInventorySite();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component5() {
        return getInventoryBrand();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component6() {
        return getInventorySerialnumber();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component7() {
        return getInventorySitename();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component8() {
        return getInventorySiteid();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component9() {
        return getInventoryDevicename();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component10() {
        return getInventoryModule();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component11() {
        return getInventoryRegion();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component12() {
        return getInventoryPid();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component13() {
        return getInventoryVid();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component14() {
        return getInventoryLatitude();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component15() {
        return getInventoryLongitude();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component16() {
        return getInventoryDescription();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp component17() {
        return getInventoryInserttime();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UInteger value1() {
        return getInventoryId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value2() {
        return getInventoryCollectortaskfiles();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value3() {
        return getInventoryInventorytype();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value4() {
        return getInventorySite();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value5() {
        return getInventoryBrand();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value6() {
        return getInventorySerialnumber();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value7() {
        return getInventorySitename();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value8() {
        return getInventorySiteid();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value9() {
        return getInventoryDevicename();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value10() {
        return getInventoryModule();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value11() {
        return getInventoryRegion();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value12() {
        return getInventoryPid();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value13() {
        return getInventoryVid();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value14() {
        return getInventoryLatitude();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value15() {
        return getInventoryLongitude();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value16() {
        return getInventoryDescription();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp value17() {
        return getInventoryInserttime();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public InventoryRecord value1(UInteger value) {
        setInventoryId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public InventoryRecord value2(Integer value) {
        setInventoryCollectortaskfiles(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public InventoryRecord value3(Integer value) {
        setInventoryInventorytype(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public InventoryRecord value4(Integer value) {
        setInventorySite(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public InventoryRecord value5(Integer value) {
        setInventoryBrand(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public InventoryRecord value6(String value) {
        setInventorySerialnumber(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public InventoryRecord value7(String value) {
        setInventorySitename(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public InventoryRecord value8(String value) {
        setInventorySiteid(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public InventoryRecord value9(String value) {
        setInventoryDevicename(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public InventoryRecord value10(String value) {
        setInventoryModule(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public InventoryRecord value11(String value) {
        setInventoryRegion(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public InventoryRecord value12(String value) {
        setInventoryPid(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public InventoryRecord value13(String value) {
        setInventoryVid(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public InventoryRecord value14(String value) {
        setInventoryLatitude(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public InventoryRecord value15(String value) {
        setInventoryLongitude(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public InventoryRecord value16(String value) {
        setInventoryDescription(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public InventoryRecord value17(Timestamp value) {
        setInventoryInserttime(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public InventoryRecord values(UInteger value1, Integer value2, Integer value3, Integer value4, Integer value5, String value6, String value7, String value8, String value9, String value10, String value11, String value12, String value13, String value14, String value15, String value16, Timestamp value17) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        value8(value8);
        value9(value9);
        value10(value10);
        value11(value11);
        value12(value12);
        value13(value13);
        value14(value14);
        value15(value15);
        value16(value16);
        value17(value17);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached InventoryRecord
     */
    public InventoryRecord() {
        super(Inventory.INVENTORY);
    }

    /**
     * Create a detached, initialised InventoryRecord
     */
    public InventoryRecord(UInteger inventoryId, Integer inventoryCollectortaskfiles, Integer inventoryInventorytype, Integer inventorySite, Integer inventoryBrand, String inventorySerialnumber, String inventorySitename, String inventorySiteid, String inventoryDevicename, String inventoryModule, String inventoryRegion, String inventoryPid, String inventoryVid, String inventoryLatitude, String inventoryLongitude, String inventoryDescription, Timestamp inventoryInserttime) {
        super(Inventory.INVENTORY);

        set(0, inventoryId);
        set(1, inventoryCollectortaskfiles);
        set(2, inventoryInventorytype);
        set(3, inventorySite);
        set(4, inventoryBrand);
        set(5, inventorySerialnumber);
        set(6, inventorySitename);
        set(7, inventorySiteid);
        set(8, inventoryDevicename);
        set(9, inventoryModule);
        set(10, inventoryRegion);
        set(11, inventoryPid);
        set(12, inventoryVid);
        set(13, inventoryLatitude);
        set(14, inventoryLongitude);
        set(15, inventoryDescription);
        set(16, inventoryInserttime);
    }
}

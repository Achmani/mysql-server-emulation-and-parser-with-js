/*
 * This file is generated by jOOQ.
*/
package id.mit.chrono.server.model.tables.records;


import id.mit.chrono.server.model.tables.Crvendorparamset;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record9;
import org.jooq.Row9;
import org.jooq.impl.UpdatableRecordImpl;


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
public class CrvendorparamsetRecord extends UpdatableRecordImpl<CrvendorparamsetRecord> implements Record9<Integer, Integer, Integer, Integer, String, String, String, String, Byte> {

    private static final long serialVersionUID = 1681316247;

    /**
     * Setter for <code>chrono.crvendorparamset.vendorparamset_id</code>.
     */
    public void setVendorparamsetId(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>chrono.crvendorparamset.vendorparamset_id</code>.
     */
    public Integer getVendorparamsetId() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>chrono.crvendorparamset.vendorparamset_vendor</code>.
     */
    public void setVendorparamsetVendor(Integer value) {
        set(1, value);
    }

    /**
     * Getter for <code>chrono.crvendorparamset.vendorparamset_vendor</code>.
     */
    public Integer getVendorparamsetVendor() {
        return (Integer) get(1);
    }

    /**
     * Setter for <code>chrono.crvendorparamset.vendorparamset_datagroup</code>.
     */
    public void setVendorparamsetDatagroup(Integer value) {
        set(2, value);
    }

    /**
     * Getter for <code>chrono.crvendorparamset.vendorparamset_datagroup</code>.
     */
    public Integer getVendorparamsetDatagroup() {
        return (Integer) get(2);
    }

    /**
     * Setter for <code>chrono.crvendorparamset.vendorparamset_datasourcetype</code>.
     */
    public void setVendorparamsetDatasourcetype(Integer value) {
        set(3, value);
    }

    /**
     * Getter for <code>chrono.crvendorparamset.vendorparamset_datasourcetype</code>.
     */
    public Integer getVendorparamsetDatasourcetype() {
        return (Integer) get(3);
    }

    /**
     * Setter for <code>chrono.crvendorparamset.vendorparamset_identitypattern</code>.
     */
    public void setVendorparamsetIdentitypattern(String value) {
        set(4, value);
    }

    /**
     * Getter for <code>chrono.crvendorparamset.vendorparamset_identitypattern</code>.
     */
    public String getVendorparamsetIdentitypattern() {
        return (String) get(4);
    }

    /**
     * Setter for <code>chrono.crvendorparamset.vendorparamset_dependencies</code>.
     */
    public void setVendorparamsetDependencies(String value) {
        set(5, value);
    }

    /**
     * Getter for <code>chrono.crvendorparamset.vendorparamset_dependencies</code>.
     */
    public String getVendorparamsetDependencies() {
        return (String) get(5);
    }

    /**
     * Setter for <code>chrono.crvendorparamset.vendorparamset_class</code>.
     */
    public void setVendorparamsetClass(String value) {
        set(6, value);
    }

    /**
     * Getter for <code>chrono.crvendorparamset.vendorparamset_class</code>.
     */
    public String getVendorparamsetClass() {
        return (String) get(6);
    }

    /**
     * Setter for <code>chrono.crvendorparamset.vendorparamset_description</code>.
     */
    public void setVendorparamsetDescription(String value) {
        set(7, value);
    }

    /**
     * Getter for <code>chrono.crvendorparamset.vendorparamset_description</code>.
     */
    public String getVendorparamsetDescription() {
        return (String) get(7);
    }

    /**
     * Setter for <code>chrono.crvendorparamset.vendorparamset_enabled</code>.
     */
    public void setVendorparamsetEnabled(Byte value) {
        set(8, value);
    }

    /**
     * Getter for <code>chrono.crvendorparamset.vendorparamset_enabled</code>.
     */
    public Byte getVendorparamsetEnabled() {
        return (Byte) get(8);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Record1<Integer> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record9 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row9<Integer, Integer, Integer, Integer, String, String, String, String, Byte> fieldsRow() {
        return (Row9) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row9<Integer, Integer, Integer, Integer, String, String, String, String, Byte> valuesRow() {
        return (Row9) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field1() {
        return Crvendorparamset.CRVENDORPARAMSET.VENDORPARAMSET_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field2() {
        return Crvendorparamset.CRVENDORPARAMSET.VENDORPARAMSET_VENDOR;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field3() {
        return Crvendorparamset.CRVENDORPARAMSET.VENDORPARAMSET_DATAGROUP;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field4() {
        return Crvendorparamset.CRVENDORPARAMSET.VENDORPARAMSET_DATASOURCETYPE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field5() {
        return Crvendorparamset.CRVENDORPARAMSET.VENDORPARAMSET_IDENTITYPATTERN;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field6() {
        return Crvendorparamset.CRVENDORPARAMSET.VENDORPARAMSET_DEPENDENCIES;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field7() {
        return Crvendorparamset.CRVENDORPARAMSET.VENDORPARAMSET_CLASS;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field8() {
        return Crvendorparamset.CRVENDORPARAMSET.VENDORPARAMSET_DESCRIPTION;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Byte> field9() {
        return Crvendorparamset.CRVENDORPARAMSET.VENDORPARAMSET_ENABLED;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component1() {
        return getVendorparamsetId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component2() {
        return getVendorparamsetVendor();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component3() {
        return getVendorparamsetDatagroup();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component4() {
        return getVendorparamsetDatasourcetype();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component5() {
        return getVendorparamsetIdentitypattern();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component6() {
        return getVendorparamsetDependencies();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component7() {
        return getVendorparamsetClass();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component8() {
        return getVendorparamsetDescription();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Byte component9() {
        return getVendorparamsetEnabled();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value1() {
        return getVendorparamsetId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value2() {
        return getVendorparamsetVendor();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value3() {
        return getVendorparamsetDatagroup();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value4() {
        return getVendorparamsetDatasourcetype();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value5() {
        return getVendorparamsetIdentitypattern();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value6() {
        return getVendorparamsetDependencies();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value7() {
        return getVendorparamsetClass();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value8() {
        return getVendorparamsetDescription();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Byte value9() {
        return getVendorparamsetEnabled();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CrvendorparamsetRecord value1(Integer value) {
        setVendorparamsetId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CrvendorparamsetRecord value2(Integer value) {
        setVendorparamsetVendor(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CrvendorparamsetRecord value3(Integer value) {
        setVendorparamsetDatagroup(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CrvendorparamsetRecord value4(Integer value) {
        setVendorparamsetDatasourcetype(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CrvendorparamsetRecord value5(String value) {
        setVendorparamsetIdentitypattern(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CrvendorparamsetRecord value6(String value) {
        setVendorparamsetDependencies(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CrvendorparamsetRecord value7(String value) {
        setVendorparamsetClass(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CrvendorparamsetRecord value8(String value) {
        setVendorparamsetDescription(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CrvendorparamsetRecord value9(Byte value) {
        setVendorparamsetEnabled(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CrvendorparamsetRecord values(Integer value1, Integer value2, Integer value3, Integer value4, String value5, String value6, String value7, String value8, Byte value9) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        value8(value8);
        value9(value9);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached CrvendorparamsetRecord
     */
    public CrvendorparamsetRecord() {
        super(Crvendorparamset.CRVENDORPARAMSET);
    }

    /**
     * Create a detached, initialised CrvendorparamsetRecord
     */
    public CrvendorparamsetRecord(Integer vendorparamsetId, Integer vendorparamsetVendor, Integer vendorparamsetDatagroup, Integer vendorparamsetDatasourcetype, String vendorparamsetIdentitypattern, String vendorparamsetDependencies, String vendorparamsetClass, String vendorparamsetDescription, Byte vendorparamsetEnabled) {
        super(Crvendorparamset.CRVENDORPARAMSET);

        set(0, vendorparamsetId);
        set(1, vendorparamsetVendor);
        set(2, vendorparamsetDatagroup);
        set(3, vendorparamsetDatasourcetype);
        set(4, vendorparamsetIdentitypattern);
        set(5, vendorparamsetDependencies);
        set(6, vendorparamsetClass);
        set(7, vendorparamsetDescription);
        set(8, vendorparamsetEnabled);
    }
}
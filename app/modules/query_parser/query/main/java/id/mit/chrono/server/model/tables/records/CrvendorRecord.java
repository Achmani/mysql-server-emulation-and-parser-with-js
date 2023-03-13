/*
 * This file is generated by jOOQ.
*/
package id.mit.chrono.server.model.tables.records;


import id.mit.chrono.server.model.tables.Crvendor;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record4;
import org.jooq.Row4;
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
public class CrvendorRecord extends UpdatableRecordImpl<CrvendorRecord> implements Record4<Integer, String, String, String> {

    private static final long serialVersionUID = 2088270131;

    /**
     * Setter for <code>chrono.crvendor.vendor_id</code>.
     */
    public void setVendorId(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>chrono.crvendor.vendor_id</code>.
     */
    public Integer getVendorId() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>chrono.crvendor.vendor_code</code>.
     */
    public void setVendorCode(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>chrono.crvendor.vendor_code</code>.
     */
    public String getVendorCode() {
        return (String) get(1);
    }

    /**
     * Setter for <code>chrono.crvendor.vendor_name</code>.
     */
    public void setVendorName(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>chrono.crvendor.vendor_name</code>.
     */
    public String getVendorName() {
        return (String) get(2);
    }

    /**
     * Setter for <code>chrono.crvendor.vendor_shortname</code>.
     */
    public void setVendorShortname(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>chrono.crvendor.vendor_shortname</code>.
     */
    public String getVendorShortname() {
        return (String) get(3);
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
    // Record4 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row4<Integer, String, String, String> fieldsRow() {
        return (Row4) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row4<Integer, String, String, String> valuesRow() {
        return (Row4) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field1() {
        return Crvendor.CRVENDOR.VENDOR_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field2() {
        return Crvendor.CRVENDOR.VENDOR_CODE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field3() {
        return Crvendor.CRVENDOR.VENDOR_NAME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field4() {
        return Crvendor.CRVENDOR.VENDOR_SHORTNAME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component1() {
        return getVendorId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component2() {
        return getVendorCode();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component3() {
        return getVendorName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component4() {
        return getVendorShortname();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value1() {
        return getVendorId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value2() {
        return getVendorCode();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value3() {
        return getVendorName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value4() {
        return getVendorShortname();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CrvendorRecord value1(Integer value) {
        setVendorId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CrvendorRecord value2(String value) {
        setVendorCode(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CrvendorRecord value3(String value) {
        setVendorName(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CrvendorRecord value4(String value) {
        setVendorShortname(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CrvendorRecord values(Integer value1, String value2, String value3, String value4) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached CrvendorRecord
     */
    public CrvendorRecord() {
        super(Crvendor.CRVENDOR);
    }

    /**
     * Create a detached, initialised CrvendorRecord
     */
    public CrvendorRecord(Integer vendorId, String vendorCode, String vendorName, String vendorShortname) {
        super(Crvendor.CRVENDOR);

        set(0, vendorId);
        set(1, vendorCode);
        set(2, vendorName);
        set(3, vendorShortname);
    }
}
/*
 * This file is generated by jOOQ.
*/
package id.mit.chrono.server.model.tables.records;


import id.mit.chrono.server.model.tables.Crsitetype;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record3;
import org.jooq.Row3;
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
public class CrsitetypeRecord extends UpdatableRecordImpl<CrsitetypeRecord> implements Record3<Integer, String, String> {

    private static final long serialVersionUID = 1674613747;

    /**
     * Setter for <code>chrono.crsitetype.sitetype_id</code>.
     */
    public void setSitetypeId(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>chrono.crsitetype.sitetype_id</code>.
     */
    public Integer getSitetypeId() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>chrono.crsitetype.sitetype_code</code>.
     */
    public void setSitetypeCode(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>chrono.crsitetype.sitetype_code</code>.
     */
    public String getSitetypeCode() {
        return (String) get(1);
    }

    /**
     * Setter for <code>chrono.crsitetype.sitetype_name</code>.
     */
    public void setSitetypeName(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>chrono.crsitetype.sitetype_name</code>.
     */
    public String getSitetypeName() {
        return (String) get(2);
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
    // Record3 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row3<Integer, String, String> fieldsRow() {
        return (Row3) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row3<Integer, String, String> valuesRow() {
        return (Row3) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field1() {
        return Crsitetype.CRSITETYPE.SITETYPE_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field2() {
        return Crsitetype.CRSITETYPE.SITETYPE_CODE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field3() {
        return Crsitetype.CRSITETYPE.SITETYPE_NAME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component1() {
        return getSitetypeId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component2() {
        return getSitetypeCode();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component3() {
        return getSitetypeName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value1() {
        return getSitetypeId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value2() {
        return getSitetypeCode();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value3() {
        return getSitetypeName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CrsitetypeRecord value1(Integer value) {
        setSitetypeId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CrsitetypeRecord value2(String value) {
        setSitetypeCode(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CrsitetypeRecord value3(String value) {
        setSitetypeName(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CrsitetypeRecord values(Integer value1, String value2, String value3) {
        value1(value1);
        value2(value2);
        value3(value3);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached CrsitetypeRecord
     */
    public CrsitetypeRecord() {
        super(Crsitetype.CRSITETYPE);
    }

    /**
     * Create a detached, initialised CrsitetypeRecord
     */
    public CrsitetypeRecord(Integer sitetypeId, String sitetypeCode, String sitetypeName) {
        super(Crsitetype.CRSITETYPE);

        set(0, sitetypeId);
        set(1, sitetypeCode);
        set(2, sitetypeName);
    }
}

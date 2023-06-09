/*
 * This file is generated by jOOQ.
*/
package id.mit.chrono.server.model.tables.records;


import id.mit.chrono.server.model.tables.Crlandstatus;

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
public class CrlandstatusRecord extends UpdatableRecordImpl<CrlandstatusRecord> implements Record3<Integer, String, String> {

    private static final long serialVersionUID = -319797921;

    /**
     * Setter for <code>chrono.crlandstatus.landstatus_id</code>.
     */
    public void setLandstatusId(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>chrono.crlandstatus.landstatus_id</code>.
     */
    public Integer getLandstatusId() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>chrono.crlandstatus.landstatus_code</code>.
     */
    public void setLandstatusCode(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>chrono.crlandstatus.landstatus_code</code>.
     */
    public String getLandstatusCode() {
        return (String) get(1);
    }

    /**
     * Setter for <code>chrono.crlandstatus.landstatus_name</code>.
     */
    public void setLandstatusName(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>chrono.crlandstatus.landstatus_name</code>.
     */
    public String getLandstatusName() {
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
        return Crlandstatus.CRLANDSTATUS.LANDSTATUS_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field2() {
        return Crlandstatus.CRLANDSTATUS.LANDSTATUS_CODE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field3() {
        return Crlandstatus.CRLANDSTATUS.LANDSTATUS_NAME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component1() {
        return getLandstatusId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component2() {
        return getLandstatusCode();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component3() {
        return getLandstatusName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value1() {
        return getLandstatusId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value2() {
        return getLandstatusCode();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value3() {
        return getLandstatusName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CrlandstatusRecord value1(Integer value) {
        setLandstatusId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CrlandstatusRecord value2(String value) {
        setLandstatusCode(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CrlandstatusRecord value3(String value) {
        setLandstatusName(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CrlandstatusRecord values(Integer value1, String value2, String value3) {
        value1(value1);
        value2(value2);
        value3(value3);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached CrlandstatusRecord
     */
    public CrlandstatusRecord() {
        super(Crlandstatus.CRLANDSTATUS);
    }

    /**
     * Create a detached, initialised CrlandstatusRecord
     */
    public CrlandstatusRecord(Integer landstatusId, String landstatusCode, String landstatusName) {
        super(Crlandstatus.CRLANDSTATUS);

        set(0, landstatusId);
        set(1, landstatusCode);
        set(2, landstatusName);
    }
}

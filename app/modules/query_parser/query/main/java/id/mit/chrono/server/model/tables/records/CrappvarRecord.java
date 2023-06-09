/*
 * This file is generated by jOOQ.
*/
package id.mit.chrono.server.model.tables.records;


import id.mit.chrono.server.model.tables.Crappvar;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record5;
import org.jooq.Row5;
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
public class CrappvarRecord extends UpdatableRecordImpl<CrappvarRecord> implements Record5<Integer, String, String, String, Byte> {

    private static final long serialVersionUID = -1649931192;

    /**
     * Setter for <code>chrono.crappvar.appvar_id</code>.
     */
    public void setAppvarId(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>chrono.crappvar.appvar_id</code>.
     */
    public Integer getAppvarId() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>chrono.crappvar.appvar_code</code>.
     */
    public void setAppvarCode(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>chrono.crappvar.appvar_code</code>.
     */
    public String getAppvarCode() {
        return (String) get(1);
    }

    /**
     * Setter for <code>chrono.crappvar.appvar_name</code>.
     */
    public void setAppvarName(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>chrono.crappvar.appvar_name</code>.
     */
    public String getAppvarName() {
        return (String) get(2);
    }

    /**
     * Setter for <code>chrono.crappvar.appvar_value</code>.
     */
    public void setAppvarValue(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>chrono.crappvar.appvar_value</code>.
     */
    public String getAppvarValue() {
        return (String) get(3);
    }

    /**
     * Setter for <code>chrono.crappvar.appvar_ispublic</code>.
     */
    public void setAppvarIspublic(Byte value) {
        set(4, value);
    }

    /**
     * Getter for <code>chrono.crappvar.appvar_ispublic</code>.
     */
    public Byte getAppvarIspublic() {
        return (Byte) get(4);
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
    // Record5 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row5<Integer, String, String, String, Byte> fieldsRow() {
        return (Row5) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row5<Integer, String, String, String, Byte> valuesRow() {
        return (Row5) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field1() {
        return Crappvar.CRAPPVAR.APPVAR_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field2() {
        return Crappvar.CRAPPVAR.APPVAR_CODE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field3() {
        return Crappvar.CRAPPVAR.APPVAR_NAME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field4() {
        return Crappvar.CRAPPVAR.APPVAR_VALUE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Byte> field5() {
        return Crappvar.CRAPPVAR.APPVAR_ISPUBLIC;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component1() {
        return getAppvarId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component2() {
        return getAppvarCode();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component3() {
        return getAppvarName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component4() {
        return getAppvarValue();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Byte component5() {
        return getAppvarIspublic();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value1() {
        return getAppvarId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value2() {
        return getAppvarCode();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value3() {
        return getAppvarName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value4() {
        return getAppvarValue();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Byte value5() {
        return getAppvarIspublic();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CrappvarRecord value1(Integer value) {
        setAppvarId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CrappvarRecord value2(String value) {
        setAppvarCode(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CrappvarRecord value3(String value) {
        setAppvarName(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CrappvarRecord value4(String value) {
        setAppvarValue(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CrappvarRecord value5(Byte value) {
        setAppvarIspublic(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CrappvarRecord values(Integer value1, String value2, String value3, String value4, Byte value5) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached CrappvarRecord
     */
    public CrappvarRecord() {
        super(Crappvar.CRAPPVAR);
    }

    /**
     * Create a detached, initialised CrappvarRecord
     */
    public CrappvarRecord(Integer appvarId, String appvarCode, String appvarName, String appvarValue, Byte appvarIspublic) {
        super(Crappvar.CRAPPVAR);

        set(0, appvarId);
        set(1, appvarCode);
        set(2, appvarName);
        set(3, appvarValue);
        set(4, appvarIspublic);
    }
}

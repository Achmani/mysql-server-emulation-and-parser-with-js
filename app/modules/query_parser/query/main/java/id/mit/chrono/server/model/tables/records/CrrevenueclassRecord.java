/*
 * This file is generated by jOOQ.
*/
package id.mit.chrono.server.model.tables.records;


import id.mit.chrono.server.model.tables.Crrevenueclass;

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
public class CrrevenueclassRecord extends UpdatableRecordImpl<CrrevenueclassRecord> implements Record5<Integer, String, String, String, Byte> {

    private static final long serialVersionUID = 1299901770;

    /**
     * Setter for <code>chrono.crrevenueclass.revenueclass_id</code>.
     */
    public void setRevenueclassId(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>chrono.crrevenueclass.revenueclass_id</code>.
     */
    public Integer getRevenueclassId() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>chrono.crrevenueclass.revenueclass_code</code>.
     */
    public void setRevenueclassCode(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>chrono.crrevenueclass.revenueclass_code</code>.
     */
    public String getRevenueclassCode() {
        return (String) get(1);
    }

    /**
     * Setter for <code>chrono.crrevenueclass.revenueclass_shortname</code>.
     */
    public void setRevenueclassShortname(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>chrono.crrevenueclass.revenueclass_shortname</code>.
     */
    public String getRevenueclassShortname() {
        return (String) get(2);
    }

    /**
     * Setter for <code>chrono.crrevenueclass.revenueclass_name</code>.
     */
    public void setRevenueclassName(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>chrono.crrevenueclass.revenueclass_name</code>.
     */
    public String getRevenueclassName() {
        return (String) get(3);
    }

    /**
     * Setter for <code>chrono.crrevenueclass.revenueclass_isdefault</code>.
     */
    public void setRevenueclassIsdefault(Byte value) {
        set(4, value);
    }

    /**
     * Getter for <code>chrono.crrevenueclass.revenueclass_isdefault</code>.
     */
    public Byte getRevenueclassIsdefault() {
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
        return Crrevenueclass.CRREVENUECLASS.REVENUECLASS_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field2() {
        return Crrevenueclass.CRREVENUECLASS.REVENUECLASS_CODE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field3() {
        return Crrevenueclass.CRREVENUECLASS.REVENUECLASS_SHORTNAME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field4() {
        return Crrevenueclass.CRREVENUECLASS.REVENUECLASS_NAME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Byte> field5() {
        return Crrevenueclass.CRREVENUECLASS.REVENUECLASS_ISDEFAULT;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component1() {
        return getRevenueclassId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component2() {
        return getRevenueclassCode();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component3() {
        return getRevenueclassShortname();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component4() {
        return getRevenueclassName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Byte component5() {
        return getRevenueclassIsdefault();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value1() {
        return getRevenueclassId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value2() {
        return getRevenueclassCode();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value3() {
        return getRevenueclassShortname();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value4() {
        return getRevenueclassName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Byte value5() {
        return getRevenueclassIsdefault();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CrrevenueclassRecord value1(Integer value) {
        setRevenueclassId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CrrevenueclassRecord value2(String value) {
        setRevenueclassCode(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CrrevenueclassRecord value3(String value) {
        setRevenueclassShortname(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CrrevenueclassRecord value4(String value) {
        setRevenueclassName(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CrrevenueclassRecord value5(Byte value) {
        setRevenueclassIsdefault(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CrrevenueclassRecord values(Integer value1, String value2, String value3, String value4, Byte value5) {
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
     * Create a detached CrrevenueclassRecord
     */
    public CrrevenueclassRecord() {
        super(Crrevenueclass.CRREVENUECLASS);
    }

    /**
     * Create a detached, initialised CrrevenueclassRecord
     */
    public CrrevenueclassRecord(Integer revenueclassId, String revenueclassCode, String revenueclassShortname, String revenueclassName, Byte revenueclassIsdefault) {
        super(Crrevenueclass.CRREVENUECLASS);

        set(0, revenueclassId);
        set(1, revenueclassCode);
        set(2, revenueclassShortname);
        set(3, revenueclassName);
        set(4, revenueclassIsdefault);
    }
}

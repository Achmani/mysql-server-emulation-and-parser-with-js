/*
 * This file is generated by jOOQ.
*/
package id.mit.chrono.server.model.tables.records;


import id.mit.chrono.server.model.tables.Crisland;

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
public class CrislandRecord extends UpdatableRecordImpl<CrislandRecord> implements Record3<Integer, String, String> {

    private static final long serialVersionUID = -306488969;

    /**
     * Setter for <code>chrono.crisland.island_id</code>.
     */
    public void setIslandId(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>chrono.crisland.island_id</code>.
     */
    public Integer getIslandId() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>chrono.crisland.island_code</code>.
     */
    public void setIslandCode(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>chrono.crisland.island_code</code>.
     */
    public String getIslandCode() {
        return (String) get(1);
    }

    /**
     * Setter for <code>chrono.crisland.island_name</code>.
     */
    public void setIslandName(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>chrono.crisland.island_name</code>.
     */
    public String getIslandName() {
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
        return Crisland.CRISLAND.ISLAND_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field2() {
        return Crisland.CRISLAND.ISLAND_CODE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field3() {
        return Crisland.CRISLAND.ISLAND_NAME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component1() {
        return getIslandId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component2() {
        return getIslandCode();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component3() {
        return getIslandName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value1() {
        return getIslandId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value2() {
        return getIslandCode();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value3() {
        return getIslandName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CrislandRecord value1(Integer value) {
        setIslandId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CrislandRecord value2(String value) {
        setIslandCode(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CrislandRecord value3(String value) {
        setIslandName(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CrislandRecord values(Integer value1, String value2, String value3) {
        value1(value1);
        value2(value2);
        value3(value3);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached CrislandRecord
     */
    public CrislandRecord() {
        super(Crisland.CRISLAND);
    }

    /**
     * Create a detached, initialised CrislandRecord
     */
    public CrislandRecord(Integer islandId, String islandCode, String islandName) {
        super(Crisland.CRISLAND);

        set(0, islandId);
        set(1, islandCode);
        set(2, islandName);
    }
}
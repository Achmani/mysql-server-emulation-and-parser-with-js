/*
 * This file is generated by jOOQ.
*/
package id.mit.chrono.server.model.tables.records;


import id.mit.chrono.server.model.tables.Crnodestate;

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
public class CrnodestateRecord extends UpdatableRecordImpl<CrnodestateRecord> implements Record3<Integer, String, String> {

    private static final long serialVersionUID = -896600433;

    /**
     * Setter for <code>chrono.crnodestate.nodestate_id</code>.
     */
    public void setNodestateId(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>chrono.crnodestate.nodestate_id</code>.
     */
    public Integer getNodestateId() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>chrono.crnodestate.nodestate_code</code>.
     */
    public void setNodestateCode(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>chrono.crnodestate.nodestate_code</code>.
     */
    public String getNodestateCode() {
        return (String) get(1);
    }

    /**
     * Setter for <code>chrono.crnodestate.nodestate_name</code>.
     */
    public void setNodestateName(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>chrono.crnodestate.nodestate_name</code>.
     */
    public String getNodestateName() {
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
        return Crnodestate.CRNODESTATE.NODESTATE_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field2() {
        return Crnodestate.CRNODESTATE.NODESTATE_CODE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field3() {
        return Crnodestate.CRNODESTATE.NODESTATE_NAME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component1() {
        return getNodestateId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component2() {
        return getNodestateCode();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component3() {
        return getNodestateName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value1() {
        return getNodestateId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value2() {
        return getNodestateCode();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value3() {
        return getNodestateName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CrnodestateRecord value1(Integer value) {
        setNodestateId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CrnodestateRecord value2(String value) {
        setNodestateCode(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CrnodestateRecord value3(String value) {
        setNodestateName(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CrnodestateRecord values(Integer value1, String value2, String value3) {
        value1(value1);
        value2(value2);
        value3(value3);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached CrnodestateRecord
     */
    public CrnodestateRecord() {
        super(Crnodestate.CRNODESTATE);
    }

    /**
     * Create a detached, initialised CrnodestateRecord
     */
    public CrnodestateRecord(Integer nodestateId, String nodestateCode, String nodestateName) {
        super(Crnodestate.CRNODESTATE);

        set(0, nodestateId);
        set(1, nodestateCode);
        set(2, nodestateName);
    }
}
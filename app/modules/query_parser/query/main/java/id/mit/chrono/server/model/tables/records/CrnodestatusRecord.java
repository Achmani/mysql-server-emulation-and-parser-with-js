/*
 * This file is generated by jOOQ.
*/
package id.mit.chrono.server.model.tables.records;


import id.mit.chrono.server.model.tables.Crnodestatus;

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
public class CrnodestatusRecord extends UpdatableRecordImpl<CrnodestatusRecord> implements Record4<Integer, String, String, String> {

    private static final long serialVersionUID = 1830690671;

    /**
     * Setter for <code>chrono.crnodestatus.nodestatus_id</code>.
     */
    public void setNodestatusId(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>chrono.crnodestatus.nodestatus_id</code>.
     */
    public Integer getNodestatusId() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>chrono.crnodestatus.nodestatus_code</code>.
     */
    public void setNodestatusCode(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>chrono.crnodestatus.nodestatus_code</code>.
     */
    public String getNodestatusCode() {
        return (String) get(1);
    }

    /**
     * Setter for <code>chrono.crnodestatus.nodestatus_name</code>.
     */
    public void setNodestatusName(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>chrono.crnodestatus.nodestatus_name</code>.
     */
    public String getNodestatusName() {
        return (String) get(2);
    }

    /**
     * Setter for <code>chrono.crnodestatus.nodestatus_prefix</code>.
     */
    public void setNodestatusPrefix(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>chrono.crnodestatus.nodestatus_prefix</code>.
     */
    public String getNodestatusPrefix() {
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
        return Crnodestatus.CRNODESTATUS.NODESTATUS_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field2() {
        return Crnodestatus.CRNODESTATUS.NODESTATUS_CODE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field3() {
        return Crnodestatus.CRNODESTATUS.NODESTATUS_NAME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field4() {
        return Crnodestatus.CRNODESTATUS.NODESTATUS_PREFIX;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component1() {
        return getNodestatusId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component2() {
        return getNodestatusCode();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component3() {
        return getNodestatusName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component4() {
        return getNodestatusPrefix();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value1() {
        return getNodestatusId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value2() {
        return getNodestatusCode();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value3() {
        return getNodestatusName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value4() {
        return getNodestatusPrefix();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CrnodestatusRecord value1(Integer value) {
        setNodestatusId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CrnodestatusRecord value2(String value) {
        setNodestatusCode(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CrnodestatusRecord value3(String value) {
        setNodestatusName(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CrnodestatusRecord value4(String value) {
        setNodestatusPrefix(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CrnodestatusRecord values(Integer value1, String value2, String value3, String value4) {
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
     * Create a detached CrnodestatusRecord
     */
    public CrnodestatusRecord() {
        super(Crnodestatus.CRNODESTATUS);
    }

    /**
     * Create a detached, initialised CrnodestatusRecord
     */
    public CrnodestatusRecord(Integer nodestatusId, String nodestatusCode, String nodestatusName, String nodestatusPrefix) {
        super(Crnodestatus.CRNODESTATUS);

        set(0, nodestatusId);
        set(1, nodestatusCode);
        set(2, nodestatusName);
        set(3, nodestatusPrefix);
    }
}

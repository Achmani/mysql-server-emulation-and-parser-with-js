/*
 * This file is generated by jOOQ.
*/
package id.mit.chrono.server.model.tables.records;


import id.mit.chrono.server.model.tables.Crdatagroup;

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
public class CrdatagroupRecord extends UpdatableRecordImpl<CrdatagroupRecord> implements Record4<Integer, String, String, String> {

    private static final long serialVersionUID = 1388973991;

    /**
     * Setter for <code>chrono.crdatagroup.datagroup_id</code>.
     */
    public void setDatagroupId(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>chrono.crdatagroup.datagroup_id</code>.
     */
    public Integer getDatagroupId() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>chrono.crdatagroup.datagroup_code</code>.
     */
    public void setDatagroupCode(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>chrono.crdatagroup.datagroup_code</code>.
     */
    public String getDatagroupCode() {
        return (String) get(1);
    }

    /**
     * Setter for <code>chrono.crdatagroup.datagroup_name</code>.
     */
    public void setDatagroupName(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>chrono.crdatagroup.datagroup_name</code>.
     */
    public String getDatagroupName() {
        return (String) get(2);
    }

    /**
     * Setter for <code>chrono.crdatagroup.datagroup_desc</code>.
     */
    public void setDatagroupDesc(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>chrono.crdatagroup.datagroup_desc</code>.
     */
    public String getDatagroupDesc() {
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
        return Crdatagroup.CRDATAGROUP.DATAGROUP_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field2() {
        return Crdatagroup.CRDATAGROUP.DATAGROUP_CODE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field3() {
        return Crdatagroup.CRDATAGROUP.DATAGROUP_NAME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field4() {
        return Crdatagroup.CRDATAGROUP.DATAGROUP_DESC;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component1() {
        return getDatagroupId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component2() {
        return getDatagroupCode();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component3() {
        return getDatagroupName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component4() {
        return getDatagroupDesc();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value1() {
        return getDatagroupId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value2() {
        return getDatagroupCode();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value3() {
        return getDatagroupName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value4() {
        return getDatagroupDesc();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CrdatagroupRecord value1(Integer value) {
        setDatagroupId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CrdatagroupRecord value2(String value) {
        setDatagroupCode(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CrdatagroupRecord value3(String value) {
        setDatagroupName(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CrdatagroupRecord value4(String value) {
        setDatagroupDesc(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CrdatagroupRecord values(Integer value1, String value2, String value3, String value4) {
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
     * Create a detached CrdatagroupRecord
     */
    public CrdatagroupRecord() {
        super(Crdatagroup.CRDATAGROUP);
    }

    /**
     * Create a detached, initialised CrdatagroupRecord
     */
    public CrdatagroupRecord(Integer datagroupId, String datagroupCode, String datagroupName, String datagroupDesc) {
        super(Crdatagroup.CRDATAGROUP);

        set(0, datagroupId);
        set(1, datagroupCode);
        set(2, datagroupName);
        set(3, datagroupDesc);
    }
}

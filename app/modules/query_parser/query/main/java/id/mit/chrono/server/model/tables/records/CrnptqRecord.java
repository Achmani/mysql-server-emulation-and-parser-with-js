/*
 * This file is generated by jOOQ.
*/
package id.mit.chrono.server.model.tables.records;


import id.mit.chrono.server.model.tables.Crnptq;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record8;
import org.jooq.Row8;
import org.jooq.impl.UpdatableRecordImpl;
import org.jooq.types.UInteger;


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
public class CrnptqRecord extends UpdatableRecordImpl<CrnptqRecord> implements Record8<UInteger, String, String, String, String, String, Integer, String> {

    private static final long serialVersionUID = 277130890;

    /**
     * Setter for <code>chrono.crnptq.nptq_id</code>.
     */
    public void setNptqId(UInteger value) {
        set(0, value);
    }

    /**
     * Getter for <code>chrono.crnptq.nptq_id</code>.
     */
    public UInteger getNptqId() {
        return (UInteger) get(0);
    }

    /**
     * Setter for <code>chrono.crnptq.nptq_object</code>.
     */
    public void setNptqObject(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>chrono.crnptq.nptq_object</code>.
     */
    public String getNptqObject() {
        return (String) get(1);
    }

    /**
     * Setter for <code>chrono.crnptq.nptq_params</code>.
     */
    public void setNptqParams(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>chrono.crnptq.nptq_params</code>.
     */
    public String getNptqParams() {
        return (String) get(2);
    }

    /**
     * Setter for <code>chrono.crnptq.nptq_entity</code>.
     */
    public void setNptqEntity(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>chrono.crnptq.nptq_entity</code>.
     */
    public String getNptqEntity() {
        return (String) get(3);
    }

    /**
     * Setter for <code>chrono.crnptq.nptq_backup_object</code>.
     */
    public void setNptqBackupObject(String value) {
        set(4, value);
    }

    /**
     * Getter for <code>chrono.crnptq.nptq_backup_object</code>.
     */
    public String getNptqBackupObject() {
        return (String) get(4);
    }

    /**
     * Setter for <code>chrono.crnptq.nptq_backup_params</code>.
     */
    public void setNptqBackupParams(String value) {
        set(5, value);
    }

    /**
     * Getter for <code>chrono.crnptq.nptq_backup_params</code>.
     */
    public String getNptqBackupParams() {
        return (String) get(5);
    }

    /**
     * Setter for <code>chrono.crnptq.nptq_priority</code>.
     */
    public void setNptqPriority(Integer value) {
        set(6, value);
    }

    /**
     * Getter for <code>chrono.crnptq.nptq_priority</code>.
     */
    public Integer getNptqPriority() {
        return (Integer) get(6);
    }

    /**
     * Setter for <code>chrono.crnptq.nptq_mo_level</code>.
     */
    public void setNptqMoLevel(String value) {
        set(7, value);
    }

    /**
     * Getter for <code>chrono.crnptq.nptq_mo_level</code>.
     */
    public String getNptqMoLevel() {
        return (String) get(7);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Record1<UInteger> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record8 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row8<UInteger, String, String, String, String, String, Integer, String> fieldsRow() {
        return (Row8) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row8<UInteger, String, String, String, String, String, Integer, String> valuesRow() {
        return (Row8) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<UInteger> field1() {
        return Crnptq.CRNPTQ.NPTQ_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field2() {
        return Crnptq.CRNPTQ.NPTQ_OBJECT;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field3() {
        return Crnptq.CRNPTQ.NPTQ_PARAMS;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field4() {
        return Crnptq.CRNPTQ.NPTQ_ENTITY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field5() {
        return Crnptq.CRNPTQ.NPTQ_BACKUP_OBJECT;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field6() {
        return Crnptq.CRNPTQ.NPTQ_BACKUP_PARAMS;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field7() {
        return Crnptq.CRNPTQ.NPTQ_PRIORITY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field8() {
        return Crnptq.CRNPTQ.NPTQ_MO_LEVEL;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UInteger component1() {
        return getNptqId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component2() {
        return getNptqObject();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component3() {
        return getNptqParams();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component4() {
        return getNptqEntity();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component5() {
        return getNptqBackupObject();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component6() {
        return getNptqBackupParams();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component7() {
        return getNptqPriority();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component8() {
        return getNptqMoLevel();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UInteger value1() {
        return getNptqId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value2() {
        return getNptqObject();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value3() {
        return getNptqParams();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value4() {
        return getNptqEntity();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value5() {
        return getNptqBackupObject();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value6() {
        return getNptqBackupParams();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value7() {
        return getNptqPriority();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value8() {
        return getNptqMoLevel();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CrnptqRecord value1(UInteger value) {
        setNptqId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CrnptqRecord value2(String value) {
        setNptqObject(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CrnptqRecord value3(String value) {
        setNptqParams(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CrnptqRecord value4(String value) {
        setNptqEntity(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CrnptqRecord value5(String value) {
        setNptqBackupObject(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CrnptqRecord value6(String value) {
        setNptqBackupParams(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CrnptqRecord value7(Integer value) {
        setNptqPriority(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CrnptqRecord value8(String value) {
        setNptqMoLevel(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CrnptqRecord values(UInteger value1, String value2, String value3, String value4, String value5, String value6, Integer value7, String value8) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        value8(value8);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached CrnptqRecord
     */
    public CrnptqRecord() {
        super(Crnptq.CRNPTQ);
    }

    /**
     * Create a detached, initialised CrnptqRecord
     */
    public CrnptqRecord(UInteger nptqId, String nptqObject, String nptqParams, String nptqEntity, String nptqBackupObject, String nptqBackupParams, Integer nptqPriority, String nptqMoLevel) {
        super(Crnptq.CRNPTQ);

        set(0, nptqId);
        set(1, nptqObject);
        set(2, nptqParams);
        set(3, nptqEntity);
        set(4, nptqBackupObject);
        set(5, nptqBackupParams);
        set(6, nptqPriority);
        set(7, nptqMoLevel);
    }
}

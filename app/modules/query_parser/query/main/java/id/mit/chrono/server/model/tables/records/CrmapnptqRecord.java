/*
 * This file is generated by jOOQ.
*/
package id.mit.chrono.server.model.tables.records;


import id.mit.chrono.server.model.tables.Crmapnptq;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record14;
import org.jooq.Row14;
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
public class CrmapnptqRecord extends UpdatableRecordImpl<CrmapnptqRecord> implements Record14<UInteger, String, String, String, String, String, String, Byte, String, String, String, String, Integer, String> {

    private static final long serialVersionUID = -1938150566;

    /**
     * Setter for <code>chrono.crmapnptq.crmapnptq_id</code>.
     */
    public void setCrmapnptqId(UInteger value) {
        set(0, value);
    }

    /**
     * Getter for <code>chrono.crmapnptq.crmapnptq_id</code>.
     */
    public UInteger getCrmapnptqId() {
        return (UInteger) get(0);
    }

    /**
     * Setter for <code>chrono.crmapnptq.crmapnptq_object</code>.
     */
    public void setCrmapnptqObject(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>chrono.crmapnptq.crmapnptq_object</code>.
     */
    public String getCrmapnptqObject() {
        return (String) get(1);
    }

    /**
     * Setter for <code>chrono.crmapnptq.crmapnptq_params</code>.
     */
    public void setCrmapnptqParams(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>chrono.crmapnptq.crmapnptq_params</code>.
     */
    public String getCrmapnptqParams() {
        return (String) get(2);
    }

    /**
     * Setter for <code>chrono.crmapnptq.mapnptq_sourcefile</code>.
     */
    public void setMapnptqSourcefile(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>chrono.crmapnptq.mapnptq_sourcefile</code>.
     */
    public String getMapnptqSourcefile() {
        return (String) get(3);
    }

    /**
     * Setter for <code>chrono.crmapnptq.mapnptq_file</code>.
     */
    public void setMapnptqFile(String value) {
        set(4, value);
    }

    /**
     * Getter for <code>chrono.crmapnptq.mapnptq_file</code>.
     */
    public String getMapnptqFile() {
        return (String) get(4);
    }

    /**
     * Setter for <code>chrono.crmapnptq.mapnptq_entitygroup</code>.
     */
    public void setMapnptqEntitygroup(String value) {
        set(5, value);
    }

    /**
     * Getter for <code>chrono.crmapnptq.mapnptq_entitygroup</code>.
     */
    public String getMapnptqEntitygroup() {
        return (String) get(5);
    }

    /**
     * Setter for <code>chrono.crmapnptq.mapnptq_entity</code>.
     */
    public void setMapnptqEntity(String value) {
        set(6, value);
    }

    /**
     * Getter for <code>chrono.crmapnptq.mapnptq_entity</code>.
     */
    public String getMapnptqEntity() {
        return (String) get(6);
    }

    /**
     * Setter for <code>chrono.crmapnptq.crmapnptq_enable</code>.
     */
    public void setCrmapnptqEnable(Byte value) {
        set(7, value);
    }

    /**
     * Getter for <code>chrono.crmapnptq.crmapnptq_enable</code>.
     */
    public Byte getCrmapnptqEnable() {
        return (Byte) get(7);
    }

    /**
     * Setter for <code>chrono.crmapnptq.mapnptq_alias</code>.
     */
    public void setMapnptqAlias(String value) {
        set(8, value);
    }

    /**
     * Getter for <code>chrono.crmapnptq.mapnptq_alias</code>.
     */
    public String getMapnptqAlias() {
        return (String) get(8);
    }

    /**
     * Setter for <code>chrono.crmapnptq.crmapnptq_backup_object</code>.
     */
    public void setCrmapnptqBackupObject(String value) {
        set(9, value);
    }

    /**
     * Getter for <code>chrono.crmapnptq.crmapnptq_backup_object</code>.
     */
    public String getCrmapnptqBackupObject() {
        return (String) get(9);
    }

    /**
     * Setter for <code>chrono.crmapnptq.crmapnptq_backup_params</code>.
     */
    public void setCrmapnptqBackupParams(String value) {
        set(10, value);
    }

    /**
     * Getter for <code>chrono.crmapnptq.crmapnptq_backup_params</code>.
     */
    public String getCrmapnptqBackupParams() {
        return (String) get(10);
    }

    /**
     * Setter for <code>chrono.crmapnptq.crmapnptq_custom_function</code>.
     */
    public void setCrmapnptqCustomFunction(String value) {
        set(11, value);
    }

    /**
     * Getter for <code>chrono.crmapnptq.crmapnptq_custom_function</code>.
     */
    public String getCrmapnptqCustomFunction() {
        return (String) get(11);
    }

    /**
     * Setter for <code>chrono.crmapnptq.crmapnptq_priority</code>.
     */
    public void setCrmapnptqPriority(Integer value) {
        set(12, value);
    }

    /**
     * Getter for <code>chrono.crmapnptq.crmapnptq_priority</code>.
     */
    public Integer getCrmapnptqPriority() {
        return (Integer) get(12);
    }

    /**
     * Setter for <code>chrono.crmapnptq.crmapnptq_mo_level</code>.
     */
    public void setCrmapnptqMoLevel(String value) {
        set(13, value);
    }

    /**
     * Getter for <code>chrono.crmapnptq.crmapnptq_mo_level</code>.
     */
    public String getCrmapnptqMoLevel() {
        return (String) get(13);
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
    // Record14 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row14<UInteger, String, String, String, String, String, String, Byte, String, String, String, String, Integer, String> fieldsRow() {
        return (Row14) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row14<UInteger, String, String, String, String, String, String, Byte, String, String, String, String, Integer, String> valuesRow() {
        return (Row14) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<UInteger> field1() {
        return Crmapnptq.CRMAPNPTQ.CRMAPNPTQ_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field2() {
        return Crmapnptq.CRMAPNPTQ.CRMAPNPTQ_OBJECT;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field3() {
        return Crmapnptq.CRMAPNPTQ.CRMAPNPTQ_PARAMS;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field4() {
        return Crmapnptq.CRMAPNPTQ.MAPNPTQ_SOURCEFILE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field5() {
        return Crmapnptq.CRMAPNPTQ.MAPNPTQ_FILE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field6() {
        return Crmapnptq.CRMAPNPTQ.MAPNPTQ_ENTITYGROUP;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field7() {
        return Crmapnptq.CRMAPNPTQ.MAPNPTQ_ENTITY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Byte> field8() {
        return Crmapnptq.CRMAPNPTQ.CRMAPNPTQ_ENABLE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field9() {
        return Crmapnptq.CRMAPNPTQ.MAPNPTQ_ALIAS;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field10() {
        return Crmapnptq.CRMAPNPTQ.CRMAPNPTQ_BACKUP_OBJECT;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field11() {
        return Crmapnptq.CRMAPNPTQ.CRMAPNPTQ_BACKUP_PARAMS;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field12() {
        return Crmapnptq.CRMAPNPTQ.CRMAPNPTQ_CUSTOM_FUNCTION;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field13() {
        return Crmapnptq.CRMAPNPTQ.CRMAPNPTQ_PRIORITY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field14() {
        return Crmapnptq.CRMAPNPTQ.CRMAPNPTQ_MO_LEVEL;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UInteger component1() {
        return getCrmapnptqId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component2() {
        return getCrmapnptqObject();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component3() {
        return getCrmapnptqParams();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component4() {
        return getMapnptqSourcefile();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component5() {
        return getMapnptqFile();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component6() {
        return getMapnptqEntitygroup();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component7() {
        return getMapnptqEntity();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Byte component8() {
        return getCrmapnptqEnable();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component9() {
        return getMapnptqAlias();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component10() {
        return getCrmapnptqBackupObject();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component11() {
        return getCrmapnptqBackupParams();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component12() {
        return getCrmapnptqCustomFunction();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component13() {
        return getCrmapnptqPriority();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component14() {
        return getCrmapnptqMoLevel();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UInteger value1() {
        return getCrmapnptqId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value2() {
        return getCrmapnptqObject();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value3() {
        return getCrmapnptqParams();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value4() {
        return getMapnptqSourcefile();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value5() {
        return getMapnptqFile();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value6() {
        return getMapnptqEntitygroup();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value7() {
        return getMapnptqEntity();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Byte value8() {
        return getCrmapnptqEnable();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value9() {
        return getMapnptqAlias();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value10() {
        return getCrmapnptqBackupObject();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value11() {
        return getCrmapnptqBackupParams();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value12() {
        return getCrmapnptqCustomFunction();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value13() {
        return getCrmapnptqPriority();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value14() {
        return getCrmapnptqMoLevel();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CrmapnptqRecord value1(UInteger value) {
        setCrmapnptqId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CrmapnptqRecord value2(String value) {
        setCrmapnptqObject(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CrmapnptqRecord value3(String value) {
        setCrmapnptqParams(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CrmapnptqRecord value4(String value) {
        setMapnptqSourcefile(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CrmapnptqRecord value5(String value) {
        setMapnptqFile(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CrmapnptqRecord value6(String value) {
        setMapnptqEntitygroup(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CrmapnptqRecord value7(String value) {
        setMapnptqEntity(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CrmapnptqRecord value8(Byte value) {
        setCrmapnptqEnable(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CrmapnptqRecord value9(String value) {
        setMapnptqAlias(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CrmapnptqRecord value10(String value) {
        setCrmapnptqBackupObject(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CrmapnptqRecord value11(String value) {
        setCrmapnptqBackupParams(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CrmapnptqRecord value12(String value) {
        setCrmapnptqCustomFunction(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CrmapnptqRecord value13(Integer value) {
        setCrmapnptqPriority(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CrmapnptqRecord value14(String value) {
        setCrmapnptqMoLevel(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CrmapnptqRecord values(UInteger value1, String value2, String value3, String value4, String value5, String value6, String value7, Byte value8, String value9, String value10, String value11, String value12, Integer value13, String value14) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        value8(value8);
        value9(value9);
        value10(value10);
        value11(value11);
        value12(value12);
        value13(value13);
        value14(value14);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached CrmapnptqRecord
     */
    public CrmapnptqRecord() {
        super(Crmapnptq.CRMAPNPTQ);
    }

    /**
     * Create a detached, initialised CrmapnptqRecord
     */
    public CrmapnptqRecord(UInteger crmapnptqId, String crmapnptqObject, String crmapnptqParams, String mapnptqSourcefile, String mapnptqFile, String mapnptqEntitygroup, String mapnptqEntity, Byte crmapnptqEnable, String mapnptqAlias, String crmapnptqBackupObject, String crmapnptqBackupParams, String crmapnptqCustomFunction, Integer crmapnptqPriority, String crmapnptqMoLevel) {
        super(Crmapnptq.CRMAPNPTQ);

        set(0, crmapnptqId);
        set(1, crmapnptqObject);
        set(2, crmapnptqParams);
        set(3, mapnptqSourcefile);
        set(4, mapnptqFile);
        set(5, mapnptqEntitygroup);
        set(6, mapnptqEntity);
        set(7, crmapnptqEnable);
        set(8, mapnptqAlias);
        set(9, crmapnptqBackupObject);
        set(10, crmapnptqBackupParams);
        set(11, crmapnptqCustomFunction);
        set(12, crmapnptqPriority);
        set(13, crmapnptqMoLevel);
    }
}

/*
 * This file is generated by jOOQ.
*/
package id.mit.chrono.server.model.tables.records;


import id.mit.chrono.server.model.tables.Crobject;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record9;
import org.jooq.Row9;
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
public class CrobjectRecord extends UpdatableRecordImpl<CrobjectRecord> implements Record9<UInteger, String, UInteger, Integer, String, Byte, Byte, Integer, String> {

    private static final long serialVersionUID = 1166303071;

    /**
     * Setter for <code>chrono.crobject.crobject_id</code>.
     */
    public void setCrobjectId(UInteger value) {
        set(0, value);
    }

    /**
     * Getter for <code>chrono.crobject.crobject_id</code>.
     */
    public UInteger getCrobjectId() {
        return (UInteger) get(0);
    }

    /**
     * Setter for <code>chrono.crobject.crobject_code</code>.
     */
    public void setCrobjectCode(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>chrono.crobject.crobject_code</code>.
     */
    public String getCrobjectCode() {
        return (String) get(1);
    }

    /**
     * Setter for <code>chrono.crobject.crobject_vendor</code>.
     */
    public void setCrobjectVendor(UInteger value) {
        set(2, value);
    }

    /**
     * Getter for <code>chrono.crobject.crobject_vendor</code>.
     */
    public UInteger getCrobjectVendor() {
        return (UInteger) get(2);
    }

    /**
     * Setter for <code>chrono.crobject.crobject_objectcategory</code>.
     */
    public void setCrobjectObjectcategory(Integer value) {
        set(3, value);
    }

    /**
     * Getter for <code>chrono.crobject.crobject_objectcategory</code>.
     */
    public Integer getCrobjectObjectcategory() {
        return (Integer) get(3);
    }

    /**
     * Setter for <code>chrono.crobject.crobject_label</code>.
     */
    public void setCrobjectLabel(String value) {
        set(4, value);
    }

    /**
     * Getter for <code>chrono.crobject.crobject_label</code>.
     */
    public String getCrobjectLabel() {
        return (String) get(4);
    }

    /**
     * Setter for <code>chrono.crobject.crobject_isendpoint</code>.
     */
    public void setCrobjectIsendpoint(Byte value) {
        set(5, value);
    }

    /**
     * Getter for <code>chrono.crobject.crobject_isendpoint</code>.
     */
    public Byte getCrobjectIsendpoint() {
        return (Byte) get(5);
    }

    /**
     * Setter for <code>chrono.crobject.crobject_multisearch</code>.
     */
    public void setCrobjectMultisearch(Byte value) {
        set(6, value);
    }

    /**
     * Getter for <code>chrono.crobject.crobject_multisearch</code>.
     */
    public Byte getCrobjectMultisearch() {
        return (Byte) get(6);
    }

    /**
     * Setter for <code>chrono.crobject.crobject_mapentity</code>.
     */
    public void setCrobjectMapentity(Integer value) {
        set(7, value);
    }

    /**
     * Getter for <code>chrono.crobject.crobject_mapentity</code>.
     */
    public Integer getCrobjectMapentity() {
        return (Integer) get(7);
    }

    /**
     * Setter for <code>chrono.crobject.crobject_labelcolumn</code>.
     */
    public void setCrobjectLabelcolumn(String value) {
        set(8, value);
    }

    /**
     * Getter for <code>chrono.crobject.crobject_labelcolumn</code>.
     */
    public String getCrobjectLabelcolumn() {
        return (String) get(8);
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
    // Record9 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row9<UInteger, String, UInteger, Integer, String, Byte, Byte, Integer, String> fieldsRow() {
        return (Row9) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row9<UInteger, String, UInteger, Integer, String, Byte, Byte, Integer, String> valuesRow() {
        return (Row9) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<UInteger> field1() {
        return Crobject.CROBJECT.CROBJECT_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field2() {
        return Crobject.CROBJECT.CROBJECT_CODE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<UInteger> field3() {
        return Crobject.CROBJECT.CROBJECT_VENDOR;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field4() {
        return Crobject.CROBJECT.CROBJECT_OBJECTCATEGORY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field5() {
        return Crobject.CROBJECT.CROBJECT_LABEL;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Byte> field6() {
        return Crobject.CROBJECT.CROBJECT_ISENDPOINT;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Byte> field7() {
        return Crobject.CROBJECT.CROBJECT_MULTISEARCH;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field8() {
        return Crobject.CROBJECT.CROBJECT_MAPENTITY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field9() {
        return Crobject.CROBJECT.CROBJECT_LABELCOLUMN;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UInteger component1() {
        return getCrobjectId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component2() {
        return getCrobjectCode();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UInteger component3() {
        return getCrobjectVendor();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component4() {
        return getCrobjectObjectcategory();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component5() {
        return getCrobjectLabel();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Byte component6() {
        return getCrobjectIsendpoint();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Byte component7() {
        return getCrobjectMultisearch();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component8() {
        return getCrobjectMapentity();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component9() {
        return getCrobjectLabelcolumn();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UInteger value1() {
        return getCrobjectId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value2() {
        return getCrobjectCode();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UInteger value3() {
        return getCrobjectVendor();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value4() {
        return getCrobjectObjectcategory();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value5() {
        return getCrobjectLabel();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Byte value6() {
        return getCrobjectIsendpoint();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Byte value7() {
        return getCrobjectMultisearch();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value8() {
        return getCrobjectMapentity();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value9() {
        return getCrobjectLabelcolumn();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CrobjectRecord value1(UInteger value) {
        setCrobjectId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CrobjectRecord value2(String value) {
        setCrobjectCode(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CrobjectRecord value3(UInteger value) {
        setCrobjectVendor(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CrobjectRecord value4(Integer value) {
        setCrobjectObjectcategory(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CrobjectRecord value5(String value) {
        setCrobjectLabel(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CrobjectRecord value6(Byte value) {
        setCrobjectIsendpoint(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CrobjectRecord value7(Byte value) {
        setCrobjectMultisearch(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CrobjectRecord value8(Integer value) {
        setCrobjectMapentity(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CrobjectRecord value9(String value) {
        setCrobjectLabelcolumn(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CrobjectRecord values(UInteger value1, String value2, UInteger value3, Integer value4, String value5, Byte value6, Byte value7, Integer value8, String value9) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        value8(value8);
        value9(value9);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached CrobjectRecord
     */
    public CrobjectRecord() {
        super(Crobject.CROBJECT);
    }

    /**
     * Create a detached, initialised CrobjectRecord
     */
    public CrobjectRecord(UInteger crobjectId, String crobjectCode, UInteger crobjectVendor, Integer crobjectObjectcategory, String crobjectLabel, Byte crobjectIsendpoint, Byte crobjectMultisearch, Integer crobjectMapentity, String crobjectLabelcolumn) {
        super(Crobject.CROBJECT);

        set(0, crobjectId);
        set(1, crobjectCode);
        set(2, crobjectVendor);
        set(3, crobjectObjectcategory);
        set(4, crobjectLabel);
        set(5, crobjectIsendpoint);
        set(6, crobjectMultisearch);
        set(7, crobjectMapentity);
        set(8, crobjectLabelcolumn);
    }
}

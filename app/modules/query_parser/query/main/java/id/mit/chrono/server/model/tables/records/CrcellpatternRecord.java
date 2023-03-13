/*
 * This file is generated by jOOQ.
*/
package id.mit.chrono.server.model.tables.records;


import id.mit.chrono.server.model.tables.Crcellpattern;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record8;
import org.jooq.Row8;
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
public class CrcellpatternRecord extends UpdatableRecordImpl<CrcellpatternRecord> implements Record8<Integer, Integer, Integer, Integer, String, String, String, Byte> {

    private static final long serialVersionUID = -478085855;

    /**
     * Setter for <code>chrono.crcellpattern.cellpattern_id</code>.
     */
    public void setCellpatternId(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>chrono.crcellpattern.cellpattern_id</code>.
     */
    public Integer getCellpatternId() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>chrono.crcellpattern.cellpattern_vendor</code>.
     */
    public void setCellpatternVendor(Integer value) {
        set(1, value);
    }

    /**
     * Getter for <code>chrono.crcellpattern.cellpattern_vendor</code>.
     */
    public Integer getCellpatternVendor() {
        return (Integer) get(1);
    }

    /**
     * Setter for <code>chrono.crcellpattern.cellpattern_cellclass</code>.
     */
    public void setCellpatternCellclass(Integer value) {
        set(2, value);
    }

    /**
     * Getter for <code>chrono.crcellpattern.cellpattern_cellclass</code>.
     */
    public Integer getCellpatternCellclass() {
        return (Integer) get(2);
    }

    /**
     * Setter for <code>chrono.crcellpattern.cellpattern_order</code>.
     */
    public void setCellpatternOrder(Integer value) {
        set(3, value);
    }

    /**
     * Getter for <code>chrono.crcellpattern.cellpattern_order</code>.
     */
    public Integer getCellpatternOrder() {
        return (Integer) get(3);
    }

    /**
     * Setter for <code>chrono.crcellpattern.cellpattern_pattern</code>.
     */
    public void setCellpatternPattern(String value) {
        set(4, value);
    }

    /**
     * Getter for <code>chrono.crcellpattern.cellpattern_pattern</code>.
     */
    public String getCellpatternPattern() {
        return (String) get(4);
    }

    /**
     * Setter for <code>chrono.crcellpattern.cellpattern_startpattern</code>.
     */
    public void setCellpatternStartpattern(String value) {
        set(5, value);
    }

    /**
     * Getter for <code>chrono.crcellpattern.cellpattern_startpattern</code>.
     */
    public String getCellpatternStartpattern() {
        return (String) get(5);
    }

    /**
     * Setter for <code>chrono.crcellpattern.cellpattern_desc</code>.
     */
    public void setCellpatternDesc(String value) {
        set(6, value);
    }

    /**
     * Getter for <code>chrono.crcellpattern.cellpattern_desc</code>.
     */
    public String getCellpatternDesc() {
        return (String) get(6);
    }

    /**
     * Setter for <code>chrono.crcellpattern.cellpattern_enabled</code>.
     */
    public void setCellpatternEnabled(Byte value) {
        set(7, value);
    }

    /**
     * Getter for <code>chrono.crcellpattern.cellpattern_enabled</code>.
     */
    public Byte getCellpatternEnabled() {
        return (Byte) get(7);
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
    // Record8 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row8<Integer, Integer, Integer, Integer, String, String, String, Byte> fieldsRow() {
        return (Row8) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row8<Integer, Integer, Integer, Integer, String, String, String, Byte> valuesRow() {
        return (Row8) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field1() {
        return Crcellpattern.CRCELLPATTERN.CELLPATTERN_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field2() {
        return Crcellpattern.CRCELLPATTERN.CELLPATTERN_VENDOR;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field3() {
        return Crcellpattern.CRCELLPATTERN.CELLPATTERN_CELLCLASS;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field4() {
        return Crcellpattern.CRCELLPATTERN.CELLPATTERN_ORDER;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field5() {
        return Crcellpattern.CRCELLPATTERN.CELLPATTERN_PATTERN;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field6() {
        return Crcellpattern.CRCELLPATTERN.CELLPATTERN_STARTPATTERN;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field7() {
        return Crcellpattern.CRCELLPATTERN.CELLPATTERN_DESC;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Byte> field8() {
        return Crcellpattern.CRCELLPATTERN.CELLPATTERN_ENABLED;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component1() {
        return getCellpatternId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component2() {
        return getCellpatternVendor();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component3() {
        return getCellpatternCellclass();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component4() {
        return getCellpatternOrder();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component5() {
        return getCellpatternPattern();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component6() {
        return getCellpatternStartpattern();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component7() {
        return getCellpatternDesc();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Byte component8() {
        return getCellpatternEnabled();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value1() {
        return getCellpatternId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value2() {
        return getCellpatternVendor();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value3() {
        return getCellpatternCellclass();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value4() {
        return getCellpatternOrder();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value5() {
        return getCellpatternPattern();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value6() {
        return getCellpatternStartpattern();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value7() {
        return getCellpatternDesc();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Byte value8() {
        return getCellpatternEnabled();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CrcellpatternRecord value1(Integer value) {
        setCellpatternId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CrcellpatternRecord value2(Integer value) {
        setCellpatternVendor(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CrcellpatternRecord value3(Integer value) {
        setCellpatternCellclass(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CrcellpatternRecord value4(Integer value) {
        setCellpatternOrder(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CrcellpatternRecord value5(String value) {
        setCellpatternPattern(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CrcellpatternRecord value6(String value) {
        setCellpatternStartpattern(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CrcellpatternRecord value7(String value) {
        setCellpatternDesc(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CrcellpatternRecord value8(Byte value) {
        setCellpatternEnabled(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CrcellpatternRecord values(Integer value1, Integer value2, Integer value3, Integer value4, String value5, String value6, String value7, Byte value8) {
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
     * Create a detached CrcellpatternRecord
     */
    public CrcellpatternRecord() {
        super(Crcellpattern.CRCELLPATTERN);
    }

    /**
     * Create a detached, initialised CrcellpatternRecord
     */
    public CrcellpatternRecord(Integer cellpatternId, Integer cellpatternVendor, Integer cellpatternCellclass, Integer cellpatternOrder, String cellpatternPattern, String cellpatternStartpattern, String cellpatternDesc, Byte cellpatternEnabled) {
        super(Crcellpattern.CRCELLPATTERN);

        set(0, cellpatternId);
        set(1, cellpatternVendor);
        set(2, cellpatternCellclass);
        set(3, cellpatternOrder);
        set(4, cellpatternPattern);
        set(5, cellpatternStartpattern);
        set(6, cellpatternDesc);
        set(7, cellpatternEnabled);
    }
}
/*
 * This file is generated by jOOQ.
*/
package id.mit.chrono.server.model.tables.records;


import id.mit.chrono.server.model.tables.TempXxx;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record7;
import org.jooq.Row7;
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
public class TempXxxRecord extends UpdatableRecordImpl<TempXxxRecord> implements Record7<UInteger, String, String, String, String, String, String> {

    private static final long serialVersionUID = 1854718099;

    /**
     * Setter for <code>chrono.temp_xxx.id</code>.
     */
    public void setId(UInteger value) {
        set(0, value);
    }

    /**
     * Getter for <code>chrono.temp_xxx.id</code>.
     */
    public UInteger getId() {
        return (UInteger) get(0);
    }

    /**
     * Setter for <code>chrono.temp_xxx.key</code>.
     */
    public void setKey(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>chrono.temp_xxx.key</code>.
     */
    public String getKey() {
        return (String) get(1);
    }

    /**
     * Setter for <code>chrono.temp_xxx.value</code>.
     */
    public void setValue(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>chrono.temp_xxx.value</code>.
     */
    public String getValue() {
        return (String) get(2);
    }

    /**
     * Setter for <code>chrono.temp_xxx.ext1_key</code>.
     */
    public void setExt1Key(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>chrono.temp_xxx.ext1_key</code>.
     */
    public String getExt1Key() {
        return (String) get(3);
    }

    /**
     * Setter for <code>chrono.temp_xxx.ext1_value</code>.
     */
    public void setExt1Value(String value) {
        set(4, value);
    }

    /**
     * Getter for <code>chrono.temp_xxx.ext1_value</code>.
     */
    public String getExt1Value() {
        return (String) get(4);
    }

    /**
     * Setter for <code>chrono.temp_xxx.ext2_key</code>.
     */
    public void setExt2Key(String value) {
        set(5, value);
    }

    /**
     * Getter for <code>chrono.temp_xxx.ext2_key</code>.
     */
    public String getExt2Key() {
        return (String) get(5);
    }

    /**
     * Setter for <code>chrono.temp_xxx.ext2_value</code>.
     */
    public void setExt2Value(String value) {
        set(6, value);
    }

    /**
     * Getter for <code>chrono.temp_xxx.ext2_value</code>.
     */
    public String getExt2Value() {
        return (String) get(6);
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
    // Record7 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row7<UInteger, String, String, String, String, String, String> fieldsRow() {
        return (Row7) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row7<UInteger, String, String, String, String, String, String> valuesRow() {
        return (Row7) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<UInteger> field1() {
        return TempXxx.TEMP_XXX.ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field2() {
        return TempXxx.TEMP_XXX.KEY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field3() {
        return TempXxx.TEMP_XXX.VALUE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field4() {
        return TempXxx.TEMP_XXX.EXT1_KEY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field5() {
        return TempXxx.TEMP_XXX.EXT1_VALUE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field6() {
        return TempXxx.TEMP_XXX.EXT2_KEY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field7() {
        return TempXxx.TEMP_XXX.EXT2_VALUE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UInteger component1() {
        return getId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component2() {
        return getKey();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component3() {
        return getValue();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component4() {
        return getExt1Key();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component5() {
        return getExt1Value();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component6() {
        return getExt2Key();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component7() {
        return getExt2Value();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UInteger value1() {
        return getId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value2() {
        return getKey();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value3() {
        return getValue();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value4() {
        return getExt1Key();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value5() {
        return getExt1Value();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value6() {
        return getExt2Key();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value7() {
        return getExt2Value();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TempXxxRecord value1(UInteger value) {
        setId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TempXxxRecord value2(String value) {
        setKey(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TempXxxRecord value3(String value) {
        setValue(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TempXxxRecord value4(String value) {
        setExt1Key(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TempXxxRecord value5(String value) {
        setExt1Value(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TempXxxRecord value6(String value) {
        setExt2Key(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TempXxxRecord value7(String value) {
        setExt2Value(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TempXxxRecord values(UInteger value1, String value2, String value3, String value4, String value5, String value6, String value7) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached TempXxxRecord
     */
    public TempXxxRecord() {
        super(TempXxx.TEMP_XXX);
    }

    /**
     * Create a detached, initialised TempXxxRecord
     */
    public TempXxxRecord(UInteger id_, String key, String value, String ext1Key, String ext1Value, String ext2Key, String ext2Value) {
        super(TempXxx.TEMP_XXX);

        set(0, id_);
        set(1, key);
        set(2, value);
        set(3, ext1Key);
        set(4, ext1Value);
        set(5, ext2Key);
        set(6, ext2Value);
    }
}

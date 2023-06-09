/*
 * This file is generated by jOOQ.
*/
package id.mit.chrono.server.model.tables.records;


import id.mit.chrono.server.model.tables.Ztemme;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record2;
import org.jooq.Record9;
import org.jooq.Row9;
import org.jooq.impl.UpdatableRecordImpl;
import org.jooq.types.UInteger;
import org.jooq.types.ULong;


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
public class ZtemmeRecord extends UpdatableRecordImpl<ZtemmeRecord> implements Record9<ULong, ULong, UInteger, Integer, Integer, Integer, String, Integer, String> {

    private static final long serialVersionUID = 1417082182;

    /**
     * Setter for <code>chrono.ztemme.ztemme_id</code>.
     */
    public void setZtemmeId(ULong value) {
        set(0, value);
    }

    /**
     * Getter for <code>chrono.ztemme.ztemme_id</code>.
     */
    public ULong getZtemmeId() {
        return (ULong) get(0);
    }

    /**
     * Setter for <code>chrono.ztemme.ztemme_crcollectortaskfiles</code>.
     */
    public void setZtemmeCrcollectortaskfiles(ULong value) {
        set(1, value);
    }

    /**
     * Getter for <code>chrono.ztemme.ztemme_crcollectortaskfiles</code>.
     */
    public ULong getZtemmeCrcollectortaskfiles() {
        return (ULong) get(1);
    }

    /**
     * Setter for <code>chrono.ztemme.ztemme_date</code>.
     */
    public void setZtemmeDate(UInteger value) {
        set(2, value);
    }

    /**
     * Getter for <code>chrono.ztemme.ztemme_date</code>.
     */
    public UInteger getZtemmeDate() {
        return (UInteger) get(2);
    }

    /**
     * Setter for <code>chrono.ztemme.ztemme_datefrom</code>.
     */
    public void setZtemmeDatefrom(Integer value) {
        set(3, value);
    }

    /**
     * Getter for <code>chrono.ztemme.ztemme_datefrom</code>.
     */
    public Integer getZtemmeDatefrom() {
        return (Integer) get(3);
    }

    /**
     * Setter for <code>chrono.ztemme.ztemme_node</code>.
     */
    public void setZtemmeNode(Integer value) {
        set(4, value);
    }

    /**
     * Getter for <code>chrono.ztemme.ztemme_node</code>.
     */
    public Integer getZtemmeNode() {
        return (Integer) get(4);
    }

    /**
     * Setter for <code>chrono.ztemme.ztemme_vendor</code>.
     */
    public void setZtemmeVendor(Integer value) {
        set(5, value);
    }

    /**
     * Getter for <code>chrono.ztemme.ztemme_vendor</code>.
     */
    public Integer getZtemmeVendor() {
        return (Integer) get(5);
    }

    /**
     * Setter for <code>chrono.ztemme.MMENAME</code>.
     */
    public void setMmename(String value) {
        set(6, value);
    }

    /**
     * Getter for <code>chrono.ztemme.MMENAME</code>.
     */
    public String getMmename() {
        return (String) get(6);
    }

    /**
     * Setter for <code>chrono.ztemme.TOTALENODEB</code>.
     */
    public void setTotalenodeb(Integer value) {
        set(7, value);
    }

    /**
     * Getter for <code>chrono.ztemme.TOTALENODEB</code>.
     */
    public Integer getTotalenodeb() {
        return (Integer) get(7);
    }

    /**
     * Setter for <code>chrono.ztemme.ztemme_remark</code>.
     */
    public void setZtemmeRemark(String value) {
        set(8, value);
    }

    /**
     * Getter for <code>chrono.ztemme.ztemme_remark</code>.
     */
    public String getZtemmeRemark() {
        return (String) get(8);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Record2<ULong, ULong> key() {
        return (Record2) super.key();
    }

    // -------------------------------------------------------------------------
    // Record9 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row9<ULong, ULong, UInteger, Integer, Integer, Integer, String, Integer, String> fieldsRow() {
        return (Row9) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row9<ULong, ULong, UInteger, Integer, Integer, Integer, String, Integer, String> valuesRow() {
        return (Row9) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<ULong> field1() {
        return Ztemme.ZTEMME.ZTEMME_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<ULong> field2() {
        return Ztemme.ZTEMME.ZTEMME_CRCOLLECTORTASKFILES;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<UInteger> field3() {
        return Ztemme.ZTEMME.ZTEMME_DATE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field4() {
        return Ztemme.ZTEMME.ZTEMME_DATEFROM;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field5() {
        return Ztemme.ZTEMME.ZTEMME_NODE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field6() {
        return Ztemme.ZTEMME.ZTEMME_VENDOR;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field7() {
        return Ztemme.ZTEMME.MMENAME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field8() {
        return Ztemme.ZTEMME.TOTALENODEB;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field9() {
        return Ztemme.ZTEMME.ZTEMME_REMARK;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ULong component1() {
        return getZtemmeId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ULong component2() {
        return getZtemmeCrcollectortaskfiles();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UInteger component3() {
        return getZtemmeDate();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component4() {
        return getZtemmeDatefrom();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component5() {
        return getZtemmeNode();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component6() {
        return getZtemmeVendor();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component7() {
        return getMmename();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component8() {
        return getTotalenodeb();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component9() {
        return getZtemmeRemark();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ULong value1() {
        return getZtemmeId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ULong value2() {
        return getZtemmeCrcollectortaskfiles();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UInteger value3() {
        return getZtemmeDate();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value4() {
        return getZtemmeDatefrom();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value5() {
        return getZtemmeNode();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value6() {
        return getZtemmeVendor();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value7() {
        return getMmename();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value8() {
        return getTotalenodeb();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value9() {
        return getZtemmeRemark();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ZtemmeRecord value1(ULong value) {
        setZtemmeId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ZtemmeRecord value2(ULong value) {
        setZtemmeCrcollectortaskfiles(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ZtemmeRecord value3(UInteger value) {
        setZtemmeDate(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ZtemmeRecord value4(Integer value) {
        setZtemmeDatefrom(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ZtemmeRecord value5(Integer value) {
        setZtemmeNode(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ZtemmeRecord value6(Integer value) {
        setZtemmeVendor(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ZtemmeRecord value7(String value) {
        setMmename(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ZtemmeRecord value8(Integer value) {
        setTotalenodeb(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ZtemmeRecord value9(String value) {
        setZtemmeRemark(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ZtemmeRecord values(ULong value1, ULong value2, UInteger value3, Integer value4, Integer value5, Integer value6, String value7, Integer value8, String value9) {
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
     * Create a detached ZtemmeRecord
     */
    public ZtemmeRecord() {
        super(Ztemme.ZTEMME);
    }

    /**
     * Create a detached, initialised ZtemmeRecord
     */
    public ZtemmeRecord(ULong ztemmeId, ULong ztemmeCrcollectortaskfiles, UInteger ztemmeDate, Integer ztemmeDatefrom, Integer ztemmeNode, Integer ztemmeVendor, String mmename, Integer totalenodeb, String ztemmeRemark) {
        super(Ztemme.ZTEMME);

        set(0, ztemmeId);
        set(1, ztemmeCrcollectortaskfiles);
        set(2, ztemmeDate);
        set(3, ztemmeDatefrom);
        set(4, ztemmeNode);
        set(5, ztemmeVendor);
        set(6, mmename);
        set(7, totalenodeb);
        set(8, ztemmeRemark);
    }
}

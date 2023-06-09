/*
 * This file is generated by jOOQ.
*/
package id.mit.chrono.server.model.tables.records;


import id.mit.chrono.server.model.tables.Crsiteflags;

import java.sql.Timestamp;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record5;
import org.jooq.Row5;
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
public class CrsiteflagsRecord extends UpdatableRecordImpl<CrsiteflagsRecord> implements Record5<Long, Integer, Integer, String, Timestamp> {

    private static final long serialVersionUID = -1664615400;

    /**
     * Setter for <code>chrono.crsiteflags.site_flags_id</code>.
     */
    public void setSiteFlagsId(Long value) {
        set(0, value);
    }

    /**
     * Getter for <code>chrono.crsiteflags.site_flags_id</code>.
     */
    public Long getSiteFlagsId() {
        return (Long) get(0);
    }

    /**
     * Setter for <code>chrono.crsiteflags.site_id</code>.
     */
    public void setSiteId(Integer value) {
        set(1, value);
    }

    /**
     * Getter for <code>chrono.crsiteflags.site_id</code>.
     */
    public Integer getSiteId() {
        return (Integer) get(1);
    }

    /**
     * Setter for <code>chrono.crsiteflags.site_flags_flag</code>.
     */
    public void setSiteFlagsFlag(Integer value) {
        set(2, value);
    }

    /**
     * Getter for <code>chrono.crsiteflags.site_flags_flag</code>.
     */
    public Integer getSiteFlagsFlag() {
        return (Integer) get(2);
    }

    /**
     * Setter for <code>chrono.crsiteflags.site_flags_value</code>.
     */
    public void setSiteFlagsValue(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>chrono.crsiteflags.site_flags_value</code>.
     */
    public String getSiteFlagsValue() {
        return (String) get(3);
    }

    /**
     * Setter for <code>chrono.crsiteflags.site_flags_lastupdate</code>.
     */
    public void setSiteFlagsLastupdate(Timestamp value) {
        set(4, value);
    }

    /**
     * Getter for <code>chrono.crsiteflags.site_flags_lastupdate</code>.
     */
    public Timestamp getSiteFlagsLastupdate() {
        return (Timestamp) get(4);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Record1<Long> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record5 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row5<Long, Integer, Integer, String, Timestamp> fieldsRow() {
        return (Row5) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row5<Long, Integer, Integer, String, Timestamp> valuesRow() {
        return (Row5) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field1() {
        return Crsiteflags.CRSITEFLAGS.SITE_FLAGS_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field2() {
        return Crsiteflags.CRSITEFLAGS.SITE_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field3() {
        return Crsiteflags.CRSITEFLAGS.SITE_FLAGS_FLAG;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field4() {
        return Crsiteflags.CRSITEFLAGS.SITE_FLAGS_VALUE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Timestamp> field5() {
        return Crsiteflags.CRSITEFLAGS.SITE_FLAGS_LASTUPDATE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long component1() {
        return getSiteFlagsId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component2() {
        return getSiteId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component3() {
        return getSiteFlagsFlag();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component4() {
        return getSiteFlagsValue();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp component5() {
        return getSiteFlagsLastupdate();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long value1() {
        return getSiteFlagsId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value2() {
        return getSiteId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value3() {
        return getSiteFlagsFlag();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value4() {
        return getSiteFlagsValue();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp value5() {
        return getSiteFlagsLastupdate();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CrsiteflagsRecord value1(Long value) {
        setSiteFlagsId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CrsiteflagsRecord value2(Integer value) {
        setSiteId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CrsiteflagsRecord value3(Integer value) {
        setSiteFlagsFlag(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CrsiteflagsRecord value4(String value) {
        setSiteFlagsValue(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CrsiteflagsRecord value5(Timestamp value) {
        setSiteFlagsLastupdate(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CrsiteflagsRecord values(Long value1, Integer value2, Integer value3, String value4, Timestamp value5) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached CrsiteflagsRecord
     */
    public CrsiteflagsRecord() {
        super(Crsiteflags.CRSITEFLAGS);
    }

    /**
     * Create a detached, initialised CrsiteflagsRecord
     */
    public CrsiteflagsRecord(Long siteFlagsId, Integer siteId, Integer siteFlagsFlag, String siteFlagsValue, Timestamp siteFlagsLastupdate) {
        super(Crsiteflags.CRSITEFLAGS);

        set(0, siteFlagsId);
        set(1, siteId);
        set(2, siteFlagsFlag);
        set(3, siteFlagsValue);
        set(4, siteFlagsLastupdate);
    }
}

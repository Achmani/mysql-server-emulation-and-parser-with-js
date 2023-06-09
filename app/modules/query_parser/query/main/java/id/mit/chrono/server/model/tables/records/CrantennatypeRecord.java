/*
 * This file is generated by jOOQ.
*/
package id.mit.chrono.server.model.tables.records;


import id.mit.chrono.server.model.tables.Crantennatype;

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
public class CrantennatypeRecord extends UpdatableRecordImpl<CrantennatypeRecord> implements Record5<Integer, String, String, Double, Double> {

    private static final long serialVersionUID = -1522763845;

    /**
     * Setter for <code>chrono.crantennatype.antennatype_id</code>.
     */
    public void setAntennatypeId(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>chrono.crantennatype.antennatype_id</code>.
     */
    public Integer getAntennatypeId() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>chrono.crantennatype.antennatype_code</code>.
     */
    public void setAntennatypeCode(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>chrono.crantennatype.antennatype_code</code>.
     */
    public String getAntennatypeCode() {
        return (String) get(1);
    }

    /**
     * Setter for <code>chrono.crantennatype.antennatype_name</code>.
     */
    public void setAntennatypeName(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>chrono.crantennatype.antennatype_name</code>.
     */
    public String getAntennatypeName() {
        return (String) get(2);
    }

    /**
     * Setter for <code>chrono.crantennatype.antennatype_beam</code>.
     */
    public void setAntennatypeBeam(Double value) {
        set(3, value);
    }

    /**
     * Getter for <code>chrono.crantennatype.antennatype_beam</code>.
     */
    public Double getAntennatypeBeam() {
        return (Double) get(3);
    }

    /**
     * Setter for <code>chrono.crantennatype.antennatype_coverage</code>.
     */
    public void setAntennatypeCoverage(Double value) {
        set(4, value);
    }

    /**
     * Getter for <code>chrono.crantennatype.antennatype_coverage</code>.
     */
    public Double getAntennatypeCoverage() {
        return (Double) get(4);
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
    // Record5 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row5<Integer, String, String, Double, Double> fieldsRow() {
        return (Row5) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row5<Integer, String, String, Double, Double> valuesRow() {
        return (Row5) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field1() {
        return Crantennatype.CRANTENNATYPE.ANTENNATYPE_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field2() {
        return Crantennatype.CRANTENNATYPE.ANTENNATYPE_CODE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field3() {
        return Crantennatype.CRANTENNATYPE.ANTENNATYPE_NAME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Double> field4() {
        return Crantennatype.CRANTENNATYPE.ANTENNATYPE_BEAM;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Double> field5() {
        return Crantennatype.CRANTENNATYPE.ANTENNATYPE_COVERAGE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component1() {
        return getAntennatypeId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component2() {
        return getAntennatypeCode();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component3() {
        return getAntennatypeName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Double component4() {
        return getAntennatypeBeam();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Double component5() {
        return getAntennatypeCoverage();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value1() {
        return getAntennatypeId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value2() {
        return getAntennatypeCode();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value3() {
        return getAntennatypeName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Double value4() {
        return getAntennatypeBeam();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Double value5() {
        return getAntennatypeCoverage();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CrantennatypeRecord value1(Integer value) {
        setAntennatypeId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CrantennatypeRecord value2(String value) {
        setAntennatypeCode(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CrantennatypeRecord value3(String value) {
        setAntennatypeName(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CrantennatypeRecord value4(Double value) {
        setAntennatypeBeam(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CrantennatypeRecord value5(Double value) {
        setAntennatypeCoverage(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CrantennatypeRecord values(Integer value1, String value2, String value3, Double value4, Double value5) {
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
     * Create a detached CrantennatypeRecord
     */
    public CrantennatypeRecord() {
        super(Crantennatype.CRANTENNATYPE);
    }

    /**
     * Create a detached, initialised CrantennatypeRecord
     */
    public CrantennatypeRecord(Integer antennatypeId, String antennatypeCode, String antennatypeName, Double antennatypeBeam, Double antennatypeCoverage) {
        super(Crantennatype.CRANTENNATYPE);

        set(0, antennatypeId);
        set(1, antennatypeCode);
        set(2, antennatypeName);
        set(3, antennatypeBeam);
        set(4, antennatypeCoverage);
    }
}

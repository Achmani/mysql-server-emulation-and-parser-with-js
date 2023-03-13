/*
 * This file is generated by jOOQ.
*/
package id.mit.chrono.server.model.tables.records;


import id.mit.chrono.server.model.tables.Crsummaryarea;

import javax.annotation.Generated;

import org.jooq.Record1;
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
public class CrsummaryareaRecord extends UpdatableRecordImpl<CrsummaryareaRecord> {

    private static final long serialVersionUID = 741541442;

    /**
     * Setter for <code>chrono.crsummaryarea.summaryarea_id</code>.
     */
    public void setSummaryareaId(ULong value) {
        set(0, value);
    }

    /**
     * Getter for <code>chrono.crsummaryarea.summaryarea_id</code>.
     */
    public ULong getSummaryareaId() {
        return (ULong) get(0);
    }

    /**
     * Setter for <code>chrono.crsummaryarea.summaryarea_date</code>.
     */
    public void setSummaryareaDate(UInteger value) {
        set(1, value);
    }

    /**
     * Getter for <code>chrono.crsummaryarea.summaryarea_date</code>.
     */
    public UInteger getSummaryareaDate() {
        return (UInteger) get(1);
    }

    /**
     * Setter for <code>chrono.crsummaryarea.summaryarea_updated</code>.
     */
    public void setSummaryareaUpdated(UInteger value) {
        set(2, value);
    }

    /**
     * Getter for <code>chrono.crsummaryarea.summaryarea_updated</code>.
     */
    public UInteger getSummaryareaUpdated() {
        return (UInteger) get(2);
    }

    /**
     * Setter for <code>chrono.crsummaryarea.summaryarea_areaname</code>.
     */
    public void setSummaryareaAreaname(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>chrono.crsummaryarea.summaryarea_areaname</code>.
     */
    public String getSummaryareaAreaname() {
        return (String) get(3);
    }

    /**
     * Setter for <code>chrono.crsummaryarea.bts2gcount</code>.
     */
    public void setBts2gcount(Integer value) {
        set(4, value);
    }

    /**
     * Getter for <code>chrono.crsummaryarea.bts2gcount</code>.
     */
    public Integer getBts2gcount() {
        return (Integer) get(4);
    }

    /**
     * Setter for <code>chrono.crsummaryarea.bts3gcount</code>.
     */
    public void setBts3gcount(Integer value) {
        set(5, value);
    }

    /**
     * Getter for <code>chrono.crsummaryarea.bts3gcount</code>.
     */
    public Integer getBts3gcount() {
        return (Integer) get(5);
    }

    /**
     * Setter for <code>chrono.crsummaryarea.bts4gcount</code>.
     */
    public void setBts4gcount(Integer value) {
        set(6, value);
    }

    /**
     * Getter for <code>chrono.crsummaryarea.bts4gcount</code>.
     */
    public Integer getBts4gcount() {
        return (Integer) get(6);
    }

    /**
     * Setter for <code>chrono.crsummaryarea.cell2gcount</code>.
     */
    public void setCell2gcount(Integer value) {
        set(7, value);
    }

    /**
     * Getter for <code>chrono.crsummaryarea.cell2gcount</code>.
     */
    public Integer getCell2gcount() {
        return (Integer) get(7);
    }

    /**
     * Setter for <code>chrono.crsummaryarea.cell3gcount</code>.
     */
    public void setCell3gcount(Integer value) {
        set(8, value);
    }

    /**
     * Getter for <code>chrono.crsummaryarea.cell3gcount</code>.
     */
    public Integer getCell3gcount() {
        return (Integer) get(8);
    }

    /**
     * Setter for <code>chrono.crsummaryarea.cell4gcount</code>.
     */
    public void setCell4gcount(Integer value) {
        set(9, value);
    }

    /**
     * Getter for <code>chrono.crsummaryarea.cell4gcount</code>.
     */
    public Integer getCell4gcount() {
        return (Integer) get(9);
    }

    /**
     * Setter for <code>chrono.crsummaryarea.GSM900_count</code>.
     */
    public void setGsm900Count(Integer value) {
        set(10, value);
    }

    /**
     * Getter for <code>chrono.crsummaryarea.GSM900_count</code>.
     */
    public Integer getGsm900Count() {
        return (Integer) get(10);
    }

    /**
     * Setter for <code>chrono.crsummaryarea.DCS1800_count</code>.
     */
    public void setDcs1800Count(Integer value) {
        set(11, value);
    }

    /**
     * Getter for <code>chrono.crsummaryarea.DCS1800_count</code>.
     */
    public Integer getDcs1800Count() {
        return (Integer) get(11);
    }

    /**
     * Setter for <code>chrono.crsummaryarea.GSM1800_count</code>.
     */
    public void setGsm1800Count(Integer value) {
        set(12, value);
    }

    /**
     * Getter for <code>chrono.crsummaryarea.GSM1800_count</code>.
     */
    public Integer getGsm1800Count() {
        return (Integer) get(12);
    }

    /**
     * Setter for <code>chrono.crsummaryarea.UMTS800_count</code>.
     */
    public void setUmts800Count(Integer value) {
        set(13, value);
    }

    /**
     * Getter for <code>chrono.crsummaryarea.UMTS800_count</code>.
     */
    public Integer getUmts800Count() {
        return (Integer) get(13);
    }

    /**
     * Setter for <code>chrono.crsummaryarea.UMTS850_count</code>.
     */
    public void setUmts850Count(Integer value) {
        set(14, value);
    }

    /**
     * Getter for <code>chrono.crsummaryarea.UMTS850_count</code>.
     */
    public Integer getUmts850Count() {
        return (Integer) get(14);
    }

    /**
     * Setter for <code>chrono.crsummaryarea.UMTS900_count</code>.
     */
    public void setUmts900Count(Integer value) {
        set(15, value);
    }

    /**
     * Getter for <code>chrono.crsummaryarea.UMTS900_count</code>.
     */
    public Integer getUmts900Count() {
        return (Integer) get(15);
    }

    /**
     * Setter for <code>chrono.crsummaryarea.UMTS1800_count</code>.
     */
    public void setUmts1800Count(Integer value) {
        set(16, value);
    }

    /**
     * Getter for <code>chrono.crsummaryarea.UMTS1800_count</code>.
     */
    public Integer getUmts1800Count() {
        return (Integer) get(16);
    }

    /**
     * Setter for <code>chrono.crsummaryarea.UMTS1900_count</code>.
     */
    public void setUmts1900Count(Integer value) {
        set(17, value);
    }

    /**
     * Getter for <code>chrono.crsummaryarea.UMTS1900_count</code>.
     */
    public Integer getUmts1900Count() {
        return (Integer) get(17);
    }

    /**
     * Setter for <code>chrono.crsummaryarea.UMTS2100_count</code>.
     */
    public void setUmts2100Count(Integer value) {
        set(18, value);
    }

    /**
     * Getter for <code>chrono.crsummaryarea.UMTS2100_count</code>.
     */
    public Integer getUmts2100Count() {
        return (Integer) get(18);
    }

    /**
     * Setter for <code>chrono.crsummaryarea.UMTS2600_count</code>.
     */
    public void setUmts2600Count(Integer value) {
        set(19, value);
    }

    /**
     * Getter for <code>chrono.crsummaryarea.UMTS2600_count</code>.
     */
    public Integer getUmts2600Count() {
        return (Integer) get(19);
    }

    /**
     * Setter for <code>chrono.crsummaryarea.UMTS1700_count</code>.
     */
    public void setUmts1700Count(Integer value) {
        set(20, value);
    }

    /**
     * Getter for <code>chrono.crsummaryarea.UMTS1700_count</code>.
     */
    public Integer getUmts1700Count() {
        return (Integer) get(20);
    }

    /**
     * Setter for <code>chrono.crsummaryarea.UMTS1500_count</code>.
     */
    public void setUmts1500Count(Integer value) {
        set(21, value);
    }

    /**
     * Getter for <code>chrono.crsummaryarea.UMTS1500_count</code>.
     */
    public Integer getUmts1500Count() {
        return (Integer) get(21);
    }

    /**
     * Setter for <code>chrono.crsummaryarea.LTETDD2300_count</code>.
     */
    public void setLtetdd2300Count(Integer value) {
        set(22, value);
    }

    /**
     * Getter for <code>chrono.crsummaryarea.LTETDD2300_count</code>.
     */
    public Integer getLtetdd2300Count() {
        return (Integer) get(22);
    }

    /**
     * Setter for <code>chrono.crsummaryarea.LTEFDD900_count</code>.
     */
    public void setLtefdd900Count(Integer value) {
        set(23, value);
    }

    /**
     * Getter for <code>chrono.crsummaryarea.LTEFDD900_count</code>.
     */
    public Integer getLtefdd900Count() {
        return (Integer) get(23);
    }

    /**
     * Setter for <code>chrono.crsummaryarea.LTEFDD1800_count</code>.
     */
    public void setLtefdd1800Count(Integer value) {
        set(24, value);
    }

    /**
     * Getter for <code>chrono.crsummaryarea.LTEFDD1800_count</code>.
     */
    public Integer getLtefdd1800Count() {
        return (Integer) get(24);
    }

    /**
     * Setter for <code>chrono.crsummaryarea.LTEFDD2100_count</code>.
     */
    public void setLtefdd2100Count(Integer value) {
        set(25, value);
    }

    /**
     * Getter for <code>chrono.crsummaryarea.LTEFDD2100_count</code>.
     */
    public Integer getLtefdd2100Count() {
        return (Integer) get(25);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Record1<ULong> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached CrsummaryareaRecord
     */
    public CrsummaryareaRecord() {
        super(Crsummaryarea.CRSUMMARYAREA);
    }

    /**
     * Create a detached, initialised CrsummaryareaRecord
     */
    public CrsummaryareaRecord(ULong summaryareaId, UInteger summaryareaDate, UInteger summaryareaUpdated, String summaryareaAreaname, Integer bts2gcount, Integer bts3gcount, Integer bts4gcount, Integer cell2gcount, Integer cell3gcount, Integer cell4gcount, Integer gsm900Count, Integer dcs1800Count, Integer gsm1800Count, Integer umts800Count, Integer umts850Count, Integer umts900Count, Integer umts1800Count, Integer umts1900Count, Integer umts2100Count, Integer umts2600Count, Integer umts1700Count, Integer umts1500Count, Integer ltetdd2300Count, Integer ltefdd900Count, Integer ltefdd1800Count, Integer ltefdd2100Count) {
        super(Crsummaryarea.CRSUMMARYAREA);

        set(0, summaryareaId);
        set(1, summaryareaDate);
        set(2, summaryareaUpdated);
        set(3, summaryareaAreaname);
        set(4, bts2gcount);
        set(5, bts3gcount);
        set(6, bts4gcount);
        set(7, cell2gcount);
        set(8, cell3gcount);
        set(9, cell4gcount);
        set(10, gsm900Count);
        set(11, dcs1800Count);
        set(12, gsm1800Count);
        set(13, umts800Count);
        set(14, umts850Count);
        set(15, umts900Count);
        set(16, umts1800Count);
        set(17, umts1900Count);
        set(18, umts2100Count);
        set(19, umts2600Count);
        set(20, umts1700Count);
        set(21, umts1500Count);
        set(22, ltetdd2300Count);
        set(23, ltefdd900Count);
        set(24, ltefdd1800Count);
        set(25, ltefdd2100Count);
    }
}

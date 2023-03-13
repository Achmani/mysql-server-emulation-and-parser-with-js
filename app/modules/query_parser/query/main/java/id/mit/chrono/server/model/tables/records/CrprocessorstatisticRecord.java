/*
 * This file is generated by jOOQ.
*/
package id.mit.chrono.server.model.tables.records;


import id.mit.chrono.server.model.tables.Crprocessorstatistic;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record16;
import org.jooq.Record2;
import org.jooq.Row16;
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
public class CrprocessorstatisticRecord extends UpdatableRecordImpl<CrprocessorstatisticRecord> implements Record16<Long, Integer, Integer, Integer, Long, Integer, String, String, String, Integer, Integer, Integer, Integer, Integer, Integer, Integer> {

    private static final long serialVersionUID = -571746019;

    /**
     * Setter for <code>chrono.crprocessorstatistic.processorstatistic_id</code>.
     */
    public void setProcessorstatisticId(Long value) {
        set(0, value);
    }

    /**
     * Getter for <code>chrono.crprocessorstatistic.processorstatistic_id</code>.
     */
    public Long getProcessorstatisticId() {
        return (Long) get(0);
    }

    /**
     * Setter for <code>chrono.crprocessorstatistic.processorstatistic_date</code>.
     */
    public void setProcessorstatisticDate(Integer value) {
        set(1, value);
    }

    /**
     * Getter for <code>chrono.crprocessorstatistic.processorstatistic_date</code>.
     */
    public Integer getProcessorstatisticDate() {
        return (Integer) get(1);
    }

    /**
     * Setter for <code>chrono.crprocessorstatistic.processorstatistic_collectortask</code>.
     */
    public void setProcessorstatisticCollectortask(Integer value) {
        set(2, value);
    }

    /**
     * Getter for <code>chrono.crprocessorstatistic.processorstatistic_collectortask</code>.
     */
    public Integer getProcessorstatisticCollectortask() {
        return (Integer) get(2);
    }

    /**
     * Setter for <code>chrono.crprocessorstatistic.processorstatistic_datagroup</code>.
     */
    public void setProcessorstatisticDatagroup(Integer value) {
        set(3, value);
    }

    /**
     * Getter for <code>chrono.crprocessorstatistic.processorstatistic_datagroup</code>.
     */
    public Integer getProcessorstatisticDatagroup() {
        return (Integer) get(3);
    }

    /**
     * Setter for <code>chrono.crprocessorstatistic.processorstatistic_collectortaskfiles</code>.
     */
    public void setProcessorstatisticCollectortaskfiles(Long value) {
        set(4, value);
    }

    /**
     * Getter for <code>chrono.crprocessorstatistic.processorstatistic_collectortaskfiles</code>.
     */
    public Long getProcessorstatisticCollectortaskfiles() {
        return (Long) get(4);
    }

    /**
     * Setter for <code>chrono.crprocessorstatistic.processorstatistic_time</code>.
     */
    public void setProcessorstatisticTime(Integer value) {
        set(5, value);
    }

    /**
     * Getter for <code>chrono.crprocessorstatistic.processorstatistic_time</code>.
     */
    public Integer getProcessorstatisticTime() {
        return (Integer) get(5);
    }

    /**
     * Setter for <code>chrono.crprocessorstatistic.processorstatistic_class</code>.
     */
    public void setProcessorstatisticClass(String value) {
        set(6, value);
    }

    /**
     * Getter for <code>chrono.crprocessorstatistic.processorstatistic_class</code>.
     */
    public String getProcessorstatisticClass() {
        return (String) get(6);
    }

    /**
     * Setter for <code>chrono.crprocessorstatistic.processorstatistic_key</code>.
     */
    public void setProcessorstatisticKey(String value) {
        set(7, value);
    }

    /**
     * Getter for <code>chrono.crprocessorstatistic.processorstatistic_key</code>.
     */
    public String getProcessorstatisticKey() {
        return (String) get(7);
    }

    /**
     * Setter for <code>chrono.crprocessorstatistic.processorstatistic_state</code>.
     */
    public void setProcessorstatisticState(String value) {
        set(8, value);
    }

    /**
     * Getter for <code>chrono.crprocessorstatistic.processorstatistic_state</code>.
     */
    public String getProcessorstatisticState() {
        return (String) get(8);
    }

    /**
     * Setter for <code>chrono.crprocessorstatistic.processorstatistic_duration</code>.
     */
    public void setProcessorstatisticDuration(Integer value) {
        set(9, value);
    }

    /**
     * Getter for <code>chrono.crprocessorstatistic.processorstatistic_duration</code>.
     */
    public Integer getProcessorstatisticDuration() {
        return (Integer) get(9);
    }

    /**
     * Setter for <code>chrono.crprocessorstatistic.processorstatistic_totalselect</code>.
     */
    public void setProcessorstatisticTotalselect(Integer value) {
        set(10, value);
    }

    /**
     * Getter for <code>chrono.crprocessorstatistic.processorstatistic_totalselect</code>.
     */
    public Integer getProcessorstatisticTotalselect() {
        return (Integer) get(10);
    }

    /**
     * Setter for <code>chrono.crprocessorstatistic.processorstatistic_avgselecttime</code>.
     */
    public void setProcessorstatisticAvgselecttime(Integer value) {
        set(11, value);
    }

    /**
     * Getter for <code>chrono.crprocessorstatistic.processorstatistic_avgselecttime</code>.
     */
    public Integer getProcessorstatisticAvgselecttime() {
        return (Integer) get(11);
    }

    /**
     * Setter for <code>chrono.crprocessorstatistic.processorstatistic_totalinsert</code>.
     */
    public void setProcessorstatisticTotalinsert(Integer value) {
        set(12, value);
    }

    /**
     * Getter for <code>chrono.crprocessorstatistic.processorstatistic_totalinsert</code>.
     */
    public Integer getProcessorstatisticTotalinsert() {
        return (Integer) get(12);
    }

    /**
     * Setter for <code>chrono.crprocessorstatistic.processorstatistic_avginserttime</code>.
     */
    public void setProcessorstatisticAvginserttime(Integer value) {
        set(13, value);
    }

    /**
     * Getter for <code>chrono.crprocessorstatistic.processorstatistic_avginserttime</code>.
     */
    public Integer getProcessorstatisticAvginserttime() {
        return (Integer) get(13);
    }

    /**
     * Setter for <code>chrono.crprocessorstatistic.processorstatistic_totalupdate</code>.
     */
    public void setProcessorstatisticTotalupdate(Integer value) {
        set(14, value);
    }

    /**
     * Getter for <code>chrono.crprocessorstatistic.processorstatistic_totalupdate</code>.
     */
    public Integer getProcessorstatisticTotalupdate() {
        return (Integer) get(14);
    }

    /**
     * Setter for <code>chrono.crprocessorstatistic.processorstatistic_avgupdatetime</code>.
     */
    public void setProcessorstatisticAvgupdatetime(Integer value) {
        set(15, value);
    }

    /**
     * Getter for <code>chrono.crprocessorstatistic.processorstatistic_avgupdatetime</code>.
     */
    public Integer getProcessorstatisticAvgupdatetime() {
        return (Integer) get(15);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Record2<Integer, Long> key() {
        return (Record2) super.key();
    }

    // -------------------------------------------------------------------------
    // Record16 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row16<Long, Integer, Integer, Integer, Long, Integer, String, String, String, Integer, Integer, Integer, Integer, Integer, Integer, Integer> fieldsRow() {
        return (Row16) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row16<Long, Integer, Integer, Integer, Long, Integer, String, String, String, Integer, Integer, Integer, Integer, Integer, Integer, Integer> valuesRow() {
        return (Row16) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field1() {
        return Crprocessorstatistic.CRPROCESSORSTATISTIC.PROCESSORSTATISTIC_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field2() {
        return Crprocessorstatistic.CRPROCESSORSTATISTIC.PROCESSORSTATISTIC_DATE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field3() {
        return Crprocessorstatistic.CRPROCESSORSTATISTIC.PROCESSORSTATISTIC_COLLECTORTASK;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field4() {
        return Crprocessorstatistic.CRPROCESSORSTATISTIC.PROCESSORSTATISTIC_DATAGROUP;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field5() {
        return Crprocessorstatistic.CRPROCESSORSTATISTIC.PROCESSORSTATISTIC_COLLECTORTASKFILES;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field6() {
        return Crprocessorstatistic.CRPROCESSORSTATISTIC.PROCESSORSTATISTIC_TIME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field7() {
        return Crprocessorstatistic.CRPROCESSORSTATISTIC.PROCESSORSTATISTIC_CLASS;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field8() {
        return Crprocessorstatistic.CRPROCESSORSTATISTIC.PROCESSORSTATISTIC_KEY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field9() {
        return Crprocessorstatistic.CRPROCESSORSTATISTIC.PROCESSORSTATISTIC_STATE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field10() {
        return Crprocessorstatistic.CRPROCESSORSTATISTIC.PROCESSORSTATISTIC_DURATION;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field11() {
        return Crprocessorstatistic.CRPROCESSORSTATISTIC.PROCESSORSTATISTIC_TOTALSELECT;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field12() {
        return Crprocessorstatistic.CRPROCESSORSTATISTIC.PROCESSORSTATISTIC_AVGSELECTTIME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field13() {
        return Crprocessorstatistic.CRPROCESSORSTATISTIC.PROCESSORSTATISTIC_TOTALINSERT;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field14() {
        return Crprocessorstatistic.CRPROCESSORSTATISTIC.PROCESSORSTATISTIC_AVGINSERTTIME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field15() {
        return Crprocessorstatistic.CRPROCESSORSTATISTIC.PROCESSORSTATISTIC_TOTALUPDATE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field16() {
        return Crprocessorstatistic.CRPROCESSORSTATISTIC.PROCESSORSTATISTIC_AVGUPDATETIME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long component1() {
        return getProcessorstatisticId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component2() {
        return getProcessorstatisticDate();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component3() {
        return getProcessorstatisticCollectortask();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component4() {
        return getProcessorstatisticDatagroup();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long component5() {
        return getProcessorstatisticCollectortaskfiles();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component6() {
        return getProcessorstatisticTime();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component7() {
        return getProcessorstatisticClass();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component8() {
        return getProcessorstatisticKey();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component9() {
        return getProcessorstatisticState();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component10() {
        return getProcessorstatisticDuration();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component11() {
        return getProcessorstatisticTotalselect();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component12() {
        return getProcessorstatisticAvgselecttime();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component13() {
        return getProcessorstatisticTotalinsert();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component14() {
        return getProcessorstatisticAvginserttime();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component15() {
        return getProcessorstatisticTotalupdate();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component16() {
        return getProcessorstatisticAvgupdatetime();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long value1() {
        return getProcessorstatisticId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value2() {
        return getProcessorstatisticDate();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value3() {
        return getProcessorstatisticCollectortask();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value4() {
        return getProcessorstatisticDatagroup();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long value5() {
        return getProcessorstatisticCollectortaskfiles();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value6() {
        return getProcessorstatisticTime();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value7() {
        return getProcessorstatisticClass();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value8() {
        return getProcessorstatisticKey();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value9() {
        return getProcessorstatisticState();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value10() {
        return getProcessorstatisticDuration();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value11() {
        return getProcessorstatisticTotalselect();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value12() {
        return getProcessorstatisticAvgselecttime();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value13() {
        return getProcessorstatisticTotalinsert();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value14() {
        return getProcessorstatisticAvginserttime();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value15() {
        return getProcessorstatisticTotalupdate();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value16() {
        return getProcessorstatisticAvgupdatetime();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CrprocessorstatisticRecord value1(Long value) {
        setProcessorstatisticId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CrprocessorstatisticRecord value2(Integer value) {
        setProcessorstatisticDate(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CrprocessorstatisticRecord value3(Integer value) {
        setProcessorstatisticCollectortask(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CrprocessorstatisticRecord value4(Integer value) {
        setProcessorstatisticDatagroup(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CrprocessorstatisticRecord value5(Long value) {
        setProcessorstatisticCollectortaskfiles(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CrprocessorstatisticRecord value6(Integer value) {
        setProcessorstatisticTime(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CrprocessorstatisticRecord value7(String value) {
        setProcessorstatisticClass(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CrprocessorstatisticRecord value8(String value) {
        setProcessorstatisticKey(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CrprocessorstatisticRecord value9(String value) {
        setProcessorstatisticState(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CrprocessorstatisticRecord value10(Integer value) {
        setProcessorstatisticDuration(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CrprocessorstatisticRecord value11(Integer value) {
        setProcessorstatisticTotalselect(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CrprocessorstatisticRecord value12(Integer value) {
        setProcessorstatisticAvgselecttime(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CrprocessorstatisticRecord value13(Integer value) {
        setProcessorstatisticTotalinsert(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CrprocessorstatisticRecord value14(Integer value) {
        setProcessorstatisticAvginserttime(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CrprocessorstatisticRecord value15(Integer value) {
        setProcessorstatisticTotalupdate(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CrprocessorstatisticRecord value16(Integer value) {
        setProcessorstatisticAvgupdatetime(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CrprocessorstatisticRecord values(Long value1, Integer value2, Integer value3, Integer value4, Long value5, Integer value6, String value7, String value8, String value9, Integer value10, Integer value11, Integer value12, Integer value13, Integer value14, Integer value15, Integer value16) {
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
        value15(value15);
        value16(value16);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached CrprocessorstatisticRecord
     */
    public CrprocessorstatisticRecord() {
        super(Crprocessorstatistic.CRPROCESSORSTATISTIC);
    }

    /**
     * Create a detached, initialised CrprocessorstatisticRecord
     */
    public CrprocessorstatisticRecord(Long processorstatisticId, Integer processorstatisticDate, Integer processorstatisticCollectortask, Integer processorstatisticDatagroup, Long processorstatisticCollectortaskfiles, Integer processorstatisticTime, String processorstatisticClass, String processorstatisticKey, String processorstatisticState, Integer processorstatisticDuration, Integer processorstatisticTotalselect, Integer processorstatisticAvgselecttime, Integer processorstatisticTotalinsert, Integer processorstatisticAvginserttime, Integer processorstatisticTotalupdate, Integer processorstatisticAvgupdatetime) {
        super(Crprocessorstatistic.CRPROCESSORSTATISTIC);

        set(0, processorstatisticId);
        set(1, processorstatisticDate);
        set(2, processorstatisticCollectortask);
        set(3, processorstatisticDatagroup);
        set(4, processorstatisticCollectortaskfiles);
        set(5, processorstatisticTime);
        set(6, processorstatisticClass);
        set(7, processorstatisticKey);
        set(8, processorstatisticState);
        set(9, processorstatisticDuration);
        set(10, processorstatisticTotalselect);
        set(11, processorstatisticAvgselecttime);
        set(12, processorstatisticTotalinsert);
        set(13, processorstatisticAvginserttime);
        set(14, processorstatisticTotalupdate);
        set(15, processorstatisticAvgupdatetime);
    }
}
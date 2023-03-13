/*
 * This file is generated by jOOQ.
*/
package id.mit.chrono.server.model.tables.records;


import id.mit.chrono.server.model.tables.Crdataexport;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record11;
import org.jooq.Row11;
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
public class CrdataexportRecord extends UpdatableRecordImpl<CrdataexportRecord> implements Record11<Integer, Integer, Integer, String, String, Integer, Integer, Integer, String, String, Integer> {

    private static final long serialVersionUID = 1158508491;

    /**
     * Setter for <code>chrono.crdataexport.dataexport_id</code>.
     */
    public void setDataexportId(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>chrono.crdataexport.dataexport_id</code>.
     */
    public Integer getDataexportId() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>chrono.crdataexport.dataexport_date</code>.
     */
    public void setDataexportDate(Integer value) {
        set(1, value);
    }

    /**
     * Getter for <code>chrono.crdataexport.dataexport_date</code>.
     */
    public Integer getDataexportDate() {
        return (Integer) get(1);
    }

    /**
     * Setter for <code>chrono.crdataexport.dataexport_dataexporttype</code>.
     */
    public void setDataexportDataexporttype(Integer value) {
        set(2, value);
    }

    /**
     * Getter for <code>chrono.crdataexport.dataexport_dataexporttype</code>.
     */
    public Integer getDataexportDataexporttype() {
        return (Integer) get(2);
    }

    /**
     * Setter for <code>chrono.crdataexport.dataexport_filename</code>.
     */
    public void setDataexportFilename(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>chrono.crdataexport.dataexport_filename</code>.
     */
    public String getDataexportFilename() {
        return (String) get(3);
    }

    /**
     * Setter for <code>chrono.crdataexport.dataexport_path</code>.
     */
    public void setDataexportPath(String value) {
        set(4, value);
    }

    /**
     * Getter for <code>chrono.crdataexport.dataexport_path</code>.
     */
    public String getDataexportPath() {
        return (String) get(4);
    }

    /**
     * Setter for <code>chrono.crdataexport.dataexport_size</code>.
     */
    public void setDataexportSize(Integer value) {
        set(5, value);
    }

    /**
     * Getter for <code>chrono.crdataexport.dataexport_size</code>.
     */
    public Integer getDataexportSize() {
        return (Integer) get(5);
    }

    /**
     * Setter for <code>chrono.crdataexport.dataexport_totaldata</code>.
     */
    public void setDataexportTotaldata(Integer value) {
        set(6, value);
    }

    /**
     * Getter for <code>chrono.crdataexport.dataexport_totaldata</code>.
     */
    public Integer getDataexportTotaldata() {
        return (Integer) get(6);
    }

    /**
     * Setter for <code>chrono.crdataexport.dataexport_lastupdate</code>.
     */
    public void setDataexportLastupdate(Integer value) {
        set(7, value);
    }

    /**
     * Getter for <code>chrono.crdataexport.dataexport_lastupdate</code>.
     */
    public Integer getDataexportLastupdate() {
        return (Integer) get(7);
    }

    /**
     * Setter for <code>chrono.crdataexport.dataexport_extension</code>.
     */
    public void setDataexportExtension(String value) {
        set(8, value);
    }

    /**
     * Getter for <code>chrono.crdataexport.dataexport_extension</code>.
     */
    public String getDataexportExtension() {
        return (String) get(8);
    }

    /**
     * Setter for <code>chrono.crdataexport.dataexport_checksum</code>.
     */
    public void setDataexportChecksum(String value) {
        set(9, value);
    }

    /**
     * Getter for <code>chrono.crdataexport.dataexport_checksum</code>.
     */
    public String getDataexportChecksum() {
        return (String) get(9);
    }

    /**
     * Setter for <code>chrono.crdataexport.dataexport_totaldownload</code>.
     */
    public void setDataexportTotaldownload(Integer value) {
        set(10, value);
    }

    /**
     * Getter for <code>chrono.crdataexport.dataexport_totaldownload</code>.
     */
    public Integer getDataexportTotaldownload() {
        return (Integer) get(10);
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
    // Record11 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row11<Integer, Integer, Integer, String, String, Integer, Integer, Integer, String, String, Integer> fieldsRow() {
        return (Row11) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row11<Integer, Integer, Integer, String, String, Integer, Integer, Integer, String, String, Integer> valuesRow() {
        return (Row11) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field1() {
        return Crdataexport.CRDATAEXPORT.DATAEXPORT_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field2() {
        return Crdataexport.CRDATAEXPORT.DATAEXPORT_DATE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field3() {
        return Crdataexport.CRDATAEXPORT.DATAEXPORT_DATAEXPORTTYPE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field4() {
        return Crdataexport.CRDATAEXPORT.DATAEXPORT_FILENAME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field5() {
        return Crdataexport.CRDATAEXPORT.DATAEXPORT_PATH;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field6() {
        return Crdataexport.CRDATAEXPORT.DATAEXPORT_SIZE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field7() {
        return Crdataexport.CRDATAEXPORT.DATAEXPORT_TOTALDATA;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field8() {
        return Crdataexport.CRDATAEXPORT.DATAEXPORT_LASTUPDATE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field9() {
        return Crdataexport.CRDATAEXPORT.DATAEXPORT_EXTENSION;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field10() {
        return Crdataexport.CRDATAEXPORT.DATAEXPORT_CHECKSUM;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field11() {
        return Crdataexport.CRDATAEXPORT.DATAEXPORT_TOTALDOWNLOAD;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component1() {
        return getDataexportId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component2() {
        return getDataexportDate();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component3() {
        return getDataexportDataexporttype();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component4() {
        return getDataexportFilename();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component5() {
        return getDataexportPath();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component6() {
        return getDataexportSize();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component7() {
        return getDataexportTotaldata();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component8() {
        return getDataexportLastupdate();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component9() {
        return getDataexportExtension();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component10() {
        return getDataexportChecksum();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component11() {
        return getDataexportTotaldownload();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value1() {
        return getDataexportId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value2() {
        return getDataexportDate();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value3() {
        return getDataexportDataexporttype();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value4() {
        return getDataexportFilename();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value5() {
        return getDataexportPath();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value6() {
        return getDataexportSize();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value7() {
        return getDataexportTotaldata();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value8() {
        return getDataexportLastupdate();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value9() {
        return getDataexportExtension();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value10() {
        return getDataexportChecksum();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value11() {
        return getDataexportTotaldownload();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CrdataexportRecord value1(Integer value) {
        setDataexportId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CrdataexportRecord value2(Integer value) {
        setDataexportDate(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CrdataexportRecord value3(Integer value) {
        setDataexportDataexporttype(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CrdataexportRecord value4(String value) {
        setDataexportFilename(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CrdataexportRecord value5(String value) {
        setDataexportPath(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CrdataexportRecord value6(Integer value) {
        setDataexportSize(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CrdataexportRecord value7(Integer value) {
        setDataexportTotaldata(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CrdataexportRecord value8(Integer value) {
        setDataexportLastupdate(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CrdataexportRecord value9(String value) {
        setDataexportExtension(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CrdataexportRecord value10(String value) {
        setDataexportChecksum(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CrdataexportRecord value11(Integer value) {
        setDataexportTotaldownload(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CrdataexportRecord values(Integer value1, Integer value2, Integer value3, String value4, String value5, Integer value6, Integer value7, Integer value8, String value9, String value10, Integer value11) {
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
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached CrdataexportRecord
     */
    public CrdataexportRecord() {
        super(Crdataexport.CRDATAEXPORT);
    }

    /**
     * Create a detached, initialised CrdataexportRecord
     */
    public CrdataexportRecord(Integer dataexportId, Integer dataexportDate, Integer dataexportDataexporttype, String dataexportFilename, String dataexportPath, Integer dataexportSize, Integer dataexportTotaldata, Integer dataexportLastupdate, String dataexportExtension, String dataexportChecksum, Integer dataexportTotaldownload) {
        super(Crdataexport.CRDATAEXPORT);

        set(0, dataexportId);
        set(1, dataexportDate);
        set(2, dataexportDataexporttype);
        set(3, dataexportFilename);
        set(4, dataexportPath);
        set(5, dataexportSize);
        set(6, dataexportTotaldata);
        set(7, dataexportLastupdate);
        set(8, dataexportExtension);
        set(9, dataexportChecksum);
        set(10, dataexportTotaldownload);
    }
}

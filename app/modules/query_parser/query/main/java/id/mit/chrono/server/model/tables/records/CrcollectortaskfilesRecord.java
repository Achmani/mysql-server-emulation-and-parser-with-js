/*
 * This file is generated by jOOQ.
*/
package id.mit.chrono.server.model.tables.records;


import id.mit.chrono.server.model.tables.Crcollectortaskfiles;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record17;
import org.jooq.Record2;
import org.jooq.Row17;
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
public class CrcollectortaskfilesRecord extends UpdatableRecordImpl<CrcollectortaskfilesRecord> implements Record17<Long, Integer, Integer, Integer, String, String, String, String, Integer, Integer, Integer, Long, String, String, Integer, Integer, String> {

    private static final long serialVersionUID = -1608653173;

    /**
     * Setter for <code>chrono.crcollectortaskfiles.collectortaskfiles_id</code>.
     */
    public void setCollectortaskfilesId(Long value) {
        set(0, value);
    }

    /**
     * Getter for <code>chrono.crcollectortaskfiles.collectortaskfiles_id</code>.
     */
    public Long getCollectortaskfilesId() {
        return (Long) get(0);
    }

    /**
     * Setter for <code>chrono.crcollectortaskfiles.crcollectortaskfiles_date</code>.
     */
    public void setCrcollectortaskfilesDate(Integer value) {
        set(1, value);
    }

    /**
     * Getter for <code>chrono.crcollectortaskfiles.crcollectortaskfiles_date</code>.
     */
    public Integer getCrcollectortaskfilesDate() {
        return (Integer) get(1);
    }

    /**
     * Setter for <code>chrono.crcollectortaskfiles.collectortaskfiles_collectortask</code>.
     */
    public void setCollectortaskfilesCollectortask(Integer value) {
        set(2, value);
    }

    /**
     * Getter for <code>chrono.crcollectortaskfiles.collectortaskfiles_collectortask</code>.
     */
    public Integer getCollectortaskfilesCollectortask() {
        return (Integer) get(2);
    }

    /**
     * Setter for <code>chrono.crcollectortaskfiles.collectortaskfiles_datasource</code>.
     */
    public void setCollectortaskfilesDatasource(Integer value) {
        set(3, value);
    }

    /**
     * Getter for <code>chrono.crcollectortaskfiles.collectortaskfiles_datasource</code>.
     */
    public Integer getCollectortaskfilesDatasource() {
        return (Integer) get(3);
    }

    /**
     * Setter for <code>chrono.crcollectortaskfiles.collectortaskfiles_remotedir</code>.
     */
    public void setCollectortaskfilesRemotedir(String value) {
        set(4, value);
    }

    /**
     * Getter for <code>chrono.crcollectortaskfiles.collectortaskfiles_remotedir</code>.
     */
    public String getCollectortaskfilesRemotedir() {
        return (String) get(4);
    }

    /**
     * Setter for <code>chrono.crcollectortaskfiles.collectortaskfiles_remotefilename</code>.
     */
    public void setCollectortaskfilesRemotefilename(String value) {
        set(5, value);
    }

    /**
     * Getter for <code>chrono.crcollectortaskfiles.collectortaskfiles_remotefilename</code>.
     */
    public String getCollectortaskfilesRemotefilename() {
        return (String) get(5);
    }

    /**
     * Setter for <code>chrono.crcollectortaskfiles.collectortaskfiles_localdir</code>.
     */
    public void setCollectortaskfilesLocaldir(String value) {
        set(6, value);
    }

    /**
     * Getter for <code>chrono.crcollectortaskfiles.collectortaskfiles_localdir</code>.
     */
    public String getCollectortaskfilesLocaldir() {
        return (String) get(6);
    }

    /**
     * Setter for <code>chrono.crcollectortaskfiles.collectortaskfiles_localfilename</code>.
     */
    public void setCollectortaskfilesLocalfilename(String value) {
        set(7, value);
    }

    /**
     * Getter for <code>chrono.crcollectortaskfiles.collectortaskfiles_localfilename</code>.
     */
    public String getCollectortaskfilesLocalfilename() {
        return (String) get(7);
    }

    /**
     * Setter for <code>chrono.crcollectortaskfiles.collectortaskfiles_created</code>.
     */
    public void setCollectortaskfilesCreated(Integer value) {
        set(8, value);
    }

    /**
     * Getter for <code>chrono.crcollectortaskfiles.collectortaskfiles_created</code>.
     */
    public Integer getCollectortaskfilesCreated() {
        return (Integer) get(8);
    }

    /**
     * Setter for <code>chrono.crcollectortaskfiles.collectortaskfiles_added</code>.
     */
    public void setCollectortaskfilesAdded(Integer value) {
        set(9, value);
    }

    /**
     * Getter for <code>chrono.crcollectortaskfiles.collectortaskfiles_added</code>.
     */
    public Integer getCollectortaskfilesAdded() {
        return (Integer) get(9);
    }

    /**
     * Setter for <code>chrono.crcollectortaskfiles.collectortaskfiles_modified</code>.
     */
    public void setCollectortaskfilesModified(Integer value) {
        set(10, value);
    }

    /**
     * Getter for <code>chrono.crcollectortaskfiles.collectortaskfiles_modified</code>.
     */
    public Integer getCollectortaskfilesModified() {
        return (Integer) get(10);
    }

    /**
     * Setter for <code>chrono.crcollectortaskfiles.collectortaskfiles_size</code>.
     */
    public void setCollectortaskfilesSize(Long value) {
        set(11, value);
    }

    /**
     * Getter for <code>chrono.crcollectortaskfiles.collectortaskfiles_size</code>.
     */
    public Long getCollectortaskfilesSize() {
        return (Long) get(11);
    }

    /**
     * Setter for <code>chrono.crcollectortaskfiles.collectortaskfiles_type</code>.
     */
    public void setCollectortaskfilesType(String value) {
        set(12, value);
    }

    /**
     * Getter for <code>chrono.crcollectortaskfiles.collectortaskfiles_type</code>.
     */
    public String getCollectortaskfilesType() {
        return (String) get(12);
    }

    /**
     * Setter for <code>chrono.crcollectortaskfiles.collectortaskfiles_checksum</code>.
     */
    public void setCollectortaskfilesChecksum(String value) {
        set(13, value);
    }

    /**
     * Getter for <code>chrono.crcollectortaskfiles.collectortaskfiles_checksum</code>.
     */
    public String getCollectortaskfilesChecksum() {
        return (String) get(13);
    }

    /**
     * Setter for <code>chrono.crcollectortaskfiles.collectortaskfiles_processtime</code>.
     */
    public void setCollectortaskfilesProcesstime(Integer value) {
        set(14, value);
    }

    /**
     * Getter for <code>chrono.crcollectortaskfiles.collectortaskfiles_processtime</code>.
     */
    public Integer getCollectortaskfilesProcesstime() {
        return (Integer) get(14);
    }

    /**
     * Setter for <code>chrono.crcollectortaskfiles.collectortaskfiles_processstatus</code>.
     */
    public void setCollectortaskfilesProcessstatus(Integer value) {
        set(15, value);
    }

    /**
     * Getter for <code>chrono.crcollectortaskfiles.collectortaskfiles_processstatus</code>.
     */
    public Integer getCollectortaskfilesProcessstatus() {
        return (Integer) get(15);
    }

    /**
     * Setter for <code>chrono.crcollectortaskfiles.collectortaskfiles_processstatusreason</code>.
     */
    public void setCollectortaskfilesProcessstatusreason(String value) {
        set(16, value);
    }

    /**
     * Getter for <code>chrono.crcollectortaskfiles.collectortaskfiles_processstatusreason</code>.
     */
    public String getCollectortaskfilesProcessstatusreason() {
        return (String) get(16);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Record2<Long, Integer> key() {
        return (Record2) super.key();
    }

    // -------------------------------------------------------------------------
    // Record17 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row17<Long, Integer, Integer, Integer, String, String, String, String, Integer, Integer, Integer, Long, String, String, Integer, Integer, String> fieldsRow() {
        return (Row17) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row17<Long, Integer, Integer, Integer, String, String, String, String, Integer, Integer, Integer, Long, String, String, Integer, Integer, String> valuesRow() {
        return (Row17) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field1() {
        return Crcollectortaskfiles.CRCOLLECTORTASKFILES.COLLECTORTASKFILES_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field2() {
        return Crcollectortaskfiles.CRCOLLECTORTASKFILES.CRCOLLECTORTASKFILES_DATE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field3() {
        return Crcollectortaskfiles.CRCOLLECTORTASKFILES.COLLECTORTASKFILES_COLLECTORTASK;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field4() {
        return Crcollectortaskfiles.CRCOLLECTORTASKFILES.COLLECTORTASKFILES_DATASOURCE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field5() {
        return Crcollectortaskfiles.CRCOLLECTORTASKFILES.COLLECTORTASKFILES_REMOTEDIR;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field6() {
        return Crcollectortaskfiles.CRCOLLECTORTASKFILES.COLLECTORTASKFILES_REMOTEFILENAME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field7() {
        return Crcollectortaskfiles.CRCOLLECTORTASKFILES.COLLECTORTASKFILES_LOCALDIR;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field8() {
        return Crcollectortaskfiles.CRCOLLECTORTASKFILES.COLLECTORTASKFILES_LOCALFILENAME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field9() {
        return Crcollectortaskfiles.CRCOLLECTORTASKFILES.COLLECTORTASKFILES_CREATED;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field10() {
        return Crcollectortaskfiles.CRCOLLECTORTASKFILES.COLLECTORTASKFILES_ADDED;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field11() {
        return Crcollectortaskfiles.CRCOLLECTORTASKFILES.COLLECTORTASKFILES_MODIFIED;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field12() {
        return Crcollectortaskfiles.CRCOLLECTORTASKFILES.COLLECTORTASKFILES_SIZE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field13() {
        return Crcollectortaskfiles.CRCOLLECTORTASKFILES.COLLECTORTASKFILES_TYPE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field14() {
        return Crcollectortaskfiles.CRCOLLECTORTASKFILES.COLLECTORTASKFILES_CHECKSUM;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field15() {
        return Crcollectortaskfiles.CRCOLLECTORTASKFILES.COLLECTORTASKFILES_PROCESSTIME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field16() {
        return Crcollectortaskfiles.CRCOLLECTORTASKFILES.COLLECTORTASKFILES_PROCESSSTATUS;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field17() {
        return Crcollectortaskfiles.CRCOLLECTORTASKFILES.COLLECTORTASKFILES_PROCESSSTATUSREASON;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long component1() {
        return getCollectortaskfilesId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component2() {
        return getCrcollectortaskfilesDate();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component3() {
        return getCollectortaskfilesCollectortask();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component4() {
        return getCollectortaskfilesDatasource();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component5() {
        return getCollectortaskfilesRemotedir();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component6() {
        return getCollectortaskfilesRemotefilename();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component7() {
        return getCollectortaskfilesLocaldir();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component8() {
        return getCollectortaskfilesLocalfilename();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component9() {
        return getCollectortaskfilesCreated();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component10() {
        return getCollectortaskfilesAdded();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component11() {
        return getCollectortaskfilesModified();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long component12() {
        return getCollectortaskfilesSize();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component13() {
        return getCollectortaskfilesType();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component14() {
        return getCollectortaskfilesChecksum();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component15() {
        return getCollectortaskfilesProcesstime();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component16() {
        return getCollectortaskfilesProcessstatus();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component17() {
        return getCollectortaskfilesProcessstatusreason();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long value1() {
        return getCollectortaskfilesId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value2() {
        return getCrcollectortaskfilesDate();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value3() {
        return getCollectortaskfilesCollectortask();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value4() {
        return getCollectortaskfilesDatasource();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value5() {
        return getCollectortaskfilesRemotedir();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value6() {
        return getCollectortaskfilesRemotefilename();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value7() {
        return getCollectortaskfilesLocaldir();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value8() {
        return getCollectortaskfilesLocalfilename();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value9() {
        return getCollectortaskfilesCreated();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value10() {
        return getCollectortaskfilesAdded();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value11() {
        return getCollectortaskfilesModified();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long value12() {
        return getCollectortaskfilesSize();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value13() {
        return getCollectortaskfilesType();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value14() {
        return getCollectortaskfilesChecksum();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value15() {
        return getCollectortaskfilesProcesstime();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value16() {
        return getCollectortaskfilesProcessstatus();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value17() {
        return getCollectortaskfilesProcessstatusreason();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CrcollectortaskfilesRecord value1(Long value) {
        setCollectortaskfilesId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CrcollectortaskfilesRecord value2(Integer value) {
        setCrcollectortaskfilesDate(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CrcollectortaskfilesRecord value3(Integer value) {
        setCollectortaskfilesCollectortask(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CrcollectortaskfilesRecord value4(Integer value) {
        setCollectortaskfilesDatasource(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CrcollectortaskfilesRecord value5(String value) {
        setCollectortaskfilesRemotedir(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CrcollectortaskfilesRecord value6(String value) {
        setCollectortaskfilesRemotefilename(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CrcollectortaskfilesRecord value7(String value) {
        setCollectortaskfilesLocaldir(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CrcollectortaskfilesRecord value8(String value) {
        setCollectortaskfilesLocalfilename(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CrcollectortaskfilesRecord value9(Integer value) {
        setCollectortaskfilesCreated(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CrcollectortaskfilesRecord value10(Integer value) {
        setCollectortaskfilesAdded(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CrcollectortaskfilesRecord value11(Integer value) {
        setCollectortaskfilesModified(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CrcollectortaskfilesRecord value12(Long value) {
        setCollectortaskfilesSize(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CrcollectortaskfilesRecord value13(String value) {
        setCollectortaskfilesType(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CrcollectortaskfilesRecord value14(String value) {
        setCollectortaskfilesChecksum(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CrcollectortaskfilesRecord value15(Integer value) {
        setCollectortaskfilesProcesstime(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CrcollectortaskfilesRecord value16(Integer value) {
        setCollectortaskfilesProcessstatus(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CrcollectortaskfilesRecord value17(String value) {
        setCollectortaskfilesProcessstatusreason(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CrcollectortaskfilesRecord values(Long value1, Integer value2, Integer value3, Integer value4, String value5, String value6, String value7, String value8, Integer value9, Integer value10, Integer value11, Long value12, String value13, String value14, Integer value15, Integer value16, String value17) {
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
        value17(value17);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached CrcollectortaskfilesRecord
     */
    public CrcollectortaskfilesRecord() {
        super(Crcollectortaskfiles.CRCOLLECTORTASKFILES);
    }

    /**
     * Create a detached, initialised CrcollectortaskfilesRecord
     */
    public CrcollectortaskfilesRecord(Long collectortaskfilesId, Integer crcollectortaskfilesDate, Integer collectortaskfilesCollectortask, Integer collectortaskfilesDatasource, String collectortaskfilesRemotedir, String collectortaskfilesRemotefilename, String collectortaskfilesLocaldir, String collectortaskfilesLocalfilename, Integer collectortaskfilesCreated, Integer collectortaskfilesAdded, Integer collectortaskfilesModified, Long collectortaskfilesSize, String collectortaskfilesType, String collectortaskfilesChecksum, Integer collectortaskfilesProcesstime, Integer collectortaskfilesProcessstatus, String collectortaskfilesProcessstatusreason) {
        super(Crcollectortaskfiles.CRCOLLECTORTASKFILES);

        set(0, collectortaskfilesId);
        set(1, crcollectortaskfilesDate);
        set(2, collectortaskfilesCollectortask);
        set(3, collectortaskfilesDatasource);
        set(4, collectortaskfilesRemotedir);
        set(5, collectortaskfilesRemotefilename);
        set(6, collectortaskfilesLocaldir);
        set(7, collectortaskfilesLocalfilename);
        set(8, collectortaskfilesCreated);
        set(9, collectortaskfilesAdded);
        set(10, collectortaskfilesModified);
        set(11, collectortaskfilesSize);
        set(12, collectortaskfilesType);
        set(13, collectortaskfilesChecksum);
        set(14, collectortaskfilesProcesstime);
        set(15, collectortaskfilesProcessstatus);
        set(16, collectortaskfilesProcessstatusreason);
    }
}

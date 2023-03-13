/*
 * This file is generated by jOOQ.
*/
package id.mit.chrono.server.model.tables.records;


import id.mit.chrono.server.model.tables.Crmapfield;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record20;
import org.jooq.Row20;
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
public class CrmapfieldRecord extends UpdatableRecordImpl<CrmapfieldRecord> implements Record20<Integer, String, Integer, String, String, String, Byte, Integer, String, String, String, String, String, String, Byte, String, String, String, Byte, Byte> {

    private static final long serialVersionUID = 988015761;

    /**
     * Setter for <code>chrono.crmapfield.mapfield_id</code>.
     */
    public void setMapfieldId(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>chrono.crmapfield.mapfield_id</code>.
     */
    public Integer getMapfieldId() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>chrono.crmapfield.mapfield_code</code>.
     */
    public void setMapfieldCode(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>chrono.crmapfield.mapfield_code</code>.
     */
    public String getMapfieldCode() {
        return (String) get(1);
    }

    /**
     * Setter for <code>chrono.crmapfield.mapfield_mapentity</code>.
     */
    public void setMapfieldMapentity(Integer value) {
        set(2, value);
    }

    /**
     * Getter for <code>chrono.crmapfield.mapfield_mapentity</code>.
     */
    public Integer getMapfieldMapentity() {
        return (Integer) get(2);
    }

    /**
     * Setter for <code>chrono.crmapfield.mapfield_fieldname</code>.
     */
    public void setMapfieldFieldname(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>chrono.crmapfield.mapfield_fieldname</code>.
     */
    public String getMapfieldFieldname() {
        return (String) get(3);
    }

    /**
     * Setter for <code>chrono.crmapfield.mapfield_label</code>.
     */
    public void setMapfieldLabel(String value) {
        set(4, value);
    }

    /**
     * Getter for <code>chrono.crmapfield.mapfield_label</code>.
     */
    public String getMapfieldLabel() {
        return (String) get(4);
    }

    /**
     * Setter for <code>chrono.crmapfield.mapfield_valuepattern</code>.
     */
    public void setMapfieldValuepattern(String value) {
        set(5, value);
    }

    /**
     * Getter for <code>chrono.crmapfield.mapfield_valuepattern</code>.
     */
    public String getMapfieldValuepattern() {
        return (String) get(5);
    }

    /**
     * Setter for <code>chrono.crmapfield.mapfield_ismandatory</code>.
     */
    public void setMapfieldIsmandatory(Byte value) {
        set(6, value);
    }

    /**
     * Getter for <code>chrono.crmapfield.mapfield_ismandatory</code>.
     */
    public Byte getMapfieldIsmandatory() {
        return (Byte) get(6);
    }

    /**
     * Setter for <code>chrono.crmapfield.mapfield_datasourcetype</code>.
     */
    public void setMapfieldDatasourcetype(Integer value) {
        set(7, value);
    }

    /**
     * Getter for <code>chrono.crmapfield.mapfield_datasourcetype</code>.
     */
    public Integer getMapfieldDatasourcetype() {
        return (Integer) get(7);
    }

    /**
     * Setter for <code>chrono.crmapfield.mapfield_sourcegroup</code>.
     */
    public void setMapfieldSourcegroup(String value) {
        set(8, value);
    }

    /**
     * Getter for <code>chrono.crmapfield.mapfield_sourcegroup</code>.
     */
    public String getMapfieldSourcegroup() {
        return (String) get(8);
    }

    /**
     * Setter for <code>chrono.crmapfield.mapfield_sourceparam</code>.
     */
    public void setMapfieldSourceparam(String value) {
        set(9, value);
    }

    /**
     * Getter for <code>chrono.crmapfield.mapfield_sourceparam</code>.
     */
    public String getMapfieldSourceparam() {
        return (String) get(9);
    }

    /**
     * Setter for <code>chrono.crmapfield.mapfield_sourcegroupbackup</code>.
     */
    public void setMapfieldSourcegroupbackup(String value) {
        set(10, value);
    }

    /**
     * Getter for <code>chrono.crmapfield.mapfield_sourcegroupbackup</code>.
     */
    public String getMapfieldSourcegroupbackup() {
        return (String) get(10);
    }

    /**
     * Setter for <code>chrono.crmapfield.mapfield_sourceparambackup</code>.
     */
    public void setMapfieldSourceparambackup(String value) {
        set(11, value);
    }

    /**
     * Getter for <code>chrono.crmapfield.mapfield_sourceparambackup</code>.
     */
    public String getMapfieldSourceparambackup() {
        return (String) get(11);
    }

    /**
     * Setter for <code>chrono.crmapfield.mapfield_sourcegroupcheck</code>.
     */
    public void setMapfieldSourcegroupcheck(String value) {
        set(12, value);
    }

    /**
     * Getter for <code>chrono.crmapfield.mapfield_sourcegroupcheck</code>.
     */
    public String getMapfieldSourcegroupcheck() {
        return (String) get(12);
    }

    /**
     * Setter for <code>chrono.crmapfield.mapfield_valueifcheckexist</code>.
     */
    public void setMapfieldValueifcheckexist(String value) {
        set(13, value);
    }

    /**
     * Getter for <code>chrono.crmapfield.mapfield_valueifcheckexist</code>.
     */
    public String getMapfieldValueifcheckexist() {
        return (String) get(13);
    }

    /**
     * Setter for <code>chrono.crmapfield.mapfield_iskey</code>.
     */
    public void setMapfieldIskey(Byte value) {
        set(14, value);
    }

    /**
     * Getter for <code>chrono.crmapfield.mapfield_iskey</code>.
     */
    public Byte getMapfieldIskey() {
        return (Byte) get(14);
    }

    /**
     * Setter for <code>chrono.crmapfield.mapfield_defaultvalue</code>.
     */
    public void setMapfieldDefaultvalue(String value) {
        set(15, value);
    }

    /**
     * Getter for <code>chrono.crmapfield.mapfield_defaultvalue</code>.
     */
    public String getMapfieldDefaultvalue() {
        return (String) get(15);
    }

    /**
     * Setter for <code>chrono.crmapfield.mapfield_convertpattern</code>.
     */
    public void setMapfieldConvertpattern(String value) {
        set(16, value);
    }

    /**
     * Getter for <code>chrono.crmapfield.mapfield_convertpattern</code>.
     */
    public String getMapfieldConvertpattern() {
        return (String) get(16);
    }

    /**
     * Setter for <code>chrono.crmapfield.mapfield_convertfunction</code>.
     */
    public void setMapfieldConvertfunction(String value) {
        set(17, value);
    }

    /**
     * Getter for <code>chrono.crmapfield.mapfield_convertfunction</code>.
     */
    public String getMapfieldConvertfunction() {
        return (String) get(17);
    }

    /**
     * Setter for <code>chrono.crmapfield.mapfield_ispublic</code>.
     */
    public void setMapfieldIspublic(Byte value) {
        set(18, value);
    }

    /**
     * Getter for <code>chrono.crmapfield.mapfield_ispublic</code>.
     */
    public Byte getMapfieldIspublic() {
        return (Byte) get(18);
    }

    /**
     * Setter for <code>chrono.crmapfield.mapfield_enabled</code>.
     */
    public void setMapfieldEnabled(Byte value) {
        set(19, value);
    }

    /**
     * Getter for <code>chrono.crmapfield.mapfield_enabled</code>.
     */
    public Byte getMapfieldEnabled() {
        return (Byte) get(19);
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
    // Record20 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row20<Integer, String, Integer, String, String, String, Byte, Integer, String, String, String, String, String, String, Byte, String, String, String, Byte, Byte> fieldsRow() {
        return (Row20) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row20<Integer, String, Integer, String, String, String, Byte, Integer, String, String, String, String, String, String, Byte, String, String, String, Byte, Byte> valuesRow() {
        return (Row20) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field1() {
        return Crmapfield.CRMAPFIELD.MAPFIELD_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field2() {
        return Crmapfield.CRMAPFIELD.MAPFIELD_CODE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field3() {
        return Crmapfield.CRMAPFIELD.MAPFIELD_MAPENTITY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field4() {
        return Crmapfield.CRMAPFIELD.MAPFIELD_FIELDNAME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field5() {
        return Crmapfield.CRMAPFIELD.MAPFIELD_LABEL;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field6() {
        return Crmapfield.CRMAPFIELD.MAPFIELD_VALUEPATTERN;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Byte> field7() {
        return Crmapfield.CRMAPFIELD.MAPFIELD_ISMANDATORY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field8() {
        return Crmapfield.CRMAPFIELD.MAPFIELD_DATASOURCETYPE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field9() {
        return Crmapfield.CRMAPFIELD.MAPFIELD_SOURCEGROUP;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field10() {
        return Crmapfield.CRMAPFIELD.MAPFIELD_SOURCEPARAM;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field11() {
        return Crmapfield.CRMAPFIELD.MAPFIELD_SOURCEGROUPBACKUP;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field12() {
        return Crmapfield.CRMAPFIELD.MAPFIELD_SOURCEPARAMBACKUP;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field13() {
        return Crmapfield.CRMAPFIELD.MAPFIELD_SOURCEGROUPCHECK;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field14() {
        return Crmapfield.CRMAPFIELD.MAPFIELD_VALUEIFCHECKEXIST;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Byte> field15() {
        return Crmapfield.CRMAPFIELD.MAPFIELD_ISKEY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field16() {
        return Crmapfield.CRMAPFIELD.MAPFIELD_DEFAULTVALUE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field17() {
        return Crmapfield.CRMAPFIELD.MAPFIELD_CONVERTPATTERN;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field18() {
        return Crmapfield.CRMAPFIELD.MAPFIELD_CONVERTFUNCTION;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Byte> field19() {
        return Crmapfield.CRMAPFIELD.MAPFIELD_ISPUBLIC;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Byte> field20() {
        return Crmapfield.CRMAPFIELD.MAPFIELD_ENABLED;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component1() {
        return getMapfieldId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component2() {
        return getMapfieldCode();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component3() {
        return getMapfieldMapentity();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component4() {
        return getMapfieldFieldname();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component5() {
        return getMapfieldLabel();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component6() {
        return getMapfieldValuepattern();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Byte component7() {
        return getMapfieldIsmandatory();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component8() {
        return getMapfieldDatasourcetype();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component9() {
        return getMapfieldSourcegroup();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component10() {
        return getMapfieldSourceparam();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component11() {
        return getMapfieldSourcegroupbackup();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component12() {
        return getMapfieldSourceparambackup();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component13() {
        return getMapfieldSourcegroupcheck();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component14() {
        return getMapfieldValueifcheckexist();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Byte component15() {
        return getMapfieldIskey();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component16() {
        return getMapfieldDefaultvalue();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component17() {
        return getMapfieldConvertpattern();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component18() {
        return getMapfieldConvertfunction();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Byte component19() {
        return getMapfieldIspublic();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Byte component20() {
        return getMapfieldEnabled();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value1() {
        return getMapfieldId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value2() {
        return getMapfieldCode();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value3() {
        return getMapfieldMapentity();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value4() {
        return getMapfieldFieldname();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value5() {
        return getMapfieldLabel();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value6() {
        return getMapfieldValuepattern();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Byte value7() {
        return getMapfieldIsmandatory();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value8() {
        return getMapfieldDatasourcetype();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value9() {
        return getMapfieldSourcegroup();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value10() {
        return getMapfieldSourceparam();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value11() {
        return getMapfieldSourcegroupbackup();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value12() {
        return getMapfieldSourceparambackup();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value13() {
        return getMapfieldSourcegroupcheck();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value14() {
        return getMapfieldValueifcheckexist();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Byte value15() {
        return getMapfieldIskey();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value16() {
        return getMapfieldDefaultvalue();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value17() {
        return getMapfieldConvertpattern();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value18() {
        return getMapfieldConvertfunction();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Byte value19() {
        return getMapfieldIspublic();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Byte value20() {
        return getMapfieldEnabled();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CrmapfieldRecord value1(Integer value) {
        setMapfieldId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CrmapfieldRecord value2(String value) {
        setMapfieldCode(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CrmapfieldRecord value3(Integer value) {
        setMapfieldMapentity(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CrmapfieldRecord value4(String value) {
        setMapfieldFieldname(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CrmapfieldRecord value5(String value) {
        setMapfieldLabel(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CrmapfieldRecord value6(String value) {
        setMapfieldValuepattern(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CrmapfieldRecord value7(Byte value) {
        setMapfieldIsmandatory(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CrmapfieldRecord value8(Integer value) {
        setMapfieldDatasourcetype(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CrmapfieldRecord value9(String value) {
        setMapfieldSourcegroup(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CrmapfieldRecord value10(String value) {
        setMapfieldSourceparam(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CrmapfieldRecord value11(String value) {
        setMapfieldSourcegroupbackup(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CrmapfieldRecord value12(String value) {
        setMapfieldSourceparambackup(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CrmapfieldRecord value13(String value) {
        setMapfieldSourcegroupcheck(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CrmapfieldRecord value14(String value) {
        setMapfieldValueifcheckexist(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CrmapfieldRecord value15(Byte value) {
        setMapfieldIskey(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CrmapfieldRecord value16(String value) {
        setMapfieldDefaultvalue(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CrmapfieldRecord value17(String value) {
        setMapfieldConvertpattern(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CrmapfieldRecord value18(String value) {
        setMapfieldConvertfunction(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CrmapfieldRecord value19(Byte value) {
        setMapfieldIspublic(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CrmapfieldRecord value20(Byte value) {
        setMapfieldEnabled(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CrmapfieldRecord values(Integer value1, String value2, Integer value3, String value4, String value5, String value6, Byte value7, Integer value8, String value9, String value10, String value11, String value12, String value13, String value14, Byte value15, String value16, String value17, String value18, Byte value19, Byte value20) {
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
        value18(value18);
        value19(value19);
        value20(value20);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached CrmapfieldRecord
     */
    public CrmapfieldRecord() {
        super(Crmapfield.CRMAPFIELD);
    }

    /**
     * Create a detached, initialised CrmapfieldRecord
     */
    public CrmapfieldRecord(Integer mapfieldId, String mapfieldCode, Integer mapfieldMapentity, String mapfieldFieldname, String mapfieldLabel, String mapfieldValuepattern, Byte mapfieldIsmandatory, Integer mapfieldDatasourcetype, String mapfieldSourcegroup, String mapfieldSourceparam, String mapfieldSourcegroupbackup, String mapfieldSourceparambackup, String mapfieldSourcegroupcheck, String mapfieldValueifcheckexist, Byte mapfieldIskey, String mapfieldDefaultvalue, String mapfieldConvertpattern, String mapfieldConvertfunction, Byte mapfieldIspublic, Byte mapfieldEnabled) {
        super(Crmapfield.CRMAPFIELD);

        set(0, mapfieldId);
        set(1, mapfieldCode);
        set(2, mapfieldMapentity);
        set(3, mapfieldFieldname);
        set(4, mapfieldLabel);
        set(5, mapfieldValuepattern);
        set(6, mapfieldIsmandatory);
        set(7, mapfieldDatasourcetype);
        set(8, mapfieldSourcegroup);
        set(9, mapfieldSourceparam);
        set(10, mapfieldSourcegroupbackup);
        set(11, mapfieldSourceparambackup);
        set(12, mapfieldSourcegroupcheck);
        set(13, mapfieldValueifcheckexist);
        set(14, mapfieldIskey);
        set(15, mapfieldDefaultvalue);
        set(16, mapfieldConvertpattern);
        set(17, mapfieldConvertfunction);
        set(18, mapfieldIspublic);
        set(19, mapfieldEnabled);
    }
}
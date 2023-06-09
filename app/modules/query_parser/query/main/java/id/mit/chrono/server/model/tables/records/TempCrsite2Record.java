/*
 * This file is generated by jOOQ.
*/
package id.mit.chrono.server.model.tables.records;


import id.mit.chrono.server.model.tables.TempCrsite2;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record18;
import org.jooq.Row18;
import org.jooq.impl.TableRecordImpl;


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
public class TempCrsite2Record extends TableRecordImpl<TempCrsite2Record> implements Record18<String, Integer, String, String, String, String, String, String, String, String, String, String, String, String, String, Integer, Integer, Integer> {

    private static final long serialVersionUID = -1397246217;

    /**
     * Setter for <code>chrono.temp_crsite2.regional</code>.
     */
    public void setRegional(String value) {
        set(0, value);
    }

    /**
     * Getter for <code>chrono.temp_crsite2.regional</code>.
     */
    public String getRegional() {
        return (String) get(0);
    }

    /**
     * Setter for <code>chrono.temp_crsite2.siteareaid</code>.
     */
    public void setSiteareaid(Integer value) {
        set(1, value);
    }

    /**
     * Getter for <code>chrono.temp_crsite2.siteareaid</code>.
     */
    public Integer getSiteareaid() {
        return (Integer) get(1);
    }

    /**
     * Setter for <code>chrono.temp_crsite2.area</code>.
     */
    public void setArea(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>chrono.temp_crsite2.area</code>.
     */
    public String getArea() {
        return (String) get(2);
    }

    /**
     * Setter for <code>chrono.temp_crsite2.siteid</code>.
     */
    public void setSiteid(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>chrono.temp_crsite2.siteid</code>.
     */
    public String getSiteid() {
        return (String) get(3);
    }

    /**
     * Setter for <code>chrono.temp_crsite2.sitename</code>.
     */
    public void setSitename(String value) {
        set(4, value);
    }

    /**
     * Getter for <code>chrono.temp_crsite2.sitename</code>.
     */
    public String getSitename() {
        return (String) get(4);
    }

    /**
     * Setter for <code>chrono.temp_crsite2.nsa</code>.
     */
    public void setNsa(String value) {
        set(5, value);
    }

    /**
     * Getter for <code>chrono.temp_crsite2.nsa</code>.
     */
    public String getNsa() {
        return (String) get(5);
    }

    /**
     * Setter for <code>chrono.temp_crsite2.rtp</code>.
     */
    public void setRtp(String value) {
        set(6, value);
    }

    /**
     * Getter for <code>chrono.temp_crsite2.rtp</code>.
     */
    public String getRtp() {
        return (String) get(6);
    }

    /**
     * Setter for <code>chrono.temp_crsite2.rtpalias</code>.
     */
    public void setRtpalias(String value) {
        set(7, value);
    }

    /**
     * Getter for <code>chrono.temp_crsite2.rtpalias</code>.
     */
    public String getRtpalias() {
        return (String) get(7);
    }

    /**
     * Setter for <code>chrono.temp_crsite2.longitude</code>.
     */
    public void setLongitude(String value) {
        set(8, value);
    }

    /**
     * Getter for <code>chrono.temp_crsite2.longitude</code>.
     */
    public String getLongitude() {
        return (String) get(8);
    }

    /**
     * Setter for <code>chrono.temp_crsite2.latitude</code>.
     */
    public void setLatitude(String value) {
        set(9, value);
    }

    /**
     * Getter for <code>chrono.temp_crsite2.latitude</code>.
     */
    public String getLatitude() {
        return (String) get(9);
    }

    /**
     * Setter for <code>chrono.temp_crsite2.alamat</code>.
     */
    public void setAlamat(String value) {
        set(10, value);
    }

    /**
     * Getter for <code>chrono.temp_crsite2.alamat</code>.
     */
    public String getAlamat() {
        return (String) get(10);
    }

    /**
     * Setter for <code>chrono.temp_crsite2.kelurahan</code>.
     */
    public void setKelurahan(String value) {
        set(11, value);
    }

    /**
     * Getter for <code>chrono.temp_crsite2.kelurahan</code>.
     */
    public String getKelurahan() {
        return (String) get(11);
    }

    /**
     * Setter for <code>chrono.temp_crsite2.kecamatan</code>.
     */
    public void setKecamatan(String value) {
        set(12, value);
    }

    /**
     * Getter for <code>chrono.temp_crsite2.kecamatan</code>.
     */
    public String getKecamatan() {
        return (String) get(12);
    }

    /**
     * Setter for <code>chrono.temp_crsite2.kota</code>.
     */
    public void setKota(String value) {
        set(13, value);
    }

    /**
     * Getter for <code>chrono.temp_crsite2.kota</code>.
     */
    public String getKota() {
        return (String) get(13);
    }

    /**
     * Setter for <code>chrono.temp_crsite2.provinsi</code>.
     */
    public void setProvinsi(String value) {
        set(14, value);
    }

    /**
     * Getter for <code>chrono.temp_crsite2.provinsi</code>.
     */
    public String getProvinsi() {
        return (String) get(14);
    }

    /**
     * Setter for <code>chrono.temp_crsite2.exist</code>.
     */
    public void setExist(Integer value) {
        set(15, value);
    }

    /**
     * Getter for <code>chrono.temp_crsite2.exist</code>.
     */
    public Integer getExist() {
        return (Integer) get(15);
    }

    /**
     * Setter for <code>chrono.temp_crsite2.test</code>.
     */
    public void setTest(Integer value) {
        set(16, value);
    }

    /**
     * Getter for <code>chrono.temp_crsite2.test</code>.
     */
    public Integer getTest() {
        return (Integer) get(16);
    }

    /**
     * Setter for <code>chrono.temp_crsite2.flag</code>.
     */
    public void setFlag(Integer value) {
        set(17, value);
    }

    /**
     * Getter for <code>chrono.temp_crsite2.flag</code>.
     */
    public Integer getFlag() {
        return (Integer) get(17);
    }

    // -------------------------------------------------------------------------
    // Record18 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row18<String, Integer, String, String, String, String, String, String, String, String, String, String, String, String, String, Integer, Integer, Integer> fieldsRow() {
        return (Row18) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row18<String, Integer, String, String, String, String, String, String, String, String, String, String, String, String, String, Integer, Integer, Integer> valuesRow() {
        return (Row18) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field1() {
        return TempCrsite2.TEMP_CRSITE2.REGIONAL;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field2() {
        return TempCrsite2.TEMP_CRSITE2.SITEAREAID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field3() {
        return TempCrsite2.TEMP_CRSITE2.AREA;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field4() {
        return TempCrsite2.TEMP_CRSITE2.SITEID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field5() {
        return TempCrsite2.TEMP_CRSITE2.SITENAME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field6() {
        return TempCrsite2.TEMP_CRSITE2.NSA;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field7() {
        return TempCrsite2.TEMP_CRSITE2.RTP;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field8() {
        return TempCrsite2.TEMP_CRSITE2.RTPALIAS;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field9() {
        return TempCrsite2.TEMP_CRSITE2.LONGITUDE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field10() {
        return TempCrsite2.TEMP_CRSITE2.LATITUDE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field11() {
        return TempCrsite2.TEMP_CRSITE2.ALAMAT;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field12() {
        return TempCrsite2.TEMP_CRSITE2.KELURAHAN;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field13() {
        return TempCrsite2.TEMP_CRSITE2.KECAMATAN;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field14() {
        return TempCrsite2.TEMP_CRSITE2.KOTA;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field15() {
        return TempCrsite2.TEMP_CRSITE2.PROVINSI;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field16() {
        return TempCrsite2.TEMP_CRSITE2.EXIST;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field17() {
        return TempCrsite2.TEMP_CRSITE2.TEST;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field18() {
        return TempCrsite2.TEMP_CRSITE2.FLAG;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component1() {
        return getRegional();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component2() {
        return getSiteareaid();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component3() {
        return getArea();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component4() {
        return getSiteid();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component5() {
        return getSitename();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component6() {
        return getNsa();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component7() {
        return getRtp();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component8() {
        return getRtpalias();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component9() {
        return getLongitude();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component10() {
        return getLatitude();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component11() {
        return getAlamat();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component12() {
        return getKelurahan();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component13() {
        return getKecamatan();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component14() {
        return getKota();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component15() {
        return getProvinsi();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component16() {
        return getExist();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component17() {
        return getTest();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component18() {
        return getFlag();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value1() {
        return getRegional();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value2() {
        return getSiteareaid();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value3() {
        return getArea();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value4() {
        return getSiteid();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value5() {
        return getSitename();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value6() {
        return getNsa();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value7() {
        return getRtp();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value8() {
        return getRtpalias();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value9() {
        return getLongitude();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value10() {
        return getLatitude();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value11() {
        return getAlamat();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value12() {
        return getKelurahan();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value13() {
        return getKecamatan();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value14() {
        return getKota();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value15() {
        return getProvinsi();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value16() {
        return getExist();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value17() {
        return getTest();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value18() {
        return getFlag();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TempCrsite2Record value1(String value) {
        setRegional(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TempCrsite2Record value2(Integer value) {
        setSiteareaid(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TempCrsite2Record value3(String value) {
        setArea(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TempCrsite2Record value4(String value) {
        setSiteid(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TempCrsite2Record value5(String value) {
        setSitename(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TempCrsite2Record value6(String value) {
        setNsa(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TempCrsite2Record value7(String value) {
        setRtp(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TempCrsite2Record value8(String value) {
        setRtpalias(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TempCrsite2Record value9(String value) {
        setLongitude(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TempCrsite2Record value10(String value) {
        setLatitude(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TempCrsite2Record value11(String value) {
        setAlamat(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TempCrsite2Record value12(String value) {
        setKelurahan(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TempCrsite2Record value13(String value) {
        setKecamatan(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TempCrsite2Record value14(String value) {
        setKota(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TempCrsite2Record value15(String value) {
        setProvinsi(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TempCrsite2Record value16(Integer value) {
        setExist(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TempCrsite2Record value17(Integer value) {
        setTest(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TempCrsite2Record value18(Integer value) {
        setFlag(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TempCrsite2Record values(String value1, Integer value2, String value3, String value4, String value5, String value6, String value7, String value8, String value9, String value10, String value11, String value12, String value13, String value14, String value15, Integer value16, Integer value17, Integer value18) {
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
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached TempCrsite2Record
     */
    public TempCrsite2Record() {
        super(TempCrsite2.TEMP_CRSITE2);
    }

    /**
     * Create a detached, initialised TempCrsite2Record
     */
    public TempCrsite2Record(String regional, Integer siteareaid, String area, String siteid, String sitename, String nsa, String rtp, String rtpalias, String longitude, String latitude, String alamat, String kelurahan, String kecamatan, String kota, String provinsi, Integer exist, Integer test, Integer flag) {
        super(TempCrsite2.TEMP_CRSITE2);

        set(0, regional);
        set(1, siteareaid);
        set(2, area);
        set(3, siteid);
        set(4, sitename);
        set(5, nsa);
        set(6, rtp);
        set(7, rtpalias);
        set(8, longitude);
        set(9, latitude);
        set(10, alamat);
        set(11, kelurahan);
        set(12, kecamatan);
        set(13, kota);
        set(14, provinsi);
        set(15, exist);
        set(16, test);
        set(17, flag);
    }
}

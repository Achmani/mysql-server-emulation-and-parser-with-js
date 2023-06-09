/*
 * This file is generated by jOOQ.
*/
package id.mit.chrono.server.model.tables.records;


import id.mit.chrono.server.model.tables.Styloucell;

import javax.annotation.Generated;

import org.jooq.Record2;
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
public class StyloucellRecord extends UpdatableRecordImpl<StyloucellRecord> {

    private static final long serialVersionUID = 2044729352;

    /**
     * Setter for <code>chrono.styloucell.styloucell_id</code>.
     */
    public void setStyloucellId(ULong value) {
        set(0, value);
    }

    /**
     * Getter for <code>chrono.styloucell.styloucell_id</code>.
     */
    public ULong getStyloucellId() {
        return (ULong) get(0);
    }

    /**
     * Setter for <code>chrono.styloucell.styloucell_crcollectortaskfiles</code>.
     */
    public void setStyloucellCrcollectortaskfiles(ULong value) {
        set(1, value);
    }

    /**
     * Getter for <code>chrono.styloucell.styloucell_crcollectortaskfiles</code>.
     */
    public ULong getStyloucellCrcollectortaskfiles() {
        return (ULong) get(1);
    }

    /**
     * Setter for <code>chrono.styloucell.styloucell_date</code>.
     */
    public void setStyloucellDate(UInteger value) {
        set(2, value);
    }

    /**
     * Getter for <code>chrono.styloucell.styloucell_date</code>.
     */
    public UInteger getStyloucellDate() {
        return (UInteger) get(2);
    }

    /**
     * Setter for <code>chrono.styloucell.SOURCE</code>.
     */
    public void setSource(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>chrono.styloucell.SOURCE</code>.
     */
    public String getSource() {
        return (String) get(3);
    }

    /**
     * Setter for <code>chrono.styloucell.REGIONAL</code>.
     */
    public void setRegional(String value) {
        set(4, value);
    }

    /**
     * Getter for <code>chrono.styloucell.REGIONAL</code>.
     */
    public String getRegional() {
        return (String) get(4);
    }

    /**
     * Setter for <code>chrono.styloucell.VENDOR</code>.
     */
    public void setVendor(String value) {
        set(5, value);
    }

    /**
     * Getter for <code>chrono.styloucell.VENDOR</code>.
     */
    public String getVendor() {
        return (String) get(5);
    }

    /**
     * Setter for <code>chrono.styloucell.RNCID_LAC_CI</code>.
     */
    public void setRncidLacCi(String value) {
        set(6, value);
    }

    /**
     * Getter for <code>chrono.styloucell.RNCID_LAC_CI</code>.
     */
    public String getRncidLacCi() {
        return (String) get(6);
    }

    /**
     * Setter for <code>chrono.styloucell.RNC_NAME</code>.
     */
    public void setRncName(String value) {
        set(7, value);
    }

    /**
     * Getter for <code>chrono.styloucell.RNC_NAME</code>.
     */
    public String getRncName() {
        return (String) get(7);
    }

    /**
     * Setter for <code>chrono.styloucell.NODEB_NAME</code>.
     */
    public void setNodebName(String value) {
        set(8, value);
    }

    /**
     * Getter for <code>chrono.styloucell.NODEB_NAME</code>.
     */
    public String getNodebName() {
        return (String) get(8);
    }

    /**
     * Setter for <code>chrono.styloucell.CELL_NAME</code>.
     */
    public void setCellName(String value) {
        set(9, value);
    }

    /**
     * Getter for <code>chrono.styloucell.CELL_NAME</code>.
     */
    public String getCellName() {
        return (String) get(9);
    }

    /**
     * Setter for <code>chrono.styloucell.CELL_NO</code>.
     */
    public void setCellNo(String value) {
        set(10, value);
    }

    /**
     * Getter for <code>chrono.styloucell.CELL_NO</code>.
     */
    public String getCellNo() {
        return (String) get(10);
    }

    /**
     * Setter for <code>chrono.styloucell.NE_ID</code>.
     */
    public void setNeId(String value) {
        set(11, value);
    }

    /**
     * Getter for <code>chrono.styloucell.NE_ID</code>.
     */
    public String getNeId() {
        return (String) get(11);
    }

    /**
     * Setter for <code>chrono.styloucell.SITE_ID</code>.
     */
    public void setSiteId(String value) {
        set(12, value);
    }

    /**
     * Getter for <code>chrono.styloucell.SITE_ID</code>.
     */
    public String getSiteId() {
        return (String) get(12);
    }

    /**
     * Setter for <code>chrono.styloucell.HSDPA</code>.
     */
    public void setHsdpa(String value) {
        set(13, value);
    }

    /**
     * Getter for <code>chrono.styloucell.HSDPA</code>.
     */
    public String getHsdpa() {
        return (String) get(13);
    }

    /**
     * Setter for <code>chrono.styloucell.LAC</code>.
     */
    public void setLac(String value) {
        set(14, value);
    }

    /**
     * Getter for <code>chrono.styloucell.LAC</code>.
     */
    public String getLac() {
        return (String) get(14);
    }

    /**
     * Setter for <code>chrono.styloucell.CI</code>.
     */
    public void setCi(String value) {
        set(15, value);
    }

    /**
     * Getter for <code>chrono.styloucell.CI</code>.
     */
    public String getCi() {
        return (String) get(15);
    }

    /**
     * Setter for <code>chrono.styloucell.SAC</code>.
     */
    public void setSac(String value) {
        set(16, value);
    }

    /**
     * Getter for <code>chrono.styloucell.SAC</code>.
     */
    public String getSac() {
        return (String) get(16);
    }

    /**
     * Setter for <code>chrono.styloucell.PSCCODE</code>.
     */
    public void setPsccode(String value) {
        set(17, value);
    }

    /**
     * Getter for <code>chrono.styloucell.PSCCODE</code>.
     */
    public String getPsccode() {
        return (String) get(17);
    }

    /**
     * Setter for <code>chrono.styloucell.UARFCN</code>.
     */
    public void setUarfcn(String value) {
        set(18, value);
    }

    /**
     * Getter for <code>chrono.styloucell.UARFCN</code>.
     */
    public String getUarfcn() {
        return (String) get(18);
    }

    /**
     * Setter for <code>chrono.styloucell.FREQUENCY_MHZ</code>.
     */
    public void setFrequencyMhz(String value) {
        set(19, value);
    }

    /**
     * Getter for <code>chrono.styloucell.FREQUENCY_MHZ</code>.
     */
    public String getFrequencyMhz() {
        return (String) get(19);
    }

    /**
     * Setter for <code>chrono.styloucell.BANDTYPE</code>.
     */
    public void setBandtype(String value) {
        set(20, value);
    }

    /**
     * Getter for <code>chrono.styloucell.BANDTYPE</code>.
     */
    public String getBandtype() {
        return (String) get(20);
    }

    /**
     * Setter for <code>chrono.styloucell.F1_F2_F3</code>.
     */
    public void setF1F2F3(String value) {
        set(21, value);
    }

    /**
     * Getter for <code>chrono.styloucell.F1_F2_F3</code>.
     */
    public String getF1F2F3() {
        return (String) get(21);
    }

    /**
     * Setter for <code>chrono.styloucell.TYPE_BTS</code>.
     */
    public void setTypeBts(String value) {
        set(22, value);
    }

    /**
     * Getter for <code>chrono.styloucell.TYPE_BTS</code>.
     */
    public String getTypeBts() {
        return (String) get(22);
    }

    /**
     * Setter for <code>chrono.styloucell.NEW_SITE</code>.
     */
    public void setNewSite(String value) {
        set(23, value);
    }

    /**
     * Getter for <code>chrono.styloucell.NEW_SITE</code>.
     */
    public String getNewSite() {
        return (String) get(23);
    }

    /**
     * Setter for <code>chrono.styloucell.LONGITUDE</code>.
     */
    public void setLongitude(String value) {
        set(24, value);
    }

    /**
     * Getter for <code>chrono.styloucell.LONGITUDE</code>.
     */
    public String getLongitude() {
        return (String) get(24);
    }

    /**
     * Setter for <code>chrono.styloucell.LATITUDE</code>.
     */
    public void setLatitude(String value) {
        set(25, value);
    }

    /**
     * Getter for <code>chrono.styloucell.LATITUDE</code>.
     */
    public String getLatitude() {
        return (String) get(25);
    }

    /**
     * Setter for <code>chrono.styloucell.STATUS</code>.
     */
    public void setStatus(String value) {
        set(26, value);
    }

    /**
     * Getter for <code>chrono.styloucell.STATUS</code>.
     */
    public String getStatus() {
        return (String) get(26);
    }

    /**
     * Setter for <code>chrono.styloucell.BTSNUMBER</code>.
     */
    public void setBtsnumber(String value) {
        set(27, value);
    }

    /**
     * Getter for <code>chrono.styloucell.BTSNUMBER</code>.
     */
    public String getBtsnumber() {
        return (String) get(27);
    }

    /**
     * Setter for <code>chrono.styloucell.CELLNUMBER</code>.
     */
    public void setCellnumber(String value) {
        set(28, value);
    }

    /**
     * Getter for <code>chrono.styloucell.CELLNUMBER</code>.
     */
    public String getCellnumber() {
        return (String) get(28);
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
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached StyloucellRecord
     */
    public StyloucellRecord() {
        super(Styloucell.STYLOUCELL);
    }

    /**
     * Create a detached, initialised StyloucellRecord
     */
    public StyloucellRecord(ULong styloucellId, ULong styloucellCrcollectortaskfiles, UInteger styloucellDate, String source, String regional, String vendor, String rncidLacCi, String rncName, String nodebName, String cellName, String cellNo, String neId, String siteId, String hsdpa, String lac, String ci, String sac, String psccode, String uarfcn, String frequencyMhz, String bandtype, String f1F2F3, String typeBts, String newSite, String longitude, String latitude, String status, String btsnumber, String cellnumber) {
        super(Styloucell.STYLOUCELL);

        set(0, styloucellId);
        set(1, styloucellCrcollectortaskfiles);
        set(2, styloucellDate);
        set(3, source);
        set(4, regional);
        set(5, vendor);
        set(6, rncidLacCi);
        set(7, rncName);
        set(8, nodebName);
        set(9, cellName);
        set(10, cellNo);
        set(11, neId);
        set(12, siteId);
        set(13, hsdpa);
        set(14, lac);
        set(15, ci);
        set(16, sac);
        set(17, psccode);
        set(18, uarfcn);
        set(19, frequencyMhz);
        set(20, bandtype);
        set(21, f1F2F3);
        set(22, typeBts);
        set(23, newSite);
        set(24, longitude);
        set(25, latitude);
        set(26, status);
        set(27, btsnumber);
        set(28, cellnumber);
    }
}

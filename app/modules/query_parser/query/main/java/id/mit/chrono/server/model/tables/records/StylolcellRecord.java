/*
 * This file is generated by jOOQ.
*/
package id.mit.chrono.server.model.tables.records;


import id.mit.chrono.server.model.tables.Stylolcell;

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
public class StylolcellRecord extends UpdatableRecordImpl<StylolcellRecord> {

    private static final long serialVersionUID = -1449582451;

    /**
     * Setter for <code>chrono.stylolcell.stylolcell_id</code>.
     */
    public void setStylolcellId(ULong value) {
        set(0, value);
    }

    /**
     * Getter for <code>chrono.stylolcell.stylolcell_id</code>.
     */
    public ULong getStylolcellId() {
        return (ULong) get(0);
    }

    /**
     * Setter for <code>chrono.stylolcell.stylolcell_crcollectortaskfiles</code>.
     */
    public void setStylolcellCrcollectortaskfiles(ULong value) {
        set(1, value);
    }

    /**
     * Getter for <code>chrono.stylolcell.stylolcell_crcollectortaskfiles</code>.
     */
    public ULong getStylolcellCrcollectortaskfiles() {
        return (ULong) get(1);
    }

    /**
     * Setter for <code>chrono.stylolcell.stylolcell_date</code>.
     */
    public void setStylolcellDate(UInteger value) {
        set(2, value);
    }

    /**
     * Getter for <code>chrono.stylolcell.stylolcell_date</code>.
     */
    public UInteger getStylolcellDate() {
        return (UInteger) get(2);
    }

    /**
     * Setter for <code>chrono.stylolcell.SOURCE</code>.
     */
    public void setSource(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>chrono.stylolcell.SOURCE</code>.
     */
    public String getSource() {
        return (String) get(3);
    }

    /**
     * Setter for <code>chrono.stylolcell.REGIONAL</code>.
     */
    public void setRegional(String value) {
        set(4, value);
    }

    /**
     * Getter for <code>chrono.stylolcell.REGIONAL</code>.
     */
    public String getRegional() {
        return (String) get(4);
    }

    /**
     * Setter for <code>chrono.stylolcell.VENDOR</code>.
     */
    public void setVendor(String value) {
        set(5, value);
    }

    /**
     * Getter for <code>chrono.stylolcell.VENDOR</code>.
     */
    public String getVendor() {
        return (String) get(5);
    }

    /**
     * Setter for <code>chrono.stylolcell.TAC_ENODEBID_CI</code>.
     */
    public void setTacEnodebidCi(String value) {
        set(6, value);
    }

    /**
     * Getter for <code>chrono.stylolcell.TAC_ENODEBID_CI</code>.
     */
    public String getTacEnodebidCi() {
        return (String) get(6);
    }

    /**
     * Setter for <code>chrono.stylolcell.ENODEBID</code>.
     */
    public void setEnodebid(String value) {
        set(7, value);
    }

    /**
     * Getter for <code>chrono.stylolcell.ENODEBID</code>.
     */
    public String getEnodebid() {
        return (String) get(7);
    }

    /**
     * Setter for <code>chrono.stylolcell.NODEB_NAME</code>.
     */
    public void setNodebName(String value) {
        set(8, value);
    }

    /**
     * Getter for <code>chrono.stylolcell.NODEB_NAME</code>.
     */
    public String getNodebName() {
        return (String) get(8);
    }

    /**
     * Setter for <code>chrono.stylolcell.CELL_NAME</code>.
     */
    public void setCellName(String value) {
        set(9, value);
    }

    /**
     * Getter for <code>chrono.stylolcell.CELL_NAME</code>.
     */
    public String getCellName() {
        return (String) get(9);
    }

    /**
     * Setter for <code>chrono.stylolcell.CELL_NO</code>.
     */
    public void setCellNo(String value) {
        set(10, value);
    }

    /**
     * Getter for <code>chrono.stylolcell.CELL_NO</code>.
     */
    public String getCellNo() {
        return (String) get(10);
    }

    /**
     * Setter for <code>chrono.stylolcell.NE_ID</code>.
     */
    public void setNeId(String value) {
        set(11, value);
    }

    /**
     * Getter for <code>chrono.stylolcell.NE_ID</code>.
     */
    public String getNeId() {
        return (String) get(11);
    }

    /**
     * Setter for <code>chrono.stylolcell.SITE_ID</code>.
     */
    public void setSiteId(String value) {
        set(12, value);
    }

    /**
     * Getter for <code>chrono.stylolcell.SITE_ID</code>.
     */
    public String getSiteId() {
        return (String) get(12);
    }

    /**
     * Setter for <code>chrono.stylolcell.TAC</code>.
     */
    public void setTac(String value) {
        set(13, value);
    }

    /**
     * Getter for <code>chrono.stylolcell.TAC</code>.
     */
    public String getTac() {
        return (String) get(13);
    }

    /**
     * Setter for <code>chrono.stylolcell.CI</code>.
     */
    public void setCi(String value) {
        set(14, value);
    }

    /**
     * Getter for <code>chrono.stylolcell.CI</code>.
     */
    public String getCi() {
        return (String) get(14);
    }

    /**
     * Setter for <code>chrono.stylolcell.EARFCN</code>.
     */
    public void setEarfcn(String value) {
        set(15, value);
    }

    /**
     * Getter for <code>chrono.stylolcell.EARFCN</code>.
     */
    public String getEarfcn() {
        return (String) get(15);
    }

    /**
     * Setter for <code>chrono.stylolcell.FREQUENCY_MHZ</code>.
     */
    public void setFrequencyMhz(String value) {
        set(16, value);
    }

    /**
     * Getter for <code>chrono.stylolcell.FREQUENCY_MHZ</code>.
     */
    public String getFrequencyMhz() {
        return (String) get(16);
    }

    /**
     * Setter for <code>chrono.stylolcell.BANDTYPE</code>.
     */
    public void setBandtype(String value) {
        set(17, value);
    }

    /**
     * Getter for <code>chrono.stylolcell.BANDTYPE</code>.
     */
    public String getBandtype() {
        return (String) get(17);
    }

    /**
     * Setter for <code>chrono.stylolcell.BANDWITH</code>.
     */
    public void setBandwith(String value) {
        set(18, value);
    }

    /**
     * Getter for <code>chrono.stylolcell.BANDWITH</code>.
     */
    public String getBandwith() {
        return (String) get(18);
    }

    /**
     * Setter for <code>chrono.stylolcell.LONGITUDE</code>.
     */
    public void setLongitude(String value) {
        set(19, value);
    }

    /**
     * Getter for <code>chrono.stylolcell.LONGITUDE</code>.
     */
    public String getLongitude() {
        return (String) get(19);
    }

    /**
     * Setter for <code>chrono.stylolcell.LATITUDE</code>.
     */
    public void setLatitude(String value) {
        set(20, value);
    }

    /**
     * Getter for <code>chrono.stylolcell.LATITUDE</code>.
     */
    public String getLatitude() {
        return (String) get(20);
    }

    /**
     * Setter for <code>chrono.stylolcell.BTSTYPE</code>.
     */
    public void setBtstype(String value) {
        set(21, value);
    }

    /**
     * Getter for <code>chrono.stylolcell.BTSTYPE</code>.
     */
    public String getBtstype() {
        return (String) get(21);
    }

    /**
     * Setter for <code>chrono.stylolcell.STATUS</code>.
     */
    public void setStatus(String value) {
        set(22, value);
    }

    /**
     * Getter for <code>chrono.stylolcell.STATUS</code>.
     */
    public String getStatus() {
        return (String) get(22);
    }

    /**
     * Setter for <code>chrono.stylolcell.NEWSITE</code>.
     */
    public void setNewsite(String value) {
        set(23, value);
    }

    /**
     * Getter for <code>chrono.stylolcell.NEWSITE</code>.
     */
    public String getNewsite() {
        return (String) get(23);
    }

    /**
     * Setter for <code>chrono.stylolcell.PID</code>.
     */
    public void setPid(String value) {
        set(24, value);
    }

    /**
     * Getter for <code>chrono.stylolcell.PID</code>.
     */
    public String getPid() {
        return (String) get(24);
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
     * Create a detached StylolcellRecord
     */
    public StylolcellRecord() {
        super(Stylolcell.STYLOLCELL);
    }

    /**
     * Create a detached, initialised StylolcellRecord
     */
    public StylolcellRecord(ULong stylolcellId, ULong stylolcellCrcollectortaskfiles, UInteger stylolcellDate, String source, String regional, String vendor, String tacEnodebidCi, String enodebid, String nodebName, String cellName, String cellNo, String neId, String siteId, String tac, String ci, String earfcn, String frequencyMhz, String bandtype, String bandwith, String longitude, String latitude, String btstype, String status, String newsite, String pid) {
        super(Stylolcell.STYLOLCELL);

        set(0, stylolcellId);
        set(1, stylolcellCrcollectortaskfiles);
        set(2, stylolcellDate);
        set(3, source);
        set(4, regional);
        set(5, vendor);
        set(6, tacEnodebidCi);
        set(7, enodebid);
        set(8, nodebName);
        set(9, cellName);
        set(10, cellNo);
        set(11, neId);
        set(12, siteId);
        set(13, tac);
        set(14, ci);
        set(15, earfcn);
        set(16, frequencyMhz);
        set(17, bandtype);
        set(18, bandwith);
        set(19, longitude);
        set(20, latitude);
        set(21, btstype);
        set(22, status);
        set(23, newsite);
        set(24, pid);
    }
}
/*
 * This file is generated by jOOQ.
*/
package id.mit.chrono.server.model.tables.records;


import id.mit.chrono.server.model.tables.Ztegtrx;

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
public class ZtegtrxRecord extends UpdatableRecordImpl<ZtegtrxRecord> {

    private static final long serialVersionUID = 596635362;

    /**
     * Setter for <code>chrono.ztegtrx.ztegtrx_id</code>.
     */
    public void setZtegtrxId(ULong value) {
        set(0, value);
    }

    /**
     * Getter for <code>chrono.ztegtrx.ztegtrx_id</code>.
     */
    public ULong getZtegtrxId() {
        return (ULong) get(0);
    }

    /**
     * Setter for <code>chrono.ztegtrx.ztegtrx_crcollectortaskfiles</code>.
     */
    public void setZtegtrxCrcollectortaskfiles(ULong value) {
        set(1, value);
    }

    /**
     * Getter for <code>chrono.ztegtrx.ztegtrx_crcollectortaskfiles</code>.
     */
    public ULong getZtegtrxCrcollectortaskfiles() {
        return (ULong) get(1);
    }

    /**
     * Setter for <code>chrono.ztegtrx.ztegtrx_date</code>.
     */
    public void setZtegtrxDate(UInteger value) {
        set(2, value);
    }

    /**
     * Getter for <code>chrono.ztegtrx.ztegtrx_date</code>.
     */
    public UInteger getZtegtrxDate() {
        return (UInteger) get(2);
    }

    /**
     * Setter for <code>chrono.ztegtrx.ztegtrx_datefrom</code>.
     */
    public void setZtegtrxDatefrom(UInteger value) {
        set(3, value);
    }

    /**
     * Getter for <code>chrono.ztegtrx.ztegtrx_datefrom</code>.
     */
    public UInteger getZtegtrxDatefrom() {
        return (UInteger) get(3);
    }

    /**
     * Setter for <code>chrono.ztegtrx.ztegtrx_ztebsc</code>.
     */
    public void setZtegtrxZtebsc(ULong value) {
        set(4, value);
    }

    /**
     * Getter for <code>chrono.ztegtrx.ztegtrx_ztebsc</code>.
     */
    public ULong getZtegtrxZtebsc() {
        return (ULong) get(4);
    }

    /**
     * Setter for <code>chrono.ztegtrx.ztegtrx_ztebts</code>.
     */
    public void setZtegtrxZtebts(ULong value) {
        set(5, value);
    }

    /**
     * Getter for <code>chrono.ztegtrx.ztegtrx_ztebts</code>.
     */
    public ULong getZtegtrxZtebts() {
        return (ULong) get(5);
    }

    /**
     * Setter for <code>chrono.ztegtrx.ztegtrx_ztegcell</code>.
     */
    public void setZtegtrxZtegcell(ULong value) {
        set(6, value);
    }

    /**
     * Getter for <code>chrono.ztegtrx.ztegtrx_ztegcell</code>.
     */
    public ULong getZtegtrxZtegcell() {
        return (ULong) get(6);
    }

    /**
     * Setter for <code>chrono.ztegtrx.MOI</code>.
     */
    public void setMoi(String value) {
        set(7, value);
    }

    /**
     * Getter for <code>chrono.ztegtrx.MOI</code>.
     */
    public String getMoi() {
        return (String) get(7);
    }

    /**
     * Setter for <code>chrono.ztegtrx.SubNetwork</code>.
     */
    public void setSubnetwork(String value) {
        set(8, value);
    }

    /**
     * Getter for <code>chrono.ztegtrx.SubNetwork</code>.
     */
    public String getSubnetwork() {
        return (String) get(8);
    }

    /**
     * Setter for <code>chrono.ztegtrx.MEID</code>.
     */
    public void setMeid(String value) {
        set(9, value);
    }

    /**
     * Getter for <code>chrono.ztegtrx.MEID</code>.
     */
    public String getMeid() {
        return (String) get(9);
    }

    /**
     * Setter for <code>chrono.ztegtrx.GBssFunction</code>.
     */
    public void setGbssfunction(String value) {
        set(10, value);
    }

    /**
     * Getter for <code>chrono.ztegtrx.GBssFunction</code>.
     */
    public String getGbssfunction() {
        return (String) get(10);
    }

    /**
     * Setter for <code>chrono.ztegtrx.GBtsSiteManager</code>.
     */
    public void setGbtssitemanager(String value) {
        set(11, value);
    }

    /**
     * Getter for <code>chrono.ztegtrx.GBtsSiteManager</code>.
     */
    public String getGbtssitemanager() {
        return (String) get(11);
    }

    /**
     * Setter for <code>chrono.ztegtrx.GGsmCell</code>.
     */
    public void setGgsmcell(String value) {
        set(12, value);
    }

    /**
     * Getter for <code>chrono.ztegtrx.GGsmCell</code>.
     */
    public String getGgsmcell() {
        return (String) get(12);
    }

    /**
     * Setter for <code>chrono.ztegtrx.GTrx</code>.
     */
    public void setGtrx(String value) {
        set(13, value);
    }

    /**
     * Getter for <code>chrono.ztegtrx.GTrx</code>.
     */
    public String getGtrx() {
        return (String) get(13);
    }

    /**
     * Setter for <code>chrono.ztegtrx.userLabel</code>.
     */
    public void setUserlabel(String value) {
        set(14, value);
    }

    /**
     * Getter for <code>chrono.ztegtrx.userLabel</code>.
     */
    public String getUserlabel() {
        return (String) get(14);
    }

    /**
     * Setter for <code>chrono.ztegtrx.GTrxSeq</code>.
     */
    public void setGtrxseq(String value) {
        set(15, value);
    }

    /**
     * Getter for <code>chrono.ztegtrx.GTrxSeq</code>.
     */
    public String getGtrxseq() {
        return (String) get(15);
    }

    /**
     * Setter for <code>chrono.ztegtrx.BCCHMARK</code>.
     */
    public void setBcchmark(String value) {
        set(16, value);
    }

    /**
     * Getter for <code>chrono.ztegtrx.BCCHMARK</code>.
     */
    public String getBcchmark() {
        return (String) get(16);
    }

    /**
     * Setter for <code>chrono.ztegtrx.trxPriority</code>.
     */
    public void setTrxpriority(String value) {
        set(17, value);
    }

    /**
     * Getter for <code>chrono.ztegtrx.trxPriority</code>.
     */
    public String getTrxpriority() {
        return (String) get(17);
    }

    /**
     * Setter for <code>chrono.ztegtrx.arfcn</code>.
     */
    public void setArfcn(String value) {
        set(18, value);
    }

    /**
     * Getter for <code>chrono.ztegtrx.arfcn</code>.
     */
    public String getArfcn() {
        return (String) get(18);
    }

    /**
     * Setter for <code>chrono.ztegtrx.refGBtsPanel</code>.
     */
    public void setRefgbtspanel(String value) {
        set(19, value);
    }

    /**
     * Getter for <code>chrono.ztegtrx.refGBtsPanel</code>.
     */
    public String getRefgbtspanel() {
        return (String) get(19);
    }

    /**
     * Setter for <code>chrono.ztegtrx.trxType</code>.
     */
    public void setTrxtype(String value) {
        set(20, value);
    }

    /**
     * Getter for <code>chrono.ztegtrx.trxType</code>.
     */
    public String getTrxtype() {
        return (String) get(20);
    }

    /**
     * Setter for <code>chrono.ztegtrx.pwrReduction</code>.
     */
    public void setPwrreduction(String value) {
        set(21, value);
    }

    /**
     * Getter for <code>chrono.ztegtrx.pwrReduction</code>.
     */
    public String getPwrreduction() {
        return (String) get(21);
    }

    /**
     * Setter for <code>chrono.ztegtrx.powerClass</code>.
     */
    public void setPowerclass(String value) {
        set(22, value);
    }

    /**
     * Getter for <code>chrono.ztegtrx.powerClass</code>.
     */
    public String getPowerclass() {
        return (String) get(22);
    }

    /**
     * Setter for <code>chrono.ztegtrx.refGTrx</code>.
     */
    public void setRefgtrx(String value) {
        set(23, value);
    }

    /**
     * Getter for <code>chrono.ztegtrx.refGTrx</code>.
     */
    public String getRefgtrx() {
        return (String) get(23);
    }

    /**
     * Setter for <code>chrono.ztegtrx.rttiPrefer</code>.
     */
    public void setRttiprefer(String value) {
        set(24, value);
    }

    /**
     * Getter for <code>chrono.ztegtrx.rttiPrefer</code>.
     */
    public String getRttiprefer() {
        return (String) get(24);
    }

    /**
     * Setter for <code>chrono.ztegtrx.tsc2</code>.
     */
    public void setTsc2(String value) {
        set(25, value);
    }

    /**
     * Getter for <code>chrono.ztegtrx.tsc2</code>.
     */
    public String getTsc2() {
        return (String) get(25);
    }

    /**
     * Setter for <code>chrono.ztegtrx.DynamicTrx</code>.
     */
    public void setDynamictrx(String value) {
        set(26, value);
    }

    /**
     * Getter for <code>chrono.ztegtrx.DynamicTrx</code>.
     */
    public String getDynamictrx() {
        return (String) get(26);
    }

    /**
     * Setter for <code>chrono.ztegtrx.refGHoppingFrequency</code>.
     */
    public void setRefghoppingfrequency(String value) {
        set(27, value);
    }

    /**
     * Getter for <code>chrono.ztegtrx.refGHoppingFrequency</code>.
     */
    public String getRefghoppingfrequency() {
        return (String) get(27);
    }

    /**
     * Setter for <code>chrono.ztegtrx.refGHoppingBaseband</code>.
     */
    public void setRefghoppingbaseband(String value) {
        set(28, value);
    }

    /**
     * Getter for <code>chrono.ztegtrx.refGHoppingBaseband</code>.
     */
    public String getRefghoppingbaseband() {
        return (String) get(28);
    }

    /**
     * Setter for <code>chrono.ztegtrx.CombinerLoss</code>.
     */
    public void setCombinerloss(String value) {
        set(29, value);
    }

    /**
     * Getter for <code>chrono.ztegtrx.CombinerLoss</code>.
     */
    public String getCombinerloss() {
        return (String) get(29);
    }

    /**
     * Setter for <code>chrono.ztegtrx.maio</code>.
     */
    public void setMaio(String value) {
        set(30, value);
    }

    /**
     * Getter for <code>chrono.ztegtrx.maio</code>.
     */
    public String getMaio() {
        return (String) get(30);
    }

    /**
     * Setter for <code>chrono.ztegtrx.TsFHSupport</code>.
     */
    public void setTsfhsupport(String value) {
        set(31, value);
    }

    /**
     * Getter for <code>chrono.ztegtrx.TsFHSupport</code>.
     */
    public String getTsfhsupport() {
        return (String) get(31);
    }

    /**
     * Setter for <code>chrono.ztegtrx.IFTATRX</code>.
     */
    public void setIftatrx(String value) {
        set(32, value);
    }

    /**
     * Getter for <code>chrono.ztegtrx.IFTATRX</code>.
     */
    public String getIftatrx() {
        return (String) get(32);
    }

    /**
     * Setter for <code>chrono.ztegtrx.UseWhenIFTAOff</code>.
     */
    public void setUsewheniftaoff(String value) {
        set(33, value);
    }

    /**
     * Getter for <code>chrono.ztegtrx.UseWhenIFTAOff</code>.
     */
    public String getUsewheniftaoff() {
        return (String) get(33);
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
     * Create a detached ZtegtrxRecord
     */
    public ZtegtrxRecord() {
        super(Ztegtrx.ZTEGTRX);
    }

    /**
     * Create a detached, initialised ZtegtrxRecord
     */
    public ZtegtrxRecord(ULong ztegtrxId, ULong ztegtrxCrcollectortaskfiles, UInteger ztegtrxDate, UInteger ztegtrxDatefrom, ULong ztegtrxZtebsc, ULong ztegtrxZtebts, ULong ztegtrxZtegcell, String moi, String subnetwork, String meid, String gbssfunction, String gbtssitemanager, String ggsmcell, String gtrx, String userlabel, String gtrxseq, String bcchmark, String trxpriority, String arfcn, String refgbtspanel, String trxtype, String pwrreduction, String powerclass, String refgtrx, String rttiprefer, String tsc2, String dynamictrx, String refghoppingfrequency, String refghoppingbaseband, String combinerloss, String maio, String tsfhsupport, String iftatrx, String usewheniftaoff) {
        super(Ztegtrx.ZTEGTRX);

        set(0, ztegtrxId);
        set(1, ztegtrxCrcollectortaskfiles);
        set(2, ztegtrxDate);
        set(3, ztegtrxDatefrom);
        set(4, ztegtrxZtebsc);
        set(5, ztegtrxZtebts);
        set(6, ztegtrxZtegcell);
        set(7, moi);
        set(8, subnetwork);
        set(9, meid);
        set(10, gbssfunction);
        set(11, gbtssitemanager);
        set(12, ggsmcell);
        set(13, gtrx);
        set(14, userlabel);
        set(15, gtrxseq);
        set(16, bcchmark);
        set(17, trxpriority);
        set(18, arfcn);
        set(19, refgbtspanel);
        set(20, trxtype);
        set(21, pwrreduction);
        set(22, powerclass);
        set(23, refgtrx);
        set(24, rttiprefer);
        set(25, tsc2);
        set(26, dynamictrx);
        set(27, refghoppingfrequency);
        set(28, refghoppingbaseband);
        set(29, combinerloss);
        set(30, maio);
        set(31, tsfhsupport);
        set(32, iftatrx);
        set(33, usewheniftaoff);
    }
}

/*
 * This file is generated by jOOQ.
*/
package id.mit.chrono.server.model.tables.records;


import id.mit.chrono.server.model.tables.Ztebts;

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
public class ZtebtsRecord extends UpdatableRecordImpl<ZtebtsRecord> {

    private static final long serialVersionUID = 531389916;

    /**
     * Setter for <code>chrono.ztebts.ztebts_id</code>.
     */
    public void setZtebtsId(ULong value) {
        set(0, value);
    }

    /**
     * Getter for <code>chrono.ztebts.ztebts_id</code>.
     */
    public ULong getZtebtsId() {
        return (ULong) get(0);
    }

    /**
     * Setter for <code>chrono.ztebts.ztebts_crcollectortaskfiles</code>.
     */
    public void setZtebtsCrcollectortaskfiles(ULong value) {
        set(1, value);
    }

    /**
     * Getter for <code>chrono.ztebts.ztebts_crcollectortaskfiles</code>.
     */
    public ULong getZtebtsCrcollectortaskfiles() {
        return (ULong) get(1);
    }

    /**
     * Setter for <code>chrono.ztebts.ztebts_date</code>.
     */
    public void setZtebtsDate(UInteger value) {
        set(2, value);
    }

    /**
     * Getter for <code>chrono.ztebts.ztebts_date</code>.
     */
    public UInteger getZtebtsDate() {
        return (UInteger) get(2);
    }

    /**
     * Setter for <code>chrono.ztebts.ztebts_datefrom</code>.
     */
    public void setZtebtsDatefrom(UInteger value) {
        set(3, value);
    }

    /**
     * Getter for <code>chrono.ztebts.ztebts_datefrom</code>.
     */
    public UInteger getZtebtsDatefrom() {
        return (UInteger) get(3);
    }

    /**
     * Setter for <code>chrono.ztebts.ztebts_ztebsc</code>.
     */
    public void setZtebtsZtebsc(ULong value) {
        set(4, value);
    }

    /**
     * Getter for <code>chrono.ztebts.ztebts_ztebsc</code>.
     */
    public ULong getZtebtsZtebsc() {
        return (ULong) get(4);
    }

    /**
     * Setter for <code>chrono.ztebts.ztebts_node</code>.
     */
    public void setZtebtsNode(Integer value) {
        set(5, value);
    }

    /**
     * Getter for <code>chrono.ztebts.ztebts_node</code>.
     */
    public Integer getZtebtsNode() {
        return (Integer) get(5);
    }

    /**
     * Setter for <code>chrono.ztebts.ztebts_nodephysical</code>.
     */
    public void setZtebtsNodephysical(Integer value) {
        set(6, value);
    }

    /**
     * Getter for <code>chrono.ztebts.ztebts_nodephysical</code>.
     */
    public Integer getZtebtsNodephysical() {
        return (Integer) get(6);
    }

    /**
     * Setter for <code>chrono.ztebts.ztebts_nodestatus</code>.
     */
    public void setZtebtsNodestatus(Integer value) {
        set(7, value);
    }

    /**
     * Getter for <code>chrono.ztebts.ztebts_nodestatus</code>.
     */
    public Integer getZtebtsNodestatus() {
        return (Integer) get(7);
    }

    /**
     * Setter for <code>chrono.ztebts.ztebts_revenueclass</code>.
     */
    public void setZtebtsRevenueclass(Integer value) {
        set(8, value);
    }

    /**
     * Getter for <code>chrono.ztebts.ztebts_revenueclass</code>.
     */
    public Integer getZtebtsRevenueclass() {
        return (Integer) get(8);
    }

    /**
     * Setter for <code>chrono.ztebts.ztebts_vendor</code>.
     */
    public void setZtebtsVendor(Integer value) {
        set(9, value);
    }

    /**
     * Getter for <code>chrono.ztebts.ztebts_vendor</code>.
     */
    public Integer getZtebtsVendor() {
        return (Integer) get(9);
    }

    /**
     * Setter for <code>chrono.ztebts.ztebts_namingvalid</code>.
     */
    public void setZtebtsNamingvalid(Byte value) {
        set(10, value);
    }

    /**
     * Getter for <code>chrono.ztebts.ztebts_namingvalid</code>.
     */
    public Byte getZtebtsNamingvalid() {
        return (Byte) get(10);
    }

    /**
     * Setter for <code>chrono.ztebts.TOTALCELL</code>.
     */
    public void setTotalcell(Integer value) {
        set(11, value);
    }

    /**
     * Getter for <code>chrono.ztebts.TOTALCELL</code>.
     */
    public Integer getTotalcell() {
        return (Integer) get(11);
    }

    /**
     * Setter for <code>chrono.ztebts.TOTALTRX</code>.
     */
    public void setTotaltrx(Integer value) {
        set(12, value);
    }

    /**
     * Getter for <code>chrono.ztebts.TOTALTRX</code>.
     */
    public Integer getTotaltrx() {
        return (Integer) get(12);
    }

    /**
     * Setter for <code>chrono.ztebts.BTSNAME</code>.
     */
    public void setBtsname(String value) {
        set(13, value);
    }

    /**
     * Getter for <code>chrono.ztebts.BTSNAME</code>.
     */
    public String getBtsname() {
        return (String) get(13);
    }

    /**
     * Setter for <code>chrono.ztebts.MOI</code>.
     */
    public void setMoi(String value) {
        set(14, value);
    }

    /**
     * Getter for <code>chrono.ztebts.MOI</code>.
     */
    public String getMoi() {
        return (String) get(14);
    }

    /**
     * Setter for <code>chrono.ztebts.SubNetwork</code>.
     */
    public void setSubnetwork(String value) {
        set(15, value);
    }

    /**
     * Getter for <code>chrono.ztebts.SubNetwork</code>.
     */
    public String getSubnetwork() {
        return (String) get(15);
    }

    /**
     * Setter for <code>chrono.ztebts.MEID</code>.
     */
    public void setMeid(String value) {
        set(16, value);
    }

    /**
     * Getter for <code>chrono.ztebts.MEID</code>.
     */
    public String getMeid() {
        return (String) get(16);
    }

    /**
     * Setter for <code>chrono.ztebts.GBssFunction</code>.
     */
    public void setGbssfunction(String value) {
        set(17, value);
    }

    /**
     * Getter for <code>chrono.ztebts.GBssFunction</code>.
     */
    public String getGbssfunction() {
        return (String) get(17);
    }

    /**
     * Setter for <code>chrono.ztebts.GBtsSiteManager</code>.
     */
    public void setGbtssitemanager(String value) {
        set(18, value);
    }

    /**
     * Getter for <code>chrono.ztebts.GBtsSiteManager</code>.
     */
    public String getGbtssitemanager() {
        return (String) get(18);
    }

    /**
     * Setter for <code>chrono.ztebts.userLabel</code>.
     */
    public void setUserlabel(String value) {
        set(19, value);
    }

    /**
     * Getter for <code>chrono.ztebts.userLabel</code>.
     */
    public String getUserlabel() {
        return (String) get(19);
    }

    /**
     * Setter for <code>chrono.ztebts.description</code>.
     */
    public void setDescription(String value) {
        set(20, value);
    }

    /**
     * Getter for <code>chrono.ztebts.description</code>.
     */
    public String getDescription() {
        return (String) get(20);
    }

    /**
     * Setter for <code>chrono.ztebts.MasterPwCtrlGNode</code>.
     */
    public void setMasterpwctrlgnode(String value) {
        set(21, value);
    }

    /**
     * Getter for <code>chrono.ztebts.MasterPwCtrlGNode</code>.
     */
    public String getMasterpwctrlgnode() {
        return (String) get(21);
    }

    /**
     * Setter for <code>chrono.ztebts.refGBtsEquipment</code>.
     */
    public void setRefgbtsequipment(String value) {
        set(22, value);
    }

    /**
     * Getter for <code>chrono.ztebts.refGBtsEquipment</code>.
     */
    public String getRefgbtsequipment() {
        return (String) get(22);
    }

    /**
     * Setter for <code>chrono.ztebts.CfgPagingRepSupport</code>.
     */
    public void setCfgpagingrepsupport(String value) {
        set(23, value);
    }

    /**
     * Getter for <code>chrono.ztebts.CfgPagingRepSupport</code>.
     */
    public String getCfgpagingrepsupport() {
        return (String) get(23);
    }

    /**
     * Setter for <code>chrono.ztebts.SubCellHO</code>.
     */
    public void setSubcellho(String value) {
        set(24, value);
    }

    /**
     * Getter for <code>chrono.ztebts.SubCellHO</code>.
     */
    public String getSubcellho() {
        return (String) get(24);
    }

    /**
     * Setter for <code>chrono.ztebts.SupNewAbisPsMsg</code>.
     */
    public void setSupnewabispsmsg(String value) {
        set(25, value);
    }

    /**
     * Getter for <code>chrono.ztebts.SupNewAbisPsMsg</code>.
     */
    public String getSupnewabispsmsg() {
        return (String) get(25);
    }

    /**
     * Setter for <code>chrono.ztebts.bwrestorelimit</code>.
     */
    public void setBwrestorelimit(String value) {
        set(26, value);
    }

    /**
     * Getter for <code>chrono.ztebts.bwrestorelimit</code>.
     */
    public String getBwrestorelimit() {
        return (String) get(26);
    }

    /**
     * Setter for <code>chrono.ztebts.frtohrbwlimit</code>.
     */
    public void setFrtohrbwlimit(String value) {
        set(27, value);
    }

    /**
     * Getter for <code>chrono.ztebts.frtohrbwlimit</code>.
     */
    public String getFrtohrbwlimit() {
        return (String) get(27);
    }

    /**
     * Setter for <code>chrono.ztebts.MinAccessAbisThsE1</code>.
     */
    public void setMinaccessabisthse1(String value) {
        set(28, value);
    }

    /**
     * Getter for <code>chrono.ztebts.MinAccessAbisThsE1</code>.
     */
    public String getMinaccessabisthse1() {
        return (String) get(28);
    }

    /**
     * Setter for <code>chrono.ztebts.MinAccessAbisThsIP</code>.
     */
    public void setMinaccessabisthsip(String value) {
        set(29, value);
    }

    /**
     * Getter for <code>chrono.ztebts.MinAccessAbisThsIP</code>.
     */
    public String getMinaccessabisthsip() {
        return (String) get(29);
    }

    /**
     * Setter for <code>chrono.ztebts.BtsMasterPwCtrlOp</code>.
     */
    public void setBtsmasterpwctrlop(String value) {
        set(30, value);
    }

    /**
     * Getter for <code>chrono.ztebts.BtsMasterPwCtrlOp</code>.
     */
    public String getBtsmasterpwctrlop() {
        return (String) get(30);
    }

    /**
     * Setter for <code>chrono.ztebts.MasterPwrOffTime</code>.
     */
    public void setMasterpwrofftime(String value) {
        set(31, value);
    }

    /**
     * Getter for <code>chrono.ztebts.MasterPwrOffTime</code>.
     */
    public String getMasterpwrofftime() {
        return (String) get(31);
    }

    /**
     * Setter for <code>chrono.ztebts.TrxOffTime</code>.
     */
    public void setTrxofftime(String value) {
        set(32, value);
    }

    /**
     * Getter for <code>chrono.ztebts.TrxOffTime</code>.
     */
    public String getTrxofftime() {
        return (String) get(32);
    }

    /**
     * Setter for <code>chrono.ztebts.TrxOffPercent</code>.
     */
    public void setTrxoffpercent(String value) {
        set(33, value);
    }

    /**
     * Getter for <code>chrono.ztebts.TrxOffPercent</code>.
     */
    public String getTrxoffpercent() {
        return (String) get(33);
    }

    /**
     * Setter for <code>chrono.ztebts.BenchmarkSite</code>.
     */
    public void setBenchmarksite(String value) {
        set(34, value);
    }

    /**
     * Getter for <code>chrono.ztebts.BenchmarkSite</code>.
     */
    public String getBenchmarksite() {
        return (String) get(34);
    }

    /**
     * Setter for <code>chrono.ztebts.Longitude</code>.
     */
    public void setLongitude(String value) {
        set(35, value);
    }

    /**
     * Getter for <code>chrono.ztebts.Longitude</code>.
     */
    public String getLongitude() {
        return (String) get(35);
    }

    /**
     * Setter for <code>chrono.ztebts.Latitude</code>.
     */
    public void setLatitude(String value) {
        set(36, value);
    }

    /**
     * Getter for <code>chrono.ztebts.Latitude</code>.
     */
    public String getLatitude() {
        return (String) get(36);
    }

    /**
     * Setter for <code>chrono.ztebts.ztebts_remark</code>.
     */
    public void setZtebtsRemark(String value) {
        set(37, value);
    }

    /**
     * Getter for <code>chrono.ztebts.ztebts_remark</code>.
     */
    public String getZtebtsRemark() {
        return (String) get(37);
    }

    /**
     * Setter for <code>chrono.ztebts.GSiteBaseBandShare</code>.
     */
    public void setGsitebasebandshare(String value) {
        set(38, value);
    }

    /**
     * Getter for <code>chrono.ztebts.GSiteBaseBandShare</code>.
     */
    public String getGsitebasebandshare() {
        return (String) get(38);
    }

    /**
     * Setter for <code>chrono.ztebts.bbRequestTraThs</code>.
     */
    public void setBbrequesttraths(String value) {
        set(39, value);
    }

    /**
     * Getter for <code>chrono.ztebts.bbRequestTraThs</code>.
     */
    public String getBbrequesttraths() {
        return (String) get(39);
    }

    /**
     * Setter for <code>chrono.ztebts.bbReleaseTraThs</code>.
     */
    public void setBbreleasetraths(String value) {
        set(40, value);
    }

    /**
     * Getter for <code>chrono.ztebts.bbReleaseTraThs</code>.
     */
    public String getBbreleasetraths() {
        return (String) get(40);
    }

    /**
     * Setter for <code>chrono.ztebts.bbOverThs</code>.
     */
    public void setBboverths(String value) {
        set(41, value);
    }

    /**
     * Getter for <code>chrono.ztebts.bbOverThs</code>.
     */
    public String getBboverths() {
        return (String) get(41);
    }

    /**
     * Setter for <code>chrono.ztebts.bbLowerThs</code>.
     */
    public void setBblowerths(String value) {
        set(42, value);
    }

    /**
     * Getter for <code>chrono.ztebts.bbLowerThs</code>.
     */
    public String getBblowerths() {
        return (String) get(42);
    }

    /**
     * Setter for <code>chrono.ztebts.EXTPROP1</code>.
     */
    public void setExtprop1(Integer value) {
        set(43, value);
    }

    /**
     * Getter for <code>chrono.ztebts.EXTPROP1</code>.
     */
    public Integer getExtprop1() {
        return (Integer) get(43);
    }

    /**
     * Setter for <code>chrono.ztebts.EXTPROP2</code>.
     */
    public void setExtprop2(String value) {
        set(44, value);
    }

    /**
     * Getter for <code>chrono.ztebts.EXTPROP2</code>.
     */
    public String getExtprop2() {
        return (String) get(44);
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
     * Create a detached ZtebtsRecord
     */
    public ZtebtsRecord() {
        super(Ztebts.ZTEBTS);
    }

    /**
     * Create a detached, initialised ZtebtsRecord
     */
    public ZtebtsRecord(ULong ztebtsId, ULong ztebtsCrcollectortaskfiles, UInteger ztebtsDate, UInteger ztebtsDatefrom, ULong ztebtsZtebsc, Integer ztebtsNode, Integer ztebtsNodephysical, Integer ztebtsNodestatus, Integer ztebtsRevenueclass, Integer ztebtsVendor, Byte ztebtsNamingvalid, Integer totalcell, Integer totaltrx, String btsname, String moi, String subnetwork, String meid, String gbssfunction, String gbtssitemanager, String userlabel, String description, String masterpwctrlgnode, String refgbtsequipment, String cfgpagingrepsupport, String subcellho, String supnewabispsmsg, String bwrestorelimit, String frtohrbwlimit, String minaccessabisthse1, String minaccessabisthsip, String btsmasterpwctrlop, String masterpwrofftime, String trxofftime, String trxoffpercent, String benchmarksite, String longitude, String latitude, String ztebtsRemark, String gsitebasebandshare, String bbrequesttraths, String bbreleasetraths, String bboverths, String bblowerths, Integer extprop1, String extprop2) {
        super(Ztebts.ZTEBTS);

        set(0, ztebtsId);
        set(1, ztebtsCrcollectortaskfiles);
        set(2, ztebtsDate);
        set(3, ztebtsDatefrom);
        set(4, ztebtsZtebsc);
        set(5, ztebtsNode);
        set(6, ztebtsNodephysical);
        set(7, ztebtsNodestatus);
        set(8, ztebtsRevenueclass);
        set(9, ztebtsVendor);
        set(10, ztebtsNamingvalid);
        set(11, totalcell);
        set(12, totaltrx);
        set(13, btsname);
        set(14, moi);
        set(15, subnetwork);
        set(16, meid);
        set(17, gbssfunction);
        set(18, gbtssitemanager);
        set(19, userlabel);
        set(20, description);
        set(21, masterpwctrlgnode);
        set(22, refgbtsequipment);
        set(23, cfgpagingrepsupport);
        set(24, subcellho);
        set(25, supnewabispsmsg);
        set(26, bwrestorelimit);
        set(27, frtohrbwlimit);
        set(28, minaccessabisthse1);
        set(29, minaccessabisthsip);
        set(30, btsmasterpwctrlop);
        set(31, masterpwrofftime);
        set(32, trxofftime);
        set(33, trxoffpercent);
        set(34, benchmarksite);
        set(35, longitude);
        set(36, latitude);
        set(37, ztebtsRemark);
        set(38, gsitebasebandshare);
        set(39, bbrequesttraths);
        set(40, bbreleasetraths);
        set(41, bboverths);
        set(42, bblowerths);
        set(43, extprop1);
        set(44, extprop2);
    }
}
/*
 * This file is generated by jOOQ.
*/
package id.mit.chrono.server.model.tables.records;


import id.mit.chrono.server.model.tables.ZtebscextgcellX;

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
public class ZtebscextgcellXRecord extends UpdatableRecordImpl<ZtebscextgcellXRecord> {

    private static final long serialVersionUID = 1190037282;

    /**
     * Setter for <code>chrono.ztebscextgcell_x.ztebscextgcell_id</code>.
     */
    public void setZtebscextgcellId(ULong value) {
        set(0, value);
    }

    /**
     * Getter for <code>chrono.ztebscextgcell_x.ztebscextgcell_id</code>.
     */
    public ULong getZtebscextgcellId() {
        return (ULong) get(0);
    }

    /**
     * Setter for <code>chrono.ztebscextgcell_x.ztebscextgcell_crcollectortaskfiles</code>.
     */
    public void setZtebscextgcellCrcollectortaskfiles(ULong value) {
        set(1, value);
    }

    /**
     * Getter for <code>chrono.ztebscextgcell_x.ztebscextgcell_crcollectortaskfiles</code>.
     */
    public ULong getZtebscextgcellCrcollectortaskfiles() {
        return (ULong) get(1);
    }

    /**
     * Setter for <code>chrono.ztebscextgcell_x.ztebscextgcell_crprocessortaskfiles</code>.
     */
    public void setZtebscextgcellCrprocessortaskfiles(Long value) {
        set(2, value);
    }

    /**
     * Getter for <code>chrono.ztebscextgcell_x.ztebscextgcell_crprocessortaskfiles</code>.
     */
    public Long getZtebscextgcellCrprocessortaskfiles() {
        return (Long) get(2);
    }

    /**
     * Setter for <code>chrono.ztebscextgcell_x.ztegcell_date</code>.
     */
    public void setZtegcellDate(UInteger value) {
        set(3, value);
    }

    /**
     * Getter for <code>chrono.ztebscextgcell_x.ztegcell_date</code>.
     */
    public UInteger getZtegcellDate() {
        return (UInteger) get(3);
    }

    /**
     * Setter for <code>chrono.ztebscextgcell_x.ztebscextgcell_datefrom</code>.
     */
    public void setZtebscextgcellDatefrom(UInteger value) {
        set(4, value);
    }

    /**
     * Getter for <code>chrono.ztebscextgcell_x.ztebscextgcell_datefrom</code>.
     */
    public UInteger getZtebscextgcellDatefrom() {
        return (UInteger) get(4);
    }

    /**
     * Setter for <code>chrono.ztebscextgcell_x.ztebscextgcell_ztebsc</code>.
     */
    public void setZtebscextgcellZtebsc(ULong value) {
        set(5, value);
    }

    /**
     * Getter for <code>chrono.ztebscextgcell_x.ztebscextgcell_ztebsc</code>.
     */
    public ULong getZtebscextgcellZtebsc() {
        return (ULong) get(5);
    }

    /**
     * Setter for <code>chrono.ztebscextgcell_x.ztebscextgcell_ztebts</code>.
     */
    public void setZtebscextgcellZtebts(ULong value) {
        set(6, value);
    }

    /**
     * Getter for <code>chrono.ztebscextgcell_x.ztebscextgcell_ztebts</code>.
     */
    public ULong getZtebscextgcellZtebts() {
        return (ULong) get(6);
    }

    /**
     * Setter for <code>chrono.ztebscextgcell_x.ztebscextgcell_nodealias</code>.
     */
    public void setZtebscextgcellNodealias(Integer value) {
        set(7, value);
    }

    /**
     * Getter for <code>chrono.ztebscextgcell_x.ztebscextgcell_nodealias</code>.
     */
    public Integer getZtebscextgcellNodealias() {
        return (Integer) get(7);
    }

    /**
     * Setter for <code>chrono.ztebscextgcell_x.ztebscextgcell_cell</code>.
     */
    public void setZtebscextgcellCell(Integer value) {
        set(8, value);
    }

    /**
     * Getter for <code>chrono.ztebscextgcell_x.ztebscextgcell_cell</code>.
     */
    public Integer getZtebscextgcellCell() {
        return (Integer) get(8);
    }

    /**
     * Setter for <code>chrono.ztebscextgcell_x.ztebscextgcell_cellclass</code>.
     */
    public void setZtebscextgcellCellclass(Integer value) {
        set(9, value);
    }

    /**
     * Getter for <code>chrono.ztebscextgcell_x.ztebscextgcell_cellclass</code>.
     */
    public Integer getZtebscextgcellCellclass() {
        return (Integer) get(9);
    }

    /**
     * Setter for <code>chrono.ztebscextgcell_x.ztebscextgcell_cellclassgroup</code>.
     */
    public void setZtebscextgcellCellclassgroup(Integer value) {
        set(10, value);
    }

    /**
     * Getter for <code>chrono.ztebscextgcell_x.ztebscextgcell_cellclassgroup</code>.
     */
    public Integer getZtebscextgcellCellclassgroup() {
        return (Integer) get(10);
    }

    /**
     * Setter for <code>chrono.ztebscextgcell_x.ztebscextgcell_cellcoverage</code>.
     */
    public void setZtebscextgcellCellcoverage(Integer value) {
        set(11, value);
    }

    /**
     * Getter for <code>chrono.ztebscextgcell_x.ztebscextgcell_cellcoverage</code>.
     */
    public Integer getZtebscextgcellCellcoverage() {
        return (Integer) get(11);
    }

    /**
     * Setter for <code>chrono.ztebscextgcell_x.ztebscextgcell_revenueclass</code>.
     */
    public void setZtebscextgcellRevenueclass(Integer value) {
        set(12, value);
    }

    /**
     * Getter for <code>chrono.ztebscextgcell_x.ztebscextgcell_revenueclass</code>.
     */
    public Integer getZtebscextgcellRevenueclass() {
        return (Integer) get(12);
    }

    /**
     * Setter for <code>chrono.ztebscextgcell_x.ztebscextgcell_cellstatus</code>.
     */
    public void setZtebscextgcellCellstatus(Integer value) {
        set(13, value);
    }

    /**
     * Getter for <code>chrono.ztebscextgcell_x.ztebscextgcell_cellstatus</code>.
     */
    public Integer getZtebscextgcellCellstatus() {
        return (Integer) get(13);
    }

    /**
     * Setter for <code>chrono.ztebscextgcell_x.ztebscextgcell_vendor</code>.
     */
    public void setZtebscextgcellVendor(Integer value) {
        set(14, value);
    }

    /**
     * Getter for <code>chrono.ztebscextgcell_x.ztebscextgcell_vendor</code>.
     */
    public Integer getZtebscextgcellVendor() {
        return (Integer) get(14);
    }

    /**
     * Setter for <code>chrono.ztebscextgcell_x.ztebscextgcell_latitude</code>.
     */
    public void setZtebscextgcellLatitude(Double value) {
        set(15, value);
    }

    /**
     * Getter for <code>chrono.ztebscextgcell_x.ztebscextgcell_latitude</code>.
     */
    public Double getZtebscextgcellLatitude() {
        return (Double) get(15);
    }

    /**
     * Setter for <code>chrono.ztebscextgcell_x.ztebscextgcell_longitude</code>.
     */
    public void setZtebscextgcellLongitude(Double value) {
        set(16, value);
    }

    /**
     * Getter for <code>chrono.ztebscextgcell_x.ztebscextgcell_longitude</code>.
     */
    public Double getZtebscextgcellLongitude() {
        return (Double) get(16);
    }

    /**
     * Setter for <code>chrono.ztebscextgcell_x.ztebscextgcell_namingvalid</code>.
     */
    public void setZtebscextgcellNamingvalid(Byte value) {
        set(17, value);
    }

    /**
     * Getter for <code>chrono.ztebscextgcell_x.ztebscextgcell_namingvalid</code>.
     */
    public Byte getZtebscextgcellNamingvalid() {
        return (Byte) get(17);
    }

    /**
     * Setter for <code>chrono.ztebscextgcell_x.TOTALTRX</code>.
     */
    public void setTotaltrx(Integer value) {
        set(18, value);
    }

    /**
     * Getter for <code>chrono.ztebscextgcell_x.TOTALTRX</code>.
     */
    public Integer getTotaltrx() {
        return (Integer) get(18);
    }

    /**
     * Setter for <code>chrono.ztebscextgcell_x.MOI</code>.
     */
    public void setMoi(String value) {
        set(19, value);
    }

    /**
     * Getter for <code>chrono.ztebscextgcell_x.MOI</code>.
     */
    public String getMoi() {
        return (String) get(19);
    }

    /**
     * Setter for <code>chrono.ztebscextgcell_x.SubNetwork</code>.
     */
    public void setSubnetwork(String value) {
        set(20, value);
    }

    /**
     * Getter for <code>chrono.ztebscextgcell_x.SubNetwork</code>.
     */
    public String getSubnetwork() {
        return (String) get(20);
    }

    /**
     * Setter for <code>chrono.ztebscextgcell_x.MEID</code>.
     */
    public void setMeid(String value) {
        set(21, value);
    }

    /**
     * Getter for <code>chrono.ztebscextgcell_x.MEID</code>.
     */
    public String getMeid() {
        return (String) get(21);
    }

    /**
     * Setter for <code>chrono.ztebscextgcell_x.GBssFunction</code>.
     */
    public void setGbssfunction(String value) {
        set(22, value);
    }

    /**
     * Getter for <code>chrono.ztebscextgcell_x.GBssFunction</code>.
     */
    public String getGbssfunction() {
        return (String) get(22);
    }

    /**
     * Setter for <code>chrono.ztebscextgcell_x.GBtsSiteManager</code>.
     */
    public void setGbtssitemanager(String value) {
        set(23, value);
    }

    /**
     * Getter for <code>chrono.ztebscextgcell_x.GBtsSiteManager</code>.
     */
    public String getGbtssitemanager() {
        return (String) get(23);
    }

    /**
     * Setter for <code>chrono.ztebscextgcell_x.GGsmCell</code>.
     */
    public void setGgsmcell(String value) {
        set(24, value);
    }

    /**
     * Getter for <code>chrono.ztebscextgcell_x.GGsmCell</code>.
     */
    public String getGgsmcell() {
        return (String) get(24);
    }

    /**
     * Setter for <code>chrono.ztebscextgcell_x.userLabel</code>.
     */
    public void setUserlabel(String value) {
        set(25, value);
    }

    /**
     * Getter for <code>chrono.ztebscextgcell_x.userLabel</code>.
     */
    public String getUserlabel() {
        return (String) get(25);
    }

    /**
     * Setter for <code>chrono.ztebscextgcell_x.description</code>.
     */
    public void setDescription(String value) {
        set(26, value);
    }

    /**
     * Getter for <code>chrono.ztebscextgcell_x.description</code>.
     */
    public String getDescription() {
        return (String) get(26);
    }

    /**
     * Setter for <code>chrono.ztebscextgcell_x.cellIdentity</code>.
     */
    public void setCellidentity(String value) {
        set(27, value);
    }

    /**
     * Getter for <code>chrono.ztebscextgcell_x.cellIdentity</code>.
     */
    public String getCellidentity() {
        return (String) get(27);
    }

    /**
     * Setter for <code>chrono.ztebscextgcell_x.ncc</code>.
     */
    public void setNcc(String value) {
        set(28, value);
    }

    /**
     * Getter for <code>chrono.ztebscextgcell_x.ncc</code>.
     */
    public String getNcc() {
        return (String) get(28);
    }

    /**
     * Setter for <code>chrono.ztebscextgcell_x.bcc</code>.
     */
    public void setBcc(String value) {
        set(29, value);
    }

    /**
     * Getter for <code>chrono.ztebscextgcell_x.bcc</code>.
     */
    public String getBcc() {
        return (String) get(29);
    }

    /**
     * Setter for <code>chrono.ztebscextgcell_x.lac</code>.
     */
    public void setLac(String value) {
        set(30, value);
    }

    /**
     * Getter for <code>chrono.ztebscextgcell_x.lac</code>.
     */
    public String getLac() {
        return (String) get(30);
    }

    /**
     * Setter for <code>chrono.ztebscextgcell_x.refGLocationArea</code>.
     */
    public void setRefglocationarea(String value) {
        set(31, value);
    }

    /**
     * Getter for <code>chrono.ztebscextgcell_x.refGLocationArea</code>.
     */
    public String getRefglocationarea() {
        return (String) get(31);
    }

    /**
     * Setter for <code>chrono.ztebscextgcell_x.GGsmCellSeq</code>.
     */
    public void setGgsmcellseq(String value) {
        set(32, value);
    }

    /**
     * Getter for <code>chrono.ztebscextgcell_x.GGsmCellSeq</code>.
     */
    public String getGgsmcellseq() {
        return (String) get(32);
    }

    /**
     * Setter for <code>chrono.ztebscextgcell_x.bcchFrequency</code>.
     */
    public void setBcchfrequency(String value) {
        set(33, value);
    }

    /**
     * Getter for <code>chrono.ztebscextgcell_x.bcchFrequency</code>.
     */
    public String getBcchfrequency() {
        return (String) get(33);
    }

    /**
     * Setter for <code>chrono.ztebscextgcell_x.CcchConf</code>.
     */
    public void setCcchconf(String value) {
        set(34, value);
    }

    /**
     * Getter for <code>chrono.ztebscextgcell_x.CcchConf</code>.
     */
    public String getCcchconf() {
        return (String) get(34);
    }

    /**
     * Setter for <code>chrono.ztebscextgcell_x.PsSupport</code>.
     */
    public void setPssupport(String value) {
        set(35, value);
    }

    /**
     * Getter for <code>chrono.ztebscextgcell_x.PsSupport</code>.
     */
    public String getPssupport() {
        return (String) get(35);
    }

    /**
     * Setter for <code>chrono.ztebscextgcell_x.refGRoutingArea</code>.
     */
    public void setRefgroutingarea(String value) {
        set(36, value);
    }

    /**
     * Getter for <code>chrono.ztebscextgcell_x.refGRoutingArea</code>.
     */
    public String getRefgroutingarea() {
        return (String) get(36);
    }

    /**
     * Setter for <code>chrono.ztebscextgcell_x.GCellPs</code>.
     */
    public void setGcellps(String value) {
        set(37, value);
    }

    /**
     * Getter for <code>chrono.ztebscextgcell_x.GCellPs</code>.
     */
    public String getGcellps() {
        return (String) get(37);
    }

    /**
     * Setter for <code>chrono.ztebscextgcell_x.GCellEdge</code>.
     */
    public void setGcelledge(String value) {
        set(38, value);
    }

    /**
     * Getter for <code>chrono.ztebscextgcell_x.GCellEdge</code>.
     */
    public String getGcelledge() {
        return (String) get(38);
    }

    /**
     * Setter for <code>chrono.ztebscextgcell_x.mcc</code>.
     */
    public void setMcc(String value) {
        set(39, value);
    }

    /**
     * Getter for <code>chrono.ztebscextgcell_x.mcc</code>.
     */
    public String getMcc() {
        return (String) get(39);
    }

    /**
     * Setter for <code>chrono.ztebscextgcell_x.mnc</code>.
     */
    public void setMnc(String value) {
        set(40, value);
    }

    /**
     * Getter for <code>chrono.ztebscextgcell_x.mnc</code>.
     */
    public String getMnc() {
        return (String) get(40);
    }

    /**
     * Setter for <code>chrono.ztebscextgcell_x.cgi</code>.
     */
    public void setCgi(String value) {
        set(41, value);
    }

    /**
     * Getter for <code>chrono.ztebscextgcell_x.cgi</code>.
     */
    public String getCgi() {
        return (String) get(41);
    }

    /**
     * Setter for <code>chrono.ztebscextgcell_x.freqBand</code>.
     */
    public void setFreqband(String value) {
        set(42, value);
    }

    /**
     * Getter for <code>chrono.ztebscextgcell_x.freqBand</code>.
     */
    public String getFreqband() {
        return (String) get(42);
    }

    /**
     * Setter for <code>chrono.ztebscextgcell_x.FREQ1</code>.
     */
    public void setFreq1(String value) {
        set(43, value);
    }

    /**
     * Getter for <code>chrono.ztebscextgcell_x.FREQ1</code>.
     */
    public String getFreq1() {
        return (String) get(43);
    }

    /**
     * Setter for <code>chrono.ztebscextgcell_x.FREQ2</code>.
     */
    public void setFreq2(String value) {
        set(44, value);
    }

    /**
     * Getter for <code>chrono.ztebscextgcell_x.FREQ2</code>.
     */
    public String getFreq2() {
        return (String) get(44);
    }

    /**
     * Setter for <code>chrono.ztebscextgcell_x.FREQ3</code>.
     */
    public void setFreq3(String value) {
        set(45, value);
    }

    /**
     * Getter for <code>chrono.ztebscextgcell_x.FREQ3</code>.
     */
    public String getFreq3() {
        return (String) get(45);
    }

    /**
     * Setter for <code>chrono.ztebscextgcell_x.FREQ4</code>.
     */
    public void setFreq4(String value) {
        set(46, value);
    }

    /**
     * Getter for <code>chrono.ztebscextgcell_x.FREQ4</code>.
     */
    public String getFreq4() {
        return (String) get(46);
    }

    /**
     * Setter for <code>chrono.ztebscextgcell_x.FREQ5</code>.
     */
    public void setFreq5(String value) {
        set(47, value);
    }

    /**
     * Getter for <code>chrono.ztebscextgcell_x.FREQ5</code>.
     */
    public String getFreq5() {
        return (String) get(47);
    }

    /**
     * Setter for <code>chrono.ztebscextgcell_x.FREQ6</code>.
     */
    public void setFreq6(String value) {
        set(48, value);
    }

    /**
     * Getter for <code>chrono.ztebscextgcell_x.FREQ6</code>.
     */
    public String getFreq6() {
        return (String) get(48);
    }

    /**
     * Setter for <code>chrono.ztebscextgcell_x.FREQ7</code>.
     */
    public void setFreq7(String value) {
        set(49, value);
    }

    /**
     * Getter for <code>chrono.ztebscextgcell_x.FREQ7</code>.
     */
    public String getFreq7() {
        return (String) get(49);
    }

    /**
     * Setter for <code>chrono.ztebscextgcell_x.FREQ8</code>.
     */
    public void setFreq8(String value) {
        set(50, value);
    }

    /**
     * Getter for <code>chrono.ztebscextgcell_x.FREQ8</code>.
     */
    public String getFreq8() {
        return (String) get(50);
    }

    /**
     * Setter for <code>chrono.ztebscextgcell_x.FREQ9</code>.
     */
    public void setFreq9(String value) {
        set(51, value);
    }

    /**
     * Getter for <code>chrono.ztebscextgcell_x.FREQ9</code>.
     */
    public String getFreq9() {
        return (String) get(51);
    }

    /**
     * Setter for <code>chrono.ztebscextgcell_x.FREQ10</code>.
     */
    public void setFreq10(String value) {
        set(52, value);
    }

    /**
     * Getter for <code>chrono.ztebscextgcell_x.FREQ10</code>.
     */
    public String getFreq10() {
        return (String) get(52);
    }

    /**
     * Setter for <code>chrono.ztebscextgcell_x.FREQ11</code>.
     */
    public void setFreq11(String value) {
        set(53, value);
    }

    /**
     * Getter for <code>chrono.ztebscextgcell_x.FREQ11</code>.
     */
    public String getFreq11() {
        return (String) get(53);
    }

    /**
     * Setter for <code>chrono.ztebscextgcell_x.FREQ12</code>.
     */
    public void setFreq12(String value) {
        set(54, value);
    }

    /**
     * Getter for <code>chrono.ztebscextgcell_x.FREQ12</code>.
     */
    public String getFreq12() {
        return (String) get(54);
    }

    /**
     * Setter for <code>chrono.ztebscextgcell_x.FREQ13</code>.
     */
    public void setFreq13(String value) {
        set(55, value);
    }

    /**
     * Getter for <code>chrono.ztebscextgcell_x.FREQ13</code>.
     */
    public String getFreq13() {
        return (String) get(55);
    }

    /**
     * Setter for <code>chrono.ztebscextgcell_x.FREQ14</code>.
     */
    public void setFreq14(String value) {
        set(56, value);
    }

    /**
     * Getter for <code>chrono.ztebscextgcell_x.FREQ14</code>.
     */
    public String getFreq14() {
        return (String) get(56);
    }

    /**
     * Setter for <code>chrono.ztebscextgcell_x.FREQ15</code>.
     */
    public void setFreq15(String value) {
        set(57, value);
    }

    /**
     * Getter for <code>chrono.ztebscextgcell_x.FREQ15</code>.
     */
    public String getFreq15() {
        return (String) get(57);
    }

    /**
     * Setter for <code>chrono.ztebscextgcell_x.FREQ16</code>.
     */
    public void setFreq16(String value) {
        set(58, value);
    }

    /**
     * Getter for <code>chrono.ztebscextgcell_x.FREQ16</code>.
     */
    public String getFreq16() {
        return (String) get(58);
    }

    /**
     * Setter for <code>chrono.ztebscextgcell_x.FREQ17</code>.
     */
    public void setFreq17(String value) {
        set(59, value);
    }

    /**
     * Getter for <code>chrono.ztebscextgcell_x.FREQ17</code>.
     */
    public String getFreq17() {
        return (String) get(59);
    }

    /**
     * Setter for <code>chrono.ztebscextgcell_x.FREQ18</code>.
     */
    public void setFreq18(String value) {
        set(60, value);
    }

    /**
     * Getter for <code>chrono.ztebscextgcell_x.FREQ18</code>.
     */
    public String getFreq18() {
        return (String) get(60);
    }

    /**
     * Setter for <code>chrono.ztebscextgcell_x.FREQ19</code>.
     */
    public void setFreq19(String value) {
        set(61, value);
    }

    /**
     * Getter for <code>chrono.ztebscextgcell_x.FREQ19</code>.
     */
    public String getFreq19() {
        return (String) get(61);
    }

    /**
     * Setter for <code>chrono.ztebscextgcell_x.FREQ20</code>.
     */
    public void setFreq20(String value) {
        set(62, value);
    }

    /**
     * Getter for <code>chrono.ztebscextgcell_x.FREQ20</code>.
     */
    public String getFreq20() {
        return (String) get(62);
    }

    /**
     * Setter for <code>chrono.ztebscextgcell_x.FREQ21</code>.
     */
    public void setFreq21(String value) {
        set(63, value);
    }

    /**
     * Getter for <code>chrono.ztebscextgcell_x.FREQ21</code>.
     */
    public String getFreq21() {
        return (String) get(63);
    }

    /**
     * Setter for <code>chrono.ztebscextgcell_x.FREQ22</code>.
     */
    public void setFreq22(String value) {
        set(64, value);
    }

    /**
     * Getter for <code>chrono.ztebscextgcell_x.FREQ22</code>.
     */
    public String getFreq22() {
        return (String) get(64);
    }

    /**
     * Setter for <code>chrono.ztebscextgcell_x.FREQ23</code>.
     */
    public void setFreq23(String value) {
        set(65, value);
    }

    /**
     * Getter for <code>chrono.ztebscextgcell_x.FREQ23</code>.
     */
    public String getFreq23() {
        return (String) get(65);
    }

    /**
     * Setter for <code>chrono.ztebscextgcell_x.FREQ24</code>.
     */
    public void setFreq24(String value) {
        set(66, value);
    }

    /**
     * Getter for <code>chrono.ztebscextgcell_x.FREQ24</code>.
     */
    public String getFreq24() {
        return (String) get(66);
    }

    /**
     * Setter for <code>chrono.ztebscextgcell_x.Latitude</code>.
     */
    public void setLatitude(Double value) {
        set(67, value);
    }

    /**
     * Getter for <code>chrono.ztebscextgcell_x.Latitude</code>.
     */
    public Double getLatitude() {
        return (Double) get(67);
    }

    /**
     * Setter for <code>chrono.ztebscextgcell_x.Longitude</code>.
     */
    public void setLongitude(Double value) {
        set(68, value);
    }

    /**
     * Getter for <code>chrono.ztebscextgcell_x.Longitude</code>.
     */
    public Double getLongitude() {
        return (Double) get(68);
    }

    /**
     * Setter for <code>chrono.ztebscextgcell_x.altitude</code>.
     */
    public void setAltitude(String value) {
        set(69, value);
    }

    /**
     * Getter for <code>chrono.ztebscextgcell_x.altitude</code>.
     */
    public String getAltitude() {
        return (String) get(69);
    }

    /**
     * Setter for <code>chrono.ztebscextgcell_x.offsetAngle</code>.
     */
    public void setOffsetangle(String value) {
        set(70, value);
    }

    /**
     * Getter for <code>chrono.ztebscextgcell_x.offsetAngle</code>.
     */
    public String getOffsetangle() {
        return (String) get(70);
    }

    /**
     * Setter for <code>chrono.ztebscextgcell_x.address</code>.
     */
    public void setAddress(String value) {
        set(71, value);
    }

    /**
     * Getter for <code>chrono.ztebscextgcell_x.address</code>.
     */
    public String getAddress() {
        return (String) get(71);
    }

    /**
     * Setter for <code>chrono.ztebscextgcell_x.ztegcell_remark</code>.
     */
    public void setZtegcellRemark(String value) {
        set(72, value);
    }

    /**
     * Getter for <code>chrono.ztebscextgcell_x.ztegcell_remark</code>.
     */
    public String getZtegcellRemark() {
        return (String) get(72);
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
     * Create a detached ZtebscextgcellXRecord
     */
    public ZtebscextgcellXRecord() {
        super(ZtebscextgcellX.ZTEBSCEXTGCELL_X);
    }

    /**
     * Create a detached, initialised ZtebscextgcellXRecord
     */
    public ZtebscextgcellXRecord(ULong ztebscextgcellId, ULong ztebscextgcellCrcollectortaskfiles, Long ztebscextgcellCrprocessortaskfiles, UInteger ztegcellDate, UInteger ztebscextgcellDatefrom, ULong ztebscextgcellZtebsc, ULong ztebscextgcellZtebts, Integer ztebscextgcellNodealias, Integer ztebscextgcellCell, Integer ztebscextgcellCellclass, Integer ztebscextgcellCellclassgroup, Integer ztebscextgcellCellcoverage, Integer ztebscextgcellRevenueclass, Integer ztebscextgcellCellstatus, Integer ztebscextgcellVendor, Double ztebscextgcellLatitude, Double ztebscextgcellLongitude, Byte ztebscextgcellNamingvalid, Integer totaltrx, String moi, String subnetwork, String meid, String gbssfunction, String gbtssitemanager, String ggsmcell, String userlabel, String description, String cellidentity, String ncc, String bcc, String lac, String refglocationarea, String ggsmcellseq, String bcchfrequency, String ccchconf, String pssupport, String refgroutingarea, String gcellps, String gcelledge, String mcc, String mnc, String cgi, String freqband, String freq1, String freq2, String freq3, String freq4, String freq5, String freq6, String freq7, String freq8, String freq9, String freq10, String freq11, String freq12, String freq13, String freq14, String freq15, String freq16, String freq17, String freq18, String freq19, String freq20, String freq21, String freq22, String freq23, String freq24, Double latitude, Double longitude, String altitude, String offsetangle, String address, String ztegcellRemark) {
        super(ZtebscextgcellX.ZTEBSCEXTGCELL_X);

        set(0, ztebscextgcellId);
        set(1, ztebscextgcellCrcollectortaskfiles);
        set(2, ztebscextgcellCrprocessortaskfiles);
        set(3, ztegcellDate);
        set(4, ztebscextgcellDatefrom);
        set(5, ztebscextgcellZtebsc);
        set(6, ztebscextgcellZtebts);
        set(7, ztebscextgcellNodealias);
        set(8, ztebscextgcellCell);
        set(9, ztebscextgcellCellclass);
        set(10, ztebscextgcellCellclassgroup);
        set(11, ztebscextgcellCellcoverage);
        set(12, ztebscextgcellRevenueclass);
        set(13, ztebscextgcellCellstatus);
        set(14, ztebscextgcellVendor);
        set(15, ztebscextgcellLatitude);
        set(16, ztebscextgcellLongitude);
        set(17, ztebscextgcellNamingvalid);
        set(18, totaltrx);
        set(19, moi);
        set(20, subnetwork);
        set(21, meid);
        set(22, gbssfunction);
        set(23, gbtssitemanager);
        set(24, ggsmcell);
        set(25, userlabel);
        set(26, description);
        set(27, cellidentity);
        set(28, ncc);
        set(29, bcc);
        set(30, lac);
        set(31, refglocationarea);
        set(32, ggsmcellseq);
        set(33, bcchfrequency);
        set(34, ccchconf);
        set(35, pssupport);
        set(36, refgroutingarea);
        set(37, gcellps);
        set(38, gcelledge);
        set(39, mcc);
        set(40, mnc);
        set(41, cgi);
        set(42, freqband);
        set(43, freq1);
        set(44, freq2);
        set(45, freq3);
        set(46, freq4);
        set(47, freq5);
        set(48, freq6);
        set(49, freq7);
        set(50, freq8);
        set(51, freq9);
        set(52, freq10);
        set(53, freq11);
        set(54, freq12);
        set(55, freq13);
        set(56, freq14);
        set(57, freq15);
        set(58, freq16);
        set(59, freq17);
        set(60, freq18);
        set(61, freq19);
        set(62, freq20);
        set(63, freq21);
        set(64, freq22);
        set(65, freq23);
        set(66, freq24);
        set(67, latitude);
        set(68, longitude);
        set(69, altitude);
        set(70, offsetangle);
        set(71, address);
        set(72, ztegcellRemark);
    }
}
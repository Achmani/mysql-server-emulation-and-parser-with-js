/*
 * This file is generated by jOOQ.
*/
package id.mit.chrono.server.model.tables.records;


import id.mit.chrono.server.model.tables.MTempsysinfo3g;

import javax.annotation.Generated;

import org.jooq.Record1;
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
public class MTempsysinfo3gRecord extends UpdatableRecordImpl<MTempsysinfo3gRecord> {

    private static final long serialVersionUID = -1851031310;

    /**
     * Setter for <code>chrono.m_tempsysinfo3G.tempsysinfo3G_id</code>.
     */
    public void setTempsysinfo3gId(Long value) {
        set(0, value);
    }

    /**
     * Getter for <code>chrono.m_tempsysinfo3G.tempsysinfo3G_id</code>.
     */
    public Long getTempsysinfo3gId() {
        return (Long) get(0);
    }

    /**
     * Setter for <code>chrono.m_tempsysinfo3G.region</code>.
     */
    public void setRegion(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>chrono.m_tempsysinfo3G.region</code>.
     */
    public String getRegion() {
        return (String) get(1);
    }

    /**
     * Setter for <code>chrono.m_tempsysinfo3G.vendor</code>.
     */
    public void setVendor(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>chrono.m_tempsysinfo3G.vendor</code>.
     */
    public String getVendor() {
        return (String) get(2);
    }

    /**
     * Setter for <code>chrono.m_tempsysinfo3G.site_id</code>.
     */
    public void setSiteId(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>chrono.m_tempsysinfo3G.site_id</code>.
     */
    public String getSiteId() {
        return (String) get(3);
    }

    /**
     * Setter for <code>chrono.m_tempsysinfo3G.ne_id</code>.
     */
    public void setNeId(String value) {
        set(4, value);
    }

    /**
     * Getter for <code>chrono.m_tempsysinfo3G.ne_id</code>.
     */
    public String getNeId() {
        return (String) get(4);
    }

    /**
     * Setter for <code>chrono.m_tempsysinfo3G.enodeb_name</code>.
     */
    public void setEnodebName(String value) {
        set(5, value);
    }

    /**
     * Getter for <code>chrono.m_tempsysinfo3G.enodeb_name</code>.
     */
    public String getEnodebName() {
        return (String) get(5);
    }

    /**
     * Setter for <code>chrono.m_tempsysinfo3G.cell_name</code>.
     */
    public void setCellName(String value) {
        set(6, value);
    }

    /**
     * Getter for <code>chrono.m_tempsysinfo3G.cell_name</code>.
     */
    public String getCellName() {
        return (String) get(6);
    }

    /**
     * Setter for <code>chrono.m_tempsysinfo3G.lac_enodeb_ci</code>.
     */
    public void setLacEnodebCi(String value) {
        set(7, value);
    }

    /**
     * Getter for <code>chrono.m_tempsysinfo3G.lac_enodeb_ci</code>.
     */
    public String getLacEnodebCi() {
        return (String) get(7);
    }

    /**
     * Setter for <code>chrono.m_tempsysinfo3G.siteid_ci</code>.
     */
    public void setSiteidCi(String value) {
        set(8, value);
    }

    /**
     * Getter for <code>chrono.m_tempsysinfo3G.siteid_ci</code>.
     */
    public String getSiteidCi() {
        return (String) get(8);
    }

    /**
     * Setter for <code>chrono.m_tempsysinfo3G.teknologi</code>.
     */
    public void setTeknologi(String value) {
        set(9, value);
    }

    /**
     * Getter for <code>chrono.m_tempsysinfo3G.teknologi</code>.
     */
    public String getTeknologi() {
        return (String) get(9);
    }

    /**
     * Setter for <code>chrono.m_tempsysinfo3G.lac_enodeb</code>.
     */
    public void setLacEnodeb(Integer value) {
        set(10, value);
    }

    /**
     * Getter for <code>chrono.m_tempsysinfo3G.lac_enodeb</code>.
     */
    public Integer getLacEnodeb() {
        return (Integer) get(10);
    }

    /**
     * Setter for <code>chrono.m_tempsysinfo3G.ci</code>.
     */
    public void setCi(Integer value) {
        set(11, value);
    }

    /**
     * Getter for <code>chrono.m_tempsysinfo3G.ci</code>.
     */
    public Integer getCi() {
        return (Integer) get(11);
    }

    /**
     * Setter for <code>chrono.m_tempsysinfo3G.sector</code>.
     */
    public void setSector(Integer value) {
        set(12, value);
    }

    /**
     * Getter for <code>chrono.m_tempsysinfo3G.sector</code>.
     */
    public Integer getSector() {
        return (Integer) get(12);
    }

    /**
     * Setter for <code>chrono.m_tempsysinfo3G.bts_type</code>.
     */
    public void setBtsType(String value) {
        set(13, value);
    }

    /**
     * Getter for <code>chrono.m_tempsysinfo3G.bts_type</code>.
     */
    public String getBtsType() {
        return (String) get(13);
    }

    /**
     * Setter for <code>chrono.m_tempsysinfo3G.band</code>.
     */
    public void setBand(String value) {
        set(14, value);
    }

    /**
     * Getter for <code>chrono.m_tempsysinfo3G.band</code>.
     */
    public String getBand() {
        return (String) get(14);
    }

    /**
     * Setter for <code>chrono.m_tempsysinfo3G.longitude_fix</code>.
     */
    public void setLongitudeFix(Double value) {
        set(15, value);
    }

    /**
     * Getter for <code>chrono.m_tempsysinfo3G.longitude_fix</code>.
     */
    public Double getLongitudeFix() {
        return (Double) get(15);
    }

    /**
     * Setter for <code>chrono.m_tempsysinfo3G.latitude_fix</code>.
     */
    public void setLatitudeFix(Double value) {
        set(16, value);
    }

    /**
     * Getter for <code>chrono.m_tempsysinfo3G.latitude_fix</code>.
     */
    public Double getLatitudeFix() {
        return (Double) get(16);
    }

    /**
     * Setter for <code>chrono.m_tempsysinfo3G.flag_on_air</code>.
     */
    public void setFlagOnAir(String value) {
        set(17, value);
    }

    /**
     * Getter for <code>chrono.m_tempsysinfo3G.flag_on_air</code>.
     */
    public String getFlagOnAir() {
        return (String) get(17);
    }

    /**
     * Setter for <code>chrono.m_tempsysinfo3G.azimuth</code>.
     */
    public void setAzimuth(Integer value) {
        set(18, value);
    }

    /**
     * Getter for <code>chrono.m_tempsysinfo3G.azimuth</code>.
     */
    public Integer getAzimuth() {
        return (Integer) get(18);
    }

    /**
     * Setter for <code>chrono.m_tempsysinfo3G.electrical_tilt</code>.
     */
    public void setElectricalTilt(Integer value) {
        set(19, value);
    }

    /**
     * Getter for <code>chrono.m_tempsysinfo3G.electrical_tilt</code>.
     */
    public Integer getElectricalTilt() {
        return (Integer) get(19);
    }

    /**
     * Setter for <code>chrono.m_tempsysinfo3G.mechanical_tilt</code>.
     */
    public void setMechanicalTilt(Integer value) {
        set(20, value);
    }

    /**
     * Getter for <code>chrono.m_tempsysinfo3G.mechanical_tilt</code>.
     */
    public Integer getMechanicalTilt() {
        return (Integer) get(20);
    }

    /**
     * Setter for <code>chrono.m_tempsysinfo3G.beamwidth_antenna</code>.
     */
    public void setBeamwidthAntenna(Integer value) {
        set(21, value);
    }

    /**
     * Getter for <code>chrono.m_tempsysinfo3G.beamwidth_antenna</code>.
     */
    public Integer getBeamwidthAntenna() {
        return (Integer) get(21);
    }

    /**
     * Setter for <code>chrono.m_tempsysinfo3G.antenna_height</code>.
     */
    public void setAntennaHeight(Integer value) {
        set(22, value);
    }

    /**
     * Getter for <code>chrono.m_tempsysinfo3G.antenna_height</code>.
     */
    public Integer getAntennaHeight() {
        return (Integer) get(22);
    }

    /**
     * Setter for <code>chrono.m_tempsysinfo3G.antenna_type</code>.
     */
    public void setAntennaType(String value) {
        set(23, value);
    }

    /**
     * Getter for <code>chrono.m_tempsysinfo3G.antenna_type</code>.
     */
    public String getAntennaType() {
        return (String) get(23);
    }

    /**
     * Setter for <code>chrono.m_tempsysinfo3G.ret_nonret</code>.
     */
    public void setRetNonret(String value) {
        set(24, value);
    }

    /**
     * Getter for <code>chrono.m_tempsysinfo3G.ret_nonret</code>.
     */
    public String getRetNonret() {
        return (String) get(24);
    }

    /**
     * Setter for <code>chrono.m_tempsysinfo3G.tac</code>.
     */
    public void setTac(Integer value) {
        set(25, value);
    }

    /**
     * Getter for <code>chrono.m_tempsysinfo3G.tac</code>.
     */
    public Integer getTac() {
        return (Integer) get(25);
    }

    /**
     * Setter for <code>chrono.m_tempsysinfo3G.bsc_rnc</code>.
     */
    public void setBscRnc(String value) {
        set(26, value);
    }

    /**
     * Getter for <code>chrono.m_tempsysinfo3G.bsc_rnc</code>.
     */
    public String getBscRnc() {
        return (String) get(26);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Record1<Long> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached MTempsysinfo3gRecord
     */
    public MTempsysinfo3gRecord() {
        super(MTempsysinfo3g.M_TEMPSYSINFO3G);
    }

    /**
     * Create a detached, initialised MTempsysinfo3gRecord
     */
    public MTempsysinfo3gRecord(Long tempsysinfo3gId, String region, String vendor, String siteId, String neId, String enodebName, String cellName, String lacEnodebCi, String siteidCi, String teknologi, Integer lacEnodeb, Integer ci, Integer sector, String btsType, String band, Double longitudeFix, Double latitudeFix, String flagOnAir, Integer azimuth, Integer electricalTilt, Integer mechanicalTilt, Integer beamwidthAntenna, Integer antennaHeight, String antennaType, String retNonret, Integer tac, String bscRnc) {
        super(MTempsysinfo3g.M_TEMPSYSINFO3G);

        set(0, tempsysinfo3gId);
        set(1, region);
        set(2, vendor);
        set(3, siteId);
        set(4, neId);
        set(5, enodebName);
        set(6, cellName);
        set(7, lacEnodebCi);
        set(8, siteidCi);
        set(9, teknologi);
        set(10, lacEnodeb);
        set(11, ci);
        set(12, sector);
        set(13, btsType);
        set(14, band);
        set(15, longitudeFix);
        set(16, latitudeFix);
        set(17, flagOnAir);
        set(18, azimuth);
        set(19, electricalTilt);
        set(20, mechanicalTilt);
        set(21, beamwidthAntenna);
        set(22, antennaHeight);
        set(23, antennaType);
        set(24, retNonret);
        set(25, tac);
        set(26, bscRnc);
    }
}

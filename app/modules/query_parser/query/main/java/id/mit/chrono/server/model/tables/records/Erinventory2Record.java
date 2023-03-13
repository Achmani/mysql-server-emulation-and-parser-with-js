/*
 * This file is generated by jOOQ.
*/
package id.mit.chrono.server.model.tables.records;


import id.mit.chrono.server.model.tables.Erinventory2;

import java.sql.Timestamp;

import javax.annotation.Generated;

import org.jooq.Record2;
import org.jooq.impl.UpdatableRecordImpl;
import org.jooq.types.UInteger;


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
public class Erinventory2Record extends UpdatableRecordImpl<Erinventory2Record> {

    private static final long serialVersionUID = 2072171821;

    /**
     * Setter for <code>chrono.erinventory2.erinventory_id</code>.
     */
    public void setErinventoryId(UInteger value) {
        set(0, value);
    }

    /**
     * Getter for <code>chrono.erinventory2.erinventory_id</code>.
     */
    public UInteger getErinventoryId() {
        return (UInteger) get(0);
    }

    /**
     * Setter for <code>chrono.erinventory2.erinventory_date</code>.
     */
    public void setErinventoryDate(Integer value) {
        set(1, value);
    }

    /**
     * Getter for <code>chrono.erinventory2.erinventory_date</code>.
     */
    public Integer getErinventoryDate() {
        return (Integer) get(1);
    }

    /**
     * Setter for <code>chrono.erinventory2.erinventory_datatype</code>.
     */
    public void setErinventoryDatatype(Integer value) {
        set(2, value);
    }

    /**
     * Getter for <code>chrono.erinventory2.erinventory_datatype</code>.
     */
    public Integer getErinventoryDatatype() {
        return (Integer) get(2);
    }

    /**
     * Setter for <code>chrono.erinventory2.erinventory_collectortaskfiles</code>.
     */
    public void setErinventoryCollectortaskfiles(Long value) {
        set(3, value);
    }

    /**
     * Getter for <code>chrono.erinventory2.erinventory_collectortaskfiles</code>.
     */
    public Long getErinventoryCollectortaskfiles() {
        return (Long) get(3);
    }

    /**
     * Setter for <code>chrono.erinventory2.erinventory_vendor</code>.
     */
    public void setErinventoryVendor(Integer value) {
        set(4, value);
    }

    /**
     * Getter for <code>chrono.erinventory2.erinventory_vendor</code>.
     */
    public Integer getErinventoryVendor() {
        return (Integer) get(4);
    }

    /**
     * Setter for <code>chrono.erinventory2.erinventory_site</code>.
     */
    public void setErinventorySite(Integer value) {
        set(5, value);
    }

    /**
     * Getter for <code>chrono.erinventory2.erinventory_site</code>.
     */
    public Integer getErinventorySite() {
        return (Integer) get(5);
    }

    /**
     * Setter for <code>chrono.erinventory2.erinventory_siteId</code>.
     */
    public void setErinventorySiteid(String value) {
        set(6, value);
    }

    /**
     * Getter for <code>chrono.erinventory2.erinventory_siteId</code>.
     */
    public String getErinventorySiteid() {
        return (String) get(6);
    }

    /**
     * Setter for <code>chrono.erinventory2.erinventory_subnetwork</code>.
     */
    public void setErinventorySubnetwork(String value) {
        set(7, value);
    }

    /**
     * Getter for <code>chrono.erinventory2.erinventory_subnetwork</code>.
     */
    public String getErinventorySubnetwork() {
        return (String) get(7);
    }

    /**
     * Setter for <code>chrono.erinventory2.erinventory_subnetwork2</code>.
     */
    public void setErinventorySubnetwork2(String value) {
        set(8, value);
    }

    /**
     * Getter for <code>chrono.erinventory2.erinventory_subnetwork2</code>.
     */
    public String getErinventorySubnetwork2() {
        return (String) get(8);
    }

    /**
     * Setter for <code>chrono.erinventory2.erinventory_bsc</code>.
     */
    public void setErinventoryBsc(String value) {
        set(9, value);
    }

    /**
     * Getter for <code>chrono.erinventory2.erinventory_bsc</code>.
     */
    public String getErinventoryBsc() {
        return (String) get(9);
    }

    /**
     * Setter for <code>chrono.erinventory2.erinventory_nename</code>.
     */
    public void setErinventoryNename(String value) {
        set(10, value);
    }

    /**
     * Getter for <code>chrono.erinventory2.erinventory_nename</code>.
     */
    public String getErinventoryNename() {
        return (String) get(10);
    }

    /**
     * Setter for <code>chrono.erinventory2.erinventory_ru1</code>.
     */
    public void setErinventoryRu1(String value) {
        set(11, value);
    }

    /**
     * Getter for <code>chrono.erinventory2.erinventory_ru1</code>.
     */
    public String getErinventoryRu1() {
        return (String) get(11);
    }

    /**
     * Setter for <code>chrono.erinventory2.erinventory_ru2</code>.
     */
    public void setErinventoryRu2(String value) {
        set(12, value);
    }

    /**
     * Getter for <code>chrono.erinventory2.erinventory_ru2</code>.
     */
    public String getErinventoryRu2() {
        return (String) get(12);
    }

    /**
     * Setter for <code>chrono.erinventory2.erinventory_productname</code>.
     */
    public void setErinventoryProductname(String value) {
        set(13, value);
    }

    /**
     * Getter for <code>chrono.erinventory2.erinventory_productname</code>.
     */
    public String getErinventoryProductname() {
        return (String) get(13);
    }

    /**
     * Setter for <code>chrono.erinventory2.erinventory_serialnumber</code>.
     */
    public void setErinventorySerialnumber(String value) {
        set(14, value);
    }

    /**
     * Getter for <code>chrono.erinventory2.erinventory_serialnumber</code>.
     */
    public String getErinventorySerialnumber() {
        return (String) get(14);
    }

    /**
     * Setter for <code>chrono.erinventory2.erinventory_bomcode</code>.
     */
    public void setErinventoryBomcode(String value) {
        set(15, value);
    }

    /**
     * Getter for <code>chrono.erinventory2.erinventory_bomcode</code>.
     */
    public String getErinventoryBomcode() {
        return (String) get(15);
    }

    /**
     * Setter for <code>chrono.erinventory2.erinventory_revisioncode</code>.
     */
    public void setErinventoryRevisioncode(String value) {
        set(16, value);
    }

    /**
     * Getter for <code>chrono.erinventory2.erinventory_revisioncode</code>.
     */
    public String getErinventoryRevisioncode() {
        return (String) get(16);
    }

    /**
     * Setter for <code>chrono.erinventory2.erinventory_locationinformation</code>.
     */
    public void setErinventoryLocationinformation(String value) {
        set(17, value);
    }

    /**
     * Getter for <code>chrono.erinventory2.erinventory_locationinformation</code>.
     */
    public String getErinventoryLocationinformation() {
        return (String) get(17);
    }

    /**
     * Setter for <code>chrono.erinventory2.erinventory_softwareversion</code>.
     */
    public void setErinventorySoftwareversion(String value) {
        set(18, value);
    }

    /**
     * Getter for <code>chrono.erinventory2.erinventory_softwareversion</code>.
     */
    public String getErinventorySoftwareversion() {
        return (String) get(18);
    }

    /**
     * Setter for <code>chrono.erinventory2.erinventory_managedobject</code>.
     */
    public void setErinventoryManagedobject(String value) {
        set(19, value);
    }

    /**
     * Getter for <code>chrono.erinventory2.erinventory_managedobject</code>.
     */
    public String getErinventoryManagedobject() {
        return (String) get(19);
    }

    /**
     * Setter for <code>chrono.erinventory2.erinventory_dateofmanufacture</code>.
     */
    public void setErinventoryDateofmanufacture(String value) {
        set(20, value);
    }

    /**
     * Getter for <code>chrono.erinventory2.erinventory_dateofmanufacture</code>.
     */
    public String getErinventoryDateofmanufacture() {
        return (String) get(20);
    }

    /**
     * Setter for <code>chrono.erinventory2.erinventory_isfirst</code>.
     */
    public void setErinventoryIsfirst(Integer value) {
        set(21, value);
    }

    /**
     * Getter for <code>chrono.erinventory2.erinventory_isfirst</code>.
     */
    public Integer getErinventoryIsfirst() {
        return (Integer) get(21);
    }

    /**
     * Setter for <code>chrono.erinventory2.erinventory_administrativestate</code>.
     */
    public void setErinventoryAdministrativestate(String value) {
        set(22, value);
    }

    /**
     * Getter for <code>chrono.erinventory2.erinventory_administrativestate</code>.
     */
    public String getErinventoryAdministrativestate() {
        return (String) get(22);
    }

    /**
     * Setter for <code>chrono.erinventory2.erinventory_operationalState</code>.
     */
    public void setErinventoryOperationalstate(String value) {
        set(23, value);
    }

    /**
     * Getter for <code>chrono.erinventory2.erinventory_operationalState</code>.
     */
    public String getErinventoryOperationalstate() {
        return (String) get(23);
    }

    /**
     * Setter for <code>chrono.erinventory2.erinventory_availabilitystatus</code>.
     */
    public void setErinventoryAvailabilitystatus(String value) {
        set(24, value);
    }

    /**
     * Getter for <code>chrono.erinventory2.erinventory_availabilitystatus</code>.
     */
    public String getErinventoryAvailabilitystatus() {
        return (String) get(24);
    }

    /**
     * Setter for <code>chrono.erinventory2.erinventory_productrevision</code>.
     */
    public void setErinventoryProductrevision(String value) {
        set(25, value);
    }

    /**
     * Getter for <code>chrono.erinventory2.erinventory_productrevision</code>.
     */
    public String getErinventoryProductrevision() {
        return (String) get(25);
    }

    /**
     * Setter for <code>chrono.erinventory2.erinventory_hwvendorname</code>.
     */
    public void setErinventoryHwvendorname(String value) {
        set(26, value);
    }

    /**
     * Getter for <code>chrono.erinventory2.erinventory_hwvendorname</code>.
     */
    public String getErinventoryHwvendorname() {
        return (String) get(26);
    }

    /**
     * Setter for <code>chrono.erinventory2.erinventory_position</code>.
     */
    public void setErinventoryPosition(String value) {
        set(27, value);
    }

    /**
     * Getter for <code>chrono.erinventory2.erinventory_position</code>.
     */
    public String getErinventoryPosition() {
        return (String) get(27);
    }

    /**
     * Setter for <code>chrono.erinventory2.erinventory_inserttime</code>.
     */
    public void setErinventoryInserttime(Timestamp value) {
        set(28, value);
    }

    /**
     * Getter for <code>chrono.erinventory2.erinventory_inserttime</code>.
     */
    public Timestamp getErinventoryInserttime() {
        return (Timestamp) get(28);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Record2<Integer, UInteger> key() {
        return (Record2) super.key();
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached Erinventory2Record
     */
    public Erinventory2Record() {
        super(Erinventory2.ERINVENTORY2);
    }

    /**
     * Create a detached, initialised Erinventory2Record
     */
    public Erinventory2Record(UInteger erinventoryId, Integer erinventoryDate, Integer erinventoryDatatype, Long erinventoryCollectortaskfiles, Integer erinventoryVendor, Integer erinventorySite, String erinventorySiteid, String erinventorySubnetwork, String erinventorySubnetwork2, String erinventoryBsc, String erinventoryNename, String erinventoryRu1, String erinventoryRu2, String erinventoryProductname, String erinventorySerialnumber, String erinventoryBomcode, String erinventoryRevisioncode, String erinventoryLocationinformation, String erinventorySoftwareversion, String erinventoryManagedobject, String erinventoryDateofmanufacture, Integer erinventoryIsfirst, String erinventoryAdministrativestate, String erinventoryOperationalstate, String erinventoryAvailabilitystatus, String erinventoryProductrevision, String erinventoryHwvendorname, String erinventoryPosition, Timestamp erinventoryInserttime) {
        super(Erinventory2.ERINVENTORY2);

        set(0, erinventoryId);
        set(1, erinventoryDate);
        set(2, erinventoryDatatype);
        set(3, erinventoryCollectortaskfiles);
        set(4, erinventoryVendor);
        set(5, erinventorySite);
        set(6, erinventorySiteid);
        set(7, erinventorySubnetwork);
        set(8, erinventorySubnetwork2);
        set(9, erinventoryBsc);
        set(10, erinventoryNename);
        set(11, erinventoryRu1);
        set(12, erinventoryRu2);
        set(13, erinventoryProductname);
        set(14, erinventorySerialnumber);
        set(15, erinventoryBomcode);
        set(16, erinventoryRevisioncode);
        set(17, erinventoryLocationinformation);
        set(18, erinventorySoftwareversion);
        set(19, erinventoryManagedobject);
        set(20, erinventoryDateofmanufacture);
        set(21, erinventoryIsfirst);
        set(22, erinventoryAdministrativestate);
        set(23, erinventoryOperationalstate);
        set(24, erinventoryAvailabilitystatus);
        set(25, erinventoryProductrevision);
        set(26, erinventoryHwvendorname);
        set(27, erinventoryPosition);
        set(28, erinventoryInserttime);
    }
}

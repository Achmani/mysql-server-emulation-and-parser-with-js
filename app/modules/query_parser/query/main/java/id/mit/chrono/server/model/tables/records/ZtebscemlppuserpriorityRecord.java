/*
 * This file is generated by jOOQ.
*/
package id.mit.chrono.server.model.tables.records;


import id.mit.chrono.server.model.tables.Ztebscemlppuserpriority;

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
public class ZtebscemlppuserpriorityRecord extends UpdatableRecordImpl<ZtebscemlppuserpriorityRecord> {

    private static final long serialVersionUID = 1523092775;

    /**
     * Setter for <code>chrono.ztebscemlppuserpriority.ztebscemlppuserpriority_id</code>.
     */
    public void setZtebscemlppuserpriorityId(ULong value) {
        set(0, value);
    }

    /**
     * Getter for <code>chrono.ztebscemlppuserpriority.ztebscemlppuserpriority_id</code>.
     */
    public ULong getZtebscemlppuserpriorityId() {
        return (ULong) get(0);
    }

    /**
     * Setter for <code>chrono.ztebscemlppuserpriority.ztebscemlppuserpriority_crcollectortaskfiles</code>.
     */
    public void setZtebscemlppuserpriorityCrcollectortaskfiles(ULong value) {
        set(1, value);
    }

    /**
     * Getter for <code>chrono.ztebscemlppuserpriority.ztebscemlppuserpriority_crcollectortaskfiles</code>.
     */
    public ULong getZtebscemlppuserpriorityCrcollectortaskfiles() {
        return (ULong) get(1);
    }

    /**
     * Setter for <code>chrono.ztebscemlppuserpriority.ztebscemlppuserpriority_date</code>.
     */
    public void setZtebscemlppuserpriorityDate(UInteger value) {
        set(2, value);
    }

    /**
     * Getter for <code>chrono.ztebscemlppuserpriority.ztebscemlppuserpriority_date</code>.
     */
    public UInteger getZtebscemlppuserpriorityDate() {
        return (UInteger) get(2);
    }

    /**
     * Setter for <code>chrono.ztebscemlppuserpriority.ztebscemlppuserpriority_datefrom</code>.
     */
    public void setZtebscemlppuserpriorityDatefrom(UInteger value) {
        set(3, value);
    }

    /**
     * Getter for <code>chrono.ztebscemlppuserpriority.ztebscemlppuserpriority_datefrom</code>.
     */
    public UInteger getZtebscemlppuserpriorityDatefrom() {
        return (UInteger) get(3);
    }

    /**
     * Setter for <code>chrono.ztebscemlppuserpriority.ztebscemlppuserpriority_ztebsc</code>.
     */
    public void setZtebscemlppuserpriorityZtebsc(ULong value) {
        set(4, value);
    }

    /**
     * Getter for <code>chrono.ztebscemlppuserpriority.ztebscemlppuserpriority_ztebsc</code>.
     */
    public ULong getZtebscemlppuserpriorityZtebsc() {
        return (ULong) get(4);
    }

    /**
     * Setter for <code>chrono.ztebscemlppuserpriority.MOI</code>.
     */
    public void setMoi(String value) {
        set(5, value);
    }

    /**
     * Getter for <code>chrono.ztebscemlppuserpriority.MOI</code>.
     */
    public String getMoi() {
        return (String) get(5);
    }

    /**
     * Setter for <code>chrono.ztebscemlppuserpriority.SubNetwork</code>.
     */
    public void setSubnetwork(String value) {
        set(6, value);
    }

    /**
     * Getter for <code>chrono.ztebscemlppuserpriority.SubNetwork</code>.
     */
    public String getSubnetwork() {
        return (String) get(6);
    }

    /**
     * Setter for <code>chrono.ztebscemlppuserpriority.MEID</code>.
     */
    public void setMeid(String value) {
        set(7, value);
    }

    /**
     * Getter for <code>chrono.ztebscemlppuserpriority.MEID</code>.
     */
    public String getMeid() {
        return (String) get(7);
    }

    /**
     * Setter for <code>chrono.ztebscemlppuserpriority.GBssFunction</code>.
     */
    public void setGbssfunction(String value) {
        set(8, value);
    }

    /**
     * Getter for <code>chrono.ztebscemlppuserpriority.GBssFunction</code>.
     */
    public String getGbssfunction() {
        return (String) get(8);
    }

    /**
     * Setter for <code>chrono.ztebscemlppuserpriority.Gemlpp</code>.
     */
    public void setGemlpp(String value) {
        set(9, value);
    }

    /**
     * Getter for <code>chrono.ztebscemlppuserpriority.Gemlpp</code>.
     */
    public String getGemlpp() {
        return (String) get(9);
    }

    /**
     * Setter for <code>chrono.ztebscemlppuserpriority.GEmlppUserPriority</code>.
     */
    public void setGemlppuserpriority(String value) {
        set(10, value);
    }

    /**
     * Getter for <code>chrono.ztebscemlppuserpriority.GEmlppUserPriority</code>.
     */
    public String getGemlppuserpriority() {
        return (String) get(10);
    }

    /**
     * Setter for <code>chrono.ztebscemlppuserpriority.userPriority</code>.
     */
    public void setUserpriority(String value) {
        set(11, value);
    }

    /**
     * Getter for <code>chrono.ztebscemlppuserpriority.userPriority</code>.
     */
    public String getUserpriority() {
        return (String) get(11);
    }

    /**
     * Setter for <code>chrono.ztebscemlppuserpriority.assPreemptstrategy</code>.
     */
    public void setAsspreemptstrategy(String value) {
        set(12, value);
    }

    /**
     * Getter for <code>chrono.ztebscemlppuserpriority.assPreemptstrategy</code>.
     */
    public String getAsspreemptstrategy() {
        return (String) get(12);
    }

    /**
     * Setter for <code>chrono.ztebscemlppuserpriority.hoPreemptstrategy</code>.
     */
    public void setHopreemptstrategy(String value) {
        set(13, value);
    }

    /**
     * Getter for <code>chrono.ztebscemlppuserpriority.hoPreemptstrategy</code>.
     */
    public String getHopreemptstrategy() {
        return (String) get(13);
    }

    /**
     * Setter for <code>chrono.ztebscemlppuserpriority.assForcedHoTry</code>.
     */
    public void setAssforcedhotry(String value) {
        set(14, value);
    }

    /**
     * Getter for <code>chrono.ztebscemlppuserpriority.assForcedHoTry</code>.
     */
    public String getAssforcedhotry() {
        return (String) get(14);
    }

    /**
     * Setter for <code>chrono.ztebscemlppuserpriority.hoForcedHoTry</code>.
     */
    public void setHoforcedhotry(String value) {
        set(15, value);
    }

    /**
     * Getter for <code>chrono.ztebscemlppuserpriority.hoForcedHoTry</code>.
     */
    public String getHoforcedhotry() {
        return (String) get(15);
    }

    /**
     * Setter for <code>chrono.ztebscemlppuserpriority.assForcedRelTry</code>.
     */
    public void setAssforcedreltry(String value) {
        set(16, value);
    }

    /**
     * Getter for <code>chrono.ztebscemlppuserpriority.assForcedRelTry</code>.
     */
    public String getAssforcedreltry() {
        return (String) get(16);
    }

    /**
     * Setter for <code>chrono.ztebscemlppuserpriority.hoForcedRelTry</code>.
     */
    public void setHoforcedreltry(String value) {
        set(17, value);
    }

    /**
     * Getter for <code>chrono.ztebscemlppuserpriority.hoForcedRelTry</code>.
     */
    public String getHoforcedreltry() {
        return (String) get(17);
    }

    /**
     * Setter for <code>chrono.ztebscemlppuserpriority.assPreempTimer</code>.
     */
    public void setAsspreemptimer(String value) {
        set(18, value);
    }

    /**
     * Getter for <code>chrono.ztebscemlppuserpriority.assPreempTimer</code>.
     */
    public String getAsspreemptimer() {
        return (String) get(18);
    }

    /**
     * Setter for <code>chrono.ztebscemlppuserpriority.hoPreempTimer</code>.
     */
    public void setHopreemptimer(String value) {
        set(19, value);
    }

    /**
     * Getter for <code>chrono.ztebscemlppuserpriority.hoPreempTimer</code>.
     */
    public String getHopreemptimer() {
        return (String) get(19);
    }

    /**
     * Setter for <code>chrono.ztebscemlppuserpriority.assForceRelTimer</code>.
     */
    public void setAssforcereltimer(String value) {
        set(20, value);
    }

    /**
     * Getter for <code>chrono.ztebscemlppuserpriority.assForceRelTimer</code>.
     */
    public String getAssforcereltimer() {
        return (String) get(20);
    }

    /**
     * Setter for <code>chrono.ztebscemlppuserpriority.hoForceRelTimer</code>.
     */
    public void setHoforcereltimer(String value) {
        set(21, value);
    }

    /**
     * Getter for <code>chrono.ztebscemlppuserpriority.hoForceRelTimer</code>.
     */
    public String getHoforcereltimer() {
        return (String) get(21);
    }

    /**
     * Setter for <code>chrono.ztebscemlppuserpriority.assForceHoInterval</code>.
     */
    public void setAssforcehointerval(String value) {
        set(22, value);
    }

    /**
     * Getter for <code>chrono.ztebscemlppuserpriority.assForceHoInterval</code>.
     */
    public String getAssforcehointerval() {
        return (String) get(22);
    }

    /**
     * Setter for <code>chrono.ztebscemlppuserpriority.hoForceHoInterval</code>.
     */
    public void setHoforcehointerval(String value) {
        set(23, value);
    }

    /**
     * Getter for <code>chrono.ztebscemlppuserpriority.hoForceHoInterval</code>.
     */
    public String getHoforcehointerval() {
        return (String) get(23);
    }

    /**
     * Setter for <code>chrono.ztebscemlppuserpriority.assForceRelInterval</code>.
     */
    public void setAssforcerelinterval(String value) {
        set(24, value);
    }

    /**
     * Getter for <code>chrono.ztebscemlppuserpriority.assForceRelInterval</code>.
     */
    public String getAssforcerelinterval() {
        return (String) get(24);
    }

    /**
     * Setter for <code>chrono.ztebscemlppuserpriority.hoForceRelInterval</code>.
     */
    public void setHoforcerelinterval(String value) {
        set(25, value);
    }

    /**
     * Getter for <code>chrono.ztebscemlppuserpriority.hoForceRelInterval</code>.
     */
    public String getHoforcerelinterval() {
        return (String) get(25);
    }

    /**
     * Setter for <code>chrono.ztebscemlppuserpriority.rmsT11</code>.
     */
    public void setRmst11(String value) {
        set(26, value);
    }

    /**
     * Getter for <code>chrono.ztebscemlppuserpriority.rmsT11</code>.
     */
    public String getRmst11() {
        return (String) get(26);
    }

    /**
     * Setter for <code>chrono.ztebscemlppuserpriority.rmsTqho</code>.
     */
    public void setRmstqho(String value) {
        set(27, value);
    }

    /**
     * Getter for <code>chrono.ztebscemlppuserpriority.rmsTqho</code>.
     */
    public String getRmstqho() {
        return (String) get(27);
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
     * Create a detached ZtebscemlppuserpriorityRecord
     */
    public ZtebscemlppuserpriorityRecord() {
        super(Ztebscemlppuserpriority.ZTEBSCEMLPPUSERPRIORITY);
    }

    /**
     * Create a detached, initialised ZtebscemlppuserpriorityRecord
     */
    public ZtebscemlppuserpriorityRecord(ULong ztebscemlppuserpriorityId, ULong ztebscemlppuserpriorityCrcollectortaskfiles, UInteger ztebscemlppuserpriorityDate, UInteger ztebscemlppuserpriorityDatefrom, ULong ztebscemlppuserpriorityZtebsc, String moi, String subnetwork, String meid, String gbssfunction, String gemlpp, String gemlppuserpriority, String userpriority, String asspreemptstrategy, String hopreemptstrategy, String assforcedhotry, String hoforcedhotry, String assforcedreltry, String hoforcedreltry, String asspreemptimer, String hopreemptimer, String assforcereltimer, String hoforcereltimer, String assforcehointerval, String hoforcehointerval, String assforcerelinterval, String hoforcerelinterval, String rmst11, String rmstqho) {
        super(Ztebscemlppuserpriority.ZTEBSCEMLPPUSERPRIORITY);

        set(0, ztebscemlppuserpriorityId);
        set(1, ztebscemlppuserpriorityCrcollectortaskfiles);
        set(2, ztebscemlppuserpriorityDate);
        set(3, ztebscemlppuserpriorityDatefrom);
        set(4, ztebscemlppuserpriorityZtebsc);
        set(5, moi);
        set(6, subnetwork);
        set(7, meid);
        set(8, gbssfunction);
        set(9, gemlpp);
        set(10, gemlppuserpriority);
        set(11, userpriority);
        set(12, asspreemptstrategy);
        set(13, hopreemptstrategy);
        set(14, assforcedhotry);
        set(15, hoforcedhotry);
        set(16, assforcedreltry);
        set(17, hoforcedreltry);
        set(18, asspreemptimer);
        set(19, hopreemptimer);
        set(20, assforcereltimer);
        set(21, hoforcereltimer);
        set(22, assforcehointerval);
        set(23, hoforcehointerval);
        set(24, assforcerelinterval);
        set(25, hoforcerelinterval);
        set(26, rmst11);
        set(27, rmstqho);
    }
}

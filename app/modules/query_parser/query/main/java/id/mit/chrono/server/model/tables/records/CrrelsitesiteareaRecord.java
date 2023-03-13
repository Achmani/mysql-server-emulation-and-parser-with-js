/*
 * This file is generated by jOOQ.
*/
package id.mit.chrono.server.model.tables.records;


import id.mit.chrono.server.model.tables.Crrelsitesitearea;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record4;
import org.jooq.Row4;
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
public class CrrelsitesiteareaRecord extends UpdatableRecordImpl<CrrelsitesiteareaRecord> implements Record4<UInteger, Integer, Integer, Byte> {

    private static final long serialVersionUID = 1799428463;

    /**
     * Setter for <code>chrono.crrelsitesitearea.relsitesitearea_id</code>.
     */
    public void setRelsitesiteareaId(UInteger value) {
        set(0, value);
    }

    /**
     * Getter for <code>chrono.crrelsitesitearea.relsitesitearea_id</code>.
     */
    public UInteger getRelsitesiteareaId() {
        return (UInteger) get(0);
    }

    /**
     * Setter for <code>chrono.crrelsitesitearea.relsitesitearea_site</code>.
     */
    public void setRelsitesiteareaSite(Integer value) {
        set(1, value);
    }

    /**
     * Getter for <code>chrono.crrelsitesitearea.relsitesitearea_site</code>.
     */
    public Integer getRelsitesiteareaSite() {
        return (Integer) get(1);
    }

    /**
     * Setter for <code>chrono.crrelsitesitearea.relsitesitearea_sitearea</code>.
     */
    public void setRelsitesiteareaSitearea(Integer value) {
        set(2, value);
    }

    /**
     * Getter for <code>chrono.crrelsitesitearea.relsitesitearea_sitearea</code>.
     */
    public Integer getRelsitesiteareaSitearea() {
        return (Integer) get(2);
    }

    /**
     * Setter for <code>chrono.crrelsitesitearea.relsitesitearea_istemporary</code>.
     */
    public void setRelsitesiteareaIstemporary(Byte value) {
        set(3, value);
    }

    /**
     * Getter for <code>chrono.crrelsitesitearea.relsitesitearea_istemporary</code>.
     */
    public Byte getRelsitesiteareaIstemporary() {
        return (Byte) get(3);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Record1<UInteger> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record4 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row4<UInteger, Integer, Integer, Byte> fieldsRow() {
        return (Row4) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row4<UInteger, Integer, Integer, Byte> valuesRow() {
        return (Row4) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<UInteger> field1() {
        return Crrelsitesitearea.CRRELSITESITEAREA.RELSITESITEAREA_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field2() {
        return Crrelsitesitearea.CRRELSITESITEAREA.RELSITESITEAREA_SITE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field3() {
        return Crrelsitesitearea.CRRELSITESITEAREA.RELSITESITEAREA_SITEAREA;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Byte> field4() {
        return Crrelsitesitearea.CRRELSITESITEAREA.RELSITESITEAREA_ISTEMPORARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UInteger component1() {
        return getRelsitesiteareaId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component2() {
        return getRelsitesiteareaSite();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component3() {
        return getRelsitesiteareaSitearea();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Byte component4() {
        return getRelsitesiteareaIstemporary();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UInteger value1() {
        return getRelsitesiteareaId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value2() {
        return getRelsitesiteareaSite();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value3() {
        return getRelsitesiteareaSitearea();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Byte value4() {
        return getRelsitesiteareaIstemporary();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CrrelsitesiteareaRecord value1(UInteger value) {
        setRelsitesiteareaId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CrrelsitesiteareaRecord value2(Integer value) {
        setRelsitesiteareaSite(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CrrelsitesiteareaRecord value3(Integer value) {
        setRelsitesiteareaSitearea(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CrrelsitesiteareaRecord value4(Byte value) {
        setRelsitesiteareaIstemporary(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CrrelsitesiteareaRecord values(UInteger value1, Integer value2, Integer value3, Byte value4) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached CrrelsitesiteareaRecord
     */
    public CrrelsitesiteareaRecord() {
        super(Crrelsitesitearea.CRRELSITESITEAREA);
    }

    /**
     * Create a detached, initialised CrrelsitesiteareaRecord
     */
    public CrrelsitesiteareaRecord(UInteger relsitesiteareaId, Integer relsitesiteareaSite, Integer relsitesiteareaSitearea, Byte relsitesiteareaIstemporary) {
        super(Crrelsitesitearea.CRRELSITESITEAREA);

        set(0, relsitesiteareaId);
        set(1, relsitesiteareaSite);
        set(2, relsitesiteareaSitearea);
        set(3, relsitesiteareaIstemporary);
    }
}

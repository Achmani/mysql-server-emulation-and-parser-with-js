/*
 * This file is generated by jOOQ.
*/
package id.mit.chrono.server.model.tables;


import id.mit.chrono.server.model.Chrono;
import id.mit.chrono.server.model.Keys;
import id.mit.chrono.server.model.tables.records.HwinventoryRecord;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Name;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;
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
public class Hwinventory extends TableImpl<HwinventoryRecord> {

    private static final long serialVersionUID = 2004142473;

    /**
     * The reference instance of <code>chrono.hwinventory</code>
     */
    public static final Hwinventory HWINVENTORY = new Hwinventory();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<HwinventoryRecord> getRecordType() {
        return HwinventoryRecord.class;
    }

    /**
     * The column <code>chrono.hwinventory.hwinventory_id</code>.
     */
    public final TableField<HwinventoryRecord, UInteger> HWINVENTORY_ID = createField("hwinventory_id", org.jooq.impl.SQLDataType.INTEGERUNSIGNED.nullable(false), this, "");

    /**
     * The column <code>chrono.hwinventory.hwinventory_date</code>.
     */
    public final TableField<HwinventoryRecord, Integer> HWINVENTORY_DATE = createField("hwinventory_date", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>chrono.hwinventory.hwinventory_datatype</code>.
     */
    public final TableField<HwinventoryRecord, Integer> HWINVENTORY_DATATYPE = createField("hwinventory_datatype", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.hwinventory.hwinventory_collectortaskfiles</code>.
     */
    public final TableField<HwinventoryRecord, Long> HWINVENTORY_COLLECTORTASKFILES = createField("hwinventory_collectortaskfiles", org.jooq.impl.SQLDataType.BIGINT, this, "");

    /**
     * The column <code>chrono.hwinventory.hwinventory_vendor</code>.
     */
    public final TableField<HwinventoryRecord, Integer> HWINVENTORY_VENDOR = createField("hwinventory_vendor", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.hwinventory.hwinventory_site</code>.
     */
    public final TableField<HwinventoryRecord, Integer> HWINVENTORY_SITE = createField("hwinventory_site", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.hwinventory.hwinventory_siteId</code>.
     */
    public final TableField<HwinventoryRecord, String> HWINVENTORY_SITEID = createField("hwinventory_siteId", org.jooq.impl.SQLDataType.CHAR(11), this, "");

    /**
     * The column <code>chrono.hwinventory.hwinventory_nefdn</code>.
     */
    public final TableField<HwinventoryRecord, String> HWINVENTORY_NEFDN = createField("hwinventory_nefdn", org.jooq.impl.SQLDataType.VARCHAR(20), this, "");

    /**
     * The column <code>chrono.hwinventory.hwinventory_neType</code>.
     */
    public final TableField<HwinventoryRecord, String> HWINVENTORY_NETYPE = createField("hwinventory_neType", org.jooq.impl.SQLDataType.VARCHAR(20), this, "");

    /**
     * The column <code>chrono.hwinventory.hwinventory_serialnumber</code>.
     */
    public final TableField<HwinventoryRecord, String> HWINVENTORY_SERIALNUMBER = createField("hwinventory_serialnumber", org.jooq.impl.SQLDataType.VARCHAR(100), this, "");

    /**
     * The column <code>chrono.hwinventory.hwinventory_nename</code>.
     */
    public final TableField<HwinventoryRecord, String> HWINVENTORY_NENAME = createField("hwinventory_nename", org.jooq.impl.SQLDataType.VARCHAR(200), this, "");

    /**
     * The column <code>chrono.hwinventory.hwinventory_boardname</code>.
     */
    public final TableField<HwinventoryRecord, String> HWINVENTORY_BOARDNAME = createField("hwinventory_boardname", org.jooq.impl.SQLDataType.VARCHAR(20), this, "");

    /**
     * The column <code>chrono.hwinventory.hwinventory_boardtype</code>.
     */
    public final TableField<HwinventoryRecord, String> HWINVENTORY_BOARDTYPE = createField("hwinventory_boardtype", org.jooq.impl.SQLDataType.VARCHAR(20), this, "");

    /**
     * The column <code>chrono.hwinventory.hwinventory_bomcode</code>.
     */
    public final TableField<HwinventoryRecord, String> HWINVENTORY_BOMCODE = createField("hwinventory_bomcode", org.jooq.impl.SQLDataType.VARCHAR(20), this, "");

    /**
     * The column <code>chrono.hwinventory.hwinventory_unitposition</code>.
     */
    public final TableField<HwinventoryRecord, String> HWINVENTORY_UNITPOSITION = createField("hwinventory_unitposition", org.jooq.impl.SQLDataType.VARCHAR(150), this, "");

    /**
     * The column <code>chrono.hwinventory.hwinventory_dateofmanufacture</code>.
     */
    public final TableField<HwinventoryRecord, String> HWINVENTORY_DATEOFMANUFACTURE = createField("hwinventory_dateofmanufacture", org.jooq.impl.SQLDataType.VARCHAR(20), this, "");

    /**
     * The column <code>chrono.hwinventory.hwinventory_manufacturerdata</code>.
     */
    public final TableField<HwinventoryRecord, String> HWINVENTORY_MANUFACTURERDATA = createField("hwinventory_manufacturerdata", org.jooq.impl.SQLDataType.CLOB, this, "");

    /**
     * The column <code>chrono.hwinventory.hwinventory_cabinetno</code>.
     */
    public final TableField<HwinventoryRecord, String> HWINVENTORY_CABINETNO = createField("hwinventory_cabinetno", org.jooq.impl.SQLDataType.CHAR(20), this, "");

    /**
     * The column <code>chrono.hwinventory.hwinventory_subrackno</code>.
     */
    public final TableField<HwinventoryRecord, String> HWINVENTORY_SUBRACKNO = createField("hwinventory_subrackno", org.jooq.impl.SQLDataType.CHAR(20), this, "");

    /**
     * The column <code>chrono.hwinventory.hwinventory_slotno</code>.
     */
    public final TableField<HwinventoryRecord, String> HWINVENTORY_SLOTNO = createField("hwinventory_slotno", org.jooq.impl.SQLDataType.CHAR(20), this, "");

    /**
     * The column <code>chrono.hwinventory.hwinventory_subslotno</code>.
     */
    public final TableField<HwinventoryRecord, String> HWINVENTORY_SUBSLOTNO = createField("hwinventory_subslotno", org.jooq.impl.SQLDataType.CHAR(20), this, "");

    /**
     * The column <code>chrono.hwinventory.hwinventory_portno</code>.
     */
    public final TableField<HwinventoryRecord, String> HWINVENTORY_PORTNO = createField("hwinventory_portno", org.jooq.impl.SQLDataType.CHAR(20), this, "");

    /**
     * The column <code>chrono.hwinventory.hwinventory_inventoryunitid</code>.
     */
    public final TableField<HwinventoryRecord, String> HWINVENTORY_INVENTORYUNITID = createField("hwinventory_inventoryunitid", org.jooq.impl.SQLDataType.CHAR(20), this, "");

    /**
     * The column <code>chrono.hwinventory.hwinventory_inventoryunittype</code>.
     */
    public final TableField<HwinventoryRecord, String> HWINVENTORY_INVENTORYUNITTYPE = createField("hwinventory_inventoryunittype", org.jooq.impl.SQLDataType.VARCHAR(20), this, "");

    /**
     * The column <code>chrono.hwinventory.hwinventory_softwareversion</code>.
     */
    public final TableField<HwinventoryRecord, String> HWINVENTORY_SOFTWAREVERSION = createField("hwinventory_softwareversion", org.jooq.impl.SQLDataType.VARCHAR(100), this, "");

    /**
     * The column <code>chrono.hwinventory.hwinventory_hardwareversion</code>.
     */
    public final TableField<HwinventoryRecord, String> HWINVENTORY_HARDWAREVERSION = createField("hwinventory_hardwareversion", org.jooq.impl.SQLDataType.VARCHAR(100), this, "");

    /**
     * The column <code>chrono.hwinventory.hwinverntory_isfirst</code>.
     */
    public final TableField<HwinventoryRecord, Integer> HWINVERNTORY_ISFIRST = createField("hwinverntory_isfirst", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.hwinventory.hwinventory_inserttime</code>.
     */
    public final TableField<HwinventoryRecord, Timestamp> HWINVENTORY_INSERTTIME = createField("hwinventory_inserttime", org.jooq.impl.SQLDataType.TIMESTAMP, this, "");

    /**
     * Create a <code>chrono.hwinventory</code> table reference
     */
    public Hwinventory() {
        this(DSL.name("hwinventory"), null);
    }

    /**
     * Create an aliased <code>chrono.hwinventory</code> table reference
     */
    public Hwinventory(String alias) {
        this(DSL.name(alias), HWINVENTORY);
    }

    /**
     * Create an aliased <code>chrono.hwinventory</code> table reference
     */
    public Hwinventory(Name alias) {
        this(alias, HWINVENTORY);
    }

    private Hwinventory(Name alias, Table<HwinventoryRecord> aliased) {
        this(alias, aliased, null);
    }

    private Hwinventory(Name alias, Table<HwinventoryRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, "");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Schema getSchema() {
        return Chrono.CHRONO;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<HwinventoryRecord> getPrimaryKey() {
        return Keys.KEY_HWINVENTORY_PRIMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<HwinventoryRecord>> getKeys() {
        return Arrays.<UniqueKey<HwinventoryRecord>>asList(Keys.KEY_HWINVENTORY_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Hwinventory as(String alias) {
        return new Hwinventory(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Hwinventory as(Name alias) {
        return new Hwinventory(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Hwinventory rename(String name) {
        return new Hwinventory(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Hwinventory rename(Name name) {
        return new Hwinventory(name, null);
    }
}
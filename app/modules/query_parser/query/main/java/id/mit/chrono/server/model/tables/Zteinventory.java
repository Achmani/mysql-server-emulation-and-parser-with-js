/*
 * This file is generated by jOOQ.
*/
package id.mit.chrono.server.model.tables;


import id.mit.chrono.server.model.Chrono;
import id.mit.chrono.server.model.Keys;
import id.mit.chrono.server.model.tables.records.ZteinventoryRecord;

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
public class Zteinventory extends TableImpl<ZteinventoryRecord> {

    private static final long serialVersionUID = -2124303608;

    /**
     * The reference instance of <code>chrono.zteinventory</code>
     */
    public static final Zteinventory ZTEINVENTORY = new Zteinventory();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<ZteinventoryRecord> getRecordType() {
        return ZteinventoryRecord.class;
    }

    /**
     * The column <code>chrono.zteinventory.zteinventory_id</code>.
     */
    public final TableField<ZteinventoryRecord, UInteger> ZTEINVENTORY_ID = createField("zteinventory_id", org.jooq.impl.SQLDataType.INTEGERUNSIGNED.nullable(false), this, "");

    /**
     * The column <code>chrono.zteinventory.zteinventory_date</code>.
     */
    public final TableField<ZteinventoryRecord, Integer> ZTEINVENTORY_DATE = createField("zteinventory_date", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>chrono.zteinventory.zteinventory_datatype</code>.
     */
    public final TableField<ZteinventoryRecord, Integer> ZTEINVENTORY_DATATYPE = createField("zteinventory_datatype", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.zteinventory.zteinventory_collectortaskfiles</code>.
     */
    public final TableField<ZteinventoryRecord, Long> ZTEINVENTORY_COLLECTORTASKFILES = createField("zteinventory_collectortaskfiles", org.jooq.impl.SQLDataType.BIGINT, this, "");

    /**
     * The column <code>chrono.zteinventory.zteinventory_vendor</code>.
     */
    public final TableField<ZteinventoryRecord, Integer> ZTEINVENTORY_VENDOR = createField("zteinventory_vendor", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.zteinventory.zteinventory_site</code>.
     */
    public final TableField<ZteinventoryRecord, Integer> ZTEINVENTORY_SITE = createField("zteinventory_site", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.zteinventory.zteinventory_siteId</code>.
     */
    public final TableField<ZteinventoryRecord, String> ZTEINVENTORY_SITEID = createField("zteinventory_siteId", org.jooq.impl.SQLDataType.CHAR(11), this, "");

    /**
     * The column <code>chrono.zteinventory.zteinventory_nename</code>.
     */
    public final TableField<ZteinventoryRecord, String> ZTEINVENTORY_NENAME = createField("zteinventory_nename", org.jooq.impl.SQLDataType.VARCHAR(200), this, "");

    /**
     * The column <code>chrono.zteinventory.zteinventory_inventoryunittype</code>.
     */
    public final TableField<ZteinventoryRecord, String> ZTEINVENTORY_INVENTORYUNITTYPE = createField("zteinventory_inventoryunittype", org.jooq.impl.SQLDataType.VARCHAR(100), this, "");

    /**
     * The column <code>chrono.zteinventory.zteinventory_vendorunitfamilytype</code>.
     */
    public final TableField<ZteinventoryRecord, String> ZTEINVENTORY_VENDORUNITFAMILYTYPE = createField("zteinventory_vendorunitfamilytype", org.jooq.impl.SQLDataType.VARCHAR(100), this, "");

    /**
     * The column <code>chrono.zteinventory.zteinventory_vendorname</code>.
     */
    public final TableField<ZteinventoryRecord, String> ZTEINVENTORY_VENDORNAME = createField("zteinventory_vendorname", org.jooq.impl.SQLDataType.VARCHAR(100), this, "");

    /**
     * The column <code>chrono.zteinventory.zteinventory_serialnumber</code>.
     */
    public final TableField<ZteinventoryRecord, String> ZTEINVENTORY_SERIALNUMBER = createField("zteinventory_serialnumber", org.jooq.impl.SQLDataType.CHAR(50), this, "");

    /**
     * The column <code>chrono.zteinventory.zteinventory_versionnumber</code>.
     */
    public final TableField<ZteinventoryRecord, String> ZTEINVENTORY_VERSIONNUMBER = createField("zteinventory_versionnumber", org.jooq.impl.SQLDataType.VARCHAR(100), this, "");

    /**
     * The column <code>chrono.zteinventory.zteinventory_dateofmanufacture</code>.
     */
    public final TableField<ZteinventoryRecord, String> ZTEINVENTORY_DATEOFMANUFACTURE = createField("zteinventory_dateofmanufacture", org.jooq.impl.SQLDataType.VARCHAR(50), this, "");

    /**
     * The column <code>chrono.zteinventory.zteinventory_unitposition</code>.
     */
    public final TableField<ZteinventoryRecord, String> ZTEINVENTORY_UNITPOSITION = createField("zteinventory_unitposition", org.jooq.impl.SQLDataType.VARCHAR(200), this, "");

    /**
     * The column <code>chrono.zteinventory.zteinventory_manufacturedata</code>.
     */
    public final TableField<ZteinventoryRecord, String> ZTEINVENTORY_MANUFACTUREDATA = createField("zteinventory_manufacturedata", org.jooq.impl.SQLDataType.VARCHAR(100), this, "");

    /**
     * The column <code>chrono.zteinventory.zteinventory_packsilkscreen</code>.
     */
    public final TableField<ZteinventoryRecord, String> ZTEINVENTORY_PACKSILKSCREEN = createField("zteinventory_packsilkscreen", org.jooq.impl.SQLDataType.VARCHAR(100), this, "");

    /**
     * The column <code>chrono.zteinventory.zteinventory_packfunction</code>.
     */
    public final TableField<ZteinventoryRecord, String> ZTEINVENTORY_PACKFUNCTION = createField("zteinventory_packfunction", org.jooq.impl.SQLDataType.VARCHAR(100), this, "");

    /**
     * The column <code>chrono.zteinventory.zteinventory_ne</code>.
     */
    public final TableField<ZteinventoryRecord, String> ZTEINVENTORY_NE = createField("zteinventory_ne", org.jooq.impl.SQLDataType.CLOB, this, "");

    /**
     * The column <code>chrono.zteinventory.zteinventory_netype</code>.
     */
    public final TableField<ZteinventoryRecord, String> ZTEINVENTORY_NETYPE = createField("zteinventory_netype", org.jooq.impl.SQLDataType.VARCHAR(100), this, "");

    /**
     * The column <code>chrono.zteinventory.zteinventory_updatetime</code>.
     */
    public final TableField<ZteinventoryRecord, String> ZTEINVENTORY_UPDATETIME = createField("zteinventory_updatetime", org.jooq.impl.SQLDataType.VARCHAR(100), this, "");

    /**
     * The column <code>chrono.zteinventory.zteinventory_source</code>.
     */
    public final TableField<ZteinventoryRecord, String> ZTEINVENTORY_SOURCE = createField("zteinventory_source", org.jooq.impl.SQLDataType.CHAR(50), this, "");

    /**
     * The column <code>chrono.zteinventory.zteinventory_state</code>.
     */
    public final TableField<ZteinventoryRecord, String> ZTEINVENTORY_STATE = createField("zteinventory_state", org.jooq.impl.SQLDataType.CHAR(50), this, "");

    /**
     * The column <code>chrono.zteinventory.zteinventory_reserve1</code>.
     */
    public final TableField<ZteinventoryRecord, String> ZTEINVENTORY_RESERVE1 = createField("zteinventory_reserve1", org.jooq.impl.SQLDataType.CLOB, this, "");

    /**
     * The column <code>chrono.zteinventory.zteinventory_reserve2</code>.
     */
    public final TableField<ZteinventoryRecord, String> ZTEINVENTORY_RESERVE2 = createField("zteinventory_reserve2", org.jooq.impl.SQLDataType.CLOB, this, "");

    /**
     * The column <code>chrono.zteinventory.zteinventory_reserve11</code>.
     */
    public final TableField<ZteinventoryRecord, String> ZTEINVENTORY_RESERVE11 = createField("zteinventory_reserve11", org.jooq.impl.SQLDataType.CLOB, this, "");

    /**
     * The column <code>chrono.zteinventory.zteinventory_productcode</code>.
     */
    public final TableField<ZteinventoryRecord, String> ZTEINVENTORY_PRODUCTCODE = createField("zteinventory_productcode", org.jooq.impl.SQLDataType.VARCHAR(100), this, "");

    /**
     * The column <code>chrono.zteinventory.zteinventory_isfirst</code>.
     */
    public final TableField<ZteinventoryRecord, Integer> ZTEINVENTORY_ISFIRST = createField("zteinventory_isfirst", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.zteinventory.zteinventory_inserttime</code>.
     */
    public final TableField<ZteinventoryRecord, Timestamp> ZTEINVENTORY_INSERTTIME = createField("zteinventory_inserttime", org.jooq.impl.SQLDataType.TIMESTAMP, this, "");

    /**
     * Create a <code>chrono.zteinventory</code> table reference
     */
    public Zteinventory() {
        this(DSL.name("zteinventory"), null);
    }

    /**
     * Create an aliased <code>chrono.zteinventory</code> table reference
     */
    public Zteinventory(String alias) {
        this(DSL.name(alias), ZTEINVENTORY);
    }

    /**
     * Create an aliased <code>chrono.zteinventory</code> table reference
     */
    public Zteinventory(Name alias) {
        this(alias, ZTEINVENTORY);
    }

    private Zteinventory(Name alias, Table<ZteinventoryRecord> aliased) {
        this(alias, aliased, null);
    }

    private Zteinventory(Name alias, Table<ZteinventoryRecord> aliased, Field<?>[] parameters) {
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
    public UniqueKey<ZteinventoryRecord> getPrimaryKey() {
        return Keys.KEY_ZTEINVENTORY_PRIMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<ZteinventoryRecord>> getKeys() {
        return Arrays.<UniqueKey<ZteinventoryRecord>>asList(Keys.KEY_ZTEINVENTORY_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Zteinventory as(String alias) {
        return new Zteinventory(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Zteinventory as(Name alias) {
        return new Zteinventory(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Zteinventory rename(String name) {
        return new Zteinventory(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Zteinventory rename(Name name) {
        return new Zteinventory(name, null);
    }
}
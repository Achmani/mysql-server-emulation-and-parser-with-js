/*
 * This file is generated by jOOQ.
*/
package id.mit.chrono.server.model.tables;


import id.mit.chrono.server.model.Chrono;
import id.mit.chrono.server.model.Indexes;
import id.mit.chrono.server.model.Keys;
import id.mit.chrono.server.model.tables.records.ErbtsRecord;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Index;
import org.jooq.Name;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;
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
public class Erbts extends TableImpl<ErbtsRecord> {

    private static final long serialVersionUID = 193886654;

    /**
     * The reference instance of <code>chrono.erbts</code>
     */
    public static final Erbts ERBTS = new Erbts();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<ErbtsRecord> getRecordType() {
        return ErbtsRecord.class;
    }

    /**
     * The column <code>chrono.erbts.erbts_id</code>.
     */
    public final TableField<ErbtsRecord, ULong> ERBTS_ID = createField("erbts_id", org.jooq.impl.SQLDataType.BIGINTUNSIGNED.nullable(false), this, "");

    /**
     * The column <code>chrono.erbts.erbts_crcollectortaskfiles</code>.
     */
    public final TableField<ErbtsRecord, ULong> ERBTS_CRCOLLECTORTASKFILES = createField("erbts_crcollectortaskfiles", org.jooq.impl.SQLDataType.BIGINTUNSIGNED, this, "");

    /**
     * The column <code>chrono.erbts.erbts_date</code>.
     */
    public final TableField<ErbtsRecord, UInteger> ERBTS_DATE = createField("erbts_date", org.jooq.impl.SQLDataType.INTEGERUNSIGNED.nullable(false), this, "");

    /**
     * The column <code>chrono.erbts.erbts_datefrom</code>.
     */
    public final TableField<ErbtsRecord, Integer> ERBTS_DATEFROM = createField("erbts_datefrom", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.erbts.erbts_erbsc</code>.
     */
    public final TableField<ErbtsRecord, ULong> ERBTS_ERBSC = createField("erbts_erbsc", org.jooq.impl.SQLDataType.BIGINTUNSIGNED.nullable(false), this, "");

    /**
     * The column <code>chrono.erbts.erbts_node</code>.
     */
    public final TableField<ErbtsRecord, Integer> ERBTS_NODE = createField("erbts_node", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.erbts.erbts_nodephysical</code>.
     */
    public final TableField<ErbtsRecord, Integer> ERBTS_NODEPHYSICAL = createField("erbts_nodephysical", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.erbts.erbts_nodestatus</code>.
     */
    public final TableField<ErbtsRecord, Integer> ERBTS_NODESTATUS = createField("erbts_nodestatus", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.erbts.erbts_revenueclass</code>.
     */
    public final TableField<ErbtsRecord, Integer> ERBTS_REVENUECLASS = createField("erbts_revenueclass", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.erbts.erbts_vendor</code>.
     */
    public final TableField<ErbtsRecord, Integer> ERBTS_VENDOR = createField("erbts_vendor", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.erbts.erbts_namingvalid</code>.
     */
    public final TableField<ErbtsRecord, Byte> ERBTS_NAMINGVALID = createField("erbts_namingvalid", org.jooq.impl.SQLDataType.TINYINT, this, "");

    /**
     * The column <code>chrono.erbts.TOTALCELL</code>.
     */
    public final TableField<ErbtsRecord, Integer> TOTALCELL = createField("TOTALCELL", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.erbts.TOTALTRX</code>.
     */
    public final TableField<ErbtsRecord, Integer> TOTALTRX = createField("TOTALTRX", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.erbts.BTSNAME</code>.
     */
    public final TableField<ErbtsRecord, String> BTSNAME = createField("BTSNAME", org.jooq.impl.SQLDataType.CHAR(96), this, "");

    /**
     * The column <code>chrono.erbts.BTSID</code>.
     */
    public final TableField<ErbtsRecord, Integer> BTSID = createField("BTSID", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.erbts.TG</code>.
     */
    public final TableField<ErbtsRecord, String> TG = createField("TG", org.jooq.impl.SQLDataType.CHAR(32), this, "");

    /**
     * The column <code>chrono.erbts.SITE</code>.
     */
    public final TableField<ErbtsRecord, String> SITE = createField("SITE", org.jooq.impl.SQLDataType.CHAR(96), this, "");

    /**
     * The column <code>chrono.erbts.NEID</code>.
     */
    public final TableField<ErbtsRecord, String> NEID = createField("NEID", org.jooq.impl.SQLDataType.CHAR(96), this, "");

    /**
     * The column <code>chrono.erbts.LATITUDE</code>.
     */
    public final TableField<ErbtsRecord, String> LATITUDE = createField("LATITUDE", org.jooq.impl.SQLDataType.CHAR(16), this, "");

    /**
     * The column <code>chrono.erbts.LONGITUDE</code>.
     */
    public final TableField<ErbtsRecord, String> LONGITUDE = createField("LONGITUDE", org.jooq.impl.SQLDataType.CHAR(16), this, "");

    /**
     * The column <code>chrono.erbts.SWVERSION</code>.
     */
    public final TableField<ErbtsRecord, String> SWVERSION = createField("SWVERSION", org.jooq.impl.SQLDataType.CHAR(32), this, "");

    /**
     * The column <code>chrono.erbts.erbts_remark</code>.
     */
    public final TableField<ErbtsRecord, String> ERBTS_REMARK = createField("erbts_remark", org.jooq.impl.SQLDataType.CLOB, this, "");

    /**
     * The column <code>chrono.erbts.EXTPROP1</code>.
     */
    public final TableField<ErbtsRecord, Integer> EXTPROP1 = createField("EXTPROP1", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.erbts.EXTPROP2</code>.
     */
    public final TableField<ErbtsRecord, String> EXTPROP2 = createField("EXTPROP2", org.jooq.impl.SQLDataType.CHAR(8), this, "");

    /**
     * Create a <code>chrono.erbts</code> table reference
     */
    public Erbts() {
        this(DSL.name("erbts"), null);
    }

    /**
     * Create an aliased <code>chrono.erbts</code> table reference
     */
    public Erbts(String alias) {
        this(DSL.name(alias), ERBTS);
    }

    /**
     * Create an aliased <code>chrono.erbts</code> table reference
     */
    public Erbts(Name alias) {
        this(alias, ERBTS);
    }

    private Erbts(Name alias, Table<ErbtsRecord> aliased) {
        this(alias, aliased, null);
    }

    private Erbts(Name alias, Table<ErbtsRecord> aliased, Field<?>[] parameters) {
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
    public List<Index> getIndexes() {
        return Arrays.<Index>asList(Indexes.ERBTS_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<ErbtsRecord> getPrimaryKey() {
        return Keys.KEY_ERBTS_PRIMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<ErbtsRecord>> getKeys() {
        return Arrays.<UniqueKey<ErbtsRecord>>asList(Keys.KEY_ERBTS_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Erbts as(String alias) {
        return new Erbts(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Erbts as(Name alias) {
        return new Erbts(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Erbts rename(String name) {
        return new Erbts(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Erbts rename(Name name) {
        return new Erbts(name, null);
    }
}

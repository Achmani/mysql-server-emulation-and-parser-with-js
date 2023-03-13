/*
 * This file is generated by jOOQ.
*/
package id.mit.chrono.server.model.tables;


import id.mit.chrono.server.model.Chrono;
import id.mit.chrono.server.model.Keys;
import id.mit.chrono.server.model.tables.records.CrranbtsRecord;

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
public class Crranbts extends TableImpl<CrranbtsRecord> {

    private static final long serialVersionUID = 391451696;

    /**
     * The reference instance of <code>chrono.crranbts</code>
     */
    public static final Crranbts CRRANBTS = new Crranbts();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<CrranbtsRecord> getRecordType() {
        return CrranbtsRecord.class;
    }

    /**
     * The column <code>chrono.crranbts.ranbts_id</code>.
     */
    public final TableField<CrranbtsRecord, ULong> RANBTS_ID = createField("ranbts_id", org.jooq.impl.SQLDataType.BIGINTUNSIGNED.nullable(false), this, "");

    /**
     * The column <code>chrono.crranbts.ranbts_date</code>.
     */
    public final TableField<CrranbtsRecord, UInteger> RANBTS_DATE = createField("ranbts_date", org.jooq.impl.SQLDataType.INTEGERUNSIGNED.nullable(false), this, "");

    /**
     * The column <code>chrono.crranbts.ranbts_datefrom</code>.
     */
    public final TableField<CrranbtsRecord, Integer> RANBTS_DATEFROM = createField("ranbts_datefrom", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.crranbts.ranbts_key</code>.
     */
    public final TableField<CrranbtsRecord, String> RANBTS_KEY = createField("ranbts_key", org.jooq.impl.SQLDataType.CHAR(32).nullable(false), this, "");

    /**
     * The column <code>chrono.crranbts.ranbts_node</code>.
     */
    public final TableField<CrranbtsRecord, Integer> RANBTS_NODE = createField("ranbts_node", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.crranbts.ranbts_nodestatus</code>.
     */
    public final TableField<CrranbtsRecord, Integer> RANBTS_NODESTATUS = createField("ranbts_nodestatus", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.crranbts.ranbts_vendor</code>.
     */
    public final TableField<CrranbtsRecord, Integer> RANBTS_VENDOR = createField("ranbts_vendor", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.crranbts.ranbts_namingvalid</code>.
     */
    public final TableField<CrranbtsRecord, Byte> RANBTS_NAMINGVALID = createField("ranbts_namingvalid", org.jooq.impl.SQLDataType.TINYINT, this, "");

    /**
     * The column <code>chrono.crranbts.ranbts_src</code>.
     */
    public final TableField<CrranbtsRecord, String> RANBTS_SRC = createField("ranbts_src", org.jooq.impl.SQLDataType.CHAR(12), this, "");

    /**
     * The column <code>chrono.crranbts.ranbts_refid</code>.
     */
    public final TableField<CrranbtsRecord, ULong> RANBTS_REFID = createField("ranbts_refid", org.jooq.impl.SQLDataType.BIGINTUNSIGNED.nullable(false), this, "");

    /**
     * The column <code>chrono.crranbts.CONTROLLER</code>.
     */
    public final TableField<CrranbtsRecord, String> CONTROLLER = createField("CONTROLLER", org.jooq.impl.SQLDataType.CHAR(32), this, "");

    /**
     * The column <code>chrono.crranbts.BTSINDEX</code>.
     */
    public final TableField<CrranbtsRecord, String> BTSINDEX = createField("BTSINDEX", org.jooq.impl.SQLDataType.CHAR(96), this, "");

    /**
     * The column <code>chrono.crranbts.BTSNAME</code>.
     */
    public final TableField<CrranbtsRecord, String> BTSNAME = createField("BTSNAME", org.jooq.impl.SQLDataType.CHAR(32), this, "");

    /**
     * The column <code>chrono.crranbts.SWVERSION</code>.
     */
    public final TableField<CrranbtsRecord, String> SWVERSION = createField("SWVERSION", org.jooq.impl.SQLDataType.CHAR(32), this, "");

    /**
     * The column <code>chrono.crranbts.TOTALTRX</code>.
     */
    public final TableField<CrranbtsRecord, Integer> TOTALTRX = createField("TOTALTRX", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.crranbts.TOTALCELL</code>.
     */
    public final TableField<CrranbtsRecord, Integer> TOTALCELL = createField("TOTALCELL", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * Create a <code>chrono.crranbts</code> table reference
     */
    public Crranbts() {
        this(DSL.name("crranbts"), null);
    }

    /**
     * Create an aliased <code>chrono.crranbts</code> table reference
     */
    public Crranbts(String alias) {
        this(DSL.name(alias), CRRANBTS);
    }

    /**
     * Create an aliased <code>chrono.crranbts</code> table reference
     */
    public Crranbts(Name alias) {
        this(alias, CRRANBTS);
    }

    private Crranbts(Name alias, Table<CrranbtsRecord> aliased) {
        this(alias, aliased, null);
    }

    private Crranbts(Name alias, Table<CrranbtsRecord> aliased, Field<?>[] parameters) {
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
    public UniqueKey<CrranbtsRecord> getPrimaryKey() {
        return Keys.KEY_CRRANBTS_PRIMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<CrranbtsRecord>> getKeys() {
        return Arrays.<UniqueKey<CrranbtsRecord>>asList(Keys.KEY_CRRANBTS_PRIMARY, Keys.KEY_CRRANBTS_RANBTS_DATE_2);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Crranbts as(String alias) {
        return new Crranbts(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Crranbts as(Name alias) {
        return new Crranbts(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Crranbts rename(String name) {
        return new Crranbts(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Crranbts rename(Name name) {
        return new Crranbts(name, null);
    }
}

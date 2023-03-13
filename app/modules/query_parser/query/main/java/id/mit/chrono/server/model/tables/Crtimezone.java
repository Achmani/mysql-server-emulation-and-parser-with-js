/*
 * This file is generated by jOOQ.
*/
package id.mit.chrono.server.model.tables;


import id.mit.chrono.server.model.Chrono;
import id.mit.chrono.server.model.Indexes;
import id.mit.chrono.server.model.Keys;
import id.mit.chrono.server.model.tables.records.CrtimezoneRecord;

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
public class Crtimezone extends TableImpl<CrtimezoneRecord> {

    private static final long serialVersionUID = -639543271;

    /**
     * The reference instance of <code>chrono.crtimezone</code>
     */
    public static final Crtimezone CRTIMEZONE = new Crtimezone();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<CrtimezoneRecord> getRecordType() {
        return CrtimezoneRecord.class;
    }

    /**
     * The column <code>chrono.crtimezone.timezone_id</code>.
     */
    public final TableField<CrtimezoneRecord, Integer> TIMEZONE_ID = createField("timezone_id", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>chrono.crtimezone.timezone_code</code>.
     */
    public final TableField<CrtimezoneRecord, String> TIMEZONE_CODE = createField("timezone_code", org.jooq.impl.SQLDataType.CHAR(32), this, "");

    /**
     * The column <code>chrono.crtimezone.timezone_name</code>.
     */
    public final TableField<CrtimezoneRecord, String> TIMEZONE_NAME = createField("timezone_name", org.jooq.impl.SQLDataType.CHAR(16), this, "");

    /**
     * The column <code>chrono.crtimezone.timezone_diff</code>.
     */
    public final TableField<CrtimezoneRecord, Integer> TIMEZONE_DIFF = createField("timezone_diff", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.crtimezone.timezone_alias</code>.
     */
    public final TableField<CrtimezoneRecord, String> TIMEZONE_ALIAS = createField("timezone_alias", org.jooq.impl.SQLDataType.CHAR(16), this, "");

    /**
     * The column <code>chrono.crtimezone.timezone_sysdefault</code>.
     */
    public final TableField<CrtimezoneRecord, Byte> TIMEZONE_SYSDEFAULT = createField("timezone_sysdefault", org.jooq.impl.SQLDataType.TINYINT, this, "");

    /**
     * Create a <code>chrono.crtimezone</code> table reference
     */
    public Crtimezone() {
        this(DSL.name("crtimezone"), null);
    }

    /**
     * Create an aliased <code>chrono.crtimezone</code> table reference
     */
    public Crtimezone(String alias) {
        this(DSL.name(alias), CRTIMEZONE);
    }

    /**
     * Create an aliased <code>chrono.crtimezone</code> table reference
     */
    public Crtimezone(Name alias) {
        this(alias, CRTIMEZONE);
    }

    private Crtimezone(Name alias, Table<CrtimezoneRecord> aliased) {
        this(alias, aliased, null);
    }

    private Crtimezone(Name alias, Table<CrtimezoneRecord> aliased, Field<?>[] parameters) {
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
        return Arrays.<Index>asList(Indexes.CRTIMEZONE_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<CrtimezoneRecord> getPrimaryKey() {
        return Keys.KEY_CRTIMEZONE_PRIMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<CrtimezoneRecord>> getKeys() {
        return Arrays.<UniqueKey<CrtimezoneRecord>>asList(Keys.KEY_CRTIMEZONE_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Crtimezone as(String alias) {
        return new Crtimezone(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Crtimezone as(Name alias) {
        return new Crtimezone(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Crtimezone rename(String name) {
        return new Crtimezone(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Crtimezone rename(Name name) {
        return new Crtimezone(name, null);
    }
}

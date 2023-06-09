/*
 * This file is generated by jOOQ.
*/
package id.mit.chrono.server.model.tables;


import id.mit.chrono.server.model.Chrono;
import id.mit.chrono.server.model.Keys;
import id.mit.chrono.server.model.tables.records.CrflagRecord;

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
public class Crflag extends TableImpl<CrflagRecord> {

    private static final long serialVersionUID = -75799362;

    /**
     * The reference instance of <code>chrono.crflag</code>
     */
    public static final Crflag CRFLAG = new Crflag();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<CrflagRecord> getRecordType() {
        return CrflagRecord.class;
    }

    /**
     * The column <code>chrono.crflag.flag_id</code>.
     */
    public final TableField<CrflagRecord, UInteger> FLAG_ID = createField("flag_id", org.jooq.impl.SQLDataType.INTEGERUNSIGNED.nullable(false), this, "");

    /**
     * The column <code>chrono.crflag.flag_code</code>.
     */
    public final TableField<CrflagRecord, String> FLAG_CODE = createField("flag_code", org.jooq.impl.SQLDataType.CHAR(32), this, "");

    /**
     * The column <code>chrono.crflag.flag_name</code>.
     */
    public final TableField<CrflagRecord, String> FLAG_NAME = createField("flag_name", org.jooq.impl.SQLDataType.CHAR(64), this, "");

    /**
     * Create a <code>chrono.crflag</code> table reference
     */
    public Crflag() {
        this(DSL.name("crflag"), null);
    }

    /**
     * Create an aliased <code>chrono.crflag</code> table reference
     */
    public Crflag(String alias) {
        this(DSL.name(alias), CRFLAG);
    }

    /**
     * Create an aliased <code>chrono.crflag</code> table reference
     */
    public Crflag(Name alias) {
        this(alias, CRFLAG);
    }

    private Crflag(Name alias, Table<CrflagRecord> aliased) {
        this(alias, aliased, null);
    }

    private Crflag(Name alias, Table<CrflagRecord> aliased, Field<?>[] parameters) {
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
    public UniqueKey<CrflagRecord> getPrimaryKey() {
        return Keys.KEY_CRFLAG_PRIMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<CrflagRecord>> getKeys() {
        return Arrays.<UniqueKey<CrflagRecord>>asList(Keys.KEY_CRFLAG_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Crflag as(String alias) {
        return new Crflag(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Crflag as(Name alias) {
        return new Crflag(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Crflag rename(String name) {
        return new Crflag(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Crflag rename(Name name) {
        return new Crflag(name, null);
    }
}

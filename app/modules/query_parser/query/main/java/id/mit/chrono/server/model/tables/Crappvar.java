/*
 * This file is generated by jOOQ.
*/
package id.mit.chrono.server.model.tables;


import id.mit.chrono.server.model.Chrono;
import id.mit.chrono.server.model.Indexes;
import id.mit.chrono.server.model.Keys;
import id.mit.chrono.server.model.tables.records.CrappvarRecord;

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
public class Crappvar extends TableImpl<CrappvarRecord> {

    private static final long serialVersionUID = 335127742;

    /**
     * The reference instance of <code>chrono.crappvar</code>
     */
    public static final Crappvar CRAPPVAR = new Crappvar();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<CrappvarRecord> getRecordType() {
        return CrappvarRecord.class;
    }

    /**
     * The column <code>chrono.crappvar.appvar_id</code>.
     */
    public final TableField<CrappvarRecord, Integer> APPVAR_ID = createField("appvar_id", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>chrono.crappvar.appvar_code</code>.
     */
    public final TableField<CrappvarRecord, String> APPVAR_CODE = createField("appvar_code", org.jooq.impl.SQLDataType.VARCHAR(32), this, "");

    /**
     * The column <code>chrono.crappvar.appvar_name</code>.
     */
    public final TableField<CrappvarRecord, String> APPVAR_NAME = createField("appvar_name", org.jooq.impl.SQLDataType.VARCHAR(128), this, "");

    /**
     * The column <code>chrono.crappvar.appvar_value</code>.
     */
    public final TableField<CrappvarRecord, String> APPVAR_VALUE = createField("appvar_value", org.jooq.impl.SQLDataType.CLOB, this, "");

    /**
     * The column <code>chrono.crappvar.appvar_ispublic</code>.
     */
    public final TableField<CrappvarRecord, Byte> APPVAR_ISPUBLIC = createField("appvar_ispublic", org.jooq.impl.SQLDataType.TINYINT, this, "");

    /**
     * Create a <code>chrono.crappvar</code> table reference
     */
    public Crappvar() {
        this(DSL.name("crappvar"), null);
    }

    /**
     * Create an aliased <code>chrono.crappvar</code> table reference
     */
    public Crappvar(String alias) {
        this(DSL.name(alias), CRAPPVAR);
    }

    /**
     * Create an aliased <code>chrono.crappvar</code> table reference
     */
    public Crappvar(Name alias) {
        this(alias, CRAPPVAR);
    }

    private Crappvar(Name alias, Table<CrappvarRecord> aliased) {
        this(alias, aliased, null);
    }

    private Crappvar(Name alias, Table<CrappvarRecord> aliased, Field<?>[] parameters) {
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
        return Arrays.<Index>asList(Indexes.CRAPPVAR_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<CrappvarRecord> getPrimaryKey() {
        return Keys.KEY_CRAPPVAR_PRIMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<CrappvarRecord>> getKeys() {
        return Arrays.<UniqueKey<CrappvarRecord>>asList(Keys.KEY_CRAPPVAR_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Crappvar as(String alias) {
        return new Crappvar(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Crappvar as(Name alias) {
        return new Crappvar(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Crappvar rename(String name) {
        return new Crappvar(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Crappvar rename(Name name) {
        return new Crappvar(name, null);
    }
}
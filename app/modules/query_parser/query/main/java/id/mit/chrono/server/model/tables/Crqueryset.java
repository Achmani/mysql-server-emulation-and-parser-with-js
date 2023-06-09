/*
 * This file is generated by jOOQ.
*/
package id.mit.chrono.server.model.tables;


import id.mit.chrono.server.model.Chrono;
import id.mit.chrono.server.model.Keys;
import id.mit.chrono.server.model.tables.records.CrquerysetRecord;

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
public class Crqueryset extends TableImpl<CrquerysetRecord> {

    private static final long serialVersionUID = 1259512275;

    /**
     * The reference instance of <code>chrono.crqueryset</code>
     */
    public static final Crqueryset CRQUERYSET = new Crqueryset();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<CrquerysetRecord> getRecordType() {
        return CrquerysetRecord.class;
    }

    /**
     * The column <code>chrono.crqueryset.queryset_id</code>.
     */
    public final TableField<CrquerysetRecord, UInteger> QUERYSET_ID = createField("queryset_id", org.jooq.impl.SQLDataType.INTEGERUNSIGNED.nullable(false), this, "");

    /**
     * The column <code>chrono.crqueryset.queryset_code</code>.
     */
    public final TableField<CrquerysetRecord, String> QUERYSET_CODE = createField("queryset_code", org.jooq.impl.SQLDataType.CHAR(8), this, "");

    /**
     * The column <code>chrono.crqueryset.queryset_vendor</code>.
     */
    public final TableField<CrquerysetRecord, Integer> QUERYSET_VENDOR = createField("queryset_vendor", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.crqueryset.queryset_datagroup</code>.
     */
    public final TableField<CrquerysetRecord, Integer> QUERYSET_DATAGROUP = createField("queryset_datagroup", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.crqueryset.queryset_datasourcetype</code>.
     */
    public final TableField<CrquerysetRecord, Integer> QUERYSET_DATASOURCETYPE = createField("queryset_datasourcetype", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.crqueryset.queryset_entitygroup</code>.
     */
    public final TableField<CrquerysetRecord, String> QUERYSET_ENTITYGROUP = createField("queryset_entitygroup", org.jooq.impl.SQLDataType.CHAR(10), this, "");

    /**
     * The column <code>chrono.crqueryset.queryset_entity</code>.
     */
    public final TableField<CrquerysetRecord, String> QUERYSET_ENTITY = createField("queryset_entity", org.jooq.impl.SQLDataType.CHAR(24), this, "");

    /**
     * The column <code>chrono.crqueryset.queryset_tabletarget</code>.
     */
    public final TableField<CrquerysetRecord, String> QUERYSET_TABLETARGET = createField("queryset_tabletarget", org.jooq.impl.SQLDataType.CHAR(32), this, "");

    /**
     * The column <code>chrono.crqueryset.queryset_mo_level</code>.
     */
    public final TableField<CrquerysetRecord, String> QUERYSET_MO_LEVEL = createField("queryset_mo_level", org.jooq.impl.SQLDataType.CHAR(24), this, "");

    /**
     * The column <code>chrono.crqueryset.queryset_sql</code>.
     */
    public final TableField<CrquerysetRecord, String> QUERYSET_SQL = createField("queryset_sql", org.jooq.impl.SQLDataType.CLOB, this, "");

    /**
     * The column <code>chrono.crqueryset.queryset_nodecategory</code>.
     */
    public final TableField<CrquerysetRecord, Integer> QUERYSET_NODECATEGORY = createField("queryset_nodecategory", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.crqueryset.queryset_enabled</code>.
     */
    public final TableField<CrquerysetRecord, Byte> QUERYSET_ENABLED = createField("queryset_enabled", org.jooq.impl.SQLDataType.TINYINT, this, "");

    /**
     * The column <code>chrono.crqueryset.queryset_description</code>.
     */
    public final TableField<CrquerysetRecord, String> QUERYSET_DESCRIPTION = createField("queryset_description", org.jooq.impl.SQLDataType.CLOB, this, "");

    /**
     * Create a <code>chrono.crqueryset</code> table reference
     */
    public Crqueryset() {
        this(DSL.name("crqueryset"), null);
    }

    /**
     * Create an aliased <code>chrono.crqueryset</code> table reference
     */
    public Crqueryset(String alias) {
        this(DSL.name(alias), CRQUERYSET);
    }

    /**
     * Create an aliased <code>chrono.crqueryset</code> table reference
     */
    public Crqueryset(Name alias) {
        this(alias, CRQUERYSET);
    }

    private Crqueryset(Name alias, Table<CrquerysetRecord> aliased) {
        this(alias, aliased, null);
    }

    private Crqueryset(Name alias, Table<CrquerysetRecord> aliased, Field<?>[] parameters) {
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
    public UniqueKey<CrquerysetRecord> getPrimaryKey() {
        return Keys.KEY_CRQUERYSET_PRIMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<CrquerysetRecord>> getKeys() {
        return Arrays.<UniqueKey<CrquerysetRecord>>asList(Keys.KEY_CRQUERYSET_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Crqueryset as(String alias) {
        return new Crqueryset(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Crqueryset as(Name alias) {
        return new Crqueryset(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Crqueryset rename(String name) {
        return new Crqueryset(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Crqueryset rename(Name name) {
        return new Crqueryset(name, null);
    }
}

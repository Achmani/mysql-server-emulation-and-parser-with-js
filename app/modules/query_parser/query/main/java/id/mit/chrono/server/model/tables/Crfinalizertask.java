/*
 * This file is generated by jOOQ.
*/
package id.mit.chrono.server.model.tables;


import id.mit.chrono.server.model.Chrono;
import id.mit.chrono.server.model.Keys;
import id.mit.chrono.server.model.tables.records.CrfinalizertaskRecord;

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
public class Crfinalizertask extends TableImpl<CrfinalizertaskRecord> {

    private static final long serialVersionUID = 165396315;

    /**
     * The reference instance of <code>chrono.crfinalizertask</code>
     */
    public static final Crfinalizertask CRFINALIZERTASK = new Crfinalizertask();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<CrfinalizertaskRecord> getRecordType() {
        return CrfinalizertaskRecord.class;
    }

    /**
     * The column <code>chrono.crfinalizertask.finalizertask_id</code>.
     */
    public final TableField<CrfinalizertaskRecord, Integer> FINALIZERTASK_ID = createField("finalizertask_id", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>chrono.crfinalizertask.finalizertask_code</code>.
     */
    public final TableField<CrfinalizertaskRecord, String> FINALIZERTASK_CODE = createField("finalizertask_code", org.jooq.impl.SQLDataType.CHAR(64), this, "");

    /**
     * The column <code>chrono.crfinalizertask.finalizertask_tasktype</code>.
     */
    public final TableField<CrfinalizertaskRecord, String> FINALIZERTASK_TASKTYPE = createField("finalizertask_tasktype", org.jooq.impl.SQLDataType.CHAR(32), this, "");

    /**
     * The column <code>chrono.crfinalizertask.finalizertask_query</code>.
     */
    public final TableField<CrfinalizertaskRecord, String> FINALIZERTASK_QUERY = createField("finalizertask_query", org.jooq.impl.SQLDataType.CLOB, this, "");

    /**
     * The column <code>chrono.crfinalizertask.finalizertask_name</code>.
     */
    public final TableField<CrfinalizertaskRecord, String> FINALIZERTASK_NAME = createField("finalizertask_name", org.jooq.impl.SQLDataType.CHAR(16), this, "");

    /**
     * The column <code>chrono.crfinalizertask.finalizertask_columns</code>.
     */
    public final TableField<CrfinalizertaskRecord, String> FINALIZERTASK_COLUMNS = createField("finalizertask_columns", org.jooq.impl.SQLDataType.CLOB, this, "");

    /**
     * The column <code>chrono.crfinalizertask.finalizertask_columnstarget</code>.
     */
    public final TableField<CrfinalizertaskRecord, String> FINALIZERTASK_COLUMNSTARGET = createField("finalizertask_columnstarget", org.jooq.impl.SQLDataType.CLOB, this, "");

    /**
     * The column <code>chrono.crfinalizertask.finalizertask_customtarget</code>.
     */
    public final TableField<CrfinalizertaskRecord, String> FINALIZERTASK_CUSTOMTARGET = createField("finalizertask_customtarget", org.jooq.impl.SQLDataType.CLOB, this, "");

    /**
     * The column <code>chrono.crfinalizertask.finalizertask_customfunction</code>.
     */
    public final TableField<CrfinalizertaskRecord, String> FINALIZERTASK_CUSTOMFUNCTION = createField("finalizertask_customfunction", org.jooq.impl.SQLDataType.CLOB, this, "");

    /**
     * The column <code>chrono.crfinalizertask.finalizertask_enabled</code>.
     */
    public final TableField<CrfinalizertaskRecord, Byte> FINALIZERTASK_ENABLED = createField("finalizertask_enabled", org.jooq.impl.SQLDataType.TINYINT, this, "");

    /**
     * Create a <code>chrono.crfinalizertask</code> table reference
     */
    public Crfinalizertask() {
        this(DSL.name("crfinalizertask"), null);
    }

    /**
     * Create an aliased <code>chrono.crfinalizertask</code> table reference
     */
    public Crfinalizertask(String alias) {
        this(DSL.name(alias), CRFINALIZERTASK);
    }

    /**
     * Create an aliased <code>chrono.crfinalizertask</code> table reference
     */
    public Crfinalizertask(Name alias) {
        this(alias, CRFINALIZERTASK);
    }

    private Crfinalizertask(Name alias, Table<CrfinalizertaskRecord> aliased) {
        this(alias, aliased, null);
    }

    private Crfinalizertask(Name alias, Table<CrfinalizertaskRecord> aliased, Field<?>[] parameters) {
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
    public UniqueKey<CrfinalizertaskRecord> getPrimaryKey() {
        return Keys.KEY_CRFINALIZERTASK_PRIMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<CrfinalizertaskRecord>> getKeys() {
        return Arrays.<UniqueKey<CrfinalizertaskRecord>>asList(Keys.KEY_CRFINALIZERTASK_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Crfinalizertask as(String alias) {
        return new Crfinalizertask(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Crfinalizertask as(Name alias) {
        return new Crfinalizertask(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Crfinalizertask rename(String name) {
        return new Crfinalizertask(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Crfinalizertask rename(Name name) {
        return new Crfinalizertask(name, null);
    }
}

/*
 * This file is generated by jOOQ.
*/
package id.mit.chrono.server.model.tables;


import id.mit.chrono.server.model.Chrono;
import id.mit.chrono.server.model.Keys;
import id.mit.chrono.server.model.tables.records.CrdatasourcecommandsRecord;

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
public class Crdatasourcecommands extends TableImpl<CrdatasourcecommandsRecord> {

    private static final long serialVersionUID = -2002972527;

    /**
     * The reference instance of <code>chrono.crdatasourcecommands</code>
     */
    public static final Crdatasourcecommands CRDATASOURCECOMMANDS = new Crdatasourcecommands();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<CrdatasourcecommandsRecord> getRecordType() {
        return CrdatasourcecommandsRecord.class;
    }

    /**
     * The column <code>chrono.crdatasourcecommands.datasourcecommands_id</code>.
     */
    public final TableField<CrdatasourcecommandsRecord, Integer> DATASOURCECOMMANDS_ID = createField("datasourcecommands_id", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>chrono.crdatasourcecommands.datasourcecommands_datasource</code>.
     */
    public final TableField<CrdatasourcecommandsRecord, Integer> DATASOURCECOMMANDS_DATASOURCE = createField("datasourcecommands_datasource", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.crdatasourcecommands.datasourcecommands_type</code>.
     */
    public final TableField<CrdatasourcecommandsRecord, String> DATASOURCECOMMANDS_TYPE = createField("datasourcecommands_type", org.jooq.impl.SQLDataType.CHAR(32), this, "");

    /**
     * The column <code>chrono.crdatasourcecommands.datasourcecommands_command</code>.
     */
    public final TableField<CrdatasourcecommandsRecord, String> DATASOURCECOMMANDS_COMMAND = createField("datasourcecommands_command", org.jooq.impl.SQLDataType.CLOB, this, "");

    /**
     * The column <code>chrono.crdatasourcecommands.datasourcecommands_outputtarget</code>.
     */
    public final TableField<CrdatasourcecommandsRecord, String> DATASOURCECOMMANDS_OUTPUTTARGET = createField("datasourcecommands_outputtarget", org.jooq.impl.SQLDataType.CHAR(24), this, "");

    /**
     * The column <code>chrono.crdatasourcecommands.datasourcecommands_outputformat</code>.
     */
    public final TableField<CrdatasourcecommandsRecord, String> DATASOURCECOMMANDS_OUTPUTFORMAT = createField("datasourcecommands_outputformat", org.jooq.impl.SQLDataType.CHAR(16), this, "");

    /**
     * The column <code>chrono.crdatasourcecommands.datasourcecommands_outputlocation</code>.
     */
    public final TableField<CrdatasourcecommandsRecord, String> DATASOURCECOMMANDS_OUTPUTLOCATION = createField("datasourcecommands_outputlocation", org.jooq.impl.SQLDataType.CHAR(24), this, "");

    /**
     * The column <code>chrono.crdatasourcecommands.datasourcecommands_description</code>.
     */
    public final TableField<CrdatasourcecommandsRecord, String> DATASOURCECOMMANDS_DESCRIPTION = createField("datasourcecommands_description", org.jooq.impl.SQLDataType.CLOB, this, "");

    /**
     * Create a <code>chrono.crdatasourcecommands</code> table reference
     */
    public Crdatasourcecommands() {
        this(DSL.name("crdatasourcecommands"), null);
    }

    /**
     * Create an aliased <code>chrono.crdatasourcecommands</code> table reference
     */
    public Crdatasourcecommands(String alias) {
        this(DSL.name(alias), CRDATASOURCECOMMANDS);
    }

    /**
     * Create an aliased <code>chrono.crdatasourcecommands</code> table reference
     */
    public Crdatasourcecommands(Name alias) {
        this(alias, CRDATASOURCECOMMANDS);
    }

    private Crdatasourcecommands(Name alias, Table<CrdatasourcecommandsRecord> aliased) {
        this(alias, aliased, null);
    }

    private Crdatasourcecommands(Name alias, Table<CrdatasourcecommandsRecord> aliased, Field<?>[] parameters) {
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
    public UniqueKey<CrdatasourcecommandsRecord> getPrimaryKey() {
        return Keys.KEY_CRDATASOURCECOMMANDS_PRIMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<CrdatasourcecommandsRecord>> getKeys() {
        return Arrays.<UniqueKey<CrdatasourcecommandsRecord>>asList(Keys.KEY_CRDATASOURCECOMMANDS_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Crdatasourcecommands as(String alias) {
        return new Crdatasourcecommands(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Crdatasourcecommands as(Name alias) {
        return new Crdatasourcecommands(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Crdatasourcecommands rename(String name) {
        return new Crdatasourcecommands(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Crdatasourcecommands rename(Name name) {
        return new Crdatasourcecommands(name, null);
    }
}

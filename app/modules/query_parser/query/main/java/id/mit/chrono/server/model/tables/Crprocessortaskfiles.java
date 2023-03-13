/*
 * This file is generated by jOOQ.
*/
package id.mit.chrono.server.model.tables;


import id.mit.chrono.server.model.Chrono;
import id.mit.chrono.server.model.Keys;
import id.mit.chrono.server.model.tables.records.CrprocessortaskfilesRecord;

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
public class Crprocessortaskfiles extends TableImpl<CrprocessortaskfilesRecord> {

    private static final long serialVersionUID = 2034668214;

    /**
     * The reference instance of <code>chrono.crprocessortaskfiles</code>
     */
    public static final Crprocessortaskfiles CRPROCESSORTASKFILES = new Crprocessortaskfiles();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<CrprocessortaskfilesRecord> getRecordType() {
        return CrprocessortaskfilesRecord.class;
    }

    /**
     * The column <code>chrono.crprocessortaskfiles.processortaskfiles_id</code>.
     */
    public final TableField<CrprocessortaskfilesRecord, Long> PROCESSORTASKFILES_ID = createField("processortaskfiles_id", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>chrono.crprocessortaskfiles.crprocessortaskfiles_date</code>.
     */
    public final TableField<CrprocessortaskfilesRecord, Integer> CRPROCESSORTASKFILES_DATE = createField("crprocessortaskfiles_date", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>chrono.crprocessortaskfiles.processortaskfiles_collectortaskfiles</code>.
     */
    public final TableField<CrprocessortaskfilesRecord, Long> PROCESSORTASKFILES_COLLECTORTASKFILES = createField("processortaskfiles_collectortaskfiles", org.jooq.impl.SQLDataType.BIGINT, this, "");

    /**
     * The column <code>chrono.crprocessortaskfiles.processortaskfiles_datasource</code>.
     */
    public final TableField<CrprocessortaskfilesRecord, Integer> PROCESSORTASKFILES_DATASOURCE = createField("processortaskfiles_datasource", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.crprocessortaskfiles.processortaskfiles_remotedir</code>.
     */
    public final TableField<CrprocessortaskfilesRecord, String> PROCESSORTASKFILES_REMOTEDIR = createField("processortaskfiles_remotedir", org.jooq.impl.SQLDataType.CLOB, this, "");

    /**
     * The column <code>chrono.crprocessortaskfiles.processortaskfiles_remotefilename</code>.
     */
    public final TableField<CrprocessortaskfilesRecord, String> PROCESSORTASKFILES_REMOTEFILENAME = createField("processortaskfiles_remotefilename", org.jooq.impl.SQLDataType.CHAR(255), this, "");

    /**
     * The column <code>chrono.crprocessortaskfiles.processortaskfiles_localdir</code>.
     */
    public final TableField<CrprocessortaskfilesRecord, String> PROCESSORTASKFILES_LOCALDIR = createField("processortaskfiles_localdir", org.jooq.impl.SQLDataType.CLOB, this, "");

    /**
     * The column <code>chrono.crprocessortaskfiles.processortaskfiles_localfilename</code>.
     */
    public final TableField<CrprocessortaskfilesRecord, String> PROCESSORTASKFILES_LOCALFILENAME = createField("processortaskfiles_localfilename", org.jooq.impl.SQLDataType.CHAR(255), this, "");

    /**
     * The column <code>chrono.crprocessortaskfiles.processortaskfiles_created</code>.
     */
    public final TableField<CrprocessortaskfilesRecord, Integer> PROCESSORTASKFILES_CREATED = createField("processortaskfiles_created", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.crprocessortaskfiles.processortaskfiles_added</code>.
     */
    public final TableField<CrprocessortaskfilesRecord, Integer> PROCESSORTASKFILES_ADDED = createField("processortaskfiles_added", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.crprocessortaskfiles.processortaskfiles_modified</code>.
     */
    public final TableField<CrprocessortaskfilesRecord, Integer> PROCESSORTASKFILES_MODIFIED = createField("processortaskfiles_modified", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.crprocessortaskfiles.processortaskfiles_size</code>.
     */
    public final TableField<CrprocessortaskfilesRecord, Long> PROCESSORTASKFILES_SIZE = createField("processortaskfiles_size", org.jooq.impl.SQLDataType.BIGINT, this, "");

    /**
     * The column <code>chrono.crprocessortaskfiles.processortaskfiles_type</code>.
     */
    public final TableField<CrprocessortaskfilesRecord, String> PROCESSORTASKFILES_TYPE = createField("processortaskfiles_type", org.jooq.impl.SQLDataType.CHAR(8), this, "");

    /**
     * The column <code>chrono.crprocessortaskfiles.processortaskfiles_checksum</code>.
     */
    public final TableField<CrprocessortaskfilesRecord, String> PROCESSORTASKFILES_CHECKSUM = createField("processortaskfiles_checksum", org.jooq.impl.SQLDataType.CHAR(32), this, "");

    /**
     * The column <code>chrono.crprocessortaskfiles.processortaskfiles_processtime</code>.
     */
    public final TableField<CrprocessortaskfilesRecord, Integer> PROCESSORTASKFILES_PROCESSTIME = createField("processortaskfiles_processtime", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.crprocessortaskfiles.processortaskfiles_processstatus</code>.
     */
    public final TableField<CrprocessortaskfilesRecord, Integer> PROCESSORTASKFILES_PROCESSSTATUS = createField("processortaskfiles_processstatus", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.crprocessortaskfiles.processortaskfiles_processstatusreason</code>.
     */
    public final TableField<CrprocessortaskfilesRecord, String> PROCESSORTASKFILES_PROCESSSTATUSREASON = createField("processortaskfiles_processstatusreason", org.jooq.impl.SQLDataType.CLOB, this, "");

    /**
     * The column <code>chrono.crprocessortaskfiles.processortaskfiles_columnset</code>.
     */
    public final TableField<CrprocessortaskfilesRecord, Integer> PROCESSORTASKFILES_COLUMNSET = createField("processortaskfiles_columnset", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * Create a <code>chrono.crprocessortaskfiles</code> table reference
     */
    public Crprocessortaskfiles() {
        this(DSL.name("crprocessortaskfiles"), null);
    }

    /**
     * Create an aliased <code>chrono.crprocessortaskfiles</code> table reference
     */
    public Crprocessortaskfiles(String alias) {
        this(DSL.name(alias), CRPROCESSORTASKFILES);
    }

    /**
     * Create an aliased <code>chrono.crprocessortaskfiles</code> table reference
     */
    public Crprocessortaskfiles(Name alias) {
        this(alias, CRPROCESSORTASKFILES);
    }

    private Crprocessortaskfiles(Name alias, Table<CrprocessortaskfilesRecord> aliased) {
        this(alias, aliased, null);
    }

    private Crprocessortaskfiles(Name alias, Table<CrprocessortaskfilesRecord> aliased, Field<?>[] parameters) {
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
    public UniqueKey<CrprocessortaskfilesRecord> getPrimaryKey() {
        return Keys.KEY_CRPROCESSORTASKFILES_PRIMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<CrprocessortaskfilesRecord>> getKeys() {
        return Arrays.<UniqueKey<CrprocessortaskfilesRecord>>asList(Keys.KEY_CRPROCESSORTASKFILES_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Crprocessortaskfiles as(String alias) {
        return new Crprocessortaskfiles(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Crprocessortaskfiles as(Name alias) {
        return new Crprocessortaskfiles(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Crprocessortaskfiles rename(String name) {
        return new Crprocessortaskfiles(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Crprocessortaskfiles rename(Name name) {
        return new Crprocessortaskfiles(name, null);
    }
}
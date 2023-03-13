/*
 * This file is generated by jOOQ.
*/
package id.mit.chrono.server.model.tables;


import id.mit.chrono.server.model.Chrono;
import id.mit.chrono.server.model.Keys;
import id.mit.chrono.server.model.tables.records.CrmapnptqRecord;

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
public class Crmapnptq extends TableImpl<CrmapnptqRecord> {

    private static final long serialVersionUID = 529880715;

    /**
     * The reference instance of <code>chrono.crmapnptq</code>
     */
    public static final Crmapnptq CRMAPNPTQ = new Crmapnptq();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<CrmapnptqRecord> getRecordType() {
        return CrmapnptqRecord.class;
    }

    /**
     * The column <code>chrono.crmapnptq.crmapnptq_id</code>.
     */
    public final TableField<CrmapnptqRecord, UInteger> CRMAPNPTQ_ID = createField("crmapnptq_id", org.jooq.impl.SQLDataType.INTEGERUNSIGNED.nullable(false), this, "");

    /**
     * The column <code>chrono.crmapnptq.crmapnptq_object</code>.
     */
    public final TableField<CrmapnptqRecord, String> CRMAPNPTQ_OBJECT = createField("crmapnptq_object", org.jooq.impl.SQLDataType.CHAR(64), this, "");

    /**
     * The column <code>chrono.crmapnptq.crmapnptq_params</code>.
     */
    public final TableField<CrmapnptqRecord, String> CRMAPNPTQ_PARAMS = createField("crmapnptq_params", org.jooq.impl.SQLDataType.CHAR(128), this, "");

    /**
     * The column <code>chrono.crmapnptq.mapnptq_sourcefile</code>.
     */
    public final TableField<CrmapnptqRecord, String> MAPNPTQ_SOURCEFILE = createField("mapnptq_sourcefile", org.jooq.impl.SQLDataType.CHAR(64), this, "");

    /**
     * The column <code>chrono.crmapnptq.mapnptq_file</code>.
     */
    public final TableField<CrmapnptqRecord, String> MAPNPTQ_FILE = createField("mapnptq_file", org.jooq.impl.SQLDataType.CHAR(64), this, "");

    /**
     * The column <code>chrono.crmapnptq.mapnptq_entitygroup</code>.
     */
    public final TableField<CrmapnptqRecord, String> MAPNPTQ_ENTITYGROUP = createField("mapnptq_entitygroup", org.jooq.impl.SQLDataType.CHAR(24), this, "");

    /**
     * The column <code>chrono.crmapnptq.mapnptq_entity</code>.
     */
    public final TableField<CrmapnptqRecord, String> MAPNPTQ_ENTITY = createField("mapnptq_entity", org.jooq.impl.SQLDataType.CHAR(32), this, "");

    /**
     * The column <code>chrono.crmapnptq.crmapnptq_enable</code>.
     */
    public final TableField<CrmapnptqRecord, Byte> CRMAPNPTQ_ENABLE = createField("crmapnptq_enable", org.jooq.impl.SQLDataType.TINYINT, this, "");

    /**
     * The column <code>chrono.crmapnptq.mapnptq_alias</code>.
     */
    public final TableField<CrmapnptqRecord, String> MAPNPTQ_ALIAS = createField("mapnptq_alias", org.jooq.impl.SQLDataType.CLOB, this, "");

    /**
     * The column <code>chrono.crmapnptq.crmapnptq_backup_object</code>.
     */
    public final TableField<CrmapnptqRecord, String> CRMAPNPTQ_BACKUP_OBJECT = createField("crmapnptq_backup_object", org.jooq.impl.SQLDataType.CHAR(64), this, "");

    /**
     * The column <code>chrono.crmapnptq.crmapnptq_backup_params</code>.
     */
    public final TableField<CrmapnptqRecord, String> CRMAPNPTQ_BACKUP_PARAMS = createField("crmapnptq_backup_params", org.jooq.impl.SQLDataType.CHAR(128), this, "");

    /**
     * The column <code>chrono.crmapnptq.crmapnptq_custom_function</code>.
     */
    public final TableField<CrmapnptqRecord, String> CRMAPNPTQ_CUSTOM_FUNCTION = createField("crmapnptq_custom_function", org.jooq.impl.SQLDataType.CLOB, this, "");

    /**
     * The column <code>chrono.crmapnptq.crmapnptq_priority</code>.
     */
    public final TableField<CrmapnptqRecord, Integer> CRMAPNPTQ_PRIORITY = createField("crmapnptq_priority", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.crmapnptq.crmapnptq_mo_level</code>.
     */
    public final TableField<CrmapnptqRecord, String> CRMAPNPTQ_MO_LEVEL = createField("crmapnptq_mo_level", org.jooq.impl.SQLDataType.CHAR(64), this, "");

    /**
     * Create a <code>chrono.crmapnptq</code> table reference
     */
    public Crmapnptq() {
        this(DSL.name("crmapnptq"), null);
    }

    /**
     * Create an aliased <code>chrono.crmapnptq</code> table reference
     */
    public Crmapnptq(String alias) {
        this(DSL.name(alias), CRMAPNPTQ);
    }

    /**
     * Create an aliased <code>chrono.crmapnptq</code> table reference
     */
    public Crmapnptq(Name alias) {
        this(alias, CRMAPNPTQ);
    }

    private Crmapnptq(Name alias, Table<CrmapnptqRecord> aliased) {
        this(alias, aliased, null);
    }

    private Crmapnptq(Name alias, Table<CrmapnptqRecord> aliased, Field<?>[] parameters) {
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
    public UniqueKey<CrmapnptqRecord> getPrimaryKey() {
        return Keys.KEY_CRMAPNPTQ_PRIMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<CrmapnptqRecord>> getKeys() {
        return Arrays.<UniqueKey<CrmapnptqRecord>>asList(Keys.KEY_CRMAPNPTQ_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Crmapnptq as(String alias) {
        return new Crmapnptq(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Crmapnptq as(Name alias) {
        return new Crmapnptq(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Crmapnptq rename(String name) {
        return new Crmapnptq(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Crmapnptq rename(Name name) {
        return new Crmapnptq(name, null);
    }
}
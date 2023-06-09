/*
 * This file is generated by jOOQ.
*/
package id.mit.chrono.server.model.tables;


import id.mit.chrono.server.model.Chrono;
import id.mit.chrono.server.model.Indexes;
import id.mit.chrono.server.model.Keys;
import id.mit.chrono.server.model.tables.records.CrmapfieldRecord;

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
public class Crmapfield extends TableImpl<CrmapfieldRecord> {

    private static final long serialVersionUID = -341866370;

    /**
     * The reference instance of <code>chrono.crmapfield</code>
     */
    public static final Crmapfield CRMAPFIELD = new Crmapfield();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<CrmapfieldRecord> getRecordType() {
        return CrmapfieldRecord.class;
    }

    /**
     * The column <code>chrono.crmapfield.mapfield_id</code>.
     */
    public final TableField<CrmapfieldRecord, Integer> MAPFIELD_ID = createField("mapfield_id", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>chrono.crmapfield.mapfield_code</code>.
     */
    public final TableField<CrmapfieldRecord, String> MAPFIELD_CODE = createField("mapfield_code", org.jooq.impl.SQLDataType.CHAR(16), this, "");

    /**
     * The column <code>chrono.crmapfield.mapfield_mapentity</code>.
     */
    public final TableField<CrmapfieldRecord, Integer> MAPFIELD_MAPENTITY = createField("mapfield_mapentity", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.crmapfield.mapfield_fieldname</code>.
     */
    public final TableField<CrmapfieldRecord, String> MAPFIELD_FIELDNAME = createField("mapfield_fieldname", org.jooq.impl.SQLDataType.CHAR(32), this, "");

    /**
     * The column <code>chrono.crmapfield.mapfield_label</code>.
     */
    public final TableField<CrmapfieldRecord, String> MAPFIELD_LABEL = createField("mapfield_label", org.jooq.impl.SQLDataType.CHAR(32), this, "");

    /**
     * The column <code>chrono.crmapfield.mapfield_valuepattern</code>.
     */
    public final TableField<CrmapfieldRecord, String> MAPFIELD_VALUEPATTERN = createField("mapfield_valuepattern", org.jooq.impl.SQLDataType.CHAR(32), this, "");

    /**
     * The column <code>chrono.crmapfield.mapfield_ismandatory</code>.
     */
    public final TableField<CrmapfieldRecord, Byte> MAPFIELD_ISMANDATORY = createField("mapfield_ismandatory", org.jooq.impl.SQLDataType.TINYINT, this, "");

    /**
     * The column <code>chrono.crmapfield.mapfield_datasourcetype</code>.
     */
    public final TableField<CrmapfieldRecord, Integer> MAPFIELD_DATASOURCETYPE = createField("mapfield_datasourcetype", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.crmapfield.mapfield_sourcegroup</code>.
     */
    public final TableField<CrmapfieldRecord, String> MAPFIELD_SOURCEGROUP = createField("mapfield_sourcegroup", org.jooq.impl.SQLDataType.CHAR(64).nullable(false), this, "");

    /**
     * The column <code>chrono.crmapfield.mapfield_sourceparam</code>.
     */
    public final TableField<CrmapfieldRecord, String> MAPFIELD_SOURCEPARAM = createField("mapfield_sourceparam", org.jooq.impl.SQLDataType.CHAR(64).nullable(false), this, "");

    /**
     * The column <code>chrono.crmapfield.mapfield_sourcegroupbackup</code>.
     */
    public final TableField<CrmapfieldRecord, String> MAPFIELD_SOURCEGROUPBACKUP = createField("mapfield_sourcegroupbackup", org.jooq.impl.SQLDataType.CHAR(64).nullable(false), this, "");

    /**
     * The column <code>chrono.crmapfield.mapfield_sourceparambackup</code>.
     */
    public final TableField<CrmapfieldRecord, String> MAPFIELD_SOURCEPARAMBACKUP = createField("mapfield_sourceparambackup", org.jooq.impl.SQLDataType.CHAR(64).nullable(false), this, "");

    /**
     * The column <code>chrono.crmapfield.mapfield_sourcegroupcheck</code>.
     */
    public final TableField<CrmapfieldRecord, String> MAPFIELD_SOURCEGROUPCHECK = createField("mapfield_sourcegroupcheck", org.jooq.impl.SQLDataType.CHAR(64).nullable(false), this, "");

    /**
     * The column <code>chrono.crmapfield.mapfield_valueifcheckexist</code>.
     */
    public final TableField<CrmapfieldRecord, String> MAPFIELD_VALUEIFCHECKEXIST = createField("mapfield_valueifcheckexist", org.jooq.impl.SQLDataType.CHAR(64).nullable(false), this, "");

    /**
     * The column <code>chrono.crmapfield.mapfield_iskey</code>.
     */
    public final TableField<CrmapfieldRecord, Byte> MAPFIELD_ISKEY = createField("mapfield_iskey", org.jooq.impl.SQLDataType.TINYINT.nullable(false), this, "");

    /**
     * The column <code>chrono.crmapfield.mapfield_defaultvalue</code>.
     */
    public final TableField<CrmapfieldRecord, String> MAPFIELD_DEFAULTVALUE = createField("mapfield_defaultvalue", org.jooq.impl.SQLDataType.CHAR(32), this, "");

    /**
     * The column <code>chrono.crmapfield.mapfield_convertpattern</code>.
     */
    public final TableField<CrmapfieldRecord, String> MAPFIELD_CONVERTPATTERN = createField("mapfield_convertpattern", org.jooq.impl.SQLDataType.CHAR(96), this, "");

    /**
     * The column <code>chrono.crmapfield.mapfield_convertfunction</code>.
     */
    public final TableField<CrmapfieldRecord, String> MAPFIELD_CONVERTFUNCTION = createField("mapfield_convertfunction", org.jooq.impl.SQLDataType.CHAR(32), this, "");

    /**
     * The column <code>chrono.crmapfield.mapfield_ispublic</code>.
     */
    public final TableField<CrmapfieldRecord, Byte> MAPFIELD_ISPUBLIC = createField("mapfield_ispublic", org.jooq.impl.SQLDataType.TINYINT.nullable(false), this, "");

    /**
     * The column <code>chrono.crmapfield.mapfield_enabled</code>.
     */
    public final TableField<CrmapfieldRecord, Byte> MAPFIELD_ENABLED = createField("mapfield_enabled", org.jooq.impl.SQLDataType.TINYINT.nullable(false), this, "");

    /**
     * Create a <code>chrono.crmapfield</code> table reference
     */
    public Crmapfield() {
        this(DSL.name("crmapfield"), null);
    }

    /**
     * Create an aliased <code>chrono.crmapfield</code> table reference
     */
    public Crmapfield(String alias) {
        this(DSL.name(alias), CRMAPFIELD);
    }

    /**
     * Create an aliased <code>chrono.crmapfield</code> table reference
     */
    public Crmapfield(Name alias) {
        this(alias, CRMAPFIELD);
    }

    private Crmapfield(Name alias, Table<CrmapfieldRecord> aliased) {
        this(alias, aliased, null);
    }

    private Crmapfield(Name alias, Table<CrmapfieldRecord> aliased, Field<?>[] parameters) {
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
        return Arrays.<Index>asList(Indexes.CRMAPFIELD_MAPFIELD_CODE, Indexes.CRMAPFIELD_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<CrmapfieldRecord> getPrimaryKey() {
        return Keys.KEY_CRMAPFIELD_PRIMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<CrmapfieldRecord>> getKeys() {
        return Arrays.<UniqueKey<CrmapfieldRecord>>asList(Keys.KEY_CRMAPFIELD_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Crmapfield as(String alias) {
        return new Crmapfield(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Crmapfield as(Name alias) {
        return new Crmapfield(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Crmapfield rename(String name) {
        return new Crmapfield(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Crmapfield rename(Name name) {
        return new Crmapfield(name, null);
    }
}

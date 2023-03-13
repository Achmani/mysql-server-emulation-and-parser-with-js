/*
 * This file is generated by jOOQ.
*/
package id.mit.chrono.server.model.tables;


import id.mit.chrono.server.model.Chrono;
import id.mit.chrono.server.model.Indexes;
import id.mit.chrono.server.model.Keys;
import id.mit.chrono.server.model.tables.records.CrprovinceRecord;

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
public class Crprovince extends TableImpl<CrprovinceRecord> {

    private static final long serialVersionUID = 1851219216;

    /**
     * The reference instance of <code>chrono.crprovince</code>
     */
    public static final Crprovince CRPROVINCE = new Crprovince();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<CrprovinceRecord> getRecordType() {
        return CrprovinceRecord.class;
    }

    /**
     * The column <code>chrono.crprovince.province_id</code>.
     */
    public final TableField<CrprovinceRecord, Integer> PROVINCE_ID = createField("province_id", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>chrono.crprovince.province_country</code>.
     */
    public final TableField<CrprovinceRecord, Integer> PROVINCE_COUNTRY = createField("province_country", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.crprovince.province_code</code>.
     */
    public final TableField<CrprovinceRecord, String> PROVINCE_CODE = createField("province_code", org.jooq.impl.SQLDataType.CHAR(16), this, "");

    /**
     * The column <code>chrono.crprovince.province_name</code>.
     */
    public final TableField<CrprovinceRecord, String> PROVINCE_NAME = createField("province_name", org.jooq.impl.SQLDataType.VARCHAR(64), this, "");

    /**
     * The column <code>chrono.crprovince.province_polygon</code>.
     */
    public final TableField<CrprovinceRecord, String> PROVINCE_POLYGON = createField("province_polygon", org.jooq.impl.SQLDataType.CLOB, this, "");

    /**
     * Create a <code>chrono.crprovince</code> table reference
     */
    public Crprovince() {
        this(DSL.name("crprovince"), null);
    }

    /**
     * Create an aliased <code>chrono.crprovince</code> table reference
     */
    public Crprovince(String alias) {
        this(DSL.name(alias), CRPROVINCE);
    }

    /**
     * Create an aliased <code>chrono.crprovince</code> table reference
     */
    public Crprovince(Name alias) {
        this(alias, CRPROVINCE);
    }

    private Crprovince(Name alias, Table<CrprovinceRecord> aliased) {
        this(alias, aliased, null);
    }

    private Crprovince(Name alias, Table<CrprovinceRecord> aliased, Field<?>[] parameters) {
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
        return Arrays.<Index>asList(Indexes.CRPROVINCE_PRIMARY, Indexes.CRPROVINCE_PROVINCE_CODE, Indexes.CRPROVINCE_PROVINCE_COUNTRY, Indexes.CRPROVINCE_PROVINCE_NAME);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<CrprovinceRecord> getPrimaryKey() {
        return Keys.KEY_CRPROVINCE_PRIMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<CrprovinceRecord>> getKeys() {
        return Arrays.<UniqueKey<CrprovinceRecord>>asList(Keys.KEY_CRPROVINCE_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Crprovince as(String alias) {
        return new Crprovince(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Crprovince as(Name alias) {
        return new Crprovince(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Crprovince rename(String name) {
        return new Crprovince(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Crprovince rename(Name name) {
        return new Crprovince(name, null);
    }
}

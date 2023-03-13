/*
 * This file is generated by jOOQ.
*/
package id.mit.chrono.server.model.tables;


import id.mit.chrono.server.model.Chrono;
import id.mit.chrono.server.model.Indexes;
import id.mit.chrono.server.model.Keys;
import id.mit.chrono.server.model.tables.records.CrcountryRecord;

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
public class Crcountry extends TableImpl<CrcountryRecord> {

    private static final long serialVersionUID = -1479024305;

    /**
     * The reference instance of <code>chrono.crcountry</code>
     */
    public static final Crcountry CRCOUNTRY = new Crcountry();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<CrcountryRecord> getRecordType() {
        return CrcountryRecord.class;
    }

    /**
     * The column <code>chrono.crcountry.country_id</code>.
     */
    public final TableField<CrcountryRecord, Integer> COUNTRY_ID = createField("country_id", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>chrono.crcountry.country_code</code>.
     */
    public final TableField<CrcountryRecord, String> COUNTRY_CODE = createField("country_code", org.jooq.impl.SQLDataType.CHAR(8), this, "");

    /**
     * The column <code>chrono.crcountry.country_name</code>.
     */
    public final TableField<CrcountryRecord, String> COUNTRY_NAME = createField("country_name", org.jooq.impl.SQLDataType.VARCHAR(45), this, "");

    /**
     * The column <code>chrono.crcountry.country_polygon</code>.
     */
    public final TableField<CrcountryRecord, String> COUNTRY_POLYGON = createField("country_polygon", org.jooq.impl.SQLDataType.CLOB, this, "");

    /**
     * Create a <code>chrono.crcountry</code> table reference
     */
    public Crcountry() {
        this(DSL.name("crcountry"), null);
    }

    /**
     * Create an aliased <code>chrono.crcountry</code> table reference
     */
    public Crcountry(String alias) {
        this(DSL.name(alias), CRCOUNTRY);
    }

    /**
     * Create an aliased <code>chrono.crcountry</code> table reference
     */
    public Crcountry(Name alias) {
        this(alias, CRCOUNTRY);
    }

    private Crcountry(Name alias, Table<CrcountryRecord> aliased) {
        this(alias, aliased, null);
    }

    private Crcountry(Name alias, Table<CrcountryRecord> aliased, Field<?>[] parameters) {
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
        return Arrays.<Index>asList(Indexes.CRCOUNTRY_COUNTRY_CODE, Indexes.CRCOUNTRY_COUNTRY_NAME, Indexes.CRCOUNTRY_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<CrcountryRecord> getPrimaryKey() {
        return Keys.KEY_CRCOUNTRY_PRIMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<CrcountryRecord>> getKeys() {
        return Arrays.<UniqueKey<CrcountryRecord>>asList(Keys.KEY_CRCOUNTRY_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Crcountry as(String alias) {
        return new Crcountry(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Crcountry as(Name alias) {
        return new Crcountry(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Crcountry rename(String name) {
        return new Crcountry(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Crcountry rename(Name name) {
        return new Crcountry(name, null);
    }
}
/*
 * This file is generated by jOOQ.
*/
package id.mit.chrono.server.model.tables;


import id.mit.chrono.server.model.Chrono;
import id.mit.chrono.server.model.Indexes;
import id.mit.chrono.server.model.Keys;
import id.mit.chrono.server.model.tables.records.CrislandRecord;

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
public class Crisland extends TableImpl<CrislandRecord> {

    private static final long serialVersionUID = -1191114444;

    /**
     * The reference instance of <code>chrono.crisland</code>
     */
    public static final Crisland CRISLAND = new Crisland();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<CrislandRecord> getRecordType() {
        return CrislandRecord.class;
    }

    /**
     * The column <code>chrono.crisland.island_id</code>.
     */
    public final TableField<CrislandRecord, Integer> ISLAND_ID = createField("island_id", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>chrono.crisland.island_code</code>.
     */
    public final TableField<CrislandRecord, String> ISLAND_CODE = createField("island_code", org.jooq.impl.SQLDataType.CHAR(16), this, "");

    /**
     * The column <code>chrono.crisland.island_name</code>.
     */
    public final TableField<CrislandRecord, String> ISLAND_NAME = createField("island_name", org.jooq.impl.SQLDataType.VARCHAR(45), this, "");

    /**
     * Create a <code>chrono.crisland</code> table reference
     */
    public Crisland() {
        this(DSL.name("crisland"), null);
    }

    /**
     * Create an aliased <code>chrono.crisland</code> table reference
     */
    public Crisland(String alias) {
        this(DSL.name(alias), CRISLAND);
    }

    /**
     * Create an aliased <code>chrono.crisland</code> table reference
     */
    public Crisland(Name alias) {
        this(alias, CRISLAND);
    }

    private Crisland(Name alias, Table<CrislandRecord> aliased) {
        this(alias, aliased, null);
    }

    private Crisland(Name alias, Table<CrislandRecord> aliased, Field<?>[] parameters) {
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
        return Arrays.<Index>asList(Indexes.CRISLAND_ISLAND_CODE, Indexes.CRISLAND_ISLAND_NAME, Indexes.CRISLAND_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<CrislandRecord> getPrimaryKey() {
        return Keys.KEY_CRISLAND_PRIMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<CrislandRecord>> getKeys() {
        return Arrays.<UniqueKey<CrislandRecord>>asList(Keys.KEY_CRISLAND_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Crisland as(String alias) {
        return new Crisland(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Crisland as(Name alias) {
        return new Crisland(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Crisland rename(String name) {
        return new Crisland(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Crisland rename(Name name) {
        return new Crisland(name, null);
    }
}

/*
 * This file is generated by jOOQ.
*/
package id.mit.chrono.server.model.tables;


import id.mit.chrono.server.model.Chrono;
import id.mit.chrono.server.model.Indexes;
import id.mit.chrono.server.model.Keys;
import id.mit.chrono.server.model.tables.records.CrsitetypeRecord;

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
public class Crsitetype extends TableImpl<CrsitetypeRecord> {

    private static final long serialVersionUID = 1114764003;

    /**
     * The reference instance of <code>chrono.crsitetype</code>
     */
    public static final Crsitetype CRSITETYPE = new Crsitetype();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<CrsitetypeRecord> getRecordType() {
        return CrsitetypeRecord.class;
    }

    /**
     * The column <code>chrono.crsitetype.sitetype_id</code>.
     */
    public final TableField<CrsitetypeRecord, Integer> SITETYPE_ID = createField("sitetype_id", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>chrono.crsitetype.sitetype_code</code>.
     */
    public final TableField<CrsitetypeRecord, String> SITETYPE_CODE = createField("sitetype_code", org.jooq.impl.SQLDataType.CHAR(32), this, "");

    /**
     * The column <code>chrono.crsitetype.sitetype_name</code>.
     */
    public final TableField<CrsitetypeRecord, String> SITETYPE_NAME = createField("sitetype_name", org.jooq.impl.SQLDataType.VARCHAR(255), this, "");

    /**
     * Create a <code>chrono.crsitetype</code> table reference
     */
    public Crsitetype() {
        this(DSL.name("crsitetype"), null);
    }

    /**
     * Create an aliased <code>chrono.crsitetype</code> table reference
     */
    public Crsitetype(String alias) {
        this(DSL.name(alias), CRSITETYPE);
    }

    /**
     * Create an aliased <code>chrono.crsitetype</code> table reference
     */
    public Crsitetype(Name alias) {
        this(alias, CRSITETYPE);
    }

    private Crsitetype(Name alias, Table<CrsitetypeRecord> aliased) {
        this(alias, aliased, null);
    }

    private Crsitetype(Name alias, Table<CrsitetypeRecord> aliased, Field<?>[] parameters) {
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
        return Arrays.<Index>asList(Indexes.CRSITETYPE_PRIMARY, Indexes.CRSITETYPE_SITETYPE_CODE, Indexes.CRSITETYPE_SITETYPE_NAME);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<CrsitetypeRecord> getPrimaryKey() {
        return Keys.KEY_CRSITETYPE_PRIMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<CrsitetypeRecord>> getKeys() {
        return Arrays.<UniqueKey<CrsitetypeRecord>>asList(Keys.KEY_CRSITETYPE_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Crsitetype as(String alias) {
        return new Crsitetype(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Crsitetype as(Name alias) {
        return new Crsitetype(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Crsitetype rename(String name) {
        return new Crsitetype(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Crsitetype rename(Name name) {
        return new Crsitetype(name, null);
    }
}

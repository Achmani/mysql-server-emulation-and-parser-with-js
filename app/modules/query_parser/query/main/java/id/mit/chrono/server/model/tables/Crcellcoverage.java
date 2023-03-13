/*
 * This file is generated by jOOQ.
*/
package id.mit.chrono.server.model.tables;


import id.mit.chrono.server.model.Chrono;
import id.mit.chrono.server.model.Indexes;
import id.mit.chrono.server.model.Keys;
import id.mit.chrono.server.model.tables.records.CrcellcoverageRecord;

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
public class Crcellcoverage extends TableImpl<CrcellcoverageRecord> {

    private static final long serialVersionUID = -634909923;

    /**
     * The reference instance of <code>chrono.crcellcoverage</code>
     */
    public static final Crcellcoverage CRCELLCOVERAGE = new Crcellcoverage();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<CrcellcoverageRecord> getRecordType() {
        return CrcellcoverageRecord.class;
    }

    /**
     * The column <code>chrono.crcellcoverage.cellcoverage_id</code>.
     */
    public final TableField<CrcellcoverageRecord, UInteger> CELLCOVERAGE_ID = createField("cellcoverage_id", org.jooq.impl.SQLDataType.INTEGERUNSIGNED.nullable(false), this, "");

    /**
     * The column <code>chrono.crcellcoverage.cellcoverage_code</code>.
     */
    public final TableField<CrcellcoverageRecord, String> CELLCOVERAGE_CODE = createField("cellcoverage_code", org.jooq.impl.SQLDataType.CHAR(32).nullable(false), this, "");

    /**
     * The column <code>chrono.crcellcoverage.cellcoverage_name</code>.
     */
    public final TableField<CrcellcoverageRecord, String> CELLCOVERAGE_NAME = createField("cellcoverage_name", org.jooq.impl.SQLDataType.CHAR(32).nullable(false), this, "");

    /**
     * Create a <code>chrono.crcellcoverage</code> table reference
     */
    public Crcellcoverage() {
        this(DSL.name("crcellcoverage"), null);
    }

    /**
     * Create an aliased <code>chrono.crcellcoverage</code> table reference
     */
    public Crcellcoverage(String alias) {
        this(DSL.name(alias), CRCELLCOVERAGE);
    }

    /**
     * Create an aliased <code>chrono.crcellcoverage</code> table reference
     */
    public Crcellcoverage(Name alias) {
        this(alias, CRCELLCOVERAGE);
    }

    private Crcellcoverage(Name alias, Table<CrcellcoverageRecord> aliased) {
        this(alias, aliased, null);
    }

    private Crcellcoverage(Name alias, Table<CrcellcoverageRecord> aliased, Field<?>[] parameters) {
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
        return Arrays.<Index>asList(Indexes.CRCELLCOVERAGE_CELLCLASS_CODE, Indexes.CRCELLCOVERAGE_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<CrcellcoverageRecord> getPrimaryKey() {
        return Keys.KEY_CRCELLCOVERAGE_PRIMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<CrcellcoverageRecord>> getKeys() {
        return Arrays.<UniqueKey<CrcellcoverageRecord>>asList(Keys.KEY_CRCELLCOVERAGE_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Crcellcoverage as(String alias) {
        return new Crcellcoverage(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Crcellcoverage as(Name alias) {
        return new Crcellcoverage(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Crcellcoverage rename(String name) {
        return new Crcellcoverage(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Crcellcoverage rename(Name name) {
        return new Crcellcoverage(name, null);
    }
}

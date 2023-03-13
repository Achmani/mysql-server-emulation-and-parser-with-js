/*
 * This file is generated by jOOQ.
*/
package id.mit.chrono.server.model.tables;


import id.mit.chrono.server.model.Chrono;
import id.mit.chrono.server.model.Keys;
import id.mit.chrono.server.model.tables.records.CrcellpatternRecord;

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
public class Crcellpattern extends TableImpl<CrcellpatternRecord> {

    private static final long serialVersionUID = 466390645;

    /**
     * The reference instance of <code>chrono.crcellpattern</code>
     */
    public static final Crcellpattern CRCELLPATTERN = new Crcellpattern();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<CrcellpatternRecord> getRecordType() {
        return CrcellpatternRecord.class;
    }

    /**
     * The column <code>chrono.crcellpattern.cellpattern_id</code>.
     */
    public final TableField<CrcellpatternRecord, Integer> CELLPATTERN_ID = createField("cellpattern_id", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>chrono.crcellpattern.cellpattern_vendor</code>.
     */
    public final TableField<CrcellpatternRecord, Integer> CELLPATTERN_VENDOR = createField("cellpattern_vendor", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.crcellpattern.cellpattern_cellclass</code>.
     */
    public final TableField<CrcellpatternRecord, Integer> CELLPATTERN_CELLCLASS = createField("cellpattern_cellclass", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.crcellpattern.cellpattern_order</code>.
     */
    public final TableField<CrcellpatternRecord, Integer> CELLPATTERN_ORDER = createField("cellpattern_order", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>chrono.crcellpattern.cellpattern_pattern</code>.
     */
    public final TableField<CrcellpatternRecord, String> CELLPATTERN_PATTERN = createField("cellpattern_pattern", org.jooq.impl.SQLDataType.CHAR(255).nullable(false), this, "");

    /**
     * The column <code>chrono.crcellpattern.cellpattern_startpattern</code>.
     */
    public final TableField<CrcellpatternRecord, String> CELLPATTERN_STARTPATTERN = createField("cellpattern_startpattern", org.jooq.impl.SQLDataType.CHAR(255), this, "");

    /**
     * The column <code>chrono.crcellpattern.cellpattern_desc</code>.
     */
    public final TableField<CrcellpatternRecord, String> CELLPATTERN_DESC = createField("cellpattern_desc", org.jooq.impl.SQLDataType.CHAR(72), this, "");

    /**
     * The column <code>chrono.crcellpattern.cellpattern_enabled</code>.
     */
    public final TableField<CrcellpatternRecord, Byte> CELLPATTERN_ENABLED = createField("cellpattern_enabled", org.jooq.impl.SQLDataType.TINYINT.nullable(false), this, "");

    /**
     * Create a <code>chrono.crcellpattern</code> table reference
     */
    public Crcellpattern() {
        this(DSL.name("crcellpattern"), null);
    }

    /**
     * Create an aliased <code>chrono.crcellpattern</code> table reference
     */
    public Crcellpattern(String alias) {
        this(DSL.name(alias), CRCELLPATTERN);
    }

    /**
     * Create an aliased <code>chrono.crcellpattern</code> table reference
     */
    public Crcellpattern(Name alias) {
        this(alias, CRCELLPATTERN);
    }

    private Crcellpattern(Name alias, Table<CrcellpatternRecord> aliased) {
        this(alias, aliased, null);
    }

    private Crcellpattern(Name alias, Table<CrcellpatternRecord> aliased, Field<?>[] parameters) {
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
    public UniqueKey<CrcellpatternRecord> getPrimaryKey() {
        return Keys.KEY_CRCELLPATTERN_PRIMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<CrcellpatternRecord>> getKeys() {
        return Arrays.<UniqueKey<CrcellpatternRecord>>asList(Keys.KEY_CRCELLPATTERN_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Crcellpattern as(String alias) {
        return new Crcellpattern(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Crcellpattern as(Name alias) {
        return new Crcellpattern(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Crcellpattern rename(String name) {
        return new Crcellpattern(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Crcellpattern rename(Name name) {
        return new Crcellpattern(name, null);
    }
}
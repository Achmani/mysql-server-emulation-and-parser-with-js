/*
 * This file is generated by jOOQ.
*/
package id.mit.chrono.server.model.tables;


import id.mit.chrono.server.model.Chrono;
import id.mit.chrono.server.model.Indexes;
import id.mit.chrono.server.model.Keys;
import id.mit.chrono.server.model.tables.records.CrcollectorstatusRecord;

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
public class Crcollectorstatus extends TableImpl<CrcollectorstatusRecord> {

    private static final long serialVersionUID = -714451169;

    /**
     * The reference instance of <code>chrono.crcollectorstatus</code>
     */
    public static final Crcollectorstatus CRCOLLECTORSTATUS = new Crcollectorstatus();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<CrcollectorstatusRecord> getRecordType() {
        return CrcollectorstatusRecord.class;
    }

    /**
     * The column <code>chrono.crcollectorstatus.collectorstatus_id</code>.
     */
    public final TableField<CrcollectorstatusRecord, Integer> COLLECTORSTATUS_ID = createField("collectorstatus_id", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>chrono.crcollectorstatus.collectorstatus_code</code>.
     */
    public final TableField<CrcollectorstatusRecord, String> COLLECTORSTATUS_CODE = createField("collectorstatus_code", org.jooq.impl.SQLDataType.CHAR(16), this, "");

    /**
     * The column <code>chrono.crcollectorstatus.collectorstatus_name</code>.
     */
    public final TableField<CrcollectorstatusRecord, String> COLLECTORSTATUS_NAME = createField("collectorstatus_name", org.jooq.impl.SQLDataType.CHAR(16), this, "");

    /**
     * Create a <code>chrono.crcollectorstatus</code> table reference
     */
    public Crcollectorstatus() {
        this(DSL.name("crcollectorstatus"), null);
    }

    /**
     * Create an aliased <code>chrono.crcollectorstatus</code> table reference
     */
    public Crcollectorstatus(String alias) {
        this(DSL.name(alias), CRCOLLECTORSTATUS);
    }

    /**
     * Create an aliased <code>chrono.crcollectorstatus</code> table reference
     */
    public Crcollectorstatus(Name alias) {
        this(alias, CRCOLLECTORSTATUS);
    }

    private Crcollectorstatus(Name alias, Table<CrcollectorstatusRecord> aliased) {
        this(alias, aliased, null);
    }

    private Crcollectorstatus(Name alias, Table<CrcollectorstatusRecord> aliased, Field<?>[] parameters) {
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
        return Arrays.<Index>asList(Indexes.CRCOLLECTORSTATUS_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<CrcollectorstatusRecord> getPrimaryKey() {
        return Keys.KEY_CRCOLLECTORSTATUS_PRIMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<CrcollectorstatusRecord>> getKeys() {
        return Arrays.<UniqueKey<CrcollectorstatusRecord>>asList(Keys.KEY_CRCOLLECTORSTATUS_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Crcollectorstatus as(String alias) {
        return new Crcollectorstatus(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Crcollectorstatus as(Name alias) {
        return new Crcollectorstatus(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Crcollectorstatus rename(String name) {
        return new Crcollectorstatus(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Crcollectorstatus rename(Name name) {
        return new Crcollectorstatus(name, null);
    }
}

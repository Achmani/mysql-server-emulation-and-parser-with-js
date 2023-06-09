/*
 * This file is generated by jOOQ.
*/
package id.mit.chrono.server.model.tables;


import id.mit.chrono.server.model.Chrono;
import id.mit.chrono.server.model.Keys;
import id.mit.chrono.server.model.tables.records.ErmmeRecord;

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
import org.jooq.types.ULong;


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
public class Ermme extends TableImpl<ErmmeRecord> {

    private static final long serialVersionUID = 1791344891;

    /**
     * The reference instance of <code>chrono.ermme</code>
     */
    public static final Ermme ERMME = new Ermme();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<ErmmeRecord> getRecordType() {
        return ErmmeRecord.class;
    }

    /**
     * The column <code>chrono.ermme.ermme_id</code>.
     */
    public final TableField<ErmmeRecord, ULong> ERMME_ID = createField("ermme_id", org.jooq.impl.SQLDataType.BIGINTUNSIGNED.nullable(false), this, "");

    /**
     * The column <code>chrono.ermme.ermme_crcollectortaskfiles</code>.
     */
    public final TableField<ErmmeRecord, ULong> ERMME_CRCOLLECTORTASKFILES = createField("ermme_crcollectortaskfiles", org.jooq.impl.SQLDataType.BIGINTUNSIGNED, this, "");

    /**
     * The column <code>chrono.ermme.ermme_date</code>.
     */
    public final TableField<ErmmeRecord, UInteger> ERMME_DATE = createField("ermme_date", org.jooq.impl.SQLDataType.INTEGERUNSIGNED.nullable(false), this, "");

    /**
     * The column <code>chrono.ermme.ermme_datefrom</code>.
     */
    public final TableField<ErmmeRecord, Integer> ERMME_DATEFROM = createField("ermme_datefrom", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.ermme.ermme_node</code>.
     */
    public final TableField<ErmmeRecord, Integer> ERMME_NODE = createField("ermme_node", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.ermme.ermme_vendor</code>.
     */
    public final TableField<ErmmeRecord, Integer> ERMME_VENDOR = createField("ermme_vendor", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.ermme.MMENAME</code>.
     */
    public final TableField<ErmmeRecord, String> MMENAME = createField("MMENAME", org.jooq.impl.SQLDataType.CHAR(32), this, "");

    /**
     * The column <code>chrono.ermme.TOTALENODEB</code>.
     */
    public final TableField<ErmmeRecord, Integer> TOTALENODEB = createField("TOTALENODEB", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.ermme.ermme_remark</code>.
     */
    public final TableField<ErmmeRecord, String> ERMME_REMARK = createField("ermme_remark", org.jooq.impl.SQLDataType.CLOB, this, "");

    /**
     * Create a <code>chrono.ermme</code> table reference
     */
    public Ermme() {
        this(DSL.name("ermme"), null);
    }

    /**
     * Create an aliased <code>chrono.ermme</code> table reference
     */
    public Ermme(String alias) {
        this(DSL.name(alias), ERMME);
    }

    /**
     * Create an aliased <code>chrono.ermme</code> table reference
     */
    public Ermme(Name alias) {
        this(alias, ERMME);
    }

    private Ermme(Name alias, Table<ErmmeRecord> aliased) {
        this(alias, aliased, null);
    }

    private Ermme(Name alias, Table<ErmmeRecord> aliased, Field<?>[] parameters) {
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
    public UniqueKey<ErmmeRecord> getPrimaryKey() {
        return Keys.KEY_ERMME_PRIMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<ErmmeRecord>> getKeys() {
        return Arrays.<UniqueKey<ErmmeRecord>>asList(Keys.KEY_ERMME_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Ermme as(String alias) {
        return new Ermme(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Ermme as(Name alias) {
        return new Ermme(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Ermme rename(String name) {
        return new Ermme(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Ermme rename(Name name) {
        return new Ermme(name, null);
    }
}

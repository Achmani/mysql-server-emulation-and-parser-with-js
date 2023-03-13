/*
 * This file is generated by jOOQ.
*/
package id.mit.chrono.server.model.tables;


import id.mit.chrono.server.model.Chrono;
import id.mit.chrono.server.model.Keys;
import id.mit.chrono.server.model.tables.records.ZtemmeRecord;

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
public class Ztemme extends TableImpl<ZtemmeRecord> {

    private static final long serialVersionUID = 1159591175;

    /**
     * The reference instance of <code>chrono.ztemme</code>
     */
    public static final Ztemme ZTEMME = new Ztemme();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<ZtemmeRecord> getRecordType() {
        return ZtemmeRecord.class;
    }

    /**
     * The column <code>chrono.ztemme.ztemme_id</code>.
     */
    public final TableField<ZtemmeRecord, ULong> ZTEMME_ID = createField("ztemme_id", org.jooq.impl.SQLDataType.BIGINTUNSIGNED.nullable(false), this, "");

    /**
     * The column <code>chrono.ztemme.ztemme_crcollectortaskfiles</code>.
     */
    public final TableField<ZtemmeRecord, ULong> ZTEMME_CRCOLLECTORTASKFILES = createField("ztemme_crcollectortaskfiles", org.jooq.impl.SQLDataType.BIGINTUNSIGNED, this, "");

    /**
     * The column <code>chrono.ztemme.ztemme_date</code>.
     */
    public final TableField<ZtemmeRecord, UInteger> ZTEMME_DATE = createField("ztemme_date", org.jooq.impl.SQLDataType.INTEGERUNSIGNED.nullable(false), this, "");

    /**
     * The column <code>chrono.ztemme.ztemme_datefrom</code>.
     */
    public final TableField<ZtemmeRecord, Integer> ZTEMME_DATEFROM = createField("ztemme_datefrom", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.ztemme.ztemme_node</code>.
     */
    public final TableField<ZtemmeRecord, Integer> ZTEMME_NODE = createField("ztemme_node", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.ztemme.ztemme_vendor</code>.
     */
    public final TableField<ZtemmeRecord, Integer> ZTEMME_VENDOR = createField("ztemme_vendor", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.ztemme.MMENAME</code>.
     */
    public final TableField<ZtemmeRecord, String> MMENAME = createField("MMENAME", org.jooq.impl.SQLDataType.CHAR(32), this, "");

    /**
     * The column <code>chrono.ztemme.TOTALENODEB</code>.
     */
    public final TableField<ZtemmeRecord, Integer> TOTALENODEB = createField("TOTALENODEB", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.ztemme.ztemme_remark</code>.
     */
    public final TableField<ZtemmeRecord, String> ZTEMME_REMARK = createField("ztemme_remark", org.jooq.impl.SQLDataType.CLOB, this, "");

    /**
     * Create a <code>chrono.ztemme</code> table reference
     */
    public Ztemme() {
        this(DSL.name("ztemme"), null);
    }

    /**
     * Create an aliased <code>chrono.ztemme</code> table reference
     */
    public Ztemme(String alias) {
        this(DSL.name(alias), ZTEMME);
    }

    /**
     * Create an aliased <code>chrono.ztemme</code> table reference
     */
    public Ztemme(Name alias) {
        this(alias, ZTEMME);
    }

    private Ztemme(Name alias, Table<ZtemmeRecord> aliased) {
        this(alias, aliased, null);
    }

    private Ztemme(Name alias, Table<ZtemmeRecord> aliased, Field<?>[] parameters) {
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
    public UniqueKey<ZtemmeRecord> getPrimaryKey() {
        return Keys.KEY_ZTEMME_PRIMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<ZtemmeRecord>> getKeys() {
        return Arrays.<UniqueKey<ZtemmeRecord>>asList(Keys.KEY_ZTEMME_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Ztemme as(String alias) {
        return new Ztemme(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Ztemme as(Name alias) {
        return new Ztemme(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Ztemme rename(String name) {
        return new Ztemme(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Ztemme rename(Name name) {
        return new Ztemme(name, null);
    }
}
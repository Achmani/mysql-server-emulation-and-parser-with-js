/*
 * This file is generated by jOOQ.
*/
package id.mit.chrono.server.model.tables;


import id.mit.chrono.server.model.Chrono;
import id.mit.chrono.server.model.Indexes;
import id.mit.chrono.server.model.Keys;
import id.mit.chrono.server.model.tables.records.ErbscRecord;

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
public class Erbsc extends TableImpl<ErbscRecord> {

    private static final long serialVersionUID = -1884370883;

    /**
     * The reference instance of <code>chrono.erbsc</code>
     */
    public static final Erbsc ERBSC = new Erbsc();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<ErbscRecord> getRecordType() {
        return ErbscRecord.class;
    }

    /**
     * The column <code>chrono.erbsc.erbsc_id</code>.
     */
    public final TableField<ErbscRecord, ULong> ERBSC_ID = createField("erbsc_id", org.jooq.impl.SQLDataType.BIGINTUNSIGNED.nullable(false), this, "");

    /**
     * The column <code>chrono.erbsc.erbsc_crcollectortaskfiles</code>.
     */
    public final TableField<ErbscRecord, ULong> ERBSC_CRCOLLECTORTASKFILES = createField("erbsc_crcollectortaskfiles", org.jooq.impl.SQLDataType.BIGINTUNSIGNED, this, "");

    /**
     * The column <code>chrono.erbsc.erbsc_date</code>.
     */
    public final TableField<ErbscRecord, UInteger> ERBSC_DATE = createField("erbsc_date", org.jooq.impl.SQLDataType.INTEGERUNSIGNED.nullable(false), this, "");

    /**
     * The column <code>chrono.erbsc.erbsc_node</code>.
     */
    public final TableField<ErbscRecord, Integer> ERBSC_NODE = createField("erbsc_node", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.erbsc.erbsc_vendor</code>.
     */
    public final TableField<ErbscRecord, Integer> ERBSC_VENDOR = createField("erbsc_vendor", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.erbsc.BSCNAME</code>.
     */
    public final TableField<ErbscRecord, String> BSCNAME = createField("BSCNAME", org.jooq.impl.SQLDataType.CHAR(32), this, "");

    /**
     * The column <code>chrono.erbsc.TOTALSUBRACK</code>.
     */
    public final TableField<ErbscRecord, Integer> TOTALSUBRACK = createField("TOTALSUBRACK", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.erbsc.TOTALBRD</code>.
     */
    public final TableField<ErbscRecord, Integer> TOTALBRD = createField("TOTALBRD", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.erbsc.TOTALBTS</code>.
     */
    public final TableField<ErbscRecord, Integer> TOTALBTS = createField("TOTALBTS", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.erbsc.TOTALTRXCAP</code>.
     */
    public final TableField<ErbscRecord, Integer> TOTALTRXCAP = createField("TOTALTRXCAP", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.erbsc.TOTALTRX</code>.
     */
    public final TableField<ErbscRecord, Integer> TOTALTRX = createField("TOTALTRX", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.erbsc.TRXOCCUP</code>.
     */
    public final TableField<ErbscRecord, Double> TRXOCCUP = createField("TRXOCCUP", org.jooq.impl.SQLDataType.DOUBLE, this, "");

    /**
     * The column <code>chrono.erbsc.TOTALCELL</code>.
     */
    public final TableField<ErbscRecord, Integer> TOTALCELL = createField("TOTALCELL", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.erbsc.SWVERSION</code>.
     */
    public final TableField<ErbscRecord, String> SWVERSION = createField("SWVERSION", org.jooq.impl.SQLDataType.CHAR(32), this, "");

    /**
     * The column <code>chrono.erbsc.IPADDRESS</code>.
     */
    public final TableField<ErbscRecord, String> IPADDRESS = createField("IPADDRESS", org.jooq.impl.SQLDataType.CHAR(16), this, "");

    /**
     * The column <code>chrono.erbsc.NETYPE</code>.
     */
    public final TableField<ErbscRecord, String> NETYPE = createField("NETYPE", org.jooq.impl.SQLDataType.CHAR(16), this, "");

    /**
     * The column <code>chrono.erbsc.erbsc_remark</code>.
     */
    public final TableField<ErbscRecord, String> ERBSC_REMARK = createField("erbsc_remark", org.jooq.impl.SQLDataType.CLOB, this, "");

    /**
     * The column <code>chrono.erbsc.EXTPROP1</code>.
     */
    public final TableField<ErbscRecord, Integer> EXTPROP1 = createField("EXTPROP1", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.erbsc.EXTPROP2</code>.
     */
    public final TableField<ErbscRecord, String> EXTPROP2 = createField("EXTPROP2", org.jooq.impl.SQLDataType.CHAR(8), this, "");

    /**
     * Create a <code>chrono.erbsc</code> table reference
     */
    public Erbsc() {
        this(DSL.name("erbsc"), null);
    }

    /**
     * Create an aliased <code>chrono.erbsc</code> table reference
     */
    public Erbsc(String alias) {
        this(DSL.name(alias), ERBSC);
    }

    /**
     * Create an aliased <code>chrono.erbsc</code> table reference
     */
    public Erbsc(Name alias) {
        this(alias, ERBSC);
    }

    private Erbsc(Name alias, Table<ErbscRecord> aliased) {
        this(alias, aliased, null);
    }

    private Erbsc(Name alias, Table<ErbscRecord> aliased, Field<?>[] parameters) {
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
        return Arrays.<Index>asList(Indexes.ERBSC_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<ErbscRecord> getPrimaryKey() {
        return Keys.KEY_ERBSC_PRIMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<ErbscRecord>> getKeys() {
        return Arrays.<UniqueKey<ErbscRecord>>asList(Keys.KEY_ERBSC_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Erbsc as(String alias) {
        return new Erbsc(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Erbsc as(Name alias) {
        return new Erbsc(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Erbsc rename(String name) {
        return new Erbsc(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Erbsc rename(Name name) {
        return new Erbsc(name, null);
    }
}
/*
 * This file is generated by jOOQ.
*/
package id.mit.chrono.server.model.tables;


import id.mit.chrono.server.model.Chrono;
import id.mit.chrono.server.model.Keys;
import id.mit.chrono.server.model.tables.records.CrrancontrollerRecord;

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
public class Crrancontroller extends TableImpl<CrrancontrollerRecord> {

    private static final long serialVersionUID = -1435472878;

    /**
     * The reference instance of <code>chrono.crrancontroller</code>
     */
    public static final Crrancontroller CRRANCONTROLLER = new Crrancontroller();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<CrrancontrollerRecord> getRecordType() {
        return CrrancontrollerRecord.class;
    }

    /**
     * The column <code>chrono.crrancontroller.rancontroller_id</code>.
     */
    public final TableField<CrrancontrollerRecord, ULong> RANCONTROLLER_ID = createField("rancontroller_id", org.jooq.impl.SQLDataType.BIGINTUNSIGNED.nullable(false), this, "");

    /**
     * The column <code>chrono.crrancontroller.rancontroller_date</code>.
     */
    public final TableField<CrrancontrollerRecord, UInteger> RANCONTROLLER_DATE = createField("rancontroller_date", org.jooq.impl.SQLDataType.INTEGERUNSIGNED.nullable(false), this, "");

    /**
     * The column <code>chrono.crrancontroller.rancontroller_datefrom</code>.
     */
    public final TableField<CrrancontrollerRecord, Integer> RANCONTROLLER_DATEFROM = createField("rancontroller_datefrom", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.crrancontroller.rancontroller_key</code>.
     */
    public final TableField<CrrancontrollerRecord, String> RANCONTROLLER_KEY = createField("rancontroller_key", org.jooq.impl.SQLDataType.CHAR(32).nullable(false), this, "");

    /**
     * The column <code>chrono.crrancontroller.rancontroller_node</code>.
     */
    public final TableField<CrrancontrollerRecord, Integer> RANCONTROLLER_NODE = createField("rancontroller_node", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.crrancontroller.rancontroller_vendor</code>.
     */
    public final TableField<CrrancontrollerRecord, Integer> RANCONTROLLER_VENDOR = createField("rancontroller_vendor", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.crrancontroller.rancontroller_src</code>.
     */
    public final TableField<CrrancontrollerRecord, String> RANCONTROLLER_SRC = createField("rancontroller_src", org.jooq.impl.SQLDataType.CHAR(12), this, "");

    /**
     * The column <code>chrono.crrancontroller.rancontroller_refid</code>.
     */
    public final TableField<CrrancontrollerRecord, ULong> RANCONTROLLER_REFID = createField("rancontroller_refid", org.jooq.impl.SQLDataType.BIGINTUNSIGNED.nullable(false), this, "");

    /**
     * The column <code>chrono.crrancontroller.CONTROLLERNAME</code>.
     */
    public final TableField<CrrancontrollerRecord, String> CONTROLLERNAME = createField("CONTROLLERNAME", org.jooq.impl.SQLDataType.CHAR(32), this, "");

    /**
     * The column <code>chrono.crrancontroller.TYPE</code>.
     */
    public final TableField<CrrancontrollerRecord, String> TYPE = createField("TYPE", org.jooq.impl.SQLDataType.CHAR(32), this, "");

    /**
     * The column <code>chrono.crrancontroller.SWVERSION</code>.
     */
    public final TableField<CrrancontrollerRecord, String> SWVERSION = createField("SWVERSION", org.jooq.impl.SQLDataType.CHAR(32), this, "");

    /**
     * The column <code>chrono.crrancontroller.TOTALSUBRACK</code>.
     */
    public final TableField<CrrancontrollerRecord, Integer> TOTALSUBRACK = createField("TOTALSUBRACK", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.crrancontroller.TOTALBRD</code>.
     */
    public final TableField<CrrancontrollerRecord, Integer> TOTALBRD = createField("TOTALBRD", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.crrancontroller.TOTALBTS</code>.
     */
    public final TableField<CrrancontrollerRecord, Integer> TOTALBTS = createField("TOTALBTS", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.crrancontroller.TOTALTRXCAP</code>.
     */
    public final TableField<CrrancontrollerRecord, Integer> TOTALTRXCAP = createField("TOTALTRXCAP", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.crrancontroller.TOTALTRX</code>.
     */
    public final TableField<CrrancontrollerRecord, Integer> TOTALTRX = createField("TOTALTRX", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.crrancontroller.TRXOCCUP</code>.
     */
    public final TableField<CrrancontrollerRecord, Double> TRXOCCUP = createField("TRXOCCUP", org.jooq.impl.SQLDataType.DOUBLE, this, "");

    /**
     * The column <code>chrono.crrancontroller.TOTALCELL</code>.
     */
    public final TableField<CrrancontrollerRecord, Integer> TOTALCELL = createField("TOTALCELL", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.crrancontroller.IP</code>.
     */
    public final TableField<CrrancontrollerRecord, String> IP = createField("IP", org.jooq.impl.SQLDataType.CHAR(32), this, "");

    /**
     * Create a <code>chrono.crrancontroller</code> table reference
     */
    public Crrancontroller() {
        this(DSL.name("crrancontroller"), null);
    }

    /**
     * Create an aliased <code>chrono.crrancontroller</code> table reference
     */
    public Crrancontroller(String alias) {
        this(DSL.name(alias), CRRANCONTROLLER);
    }

    /**
     * Create an aliased <code>chrono.crrancontroller</code> table reference
     */
    public Crrancontroller(Name alias) {
        this(alias, CRRANCONTROLLER);
    }

    private Crrancontroller(Name alias, Table<CrrancontrollerRecord> aliased) {
        this(alias, aliased, null);
    }

    private Crrancontroller(Name alias, Table<CrrancontrollerRecord> aliased, Field<?>[] parameters) {
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
    public UniqueKey<CrrancontrollerRecord> getPrimaryKey() {
        return Keys.KEY_CRRANCONTROLLER_PRIMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<CrrancontrollerRecord>> getKeys() {
        return Arrays.<UniqueKey<CrrancontrollerRecord>>asList(Keys.KEY_CRRANCONTROLLER_PRIMARY, Keys.KEY_CRRANCONTROLLER_RANCONTROLLER_DATE_2);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Crrancontroller as(String alias) {
        return new Crrancontroller(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Crrancontroller as(Name alias) {
        return new Crrancontroller(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Crrancontroller rename(String name) {
        return new Crrancontroller(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Crrancontroller rename(Name name) {
        return new Crrancontroller(name, null);
    }
}

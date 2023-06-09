/*
 * This file is generated by jOOQ.
*/
package id.mit.chrono.server.model.tables;


import id.mit.chrono.server.model.Chrono;
import id.mit.chrono.server.model.Keys;
import id.mit.chrono.server.model.tables.records.Dailysysinfo2gcompare2Record;

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
public class Dailysysinfo2gcompare2 extends TableImpl<Dailysysinfo2gcompare2Record> {

    private static final long serialVersionUID = -1822438401;

    /**
     * The reference instance of <code>chrono.DailySysinfo2GCompare2</code>
     */
    public static final Dailysysinfo2gcompare2 DAILYSYSINFO2GCOMPARE2 = new Dailysysinfo2gcompare2();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<Dailysysinfo2gcompare2Record> getRecordType() {
        return Dailysysinfo2gcompare2Record.class;
    }

    /**
     * The column <code>chrono.DailySysinfo2GCompare2.SOURCE</code>.
     */
    public final TableField<Dailysysinfo2gcompare2Record, String> SOURCE = createField("SOURCE", org.jooq.impl.SQLDataType.VARCHAR(8).nullable(false), this, "");

    /**
     * The column <code>chrono.DailySysinfo2GCompare2.TEXT</code>.
     */
    public final TableField<Dailysysinfo2gcompare2Record, String> TEXT = createField("TEXT", org.jooq.impl.SQLDataType.CHAR(128).nullable(false), this, "");

    /**
     * The column <code>chrono.DailySysinfo2GCompare2.REGIONAL</code>.
     */
    public final TableField<Dailysysinfo2gcompare2Record, String> REGIONAL = createField("REGIONAL", org.jooq.impl.SQLDataType.VARCHAR(10).nullable(false), this, "");

    /**
     * The column <code>chrono.DailySysinfo2GCompare2.VENDOR</code>.
     */
    public final TableField<Dailysysinfo2gcompare2Record, String> VENDOR = createField("VENDOR", org.jooq.impl.SQLDataType.VARCHAR(8).nullable(false), this, "");

    /**
     * The column <code>chrono.DailySysinfo2GCompare2.BSCID LAC CI</code>.
     */
    public final TableField<Dailysysinfo2gcompare2Record, String> BSCID_LAC_CI = createField("BSCID LAC CI", org.jooq.impl.SQLDataType.VARCHAR(34).nullable(false), this, "");

    /**
     * The column <code>chrono.DailySysinfo2GCompare2.BSC NAME</code>.
     */
    public final TableField<Dailysysinfo2gcompare2Record, String> BSC_NAME = createField("BSC NAME", org.jooq.impl.SQLDataType.VARCHAR(23).nullable(false), this, "");

    /**
     * The column <code>chrono.DailySysinfo2GCompare2.BTS NAME</code>.
     */
    public final TableField<Dailysysinfo2gcompare2Record, String> BTS_NAME = createField("BTS NAME", org.jooq.impl.SQLDataType.VARCHAR(64), this, "");

    /**
     * The column <code>chrono.DailySysinfo2GCompare2.CELL NAME</code>.
     */
    public final TableField<Dailysysinfo2gcompare2Record, String> CELL_NAME = createField("CELL NAME", org.jooq.impl.SQLDataType.VARCHAR(63).nullable(false), this, "");

    /**
     * The column <code>chrono.DailySysinfo2GCompare2.CELL NO</code>.
     */
    public final TableField<Dailysysinfo2gcompare2Record, Integer> CELL_NO = createField("CELL NO", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>chrono.DailySysinfo2GCompare2.NE ID</code>.
     */
    public final TableField<Dailysysinfo2gcompare2Record, String> NE_ID = createField("NE ID", org.jooq.impl.SQLDataType.VARCHAR(18), this, "");

    /**
     * The column <code>chrono.DailySysinfo2GCompare2.SITE ID</code>.
     */
    public final TableField<Dailysysinfo2gcompare2Record, String> SITE_ID = createField("SITE ID", org.jooq.impl.SQLDataType.VARCHAR(7), this, "");

    /**
     * The column <code>chrono.DailySysinfo2GCompare2.LAC</code>.
     */
    public final TableField<Dailysysinfo2gcompare2Record, Integer> LAC = createField("LAC", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>chrono.DailySysinfo2GCompare2.CI</code>.
     */
    public final TableField<Dailysysinfo2gcompare2Record, Integer> CI = createField("CI", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>chrono.DailySysinfo2GCompare2.NCC</code>.
     */
    public final TableField<Dailysysinfo2gcompare2Record, Integer> NCC = createField("NCC", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.DailySysinfo2GCompare2.BCC</code>.
     */
    public final TableField<Dailysysinfo2gcompare2Record, Integer> BCC = createField("BCC", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.DailySysinfo2GCompare2.f0</code>.
     */
    public final TableField<Dailysysinfo2gcompare2Record, Integer> F0 = createField("f0", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.DailySysinfo2GCompare2.f1</code>.
     */
    public final TableField<Dailysysinfo2gcompare2Record, Integer> F1 = createField("f1", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.DailySysinfo2GCompare2.f2</code>.
     */
    public final TableField<Dailysysinfo2gcompare2Record, Integer> F2 = createField("f2", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.DailySysinfo2GCompare2.f3</code>.
     */
    public final TableField<Dailysysinfo2gcompare2Record, Integer> F3 = createField("f3", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.DailySysinfo2GCompare2.f4</code>.
     */
    public final TableField<Dailysysinfo2gcompare2Record, Integer> F4 = createField("f4", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.DailySysinfo2GCompare2.f5</code>.
     */
    public final TableField<Dailysysinfo2gcompare2Record, Integer> F5 = createField("f5", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.DailySysinfo2GCompare2.f6</code>.
     */
    public final TableField<Dailysysinfo2gcompare2Record, Integer> F6 = createField("f6", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.DailySysinfo2GCompare2.f7</code>.
     */
    public final TableField<Dailysysinfo2gcompare2Record, Integer> F7 = createField("f7", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.DailySysinfo2GCompare2.f8</code>.
     */
    public final TableField<Dailysysinfo2gcompare2Record, Integer> F8 = createField("f8", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.DailySysinfo2GCompare2.f9</code>.
     */
    public final TableField<Dailysysinfo2gcompare2Record, Integer> F9 = createField("f9", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.DailySysinfo2GCompare2.f10</code>.
     */
    public final TableField<Dailysysinfo2gcompare2Record, Integer> F10 = createField("f10", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.DailySysinfo2GCompare2.f11</code>.
     */
    public final TableField<Dailysysinfo2gcompare2Record, Integer> F11 = createField("f11", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.DailySysinfo2GCompare2.TRX</code>.
     */
    public final TableField<Dailysysinfo2gcompare2Record, Integer> TRX = createField("TRX", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.DailySysinfo2GCompare2.FREQUENCY(MHZ)</code>.
     */
    public final TableField<Dailysysinfo2gcompare2Record, Double> FREQUENCY_28MHZ_29 = createField("FREQUENCY(MHZ)", org.jooq.impl.SQLDataType.FLOAT, this, "");

    /**
     * The column <code>chrono.DailySysinfo2GCompare2.BANDTYPE</code>.
     */
    public final TableField<Dailysysinfo2gcompare2Record, String> BANDTYPE = createField("BANDTYPE", org.jooq.impl.SQLDataType.VARCHAR(9).nullable(false), this, "");

    /**
     * The column <code>chrono.DailySysinfo2GCompare2.TYPE BTS</code>.
     */
    public final TableField<Dailysysinfo2gcompare2Record, String> TYPE_BTS = createField("TYPE BTS", org.jooq.impl.SQLDataType.VARCHAR(16), this, "");

    /**
     * The column <code>chrono.DailySysinfo2GCompare2.TYPE FREQUENCY</code>.
     */
    public final TableField<Dailysysinfo2gcompare2Record, String> TYPE_FREQUENCY = createField("TYPE FREQUENCY", org.jooq.impl.SQLDataType.VARCHAR(7).nullable(false), this, "");

    /**
     * The column <code>chrono.DailySysinfo2GCompare2.NEW SITE</code>.
     */
    public final TableField<Dailysysinfo2gcompare2Record, String> NEW_SITE = createField("NEW SITE", org.jooq.impl.SQLDataType.VARCHAR(8).nullable(false), this, "");

    /**
     * The column <code>chrono.DailySysinfo2GCompare2.LONGITUDE</code>.
     */
    public final TableField<Dailysysinfo2gcompare2Record, Double> LONGITUDE = createField("LONGITUDE", org.jooq.impl.SQLDataType.FLOAT.nullable(false), this, "");

    /**
     * The column <code>chrono.DailySysinfo2GCompare2.LATITUDE</code>.
     */
    public final TableField<Dailysysinfo2gcompare2Record, Double> LATITUDE = createField("LATITUDE", org.jooq.impl.SQLDataType.FLOAT.nullable(false), this, "");

    /**
     * The column <code>chrono.DailySysinfo2GCompare2.STATUS</code>.
     */
    public final TableField<Dailysysinfo2gcompare2Record, String> STATUS = createField("STATUS", org.jooq.impl.SQLDataType.VARCHAR(8), this, "");

    /**
     * The column <code>chrono.DailySysinfo2GCompare2.BTSNUMBER</code>.
     */
    public final TableField<Dailysysinfo2gcompare2Record, Integer> BTSNUMBER = createField("BTSNUMBER", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.DailySysinfo2GCompare2.CELLNUMBER</code>.
     */
    public final TableField<Dailysysinfo2gcompare2Record, Integer> CELLNUMBER = createField("CELLNUMBER", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * Create a <code>chrono.DailySysinfo2GCompare2</code> table reference
     */
    public Dailysysinfo2gcompare2() {
        this(DSL.name("DailySysinfo2GCompare2"), null);
    }

    /**
     * Create an aliased <code>chrono.DailySysinfo2GCompare2</code> table reference
     */
    public Dailysysinfo2gcompare2(String alias) {
        this(DSL.name(alias), DAILYSYSINFO2GCOMPARE2);
    }

    /**
     * Create an aliased <code>chrono.DailySysinfo2GCompare2</code> table reference
     */
    public Dailysysinfo2gcompare2(Name alias) {
        this(alias, DAILYSYSINFO2GCOMPARE2);
    }

    private Dailysysinfo2gcompare2(Name alias, Table<Dailysysinfo2gcompare2Record> aliased) {
        this(alias, aliased, null);
    }

    private Dailysysinfo2gcompare2(Name alias, Table<Dailysysinfo2gcompare2Record> aliased, Field<?>[] parameters) {
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
    public UniqueKey<Dailysysinfo2gcompare2Record> getPrimaryKey() {
        return Keys.KEY_DAILYSYSINFO2GCOMPARE2_PRIMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<Dailysysinfo2gcompare2Record>> getKeys() {
        return Arrays.<UniqueKey<Dailysysinfo2gcompare2Record>>asList(Keys.KEY_DAILYSYSINFO2GCOMPARE2_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Dailysysinfo2gcompare2 as(String alias) {
        return new Dailysysinfo2gcompare2(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Dailysysinfo2gcompare2 as(Name alias) {
        return new Dailysysinfo2gcompare2(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Dailysysinfo2gcompare2 rename(String name) {
        return new Dailysysinfo2gcompare2(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Dailysysinfo2gcompare2 rename(Name name) {
        return new Dailysysinfo2gcompare2(name, null);
    }
}

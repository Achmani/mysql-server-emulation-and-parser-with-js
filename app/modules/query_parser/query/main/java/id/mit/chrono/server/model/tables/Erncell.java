/*
 * This file is generated by jOOQ.
*/
package id.mit.chrono.server.model.tables;


import id.mit.chrono.server.model.Chrono;
import id.mit.chrono.server.model.Keys;
import id.mit.chrono.server.model.tables.records.ErncellRecord;

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
public class Erncell extends TableImpl<ErncellRecord> {

    private static final long serialVersionUID = 253305287;

    /**
     * The reference instance of <code>chrono.erncell</code>
     */
    public static final Erncell ERNCELL = new Erncell();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<ErncellRecord> getRecordType() {
        return ErncellRecord.class;
    }

    /**
     * The column <code>chrono.erncell.erncell_id</code>.
     */
    public final TableField<ErncellRecord, ULong> ERNCELL_ID = createField("erncell_id", org.jooq.impl.SQLDataType.BIGINTUNSIGNED.nullable(false), this, "");

    /**
     * The column <code>chrono.erncell.erncell_crcollectortaskfiles</code>.
     */
    public final TableField<ErncellRecord, ULong> ERNCELL_CRCOLLECTORTASKFILES = createField("erncell_crcollectortaskfiles", org.jooq.impl.SQLDataType.BIGINTUNSIGNED, this, "");

    /**
     * The column <code>chrono.erncell.erncell_date</code>.
     */
    public final TableField<ErncellRecord, UInteger> ERNCELL_DATE = createField("erncell_date", org.jooq.impl.SQLDataType.INTEGERUNSIGNED.nullable(false), this, "");

    /**
     * The column <code>chrono.erncell.erncell_ergnodeb</code>.
     */
    public final TableField<ErncellRecord, ULong> ERNCELL_ERGNODEB = createField("erncell_ergnodeb", org.jooq.impl.SQLDataType.BIGINTUNSIGNED, this, "");

    /**
     * The column <code>chrono.erncell.erncell_nodealias</code>.
     */
    public final TableField<ErncellRecord, Integer> ERNCELL_NODEALIAS = createField("erncell_nodealias", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.erncell.erncell_cell</code>.
     */
    public final TableField<ErncellRecord, Integer> ERNCELL_CELL = createField("erncell_cell", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.erncell.erncell_cellclass</code>.
     */
    public final TableField<ErncellRecord, Integer> ERNCELL_CELLCLASS = createField("erncell_cellclass", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.erncell.erncell_cellclassgroup</code>.
     */
    public final TableField<ErncellRecord, Integer> ERNCELL_CELLCLASSGROUP = createField("erncell_cellclassgroup", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.erncell.erncell_cellcoverage</code>.
     */
    public final TableField<ErncellRecord, Integer> ERNCELL_CELLCOVERAGE = createField("erncell_cellcoverage", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.erncell.erncell_revenueclass</code>.
     */
    public final TableField<ErncellRecord, Integer> ERNCELL_REVENUECLASS = createField("erncell_revenueclass", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.erncell.erncell_cellstatus</code>.
     */
    public final TableField<ErncellRecord, Integer> ERNCELL_CELLSTATUS = createField("erncell_cellstatus", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.erncell.erncell_vendor</code>.
     */
    public final TableField<ErncellRecord, Integer> ERNCELL_VENDOR = createField("erncell_vendor", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.erncell.erncell_latitude</code>.
     */
    public final TableField<ErncellRecord, Double> ERNCELL_LATITUDE = createField("erncell_latitude", org.jooq.impl.SQLDataType.DOUBLE, this, "");

    /**
     * The column <code>chrono.erncell.erncell_longitude</code>.
     */
    public final TableField<ErncellRecord, Double> ERNCELL_LONGITUDE = createField("erncell_longitude", org.jooq.impl.SQLDataType.DOUBLE, this, "");

    /**
     * The column <code>chrono.erncell.erncell_namingvalid</code>.
     */
    public final TableField<ErncellRecord, Byte> ERNCELL_NAMINGVALID = createField("erncell_namingvalid", org.jooq.impl.SQLDataType.TINYINT, this, "");

    /**
     * The column <code>chrono.erncell.CELLID</code>.
     */
    public final TableField<ErncellRecord, String> CELLID = createField("CELLID", org.jooq.impl.SQLDataType.CHAR(8), this, "");

    /**
     * The column <code>chrono.erncell.CELLRADIUS</code>.
     */
    public final TableField<ErncellRecord, String> CELLRADIUS = createField("CELLRADIUS", org.jooq.impl.SQLDataType.CHAR(8), this, "");

    /**
     * The column <code>chrono.erncell.DLBANDWIDTH</code>.
     */
    public final TableField<ErncellRecord, String> DLBANDWIDTH = createField("DLBANDWIDTH", org.jooq.impl.SQLDataType.CHAR(12), this, "");

    /**
     * The column <code>chrono.erncell.GNODEBFUNCTIONNAME</code>.
     */
    public final TableField<ErncellRecord, String> GNODEBFUNCTIONNAME = createField("GNODEBFUNCTIONNAME", org.jooq.impl.SQLDataType.CHAR(96), this, "");

    /**
     * The column <code>chrono.erncell.NARFCN</code>.
     */
    public final TableField<ErncellRecord, String> NARFCN = createField("NARFCN", org.jooq.impl.SQLDataType.CHAR(8), this, "");

    /**
     * The column <code>chrono.erncell.DLNARFCN</code>.
     */
    public final TableField<ErncellRecord, String> DLNARFCN = createField("DLNARFCN", org.jooq.impl.SQLDataType.CHAR(8), this, "");

    /**
     * The column <code>chrono.erncell.ULNARFCN</code>.
     */
    public final TableField<ErncellRecord, String> ULNARFCN = createField("ULNARFCN", org.jooq.impl.SQLDataType.CHAR(8), this, "");

    /**
     * The column <code>chrono.erncell.DLFREQ</code>.
     */
    public final TableField<ErncellRecord, Double> DLFREQ = createField("DLFREQ", org.jooq.impl.SQLDataType.DOUBLE, this, "");

    /**
     * The column <code>chrono.erncell.ULFREQ</code>.
     */
    public final TableField<ErncellRecord, Double> ULFREQ = createField("ULFREQ", org.jooq.impl.SQLDataType.DOUBLE, this, "");

    /**
     * The column <code>chrono.erncell.FDDTDDIND</code>.
     */
    public final TableField<ErncellRecord, String> FDDTDDIND = createField("FDDTDDIND", org.jooq.impl.SQLDataType.CHAR(12), this, "");

    /**
     * The column <code>chrono.erncell.LOCALCELLID</code>.
     */
    public final TableField<ErncellRecord, String> LOCALCELLID = createField("LOCALCELLID", org.jooq.impl.SQLDataType.CHAR(8), this, "");

    /**
     * The column <code>chrono.erncell.PHYCELLID</code>.
     */
    public final TableField<ErncellRecord, String> PHYCELLID = createField("PHYCELLID", org.jooq.impl.SQLDataType.CHAR(8), this, "");

    /**
     * The column <code>chrono.erncell.TXRXMODE</code>.
     */
    public final TableField<ErncellRecord, String> TXRXMODE = createField("TXRXMODE", org.jooq.impl.SQLDataType.CHAR(32), this, "");

    /**
     * The column <code>chrono.erncell.ULBANDWIDTH</code>.
     */
    public final TableField<ErncellRecord, String> ULBANDWIDTH = createField("ULBANDWIDTH", org.jooq.impl.SQLDataType.CHAR(16), this, "");

    /**
     * The column <code>chrono.erncell.CELLNAME</code>.
     */
    public final TableField<ErncellRecord, String> CELLNAME = createField("CELLNAME", org.jooq.impl.SQLDataType.CHAR(64), this, "");

    /**
     * The column <code>chrono.erncell.FREQBAND</code>.
     */
    public final TableField<ErncellRecord, String> FREQBAND = createField("FREQBAND", org.jooq.impl.SQLDataType.CHAR(4), this, "");

    /**
     * The column <code>chrono.erncell.WORKMODE</code>.
     */
    public final TableField<ErncellRecord, String> WORKMODE = createField("WORKMODE", org.jooq.impl.SQLDataType.CHAR(8), this, "");

    /**
     * The column <code>chrono.erncell.CSIRSPERIOD</code>.
     */
    public final TableField<ErncellRecord, String> CSIRSPERIOD = createField("CSIRSPERIOD", org.jooq.impl.SQLDataType.CHAR(8), this, "");

    /**
     * The column <code>chrono.erncell.EUCELLSTANDBYMODE</code>.
     */
    public final TableField<ErncellRecord, String> EUCELLSTANDBYMODE = createField("EUCELLSTANDBYMODE", org.jooq.impl.SQLDataType.CHAR(8), this, "");

    /**
     * The column <code>chrono.erncell.HIGHSPEEDFLAG</code>.
     */
    public final TableField<ErncellRecord, String> HIGHSPEEDFLAG = createField("HIGHSPEEDFLAG", org.jooq.impl.SQLDataType.CHAR(12), this, "");

    /**
     * The column <code>chrono.erncell.INTRAFREQANRIND</code>.
     */
    public final TableField<ErncellRecord, String> INTRAFREQANRIND = createField("INTRAFREQANRIND", org.jooq.impl.SQLDataType.CHAR(12), this, "");

    /**
     * The column <code>chrono.erncell.INTRAFREQRANSHARINGIND</code>.
     */
    public final TableField<ErncellRecord, String> INTRAFREQRANSHARINGIND = createField("INTRAFREQRANSHARINGIND", org.jooq.impl.SQLDataType.CHAR(16), this, "");

    /**
     * The column <code>chrono.erncell.MULTICELLSHAREMODE</code>.
     */
    public final TableField<ErncellRecord, String> MULTICELLSHAREMODE = createField("MULTICELLSHAREMODE", org.jooq.impl.SQLDataType.CHAR(12), this, "");

    /**
     * The column <code>chrono.erncell.MULTIRRUCELLFLAG</code>.
     */
    public final TableField<ErncellRecord, String> MULTIRRUCELLFLAG = createField("MULTIRRUCELLFLAG", org.jooq.impl.SQLDataType.CHAR(16), this, "");

    /**
     * The column <code>chrono.erncell.MCC</code>.
     */
    public final TableField<ErncellRecord, String> MCC = createField("MCC", org.jooq.impl.SQLDataType.CHAR(4), this, "");

    /**
     * The column <code>chrono.erncell.MNC</code>.
     */
    public final TableField<ErncellRecord, String> MNC = createField("MNC", org.jooq.impl.SQLDataType.CHAR(4), this, "");

    /**
     * The column <code>chrono.erncell.GNODEBID</code>.
     */
    public final TableField<ErncellRecord, String> GNODEBID = createField("GNODEBID", org.jooq.impl.SQLDataType.CHAR(8), this, "");

    /**
     * The column <code>chrono.erncell.TAC</code>.
     */
    public final TableField<ErncellRecord, String> TAC = createField("TAC", org.jooq.impl.SQLDataType.CHAR(11), this, "");

    /**
     * The column <code>chrono.erncell.TAI</code>.
     */
    public final TableField<ErncellRecord, String> TAI = createField("TAI", org.jooq.impl.SQLDataType.CHAR(16), this, "");

    /**
     * The column <code>chrono.erncell.ECI</code>.
     */
    public final TableField<ErncellRecord, String> ECI = createField("ECI", org.jooq.impl.SQLDataType.CHAR(16), this, "");

    /**
     * The column <code>chrono.erncell.NCGI</code>.
     */
    public final TableField<ErncellRecord, String> NCGI = createField("NCGI", org.jooq.impl.SQLDataType.CHAR(24), this, "");

    /**
     * The column <code>chrono.erncell.GGNODEBID</code>.
     */
    public final TableField<ErncellRecord, String> GGNODEBID = createField("GGNODEBID", org.jooq.impl.SQLDataType.CHAR(16), this, "");

    /**
     * The column <code>chrono.erncell.CELLACTIVESTATE</code>.
     */
    public final TableField<ErncellRecord, String> CELLACTIVESTATE = createField("CELLACTIVESTATE", org.jooq.impl.SQLDataType.CHAR(16), this, "");

    /**
     * The column <code>chrono.erncell.CELLADMINSTATE</code>.
     */
    public final TableField<ErncellRecord, String> CELLADMINSTATE = createField("CELLADMINSTATE", org.jooq.impl.SQLDataType.CHAR(16), this, "");

    /**
     * The column <code>chrono.erncell.ANTLATITUDE</code>.
     */
    public final TableField<ErncellRecord, String> ANTLATITUDE = createField("ANTLATITUDE", org.jooq.impl.SQLDataType.CHAR(16), this, "");

    /**
     * The column <code>chrono.erncell.ANTLONGITUDE</code>.
     */
    public final TableField<ErncellRecord, String> ANTLONGITUDE = createField("ANTLONGITUDE", org.jooq.impl.SQLDataType.CHAR(16), this, "");

    /**
     * The column <code>chrono.erncell.LATITUDE</code>.
     */
    public final TableField<ErncellRecord, String> LATITUDE = createField("LATITUDE", org.jooq.impl.SQLDataType.CHAR(16), this, "");

    /**
     * The column <code>chrono.erncell.LONGITUDE</code>.
     */
    public final TableField<ErncellRecord, String> LONGITUDE = createField("LONGITUDE", org.jooq.impl.SQLDataType.CHAR(16), this, "");

    /**
     * The column <code>chrono.erncell.erlcell_remark</code>.
     */
    public final TableField<ErncellRecord, String> ERLCELL_REMARK = createField("erlcell_remark", org.jooq.impl.SQLDataType.CLOB, this, "");

    /**
     * Create a <code>chrono.erncell</code> table reference
     */
    public Erncell() {
        this(DSL.name("erncell"), null);
    }

    /**
     * Create an aliased <code>chrono.erncell</code> table reference
     */
    public Erncell(String alias) {
        this(DSL.name(alias), ERNCELL);
    }

    /**
     * Create an aliased <code>chrono.erncell</code> table reference
     */
    public Erncell(Name alias) {
        this(alias, ERNCELL);
    }

    private Erncell(Name alias, Table<ErncellRecord> aliased) {
        this(alias, aliased, null);
    }

    private Erncell(Name alias, Table<ErncellRecord> aliased, Field<?>[] parameters) {
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
    public UniqueKey<ErncellRecord> getPrimaryKey() {
        return Keys.KEY_ERNCELL_PRIMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<ErncellRecord>> getKeys() {
        return Arrays.<UniqueKey<ErncellRecord>>asList(Keys.KEY_ERNCELL_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Erncell as(String alias) {
        return new Erncell(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Erncell as(Name alias) {
        return new Erncell(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Erncell rename(String name) {
        return new Erncell(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Erncell rename(Name name) {
        return new Erncell(name, null);
    }
}

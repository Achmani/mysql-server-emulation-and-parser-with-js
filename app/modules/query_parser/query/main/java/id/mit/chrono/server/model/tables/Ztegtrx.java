/*
 * This file is generated by jOOQ.
*/
package id.mit.chrono.server.model.tables;


import id.mit.chrono.server.model.Chrono;
import id.mit.chrono.server.model.Indexes;
import id.mit.chrono.server.model.Keys;
import id.mit.chrono.server.model.tables.records.ZtegtrxRecord;

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
public class Ztegtrx extends TableImpl<ZtegtrxRecord> {

    private static final long serialVersionUID = -1791824183;

    /**
     * The reference instance of <code>chrono.ztegtrx</code>
     */
    public static final Ztegtrx ZTEGTRX = new Ztegtrx();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<ZtegtrxRecord> getRecordType() {
        return ZtegtrxRecord.class;
    }

    /**
     * The column <code>chrono.ztegtrx.ztegtrx_id</code>.
     */
    public final TableField<ZtegtrxRecord, ULong> ZTEGTRX_ID = createField("ztegtrx_id", org.jooq.impl.SQLDataType.BIGINTUNSIGNED.nullable(false), this, "");

    /**
     * The column <code>chrono.ztegtrx.ztegtrx_crcollectortaskfiles</code>.
     */
    public final TableField<ZtegtrxRecord, ULong> ZTEGTRX_CRCOLLECTORTASKFILES = createField("ztegtrx_crcollectortaskfiles", org.jooq.impl.SQLDataType.BIGINTUNSIGNED, this, "");

    /**
     * The column <code>chrono.ztegtrx.ztegtrx_date</code>.
     */
    public final TableField<ZtegtrxRecord, UInteger> ZTEGTRX_DATE = createField("ztegtrx_date", org.jooq.impl.SQLDataType.INTEGERUNSIGNED.nullable(false), this, "");

    /**
     * The column <code>chrono.ztegtrx.ztegtrx_datefrom</code>.
     */
    public final TableField<ZtegtrxRecord, UInteger> ZTEGTRX_DATEFROM = createField("ztegtrx_datefrom", org.jooq.impl.SQLDataType.INTEGERUNSIGNED, this, "");

    /**
     * The column <code>chrono.ztegtrx.ztegtrx_ztebsc</code>.
     */
    public final TableField<ZtegtrxRecord, ULong> ZTEGTRX_ZTEBSC = createField("ztegtrx_ztebsc", org.jooq.impl.SQLDataType.BIGINTUNSIGNED.nullable(false), this, "");

    /**
     * The column <code>chrono.ztegtrx.ztegtrx_ztebts</code>.
     */
    public final TableField<ZtegtrxRecord, ULong> ZTEGTRX_ZTEBTS = createField("ztegtrx_ztebts", org.jooq.impl.SQLDataType.BIGINTUNSIGNED, this, "");

    /**
     * The column <code>chrono.ztegtrx.ztegtrx_ztegcell</code>.
     */
    public final TableField<ZtegtrxRecord, ULong> ZTEGTRX_ZTEGCELL = createField("ztegtrx_ztegcell", org.jooq.impl.SQLDataType.BIGINTUNSIGNED, this, "");

    /**
     * The column <code>chrono.ztegtrx.MOI</code>.
     */
    public final TableField<ZtegtrxRecord, String> MOI = createField("MOI", org.jooq.impl.SQLDataType.CHAR(96), this, "");

    /**
     * The column <code>chrono.ztegtrx.SubNetwork</code>.
     */
    public final TableField<ZtegtrxRecord, String> SUBNETWORK = createField("SubNetwork", org.jooq.impl.SQLDataType.CHAR(6), this, "");

    /**
     * The column <code>chrono.ztegtrx.MEID</code>.
     */
    public final TableField<ZtegtrxRecord, String> MEID = createField("MEID", org.jooq.impl.SQLDataType.CHAR(6), this, "");

    /**
     * The column <code>chrono.ztegtrx.GBssFunction</code>.
     */
    public final TableField<ZtegtrxRecord, String> GBSSFUNCTION = createField("GBssFunction", org.jooq.impl.SQLDataType.CHAR(6), this, "");

    /**
     * The column <code>chrono.ztegtrx.GBtsSiteManager</code>.
     */
    public final TableField<ZtegtrxRecord, String> GBTSSITEMANAGER = createField("GBtsSiteManager", org.jooq.impl.SQLDataType.CHAR(6), this, "");

    /**
     * The column <code>chrono.ztegtrx.GGsmCell</code>.
     */
    public final TableField<ZtegtrxRecord, String> GGSMCELL = createField("GGsmCell", org.jooq.impl.SQLDataType.CHAR(6), this, "");

    /**
     * The column <code>chrono.ztegtrx.GTrx</code>.
     */
    public final TableField<ZtegtrxRecord, String> GTRX = createField("GTrx", org.jooq.impl.SQLDataType.CHAR(6), this, "");

    /**
     * The column <code>chrono.ztegtrx.userLabel</code>.
     */
    public final TableField<ZtegtrxRecord, String> USERLABEL = createField("userLabel", org.jooq.impl.SQLDataType.CHAR(96), this, "");

    /**
     * The column <code>chrono.ztegtrx.GTrxSeq</code>.
     */
    public final TableField<ZtegtrxRecord, String> GTRXSEQ = createField("GTrxSeq", org.jooq.impl.SQLDataType.CHAR(8), this, "");

    /**
     * The column <code>chrono.ztegtrx.BCCHMARK</code>.
     */
    public final TableField<ZtegtrxRecord, String> BCCHMARK = createField("BCCHMARK", org.jooq.impl.SQLDataType.CHAR(8), this, "");

    /**
     * The column <code>chrono.ztegtrx.trxPriority</code>.
     */
    public final TableField<ZtegtrxRecord, String> TRXPRIORITY = createField("trxPriority", org.jooq.impl.SQLDataType.CHAR(8), this, "");

    /**
     * The column <code>chrono.ztegtrx.arfcn</code>.
     */
    public final TableField<ZtegtrxRecord, String> ARFCN = createField("arfcn", org.jooq.impl.SQLDataType.CHAR(8), this, "");

    /**
     * The column <code>chrono.ztegtrx.refGBtsPanel</code>.
     */
    public final TableField<ZtegtrxRecord, String> REFGBTSPANEL = createField("refGBtsPanel", org.jooq.impl.SQLDataType.CHAR(64), this, "");

    /**
     * The column <code>chrono.ztegtrx.trxType</code>.
     */
    public final TableField<ZtegtrxRecord, String> TRXTYPE = createField("trxType", org.jooq.impl.SQLDataType.CHAR(3), this, "");

    /**
     * The column <code>chrono.ztegtrx.pwrReduction</code>.
     */
    public final TableField<ZtegtrxRecord, String> PWRREDUCTION = createField("pwrReduction", org.jooq.impl.SQLDataType.CHAR(3), this, "");

    /**
     * The column <code>chrono.ztegtrx.powerClass</code>.
     */
    public final TableField<ZtegtrxRecord, String> POWERCLASS = createField("powerClass", org.jooq.impl.SQLDataType.CHAR(3), this, "");

    /**
     * The column <code>chrono.ztegtrx.refGTrx</code>.
     */
    public final TableField<ZtegtrxRecord, String> REFGTRX = createField("refGTrx", org.jooq.impl.SQLDataType.CHAR(64), this, "");

    /**
     * The column <code>chrono.ztegtrx.rttiPrefer</code>.
     */
    public final TableField<ZtegtrxRecord, String> RTTIPREFER = createField("rttiPrefer", org.jooq.impl.SQLDataType.CHAR(3), this, "");

    /**
     * The column <code>chrono.ztegtrx.tsc2</code>.
     */
    public final TableField<ZtegtrxRecord, String> TSC2 = createField("tsc2", org.jooq.impl.SQLDataType.CHAR(3), this, "");

    /**
     * The column <code>chrono.ztegtrx.DynamicTrx</code>.
     */
    public final TableField<ZtegtrxRecord, String> DYNAMICTRX = createField("DynamicTrx", org.jooq.impl.SQLDataType.CHAR(3), this, "");

    /**
     * The column <code>chrono.ztegtrx.refGHoppingFrequency</code>.
     */
    public final TableField<ZtegtrxRecord, String> REFGHOPPINGFREQUENCY = createField("refGHoppingFrequency", org.jooq.impl.SQLDataType.CHAR(128), this, "");

    /**
     * The column <code>chrono.ztegtrx.refGHoppingBaseband</code>.
     */
    public final TableField<ZtegtrxRecord, String> REFGHOPPINGBASEBAND = createField("refGHoppingBaseband", org.jooq.impl.SQLDataType.CHAR(64), this, "");

    /**
     * The column <code>chrono.ztegtrx.CombinerLoss</code>.
     */
    public final TableField<ZtegtrxRecord, String> COMBINERLOSS = createField("CombinerLoss", org.jooq.impl.SQLDataType.CHAR(3), this, "");

    /**
     * The column <code>chrono.ztegtrx.maio</code>.
     */
    public final TableField<ZtegtrxRecord, String> MAIO = createField("maio", org.jooq.impl.SQLDataType.CHAR(3), this, "");

    /**
     * The column <code>chrono.ztegtrx.TsFHSupport</code>.
     */
    public final TableField<ZtegtrxRecord, String> TSFHSUPPORT = createField("TsFHSupport", org.jooq.impl.SQLDataType.CHAR(3), this, "");

    /**
     * The column <code>chrono.ztegtrx.IFTATRX</code>.
     */
    public final TableField<ZtegtrxRecord, String> IFTATRX = createField("IFTATRX", org.jooq.impl.SQLDataType.CHAR(3), this, "");

    /**
     * The column <code>chrono.ztegtrx.UseWhenIFTAOff</code>.
     */
    public final TableField<ZtegtrxRecord, String> USEWHENIFTAOFF = createField("UseWhenIFTAOff", org.jooq.impl.SQLDataType.CHAR(3), this, "");

    /**
     * Create a <code>chrono.ztegtrx</code> table reference
     */
    public Ztegtrx() {
        this(DSL.name("ztegtrx"), null);
    }

    /**
     * Create an aliased <code>chrono.ztegtrx</code> table reference
     */
    public Ztegtrx(String alias) {
        this(DSL.name(alias), ZTEGTRX);
    }

    /**
     * Create an aliased <code>chrono.ztegtrx</code> table reference
     */
    public Ztegtrx(Name alias) {
        this(alias, ZTEGTRX);
    }

    private Ztegtrx(Name alias, Table<ZtegtrxRecord> aliased) {
        this(alias, aliased, null);
    }

    private Ztegtrx(Name alias, Table<ZtegtrxRecord> aliased, Field<?>[] parameters) {
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
        return Arrays.<Index>asList(Indexes.ZTEGTRX_PRIMARY, Indexes.ZTEGTRX_ZTEGTRX_DATE);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<ZtegtrxRecord> getPrimaryKey() {
        return Keys.KEY_ZTEGTRX_PRIMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<ZtegtrxRecord>> getKeys() {
        return Arrays.<UniqueKey<ZtegtrxRecord>>asList(Keys.KEY_ZTEGTRX_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Ztegtrx as(String alias) {
        return new Ztegtrx(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Ztegtrx as(Name alias) {
        return new Ztegtrx(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Ztegtrx rename(String name) {
        return new Ztegtrx(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Ztegtrx rename(Name name) {
        return new Ztegtrx(name, null);
    }
}
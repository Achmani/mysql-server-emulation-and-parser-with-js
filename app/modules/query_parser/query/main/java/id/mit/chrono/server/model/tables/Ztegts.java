/*
 * This file is generated by jOOQ.
*/
package id.mit.chrono.server.model.tables;


import id.mit.chrono.server.model.Chrono;
import id.mit.chrono.server.model.Keys;
import id.mit.chrono.server.model.tables.records.ZtegtsRecord;

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
public class Ztegts extends TableImpl<ZtegtsRecord> {

    private static final long serialVersionUID = 648479133;

    /**
     * The reference instance of <code>chrono.ztegts</code>
     */
    public static final Ztegts ZTEGTS = new Ztegts();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<ZtegtsRecord> getRecordType() {
        return ZtegtsRecord.class;
    }

    /**
     * The column <code>chrono.ztegts.ztegts_id</code>.
     */
    public final TableField<ZtegtsRecord, ULong> ZTEGTS_ID = createField("ztegts_id", org.jooq.impl.SQLDataType.BIGINTUNSIGNED.nullable(false), this, "");

    /**
     * The column <code>chrono.ztegts.ztegts_crcollectortaskfiles</code>.
     */
    public final TableField<ZtegtsRecord, ULong> ZTEGTS_CRCOLLECTORTASKFILES = createField("ztegts_crcollectortaskfiles", org.jooq.impl.SQLDataType.BIGINTUNSIGNED, this, "");

    /**
     * The column <code>chrono.ztegts.ztegts_date</code>.
     */
    public final TableField<ZtegtsRecord, UInteger> ZTEGTS_DATE = createField("ztegts_date", org.jooq.impl.SQLDataType.INTEGERUNSIGNED.nullable(false), this, "");

    /**
     * The column <code>chrono.ztegts.ztegts_datefrom</code>.
     */
    public final TableField<ZtegtsRecord, UInteger> ZTEGTS_DATEFROM = createField("ztegts_datefrom", org.jooq.impl.SQLDataType.INTEGERUNSIGNED, this, "");

    /**
     * The column <code>chrono.ztegts.ztegts_ztebsc</code>.
     */
    public final TableField<ZtegtsRecord, ULong> ZTEGTS_ZTEBSC = createField("ztegts_ztebsc", org.jooq.impl.SQLDataType.BIGINTUNSIGNED.nullable(false), this, "");

    /**
     * The column <code>chrono.ztegts.ztegts_ztebts</code>.
     */
    public final TableField<ZtegtsRecord, ULong> ZTEGTS_ZTEBTS = createField("ztegts_ztebts", org.jooq.impl.SQLDataType.BIGINTUNSIGNED, this, "");

    /**
     * The column <code>chrono.ztegts.ztegts_ztegcell</code>.
     */
    public final TableField<ZtegtsRecord, ULong> ZTEGTS_ZTEGCELL = createField("ztegts_ztegcell", org.jooq.impl.SQLDataType.BIGINTUNSIGNED, this, "");

    /**
     * The column <code>chrono.ztegts.ztegts_ztegtrx</code>.
     */
    public final TableField<ZtegtsRecord, ULong> ZTEGTS_ZTEGTRX = createField("ztegts_ztegtrx", org.jooq.impl.SQLDataType.BIGINTUNSIGNED, this, "");

    /**
     * The column <code>chrono.ztegts.MOI</code>.
     */
    public final TableField<ZtegtsRecord, String> MOI = createField("MOI", org.jooq.impl.SQLDataType.CHAR(96), this, "");

    /**
     * The column <code>chrono.ztegts.SubNetwork</code>.
     */
    public final TableField<ZtegtsRecord, String> SUBNETWORK = createField("SubNetwork", org.jooq.impl.SQLDataType.CHAR(6), this, "");

    /**
     * The column <code>chrono.ztegts.MEID</code>.
     */
    public final TableField<ZtegtsRecord, String> MEID = createField("MEID", org.jooq.impl.SQLDataType.CHAR(6), this, "");

    /**
     * The column <code>chrono.ztegts.GBssFunction</code>.
     */
    public final TableField<ZtegtsRecord, String> GBSSFUNCTION = createField("GBssFunction", org.jooq.impl.SQLDataType.CHAR(6), this, "");

    /**
     * The column <code>chrono.ztegts.GBtsSiteManager</code>.
     */
    public final TableField<ZtegtsRecord, String> GBTSSITEMANAGER = createField("GBtsSiteManager", org.jooq.impl.SQLDataType.CHAR(6), this, "");

    /**
     * The column <code>chrono.ztegts.GGsmCell</code>.
     */
    public final TableField<ZtegtsRecord, String> GGSMCELL = createField("GGsmCell", org.jooq.impl.SQLDataType.CHAR(6), this, "");

    /**
     * The column <code>chrono.ztegts.GTrx</code>.
     */
    public final TableField<ZtegtsRecord, String> GTRX = createField("GTrx", org.jooq.impl.SQLDataType.CHAR(6), this, "");

    /**
     * The column <code>chrono.ztegts.GTs</code>.
     */
    public final TableField<ZtegtsRecord, String> GTS = createField("GTs", org.jooq.impl.SQLDataType.CHAR(6), this, "");

    /**
     * The column <code>chrono.ztegts.userLabel</code>.
     */
    public final TableField<ZtegtsRecord, String> USERLABEL = createField("userLabel", org.jooq.impl.SQLDataType.CHAR(96), this, "");

    /**
     * The column <code>chrono.ztegts.GTsSeq</code>.
     */
    public final TableField<ZtegtsRecord, String> GTSSEQ = createField("GTsSeq", org.jooq.impl.SQLDataType.CHAR(8), this, "");

    /**
     * The column <code>chrono.ztegts.tsChannelComb</code>.
     */
    public final TableField<ZtegtsRecord, String> TSCHANNELCOMB = createField("tsChannelComb", org.jooq.impl.SQLDataType.CHAR(8), this, "");

    /**
     * The column <code>chrono.ztegts.changeable</code>.
     */
    public final TableField<ZtegtsRecord, String> CHANGEABLE = createField("changeable", org.jooq.impl.SQLDataType.CHAR(8), this, "");

    /**
     * The column <code>chrono.ztegts.preferPsService</code>.
     */
    public final TableField<ZtegtsRecord, String> PREFERPSSERVICE = createField("preferPsService", org.jooq.impl.SQLDataType.CHAR(8), this, "");

    /**
     * The column <code>chrono.ztegts.pairNo</code>.
     */
    public final TableField<ZtegtsRecord, String> PAIRNO = createField("pairNo", org.jooq.impl.SQLDataType.CHAR(8), this, "");

    /**
     * The column <code>chrono.ztegts.usfMode</code>.
     */
    public final TableField<ZtegtsRecord, String> USFMODE = createField("usfMode", org.jooq.impl.SQLDataType.CHAR(8), this, "");

    /**
     * The column <code>chrono.ztegts.pdchPrecedence</code>.
     */
    public final TableField<ZtegtsRecord, String> PDCHPRECEDENCE = createField("pdchPrecedence", org.jooq.impl.SQLDataType.CHAR(8), this, "");

    /**
     * The column <code>chrono.ztegts.Isrsv</code>.
     */
    public final TableField<ZtegtsRecord, String> ISRSV = createField("Isrsv", org.jooq.impl.SQLDataType.CHAR(8), this, "");

    /**
     * Create a <code>chrono.ztegts</code> table reference
     */
    public Ztegts() {
        this(DSL.name("ztegts"), null);
    }

    /**
     * Create an aliased <code>chrono.ztegts</code> table reference
     */
    public Ztegts(String alias) {
        this(DSL.name(alias), ZTEGTS);
    }

    /**
     * Create an aliased <code>chrono.ztegts</code> table reference
     */
    public Ztegts(Name alias) {
        this(alias, ZTEGTS);
    }

    private Ztegts(Name alias, Table<ZtegtsRecord> aliased) {
        this(alias, aliased, null);
    }

    private Ztegts(Name alias, Table<ZtegtsRecord> aliased, Field<?>[] parameters) {
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
    public UniqueKey<ZtegtsRecord> getPrimaryKey() {
        return Keys.KEY_ZTEGTS_PRIMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<ZtegtsRecord>> getKeys() {
        return Arrays.<UniqueKey<ZtegtsRecord>>asList(Keys.KEY_ZTEGTS_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Ztegts as(String alias) {
        return new Ztegts(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Ztegts as(Name alias) {
        return new Ztegts(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Ztegts rename(String name) {
        return new Ztegts(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Ztegts rename(Name name) {
        return new Ztegts(name, null);
    }
}

/*
 * This file is generated by jOOQ.
*/
package id.mit.chrono.server.model.tables;


import id.mit.chrono.server.model.Chrono;
import id.mit.chrono.server.model.Indexes;
import id.mit.chrono.server.model.Keys;
import id.mit.chrono.server.model.tables.records.HwenodebRecord;

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
public class Hwenodeb extends TableImpl<HwenodebRecord> {

    private static final long serialVersionUID = -1028420254;

    /**
     * The reference instance of <code>chrono.hwenodeb</code>
     */
    public static final Hwenodeb HWENODEB = new Hwenodeb();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<HwenodebRecord> getRecordType() {
        return HwenodebRecord.class;
    }

    /**
     * The column <code>chrono.hwenodeb.hwenodeb_id</code>.
     */
    public final TableField<HwenodebRecord, ULong> HWENODEB_ID = createField("hwenodeb_id", org.jooq.impl.SQLDataType.BIGINTUNSIGNED.nullable(false), this, "");

    /**
     * The column <code>chrono.hwenodeb.hwenodeb_crcollectortaskfiles</code>.
     */
    public final TableField<HwenodebRecord, ULong> HWENODEB_CRCOLLECTORTASKFILES = createField("hwenodeb_crcollectortaskfiles", org.jooq.impl.SQLDataType.BIGINTUNSIGNED.nullable(false), this, "");

    /**
     * The column <code>chrono.hwenodeb.hwenodeb_date</code>.
     */
    public final TableField<HwenodebRecord, UInteger> HWENODEB_DATE = createField("hwenodeb_date", org.jooq.impl.SQLDataType.INTEGERUNSIGNED.nullable(false), this, "");

    /**
     * The column <code>chrono.hwenodeb.hwenodeb_datefrom</code>.
     */
    public final TableField<HwenodebRecord, Integer> HWENODEB_DATEFROM = createField("hwenodeb_datefrom", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.hwenodeb.hwenodeb_node</code>.
     */
    public final TableField<HwenodebRecord, Integer> HWENODEB_NODE = createField("hwenodeb_node", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.hwenodeb.hwenodeb_nodephysical</code>.
     */
    public final TableField<HwenodebRecord, Integer> HWENODEB_NODEPHYSICAL = createField("hwenodeb_nodephysical", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.hwenodeb.hwenodeb_nodestatus</code>.
     */
    public final TableField<HwenodebRecord, Integer> HWENODEB_NODESTATUS = createField("hwenodeb_nodestatus", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.hwenodeb.hwenodeb_revenueclass</code>.
     */
    public final TableField<HwenodebRecord, Integer> HWENODEB_REVENUECLASS = createField("hwenodeb_revenueclass", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.hwenodeb.hwenodeb_vendor</code>.
     */
    public final TableField<HwenodebRecord, Integer> HWENODEB_VENDOR = createField("hwenodeb_vendor", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.hwenodeb.hwenodeb_namingvalid</code>.
     */
    public final TableField<HwenodebRecord, Byte> HWENODEB_NAMINGVALID = createField("hwenodeb_namingvalid", org.jooq.impl.SQLDataType.TINYINT, this, "");

    /**
     * The column <code>chrono.hwenodeb.TOTALCELL</code>.
     */
    public final TableField<HwenodebRecord, Integer> TOTALCELL = createField("TOTALCELL", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.hwenodeb.ENODEBID</code>.
     */
    public final TableField<HwenodebRecord, String> ENODEBID = createField("ENODEBID", org.jooq.impl.SQLDataType.CHAR(16), this, "");

    /**
     * The column <code>chrono.hwenodeb.ENODEBFUNCTIONNAME</code>.
     */
    public final TableField<HwenodebRecord, String> ENODEBFUNCTIONNAME = createField("ENODEBFUNCTIONNAME", org.jooq.impl.SQLDataType.CHAR(96), this, "");

    /**
     * The column <code>chrono.hwenodeb.FDN</code>.
     */
    public final TableField<HwenodebRecord, String> FDN = createField("FDN", org.jooq.impl.SQLDataType.CHAR(32), this, "");

    /**
     * The column <code>chrono.hwenodeb.MOINDEX</code>.
     */
    public final TableField<HwenodebRecord, String> MOINDEX = createField("MOINDEX", org.jooq.impl.SQLDataType.CHAR(12), this, "");

    /**
     * The column <code>chrono.hwenodeb.USERLABEL</code>.
     */
    public final TableField<HwenodebRecord, String> USERLABEL = createField("USERLABEL", org.jooq.impl.SQLDataType.CHAR(96), this, "");

    /**
     * The column <code>chrono.hwenodeb.NAME</code>.
     */
    public final TableField<HwenodebRecord, String> NAME = createField("NAME", org.jooq.impl.SQLDataType.CHAR(96), this, "");

    /**
     * The column <code>chrono.hwenodeb.NEID</code>.
     */
    public final TableField<HwenodebRecord, String> NEID = createField("NEID", org.jooq.impl.SQLDataType.CHAR(8), this, "");

    /**
     * The column <code>chrono.hwenodeb.IP</code>.
     */
    public final TableField<HwenodebRecord, String> IP = createField("IP", org.jooq.impl.SQLDataType.CHAR(32), this, "");

    /**
     * The column <code>chrono.hwenodeb.MATCHVERSION</code>.
     */
    public final TableField<HwenodebRecord, String> MATCHVERSION = createField("MATCHVERSION", org.jooq.impl.SQLDataType.CHAR(128), this, "");

    /**
     * The column <code>chrono.hwenodeb.NETYPE</code>.
     */
    public final TableField<HwenodebRecord, String> NETYPE = createField("NETYPE", org.jooq.impl.SQLDataType.CHAR(32), this, "");

    /**
     * The column <code>chrono.hwenodeb.NEVERSION</code>.
     */
    public final TableField<HwenodebRecord, String> NEVERSION = createField("NEVERSION", org.jooq.impl.SQLDataType.CHAR(32), this, "");

    /**
     * The column <code>chrono.hwenodeb.GBTSVERSION</code>.
     */
    public final TableField<HwenodebRecord, String> GBTSVERSION = createField("GBTSVERSION", org.jooq.impl.SQLDataType.CHAR(32), this, "");

    /**
     * The column <code>chrono.hwenodeb.NODEVERSION</code>.
     */
    public final TableField<HwenodebRecord, String> NODEVERSION = createField("NODEVERSION", org.jooq.impl.SQLDataType.CHAR(32), this, "");

    /**
     * The column <code>chrono.hwenodeb.ENODEBVERSION</code>.
     */
    public final TableField<HwenodebRecord, String> ENODEBVERSION = createField("ENODEBVERSION", org.jooq.impl.SQLDataType.CHAR(32), this, "");

    /**
     * The column <code>chrono.hwenodeb.TIMEZONE</code>.
     */
    public final TableField<HwenodebRecord, String> TIMEZONE = createField("TIMEZONE", org.jooq.impl.SQLDataType.CHAR(32), this, "");

    /**
     * The column <code>chrono.hwenodeb.CNOPERATORNAME</code>.
     */
    public final TableField<HwenodebRecord, String> CNOPERATORNAME = createField("CNOPERATORNAME", org.jooq.impl.SQLDataType.CHAR(32), this, "");

    /**
     * The column <code>chrono.hwenodeb.MCC</code>.
     */
    public final TableField<HwenodebRecord, String> MCC = createField("MCC", org.jooq.impl.SQLDataType.CHAR(6), this, "");

    /**
     * The column <code>chrono.hwenodeb.MNC</code>.
     */
    public final TableField<HwenodebRecord, String> MNC = createField("MNC", org.jooq.impl.SQLDataType.CHAR(6), this, "");

    /**
     * The column <code>chrono.hwenodeb.NBIOTTAFLAG</code>.
     */
    public final TableField<HwenodebRecord, String> NBIOTTAFLAG = createField("NBIOTTAFLAG", org.jooq.impl.SQLDataType.CHAR(16), this, "");

    /**
     * The column <code>chrono.hwenodeb.TAC</code>.
     */
    public final TableField<HwenodebRecord, String> TAC = createField("TAC", org.jooq.impl.SQLDataType.CHAR(8), this, "");

    /**
     * The column <code>chrono.hwenodeb.TRACKINGAREAID</code>.
     */
    public final TableField<HwenodebRecord, String> TRACKINGAREAID = createField("TRACKINGAREAID", org.jooq.impl.SQLDataType.CHAR(8), this, "");

    /**
     * The column <code>chrono.hwenodeb.GENODEBID</code>.
     */
    public final TableField<HwenodebRecord, String> GENODEBID = createField("GENODEBID", org.jooq.impl.SQLDataType.CHAR(16), this, "");

    /**
     * The column <code>chrono.hwenodeb.ADJNODEID</code>.
     */
    public final TableField<HwenodebRecord, String> ADJNODEID = createField("ADJNODEID", org.jooq.impl.SQLDataType.CHAR(16), this, "");

    /**
     * The column <code>chrono.hwenodeb.LATITUDEDEGFORMAT</code>.
     */
    public final TableField<HwenodebRecord, String> LATITUDEDEGFORMAT = createField("LATITUDEDEGFORMAT", org.jooq.impl.SQLDataType.CHAR(16), this, "");

    /**
     * The column <code>chrono.hwenodeb.LONGITUDEDEGFORMAT</code>.
     */
    public final TableField<HwenodebRecord, String> LONGITUDEDEGFORMAT = createField("LONGITUDEDEGFORMAT", org.jooq.impl.SQLDataType.CHAR(16), this, "");

    /**
     * The column <code>chrono.hwenodeb.hwenodeb_remark</code>.
     */
    public final TableField<HwenodebRecord, String> HWENODEB_REMARK = createField("hwenodeb_remark", org.jooq.impl.SQLDataType.CLOB, this, "");

    /**
     * The column <code>chrono.hwenodeb.LATITUDEGPS</code>.
     */
    public final TableField<HwenodebRecord, String> LATITUDEGPS = createField("LATITUDEGPS", org.jooq.impl.SQLDataType.CHAR(16), this, "");

    /**
     * The column <code>chrono.hwenodeb.LONGITUDEGPS</code>.
     */
    public final TableField<HwenodebRecord, String> LONGITUDEGPS = createField("LONGITUDEGPS", org.jooq.impl.SQLDataType.CHAR(16), this, "");

    /**
     * The column <code>chrono.hwenodeb.EXTPROP1</code>.
     */
    public final TableField<HwenodebRecord, Integer> EXTPROP1 = createField("EXTPROP1", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.hwenodeb.EXTPROP2</code>.
     */
    public final TableField<HwenodebRecord, String> EXTPROP2 = createField("EXTPROP2", org.jooq.impl.SQLDataType.CHAR(8), this, "");

    /**
     * Create a <code>chrono.hwenodeb</code> table reference
     */
    public Hwenodeb() {
        this(DSL.name("hwenodeb"), null);
    }

    /**
     * Create an aliased <code>chrono.hwenodeb</code> table reference
     */
    public Hwenodeb(String alias) {
        this(DSL.name(alias), HWENODEB);
    }

    /**
     * Create an aliased <code>chrono.hwenodeb</code> table reference
     */
    public Hwenodeb(Name alias) {
        this(alias, HWENODEB);
    }

    private Hwenodeb(Name alias, Table<HwenodebRecord> aliased) {
        this(alias, aliased, null);
    }

    private Hwenodeb(Name alias, Table<HwenodebRecord> aliased, Field<?>[] parameters) {
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
        return Arrays.<Index>asList(Indexes.HWENODEB_HWBTS_DATE, Indexes.HWENODEB_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<HwenodebRecord> getPrimaryKey() {
        return Keys.KEY_HWENODEB_PRIMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<HwenodebRecord>> getKeys() {
        return Arrays.<UniqueKey<HwenodebRecord>>asList(Keys.KEY_HWENODEB_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Hwenodeb as(String alias) {
        return new Hwenodeb(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Hwenodeb as(Name alias) {
        return new Hwenodeb(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Hwenodeb rename(String name) {
        return new Hwenodeb(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Hwenodeb rename(Name name) {
        return new Hwenodeb(name, null);
    }
}

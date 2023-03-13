/*
 * This file is generated by jOOQ.
*/
package id.mit.chrono.server.model.tables;


import id.mit.chrono.server.model.Chrono;
import id.mit.chrono.server.model.Indexes;
import id.mit.chrono.server.model.Keys;
import id.mit.chrono.server.model.tables.records.HwbtsRecord;

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
public class Hwbts extends TableImpl<HwbtsRecord> {

    private static final long serialVersionUID = 1195007214;

    /**
     * The reference instance of <code>chrono.hwbts</code>
     */
    public static final Hwbts HWBTS = new Hwbts();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<HwbtsRecord> getRecordType() {
        return HwbtsRecord.class;
    }

    /**
     * The column <code>chrono.hwbts.hwbts_id</code>.
     */
    public final TableField<HwbtsRecord, ULong> HWBTS_ID = createField("hwbts_id", org.jooq.impl.SQLDataType.BIGINTUNSIGNED.nullable(false), this, "");

    /**
     * The column <code>chrono.hwbts.hwbts_crcollectortaskfiles</code>.
     */
    public final TableField<HwbtsRecord, ULong> HWBTS_CRCOLLECTORTASKFILES = createField("hwbts_crcollectortaskfiles", org.jooq.impl.SQLDataType.BIGINTUNSIGNED, this, "");

    /**
     * The column <code>chrono.hwbts.hwbts_date</code>.
     */
    public final TableField<HwbtsRecord, UInteger> HWBTS_DATE = createField("hwbts_date", org.jooq.impl.SQLDataType.INTEGERUNSIGNED.nullable(false), this, "");

    /**
     * The column <code>chrono.hwbts.hwbts_datefrom</code>.
     */
    public final TableField<HwbtsRecord, Integer> HWBTS_DATEFROM = createField("hwbts_datefrom", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.hwbts.hwbts_hwbsc</code>.
     */
    public final TableField<HwbtsRecord, ULong> HWBTS_HWBSC = createField("hwbts_hwbsc", org.jooq.impl.SQLDataType.BIGINTUNSIGNED.nullable(false), this, "");

    /**
     * The column <code>chrono.hwbts.hwbts_node</code>.
     */
    public final TableField<HwbtsRecord, Integer> HWBTS_NODE = createField("hwbts_node", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.hwbts.hwbts_nodephysical</code>.
     */
    public final TableField<HwbtsRecord, Integer> HWBTS_NODEPHYSICAL = createField("hwbts_nodephysical", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.hwbts.hwbts_nodestatus</code>.
     */
    public final TableField<HwbtsRecord, Integer> HWBTS_NODESTATUS = createField("hwbts_nodestatus", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.hwbts.hwbts_revenueclass</code>.
     */
    public final TableField<HwbtsRecord, Integer> HWBTS_REVENUECLASS = createField("hwbts_revenueclass", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.hwbts.hwbts_vendor</code>.
     */
    public final TableField<HwbtsRecord, Integer> HWBTS_VENDOR = createField("hwbts_vendor", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.hwbts.hwbts_namingvalid</code>.
     */
    public final TableField<HwbtsRecord, Byte> HWBTS_NAMINGVALID = createField("hwbts_namingvalid", org.jooq.impl.SQLDataType.TINYINT, this, "");

    /**
     * The column <code>chrono.hwbts.TOTALCELL</code>.
     */
    public final TableField<HwbtsRecord, Integer> TOTALCELL = createField("TOTALCELL", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.hwbts.TOTALTRX</code>.
     */
    public final TableField<HwbtsRecord, Integer> TOTALTRX = createField("TOTALTRX", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.hwbts.BTSNAME</code>.
     */
    public final TableField<HwbtsRecord, String> BTSNAME = createField("BTSNAME", org.jooq.impl.SQLDataType.CHAR(96), this, "");

    /**
     * The column <code>chrono.hwbts.BTSID</code>.
     */
    public final TableField<HwbtsRecord, String> BTSID = createField("BTSID", org.jooq.impl.SQLDataType.CHAR(32), this, "");

    /**
     * The column <code>chrono.hwbts.FDN</code>.
     */
    public final TableField<HwbtsRecord, String> FDN = createField("FDN", org.jooq.impl.SQLDataType.CHAR(32), this, "");

    /**
     * The column <code>chrono.hwbts.ACTSTATUS</code>.
     */
    public final TableField<HwbtsRecord, String> ACTSTATUS = createField("ACTSTATUS", org.jooq.impl.SQLDataType.CHAR(32), this, "");

    /**
     * The column <code>chrono.hwbts.BTSDESC</code>.
     */
    public final TableField<HwbtsRecord, String> BTSDESC = createField("BTSDESC", org.jooq.impl.SQLDataType.CHAR(96), this, "");

    /**
     * The column <code>chrono.hwbts.BTSTYPE</code>.
     */
    public final TableField<HwbtsRecord, String> BTSTYPE = createField("BTSTYPE", org.jooq.impl.SQLDataType.CHAR(32), this, "");

    /**
     * The column <code>chrono.hwbts.MOINDEX</code>.
     */
    public final TableField<HwbtsRecord, String> MOINDEX = createField("MOINDEX", org.jooq.impl.SQLDataType.CHAR(32), this, "");

    /**
     * The column <code>chrono.hwbts.SERVICEMODE</code>.
     */
    public final TableField<HwbtsRecord, String> SERVICEMODE = createField("SERVICEMODE", org.jooq.impl.SQLDataType.CHAR(32), this, "");

    /**
     * The column <code>chrono.hwbts.MPMODE</code>.
     */
    public final TableField<HwbtsRecord, String> MPMODE = createField("MPMODE", org.jooq.impl.SQLDataType.CHAR(32), this, "");

    /**
     * The column <code>chrono.hwbts.SRANMODE</code>.
     */
    public final TableField<HwbtsRecord, String> SRANMODE = createField("SRANMODE", org.jooq.impl.SQLDataType.CHAR(32), this, "");

    /**
     * The column <code>chrono.hwbts.NEID</code>.
     */
    public final TableField<HwbtsRecord, String> NEID = createField("NEID", org.jooq.impl.SQLDataType.CHAR(8), this, "");

    /**
     * The column <code>chrono.hwbts.FLEXABISMODE</code>.
     */
    public final TableField<HwbtsRecord, String> FLEXABISMODE = createField("FLEXABISMODE", org.jooq.impl.SQLDataType.CHAR(32), this, "");

    /**
     * The column <code>chrono.hwbts.IPPHYTRANSTYPE</code>.
     */
    public final TableField<HwbtsRecord, String> IPPHYTRANSTYPE = createField("IPPHYTRANSTYPE", org.jooq.impl.SQLDataType.CHAR(32), this, "");

    /**
     * The column <code>chrono.hwbts.LATITUDEDEGFORMAT</code>.
     */
    public final TableField<HwbtsRecord, String> LATITUDEDEGFORMAT = createField("LATITUDEDEGFORMAT", org.jooq.impl.SQLDataType.CHAR(16), this, "");

    /**
     * The column <code>chrono.hwbts.LONGITUDEDEGFORMAT</code>.
     */
    public final TableField<HwbtsRecord, String> LONGITUDEDEGFORMAT = createField("LONGITUDEDEGFORMAT", org.jooq.impl.SQLDataType.CHAR(16), this, "");

    /**
     * The column <code>chrono.hwbts.hwbts_remark</code>.
     */
    public final TableField<HwbtsRecord, String> HWBTS_REMARK = createField("hwbts_remark", org.jooq.impl.SQLDataType.CLOB, this, "");

    /**
     * The column <code>chrono.hwbts.ANI</code>.
     */
    public final TableField<HwbtsRecord, String> ANI = createField("ANI", org.jooq.impl.SQLDataType.CHAR(8), this, "");

    /**
     * The column <code>chrono.hwbts.EXTPROP1</code>.
     */
    public final TableField<HwbtsRecord, Integer> EXTPROP1 = createField("EXTPROP1", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.hwbts.EXTPROP2</code>.
     */
    public final TableField<HwbtsRecord, Integer> EXTPROP2 = createField("EXTPROP2", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * Create a <code>chrono.hwbts</code> table reference
     */
    public Hwbts() {
        this(DSL.name("hwbts"), null);
    }

    /**
     * Create an aliased <code>chrono.hwbts</code> table reference
     */
    public Hwbts(String alias) {
        this(DSL.name(alias), HWBTS);
    }

    /**
     * Create an aliased <code>chrono.hwbts</code> table reference
     */
    public Hwbts(Name alias) {
        this(alias, HWBTS);
    }

    private Hwbts(Name alias, Table<HwbtsRecord> aliased) {
        this(alias, aliased, null);
    }

    private Hwbts(Name alias, Table<HwbtsRecord> aliased, Field<?>[] parameters) {
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
        return Arrays.<Index>asList(Indexes.HWBTS_HWBTS_DATE, Indexes.HWBTS_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<HwbtsRecord> getPrimaryKey() {
        return Keys.KEY_HWBTS_PRIMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<HwbtsRecord>> getKeys() {
        return Arrays.<UniqueKey<HwbtsRecord>>asList(Keys.KEY_HWBTS_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Hwbts as(String alias) {
        return new Hwbts(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Hwbts as(Name alias) {
        return new Hwbts(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Hwbts rename(String name) {
        return new Hwbts(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Hwbts rename(Name name) {
        return new Hwbts(name, null);
    }
}
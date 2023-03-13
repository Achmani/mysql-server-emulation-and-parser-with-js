/*
 * This file is generated by jOOQ.
*/
package id.mit.chrono.server.model.tables;


import id.mit.chrono.server.model.Chrono;
import id.mit.chrono.server.model.Indexes;
import id.mit.chrono.server.model.Keys;
import id.mit.chrono.server.model.tables.records.ZteenodebRecord;

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
public class Zteenodeb extends TableImpl<ZteenodebRecord> {

    private static final long serialVersionUID = -1712055192;

    /**
     * The reference instance of <code>chrono.zteenodeb</code>
     */
    public static final Zteenodeb ZTEENODEB = new Zteenodeb();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<ZteenodebRecord> getRecordType() {
        return ZteenodebRecord.class;
    }

    /**
     * The column <code>chrono.zteenodeb.zteenodeb_id</code>.
     */
    public final TableField<ZteenodebRecord, ULong> ZTEENODEB_ID = createField("zteenodeb_id", org.jooq.impl.SQLDataType.BIGINTUNSIGNED.nullable(false), this, "");

    /**
     * The column <code>chrono.zteenodeb.zteenodeb_crcollectortaskfiles</code>.
     */
    public final TableField<ZteenodebRecord, ULong> ZTEENODEB_CRCOLLECTORTASKFILES = createField("zteenodeb_crcollectortaskfiles", org.jooq.impl.SQLDataType.BIGINTUNSIGNED, this, "");

    /**
     * The column <code>chrono.zteenodeb.zteenodeb_date</code>.
     */
    public final TableField<ZteenodebRecord, UInteger> ZTEENODEB_DATE = createField("zteenodeb_date", org.jooq.impl.SQLDataType.INTEGERUNSIGNED.nullable(false), this, "");

    /**
     * The column <code>chrono.zteenodeb.zteenodeb_datefrom</code>.
     */
    public final TableField<ZteenodebRecord, UInteger> ZTEENODEB_DATEFROM = createField("zteenodeb_datefrom", org.jooq.impl.SQLDataType.INTEGERUNSIGNED, this, "");

    /**
     * The column <code>chrono.zteenodeb.zteenodeb_node</code>.
     */
    public final TableField<ZteenodebRecord, Integer> ZTEENODEB_NODE = createField("zteenodeb_node", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.zteenodeb.zteenodeb_nodephysical</code>.
     */
    public final TableField<ZteenodebRecord, Integer> ZTEENODEB_NODEPHYSICAL = createField("zteenodeb_nodephysical", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.zteenodeb.zteenodeb_nodestatus</code>.
     */
    public final TableField<ZteenodebRecord, Integer> ZTEENODEB_NODESTATUS = createField("zteenodeb_nodestatus", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.zteenodeb.zteenodeb_revenueclass</code>.
     */
    public final TableField<ZteenodebRecord, Integer> ZTEENODEB_REVENUECLASS = createField("zteenodeb_revenueclass", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.zteenodeb.zteenodeb_vendor</code>.
     */
    public final TableField<ZteenodebRecord, Integer> ZTEENODEB_VENDOR = createField("zteenodeb_vendor", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.zteenodeb.zteenodeb_namingvalid</code>.
     */
    public final TableField<ZteenodebRecord, Byte> ZTEENODEB_NAMINGVALID = createField("zteenodeb_namingvalid", org.jooq.impl.SQLDataType.TINYINT, this, "");

    /**
     * The column <code>chrono.zteenodeb.TOTALCELL</code>.
     */
    public final TableField<ZteenodebRecord, Integer> TOTALCELL = createField("TOTALCELL", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.zteenodeb.ENODEBFUNCTIONNAME</code>.
     */
    public final TableField<ZteenodebRecord, String> ENODEBFUNCTIONNAME = createField("ENODEBFUNCTIONNAME", org.jooq.impl.SQLDataType.CHAR(96), this, "");

    /**
     * The column <code>chrono.zteenodeb.MOI</code>.
     */
    public final TableField<ZteenodebRecord, String> MOI = createField("MOI", org.jooq.impl.SQLDataType.CHAR(64), this, "");

    /**
     * The column <code>chrono.zteenodeb.SubNetwork</code>.
     */
    public final TableField<ZteenodebRecord, String> SUBNETWORK = createField("SubNetwork", org.jooq.impl.SQLDataType.CHAR(6), this, "");

    /**
     * The column <code>chrono.zteenodeb.MEID</code>.
     */
    public final TableField<ZteenodebRecord, String> MEID = createField("MEID", org.jooq.impl.SQLDataType.CHAR(12), this, "");

    /**
     * The column <code>chrono.zteenodeb.swVersion</code>.
     */
    public final TableField<ZteenodebRecord, String> SWVERSION = createField("swVersion", org.jooq.impl.SQLDataType.CHAR(48), this, "");

    /**
     * The column <code>chrono.zteenodeb.userLabel</code>.
     */
    public final TableField<ZteenodebRecord, String> USERLABEL = createField("userLabel", org.jooq.impl.SQLDataType.CHAR(96), this, "");

    /**
     * The column <code>chrono.zteenodeb.description</code>.
     */
    public final TableField<ZteenodebRecord, String> DESCRIPTION = createField("description", org.jooq.impl.SQLDataType.CHAR(64), this, "");

    /**
     * The column <code>chrono.zteenodeb.locationName</code>.
     */
    public final TableField<ZteenodebRecord, String> LOCATIONNAME = createField("locationName", org.jooq.impl.SQLDataType.CLOB, this, "");

    /**
     * The column <code>chrono.zteenodeb.autoGetGeographicPos</code>.
     */
    public final TableField<ZteenodebRecord, String> AUTOGETGEOGRAPHICPOS = createField("autoGetGeographicPos", org.jooq.impl.SQLDataType.CHAR(4), this, "");

    /**
     * The column <code>chrono.zteenodeb.longitude</code>.
     */
    public final TableField<ZteenodebRecord, String> LONGITUDE = createField("longitude", org.jooq.impl.SQLDataType.CHAR(16), this, "");

    /**
     * The column <code>chrono.zteenodeb.latitude</code>.
     */
    public final TableField<ZteenodebRecord, String> LATITUDE = createField("latitude", org.jooq.impl.SQLDataType.CHAR(16), this, "");

    /**
     * The column <code>chrono.zteenodeb.productData_productNumber</code>.
     */
    public final TableField<ZteenodebRecord, String> PRODUCTDATA_PRODUCTNUMBER = createField("productData_productNumber", org.jooq.impl.SQLDataType.CHAR(8), this, "");

    /**
     * The column <code>chrono.zteenodeb.productData_productName</code>.
     */
    public final TableField<ZteenodebRecord, String> PRODUCTDATA_PRODUCTNAME = createField("productData_productName", org.jooq.impl.SQLDataType.CHAR(16), this, "");

    /**
     * The column <code>chrono.zteenodeb.RADIOMODE</code>.
     */
    public final TableField<ZteenodebRecord, String> RADIOMODE = createField("RADIOMODE", org.jooq.impl.SQLDataType.CHAR(4), this, "");

    /**
     * The column <code>chrono.zteenodeb.ENBFunctionID</code>.
     */
    public final TableField<ZteenodebRecord, String> ENBFUNCTIONID = createField("ENBFunctionID", org.jooq.impl.SQLDataType.CHAR(12), this, "");

    /**
     * The column <code>chrono.zteenodeb.eNBId</code>.
     */
    public final TableField<ZteenodebRecord, String> ENBID = createField("eNBId", org.jooq.impl.SQLDataType.CHAR(12), this, "");

    /**
     * The column <code>chrono.zteenodeb.enbName</code>.
     */
    public final TableField<ZteenodebRecord, String> ENBNAME = createField("enbName", org.jooq.impl.SQLDataType.CHAR(96), this, "");

    /**
     * The column <code>chrono.zteenodeb.refPlmn</code>.
     */
    public final TableField<ZteenodebRecord, String> REFPLMN = createField("refPlmn", org.jooq.impl.SQLDataType.CHAR(96), this, "");

    /**
     * The column <code>chrono.zteenodeb.mcc</code>.
     */
    public final TableField<ZteenodebRecord, String> MCC = createField("mcc", org.jooq.impl.SQLDataType.CHAR(4), this, "");

    /**
     * The column <code>chrono.zteenodeb.mnc</code>.
     */
    public final TableField<ZteenodebRecord, String> MNC = createField("mnc", org.jooq.impl.SQLDataType.CHAR(4), this, "");

    /**
     * The column <code>chrono.zteenodeb.tac</code>.
     */
    public final TableField<ZteenodebRecord, Integer> TAC = createField("tac", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.zteenodeb.zteenodeb_remark</code>.
     */
    public final TableField<ZteenodebRecord, String> ZTEENODEB_REMARK = createField("zteenodeb_remark", org.jooq.impl.SQLDataType.CLOB, this, "");

    /**
     * The column <code>chrono.zteenodeb.EXTPROP1</code>.
     */
    public final TableField<ZteenodebRecord, Integer> EXTPROP1 = createField("EXTPROP1", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.zteenodeb.EXTPROP2</code>.
     */
    public final TableField<ZteenodebRecord, String> EXTPROP2 = createField("EXTPROP2", org.jooq.impl.SQLDataType.CHAR(8), this, "");

    /**
     * Create a <code>chrono.zteenodeb</code> table reference
     */
    public Zteenodeb() {
        this(DSL.name("zteenodeb"), null);
    }

    /**
     * Create an aliased <code>chrono.zteenodeb</code> table reference
     */
    public Zteenodeb(String alias) {
        this(DSL.name(alias), ZTEENODEB);
    }

    /**
     * Create an aliased <code>chrono.zteenodeb</code> table reference
     */
    public Zteenodeb(Name alias) {
        this(alias, ZTEENODEB);
    }

    private Zteenodeb(Name alias, Table<ZteenodebRecord> aliased) {
        this(alias, aliased, null);
    }

    private Zteenodeb(Name alias, Table<ZteenodebRecord> aliased, Field<?>[] parameters) {
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
        return Arrays.<Index>asList(Indexes.ZTEENODEB_PRIMARY, Indexes.ZTEENODEB_ZTEBTS_DATE, Indexes.ZTEENODEB_ZTEBTS_DATE_2);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<ZteenodebRecord> getPrimaryKey() {
        return Keys.KEY_ZTEENODEB_PRIMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<ZteenodebRecord>> getKeys() {
        return Arrays.<UniqueKey<ZteenodebRecord>>asList(Keys.KEY_ZTEENODEB_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Zteenodeb as(String alias) {
        return new Zteenodeb(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Zteenodeb as(Name alias) {
        return new Zteenodeb(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Zteenodeb rename(String name) {
        return new Zteenodeb(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Zteenodeb rename(Name name) {
        return new Zteenodeb(name, null);
    }
}

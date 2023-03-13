/*
 * This file is generated by jOOQ.
*/
package id.mit.chrono.server.model.tables;


import id.mit.chrono.server.model.Chrono;
import id.mit.chrono.server.model.Indexes;
import id.mit.chrono.server.model.Keys;
import id.mit.chrono.server.model.tables.records.NokenodebRecord;

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
public class Nokenodeb extends TableImpl<NokenodebRecord> {

    private static final long serialVersionUID = 1098038450;

    /**
     * The reference instance of <code>chrono.nokenodeb</code>
     */
    public static final Nokenodeb NOKENODEB = new Nokenodeb();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<NokenodebRecord> getRecordType() {
        return NokenodebRecord.class;
    }

    /**
     * The column <code>chrono.nokenodeb.nokenodeb_id</code>.
     */
    public final TableField<NokenodebRecord, ULong> NOKENODEB_ID = createField("nokenodeb_id", org.jooq.impl.SQLDataType.BIGINTUNSIGNED.nullable(false), this, "");

    /**
     * The column <code>chrono.nokenodeb.nokenodeb_crcollectortaskfiles</code>.
     */
    public final TableField<NokenodebRecord, ULong> NOKENODEB_CRCOLLECTORTASKFILES = createField("nokenodeb_crcollectortaskfiles", org.jooq.impl.SQLDataType.BIGINTUNSIGNED, this, "");

    /**
     * The column <code>chrono.nokenodeb.nokenodeb_date</code>.
     */
    public final TableField<NokenodebRecord, UInteger> NOKENODEB_DATE = createField("nokenodeb_date", org.jooq.impl.SQLDataType.INTEGERUNSIGNED.nullable(false), this, "");

    /**
     * The column <code>chrono.nokenodeb.nokenodeb_datefrom</code>.
     */
    public final TableField<NokenodebRecord, UInteger> NOKENODEB_DATEFROM = createField("nokenodeb_datefrom", org.jooq.impl.SQLDataType.INTEGERUNSIGNED, this, "");

    /**
     * The column <code>chrono.nokenodeb.nokenodeb_node</code>.
     */
    public final TableField<NokenodebRecord, Integer> NOKENODEB_NODE = createField("nokenodeb_node", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.nokenodeb.nokenodeb_nodephysical</code>.
     */
    public final TableField<NokenodebRecord, Integer> NOKENODEB_NODEPHYSICAL = createField("nokenodeb_nodephysical", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.nokenodeb.nokenodeb_nodestatus</code>.
     */
    public final TableField<NokenodebRecord, Integer> NOKENODEB_NODESTATUS = createField("nokenodeb_nodestatus", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.nokenodeb.nokenodeb_revenueclass</code>.
     */
    public final TableField<NokenodebRecord, Integer> NOKENODEB_REVENUECLASS = createField("nokenodeb_revenueclass", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.nokenodeb.nokenodeb_vendor</code>.
     */
    public final TableField<NokenodebRecord, Integer> NOKENODEB_VENDOR = createField("nokenodeb_vendor", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.nokenodeb.nokenodeb_namingvalid</code>.
     */
    public final TableField<NokenodebRecord, Byte> NOKENODEB_NAMINGVALID = createField("nokenodeb_namingvalid", org.jooq.impl.SQLDataType.TINYINT, this, "");

    /**
     * The column <code>chrono.nokenodeb.TOTALCELL</code>.
     */
    public final TableField<NokenodebRecord, Integer> TOTALCELL = createField("TOTALCELL", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.nokenodeb.ENODEBFUNCTIONNAME</code>.
     */
    public final TableField<NokenodebRecord, String> ENODEBFUNCTIONNAME = createField("ENODEBFUNCTIONNAME", org.jooq.impl.SQLDataType.CHAR(96), this, "");

    /**
     * The column <code>chrono.nokenodeb.distName</code>.
     */
    public final TableField<NokenodebRecord, String> DISTNAME = createField("distName", org.jooq.impl.SQLDataType.CHAR(96), this, "");

    /**
     * The column <code>chrono.nokenodeb.distName2</code>.
     */
    public final TableField<NokenodebRecord, String> DISTNAME2 = createField("distName2", org.jooq.impl.SQLDataType.CHAR(96), this, "");

    /**
     * The column <code>chrono.nokenodeb.version</code>.
     */
    public final TableField<NokenodebRecord, String> VERSION = createField("version", org.jooq.impl.SQLDataType.CHAR(32), this, "");

    /**
     * The column <code>chrono.nokenodeb.mcc</code>.
     */
    public final TableField<NokenodebRecord, String> MCC = createField("mcc", org.jooq.impl.SQLDataType.CHAR(6), this, "");

    /**
     * The column <code>chrono.nokenodeb.mnc</code>.
     */
    public final TableField<NokenodebRecord, String> MNC = createField("mnc", org.jooq.impl.SQLDataType.CHAR(6), this, "");

    /**
     * The column <code>chrono.nokenodeb.eNodeBId</code>.
     */
    public final TableField<NokenodebRecord, String> ENODEBID = createField("eNodeBId", org.jooq.impl.SQLDataType.CHAR(8), this, "");

    /**
     * The column <code>chrono.nokenodeb.caMinDlAmbr</code>.
     */
    public final TableField<NokenodebRecord, String> CAMINDLAMBR = createField("caMinDlAmbr", org.jooq.impl.SQLDataType.CHAR(8), this, "");

    /**
     * The column <code>chrono.nokenodeb.caMinUlAmbr</code>.
     */
    public final TableField<NokenodebRecord, String> CAMINULAMBR = createField("caMinUlAmbr", org.jooq.impl.SQLDataType.CHAR(8), this, "");

    /**
     * The column <code>chrono.nokenodeb.enbName</code>.
     */
    public final TableField<NokenodebRecord, String> ENBNAME = createField("enbName", org.jooq.impl.SQLDataType.CHAR(96), this, "");

    /**
     * The column <code>chrono.nokenodeb.keyRefrMarg</code>.
     */
    public final TableField<NokenodebRecord, String> KEYREFRMARG = createField("keyRefrMarg", org.jooq.impl.SQLDataType.CHAR(8), this, "");

    /**
     * The column <code>chrono.nokenodeb.maxNumAnrMoiAllowed</code>.
     */
    public final TableField<NokenodebRecord, String> MAXNUMANRMOIALLOWED = createField("maxNumAnrMoiAllowed", org.jooq.impl.SQLDataType.CHAR(8), this, "");

    /**
     * The column <code>chrono.nokenodeb.maxNumOfLnadjLimit</code>.
     */
    public final TableField<NokenodebRecord, String> MAXNUMOFLNADJLIMIT = createField("maxNumOfLnadjLimit", org.jooq.impl.SQLDataType.CHAR(8), this, "");

    /**
     * The column <code>chrono.nokenodeb.maxNumPreEmptions</code>.
     */
    public final TableField<NokenodebRecord, String> MAXNUMPREEMPTIONS = createField("maxNumPreEmptions", org.jooq.impl.SQLDataType.CHAR(8), this, "");

    /**
     * The column <code>chrono.nokenodeb.supportedNumOfAnrMoi</code>.
     */
    public final TableField<NokenodebRecord, String> SUPPORTEDNUMOFANRMOI = createField("supportedNumOfAnrMoi", org.jooq.impl.SQLDataType.CHAR(8), this, "");

    /**
     * The column <code>chrono.nokenodeb.supportedNumOfLnadj</code>.
     */
    public final TableField<NokenodebRecord, String> SUPPORTEDNUMOFLNADJ = createField("supportedNumOfLnadj", org.jooq.impl.SQLDataType.CHAR(8), this, "");

    /**
     * The column <code>chrono.nokenodeb.nokenodeb_remark</code>.
     */
    public final TableField<NokenodebRecord, String> NOKENODEB_REMARK = createField("nokenodeb_remark", org.jooq.impl.SQLDataType.CLOB, this, "");

    /**
     * The column <code>chrono.nokenodeb.latitude</code>.
     */
    public final TableField<NokenodebRecord, String> LATITUDE = createField("latitude", org.jooq.impl.SQLDataType.CHAR(16), this, "");

    /**
     * The column <code>chrono.nokenodeb.longitude</code>.
     */
    public final TableField<NokenodebRecord, String> LONGITUDE = createField("longitude", org.jooq.impl.SQLDataType.CHAR(16), this, "");

    /**
     * The column <code>chrono.nokenodeb.EXTPROP1</code>.
     */
    public final TableField<NokenodebRecord, Integer> EXTPROP1 = createField("EXTPROP1", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.nokenodeb.EXTPROP2</code>.
     */
    public final TableField<NokenodebRecord, String> EXTPROP2 = createField("EXTPROP2", org.jooq.impl.SQLDataType.CHAR(8), this, "");

    /**
     * Create a <code>chrono.nokenodeb</code> table reference
     */
    public Nokenodeb() {
        this(DSL.name("nokenodeb"), null);
    }

    /**
     * Create an aliased <code>chrono.nokenodeb</code> table reference
     */
    public Nokenodeb(String alias) {
        this(DSL.name(alias), NOKENODEB);
    }

    /**
     * Create an aliased <code>chrono.nokenodeb</code> table reference
     */
    public Nokenodeb(Name alias) {
        this(alias, NOKENODEB);
    }

    private Nokenodeb(Name alias, Table<NokenodebRecord> aliased) {
        this(alias, aliased, null);
    }

    private Nokenodeb(Name alias, Table<NokenodebRecord> aliased, Field<?>[] parameters) {
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
        return Arrays.<Index>asList(Indexes.NOKENODEB_NOKENODEB_DATE, Indexes.NOKENODEB_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<NokenodebRecord> getPrimaryKey() {
        return Keys.KEY_NOKENODEB_PRIMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<NokenodebRecord>> getKeys() {
        return Arrays.<UniqueKey<NokenodebRecord>>asList(Keys.KEY_NOKENODEB_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Nokenodeb as(String alias) {
        return new Nokenodeb(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Nokenodeb as(Name alias) {
        return new Nokenodeb(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Nokenodeb rename(String name) {
        return new Nokenodeb(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Nokenodeb rename(Name name) {
        return new Nokenodeb(name, null);
    }
}

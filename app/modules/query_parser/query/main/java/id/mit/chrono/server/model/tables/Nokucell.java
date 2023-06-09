/*
 * This file is generated by jOOQ.
*/
package id.mit.chrono.server.model.tables;


import id.mit.chrono.server.model.Chrono;
import id.mit.chrono.server.model.Indexes;
import id.mit.chrono.server.model.Keys;
import id.mit.chrono.server.model.tables.records.NokucellRecord;

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
public class Nokucell extends TableImpl<NokucellRecord> {

    private static final long serialVersionUID = -491136630;

    /**
     * The reference instance of <code>chrono.nokucell</code>
     */
    public static final Nokucell NOKUCELL = new Nokucell();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<NokucellRecord> getRecordType() {
        return NokucellRecord.class;
    }

    /**
     * The column <code>chrono.nokucell.nokucell_id</code>.
     */
    public final TableField<NokucellRecord, ULong> NOKUCELL_ID = createField("nokucell_id", org.jooq.impl.SQLDataType.BIGINTUNSIGNED.nullable(false), this, "");

    /**
     * The column <code>chrono.nokucell.nokucell_crcollectortaskfiles</code>.
     */
    public final TableField<NokucellRecord, ULong> NOKUCELL_CRCOLLECTORTASKFILES = createField("nokucell_crcollectortaskfiles", org.jooq.impl.SQLDataType.BIGINTUNSIGNED, this, "");

    /**
     * The column <code>chrono.nokucell.nokucell_date</code>.
     */
    public final TableField<NokucellRecord, UInteger> NOKUCELL_DATE = createField("nokucell_date", org.jooq.impl.SQLDataType.INTEGERUNSIGNED.nullable(false), this, "");

    /**
     * The column <code>chrono.nokucell.nokucell_datefrom</code>.
     */
    public final TableField<NokucellRecord, UInteger> NOKUCELL_DATEFROM = createField("nokucell_datefrom", org.jooq.impl.SQLDataType.INTEGERUNSIGNED, this, "");

    /**
     * The column <code>chrono.nokucell.nokucell_nokrnc</code>.
     */
    public final TableField<NokucellRecord, ULong> NOKUCELL_NOKRNC = createField("nokucell_nokrnc", org.jooq.impl.SQLDataType.BIGINTUNSIGNED, this, "");

    /**
     * The column <code>chrono.nokucell.nokucell_noknodeb</code>.
     */
    public final TableField<NokucellRecord, ULong> NOKUCELL_NOKNODEB = createField("nokucell_noknodeb", org.jooq.impl.SQLDataType.BIGINTUNSIGNED, this, "");

    /**
     * The column <code>chrono.nokucell.nokucell_nodealias</code>.
     */
    public final TableField<NokucellRecord, Integer> NOKUCELL_NODEALIAS = createField("nokucell_nodealias", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.nokucell.nokucell_cell</code>.
     */
    public final TableField<NokucellRecord, Integer> NOKUCELL_CELL = createField("nokucell_cell", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.nokucell.nokucell_cellclass</code>.
     */
    public final TableField<NokucellRecord, Integer> NOKUCELL_CELLCLASS = createField("nokucell_cellclass", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.nokucell.nokucell_cellclassgroup</code>.
     */
    public final TableField<NokucellRecord, Integer> NOKUCELL_CELLCLASSGROUP = createField("nokucell_cellclassgroup", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.nokucell.nokucell_cellcoverage</code>.
     */
    public final TableField<NokucellRecord, Integer> NOKUCELL_CELLCOVERAGE = createField("nokucell_cellcoverage", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.nokucell.nokucell_revenueclass</code>.
     */
    public final TableField<NokucellRecord, Integer> NOKUCELL_REVENUECLASS = createField("nokucell_revenueclass", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.nokucell.nokucell_cellstatus</code>.
     */
    public final TableField<NokucellRecord, Integer> NOKUCELL_CELLSTATUS = createField("nokucell_cellstatus", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.nokucell.nokucell_vendor</code>.
     */
    public final TableField<NokucellRecord, Integer> NOKUCELL_VENDOR = createField("nokucell_vendor", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.nokucell.nokucell_latitude</code>.
     */
    public final TableField<NokucellRecord, Double> NOKUCELL_LATITUDE = createField("nokucell_latitude", org.jooq.impl.SQLDataType.DOUBLE, this, "");

    /**
     * The column <code>chrono.nokucell.nokucell_longitude</code>.
     */
    public final TableField<NokucellRecord, Double> NOKUCELL_LONGITUDE = createField("nokucell_longitude", org.jooq.impl.SQLDataType.DOUBLE, this, "");

    /**
     * The column <code>chrono.nokucell.nokucell_namingvalid</code>.
     */
    public final TableField<NokucellRecord, Byte> NOKUCELL_NAMINGVALID = createField("nokucell_namingvalid", org.jooq.impl.SQLDataType.TINYINT, this, "");

    /**
     * The column <code>chrono.nokucell.distName</code>.
     */
    public final TableField<NokucellRecord, String> DISTNAME = createField("distName", org.jooq.impl.SQLDataType.CHAR(96), this, "");

    /**
     * The column <code>chrono.nokucell.WCELMCC</code>.
     */
    public final TableField<NokucellRecord, String> WCELMCC = createField("WCELMCC", org.jooq.impl.SQLDataType.CHAR(8), this, "");

    /**
     * The column <code>chrono.nokucell.WCELMNC</code>.
     */
    public final TableField<NokucellRecord, String> WCELMNC = createField("WCELMNC", org.jooq.impl.SQLDataType.CHAR(8), this, "");

    /**
     * The column <code>chrono.nokucell.name</code>.
     */
    public final TableField<NokucellRecord, String> NAME = createField("name", org.jooq.impl.SQLDataType.CHAR(96), this, "");

    /**
     * The column <code>chrono.nokucell.AdminCellState</code>.
     */
    public final TableField<NokucellRecord, String> ADMINCELLSTATE = createField("AdminCellState", org.jooq.impl.SQLDataType.CHAR(8), this, "");

    /**
     * The column <code>chrono.nokucell.AdminPICState</code>.
     */
    public final TableField<NokucellRecord, String> ADMINPICSTATE = createField("AdminPICState", org.jooq.impl.SQLDataType.CHAR(8), this, "");

    /**
     * The column <code>chrono.nokucell.CId</code>.
     */
    public final TableField<NokucellRecord, String> CID = createField("CId", org.jooq.impl.SQLDataType.CHAR(8), this, "");

    /**
     * The column <code>chrono.nokucell.CellRange</code>.
     */
    public final TableField<NokucellRecord, String> CELLRANGE = createField("CellRange", org.jooq.impl.SQLDataType.CHAR(8), this, "");

    /**
     * The column <code>chrono.nokucell.DCellHSDPACapaHO</code>.
     */
    public final TableField<NokucellRecord, String> DCELLHSDPACAPAHO = createField("DCellHSDPACapaHO", org.jooq.impl.SQLDataType.CHAR(8), this, "");

    /**
     * The column <code>chrono.nokucell.DCellHSDPAEnabled</code>.
     */
    public final TableField<NokucellRecord, String> DCELLHSDPAENABLED = createField("DCellHSDPAEnabled", org.jooq.impl.SQLDataType.CHAR(8), this, "");

    /**
     * The column <code>chrono.nokucell.DCellHSDPAFmcsId</code>.
     */
    public final TableField<NokucellRecord, String> DCELLHSDPAFMCSID = createField("DCellHSDPAFmcsId", org.jooq.impl.SQLDataType.CHAR(8), this, "");

    /**
     * The column <code>chrono.nokucell.DCellHSUPAEnabled</code>.
     */
    public final TableField<NokucellRecord, String> DCELLHSUPAENABLED = createField("DCellHSUPAEnabled", org.jooq.impl.SQLDataType.CHAR(8), this, "");

    /**
     * The column <code>chrono.nokucell.FDPCHEnabled</code>.
     */
    public final TableField<NokucellRecord, String> FDPCHENABLED = createField("FDPCHEnabled", org.jooq.impl.SQLDataType.CHAR(8), this, "");

    /**
     * The column <code>chrono.nokucell.HSUPAEnabled</code>.
     */
    public final TableField<NokucellRecord, String> HSUPAENABLED = createField("HSUPAEnabled", org.jooq.impl.SQLDataType.CHAR(8), this, "");

    /**
     * The column <code>chrono.nokucell.LAC</code>.
     */
    public final TableField<NokucellRecord, String> LAC = createField("LAC", org.jooq.impl.SQLDataType.CHAR(8), this, "");

    /**
     * The column <code>chrono.nokucell.PriScrCode</code>.
     */
    public final TableField<NokucellRecord, String> PRISCRCODE = createField("PriScrCode", org.jooq.impl.SQLDataType.CHAR(8), this, "");

    /**
     * The column <code>chrono.nokucell.RAC</code>.
     */
    public final TableField<NokucellRecord, String> RAC = createField("RAC", org.jooq.impl.SQLDataType.CHAR(8), this, "");

    /**
     * The column <code>chrono.nokucell.CGI</code>.
     */
    public final TableField<NokucellRecord, String> CGI = createField("CGI", org.jooq.impl.SQLDataType.CHAR(24), this, "");

    /**
     * The column <code>chrono.nokucell.SAC</code>.
     */
    public final TableField<NokucellRecord, String> SAC = createField("SAC", org.jooq.impl.SQLDataType.CHAR(8), this, "");

    /**
     * The column <code>chrono.nokucell.UARFCN</code>.
     */
    public final TableField<NokucellRecord, Double> UARFCN = createField("UARFCN", org.jooq.impl.SQLDataType.DOUBLE, this, "");

    /**
     * The column <code>chrono.nokucell.WCelState</code>.
     */
    public final TableField<NokucellRecord, String> WCELSTATE = createField("WCelState", org.jooq.impl.SQLDataType.CHAR(8), this, "");

    /**
     * The column <code>chrono.nokucell.rncId</code>.
     */
    public final TableField<NokucellRecord, String> RNCID = createField("rncId", org.jooq.impl.SQLDataType.CHAR(8), this, "");

    /**
     * The column <code>chrono.nokucell.LATITUDE</code>.
     */
    public final TableField<NokucellRecord, String> LATITUDE = createField("LATITUDE", org.jooq.impl.SQLDataType.CHAR(16), this, "");

    /**
     * The column <code>chrono.nokucell.LONGITUDE</code>.
     */
    public final TableField<NokucellRecord, String> LONGITUDE = createField("LONGITUDE", org.jooq.impl.SQLDataType.CHAR(16), this, "");

    /**
     * The column <code>chrono.nokucell.nokucell_remark</code>.
     */
    public final TableField<NokucellRecord, String> NOKUCELL_REMARK = createField("nokucell_remark", org.jooq.impl.SQLDataType.CLOB, this, "");

    /**
     * The column <code>chrono.nokucell.MaxDLPowerCapability</code>.
     */
    public final TableField<NokucellRecord, String> MAXDLPOWERCAPABILITY = createField("MaxDLPowerCapability", org.jooq.impl.SQLDataType.CHAR(8), this, "");

    /**
     * The column <code>chrono.nokucell.EXTPROP1</code>.
     */
    public final TableField<NokucellRecord, Integer> EXTPROP1 = createField("EXTPROP1", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.nokucell.EXTPROP2</code>.
     */
    public final TableField<NokucellRecord, String> EXTPROP2 = createField("EXTPROP2", org.jooq.impl.SQLDataType.CHAR(8), this, "");

    /**
     * Create a <code>chrono.nokucell</code> table reference
     */
    public Nokucell() {
        this(DSL.name("nokucell"), null);
    }

    /**
     * Create an aliased <code>chrono.nokucell</code> table reference
     */
    public Nokucell(String alias) {
        this(DSL.name(alias), NOKUCELL);
    }

    /**
     * Create an aliased <code>chrono.nokucell</code> table reference
     */
    public Nokucell(Name alias) {
        this(alias, NOKUCELL);
    }

    private Nokucell(Name alias, Table<NokucellRecord> aliased) {
        this(alias, aliased, null);
    }

    private Nokucell(Name alias, Table<NokucellRecord> aliased, Field<?>[] parameters) {
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
        return Arrays.<Index>asList(Indexes.NOKUCELL_NOKUCELL_DATE, Indexes.NOKUCELL_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<NokucellRecord> getPrimaryKey() {
        return Keys.KEY_NOKUCELL_PRIMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<NokucellRecord>> getKeys() {
        return Arrays.<UniqueKey<NokucellRecord>>asList(Keys.KEY_NOKUCELL_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Nokucell as(String alias) {
        return new Nokucell(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Nokucell as(Name alias) {
        return new Nokucell(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Nokucell rename(String name) {
        return new Nokucell(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Nokucell rename(Name name) {
        return new Nokucell(name, null);
    }
}

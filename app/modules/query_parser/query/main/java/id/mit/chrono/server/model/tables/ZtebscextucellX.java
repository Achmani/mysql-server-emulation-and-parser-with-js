/*
 * This file is generated by jOOQ.
*/
package id.mit.chrono.server.model.tables;


import id.mit.chrono.server.model.Chrono;
import id.mit.chrono.server.model.Keys;
import id.mit.chrono.server.model.tables.records.ZtebscextucellXRecord;

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
public class ZtebscextucellX extends TableImpl<ZtebscextucellXRecord> {

    private static final long serialVersionUID = -2006200611;

    /**
     * The reference instance of <code>chrono.ztebscextucell_x</code>
     */
    public static final ZtebscextucellX ZTEBSCEXTUCELL_X = new ZtebscextucellX();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<ZtebscextucellXRecord> getRecordType() {
        return ZtebscextucellXRecord.class;
    }

    /**
     * The column <code>chrono.ztebscextucell_x.ztebscextucell_id</code>.
     */
    public final TableField<ZtebscextucellXRecord, ULong> ZTEBSCEXTUCELL_ID = createField("ztebscextucell_id", org.jooq.impl.SQLDataType.BIGINTUNSIGNED.nullable(false), this, "");

    /**
     * The column <code>chrono.ztebscextucell_x.ztebscextucell_crcollectortaskfiles</code>.
     */
    public final TableField<ZtebscextucellXRecord, ULong> ZTEBSCEXTUCELL_CRCOLLECTORTASKFILES = createField("ztebscextucell_crcollectortaskfiles", org.jooq.impl.SQLDataType.BIGINTUNSIGNED, this, "");

    /**
     * The column <code>chrono.ztebscextucell_x.ztebscextucell_crprocessortaskfiles</code>.
     */
    public final TableField<ZtebscextucellXRecord, Long> ZTEBSCEXTUCELL_CRPROCESSORTASKFILES = createField("ztebscextucell_crprocessortaskfiles", org.jooq.impl.SQLDataType.BIGINT, this, "");

    /**
     * The column <code>chrono.ztebscextucell_x.zteucell_date</code>.
     */
    public final TableField<ZtebscextucellXRecord, UInteger> ZTEUCELL_DATE = createField("zteucell_date", org.jooq.impl.SQLDataType.INTEGERUNSIGNED.nullable(false), this, "");

    /**
     * The column <code>chrono.ztebscextucell_x.ztebscextucell_datefrom</code>.
     */
    public final TableField<ZtebscextucellXRecord, UInteger> ZTEBSCEXTUCELL_DATEFROM = createField("ztebscextucell_datefrom", org.jooq.impl.SQLDataType.INTEGERUNSIGNED, this, "");

    /**
     * The column <code>chrono.ztebscextucell_x.ztebscextucell_zternc</code>.
     */
    public final TableField<ZtebscextucellXRecord, ULong> ZTEBSCEXTUCELL_ZTERNC = createField("ztebscextucell_zternc", org.jooq.impl.SQLDataType.BIGINTUNSIGNED.nullable(false), this, "");

    /**
     * The column <code>chrono.ztebscextucell_x.ztebscextucell_ztenodeb</code>.
     */
    public final TableField<ZtebscextucellXRecord, ULong> ZTEBSCEXTUCELL_ZTENODEB = createField("ztebscextucell_ztenodeb", org.jooq.impl.SQLDataType.BIGINTUNSIGNED, this, "");

    /**
     * The column <code>chrono.ztebscextucell_x.ztebscextucell_nodealias</code>.
     */
    public final TableField<ZtebscextucellXRecord, Integer> ZTEBSCEXTUCELL_NODEALIAS = createField("ztebscextucell_nodealias", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.ztebscextucell_x.ztebscextucell_cell</code>.
     */
    public final TableField<ZtebscextucellXRecord, Integer> ZTEBSCEXTUCELL_CELL = createField("ztebscextucell_cell", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.ztebscextucell_x.ztebscextucell_cellclass</code>.
     */
    public final TableField<ZtebscextucellXRecord, Integer> ZTEBSCEXTUCELL_CELLCLASS = createField("ztebscextucell_cellclass", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.ztebscextucell_x.ztebscextucell_cellclassgroup</code>.
     */
    public final TableField<ZtebscextucellXRecord, Integer> ZTEBSCEXTUCELL_CELLCLASSGROUP = createField("ztebscextucell_cellclassgroup", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.ztebscextucell_x.ztebscextucell_cellcoverage</code>.
     */
    public final TableField<ZtebscextucellXRecord, Integer> ZTEBSCEXTUCELL_CELLCOVERAGE = createField("ztebscextucell_cellcoverage", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.ztebscextucell_x.ztebscextucell_revenueclass</code>.
     */
    public final TableField<ZtebscextucellXRecord, Integer> ZTEBSCEXTUCELL_REVENUECLASS = createField("ztebscextucell_revenueclass", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.ztebscextucell_x.ztebscextucell_cellstatus</code>.
     */
    public final TableField<ZtebscextucellXRecord, Integer> ZTEBSCEXTUCELL_CELLSTATUS = createField("ztebscextucell_cellstatus", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.ztebscextucell_x.ztebscextucell_vendor</code>.
     */
    public final TableField<ZtebscextucellXRecord, Integer> ZTEBSCEXTUCELL_VENDOR = createField("ztebscextucell_vendor", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.ztebscextucell_x.ztebscextucell_latitude</code>.
     */
    public final TableField<ZtebscextucellXRecord, Double> ZTEBSCEXTUCELL_LATITUDE = createField("ztebscextucell_latitude", org.jooq.impl.SQLDataType.DOUBLE, this, "");

    /**
     * The column <code>chrono.ztebscextucell_x.ztebscextucell_longitude</code>.
     */
    public final TableField<ZtebscextucellXRecord, Double> ZTEBSCEXTUCELL_LONGITUDE = createField("ztebscextucell_longitude", org.jooq.impl.SQLDataType.DOUBLE, this, "");

    /**
     * The column <code>chrono.ztebscextucell_x.ztebscextucell_namingvalid</code>.
     */
    public final TableField<ZtebscextucellXRecord, Byte> ZTEBSCEXTUCELL_NAMINGVALID = createField("ztebscextucell_namingvalid", org.jooq.impl.SQLDataType.TINYINT, this, "");

    /**
     * The column <code>chrono.ztebscextucell_x.MOI</code>.
     */
    public final TableField<ZtebscextucellXRecord, String> MOI = createField("MOI", org.jooq.impl.SQLDataType.CHAR(92), this, "");

    /**
     * The column <code>chrono.ztebscextucell_x.SubNetwork</code>.
     */
    public final TableField<ZtebscextucellXRecord, String> SUBNETWORK = createField("SubNetwork", org.jooq.impl.SQLDataType.CHAR(6), this, "");

    /**
     * The column <code>chrono.ztebscextucell_x.MEID</code>.
     */
    public final TableField<ZtebscextucellXRecord, String> MEID = createField("MEID", org.jooq.impl.SQLDataType.CHAR(6), this, "");

    /**
     * The column <code>chrono.ztebscextucell_x.URncFunction</code>.
     */
    public final TableField<ZtebscextucellXRecord, String> URNCFUNCTION = createField("URncFunction", org.jooq.impl.SQLDataType.CHAR(6), this, "");

    /**
     * The column <code>chrono.ztebscextucell_x.UUtranCellFDD</code>.
     */
    public final TableField<ZtebscextucellXRecord, String> UUTRANCELLFDD = createField("UUtranCellFDD", org.jooq.impl.SQLDataType.CHAR(6), this, "");

    /**
     * The column <code>chrono.ztebscextucell_x.userLabel</code>.
     */
    public final TableField<ZtebscextucellXRecord, String> USERLABEL = createField("userLabel", org.jooq.impl.SQLDataType.CHAR(64), this, "");

    /**
     * The column <code>chrono.ztebscextucell_x.description</code>.
     */
    public final TableField<ZtebscextucellXRecord, String> DESCRIPTION = createField("description", org.jooq.impl.SQLDataType.CHAR(96), this, "");

    /**
     * The column <code>chrono.ztebscextucell_x.cId</code>.
     */
    public final TableField<ZtebscextucellXRecord, String> CID = createField("cId", org.jooq.impl.SQLDataType.CHAR(8), this, "");

    /**
     * The column <code>chrono.ztebscextucell_x.localCellId</code>.
     */
    public final TableField<ZtebscextucellXRecord, String> LOCALCELLID = createField("localCellId", org.jooq.impl.SQLDataType.CHAR(8), this, "");

    /**
     * The column <code>chrono.ztebscextucell_x.maximumTransmissionPower</code>.
     */
    public final TableField<ZtebscextucellXRecord, String> MAXIMUMTRANSMISSIONPOWER = createField("maximumTransmissionPower", org.jooq.impl.SQLDataType.CHAR(8), this, "");

    /**
     * The column <code>chrono.ztebscextucell_x.pichPower</code>.
     */
    public final TableField<ZtebscextucellXRecord, String> PICHPOWER = createField("pichPower", org.jooq.impl.SQLDataType.CHAR(6), this, "");

    /**
     * The column <code>chrono.ztebscextucell_x.cellMode</code>.
     */
    public final TableField<ZtebscextucellXRecord, String> CELLMODE = createField("cellMode", org.jooq.impl.SQLDataType.CHAR(4), this, "");

    /**
     * The column <code>chrono.ztebscextucell_x.refULocationArea</code>.
     */
    public final TableField<ZtebscextucellXRecord, String> REFULOCATIONAREA = createField("refULocationArea", org.jooq.impl.SQLDataType.CHAR(96), this, "");

    /**
     * The column <code>chrono.ztebscextucell_x.refURoutingArea</code>.
     */
    public final TableField<ZtebscextucellXRecord, String> REFUROUTINGAREA = createField("refURoutingArea", org.jooq.impl.SQLDataType.CHAR(96), this, "");

    /**
     * The column <code>chrono.ztebscextucell_x.refUServiceArea</code>.
     */
    public final TableField<ZtebscextucellXRecord, String> REFUSERVICEAREA = createField("refUServiceArea", org.jooq.impl.SQLDataType.CHAR(96), this, "");

    /**
     * The column <code>chrono.ztebscextucell_x.refUIubLink</code>.
     */
    public final TableField<ZtebscextucellXRecord, String> REFUIUBLINK = createField("refUIubLink", org.jooq.impl.SQLDataType.CHAR(96), this, "");

    /**
     * The column <code>chrono.ztebscextucell_x.freqBandInd</code>.
     */
    public final TableField<ZtebscextucellXRecord, String> FREQBANDIND = createField("freqBandInd", org.jooq.impl.SQLDataType.CHAR(6), this, "");

    /**
     * The column <code>chrono.ztebscextucell_x.uarfcnDl</code>.
     */
    public final TableField<ZtebscextucellXRecord, String> UARFCNDL = createField("uarfcnDl", org.jooq.impl.SQLDataType.CHAR(6), this, "");

    /**
     * The column <code>chrono.ztebscextucell_x.uarfcnUl</code>.
     */
    public final TableField<ZtebscextucellXRecord, String> UARFCNUL = createField("uarfcnUl", org.jooq.impl.SQLDataType.CHAR(96), this, "");

    /**
     * The column <code>chrono.ztebscextucell_x.ULFREQ</code>.
     */
    public final TableField<ZtebscextucellXRecord, Double> ULFREQ = createField("ULFREQ", org.jooq.impl.SQLDataType.DOUBLE, this, "");

    /**
     * The column <code>chrono.ztebscextucell_x.DLFREQ</code>.
     */
    public final TableField<ZtebscextucellXRecord, Double> DLFREQ = createField("DLFREQ", org.jooq.impl.SQLDataType.DOUBLE, this, "");

    /**
     * The column <code>chrono.ztebscextucell_x.primaryScramblingCode</code>.
     */
    public final TableField<ZtebscextucellXRecord, String> PRIMARYSCRAMBLINGCODE = createField("primaryScramblingCode", org.jooq.impl.SQLDataType.CHAR(6), this, "");

    /**
     * The column <code>chrono.ztebscextucell_x.primaryCpichPower</code>.
     */
    public final TableField<ZtebscextucellXRecord, String> PRIMARYCPICHPOWER = createField("primaryCpichPower", org.jooq.impl.SQLDataType.CHAR(6), this, "");

    /**
     * The column <code>chrono.ztebscextucell_x.primarySchPower</code>.
     */
    public final TableField<ZtebscextucellXRecord, String> PRIMARYSCHPOWER = createField("primarySchPower", org.jooq.impl.SQLDataType.CHAR(6), this, "");

    /**
     * The column <code>chrono.ztebscextucell_x.mcc</code>.
     */
    public final TableField<ZtebscextucellXRecord, String> MCC = createField("mcc", org.jooq.impl.SQLDataType.CHAR(4), this, "");

    /**
     * The column <code>chrono.ztebscextucell_x.mnc</code>.
     */
    public final TableField<ZtebscextucellXRecord, String> MNC = createField("mnc", org.jooq.impl.SQLDataType.CHAR(4), this, "");

    /**
     * The column <code>chrono.ztebscextucell_x.lac</code>.
     */
    public final TableField<ZtebscextucellXRecord, String> LAC = createField("lac", org.jooq.impl.SQLDataType.CHAR(6), this, "");

    /**
     * The column <code>chrono.ztebscextucell_x.cgi</code>.
     */
    public final TableField<ZtebscextucellXRecord, String> CGI = createField("cgi", org.jooq.impl.SQLDataType.CHAR(24), this, "");

    /**
     * The column <code>chrono.ztebscextucell_x.rac</code>.
     */
    public final TableField<ZtebscextucellXRecord, String> RAC = createField("rac", org.jooq.impl.SQLDataType.CHAR(6), this, "");

    /**
     * The column <code>chrono.ztebscextucell_x.sac</code>.
     */
    public final TableField<ZtebscextucellXRecord, String> SAC = createField("sac", org.jooq.impl.SQLDataType.CHAR(6), this, "");

    /**
     * The column <code>chrono.ztebscextucell_x.address</code>.
     */
    public final TableField<ZtebscextucellXRecord, String> ADDRESS = createField("address", org.jooq.impl.SQLDataType.CLOB, this, "");

    /**
     * The column <code>chrono.ztebscextucell_x.latitudeSign</code>.
     */
    public final TableField<ZtebscextucellXRecord, Byte> LATITUDESIGN = createField("latitudeSign", org.jooq.impl.SQLDataType.TINYINT, this, "");

    /**
     * The column <code>chrono.ztebscextucell_x.latitude</code>.
     */
    public final TableField<ZtebscextucellXRecord, Double> LATITUDE = createField("latitude", org.jooq.impl.SQLDataType.DOUBLE, this, "");

    /**
     * The column <code>chrono.ztebscextucell_x.longitude</code>.
     */
    public final TableField<ZtebscextucellXRecord, Double> LONGITUDE = createField("longitude", org.jooq.impl.SQLDataType.DOUBLE, this, "");

    /**
     * The column <code>chrono.ztebscextucell_x.altitude</code>.
     */
    public final TableField<ZtebscextucellXRecord, String> ALTITUDE = createField("altitude", org.jooq.impl.SQLDataType.CHAR(4), this, "");

    /**
     * The column <code>chrono.ztebscextucell_x.cellRadius</code>.
     */
    public final TableField<ZtebscextucellXRecord, String> CELLRADIUS = createField("cellRadius", org.jooq.impl.SQLDataType.CHAR(6), this, "");

    /**
     * The column <code>chrono.ztebscextucell_x.anteLatitude</code>.
     */
    public final TableField<ZtebscextucellXRecord, Double> ANTELATITUDE = createField("anteLatitude", org.jooq.impl.SQLDataType.DOUBLE, this, "");

    /**
     * The column <code>chrono.ztebscextucell_x.anteLongitude</code>.
     */
    public final TableField<ZtebscextucellXRecord, Double> ANTELONGITUDE = createField("anteLongitude", org.jooq.impl.SQLDataType.DOUBLE, this, "");

    /**
     * The column <code>chrono.ztebscextucell_x.anteAltitude</code>.
     */
    public final TableField<ZtebscextucellXRecord, String> ANTEALTITUDE = createField("anteAltitude", org.jooq.impl.SQLDataType.CHAR(4), this, "");

    /**
     * The column <code>chrono.ztebscextucell_x.anteAltitudeDir</code>.
     */
    public final TableField<ZtebscextucellXRecord, String> ANTEALTITUDEDIR = createField("anteAltitudeDir", org.jooq.impl.SQLDataType.CHAR(4), this, "");

    /**
     * The column <code>chrono.ztebscextucell_x.offsetAngle</code>.
     */
    public final TableField<ZtebscextucellXRecord, String> OFFSETANGLE = createField("offsetAngle", org.jooq.impl.SQLDataType.CHAR(4), this, "");

    /**
     * The column <code>chrono.ztebscextucell_x.zteucell_remark</code>.
     */
    public final TableField<ZtebscextucellXRecord, String> ZTEUCELL_REMARK = createField("zteucell_remark", org.jooq.impl.SQLDataType.CLOB, this, "");

    /**
     * Create a <code>chrono.ztebscextucell_x</code> table reference
     */
    public ZtebscextucellX() {
        this(DSL.name("ztebscextucell_x"), null);
    }

    /**
     * Create an aliased <code>chrono.ztebscextucell_x</code> table reference
     */
    public ZtebscextucellX(String alias) {
        this(DSL.name(alias), ZTEBSCEXTUCELL_X);
    }

    /**
     * Create an aliased <code>chrono.ztebscextucell_x</code> table reference
     */
    public ZtebscextucellX(Name alias) {
        this(alias, ZTEBSCEXTUCELL_X);
    }

    private ZtebscextucellX(Name alias, Table<ZtebscextucellXRecord> aliased) {
        this(alias, aliased, null);
    }

    private ZtebscextucellX(Name alias, Table<ZtebscextucellXRecord> aliased, Field<?>[] parameters) {
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
    public UniqueKey<ZtebscextucellXRecord> getPrimaryKey() {
        return Keys.KEY_ZTEBSCEXTUCELL_X_PRIMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<ZtebscextucellXRecord>> getKeys() {
        return Arrays.<UniqueKey<ZtebscextucellXRecord>>asList(Keys.KEY_ZTEBSCEXTUCELL_X_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ZtebscextucellX as(String alias) {
        return new ZtebscextucellX(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ZtebscextucellX as(Name alias) {
        return new ZtebscextucellX(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public ZtebscextucellX rename(String name) {
        return new ZtebscextucellX(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public ZtebscextucellX rename(Name name) {
        return new ZtebscextucellX(name, null);
    }
}

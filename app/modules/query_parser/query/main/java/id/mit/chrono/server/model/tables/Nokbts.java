/*
 * This file is generated by jOOQ.
*/
package id.mit.chrono.server.model.tables;


import id.mit.chrono.server.model.Chrono;
import id.mit.chrono.server.model.Indexes;
import id.mit.chrono.server.model.Keys;
import id.mit.chrono.server.model.tables.records.NokbtsRecord;

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
public class Nokbts extends TableImpl<NokbtsRecord> {

    private static final long serialVersionUID = 720742134;

    /**
     * The reference instance of <code>chrono.nokbts</code>
     */
    public static final Nokbts NOKBTS = new Nokbts();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<NokbtsRecord> getRecordType() {
        return NokbtsRecord.class;
    }

    /**
     * The column <code>chrono.nokbts.nokbts_id</code>.
     */
    public final TableField<NokbtsRecord, ULong> NOKBTS_ID = createField("nokbts_id", org.jooq.impl.SQLDataType.BIGINTUNSIGNED.nullable(false), this, "");

    /**
     * The column <code>chrono.nokbts.nokbts_crcollectortaskfiles</code>.
     */
    public final TableField<NokbtsRecord, ULong> NOKBTS_CRCOLLECTORTASKFILES = createField("nokbts_crcollectortaskfiles", org.jooq.impl.SQLDataType.BIGINTUNSIGNED, this, "");

    /**
     * The column <code>chrono.nokbts.nokbts_date</code>.
     */
    public final TableField<NokbtsRecord, UInteger> NOKBTS_DATE = createField("nokbts_date", org.jooq.impl.SQLDataType.INTEGERUNSIGNED.nullable(false), this, "");

    /**
     * The column <code>chrono.nokbts.nokbts_datefrom</code>.
     */
    public final TableField<NokbtsRecord, UInteger> NOKBTS_DATEFROM = createField("nokbts_datefrom", org.jooq.impl.SQLDataType.INTEGERUNSIGNED, this, "");

    /**
     * The column <code>chrono.nokbts.nokbts_nokbsc</code>.
     */
    public final TableField<NokbtsRecord, ULong> NOKBTS_NOKBSC = createField("nokbts_nokbsc", org.jooq.impl.SQLDataType.BIGINTUNSIGNED, this, "");

    /**
     * The column <code>chrono.nokbts.nokbts_node</code>.
     */
    public final TableField<NokbtsRecord, Integer> NOKBTS_NODE = createField("nokbts_node", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.nokbts.nokbts_nodephysical</code>.
     */
    public final TableField<NokbtsRecord, Integer> NOKBTS_NODEPHYSICAL = createField("nokbts_nodephysical", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.nokbts.nokbts_nodestatus</code>.
     */
    public final TableField<NokbtsRecord, Integer> NOKBTS_NODESTATUS = createField("nokbts_nodestatus", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.nokbts.nokbts_revenueclass</code>.
     */
    public final TableField<NokbtsRecord, Integer> NOKBTS_REVENUECLASS = createField("nokbts_revenueclass", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.nokbts.nokbts_vendor</code>.
     */
    public final TableField<NokbtsRecord, Integer> NOKBTS_VENDOR = createField("nokbts_vendor", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.nokbts.nokbts_namingvalid</code>.
     */
    public final TableField<NokbtsRecord, Byte> NOKBTS_NAMINGVALID = createField("nokbts_namingvalid", org.jooq.impl.SQLDataType.TINYINT, this, "");

    /**
     * The column <code>chrono.nokbts.TOTALCELL</code>.
     */
    public final TableField<NokbtsRecord, Integer> TOTALCELL = createField("TOTALCELL", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.nokbts.TOTALTRX</code>.
     */
    public final TableField<NokbtsRecord, Integer> TOTALTRX = createField("TOTALTRX", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.nokbts.BTSNAME</code>.
     */
    public final TableField<NokbtsRecord, String> BTSNAME = createField("BTSNAME", org.jooq.impl.SQLDataType.CHAR(96), this, "");

    /**
     * The column <code>chrono.nokbts.BTSID</code>.
     */
    public final TableField<NokbtsRecord, Integer> BTSID = createField("BTSID", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.nokbts.distName</code>.
     */
    public final TableField<NokbtsRecord, String> DISTNAME = createField("distName", org.jooq.impl.SQLDataType.CHAR(96), this, "");

    /**
     * The column <code>chrono.nokbts.version</code>.
     */
    public final TableField<NokbtsRecord, String> VERSION = createField("version", org.jooq.impl.SQLDataType.CHAR(16), this, "");

    /**
     * The column <code>chrono.nokbts.linkedMrsiteDN</code>.
     */
    public final TableField<NokbtsRecord, String> LINKEDMRSITEDN = createField("linkedMrsiteDN", org.jooq.impl.SQLDataType.CHAR(96), this, "");

    /**
     * The column <code>chrono.nokbts.siteId</code>.
     */
    public final TableField<NokbtsRecord, String> SITEID = createField("siteId", org.jooq.impl.SQLDataType.CHAR(64), this, "");

    /**
     * The column <code>chrono.nokbts.siteCId</code>.
     */
    public final TableField<NokbtsRecord, String> SITECID = createField("siteCId", org.jooq.impl.SQLDataType.CHAR(8), this, "");

    /**
     * The column <code>chrono.nokbts.name</code>.
     */
    public final TableField<NokbtsRecord, String> NAME = createField("name", org.jooq.impl.SQLDataType.CHAR(96), this, "");

    /**
     * The column <code>chrono.nokbts.abisInterfaceConnectionType</code>.
     */
    public final TableField<NokbtsRecord, String> ABISINTERFACECONNECTIONTYPE = createField("abisInterfaceConnectionType", org.jooq.impl.SQLDataType.CHAR(8), this, "");

    /**
     * The column <code>chrono.nokbts.adminState</code>.
     */
    public final TableField<NokbtsRecord, String> ADMINSTATE = createField("adminState", org.jooq.impl.SQLDataType.CHAR(8), this, "");

    /**
     * The column <code>chrono.nokbts.autoConfig</code>.
     */
    public final TableField<NokbtsRecord, String> AUTOCONFIG = createField("autoConfig", org.jooq.impl.SQLDataType.CHAR(8), this, "");

    /**
     * The column <code>chrono.nokbts.bcfType</code>.
     */
    public final TableField<NokbtsRecord, String> BCFTYPE = createField("bcfType", org.jooq.impl.SQLDataType.CHAR(8), this, "");

    /**
     * The column <code>chrono.nokbts.bcfUpToDate</code>.
     */
    public final TableField<NokbtsRecord, String> BCFUPTODATE = createField("bcfUpToDate", org.jooq.impl.SQLDataType.CHAR(8), this, "");

    /**
     * The column <code>chrono.nokbts.btsCuPlaneIpAddress</code>.
     */
    public final TableField<NokbtsRecord, String> BTSCUPLANEIPADDRESS = createField("btsCuPlaneIpAddress", org.jooq.impl.SQLDataType.CHAR(32), this, "");

    /**
     * The column <code>chrono.nokbts.btsIpv4SubnetMasklengthCUplane</code>.
     */
    public final TableField<NokbtsRecord, String> BTSIPV4SUBNETMASKLENGTHCUPLANE = createField("btsIpv4SubnetMasklengthCUplane", org.jooq.impl.SQLDataType.CHAR(8), this, "");

    /**
     * The column <code>chrono.nokbts.btsIpv4SubnetMasklengthMplane</code>.
     */
    public final TableField<NokbtsRecord, String> BTSIPV4SUBNETMASKLENGTHMPLANE = createField("btsIpv4SubnetMasklengthMplane", org.jooq.impl.SQLDataType.CHAR(8), this, "");

    /**
     * The column <code>chrono.nokbts.btsMPlaneIpAddress</code>.
     */
    public final TableField<NokbtsRecord, String> BTSMPLANEIPADDRESS = createField("btsMPlaneIpAddress", org.jooq.impl.SQLDataType.CHAR(32), this, "");

    /**
     * The column <code>chrono.nokbts.btsSiteSubtype</code>.
     */
    public final TableField<NokbtsRecord, String> BTSSITESUBTYPE = createField("btsSiteSubtype", org.jooq.impl.SQLDataType.CHAR(8), this, "");

    /**
     * The column <code>chrono.nokbts.clockSource</code>.
     */
    public final TableField<NokbtsRecord, String> CLOCKSOURCE = createField("clockSource", org.jooq.impl.SQLDataType.CHAR(8), this, "");

    /**
     * The column <code>chrono.nokbts.lapdLinkName</code>.
     */
    public final TableField<NokbtsRecord, String> LAPDLINKNAME = createField("lapdLinkName", org.jooq.impl.SQLDataType.CHAR(32), this, "");

    /**
     * The column <code>chrono.nokbts.lapdLinkNumber</code>.
     */
    public final TableField<NokbtsRecord, String> LAPDLINKNUMBER = createField("lapdLinkNumber", org.jooq.impl.SQLDataType.CHAR(8), this, "");

    /**
     * The column <code>chrono.nokbts.masterClockBcf</code>.
     */
    public final TableField<NokbtsRecord, String> MASTERCLOCKBCF = createField("masterClockBcf", org.jooq.impl.SQLDataType.CHAR(88), this, "");

    /**
     * The column <code>chrono.nokbts.usedCsUdpMuxPort</code>.
     */
    public final TableField<NokbtsRecord, String> USEDCSUDPMUXPORT = createField("usedCsUdpMuxPort", org.jooq.impl.SQLDataType.CHAR(8), this, "");

    /**
     * The column <code>chrono.nokbts.usedPsUdpMuxPort</code>.
     */
    public final TableField<NokbtsRecord, String> USEDPSUDPMUXPORT = createField("usedPsUdpMuxPort", org.jooq.impl.SQLDataType.CHAR(8), this, "");

    /**
     * The column <code>chrono.nokbts.vlanId</code>.
     */
    public final TableField<NokbtsRecord, String> VLANID = createField("vlanId", org.jooq.impl.SQLDataType.CHAR(8), this, "");

    /**
     * The column <code>chrono.nokbts.longitude</code>.
     */
    public final TableField<NokbtsRecord, String> LONGITUDE = createField("longitude", org.jooq.impl.SQLDataType.CHAR(16), this, "");

    /**
     * The column <code>chrono.nokbts.latitude</code>.
     */
    public final TableField<NokbtsRecord, String> LATITUDE = createField("latitude", org.jooq.impl.SQLDataType.CHAR(16), this, "");

    /**
     * The column <code>chrono.nokbts.lon</code>.
     */
    public final TableField<NokbtsRecord, Double> LON = createField("lon", org.jooq.impl.SQLDataType.DOUBLE, this, "");

    /**
     * The column <code>chrono.nokbts.lat</code>.
     */
    public final TableField<NokbtsRecord, Double> LAT = createField("lat", org.jooq.impl.SQLDataType.DOUBLE, this, "");

    /**
     * The column <code>chrono.nokbts.streetAddress</code>.
     */
    public final TableField<NokbtsRecord, String> STREETADDRESS = createField("streetAddress", org.jooq.impl.SQLDataType.CLOB, this, "");

    /**
     * The column <code>chrono.nokbts.nokbts_remark</code>.
     */
    public final TableField<NokbtsRecord, String> NOKBTS_REMARK = createField("nokbts_remark", org.jooq.impl.SQLDataType.CLOB, this, "");

    /**
     * The column <code>chrono.nokbts.EXTPROP1</code>.
     */
    public final TableField<NokbtsRecord, Integer> EXTPROP1 = createField("EXTPROP1", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.nokbts.EXTPROP2</code>.
     */
    public final TableField<NokbtsRecord, String> EXTPROP2 = createField("EXTPROP2", org.jooq.impl.SQLDataType.CHAR(8), this, "");

    /**
     * Create a <code>chrono.nokbts</code> table reference
     */
    public Nokbts() {
        this(DSL.name("nokbts"), null);
    }

    /**
     * Create an aliased <code>chrono.nokbts</code> table reference
     */
    public Nokbts(String alias) {
        this(DSL.name(alias), NOKBTS);
    }

    /**
     * Create an aliased <code>chrono.nokbts</code> table reference
     */
    public Nokbts(Name alias) {
        this(alias, NOKBTS);
    }

    private Nokbts(Name alias, Table<NokbtsRecord> aliased) {
        this(alias, aliased, null);
    }

    private Nokbts(Name alias, Table<NokbtsRecord> aliased, Field<?>[] parameters) {
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
        return Arrays.<Index>asList(Indexes.NOKBTS_HWBTS_DATE, Indexes.NOKBTS_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<NokbtsRecord> getPrimaryKey() {
        return Keys.KEY_NOKBTS_PRIMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<NokbtsRecord>> getKeys() {
        return Arrays.<UniqueKey<NokbtsRecord>>asList(Keys.KEY_NOKBTS_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Nokbts as(String alias) {
        return new Nokbts(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Nokbts as(Name alias) {
        return new Nokbts(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Nokbts rename(String name) {
        return new Nokbts(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Nokbts rename(Name name) {
        return new Nokbts(name, null);
    }
}
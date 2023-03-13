/*
 * This file is generated by jOOQ.
*/
package id.mit.chrono.server.model.tables;


import id.mit.chrono.server.model.Chrono;
import id.mit.chrono.server.model.Indexes;
import id.mit.chrono.server.model.Keys;
import id.mit.chrono.server.model.tables.records.NokrncRecord;

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
public class Nokrnc extends TableImpl<NokrncRecord> {

    private static final long serialVersionUID = -1288672868;

    /**
     * The reference instance of <code>chrono.nokrnc</code>
     */
    public static final Nokrnc NOKRNC = new Nokrnc();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<NokrncRecord> getRecordType() {
        return NokrncRecord.class;
    }

    /**
     * The column <code>chrono.nokrnc.nokrnc_id</code>.
     */
    public final TableField<NokrncRecord, ULong> NOKRNC_ID = createField("nokrnc_id", org.jooq.impl.SQLDataType.BIGINTUNSIGNED.nullable(false), this, "");

    /**
     * The column <code>chrono.nokrnc.nokrnc_crcollectortaskfiles</code>.
     */
    public final TableField<NokrncRecord, ULong> NOKRNC_CRCOLLECTORTASKFILES = createField("nokrnc_crcollectortaskfiles", org.jooq.impl.SQLDataType.BIGINTUNSIGNED, this, "");

    /**
     * The column <code>chrono.nokrnc.nokrnc_date</code>.
     */
    public final TableField<NokrncRecord, UInteger> NOKRNC_DATE = createField("nokrnc_date", org.jooq.impl.SQLDataType.INTEGERUNSIGNED.nullable(false), this, "");

    /**
     * The column <code>chrono.nokrnc.nokrnc_datefrom</code>.
     */
    public final TableField<NokrncRecord, UInteger> NOKRNC_DATEFROM = createField("nokrnc_datefrom", org.jooq.impl.SQLDataType.INTEGERUNSIGNED, this, "");

    /**
     * The column <code>chrono.nokrnc.nokrnc_node</code>.
     */
    public final TableField<NokrncRecord, Integer> NOKRNC_NODE = createField("nokrnc_node", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.nokrnc.nokrnc_vendor</code>.
     */
    public final TableField<NokrncRecord, Integer> NOKRNC_VENDOR = createField("nokrnc_vendor", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.nokrnc.RNCNAME</code>.
     */
    public final TableField<NokrncRecord, String> RNCNAME = createField("RNCNAME", org.jooq.impl.SQLDataType.CHAR(32), this, "");

    /**
     * The column <code>chrono.nokrnc.TOTALSUBRACK</code>.
     */
    public final TableField<NokrncRecord, Integer> TOTALSUBRACK = createField("TOTALSUBRACK", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.nokrnc.TOTALBRD</code>.
     */
    public final TableField<NokrncRecord, Integer> TOTALBRD = createField("TOTALBRD", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.nokrnc.TOTALNODEB</code>.
     */
    public final TableField<NokrncRecord, Integer> TOTALNODEB = createField("TOTALNODEB", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.nokrnc.TOTALCELL</code>.
     */
    public final TableField<NokrncRecord, Integer> TOTALCELL = createField("TOTALCELL", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.nokrnc.ActivePRNC</code>.
     */
    public final TableField<NokrncRecord, String> ACTIVEPRNC = createField("ActivePRNC", org.jooq.impl.SQLDataType.CHAR(8), this, "");

    /**
     * The column <code>chrono.nokrnc.AlarmSetforWCELBLINIT</code>.
     */
    public final TableField<NokrncRecord, String> ALARMSETFORWCELBLINIT = createField("AlarmSetforWCELBLINIT", org.jooq.impl.SQLDataType.CHAR(8), this, "");

    /**
     * The column <code>chrono.nokrnc.name</code>.
     */
    public final TableField<NokrncRecord, String> NAME = createField("name", org.jooq.impl.SQLDataType.CHAR(32), this, "");

    /**
     * The column <code>chrono.nokrnc.MaxAMRCapacityErl</code>.
     */
    public final TableField<NokrncRecord, String> MAXAMRCAPACITYERL = createField("MaxAMRCapacityErl", org.jooq.impl.SQLDataType.CHAR(8), this, "");

    /**
     * The column <code>chrono.nokrnc.distName</code>.
     */
    public final TableField<NokrncRecord, String> DISTNAME = createField("distName", org.jooq.impl.SQLDataType.CHAR(96), this, "");

    /**
     * The column <code>chrono.nokrnc.MaxCarrierConnectivity</code>.
     */
    public final TableField<NokrncRecord, String> MAXCARRIERCONNECTIVITY = createField("MaxCarrierConnectivity", org.jooq.impl.SQLDataType.CHAR(8), this, "");

    /**
     * The column <code>chrono.nokrnc.MaxIubPSThroughputMbps</code>.
     */
    public final TableField<NokrncRecord, String> MAXIUBPSTHROUGHPUTMBPS = createField("MaxIubPSThroughputMbps", org.jooq.impl.SQLDataType.CHAR(8), this, "");

    /**
     * The column <code>chrono.nokrnc.MinRedEDPDCH</code>.
     */
    public final TableField<NokrncRecord, String> MINREDEDPDCH = createField("MinRedEDPDCH", org.jooq.impl.SQLDataType.CHAR(8), this, "");

    /**
     * The column <code>chrono.nokrnc.N302</code>.
     */
    public final TableField<NokrncRecord, String> N302 = createField("N302", org.jooq.impl.SQLDataType.CHAR(8), this, "");

    /**
     * The column <code>chrono.nokrnc.N304</code>.
     */
    public final TableField<NokrncRecord, String> N304 = createField("N304", org.jooq.impl.SQLDataType.CHAR(8), this, "");

    /**
     * The column <code>chrono.nokrnc.N308</code>.
     */
    public final TableField<NokrncRecord, String> N308 = createField("N308", org.jooq.impl.SQLDataType.CHAR(8), this, "");

    /**
     * The column <code>chrono.nokrnc.OMSBackupIpAddress</code>.
     */
    public final TableField<NokrncRecord, String> OMSBACKUPIPADDRESS = createField("OMSBackupIpAddress", org.jooq.impl.SQLDataType.CHAR(16), this, "");

    /**
     * The column <code>chrono.nokrnc.OMSIpAddress</code>.
     */
    public final TableField<NokrncRecord, String> OMSIPADDRESS = createField("OMSIpAddress", org.jooq.impl.SQLDataType.CHAR(16), this, "");

    /**
     * The column <code>chrono.nokrnc.RNCIPAddress</code>.
     */
    public final TableField<NokrncRecord, String> RNCIPADDRESS = createField("RNCIPAddress", org.jooq.impl.SQLDataType.CHAR(16), this, "");

    /**
     * The column <code>chrono.nokrnc.SecOMSIpAddress</code>.
     */
    public final TableField<NokrncRecord, String> SECOMSIPADDRESS = createField("SecOMSIpAddress", org.jooq.impl.SQLDataType.CHAR(16), this, "");

    /**
     * The column <code>chrono.nokrnc.ServingOMS</code>.
     */
    public final TableField<NokrncRecord, String> SERVINGOMS = createField("ServingOMS", org.jooq.impl.SQLDataType.CHAR(8), this, "");

    /**
     * The column <code>chrono.nokrnc.ServingOMSAdminSetting</code>.
     */
    public final TableField<NokrncRecord, String> SERVINGOMSADMINSETTING = createField("ServingOMSAdminSetting", org.jooq.impl.SQLDataType.CHAR(8), this, "");

    /**
     * The column <code>chrono.nokrnc.softwareReleaseVersion</code>.
     */
    public final TableField<NokrncRecord, String> SOFTWARERELEASEVERSION = createField("softwareReleaseVersion", org.jooq.impl.SQLDataType.CHAR(32), this, "");

    /**
     * The column <code>chrono.nokrnc.systemReleaseVersion</code>.
     */
    public final TableField<NokrncRecord, String> SYSTEMRELEASEVERSION = createField("systemReleaseVersion", org.jooq.impl.SQLDataType.CHAR(16), this, "");

    /**
     * The column <code>chrono.nokrnc.systemTitle</code>.
     */
    public final TableField<NokrncRecord, String> SYSTEMTITLE = createField("systemTitle", org.jooq.impl.SQLDataType.CHAR(64), this, "");

    /**
     * The column <code>chrono.nokrnc.nokrnc_remark</code>.
     */
    public final TableField<NokrncRecord, String> NOKRNC_REMARK = createField("nokrnc_remark", org.jooq.impl.SQLDataType.CLOB, this, "");

    /**
     * The column <code>chrono.nokrnc.EXTPROP1</code>.
     */
    public final TableField<NokrncRecord, Integer> EXTPROP1 = createField("EXTPROP1", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.nokrnc.EXTPROP2</code>.
     */
    public final TableField<NokrncRecord, String> EXTPROP2 = createField("EXTPROP2", org.jooq.impl.SQLDataType.CHAR(8), this, "");

    /**
     * Create a <code>chrono.nokrnc</code> table reference
     */
    public Nokrnc() {
        this(DSL.name("nokrnc"), null);
    }

    /**
     * Create an aliased <code>chrono.nokrnc</code> table reference
     */
    public Nokrnc(String alias) {
        this(DSL.name(alias), NOKRNC);
    }

    /**
     * Create an aliased <code>chrono.nokrnc</code> table reference
     */
    public Nokrnc(Name alias) {
        this(alias, NOKRNC);
    }

    private Nokrnc(Name alias, Table<NokrncRecord> aliased) {
        this(alias, aliased, null);
    }

    private Nokrnc(Name alias, Table<NokrncRecord> aliased, Field<?>[] parameters) {
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
        return Arrays.<Index>asList(Indexes.NOKRNC_HWMBSC_DATE, Indexes.NOKRNC_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<NokrncRecord> getPrimaryKey() {
        return Keys.KEY_NOKRNC_PRIMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<NokrncRecord>> getKeys() {
        return Arrays.<UniqueKey<NokrncRecord>>asList(Keys.KEY_NOKRNC_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Nokrnc as(String alias) {
        return new Nokrnc(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Nokrnc as(Name alias) {
        return new Nokrnc(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Nokrnc rename(String name) {
        return new Nokrnc(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Nokrnc rename(Name name) {
        return new Nokrnc(name, null);
    }
}
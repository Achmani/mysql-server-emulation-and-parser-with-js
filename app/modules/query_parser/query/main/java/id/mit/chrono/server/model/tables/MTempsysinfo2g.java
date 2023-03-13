/*
 * This file is generated by jOOQ.
*/
package id.mit.chrono.server.model.tables;


import id.mit.chrono.server.model.Chrono;
import id.mit.chrono.server.model.Keys;
import id.mit.chrono.server.model.tables.records.MTempsysinfo2gRecord;

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
public class MTempsysinfo2g extends TableImpl<MTempsysinfo2gRecord> {

    private static final long serialVersionUID = -1529424245;

    /**
     * The reference instance of <code>chrono.m_tempsysinfo2G</code>
     */
    public static final MTempsysinfo2g M_TEMPSYSINFO2G = new MTempsysinfo2g();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<MTempsysinfo2gRecord> getRecordType() {
        return MTempsysinfo2gRecord.class;
    }

    /**
     * The column <code>chrono.m_tempsysinfo2G.tempsysinfo2G_id</code>.
     */
    public final TableField<MTempsysinfo2gRecord, Long> TEMPSYSINFO2G_ID = createField("tempsysinfo2G_id", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>chrono.m_tempsysinfo2G.region</code>.
     */
    public final TableField<MTempsysinfo2gRecord, String> REGION = createField("region", org.jooq.impl.SQLDataType.VARCHAR(128), this, "");

    /**
     * The column <code>chrono.m_tempsysinfo2G.vendor</code>.
     */
    public final TableField<MTempsysinfo2gRecord, String> VENDOR = createField("vendor", org.jooq.impl.SQLDataType.VARCHAR(128), this, "");

    /**
     * The column <code>chrono.m_tempsysinfo2G.site_id</code>.
     */
    public final TableField<MTempsysinfo2gRecord, String> SITE_ID = createField("site_id", org.jooq.impl.SQLDataType.VARCHAR(128), this, "");

    /**
     * The column <code>chrono.m_tempsysinfo2G.ne_id</code>.
     */
    public final TableField<MTempsysinfo2gRecord, String> NE_ID = createField("ne_id", org.jooq.impl.SQLDataType.VARCHAR(128), this, "");

    /**
     * The column <code>chrono.m_tempsysinfo2G.enodeb_name</code>.
     */
    public final TableField<MTempsysinfo2gRecord, String> ENODEB_NAME = createField("enodeb_name", org.jooq.impl.SQLDataType.VARCHAR(128), this, "");

    /**
     * The column <code>chrono.m_tempsysinfo2G.cell_name</code>.
     */
    public final TableField<MTempsysinfo2gRecord, String> CELL_NAME = createField("cell_name", org.jooq.impl.SQLDataType.VARCHAR(128), this, "");

    /**
     * The column <code>chrono.m_tempsysinfo2G.lac_enodeb_ci</code>.
     */
    public final TableField<MTempsysinfo2gRecord, String> LAC_ENODEB_CI = createField("lac_enodeb_ci", org.jooq.impl.SQLDataType.VARCHAR(128), this, "");

    /**
     * The column <code>chrono.m_tempsysinfo2G.siteid_ci</code>.
     */
    public final TableField<MTempsysinfo2gRecord, String> SITEID_CI = createField("siteid_ci", org.jooq.impl.SQLDataType.VARCHAR(128), this, "");

    /**
     * The column <code>chrono.m_tempsysinfo2G.teknologi</code>.
     */
    public final TableField<MTempsysinfo2gRecord, String> TEKNOLOGI = createField("teknologi", org.jooq.impl.SQLDataType.VARCHAR(128), this, "");

    /**
     * The column <code>chrono.m_tempsysinfo2G.lac_enodeb</code>.
     */
    public final TableField<MTempsysinfo2gRecord, Integer> LAC_ENODEB = createField("lac_enodeb", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.m_tempsysinfo2G.ci</code>.
     */
    public final TableField<MTempsysinfo2gRecord, Integer> CI = createField("ci", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.m_tempsysinfo2G.sector</code>.
     */
    public final TableField<MTempsysinfo2gRecord, Integer> SECTOR = createField("sector", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.m_tempsysinfo2G.bts_type</code>.
     */
    public final TableField<MTempsysinfo2gRecord, String> BTS_TYPE = createField("bts_type", org.jooq.impl.SQLDataType.VARCHAR(128), this, "");

    /**
     * The column <code>chrono.m_tempsysinfo2G.band</code>.
     */
    public final TableField<MTempsysinfo2gRecord, String> BAND = createField("band", org.jooq.impl.SQLDataType.VARCHAR(128), this, "");

    /**
     * The column <code>chrono.m_tempsysinfo2G.longitude_fix</code>.
     */
    public final TableField<MTempsysinfo2gRecord, Double> LONGITUDE_FIX = createField("longitude_fix", org.jooq.impl.SQLDataType.FLOAT, this, "");

    /**
     * The column <code>chrono.m_tempsysinfo2G.latitude_fix</code>.
     */
    public final TableField<MTempsysinfo2gRecord, Double> LATITUDE_FIX = createField("latitude_fix", org.jooq.impl.SQLDataType.FLOAT, this, "");

    /**
     * The column <code>chrono.m_tempsysinfo2G.flag_on_air</code>.
     */
    public final TableField<MTempsysinfo2gRecord, String> FLAG_ON_AIR = createField("flag_on_air", org.jooq.impl.SQLDataType.VARCHAR(128), this, "");

    /**
     * The column <code>chrono.m_tempsysinfo2G.azimuth</code>.
     */
    public final TableField<MTempsysinfo2gRecord, Integer> AZIMUTH = createField("azimuth", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.m_tempsysinfo2G.electrical_tilt</code>.
     */
    public final TableField<MTempsysinfo2gRecord, Integer> ELECTRICAL_TILT = createField("electrical_tilt", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.m_tempsysinfo2G.mechanical_tilt</code>.
     */
    public final TableField<MTempsysinfo2gRecord, Integer> MECHANICAL_TILT = createField("mechanical_tilt", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.m_tempsysinfo2G.beamwidth_antenna</code>.
     */
    public final TableField<MTempsysinfo2gRecord, Integer> BEAMWIDTH_ANTENNA = createField("beamwidth_antenna", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.m_tempsysinfo2G.antenna_height</code>.
     */
    public final TableField<MTempsysinfo2gRecord, Integer> ANTENNA_HEIGHT = createField("antenna_height", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.m_tempsysinfo2G.antenna_type</code>.
     */
    public final TableField<MTempsysinfo2gRecord, String> ANTENNA_TYPE = createField("antenna_type", org.jooq.impl.SQLDataType.VARCHAR(128), this, "");

    /**
     * The column <code>chrono.m_tempsysinfo2G.ret_nonret</code>.
     */
    public final TableField<MTempsysinfo2gRecord, String> RET_NONRET = createField("ret_nonret", org.jooq.impl.SQLDataType.VARCHAR(128), this, "");

    /**
     * The column <code>chrono.m_tempsysinfo2G.tac</code>.
     */
    public final TableField<MTempsysinfo2gRecord, Integer> TAC = createField("tac", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.m_tempsysinfo2G.bsc_rnc</code>.
     */
    public final TableField<MTempsysinfo2gRecord, String> BSC_RNC = createField("bsc_rnc", org.jooq.impl.SQLDataType.VARCHAR(128), this, "");

    /**
     * Create a <code>chrono.m_tempsysinfo2G</code> table reference
     */
    public MTempsysinfo2g() {
        this(DSL.name("m_tempsysinfo2G"), null);
    }

    /**
     * Create an aliased <code>chrono.m_tempsysinfo2G</code> table reference
     */
    public MTempsysinfo2g(String alias) {
        this(DSL.name(alias), M_TEMPSYSINFO2G);
    }

    /**
     * Create an aliased <code>chrono.m_tempsysinfo2G</code> table reference
     */
    public MTempsysinfo2g(Name alias) {
        this(alias, M_TEMPSYSINFO2G);
    }

    private MTempsysinfo2g(Name alias, Table<MTempsysinfo2gRecord> aliased) {
        this(alias, aliased, null);
    }

    private MTempsysinfo2g(Name alias, Table<MTempsysinfo2gRecord> aliased, Field<?>[] parameters) {
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
    public UniqueKey<MTempsysinfo2gRecord> getPrimaryKey() {
        return Keys.KEY_M_TEMPSYSINFO2G_PRIMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<MTempsysinfo2gRecord>> getKeys() {
        return Arrays.<UniqueKey<MTempsysinfo2gRecord>>asList(Keys.KEY_M_TEMPSYSINFO2G_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MTempsysinfo2g as(String alias) {
        return new MTempsysinfo2g(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MTempsysinfo2g as(Name alias) {
        return new MTempsysinfo2g(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public MTempsysinfo2g rename(String name) {
        return new MTempsysinfo2g(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public MTempsysinfo2g rename(Name name) {
        return new MTempsysinfo2g(name, null);
    }
}

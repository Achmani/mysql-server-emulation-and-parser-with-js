/*
 * This file is generated by jOOQ.
*/
package id.mit.chrono.server.model.tables;


import id.mit.chrono.server.model.Chrono;
import id.mit.chrono.server.model.Keys;
import id.mit.chrono.server.model.tables.records.MTempsysinfo4gRecord;

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
public class MTempsysinfo4g extends TableImpl<MTempsysinfo4gRecord> {

    private static final long serialVersionUID = -1815450869;

    /**
     * The reference instance of <code>chrono.m_tempsysinfo4G</code>
     */
    public static final MTempsysinfo4g M_TEMPSYSINFO4G = new MTempsysinfo4g();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<MTempsysinfo4gRecord> getRecordType() {
        return MTempsysinfo4gRecord.class;
    }

    /**
     * The column <code>chrono.m_tempsysinfo4G.tempsysinfo4G_id</code>.
     */
    public final TableField<MTempsysinfo4gRecord, Long> TEMPSYSINFO4G_ID = createField("tempsysinfo4G_id", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>chrono.m_tempsysinfo4G.region</code>.
     */
    public final TableField<MTempsysinfo4gRecord, String> REGION = createField("region", org.jooq.impl.SQLDataType.VARCHAR(128), this, "");

    /**
     * The column <code>chrono.m_tempsysinfo4G.vendor</code>.
     */
    public final TableField<MTempsysinfo4gRecord, String> VENDOR = createField("vendor", org.jooq.impl.SQLDataType.VARCHAR(128), this, "");

    /**
     * The column <code>chrono.m_tempsysinfo4G.site_id</code>.
     */
    public final TableField<MTempsysinfo4gRecord, String> SITE_ID = createField("site_id", org.jooq.impl.SQLDataType.VARCHAR(128), this, "");

    /**
     * The column <code>chrono.m_tempsysinfo4G.ne_id</code>.
     */
    public final TableField<MTempsysinfo4gRecord, String> NE_ID = createField("ne_id", org.jooq.impl.SQLDataType.VARCHAR(128), this, "");

    /**
     * The column <code>chrono.m_tempsysinfo4G.enodeb_name</code>.
     */
    public final TableField<MTempsysinfo4gRecord, String> ENODEB_NAME = createField("enodeb_name", org.jooq.impl.SQLDataType.VARCHAR(128), this, "");

    /**
     * The column <code>chrono.m_tempsysinfo4G.cell_name</code>.
     */
    public final TableField<MTempsysinfo4gRecord, String> CELL_NAME = createField("cell_name", org.jooq.impl.SQLDataType.VARCHAR(128), this, "");

    /**
     * The column <code>chrono.m_tempsysinfo4G.lac_enodeb_ci</code>.
     */
    public final TableField<MTempsysinfo4gRecord, String> LAC_ENODEB_CI = createField("lac_enodeb_ci", org.jooq.impl.SQLDataType.VARCHAR(128), this, "");

    /**
     * The column <code>chrono.m_tempsysinfo4G.siteid_ci</code>.
     */
    public final TableField<MTempsysinfo4gRecord, String> SITEID_CI = createField("siteid_ci", org.jooq.impl.SQLDataType.VARCHAR(128), this, "");

    /**
     * The column <code>chrono.m_tempsysinfo4G.teknologi</code>.
     */
    public final TableField<MTempsysinfo4gRecord, String> TEKNOLOGI = createField("teknologi", org.jooq.impl.SQLDataType.VARCHAR(128), this, "");

    /**
     * The column <code>chrono.m_tempsysinfo4G.lac_enodeb</code>.
     */
    public final TableField<MTempsysinfo4gRecord, Integer> LAC_ENODEB = createField("lac_enodeb", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.m_tempsysinfo4G.ci</code>.
     */
    public final TableField<MTempsysinfo4gRecord, Integer> CI = createField("ci", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.m_tempsysinfo4G.sector</code>.
     */
    public final TableField<MTempsysinfo4gRecord, Integer> SECTOR = createField("sector", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.m_tempsysinfo4G.bts_type</code>.
     */
    public final TableField<MTempsysinfo4gRecord, String> BTS_TYPE = createField("bts_type", org.jooq.impl.SQLDataType.VARCHAR(128), this, "");

    /**
     * The column <code>chrono.m_tempsysinfo4G.band</code>.
     */
    public final TableField<MTempsysinfo4gRecord, String> BAND = createField("band", org.jooq.impl.SQLDataType.VARCHAR(128), this, "");

    /**
     * The column <code>chrono.m_tempsysinfo4G.longitude_fix</code>.
     */
    public final TableField<MTempsysinfo4gRecord, Double> LONGITUDE_FIX = createField("longitude_fix", org.jooq.impl.SQLDataType.FLOAT, this, "");

    /**
     * The column <code>chrono.m_tempsysinfo4G.latitude_fix</code>.
     */
    public final TableField<MTempsysinfo4gRecord, Double> LATITUDE_FIX = createField("latitude_fix", org.jooq.impl.SQLDataType.FLOAT, this, "");

    /**
     * The column <code>chrono.m_tempsysinfo4G.flag_on_air</code>.
     */
    public final TableField<MTempsysinfo4gRecord, String> FLAG_ON_AIR = createField("flag_on_air", org.jooq.impl.SQLDataType.VARCHAR(128), this, "");

    /**
     * The column <code>chrono.m_tempsysinfo4G.azimuth</code>.
     */
    public final TableField<MTempsysinfo4gRecord, Integer> AZIMUTH = createField("azimuth", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.m_tempsysinfo4G.electrical_tilt</code>.
     */
    public final TableField<MTempsysinfo4gRecord, Integer> ELECTRICAL_TILT = createField("electrical_tilt", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.m_tempsysinfo4G.mechanical_tilt</code>.
     */
    public final TableField<MTempsysinfo4gRecord, Integer> MECHANICAL_TILT = createField("mechanical_tilt", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.m_tempsysinfo4G.beamwidth_antenna</code>.
     */
    public final TableField<MTempsysinfo4gRecord, Integer> BEAMWIDTH_ANTENNA = createField("beamwidth_antenna", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.m_tempsysinfo4G.antenna_height</code>.
     */
    public final TableField<MTempsysinfo4gRecord, Integer> ANTENNA_HEIGHT = createField("antenna_height", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.m_tempsysinfo4G.antenna_type</code>.
     */
    public final TableField<MTempsysinfo4gRecord, String> ANTENNA_TYPE = createField("antenna_type", org.jooq.impl.SQLDataType.VARCHAR(128), this, "");

    /**
     * The column <code>chrono.m_tempsysinfo4G.ret_nonret</code>.
     */
    public final TableField<MTempsysinfo4gRecord, String> RET_NONRET = createField("ret_nonret", org.jooq.impl.SQLDataType.VARCHAR(128), this, "");

    /**
     * The column <code>chrono.m_tempsysinfo4G.tac</code>.
     */
    public final TableField<MTempsysinfo4gRecord, Integer> TAC = createField("tac", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.m_tempsysinfo4G.bsc_rnc</code>.
     */
    public final TableField<MTempsysinfo4gRecord, String> BSC_RNC = createField("bsc_rnc", org.jooq.impl.SQLDataType.VARCHAR(128), this, "");

    /**
     * Create a <code>chrono.m_tempsysinfo4G</code> table reference
     */
    public MTempsysinfo4g() {
        this(DSL.name("m_tempsysinfo4G"), null);
    }

    /**
     * Create an aliased <code>chrono.m_tempsysinfo4G</code> table reference
     */
    public MTempsysinfo4g(String alias) {
        this(DSL.name(alias), M_TEMPSYSINFO4G);
    }

    /**
     * Create an aliased <code>chrono.m_tempsysinfo4G</code> table reference
     */
    public MTempsysinfo4g(Name alias) {
        this(alias, M_TEMPSYSINFO4G);
    }

    private MTempsysinfo4g(Name alias, Table<MTempsysinfo4gRecord> aliased) {
        this(alias, aliased, null);
    }

    private MTempsysinfo4g(Name alias, Table<MTempsysinfo4gRecord> aliased, Field<?>[] parameters) {
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
    public UniqueKey<MTempsysinfo4gRecord> getPrimaryKey() {
        return Keys.KEY_M_TEMPSYSINFO4G_PRIMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<MTempsysinfo4gRecord>> getKeys() {
        return Arrays.<UniqueKey<MTempsysinfo4gRecord>>asList(Keys.KEY_M_TEMPSYSINFO4G_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MTempsysinfo4g as(String alias) {
        return new MTempsysinfo4g(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MTempsysinfo4g as(Name alias) {
        return new MTempsysinfo4g(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public MTempsysinfo4g rename(String name) {
        return new MTempsysinfo4g(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public MTempsysinfo4g rename(Name name) {
        return new MTempsysinfo4g(name, null);
    }
}

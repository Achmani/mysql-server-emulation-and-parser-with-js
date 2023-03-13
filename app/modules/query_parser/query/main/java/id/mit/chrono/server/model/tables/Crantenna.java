/*
 * This file is generated by jOOQ.
*/
package id.mit.chrono.server.model.tables;


import id.mit.chrono.server.model.Chrono;
import id.mit.chrono.server.model.Indexes;
import id.mit.chrono.server.model.Keys;
import id.mit.chrono.server.model.tables.records.CrantennaRecord;

import java.sql.Date;
import java.sql.Timestamp;
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
public class Crantenna extends TableImpl<CrantennaRecord> {

    private static final long serialVersionUID = 1371644047;

    /**
     * The reference instance of <code>chrono.crantenna</code>
     */
    public static final Crantenna CRANTENNA = new Crantenna();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<CrantennaRecord> getRecordType() {
        return CrantennaRecord.class;
    }

    /**
     * The column <code>chrono.crantenna.antenna_id</code>.
     */
    public final TableField<CrantennaRecord, Long> ANTENNA_ID = createField("antenna_id", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>chrono.crantenna.antenna_code</code>.
     */
    public final TableField<CrantennaRecord, String> ANTENNA_CODE = createField("antenna_code", org.jooq.impl.SQLDataType.VARCHAR(32), this, "");

    /**
     * The column <code>chrono.crantenna.antenna_site</code>.
     */
    public final TableField<CrantennaRecord, Integer> ANTENNA_SITE = createField("antenna_site", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.crantenna.antenna_siteoperatorasset</code>.
     */
    public final TableField<CrantennaRecord, Integer> ANTENNA_SITEOPERATORASSET = createField("antenna_siteoperatorasset", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.crantenna.antenna_company</code>.
     */
    public final TableField<CrantennaRecord, Integer> ANTENNA_COMPANY = createField("antenna_company", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.crantenna.antenna_antennatype</code>.
     */
    public final TableField<CrantennaRecord, Integer> ANTENNA_ANTENNATYPE = createField("antenna_antennatype", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.crantenna.antenna_brand</code>.
     */
    public final TableField<CrantennaRecord, Integer> ANTENNA_BRAND = createField("antenna_brand", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.crantenna.antenna_model</code>.
     */
    public final TableField<CrantennaRecord, String> ANTENNA_MODEL = createField("antenna_model", org.jooq.impl.SQLDataType.VARCHAR(128), this, "");

    /**
     * The column <code>chrono.crantenna.antenna_diameter</code>.
     */
    public final TableField<CrantennaRecord, Integer> ANTENNA_DIAMETER = createField("antenna_diameter", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.crantenna.antenna_beam</code>.
     */
    public final TableField<CrantennaRecord, Integer> ANTENNA_BEAM = createField("antenna_beam", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.crantenna.antenna_height</code>.
     */
    public final TableField<CrantennaRecord, Double> ANTENNA_HEIGHT = createField("antenna_height", org.jooq.impl.SQLDataType.DOUBLE, this, "");

    /**
     * The column <code>chrono.crantenna.antenna_buildingheight</code>.
     */
    public final TableField<CrantennaRecord, Double> ANTENNA_BUILDINGHEIGHT = createField("antenna_buildingheight", org.jooq.impl.SQLDataType.DOUBLE, this, "");

    /**
     * The column <code>chrono.crantenna.antenna_towerheight</code>.
     */
    public final TableField<CrantennaRecord, Double> ANTENNA_TOWERHEIGHT = createField("antenna_towerheight", org.jooq.impl.SQLDataType.DOUBLE, this, "");

    /**
     * The column <code>chrono.crantenna.antenna_direction</code>.
     */
    public final TableField<CrantennaRecord, Double> ANTENNA_DIRECTION = createField("antenna_direction", org.jooq.impl.SQLDataType.DOUBLE, this, "");

    /**
     * The column <code>chrono.crantenna.antenna_mtilting</code>.
     */
    public final TableField<CrantennaRecord, Integer> ANTENNA_MTILTING = createField("antenna_mtilting", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.crantenna.antenna_statusret</code>.
     */
    public final TableField<CrantennaRecord, String> ANTENNA_STATUSRET = createField("antenna_statusret", org.jooq.impl.SQLDataType.CHAR(16), this, "");

    /**
     * The column <code>chrono.crantenna.antenna_etilting</code>.
     */
    public final TableField<CrantennaRecord, Integer> ANTENNA_ETILTING = createField("antenna_etilting", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.crantenna.antenna_legposition</code>.
     */
    public final TableField<CrantennaRecord, String> ANTENNA_LEGPOSITION = createField("antenna_legposition", org.jooq.impl.SQLDataType.CHAR(16), this, "");

    /**
     * The column <code>chrono.crantenna.antenna_status</code>.
     */
    public final TableField<CrantennaRecord, String> ANTENNA_STATUS = createField("antenna_status", org.jooq.impl.SQLDataType.CHAR(64), this, "");

    /**
     * The column <code>chrono.crantenna.antenna_sectornumber</code>.
     */
    public final TableField<CrantennaRecord, Byte> ANTENNA_SECTORNUMBER = createField("antenna_sectornumber", org.jooq.impl.SQLDataType.TINYINT, this, "");

    /**
     * The column <code>chrono.crantenna.antenna_tilt</code>.
     */
    public final TableField<CrantennaRecord, Double> ANTENNA_TILT = createField("antenna_tilt", org.jooq.impl.SQLDataType.DOUBLE, this, "");

    /**
     * The column <code>chrono.crantenna.antenna_serialnumber</code>.
     */
    public final TableField<CrantennaRecord, String> ANTENNA_SERIALNUMBER = createField("antenna_serialnumber", org.jooq.impl.SQLDataType.CHAR(255), this, "");

    /**
     * The column <code>chrono.crantenna.antenna_barcodenumber</code>.
     */
    public final TableField<CrantennaRecord, String> ANTENNA_BARCODENUMBER = createField("antenna_barcodenumber", org.jooq.impl.SQLDataType.CHAR(255), this, "");

    /**
     * The column <code>chrono.crantenna.antenna_installdate</code>.
     */
    public final TableField<CrantennaRecord, Date> ANTENNA_INSTALLDATE = createField("antenna_installdate", org.jooq.impl.SQLDataType.DATE, this, "");

    /**
     * The column <code>chrono.crantenna.antenna_updated_date</code>.
     */
    public final TableField<CrantennaRecord, Timestamp> ANTENNA_UPDATED_DATE = createField("antenna_updated_date", org.jooq.impl.SQLDataType.TIMESTAMP, this, "");

    /**
     * The column <code>chrono.crantenna.antenna_updated_by</code>.
     */
    public final TableField<CrantennaRecord, String> ANTENNA_UPDATED_BY = createField("antenna_updated_by", org.jooq.impl.SQLDataType.CHAR(32), this, "");

    /**
     * The column <code>chrono.crantenna.antenna_row_active</code>.
     */
    public final TableField<CrantennaRecord, Byte> ANTENNA_ROW_ACTIVE = createField("antenna_row_active", org.jooq.impl.SQLDataType.TINYINT, this, "");

    /**
     * The column <code>chrono.crantenna.antenna_latitude</code>.
     */
    public final TableField<CrantennaRecord, Double> ANTENNA_LATITUDE = createField("antenna_latitude", org.jooq.impl.SQLDataType.DOUBLE, this, "");

    /**
     * The column <code>chrono.crantenna.antenna_longitude</code>.
     */
    public final TableField<CrantennaRecord, Double> ANTENNA_LONGITUDE = createField("antenna_longitude", org.jooq.impl.SQLDataType.DOUBLE, this, "");

    /**
     * Create a <code>chrono.crantenna</code> table reference
     */
    public Crantenna() {
        this(DSL.name("crantenna"), null);
    }

    /**
     * Create an aliased <code>chrono.crantenna</code> table reference
     */
    public Crantenna(String alias) {
        this(DSL.name(alias), CRANTENNA);
    }

    /**
     * Create an aliased <code>chrono.crantenna</code> table reference
     */
    public Crantenna(Name alias) {
        this(alias, CRANTENNA);
    }

    private Crantenna(Name alias, Table<CrantennaRecord> aliased) {
        this(alias, aliased, null);
    }

    private Crantenna(Name alias, Table<CrantennaRecord> aliased, Field<?>[] parameters) {
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
        return Arrays.<Index>asList(Indexes.CRANTENNA_ANTENNA_ANTENNATYPE, Indexes.CRANTENNA_ANTENNA_BRAND, Indexes.CRANTENNA_ANTENNA_COMPANY, Indexes.CRANTENNA_ANTENNA_SITE, Indexes.CRANTENNA_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<CrantennaRecord> getPrimaryKey() {
        return Keys.KEY_CRANTENNA_PRIMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<CrantennaRecord>> getKeys() {
        return Arrays.<UniqueKey<CrantennaRecord>>asList(Keys.KEY_CRANTENNA_PRIMARY, Keys.KEY_CRANTENNA_ANTENNA_SITEOPERATORASSET);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Crantenna as(String alias) {
        return new Crantenna(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Crantenna as(Name alias) {
        return new Crantenna(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Crantenna rename(String name) {
        return new Crantenna(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Crantenna rename(Name name) {
        return new Crantenna(name, null);
    }
}
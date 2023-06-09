/*
 * This file is generated by jOOQ.
*/
package id.mit.chrono.server.model.tables;


import id.mit.chrono.server.model.Chrono;
import id.mit.chrono.server.model.Keys;
import id.mit.chrono.server.model.tables.records.CrsiteOldRecord;

import java.sql.Date;
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
public class CrsiteOld extends TableImpl<CrsiteOldRecord> {

    private static final long serialVersionUID = 1653550319;

    /**
     * The reference instance of <code>chrono.crsite_old</code>
     */
    public static final CrsiteOld CRSITE_OLD = new CrsiteOld();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<CrsiteOldRecord> getRecordType() {
        return CrsiteOldRecord.class;
    }

    /**
     * The column <code>chrono.crsite_old.site_id</code>.
     */
    public final TableField<CrsiteOldRecord, Integer> SITE_ID = createField("site_id", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>chrono.crsite_old.site_code</code>.
     */
    public final TableField<CrsiteOldRecord, String> SITE_CODE = createField("site_code", org.jooq.impl.SQLDataType.CHAR(32), this, "");

    /**
     * The column <code>chrono.crsite_old.site_name</code>.
     */
    public final TableField<CrsiteOldRecord, String> SITE_NAME = createField("site_name", org.jooq.impl.SQLDataType.CHAR(255), this, "");

    /**
     * The column <code>chrono.crsite_old.site_sitearea</code>.
     */
    public final TableField<CrsiteOldRecord, Integer> SITE_SITEAREA = createField("site_sitearea", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.crsite_old.site_canonicalname</code>.
     */
    public final TableField<CrsiteOldRecord, String> SITE_CANONICALNAME = createField("site_canonicalname", org.jooq.impl.SQLDataType.CHAR(255), this, "");

    /**
     * The column <code>chrono.crsite_old.site_company</code>.
     */
    public final TableField<CrsiteOldRecord, Integer> SITE_COMPANY = createField("site_company", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.crsite_old.site_country</code>.
     */
    public final TableField<CrsiteOldRecord, Integer> SITE_COUNTRY = createField("site_country", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.crsite_old.site_countryname</code>.
     */
    public final TableField<CrsiteOldRecord, String> SITE_COUNTRYNAME = createField("site_countryname", org.jooq.impl.SQLDataType.CHAR(64), this, "");

    /**
     * The column <code>chrono.crsite_old.site_province</code>.
     */
    public final TableField<CrsiteOldRecord, Integer> SITE_PROVINCE = createField("site_province", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.crsite_old.site_provincename</code>.
     */
    public final TableField<CrsiteOldRecord, String> SITE_PROVINCENAME = createField("site_provincename", org.jooq.impl.SQLDataType.CHAR(64), this, "");

    /**
     * The column <code>chrono.crsite_old.site_city</code>.
     */
    public final TableField<CrsiteOldRecord, Integer> SITE_CITY = createField("site_city", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.crsite_old.site_cityname</code>.
     */
    public final TableField<CrsiteOldRecord, String> SITE_CITYNAME = createField("site_cityname", org.jooq.impl.SQLDataType.CHAR(64), this, "");

    /**
     * The column <code>chrono.crsite_old.site_subdistrict</code>.
     */
    public final TableField<CrsiteOldRecord, Integer> SITE_SUBDISTRICT = createField("site_subdistrict", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.crsite_old.site_subdistrictname</code>.
     */
    public final TableField<CrsiteOldRecord, String> SITE_SUBDISTRICTNAME = createField("site_subdistrictname", org.jooq.impl.SQLDataType.CHAR(64), this, "");

    /**
     * The column <code>chrono.crsite_old.site_village</code>.
     */
    public final TableField<CrsiteOldRecord, Integer> SITE_VILLAGE = createField("site_village", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.crsite_old.site_villagename</code>.
     */
    public final TableField<CrsiteOldRecord, String> SITE_VILLAGENAME = createField("site_villagename", org.jooq.impl.SQLDataType.CHAR(64), this, "");

    /**
     * The column <code>chrono.crsite_old.site_address</code>.
     */
    public final TableField<CrsiteOldRecord, String> SITE_ADDRESS = createField("site_address", org.jooq.impl.SQLDataType.CLOB, this, "");

    /**
     * The column <code>chrono.crsite_old.site_latitude</code>.
     */
    public final TableField<CrsiteOldRecord, Double> SITE_LATITUDE = createField("site_latitude", org.jooq.impl.SQLDataType.DOUBLE, this, "");

    /**
     * The column <code>chrono.crsite_old.site_longitude</code>.
     */
    public final TableField<CrsiteOldRecord, Double> SITE_LONGITUDE = createField("site_longitude", org.jooq.impl.SQLDataType.DOUBLE, this, "");

    /**
     * The column <code>chrono.crsite_old.site_sitetype</code>.
     */
    public final TableField<CrsiteOldRecord, Integer> SITE_SITETYPE = createField("site_sitetype", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.crsite_old.site_siteplace</code>.
     */
    public final TableField<CrsiteOldRecord, Integer> SITE_SITEPLACE = createField("site_siteplace", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.crsite_old.site_powerid</code>.
     */
    public final TableField<CrsiteOldRecord, String> SITE_POWERID = createField("site_powerid", org.jooq.impl.SQLDataType.CHAR(32), this, "");

    /**
     * The column <code>chrono.crsite_old.site_builddate</code>.
     */
    public final TableField<CrsiteOldRecord, Date> SITE_BUILDDATE = createField("site_builddate", org.jooq.impl.SQLDataType.DATE, this, "");

    /**
     * The column <code>chrono.crsite_old.site_landstatus</code>.
     */
    public final TableField<CrsiteOldRecord, Integer> SITE_LANDSTATUS = createField("site_landstatus", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.crsite_old.site_landcontractstart</code>.
     */
    public final TableField<CrsiteOldRecord, Date> SITE_LANDCONTRACTSTART = createField("site_landcontractstart", org.jooq.impl.SQLDataType.DATE, this, "");

    /**
     * The column <code>chrono.crsite_old.site_landcontractend</code>.
     */
    public final TableField<CrsiteOldRecord, Date> SITE_LANDCONTRACTEND = createField("site_landcontractend", org.jooq.impl.SQLDataType.DATE, this, "");

    /**
     * Create a <code>chrono.crsite_old</code> table reference
     */
    public CrsiteOld() {
        this(DSL.name("crsite_old"), null);
    }

    /**
     * Create an aliased <code>chrono.crsite_old</code> table reference
     */
    public CrsiteOld(String alias) {
        this(DSL.name(alias), CRSITE_OLD);
    }

    /**
     * Create an aliased <code>chrono.crsite_old</code> table reference
     */
    public CrsiteOld(Name alias) {
        this(alias, CRSITE_OLD);
    }

    private CrsiteOld(Name alias, Table<CrsiteOldRecord> aliased) {
        this(alias, aliased, null);
    }

    private CrsiteOld(Name alias, Table<CrsiteOldRecord> aliased, Field<?>[] parameters) {
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
    public UniqueKey<CrsiteOldRecord> getPrimaryKey() {
        return Keys.KEY_CRSITE_OLD_PRIMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<CrsiteOldRecord>> getKeys() {
        return Arrays.<UniqueKey<CrsiteOldRecord>>asList(Keys.KEY_CRSITE_OLD_PRIMARY, Keys.KEY_CRSITE_OLD_SITE_CODE_2);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CrsiteOld as(String alias) {
        return new CrsiteOld(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CrsiteOld as(Name alias) {
        return new CrsiteOld(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public CrsiteOld rename(String name) {
        return new CrsiteOld(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public CrsiteOld rename(Name name) {
        return new CrsiteOld(name, null);
    }
}

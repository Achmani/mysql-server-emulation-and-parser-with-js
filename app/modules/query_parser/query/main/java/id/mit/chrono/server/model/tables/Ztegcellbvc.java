/*
 * This file is generated by jOOQ.
*/
package id.mit.chrono.server.model.tables;


import id.mit.chrono.server.model.Chrono;
import id.mit.chrono.server.model.Keys;
import id.mit.chrono.server.model.tables.records.ZtegcellbvcRecord;

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
public class Ztegcellbvc extends TableImpl<ZtegcellbvcRecord> {

    private static final long serialVersionUID = 1813074296;

    /**
     * The reference instance of <code>chrono.ztegcellbvc</code>
     */
    public static final Ztegcellbvc ZTEGCELLBVC = new Ztegcellbvc();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<ZtegcellbvcRecord> getRecordType() {
        return ZtegcellbvcRecord.class;
    }

    /**
     * The column <code>chrono.ztegcellbvc.ztegcellbvc_id</code>.
     */
    public final TableField<ZtegcellbvcRecord, ULong> ZTEGCELLBVC_ID = createField("ztegcellbvc_id", org.jooq.impl.SQLDataType.BIGINTUNSIGNED.nullable(false), this, "");

    /**
     * The column <code>chrono.ztegcellbvc.ztegcellbvc_crcollectortaskfiles</code>.
     */
    public final TableField<ZtegcellbvcRecord, ULong> ZTEGCELLBVC_CRCOLLECTORTASKFILES = createField("ztegcellbvc_crcollectortaskfiles", org.jooq.impl.SQLDataType.BIGINTUNSIGNED, this, "");

    /**
     * The column <code>chrono.ztegcellbvc.ztegcellbvc_date</code>.
     */
    public final TableField<ZtegcellbvcRecord, UInteger> ZTEGCELLBVC_DATE = createField("ztegcellbvc_date", org.jooq.impl.SQLDataType.INTEGERUNSIGNED.nullable(false), this, "");

    /**
     * The column <code>chrono.ztegcellbvc.ztegcellbvc_datefrom</code>.
     */
    public final TableField<ZtegcellbvcRecord, UInteger> ZTEGCELLBVC_DATEFROM = createField("ztegcellbvc_datefrom", org.jooq.impl.SQLDataType.INTEGERUNSIGNED, this, "");

    /**
     * The column <code>chrono.ztegcellbvc.ztegcellbvc_ztebsc</code>.
     */
    public final TableField<ZtegcellbvcRecord, ULong> ZTEGCELLBVC_ZTEBSC = createField("ztegcellbvc_ztebsc", org.jooq.impl.SQLDataType.BIGINTUNSIGNED.nullable(false), this, "");

    /**
     * The column <code>chrono.ztegcellbvc.ztegcellbvc_ztebts</code>.
     */
    public final TableField<ZtegcellbvcRecord, ULong> ZTEGCELLBVC_ZTEBTS = createField("ztegcellbvc_ztebts", org.jooq.impl.SQLDataType.BIGINTUNSIGNED, this, "");

    /**
     * The column <code>chrono.ztegcellbvc.ztegcellbvc_ztegcell</code>.
     */
    public final TableField<ZtegcellbvcRecord, ULong> ZTEGCELLBVC_ZTEGCELL = createField("ztegcellbvc_ztegcell", org.jooq.impl.SQLDataType.BIGINTUNSIGNED, this, "");

    /**
     * The column <code>chrono.ztegcellbvc.MOI</code>.
     */
    public final TableField<ZtegcellbvcRecord, String> MOI = createField("MOI", org.jooq.impl.SQLDataType.CHAR(96), this, "");

    /**
     * The column <code>chrono.ztegcellbvc.SubNetwork</code>.
     */
    public final TableField<ZtegcellbvcRecord, String> SUBNETWORK = createField("SubNetwork", org.jooq.impl.SQLDataType.CHAR(6), this, "");

    /**
     * The column <code>chrono.ztegcellbvc.MEID</code>.
     */
    public final TableField<ZtegcellbvcRecord, String> MEID = createField("MEID", org.jooq.impl.SQLDataType.CHAR(6), this, "");

    /**
     * The column <code>chrono.ztegcellbvc.GBssFunction</code>.
     */
    public final TableField<ZtegcellbvcRecord, String> GBSSFUNCTION = createField("GBssFunction", org.jooq.impl.SQLDataType.CHAR(6), this, "");

    /**
     * The column <code>chrono.ztegcellbvc.GBtsSiteManager</code>.
     */
    public final TableField<ZtegcellbvcRecord, String> GBTSSITEMANAGER = createField("GBtsSiteManager", org.jooq.impl.SQLDataType.CHAR(6), this, "");

    /**
     * The column <code>chrono.ztegcellbvc.GGsmCell</code>.
     */
    public final TableField<ZtegcellbvcRecord, String> GGSMCELL = createField("GGsmCell", org.jooq.impl.SQLDataType.CHAR(6), this, "");

    /**
     * The column <code>chrono.ztegcellbvc.GBvc</code>.
     */
    public final TableField<ZtegcellbvcRecord, String> GBVC = createField("GBvc", org.jooq.impl.SQLDataType.CHAR(6), this, "");

    /**
     * The column <code>chrono.ztegcellbvc.BVCI</code>.
     */
    public final TableField<ZtegcellbvcRecord, String> BVCI = createField("BVCI", org.jooq.impl.SQLDataType.CHAR(6), this, "");

    /**
     * The column <code>chrono.ztegcellbvc.refGFrGbNse</code>.
     */
    public final TableField<ZtegcellbvcRecord, String> REFGFRGBNSE = createField("refGFrGbNse", org.jooq.impl.SQLDataType.CHAR(96), this, "");

    /**
     * The column <code>chrono.ztegcellbvc.refGIpGbNse</code>.
     */
    public final TableField<ZtegcellbvcRecord, String> REFGIPGBNSE = createField("refGIpGbNse", org.jooq.impl.SQLDataType.CHAR(96), this, "");

    /**
     * Create a <code>chrono.ztegcellbvc</code> table reference
     */
    public Ztegcellbvc() {
        this(DSL.name("ztegcellbvc"), null);
    }

    /**
     * Create an aliased <code>chrono.ztegcellbvc</code> table reference
     */
    public Ztegcellbvc(String alias) {
        this(DSL.name(alias), ZTEGCELLBVC);
    }

    /**
     * Create an aliased <code>chrono.ztegcellbvc</code> table reference
     */
    public Ztegcellbvc(Name alias) {
        this(alias, ZTEGCELLBVC);
    }

    private Ztegcellbvc(Name alias, Table<ZtegcellbvcRecord> aliased) {
        this(alias, aliased, null);
    }

    private Ztegcellbvc(Name alias, Table<ZtegcellbvcRecord> aliased, Field<?>[] parameters) {
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
    public UniqueKey<ZtegcellbvcRecord> getPrimaryKey() {
        return Keys.KEY_ZTEGCELLBVC_PRIMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<ZtegcellbvcRecord>> getKeys() {
        return Arrays.<UniqueKey<ZtegcellbvcRecord>>asList(Keys.KEY_ZTEGCELLBVC_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Ztegcellbvc as(String alias) {
        return new Ztegcellbvc(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Ztegcellbvc as(Name alias) {
        return new Ztegcellbvc(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Ztegcellbvc rename(String name) {
        return new Ztegcellbvc(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Ztegcellbvc rename(Name name) {
        return new Ztegcellbvc(name, null);
    }
}
/*
 * This file is generated by jOOQ.
*/
package id.mit.chrono.server.model.tables;


import id.mit.chrono.server.model.Chrono;
import id.mit.chrono.server.model.Keys;
import id.mit.chrono.server.model.tables.records.NokinventoryRecord;

import java.sql.Timestamp;
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
public class Nokinventory extends TableImpl<NokinventoryRecord> {

    private static final long serialVersionUID = 962472424;

    /**
     * The reference instance of <code>chrono.nokinventory</code>
     */
    public static final Nokinventory NOKINVENTORY = new Nokinventory();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<NokinventoryRecord> getRecordType() {
        return NokinventoryRecord.class;
    }

    /**
     * The column <code>chrono.nokinventory.nokinventory_id</code>.
     */
    public final TableField<NokinventoryRecord, UInteger> NOKINVENTORY_ID = createField("nokinventory_id", org.jooq.impl.SQLDataType.INTEGERUNSIGNED.nullable(false), this, "");

    /**
     * The column <code>chrono.nokinventory.nokinventory_date</code>.
     */
    public final TableField<NokinventoryRecord, Integer> NOKINVENTORY_DATE = createField("nokinventory_date", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>chrono.nokinventory.nokinventory_datatype</code>.
     */
    public final TableField<NokinventoryRecord, Integer> NOKINVENTORY_DATATYPE = createField("nokinventory_datatype", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.nokinventory.nokinventory_collectortaskfiles</code>.
     */
    public final TableField<NokinventoryRecord, Long> NOKINVENTORY_COLLECTORTASKFILES = createField("nokinventory_collectortaskfiles", org.jooq.impl.SQLDataType.BIGINT, this, "");

    /**
     * The column <code>chrono.nokinventory.nokinventory_vendor</code>.
     */
    public final TableField<NokinventoryRecord, Integer> NOKINVENTORY_VENDOR = createField("nokinventory_vendor", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.nokinventory.nokinventory_site</code>.
     */
    public final TableField<NokinventoryRecord, Integer> NOKINVENTORY_SITE = createField("nokinventory_site", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.nokinventory.nokinventory_siteidname</code>.
     */
    public final TableField<NokinventoryRecord, String> NOKINVENTORY_SITEIDNAME = createField("nokinventory_siteidname", org.jooq.impl.SQLDataType.CHAR(11), this, "");

    /**
     * The column <code>chrono.nokinventory.nokinventory_identificationcode</code>.
     */
    public final TableField<NokinventoryRecord, String> NOKINVENTORY_IDENTIFICATIONCODE = createField("nokinventory_identificationcode", org.jooq.impl.SQLDataType.CHAR(50), this, "");

    /**
     * The column <code>chrono.nokinventory.nokinventory_serialnumber</code>.
     */
    public final TableField<NokinventoryRecord, String> NOKINVENTORY_SERIALNUMBER = createField("nokinventory_serialnumber", org.jooq.impl.SQLDataType.CHAR(50), this, "");

    /**
     * The column <code>chrono.nokinventory.nokinventory_unitid</code>.
     */
    public final TableField<NokinventoryRecord, String> NOKINVENTORY_UNITID = createField("nokinventory_unitid", org.jooq.impl.SQLDataType.CHAR(20), this, "");

    /**
     * The column <code>chrono.nokinventory.nokinventory_unittype</code>.
     */
    public final TableField<NokinventoryRecord, String> NOKINVENTORY_UNITTYPE = createField("nokinventory_unittype", org.jooq.impl.SQLDataType.CHAR(100), this, "");

    /**
     * The column <code>chrono.nokinventory.nokinventory_nename</code>.
     */
    public final TableField<NokinventoryRecord, String> NOKINVENTORY_NENAME = createField("nokinventory_nename", org.jooq.impl.SQLDataType.CHAR(200), this, "");

    /**
     * The column <code>chrono.nokinventory.nokinventory_siteid</code>.
     */
    public final TableField<NokinventoryRecord, String> NOKINVENTORY_SITEID = createField("nokinventory_siteid", org.jooq.impl.SQLDataType.CHAR(50), this, "");

    /**
     * The column <code>chrono.nokinventory.nokinventory_locationname</code>.
     */
    public final TableField<NokinventoryRecord, String> NOKINVENTORY_LOCATIONNAME = createField("nokinventory_locationname", org.jooq.impl.SQLDataType.CLOB, this, "");

    /**
     * The column <code>chrono.nokinventory.nokinventory_systemtitle</code>.
     */
    public final TableField<NokinventoryRecord, String> NOKINVENTORY_SYSTEMTITLE = createField("nokinventory_systemtitle", org.jooq.impl.SQLDataType.CLOB, this, "");

    /**
     * The column <code>chrono.nokinventory.nokinventory_subrackspecifictype</code>.
     */
    public final TableField<NokinventoryRecord, String> NOKINVENTORY_SUBRACKSPECIFICTYPE = createField("nokinventory_subrackspecifictype", org.jooq.impl.SQLDataType.VARCHAR(100), this, "");

    /**
     * The column <code>chrono.nokinventory.nokinventory_sitecid</code>.
     */
    public final TableField<NokinventoryRecord, String> NOKINVENTORY_SITECID = createField("nokinventory_sitecid", org.jooq.impl.SQLDataType.CHAR(20), this, "");

    /**
     * The column <code>chrono.nokinventory.nokinventory_unittypeactual</code>.
     */
    public final TableField<NokinventoryRecord, String> NOKINVENTORY_UNITTYPEACTUAL = createField("nokinventory_unittypeactual", org.jooq.impl.SQLDataType.CHAR(50), this, "");

    /**
     * The column <code>chrono.nokinventory.nokinventory_unittypeexpected</code>.
     */
    public final TableField<NokinventoryRecord, String> NOKINVENTORY_UNITTYPEEXPECTED = createField("nokinventory_unittypeexpected", org.jooq.impl.SQLDataType.CHAR(50), this, "");

    /**
     * The column <code>chrono.nokinventory.nokinventory_state</code>.
     */
    public final TableField<NokinventoryRecord, String> NOKINVENTORY_STATE = createField("nokinventory_state", org.jooq.impl.SQLDataType.CHAR(50), this, "");

    /**
     * The column <code>chrono.nokinventory.nokinventory_userlabel</code>.
     */
    public final TableField<NokinventoryRecord, String> NOKINVENTORY_USERLABEL = createField("nokinventory_userlabel", org.jooq.impl.SQLDataType.CHAR(50), this, "");

    /**
     * The column <code>chrono.nokinventory.nokinventory_netype</code>.
     */
    public final TableField<NokinventoryRecord, String> NOKINVENTORY_NETYPE = createField("nokinventory_netype", org.jooq.impl.SQLDataType.CHAR(50), this, "");

    /**
     * The column <code>chrono.nokinventory.nokinventory_softwarereleaseversion</code>.
     */
    public final TableField<NokinventoryRecord, String> NOKINVENTORY_SOFTWARERELEASEVERSION = createField("nokinventory_softwarereleaseversion", org.jooq.impl.SQLDataType.CLOB, this, "");

    /**
     * The column <code>chrono.nokinventory.nokinventory_vendorname</code>.
     */
    public final TableField<NokinventoryRecord, String> NOKINVENTORY_VENDORNAME = createField("nokinventory_vendorname", org.jooq.impl.SQLDataType.CHAR(50), this, "");

    /**
     * The column <code>chrono.nokinventory.nokinventory_classname</code>.
     */
    public final TableField<NokinventoryRecord, String> NOKINVENTORY_CLASSNAME = createField("nokinventory_classname", org.jooq.impl.SQLDataType.CHAR(50), this, "");

    /**
     * The column <code>chrono.nokinventory.nokinventory_isfirst</code>.
     */
    public final TableField<NokinventoryRecord, Integer> NOKINVENTORY_ISFIRST = createField("nokinventory_isfirst", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.nokinventory.nokinventory_inserttime</code>.
     */
    public final TableField<NokinventoryRecord, Timestamp> NOKINVENTORY_INSERTTIME = createField("nokinventory_inserttime", org.jooq.impl.SQLDataType.TIMESTAMP, this, "");

    /**
     * Create a <code>chrono.nokinventory</code> table reference
     */
    public Nokinventory() {
        this(DSL.name("nokinventory"), null);
    }

    /**
     * Create an aliased <code>chrono.nokinventory</code> table reference
     */
    public Nokinventory(String alias) {
        this(DSL.name(alias), NOKINVENTORY);
    }

    /**
     * Create an aliased <code>chrono.nokinventory</code> table reference
     */
    public Nokinventory(Name alias) {
        this(alias, NOKINVENTORY);
    }

    private Nokinventory(Name alias, Table<NokinventoryRecord> aliased) {
        this(alias, aliased, null);
    }

    private Nokinventory(Name alias, Table<NokinventoryRecord> aliased, Field<?>[] parameters) {
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
    public UniqueKey<NokinventoryRecord> getPrimaryKey() {
        return Keys.KEY_NOKINVENTORY_PRIMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<NokinventoryRecord>> getKeys() {
        return Arrays.<UniqueKey<NokinventoryRecord>>asList(Keys.KEY_NOKINVENTORY_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Nokinventory as(String alias) {
        return new Nokinventory(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Nokinventory as(Name alias) {
        return new Nokinventory(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Nokinventory rename(String name) {
        return new Nokinventory(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Nokinventory rename(Name name) {
        return new Nokinventory(name, null);
    }
}

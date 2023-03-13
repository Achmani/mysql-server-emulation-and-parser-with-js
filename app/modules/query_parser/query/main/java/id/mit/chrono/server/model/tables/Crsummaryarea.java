/*
 * This file is generated by jOOQ.
*/
package id.mit.chrono.server.model.tables;


import id.mit.chrono.server.model.Chrono;
import id.mit.chrono.server.model.Keys;
import id.mit.chrono.server.model.tables.records.CrsummaryareaRecord;

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
public class Crsummaryarea extends TableImpl<CrsummaryareaRecord> {

    private static final long serialVersionUID = -1127481883;

    /**
     * The reference instance of <code>chrono.crsummaryarea</code>
     */
    public static final Crsummaryarea CRSUMMARYAREA = new Crsummaryarea();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<CrsummaryareaRecord> getRecordType() {
        return CrsummaryareaRecord.class;
    }

    /**
     * The column <code>chrono.crsummaryarea.summaryarea_id</code>.
     */
    public final TableField<CrsummaryareaRecord, ULong> SUMMARYAREA_ID = createField("summaryarea_id", org.jooq.impl.SQLDataType.BIGINTUNSIGNED.nullable(false), this, "");

    /**
     * The column <code>chrono.crsummaryarea.summaryarea_date</code>.
     */
    public final TableField<CrsummaryareaRecord, UInteger> SUMMARYAREA_DATE = createField("summaryarea_date", org.jooq.impl.SQLDataType.INTEGERUNSIGNED, this, "");

    /**
     * The column <code>chrono.crsummaryarea.summaryarea_updated</code>.
     */
    public final TableField<CrsummaryareaRecord, UInteger> SUMMARYAREA_UPDATED = createField("summaryarea_updated", org.jooq.impl.SQLDataType.INTEGERUNSIGNED, this, "");

    /**
     * The column <code>chrono.crsummaryarea.summaryarea_areaname</code>.
     */
    public final TableField<CrsummaryareaRecord, String> SUMMARYAREA_AREANAME = createField("summaryarea_areaname", org.jooq.impl.SQLDataType.CHAR(32), this, "");

    /**
     * The column <code>chrono.crsummaryarea.bts2gcount</code>.
     */
    public final TableField<CrsummaryareaRecord, Integer> BTS2GCOUNT = createField("bts2gcount", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.crsummaryarea.bts3gcount</code>.
     */
    public final TableField<CrsummaryareaRecord, Integer> BTS3GCOUNT = createField("bts3gcount", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.crsummaryarea.bts4gcount</code>.
     */
    public final TableField<CrsummaryareaRecord, Integer> BTS4GCOUNT = createField("bts4gcount", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.crsummaryarea.cell2gcount</code>.
     */
    public final TableField<CrsummaryareaRecord, Integer> CELL2GCOUNT = createField("cell2gcount", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.crsummaryarea.cell3gcount</code>.
     */
    public final TableField<CrsummaryareaRecord, Integer> CELL3GCOUNT = createField("cell3gcount", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.crsummaryarea.cell4gcount</code>.
     */
    public final TableField<CrsummaryareaRecord, Integer> CELL4GCOUNT = createField("cell4gcount", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.crsummaryarea.GSM900_count</code>.
     */
    public final TableField<CrsummaryareaRecord, Integer> GSM900_COUNT = createField("GSM900_count", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.crsummaryarea.DCS1800_count</code>.
     */
    public final TableField<CrsummaryareaRecord, Integer> DCS1800_COUNT = createField("DCS1800_count", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.crsummaryarea.GSM1800_count</code>.
     */
    public final TableField<CrsummaryareaRecord, Integer> GSM1800_COUNT = createField("GSM1800_count", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.crsummaryarea.UMTS800_count</code>.
     */
    public final TableField<CrsummaryareaRecord, Integer> UMTS800_COUNT = createField("UMTS800_count", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.crsummaryarea.UMTS850_count</code>.
     */
    public final TableField<CrsummaryareaRecord, Integer> UMTS850_COUNT = createField("UMTS850_count", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.crsummaryarea.UMTS900_count</code>.
     */
    public final TableField<CrsummaryareaRecord, Integer> UMTS900_COUNT = createField("UMTS900_count", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.crsummaryarea.UMTS1800_count</code>.
     */
    public final TableField<CrsummaryareaRecord, Integer> UMTS1800_COUNT = createField("UMTS1800_count", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.crsummaryarea.UMTS1900_count</code>.
     */
    public final TableField<CrsummaryareaRecord, Integer> UMTS1900_COUNT = createField("UMTS1900_count", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.crsummaryarea.UMTS2100_count</code>.
     */
    public final TableField<CrsummaryareaRecord, Integer> UMTS2100_COUNT = createField("UMTS2100_count", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.crsummaryarea.UMTS2600_count</code>.
     */
    public final TableField<CrsummaryareaRecord, Integer> UMTS2600_COUNT = createField("UMTS2600_count", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.crsummaryarea.UMTS1700_count</code>.
     */
    public final TableField<CrsummaryareaRecord, Integer> UMTS1700_COUNT = createField("UMTS1700_count", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.crsummaryarea.UMTS1500_count</code>.
     */
    public final TableField<CrsummaryareaRecord, Integer> UMTS1500_COUNT = createField("UMTS1500_count", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.crsummaryarea.LTETDD2300_count</code>.
     */
    public final TableField<CrsummaryareaRecord, Integer> LTETDD2300_COUNT = createField("LTETDD2300_count", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.crsummaryarea.LTEFDD900_count</code>.
     */
    public final TableField<CrsummaryareaRecord, Integer> LTEFDD900_COUNT = createField("LTEFDD900_count", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.crsummaryarea.LTEFDD1800_count</code>.
     */
    public final TableField<CrsummaryareaRecord, Integer> LTEFDD1800_COUNT = createField("LTEFDD1800_count", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.crsummaryarea.LTEFDD2100_count</code>.
     */
    public final TableField<CrsummaryareaRecord, Integer> LTEFDD2100_COUNT = createField("LTEFDD2100_count", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * Create a <code>chrono.crsummaryarea</code> table reference
     */
    public Crsummaryarea() {
        this(DSL.name("crsummaryarea"), null);
    }

    /**
     * Create an aliased <code>chrono.crsummaryarea</code> table reference
     */
    public Crsummaryarea(String alias) {
        this(DSL.name(alias), CRSUMMARYAREA);
    }

    /**
     * Create an aliased <code>chrono.crsummaryarea</code> table reference
     */
    public Crsummaryarea(Name alias) {
        this(alias, CRSUMMARYAREA);
    }

    private Crsummaryarea(Name alias, Table<CrsummaryareaRecord> aliased) {
        this(alias, aliased, null);
    }

    private Crsummaryarea(Name alias, Table<CrsummaryareaRecord> aliased, Field<?>[] parameters) {
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
    public UniqueKey<CrsummaryareaRecord> getPrimaryKey() {
        return Keys.KEY_CRSUMMARYAREA_PRIMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<CrsummaryareaRecord>> getKeys() {
        return Arrays.<UniqueKey<CrsummaryareaRecord>>asList(Keys.KEY_CRSUMMARYAREA_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Crsummaryarea as(String alias) {
        return new Crsummaryarea(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Crsummaryarea as(Name alias) {
        return new Crsummaryarea(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Crsummaryarea rename(String name) {
        return new Crsummaryarea(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Crsummaryarea rename(Name name) {
        return new Crsummaryarea(name, null);
    }
}

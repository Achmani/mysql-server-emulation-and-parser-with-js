/*
 * This file is generated by jOOQ.
*/
package id.mit.chrono.server.model.tables;


import id.mit.chrono.server.model.Chrono;
import id.mit.chrono.server.model.Keys;
import id.mit.chrono.server.model.tables.records.CrsummaryossRecord;

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
public class Crsummaryoss extends TableImpl<CrsummaryossRecord> {

    private static final long serialVersionUID = 537818986;

    /**
     * The reference instance of <code>chrono.crsummaryoss</code>
     */
    public static final Crsummaryoss CRSUMMARYOSS = new Crsummaryoss();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<CrsummaryossRecord> getRecordType() {
        return CrsummaryossRecord.class;
    }

    /**
     * The column <code>chrono.crsummaryoss.summaryoss_id</code>.
     */
    public final TableField<CrsummaryossRecord, ULong> SUMMARYOSS_ID = createField("summaryoss_id", org.jooq.impl.SQLDataType.BIGINTUNSIGNED.nullable(false), this, "");

    /**
     * The column <code>chrono.crsummaryoss.summaryoss_date</code>.
     */
    public final TableField<CrsummaryossRecord, UInteger> SUMMARYOSS_DATE = createField("summaryoss_date", org.jooq.impl.SQLDataType.INTEGERUNSIGNED, this, "");

    /**
     * The column <code>chrono.crsummaryoss.summaryoss_updated</code>.
     */
    public final TableField<CrsummaryossRecord, UInteger> SUMMARYOSS_UPDATED = createField("summaryoss_updated", org.jooq.impl.SQLDataType.INTEGERUNSIGNED, this, "");

    /**
     * The column <code>chrono.crsummaryoss.summaryoss_datasourceid</code>.
     */
    public final TableField<CrsummaryossRecord, Integer> SUMMARYOSS_DATASOURCEID = createField("summaryoss_datasourceid", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.crsummaryoss.bts2gcount</code>.
     */
    public final TableField<CrsummaryossRecord, Integer> BTS2GCOUNT = createField("bts2gcount", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.crsummaryoss.bts3gcount</code>.
     */
    public final TableField<CrsummaryossRecord, Integer> BTS3GCOUNT = createField("bts3gcount", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.crsummaryoss.bts4gcount</code>.
     */
    public final TableField<CrsummaryossRecord, Integer> BTS4GCOUNT = createField("bts4gcount", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.crsummaryoss.cell2gcount</code>.
     */
    public final TableField<CrsummaryossRecord, Integer> CELL2GCOUNT = createField("cell2gcount", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.crsummaryoss.cell3gcount</code>.
     */
    public final TableField<CrsummaryossRecord, Integer> CELL3GCOUNT = createField("cell3gcount", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.crsummaryoss.cell4gcount</code>.
     */
    public final TableField<CrsummaryossRecord, Integer> CELL4GCOUNT = createField("cell4gcount", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.crsummaryoss.GSM900_count</code>.
     */
    public final TableField<CrsummaryossRecord, Integer> GSM900_COUNT = createField("GSM900_count", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.crsummaryoss.DCS1800_count</code>.
     */
    public final TableField<CrsummaryossRecord, Integer> DCS1800_COUNT = createField("DCS1800_count", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.crsummaryoss.GSM1800_count</code>.
     */
    public final TableField<CrsummaryossRecord, Integer> GSM1800_COUNT = createField("GSM1800_count", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.crsummaryoss.UMTS800_count</code>.
     */
    public final TableField<CrsummaryossRecord, Integer> UMTS800_COUNT = createField("UMTS800_count", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.crsummaryoss.UMTS850_count</code>.
     */
    public final TableField<CrsummaryossRecord, Integer> UMTS850_COUNT = createField("UMTS850_count", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.crsummaryoss.UMTS900_count</code>.
     */
    public final TableField<CrsummaryossRecord, Integer> UMTS900_COUNT = createField("UMTS900_count", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.crsummaryoss.UMTS1800_count</code>.
     */
    public final TableField<CrsummaryossRecord, Integer> UMTS1800_COUNT = createField("UMTS1800_count", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.crsummaryoss.UMTS1900_count</code>.
     */
    public final TableField<CrsummaryossRecord, Integer> UMTS1900_COUNT = createField("UMTS1900_count", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.crsummaryoss.UMTS2100_count</code>.
     */
    public final TableField<CrsummaryossRecord, Integer> UMTS2100_COUNT = createField("UMTS2100_count", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.crsummaryoss.UMTS2600_count</code>.
     */
    public final TableField<CrsummaryossRecord, Integer> UMTS2600_COUNT = createField("UMTS2600_count", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.crsummaryoss.UMTS1700_count</code>.
     */
    public final TableField<CrsummaryossRecord, Integer> UMTS1700_COUNT = createField("UMTS1700_count", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.crsummaryoss.UMTS1500_count</code>.
     */
    public final TableField<CrsummaryossRecord, Integer> UMTS1500_COUNT = createField("UMTS1500_count", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.crsummaryoss.LTETDD2300_count</code>.
     */
    public final TableField<CrsummaryossRecord, Integer> LTETDD2300_COUNT = createField("LTETDD2300_count", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.crsummaryoss.LTEFDD900_count</code>.
     */
    public final TableField<CrsummaryossRecord, Integer> LTEFDD900_COUNT = createField("LTEFDD900_count", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.crsummaryoss.LTEFDD1800_count</code>.
     */
    public final TableField<CrsummaryossRecord, Integer> LTEFDD1800_COUNT = createField("LTEFDD1800_count", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.crsummaryoss.LTEFDD2100_count</code>.
     */
    public final TableField<CrsummaryossRecord, Integer> LTEFDD2100_COUNT = createField("LTEFDD2100_count", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * Create a <code>chrono.crsummaryoss</code> table reference
     */
    public Crsummaryoss() {
        this(DSL.name("crsummaryoss"), null);
    }

    /**
     * Create an aliased <code>chrono.crsummaryoss</code> table reference
     */
    public Crsummaryoss(String alias) {
        this(DSL.name(alias), CRSUMMARYOSS);
    }

    /**
     * Create an aliased <code>chrono.crsummaryoss</code> table reference
     */
    public Crsummaryoss(Name alias) {
        this(alias, CRSUMMARYOSS);
    }

    private Crsummaryoss(Name alias, Table<CrsummaryossRecord> aliased) {
        this(alias, aliased, null);
    }

    private Crsummaryoss(Name alias, Table<CrsummaryossRecord> aliased, Field<?>[] parameters) {
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
    public UniqueKey<CrsummaryossRecord> getPrimaryKey() {
        return Keys.KEY_CRSUMMARYOSS_PRIMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<CrsummaryossRecord>> getKeys() {
        return Arrays.<UniqueKey<CrsummaryossRecord>>asList(Keys.KEY_CRSUMMARYOSS_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Crsummaryoss as(String alias) {
        return new Crsummaryoss(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Crsummaryoss as(Name alias) {
        return new Crsummaryoss(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Crsummaryoss rename(String name) {
        return new Crsummaryoss(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Crsummaryoss rename(Name name) {
        return new Crsummaryoss(name, null);
    }
}
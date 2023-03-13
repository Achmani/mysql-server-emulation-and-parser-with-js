/*
 * This file is generated by jOOQ.
*/
package id.mit.chrono.server.model.tables;


import id.mit.chrono.server.model.Chrono;
import id.mit.chrono.server.model.Keys;
import id.mit.chrono.server.model.tables.records.CrsummarynationRecord;

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
public class Crsummarynation extends TableImpl<CrsummarynationRecord> {

    private static final long serialVersionUID = 1058759609;

    /**
     * The reference instance of <code>chrono.crsummarynation</code>
     */
    public static final Crsummarynation CRSUMMARYNATION = new Crsummarynation();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<CrsummarynationRecord> getRecordType() {
        return CrsummarynationRecord.class;
    }

    /**
     * The column <code>chrono.crsummarynation.summarynation_id</code>.
     */
    public final TableField<CrsummarynationRecord, ULong> SUMMARYNATION_ID = createField("summarynation_id", org.jooq.impl.SQLDataType.BIGINTUNSIGNED.nullable(false), this, "");

    /**
     * The column <code>chrono.crsummarynation.summarynation_date</code>.
     */
    public final TableField<CrsummarynationRecord, UInteger> SUMMARYNATION_DATE = createField("summarynation_date", org.jooq.impl.SQLDataType.INTEGERUNSIGNED, this, "");

    /**
     * The column <code>chrono.crsummarynation.summarynation_updated</code>.
     */
    public final TableField<CrsummarynationRecord, UInteger> SUMMARYNATION_UPDATED = createField("summarynation_updated", org.jooq.impl.SQLDataType.INTEGERUNSIGNED, this, "");

    /**
     * The column <code>chrono.crsummarynation.bts2gcount</code>.
     */
    public final TableField<CrsummarynationRecord, Integer> BTS2GCOUNT = createField("bts2gcount", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.crsummarynation.bts3gcount</code>.
     */
    public final TableField<CrsummarynationRecord, Integer> BTS3GCOUNT = createField("bts3gcount", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.crsummarynation.bts4gcount</code>.
     */
    public final TableField<CrsummarynationRecord, Integer> BTS4GCOUNT = createField("bts4gcount", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.crsummarynation.cell2gcount</code>.
     */
    public final TableField<CrsummarynationRecord, Integer> CELL2GCOUNT = createField("cell2gcount", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.crsummarynation.cell3gcount</code>.
     */
    public final TableField<CrsummarynationRecord, Integer> CELL3GCOUNT = createField("cell3gcount", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.crsummarynation.cell4gcount</code>.
     */
    public final TableField<CrsummarynationRecord, Integer> CELL4GCOUNT = createField("cell4gcount", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.crsummarynation.GSM900_count</code>.
     */
    public final TableField<CrsummarynationRecord, Integer> GSM900_COUNT = createField("GSM900_count", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.crsummarynation.DCS1800_count</code>.
     */
    public final TableField<CrsummarynationRecord, Integer> DCS1800_COUNT = createField("DCS1800_count", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.crsummarynation.GSM1800_count</code>.
     */
    public final TableField<CrsummarynationRecord, Integer> GSM1800_COUNT = createField("GSM1800_count", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.crsummarynation.UMTS800_count</code>.
     */
    public final TableField<CrsummarynationRecord, Integer> UMTS800_COUNT = createField("UMTS800_count", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.crsummarynation.UMTS850_count</code>.
     */
    public final TableField<CrsummarynationRecord, Integer> UMTS850_COUNT = createField("UMTS850_count", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.crsummarynation.UMTS900_count</code>.
     */
    public final TableField<CrsummarynationRecord, Integer> UMTS900_COUNT = createField("UMTS900_count", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.crsummarynation.UMTS1800_count</code>.
     */
    public final TableField<CrsummarynationRecord, Integer> UMTS1800_COUNT = createField("UMTS1800_count", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.crsummarynation.UMTS1900_count</code>.
     */
    public final TableField<CrsummarynationRecord, Integer> UMTS1900_COUNT = createField("UMTS1900_count", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.crsummarynation.UMTS2100_count</code>.
     */
    public final TableField<CrsummarynationRecord, Integer> UMTS2100_COUNT = createField("UMTS2100_count", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.crsummarynation.UMTS2600_count</code>.
     */
    public final TableField<CrsummarynationRecord, Integer> UMTS2600_COUNT = createField("UMTS2600_count", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.crsummarynation.UMTS1700_count</code>.
     */
    public final TableField<CrsummarynationRecord, Integer> UMTS1700_COUNT = createField("UMTS1700_count", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.crsummarynation.UMTS1500_count</code>.
     */
    public final TableField<CrsummarynationRecord, Integer> UMTS1500_COUNT = createField("UMTS1500_count", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.crsummarynation.LTETDD2300_count</code>.
     */
    public final TableField<CrsummarynationRecord, Integer> LTETDD2300_COUNT = createField("LTETDD2300_count", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.crsummarynation.LTEFDD900_count</code>.
     */
    public final TableField<CrsummarynationRecord, Integer> LTEFDD900_COUNT = createField("LTEFDD900_count", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.crsummarynation.LTEFDD1800_count</code>.
     */
    public final TableField<CrsummarynationRecord, Integer> LTEFDD1800_COUNT = createField("LTEFDD1800_count", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.crsummarynation.LTEFDD2100_count</code>.
     */
    public final TableField<CrsummarynationRecord, Integer> LTEFDD2100_COUNT = createField("LTEFDD2100_count", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * Create a <code>chrono.crsummarynation</code> table reference
     */
    public Crsummarynation() {
        this(DSL.name("crsummarynation"), null);
    }

    /**
     * Create an aliased <code>chrono.crsummarynation</code> table reference
     */
    public Crsummarynation(String alias) {
        this(DSL.name(alias), CRSUMMARYNATION);
    }

    /**
     * Create an aliased <code>chrono.crsummarynation</code> table reference
     */
    public Crsummarynation(Name alias) {
        this(alias, CRSUMMARYNATION);
    }

    private Crsummarynation(Name alias, Table<CrsummarynationRecord> aliased) {
        this(alias, aliased, null);
    }

    private Crsummarynation(Name alias, Table<CrsummarynationRecord> aliased, Field<?>[] parameters) {
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
    public UniqueKey<CrsummarynationRecord> getPrimaryKey() {
        return Keys.KEY_CRSUMMARYNATION_PRIMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<CrsummarynationRecord>> getKeys() {
        return Arrays.<UniqueKey<CrsummarynationRecord>>asList(Keys.KEY_CRSUMMARYNATION_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Crsummarynation as(String alias) {
        return new Crsummarynation(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Crsummarynation as(Name alias) {
        return new Crsummarynation(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Crsummarynation rename(String name) {
        return new Crsummarynation(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Crsummarynation rename(Name name) {
        return new Crsummarynation(name, null);
    }
}

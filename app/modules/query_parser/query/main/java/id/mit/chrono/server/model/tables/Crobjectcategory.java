/*
 * This file is generated by jOOQ.
*/
package id.mit.chrono.server.model.tables;


import id.mit.chrono.server.model.Chrono;
import id.mit.chrono.server.model.Keys;
import id.mit.chrono.server.model.tables.records.CrobjectcategoryRecord;

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
public class Crobjectcategory extends TableImpl<CrobjectcategoryRecord> {

    private static final long serialVersionUID = 213316359;

    /**
     * The reference instance of <code>chrono.crobjectcategory</code>
     */
    public static final Crobjectcategory CROBJECTCATEGORY = new Crobjectcategory();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<CrobjectcategoryRecord> getRecordType() {
        return CrobjectcategoryRecord.class;
    }

    /**
     * The column <code>chrono.crobjectcategory.crobjectcategory_id</code>.
     */
    public final TableField<CrobjectcategoryRecord, UInteger> CROBJECTCATEGORY_ID = createField("crobjectcategory_id", org.jooq.impl.SQLDataType.INTEGERUNSIGNED.nullable(false), this, "");

    /**
     * The column <code>chrono.crobjectcategory.crobjectcategory_code</code>.
     */
    public final TableField<CrobjectcategoryRecord, String> CROBJECTCATEGORY_CODE = createField("crobjectcategory_code", org.jooq.impl.SQLDataType.CHAR(32), this, "");

    /**
     * The column <code>chrono.crobjectcategory.crobjectcategory_name</code>.
     */
    public final TableField<CrobjectcategoryRecord, String> CROBJECTCATEGORY_NAME = createField("crobjectcategory_name", org.jooq.impl.SQLDataType.CHAR(64), this, "");

    /**
     * Create a <code>chrono.crobjectcategory</code> table reference
     */
    public Crobjectcategory() {
        this(DSL.name("crobjectcategory"), null);
    }

    /**
     * Create an aliased <code>chrono.crobjectcategory</code> table reference
     */
    public Crobjectcategory(String alias) {
        this(DSL.name(alias), CROBJECTCATEGORY);
    }

    /**
     * Create an aliased <code>chrono.crobjectcategory</code> table reference
     */
    public Crobjectcategory(Name alias) {
        this(alias, CROBJECTCATEGORY);
    }

    private Crobjectcategory(Name alias, Table<CrobjectcategoryRecord> aliased) {
        this(alias, aliased, null);
    }

    private Crobjectcategory(Name alias, Table<CrobjectcategoryRecord> aliased, Field<?>[] parameters) {
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
    public UniqueKey<CrobjectcategoryRecord> getPrimaryKey() {
        return Keys.KEY_CROBJECTCATEGORY_PRIMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<CrobjectcategoryRecord>> getKeys() {
        return Arrays.<UniqueKey<CrobjectcategoryRecord>>asList(Keys.KEY_CROBJECTCATEGORY_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Crobjectcategory as(String alias) {
        return new Crobjectcategory(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Crobjectcategory as(Name alias) {
        return new Crobjectcategory(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Crobjectcategory rename(String name) {
        return new Crobjectcategory(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Crobjectcategory rename(Name name) {
        return new Crobjectcategory(name, null);
    }
}

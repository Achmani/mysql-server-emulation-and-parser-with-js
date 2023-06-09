/*
 * This file is generated by jOOQ.
*/
package id.mit.chrono.server.model.tables;


import id.mit.chrono.server.model.Chrono;
import id.mit.chrono.server.model.Keys;
import id.mit.chrono.server.model.tables.records.Crgeomap3Record;

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
public class Crgeomap3 extends TableImpl<Crgeomap3Record> {

    private static final long serialVersionUID = -1519600506;

    /**
     * The reference instance of <code>chrono.crgeomap3</code>
     */
    public static final Crgeomap3 CRGEOMAP3 = new Crgeomap3();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<Crgeomap3Record> getRecordType() {
        return Crgeomap3Record.class;
    }

    /**
     * The column <code>chrono.crgeomap3.geomap_id</code>.
     */
    public final TableField<Crgeomap3Record, Integer> GEOMAP_ID = createField("geomap_id", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * @deprecated Unknown data type. Please define an explicit {@link org.jooq.Binding} to specify how this type should be handled. Deprecation can be turned off using <deprecationOnUnknownTypes/> in your code generator configuration.
     */
    @java.lang.Deprecated
    public final TableField<Crgeomap3Record, Object> GEOMAP_DATA = createField("geomap_data", org.jooq.impl.DefaultDataType.getDefaultDataType("geometry"), this, "");

    /**
     * @deprecated Unknown data type. Please define an explicit {@link org.jooq.Binding} to specify how this type should be handled. Deprecation can be turned off using <deprecationOnUnknownTypes/> in your code generator configuration.
     */
    @java.lang.Deprecated
    public final TableField<Crgeomap3Record, Object> GEOMAP_CENTROID = createField("geomap_centroid", org.jooq.impl.DefaultDataType.getDefaultDataType("geometry"), this, "");

    /**
     * @deprecated Unknown data type. Please define an explicit {@link org.jooq.Binding} to specify how this type should be handled. Deprecation can be turned off using <deprecationOnUnknownTypes/> in your code generator configuration.
     */
    @java.lang.Deprecated
    public final TableField<Crgeomap3Record, Object> GEOMAP_MIN = createField("geomap_min", org.jooq.impl.DefaultDataType.getDefaultDataType("geometry"), this, "");

    /**
     * @deprecated Unknown data type. Please define an explicit {@link org.jooq.Binding} to specify how this type should be handled. Deprecation can be turned off using <deprecationOnUnknownTypes/> in your code generator configuration.
     */
    @java.lang.Deprecated
    public final TableField<Crgeomap3Record, Object> GEOMAP_MAX = createField("geomap_max", org.jooq.impl.DefaultDataType.getDefaultDataType("geometry"), this, "");

    /**
     * The column <code>chrono.crgeomap3.gid_0</code>.
     */
    public final TableField<Crgeomap3Record, String> GID_0 = createField("gid_0", org.jooq.impl.SQLDataType.VARCHAR(80), this, "");

    /**
     * The column <code>chrono.crgeomap3.geomap_attr0</code>.
     */
    public final TableField<Crgeomap3Record, String> GEOMAP_ATTR0 = createField("geomap_attr0", org.jooq.impl.SQLDataType.VARCHAR(80), this, "");

    /**
     * The column <code>chrono.crgeomap3.gid_1</code>.
     */
    public final TableField<Crgeomap3Record, String> GID_1 = createField("gid_1", org.jooq.impl.SQLDataType.VARCHAR(80), this, "");

    /**
     * The column <code>chrono.crgeomap3.geomap_attr1</code>.
     */
    public final TableField<Crgeomap3Record, String> GEOMAP_ATTR1 = createField("geomap_attr1", org.jooq.impl.SQLDataType.VARCHAR(80), this, "");

    /**
     * The column <code>chrono.crgeomap3.gid_2</code>.
     */
    public final TableField<Crgeomap3Record, String> GID_2 = createField("gid_2", org.jooq.impl.SQLDataType.VARCHAR(80), this, "");

    /**
     * The column <code>chrono.crgeomap3.geomap_attr2</code>.
     */
    public final TableField<Crgeomap3Record, String> GEOMAP_ATTR2 = createField("geomap_attr2", org.jooq.impl.SQLDataType.VARCHAR(80), this, "");

    /**
     * The column <code>chrono.crgeomap3.gid_3</code>.
     */
    public final TableField<Crgeomap3Record, String> GID_3 = createField("gid_3", org.jooq.impl.SQLDataType.VARCHAR(80), this, "");

    /**
     * The column <code>chrono.crgeomap3.geomap_attr3</code>.
     */
    public final TableField<Crgeomap3Record, String> GEOMAP_ATTR3 = createField("geomap_attr3", org.jooq.impl.SQLDataType.VARCHAR(80), this, "");

    /**
     * The column <code>chrono.crgeomap3.gid_4</code>.
     */
    public final TableField<Crgeomap3Record, String> GID_4 = createField("gid_4", org.jooq.impl.SQLDataType.VARCHAR(80), this, "");

    /**
     * The column <code>chrono.crgeomap3.geomap_attr4</code>.
     */
    public final TableField<Crgeomap3Record, String> GEOMAP_ATTR4 = createField("geomap_attr4", org.jooq.impl.SQLDataType.VARCHAR(80), this, "");

    /**
     * The column <code>chrono.crgeomap3.varname_4</code>.
     */
    public final TableField<Crgeomap3Record, String> VARNAME_4 = createField("varname_4", org.jooq.impl.SQLDataType.VARCHAR(80), this, "");

    /**
     * The column <code>chrono.crgeomap3.type_4</code>.
     */
    public final TableField<Crgeomap3Record, String> TYPE_4 = createField("type_4", org.jooq.impl.SQLDataType.VARCHAR(80), this, "");

    /**
     * The column <code>chrono.crgeomap3.engtype_4</code>.
     */
    public final TableField<Crgeomap3Record, String> ENGTYPE_4 = createField("engtype_4", org.jooq.impl.SQLDataType.VARCHAR(80), this, "");

    /**
     * The column <code>chrono.crgeomap3.cc_4</code>.
     */
    public final TableField<Crgeomap3Record, String> CC_4 = createField("cc_4", org.jooq.impl.SQLDataType.VARCHAR(80), this, "");

    /**
     * Create a <code>chrono.crgeomap3</code> table reference
     */
    public Crgeomap3() {
        this(DSL.name("crgeomap3"), null);
    }

    /**
     * Create an aliased <code>chrono.crgeomap3</code> table reference
     */
    public Crgeomap3(String alias) {
        this(DSL.name(alias), CRGEOMAP3);
    }

    /**
     * Create an aliased <code>chrono.crgeomap3</code> table reference
     */
    public Crgeomap3(Name alias) {
        this(alias, CRGEOMAP3);
    }

    private Crgeomap3(Name alias, Table<Crgeomap3Record> aliased) {
        this(alias, aliased, null);
    }

    private Crgeomap3(Name alias, Table<Crgeomap3Record> aliased, Field<?>[] parameters) {
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
    public List<UniqueKey<Crgeomap3Record>> getKeys() {
        return Arrays.<UniqueKey<Crgeomap3Record>>asList(Keys.KEY_CRGEOMAP3_OGR_FID);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Crgeomap3 as(String alias) {
        return new Crgeomap3(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Crgeomap3 as(Name alias) {
        return new Crgeomap3(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Crgeomap3 rename(String name) {
        return new Crgeomap3(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Crgeomap3 rename(Name name) {
        return new Crgeomap3(name, null);
    }
}

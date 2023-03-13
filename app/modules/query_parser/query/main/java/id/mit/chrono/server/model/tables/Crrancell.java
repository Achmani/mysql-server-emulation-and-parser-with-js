/*
 * This file is generated by jOOQ.
*/
package id.mit.chrono.server.model.tables;


import id.mit.chrono.server.model.Chrono;
import id.mit.chrono.server.model.Keys;
import id.mit.chrono.server.model.tables.records.CrrancellRecord;

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
public class Crrancell extends TableImpl<CrrancellRecord> {

    private static final long serialVersionUID = -1185977416;

    /**
     * The reference instance of <code>chrono.crrancell</code>
     */
    public static final Crrancell CRRANCELL = new Crrancell();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<CrrancellRecord> getRecordType() {
        return CrrancellRecord.class;
    }

    /**
     * The column <code>chrono.crrancell.rancell_id</code>.
     */
    public final TableField<CrrancellRecord, ULong> RANCELL_ID = createField("rancell_id", org.jooq.impl.SQLDataType.BIGINTUNSIGNED.nullable(false), this, "");

    /**
     * The column <code>chrono.crrancell.rancell_crcollectortaskfiles</code>.
     */
    public final TableField<CrrancellRecord, Long> RANCELL_CRCOLLECTORTASKFILES = createField("rancell_crcollectortaskfiles", org.jooq.impl.SQLDataType.BIGINT, this, "");

    /**
     * The column <code>chrono.crrancell.rancell_datasource</code>.
     */
    public final TableField<CrrancellRecord, Integer> RANCELL_DATASOURCE = createField("rancell_datasource", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.crrancell.rancell_date</code>.
     */
    public final TableField<CrrancellRecord, UInteger> RANCELL_DATE = createField("rancell_date", org.jooq.impl.SQLDataType.INTEGERUNSIGNED.nullable(false), this, "");

    /**
     * The column <code>chrono.crrancell.rancell_datefrom</code>.
     */
    public final TableField<CrrancellRecord, UInteger> RANCELL_DATEFROM = createField("rancell_datefrom", org.jooq.impl.SQLDataType.INTEGERUNSIGNED, this, "");

    /**
     * The column <code>chrono.crrancell.rancell_crfinalizertask</code>.
     */
    public final TableField<CrrancellRecord, Integer> RANCELL_CRFINALIZERTASK = createField("rancell_crfinalizertask", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.crrancell.rancell_key</code>.
     */
    public final TableField<CrrancellRecord, String> RANCELL_KEY = createField("rancell_key", org.jooq.impl.SQLDataType.CHAR(96).nullable(false), this, "");

    /**
     * The column <code>chrono.crrancell.rancell_site</code>.
     */
    public final TableField<CrrancellRecord, Integer> RANCELL_SITE = createField("rancell_site", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.crrancell.rancell_node</code>.
     */
    public final TableField<CrrancellRecord, Integer> RANCELL_NODE = createField("rancell_node", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.crrancell.rancell_nodealias</code>.
     */
    public final TableField<CrrancellRecord, Integer> RANCELL_NODEALIAS = createField("rancell_nodealias", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.crrancell.rancell_vendor</code>.
     */
    public final TableField<CrrancellRecord, Integer> RANCELL_VENDOR = createField("rancell_vendor", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.crrancell.rancell_latitude</code>.
     */
    public final TableField<CrrancellRecord, Double> RANCELL_LATITUDE = createField("rancell_latitude", org.jooq.impl.SQLDataType.DOUBLE, this, "");

    /**
     * The column <code>chrono.crrancell.rancell_longitude</code>.
     */
    public final TableField<CrrancellRecord, Double> RANCELL_LONGITUDE = createField("rancell_longitude", org.jooq.impl.SQLDataType.DOUBLE, this, "");

    /**
     * The column <code>chrono.crrancell.rancell_namingvalid</code>.
     */
    public final TableField<CrrancellRecord, Byte> RANCELL_NAMINGVALID = createField("rancell_namingvalid", org.jooq.impl.SQLDataType.TINYINT, this, "");

    /**
     * The column <code>chrono.crrancell.rancell_cell</code>.
     */
    public final TableField<CrrancellRecord, Integer> RANCELL_CELL = createField("rancell_cell", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.crrancell.rancell_cellclass</code>.
     */
    public final TableField<CrrancellRecord, Integer> RANCELL_CELLCLASS = createField("rancell_cellclass", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.crrancell.rancell_cellclassgroup</code>.
     */
    public final TableField<CrrancellRecord, Integer> RANCELL_CELLCLASSGROUP = createField("rancell_cellclassgroup", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.crrancell.rancell_cellstatus</code>.
     */
    public final TableField<CrrancellRecord, Integer> RANCELL_CELLSTATUS = createField("rancell_cellstatus", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.crrancell.rancell_src</code>.
     */
    public final TableField<CrrancellRecord, String> RANCELL_SRC = createField("rancell_src", org.jooq.impl.SQLDataType.CHAR(12), this, "");

    /**
     * The column <code>chrono.crrancell.rancell_refid</code>.
     */
    public final TableField<CrrancellRecord, ULong> RANCELL_REFID = createField("rancell_refid", org.jooq.impl.SQLDataType.BIGINTUNSIGNED.nullable(false), this, "");

    /**
     * The column <code>chrono.crrancell.CONTROLLER</code>.
     */
    public final TableField<CrrancellRecord, String> CONTROLLER = createField("CONTROLLER", org.jooq.impl.SQLDataType.CHAR(32), this, "");

    /**
     * The column <code>chrono.crrancell.CONTROLLERID</code>.
     */
    public final TableField<CrrancellRecord, Integer> CONTROLLERID = createField("CONTROLLERID", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.crrancell.BTSINDEX</code>.
     */
    public final TableField<CrrancellRecord, String> BTSINDEX = createField("BTSINDEX", org.jooq.impl.SQLDataType.CHAR(96), this, "");

    /**
     * The column <code>chrono.crrancell.BTSNAME</code>.
     */
    public final TableField<CrrancellRecord, String> BTSNAME = createField("BTSNAME", org.jooq.impl.SQLDataType.CHAR(96), this, "");

    /**
     * The column <code>chrono.crrancell.CELLNAME</code>.
     */
    public final TableField<CrrancellRecord, String> CELLNAME = createField("CELLNAME", org.jooq.impl.SQLDataType.CHAR(96), this, "");

    /**
     * The column <code>chrono.crrancell.IDENTIFIER</code>.
     */
    public final TableField<CrrancellRecord, String> IDENTIFIER = createField("IDENTIFIER", org.jooq.impl.SQLDataType.CHAR(96), this, "");

    /**
     * The column <code>chrono.crrancell.TOTALTRX</code>.
     */
    public final TableField<CrrancellRecord, Integer> TOTALTRX = createField("TOTALTRX", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.crrancell.BANDTYPE</code>.
     */
    public final TableField<CrrancellRecord, String> BANDTYPE = createField("BANDTYPE", org.jooq.impl.SQLDataType.CHAR(32), this, "");

    /**
     * The column <code>chrono.crrancell.BANDGROUP</code>.
     */
    public final TableField<CrrancellRecord, String> BANDGROUP = createField("BANDGROUP", org.jooq.impl.SQLDataType.CHAR(32), this, "");

    /**
     * The column <code>chrono.crrancell.MCC</code>.
     */
    public final TableField<CrrancellRecord, String> MCC = createField("MCC", org.jooq.impl.SQLDataType.CHAR(8), this, "");

    /**
     * The column <code>chrono.crrancell.MNC</code>.
     */
    public final TableField<CrrancellRecord, String> MNC = createField("MNC", org.jooq.impl.SQLDataType.CHAR(8), this, "");

    /**
     * The column <code>chrono.crrancell.LAC</code>.
     */
    public final TableField<CrrancellRecord, String> LAC = createField("LAC", org.jooq.impl.SQLDataType.CHAR(8), this, "");

    /**
     * The column <code>chrono.crrancell.TAC</code>.
     */
    public final TableField<CrrancellRecord, String> TAC = createField("TAC", org.jooq.impl.SQLDataType.CHAR(11), this, "");

    /**
     * The column <code>chrono.crrancell.CI</code>.
     */
    public final TableField<CrrancellRecord, String> CI = createField("CI", org.jooq.impl.SQLDataType.CHAR(8), this, "");

    /**
     * The column <code>chrono.crrancell.PCI</code>.
     */
    public final TableField<CrrancellRecord, String> PCI = createField("PCI", org.jooq.impl.SQLDataType.CHAR(8), this, "");

    /**
     * The column <code>chrono.crrancell.NCC</code>.
     */
    public final TableField<CrrancellRecord, String> NCC = createField("NCC", org.jooq.impl.SQLDataType.CHAR(8), this, "");

    /**
     * The column <code>chrono.crrancell.BCC</code>.
     */
    public final TableField<CrrancellRecord, String> BCC = createField("BCC", org.jooq.impl.SQLDataType.CHAR(8), this, "");

    /**
     * The column <code>chrono.crrancell.SAC</code>.
     */
    public final TableField<CrrancellRecord, String> SAC = createField("SAC", org.jooq.impl.SQLDataType.CHAR(32), this, "");

    /**
     * The column <code>chrono.crrancell.RAC</code>.
     */
    public final TableField<CrrancellRecord, String> RAC = createField("RAC", org.jooq.impl.SQLDataType.CHAR(11), this, "");

    /**
     * The column <code>chrono.crrancell.PSC</code>.
     */
    public final TableField<CrrancellRecord, String> PSC = createField("PSC", org.jooq.impl.SQLDataType.CHAR(16), this, "");

    /**
     * The column <code>chrono.crrancell.ARFCN</code>.
     */
    public final TableField<CrrancellRecord, String> ARFCN = createField("ARFCN", org.jooq.impl.SQLDataType.CHAR(32), this, "");

    /**
     * The column <code>chrono.crrancell.UARFCN</code>.
     */
    public final TableField<CrrancellRecord, String> UARFCN = createField("UARFCN", org.jooq.impl.SQLDataType.CHAR(64), this, "");

    /**
     * The column <code>chrono.crrancell.EARFCN</code>.
     */
    public final TableField<CrrancellRecord, String> EARFCN = createField("EARFCN", org.jooq.impl.SQLDataType.CHAR(64), this, "");

    /**
     * The column <code>chrono.crrancell.PID</code>.
     */
    public final TableField<CrrancellRecord, String> PID = createField("PID", org.jooq.impl.SQLDataType.CHAR(8), this, "");

    /**
     * The column <code>chrono.crrancell.FREQ1</code>.
     */
    public final TableField<CrrancellRecord, Double> FREQ1 = createField("FREQ1", org.jooq.impl.SQLDataType.DOUBLE, this, "");

    /**
     * The column <code>chrono.crrancell.FREQ2</code>.
     */
    public final TableField<CrrancellRecord, Double> FREQ2 = createField("FREQ2", org.jooq.impl.SQLDataType.DOUBLE, this, "");

    /**
     * The column <code>chrono.crrancell.FREQ3</code>.
     */
    public final TableField<CrrancellRecord, Double> FREQ3 = createField("FREQ3", org.jooq.impl.SQLDataType.DOUBLE, this, "");

    /**
     * The column <code>chrono.crrancell.FREQ4</code>.
     */
    public final TableField<CrrancellRecord, Double> FREQ4 = createField("FREQ4", org.jooq.impl.SQLDataType.DOUBLE, this, "");

    /**
     * The column <code>chrono.crrancell.FREQ5</code>.
     */
    public final TableField<CrrancellRecord, Double> FREQ5 = createField("FREQ5", org.jooq.impl.SQLDataType.DOUBLE, this, "");

    /**
     * The column <code>chrono.crrancell.FREQ6</code>.
     */
    public final TableField<CrrancellRecord, Double> FREQ6 = createField("FREQ6", org.jooq.impl.SQLDataType.DOUBLE, this, "");

    /**
     * The column <code>chrono.crrancell.FREQ7</code>.
     */
    public final TableField<CrrancellRecord, Double> FREQ7 = createField("FREQ7", org.jooq.impl.SQLDataType.DOUBLE, this, "");

    /**
     * The column <code>chrono.crrancell.FREQ8</code>.
     */
    public final TableField<CrrancellRecord, Double> FREQ8 = createField("FREQ8", org.jooq.impl.SQLDataType.DOUBLE, this, "");

    /**
     * The column <code>chrono.crrancell.FREQ9</code>.
     */
    public final TableField<CrrancellRecord, Double> FREQ9 = createField("FREQ9", org.jooq.impl.SQLDataType.DOUBLE, this, "");

    /**
     * The column <code>chrono.crrancell.FREQ10</code>.
     */
    public final TableField<CrrancellRecord, Double> FREQ10 = createField("FREQ10", org.jooq.impl.SQLDataType.DOUBLE, this, "");

    /**
     * The column <code>chrono.crrancell.FREQ11</code>.
     */
    public final TableField<CrrancellRecord, Double> FREQ11 = createField("FREQ11", org.jooq.impl.SQLDataType.DOUBLE, this, "");

    /**
     * The column <code>chrono.crrancell.FREQ12</code>.
     */
    public final TableField<CrrancellRecord, Double> FREQ12 = createField("FREQ12", org.jooq.impl.SQLDataType.DOUBLE, this, "");

    /**
     * The column <code>chrono.crrancell.FREQ13</code>.
     */
    public final TableField<CrrancellRecord, Double> FREQ13 = createField("FREQ13", org.jooq.impl.SQLDataType.DOUBLE, this, "");

    /**
     * The column <code>chrono.crrancell.FREQ14</code>.
     */
    public final TableField<CrrancellRecord, Double> FREQ14 = createField("FREQ14", org.jooq.impl.SQLDataType.DOUBLE, this, "");

    /**
     * The column <code>chrono.crrancell.FREQ15</code>.
     */
    public final TableField<CrrancellRecord, Double> FREQ15 = createField("FREQ15", org.jooq.impl.SQLDataType.DOUBLE, this, "");

    /**
     * The column <code>chrono.crrancell.FREQ16</code>.
     */
    public final TableField<CrrancellRecord, Double> FREQ16 = createField("FREQ16", org.jooq.impl.SQLDataType.DOUBLE, this, "");

    /**
     * The column <code>chrono.crrancell.FREQ17</code>.
     */
    public final TableField<CrrancellRecord, String> FREQ17 = createField("FREQ17", org.jooq.impl.SQLDataType.CHAR(8), this, "");

    /**
     * The column <code>chrono.crrancell.FREQ18</code>.
     */
    public final TableField<CrrancellRecord, String> FREQ18 = createField("FREQ18", org.jooq.impl.SQLDataType.CHAR(8), this, "");

    /**
     * The column <code>chrono.crrancell.FREQ19</code>.
     */
    public final TableField<CrrancellRecord, String> FREQ19 = createField("FREQ19", org.jooq.impl.SQLDataType.CHAR(8), this, "");

    /**
     * The column <code>chrono.crrancell.FREQ20</code>.
     */
    public final TableField<CrrancellRecord, String> FREQ20 = createField("FREQ20", org.jooq.impl.SQLDataType.CHAR(8), this, "");

    /**
     * The column <code>chrono.crrancell.FREQ21</code>.
     */
    public final TableField<CrrancellRecord, String> FREQ21 = createField("FREQ21", org.jooq.impl.SQLDataType.CHAR(8), this, "");

    /**
     * The column <code>chrono.crrancell.FREQ22</code>.
     */
    public final TableField<CrrancellRecord, String> FREQ22 = createField("FREQ22", org.jooq.impl.SQLDataType.CHAR(8), this, "");

    /**
     * The column <code>chrono.crrancell.FREQ23</code>.
     */
    public final TableField<CrrancellRecord, String> FREQ23 = createField("FREQ23", org.jooq.impl.SQLDataType.CHAR(8), this, "");

    /**
     * The column <code>chrono.crrancell.FREQ24</code>.
     */
    public final TableField<CrrancellRecord, String> FREQ24 = createField("FREQ24", org.jooq.impl.SQLDataType.CHAR(8), this, "");

    /**
     * The column <code>chrono.crrancell.FREQ25</code>.
     */
    public final TableField<CrrancellRecord, String> FREQ25 = createField("FREQ25", org.jooq.impl.SQLDataType.CHAR(8), this, "");

    /**
     * The column <code>chrono.crrancell.FREQ26</code>.
     */
    public final TableField<CrrancellRecord, String> FREQ26 = createField("FREQ26", org.jooq.impl.SQLDataType.CHAR(8), this, "");

    /**
     * The column <code>chrono.crrancell.FREQ27</code>.
     */
    public final TableField<CrrancellRecord, String> FREQ27 = createField("FREQ27", org.jooq.impl.SQLDataType.CHAR(8), this, "");

    /**
     * The column <code>chrono.crrancell.FREQ28</code>.
     */
    public final TableField<CrrancellRecord, String> FREQ28 = createField("FREQ28", org.jooq.impl.SQLDataType.CHAR(8), this, "");

    /**
     * The column <code>chrono.crrancell.FREQ29</code>.
     */
    public final TableField<CrrancellRecord, String> FREQ29 = createField("FREQ29", org.jooq.impl.SQLDataType.CHAR(8), this, "");

    /**
     * The column <code>chrono.crrancell.FREQ30</code>.
     */
    public final TableField<CrrancellRecord, String> FREQ30 = createField("FREQ30", org.jooq.impl.SQLDataType.CHAR(8), this, "");

    /**
     * The column <code>chrono.crrancell.FREQ31</code>.
     */
    public final TableField<CrrancellRecord, String> FREQ31 = createField("FREQ31", org.jooq.impl.SQLDataType.CHAR(8), this, "");

    /**
     * The column <code>chrono.crrancell.FREQ32</code>.
     */
    public final TableField<CrrancellRecord, String> FREQ32 = createField("FREQ32", org.jooq.impl.SQLDataType.CHAR(8), this, "");

    /**
     * The column <code>chrono.crrancell.ANEID</code>.
     */
    public final TableField<CrrancellRecord, String> ANEID = createField("ANEID", org.jooq.impl.SQLDataType.CHAR(8), this, "");

    /**
     * The column <code>chrono.crrancell.DLFREQ</code>.
     */
    public final TableField<CrrancellRecord, Double> DLFREQ = createField("DLFREQ", org.jooq.impl.SQLDataType.DOUBLE, this, "");

    /**
     * The column <code>chrono.crrancell.ULFREQ</code>.
     */
    public final TableField<CrrancellRecord, Double> ULFREQ = createField("ULFREQ", org.jooq.impl.SQLDataType.DOUBLE, this, "");

    /**
     * The column <code>chrono.crrancell.BTSTYPE</code>.
     */
    public final TableField<CrrancellRecord, String> BTSTYPE = createField("BTSTYPE", org.jooq.impl.SQLDataType.CHAR(32), this, "");

    /**
     * The column <code>chrono.crrancell.BANDWIDTH</code>.
     */
    public final TableField<CrrancellRecord, Double> BANDWIDTH = createField("BANDWIDTH", org.jooq.impl.SQLDataType.DOUBLE, this, "");

    /**
     * The column <code>chrono.crrancell.CELLNO</code>.
     */
    public final TableField<CrrancellRecord, Integer> CELLNO = createField("CELLNO", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.crrancell.STATUS</code>.
     */
    public final TableField<CrrancellRecord, String> STATUS = createField("STATUS", org.jooq.impl.SQLDataType.CHAR(32), this, "");

    /**
     * The column <code>chrono.crrancell.FLAG1</code>.
     */
    public final TableField<CrrancellRecord, String> FLAG1 = createField("FLAG1", org.jooq.impl.SQLDataType.CHAR(64), this, "");

    /**
     * The column <code>chrono.crrancell.FLAG2</code>.
     */
    public final TableField<CrrancellRecord, String> FLAG2 = createField("FLAG2", org.jooq.impl.SQLDataType.CHAR(64), this, "");

    /**
     * The column <code>chrono.crrancell.FLAG3</code>.
     */
    public final TableField<CrrancellRecord, String> FLAG3 = createField("FLAG3", org.jooq.impl.SQLDataType.CHAR(64), this, "");

    /**
     * The column <code>chrono.crrancell.FLAG4</code>.
     */
    public final TableField<CrrancellRecord, String> FLAG4 = createField("FLAG4", org.jooq.impl.SQLDataType.CHAR(64), this, "");

    /**
     * The column <code>chrono.crrancell.FLAG5</code>.
     */
    public final TableField<CrrancellRecord, String> FLAG5 = createField("FLAG5", org.jooq.impl.SQLDataType.CHAR(64), this, "");

    /**
     * The column <code>chrono.crrancell.FLAG6</code>.
     */
    public final TableField<CrrancellRecord, String> FLAG6 = createField("FLAG6", org.jooq.impl.SQLDataType.CHAR(64), this, "");

    /**
     * The column <code>chrono.crrancell.FLAG7</code>.
     */
    public final TableField<CrrancellRecord, String> FLAG7 = createField("FLAG7", org.jooq.impl.SQLDataType.CHAR(64), this, "");

    /**
     * The column <code>chrono.crrancell.FLAG8</code>.
     */
    public final TableField<CrrancellRecord, String> FLAG8 = createField("FLAG8", org.jooq.impl.SQLDataType.CHAR(64), this, "");

    /**
     * Create a <code>chrono.crrancell</code> table reference
     */
    public Crrancell() {
        this(DSL.name("crrancell"), null);
    }

    /**
     * Create an aliased <code>chrono.crrancell</code> table reference
     */
    public Crrancell(String alias) {
        this(DSL.name(alias), CRRANCELL);
    }

    /**
     * Create an aliased <code>chrono.crrancell</code> table reference
     */
    public Crrancell(Name alias) {
        this(alias, CRRANCELL);
    }

    private Crrancell(Name alias, Table<CrrancellRecord> aliased) {
        this(alias, aliased, null);
    }

    private Crrancell(Name alias, Table<CrrancellRecord> aliased, Field<?>[] parameters) {
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
    public UniqueKey<CrrancellRecord> getPrimaryKey() {
        return Keys.KEY_CRRANCELL_PRIMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<CrrancellRecord>> getKeys() {
        return Arrays.<UniqueKey<CrrancellRecord>>asList(Keys.KEY_CRRANCELL_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Crrancell as(String alias) {
        return new Crrancell(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Crrancell as(Name alias) {
        return new Crrancell(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Crrancell rename(String name) {
        return new Crrancell(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Crrancell rename(Name name) {
        return new Crrancell(name, null);
    }
}
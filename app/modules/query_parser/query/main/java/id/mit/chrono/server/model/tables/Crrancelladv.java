/*
 * This file is generated by jOOQ.
*/
package id.mit.chrono.server.model.tables;


import id.mit.chrono.server.model.Chrono;
import id.mit.chrono.server.model.Keys;
import id.mit.chrono.server.model.tables.records.CrrancelladvRecord;

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
public class Crrancelladv extends TableImpl<CrrancelladvRecord> {

    private static final long serialVersionUID = 2126490511;

    /**
     * The reference instance of <code>chrono.crrancelladv</code>
     */
    public static final Crrancelladv CRRANCELLADV = new Crrancelladv();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<CrrancelladvRecord> getRecordType() {
        return CrrancelladvRecord.class;
    }

    /**
     * The column <code>chrono.crrancelladv.rancell_id</code>.
     */
    public final TableField<CrrancelladvRecord, ULong> RANCELL_ID = createField("rancell_id", org.jooq.impl.SQLDataType.BIGINTUNSIGNED.nullable(false), this, "");

    /**
     * The column <code>chrono.crrancelladv.rancell_crcollectortaskfiles</code>.
     */
    public final TableField<CrrancelladvRecord, Long> RANCELL_CRCOLLECTORTASKFILES = createField("rancell_crcollectortaskfiles", org.jooq.impl.SQLDataType.BIGINT, this, "");

    /**
     * The column <code>chrono.crrancelladv.rancell_datasource</code>.
     */
    public final TableField<CrrancelladvRecord, Integer> RANCELL_DATASOURCE = createField("rancell_datasource", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.crrancelladv.rancell_date</code>.
     */
    public final TableField<CrrancelladvRecord, UInteger> RANCELL_DATE = createField("rancell_date", org.jooq.impl.SQLDataType.INTEGERUNSIGNED.nullable(false), this, "");

    /**
     * The column <code>chrono.crrancelladv.rancell_datefrom</code>.
     */
    public final TableField<CrrancelladvRecord, UInteger> RANCELL_DATEFROM = createField("rancell_datefrom", org.jooq.impl.SQLDataType.INTEGERUNSIGNED, this, "");

    /**
     * The column <code>chrono.crrancelladv.rancell_crfinalizertask</code>.
     */
    public final TableField<CrrancelladvRecord, Integer> RANCELL_CRFINALIZERTASK = createField("rancell_crfinalizertask", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.crrancelladv.rancell_key</code>.
     */
    public final TableField<CrrancelladvRecord, String> RANCELL_KEY = createField("rancell_key", org.jooq.impl.SQLDataType.CHAR(96).nullable(false), this, "");

    /**
     * The column <code>chrono.crrancelladv.rancell_site</code>.
     */
    public final TableField<CrrancelladvRecord, Integer> RANCELL_SITE = createField("rancell_site", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.crrancelladv.rancell_node</code>.
     */
    public final TableField<CrrancelladvRecord, Integer> RANCELL_NODE = createField("rancell_node", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.crrancelladv.rancell_nodealias</code>.
     */
    public final TableField<CrrancelladvRecord, Integer> RANCELL_NODEALIAS = createField("rancell_nodealias", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.crrancelladv.rancell_vendor</code>.
     */
    public final TableField<CrrancelladvRecord, Integer> RANCELL_VENDOR = createField("rancell_vendor", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.crrancelladv.rancell_latitude</code>.
     */
    public final TableField<CrrancelladvRecord, Double> RANCELL_LATITUDE = createField("rancell_latitude", org.jooq.impl.SQLDataType.DOUBLE, this, "");

    /**
     * The column <code>chrono.crrancelladv.rancell_longitude</code>.
     */
    public final TableField<CrrancelladvRecord, Double> RANCELL_LONGITUDE = createField("rancell_longitude", org.jooq.impl.SQLDataType.DOUBLE, this, "");

    /**
     * The column <code>chrono.crrancelladv.rancell_namingvalid</code>.
     */
    public final TableField<CrrancelladvRecord, Byte> RANCELL_NAMINGVALID = createField("rancell_namingvalid", org.jooq.impl.SQLDataType.TINYINT, this, "");

    /**
     * The column <code>chrono.crrancelladv.rancell_cell</code>.
     */
    public final TableField<CrrancelladvRecord, Integer> RANCELL_CELL = createField("rancell_cell", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.crrancelladv.rancell_cellclass</code>.
     */
    public final TableField<CrrancelladvRecord, Integer> RANCELL_CELLCLASS = createField("rancell_cellclass", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.crrancelladv.rancell_cellclassgroup</code>.
     */
    public final TableField<CrrancelladvRecord, Integer> RANCELL_CELLCLASSGROUP = createField("rancell_cellclassgroup", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.crrancelladv.rancell_cellstatus</code>.
     */
    public final TableField<CrrancelladvRecord, Integer> RANCELL_CELLSTATUS = createField("rancell_cellstatus", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.crrancelladv.rancell_src</code>.
     */
    public final TableField<CrrancelladvRecord, String> RANCELL_SRC = createField("rancell_src", org.jooq.impl.SQLDataType.CHAR(12), this, "");

    /**
     * The column <code>chrono.crrancelladv.rancell_refid</code>.
     */
    public final TableField<CrrancelladvRecord, ULong> RANCELL_REFID = createField("rancell_refid", org.jooq.impl.SQLDataType.BIGINTUNSIGNED.nullable(false), this, "");

    /**
     * The column <code>chrono.crrancelladv.CONTROLLER</code>.
     */
    public final TableField<CrrancelladvRecord, String> CONTROLLER = createField("CONTROLLER", org.jooq.impl.SQLDataType.CHAR(32), this, "");

    /**
     * The column <code>chrono.crrancelladv.CONTROLLERID</code>.
     */
    public final TableField<CrrancelladvRecord, Integer> CONTROLLERID = createField("CONTROLLERID", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.crrancelladv.BTSINDEX</code>.
     */
    public final TableField<CrrancelladvRecord, String> BTSINDEX = createField("BTSINDEX", org.jooq.impl.SQLDataType.CHAR(96), this, "");

    /**
     * The column <code>chrono.crrancelladv.BTSNAME</code>.
     */
    public final TableField<CrrancelladvRecord, String> BTSNAME = createField("BTSNAME", org.jooq.impl.SQLDataType.CHAR(96), this, "");

    /**
     * The column <code>chrono.crrancelladv.CELLNAME</code>.
     */
    public final TableField<CrrancelladvRecord, String> CELLNAME = createField("CELLNAME", org.jooq.impl.SQLDataType.CHAR(96), this, "");

    /**
     * The column <code>chrono.crrancelladv.IDENTIFIER</code>.
     */
    public final TableField<CrrancelladvRecord, String> IDENTIFIER = createField("IDENTIFIER", org.jooq.impl.SQLDataType.CHAR(96), this, "");

    /**
     * The column <code>chrono.crrancelladv.TOTALTRX</code>.
     */
    public final TableField<CrrancelladvRecord, Integer> TOTALTRX = createField("TOTALTRX", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.crrancelladv.BANDTYPE</code>.
     */
    public final TableField<CrrancelladvRecord, String> BANDTYPE = createField("BANDTYPE", org.jooq.impl.SQLDataType.CHAR(32), this, "");

    /**
     * The column <code>chrono.crrancelladv.BANDGROUP</code>.
     */
    public final TableField<CrrancelladvRecord, String> BANDGROUP = createField("BANDGROUP", org.jooq.impl.SQLDataType.CHAR(32), this, "");

    /**
     * The column <code>chrono.crrancelladv.MCC</code>.
     */
    public final TableField<CrrancelladvRecord, String> MCC = createField("MCC", org.jooq.impl.SQLDataType.CHAR(8), this, "");

    /**
     * The column <code>chrono.crrancelladv.MNC</code>.
     */
    public final TableField<CrrancelladvRecord, String> MNC = createField("MNC", org.jooq.impl.SQLDataType.CHAR(8), this, "");

    /**
     * The column <code>chrono.crrancelladv.LAC</code>.
     */
    public final TableField<CrrancelladvRecord, String> LAC = createField("LAC", org.jooq.impl.SQLDataType.CHAR(8), this, "");

    /**
     * The column <code>chrono.crrancelladv.TAC</code>.
     */
    public final TableField<CrrancelladvRecord, String> TAC = createField("TAC", org.jooq.impl.SQLDataType.CHAR(11), this, "");

    /**
     * The column <code>chrono.crrancelladv.CI</code>.
     */
    public final TableField<CrrancelladvRecord, String> CI = createField("CI", org.jooq.impl.SQLDataType.CHAR(8), this, "");

    /**
     * The column <code>chrono.crrancelladv.PCI</code>.
     */
    public final TableField<CrrancelladvRecord, String> PCI = createField("PCI", org.jooq.impl.SQLDataType.CHAR(8), this, "");

    /**
     * The column <code>chrono.crrancelladv.NCC</code>.
     */
    public final TableField<CrrancelladvRecord, String> NCC = createField("NCC", org.jooq.impl.SQLDataType.CHAR(8), this, "");

    /**
     * The column <code>chrono.crrancelladv.BCC</code>.
     */
    public final TableField<CrrancelladvRecord, String> BCC = createField("BCC", org.jooq.impl.SQLDataType.CHAR(8), this, "");

    /**
     * The column <code>chrono.crrancelladv.SAC</code>.
     */
    public final TableField<CrrancelladvRecord, String> SAC = createField("SAC", org.jooq.impl.SQLDataType.CHAR(32), this, "");

    /**
     * The column <code>chrono.crrancelladv.RAC</code>.
     */
    public final TableField<CrrancelladvRecord, String> RAC = createField("RAC", org.jooq.impl.SQLDataType.CHAR(11), this, "");

    /**
     * The column <code>chrono.crrancelladv.PSC</code>.
     */
    public final TableField<CrrancelladvRecord, String> PSC = createField("PSC", org.jooq.impl.SQLDataType.CHAR(16), this, "");

    /**
     * The column <code>chrono.crrancelladv.ARFCN</code>.
     */
    public final TableField<CrrancelladvRecord, String> ARFCN = createField("ARFCN", org.jooq.impl.SQLDataType.CHAR(32), this, "");

    /**
     * The column <code>chrono.crrancelladv.UARFCN</code>.
     */
    public final TableField<CrrancelladvRecord, String> UARFCN = createField("UARFCN", org.jooq.impl.SQLDataType.CHAR(64), this, "");

    /**
     * The column <code>chrono.crrancelladv.EARFCN</code>.
     */
    public final TableField<CrrancelladvRecord, String> EARFCN = createField("EARFCN", org.jooq.impl.SQLDataType.CHAR(64), this, "");

    /**
     * The column <code>chrono.crrancelladv.NRARFCN</code>.
     */
    public final TableField<CrrancelladvRecord, String> NRARFCN = createField("NRARFCN", org.jooq.impl.SQLDataType.CHAR(32), this, "");

    /**
     * The column <code>chrono.crrancelladv.PID</code>.
     */
    public final TableField<CrrancelladvRecord, String> PID = createField("PID", org.jooq.impl.SQLDataType.CHAR(8), this, "");

    /**
     * The column <code>chrono.crrancelladv.FREQ1</code>.
     */
    public final TableField<CrrancelladvRecord, Double> FREQ1 = createField("FREQ1", org.jooq.impl.SQLDataType.DOUBLE, this, "");

    /**
     * The column <code>chrono.crrancelladv.FREQ2</code>.
     */
    public final TableField<CrrancelladvRecord, Double> FREQ2 = createField("FREQ2", org.jooq.impl.SQLDataType.DOUBLE, this, "");

    /**
     * The column <code>chrono.crrancelladv.FREQ3</code>.
     */
    public final TableField<CrrancelladvRecord, Double> FREQ3 = createField("FREQ3", org.jooq.impl.SQLDataType.DOUBLE, this, "");

    /**
     * The column <code>chrono.crrancelladv.FREQ4</code>.
     */
    public final TableField<CrrancelladvRecord, Double> FREQ4 = createField("FREQ4", org.jooq.impl.SQLDataType.DOUBLE, this, "");

    /**
     * The column <code>chrono.crrancelladv.FREQ5</code>.
     */
    public final TableField<CrrancelladvRecord, Double> FREQ5 = createField("FREQ5", org.jooq.impl.SQLDataType.DOUBLE, this, "");

    /**
     * The column <code>chrono.crrancelladv.FREQ6</code>.
     */
    public final TableField<CrrancelladvRecord, Double> FREQ6 = createField("FREQ6", org.jooq.impl.SQLDataType.DOUBLE, this, "");

    /**
     * The column <code>chrono.crrancelladv.FREQ7</code>.
     */
    public final TableField<CrrancelladvRecord, Double> FREQ7 = createField("FREQ7", org.jooq.impl.SQLDataType.DOUBLE, this, "");

    /**
     * The column <code>chrono.crrancelladv.FREQ8</code>.
     */
    public final TableField<CrrancelladvRecord, Double> FREQ8 = createField("FREQ8", org.jooq.impl.SQLDataType.DOUBLE, this, "");

    /**
     * The column <code>chrono.crrancelladv.FREQ9</code>.
     */
    public final TableField<CrrancelladvRecord, Double> FREQ9 = createField("FREQ9", org.jooq.impl.SQLDataType.DOUBLE, this, "");

    /**
     * The column <code>chrono.crrancelladv.FREQ10</code>.
     */
    public final TableField<CrrancelladvRecord, Double> FREQ10 = createField("FREQ10", org.jooq.impl.SQLDataType.DOUBLE, this, "");

    /**
     * The column <code>chrono.crrancelladv.FREQ11</code>.
     */
    public final TableField<CrrancelladvRecord, Double> FREQ11 = createField("FREQ11", org.jooq.impl.SQLDataType.DOUBLE, this, "");

    /**
     * The column <code>chrono.crrancelladv.FREQ12</code>.
     */
    public final TableField<CrrancelladvRecord, Double> FREQ12 = createField("FREQ12", org.jooq.impl.SQLDataType.DOUBLE, this, "");

    /**
     * The column <code>chrono.crrancelladv.FREQ13</code>.
     */
    public final TableField<CrrancelladvRecord, Double> FREQ13 = createField("FREQ13", org.jooq.impl.SQLDataType.DOUBLE, this, "");

    /**
     * The column <code>chrono.crrancelladv.FREQ14</code>.
     */
    public final TableField<CrrancelladvRecord, Double> FREQ14 = createField("FREQ14", org.jooq.impl.SQLDataType.DOUBLE, this, "");

    /**
     * The column <code>chrono.crrancelladv.FREQ15</code>.
     */
    public final TableField<CrrancelladvRecord, Double> FREQ15 = createField("FREQ15", org.jooq.impl.SQLDataType.DOUBLE, this, "");

    /**
     * The column <code>chrono.crrancelladv.FREQ16</code>.
     */
    public final TableField<CrrancelladvRecord, Double> FREQ16 = createField("FREQ16", org.jooq.impl.SQLDataType.DOUBLE, this, "");

    /**
     * The column <code>chrono.crrancelladv.FREQ17</code>.
     */
    public final TableField<CrrancelladvRecord, String> FREQ17 = createField("FREQ17", org.jooq.impl.SQLDataType.CHAR(8), this, "");

    /**
     * The column <code>chrono.crrancelladv.FREQ18</code>.
     */
    public final TableField<CrrancelladvRecord, String> FREQ18 = createField("FREQ18", org.jooq.impl.SQLDataType.CHAR(8), this, "");

    /**
     * The column <code>chrono.crrancelladv.FREQ19</code>.
     */
    public final TableField<CrrancelladvRecord, String> FREQ19 = createField("FREQ19", org.jooq.impl.SQLDataType.CHAR(8), this, "");

    /**
     * The column <code>chrono.crrancelladv.FREQ20</code>.
     */
    public final TableField<CrrancelladvRecord, String> FREQ20 = createField("FREQ20", org.jooq.impl.SQLDataType.CHAR(8), this, "");

    /**
     * The column <code>chrono.crrancelladv.FREQ21</code>.
     */
    public final TableField<CrrancelladvRecord, String> FREQ21 = createField("FREQ21", org.jooq.impl.SQLDataType.CHAR(8), this, "");

    /**
     * The column <code>chrono.crrancelladv.FREQ22</code>.
     */
    public final TableField<CrrancelladvRecord, String> FREQ22 = createField("FREQ22", org.jooq.impl.SQLDataType.CHAR(8), this, "");

    /**
     * The column <code>chrono.crrancelladv.FREQ23</code>.
     */
    public final TableField<CrrancelladvRecord, String> FREQ23 = createField("FREQ23", org.jooq.impl.SQLDataType.CHAR(8), this, "");

    /**
     * The column <code>chrono.crrancelladv.FREQ24</code>.
     */
    public final TableField<CrrancelladvRecord, String> FREQ24 = createField("FREQ24", org.jooq.impl.SQLDataType.CHAR(8), this, "");

    /**
     * The column <code>chrono.crrancelladv.FREQ25</code>.
     */
    public final TableField<CrrancelladvRecord, String> FREQ25 = createField("FREQ25", org.jooq.impl.SQLDataType.CHAR(8), this, "");

    /**
     * The column <code>chrono.crrancelladv.FREQ26</code>.
     */
    public final TableField<CrrancelladvRecord, String> FREQ26 = createField("FREQ26", org.jooq.impl.SQLDataType.CHAR(8), this, "");

    /**
     * The column <code>chrono.crrancelladv.FREQ27</code>.
     */
    public final TableField<CrrancelladvRecord, String> FREQ27 = createField("FREQ27", org.jooq.impl.SQLDataType.CHAR(8), this, "");

    /**
     * The column <code>chrono.crrancelladv.FREQ28</code>.
     */
    public final TableField<CrrancelladvRecord, String> FREQ28 = createField("FREQ28", org.jooq.impl.SQLDataType.CHAR(8), this, "");

    /**
     * The column <code>chrono.crrancelladv.FREQ29</code>.
     */
    public final TableField<CrrancelladvRecord, String> FREQ29 = createField("FREQ29", org.jooq.impl.SQLDataType.CHAR(8), this, "");

    /**
     * The column <code>chrono.crrancelladv.FREQ30</code>.
     */
    public final TableField<CrrancelladvRecord, String> FREQ30 = createField("FREQ30", org.jooq.impl.SQLDataType.CHAR(8), this, "");

    /**
     * The column <code>chrono.crrancelladv.FREQ31</code>.
     */
    public final TableField<CrrancelladvRecord, String> FREQ31 = createField("FREQ31", org.jooq.impl.SQLDataType.CHAR(8), this, "");

    /**
     * The column <code>chrono.crrancelladv.FREQ32</code>.
     */
    public final TableField<CrrancelladvRecord, String> FREQ32 = createField("FREQ32", org.jooq.impl.SQLDataType.CHAR(8), this, "");

    /**
     * The column <code>chrono.crrancelladv.ANEID</code>.
     */
    public final TableField<CrrancelladvRecord, String> ANEID = createField("ANEID", org.jooq.impl.SQLDataType.CHAR(8), this, "");

    /**
     * The column <code>chrono.crrancelladv.DLFREQ</code>.
     */
    public final TableField<CrrancelladvRecord, Double> DLFREQ = createField("DLFREQ", org.jooq.impl.SQLDataType.DOUBLE, this, "");

    /**
     * The column <code>chrono.crrancelladv.ULFREQ</code>.
     */
    public final TableField<CrrancelladvRecord, Double> ULFREQ = createField("ULFREQ", org.jooq.impl.SQLDataType.DOUBLE, this, "");

    /**
     * The column <code>chrono.crrancelladv.BTSTYPE</code>.
     */
    public final TableField<CrrancelladvRecord, String> BTSTYPE = createField("BTSTYPE", org.jooq.impl.SQLDataType.CHAR(32), this, "");

    /**
     * The column <code>chrono.crrancelladv.BANDWIDTH</code>.
     */
    public final TableField<CrrancelladvRecord, Double> BANDWIDTH = createField("BANDWIDTH", org.jooq.impl.SQLDataType.DOUBLE, this, "");

    /**
     * The column <code>chrono.crrancelladv.CELLNO</code>.
     */
    public final TableField<CrrancelladvRecord, Integer> CELLNO = createField("CELLNO", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.crrancelladv.STATUS</code>.
     */
    public final TableField<CrrancelladvRecord, String> STATUS = createField("STATUS", org.jooq.impl.SQLDataType.CHAR(32), this, "");

    /**
     * The column <code>chrono.crrancelladv.FLAG1</code>.
     */
    public final TableField<CrrancelladvRecord, String> FLAG1 = createField("FLAG1", org.jooq.impl.SQLDataType.CHAR(64), this, "");

    /**
     * The column <code>chrono.crrancelladv.FLAG2</code>.
     */
    public final TableField<CrrancelladvRecord, String> FLAG2 = createField("FLAG2", org.jooq.impl.SQLDataType.CHAR(64), this, "");

    /**
     * The column <code>chrono.crrancelladv.FLAG3</code>.
     */
    public final TableField<CrrancelladvRecord, String> FLAG3 = createField("FLAG3", org.jooq.impl.SQLDataType.CHAR(64), this, "");

    /**
     * The column <code>chrono.crrancelladv.FLAG4</code>.
     */
    public final TableField<CrrancelladvRecord, String> FLAG4 = createField("FLAG4", org.jooq.impl.SQLDataType.CHAR(64), this, "");

    /**
     * The column <code>chrono.crrancelladv.FLAG5</code>.
     */
    public final TableField<CrrancelladvRecord, String> FLAG5 = createField("FLAG5", org.jooq.impl.SQLDataType.CHAR(64), this, "");

    /**
     * The column <code>chrono.crrancelladv.FLAG6</code>.
     */
    public final TableField<CrrancelladvRecord, String> FLAG6 = createField("FLAG6", org.jooq.impl.SQLDataType.CHAR(64), this, "");

    /**
     * The column <code>chrono.crrancelladv.FLAG7</code>.
     */
    public final TableField<CrrancelladvRecord, String> FLAG7 = createField("FLAG7", org.jooq.impl.SQLDataType.CHAR(64), this, "");

    /**
     * The column <code>chrono.crrancelladv.FLAG8</code>.
     */
    public final TableField<CrrancelladvRecord, String> FLAG8 = createField("FLAG8", org.jooq.impl.SQLDataType.CHAR(64), this, "");

    /**
     * The column <code>chrono.crrancelladv.maximumTransmissionPower</code>.
     */
    public final TableField<CrrancelladvRecord, String> MAXIMUMTRANSMISSIONPOWER = createField("maximumTransmissionPower", org.jooq.impl.SQLDataType.CHAR(8), this, "");

    /**
     * The column <code>chrono.crrancelladv.MOID</code>.
     */
    public final TableField<CrrancelladvRecord, String> MOID = createField("MOID", org.jooq.impl.SQLDataType.CHAR(96), this, "");

    /**
     * The column <code>chrono.crrancelladv.TXBW</code>.
     */
    public final TableField<CrrancelladvRecord, String> TXBW = createField("TXBW", org.jooq.impl.SQLDataType.CHAR(8), this, "");

    /**
     * The column <code>chrono.crrancelladv.RXBW</code>.
     */
    public final TableField<CrrancelladvRecord, String> RXBW = createField("RXBW", org.jooq.impl.SQLDataType.CHAR(8), this, "");

    /**
     * The column <code>chrono.crrancelladv.userPlaneGbrAdmBandwidthDl</code>.
     */
    public final TableField<CrrancelladvRecord, String> USERPLANEGBRADMBANDWIDTHDL = createField("userPlaneGbrAdmBandwidthDl", org.jooq.impl.SQLDataType.CHAR(8), this, "");

    /**
     * The column <code>chrono.crrancelladv.userPlaneGbrAdmBandwidthUl</code>.
     */
    public final TableField<CrrancelladvRecord, String> USERPLANEGBRADMBANDWIDTHUL = createField("userPlaneGbrAdmBandwidthUl", org.jooq.impl.SQLDataType.CHAR(8), this, "");

    /**
     * The column <code>chrono.crrancelladv.LOCELL</code>.
     */
    public final TableField<CrrancelladvRecord, String> LOCELL = createField("LOCELL", org.jooq.impl.SQLDataType.CHAR(12), this, "");

    /**
     * The column <code>chrono.crrancelladv.MAXTXPOWER</code>.
     */
    public final TableField<CrrancelladvRecord, String> MAXTXPOWER = createField("MAXTXPOWER", org.jooq.impl.SQLDataType.CHAR(8), this, "");

    /**
     * The column <code>chrono.crrancelladv.MAXHSDPAUSERNUM</code>.
     */
    public final TableField<CrrancelladvRecord, String> MAXHSDPAUSERNUM = createField("MAXHSDPAUSERNUM", org.jooq.impl.SQLDataType.CHAR(8), this, "");

    /**
     * The column <code>chrono.crrancelladv.MAXHSUPAUSERNUM</code>.
     */
    public final TableField<CrrancelladvRecord, String> MAXHSUPAUSERNUM = createField("MAXHSUPAUSERNUM", org.jooq.impl.SQLDataType.CHAR(8), this, "");

    /**
     * The column <code>chrono.crrancelladv.MaxDLPowerCapability</code>.
     */
    public final TableField<CrrancelladvRecord, String> MAXDLPOWERCAPABILITY = createField("MaxDLPowerCapability", org.jooq.impl.SQLDataType.CHAR(8), this, "");

    /**
     * The column <code>chrono.crrancelladv.RBSIUBID</code>.
     */
    public final TableField<CrrancelladvRecord, String> RBSIUBID = createField("RBSIUBID", org.jooq.impl.SQLDataType.CHAR(32), this, "");

    /**
     * The column <code>chrono.crrancelladv.channel1Type</code>.
     */
    public final TableField<CrrancelladvRecord, Integer> CHANNEL1TYPE = createField("channel1Type", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.crrancelladv.channel2Type</code>.
     */
    public final TableField<CrrancelladvRecord, Integer> CHANNEL2TYPE = createField("channel2Type", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.crrancelladv.channel3Type</code>.
     */
    public final TableField<CrrancelladvRecord, Integer> CHANNEL3TYPE = createField("channel3Type", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.crrancelladv.channel4Type</code>.
     */
    public final TableField<CrrancelladvRecord, Integer> CHANNEL4TYPE = createField("channel4Type", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.crrancelladv.channel5Type</code>.
     */
    public final TableField<CrrancelladvRecord, Integer> CHANNEL5TYPE = createField("channel5Type", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.crrancelladv.channel6Type</code>.
     */
    public final TableField<CrrancelladvRecord, Integer> CHANNEL6TYPE = createField("channel6Type", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.crrancelladv.channel7Type</code>.
     */
    public final TableField<CrrancelladvRecord, Integer> CHANNEL7TYPE = createField("channel7Type", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.crrancelladv.ANI</code>.
     */
    public final TableField<CrrancelladvRecord, String> ANI = createField("ANI", org.jooq.impl.SQLDataType.CHAR(8), this, "");

    /**
     * The column <code>chrono.crrancelladv.FLEXBW</code>.
     */
    public final TableField<CrrancelladvRecord, Double> FLEXBW = createField("FLEXBW", org.jooq.impl.SQLDataType.DOUBLE, this, "");

    /**
     * The column <code>chrono.crrancelladv.channel0Type</code>.
     */
    public final TableField<CrrancelladvRecord, Integer> CHANNEL0TYPE = createField("channel0Type", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.crrancelladv.rancell_antenna</code>.
     */
    public final TableField<CrrancelladvRecord, Integer> RANCELL_ANTENNA = createField("rancell_antenna", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * Create a <code>chrono.crrancelladv</code> table reference
     */
    public Crrancelladv() {
        this(DSL.name("crrancelladv"), null);
    }

    /**
     * Create an aliased <code>chrono.crrancelladv</code> table reference
     */
    public Crrancelladv(String alias) {
        this(DSL.name(alias), CRRANCELLADV);
    }

    /**
     * Create an aliased <code>chrono.crrancelladv</code> table reference
     */
    public Crrancelladv(Name alias) {
        this(alias, CRRANCELLADV);
    }

    private Crrancelladv(Name alias, Table<CrrancelladvRecord> aliased) {
        this(alias, aliased, null);
    }

    private Crrancelladv(Name alias, Table<CrrancelladvRecord> aliased, Field<?>[] parameters) {
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
    public UniqueKey<CrrancelladvRecord> getPrimaryKey() {
        return Keys.KEY_CRRANCELLADV_PRIMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<CrrancelladvRecord>> getKeys() {
        return Arrays.<UniqueKey<CrrancelladvRecord>>asList(Keys.KEY_CRRANCELLADV_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Crrancelladv as(String alias) {
        return new Crrancelladv(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Crrancelladv as(Name alias) {
        return new Crrancelladv(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Crrancelladv rename(String name) {
        return new Crrancelladv(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Crrancelladv rename(Name name) {
        return new Crrancelladv(name, null);
    }
}

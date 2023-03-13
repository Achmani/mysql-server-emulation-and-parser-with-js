/*
 * This file is generated by jOOQ.
*/
package id.mit.chrono.server.model.tables;


import id.mit.chrono.server.model.Chrono;
import id.mit.chrono.server.model.Keys;
import id.mit.chrono.server.model.tables.records.CrstaticlcellRecord;

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
public class Crstaticlcell extends TableImpl<CrstaticlcellRecord> {

    private static final long serialVersionUID = 424239164;

    /**
     * The reference instance of <code>chrono.crstaticlcell</code>
     */
    public static final Crstaticlcell CRSTATICLCELL = new Crstaticlcell();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<CrstaticlcellRecord> getRecordType() {
        return CrstaticlcellRecord.class;
    }

    /**
     * The column <code>chrono.crstaticlcell.staticlcell_id</code>.
     */
    public final TableField<CrstaticlcellRecord, UInteger> STATICLCELL_ID = createField("staticlcell_id", org.jooq.impl.SQLDataType.INTEGERUNSIGNED.nullable(false), this, "");

    /**
     * The column <code>chrono.crstaticlcell.staticlcell_site</code>.
     */
    public final TableField<CrstaticlcellRecord, Integer> STATICLCELL_SITE = createField("staticlcell_site", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.crstaticlcell.staticlcell_ne</code>.
     */
    public final TableField<CrstaticlcellRecord, Integer> STATICLCELL_NE = createField("staticlcell_ne", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>chrono.crstaticlcell.staticlcell_siteid</code>.
     */
    public final TableField<CrstaticlcellRecord, String> STATICLCELL_SITEID = createField("staticlcell_siteid", org.jooq.impl.SQLDataType.CHAR(15), this, "");

    /**
     * The column <code>chrono.crstaticlcell.staticlcell_neid</code>.
     */
    public final TableField<CrstaticlcellRecord, String> STATICLCELL_NEID = createField("staticlcell_neid", org.jooq.impl.SQLDataType.CHAR(15), this, "");

    /**
     * The column <code>chrono.crstaticlcell.staticlcell_newsitename</code>.
     */
    public final TableField<CrstaticlcellRecord, String> STATICLCELL_NEWSITENAME = createField("staticlcell_newsitename", org.jooq.impl.SQLDataType.CHAR(55), this, "");

    /**
     * The column <code>chrono.crstaticlcell.staticlcell_newcellname</code>.
     */
    public final TableField<CrstaticlcellRecord, String> STATICLCELL_NEWCELLNAME = createField("staticlcell_newcellname", org.jooq.impl.SQLDataType.CHAR(55), this, "");

    /**
     * The column <code>chrono.crstaticlcell.staticlcell_village</code>.
     */
    public final TableField<CrstaticlcellRecord, String> STATICLCELL_VILLAGE = createField("staticlcell_village", org.jooq.impl.SQLDataType.CHAR(55), this, "");

    /**
     * The column <code>chrono.crstaticlcell.staticlcell_finalvillage</code>.
     */
    public final TableField<CrstaticlcellRecord, String> STATICLCELL_FINALVILLAGE = createField("staticlcell_finalvillage", org.jooq.impl.SQLDataType.CHAR(55), this, "");

    /**
     * The column <code>chrono.crstaticlcell.staticlcell_subdistrict</code>.
     */
    public final TableField<CrstaticlcellRecord, String> STATICLCELL_SUBDISTRICT = createField("staticlcell_subdistrict", org.jooq.impl.SQLDataType.CHAR(55), this, "");

    /**
     * The column <code>chrono.crstaticlcell.staticlcell_city</code>.
     */
    public final TableField<CrstaticlcellRecord, String> STATICLCELL_CITY = createField("staticlcell_city", org.jooq.impl.SQLDataType.CHAR(55), this, "");

    /**
     * The column <code>chrono.crstaticlcell.staticlcell_province</code>.
     */
    public final TableField<CrstaticlcellRecord, String> STATICLCELL_PROVINCE = createField("staticlcell_province", org.jooq.impl.SQLDataType.CHAR(55), this, "");

    /**
     * The column <code>chrono.crstaticlcell.staticlcell_latsys</code>.
     */
    public final TableField<CrstaticlcellRecord, String> STATICLCELL_LATSYS = createField("staticlcell_latsys", org.jooq.impl.SQLDataType.CHAR(55), this, "");

    /**
     * The column <code>chrono.crstaticlcell.staticlcell_longsys</code>.
     */
    public final TableField<CrstaticlcellRecord, String> STATICLCELL_LONGSYS = createField("staticlcell_longsys", org.jooq.impl.SQLDataType.CHAR(55), this, "");

    /**
     * The column <code>chrono.crstaticlcell.staticlcell_latdt</code>.
     */
    public final TableField<CrstaticlcellRecord, String> STATICLCELL_LATDT = createField("staticlcell_latdt", org.jooq.impl.SQLDataType.CHAR(55), this, "");

    /**
     * The column <code>chrono.crstaticlcell.staticlcell_longdt</code>.
     */
    public final TableField<CrstaticlcellRecord, String> STATICLCELL_LONGDT = createField("staticlcell_longdt", org.jooq.impl.SQLDataType.CHAR(55), this, "");

    /**
     * The column <code>chrono.crstaticlcell.staticlcell_region</code>.
     */
    public final TableField<CrstaticlcellRecord, String> STATICLCELL_REGION = createField("staticlcell_region", org.jooq.impl.SQLDataType.CHAR(55), this, "");

    /**
     * The column <code>chrono.crstaticlcell.staticlcell_area</code>.
     */
    public final TableField<CrstaticlcellRecord, String> STATICLCELL_AREA = createField("staticlcell_area", org.jooq.impl.SQLDataType.CHAR(55), this, "");

    /**
     * The column <code>chrono.crstaticlcell.staticlcell_neighbourcountry</code>.
     */
    public final TableField<CrstaticlcellRecord, String> STATICLCELL_NEIGHBOURCOUNTRY = createField("staticlcell_neighbourcountry", org.jooq.impl.SQLDataType.CHAR(55), this, "");

    /**
     * The column <code>chrono.crstaticlcell.staticlcell_project</code>.
     */
    public final TableField<CrstaticlcellRecord, String> STATICLCELL_PROJECT = createField("staticlcell_project", org.jooq.impl.SQLDataType.CHAR(55), this, "");

    /**
     * The column <code>chrono.crstaticlcell.staticlcell_projecttracking</code>.
     */
    public final TableField<CrstaticlcellRecord, String> STATICLCELL_PROJECTTRACKING = createField("staticlcell_projecttracking", org.jooq.impl.SQLDataType.CHAR(55), this, "");

    /**
     * The column <code>chrono.crstaticlcell.staticlcell_sitetype</code>.
     */
    public final TableField<CrstaticlcellRecord, String> STATICLCELL_SITETYPE = createField("staticlcell_sitetype", org.jooq.impl.SQLDataType.CHAR(55), this, "");

    /**
     * The column <code>chrono.crstaticlcell.staticlcell_connecteddate</code>.
     */
    public final TableField<CrstaticlcellRecord, Date> STATICLCELL_CONNECTEDDATE = createField("staticlcell_connecteddate", org.jooq.impl.SQLDataType.DATE, this, "");

    /**
     * The column <code>chrono.crstaticlcell.staticlcell_oadate</code>.
     */
    public final TableField<CrstaticlcellRecord, Date> STATICLCELL_OADATE = createField("staticlcell_oadate", org.jooq.impl.SQLDataType.DATE, this, "");

    /**
     * The column <code>chrono.crstaticlcell.staticlcell_system</code>.
     */
    public final TableField<CrstaticlcellRecord, String> STATICLCELL_SYSTEM = createField("staticlcell_system", org.jooq.impl.SQLDataType.CHAR(55), this, "");

    /**
     * The column <code>chrono.crstaticlcell.staticlcell_type</code>.
     */
    public final TableField<CrstaticlcellRecord, String> STATICLCELL_TYPE = createField("staticlcell_type", org.jooq.impl.SQLDataType.CHAR(55), this, "");

    /**
     * The column <code>chrono.crstaticlcell.staticlcell_band</code>.
     */
    public final TableField<CrstaticlcellRecord, String> STATICLCELL_BAND = createField("staticlcell_band", org.jooq.impl.SQLDataType.CHAR(55), this, "");

    /**
     * The column <code>chrono.crstaticlcell.staticlcell_btsmode</code>.
     */
    public final TableField<CrstaticlcellRecord, String> STATICLCELL_BTSMODE = createField("staticlcell_btsmode", org.jooq.impl.SQLDataType.CHAR(55), this, "");

    /**
     * The column <code>chrono.crstaticlcell.staticlcell_site2g</code>.
     */
    public final TableField<CrstaticlcellRecord, String> STATICLCELL_SITE2G = createField("staticlcell_site2g", org.jooq.impl.SQLDataType.CHAR(55), this, "");

    /**
     * The column <code>chrono.crstaticlcell.staticlcell_cell2g</code>.
     */
    public final TableField<CrstaticlcellRecord, String> STATICLCELL_CELL2G = createField("staticlcell_cell2g", org.jooq.impl.SQLDataType.CHAR(55), this, "");

    /**
     * The column <code>chrono.crstaticlcell.staticlcell_site4g</code>.
     */
    public final TableField<CrstaticlcellRecord, String> STATICLCELL_SITE4G = createField("staticlcell_site4g", org.jooq.impl.SQLDataType.CHAR(55), this, "");

    /**
     * The column <code>chrono.crstaticlcell.staticlcell_cell4g</code>.
     */
    public final TableField<CrstaticlcellRecord, String> STATICLCELL_CELL4G = createField("staticlcell_cell4g", org.jooq.impl.SQLDataType.CHAR(55), this, "");

    /**
     * The column <code>chrono.crstaticlcell.staticlcell_btsconfig</code>.
     */
    public final TableField<CrstaticlcellRecord, String> STATICLCELL_BTSCONFIG = createField("staticlcell_btsconfig", org.jooq.impl.SQLDataType.CHAR(55), this, "");

    /**
     * The column <code>chrono.crstaticlcell.staticlcell_btssector</code>.
     */
    public final TableField<CrstaticlcellRecord, String> STATICLCELL_BTSSECTOR = createField("staticlcell_btssector", org.jooq.impl.SQLDataType.CHAR(55), this, "");

    /**
     * The column <code>chrono.crstaticlcell.staticlcell_trxorcell</code>.
     */
    public final TableField<CrstaticlcellRecord, String> STATICLCELL_TRXORCELL = createField("staticlcell_trxorcell", org.jooq.impl.SQLDataType.CHAR(55), this, "");

    /**
     * The column <code>chrono.crstaticlcell.staticlcell_lac</code>.
     */
    public final TableField<CrstaticlcellRecord, String> STATICLCELL_LAC = createField("staticlcell_lac", org.jooq.impl.SQLDataType.CHAR(55), this, "");

    /**
     * The column <code>chrono.crstaticlcell.staticlcell_ci</code>.
     */
    public final TableField<CrstaticlcellRecord, String> STATICLCELL_CI = createField("staticlcell_ci", org.jooq.impl.SQLDataType.CHAR(55), this, "");

    /**
     * The column <code>chrono.crstaticlcell.staticlcell_bscname</code>.
     */
    public final TableField<CrstaticlcellRecord, String> STATICLCELL_BSCNAME = createField("staticlcell_bscname", org.jooq.impl.SQLDataType.CHAR(55), this, "");

    /**
     * The column <code>chrono.crstaticlcell.staticlcell_bsctype</code>.
     */
    public final TableField<CrstaticlcellRecord, String> STATICLCELL_BSCTYPE = createField("staticlcell_bsctype", org.jooq.impl.SQLDataType.CHAR(55), this, "");

    /**
     * The column <code>chrono.crstaticlcell.staticlcell_bscspc</code>.
     */
    public final TableField<CrstaticlcellRecord, String> STATICLCELL_BSCSPC = createField("staticlcell_bscspc", org.jooq.impl.SQLDataType.CHAR(55), this, "");

    /**
     * The column <code>chrono.crstaticlcell.staticlcell_rac</code>.
     */
    public final TableField<CrstaticlcellRecord, String> STATICLCELL_RAC = createField("staticlcell_rac", org.jooq.impl.SQLDataType.CHAR(55), this, "");

    /**
     * The column <code>chrono.crstaticlcell.staticlcell_mssspc</code>.
     */
    public final TableField<CrstaticlcellRecord, String> STATICLCELL_MSSSPC = createField("staticlcell_mssspc", org.jooq.impl.SQLDataType.CHAR(55), this, "");

    /**
     * The column <code>chrono.crstaticlcell.staticlcell_mgwname</code>.
     */
    public final TableField<CrstaticlcellRecord, String> STATICLCELL_MGWNAME = createField("staticlcell_mgwname", org.jooq.impl.SQLDataType.CHAR(55), this, "");

    /**
     * The column <code>chrono.crstaticlcell.staticlcell_mssname</code>.
     */
    public final TableField<CrstaticlcellRecord, String> STATICLCELL_MSSNAME = createField("staticlcell_mssname", org.jooq.impl.SQLDataType.CHAR(55), this, "");

    /**
     * The column <code>chrono.crstaticlcell.staticlcell_sgsn</code>.
     */
    public final TableField<CrstaticlcellRecord, String> STATICLCELL_SGSN = createField("staticlcell_sgsn", org.jooq.impl.SQLDataType.CHAR(55), this, "");

    /**
     * The column <code>chrono.crstaticlcell.staticlcell_tal</code>.
     */
    public final TableField<CrstaticlcellRecord, String> STATICLCELL_TAL = createField("staticlcell_tal", org.jooq.impl.SQLDataType.CHAR(55), this, "");

    /**
     * The column <code>chrono.crstaticlcell.staticlcell_tac</code>.
     */
    public final TableField<CrstaticlcellRecord, String> STATICLCELL_TAC = createField("staticlcell_tac", org.jooq.impl.SQLDataType.CHAR(55), this, "");

    /**
     * The column <code>chrono.crstaticlcell.staticlcell_cellid</code>.
     */
    public final TableField<CrstaticlcellRecord, String> STATICLCELL_CELLID = createField("staticlcell_cellid", org.jooq.impl.SQLDataType.CHAR(55), this, "");

    /**
     * The column <code>chrono.crstaticlcell.staticlcell_enodebid</code>.
     */
    public final TableField<CrstaticlcellRecord, String> STATICLCELL_ENODEBID = createField("staticlcell_enodebid", org.jooq.impl.SQLDataType.CHAR(55), this, "");

    /**
     * The column <code>chrono.crstaticlcell.staticlcell_pci</code>.
     */
    public final TableField<CrstaticlcellRecord, String> STATICLCELL_PCI = createField("staticlcell_pci", org.jooq.impl.SQLDataType.CHAR(55), this, "");

    /**
     * The column <code>chrono.crstaticlcell.staticlcell_ulearfcn</code>.
     */
    public final TableField<CrstaticlcellRecord, String> STATICLCELL_ULEARFCN = createField("staticlcell_ulearfcn", org.jooq.impl.SQLDataType.CHAR(55), this, "");

    /**
     * The column <code>chrono.crstaticlcell.staticlcell_dlearfcn</code>.
     */
    public final TableField<CrstaticlcellRecord, String> STATICLCELL_DLEARFCN = createField("staticlcell_dlearfcn", org.jooq.impl.SQLDataType.CHAR(55), this, "");

    /**
     * The column <code>chrono.crstaticlcell.staticlcell_mme</code>.
     */
    public final TableField<CrstaticlcellRecord, String> STATICLCELL_MME = createField("staticlcell_mme", org.jooq.impl.SQLDataType.CHAR(55), this, "");

    /**
     * The column <code>chrono.crstaticlcell.staticlcell_sgw</code>.
     */
    public final TableField<CrstaticlcellRecord, String> STATICLCELL_SGW = createField("staticlcell_sgw", org.jooq.impl.SQLDataType.CHAR(55), this, "");

    /**
     * The column <code>chrono.crstaticlcell.staticlcell_btsprovider</code>.
     */
    public final TableField<CrstaticlcellRecord, String> STATICLCELL_BTSPROVIDER = createField("staticlcell_btsprovider", org.jooq.impl.SQLDataType.CHAR(55), this, "");

    /**
     * The column <code>chrono.crstaticlcell.staticlcell_antennaprovider</code>.
     */
    public final TableField<CrstaticlcellRecord, String> STATICLCELL_ANTENNAPROVIDER = createField("staticlcell_antennaprovider", org.jooq.impl.SQLDataType.CHAR(55), this, "");

    /**
     * The column <code>chrono.crstaticlcell.staticlcell_towerprovider</code>.
     */
    public final TableField<CrstaticlcellRecord, String> STATICLCELL_TOWERPROVIDER = createField("staticlcell_towerprovider", org.jooq.impl.SQLDataType.CHAR(55), this, "");

    /**
     * The column <code>chrono.crstaticlcell.staticlcell_powerprovider</code>.
     */
    public final TableField<CrstaticlcellRecord, String> STATICLCELL_POWERPROVIDER = createField("staticlcell_powerprovider", org.jooq.impl.SQLDataType.CHAR(55), this, "");

    /**
     * The column <code>chrono.crstaticlcell.staticlcell_transmissionprovider</code>.
     */
    public final TableField<CrstaticlcellRecord, String> STATICLCELL_TRANSMISSIONPROVIDER = createField("staticlcell_transmissionprovider", org.jooq.impl.SQLDataType.CHAR(55), this, "");

    /**
     * The column <code>chrono.crstaticlcell.staticlcell_btspo</code>.
     */
    public final TableField<CrstaticlcellRecord, String> STATICLCELL_BTSPO = createField("staticlcell_btspo", org.jooq.impl.SQLDataType.CHAR(55), this, "");

    /**
     * The column <code>chrono.crstaticlcell.staticlcell_sdrornonsdr</code>.
     */
    public final TableField<CrstaticlcellRecord, String> STATICLCELL_SDRORNONSDR = createField("staticlcell_sdrornonsdr", org.jooq.impl.SQLDataType.CHAR(55), this, "");

    /**
     * The column <code>chrono.crstaticlcell.staticlcell_antennatype</code>.
     */
    public final TableField<CrstaticlcellRecord, String> STATICLCELL_ANTENNATYPE = createField("staticlcell_antennatype", org.jooq.impl.SQLDataType.CHAR(55), this, "");

    /**
     * The column <code>chrono.crstaticlcell.staticlcell_towertype</code>.
     */
    public final TableField<CrstaticlcellRecord, String> STATICLCELL_TOWERTYPE = createField("staticlcell_towertype", org.jooq.impl.SQLDataType.CHAR(55), this, "");

    /**
     * The column <code>chrono.crstaticlcell.staticlcell_powertype1</code>.
     */
    public final TableField<CrstaticlcellRecord, String> STATICLCELL_POWERTYPE1 = createField("staticlcell_powertype1", org.jooq.impl.SQLDataType.CHAR(55), this, "");

    /**
     * The column <code>chrono.crstaticlcell.staticlcell_powertype2</code>.
     */
    public final TableField<CrstaticlcellRecord, String> STATICLCELL_POWERTYPE2 = createField("staticlcell_powertype2", org.jooq.impl.SQLDataType.CHAR(55), this, "");

    /**
     * The column <code>chrono.crstaticlcell.staticlcell_transmissiontype</code>.
     */
    public final TableField<CrstaticlcellRecord, String> STATICLCELL_TRANSMISSIONTYPE = createField("staticlcell_transmissiontype", org.jooq.impl.SQLDataType.CHAR(55), this, "");

    /**
     * The column <code>chrono.crstaticlcell.staticlcell_bwtransmission</code>.
     */
    public final TableField<CrstaticlcellRecord, String> STATICLCELL_BWTRANSMISSION = createField("staticlcell_bwtransmission", org.jooq.impl.SQLDataType.CHAR(55), this, "");

    /**
     * The column <code>chrono.crstaticlcell.staticlcell_btsprocurement</code>.
     */
    public final TableField<CrstaticlcellRecord, String> STATICLCELL_BTSPROCUREMENT = createField("staticlcell_btsprocurement", org.jooq.impl.SQLDataType.CHAR(55), this, "");

    /**
     * The column <code>chrono.crstaticlcell.staticlcell_antennaprocurement</code>.
     */
    public final TableField<CrstaticlcellRecord, String> STATICLCELL_ANTENNAPROCUREMENT = createField("staticlcell_antennaprocurement", org.jooq.impl.SQLDataType.CHAR(55), this, "");

    /**
     * The column <code>chrono.crstaticlcell.staticlcell_towerprocurement</code>.
     */
    public final TableField<CrstaticlcellRecord, String> STATICLCELL_TOWERPROCUREMENT = createField("staticlcell_towerprocurement", org.jooq.impl.SQLDataType.CHAR(55), this, "");

    /**
     * The column <code>chrono.crstaticlcell.staticlcell_powerprocurement</code>.
     */
    public final TableField<CrstaticlcellRecord, String> STATICLCELL_POWERPROCUREMENT = createField("staticlcell_powerprocurement", org.jooq.impl.SQLDataType.CHAR(55), this, "");

    /**
     * The column <code>chrono.crstaticlcell.staticlcell_transmissionprocurement</code>.
     */
    public final TableField<CrstaticlcellRecord, String> STATICLCELL_TRANSMISSIONPROCUREMENT = createField("staticlcell_transmissionprocurement", org.jooq.impl.SQLDataType.CHAR(55), this, "");

    /**
     * The column <code>chrono.crstaticlcell.staticlcell_antennarent</code>.
     */
    public final TableField<CrstaticlcellRecord, String> STATICLCELL_ANTENNARENT = createField("staticlcell_antennarent", org.jooq.impl.SQLDataType.CHAR(55), this, "");

    /**
     * The column <code>chrono.crstaticlcell.staticlcell_towerrent</code>.
     */
    public final TableField<CrstaticlcellRecord, String> STATICLCELL_TOWERRENT = createField("staticlcell_towerrent", org.jooq.impl.SQLDataType.CHAR(55), this, "");

    /**
     * The column <code>chrono.crstaticlcell.staticlcell_powerrent</code>.
     */
    public final TableField<CrstaticlcellRecord, String> STATICLCELL_POWERRENT = createField("staticlcell_powerrent", org.jooq.impl.SQLDataType.CHAR(55), this, "");

    /**
     * The column <code>chrono.crstaticlcell.staticlcell_vsatrent</code>.
     */
    public final TableField<CrstaticlcellRecord, String> STATICLCELL_VSATRENT = createField("staticlcell_vsatrent", org.jooq.impl.SQLDataType.CHAR(55), this, "");

    /**
     * The column <code>chrono.crstaticlcell.staticlcell_totalrent</code>.
     */
    public final TableField<CrstaticlcellRecord, String> STATICLCELL_TOTALRENT = createField("staticlcell_totalrent", org.jooq.impl.SQLDataType.CHAR(55), this, "");

    /**
     * The column <code>chrono.crstaticlcell.staticlcell_remarks</code>.
     */
    public final TableField<CrstaticlcellRecord, String> STATICLCELL_REMARKS = createField("staticlcell_remarks", org.jooq.impl.SQLDataType.CLOB, this, "");

    /**
     * The column <code>chrono.crstaticlcell.staticlcell_lac1</code>.
     */
    public final TableField<CrstaticlcellRecord, String> STATICLCELL_LAC1 = createField("staticlcell_lac1", org.jooq.impl.SQLDataType.CHAR(55), this, "");

    /**
     * The column <code>chrono.crstaticlcell.staticlcell_ci1</code>.
     */
    public final TableField<CrstaticlcellRecord, String> STATICLCELL_CI1 = createField("staticlcell_ci1", org.jooq.impl.SQLDataType.CHAR(55), this, "");

    /**
     * The column <code>chrono.crstaticlcell.staticlcell_lac2</code>.
     */
    public final TableField<CrstaticlcellRecord, String> STATICLCELL_LAC2 = createField("staticlcell_lac2", org.jooq.impl.SQLDataType.CHAR(55), this, "");

    /**
     * The column <code>chrono.crstaticlcell.staticlcell_ci2</code>.
     */
    public final TableField<CrstaticlcellRecord, String> STATICLCELL_CI2 = createField("staticlcell_ci2", org.jooq.impl.SQLDataType.CHAR(55), this, "");

    /**
     * The column <code>chrono.crstaticlcell.staticlcell_lac3</code>.
     */
    public final TableField<CrstaticlcellRecord, String> STATICLCELL_LAC3 = createField("staticlcell_lac3", org.jooq.impl.SQLDataType.CHAR(55), this, "");

    /**
     * The column <code>chrono.crstaticlcell.staticlcell_ci3</code>.
     */
    public final TableField<CrstaticlcellRecord, String> STATICLCELL_CI3 = createField("staticlcell_ci3", org.jooq.impl.SQLDataType.CHAR(55), this, "");

    /**
     * The column <code>chrono.crstaticlcell.staticlcell_crorco</code>.
     */
    public final TableField<CrstaticlcellRecord, String> STATICLCELL_CRORCO = createField("staticlcell_crorco", org.jooq.impl.SQLDataType.CHAR(55), this, "");

    /**
     * The column <code>chrono.crstaticlcell.staticlcell_tariffzone</code>.
     */
    public final TableField<CrstaticlcellRecord, String> STATICLCELL_TARIFFZONE = createField("staticlcell_tariffzone", org.jooq.impl.SQLDataType.CHAR(55), this, "");

    /**
     * Create a <code>chrono.crstaticlcell</code> table reference
     */
    public Crstaticlcell() {
        this(DSL.name("crstaticlcell"), null);
    }

    /**
     * Create an aliased <code>chrono.crstaticlcell</code> table reference
     */
    public Crstaticlcell(String alias) {
        this(DSL.name(alias), CRSTATICLCELL);
    }

    /**
     * Create an aliased <code>chrono.crstaticlcell</code> table reference
     */
    public Crstaticlcell(Name alias) {
        this(alias, CRSTATICLCELL);
    }

    private Crstaticlcell(Name alias, Table<CrstaticlcellRecord> aliased) {
        this(alias, aliased, null);
    }

    private Crstaticlcell(Name alias, Table<CrstaticlcellRecord> aliased, Field<?>[] parameters) {
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
    public UniqueKey<CrstaticlcellRecord> getPrimaryKey() {
        return Keys.KEY_CRSTATICLCELL_PRIMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<CrstaticlcellRecord>> getKeys() {
        return Arrays.<UniqueKey<CrstaticlcellRecord>>asList(Keys.KEY_CRSTATICLCELL_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Crstaticlcell as(String alias) {
        return new Crstaticlcell(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Crstaticlcell as(Name alias) {
        return new Crstaticlcell(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Crstaticlcell rename(String name) {
        return new Crstaticlcell(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Crstaticlcell rename(Name name) {
        return new Crstaticlcell(name, null);
    }
}
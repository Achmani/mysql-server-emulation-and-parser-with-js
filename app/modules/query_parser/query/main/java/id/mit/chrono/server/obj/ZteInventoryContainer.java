package id.mit.chrono.server.obj;

import com.jcraft.jsch.Logger;
import id.mit.chrono.server.base.BaseParserGroup;
import id.mit.chrono.server.base.ZteBaseContainer;
import id.mit.chrono.server.enm.PS;
import id.mit.chrono.server.iface.FileProcessor;
import id.mit.chrono.server.iface.ParserGroupCallback;
import id.mit.chrono.server.model.tables.records.*;
import id.mit.chrono.server.util.GeoUtil;
import id.mit.chrono.server.util.GsmNetworkUtils;
import org.jooq.*;
import org.jooq.impl.DSL;
import org.jooq.types.UInteger;
import org.jooq.types.ULong;
import id.mit.chrono.server.model.tables.records.*;
import org.slf4j.LoggerFactory;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;
import java.util.Date;

import static id.mit.chrono.server.model.Tables.*;

public class ZteInventoryContainer extends ZteBaseContainer implements FileProcessor {

    private HwenodebRecord hwenodeb;
    private CrnodeRecord node;
    private List<HwlcellRecord> lcells = new ArrayList<>();
    private Result<Record> select;
    private Result<Record> inventoryValidation;
    private Result<Record> checkInventoryValidation;
    private Result<Record> selectSite;
    private HashMap<String, Integer> siteValue = new HashMap<String, Integer>();
    private HashMap<String, String> zteValidation = new HashMap<String, String>();

    public static int counter = 0;

    public ZteInventoryContainer(DSLContext db, ParserGroupCallback pgc, ChronoContext context, SourceFile sf, MapEntityObj meo) {
        super(db, pgc, context, sf, meo);
        logger = LoggerFactory.getLogger(this.getClass() + ":" + sf.getTaskFilesId());
    }

    @Override
    public boolean process(DSLContext adb, PS state) {
        return true;
    }

    @Override
    public boolean processAll(DSLContext adb) {

        resetStopwatch();

        this.prepareKeyParamsResult(adb);
        addMeasurement(PS.PREPARE, this.getKey(), true);

        this.prepareInventory(adb);
        addMeasurement(PS.INVENTORY, this.getKey(), true);

        this.clearUnusedData(adb);
        addMeasurement(PS.FINALIZE, this.getKey(), true);

        saveStatistics(adb);

        return true;
    }

    private void prepareInventory(DSLContext db) {

        logger.debug("prepareInventory()");
        System.out.println("-------");
        System.out.println("File ID: " + sf.getTaskFilesId());
        System.out.println("-------");

        // get Inventory list
        List<ZteBasicKeyParamsObj> inventories = result.stream()
                .filter(ZteBasicKeyParamsObj.class::isInstance)
                .map(ZteBasicKeyParamsObj.class::cast)
                .filter(p -> p.group.equals("Inventory_minos"))
                .collect(Collectors.toList());

        System.out.println("inventories.size(): " + inventories.size());

        ZteBasicKeyParamsObj temp;

        int collectorTask = 0, vendor = 0, zteSite = 0, isFirst = 1;
        String neName, inventoryUnitType, vendorUnitFamilyType, vendorUnitTypeNumber, vendorName, serialNumber,
                versionNumber, dateOfManufacture, dateOfLastService, unitPosition, manufacturerData, systemVersion,
                packSilkscreen, packFunction, subCardInfo, NE, NEType, updatetime, source, state, Reserve1, Reserve2,
                Reserve11, telecomOperators, IP, ProductCode, insertTime;

        if (inventories.size() != 0) {
            select = db.select()
                    .from(CRCOLLECTORTASKFILES)
                    .join(CRDATASOURCE)
                    .on(CRDATASOURCE.DATASOURCE_ID.eq(CRCOLLECTORTASKFILES.COLLECTORTASKFILES_DATASOURCE))
                    .join(CRVENDOR)
                    .on(CRVENDOR.VENDOR_ID.eq(CRDATASOURCE.DATASOURCE_VENDOR))
                    .where(CRCOLLECTORTASKFILES.COLLECTORTASKFILES_ID.eq(sf.getTaskFilesId()))
                    .fetch();

            selectSite = db.select()
                    .from(CRSITE)
                    .where(CRSITE.SITE_CODE.isNotNull())
                    .fetch();

            for (Record r : select) {
                vendor = r.get(CRVENDOR.VENDOR_ID).intValue();
            }

            for (Record r : selectSite) {
                siteValue.put(r.get(CRSITE.SITE_CODE), r.get(CRSITE.SITE_ID).intValue());
            }

            for (int i = 0; i < inventories.size(); i++) {

                temp = inventories.get(i);

                neName = temp.params.get("UserLabel");
                inventoryUnitType = temp.params.get("inventoryUnitType");
                vendorUnitFamilyType = temp.params.get("vendorUnitFamilyType");
                vendorUnitTypeNumber = temp.params.get("vendorUnitTypeNumber");
                vendorName = temp.params.get("vendorName");
                serialNumber = temp.params.get("serialNumber");
                versionNumber = temp.params.get("versionNumber");
                dateOfManufacture = temp.params.get("dateOfManufacture");
                dateOfLastService = temp.params.get("dateOfLastService");
                unitPosition = temp.params.get("unitPosition");
                manufacturerData = temp.params.get("manufacturerData");
                systemVersion = temp.params.get("systemVersion");
                packSilkscreen = temp.params.get("packSilkscreen");
                packFunction = temp.params.get("packFunction");
                subCardInfo = temp.params.get("subCardInfo");
                NE = temp.params.get("NE");
                NEType = temp.params.get("NEType");
                updatetime = temp.params.get("updatetime");
                source = temp.params.get("source");
                state = temp.params.get("state");
                Reserve1 = temp.params.get("Reserve1");
                Reserve2 = temp.params.get("Reserve2");
                Reserve11 = temp.params.get("Reserve11");
                telecomOperators = temp.params.get("telecomOperators");
                IP = temp.params.get("IP");
                ProductCode = temp.params.get("ProductCode");
                Boolean duplicate = false;
                Boolean insertOrNot = true;
                String tempNeName = "";
                String siteIdName = "";

                if (neName.length() >= 2) {
                    if (neName.substring(1, 2).equalsIgnoreCase("_") || neName.substring(1, 2).equalsIgnoreCase("-") || neName.substring(1, 2).equalsIgnoreCase("+")) {
                        tempNeName = neName.substring(2);
                    } else {
                        tempNeName = neName;
                    }
                } else {
                    tempNeName = neName;
                }

                int siteId = 0;

                if (tempNeName.length() >= 6) {

                    tempNeName = tempNeName.substring(0, 6);

                    //pengecekan siteID with regex
                    if (tempNeName.matches("[A-Z]{3}[0-9]{3}")) {
                        siteIdName = tempNeName;
                    }

                    if (siteValue.get(tempNeName) != null) {
                        siteId = siteValue.get(tempNeName);
                    }
                }

                if (!serialNumber.isEmpty() && !neName.isEmpty()) {

                    Result<Record> selectSN = db.select()
                            .from(ZTEINVENTORY)
                            .where(ZTEINVENTORY.ZTEINVENTORY_SERIALNUMBER.eq(serialNumber))
                            .and(ZTEINVENTORY.ZTEINVENTORY_SITEID.eq(siteIdName))
                            .and(ZTEINVENTORY.ZTEINVENTORY_DATE.eq(context.getEpochTime()))
                            .fetch();

                    if (selectSN.isNotEmpty()) {
                        duplicate = true;
                        System.out.println("----======duplicate======---->>" + serialNumber);
                    } else {
                        duplicate = false;
                    }

                } else {
                    insertOrNot = false;
                }


                if (!duplicate && insertOrNot) {

                    Boolean resultValidation = false;

                    // get inventory validation
                    checkInventoryValidation = db.select()
                            .from(ZTEINVENTORYVALIDATION)
                            .where(ZTEINVENTORYVALIDATION.ZTEINVENTORYVALIDATION_SERIALNUMBER.eq(serialNumber))
                            .fetch();

                    for (Record r : checkInventoryValidation) {

                        zteValidation.put(r.get(ZTEINVENTORYVALIDATION.ZTEINVENTORYVALIDATION_SERIALNUMBER), r.get(ZTEINVENTORYVALIDATION.ZTEINVENTORYVALIDATION_LASTUPDATETIME));

                    }

                    try {

                        if (zteValidation.isEmpty()) {

                            db.insertInto(ZTEINVENTORYVALIDATION)
                                    .set(ZTEINVENTORYVALIDATION.ZTEINVENTORYVALIDATION_SERIALNUMBER, serialNumber)
                                    .set(ZTEINVENTORYVALIDATION.ZTEINVENTORYVALIDATION_LASTUPDATETIME, updatetime)
                                    .set(ZTEINVENTORYVALIDATION.ZTEINVENTORYVALIDATION_DATE, context.getEpochTime())
                                    .set(ZTEINVENTORYVALIDATION.ZTEINVENTORYVALIDATION_UPDATEDDATE, new Timestamp(System.currentTimeMillis()))
                                    .execute();

                            resultValidation = true;

                        } else {

                            if (zteValidation.get(serialNumber) == null) {

                                resultValidation = true;

                                db.insertInto(ZTEINVENTORYVALIDATION)
                                        .set(ZTEINVENTORYVALIDATION.ZTEINVENTORYVALIDATION_SERIALNUMBER, serialNumber)
                                        .set(ZTEINVENTORYVALIDATION.ZTEINVENTORYVALIDATION_LASTUPDATETIME, updatetime)
                                        .set(ZTEINVENTORYVALIDATION.ZTEINVENTORYVALIDATION_DATE, context.getEpochTime())
                                        .set(ZTEINVENTORYVALIDATION.ZTEINVENTORYVALIDATION_UPDATEDDATE, new Timestamp(System.currentTimeMillis()))
                                        .execute();

                            } else {

                                Long lastUpdateTime = 0L;
                                Long lastUpdateTimeNow = 0L;

                                try {

                                    Date lastUpdateTimeDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(zteValidation.get(serialNumber));
                                    lastUpdateTime = lastUpdateTimeDate.getTime();

                                    Date lastUpdateTimeDateNow = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(updatetime);
                                    lastUpdateTimeNow = lastUpdateTimeDateNow.getTime();

                                } catch (Exception e) {
                                    e.printStackTrace();
                                }

//                                System.out.println("--------");
//                                System.out.println("last: " + lastUpdateTime);
//                                System.out.println("now: " + lastUpdateTimeNow);
//                                System.out.println("SN: " + serialNumber);
//                                System.out.println("--------");

                                if (lastUpdateTimeNow > lastUpdateTime) {

                                    db.update(ZTEINVENTORYVALIDATION)
                                            .set(ZTEINVENTORYVALIDATION.ZTEINVENTORYVALIDATION_LASTUPDATETIME, updatetime)
                                            .set(ZTEINVENTORYVALIDATION.ZTEINVENTORYVALIDATION_UPDATEDDATE, new Timestamp(System.currentTimeMillis()))
                                            .where(ZTEINVENTORYVALIDATION.ZTEINVENTORYVALIDATION_SERIALNUMBER.eq(serialNumber))
                                            .execute();

//                                    System.out.println("bedaa");

                                    resultValidation = true;
                                } else {
                                    resultValidation = false;
                                }
                            }
                        }

                    } catch (Exception e) {
                        System.out.println(e);
                        System.out.println("SN: " + serialNumber);
                    }

                    zteValidation.clear();


                    if (resultValidation) {

                        System.out.println("SN: " + serialNumber);

                        db.insertInto(ZTEINVENTORY)
                                .set(ZTEINVENTORY.ZTEINVENTORY_DATE, context.getEpochTime())
                                .set(ZTEINVENTORY.ZTEINVENTORY_DATATYPE, 1)
                                .set(ZTEINVENTORY.ZTEINVENTORY_COLLECTORTASKFILES, sf.getTaskFilesId())
                                .set(ZTEINVENTORY.ZTEINVENTORY_VENDOR, vendor)
                                .set(ZTEINVENTORY.ZTEINVENTORY_SITE, siteId)
                                .set(ZTEINVENTORY.ZTEINVENTORY_SITEID, siteIdName)
                                .set(ZTEINVENTORY.ZTEINVENTORY_NENAME, neName)
                                .set(ZTEINVENTORY.ZTEINVENTORY_INVENTORYUNITTYPE, inventoryUnitType)
                                .set(ZTEINVENTORY.ZTEINVENTORY_VENDORUNITFAMILYTYPE, vendorUnitFamilyType)
                                .set(ZTEINVENTORY.ZTEINVENTORY_VENDORNAME, vendorName)
                                .set(ZTEINVENTORY.ZTEINVENTORY_SERIALNUMBER, serialNumber)
                                .set(ZTEINVENTORY.ZTEINVENTORY_VERSIONNUMBER, versionNumber)
                                .set(ZTEINVENTORY.ZTEINVENTORY_DATEOFMANUFACTURE, dateOfManufacture)
                                .set(ZTEINVENTORY.ZTEINVENTORY_UNITPOSITION, unitPosition)
                                .set(ZTEINVENTORY.ZTEINVENTORY_MANUFACTUREDATA, manufacturerData)
                                .set(ZTEINVENTORY.ZTEINVENTORY_PACKSILKSCREEN, packSilkscreen)
                                .set(ZTEINVENTORY.ZTEINVENTORY_PACKFUNCTION, packFunction)
                                .set(ZTEINVENTORY.ZTEINVENTORY_NE, NE)
                                .set(ZTEINVENTORY.ZTEINVENTORY_NETYPE, NEType)
                                .set(ZTEINVENTORY.ZTEINVENTORY_UPDATETIME, updatetime)
                                .set(ZTEINVENTORY.ZTEINVENTORY_SOURCE, source)
                                .set(ZTEINVENTORY.ZTEINVENTORY_STATE, state)
                                .set(ZTEINVENTORY.ZTEINVENTORY_RESERVE1, Reserve1)
                                .set(ZTEINVENTORY.ZTEINVENTORY_RESERVE2, Reserve2)
                                .set(ZTEINVENTORY.ZTEINVENTORY_RESERVE11, Reserve11)
                                .set(ZTEINVENTORY.ZTEINVENTORY_PRODUCTCODE, ProductCode)
                                .set(ZTEINVENTORY.ZTEINVENTORY_ISFIRST, isFirst)
                                .set(ZTEINVENTORY.ZTEINVENTORY_INSERTTIME, new Timestamp(System.currentTimeMillis()))
                                .execute();

                    }
                }
            }
        }

        logger.debug("prepareInventory() done");
    }

    private void clearUnusedData(DSLContext db) {

        this.sf.purgeResult();
        this.hwenodeb = null;
        this.result.clear();
        this.lcells.clear();
    }
}

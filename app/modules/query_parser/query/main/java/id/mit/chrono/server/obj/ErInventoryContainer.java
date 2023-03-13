package id.mit.chrono.server.obj;

import id.mit.chrono.server.base.ErBaseContainer;
import id.mit.chrono.server.enm.PS;
import id.mit.chrono.server.iface.FileProcessor;
import id.mit.chrono.server.iface.ParserGroupCallback;
import id.mit.chrono.server.model.tables.records.Erinventory2Record;
import id.mit.chrono.server.model.tables.records.ErinventoryRecord;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Result;
import org.jooq.TableField;
import org.slf4j.LoggerFactory;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import static id.mit.chrono.server.model.Tables.*;
import static id.mit.chrono.server.model.Tables.CRSITE;

public class ErInventoryContainer extends ErBaseContainer implements FileProcessor {

    private Result<Record> select;
    private Result<Record> selectSite;
    private Result<Record> fieldValidation;

    private int vendor;

    private String filename;

    private HashMap<String, Integer> siteValue = new HashMap<String, Integer>();
    private HashMap<String, TableField> mappingFields = new HashMap<String, TableField>();

    public ErInventoryContainer(DSLContext db, ParserGroupCallback pgc, ChronoContext context, SourceFile sf, MapEntityObj meo) {
        super(db, pgc, context, sf, meo);

        logger = LoggerFactory.getLogger(this.getClass() + ":" + sf.getTaskFilesId());

        selectSite = db.select()
                .from(CRSITE)
                .where(CRSITE.SITE_CODE.isNotNull())
                .fetch();

        fieldValidation = db.select()
                .from(INVENTORYFIELDVALIDATION)
                .where(INVENTORYFIELDVALIDATION.INVENTORYPARTVALIDATION_TABLE.eq("erinventory2"))
                .and(INVENTORYFIELDVALIDATION.INVENTORYPARTVALIDATION_ENABLE.eq(1))
                .fetch();

        select = db.select()
                .from(CRCOLLECTORTASKFILES)
                .join(CRDATASOURCE)
                .on(CRDATASOURCE.DATASOURCE_ID.eq(CRCOLLECTORTASKFILES.COLLECTORTASKFILES_DATASOURCE))
                .join(CRVENDOR)
                .on(CRVENDOR.VENDOR_ID.eq(CRDATASOURCE.DATASOURCE_VENDOR))
                .where(CRCOLLECTORTASKFILES.COLLECTORTASKFILES_ID.eq(sf.getTaskFilesId()))
                .fetch();

        for (Record r : selectSite) {
            siteValue.put(r.get(CRSITE.SITE_CODE), r.get(CRSITE.SITE_ID).intValue());
        }

        for (Record r : select) {
            vendor = r.get(CRVENDOR.VENDOR_ID).intValue();
            filename = r.get(CRCOLLECTORTASKFILES.COLLECTORTASKFILES_LOCALFILENAME);
        }

        mappingFields();

    }

    @Override
    public boolean process(DSLContext db, PS state) {

        return true;
    }

    @Override
    public boolean processAll(DSLContext adb) {

        resetStopwatch();

        this.prepareKeyParamsResult(adb);
        addMeasurement(PS.PREPARE, this.getKey(), true);

        this.doProcess(adb);
        addMeasurement(PS.INVENTORY, this.getKey(), true);

        this.clearUnusedData(adb);
        addMeasurement(PS.FINALIZE, this.getKey(), true);

        saveStatistics(adb);

        return true;
    }

    public void doProcess(DSLContext db) {

        if (result.size() != 0) {

            System.out.println("-------");
            System.out.println("File ID: " + sf.getTaskFilesId());
            System.out.println("-------");

            System.out.println("sf.getFileName() : " + sf.getFileName());
            System.out.println("sf.getTaskFilesId() : " + sf.getTaskFilesId());
            System.out.println("sf.getKey() : " + sf.getKey());
            System.out.println("result.size() : " + result.size());

            if (sf.getKey() == "3GBULKCM_ERICSSON") {

                final String[] tagNames = {"vsDataHwUnit", "vsDataHwItem", "vsDataSupportUnit", "vsDataCabinet", "InventoryUnit", "InventoryUnit_2"};

                for (int i = 0; i < tagNames.length; i++) {

                    System.out.println("-----------------------------");
                    System.out.println(tagNames[i]);
                    System.out.println("-----------------------------");

                    int finalI = i;

                    List<ErBasicTagParamsObj> data = result.stream()
                            .filter(ErBasicTagParamsObj.class::isInstance)
                            .map(ErBasicTagParamsObj.class::cast)
                            .filter(tag -> tag.tag.equals(tagNames[finalI]))
                            .collect(Collectors.toList());

                    System.out.println(tagNames[i] + " count: " + data.size());

                    if (data.size() > 0) {

                        for (int j = 0; j < data.size(); j++) {

                            ErinventoryRecord insertEr = new ErinventoryRecord();

                            for (String key : data.get(j).params.keySet()) {

                                for (String field : mappingFields.keySet()) {

                                    if (field.equals(key)) {
                                        insertEr.set(mappingFields.get(field), data.get(j).params.get(key));
                                        break;
                                    }

                                }
                            }

                            // clean first
                            if (tagNames[finalI].equalsIgnoreCase("InventoryUnit")) {
                                String productName = insertEr.getErinventoryProductname();
//                                System.out.println("productName: " + productName);

                                insertEr.set(ERINVENTORY.ERINVENTORY_PRODUCTNAME, productName.substring(productName.indexOf("=")+1, productName.indexOf(",")));
                            }

                            if (tagNames[finalI].equalsIgnoreCase("InventoryUnit_2")) {
                                String productName = insertEr.getErinventoryProductname();
//                                System.out.println("productName: " + productName);

                                insertEr.set(ERINVENTORY.ERINVENTORY_PRODUCTNAME, productName.substring(productName.indexOf("=")+1));
                            }

                            if (tagNames[finalI].equals("InventoryUnit") || tagNames[finalI].equals("InventoryUnit_2")) {
                                String vendorUnitTypeNumber = data.get(j).params.get("vendorUnitTypeNumber");
                                if (!vendorUnitTypeNumber.isEmpty() && vendorUnitTypeNumber.contains("_") && vendorUnitTypeNumber.length() > 1) {
//                                    System.out.println("vendorUnitTypeNumber: " + vendorUnitTypeNumber);
                                    if (vendorUnitTypeNumber.split("_")[0] != null) {
                                        insertEr.set(ERINVENTORY.ERINVENTORY_BOMCODE, vendorUnitTypeNumber.split("_")[0]);
                                    }

                                    if (vendorUnitTypeNumber.split("_").length > 1) {
                                        insertEr.set(ERINVENTORY.ERINVENTORY_REVISIONCODE, vendorUnitTypeNumber.split("_")[1]);
                                    }
                                }
                            }

                            insertEr.set(ERINVENTORY.ERINVENTORY_VENDOR, vendor);
                            insertEr.set(ERINVENTORY.ERINVENTORY_DATE, context.getEpochTime());
                            insertEr.set(ERINVENTORY.ERINVENTORY_COLLECTORTASKFILES, sf.getTaskFilesId());
                            insertEr.set(ERINVENTORY.ERINVENTORY_INSERTTIME, new Timestamp(System.currentTimeMillis()));
                            insertEr.set(ERINVENTORY.ERINVENTORY_DATATYPE, 1);

                            String tempNeName = "";
                            String siteIdName = "";
                            String neName = "";
                            String serialNumber = "";
                            Boolean insertOrNot = true;

                            neName = data.get(j).params.get("MeContext_id") != null ? data.get(j).params.get("MeContext_id") : data.get(j).params.get("ManagedElement_id");

                            try {
                                serialNumber = insertEr.get("erinventory_serialnumber").toString();
                            } catch (Exception e) {
                                serialNumber = "";
                            }


                            try {
                                if (neName.substring(1, 2).equalsIgnoreCase("_") || neName.substring(1, 2).equalsIgnoreCase("-") || neName.substring(1, 2).equalsIgnoreCase("+")) {
                                    tempNeName = neName.substring(2);
                                } else {
                                    tempNeName = neName;
                                }

                                if (tempNeName.length() >= 6) {

                                    tempNeName = tempNeName.substring(0, 6);

                                    //pengecekan siteID with regex
                                    if (tempNeName.matches("[A-Z]{3}[0-9]{3}")) {
                                        siteIdName = tempNeName;
                                    }

                                    insertEr.setErinventorySiteid(siteIdName);

                                    if (siteValue.get(tempNeName) != null) {

                                        insertEr.setErinventorySite(siteValue.get(tempNeName));
                                    }
                                }

                            } catch (Exception e) {
                                System.out.println("error: pengecekan regex");
                            }

                            Boolean duplicate = false;

                            try {
                                if (!serialNumber.isEmpty() && !neName.isEmpty()) {

                                    Result<Record> selectSN = db.select()
                                            .from(ERINVENTORY)
                                            .where(ERINVENTORY.ERINVENTORY_SERIALNUMBER.eq(serialNumber))
                                            .and(ERINVENTORY.ERINVENTORY_SITEID.eq(siteIdName))
                                            .and(ERINVENTORY.ERINVENTORY_DATE.eq(context.getEpochTime()))
                                            .fetch();

                                    if (selectSN.isNotEmpty()) {
                                        duplicate = true;
                                        System.out.println("----======duplicate======---->>" + serialNumber);
                                    } else {
                                        duplicate = false;
                                    }
                                }
                            } catch (Exception e) {
                                insertOrNot = false;
                                System.out.println("error: pengecekan serialNumber Exist");
                            }
//                            System.out.println("----------");
//                            System.out.println("erinventory_serialnumber: " + insertEr.get("erinventory_serialnumber"));
//                            System.out.println("erinventory_bomcode: " + insertEr.get("erinventory_bomcode"));
//                            System.out.println("erinventory_nename: " + insertEr.get("erinventory_nename"));
//                            System.out.println("erinventory_productname: " + insertEr.get("erinventory_productname"));
//                            System.out.println("erinventory_siteId: " + insertEr.get("erinventory_siteId"));
//                            System.out.println("----------");

                            if (insertOrNot && !duplicate && !serialNumber.isEmpty()) {

                                try {
                                    for (Record r : fieldValidation) {

                                        if (insertEr.get(r.get(INVENTORYFIELDVALIDATION.INVENTORYPARTVALIDATION_FIELD)).equals(r.get(INVENTORYFIELDVALIDATION.INVENTORYPARTVALIDATION_PATTERN))) {
                                            if (r.get(INVENTORYFIELDVALIDATION.INVENTORYPARTVALIDATION_ACTION).equals("DELETE")) {
                                                insertOrNot = false;
                                                break;
                                            }
                                        }
                                    }
                                } catch (Exception e) {
                                    System.out.println("error: validation field");
                                }

                                if (insertOrNot) {
                                    int insertId = db.insertInto(id.mit.chrono.server.model.tables.Erinventory.ERINVENTORY).set(insertEr).execute();
                                    System.out.println("Success - SN:" + insertEr.get("erinventory_serialnumber") + " - ID: " + insertId);
                                }

                            }

                        }

                    }

                    data = null;
                }

            }
            else if (sf.getKey() == "ER_INVT") {

                List<ErBasicTagParamsObj> test2 = result.stream()
                        .filter(ErBasicTagParamsObj.class::isInstance)
                        .map(ErBasicTagParamsObj.class::cast)
                        .filter(tag -> tag.tag.equals("ER_INVT"))
                        .collect(Collectors.toList());

                System.out.println(test2.get(0).params.keySet());

                for (int i = 0; i < test2.size(); i++) {

                    ErinventoryRecord eir = new ErinventoryRecord();

//                    System.out.println("subnetwork : " + test2.get(i).params.get("subnetwork"));
//                    System.out.println("bsc : " + test2.get(i).params.get("bsc"));
//                    System.out.println("site : " + test2.get(i).params.get("site"));
//                    System.out.println("ru1 : " + test2.get(i).params.get("ru1"));
//                    System.out.println("ru2 : " + test2.get(i).params.get("ru2"));

                    String ru2 = test2.get(i).params.get("ru2");

                    Boolean sn = true;
                    Boolean bc = true;
                    Boolean rc = true;
                    Boolean li = true;
                    Boolean sv = true;
                    Boolean mo = true;
                    Boolean insertOrNot = true;
                    String serialNumber = "";

                    for (int j = 1; j < test2.get(i).params.size(); j++) {
                        try {
                            if (!ru2.contains(test2.get(i).params.get("col" + (j + 1))) && !test2.get(i).params.get("col" + (j + 1)).equals("RU2")) {
                                if (sn) {
                                    serialNumber = test2.get(i).params.get("col" + (j + 1));
                                    eir.setErinventorySerialnumber(serialNumber);


                                    if (test2.get(i).params.get("col" + (j + 1)).startsWith("C:") || test2.get(i).params.get("col" + (j + 1)).equals("SCU") || test2.get(i).params.get("col" + (j + 1)).equals("SAU") || test2.get(i).params.get("col" + (j + 1)).equals("PDU") || test2.get(i).params.get("col" + (j + 1)).equals("CABINET_S") || test2.get(i).params.get("col" + (j + 1)).equals("1234567890123") || test2.get(i).params.get("col" + (j + 1)).equals("5555555555555")) {
                                        insertOrNot = false;
                                        break;
                                    } else {
                                        insertOrNot = true;
                                    }

                                    sn = false;
                                } else if (bc) {
                                    eir.setErinventoryBomcode(test2.get(i).params.get("col" + (j + 1)));
                                    bc = false;
                                } else if (rc) {
                                    eir.setErinventoryRevisioncode(test2.get(i).params.get("col" + (j + 1)));
                                    rc = false;
                                } else if (li) {
                                    eir.setErinventoryLocationinformation(test2.get(i).params.get("col" + (j + 1)));
                                    li = false;
                                } else if (sv) {
                                    eir.setErinventorySoftwareversion(test2.get(i).params.get("col" + (j + 1)));
                                    sv = false;
                                } else if (mo) {
                                    eir.setErinventoryManagedobject(test2.get(i).params.get("col" + (j + 1)));
                                    mo = false;
                                    break;
                                } else {
                                    break;
                                }
                            }
                        } catch (Exception e) {
                            continue;
                        }
                    }

                    eir.setErinventorySubnetwork(test2.get(i).params.get("subnetwork"));
                    eir.setErinventoryBsc(test2.get(i).params.get("bsc"));
                    eir.setErinventoryNename(test2.get(i).params.get("site"));

                    String tempNeName = "";
                    String siteIdName = "";
                    String neName = "";

                    neName = test2.get(i).params.get("site");

                    try {
                        if (neName.substring(1, 2).equalsIgnoreCase("_")) {
                            tempNeName = neName.substring(2);
                        } else {
                            tempNeName = neName;
                        }

                        if (tempNeName.length() >= 6) {

                            tempNeName = tempNeName.substring(0, 6);

                            //pengecekan siteID with regex
                            if (tempNeName.matches("[A-Z]{3}[0-9]{3}")) {
                                siteIdName = tempNeName;
                            }

                            eir.setErinventorySiteid(siteIdName);

                            if (siteValue.get(tempNeName) != null) {

                                eir.setErinventorySite(siteValue.get(tempNeName));
                            }
                        }

                    } catch (Exception e) {

                    }

                    eir.setErinventoryRu1(test2.get(i).params.get("ru1"));
                    eir.setErinventoryRu2(ru2);

                    String productName = "";
                    String[] tempProductName = ru2.split("( ){3,}|\\t");

                    if (tempProductName.length > 1) {

                        for (int j = 0; j < tempProductName.length - 1; j++) {
                            productName = productName.concat(tempProductName[j]);
                        }
                    }

                    if (productName.trim().isEmpty()) {
                        eir.setErinventoryProductname(ru2);
                    } else {
                        eir.setErinventoryProductname(productName.trim());
                    }

                    eir.setErinventoryCollectortaskfiles(sf.getTaskFilesId());
                    eir.setErinventoryDate(context.getEpochTime());
                    eir.setErinventoryVendor(this.vendor);
                    eir.setErinventoryInserttime(new Timestamp(System.currentTimeMillis()));
                    eir.setErinventoryDatatype(1);

                    Boolean duplicate = false;

                    try {
                        if (!serialNumber.isEmpty() && !neName.isEmpty()) {

                            Result<Record> selectSN = db.select()
                                    .from(ERINVENTORY)
                                    .where(ERINVENTORY.ERINVENTORY_SERIALNUMBER.eq(serialNumber))
                                    .and(ERINVENTORY.ERINVENTORY_SITEID.eq(siteIdName))
                                    .and(ERINVENTORY.ERINVENTORY_DATE.eq(context.getEpochTime()))
                                    .fetch();

                            if (selectSN.isNotEmpty()) {
                                duplicate = true;
                                System.out.println("----======duplicate======---->>" + serialNumber);
                            } else {
                                duplicate = false;
                            }
                        }
                    } catch (Exception e) {
                        insertOrNot = false;
                    }


                    if (insertOrNot && !duplicate) {
                        int insertId = db.insertInto(id.mit.chrono.server.model.tables.Erinventory.ERINVENTORY).set(eir).execute();
                        System.out.println("Success insert 2g: " + insertId);
                    }
                }
            }
        }
    }

    private void mappingFields() {

        mappingFields.put("productData_productName", ERINVENTORY2.ERINVENTORY_PRODUCTNAME);
        mappingFields.put("SubNetwork_id", ERINVENTORY2.ERINVENTORY_SUBNETWORK);
        mappingFields.put("productData_productionDate", ERINVENTORY2.ERINVENTORY_DATEOFMANUFACTURE);
        mappingFields.put("productData_productNumber", ERINVENTORY2.ERINVENTORY_BOMCODE);
        mappingFields.put("productData_serialNumber", ERINVENTORY2.ERINVENTORY_SERIALNUMBER);
        mappingFields.put("MeContext_id", ERINVENTORY2.ERINVENTORY_NENAME);
        mappingFields.put("SubNetwork_2_id", ERINVENTORY2.ERINVENTORY_SUBNETWORK2);
        mappingFields.put("administrativeState", ERINVENTORY2.ERINVENTORY_ADMINISTRATIVESTATE);
        mappingFields.put("availabilityStatus", ERINVENTORY2.ERINVENTORY_AVAILABILITYSTATUS);
        mappingFields.put("productData_productRevision", ERINVENTORY2.ERINVENTORY_REVISIONCODE);
//        mappingFields.put("positionInformation", ERINVENTORY2.ERINVENTORY_LOCATIONINFORMATION);
        mappingFields.put("position", ERINVENTORY2.ERINVENTORY_POSITION);
        mappingFields.put("vendorName", ERINVENTORY2.ERINVENTORY_HWVENDORNAME);
        mappingFields.put("serialNumber", ERINVENTORY2.ERINVENTORY_SERIALNUMBER);

        // ENM Inventory Data Adjustment
        mappingFields.put("ManagedElement_id", ERINVENTORY2.ERINVENTORY_NENAME);
        mappingFields.put("configData_dnPrefix", ERINVENTORY2.ERINVENTORY_LOCATIONINFORMATION);
        mappingFields.put("unitPosition", ERINVENTORY2.ERINVENTORY_POSITION);
        mappingFields.put("dateOfManufacture", ERINVENTORY2.ERINVENTORY_DATEOFMANUFACTURE);
        mappingFields.put("manufacturerData", ERINVENTORY2.ERINVENTORY_PRODUCTNAME);

    }

    private void clearUnusedData(DSLContext db) {

        this.sf.purgeResult();
        this.result.clear();

    }
}

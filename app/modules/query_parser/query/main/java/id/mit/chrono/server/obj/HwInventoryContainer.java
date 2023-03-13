package id.mit.chrono.server.obj;

import com.jcraft.jsch.Logger;
import id.mit.chrono.server.base.BaseParserGroup;
import id.mit.chrono.server.base.HwBaseContainer;
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
import java.util.*;
import java.util.stream.Collectors;
import java.util.Date;

import static id.mit.chrono.server.model.Tables.*;

public class HwInventoryContainer extends HwBaseContainer implements FileProcessor {

    private HwenodebRecord hwenodeb;
    private CrnodeRecord node;

    private List<HwlcellRecord> lcells = new ArrayList<>();

    private Result<Record> select;
    private Result<Record> selectSite;
    private HashMap<String, Integer> siteValue = new HashMap<String, Integer>();

    public static int counter = 0;

    public HwInventoryContainer(DSLContext db, ParserGroupCallback pgc, ChronoContext context, SourceFile sf, MapEntityObj meo) {
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

        HuaweiBasicKeyParamsObj mml;
        CrmapfieldRecord mfr;

        // get Inventory list
        List<HuaweiBasicKeyParamsObj> inventories = result.stream()
                .filter(HuaweiBasicKeyParamsObj.class::isInstance)
                .map(HuaweiBasicKeyParamsObj.class::cast)
                .filter(p -> p.command.equals("Inventory_Board"))
                .collect(Collectors.toList());

        System.out.println("inventories.size(): " + inventories.size());

        HuaweiBasicKeyParamsObj temp;

        int collectorTask = 0, vendor = 0, hwSite = 0, isFirst = 1;
        String neFdn, neType, serialNumber, neName, boardName, boardType, bomCode, unitPosition, dateOfManufacture, manufactureData, cabinetNo, subrackNo,
                slotNo, subSlotNo, portNo, inventoryUnitId, inventoryUnitType, softwareVersion, hardwareVersion, insertTime = null;

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

                neFdn = temp.params.get("NEFdn");
                serialNumber = temp.params.get("Serial Number");
                neName = temp.params.get("NEName");


                Boolean duplicate = false;


                String tempNeName = "";
                String siteIdName = "";

                if (neName.substring(1, 2).equalsIgnoreCase("_") || neName.substring(1, 2).equalsIgnoreCase("-") || neName.substring(1, 2).equalsIgnoreCase("+")) {
                    tempNeName = neName.substring(2);
                } else {
                    tempNeName = neName;
                }

                int siteId = 0;

                if (tempNeName.length() >= 6) {

                    tempNeName = tempNeName.substring(0, 6);
                    siteIdName = tempNeName;

                    if (siteValue.get(tempNeName) != null) {
                        siteId = siteValue.get(tempNeName);
                    }
                } else {
                    siteIdName = "";
                }

                neType = temp.params.get("NEType");
                boardName = temp.params.get("Board Name");
                boardType = temp.params.get("Board Type");
                bomCode = temp.params.get("BOM Code");

                if (bomCode.isEmpty()) {
                    continue;
                }

                unitPosition = temp.params.get("Unit Position");
                dateOfManufacture = temp.params.get("Date Of Manufacture");
                manufactureData = temp.params.get("Manufacturer Data");
                cabinetNo = temp.params.get("Cabinet No.");
                subrackNo = temp.params.get("Subrack No.");
                slotNo = temp.params.get("Slot No.");
                subSlotNo = temp.params.get("Subslot No.");
                portNo = temp.params.get("Port No.");
                inventoryUnitId = temp.params.get("Inventory Unit ID");
                inventoryUnitType = temp.params.get("Inventory Unit Type");
                softwareVersion = temp.params.get("Software Version");
                hardwareVersion = temp.params.get("Hardware Version");

                Timestamp timestamp = new Timestamp(System.currentTimeMillis());


                //pengecekan siteID with regex
                if (!siteIdName.matches("[A-Z]{3}[0-9]{3}")) {
                    siteIdName = "";
                }

                if (!serialNumber.isEmpty() && !neName.isEmpty()) {

                    Result<Record> selectSN = db.select()
                            .from(HWINVENTORY)
                            .where(HWINVENTORY.HWINVENTORY_SERIALNUMBER.eq(serialNumber))
                            .and(HWINVENTORY.HWINVENTORY_SITEID.eq(siteIdName))
                            .and(HWINVENTORY.HWINVENTORY_DATE.eq(context.getEpochTime()))
                            .fetch();

                    if (selectSN.isNotEmpty()) {
                        duplicate = true;
                        System.out.println("----======duplicate======---->>" + serialNumber);
                    } else {
                        duplicate = false;
                    }
                }

                if (!duplicate) {
                    db.insertInto(HWINVENTORY)
                            .set(HWINVENTORY.HWINVENTORY_DATE, context.getEpochTime())
                            .set(HWINVENTORY.HWINVENTORY_DATATYPE, 1)
                            .set(HWINVENTORY.HWINVENTORY_COLLECTORTASKFILES, sf.getTaskFilesId())
                            .set(HWINVENTORY.HWINVENTORY_VENDOR, vendor)
                            .set(HWINVENTORY.HWINVENTORY_SITE, siteId)
                            .set(HWINVENTORY.HWINVENTORY_SITEID, siteIdName)
                            .set(HWINVENTORY.HWINVENTORY_NEFDN, neFdn)
                            .set(HWINVENTORY.HWINVENTORY_NETYPE, neType)
                            .set(HWINVENTORY.HWINVENTORY_SERIALNUMBER, serialNumber)
                            .set(HWINVENTORY.HWINVENTORY_NENAME, neName)
                            .set(HWINVENTORY.HWINVENTORY_BOARDNAME, boardName)
                            .set(HWINVENTORY.HWINVENTORY_BOARDTYPE, boardType)
                            .set(HWINVENTORY.HWINVENTORY_BOMCODE, bomCode)
                            .set(HWINVENTORY.HWINVENTORY_UNITPOSITION, unitPosition)
                            .set(HWINVENTORY.HWINVENTORY_DATEOFMANUFACTURE, dateOfManufacture)
                            .set(HWINVENTORY.HWINVENTORY_MANUFACTURERDATA, manufactureData)
                            .set(HWINVENTORY.HWINVENTORY_CABINETNO, cabinetNo)
                            .set(HWINVENTORY.HWINVENTORY_SUBRACKNO, subrackNo)
                            .set(HWINVENTORY.HWINVENTORY_SLOTNO, slotNo)
                            .set(HWINVENTORY.HWINVENTORY_SUBSLOTNO, subSlotNo)
                            .set(HWINVENTORY.HWINVENTORY_PORTNO, portNo)
                            .set(HWINVENTORY.HWINVENTORY_INVENTORYUNITID, inventoryUnitId)
                            .set(HWINVENTORY.HWINVENTORY_INVENTORYUNITTYPE, inventoryUnitType)
                            .set(HWINVENTORY.HWINVENTORY_SOFTWAREVERSION, softwareVersion)
                            .set(HWINVENTORY.HWINVENTORY_HARDWAREVERSION, hardwareVersion)
                            .set(HWINVENTORY.HWINVERNTORY_ISFIRST, isFirst)
                            .set(HWINVENTORY.HWINVENTORY_INSERTTIME, timestamp)
                            .execute();
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

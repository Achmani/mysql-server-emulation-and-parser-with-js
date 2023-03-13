package id.mit.chrono.server.obj;

import id.mit.chrono.server.base.BaseParserGroup;
import id.mit.chrono.server.base.HwBaseContainer;
import id.mit.chrono.server.base.NokBaseContainer;
import id.mit.chrono.server.enm.PS;
import id.mit.chrono.server.iface.FileProcessor;
import id.mit.chrono.server.iface.ParserGroupCallback;
import id.mit.chrono.server.model.Tables;
import id.mit.chrono.server.model.tables.records.*;
import it.unimi.dsi.fastutil.Hash;
import org.jooq.*;
import com.jcraft.jsch.Logger;
import org.jooq.impl.DSL;
import org.slf4j.LoggerFactory;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import static id.mit.chrono.server.model.Tables.*;
import static id.mit.chrono.server.model.Tables.HWINVENTORY;

public class NokInventoryContainer extends NokBaseContainer implements FileProcessor {

    private NokinventoryRecord tempSelectNokInventory;
    private HwenodebRecord hwenodeb;
    private CrnodeRecord node;

    private List<HwlcellRecord> lcells = new ArrayList<>();

    private Result<Record> select;
    private Result<Record> selectSite;

    private HashMap<String, Integer> siteValue = new HashMap<String, Integer>();
    private HashMap<String, TableField> mappingFields = new HashMap<String, TableField>();

    private List<NokBasicTagParamsObj> selectUnit;

    private String filename = "";
    private String filter1 = "";
    private String filter2 = "";
    private String filter3 = "";

    private int vendor = 0;
    public static int counter = 0;

    public NokInventoryContainer(DSLContext db, ParserGroupCallback pgc, ChronoContext context, SourceFile sf, MapEntityObj meo) {
        super(db, pgc, context, sf, meo);
        logger = LoggerFactory.getLogger(this.getClass() + ":" + sf.getTaskFilesId());

        mappingFields.put("identificationCode", NOKINVENTORY.NOKINVENTORY_IDENTIFICATIONCODE);
        mappingFields.put("vendorUnitTypeNumber", NOKINVENTORY.NOKINVENTORY_IDENTIFICATIONCODE);
        mappingFields.put("serialNumber", NOKINVENTORY.NOKINVENTORY_SERIALNUMBER);
        mappingFields.put("unitId", NOKINVENTORY.NOKINVENTORY_UNITID);
        mappingFields.put("unitType", NOKINVENTORY.NOKINVENTORY_UNITTYPE);
        mappingFields.put("inventoryUnitType", NOKINVENTORY.NOKINVENTORY_UNITTYPE);
        mappingFields.put("vendorName", NOKINVENTORY.NOKINVENTORY_VENDORNAME);
        mappingFields.put("locationName", NOKINVENTORY.NOKINVENTORY_LOCATIONNAME);
        mappingFields.put("subrackSpecificType", NOKINVENTORY.NOKINVENTORY_SUBRACKSPECIFICTYPE);
        mappingFields.put("systemTitle", NOKINVENTORY.NOKINVENTORY_SYSTEMTITLE);
        mappingFields.put("siteId", NOKINVENTORY.NOKINVENTORY_SITEID);
        mappingFields.put("siteCId", NOKINVENTORY.NOKINVENTORY_SITECID);
        mappingFields.put("name", NOKINVENTORY.NOKINVENTORY_NENAME);
        mappingFields.put("unitTypeActual", NOKINVENTORY.NOKINVENTORY_UNITTYPEACTUAL);
        mappingFields.put("unitTypeExpected", NOKINVENTORY.NOKINVENTORY_UNITTYPEEXPECTED);
        mappingFields.put("state", NOKINVENTORY.NOKINVENTORY_STATE);
        mappingFields.put("userLabel", NOKINVENTORY.NOKINVENTORY_USERLABEL);
        mappingFields.put("NEType", NOKINVENTORY.NOKINVENTORY_NETYPE);
        mappingFields.put("softwareReleaseVersion", NOKINVENTORY.NOKINVENTORY_SOFTWARERELEASEVERSION);
        mappingFields.put("swVersion", NOKINVENTORY.NOKINVENTORY_SOFTWARERELEASEVERSION);
        mappingFields.put("MODULE", NOKINVENTORY.NOKINVENTORY_CLASSNAME);
        mappingFields.put("UNIT", NOKINVENTORY.NOKINVENTORY_CLASSNAME);

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
        System.out.println("File Name: " + sf.getFileName());
        System.out.println("-------");

        selectSite = db.select()
                .from(CRSITE)
                .where(CRSITE.SITE_CODE.isNotNull())
                .fetch();

        for (Record r : selectSite) {
            siteValue.put(r.get(CRSITE.SITE_CODE), r.get(CRSITE.SITE_ID).intValue());
        }

        select = db.select()
                .from(CRCOLLECTORTASKFILES)
                .join(CRDATASOURCE)
                .on(CRDATASOURCE.DATASOURCE_ID.eq(CRCOLLECTORTASKFILES.COLLECTORTASKFILES_DATASOURCE))
                .join(CRVENDOR)
                .on(CRVENDOR.VENDOR_ID.eq(CRDATASOURCE.DATASOURCE_VENDOR))
                .where(CRCOLLECTORTASKFILES.COLLECTORTASKFILES_ID.eq(sf.getTaskFilesId()))
                .fetch();

        for (Record r : select) {
            vendor = r.get(CRVENDOR.VENDOR_ID).intValue();
            filename = r.get(CRCOLLECTORTASKFILES.COLLECTORTASKFILES_LOCALFILENAME);
        }

        if (sf.getFileName().startsWith("hirarki_lte")) {


            System.out.println("yes this is mrbts/sbts files");

            List<NokBasicTagParamsObj> all = result.stream()
                    .filter(NokBasicTagParamsObj.class::isInstance)
                    .map(NokBasicTagParamsObj.class::cast)
                    .filter(p -> p.params.containsKey("serialNumber"))
                    .collect(Collectors.toList());

            List<NokBasicTagParamsObj> lnbts = result.stream()
                    .filter(NokBasicTagParamsObj.class::isInstance)
                    .map(NokBasicTagParamsObj.class::cast)
                    .filter(p -> p.className.equals("LNBTS"))
                    .collect(Collectors.toList());

            List<NokBasicTagParamsObj> classHw = result.stream()
                    .filter(NokBasicTagParamsObj.class::isInstance)
                    .map(NokBasicTagParamsObj.class::cast)
                    .filter(p -> p.className.equals("HW"))
                    .collect(Collectors.toList());

            if (!lnbts.isEmpty()) {
                try {
                    System.out.println("-------------");
                    System.out.println("distName -> " + lnbts.get(0).params.get("distName"));
                    System.out.println("name -> " + lnbts.get(0).params.get("name"));
                    System.out.println("swVersion -> " + classHw.get(0).params.get("swVersion"));
                    System.out.println("userLabel -> " + classHw.get(0).params.get("userLabel"));
                    System.out.println("vendorName -> " + classHw.get(0).params.get("vendorName"));
                    System.out.println("-------------");
                } catch (Exception x) {
                    System.out.println(x);
                }
            }
            System.out.println("jumlah yang memiliki serial number -> " + all.size());

            for (int i = 0; i < all.size(); i++) {

                try {
                    if (all.get(i).params.get("vendorUnitTypeNumber") == null) {
                        continue;
                    }

                    Boolean duplicateLte = false;
                    NokinventoryRecord insertNok = new NokinventoryRecord();


                    System.out.println("------------");
                    System.out.println("all.get(i).className -> " + all.get(i).className);
                    System.out.println("- -> " + all.get(i).params.get("serialNumber"));
                    System.out.println("- -> " + all.get(i).params.get("vendorUnitTypeNumber"));
                    System.out.println("- -> " + all.get(i).params.get("inventoryUnitType"));

                    for (String key : all.get(i).params.keySet()) {

                        System.out.println("key -> " + key);

                        for (String field : mappingFields.keySet()) {

                            if (field.equals(key)) {
                                insertNok.set(mappingFields.get(field), all.get(i).params.get(key));
                                break;
                            }

                        }
                    }

                    System.out.println("------------");
                    insertNok.set(NOKINVENTORY.NOKINVENTORY_DATE, context.getEpochTime());
                    insertNok.set(NOKINVENTORY.NOKINVENTORY_COLLECTORTASKFILES, sf.getTaskFilesId());
                    insertNok.set(NOKINVENTORY.NOKINVENTORY_VENDOR, vendor);
                    insertNok.set(NOKINVENTORY.NOKINVENTORY_NENAME, lnbts.get(0).params.get("name"));
                    insertNok.set(NOKINVENTORY.NOKINVENTORY_LOCATIONNAME, lnbts.get(0).params.get("distName"));
                    insertNok.set(NOKINVENTORY.NOKINVENTORY_SOFTWARERELEASEVERSION, classHw.get(0).params.get("swVersion"));
                    insertNok.set(NOKINVENTORY.NOKINVENTORY_VENDORNAME, classHw.get(0).params.get("vendorName"));
                    insertNok.set(NOKINVENTORY.NOKINVENTORY_CLASSNAME, all.get(i).className);
                    insertNok.set(NOKINVENTORY.NOKINVENTORY_INSERTTIME, new Timestamp(System.currentTimeMillis()));
                    insertNok.set(NOKINVENTORY.NOKINVENTORY_DATATYPE, 1);


                    String tempNeNameLte = "";
                    String siteIdName = "";

                    try {

                        if (!insertNok.getNokinventoryNename().isEmpty()) {

                            if (insertNok.getNokinventoryNename().substring(1, 2).equalsIgnoreCase("_") || insertNok.getNokinventoryNename().substring(1, 2).equalsIgnoreCase("-") || insertNok.getNokinventoryNename().substring(1, 2).equalsIgnoreCase("+")) {
                                tempNeNameLte = insertNok.getNokinventoryNename().substring(2);
                            } else {
                                tempNeNameLte = insertNok.getNokinventoryNename();
                            }

                            int siteId = 0;

                            if (tempNeNameLte.length() >= 6) {

                                tempNeNameLte = tempNeNameLte.substring(0, 6);

                                //pengecekan siteID with regex
                                if (tempNeNameLte.matches("[A-Z]{3}[0-9]{3}")) {
                                    siteIdName = tempNeNameLte;
                                }

                                insertNok.setNokinventorySiteidname(siteIdName);

                                if (siteValue.get(tempNeNameLte) != null) {
                                    siteId = siteValue.get(tempNeNameLte);
                                    insertNok.setNokinventorySite(siteId);
                                }
                            }
                        }

                    } catch (Exception e) {

                    }

                    String serialNumberLte = insertNok.getNokinventorySerialnumber();
                    String neNameLte = insertNok.getNokinventoryNename();

//                    Boolean duplicateLte = false;
                    try {

                        if (!serialNumberLte.isEmpty() && !neNameLte.isEmpty()) {

                            Result<Record> selectSN = db.select()
                                    .from(NOKINVENTORY)
                                    .where(NOKINVENTORY.NOKINVENTORY_SERIALNUMBER.eq(serialNumberLte))
                                    .and(NOKINVENTORY.NOKINVENTORY_SITEIDNAME.eq(siteIdName))
                                    .and(NOKINVENTORY.NOKINVENTORY_DATE.eq(context.getEpochTime()))
                                    .fetch();

                            if (selectSN.isNotEmpty()) {
                                duplicateLte = true;
                                System.out.println("----======duplicate======----" + serialNumberLte);
                            } else {
                                duplicateLte = false;
                            }
                        }
                    } catch (Exception e) {

                    }


                    if (!duplicateLte) {
                        int success = db.insertInto(NOKINVENTORY).set(insertNok).execute();
                        System.out.println("Success inserting : " + success);
                    }

                } catch (Exception e) {
                    System.out.println(e);
                }
            }


        } else {

            List<NokBasicTagParamsObj> modules = result.stream()
                    .filter(NokBasicTagParamsObj.class::isInstance)
                    .map(NokBasicTagParamsObj.class::cast)
                    .filter(p -> p.className.equals("UNIT") || p.className.equals("MODULE"))
                    .filter(p -> p.params.containsKey("serialNumber"))
                    .collect(Collectors.toList());

            List<NokBasicTagParamsObj> bts = result.stream()
                    .filter(NokBasicTagParamsObj.class::isInstance)
                    .map(NokBasicTagParamsObj.class::cast)
                    .filter(p -> p.className.equals("BCF") || p.className.equals("WBTS"))
                    .collect(Collectors.toList());


            System.out.println("modules size: " + modules.size());
            System.out.println("bts size:  " + bts.size());

            String distNameModule, distNameParent;

            NokBasicTagParamsObj tempObjModule;
            int isFirst = 0;

            for (int i = 0; i < modules.size(); i++) {//level module

                distNameModule = modules.get(i).params.get("distName");

                for (int j = 0; j < bts.size(); j++) {//level bts

                    distNameParent = bts.get(j).params.get("distName");

                    if (distNameModule.startsWith(distNameParent)) {
                        System.out.println("distName Module >>>>>> " + distNameModule);
                        System.out.println("distName Parent BTS >>>>>> " + distNameParent);

                        // parent found

                        NokinventoryRecord nir = new NokinventoryRecord();

                        for (String key : modules.get(i).params.keySet()) {
                            for (String field : mappingFields.keySet()) {

                                if (field.equals(key)) {
                                    nir.set(mappingFields.get(field), modules.get(i).params.get(key));
                                    break;
                                }

                            }
                        }

                        for (String keybts : bts.get(j).params.keySet()) {
                            for (String field : mappingFields.keySet()) {

                                if (field.equals(keybts)) {
                                    nir.set(mappingFields.get(field), bts.get(j).params.get(keybts));
                                    break;
                                }

                            }
                        }

                        nir.set(NOKINVENTORY.NOKINVENTORY_COLLECTORTASKFILES, sf.getTaskFilesId());
                        nir.set(NOKINVENTORY.NOKINVENTORY_DATE, context.getEpochTime());
                        nir.set(NOKINVENTORY.NOKINVENTORY_VENDOR, vendor);
                        nir.set(NOKINVENTORY.NOKINVENTORY_CLASSNAME, modules.get(i).className);
                        nir.set(NOKINVENTORY.NOKINVENTORY_INSERTTIME, new Timestamp(System.currentTimeMillis()));
                        nir.set(NOKINVENTORY.NOKINVENTORY_DATATYPE, 1);

//                    Result<NokinventoryRecord> tempSelectNokInventory = db.selectFrom(NOKINVENTORY)
//                            .where(NOKINVENTORY.NOKINVENTORY_SERIALNUMBER.eq(modules.get(i).params.get("serialNumber")))
//                            .fetch();
//
//                    if (tempSelectNokInventory.isEmpty()) {
//
//                        isFirst = 1;
//                        nir.set(NOKINVENTORY.NOKINVENTORY_ISFIRST, isFirst);
//
//                    } else {
//
//                        isFirst = 0;
//                        nir.set(NOKINVENTORY.NOKINVENTORY_ISFIRST, isFirst);
//                    }
//                    Boolean insertOrNot = false;

//                    for (int k = 0; k < tempSelectNokInventory.size(); k++) {
//                        System.out.println(">>>>>>>>>>" + tempSelectNokInventory.getNokinventorySerialnumber());
//                    }

                        System.out.println("...........................");
                        System.out.println(nir.getNokinventoryNename());
                        System.out.println("...........................");

                        String tempNeName = "";
                        String siteIdName2 = "";

                        try {
                            if (!nir.getNokinventoryNename().isEmpty()) {

                                if (nir.getNokinventoryNename().substring(1, 2).equalsIgnoreCase("_") || nir.getNokinventoryNename().substring(1, 2).equalsIgnoreCase("-") || nir.getNokinventoryNename().substring(1, 2).equalsIgnoreCase("+")) {
                                    tempNeName = nir.getNokinventoryNename().substring(2);
                                } else {
                                    tempNeName = nir.getNokinventoryNename();
                                }

                                int siteId = 0;

                                if (tempNeName.length() >= 6) {

                                    tempNeName = tempNeName.substring(0, 6);

                                    //pengecekan siteID with regex
                                    if (tempNeName.matches("[A-Z]{3}[0-9]{3}")) {
                                        siteIdName2 = tempNeName;
                                    }

                                    nir.setNokinventorySiteidname(siteIdName2);

                                    if (siteValue.get(tempNeName) != null) {
                                        siteId = siteValue.get(tempNeName);
                                        nir.setNokinventorySite(siteId);
                                    }
                                }
                            }
                        } catch (Exception e) {

                        }

                        String serialNumber = nir.getNokinventorySerialnumber();
                        String neName = nir.getNokinventoryNename();

                        Boolean duplicate = false;

                        try {

                            if (!serialNumber.isEmpty() && !neName.isEmpty()) {

                                Result<Record> selectSN = db.select()
                                        .from(NOKINVENTORY)
                                        .where(NOKINVENTORY.NOKINVENTORY_SERIALNUMBER.eq(serialNumber))
                                        .and(NOKINVENTORY.NOKINVENTORY_SITEIDNAME.eq(siteIdName2))
                                        .and(NOKINVENTORY.NOKINVENTORY_DATE.eq(context.getEpochTime()))
                                        .fetch();

                                if (selectSN.isNotEmpty()) {
                                    duplicate = true;
                                    System.out.println("----======duplicate======----" + serialNumber);
                                } else {
                                    duplicate = false;
                                }
                            }
                        } catch (Exception e) {

                        }

                        if (!duplicate) {
                            int success = db.insertInto(NOKINVENTORY).set(nir).execute();
                            System.out.println("Success inserting : " + success);
                        }
                        break;
                    }
                }
            }
        }

        logger.debug("prepareInventory() done");
    }

    public List<NokBasicTagParamsObj> selectCommonObject(String filter) {

        selectUnit = result.stream()
                .filter(NokBasicTagParamsObj.class::isInstance)
                .map(NokBasicTagParamsObj.class::cast)
                .filter(p -> p.params.containsKey(filter))
                .filter(p -> p.className.equals("UNIT") || p.className.equals("MODULE"))
                .collect(Collectors.toList());

        return selectUnit;
    }

    public List<NokBasicTagParamsObj> selectObjectByKey(String filter) {

        selectUnit = result.stream()
                .filter(NokBasicTagParamsObj.class::isInstance)
                .map(NokBasicTagParamsObj.class::cast)
                .filter(p -> p.params.containsKey(filter))
                .collect(Collectors.toList());


        return selectUnit;
    }

    public List<NokBasicTagParamsObj> selectObjFilterByClassAndKey(String filterClass, String filterKey) {

        selectUnit = result.stream()
                .filter(NokBasicTagParamsObj.class::isInstance)
                .map(NokBasicTagParamsObj.class::cast)
                .filter(p -> p.className.equals(filterClass))
                .filter(p -> p.params.get("distName").contains(filterKey))
                .collect(Collectors.toList());

        return selectUnit;
    }


    public List<NokBasicTagParamsObj> selectObjectByClassName(String filter) {

        selectUnit = result.stream()
                .filter(NokBasicTagParamsObj.class::isInstance)
                .map(NokBasicTagParamsObj.class::cast)
                .filter(p -> p.className.equals(filter))
                .collect(Collectors.toList());

//        for (int i = 0; i < result.size(); i++) {
//
//            if(result.get(i) instanceof NokBasicTagParamsObj){
//
//                NokBasicTagParamsObj x = (NokBasicTagParamsObj) result.get(i);
//
//                if(x.className.equals(filter)){
//
//                    selectUnit.add(x);
//                }
//            }
//        }

        return selectUnit;
    }


    private void clearUnusedData(DSLContext db) {

        this.sf.purgeResult();
        this.hwenodeb = null;
        this.result.clear();
        this.lcells.clear();
    }
}

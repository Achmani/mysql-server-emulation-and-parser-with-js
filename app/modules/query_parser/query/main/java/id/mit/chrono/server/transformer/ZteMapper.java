package id.mit.chrono.server.transformer;

import id.mit.chrono.server.base.BaseTransformerMapper;
import id.mit.chrono.server.database.dao.mapnptq.MapNPTQDaoImpl;
import id.mit.chrono.server.factory.DaoFactory;
import id.mit.chrono.server.model.tables.records.CrmapnptqRecord;
import id.mit.chrono.server.model.tables.records.CrnptqRecord;
import id.mit.chrono.server.obj.PreparatorResult;
import org.jooq.Result;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ZteMapper extends BaseTransformerMapper {

    private List<PreparatorResult> preparedResultFiles;
    private MapNPTQDaoImpl dao = DaoFactory.getMapNPTQDaoImpl();


    private int totalParams = 0;
    private int totalSuccessInsert = 0;
    private int totalFailedInsert = 0;
    private int totalParamsExist = 0;
    private int totalParamsNew = 0;
    private int totalParamsNotFound = 0;
    private int totalParamsUpdated = 0;

    @Override
    protected void checkNPTQ() {

        totalParams = nptqParams.size();

        logger.debug("fetched " + totalParams + " param(s) for " + entity + ".");

        preparedResultFiles = resultFiles.stream().map(
                file -> new PreparatorResult(
                        prepareFileName(file.getFileName()),
                        file.getColumnset(),
                        prepareSourceName(file.getSource()),
                        file.getFile(),
                        file.getKeyColumnset())
        ).collect(Collectors.toList());

        for (CrnptqRecord params: nptqParams) {

            // filter fetched files by object and params.
            List<PreparatorResult> filteredResultFiles = new ArrayList<>();

            preparedResultFiles.parallelStream().forEach(file -> {

                List<String> columnset = Arrays.asList(file.getColumnset().toLowerCase().split(","));



                if (params.getNptqBackupObject() != null) {

                    String[] backupObject = {params.getNptqBackupObject().toLowerCase()};
                    if (params.getNptqBackupObject().indexOf(",") > 0) {
                        backupObject = params.getNptqBackupObject().split(",");
                    }

                    for (String bObject: backupObject) {
                        if (file.getFileName().toLowerCase().equals(bObject.toLowerCase())) {

                            // try to search default params
                            if (columnset.contains(params.getNptqParams().toLowerCase())) {

                                PreparatorResult f = new PreparatorResult(file);
                                f.setObjectBackup(bObject);
                                filteredResultFiles.add(f);
                            } else if (params.getNptqBackupParams() != null){
                                // try to search backup params
                                String[] backupParams = {params.getNptqBackupParams()};
                                if (params.getNptqBackupParams().indexOf(",") > 0) {
                                    backupParams = params.getNptqBackupParams().split(",");
                                }

                                for (String bParams: backupParams) {

                                    if (columnset.contains(bParams.toLowerCase())) {
                                        PreparatorResult f = new PreparatorResult(file);
                                        f.setObjectBackup(bObject);
                                        f.setParamBackup(bParams);
                                        filteredResultFiles.add(f);
                                    }
                                }
                            }
                        }
                    }
                }

                // then try to search on default object
                if (file.getFileName().toLowerCase().equals(params.getNptqObject().toLowerCase())) {

                    // try to search default params
                    if (columnset.contains(params.getNptqParams().toLowerCase())) {
                        filteredResultFiles.add(new PreparatorResult(file));
                    }
                    else if (params.getNptqBackupParams() != null) {

                        // try to search backup params
                        String[] backupParams = {params.getNptqBackupParams()};
                        if (params.getNptqBackupParams().indexOf(",") > 0) {
                            backupParams = params.getNptqBackupParams().split(",");
                        }

                        for (String bParams: backupParams) {

                            if (columnset.contains(bParams.toLowerCase())) {

                                PreparatorResult f = new PreparatorResult(file);
                                f.setParamBackup(bParams);
                                filteredResultFiles.add(f);
                            }
                        }
                    }
                }

            });

            // try to fetch existing MapNPTQ
            Result<CrmapnptqRecord> maps = dao.getMapNPTQsByEntityGroup(params.getNptqObject(), params.getNptqParams(), params.getNptqEntity());

            // if params not found, then skip.
            if (filteredResultFiles.size() <= 0) {

                logger.debug("parameter " + params.getNptqParams() + " not found.");

                totalParamsNotFound++;

                // insert default to be update later
                if (maps.size() <= 0) {
                    int insert = insertMapNPTQ(
                            params.getNptqObject(),
                            params.getNptqParams(),
                            entity,
                            null,
                            null,
                            null,
                            null
                    );

                    switch (insert) {
                        case 1:
                            totalSuccessInsert++;
                            break;
                        case -1:
                            totalFailedInsert++;
                            break;
                    }
                }

                continue;
            }

            logger.debug("found " + entity + " parameter " + params.getNptqParams() + " in " + filteredResultFiles.size() + " file(s).");

            if (maps.size() <= 0) {

                // no existing MapNPTQ. then insert all
                for (PreparatorResult file: filteredResultFiles) {

                    totalParamsNew++;

                    int insert = insertMapNPTQ(
                            params.getNptqObject(),
                            params.getNptqParams(),
                            entity,
                            file.getSource(),
                            file.getFile().getName(),
                            file.getObjectBackup(),
                            file.getParamBackup()
                    );

                    switch (insert) {
                        case 1:
                            totalSuccessInsert++;
                            break;

                        case -1:
                            totalFailedInsert++;
                            break;
                    }
                }

            } else {

                totalParamsExist++;

                for (PreparatorResult file: filteredResultFiles) {

                    boolean found = false;

                    for (CrmapnptqRecord map: maps) {

                        if (file.getSource().equals(map.getMapnptqSourcefile()) && file.getFile().getName().equals(map.getMapnptqFile())) {
                            found = true;
                            break;
                        }
                    }

                    if (!found) {
                        logger.debug("found " + entity + " parameter " + params.getNptqParams() + " in new file (" + file.getFile().getName() + ").");

                        if (maps.size() == 1) {
                            CrmapnptqRecord map = maps.get(0);
                            if (map.getMapnptqSourcefile() == null && map.getMapnptqFile() == null) {

                                // update MapNPTQ
                                logger.debug("updating: " + map.getCrmapnptqParams());
                                totalParamsUpdated += updateMapNPTQ(map.getCrmapnptqId(), file.getSource(), file.getFile().getName(), file.getObjectBackup(), file.getParamBackup());
                            } else {
                                int insert = insertMapNPTQ(
                                        params.getNptqObject(),
                                        params.getNptqParams(),
                                        entity,
                                        file.getSource(),
                                        file.getFile().getName(),
                                        file.getObjectBackup(),
                                        file.getParamBackup()
                                );

                                switch (insert) {
                                    case 1:
                                        totalSuccessInsert++;
                                        break;
                                    case -1:
                                        totalFailedInsert++;
                                        break;
                                }
                            }
                        } else {
                            int insert = insertMapNPTQ(
                                    params.getNptqObject(),
                                    params.getNptqParams(),
                                    entity,
                                    file.getSource(),
                                    file.getFile().getName(),
                                    file.getObjectBackup(),
                                    file.getParamBackup()
                            );

                            switch (insert) {
                                case 1:
                                    totalSuccessInsert++;
                                    break;
                                case -1:
                                    totalFailedInsert++;
                                    break;
                            }
                        }
                    }
                };
            }

        }

        logger.debug("NPTQ Check Complete.");
        System.out.println("############   SUMMARY NPTQ CHECK   ############");
        System.out.println("##                                            ##");
        System.out.println("##     total parameter(s): " + totalParams + "          ##");
        System.out.println("##     total new parameter(s): " + totalParamsNew + "     ##");
        System.out.println("##     total insert success: " + totalSuccessInsert + "     ##");
        System.out.println("##     total insert failed: " + totalFailedInsert + "     ##");
        System.out.println("##     total parameter(s) exists: " + totalParamsExist + "     ##");
        System.out.println("##     total parameter(s) not found: " + totalParamsNotFound + "     ##");
        System.out.println("##     total parameter(s) udpated: " + totalParamsUpdated + "     ##");
        System.out.println("##                                            ##");
        System.out.println("###########  SUMMARY NPTQ CHECK END  ###########");

    }

    private String prepareSourceName(String source) {

        // ex: SDR-tdd_radio-v12.20.40-20210317012545-162.zip
        // ex: SDR-fdd_radio-v12.20.40-20210317012612-165.zip
        // ex: SDR-nb_radio-v12.20.40-Subnetwork_2021&2046&2022&2044&2045-20210317043336-92.zip
        // ex: UMEID_ITBBU_ZTE_20210317170000.zip

        String[] rawSource = source.split("/");
        String[] fname = rawSource[rawSource.length-1].split("-");

        if (rawSource[rawSource.length-2].startsWith("UMEID")) {
            String[] part = rawSource[rawSource.length-2].split("_");
            return part[0] + "_" + part[1] + "-" + fname[0];
        }

        return fname[0] + "-" + fname[1];
    }

    private String prepareFileName(String filename) {

        // ex: CUEUtranCellNBIoT.csv
        return filename.substring(0, filename.lastIndexOf("."));
    }
}

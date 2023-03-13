package id.mit.chrono.server.transformer;

import id.mit.chrono.server.base.BaseTransformerMapper;
import id.mit.chrono.server.database.dao.mapnptq.MapNPTQDaoImpl;
import id.mit.chrono.server.factory.DaoFactory;
import id.mit.chrono.server.model.tables.records.CrmapnptqRecord;
import id.mit.chrono.server.model.tables.records.CrnptqRecord;
import id.mit.chrono.server.obj.PreparatorResult;
import org.jooq.Result;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class NokiaMapper extends BaseTransformerMapper {

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

        preparedResultFiles = resultFiles.stream().map(file -> new PreparatorResult(
                prepareFileName(file.getFileName()),
                file.getColumnset(),
                prepareSourceName(file.getSource()),
                file.getFile(),
                file.getKeyColumnset())
        ).collect(Collectors.toList());

        for (CrnptqRecord params: nptqParams) {

            // filter fetched files by object and params.
            List<PreparatorResult> filteredResultFiles = preparedResultFiles.stream().filter(file -> {

                String[] columnset = file.getColumnset().toLowerCase().split(",");
                String[] objects = params.getNptqObject().split("/");

                if (entity.equals("nokenodeb")) {
                    return file.getFileName().toLowerCase().contains(objects[objects.length-1].toLowerCase()) &&
                            Arrays.asList(columnset).contains(params.getNptqParams().toLowerCase());
                }

                return file.getFileName().toLowerCase().contains(params.getNptqObject().toLowerCase()) &&
                        Arrays.asList(columnset).contains(params.getNptqParams().toLowerCase());
            }).collect(Collectors.toList());

            // try to fetch existing MapNPTQ
            Result<CrmapnptqRecord> maps = dao.getMapNPTQsByEntityGroup(params.getNptqObject(), params.getNptqParams(), params.getNptqEntity());

            // if params not found, then skip.
            if (filteredResultFiles.size() <= 0) {

                logger.debug("parameter " + params.getNptqParams() + " not found.");

                totalParamsNotFound++;

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
                filteredResultFiles.forEach(file -> {
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
                });

            } else {

                totalParamsExist += maps.size();

                // found existing params in database. try to compare with fetched files.
                filteredResultFiles.forEach(file -> {

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
                                updateMapNPTQ(map.getCrmapnptqId(), file.getSource(), file.getFile().getName(), file.getObjectBackup(), file.getParamBackup());
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
                });
            }
        }

        logger.debug("NPTQ Check Complete.");
        System.out.println("######   SUMMARY NPTQ CHECK   ######");
        System.out.println("##                                ##");
        System.out.println("##    total parameter(s): " + totalParams + "    ##");
        System.out.println("##     total new parameter(s): " + totalParamsNew + "     ##");
        System.out.println("##     total insert success: " + totalSuccessInsert + "     ##");
        System.out.println("##     total failed success: " + totalFailedInsert + "     ##");
        System.out.println("##     total parameter(s) exists: " + totalParamsExist + "     ##");
        System.out.println("##     total parameter(s) not found: " + totalParamsNotFound + "     ##");
        System.out.println("##     total parameter(s) udpated: " + totalParamsUpdated + "     ##");
        System.out.println("##                                ##");
        System.out.println("#####  SUMMARY NPTQ CHECK END  #####");

    }

//    private void updateMapNPTQ(UInteger id, String source, String filename) {
//
//        CrmapnptqRecord record = dao.updateMapNPTQ(id, source, filename);
//
//        if (record != null) {
//            totalParamsUpdated++;
//        }
//
//    }
//
//    private void insertMapNPTQ(String object, String params, String source, String filename, String entity) {
//
//        logger.debug("insert: " + params + " from " + source + " - " + filename);
//
//        CrmapnptqRecord record = dao.insertMapNPTQ(object, params, source, filename, entity);
//
//        if (record != null) {
//            totalSuccessInsert++;
//        } else {
//            totalFailedInsert++;
//        }
//    }

    private String prepareSourceName(String source) {

        // ex: GExport_MBSC_Bima1_10.224.130.193_20210308030521.xml.gz

        String[] rawSource = source.split("/");
        source = rawSource[rawSource.length-1];

        return source.split("_")[0];
    }

    private String prepareFileName(String filename) {

        // ex: ETHTRKLNK_BSC6910GSM.csv
        return filename.substring(0, filename.lastIndexOf("."));
    }
}

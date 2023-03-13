package id.mit.chrono.server.provider;

import id.mit.chrono.server.builder.DatasourceProcessorBuilder;
import id.mit.chrono.server.builder.DependencyFileBuilder;
import id.mit.chrono.server.builder.TaskFilesTransformerBuilder;
import id.mit.chrono.server.database.DatabaseHelper;
import id.mit.chrono.server.model.tables.records.CrcollectortaskfilesRecord;
import id.mit.chrono.server.obj.ChronoContext;
import org.jooq.*;

import javax.annotation.Nullable;
import javax.validation.constraints.Null;

import java.util.Arrays;

import static id.mit.chrono.server.model.Tables.*;
import static id.mit.chrono.server.model.Tables.CRCOLLECTORTASKFILES;

public class DatasourceProviderFactory {


    public static Result<Record> getDatasourceProcessor(ChronoContext context, @Nullable DatasourceProcessorBuilder builder) {

        DSLContext db = DatabaseHelper.connectDB();

        SelectConditionStep<Record> query = db.select()
                .from(CRCOLLECTORTASKFILES)
                .join(CRDATASOURCE)
                .on(CRCOLLECTORTASKFILES.COLLECTORTASKFILES_DATASOURCE.eq(CRDATASOURCE.DATASOURCE_ID))
                .join(CRVENDOR)
                .on(CRVENDOR.VENDOR_ID.eq(CRDATASOURCE.DATASOURCE_VENDOR))
                .where();

        Condition byFileId = null;

        if (builder != null) {

            if(builder.getDataSources() != null){

                query.and(CRDATASOURCE.DATASOURCE_NAME.in(builder.getDataSources()));
            }

            if(builder.getFileNames() != null){
                Condition byFileName = CRCOLLECTORTASKFILES.COLLECTORTASKFILES_LOCALFILENAME.like(builder.getFileNames()[0].replaceAll("\\*", "%"));

                for (int i = 1; i < builder.getFileNames().length; i++) {
                    byFileName.or(CRCOLLECTORTASKFILES.COLLECTORTASKFILES_LOCALFILENAME.like(builder.getFileNames()[i].replaceAll("\\*", "%")));
                }
                System.out.println(byFileName);
                query.and(byFileName);
            }

            if(builder.getFileIds() != null){

//                Condition byFileId = CRCOLLECTORTASKFILES.COLLECTORTASKFILES_ID.eq(builder.getFileIds()[0].longValue());
//
//                for (int i = 1; i < builder.getFileIds().length; i++) {
//
//                    byFileId.or(CRCOLLECTORTASKFILES.COLLECTORTASKFILES_ID.eq(builder.getFileIds()[i].longValue()));
//                }

                byFileId = CRCOLLECTORTASKFILES.COLLECTORTASKFILES_ID.in(Arrays.asList(builder.getFileIds()));

                query.and(byFileId);
            }

            if(builder.getEntities() != null){

                // select from

                Result<Record> mapEntities = db.select()
                        .from(CRMAPENTITY)
                        .where(CRMAPENTITY.MAPENTITY_TABLENAME.in(builder.getEntities()))
                        .and(CRMAPENTITY.MAPENTITY_FILESELECTOR.isNotNull())
                        .and(CRMAPENTITY.MAPENTITY_ENABLED.isTrue())
                        .fetch();

                String fileSelector;
                String fileReducer;

                if(mapEntities.size() > 0){

                    for (int i = 0; i < mapEntities.size(); i++) {

                        fileSelector = mapEntities.get(i).getValue(CRMAPENTITY.MAPENTITY_FILESELECTOR);
                        fileReducer = mapEntities.get(i).getValue(CRMAPENTITY.MAPENTITY_FILEREDUCER);

                        String[] fileSelectorEl = fileSelector.split("\\|");

                        for (int j = 0; j < fileSelectorEl.length ; j++) {

                            Condition bySelector = CRCOLLECTORTASKFILES.COLLECTORTASKFILES_COLLECTORTASK.eq(context.getCOLLECTORTASK_ID())
                                    .and(CRCOLLECTORTASKFILES.COLLECTORTASKFILES_LOCALFILENAME.like(fileSelectorEl[j]));

                            if(byFileId != null){
                                bySelector = bySelector.and(byFileId);
                            }

                            if(fileReducer != null){

                                String[] fileReducerEl = fileReducer.split("\\|");

                                for (int k = 0; k < fileReducerEl.length; k++) {

                                    bySelector = bySelector.andNot(CRCOLLECTORTASKFILES.COLLECTORTASKFILES_LOCALFILENAME.like(fileReducerEl[k]));
                                }
                            }

                            query.or(bySelector);
                        }
                    }
                }
            }

            if (!builder.isReProcess()) {
                query.and(
                        (CRCOLLECTORTASKFILES.COLLECTORTASKFILES_PROCESSTIME.equal(0)
                                .or(CRCOLLECTORTASKFILES.COLLECTORTASKFILES_PROCESSTIME.isNull()))
                );
            }

            // add order by to prevent older file processed at the end
            query.orderBy(CRCOLLECTORTASKFILES.COLLECTORTASKFILES_ADDED.asc());

            if(builder.getFileCountLimit() != 0){
                query.limit(builder.getFileCountLimit());
            }

        } else {

            // add order by to prevent older file processed at the end
            query.orderBy(CRCOLLECTORTASKFILES.COLLECTORTASKFILES_ADDED.asc());

        }

        System.out.println("query: " + query.toString());

        return query.fetch();
    }

    public static Result<CrcollectortaskfilesRecord> getFileDeps(ChronoContext context, String[] fileSelector, boolean reProcess, String masterFileName) {

        DSLContext db = DatabaseHelper.connectDB();

        SelectConditionStep query = db.select()
                .from(CRCOLLECTORTASKFILES)
                .where(CRCOLLECTORTASKFILES.COLLECTORTASKFILES_COLLECTORTASK.eq(context.getCOLLECTORTASK_ID()))
                .andNot(CRCOLLECTORTASKFILES.COLLECTORTASKFILES_LOCALFILENAME.eq(masterFileName));      // exclude master file name to prevent select itself as deps. file

        Condition bySelector = null;

        if (fileSelector != null && fileSelector.length > 0) {

            for (String selector: fileSelector) {

                System.out.println("selector: " + selector);

                if (bySelector == null) {
                    bySelector = CRCOLLECTORTASKFILES.COLLECTORTASKFILES_LOCALFILENAME.like(selector);
                } else {
                    bySelector = bySelector.or(CRCOLLECTORTASKFILES.COLLECTORTASKFILES_LOCALFILENAME.like(selector));
                }

            }

            query.and(bySelector);

        }

        if (!reProcess) {
            query.and(CRCOLLECTORTASKFILES.COLLECTORTASKFILES_PROCESSTIME.equal(0))
                    .or(CRCOLLECTORTASKFILES.COLLECTORTASKFILES_PROCESSTIME.isNull());
        }

        query.orderBy(CRCOLLECTORTASKFILES.COLLECTORTASKFILES_ADDED.asc());

        System.out.println("query: " + query);

        return query.fetch();

    }

    public static Result<CrcollectortaskfilesRecord> getFileDeps(ChronoContext context, String[] fileSelector, boolean reProcess, Integer datasourceId, String masterFileName) {

        DSLContext db = DatabaseHelper.connectDB();

        SelectConditionStep query = db.select()
                .from(CRCOLLECTORTASKFILES)
                .where(CRCOLLECTORTASKFILES.COLLECTORTASKFILES_COLLECTORTASK.eq(context.getCOLLECTORTASK_ID()))
                .and(CRCOLLECTORTASKFILES.COLLECTORTASKFILES_DATASOURCE.eq(datasourceId))
                .andNot(CRCOLLECTORTASKFILES.COLLECTORTASKFILES_LOCALFILENAME.eq(masterFileName));      // exclude master file name to prevent select itself as deps. file

        Condition bySelector = null;

        if (fileSelector != null && fileSelector.length > 0) {

            for (String selector: fileSelector) {

                if (bySelector == null) {
                    bySelector = CRCOLLECTORTASKFILES.COLLECTORTASKFILES_LOCALFILENAME.like(selector);
                } else {
                    bySelector = bySelector.or(CRCOLLECTORTASKFILES.COLLECTORTASKFILES_LOCALFILENAME.like(selector));
                }

            }

            query.and(bySelector);

        }

        if (!reProcess) {
            query.and(CRCOLLECTORTASKFILES.COLLECTORTASKFILES_PROCESSTIME.equal(0))
                    .or(CRCOLLECTORTASKFILES.COLLECTORTASKFILES_PROCESSTIME.isNull());
        }

        query.orderBy(CRCOLLECTORTASKFILES.COLLECTORTASKFILES_ADDED.asc());

        return query.fetch();

    }

    public static Result<CrcollectortaskfilesRecord> getFileDeps(ChronoContext context, DependencyFileBuilder builder) {

        DSLContext db = DatabaseHelper.connectDB();

        SelectConditionStep query = db.select()
                .from(CRCOLLECTORTASKFILES)
                .where(CRCOLLECTORTASKFILES.COLLECTORTASKFILES_COLLECTORTASK.eq(context.getCOLLECTORTASK_ID()));

        if (builder != null) {

            if (builder.getDatasourceId() != null) {
                query.and(CRCOLLECTORTASKFILES.COLLECTORTASKFILES_DATASOURCE.eq(builder.getDatasourceId()));
            }

            if (builder.getMasterFilename() != null) {
                query.andNot(CRCOLLECTORTASKFILES.COLLECTORTASKFILES_LOCALFILENAME.eq(builder.getMasterFilename()));
            }

            if (builder.getDepsPattern() != null && builder.getDepsPattern().length > 0) {

                Condition bySelector = null;

                for (String selector: builder.getDepsPattern()) {

                    if (bySelector == null) {
                        bySelector = CRCOLLECTORTASKFILES.COLLECTORTASKFILES_LOCALFILENAME.like(selector);
                    } else {
                        bySelector = bySelector.or(CRCOLLECTORTASKFILES.COLLECTORTASKFILES_LOCALFILENAME.like(selector));
                    }
                }

//                if (bySelector != null) {
//                    System.out.println("bySelector: " + bySelector.toString());
//                }

                query.and(bySelector);
            }

            if (builder.getLocaldir() != null) {
                query.and(CRCOLLECTORTASKFILES.COLLECTORTASKFILES_LOCALDIR.like(builder.getLocaldir()));
            }

            if (!builder.isReProcess()) {
                query.and(CRCOLLECTORTASKFILES.COLLECTORTASKFILES_PROCESSTIME.equal(0))
                        .or(CRCOLLECTORTASKFILES.COLLECTORTASKFILES_PROCESSTIME.isNull());
            }

        }

        query.orderBy(CRCOLLECTORTASKFILES.COLLECTORTASKFILES_ADDED.asc());

        return query.fetch();

    }

}

// all: 26763956, 26763708, 26763742, 26763885, 26763451, 26765759, 26751060, 26751154, 26751127, 26813017
// failed : 26751060, 26751154
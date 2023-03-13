package id.mit.chrono.server.database.dao.processortaskfiles;

import id.mit.chrono.server.database.DatabaseHelper;
import id.mit.chrono.server.model.tables.Crprocessortaskfiles;
import id.mit.chrono.server.model.tables.records.CrcollectortaskfilesRecord;
import id.mit.chrono.server.model.tables.records.CrprocessortaskfilesRecord;
import id.mit.chrono.server.model.tables.records.CrtimecatalogRecord;
import org.jooq.DSLContext;
import org.jooq.Result;

import static id.mit.chrono.server.model.Tables.*;
import static id.mit.chrono.server.model.tables.Crcollectortaskfiles.CRCOLLECTORTASKFILES;

public class ProcessorTaskFilesDaoImpl implements ProcessorTaskFilesDao {

    private DSLContext db;

    public ProcessorTaskFilesDaoImpl() {
        this.db = DatabaseHelper.connectDB();
    }

    @Override
    public Result<CrprocessortaskfilesRecord> getProcessorTaskfiles(Integer date, String fileName) {
        return db.selectFrom(CRPROCESSORTASKFILES)
                .where(CRPROCESSORTASKFILES.CRPROCESSORTASKFILES_DATE.equal(date))
                .and(CRPROCESSORTASKFILES.PROCESSORTASKFILES_LOCALFILENAME.contains(fileName))
                .fetch();
    }

    @Override
    public Result<CrprocessortaskfilesRecord> getProcessorTaskfiles(Long collectorTaskFilesId) {
        return db.selectFrom(CRPROCESSORTASKFILES)
                .where(CRPROCESSORTASKFILES.PROCESSORTASKFILES_COLLECTORTASKFILES.equal(collectorTaskFilesId))
                .fetch();
    }

    @Override
    public CrprocessortaskfilesRecord getProcessorTaskFiles(Integer date, Long collectorTaskFilesId, String localDir, String localFileName) {
        return db.selectFrom(CRPROCESSORTASKFILES)
                .where(CRPROCESSORTASKFILES.CRPROCESSORTASKFILES_DATE.equal(date))
                .and(CRPROCESSORTASKFILES.PROCESSORTASKFILES_COLLECTORTASKFILES.equal(collectorTaskFilesId))
                .and(CRPROCESSORTASKFILES.PROCESSORTASKFILES_LOCALDIR.equal(localDir))
                .and(CRPROCESSORTASKFILES.PROCESSORTASKFILES_LOCALFILENAME.equal(localFileName))
                .fetchAny();
    }
    @Override
    public CrprocessortaskfilesRecord getProcessorTaskFiles(Integer date, Long collectorTaskFilesId, String localFileName) {
        return db.selectFrom(CRPROCESSORTASKFILES)
                .where(CRPROCESSORTASKFILES.CRPROCESSORTASKFILES_DATE.equal(date))
                .and(CRPROCESSORTASKFILES.PROCESSORTASKFILES_COLLECTORTASKFILES.equal(collectorTaskFilesId))
                .and(CRPROCESSORTASKFILES.PROCESSORTASKFILES_LOCALFILENAME.equal(localFileName))
                .fetchAny();
    }


    @Override
    public CrprocessortaskfilesRecord insertProcessorTaskFiles(
            int epochDate,
            int collectorTaskFilesId,
            int datasourceId,
            String remoteDir,
            String remoteFilename,
            String localDir,
            String localFilename,
            int createdAt,
            int addedAt,
            int modifiedAt,
            long fileSize,
            String fileType,
            String fileChecksum,
            int processTime,
            int processStatus
    ) {

        CrprocessortaskfilesRecord record = db.newRecord(CRPROCESSORTASKFILES);
        record.setCrprocessortaskfilesDate(epochDate);
        record.setProcessortaskfilesDatasource(datasourceId);
        record.setProcessortaskfilesRemotedir(remoteDir);
        record.setProcessortaskfilesRemotefilename(remoteFilename);
        record.setProcessortaskfilesLocaldir(localDir);
        record.setProcessortaskfilesLocalfilename(localFilename);
        record.setProcessortaskfilesCreated(createdAt);
        record.setProcessortaskfilesAdded(addedAt);
        record.setProcessortaskfilesModified(modifiedAt);
        record.setProcessortaskfilesSize(fileSize);
        record.setProcessortaskfilesType(fileType);
        record.setProcessortaskfilesChecksum(fileChecksum);
        record.setProcessortaskfilesProcesstime(processStatus);
        record.setProcessortaskfilesProcessstatus(processStatus);

        record.store();

        return record;
    }

    @Override
    public CrprocessortaskfilesRecord insertProcessorTaskFiles(CrprocessortaskfilesRecord processorTaskFiles) {

        processorTaskFiles.store();
        return processorTaskFiles;
    }

    @Override
    public CrprocessortaskfilesRecord updateProcessorTaskFiles(CrprocessortaskfilesRecord processorTaskFiles) {

        processorTaskFiles.update();
        return processorTaskFiles;
    }


}

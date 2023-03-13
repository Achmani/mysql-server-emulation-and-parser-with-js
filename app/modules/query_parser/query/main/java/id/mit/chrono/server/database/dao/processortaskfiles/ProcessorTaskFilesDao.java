package id.mit.chrono.server.database.dao.processortaskfiles;


import id.mit.chrono.server.model.tables.Crprocessortaskfiles;
import id.mit.chrono.server.model.tables.records.CrcollectortaskfilesRecord;
import id.mit.chrono.server.model.tables.records.CrprocessortaskfilesRecord;
import org.jooq.Result;

public interface ProcessorTaskFilesDao {

    public Result<CrprocessortaskfilesRecord> getProcessorTaskfiles(Integer date, String fileName);

    public Result<CrprocessortaskfilesRecord> getProcessorTaskfiles(Long collectorTaskFilesId);

    public CrprocessortaskfilesRecord getProcessorTaskFiles(Integer date, Long collectorTaskFilesId, String localDir, String localFileName);

    public CrprocessortaskfilesRecord getProcessorTaskFiles(Integer date, Long collectorTaskFilesId, String localFileName);

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
    );

    public CrprocessortaskfilesRecord insertProcessorTaskFiles(CrprocessortaskfilesRecord processorTaskFiles);

    public CrprocessortaskfilesRecord updateProcessorTaskFiles(CrprocessortaskfilesRecord processorTaskFiles);

}

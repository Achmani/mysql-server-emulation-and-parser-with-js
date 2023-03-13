package id.mit.chrono.server.database.dao.collectortaskfiles;


import id.mit.chrono.server.model.tables.records.CrcollectortaskRecord;
import id.mit.chrono.server.model.tables.records.CrcollectortaskfilesRecord;
import org.jooq.Result;

public interface CollectorTaskFilesDao {

    public Result<CrcollectortaskfilesRecord> getCollectorTaskfiles(Integer date, String fileName);

    public void updateCollectorTaskfiles(long id, Integer date);

}

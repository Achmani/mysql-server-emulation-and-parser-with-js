package id.mit.chrono.server.database.dao.collectortask;


import id.mit.chrono.server.model.tables.records.CrcollectortaskRecord;
import org.jooq.Result;

public interface CollectorTaskDao {

    public Result<CrcollectortaskRecord> getCollectorTasks();
    public CrcollectortaskRecord getSingleCollectorTask(String taskName);
    public CrcollectortaskRecord getSingleCollectorTask(Integer id);
    public CrcollectortaskRecord getSingleCollectorTask(Integer dataGroupId, String taskName);

    public CrcollectortaskRecord insertCollectorTask(Integer dataGroupId, String taskName, int epoch);

}

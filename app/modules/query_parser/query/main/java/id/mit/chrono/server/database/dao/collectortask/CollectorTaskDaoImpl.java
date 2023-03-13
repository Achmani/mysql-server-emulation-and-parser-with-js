package id.mit.chrono.server.database.dao.collectortask;

import id.mit.chrono.server.database.DatabaseHelper;
import id.mit.chrono.server.model.tables.records.CrcollectortaskRecord;
import org.jooq.DSLContext;
import org.jooq.Result;

import java.time.Instant;

import static id.mit.chrono.server.model.Tables.CRCOLLECTORTASK;

public class CollectorTaskDaoImpl implements CollectorTaskDao{

    private DSLContext db;

    public CollectorTaskDaoImpl() {
        this.db = DatabaseHelper.connectDB();
    }

    @Override
    public Result<CrcollectortaskRecord> getCollectorTasks() {
        return db.selectFrom(CRCOLLECTORTASK).fetch();
    }

    @Override
    public CrcollectortaskRecord getSingleCollectorTask(String taskName) {
        return db.selectFrom(CRCOLLECTORTASK)
                .where(CRCOLLECTORTASK.COLLECTORTASK_NAME.equal(taskName))
                .fetchAny();
    }

    @Override
    public CrcollectortaskRecord getSingleCollectorTask(Integer id) {
        return db.selectFrom(CRCOLLECTORTASK)
                .where(CRCOLLECTORTASK.COLLECTORTASK_ID.equal(id))
                .fetchAny();
    }

    @Override
    public CrcollectortaskRecord getSingleCollectorTask(Integer dataGroupId, String taskName) {
        return db.selectFrom(CRCOLLECTORTASK)
                .where(CRCOLLECTORTASK.COLLECTORTASK_DATAGROUP.equal(dataGroupId))
                .and(CRCOLLECTORTASK.COLLECTORTASK_NAME.equal(taskName))
                .fetchAny();
    }

    @Override
    public CrcollectortaskRecord insertCollectorTask(Integer dataGroupId, String taskName, int epoch) {
        CrcollectortaskRecord record = db.newRecord(CRCOLLECTORTASK);
        record.setCollectortaskDatagroup(dataGroupId);
        record.setCollectortaskName(taskName);
        record.setCollectortaskEpoch(epoch);
        record.setCollectortaskCreated((int) Instant.now().getEpochSecond());
        record.store();
        return record;
    }
}

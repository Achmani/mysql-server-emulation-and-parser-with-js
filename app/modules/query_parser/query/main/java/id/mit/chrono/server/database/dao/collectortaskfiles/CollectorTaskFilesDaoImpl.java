package id.mit.chrono.server.database.dao.collectortaskfiles;

import id.mit.chrono.server.database.DatabaseHelper;
import id.mit.chrono.server.model.tables.records.CrcollectortaskRecord;
import id.mit.chrono.server.model.tables.records.CrcollectortaskfilesRecord;
import org.jooq.DSLContext;
import org.jooq.Result;

import java.time.Instant;

import static id.mit.chrono.server.model.Tables.CRCOLLECTORTASK;
import static id.mit.chrono.server.model.Tables.CRCOLLECTORTASKFILES;

public class CollectorTaskFilesDaoImpl implements CollectorTaskFilesDao {

    private DSLContext db;

    public CollectorTaskFilesDaoImpl() {
        this.db = DatabaseHelper.connectDB();
    }

    @Override
    public Result<CrcollectortaskfilesRecord> getCollectorTaskfiles(Integer date, String fileName) {
        return db.selectFrom(CRCOLLECTORTASKFILES)
                .where(CRCOLLECTORTASKFILES.CRCOLLECTORTASKFILES_DATE.equal(date))
                .and(CRCOLLECTORTASKFILES.COLLECTORTASKFILES_LOCALFILENAME.contains(fileName))
                .fetch();
    }

    @Override
    public void updateCollectorTaskfiles(long id, Integer date) {
        db.update(CRCOLLECTORTASKFILES)
                .set(CRCOLLECTORTASKFILES.COLLECTORTASKFILES_PROCESSTIME, date)
                .where(CRCOLLECTORTASKFILES.COLLECTORTASKFILES_ID.eq(id))
                .execute();
    }
}

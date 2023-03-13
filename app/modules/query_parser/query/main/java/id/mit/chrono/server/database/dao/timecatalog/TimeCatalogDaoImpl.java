package id.mit.chrono.server.database.dao.timecatalog;

import id.mit.chrono.server.database.DatabaseHelper;
import id.mit.chrono.server.model.tables.records.CrtimecatalogRecord;
import org.jooq.DSLContext;

import static id.mit.chrono.server.model.Tables.CRTIMECATALOG;

public class TimeCatalogDaoImpl implements TimeCatalogDao {

    private DSLContext db = DatabaseHelper.connectDB();

    @Override
    public CrtimecatalogRecord getSingleTimeCatalog(int dataGroupId, int epochTime) {
        return db.selectFrom(CRTIMECATALOG)
                .where(CRTIMECATALOG.TIMECATALOG_DATAGROUP.eq(dataGroupId))
                .and(CRTIMECATALOG.TIMECATALOG_DATE.eq(epochTime))
                .fetchOne();
    }

    @Override
    public CrtimecatalogRecord insertTimeCatalog(int epochTime, int dataGroupId) {
        CrtimecatalogRecord record = db.newRecord(CRTIMECATALOG);
        record.setTimecatalogId(epochTime);
        record.setTimecatalogDatagroup(dataGroupId);
        record.setTimecatalogDate(epochTime);
        record.setTimecatalogActive((byte) 0);
        record.setTimecatalogAdminonly((byte) 1);
        record.store();

        return record;
    }
}

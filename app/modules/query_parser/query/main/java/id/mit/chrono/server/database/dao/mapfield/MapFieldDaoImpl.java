package id.mit.chrono.server.database.dao.mapfield;

import id.mit.chrono.server.database.DatabaseHelper;
import id.mit.chrono.server.model.tables.records.CrmapfieldRecord;
import org.jooq.DSLContext;
import org.jooq.Result;

import static id.mit.chrono.server.model.Tables.CRMAPFIELD;

public class MapFieldDaoImpl implements MapFieldDao {

    private DSLContext db;

    public MapFieldDaoImpl() {
        this.db = DatabaseHelper.connectDB();
    }

    @Override
    public Result<CrmapfieldRecord> getMapFields() {
        return db.selectFrom(CRMAPFIELD)
                .where(CRMAPFIELD.MAPFIELD_ENABLED.isTrue())
                .fetch();
    }

    @Override
    public Result<CrmapfieldRecord> getMapFieldsByMapEntityId(int mapEntityId) {
        return db.selectFrom(CRMAPFIELD)
                .where(CRMAPFIELD.MAPFIELD_MAPENTITY.equal(mapEntityId))
                .and(CRMAPFIELD.MAPFIELD_ENABLED.isTrue())
                .fetch();
    }
}

package id.mit.chrono.server.database.dao.mapentity;

import id.mit.chrono.server.database.DatabaseHelper;
import id.mit.chrono.server.factory.DaoFactory;
import id.mit.chrono.server.model.tables.records.CrmapentityRecord;
import org.jooq.DSLContext;
import org.jooq.Result;

import static id.mit.chrono.server.model.Tables.CRMAPENTITY;
import static id.mit.chrono.server.model.Tables.CRMAPFIELD;

public class MapEntityDaoImpl implements MapEntityDao {

    DSLContext db;

    public MapEntityDaoImpl() {
        this.db = DatabaseHelper.connectDB();
    }

    @Override
    public Result<CrmapentityRecord> getMapEntities() {
        return db.selectFrom(CRMAPENTITY)
                .where(CRMAPENTITY.MAPENTITY_ENABLED.isTrue())
                .orderBy(CRMAPENTITY.MAPENTITY_CODE.asc())
                .fetch();
    }

    @Override
    public Result<CrmapentityRecord> getMapEntitiesByVendorId(int vendorId) {
        return db.selectFrom(CRMAPENTITY)
                .where(CRMAPENTITY.MAPENTITY_VENDOR.equal(vendorId))
                .and(CRMAPENTITY.MAPENTITY_ENABLED.isTrue())
                .orderBy(CRMAPENTITY.MAPENTITY_CODE.asc())
                .fetch();
    }

    @Override
    public Result<CrmapentityRecord> getMapEntitiesByDataGroupId(int datagroupId) {
        return db.selectFrom(CRMAPENTITY)
                .where(CRMAPENTITY.MAPENTITY_DATAGROUP.equal(datagroupId))
                .and(CRMAPENTITY.MAPENTITY_ENABLED.isTrue())
                .orderBy(CRMAPENTITY.MAPENTITY_CODE.asc())
                .fetch();
    }

    @Override
    public Result<CrmapentityRecord> getMapEntitiesByVendorAndDatagroupId(int vendorId, int datagroupId) {
        return db.selectFrom(CRMAPENTITY)
                .where(CRMAPENTITY.MAPENTITY_VENDOR.equal(vendorId))
                .and(CRMAPENTITY.MAPENTITY_DATAGROUP.equal(datagroupId))
                .and(CRMAPENTITY.MAPENTITY_ENABLED.isTrue())
                .orderBy(CRMAPENTITY.MAPENTITY_CODE.asc())
                .fetch();
    }

}

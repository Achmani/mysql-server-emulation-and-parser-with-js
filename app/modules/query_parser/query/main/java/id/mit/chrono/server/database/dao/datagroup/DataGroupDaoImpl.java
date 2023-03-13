package id.mit.chrono.server.database.dao.datagroup;

import id.mit.chrono.server.database.DatabaseHelper;
import id.mit.chrono.server.model.tables.records.CrdatagroupRecord;
import org.jooq.DSLContext;
import org.jooq.Result;

import static id.mit.chrono.server.model.Tables.CRDATAGROUP;

public class DataGroupDaoImpl implements DataGroupDao{

    private DSLContext db;

    public DataGroupDaoImpl() {
        this.db = DatabaseHelper.connectDB();
    }

    @Override
    public Result<CrdatagroupRecord> getAllDataGroups() {

        return db.selectFrom(CRDATAGROUP).fetch();
    }

    @Override
    public CrdatagroupRecord getSingleDataGroup(String dataGroupCode) {
        return db.selectFrom(CRDATAGROUP)
                .where(CRDATAGROUP.DATAGROUP_CODE.equal(dataGroupCode))
                .limit(1)
                .fetchAny();
    }

    @Override
    public CrdatagroupRecord getSingleDataGroup(Integer id) {
        return db.selectFrom(CRDATAGROUP)
                .where(CRDATAGROUP.DATAGROUP_ID.equal(id))
                .limit(1)
                .fetchAny();
    }

}

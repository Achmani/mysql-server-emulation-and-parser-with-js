package id.mit.chrono.server.database.dao.columnset;

import id.mit.chrono.server.database.DatabaseHelper;
import id.mit.chrono.server.model.tables.records.ColumnsetRecord;
import org.jooq.DSLContext;
import org.jooq.Result;

import static id.mit.chrono.server.model.tables.Columnset.COLUMNSET;

public class ColumnsetDaoImpl implements ColumnsetDao {

    DSLContext db;

    public ColumnsetDaoImpl() {
        this.db = DatabaseHelper.connectDB();
    }

    @Override
    public Result<ColumnsetRecord> getColumnsets() {
        return db.selectFrom(COLUMNSET).fetch();
    }

    @Override
    public Result<ColumnsetRecord> getColumnsets(Integer vendorId) {
        return db.selectFrom(COLUMNSET)
                .where(COLUMNSET.COLUMNSET_VENDOR.equal(vendorId))
                .fetch();
    }

    @Override
    public ColumnsetRecord getColumnset(String columnsetColumns) {
        return db.selectFrom(COLUMNSET)
                .where(COLUMNSET.COLUMNSET_COLUMNS.equal(columnsetColumns))
                .fetchAny();
    }

    @Override
    public ColumnsetRecord getColumnset(Integer columnsetId) {
        return db.selectFrom(COLUMNSET)
                .where(COLUMNSET.COLUMNSET_ID.eq(columnsetId))
                .fetchAny();
    }

    @Override
    public ColumnsetRecord getColumnset(String columnsetColumns, Integer vendorId) {
        return db.selectFrom(COLUMNSET)
                .where(COLUMNSET.COLUMNSET_COLUMNS.equal(columnsetColumns))
                .and(COLUMNSET.COLUMNSET_VENDOR.equal(vendorId))
                .fetchAny();
    }

    @Override
    public ColumnsetRecord insertColumnset(String columnsetColumns, Integer vendorId) {

        ColumnsetRecord record = db.newRecord(COLUMNSET);
        record.setColumnsetVendor(vendorId);
        record.setColumnsetColumns(columnsetColumns);
        record.store();

        return record;
    }
}

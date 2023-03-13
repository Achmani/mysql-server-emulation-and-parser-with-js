package id.mit.chrono.server.database.dao.columnset;

import id.mit.chrono.server.model.tables.records.ColumnsetRecord;
import org.jooq.Result;

public interface ColumnsetDao {

    public Result<ColumnsetRecord> getColumnsets();

    public Result<ColumnsetRecord> getColumnsets(Integer vendorId);

    public ColumnsetRecord getColumnset(String columnsetColumns);

    public ColumnsetRecord getColumnset(Integer columnsetId);

    public ColumnsetRecord getColumnset(String columnsetColumns, Integer vendorId);

    public ColumnsetRecord insertColumnset(String columnsetColumns, Integer vendorId);

}

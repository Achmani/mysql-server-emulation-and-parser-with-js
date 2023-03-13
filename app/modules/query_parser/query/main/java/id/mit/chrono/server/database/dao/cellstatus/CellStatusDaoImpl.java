package id.mit.chrono.server.database.dao.cellstatus;

import id.mit.chrono.server.database.DatabaseHelper;
import id.mit.chrono.server.model.tables.records.CrcellstatusRecord;
import org.jooq.DSLContext;

import java.util.List;

import static id.mit.chrono.server.model.Tables.CRCELLSTATUS;

public class CellStatusDaoImpl implements CellStatusDao {

    DSLContext db;

    public CellStatusDaoImpl() {
        this.db = DatabaseHelper.connectDB();
    }

    @Override
    public List<CrcellstatusRecord> getCellStatuses() {
        return db.selectFrom(CRCELLSTATUS).fetch();
    }

}

package id.mit.chrono.server.database.dao.cell;

import id.mit.chrono.server.database.DatabaseHelper;
import id.mit.chrono.server.model.tables.records.CrcellRecord;
import org.jooq.DSLContext;

import java.util.List;

import static id.mit.chrono.server.model.Tables.CRCELL;

public class CellDaoImpl implements CellDao {

    DSLContext db;

    public CellDaoImpl() {
        db = DatabaseHelper.connectDB();
    }

    @Override
    public List<CrcellRecord> getCells() {
        return db.selectFrom(CRCELL).fetch();
    }
}

package id.mit.chrono.server.database.dao.cellclass;

import id.mit.chrono.server.database.DatabaseHelper;
import id.mit.chrono.server.model.tables.records.CrcellclassRecord;
import org.jooq.DSLContext;

import java.util.List;

import static id.mit.chrono.server.model.Tables.CRCELLCLASS;

public class CellClassDaoImpl implements CellClassDao {

    DSLContext db;

    public CellClassDaoImpl() {
        this.db = DatabaseHelper.connectDB();
    }

    @Override
    public List<CrcellclassRecord> getCellClasses() {
        return db.selectFrom(CRCELLCLASS).fetch();
    }
}

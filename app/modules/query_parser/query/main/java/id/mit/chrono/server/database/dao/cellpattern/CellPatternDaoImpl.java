package id.mit.chrono.server.database.dao.cellpattern;

import id.mit.chrono.server.database.DatabaseHelper;
import id.mit.chrono.server.model.tables.records.CrcellpatternRecord;
import org.jooq.DSLContext;

import java.util.List;

import static id.mit.chrono.server.model.Tables.CRCELLPATTERN;

public class CellPatternDaoImpl implements CellPatternDao {

    DSLContext db;

    public CellPatternDaoImpl() {
        db = DatabaseHelper.connectDB();
    }

    @Override
    public List<CrcellpatternRecord> getCellPatterns() {
        return db.selectFrom(CRCELLPATTERN).fetch();
    }
}

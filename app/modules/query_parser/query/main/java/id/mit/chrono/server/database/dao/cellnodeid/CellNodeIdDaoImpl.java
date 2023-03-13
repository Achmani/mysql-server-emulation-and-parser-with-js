package id.mit.chrono.server.database.dao.cellnodeid;

import id.mit.chrono.server.database.DatabaseHelper;
import id.mit.chrono.server.model.tables.records.CrcellnodeidRecord;
import org.jooq.DSLContext;

import java.util.List;

import static id.mit.chrono.server.model.Tables.CRCELLNODEID;

public class CellNodeIdDaoImpl implements CellNodeIdDao {

    DSLContext db;

    public CellNodeIdDaoImpl() {
        this.db = DatabaseHelper.connectDB();
    }

    @Override
    public List<CrcellnodeidRecord> getCellNodeIds() {
        return db.selectFrom(CRCELLNODEID)
                .where(CRCELLNODEID.CELLNODEID_ENABLED.isTrue())
                .fetch();
    }
}

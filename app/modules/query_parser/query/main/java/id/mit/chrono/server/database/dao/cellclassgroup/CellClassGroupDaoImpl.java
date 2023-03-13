package id.mit.chrono.server.database.dao.cellclassgroup;

import id.mit.chrono.server.database.DatabaseHelper;
import id.mit.chrono.server.model.tables.records.CrcellclassgroupRecord;
import org.jooq.DSLContext;

import java.util.List;

import static id.mit.chrono.server.model.Tables.CRCELLCLASSGROUP;

public class CellClassGroupDaoImpl implements CellClassGroupDao {

    DSLContext db;

    public CellClassGroupDaoImpl() {
        this.db = DatabaseHelper.connectDB();
    }

    @Override
    public List<CrcellclassgroupRecord> getCellClassGroups() {
        return db.selectFrom(CRCELLCLASSGROUP).fetch();
    }
}

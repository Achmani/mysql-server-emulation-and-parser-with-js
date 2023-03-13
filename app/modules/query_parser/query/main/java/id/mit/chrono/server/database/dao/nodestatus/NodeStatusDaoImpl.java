package id.mit.chrono.server.database.dao.nodestatus;

import id.mit.chrono.server.database.DatabaseHelper;
import id.mit.chrono.server.model.tables.records.CrnodestatusRecord;
import org.jooq.DSLContext;

import java.util.List;

import static id.mit.chrono.server.model.Tables.CRNODESTATUS;

public class NodeStatusDaoImpl implements NodeStatusDao {

    DSLContext db;

    public NodeStatusDaoImpl() {
        this.db = DatabaseHelper.connectDB();
    }

    @Override
    public List<CrnodestatusRecord> getNodeStatuses() {
        return db.selectFrom(CRNODESTATUS).fetch();
    }
}

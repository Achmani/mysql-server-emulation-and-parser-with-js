package id.mit.chrono.server.database.dao.nodemaps;

import id.mit.chrono.server.database.DatabaseHelper;
import id.mit.chrono.server.model.tables.records.CrnodemapsRecord;
import org.jooq.DSLContext;

import java.util.List;

import static id.mit.chrono.server.model.Tables.CRNODEMAPS;

public class NodeMapsDaoImpl implements NodeMapsDao {

    DSLContext db;

    public NodeMapsDaoImpl() {
        this.db = DatabaseHelper.connectDB();
    }

    @Override
    public List<CrnodemapsRecord> getNodeMaps() {
        return db.selectFrom(CRNODEMAPS).fetch();
    }
}

package id.mit.chrono.server.database.dao.node;

import id.mit.chrono.server.database.DatabaseHelper;
import id.mit.chrono.server.model.tables.records.CrnodeRecord;
import org.jooq.DSLContext;

import java.util.List;

import static id.mit.chrono.server.model.Tables.CRNODE;

public class NodeDaoImpl implements NodeDao {

    DSLContext db;

    public NodeDaoImpl() {
        this.db = DatabaseHelper.connectDB();
    }

    @Override
    public List<CrnodeRecord> getNodes() {
        return db.selectFrom(CRNODE)
                .where(CRNODE.NODE_NODETYPE.in(2))
                .fetch();
    }

    @Override
    public List<CrnodeRecord> getNodeAliases() {
        return db.selectFrom(CRNODE)
                .where(CRNODE.NODE_NODETYPE.in(3))
                .fetch();
    }
}

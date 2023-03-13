package id.mit.chrono.server.database.dao.nodepattern;

import id.mit.chrono.server.database.DatabaseHelper;
import id.mit.chrono.server.model.tables.records.CrnodepatternRecord;
import org.jooq.DSLContext;

import java.util.List;

import static id.mit.chrono.server.model.Tables.CRNODEPATTERN;

public class NodePatternDaoImpl implements NodePatternDao {

    DSLContext db;

    public NodePatternDaoImpl() {
        this.db = DatabaseHelper.connectDB();
    }

    @Override
    public List<CrnodepatternRecord> getNodePatterns() {
        return db.selectFrom(CRNODEPATTERN)
                .where(CRNODEPATTERN.NODEPATTERN_ENABLED.isTrue())
                .orderBy(CRNODEPATTERN.NODEPATTERN_ORDER.asc())
                .fetch();
    }
}

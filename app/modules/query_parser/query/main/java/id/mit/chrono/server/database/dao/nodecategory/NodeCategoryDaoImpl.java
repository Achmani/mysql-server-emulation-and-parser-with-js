package id.mit.chrono.server.database.dao.nodecategory;

import id.mit.chrono.server.database.DatabaseHelper;
import id.mit.chrono.server.model.tables.records.CrnodecategoryRecord;
import org.jooq.DSLContext;

import java.util.List;

import static id.mit.chrono.server.model.Tables.CRNODECATEGORY;

public class NodeCategoryDaoImpl implements NodeCategoryDao {

    DSLContext db;

    public NodeCategoryDaoImpl() {
        this.db = DatabaseHelper.connectDB();
    }

    @Override
    public List<CrnodecategoryRecord> getNodeCategories() {
        return db.selectFrom(CRNODECATEGORY).fetch();
    }
}

package id.mit.chrono.server.database.dao.mapparser;

import id.mit.chrono.server.database.DatabaseHelper;
import id.mit.chrono.server.model.tables.records.CrmapparserRecord;
import org.jooq.DSLContext;
import org.jooq.Result;

import static id.mit.chrono.server.model.tables.Crmapparser.CRMAPPARSER;

public class MapParserDaoImpl implements MapParserDao{

    DSLContext db;

    public MapParserDaoImpl() {
        this.db = DatabaseHelper.connectDB();
    }

    @Override
    public Result<CrmapparserRecord> getMapParsers() {
        return db.selectFrom(CRMAPPARSER)
                .where(CRMAPPARSER.MAPPARSER_ENABLED.isTrue())
                .fetch();
    }

    @Override
    public Result<CrmapparserRecord> getMapParsersById(int vendorId) {
        return db.selectFrom(CRMAPPARSER)
                .where(CRMAPPARSER.MAPPARSER_ENABLED.isTrue())
                .and(CRMAPPARSER.MAPPARSER_VENDOR.equal(vendorId))
                .fetch();
    }
}

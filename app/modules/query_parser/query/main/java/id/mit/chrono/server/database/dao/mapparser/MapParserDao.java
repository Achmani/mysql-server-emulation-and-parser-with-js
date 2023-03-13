package id.mit.chrono.server.database.dao.mapparser;

import id.mit.chrono.server.model.tables.records.CrmapparserRecord;
import org.jooq.Result;

public interface MapParserDao {

    public Result<CrmapparserRecord> getMapParsers();
    public Result<CrmapparserRecord> getMapParsersById(int vendorId);

}

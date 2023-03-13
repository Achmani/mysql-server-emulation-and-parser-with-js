package id.mit.chrono.server.database.dao.mapfield;

import id.mit.chrono.server.model.tables.records.CrmapfieldRecord;
import org.jooq.Result;

public interface MapFieldDao {

    public Result<CrmapfieldRecord> getMapFields();
    public Result<CrmapfieldRecord> getMapFieldsByMapEntityId(int mapEntityId);

}

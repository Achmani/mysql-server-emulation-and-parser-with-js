package id.mit.chrono.server.database.dao.datagroup;

import id.mit.chrono.server.model.tables.records.CrdatagroupRecord;
import org.jooq.Result;

public interface DataGroupDao {

    public Result<CrdatagroupRecord> getAllDataGroups();
    public CrdatagroupRecord getSingleDataGroup(String dataGroupCode);
    public CrdatagroupRecord getSingleDataGroup(Integer id);

}

package id.mit.chrono.server.database.dao.mapentity;

import id.mit.chrono.server.model.tables.records.CrmapentityRecord;
import org.jooq.Result;

public interface MapEntityDao {

    public Result<CrmapentityRecord> getMapEntities();
    public Result<CrmapentityRecord> getMapEntitiesByVendorId(int vendorId);
    public Result<CrmapentityRecord> getMapEntitiesByDataGroupId(int datagroupId);
    public Result<CrmapentityRecord> getMapEntitiesByVendorAndDatagroupId(int vendorId, int datagroupId);

}

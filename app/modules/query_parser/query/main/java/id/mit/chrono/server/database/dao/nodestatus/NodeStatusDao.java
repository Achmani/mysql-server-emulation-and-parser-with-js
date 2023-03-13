package id.mit.chrono.server.database.dao.nodestatus;

import id.mit.chrono.server.model.tables.records.CrnodestatusRecord;

import java.util.List;

public interface NodeStatusDao {

    public List<CrnodestatusRecord> getNodeStatuses();

}

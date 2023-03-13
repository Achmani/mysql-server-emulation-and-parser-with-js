package id.mit.chrono.server.database.dao.cellstatus;

import id.mit.chrono.server.model.tables.records.CrcellstatusRecord;

import java.util.List;

public interface CellStatusDao {

    public List<CrcellstatusRecord> getCellStatuses();

}

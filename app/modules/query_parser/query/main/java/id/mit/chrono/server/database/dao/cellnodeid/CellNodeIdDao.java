package id.mit.chrono.server.database.dao.cellnodeid;

import id.mit.chrono.server.model.tables.records.CrcellnodeidRecord;

import java.util.List;

public interface CellNodeIdDao {

    public List<CrcellnodeidRecord> getCellNodeIds();

}

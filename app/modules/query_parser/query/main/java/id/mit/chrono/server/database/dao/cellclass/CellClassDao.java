package id.mit.chrono.server.database.dao.cellclass;

import id.mit.chrono.server.model.tables.records.CrcellclassRecord;

import java.util.List;

public interface CellClassDao {

    public List<CrcellclassRecord> getCellClasses();
}

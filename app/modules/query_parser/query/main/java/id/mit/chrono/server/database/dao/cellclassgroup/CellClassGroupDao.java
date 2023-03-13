package id.mit.chrono.server.database.dao.cellclassgroup;

import id.mit.chrono.server.model.tables.records.CrcellclassgroupRecord;

import java.util.List;

public interface CellClassGroupDao {

    public List<CrcellclassgroupRecord> getCellClassGroups();

}

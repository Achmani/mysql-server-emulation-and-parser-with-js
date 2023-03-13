package id.mit.chrono.server.database.dao.cellpattern;

import id.mit.chrono.server.model.tables.records.CrcellpatternRecord;

import java.util.List;

public interface CellPatternDao {

    public List<CrcellpatternRecord> getCellPatterns();

}

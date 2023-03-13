package id.mit.chrono.server.database.dao.cell;

import id.mit.chrono.server.model.tables.Crcell;
import id.mit.chrono.server.model.tables.records.CrcellRecord;

import java.util.List;

public interface CellDao {

    public List<CrcellRecord> getCells();

}

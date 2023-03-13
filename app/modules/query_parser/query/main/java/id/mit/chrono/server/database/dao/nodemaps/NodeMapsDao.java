package id.mit.chrono.server.database.dao.nodemaps;

import id.mit.chrono.server.model.tables.Crnodemaps;
import id.mit.chrono.server.model.tables.records.CrnodemapsRecord;

import java.util.List;

public interface NodeMapsDao {

    public List<CrnodemapsRecord> getNodeMaps();

}

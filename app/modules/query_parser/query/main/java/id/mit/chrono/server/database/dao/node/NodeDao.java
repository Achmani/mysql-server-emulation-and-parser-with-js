package id.mit.chrono.server.database.dao.node;

import id.mit.chrono.server.model.tables.Crnode;
import id.mit.chrono.server.model.tables.records.CrnodeRecord;

import java.util.List;

public interface NodeDao {

    public List<CrnodeRecord> getNodes();
    public List<CrnodeRecord> getNodeAliases();

}

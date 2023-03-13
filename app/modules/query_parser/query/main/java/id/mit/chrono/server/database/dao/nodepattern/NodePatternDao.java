package id.mit.chrono.server.database.dao.nodepattern;

import id.mit.chrono.server.model.tables.records.CrnodepatternRecord;

import java.util.List;

public interface NodePatternDao {

    public List<CrnodepatternRecord> getNodePatterns();

}

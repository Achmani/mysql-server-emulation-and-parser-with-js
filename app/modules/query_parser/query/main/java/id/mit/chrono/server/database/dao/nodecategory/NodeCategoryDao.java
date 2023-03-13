package id.mit.chrono.server.database.dao.nodecategory;

import id.mit.chrono.server.model.tables.Crnodecategory;
import id.mit.chrono.server.model.tables.records.CrnodecategoryRecord;

import java.util.List;

public interface NodeCategoryDao {

    public List<CrnodecategoryRecord> getNodeCategories();

}

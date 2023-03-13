package id.mit.chrono.server.database.dao.timecatalog;

import id.mit.chrono.server.model.tables.records.CrtimecatalogRecord;

public interface TimeCatalogDao {

    public CrtimecatalogRecord getSingleTimeCatalog(int id, int epochTime);
    public CrtimecatalogRecord insertTimeCatalog(int epochTime, int dataGroupId);

}

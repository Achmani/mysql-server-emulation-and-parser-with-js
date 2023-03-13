package id.mit.chrono.server.database.dao.site;

import id.mit.chrono.server.model.tables.records.CrsiteRecord;
import org.jooq.Result;

public interface SiteDao {

    Result<CrsiteRecord> getSites();

    Result<CrsiteRecord> getSites(int limit);

    CrsiteRecord getSiteBySiteCode(String siteCode);

    void updateSites(String siteCode, String siteClass);

    void runSQL(String sql);

}

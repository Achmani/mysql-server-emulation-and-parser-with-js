package id.mit.chrono.server.database.dao.site;

import id.mit.chrono.server.database.DatabaseHelper;
import id.mit.chrono.server.model.tables.records.CrsiteRecord;
import org.jooq.DSLContext;
import org.jooq.Result;

import static id.mit.chrono.server.model.tables.Crsite.CRSITE;

public class SiteDaoImpl implements SiteDao {

    DSLContext db;

    public SiteDaoImpl() {
        this.db = DatabaseHelper.connectDB();
    }

    @Override
    public Result<CrsiteRecord> getSites() {
        return db.selectFrom(CRSITE).fetch();
    }

    @Override
    public Result<CrsiteRecord> getSites(int limit) {
        return db.selectFrom(CRSITE).limit(limit).fetch();
    }

    @Override
    public CrsiteRecord getSiteBySiteCode(String siteCode) {
        return db.selectFrom(CRSITE).where(CRSITE.SITE_CODE.equal(siteCode)).fetchAny();
    }


    @Override
    public void updateSites(String siteCode, String siteClass) {
        db.update(CRSITE)
                .set(CRSITE.SITE_SITECLASS, siteClass)
                .where(CRSITE.SITE_CODE.equal(siteCode))
                .execute();
    }

    @Override
    public void runSQL(String sql) {
        db.execute(sql);
    }
}

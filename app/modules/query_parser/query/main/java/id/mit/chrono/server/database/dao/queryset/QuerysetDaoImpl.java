package id.mit.chrono.server.database.dao.queryset;

import id.mit.chrono.server.database.DatabaseHelper;
import id.mit.chrono.server.model.tables.records.CrquerysetRecord;
import org.jooq.DSLContext;
import org.jooq.Result;

import static id.mit.chrono.server.model.Tables.CRQUERYSET;

public class QuerysetDaoImpl implements QuerysetDao {

    private DSLContext db;

    public QuerysetDaoImpl() {
        this.db = DatabaseHelper.connectDB();
    }

    @Override
    public Result<CrquerysetRecord> getQueryset() {
        return db.selectFrom(CRQUERYSET).where(CRQUERYSET.QUERYSET_ENABLED.eq((byte) 1)).fetch();
    }

    @Override
    public Result<CrquerysetRecord> getQuerysetsByEntityGroup(String entityGroup) {
        return db.selectFrom(CRQUERYSET)
                .where(CRQUERYSET.QUERYSET_ENTITYGROUP.eq(entityGroup))
                .and(CRQUERYSET.QUERYSET_ENABLED.eq((byte) 1))
                .orderBy(CRQUERYSET.QUERYSET_CODE.asc())
                .fetch();
    }

    @Override
    public Result<CrquerysetRecord> getQuerysetsByEntityGroup(String[] entityGroups) {
        return db.selectFrom(CRQUERYSET)
                .where(CRQUERYSET.QUERYSET_ENTITYGROUP.in(entityGroups))
                .and(CRQUERYSET.QUERYSET_ENABLED.eq((byte) 1))
                .orderBy(CRQUERYSET.QUERYSET_CODE.asc())
                .fetch();
    }

    @Override
    public Result<CrquerysetRecord> getQueryset(Integer vendorId) {
        return db.selectFrom(CRQUERYSET)
                .where(CRQUERYSET.QUERYSET_VENDOR.eq(vendorId))
                .and(CRQUERYSET.QUERYSET_ENABLED.eq((byte) 1))
                .orderBy(CRQUERYSET.QUERYSET_CODE.asc())
                .fetch();
    }

    @Override
    public Result<CrquerysetRecord> getQueryset(Integer[] vendorIds) {
        return db.selectFrom(CRQUERYSET)
                .where(CRQUERYSET.QUERYSET_VENDOR.in(vendorIds))
                .and(CRQUERYSET.QUERYSET_ENABLED.eq((byte) 1))
                .orderBy(CRQUERYSET.QUERYSET_CODE.asc())
                .fetch();
    }

    @Override
    public Result<CrquerysetRecord> getQuerysetByTableTarget(String tableTarget) {
        return db.selectFrom(CRQUERYSET)
                .where(CRQUERYSET.QUERYSET_TABLETARGET.eq(tableTarget))
                .and(CRQUERYSET.QUERYSET_ENABLED.eq((byte) 1))
                .orderBy(CRQUERYSET.QUERYSET_CODE.asc())
                .fetch();
    }

    @Override
    public Result<CrquerysetRecord> getQuerysetByTableTargets(String[] tableTargets) {
        return db.selectFrom(CRQUERYSET)
                .where(CRQUERYSET.QUERYSET_TABLETARGET.in(tableTargets))
                .and(CRQUERYSET.QUERYSET_ENABLED.eq((byte) 1))
                .orderBy(CRQUERYSET.QUERYSET_CODE.asc())
                .fetch();
    }

    @Override
    public CrquerysetRecord getSingleQuerysetByTableTarget(String tableTarget) {
        return db.selectFrom(CRQUERYSET)
                .where(CRQUERYSET.QUERYSET_TABLETARGET.eq(tableTarget))
                .and(CRQUERYSET.QUERYSET_ENABLED.eq((byte) 1))
                .fetchAny();
    }

    @Override
    public Result<CrquerysetRecord> getQuerysetByEntity(String entity) {
        return db.selectFrom(CRQUERYSET)
                .where(CRQUERYSET.QUERYSET_ENTITY.eq(entity))
                .and(CRQUERYSET.QUERYSET_ENABLED.eq((byte) 1))
                .orderBy(CRQUERYSET.QUERYSET_CODE.asc())
                .fetch();
    }

    @Override
    public Result<CrquerysetRecord> getQuerysetByEntities(String[] entities) {
        return db.selectFrom(CRQUERYSET)
                .where(CRQUERYSET.QUERYSET_ENTITY.in(entities))
                .and(CRQUERYSET.QUERYSET_ENABLED.eq((byte) 1))
                .orderBy(CRQUERYSET.QUERYSET_CODE.asc())
                .fetch();
    }

    @Override
    public CrquerysetRecord getSingleQuerysetByEntity(String entity) {
        return db.selectFrom(CRQUERYSET)
                .where(CRQUERYSET.QUERYSET_ENTITY.eq(entity))
                .and(CRQUERYSET.QUERYSET_ENABLED.eq((byte) 1))
                .fetchAny();
    }
}

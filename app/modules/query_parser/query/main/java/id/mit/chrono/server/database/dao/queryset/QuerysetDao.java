package id.mit.chrono.server.database.dao.queryset;

import id.mit.chrono.server.model.tables.records.CrquerysetRecord;
import id.mit.chrono.server.model.tables.records.CrworkflowRecord;
import org.jooq.Result;

public interface QuerysetDao {

    public Result<CrquerysetRecord> getQueryset();

    public Result<CrquerysetRecord> getQuerysetsByEntityGroup(String entityGroup);

    public Result<CrquerysetRecord> getQuerysetsByEntityGroup(String[] entityGroups);

    public Result<CrquerysetRecord> getQueryset(Integer vendorId);

    public Result<CrquerysetRecord> getQueryset(Integer[] vendorIds);

    public Result<CrquerysetRecord> getQuerysetByTableTarget(String tableTarget);

    public Result<CrquerysetRecord> getQuerysetByTableTargets(String[] tableTargets);

    public CrquerysetRecord getSingleQuerysetByTableTarget(String tableTarget);

    public Result<CrquerysetRecord> getQuerysetByEntity(String entity);

    public Result<CrquerysetRecord> getQuerysetByEntities(String[] entities);

    public CrquerysetRecord getSingleQuerysetByEntity(String entity);

}

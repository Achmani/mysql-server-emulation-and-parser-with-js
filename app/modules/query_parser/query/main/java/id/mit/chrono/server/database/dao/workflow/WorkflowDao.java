package id.mit.chrono.server.database.dao.workflow;

import id.mit.chrono.server.model.tables.records.CrworkflowRecord;
import org.jooq.Result;

public interface WorkflowDao {

    public Result<CrworkflowRecord> getWorkflows();

    public Result<CrworkflowRecord> getWorkflowsByEntityGroup(String entityGroup);

    public Result<CrworkflowRecord> getWorkflowsByEntityGroup(String[] entityGroups);

    public Result<CrworkflowRecord> getWorkflows(Integer vendorId);

    public Result<CrworkflowRecord> getWorkflows(Integer[] vendorIds);

    public Result<CrworkflowRecord> getWorkflowsByEntityGroup(String entityGroup, Integer phase);

    public Result<CrworkflowRecord> getWorkflowsByEntity(String entity);

    public Result<CrworkflowRecord> getWorkflowsByEntity(String[] entities);

    public Result<CrworkflowRecord> getWorkflowsByEntity(String entity, Integer phase);

    // TODO: add getWorkflowByEntity & rename current getWorkflow as getWorkflowByEntityGroup

    public CrworkflowRecord getWorkflowByEntityGroup(String entityGroup, Integer phase);

    public CrworkflowRecord getWorkflowByEntity(String entity, Integer phase);

    public Result<CrworkflowRecord> getWorkflowsByPhase(Integer phase);

}

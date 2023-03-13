package id.mit.chrono.server.database.dao.workflow;

import id.mit.chrono.server.database.DatabaseHelper;
import id.mit.chrono.server.model.tables.records.CrworkflowRecord;
import org.jooq.DSLContext;
import org.jooq.Result;

import static id.mit.chrono.server.model.Tables.CRWORKFLOW;

public class WorkflowDaoImpl implements WorkflowDao {


    private DSLContext db;

    public WorkflowDaoImpl() {
        this.db = DatabaseHelper.connectDB();
    }

    @Override
    public Result<CrworkflowRecord> getWorkflows() {
        return db.selectFrom(CRWORKFLOW).where(CRWORKFLOW.WORKFLOW_ENABLED.eq((byte) 1)).fetch();
    }

    @Override
    public Result<CrworkflowRecord> getWorkflowsByEntityGroup(String entityGroup) {
        return db.selectFrom(CRWORKFLOW)
                .where(CRWORKFLOW.WORKFLOW_ENTITYGROUP.equal(entityGroup))
                .and(CRWORKFLOW.WORKFLOW_ENABLED.eq((byte) 1))
                .fetch();
    }

    @Override
    public Result<CrworkflowRecord> getWorkflowsByEntityGroup(String[] entitiesGroup) {
        return db.selectFrom(CRWORKFLOW)
                .where(CRWORKFLOW.WORKFLOW_ENTITYGROUP.in(entitiesGroup))
                .and(CRWORKFLOW.WORKFLOW_ENABLED.eq((byte) 1))
                .fetch();
    }

    @Override
    public Result<CrworkflowRecord> getWorkflows(Integer vendorId) {
        return db.selectFrom(CRWORKFLOW)
                .where(CRWORKFLOW.WORKFLOW_VENDOR.eq(vendorId))
                .and(CRWORKFLOW.WORKFLOW_ENABLED.eq((byte) 1))
                .fetch();
    }

    @Override
    public Result<CrworkflowRecord> getWorkflows(Integer[] vendorIds) {
        return db.selectFrom(CRWORKFLOW)
                .where(CRWORKFLOW.WORKFLOW_VENDOR.in(vendorIds))
                .and(CRWORKFLOW.WORKFLOW_ENABLED.eq((byte) 1))
                .fetch();
    }

    @Override
    public CrworkflowRecord getWorkflowByEntityGroup(String entityGroup, Integer phase) {
        return db.selectFrom(CRWORKFLOW)
                .where(CRWORKFLOW.WORKFLOW_ENTITYGROUP.equal(entityGroup))
                .and(CRWORKFLOW.WORKFLOW_PHASE.eq(phase))
                .and(CRWORKFLOW.WORKFLOW_ENABLED.eq((byte) 1))
                .fetchAny();
    }

    @Override
    public Result<CrworkflowRecord> getWorkflowsByEntityGroup(String entityGroup, Integer phase) {
        return db.selectFrom(CRWORKFLOW)
                .where(CRWORKFLOW.WORKFLOW_ENTITYGROUP.equal(entityGroup))
                .and(CRWORKFLOW.WORKFLOW_PHASE.eq(phase))
                .and(CRWORKFLOW.WORKFLOW_ENABLED.eq((byte) 1))
                .fetch();
    }

    @Override
    public Result<CrworkflowRecord> getWorkflowsByEntity(String entity) {
        return db.selectFrom(CRWORKFLOW)
                .where(CRWORKFLOW.WORKFLOW_ENTITY.equal(entity))
                .and(CRWORKFLOW.WORKFLOW_ENABLED.eq((byte) 1))
                .fetch();
    }

    @Override
    public Result<CrworkflowRecord> getWorkflowsByEntity(String[] entities) {
        return db.selectFrom(CRWORKFLOW)
                .where(CRWORKFLOW.WORKFLOW_ENTITY.in(entities))
                .and(CRWORKFLOW.WORKFLOW_ENABLED.eq((byte) 1))
                .fetch();
    }

    @Override
    public Result<CrworkflowRecord> getWorkflowsByEntity(String entity, Integer phase) {
        return db.selectFrom(CRWORKFLOW)
                .where(CRWORKFLOW.WORKFLOW_ENTITY.equal(entity))
                .and(CRWORKFLOW.WORKFLOW_PHASE.eq(phase))
                .and(CRWORKFLOW.WORKFLOW_ENABLED.eq((byte) 1))
                .fetch();
    }

    @Override
    public CrworkflowRecord getWorkflowByEntity(String entity, Integer phase) {
        return db.selectFrom(CRWORKFLOW)
                .where(CRWORKFLOW.WORKFLOW_ENTITY.equal(entity))
                .and(CRWORKFLOW.WORKFLOW_PHASE.eq(phase))
                .and(CRWORKFLOW.WORKFLOW_ENABLED.eq((byte) 1))
                .fetchAny();
    }

    @Override
    public Result<CrworkflowRecord> getWorkflowsByPhase(Integer phase) {
        return db.selectFrom(CRWORKFLOW)
                .where(CRWORKFLOW.WORKFLOW_PHASE.eq(phase))
                .and(CRWORKFLOW.WORKFLOW_ENABLED.eq((byte) 1))
                .fetch();
    }
}

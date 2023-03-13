package id.mit.chrono.server.obj;

import id.mit.chrono.server.factory.DaoFactory;
import id.mit.chrono.server.model.tables.records.ColumnsetRecord;
import id.mit.chrono.server.model.tables.records.CrprocessortaskfilesRecord;
import id.mit.chrono.server.model.tables.records.CrworkflowRecord;

import java.util.HashMap;
import java.util.List;

public class PreparatorResultGroup {

    private long taskFileId;
    private CrworkflowRecord workflowPhase2;
    private List<PreparatorResult> processedFiles;
    private HashMap<String, String> queryEntity;
    private String entityGroup;
    private int vendor;

    public PreparatorResultGroup() {}

    public PreparatorResultGroup(CrworkflowRecord workflowPhase2, List<PreparatorResult> processedFiles) {
        this.workflowPhase2 = workflowPhase2;
        this.processedFiles = processedFiles;
    }

    public CrworkflowRecord getWorkflowPhase2() {
        return workflowPhase2;
    }

    public void setWorkflowPhase2(CrworkflowRecord workflowPhase2) {
        this.workflowPhase2 = workflowPhase2;
    }

    public List<PreparatorResult> getProcessedFiles() {
        return processedFiles;
    }

    public void setProcessedFiles(List<PreparatorResult> processedFiles) {
        this.processedFiles = processedFiles;
    }

    public long getTaskFileId() {
        return taskFileId;
    }

    public void setTaskFileId(long taskFileId) {
        this.taskFileId = taskFileId;
    }

    public HashMap<String, String> getQueryEntity() {
        return queryEntity;
    }

    public void setQueryEntity(HashMap<String, String> queryEntity) {
        this.queryEntity = queryEntity;
    }

    public String getEntityGroup() {
        return entityGroup;
    }

    public void setEntityGroup(String entityGroup) {
        this.entityGroup = entityGroup;
    }

    public int getVendor() {
        return vendor;
    }

    public void setVendor(int vendor) {
        this.vendor = vendor;
    }
}
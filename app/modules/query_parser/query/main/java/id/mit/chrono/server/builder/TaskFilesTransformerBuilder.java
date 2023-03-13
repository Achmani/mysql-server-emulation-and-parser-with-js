package id.mit.chrono.server.builder;

public class TaskFilesTransformerBuilder {

    private String[] entities;
    private Integer[] fileIds;
//    private Integer phase;
    private boolean reProcess;
    private int poolsize = 10;
    private String workflow;
    private boolean mapping;

    public TaskFilesTransformerBuilder() { }

    private TaskFilesTransformerBuilder(String[] entities, Integer[] fileIds, boolean reProcess, int poolsize, String workflow, boolean mapping) {
        this.entities = entities;
        this.fileIds = fileIds;
        this.reProcess = reProcess;
        this.poolsize = poolsize;
        this.workflow = workflow;
        this.mapping = mapping;
    }

    public TaskFilesTransformerBuilder setEntities(String[] entities) {
        this.entities = entities;
        return this;
    }

    public TaskFilesTransformerBuilder setFileIds(Integer[] fileIds) {
        this.fileIds = fileIds;
        return this;
    }

    public TaskFilesTransformerBuilder setReprocess(boolean reProcess) {
        this.reProcess = reProcess;
        return this;
    }

    public TaskFilesTransformerBuilder setMapping(boolean mapping) {
        this.reProcess = mapping;
        return this;
    }

    public TaskFilesTransformerBuilder setPoolsize(int poolsize) {
        this.poolsize = poolsize;
        return this;
    }

    public String[] getEntities() {
        return entities;
    }

    public String getWorkflow() {
        return workflow;
    }

    public TaskFilesTransformerBuilder setWorkflow(String workflow) {
        this.workflow = workflow;
        return this;
    }

    public Integer[] getFileIds() {
        return fileIds;
    }

    public boolean isReProcess() {
        return reProcess;
    }

    public int getPoolsize() {
        return poolsize;
    }

    public boolean isMapping() {
        return mapping;
    }

    public TaskFilesTransformerBuilder build() {
        return new TaskFilesTransformerBuilder(
                this.entities,
                this.fileIds,
                this.reProcess,
                this.poolsize,
                this.workflow,
                this.mapping
        );
    }
}

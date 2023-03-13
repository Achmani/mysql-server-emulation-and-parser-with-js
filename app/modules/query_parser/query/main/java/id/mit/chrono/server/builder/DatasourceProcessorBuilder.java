package id.mit.chrono.server.builder;

public class DatasourceProcessorBuilder {

    private String[] dataSources;
    private String[] fileNames;
    private Integer[] fileIds;
    private String[] entities;
    private boolean reProcess;
    private int fileCountLimit;

    public DatasourceProcessorBuilder() {
    }

    public DatasourceProcessorBuilder(String[] dataSources, String[] fileNames, Integer[] fileIds, String[] entities, boolean reProcess, int fileCountLimit) {
        this.dataSources = dataSources;
        this.fileNames = fileNames;
        this.fileIds = fileIds;
        this.entities = entities;
        this.reProcess = reProcess;
        this.fileCountLimit = fileCountLimit;
    }

    public DatasourceProcessorBuilder setReProcess(boolean reProcess) {
        this.reProcess = reProcess;
        return this;
    }

    public DatasourceProcessorBuilder setFileCountLimit(int fileCountLimit) {
        this.fileCountLimit = fileCountLimit;
        return this;
    }

    public DatasourceProcessorBuilder setDataSources(String[] dataSources) {
        this.dataSources = dataSources;
        return this;
    }

    public DatasourceProcessorBuilder setFileNames(String[] fileNames) {
        this.fileNames = fileNames;
        return this;
    }

    public DatasourceProcessorBuilder setFileIds(Integer[] fileIds) {
        this.fileIds = fileIds;
        return this;
    }

    public DatasourceProcessorBuilder setEntities(String[] entities) {
        this.entities = entities;
        return this;
    }

    public String[] getDataSources() {
        return dataSources;
    }

    public String[] getFileNames() {
        return fileNames;
    }

    public Integer[] getFileIds() {
        return fileIds;
    }

    public String[] getEntities() {
        return entities;
    }

    public boolean isReProcess() {
        return reProcess;
    }

    public int getFileCountLimit() {
        return fileCountLimit;
    }

    public DatasourceProcessorBuilder build() {
        return new DatasourceProcessorBuilder(
                this.dataSources,
                this.fileNames,
                this.fileIds,
                this.entities,
                this.reProcess,
                this.fileCountLimit
        );
    }
}

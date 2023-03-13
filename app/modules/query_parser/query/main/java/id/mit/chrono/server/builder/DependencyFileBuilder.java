package id.mit.chrono.server.builder;

public class DependencyFileBuilder {

    private String[] depsPattern;
    private boolean reProcess;
    private Integer datasourceId;
    private String masterFilename;
    private String localdir;

    public DependencyFileBuilder() {}

    public DependencyFileBuilder(String[] depsPattern, boolean reProcess, Integer datasourceId, String masterFilename, String localdir) {
        this.depsPattern = depsPattern;
        this.reProcess = reProcess;
        this.datasourceId = datasourceId;
        this.masterFilename = masterFilename;
        this.localdir = localdir;
    }

    public String[] getDepsPattern() {
        return depsPattern;
    }

    public DependencyFileBuilder setDepsPattern(String[] depsPattern) {
        this.depsPattern = depsPattern;
        return this;
    }

    public boolean isReProcess() {
        return reProcess;
    }

    public DependencyFileBuilder setReProcess(boolean reProcess) {
        this.reProcess = reProcess;
        return this;
    }

    public Integer getDatasourceId() {
        return datasourceId;
    }

    public DependencyFileBuilder setDatasourceId(Integer datasourceId) {
        this.datasourceId = datasourceId;
        return this;
    }

    public String getMasterFilename() {
        return masterFilename;
    }

    public DependencyFileBuilder setMasterFilename(String masterFilename) {
        this.masterFilename = masterFilename;
        return this;
    }

    public String getLocaldir() {
        return localdir;
    }

    public DependencyFileBuilder setLocaldir(String localdir) {
        this.localdir = localdir;
        return this;
    }

    public DependencyFileBuilder build() {
        return new DependencyFileBuilder(
                this.depsPattern,
                this.reProcess,
                this.datasourceId,
                this.masterFilename,
                this.localdir
        );
    }
}

package id.mit.chrono.server.obj;

import org.jooq.Record;

public class FinalizerDataSourceData {

    public int datasourceId;
    public String dataSourceCode;
    public int totalFileD;
    public int totalFileD1;

    public FinalizerDataSourceData(int datasourceId, String dataSourceCode, int totalFileD, int totalFileD1) {
        this.datasourceId = datasourceId;
        this.dataSourceCode = dataSourceCode;
        this.totalFileD = totalFileD;
        this.totalFileD1 = totalFileD1;
    }

    public int getDatasourceId() {
        return datasourceId;
    }

    public String getDataSourceCode() {
        return dataSourceCode;
    }

    public int getTotalFileD() {
        return totalFileD;
    }

    public int getTotalFileD1() {
        return totalFileD1;
    }
}

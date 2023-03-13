package id.mit.chrono.server.iface;

import id.mit.chrono.server.model.tables.records.CrworkflowRecord;
import id.mit.chrono.server.obj.ChronoContext;
import id.mit.chrono.server.obj.HDFSCl;
import org.jooq.DSLContext;
import org.jooq.Record;

import java.util.List;

public interface Extractor extends Runnable {

    public void setFile(Record file);

    public Record getFile();

    public void startExtract(DSLContext db);

    public void setReprocess(boolean reProcess);

    public void setWorkflow(CrworkflowRecord workflow);

    public void setCallback(ExtractorCallback callback);

    public void setContext(ChronoContext context);

    public void setHdfsClient(HDFSCl dfs);

    public void borrowDSLContext(DSLContext db);

//    public void returnDSLContext(DSLContext db);

}

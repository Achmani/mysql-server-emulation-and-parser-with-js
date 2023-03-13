package id.mit.chrono.server.iface;

import id.mit.chrono.server.model.tables.records.CrworkflowRecord;
import id.mit.chrono.server.obj.ChronoContext;
import org.jooq.Record;

public interface Preparator extends Runnable{

    public void setWorkflow(CrworkflowRecord workflow);

    public void setFile(Record file);

    public void setReprocess(boolean reProcess);

    public void setContext(ChronoContext context);

    public void setCallback(PreparatorCallback callback);

    public void start();

}

package id.mit.chrono.server.iface;

import id.mit.chrono.server.obj.ChronoContext;
import id.mit.chrono.server.obj.PreparatorResultGroup;
import org.jooq.DSLContext;

public interface Mapper extends Runnable {

    public void start();

    public void setCallback(MapperCallback callback);

    public void setContext(ChronoContext context);

    public void setDSLContext(DSLContext dslC);

    public void setResultGroup(PreparatorResultGroup resultGroup);

}

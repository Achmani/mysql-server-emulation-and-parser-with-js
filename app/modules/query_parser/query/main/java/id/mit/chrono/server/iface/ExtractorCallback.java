package id.mit.chrono.server.iface;

import org.jooq.DSLContext;

public interface ExtractorCallback {

    public void onExtractFinished(DSLContext db);

}

package id.mit.chrono.server.iface;

import id.mit.chrono.server.model.tables.records.CrmapparserRecord;
import id.mit.chrono.server.obj.ChronoContext;

public interface FileParserCallback {

    public CrmapparserRecord getSuitableMapParser(String fileName);

    public FileParser getParserByClassName(String identifier);

    public void onFileParserFinished(FileParser fp);

    public ChronoContext getContext();
}

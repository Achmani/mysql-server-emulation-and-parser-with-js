package id.mit.chrono.server.iface;

import id.mit.chrono.server.base.BaseParserGroup;
import id.mit.chrono.server.enm.PS;
import id.mit.chrono.server.obj.ProcessStat;
import org.jooq.DSLContext;

import java.util.ArrayList;

public interface FileProcessor {

    public String getKey();

    public boolean isFinished(PS state);

    public boolean proposeProcess(PS state);

    public boolean process(DSLContext db,  PS state);

    public boolean processAll(DSLContext db);
}

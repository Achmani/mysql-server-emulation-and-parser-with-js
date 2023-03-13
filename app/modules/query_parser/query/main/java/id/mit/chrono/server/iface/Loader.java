package id.mit.chrono.server.iface;

import id.mit.chrono.server.obj.ChronoContext;
import id.mit.chrono.server.obj.DrillCl;
import id.mit.chrono.server.obj.PreparatorResultGroup;

import java.util.HashMap;

public interface Loader {

    public void setContext(ChronoContext context);

//    public void setQueries(HashMap<String, String> drillQueries);

    public void start();

    public void setDrillClient(DrillCl drillCl);

    public void setResultGroup(PreparatorResultGroup resultGroup);

    public void setParserGroupCallback(ParserGroupCallback pgc);

}

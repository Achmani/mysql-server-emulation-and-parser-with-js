package id.mit.chrono.server.iface;

import id.mit.chrono.server.obj.PreparatorResultGroup;

import java.util.HashMap;
import java.util.List;

public interface TransformerConstructorCallback {

//    public void onConstructorFinished(List<HashMap<String, String>> drillQueries);

    public void onConstructorFinished(List<PreparatorResultGroup> resultGroups);

}

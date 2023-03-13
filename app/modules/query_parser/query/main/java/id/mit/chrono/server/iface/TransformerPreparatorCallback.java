package id.mit.chrono.server.iface;

import id.mit.chrono.server.obj.PreparatorResultGroup;

import java.util.List;

public interface TransformerPreparatorCallback {

    public void onPreparatorFinished(List<PreparatorResultGroup> preparatorResultGroups);

}

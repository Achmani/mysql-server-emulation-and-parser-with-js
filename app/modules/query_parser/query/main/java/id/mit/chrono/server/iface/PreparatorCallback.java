package id.mit.chrono.server.iface;

import id.mit.chrono.server.obj.PreparatorResultGroup;

public interface PreparatorCallback {

    void onPrepareFinished(PreparatorResultGroup preparatorResultGroup);

}

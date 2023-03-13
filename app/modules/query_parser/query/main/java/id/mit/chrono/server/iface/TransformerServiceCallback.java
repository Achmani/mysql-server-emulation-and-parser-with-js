package id.mit.chrono.server.iface;

import id.mit.chrono.server.obj.PreparatorResultGroup;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public interface TransformerServiceCallback {

    public void onTransformSuccess(List<PreparatorResultGroup> resultGroups);

    public void onTransformFailed(String reason);

}

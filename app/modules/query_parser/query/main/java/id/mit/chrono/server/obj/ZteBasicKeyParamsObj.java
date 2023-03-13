package id.mit.chrono.server.obj;

import java.util.HashMap;

public class ZteBasicKeyParamsObj {

    public String group;
    public HashMap<String, String> params;

    public ZteBasicKeyParamsObj(String group, HashMap<String, String> params) {
        this.group = group;
        this.params = params;
    }
}
package id.mit.chrono.server.obj;

import java.util.HashMap;

public class ErBasicTagParamsObj {

    public String tag;
    public HashMap<String, String> params;

    public ErBasicTagParamsObj(String tag, HashMap<String, String> params) {
        this.tag = tag;
        this.params = params;
    }
}
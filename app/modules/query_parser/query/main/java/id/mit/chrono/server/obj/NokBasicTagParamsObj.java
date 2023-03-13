package id.mit.chrono.server.obj;

import java.util.HashMap;

public class NokBasicTagParamsObj {

    public String className;
    public HashMap<String, String> params;

    public NokBasicTagParamsObj(String className, HashMap<String, String> params) {
        this.className = className;
        this.params = params;
    }
}
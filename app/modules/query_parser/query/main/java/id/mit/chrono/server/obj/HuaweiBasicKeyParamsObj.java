package id.mit.chrono.server.obj;

import java.util.HashMap;

public class HuaweiBasicKeyParamsObj {

    public String command;
    public HashMap<String, String> params;

    public HuaweiBasicKeyParamsObj(String command, HashMap<String, String> params) {
        this.command = command;
        this.params = params;
    }
}
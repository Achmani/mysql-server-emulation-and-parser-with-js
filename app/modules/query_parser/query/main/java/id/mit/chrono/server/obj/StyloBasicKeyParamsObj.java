package id.mit.chrono.server.obj;

import java.util.HashMap;

public class StyloBasicKeyParamsObj {

    public String command;
    public HashMap<String, String> params;

    public StyloBasicKeyParamsObj(String command, HashMap<String, String> params) {
        this.command = command;
        this.params = params;
    }
}
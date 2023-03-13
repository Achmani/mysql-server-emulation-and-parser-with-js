package id.mit.chrono.server.obj;

import java.util.ArrayList;
import java.util.HashMap;

public class ParserGroupObj {

    // to store this record key, nullable
    public String key;

    // not usable for 1st level entity
    public String refKey;

    public HashMap<String, String> values = new HashMap<String, String>();

    public ArrayList<ParserGroupObj> childs = new ArrayList<ParserGroupObj>();

    public ParserGroupObj(String key) {
        this.key = key;
    }

    @Override
    public String toString(){

        String params = "";

        for(String key: this.values.keySet()){

            if(!params.isEmpty()){
                params += ", ";
            }

            params += key + ":" + this.values.get(key);

        }

        return "key:" + this.key + ", refKey:" + this.refKey + " => " + params;
    }
}

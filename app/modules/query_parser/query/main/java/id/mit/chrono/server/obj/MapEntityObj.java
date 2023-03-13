package id.mit.chrono.server.obj;

import id.mit.chrono.server.model.tables.records.CrmapentityRecord;
import id.mit.chrono.server.model.tables.records.CrmapfieldRecord;

import java.util.ArrayList;
import java.util.List;

public class MapEntityObj {

    // definition of entity level
    public CrmapentityRecord mr;

    // definition of original fields
    public List<CrmapfieldRecord> mft = new ArrayList<>();

    // list of child
    public ArrayList<MapEntityObj> childs = new ArrayList<>();

    public MapEntityObj(CrmapentityRecord mr, List<CrmapfieldRecord> mft) {
        this.mr = mr;
        this.mft = mft;
    }

    public MapEntityObj getChildEntityByTableName(String tableName){

        MapEntityObj obj = this.childs.stream()
        .filter(p -> p.mr.getMapentityTablename().equals(tableName))
        .findAny().get();

        return obj;
    }

    public ArrayList<String> getUsedSourceGroup(){

        ArrayList<String> result = new ArrayList<String>();

        String temp;

        for (int i = 0; i < mft.size(); i++) {

            // source group
            temp = mft.get(i).getMapfieldSourcegroup();
            if(!temp.isEmpty() && !result.contains(temp)){
                result.add(temp);
            }

            // source group backup
            temp = mft.get(i).getMapfieldSourcegroupbackup();
            if(!temp.isEmpty() && !result.contains(temp)){
                result.add(temp);
            }

            // source group check
            temp = mft.get(i).getMapfieldSourcegroupcheck();
            if(!temp.isEmpty() && !result.contains(temp)){
                result.add(temp);
            }
        }


        return result;
    }
}

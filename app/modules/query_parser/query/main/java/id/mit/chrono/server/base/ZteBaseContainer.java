package id.mit.chrono.server.base;

import id.mit.chrono.server.enm.PS;
import id.mit.chrono.server.iface.ParserGroupCallback;
import id.mit.chrono.server.model.tables.records.CrmapfieldRecord;
import id.mit.chrono.server.obj.*;
import org.jooq.DSLContext;
import org.jooq.impl.DSL;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public abstract class ZteBaseContainer extends BaseContainer {

//    protected DSLContext db;

    protected List<ZteBasicKeyParamsObj> result;

    public ZteBaseContainer(DSLContext db, ParserGroupCallback pgc, ChronoContext context, SourceFile sf, MapEntityObj meo) {

//        this.db = db;
        this.pgc = pgc;
        this.context = context;
        this.sf = sf;
        this.meo = meo;
    }

    public String getKey(){

        return this.sf.getKey();
    }

    public boolean isFinished(PS state){

        synchronized (this.states){

            return this.states.contains(state);
        }
    }

    public boolean proposeProcess(PS state){

        synchronized (this.states){

            if(this.states.contains(state)){
                return false;
            }

            if(this.workingStates.contains(state)){
                return false;
            }

            this.workingStates.add(state);

            return true;
        }
    }

    protected boolean updateWorkingState(PS state){
        synchronized (this.workingStates){

            if(this.workingStates.contains(state)){

                this.workingStates.remove(state);

                synchronized (this.states){

                    this.states.add(state);

                    return true;
                }
            }
        }

        return false;
    }

    protected void prepareKeyParamsResult(DSLContext db){

        logger.debug("prepareKeyParamsResult(): " + sf.getResult().size());

        result = sf.getResult().stream()
                .filter(ZteBasicKeyParamsObj.class::isInstance)
                .map(ZteBasicKeyParamsObj.class::cast)
                .collect(Collectors.toList());

//        System.out.println("result: ");
//        result.forEach(o -> {
//            System.out.println(o.group);
//            System.out.println(o.params);
//            System.out.println();
//        });

        sf.purgeResult();

        logger.debug("prepareKeyParamsResult() done: " + result.size());
    }

    protected String getKeyParamsValue(CrmapfieldRecord mfr, ArrayList<String> filters){

        String val = null;
        String backupVal = null;
        String tmp,tmp2;

        ZteBasicKeyParamsObj mml;

        for (int i = 0; val == null && i < result.size(); i++) {

            mml = result.get(i);

            if(!mfr.getMapfieldSourcegroup().isEmpty()){

                // prepare for backup val
                if(backupVal == null && !mfr.getMapfieldSourcegroupbackup().isEmpty()){

                    if(mml.group.matches(mfr.getMapfieldSourcegroupbackup())){

                        backupVal = mml.params.get(mfr.getMapfieldSourceparambackup());
                    }
                }

                if(mml.group.matches(mfr.getMapfieldSourcegroup())){

                    boolean ok = true;

                    for (int j = 0; filters != null && ok && j < filters.size(); j+=2) {

                        tmp = mml.params.get(filters.get(j));

                        if(tmp != null){

                            tmp2 = filters.get(j+1);

                            if(!tmp.equals(tmp2)){
                                ok = false;
                            }
                        }
                    }

                    if(ok){

                        val = mml.params.get(mfr.getMapfieldSourceparam());
                    }
                }

                if(val == null && !mfr.getMapfieldSourcegroupbackup().isEmpty()){

                    boolean ok = true;

                    for (int j = 0; filters != null && ok && j < filters.size(); j+=2) {

                        tmp = mml.params.get(filters.get(j));

                        if(tmp != null){

                            tmp2 = filters.get(j+1);

                            if(!tmp.equals(tmp2)){
                                ok = false;
                            }
                        }
                    }

                    if(ok){

                        val = mml.params.get(mfr.getMapfieldSourceparambackup());
                    }
                }
            }
            else if(!mfr.getMapfieldSourcegroupcheck().isEmpty()){

                if(mml.group.matches(mfr.getMapfieldSourcegroupcheck())){

                    boolean ok = true;

                    for (int j = 0; filters != null && ok && j < filters.size(); j+=2) {

                        tmp = mml.params.get(filters.get(j));

                        if(tmp != null){

                            tmp2 = filters.get(j+1);

                            if(!tmp.equals(tmp2)){
                                ok = false;
                            }
                        }
                    }

                    if(ok){

                        val = mfr.getMapfieldValueifcheckexist();
                    }
                }
            }
        }

        // priority: real val, backupval, default value
        if(val == null && backupVal != null){

            val = backupVal;
        }

        if(val == null && mfr.getMapfieldDefaultvalue() != null){

            val = mfr.getMapfieldDefaultvalue();
        }

        if(val != null && mfr.getMapfieldConvertpattern() != null & mfr.getMapfieldConvertfunction() != null){

            if(val.matches(mfr.getMapfieldConvertpattern())){

                if(mfr.getMapfieldConvertfunction().equals("hwHexToInt")){

                    val = this.hwHexToInt(val);
                }
            }
        }

        return val;
    }

    protected String hwHexToInt(String origin){

        return String.valueOf(Integer.parseInt(origin.substring(2), 16));
    }

}

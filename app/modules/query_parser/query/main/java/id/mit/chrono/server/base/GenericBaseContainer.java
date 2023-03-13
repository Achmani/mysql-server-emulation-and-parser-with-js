package id.mit.chrono.server.base;

import id.mit.chrono.server.enm.PS;
import id.mit.chrono.server.iface.ParserGroupCallback;
import id.mit.chrono.server.model.tables.records.CrmapfieldRecord;
import id.mit.chrono.server.obj.*;
import org.jooq.DSLContext;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public abstract class GenericBaseContainer extends BaseContainer {

//    protected DSLContext db;

    protected List<StyloBasicKeyParamsObj> result;

    public GenericBaseContainer(DSLContext db, ParserGroupCallback pgc, ChronoContext context, SourceFile sf, MapEntityObj meo) {

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
                .filter(StyloBasicKeyParamsObj.class::isInstance)
                .map(StyloBasicKeyParamsObj.class::cast)
                .collect(Collectors.toList());

        sf.purgeResult();

        logger.debug("prepareKeyParamsResult() done: " + result.size());
    }

    protected String getKeyParamsValue(CrmapfieldRecord mfr, ArrayList<String> filters){

        String val = null;
        String backupVal = null;
        String tmp,tmp2;

        StyloBasicKeyParamsObj mml;

        for (int i = 0; val == null && i < result.size(); i++) {

            mml = result.get(i);

            // prepare for backup val
            if(backupVal == null && !mfr.getMapfieldSourcegroupbackup().isEmpty()){

                if(mml.command.equals(mfr.getMapfieldSourcegroupbackup())){

                    backupVal = mml.params.get(mfr.getMapfieldSourceparambackup());
                }
            }

            if(!mfr.getMapfieldSourcegroup().isEmpty()){

                if(mml.command.equals(mfr.getMapfieldSourcegroup())){

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

                if(mml.command.matches(mfr.getMapfieldSourcegroupcheck())){

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


                }
            }
        }

        return val;
    }
}

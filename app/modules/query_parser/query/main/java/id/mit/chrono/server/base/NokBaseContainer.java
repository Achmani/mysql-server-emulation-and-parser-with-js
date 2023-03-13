package id.mit.chrono.server.base;

import id.mit.chrono.server.enm.PS;
import id.mit.chrono.server.iface.ParserGroupCallback;
import id.mit.chrono.server.model.tables.records.CrmapfieldRecord;
import id.mit.chrono.server.obj.*;
import org.jooq.DSLContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public abstract class NokBaseContainer extends BaseContainer {

//    protected DSLContext db;

    protected List<NokBasicTagParamsObj> result;

    public NokBaseContainer(DSLContext db, ParserGroupCallback pgc, ChronoContext context, SourceFile sf, MapEntityObj meo) {

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
                .filter(NokBasicTagParamsObj.class::isInstance)
                .map(NokBasicTagParamsObj.class::cast)
                .collect(Collectors.toList());

        sf.purgeResult();

        logger.debug("prepareKeyParamsResult() done: " + result.size());
    }

    protected String getKeyParamsValue(CrmapfieldRecord mfr, ArrayList<String> filters, NokBasicTagParamsObj lookupFrom){

        String val = null;
        String backupVal = null;
        String tmp,tmp2;

        NokBasicTagParamsObj mml;

        for (int i = 0; val == null && i < result.size(); i++) {

            mml = result.get(i);

            if(lookupFrom != null){
                mml = lookupFrom;
            }

            if(!mfr.getMapfieldSourcegroup().isEmpty()){

                // prepare for backup val
                if(backupVal == null && !mfr.getMapfieldSourcegroupbackup().isEmpty()){

                    if(mml.className.equals(mfr.getMapfieldSourcegroupbackup())){

                        backupVal = mml.params.get(mfr.getMapfieldSourceparambackup());
                    }
                }

                if(mml.className.equals(mfr.getMapfieldSourcegroup())){

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

                if(mml.className.equals(mfr.getMapfieldSourcegroupcheck())){

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

            if(lookupFrom != null){
                break;
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

                if(mfr.getMapfieldConvertfunction().equals("getLnBtsId")){

                    val = this.getLnBtsId(val, mfr.getMapfieldConvertpattern());
                }
                else if(mfr.getMapfieldConvertfunction().equals("getRncId")){

                    val = this.getRncId(val, mfr.getMapfieldConvertpattern());
                }
                else if(mfr.getMapfieldConvertfunction().equals("NokiaGetBtsId")){

                    val = this.getBtsId(val, mfr.getMapfieldConvertpattern());
                }
                else if(mfr.getMapfieldConvertfunction().equals("NokiaGetNodebId")){

                    val = this.getNodebId(val, mfr.getMapfieldConvertpattern());
                }
                else if(mfr.getMapfieldConvertfunction().equals("NokiaGetLncellId")){

                    val = this.getLncellId(val, mfr.getMapfieldConvertpattern());
                }
            }
        }

        return val;
    }

    protected String hwHexToInt(String origin){

        return String.valueOf(Integer.parseInt(origin.substring(2), 16));
    }

    private String getLnBtsId(String data, String pattern){

        Pattern pat = Pattern.compile(pattern);
        Matcher mat = pat.matcher(data);

        if(mat.find()){

            return mat.group(1);
        }

        return null;
    }

    private String getRncId(String data, String pattern){

        Pattern pat = Pattern.compile(pattern);
        Matcher mat = pat.matcher(data);

        if(mat.find()){

            return mat.group(1);
        }

        return null;
    }

    private String getBtsId(String data, String pattern){

        Pattern pat = Pattern.compile(pattern);
        Matcher mat = pat.matcher(data);

        if(mat.find()){

            return mat.group(1);
        }

        return null;
    }

    private String getNodebId(String data, String pattern){

        Pattern pat = Pattern.compile(pattern);
        Matcher mat = pat.matcher(data);

        if(mat.find()){

            return mat.group(1);
        }

        return null;
    }

    private String getLncellId(String data, String pattern){

        Pattern pat = Pattern.compile(pattern);
        Matcher mat = pat.matcher(data);

        if(mat.find()){

            return mat.group(1);
        }

        return null;
    }

}

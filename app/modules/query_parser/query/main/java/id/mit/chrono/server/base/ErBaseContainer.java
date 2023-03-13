package id.mit.chrono.server.base;

import id.mit.chrono.server.enm.PS;
import id.mit.chrono.server.iface.ParserGroupCallback;
import id.mit.chrono.server.model.tables.records.CrmapfieldRecord;
import id.mit.chrono.server.obj.*;
import org.jooq.DSLContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public abstract class ErBaseContainer extends BaseContainer {

//    protected DSLContext db;

    protected List<ErBasicTagParamsObj> result;

    public ErBaseContainer(DSLContext db, ParserGroupCallback pgc, ChronoContext context, SourceFile sf, MapEntityObj meo) {

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
                .filter(ErBasicTagParamsObj.class::isInstance)
                .map(ErBasicTagParamsObj.class::cast)
                .collect(Collectors.toList());

        sf.purgeResult();

        logger.debug("prepareKeyParamsResult() done: " + result.size());
    }

    protected String getKeyParamsValue(CrmapfieldRecord mfr, ArrayList<String> filters){

        String val = null;
        String backupVal = null;
        String tmp,tmp2;

        ErBasicTagParamsObj mml;

        for (int i = 0; val == null && i < result.size(); i++) {

            mml = result.get(i);

            if(!mfr.getMapfieldSourcegroup().isEmpty()){

                // prepare for backup val
                if(backupVal == null && !mfr.getMapfieldSourcegroupbackup().isEmpty()){

                    if(mml.tag.equals(mfr.getMapfieldSourcegroupbackup())){

                        backupVal = mml.params.get(mfr.getMapfieldSourceparambackup());
                    }
                }

                if(mml.tag.equals(mfr.getMapfieldSourcegroup())){

                    boolean ok = true;
                    for (int j = 0; filters != null && ok && j < filters.size(); j+=2) {
                        tmp = mml.params.get(filters.get(j));

                        if(tmp != null){

                            tmp2 = filters.get(j+1);

                            ok &= tmp.equals(tmp2);
                        }
                        else{
                            ok = false;
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

                if(mml.tag.equals(mfr.getMapfieldSourcegroupcheck())){

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

                if(mfr.getMapfieldConvertfunction().equals("EricssonRemoveSitePrefix")){

                    val = this.EricssonRemoveSitePrefix(val);
                }
                else if(mfr.getMapfieldConvertfunction().equals("EricssonGetBscName")){

                    val = this.EricssonGetBscName(val);
                }
                else if(mfr.getMapfieldConvertfunction().equals("EricssonGetMoName")){

                    val = this.EricssonGetMoName(val);
                }
                else if(mfr.getMapfieldConvertfunction().equals("EricssonGetMcc")){

                    val = this.EricssonGetMcc(val);
                }
                else if(mfr.getMapfieldConvertfunction().equals("EricssonGetMnc")){

                    val = this.EricssonGetMnc(val);
                }
                else if(mfr.getMapfieldConvertfunction().equals("EricssonGetLac")){

                    val = this.EricssonGetLac(val);
                }
                else if(mfr.getMapfieldConvertfunction().equals("EricssonGetCi")){

                    val = this.EricssonGetCi(val);
                }
                else if(mfr.getMapfieldConvertfunction().equals("EricssonGetNcc")){

                    val = this.EricssonGetNcc(val);
                }
                else if(mfr.getMapfieldConvertfunction().equals("EricssonGetBcc")){

                    val = this.EricssonGetBcc(val);
                }
                else if(mfr.getMapfieldConvertfunction().equals("EricssonBtsId")){

                    val = this.EricssonGetBtsId(val, mfr.getMapfieldConvertpattern());
                }
                else if(mfr.getMapfieldConvertfunction().equals("EricssonGetEUtranCellName")){

                    val = this.EricssonGetEUtranCellName(val, mfr.getMapfieldConvertpattern());
                }
                else if(mfr.getMapfieldConvertfunction().equals("EricssonGet2GLatLon")){

                    val = this.EricssonGet2GLatLon(val, mfr.getMapfieldConvertpattern());
                }
                else if(mfr.getMapfieldConvertfunction().equals("EricssonGet2GLat")){

                    val = this.EricssonGet2GLat(val, mfr.getMapfieldConvertpattern());
                }
                else if(mfr.getMapfieldConvertfunction().equals("EricssonGet2GLon")){

                    val = this.EricssonGet2GLon(val, mfr.getMapfieldConvertpattern());
                }
                else if(mfr.getMapfieldConvertfunction().equals("EricssonGetCSysType")){

                    val = this.EricssonGetCSysType(val, mfr.getMapfieldConvertpattern());
                }
            }
        }

        return val;
    }

    protected String hwHexToInt(String origin){

        return String.valueOf(Integer.parseInt(origin.substring(2), 16));
    }

    private String EricssonRemoveSitePrefix(String data){

        if(data != null && data.startsWith("Site=")){

            return data.substring(5);
        }

        return null;
    }

    private String EricssonGetBscName(String data){

        if(data.contains("_")){

            return data.split("\\_")[0];
        }

        return null;
    }

    private String EricssonGetMoName(String data){

        if(data.contains("_")){

            return data.split("\\_")[1];
        }

        return null;
    }

    private String EricssonGetBtsId(String data, String pattern){

        Pattern pat = Pattern.compile(pattern);
        Matcher mat = pat.matcher(data);

        if(mat.find()){

            return mat.group(1);
        }

        return null;
    }

    private String EricssonGetMcc(String data){

        if(data.split("-").length == 4){

            return data.split("-")[0];
        }

        return null;
    }

    private String EricssonGetMnc(String data){

        if(data.split("-").length == 4){

            return data.split("-")[1];
        }

        return null;
    }

    private String EricssonGetLac(String data){

        if(data.split("-").length == 4){

            return data.split("-")[2];
        }

        return null;
    }

    private String EricssonGetCi(String data){

        if(data.split("-").length == 4){

            return data.split("-")[3];
        }

        return null;
    }

    private String EricssonGetNcc(String data){

        int bsic = Integer.parseInt(data);

        return String.valueOf(bsic/8);
    }

    private String EricssonGetBcc(String data){

        int bsic = Integer.parseInt(data);

        return String.valueOf(bsic%8);
    }

    private String EricssonGetEUtranCellName(String data, String pattern){

        Pattern pat = Pattern.compile(pattern);
        Matcher mat = pat.matcher(data);

        if(mat.find()){

            return mat.group(1);
        }

        return null;
    }

    private String EricssonGet3GLatLon(String data, String pattern, String columnName){

        if(data == null || data.isEmpty()){
            return null;
        }

        try{

            double d = Double.parseDouble(data);

            d = d/3600000;

            DecimalFormat df = new DecimalFormat("0.0000000");

            return df.format(d);

        }catch(Exception e){

        }

        return null;
    }

    private String EricssonGet2GLatLon(String data, String pattern){

        if(data == null || data.isEmpty()){
            return null;
        }

        try{

            double d = Double.parseDouble(data);

            d = d/3600000;

            DecimalFormat df = new DecimalFormat("0.0000000");

            return df.format(d);

        }catch(Exception e){

        }

        return null;
    }

    private String EricssonGet2GLat(String data, String pattern){

        //N3-15-51.264

        if(data == null || data.isEmpty()){
            return null;
        }

        try{

            String[] el = data.split("-");
            String NS = "" + el[0].charAt(0);
            double d = Float.parseFloat(el[0].substring(1));
            double min = Float.parseFloat(el[1]);
            double sec = Float.parseFloat(el[2]);

            double res = (NS.equals("N")?1:-1) * (d + (min/60) + (sec/3600));

            DecimalFormat df = new DecimalFormat("0.0000000");

            return df.format(res);

        }catch(Exception e){

        }

        return null;
    }

    private String EricssonGet2GLon(String data, String pattern){

        // E106-15-39.419

        if(data == null || data.isEmpty()){
            return null;
        }

        try{

            String[] el = data.split("-");
            String NS = "" + el[0].charAt(0);
            double d = Float.parseFloat(el[0].substring(1));
            double min = Float.parseFloat(el[1]);
            double sec = Float.parseFloat(el[2]);

            double res = (NS.equals("E")?1:-1) * (d + (min/60) + (sec/3600));

            DecimalFormat df = new DecimalFormat("0.0000000");

            return df.format(res);

        }catch(Exception e){

        }

        return null;
    }

    private String EricssonGetCSysType(String data, String pattern){

        // E106-15-39.419

        if(data == null || data.isEmpty()){
            return null;
        }

        if(data.equals("0")){
            return "GSM900";
        }

        return "DCS1800";
    }
}

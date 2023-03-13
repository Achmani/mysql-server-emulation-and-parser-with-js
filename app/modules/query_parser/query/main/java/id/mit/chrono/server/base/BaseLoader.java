package id.mit.chrono.server.base;

import id.mit.chrono.server.database.DatabaseHelper;
import id.mit.chrono.server.iface.Loader;
import id.mit.chrono.server.iface.ParserGroupCallback;
import id.mit.chrono.server.model.tables.records.CrnodeRecord;
import id.mit.chrono.server.obj.ChronoContext;
import id.mit.chrono.server.obj.DrillCl;
import id.mit.chrono.server.obj.DrillPoolFactory;
import id.mit.chrono.server.obj.PreparatorResultGroup;
import org.apache.commons.pool2.ObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPool;
import org.jooq.DSLContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.HashMap;

public abstract class BaseLoader implements Loader {

    protected static Logger logger = LoggerFactory.getLogger(BaseFileExtractor.class);

    private HashMap<String, String> drillQueries = new HashMap<>();
    protected PreparatorResultGroup resultGroup;
    protected ChronoContext context;
    protected DSLContext db = DatabaseHelper.connectDB();

    protected ParserGroupCallback pgc;

    protected DrillCl drillClient;

    protected HashMap<String, ResultSet> queryResult = new HashMap<>();

    @Override
    public void setResultGroup(PreparatorResultGroup resultGroup) {
        this.resultGroup = resultGroup;
    }

    @Override
    public void setDrillClient(DrillCl drillCl) {
        drillClient = drillCl;
    }

    @Override
    public void setContext(ChronoContext context) {
        this.context = context;
    }

    @Override
    public void setParserGroupCallback(ParserGroupCallback pgc) {
        this.pgc = pgc;
    }

    @Override
    public void start() {

        load(resultGroup.getQueryEntity());

    }

    protected abstract void load(HashMap<String, String> queryResult);

    protected String getCGI(String mcc, String mnc, String lac, String ci){

        if(mcc == null || mnc == null || lac == null || ci == null){
            return null;
        }

        return mcc + "-" + mnc + "-" + lac + "-" + ci;
    }

    protected String getECGI(String mcc, String mnc, String eci){

        if(mcc == null || mnc == null || eci == null){
            return null;
        }

        if(mcc.isEmpty() || mnc.isEmpty() || eci.isEmpty()){
            return null;
        }

        return mcc + "-" + mnc + "-" + eci;
    }

    protected String getNCGI(String mcc, String mnc, String eci){

        if(mcc == null || mnc == null || eci == null){
            return null;
        }

        if(mcc.isEmpty() || mnc.isEmpty() || eci.isEmpty()){
            return null;
        }

        return mcc + "-" + mnc + "-" + eci;
    }

}
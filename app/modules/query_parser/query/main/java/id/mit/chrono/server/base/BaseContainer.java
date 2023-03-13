package id.mit.chrono.server.base;

import com.google.common.base.Stopwatch;
import id.mit.chrono.server.enm.PS;
import id.mit.chrono.server.iface.ParserGroupCallback;
import id.mit.chrono.server.model.tables.records.CrprocessorstatisticRecord;
import id.mit.chrono.server.obj.*;
import org.jooq.DSLContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static id.mit.chrono.server.model.Tables.CRCOLLECTORTASKFILES;
import static id.mit.chrono.server.model.Tables.CRPROCESSORSTATISTIC;

public class BaseContainer {

    protected ParserGroupCallback pgc;

    protected ChronoContext context;

    protected SourceFile sf;

    protected MapEntityObj meo;

    protected ArrayList<ProcessStat> stats = new ArrayList<>();

    protected Stopwatch stopwatch = Stopwatch.createUnstarted();

    protected Logger logger = LoggerFactory.getLogger(this.getClass());

    protected ArrayList<PS> states = new ArrayList<>();
    protected ArrayList<PS> workingStates = new ArrayList<>();

    protected void resetStopwatch(){

        stopwatch.reset().start();
    }

    protected void addMeasurement(PS state, String key, boolean reset){
        stats.add(new ProcessStat(state, key, stopwatch.elapsed(TimeUnit.MILLISECONDS)));

        if(reset){
            resetStopwatch();
        }
    }

    protected void addMeasurement(PS state, String key, boolean reset, ContainerStatistic statObj){
        stats.add(new ProcessStat(state, key, stopwatch.elapsed(TimeUnit.MILLISECONDS), statObj));

        if(reset){
            resetStopwatch();
        }
    }

    protected void addMeasurement(String key, boolean reset, ContainerStatistic statObj){
        stats.add(new ProcessStat(statObj.getState(), key, stopwatch.elapsed(TimeUnit.MILLISECONDS), statObj));

        if(reset){
            resetStopwatch();
        }
    }

    protected void saveStatistics(DSLContext adb){

        // save to db
        List<CrprocessorstatisticRecord> records = new ArrayList<>();

        for (int i = 0; i < stats.size(); i++) {

            CrprocessorstatisticRecord pr = adb.newRecord(CRPROCESSORSTATISTIC);

            pr.setProcessorstatisticCollectortask(this.context.getCOLLECTORTASK_ID());
            pr.setProcessorstatisticDate(this.context.getEpochTime());
            pr.setProcessorstatisticDatagroup(this.context.getDATAGROUP_ID());
            pr.setProcessorstatisticCollectortaskfiles(this.sf.getTaskFilesId());
            pr.setProcessorstatisticClass(this.getClass().getSimpleName());
            pr.setProcessorstatisticKey(stats.get(i).key);
            pr.setProcessorstatisticState(stats.get(i).state.toString());
            pr.setProcessorstatisticTime((int) Instant.now().getEpochSecond());
            pr.setProcessorstatisticDuration((int) stats.get(i).execTime);
            pr.setProcessorstatisticTotalselect(stats.get(i).cs.getTotalSelect());
            pr.setProcessorstatisticAvgselecttime(stats.get(i).cs.getAvgSelectTime());
            pr.setProcessorstatisticTotalinsert(stats.get(i).cs.getTotalInsert());
            pr.setProcessorstatisticAvginserttime(stats.get(i).cs.getAvgInsertTime());
            pr.setProcessorstatisticTotalupdate(stats.get(i).cs.getTotalUpdate());
            pr.setProcessorstatisticAvgupdatetime(stats.get(i).cs.getAvgUpdateTime());

            records.add(pr);
        }

        adb.batchStore(records).execute();

        // update file parsing status
        adb.update(CRCOLLECTORTASKFILES)
                .set(CRCOLLECTORTASKFILES.COLLECTORTASKFILES_PROCESSTIME, sf.getProcessTime())
                .set(CRCOLLECTORTASKFILES.COLLECTORTASKFILES_PROCESSSTATUS, sf.getProcessStatus())
                .set(CRCOLLECTORTASKFILES.COLLECTORTASKFILES_PROCESSSTATUSREASON, sf.getProcessStatusReason())
                .where(CRCOLLECTORTASKFILES.COLLECTORTASKFILES_ID.eq(sf.getTaskFilesId()))
                .execute();
    }

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

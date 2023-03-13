package id.mit.chrono.server.obj;

import com.google.common.base.Stopwatch;
import id.mit.chrono.server.model.tables.records.CrdatasourceRecord;
import org.jooq.DSLContext;
import org.jooq.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class DownloadGroup {

    private ArrayList<DownloadWorker> workers = new ArrayList<DownloadWorker>();
    private boolean replace;
    private ChronoContext context;
    private DSLContext db;
    private Date groupDate;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private int collectorTaskId = 0;
    private String dataGroupName;
    private String timeGroup;
    private String TASK_NAME = null;
    private TimeoutWatcher watcher;

    protected Stopwatch stopwatch;

    public DownloadGroup(DSLContext db, ChronoContext context, boolean replace){

        this.db = db;
        this.context = context;
        this.replace = replace;

        stopwatch = Stopwatch.createUnstarted();
    }

    public void process(Result<CrdatasourceRecord> dataSources, final int timeoutMs){

        logger.debug("starting process: " + dataSources.size() + " data source(s) with timeout: " + timeoutMs + " ms");

        stopwatch.start();

        for (int i = 0; i < dataSources.size(); i++) {

            DownloadWorker dw = new DownloadWorker(db, dataSources.get(i), context, replace);
            workers.add(dw);
        }

        // set timeout watcher
        watcher = new TimeoutWatcher(timeoutMs){

            @Override
            void onTimeoutReached() {

                // only if
                if(timeoutMs > 0){

                    logger.debug("forcing finish after timeout reached: " + timeoutMs + " ms");

                    for (int i = 0; i < workers.size(); i++) {

                        workers.get(i).forceFinish();
                    }
                }
            }
        };

        // wait for all to finished
        for (int i = 0; i < workers.size(); i++) {

            workers.get(i).join();
        }

        // make sure watcher is not watching anymore
        watcher.cancel();

        stopwatch.stop();
        logger.debug("finished: " + workers.size() + " worker(s) in " + stopwatch.elapsed(TimeUnit.MILLISECONDS) + " ms");
    }

//    public void performDbOperation(DSLContext db){
//
//        for (int i = 0; i < workers.size(); i++) {
//
//            workers.get(i).performDbOperation(db);
//        }
//    }

    abstract class TimeoutWatcher implements Runnable{

        private Thread myThread;
        private int timeoutMs;

        public TimeoutWatcher(int timeoutMs){

            this.timeoutMs = timeoutMs;

            this.myThread = new Thread(this);

            if(timeoutMs != 0){

                this.myThread.start();

                logger.debug("watcher started with timeout: " + this.timeoutMs + " ms");
            }
        }

        public void cancel(){

            if(this.myThread.isAlive()){
                logger.debug("watcher interrupted");
                this.myThread.interrupt();
            }
        }

        @Override
        public void run() {

            try {
                Thread.sleep(this.timeoutMs);

                onTimeoutReached();
            } catch (InterruptedException e) {
//                e.printStackTrace();
            }
        }

        abstract void onTimeoutReached();
    }

}

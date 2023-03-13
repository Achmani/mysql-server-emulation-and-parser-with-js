package id.mit.chrono.server.base;

import com.google.common.base.Stopwatch;
import id.mit.chrono.server.database.DatabaseHelper;
import id.mit.chrono.server.factory.DaoFactory;
import id.mit.chrono.server.model.tables.records.CrcollectortaskRecord;
import id.mit.chrono.server.model.tables.records.CrdatagroupRecord;
import id.mit.chrono.server.obj.ChronoContext;
import id.mit.chrono.server.obj.DrillCl;
import id.mit.chrono.server.obj.HDFSCl;
import id.mit.chrono.server.util.DrillUtils;
import id.mit.chrono.server.util.HDFSUtils;
import id.mit.chrono.server.var.Vars;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Options;
import org.apache.commons.validator.routines.DateValidator;
import org.apache.hadoop.conf.Configuration;
import org.apache.log4j.PropertyConfigurator;
import org.jooq.DSLContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.InetAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.channels.OverlappingFileLockException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseMain {

    private static FileChannel fc;
    private static RandomAccessFile raf;

    protected ChronoContext context;
    protected DSLContext db;

    protected Options options;
    protected Logger logger;
    protected Connection conn;
    protected Stopwatch stopwatch;

    protected DateValidator dValidator;

    protected int TIMEOUT;

    protected HDFSCl dfs;
    protected DrillCl drillCl;

    protected String[] dataSources;
    protected String[] fileNames;
    protected Integer[] fileIds;
    protected String[] entities;

    protected String TASK_NAME = null;


    public BaseMain(){

        context = new ChronoContext();
        options = new Options();
        dValidator = new DateValidator();

        // initialize stopwatch
        stopwatch = Stopwatch.createUnstarted();

        this.readProp();

        this.setupLogger();

        this.assesslockFile();

        this.db = DatabaseHelper.connectDB();

//        dfs = HDFSUtils.getInstance(this.db);

//        drillCl = DrillUtils.getInstance(this.db);

//        drillCl.test();
    }

    protected void setupLogger(){

        Properties prop = new Properties();
        InputStream input = null;
        String val;

        try {

            input = new FileInputStream("log4j.properties");

            // load a properties file
            prop.load(input);

            val = prop.getProperty("log4j.appender.file.File");

            InetAddress inetAddress  = InetAddress.getLocalHost();

            // replace "log4j.appender.file.File"
            prop.setProperty("log4j.appender.file.File", val + "." + inetAddress.getHostName().toLowerCase() + "." + context.getRUNMODE());
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
//        PropertyConfigurator.configure("log4j.properties");
        PropertyConfigurator.configure(prop);
        logger = LoggerFactory.getLogger(this.getClass());
    }

    protected void assesslockFile(){

        String data = String.valueOf(System.currentTimeMillis());

        try {
            raf = new RandomAccessFile("chrono.lock", "rw");

            fc = raf.getChannel();
            ByteBuffer buffer = null;

            try{

                FileLock fileLock = fc.tryLock();

                if (null != fileLock) {
                    buffer = ByteBuffer.wrap(data.getBytes());
                    buffer.put(data.toString().getBytes());
                    buffer.flip();
                    while (buffer.hasRemaining())
                        fc.write(buffer);
                }
            } catch (OverlappingFileLockException | IOException ex) {
                logger.error("Exception occured while trying to get a lock on File... " + ex.getMessage());
                System.exit(-10);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    protected void readProp(){

        String runmode = Vars.prop.getProperty("id.mit.chrono.server.runmode");

        if(runmode != null) {
            context.setRUNMODE(runmode);
        }
    }

    protected void disconnectDB(){

        if(this.conn != null){

            boolean isClosed = true;

            try {

                if(!this.conn.isClosed()){
                    this.conn.close();
                    logger.debug("disconnected from DB");
                }

            } catch (SQLException e) {
                logger.debug("failed to disconnect from DB");
                e.printStackTrace();
            }
        }
    }

    protected void showHelp(){

        HelpFormatter formater = new HelpFormatter();
        formater.printHelp("Main", options);
    }

    protected void getTask(){

        stopwatch.start();

        CrdatagroupRecord result = DaoFactory.createDataGroupDaoImpl().getSingleDataGroup(context.getGROUP());

        if (result != null) {
            context.setDATAGROUP_ID(result.getDatagroupId());
            logger.debug("DATAGROUP_ID: " + context.getGROUP() + " -> " + context.getDATAGROUP_ID());
        }

        TASK_NAME = context.getGROUP() + "_" + context.getTIMEGROUP();

        CrcollectortaskRecord result2 = DaoFactory.createCollectorTaskDaoImpl().getSingleCollectorTask(context.getDATAGROUP_ID(), TASK_NAME);

        if(result2 == null){

            CrcollectortaskRecord r = DaoFactory.createCollectorTaskDaoImpl().insertCollectorTask(
                    context.getDATAGROUP_ID(),
                    TASK_NAME,
                    (int)(context.getGroupDate().getTime()/1000)
            );

            context.setCOLLECTORTASK_ID(r.getCollectortaskId());
        }
        else{

            context.setCOLLECTORTASK_ID(result2.getCollectortaskId());
        }

        if(context.getCOLLECTORTASK_ID() == 0){

            logger.error("unable to get COLLECTORTASK_ID");
            System.exit(-4);
        }

        // prepareBase directory for raw data
        String dirPath = "data" + File.separator + "raw" + File.separator + context.getGROUP();
        File groupDir = new File(dirPath);
        if(!groupDir.exists()){
            groupDir.mkdir();
        }

        File timeGroupDir = new File(dirPath + File.separator + context.getTIMEGROUP());
        if(!timeGroupDir.exists()){
            timeGroupDir.mkdir();
        }

        logger.debug("COLLECTORTASK_ID: " + context.getCOLLECTORTASK_ID());

        stopwatch.stop();
        logger.debug("get task done in " + stopwatch.elapsed(TimeUnit.MILLISECONDS) + " ms");
    }

}

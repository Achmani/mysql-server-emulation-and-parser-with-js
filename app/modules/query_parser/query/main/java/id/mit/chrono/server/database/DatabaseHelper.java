package id.mit.chrono.server.database;

import com.google.common.base.Stopwatch;
import id.mit.chrono.server.var.Vars;
import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.conf.Settings;
import org.jooq.conf.StatementType;
import org.jooq.impl.DSL;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.concurrent.TimeUnit;

public class DatabaseHelper {

    protected static DSLContext db;
    protected static Logger logger = LoggerFactory.getLogger(DatabaseHelper.class);
    protected static Connection conn;
    protected static Stopwatch stopwatch;

    static {

    }

    public static DSLContext connectDB(){

        if (db == null) {

            String username = "";
            String password = "";
            String url = "";
            String poolSize = "";

            if((url = Vars.prop.getProperty("id.mit.chrono.server.db.url")) != null){
                logger.debug("found id.mit.chrono.server.db.url");
            }

            if((username = Vars.prop.getProperty("id.mit.chrono.server.db.username")) != null){
                logger.debug("found id.mit.chrono.server.db.username");
            }

            if((password = Vars.prop.getProperty("id.mit.chrono.server.db.password")) != null){
                logger.debug("found id.mit.chrono.server.db.password");
            }

            if((poolSize = Vars.prop.getProperty("id.mit.chrono.server.poolsize")) != null){
                logger.debug("found id.mit.chrono.server.poolsize");
            }

            try {
                stopwatch = Stopwatch.createUnstarted();
                stopwatch.start();
                conn = DriverManager.getConnection(url, username, password);
                stopwatch.stop();
                logger.debug("connected to: '" + url + "' in " + stopwatch.elapsed(TimeUnit.MILLISECONDS) + " ms");

                Settings settings = new Settings();
                settings.setStatementType(StatementType.STATIC_STATEMENT);
                settings.setExecuteLogging(false);
                db = DSL.using(conn, SQLDialect.MYSQL, settings);

                return db;
            }
            catch (Exception e) {
                logger.error("failed to connect to: " + url);
                e.printStackTrace();
                System.exit(-3);
                return null;
            }
        }

        return db;

    }

}

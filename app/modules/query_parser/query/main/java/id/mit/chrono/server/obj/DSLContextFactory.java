package id.mit.chrono.server.obj;

import com.google.common.base.Stopwatch;
import id.mit.chrono.server.var.Vars;
import org.apache.commons.pool2.BasePooledObjectFactory;
import org.apache.commons.pool2.PooledObject;
import org.apache.commons.pool2.impl.DefaultPooledObject;
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

public class DSLContextFactory extends BasePooledObjectFactory<DSLContext> {

    protected Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public DSLContext create() throws Exception {

        Connection conn;
        DSLContext db;

        Stopwatch stopwatch = Stopwatch.createUnstarted();

        String username = "";
        String password = "";
        String url = "";

        if((url = Vars.prop.getProperty("id.mit.chrono.server.db.url")) != null){
            logger.debug("found id.mit.chrono.server.db.url");
        }

        if((username = Vars.prop.getProperty("id.mit.chrono.server.db.username")) != null){
            logger.debug("found id.mit.chrono.server.db.username");
        }

        if((password = Vars.prop.getProperty("id.mit.chrono.server.db.password")) != null){
            logger.debug("found id.mit.chrono.server.db.password");
        }

        long start = System.currentTimeMillis();

        try {

            stopwatch.start();
            conn = DriverManager.getConnection(url, username, password);
            stopwatch.stop();
            logger.debug("connected to: '" + url + "' in " + stopwatch.elapsed(TimeUnit.MILLISECONDS) + " ms");

//            Settings settings = JAXB.unmarshal(new File("jooq-settings.xml"), Settings.class);

            Settings settings = new Settings();
            settings.setStatementType(StatementType.STATIC_STATEMENT);
            settings.setExecuteLogging(false);
            db = DSL.using(conn, SQLDialect.MYSQL, settings);

            return db;
        }
        catch (Exception e) {
            logger.error("failed to connect to: " + url);
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public PooledObject<DSLContext> wrap(DSLContext obj) {

        return new DefaultPooledObject<DSLContext>(obj);
    }

    /**
     * When an object is returned to the pool, clear the buffer.
     */
    @Override
    public void passivateObject(PooledObject<DSLContext> pooledObject) {
        // do something needed
    }
}

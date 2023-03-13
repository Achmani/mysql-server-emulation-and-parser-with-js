package id.mit.chrono.server.obj;

import com.google.common.base.Stopwatch;
import id.mit.chrono.server.factory.DaoFactory;
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
import java.sql.SQLException;
import java.util.concurrent.TimeUnit;

public class DrillPoolFactory extends BasePooledObjectFactory<Connection> {

    protected Logger logger = LoggerFactory.getLogger(this.getClass());


    @Override
    public Connection create() throws Exception {

        String className;
        String connectionString;

        Connection connection;

        if ((className = DaoFactory.createSettingsDaoImpl().getSingleSettings("DRILL_PROPS", "DRILL_JDBC_DRIVER_CLASS").getSettingsValue()) != null) {
            logger.debug("found drill classname");
        }

        if ((connectionString = DaoFactory.createSettingsDaoImpl().getSingleSettings("DRILL_PROPS", "DRILL_JDBC_CONN_STRING").getSettingsValue()) != null) {
            logger.debug("found drill connection string");
        }

        try {
            Class.forName(className);

            connection = DriverManager.getConnection(connectionString);

            return connection;

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public PooledObject<Connection> wrap(Connection obj) {
        return null;
    }
}

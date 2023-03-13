package id.mit.chrono.server.util;

import id.mit.chrono.server.model.tables.records.CrsettingsRecord;
import id.mit.chrono.server.obj.DrillCl;
import id.mit.chrono.server.obj.HDFSCl;
import org.apache.hadoop.conf.Configuration;
import org.jooq.DSLContext;

import java.util.List;

import static id.mit.chrono.server.model.Tables.CRSETTINGS;

public class DrillUtils {

    protected static DrillCl drillC;

    public static DrillCl getInstance(DSLContext db){

        if (drillC == null ){
            List<CrsettingsRecord> settings = db.selectFrom(CRSETTINGS)
                    .where(CRSETTINGS.SETTINGS_ENABLED.isTrue())
                    .and(CRSETTINGS.SETTINGS_CODE.eq("DRILL_PROPS"))
                    .orderBy(CRSETTINGS.SETTINGS_ORDER.asc())
                    .fetch();

            String className = settings.stream().filter(o -> o.getSettingsName().equals("DRILL_JDBC_DRIVER_CLASS")).findFirst().get().getSettingsValue();
            String connectionString = settings.stream().filter(o -> o.getSettingsName().equals("DRILL_JDBC_CONN_STRING")).findFirst().get().getSettingsValue();

            drillC = new DrillCl(className, connectionString);

            return drillC;
        }

        return drillC;
    }
}

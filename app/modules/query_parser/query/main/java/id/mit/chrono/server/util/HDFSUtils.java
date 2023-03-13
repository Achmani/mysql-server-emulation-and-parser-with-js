package id.mit.chrono.server.util;

import id.mit.chrono.server.model.tables.records.CrsettingsRecord;
import id.mit.chrono.server.obj.HDFSCl;
import org.apache.hadoop.conf.Configuration;
import org.jooq.DSLContext;

import java.util.List;

import static id.mit.chrono.server.model.Tables.CRSETTINGS;

public class HDFSUtils {

    public static HDFSCl getInstance(DSLContext db){

        List<CrsettingsRecord> settings = db.selectFrom(CRSETTINGS)
                .where(CRSETTINGS.SETTINGS_ENABLED.isTrue())
                .and(CRSETTINGS.SETTINGS_CODE.eq("HDFS_PROPS"))
                .orderBy(CRSETTINGS.SETTINGS_ORDER.asc())
                .fetch();

        Configuration configuration = new Configuration();
        settings.stream().forEach(o -> configuration.set(o.getSettingsName(), o.getSettingsValue()));

        HDFSCl hdfsClient = new HDFSCl(configuration);

        hdfsClient.connect();

        return hdfsClient;
    }
}

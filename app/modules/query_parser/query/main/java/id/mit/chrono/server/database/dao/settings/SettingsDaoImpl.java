package id.mit.chrono.server.database.dao.settings;

import id.mit.chrono.server.database.DatabaseHelper;
import id.mit.chrono.server.model.tables.records.CrsettingsRecord;
import org.jooq.DSLContext;

import java.util.List;

import static id.mit.chrono.server.model.Tables.CRSETTINGS;

public class SettingsDaoImpl implements SettingsDao {

    DSLContext db;

    public SettingsDaoImpl() {
        this.db = DatabaseHelper.connectDB();
    }

    @Override
    public List<CrsettingsRecord> getSettings() {
        return db.selectFrom(CRSETTINGS)
                .fetch();
    }

    @Override
    public List<CrsettingsRecord> getSettings(String settingsCode) {
        return db.selectFrom(CRSETTINGS)
                .where(CRSETTINGS.SETTINGS_CODE.equal(settingsCode))
                .fetch();
    }

    @Override
    public CrsettingsRecord getSingleSettings(String settingCode, String settingName) {
        return db.selectFrom(CRSETTINGS)
                .where(CRSETTINGS.SETTINGS_CODE.equal(settingCode)
                .and(CRSETTINGS.SETTINGS_NAME.eq(settingName)))
                .fetchAny();
    }


}

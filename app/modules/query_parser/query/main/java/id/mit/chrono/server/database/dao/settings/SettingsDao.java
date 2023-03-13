package id.mit.chrono.server.database.dao.settings;

import id.mit.chrono.server.model.tables.records.CrsettingsRecord;

import java.util.List;

public interface SettingsDao {

    public List<CrsettingsRecord> getSettings();
    public List<CrsettingsRecord> getSettings(String settingsCode);
    public CrsettingsRecord getSingleSettings(String settingCode, String settingName);

}

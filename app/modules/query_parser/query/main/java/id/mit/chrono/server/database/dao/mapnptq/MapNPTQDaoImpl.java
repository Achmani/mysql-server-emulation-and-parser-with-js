package id.mit.chrono.server.database.dao.mapnptq;

import id.mit.chrono.server.database.DatabaseHelper;
import id.mit.chrono.server.model.tables.records.CrmapnptqRecord;
import org.jooq.DSLContext;
import org.jooq.Result;
import org.jooq.types.UInteger;

import static id.mit.chrono.server.model.Tables.CRMAPNPTQ;

public class MapNPTQDaoImpl implements MapNPTQDao {

    private DSLContext db;

    public MapNPTQDaoImpl() {
        this.db = DatabaseHelper.connectDB();
    }

    @Override
    public CrmapnptqRecord getSingleMapNPTQ(String params) {
        return db.selectFrom(CRMAPNPTQ)
                .where(CRMAPNPTQ.CRMAPNPTQ_PARAMS.equal(params))
                .and(CRMAPNPTQ.CRMAPNPTQ_ENABLE.eq((byte) 1))
                .fetchAny();
    }

    @Override
    public CrmapnptqRecord getSingleMapNPTQ(String params, String entity) {
        return db.selectFrom(CRMAPNPTQ)
                .where(CRMAPNPTQ.CRMAPNPTQ_PARAMS.eq(params))
                .and(CRMAPNPTQ.MAPNPTQ_ENTITY.eq(entity))
                .and(CRMAPNPTQ.CRMAPNPTQ_ENABLE.eq((byte) 1))
                .fetchAny();
    }

    @Override
    public CrmapnptqRecord getSingleMapNPTQ(String object, String params, String entity) {
        return db.selectFrom(CRMAPNPTQ)
                .where(CRMAPNPTQ.CRMAPNPTQ_PARAMS.eq(params))
                .and(CRMAPNPTQ.CRMAPNPTQ_OBJECT.equal(object))
                .and(CRMAPNPTQ.MAPNPTQ_ENTITY.eq(entity))
                .and(CRMAPNPTQ.CRMAPNPTQ_ENABLE.eq((byte) 1))
                .fetchAny();
    }

    @Override
    public CrmapnptqRecord getSingleMapNPTQ(String object, String params, String entity, String source, String filename) {
        return db.selectFrom(CRMAPNPTQ)
                .where(CRMAPNPTQ.CRMAPNPTQ_OBJECT.eq(object))
                .and(CRMAPNPTQ.CRMAPNPTQ_PARAMS.eq(params))
                .and(CRMAPNPTQ.MAPNPTQ_ENTITY.eq(entity))
                .and(CRMAPNPTQ.MAPNPTQ_SOURCEFILE.eq(source))
                .and(CRMAPNPTQ.MAPNPTQ_FILE.eq(filename))
                .and(CRMAPNPTQ.CRMAPNPTQ_ENABLE.eq((byte) 1))
                .fetchAny();

    }

    @Override
    public CrmapnptqRecord getSingleMapNPTQ(String object, String params, String entity, String source, String filename, String objectBackup, String paramBackup) {
        return db.selectFrom(CRMAPNPTQ)
                .where(CRMAPNPTQ.CRMAPNPTQ_OBJECT.eq(object))
                .and(CRMAPNPTQ.CRMAPNPTQ_PARAMS.eq(params))
                .and(CRMAPNPTQ.MAPNPTQ_ENTITY.eq(entity))
                .and(CRMAPNPTQ.MAPNPTQ_SOURCEFILE.eq(source))
                .and(CRMAPNPTQ.MAPNPTQ_FILE.eq(filename))
                .and(CRMAPNPTQ.CRMAPNPTQ_BACKUP_OBJECT.eq(objectBackup))
                .and(CRMAPNPTQ.CRMAPNPTQ_BACKUP_PARAMS.eq(paramBackup))
                .and(CRMAPNPTQ.CRMAPNPTQ_ENABLE.eq((byte) 1))
                .fetchAny();

    }

    @Override
    public Result<CrmapnptqRecord> getMapNPTQs() {
        return db.selectFrom(CRMAPNPTQ).fetch();
    }

    @Override
    public Result<CrmapnptqRecord> getMapNPTQsByEntityGroup(String params, String entitygroup) {
        return db.selectFrom(CRMAPNPTQ)
                .where(CRMAPNPTQ.CRMAPNPTQ_PARAMS.equal(params))
                .and(CRMAPNPTQ.MAPNPTQ_ENTITYGROUP.equal(entitygroup))
                .and(CRMAPNPTQ.CRMAPNPTQ_ENABLE.equal((byte) 1))
                .fetch();
    }

    @Override
    public Result<CrmapnptqRecord> getMapNPTQsByEntityGroup(String object, String params, String entitygroup) {
        return db.selectFrom(CRMAPNPTQ)
                .where(CRMAPNPTQ.CRMAPNPTQ_PARAMS.equal(params))
                .and(CRMAPNPTQ.MAPNPTQ_ENTITYGROUP.equal(entitygroup))
                .and(CRMAPNPTQ.CRMAPNPTQ_OBJECT.eq(object))
                .and(CRMAPNPTQ.CRMAPNPTQ_ENABLE.equal((byte) 1))
                .fetch();
    }

    @Override
    public Result<CrmapnptqRecord> getMapNPTQsByEntityGroup(String entitygroup) {
        return db.selectFrom(CRMAPNPTQ)
                .where(CRMAPNPTQ.MAPNPTQ_ENTITYGROUP.equal(entitygroup))
                .and(CRMAPNPTQ.CRMAPNPTQ_ENABLE.equal((byte) 1))
                .fetch();
    }

    @Override
    public Result<CrmapnptqRecord> getMapNPTQsByEntity(String params, String entitygroup) {
        return db.selectFrom(CRMAPNPTQ)
                .where(CRMAPNPTQ.CRMAPNPTQ_PARAMS.equal(params))
                .and(CRMAPNPTQ.MAPNPTQ_ENTITY.equal(entitygroup))
                .and(CRMAPNPTQ.CRMAPNPTQ_ENABLE.equal((byte) 1))
                .fetch();
    }

    @Override
    public Result<CrmapnptqRecord> getMapNPTQsByEntity(String object, String params, String entitygroup) {
        return db.selectFrom(CRMAPNPTQ)
                .where(CRMAPNPTQ.CRMAPNPTQ_PARAMS.equal(params))
                .and(CRMAPNPTQ.MAPNPTQ_ENTITY.equal(entitygroup))
                .and(CRMAPNPTQ.CRMAPNPTQ_OBJECT.eq(object))
                .and(CRMAPNPTQ.CRMAPNPTQ_ENABLE.equal((byte) 1))
                .fetch();
    }

    @Override
    public Result<CrmapnptqRecord> getMapNPTQsByEntity(String entity) {
        return db.selectFrom(CRMAPNPTQ)
                .where(CRMAPNPTQ.MAPNPTQ_ENTITY.equal(entity))
                .and(CRMAPNPTQ.CRMAPNPTQ_ENABLE.equal((byte) 1))
                .fetch();
    }

    @Override
    public Result<CrmapnptqRecord> getMapNPTQsByEntityAndSource(String entity, String source) {
        return db.selectFrom(CRMAPNPTQ)
                .where(CRMAPNPTQ.MAPNPTQ_ENTITY.equal(entity))
                .and(CRMAPNPTQ.MAPNPTQ_SOURCEFILE.equal(source))
                .and(CRMAPNPTQ.CRMAPNPTQ_ENABLE.equal((byte) 1))
                .fetch();
    }

    @Override
    public CrmapnptqRecord insertMapNPTQ(String object, String params, String entitygroup, String source, String filename) {

        CrmapnptqRecord record = db.newRecord(CRMAPNPTQ);

        record.setCrmapnptqObject(object);
        record.setCrmapnptqParams(params);
        record.setMapnptqSourcefile(source);
        record.setMapnptqFile(filename);
        record.setMapnptqEntitygroup(entitygroup);
        // enable by default
        record.setCrmapnptqEnable((byte) 1);

        record.store();

        return record;
    }

    @Override
    public CrmapnptqRecord insertMapNPTQ(String object, String params, String entitygroup, String source, String filename, String objectBackup, String paramBackup) {

        CrmapnptqRecord record = db.newRecord(CRMAPNPTQ);

        record.setCrmapnptqObject(object);
        record.setCrmapnptqParams(params);
        record.setMapnptqSourcefile(source);
        record.setMapnptqFile(filename);
        record.setMapnptqEntitygroup(entitygroup);
        record.setCrmapnptqBackupObject(objectBackup);
        record.setCrmapnptqBackupParams(paramBackup);
        // enable by default
        record.setCrmapnptqEnable((byte) 1);

        record.store();

        return record;
    }

    @Override
    public CrmapnptqRecord updateMapNPTQ(UInteger id, String object, String params, String sourceFile, String file, String entitygroup) {

        CrmapnptqRecord record = db.selectFrom(CRMAPNPTQ)
                .where(CRMAPNPTQ.CRMAPNPTQ_ID.eq(id))
                .fetchAny();

        if (record != null) {

            record.setCrmapnptqObject(object);
            record.setCrmapnptqParams(params);
            record.setMapnptqSourcefile(sourceFile);
            record.setMapnptqFile(file);
            record.setMapnptqEntitygroup(entitygroup);

            record.update();

            return record;
        }

        return null;
    }

    @Override
    public CrmapnptqRecord updateMapNPTQ(UInteger id, String sourceFile, String file) {

        CrmapnptqRecord record = db.selectFrom(CRMAPNPTQ)
                .where(CRMAPNPTQ.CRMAPNPTQ_ID.eq(id))
                .fetchAny();

        if (record != null) {

            record.setMapnptqSourcefile(sourceFile);
            record.setMapnptqFile(file);

            record.update();

            return record;
        }

        return null;
    }

    @Override
    public CrmapnptqRecord updateMapNPTQ(UInteger id, String sourceFile, String file, String objectBackup, String paramBackup) {

        CrmapnptqRecord record = db.selectFrom(CRMAPNPTQ)
                .where(CRMAPNPTQ.CRMAPNPTQ_ID.eq(id))
                .fetchAny();

        if (record != null) {

            record.setMapnptqSourcefile(sourceFile);
            record.setMapnptqFile(file);
            record.setCrmapnptqBackupObject(objectBackup);
            record.setCrmapnptqBackupParams(paramBackup);

            record.update();

            return record;
        }

        return null;
    }
}

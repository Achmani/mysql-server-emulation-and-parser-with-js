package id.mit.chrono.server.database.dao.mapnptq;

import id.mit.chrono.server.model.tables.Crmapnptq;
import id.mit.chrono.server.model.tables.records.CrmapnptqRecord;
import org.jooq.Result;
import org.jooq.types.UInteger;

public interface MapNPTQDao {

    public CrmapnptqRecord getSingleMapNPTQ(String params);

    public CrmapnptqRecord getSingleMapNPTQ(String params, String entity);

    public CrmapnptqRecord getSingleMapNPTQ(String object, String params, String entity);

    public CrmapnptqRecord getSingleMapNPTQ(String object, String params, String entity, String source, String filename);

    public CrmapnptqRecord getSingleMapNPTQ(String object, String params, String entity, String source, String filename, String objectBackup, String paramBackup);

    public Result<CrmapnptqRecord> getMapNPTQs();

    public Result<CrmapnptqRecord> getMapNPTQsByEntityGroup(String entityGroup);

    public Result<CrmapnptqRecord> getMapNPTQsByEntityGroup(String params, String entityGroup);

    public Result<CrmapnptqRecord> getMapNPTQsByEntityGroup(String object, String params, String entityGroup);

    public Result<CrmapnptqRecord> getMapNPTQsByEntity(String entity);

    public Result<CrmapnptqRecord> getMapNPTQsByEntityAndSource(String entity, String source);

    public Result<CrmapnptqRecord> getMapNPTQsByEntity(String params, String entity);

    public Result<CrmapnptqRecord> getMapNPTQsByEntity(String object, String params, String entity);

    public CrmapnptqRecord insertMapNPTQ(String object, String params, String entityGroup, String source, String filename);

    public CrmapnptqRecord insertMapNPTQ(String object, String params, String entityGroup, String source, String filename, String objectBackup, String paramBackup);

    public CrmapnptqRecord updateMapNPTQ(UInteger id, String object, String params, String sourceFile, String file, String entityGroup);

    public CrmapnptqRecord updateMapNPTQ(UInteger id, String sourceFile, String file);

    public CrmapnptqRecord updateMapNPTQ(UInteger id, String sourceFile, String file, String objectBackup, String paramBackup);

}

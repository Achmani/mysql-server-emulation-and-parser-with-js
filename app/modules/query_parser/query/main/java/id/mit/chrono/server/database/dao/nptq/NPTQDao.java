package id.mit.chrono.server.database.dao.nptq;

import id.mit.chrono.server.model.tables.records.CrnptqRecord;
import org.jooq.Result;

import java.io.File;

public interface NPTQDao {

    public Result<CrnptqRecord> getRecord();

    public CrnptqRecord getRecord(String object, String params, String entity);

    public Result<CrnptqRecord> getRecord(String entity);

    public CrnptqRecord insert(String object, String params, String entity);

    public void insert(File csvFile);

}

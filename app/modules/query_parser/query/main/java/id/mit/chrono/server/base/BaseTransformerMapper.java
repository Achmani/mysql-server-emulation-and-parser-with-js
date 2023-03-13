package id.mit.chrono.server.base;

import id.mit.chrono.server.database.dao.mapnptq.MapNPTQDaoImpl;
import id.mit.chrono.server.factory.DaoFactory;
import id.mit.chrono.server.iface.Mapper;
import id.mit.chrono.server.iface.MapperCallback;
import id.mit.chrono.server.model.tables.records.CrmapnptqRecord;
import id.mit.chrono.server.model.tables.records.CrnptqRecord;
import id.mit.chrono.server.obj.ChronoContext;
import id.mit.chrono.server.obj.PreparatorResult;
import id.mit.chrono.server.obj.PreparatorResultGroup;
import org.jooq.DSLContext;
import org.jooq.Result;
import org.jooq.types.UInteger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseTransformerMapper implements Mapper {

    protected Logger logger = LoggerFactory.getLogger(this.getClass());

    private MapperCallback callback;
    private ChronoContext context;
    private PreparatorResultGroup resultGroup;
    private Thread thread;

    protected DSLContext dslC;
    protected Result<CrnptqRecord> nptqParams;
    protected List<PreparatorResult> resultFiles = new ArrayList<>();
    protected String entity;

    protected MapNPTQDaoImpl dao = DaoFactory.getMapNPTQDaoImpl();

    private void prepare() {

        entity = resultGroup.getWorkflowPhase2().getWorkflowEntitygroup();

        nptqParams = DaoFactory.getNPTQDaoImpl().getRecord(entity);
        resultFiles = resultGroup.getProcessedFiles();
    }

    @Override
    public void start() {

        System.out.println("start transformer constructor");

        this.prepare();

//        checkNPTQ();

        this.thread = new Thread(this);
        this.thread.setName(entity);
        thread.start();
    }

    protected int updateMapNPTQ(UInteger id, String source, String filename, String objectBackup, String paramBackup) {

        CrmapnptqRecord record = dao.updateMapNPTQ(id, source, filename, objectBackup, paramBackup);

        if (record != null) {
            return 1;
        }

        return 0;

    }

    protected int insertMapNPTQ(String object, String params, String entity, String source, String filename, String objectBackup, String paramBackup) {

        CrmapnptqRecord record = dao.getSingleMapNPTQ(object, params, entity, source, filename, objectBackup, paramBackup);

        if (record == null) {


            record = dao.insertMapNPTQ(object, params, entity, source, filename, objectBackup, paramBackup);
            if (record != null) {
                logger.debug("success insert: " + params + " from " + source + " - " + filename);
                return 1;
            } else {
                logger.debug("failed insert: " + params + " from " + source + " - " + filename);
                return -1;
            }

        }

        return 0;

    }

    @Override
    public void setCallback(MapperCallback callback) {
        this.callback = callback;
    }

    @Override
    public void setContext(ChronoContext context) {
        this.context = context;
    }

    @Override
    public void setDSLContext(DSLContext dslC) {
        this.dslC = dslC;
    }

    @Override
    public void setResultGroup(PreparatorResultGroup resultGroup) {
        this.resultGroup = resultGroup;
    }

    @Override
    public void run() {
        checkNPTQ();
//        buildWorkflow();
        callback.onMapFinished(this.thread.getName());
    }

    protected abstract void checkNPTQ();

//    protected abstract void buildWorkflow();
}

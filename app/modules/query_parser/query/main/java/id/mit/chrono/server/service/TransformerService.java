package id.mit.chrono.server.service;

import id.mit.chrono.server.builder.TaskFilesTransformerBuilder;
import id.mit.chrono.server.iface.TransformerConstructorCallback;
import id.mit.chrono.server.iface.TransformerPreparatorCallback;
import id.mit.chrono.server.iface.TransformerServiceCallback;
import id.mit.chrono.server.obj.ChronoContext;
import id.mit.chrono.server.obj.DSLContextFactory;
import id.mit.chrono.server.obj.PreparatorResultGroup;
import org.apache.commons.pool2.ObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPool;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.List;

public class TransformerService implements TransformerPreparatorCallback, TransformerConstructorCallback {

    private Logger logger = LoggerFactory.getLogger(TransformerService.class);

    private TransformerServiceCallback serviceCallback;

    private ChronoContext context;
    private TaskFilesTransformerBuilder taskFileBuilder;

    private Result<Record> files;
    private boolean reProcess;
    private int poolsize = 10;
    private boolean mapper;

    protected static ObjectPool<DSLContext> dbPool = null;
    protected static final Object lockObj = new Object();
    protected static DSLContextFactory dslCF;


    public TransformerService(ChronoContext context, Result<Record> files, boolean reProcess, TaskFilesTransformerBuilder builder, TransformerServiceCallback serviceCallback) {

        this.context = context;
        this.serviceCallback = serviceCallback;
        this.taskFileBuilder = builder;
        this.files = files;
        this.reProcess = reProcess;
        this.poolsize = builder.getPoolsize();
        this.mapper = builder.isMapping();

        this.dslCF = new DSLContextFactory();

        synchronized (lockObj) {

            if (dbPool == null) {
                dbPool = new GenericObjectPool<>(dslCF);
                ((GenericObjectPool<DSLContext>) dbPool).setMaxTotal(this.poolsize);
            }
        }
    }

    public void preparator() {
        TransformerPreparatorService preparator = new TransformerPreparatorService(context, files, reProcess, taskFileBuilder, this);
        preparator.startPreparator();
    }

    public void constructor(List<PreparatorResultGroup> preparatorResultGroups) {
        TransformerConstructorService constructor = new TransformerConstructorService(context, preparatorResultGroups, this, poolsize);
        if (taskFileBuilder.isMapping()) {
            constructor.startMapper();
        } else {
            logger.debug("skip mapping phase. constructing queryset...");
            constructor.startConstruct();
        }
    }


    @Override
    public void onPreparatorFinished(List<PreparatorResultGroup> preparatorResultGroups) {
        logger.debug("Preparator Finished.");

        constructor(preparatorResultGroups);

    }

    @Override
    public void onConstructorFinished(List<PreparatorResultGroup> resultGroups) {
        logger.debug("Constructor Finished.");

        serviceCallback.onTransformSuccess(resultGroups);
    }
}

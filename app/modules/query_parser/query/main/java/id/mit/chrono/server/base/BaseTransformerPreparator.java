package id.mit.chrono.server.base;

import id.mit.chrono.server.factory.DaoFactory;
import id.mit.chrono.server.iface.Preparator;
import id.mit.chrono.server.iface.PreparatorCallback;
import id.mit.chrono.server.model.tables.records.ColumnsetRecord;
import id.mit.chrono.server.model.tables.records.CrcollectortaskfilesRecord;
import id.mit.chrono.server.model.tables.records.CrprocessortaskfilesRecord;
import id.mit.chrono.server.model.tables.records.CrworkflowRecord;
import id.mit.chrono.server.obj.ChronoContext;
import id.mit.chrono.server.obj.PreparatorResult;
import id.mit.chrono.server.obj.PreparatorResultGroup;
import org.jooq.Record;
import org.jooq.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static id.mit.chrono.server.model.Tables.CRCOLLECTORTASKFILES;
import static id.mit.chrono.server.model.Tables.CRVENDOR;

public abstract class BaseTransformerPreparator implements Preparator {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    protected Record file;
    protected boolean reProcess;
    protected CrworkflowRecord workflow;      // query set phase1 only
    protected ChronoContext context;

    private Thread thread;
    private PreparatorCallback callback;

    protected List<PreparatorResult> processedFileGroup;

    private PreparatorResultGroup preparatorResultGroup;

    @Override
    public void start() {

        this.prepare();

        this.thread = new Thread(this);
        this.thread.setName(this.getClass().getSimpleName() + ":" + this.file.getValue(CRCOLLECTORTASKFILES.COLLECTORTASKFILES_LOCALFILENAME));
        thread.start();
    }

    private void prepare() {

        // init file group
        this.processedFileGroup = new ArrayList<>();

        // add extracted master file
//        this.processedFileGroup.addAll(
//                DaoFactory.createProcessorTaskFilesDaoImpl()
//                        .getProcessorTaskfiles(file.get(CRCOLLECTORTASKFILES.COLLECTORTASKFILES_ID))
//        );

        Result<CrprocessortaskfilesRecord> processorTaskfiles = DaoFactory.createProcessorTaskFilesDaoImpl()
                .getProcessorTaskfiles(file.get(CRCOLLECTORTASKFILES.COLLECTORTASKFILES_ID));

        processorTaskfiles.forEach(file -> {
            ColumnsetRecord columnset = DaoFactory.createColumnDaoImpl()
                    .getColumnset(file.getProcessortaskfilesColumnset());

//            String[] rawSource = file.getProcessortaskfilesLocaldir().split("/");
//            String source = rawSource[rawSource.length-1];

            PreparatorResult result = new PreparatorResult(
                    file.getProcessortaskfilesLocalfilename(),
                    columnset.getColumnsetColumns(),
                    file.getProcessortaskfilesLocaldir(),
                    new File(file.getProcessortaskfilesLocaldir() + File.separator + file.getProcessortaskfilesLocalfilename()),
                    columnset.getColumnsetPk());

            this.processedFileGroup.add(result);
        });

    }

    protected void finalizePreparator(Result<CrcollectortaskfilesRecord> depFiles) {

        if (depFiles != null) {

            // add result to extracted file group
            depFiles.forEach(dep -> {

//                this.processedFileGroup.addAll(
//                        DaoFactory.createProcessorTaskFilesDaoImpl()
//                                .getProcessorTaskfiles(dep.getCollectortaskfilesId())
//                );

                Result<CrprocessortaskfilesRecord> processorTaskfiles = DaoFactory.createProcessorTaskFilesDaoImpl()
                        .getProcessorTaskfiles(dep.getCollectortaskfilesId());

                processorTaskfiles.forEach(file -> {
                    ColumnsetRecord columnset = DaoFactory.createColumnDaoImpl()
                            .getColumnset(file.getProcessortaskfilesColumnset());

//                    String[] rawSource = file.getProcessortaskfilesLocaldir().split("/");
//                    String source = rawSource[rawSource.length-1];

                    PreparatorResult result = new PreparatorResult(
                            file.getProcessortaskfilesLocalfilename(),
                            columnset.getColumnsetColumns(),
                            file.getProcessortaskfilesLocaldir(),
                            new File(file.getProcessortaskfilesLocaldir() + File.separator + file.getProcessortaskfilesLocalfilename()),
                            columnset.getColumnsetPk());

                    this.processedFileGroup.add(result);
                });


            });
        }

        logger.debug("gathered " + processedFileGroup.size() + "(s) extracted files.");

        preparatorResultGroup = new PreparatorResultGroup(
                DaoFactory.getWorkflowDaoImpl().getWorkflowByEntityGroup(workflow.getWorkflowEntitygroup(), 2),      // get workflow phase 2
                this.processedFileGroup
        );

        preparatorResultGroup.setTaskFileId(this.file.getValue(CRCOLLECTORTASKFILES.COLLECTORTASKFILES_ID));
        preparatorResultGroup.setVendor(this.file.getValue(CRVENDOR.VENDOR_ID));

    }

    @Override
    public void setContext(ChronoContext context) {
        this.context = context;
    }

    @Override
    public void setWorkflow(CrworkflowRecord workflow) {
        this.workflow = workflow;
    }

    @Override
    public void setFile(Record file) {
        this.file = file;
    }

    @Override
    public void setReprocess(boolean reProcess) {
        this.reProcess = reProcess;
    }

    @Override
    public void setCallback(PreparatorCallback callback) {
        this.callback = callback;
    }

    @Override
    public void run() {
        getFile();

        // callback to TransformerService
        callback.onPrepareFinished(preparatorResultGroup);
    }

    protected abstract void getFile();

}

package id.mit.chrono.server.service;

import id.mit.chrono.server.builder.TaskFilesTransformerBuilder;
import id.mit.chrono.server.factory.DaoFactory;
import id.mit.chrono.server.iface.Preparator;
import id.mit.chrono.server.iface.PreparatorCallback;
import id.mit.chrono.server.iface.TransformerPreparatorCallback;
import id.mit.chrono.server.model.tables.records.CrworkflowRecord;
import id.mit.chrono.server.obj.ChronoContext;
import id.mit.chrono.server.obj.PreparatorResultGroup;
import org.jooq.Record;
import org.jooq.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static id.mit.chrono.server.model.Tables.CRCOLLECTORTASKFILES;

public class TransformerPreparatorService implements PreparatorCallback {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private TransformerPreparatorCallback serviceCallback;

    private ChronoContext context;
    private TaskFilesTransformerBuilder taskFileBuilder;

    private Result<Record> files;
    private boolean reProcess;
    private Result<CrworkflowRecord> workflow;

    private List<PreparatorResultGroup> preparatorResultGroups = new ArrayList<>();

    private int totalAllFiles;

    // KPI Variables (need improvement -> list files for each variables)
    private int processedFiles = 0;     // save number of files has been checked for process
    private int failedProcess = 0;      // save number of files that can't found workflow
    private int successProcess = 0;     // save number of files that processed to the next steps
    private int totalSkip = 0;          // save number of files that skipped

    private List<Preparator> preparators = new ArrayList<>();
    private final Object lockObj = new Object();
    private int threadFinished = 0;
    private int preparatorIndex = 25;


    public TransformerPreparatorService(ChronoContext context, Result<Record> files, boolean reProcess, TaskFilesTransformerBuilder builder, TransformerPreparatorCallback serviceCallback) {
        this.context = context;
        this.serviceCallback = serviceCallback;
        this.taskFileBuilder = builder;
        this.files = files;
        this.reProcess = reProcess;
    }

    public void startPreparator() {

        this.workflow = getWorkflow(taskFileBuilder);

        List<CrworkflowRecord> workflowPhase1 = workflow.stream().filter(set -> set.getWorkflowPhase() == 1).collect(Collectors.toList());

        // transform phase1 -> Preparator
        for (Record file: files) {

            processedFiles++;

            if (!reProcess &&
                    file.getValue(CRCOLLECTORTASKFILES.COLLECTORTASKFILES_PROCESSTIME) != null &&
                    file.getValue(CRCOLLECTORTASKFILES.COLLECTORTASKFILES_PROCESSTIME, Integer.class) != 0 &&
                    file.getValue(CRCOLLECTORTASKFILES.COLLECTORTASKFILES_PROCESSSTATUS) != null) {

                totalSkip++;

                continue;
            }

            boolean foundWorkflow = false;
            for (CrworkflowRecord set : workflowPhase1) {
                if (file.getValue(CRCOLLECTORTASKFILES.COLLECTORTASKFILES_LOCALFILENAME).matches(set.getWorkflowIdentitypattern())) {

                    logger.debug("found workflow entity ("+ file.getValue(CRCOLLECTORTASKFILES.COLLECTORTASKFILES_ID) +"): " + set.getWorkflowEntitygroup());

                    Preparator preparator = this.getPreparatorByClassName(set.getWorkflowClass());
                    if (preparator != null) {

                        preparator.setFile(file);
                        preparator.setReprocess(reProcess);
                        preparator.setWorkflow(set);
                        preparator.setContext(context);
                        preparator.setCallback(this);
//                        preparator.start();

                        preparators.add(preparator);

                    }

                    foundWorkflow = true;
                    successProcess++;

                    // if found workflow, then break. else continue searching.
//                    break;
                }
            }

            if (!foundWorkflow) {
                failedProcess++;
            }
        }

        logger.debug("total thread(s): " + preparators.size());
        logger.debug("total skip(s): " + totalSkip);

        if (preparators.size() < preparatorIndex) {
            preparatorIndex = preparators.size();
        }

        for (int i = 0; i < preparatorIndex; i++) {
            preparators.get(i).start();
        }
    }

    @Override
    public void onPrepareFinished(PreparatorResultGroup preparatorResultGroup) {

        synchronized (this.lockObj) {

            threadFinished++;

            this.preparatorResultGroups.add(preparatorResultGroup);
            this.totalAllFiles += preparatorResultGroup.getProcessedFiles().size();

//            if (this.processedFiles >= this.files.size() && this.preparatorResultGroups.size() >= this.successProcess) {

            if (preparatorIndex < preparators.size()) {

                preparators.get(preparatorIndex++).start();

            } else {

                if (threadFinished == preparators.size()) {

//                    this.preparatorResultGroups.forEach(item -> {
//                        System.out.println("########## item 1 ##########");
//                        item.getProcessedFiles().forEach(file -> System.out.println(file.getSource()));
//                    });

                    System.out.println("##########   SUMMARY PREPARATOR   ##########");
                    System.out.println("##    total processed file(s): " + processedFiles + "          ##");
                    System.out.println("##    total skipped file(s): " + totalSkip + "            ##");
                    System.out.println("##    total failed process file(s): " + failedProcess + "     ##");
                    System.out.println("##    total success process file(s): " + successProcess + "    ##");
                    System.out.println("########## SUMMARY PREPARATOR END ##########");

                    serviceCallback.onPreparatorFinished(this.preparatorResultGroups);
                }
            }
        }
    }

    private Result<CrworkflowRecord> getWorkflow(TaskFilesTransformerBuilder builder) {

        if (builder.getEntities() != null && builder.getEntities().length > 0) {
            return DaoFactory.getWorkflowDaoImpl().getWorkflowsByEntityGroup(builder.getEntities());
        }

        if (builder.getWorkflow() != null) {
            return DaoFactory.getWorkflowDaoImpl().getWorkflowsByEntityGroup(builder.getWorkflow());
        }

        return DaoFactory.getWorkflowDaoImpl().getWorkflows();
    }

    private Preparator getPreparatorByClassName(String className) {
        try {
            Class cls = Class.forName(className);
            return (Preparator) cls.newInstance();
        } catch (Exception e) {
            logger.debug(e.getMessage());
            e.printStackTrace();
        }
        return null;
    }
}

package id.mit.chrono.server.service;

import id.mit.chrono.server.factory.DaoFactory;
import id.mit.chrono.server.iface.Mapper;
import id.mit.chrono.server.iface.MapperCallback;
import id.mit.chrono.server.iface.TransformerConstructorCallback;
import id.mit.chrono.server.model.tables.records.CrmapnptqRecord;
import id.mit.chrono.server.model.tables.records.CrworkflowRecord;
import id.mit.chrono.server.obj.*;
import org.apache.commons.pool2.ObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPool;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.jooq.DSLContext;
import org.jooq.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.StringWriter;
import java.util.*;
import java.util.stream.Collectors;

public class TransformerConstructorService implements MapperCallback {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private TransformerConstructorCallback constructorCallback;

    private ChronoContext context;
    private List<PreparatorResultGroup> preparatorResultGroups;
    private int poolsize = 10;

    protected static ObjectPool<DSLContext> dbPool = null;
    protected static final Object lockObj = new Object();
    protected static final Object lockObj2 = new Object();
    protected static DSLContextFactory dslCF;

    private List<Mapper> mappers = new ArrayList<>();
    private Result<CrmapnptqRecord> mapnptqParams;


    public TransformerConstructorService(ChronoContext context, List<PreparatorResultGroup> preparatorResultGroups, TransformerConstructorCallback constructorCallback, int poolsize) {

        this.context = context;
        this.constructorCallback = constructorCallback;
        this.preparatorResultGroups = preparatorResultGroups;
        this.poolsize = poolsize;

        this.dslCF = new DSLContextFactory();
    }

    public void startMapper() {

        synchronized (lockObj) {

            if (dbPool == null) {

                dbPool = new GenericObjectPool<>(dslCF);
                ((GenericObjectPool<DSLContext>) dbPool).setMaxTotal(this.poolsize);
            }

        }

        // do mapping parameters first
        // start with grouping files by entity
        Map<CrworkflowRecord, List<PreparatorResultGroup>> entityGroup = preparatorResultGroups.stream()
                .collect(Collectors.groupingBy(PreparatorResultGroup::getWorkflowPhase2));

        // iterate through entity grouped files
        entityGroup.forEach((workflow, item) -> {

            List<PreparatorResult> mergedResults = new ArrayList<>();
            item.forEach(result -> mergedResults.addAll(result.getProcessedFiles()));

            PreparatorResultGroup prg = new PreparatorResultGroup(workflow, mergedResults);

            logger.debug("start mapping NPTQ Parameter for " + workflow.getWorkflowEntity() + ", total file to map: " + prg.getProcessedFiles().size());

            Mapper mapper = this.getMapperByClassName(workflow.getWorkflowClass());
            if (mapper != null) {

                mapper.setResultGroup(prg);
                mapper.setContext(context);
                mapper.setCallback(this);

                try {

                    DSLContext dslC = dbPool.borrowObject();
                    mapper.setDSLContext(dslC);

                } catch (Exception e) {
                    e.printStackTrace();
                }

                mappers.add(mapper);
            }

        });

        mappers.forEach(Mapper::start);
    }

    // assuming only 1 entityGroup for every run
    public void startConstruct() {

        List<HashMap<String, String>> allQueries = new ArrayList<>();

        // integrating file and nptq params
        preparatorResultGroups.parallelStream().forEach(item -> {

            VelocityContext context = new VelocityContext();

            String entityGroup = item.getWorkflowPhase2().getWorkflowEntitygroup();
            List<CrworkflowRecord> workflows = DaoFactory.getWorkflowDaoImpl().getWorkflowsByEntityGroup(entityGroup, 3);

            List<RawQuerysetObj> queriesObj = new ArrayList<>();

            // hashmap for storing query and flow entity name
            HashMap<String, String> flowQueries = new HashMap<>();
            item.setEntityGroup(entityGroup);

            // iterate through workflows, ex: ztebsc, ztebts, ztegcell, ztebscextgcell, ztegcellrelgcell, etc.
            for (CrworkflowRecord flow: workflows) {

                logger.debug("Collecting necessary files for " + flow.getWorkflowEntity());

                queriesObj.clear();

                mapnptqParams = DaoFactory.getMapNPTQDaoImpl().getMapNPTQsByEntity(flow.getWorkflowEntity());

                String masterFile = DaoFactory.getWorkflowDaoImpl().getWorkflowByEntity(flow.getWorkflowEntity(), 3).getWorkflowIdentitypattern();

                for (PreparatorResult file: item.getProcessedFiles()) {
                    // RawQuerysetObj represent a file as table
                    RawQuerysetObj queryObj = new RawQuerysetObj();

                    queryObj.setColumnset(file.getColumnset());
                    queryObj.setPath(file.getSource());
                    queryObj.setFileName(file.getFileName());
                    queryObj.setPrimaryKey(file.getKeyColumnset());
                    queryObj.setFileNameAlias(transformAliasFilename(file.getFileName()));

                    if (file.getFileName().matches(masterFile)) {
                        queryObj.setMasterFile(1);
                    }

                    switch (item.getWorkflowPhase2().getWorkflowVendor()) {
                        case 1:
                            // Huawei
                            queryObj.setSource(this.transformHuaweiSourceName(file.getSource()));
                            break;

                        case 2:
                            // Ericsson
                            queryObj.setSource(this.transformEricssonSourceName(file.getSource()));
                            break;

                        case 3:
                            // ZTE
                            queryObj.setSource(this.transformZTESourceName(file.getSource()));
                            break;
                    }

                    // process to add used param into RawQuerysetObj object
                    for (CrmapnptqRecord map : mapnptqParams) {

                        if (map.getCrmapnptqPriority() == null || map.getCrmapnptqMoLevel() == null || map.getMapnptqFile() == null) {
                            continue;
                        }

                        if (map.getMapnptqFile().equals(file.getFileName()) &&
                                map.getMapnptqSourcefile().equals(queryObj.getSource()) /*&& map.getCrmapnptqPriority() == 1*/) {

                            // try to find param first. to make sure inserted param is unique
                            RawQuerysetObj.Params param = queryObj.getMapnptq(
                                    map.getCrmapnptqObject(),
                                    map.getCrmapnptqParams(),
                                    map.getCrmapnptqBackupParams()
                            );

                            if (param == null) {
                                param = new RawQuerysetObj.Params(
                                        map.getCrmapnptqObject(),
                                        map.getCrmapnptqBackupObject(),
                                        map.getCrmapnptqParams(),
                                        map.getCrmapnptqBackupParams(),
                                        map.getCrmapnptqMoLevel(),
                                        map.getCrmapnptqPriority(),
                                        map.getMapnptqAlias(),
                                        map.getCrmapnptqCustomFunction()
                                );

                                queryObj.addMapnptq(param);
                            }
                        }
                    }

                    // make sure to add file that will be used for build queryset by checking if columns will be selected from a table/file
                    if (queryObj.getMapnptq().size() > 0) {
                        RawQuerysetObj rqCheck = queriesObj.stream().filter(f -> f.getFileName().equals(queryObj.getFileName())).findAny().orElse(null);

                        if (rqCheck == null) {
                            queriesObj.add(queryObj);
                        }
                    }
                }

                queriesObj = queriesObj.stream().sorted(
                        Comparator.comparingInt(RawQuerysetObj::getMasterFile).reversed()
                ).collect(Collectors.toList());

                int totalParam = queriesObj.stream().mapToInt(p -> p.getMapnptq().size()).sum()-2;

                // try to implement Velocity template
                context.put("rawQueries", queriesObj);
                context.put("totalParams", totalParam);

                StringWriter swOut = new StringWriter();
                String sqlTemplate = DaoFactory.getQuerysetDaoImpl().getSingleQuerysetByEntity(flow.getWorkflowEntity()).getQuerysetSql();

                if (sqlTemplate != null) {
                    logger.debug("Generating query for " + flow.getWorkflowEntity() + "...");
                    Velocity.evaluate(context, swOut, "tes log woi", sqlTemplate);

                    synchronized (lockObj) {

                        flowQueries.put(flow.getWorkflowEntity(), swOut.toString());

                    }
                }
            }

            synchronized (lockObj2) {
                allQueries.add(flowQueries);
                item.setQueryEntity(flowQueries);
            }

        });

        System.out.println("allQueries.size(): " + allQueries.size());

        // do callback here and pass allQueries into parent class.
        constructorCallback.onConstructorFinished(preparatorResultGroups);
    }

    private Mapper getMapperByClassName(String className) {

        System.out.println("className: " + className);

        try {
            Class cls = Class.forName(className);
            return (Mapper) cls.newInstance();
        } catch (Exception e) {
            logger.debug(e.getLocalizedMessage());
            e.printStackTrace();
        }


        return null;
    }

    @Override
    public void onMapFinished(String threadName) {

        // assuming only 1 entityGroup for every run
        this.startConstruct();
    }

    protected String transformZTESourceName(String source) {
        // ex: SDR-tdd_radio-v12.20.40-20210317012545-162.zip
        // ex: SDR-fdd_radio-v12.20.40-20210317012612-165.zip
        // ex: SDR-nb_radio-v12.20.40-Subnetwork_2021&2046&2022&2044&2045-20210317043336-92.zip
        // ex: UMEID_ITBBU_ZTE_20210317170000.zip
        // ex: Controller-uni_ground-R4V12.18.41P02-20210602013008-222.zip

        String[] rawSource = source.split("/");
        String[] fname = rawSource[rawSource.length-1].split("-");

        if (rawSource[rawSource.length-2].startsWith("UMEID")) {
            String[] part = rawSource[rawSource.length-2].split("_");
            return part[0] + "_" + part[1] + "-" + fname[0];
        }

        return fname[0] + "-" + fname[1];
    }

    protected String transformEricssonSourceName(String source) {

        // ex: GExport_MBSC_Bima1_10.224.130.193_20210308030521.xml.gz

        String[] rawSource = source.split("/");
        String output = rawSource[rawSource.length-1];

        // ex: CM_3gpp_RXXXXX, CM_3gpp_LTE_XXX, CM_3gpp_BSC_XXXX
        if (output.startsWith("CM")) {
            output = output.split("_")[0] + "_" + output.split("_")[1];
        }
        // ex: RNXXXXX
        else if (output.startsWith("RN")) {
            output = "RNX";
        }
        // ex: RVXXXXX
        else if (output.startsWith("RV")) {
            output = "RVX";
        }
        else if (output.startsWith("LTE")) {
            output = output.split("_")[0];
        }
        else if (output.startsWith("OSSRC")) {
            output = output.substring(0, output.lastIndexOf("."));
            output = output.split("_")[0] + "_" + output.split("_")[2];
        }
        // ex: nptq_cna_export_ran2.txt
        else if (source.contains("nptq_cna_export")) {
            output = "cna_export";
        }
        else if (output.matches("^nptq_.*_3g_.*[.]txt")) {
            output = "nptq_3g";
        }
        else if (output.matches("^nptq_.*_4g_.*[.]txt")) {
            output = "nptq_4g";
        }

        return output;
    }

    protected String transformHuaweiSourceName(String source) {

        String[] rawSource = source.split("/");
        String output = rawSource[rawSource.length-1];

        // ex: GExport_MBSC_Bima1_10.224.130.193_20210308030521.xml.gz
        if (output.matches("^GExport.*|^CMExport.*")) {
            output = output.split("_")[0];
        }
        // ex: CFGDATA.XML.gz_x_XXXX
        else if (output.matches("^CFGDATA.*")) {
            output = output.substring(0, output.indexOf("."));
        }
        // ex: Regional_X_CFGMML_(MBSC|RNC)_XXX
        else if (output.matches("^Regional.*CFGMML.*")) {
            output = output.split("_")[2];
        }

        return output;
    }

    protected String transformAliasFilename(String filename) {
        return filename.substring(0, filename.lastIndexOf("."));
    }
}

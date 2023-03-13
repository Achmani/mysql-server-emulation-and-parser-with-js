package id.mit.chrono.server.transformer;

import id.mit.chrono.server.base.BaseTransformerPreparator;
import id.mit.chrono.server.model.tables.records.CrcollectortaskfilesRecord;
import id.mit.chrono.server.provider.DatasourceProviderFactory;
import org.jooq.Result;

import static id.mit.chrono.server.model.Tables.CRCOLLECTORTASKFILES;

public class HwEnodebPreparator extends BaseTransformerPreparator {

    @Override
    protected void getFile() {

        String masterFileName = file.getValue(CRCOLLECTORTASKFILES.COLLECTORTASKFILES_LOCALFILENAME);

        String[] depsPattern = new String[0];

        if (workflow.getWorkflowDependencies() != null) {

            depsPattern = workflow.getWorkflowDependencies().split("\\|");

        }

        for (int i = 0; i < depsPattern.length; i++) {

            // substring filename to replace key
            String key = masterFileName.split("_")[1] + "_" + masterFileName.split("_")[2];

            depsPattern[i] = depsPattern[i].replaceAll("%KEY", key);

        }

        // get dependencies files
        Result<CrcollectortaskfilesRecord> depFiles = DatasourceProviderFactory.getFileDeps(
                context,
                depsPattern,
                reProcess,
                file.get(CRCOLLECTORTASKFILES.COLLECTORTASKFILES_LOCALFILENAME)
        );

        depFiles.forEach(item -> System.out.println(item.getCollectortaskfilesLocalfilename()));

        // callback to parent
        this.finalizePreparator(depFiles);

    }

}

package id.mit.chrono.server.transformer;

import id.mit.chrono.server.base.BaseTransformerPreparator;
import id.mit.chrono.server.builder.DependencyFileBuilder;
import id.mit.chrono.server.model.tables.records.CrcollectortaskfilesRecord;
import id.mit.chrono.server.provider.DatasourceProviderFactory;
import org.jooq.Result;

import java.util.Arrays;

import static id.mit.chrono.server.model.Tables.CRCOLLECTORTASKFILES;

public class NokBscPreparator extends BaseTransformerPreparator {

    @Override
    protected void getFile() {

        Result<CrcollectortaskfilesRecord> depFiles = null;
        String masterFileName = file.getValue(CRCOLLECTORTASKFILES.COLLECTORTASKFILES_LOCALFILENAME);

        if (workflow.getWorkflowDependencies() != null) {

            String[] depsPattern = workflow.getWorkflowDependencies().split("\\|");

            for (int i = 0; i < depsPattern.length; i++) {

                // substring filename to replace key
                String key = masterFileName.split("_")[3];
                depsPattern[i] = depsPattern[i].replaceAll("%KEY", key);
            }

            DependencyFileBuilder builder = new DependencyFileBuilder()
                    .setDepsPattern(depsPattern)
                    .setDatasourceId(file.get(CRCOLLECTORTASKFILES.COLLECTORTASKFILES_DATASOURCE))
                    .setReProcess(reProcess)
                    .setMasterFilename(file.get(CRCOLLECTORTASKFILES.COLLECTORTASKFILES_LOCALFILENAME))
                    .setLocaldir(workflow.getWorkflowLocaldir())
                    .build();

            depFiles = DatasourceProviderFactory.getFileDeps(context, builder);
        }

        // callback to parent
        this.finalizePreparator(depFiles);

    }

}

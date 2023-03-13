package id.mit.chrono.server.transformer;

import id.mit.chrono.server.base.BaseTransformerPreparator;
import id.mit.chrono.server.model.tables.records.CrcollectortaskfilesRecord;
import id.mit.chrono.server.provider.DatasourceProviderFactory;
import org.jooq.Result;

import java.util.Arrays;

import static id.mit.chrono.server.model.Tables.CRCOLLECTORTASKFILES;

public class ZteBscPreparator extends BaseTransformerPreparator {

    @Override
    protected void getFile() {

        Result<CrcollectortaskfilesRecord> depFiles = null;

        if (workflow.getWorkflowDependencies() != null) {
            String[] depsPattern = workflow.getWorkflowDependencies().split("\\|");
            depFiles = DatasourceProviderFactory.getFileDeps(
                    context,
                    depsPattern,
                    reProcess,
                    file.get(CRCOLLECTORTASKFILES.COLLECTORTASKFILES_DATASOURCE),
                    file.get(CRCOLLECTORTASKFILES.COLLECTORTASKFILES_LOCALFILENAME)
            );
        }


        // callback to parent
        this.finalizePreparator(depFiles);

    }

}

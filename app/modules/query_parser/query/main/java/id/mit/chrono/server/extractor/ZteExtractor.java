package id.mit.chrono.server.extractor;

import id.mit.chrono.server.base.BaseFileExtractor;
import id.mit.chrono.server.iface.ExtractorCallback;
import id.mit.chrono.server.obj.ChronoContext;
import id.mit.chrono.server.obj.HDFSCl;

import java.io.File;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class ZteExtractor extends BaseFileExtractor {

    @Override
    protected void extract() {

        ArrayList<String> filePaths = files.stream().map(File::getAbsolutePath).collect(Collectors.toCollection(ArrayList::new));
        finishExtract(filePaths);

    }


}

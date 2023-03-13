package id.mit.chrono.server.iface;

import id.mit.chrono.server.obj.SourceFile;

import java.util.ArrayList;

public interface FileParser extends Runnable {

    public void setInitData(FileParserCallback fpc, SourceFile file, String fileIdentity, String fileDependencies);

    public void setUsedSourceGroups(ArrayList<String> sourceGroups);

    public SourceFile getSourceFile();

    public void freeSourceFile();

    public void parse();

    public void parseAndWait();
}

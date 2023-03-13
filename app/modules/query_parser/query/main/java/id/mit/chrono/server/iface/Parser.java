package id.mit.chrono.server.iface;

import id.mit.chrono.server.obj.SourceFile;
import org.jooq.Record;

import java.util.ArrayList;

public interface Parser {

    public void addFile(long collectorTaskFilesId, String fileName, String filePath, long size, String checksum);

    public void startParse();

    public void setParserGroupCallback(ParserGroupCallback pgc);
}

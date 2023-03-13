package id.mit.chrono.server.iface;

import id.mit.chrono.server.base.BaseParserGroup;
import id.mit.chrono.server.model.tables.Crcell;
import id.mit.chrono.server.model.tables.records.*;

import java.util.List;

public interface ParserGroupCallback {

    public void onParserGroupFinished(BaseParserGroup pg);

    public CrnodeRecord getNode(int vendorId, String nodeName, int defaultNeCategory);

    public int getNodeStatus(String nodeName);

    public CrcellRecord getCell(String lookup, String identifier, CrcellRecord cellProto, CrnodeRecord nodeData);

    public CrnodeRecord getCellNodeAlias(Object cellNodeRefObj, Object cellNodeControllerRefObj, int cellClassId, Double arfcn, String cellName, CrnodeRecord nodeData);

    public CrnodeRecord getCellNodeAlias2(int vendorId, int cellClassId, String cellName, String nodeName);

    public CrcellRecord getCellByArfcn(String rat, double arfcn, String identifier, CrcellRecord cellProto, CrnodeRecord nodeData);

    public CrcellRecord getCellByFreq(String rat, double freq, String identifier, CrcellRecord cellProto, CrnodeRecord nodeData);

    public CrcellRecord getCellByBand(String rat, int band, String identifier, CrcellRecord cellProto, CrnodeRecord nodeData);

    public List<CrsettingsRecord> getSettings(String settingsCode);

    public int getCellStatus(String cellName);

    public String getSiteAreaDefinedPrefix1ByLatLon(double lat, double lon);
}

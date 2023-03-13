package id.mit.chrono.server.obj;

public class FinalizerInadequateCell {

    public String tableName;
    public String id;
    public String epoch;
    public String fileId;
    public String cellName;
    public String cellClass;
    public String cellIdentifier;


    public FinalizerInadequateCell(String tableName, String id, String epoch, String fileId, String cellName, String cellClass, String cellIdentifier) {
        this.id = id;
        this.epoch = epoch;
        this.tableName = tableName;
        this.fileId = fileId;
        this.cellName = cellName;
        this.cellClass = cellClass;
        this.cellIdentifier = cellIdentifier;
    }

    public String getId() {
        return id;
    }

    public String getEpoch() {
        return epoch;
    }

    public String getTableName() {
        return tableName;
    }

    public String getFileId() {
        return fileId;
    }

    public String getCellName() {
        return cellName;
    }

    public String getCellClass() {
        return cellClass;
    }

    public String getCellIdentifier() {
        return cellIdentifier;
    }
}

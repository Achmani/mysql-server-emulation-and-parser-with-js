package id.mit.chrono.server.obj;

import java.io.File;

public class PreparatorResult {

    private String fileName;
    private String columnset;
    private String keyColumnset;
    private String source;
    private File file;

    private String objectBackup;
    private String paramBackup;

    public PreparatorResult(String fileName, String columnset, String source, File file, String keyColumnset) {
        this.fileName = fileName;
        this.columnset = columnset;
        this.source = source;
        this.file = file;
        this.keyColumnset = keyColumnset;
    }

    public PreparatorResult(PreparatorResult data) {
        this.fileName = data.fileName;
        this.columnset = data.columnset;
        this.source = data.source;
        this.file = data.file;
    }

    public String getKeyColumnset() {
        return keyColumnset;
    }

    public void setKeyColumnset(String keyColumnset) {
        this.keyColumnset = keyColumnset;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getColumnset() {
        return columnset;
    }

    public void setColumnset(String columnset) {
        this.columnset = columnset;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getObjectBackup() {
        return objectBackup;
    }

    public void setObjectBackup(String objectBackup) {
        this.objectBackup = objectBackup;
    }

    public String getParamBackup() {
        return paramBackup;
    }

    public void setParamBackup(String paramBackup) {
        this.paramBackup = paramBackup;
    }
}

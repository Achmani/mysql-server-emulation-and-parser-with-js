package id.mit.chrono.server.obj;

import java.io.File;
import java.util.ArrayList;

public class SourceFile {

    private long taskFilesId;
    private int dataSourceTypeId;
    private String filePath;
    private long size;
    private String checksum;
    private int processTime;
    private int processStatus;
    private String processStatusReason;

    private ArrayList<Long> taskFilesIdDeps = new ArrayList<Long>();

    private String key;
    private ArrayList<Object> result = new ArrayList<>();

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public SourceFile(long taskFilesId, int dataSourceTypeId, String filePath, long size, String checksum) {
        this.taskFilesId = taskFilesId;
        this.dataSourceTypeId = dataSourceTypeId;
        this.filePath = filePath;
        this.size = size;
        this.checksum = checksum;
    }

    public ArrayList<Object> getResult() {
        return result;
    }

    public void purgeResult() {}

    public void purgeResult2() { this.result = null; }

    public void clearResult(){
        this.result.clear();
    }

    public void setResult(ArrayList<Object> result) {
        this.result = result;
    }

    public void addResult(Object o){
        this.result.add(o);
    }

    public void addAllResult(ArrayList<Object> o){
        this.result.addAll(o);
    }

    public String getFileName(){
        return new File(this.filePath).getName();
    }

    public String getProcessStatusReason() {
        return processStatusReason;
    }

    public void setProcessStatusReason(String processStatusReason) {
        this.processStatusReason = processStatusReason;
    }

    public int getProcessTime() {
        return processTime;
    }

    public void setProcessTime(int processTime) {
        this.processTime = processTime;
    }

    public int getProcessStatus() {
        return processStatus;
    }

    public void setProcessStatus(int processStatus) {
        this.processStatus = processStatus;
    }

    public long getTaskFilesId() {
        return taskFilesId;
    }

    public void setTaskFilesId(long taskFilesId) {
        this.taskFilesId = taskFilesId;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public long getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getChecksum() {
        return checksum;
    }

    public void setChecksum(String checksum) {
        this.checksum = checksum;
    }

    public int getDataSourceTypeId() {
        return dataSourceTypeId;
    }

    public void setDataSourceTypeId(int dataSourceTypeId) {
        this.dataSourceTypeId = dataSourceTypeId;
    }
}

package id.mit.chrono.server.obj;

import java.util.ArrayList;
import java.util.List;

public class RawQuerysetObj {

    private String path;
    private String columnset;
    private String primaryKey;
    private String source;
    private String fileName;
    private String fileNameAlias;
    private List<Params> mapnptq;
    private int masterFile;

    public RawQuerysetObj() {
        this.mapnptq = new ArrayList<>();
        this.masterFile = 0;
    }

    public RawQuerysetObj(String path, String columnset, String primaryKey, String fileName, String source) {
        this.path = path;
        this.columnset = columnset;
        this.primaryKey = primaryKey;
        this.fileName = fileName;
        this.source = source;
        this.mapnptq = new ArrayList<>();
        this.masterFile = 0;
    }

    public int getMasterFile() {
        return masterFile;
    }

    public String getFileNameAlias() {
        return fileNameAlias;
    }

    public void setFileNameAlias(String fileNameAlias) {
        this.fileNameAlias = fileNameAlias;
    }

    public void setMasterFile(int masterFile) {
        this.masterFile = masterFile;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getColumnset() {
        return columnset;
    }

    public void setColumnset(String columnset) {
        this.columnset = columnset;
    }

    public String getPrimaryKey() {
        return primaryKey;
    }

    public void setPrimaryKey(String primaryKey) {
        this.primaryKey = primaryKey;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public List<Params> getMapnptq() {
        return mapnptq;
    }

    public void setMapnptq(List<Params> mapnptq) {
        this.mapnptq = mapnptq;
    }

    public void addMapnptq(String object, String backupObject, String params, String backupParams, String moLevel, int priority, String alias, String customFunction) {
        this.mapnptq.add(new Params(object, backupObject, params, backupParams, moLevel, priority, alias, customFunction));
    }

    public void addMapnptq(Params param) {
        this.mapnptq.add(param);
    }

    public Params getMapnptq(String object, String params, String backupParams) {
        for (Params param : mapnptq) {
            if (param.getObject().equals(object) && param.getParams().equals(params)) {
                if (param.getBackupParams() == null && backupParams == null) {
                    return param;
                } else if (param.getBackupParams() != null && backupParams != null) {
                    if (param.getBackupParams().equals(backupParams)) {
                        return param;
                    }
                }
            }
        }

        return null;
    }



    public static class Params {

        private String object;
        private String backupObject;
        private String params;
        private String backupParams;
        private String moLevel;
        private int priority;
        private String alias;
        private String customFunction;

        public Params() {}

        public Params(String object, String backupObject, String params, String backupParams, String moLevel, int priority, String alias, String customFunction) {
            this.object = object;
            this.backupObject = backupObject;
            this.params = params;
            this.backupParams = backupParams;
            this.moLevel = moLevel;
            this.priority = priority;
            this.alias = alias;
            this.customFunction = customFunction;
        }

        public String getCustomFunction() {
            return customFunction;
        }

        public void setCustomFunction(String customFunction) {
            this.customFunction = customFunction;
        }

        public String getAlias() {
            return alias;
        }

        public void setAlias(String alias) {
            this.alias = alias;
        }

        public String getObject() {
            return object;
        }

        public void setObject(String object) {
            this.object = object;
        }

        public String getBackupObject() {
            return backupObject;
        }

        public void setBackupObject(String backupObject) {
            this.backupObject = backupObject;
        }

        public String getParams() {
            return params;
        }

        public void setParams(String params) {
            this.params = params;
        }

        public String getBackupParams() {
            return backupParams;
        }

        public void setBackupParams(String backupParams) {
            this.backupParams = backupParams;
        }

        public String getMoLevel() {
            return moLevel;
        }

        public void setMoLevel(String moLevel) {
            this.moLevel = moLevel;
        }

        public int getPriority() {
            return priority;
        }

        public void setPriority(int priority) {
            this.priority = priority;
        }
    }


}

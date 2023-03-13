package id.mit.chrono.server.obj;

import java.util.Date;

public class ChronoContext {

    private String GROUP = null;
    private String TIMEGROUP = null;

    private Date groupDate;

    private int COLLECTORTASK_ID = 0;
    private int DATAGROUP_ID;

    private boolean PARSE_ONLY = false;

    public String getRUNMODE() {
        return RUNMODE;
    }

    public void setRUNMODE(String RUNMODE) {
        this.RUNMODE = RUNMODE;
    }

    private String RUNMODE = null;

    public boolean isPARSE_ONLY() {
        return PARSE_ONLY;
    }

    public void setPARSE_ONLY(boolean PARSE_ONLY) {
        this.PARSE_ONLY = PARSE_ONLY;
    }

    public String getGROUP() {
        return GROUP;
    }

    public void setGROUP(String GROUP) {
        this.GROUP = GROUP;
    }

    public String getTIMEGROUP() {
        return TIMEGROUP;
    }

    public void setTIMEGROUP(String TIMEGROUP) {
        this.TIMEGROUP = TIMEGROUP;
    }

    public Date getGroupDate() {
        return groupDate;
    }

    public int getEpochTime() {
        return (int) (getGroupDate().getTime()/1000);
    }

    public void setGroupDate(Date groupDate) {
        this.groupDate = groupDate;
    }

    public int getCOLLECTORTASK_ID() {
        return COLLECTORTASK_ID;
    }

    public void setCOLLECTORTASK_ID(int COLLECTORTASK_ID) {
        this.COLLECTORTASK_ID = COLLECTORTASK_ID;
    }

    public int getDATAGROUP_ID() {
        return DATAGROUP_ID;
    }

    public void setDATAGROUP_ID(int DATAGROUP_ID) {
        this.DATAGROUP_ID = DATAGROUP_ID;
    }
}

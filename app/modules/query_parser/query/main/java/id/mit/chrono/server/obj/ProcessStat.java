package id.mit.chrono.server.obj;

import id.mit.chrono.server.enm.PS;

public class ProcessStat {

    public PS state;
    public String key;
    public long execTime;
    public ContainerStatistic cs;

    public ProcessStat(PS state, String key, long execTime) {
        this.state = state;
        this.key = key;
        this.execTime = execTime;
        this.cs = new ContainerStatistic(PS.NONE);
    }

    public ProcessStat(PS state, String key, long execTime, ContainerStatistic cs) {
        this.state = state;
        this.key = key;
        this.execTime = execTime;
        this.cs = cs;
    }
}

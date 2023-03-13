package id.mit.chrono.server.obj;

import com.google.common.base.Stopwatch;
import id.mit.chrono.server.enm.PS;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class ContainerStatistic {

    private PS state;

    private Stopwatch sw = Stopwatch.createUnstarted();

    private ArrayList<Long> selectTime = new ArrayList<Long>();
    private ArrayList<Long> insertTime = new ArrayList<Long>();
    private ArrayList<Long> updateTime = new ArrayList<Long>();

    ContainerStatistic(PS state){
        this.state = state;
    }

    public void startStopWatch(){
        this.sw.start();
    }

    public void resetAndStartStopWatch(){
        this.sw.reset();
        this.sw.start();
    }

    public PS getState() {
        return state;
    }

    public void stopStopWatch(){
        this.sw.start();
    }

    public void captureSelect(){
        this.selectTime.add(sw.elapsed(TimeUnit.MILLISECONDS));
    }

    public void captureInsert(){
        this.insertTime.add(sw.elapsed(TimeUnit.MILLISECONDS));
    }

    public void captureUpdate(){
        this.updateTime.add(sw.elapsed(TimeUnit.MILLISECONDS));
    }

    public int getTotalSelect(){
        return this.selectTime.size();
    }
    public int getTotalInsert(){
        return this.insertTime.size();
    }
    public int getTotalUpdate(){
        return this.updateTime.size();
    }

    public int getAvgSelectTime(){

        return (selectTime.size()!=0)?selectTime.stream().mapToInt(Long::intValue).sum()/selectTime.size():0;
    }
    public int getAvgInsertTime(){

        return (insertTime.size()!=0)?insertTime.stream().mapToInt(Long::intValue).sum()/insertTime.size():0;
    }
    public int getAvgUpdateTime(){

        return (updateTime.size()!=0)?updateTime.stream().mapToInt(Long::intValue).sum()/updateTime.size():0;
    }
}

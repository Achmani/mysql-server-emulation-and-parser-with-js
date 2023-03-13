package id.mit.chrono.server.obj;

import id.mit.chrono.server.base.HwBaseContainer;
import id.mit.chrono.server.enm.PS;
import id.mit.chrono.server.iface.FileProcessor;
import id.mit.chrono.server.iface.ParserGroupCallback;
import id.mit.chrono.server.model.tables.records.*;
import id.mit.chrono.server.util.GeoUtil;
import id.mit.chrono.server.util.GsmNetworkUtils;
import org.jooq.DSLContext;
import org.jooq.impl.DSL;
import org.jooq.types.UInteger;
import org.jooq.types.ULong;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static id.mit.chrono.server.model.Tables.HWENODEB;
import static id.mit.chrono.server.model.Tables.HWLCELL;

public class DummyContainer implements FileProcessor {

    protected ArrayList<PS> states = new ArrayList<>();
    protected ArrayList<PS> workingStates = new ArrayList<>();

    public DummyContainer(DSLContext db, ParserGroupCallback pgc, ChronoContext context, SourceFile sf, MapEntityObj meo) {
        super();
    }

    @Override
    public String getKey() {
        return null;
    }

    public boolean isFinished(PS state){

        synchronized (this.states){

            return this.states.contains(state);
        }
    }

    public boolean proposeProcess(PS state){

        synchronized (this.states){

            if(this.states.contains(state)){
                return false;
            }

            if(this.workingStates.contains(state)){
                return false;
            }

            this.workingStates.add(state);

            return true;
        }
    }

    protected boolean updateWorkingState(PS state){

        synchronized (this.workingStates){

            if(this.workingStates.contains(state)){

                this.workingStates.remove(state);

                synchronized (this.states){

                    this.states.add(state);

                    return true;
                }
            }
        }

        return false;
    }

    @Override
    public boolean processAll(DSLContext db){

        return true;
    }

    @Override
    public boolean process(DSLContext adb, PS state){

        return updateWorkingState(state);
    }
}

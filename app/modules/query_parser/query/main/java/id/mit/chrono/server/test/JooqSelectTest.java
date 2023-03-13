package id.mit.chrono.server.test;

import id.mit.chrono.server.base.BaseMain;
import id.mit.chrono.server.model.Tables;
import id.mit.chrono.server.model.tables.records.HwbscRecord;
import id.mit.chrono.server.model.tables.records.HwbtsRecord;
import id.mit.chrono.server.model.tables.records.NokbscRecord;
import id.mit.chrono.server.model.tables.records.TempXxxRecord;
import org.jooq.Result;
import org.jooq.types.UInteger;

import java.sql.Timestamp;


public class JooqSelectTest extends BaseMain {

    public JooqSelectTest() {
        select();
    }

    private void select(){
//        Result<NokbscRecord> data = db.selectFrom(Tables.NOKBSC).where(Tables.NOKBSC.NOKBSC_DATE.eq(UInteger.valueOf(1624068000))).fetch();
//        System.out.println("Result");
//        System.out.println(data.toString());

        Result<HwbscRecord> data = db.selectFrom(Tables.HWBSC).where(Tables.HWBSC.HWBSC_DATE.eq(UInteger.valueOf(1623981600))).fetch();
        System.out.println("Result");
        System.out.println(data.toString());

//        Result<HwbtsRecord> data = db.selectFrom(Tables.HWBTS).where(Tables.HWBTS.HWBTS_DATE.eq(UInteger.value())).fetch();

    }

    public static void main(String[] args){
        new JooqSelectTest();
    }

}

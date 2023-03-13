package id.mit.chrono.server.test;

import id.mit.chrono.server.base.BaseMain;
import id.mit.chrono.server.model.Tables;
import id.mit.chrono.server.model.tables.records.NokbscRecord;
import id.mit.chrono.server.model.tables.records.TempXxxRecord;
import id.mit.chrono.server.model.tables.records.CrdatatypeRecord;
import id.mit.chrono.server.model.tables.records.HwbtsRecord;
import org.jooq.DSLContext;
import org.jooq.InsertQuery;
import org.jooq.Result;
import org.jooq.SQLDialect;
import org.jooq.conf.Settings;
import org.jooq.conf.StatementType;
import org.jooq.impl.DSL;
import org.jooq.types.UInteger;

import java.sql.DriverManager;
import java.sql.Timestamp;
import java.util.concurrent.TimeUnit;


public class JooqTest extends BaseMain {

    public JooqTest() {
        test1();
    }

    private void test1(){


    }

    public static void main(String[] args){
        new JooqTest();
    }

}

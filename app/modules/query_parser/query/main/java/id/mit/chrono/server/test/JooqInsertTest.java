package id.mit.chrono.server.test;

import id.mit.chrono.server.base.BaseMain;
import id.mit.chrono.server.model.Tables;
import id.mit.chrono.server.model.tables.records.TempXxxRecord;

import java.sql.Timestamp;


public class JooqInsertTest extends BaseMain {

    public JooqInsertTest() {
        insert();
    }

    private void insert(){

        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        String str_timestamp = String.valueOf(timestamp.getTime());

        //Create Test
        TempXxxRecord xxx  = db.newRecord(Tables.TEMP_XXX);
        xxx.setKey("JOOQ to Data Core Server");
        xxx.setValue(str_timestamp);
        xxx.setExt1Key("JOOQ to Data Core Server Ext1");
        xxx.setExt1Value(str_timestamp+"_ext_1");
        xxx.setExt2Key("JOOQ to Data Core Server Ext2");
        xxx.setExt2Value(str_timestamp+"_ext_2");
        xxx.store();

        System.out.println("Process Insert");
        System.out.println(xxx);

    }

    public static void main(String[] args){
        new JooqInsertTest();
    }

}

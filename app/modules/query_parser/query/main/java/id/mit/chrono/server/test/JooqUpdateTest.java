package id.mit.chrono.server.test;

import id.mit.chrono.server.base.BaseMain;
import id.mit.chrono.server.model.Tables;
import id.mit.chrono.server.model.tables.records.NokbscRecord;
import id.mit.chrono.server.model.tables.records.TempXxxRecord;
import org.jooq.Result;
import org.jooq.types.UInteger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Timestamp;


public class JooqUpdateTest extends BaseMain {

    public JooqUpdateTest(String ext2_value) {
        update(ext2_value);
    }

    private void update(String ext2_value){
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        String str_timestamp = String.valueOf(timestamp.getTime());

                int update = db.update(Tables.TEMP_XXX)
                        .set(Tables.TEMP_XXX.KEY,"JOOQ UPDATE DATA Core Server")
                        .set(Tables.TEMP_XXX.VALUE,str_timestamp)
                        .set(Tables.TEMP_XXX.EXT1_KEY,"JOOQ UPDATE DATA Core Server Ext 1")
                        .set(Tables.TEMP_XXX.EXT1_VALUE,str_timestamp+"_ext_1")
                        .set(Tables.TEMP_XXX.EXT2_KEY,"JOOQ UPDATE DATA Core Server Ext 2")
                        .set(Tables.TEMP_XXX.EXT2_VALUE,str_timestamp+"_ext_2")
                        .where(Tables.TEMP_XXX.EXT2_VALUE.eq(ext2_value))
                        .execute();

        System.out.println("Process Update");
        System.out.println(update);
    }

    public static void main(String[] args) throws IOException {
        // Enter data using BufferReader
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Input EXT2 Value for update : ");
        // Reading data using readLine
        String ext2_value = reader.readLine();
        new JooqUpdateTest(ext2_value);
    }

}

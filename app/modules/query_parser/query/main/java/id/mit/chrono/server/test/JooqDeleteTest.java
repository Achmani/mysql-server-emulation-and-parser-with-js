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


public class JooqDeleteTest extends BaseMain {


    public JooqDeleteTest(String ext1_value) {
        delete(ext1_value);
    }

    private void delete(String ext1_value){
        //Delete Test
        int delete = db.deleteFrom(Tables.TEMP_XXX).where(Tables.TEMP_XXX.EXT1_VALUE.eq(ext1_value)).execute();
        System.out.println("Process Delete");
        System.out.println(delete);
    }

    public static void main(String[] args) throws IOException {
        // Enter data using BufferReader
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Input EXT1 Value for delete : ");
        // Reading data using readLine
        String ext1_value = reader.readLine();
        new JooqDeleteTest(ext1_value);
    }

}

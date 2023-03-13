package id.mit.chrono.server.database.dao.nptq;

import id.mit.chrono.server.database.DatabaseHelper;
import id.mit.chrono.server.model.tables.records.CrnptqRecord;
import org.jooq.DSLContext;
import org.jooq.Result;

import java.io.*;
import java.util.Arrays;

import static id.mit.chrono.server.model.Tables.CRNPTQ;

public class NPTQDaoImpl implements NPTQDao{

    DSLContext db;

    public NPTQDaoImpl() {
        this.db = DatabaseHelper.connectDB();
    }

    @Override
    public Result<CrnptqRecord> getRecord() {
        return db.selectFrom(CRNPTQ).fetch();
    }

    @Override
    public CrnptqRecord getRecord(String object, String params, String entity) {

        return db.selectFrom(CRNPTQ)
                .where(CRNPTQ.NPTQ_OBJECT.equal(object))
                .and(CRNPTQ.NPTQ_PARAMS.equal(params))
                .and(CRNPTQ.NPTQ_ENTITY.equal(entity))
                .fetchAny();
    }

    @Override
    public Result<CrnptqRecord> getRecord(String entity) {
        return db.selectFrom(CRNPTQ)
                .where(CRNPTQ.NPTQ_ENTITY.equal(entity))
                .fetch();
    }

    @Override
    public CrnptqRecord insert(String object, String params, String entity) {

        CrnptqRecord record = getRecord(object, params, entity);

        if (record == null) {

            record = db.newRecord(CRNPTQ);
            record.setNptqObject(object);
            record.setNptqParams(params);
            record.setNptqEntity(entity);
            record.store();
        }

        return record;
    }

    @Override
    public void insert(File csvFile) {

        System.out.println("found file: " + csvFile.getName());

        String line;
        int count = 0;
        int failed = 0;
        int success = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

            System.out.println("inserting data...");

            while ((line = br.readLine()) != null) {

                count++;

                // skip header
                if (count == 1) {
                    continue;
                }

                String[] datas = line.split(";");

                System.out.println(Arrays.toString(datas));

                CrnptqRecord record = insert(datas[0], datas[1], datas[2]);
                if (record != null) {
                    success++;
                } else {
                    failed++;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("########## Insert NPTQ Summary ##########");
        System.out.println("######## total data: " + --count + " ########");
        System.out.println("##### total success insert: " + success + " #####");
        System.out.println("##### total failed insert: " + failed + " #####");

    }

}

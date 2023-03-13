package id.mit.chrono.server.test;

import id.mit.chrono.server.database.DatabaseHelper;
import id.mit.chrono.server.database.dao.mapnptq.MapNPTQDaoImpl;
import id.mit.chrono.server.factory.DaoFactory;
import id.mit.chrono.server.model.tables.records.CrmapnptqRecord;
import org.jooq.DSLContext;
import org.jooq.Result;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static id.mit.chrono.server.model.Tables.CRMAPNPTQ;


// this class only used to insert master NPTQ object and parameters
public class NPTQTest {

    public static void main(String[] args) {

        DSLContext db = DatabaseHelper.connectDB();

//        DaoFactory.getNPTQDaoImpl().insert(new File("/storage/chrono/app/collector/development/nptq_param_master.csv"));

        MapNPTQDaoImpl mapNptq = DaoFactory.getMapNPTQDaoImpl();

        Result<CrmapnptqRecord> records = mapNptq.getMapNPTQs();

        // group by entity
        Map<String, List<CrmapnptqRecord>> entityGroup = records.stream()
                .collect(Collectors.groupingBy(CrmapnptqRecord::getMapnptqEntity));

        entityGroup.forEach((entity, items) -> {
            System.out.println("entity: " + entity);

            // group by object and params
            List<CrmapnptqRecord> concats = new ArrayList<>();
            items.forEach(data -> {
                CrmapnptqRecord record = db.newRecord(CRMAPNPTQ);

            });
        });

    }

}

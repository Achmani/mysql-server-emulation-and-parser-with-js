package id.mit.chrono.server.factory;

import id.mit.chrono.server.base.BaseParserGroup;
import id.mit.chrono.server.database.dao.mapparser.MapParserDaoImpl;
import id.mit.chrono.server.model.tables.records.CrmapparserRecord;
import id.mit.chrono.server.obj.ChronoContext;
import id.mit.chrono.server.parser.*;

import java.util.ArrayList;
import java.util.List;

public class ParserGroupFactory {

    private static HuaweiParserGroup huaweiPg;
    private static EricssonParserGroup ericssonPg;
    private static ZteParserGroup ztePg;
    private static NokiaParserGroup nokiaPg;
    private static GenericParserGroup genericPg;

    private static MapParserDaoImpl mapParserDao = DaoFactory.createMapParserDaoImpl();

    public static BaseParserGroup createParserGroup(ChronoContext context, String vendorCode, int vendorId, int maxParallel, int poolSize) {

        List<CrmapparserRecord> mapParsers = mapParserDao.getMapParsersById(vendorId);

        switch (vendorCode) {
            case "HUAWEI":
                return createHuaweiParserGroup(context, mapParsers, maxParallel, poolSize);

            case "ERICSSON":
                return createEricssonParserGroup(context, mapParsers, maxParallel, poolSize);

            case "ZTE":
                return createZteParserGroup(context, mapParsers, maxParallel, poolSize);

            case "NOKIA":
                return createNokiaParserGroup(context, mapParsers, maxParallel, poolSize);

            case "GENERIC":
                return createGenericParserGroup(context, mapParsers, maxParallel, poolSize);
        }

        return null;
    }

    public static void startParse(ArrayList<String> sequence) {

        for (String s: sequence) {


            System.out.println(s);
            switch (s) {
                case "HUAWEI":
                    huaweiPg.startParse();
                    break;

                case "ERICSSON":
                    ericssonPg.startParse();
                    break;

                case "ZTE":
                    ztePg.startParse();
                    break;

                case "NOKIA":
                    nokiaPg.startParse();
                    break;

                case "GENERIC":
                    genericPg.startParse();
                    break;
            }
        }
    }

    private static HuaweiParserGroup createHuaweiParserGroup(ChronoContext context, List<CrmapparserRecord> mapParsers, int maxParallel, int poolSize) {
        if (huaweiPg == null) {
            huaweiPg = new HuaweiParserGroup(context, 1, mapParsers, maxParallel, poolSize);
        }
        return huaweiPg;
    }

    private static EricssonParserGroup createEricssonParserGroup(ChronoContext context, List<CrmapparserRecord> mapParsers, int maxParallel, int poolSize) {
        if (ericssonPg == null) {
            ericssonPg =  new EricssonParserGroup(context, 2, mapParsers, maxParallel, poolSize);
        }
        return ericssonPg;
    }

    private static ZteParserGroup createZteParserGroup(ChronoContext context, List<CrmapparserRecord> mapParsers, int maxParallel, int poolSize) {
        if (ztePg == null) {
            ztePg = new ZteParserGroup(context, 3, mapParsers, maxParallel, poolSize);
        }
        return ztePg;
    }

    private static NokiaParserGroup createNokiaParserGroup(ChronoContext context, List<CrmapparserRecord> mapParser, int maxParallel, int poolSize) {
        if (nokiaPg == null) {
            nokiaPg = new NokiaParserGroup(context, 4, mapParser, maxParallel, poolSize);
        }
        return nokiaPg;
    }

    private static GenericParserGroup createGenericParserGroup(ChronoContext context, List<CrmapparserRecord> mapParser, int maxParallel, int poolSize) {
        if (genericPg == null) {
            genericPg = new GenericParserGroup(context, 5, mapParser, maxParallel, poolSize);
        }
        return genericPg;
    }
}

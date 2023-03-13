package id.mit.chrono.server.factory;

import id.mit.chrono.server.base.BaseFileExtractor;
import id.mit.chrono.server.extractor.EricssonExtractor;
import id.mit.chrono.server.extractor.HuaweiExtractor;
import id.mit.chrono.server.extractor.NokiaExtractor;
import id.mit.chrono.server.extractor.ZteExtractor;
import id.mit.chrono.server.iface.Extractor;
import id.mit.chrono.server.iface.ExtractorCallback;
import id.mit.chrono.server.obj.ChronoContext;
import id.mit.chrono.server.obj.HDFSCl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExtractorFactory {

    private static Logger logger = LoggerFactory.getLogger(ExtractorFactory.class);

//    public static BaseFileExtractor createExtractor(ChronoContext context, String vendorCode, ExtractorCallback callback, HDFSCl dfs) {
//
//        switch (vendorCode) {
//
//            case "HUAWEI":
//                return new HuaweiExtractor(context, callback, dfs);
//
//            case "ERICSSON":
//                return new EricssonExtractor(context, callback, dfs);
//
//            case "ZTE":
//                return new ZteExtractor(context, callback, dfs);
//
//            case "NOKIA":
//                return new NokiaExtractor(context, callback, dfs);
//
//
//        }
//
//        return null;
//
//    }

    public static Extractor getExtractorByClassName(String name) {

        try {
            Class cls = Class.forName(name);
            return (Extractor) cls.newInstance();
        } catch (Exception e) {
            logger.debug(e.getLocalizedMessage());
            e.printStackTrace();
        }

        return null;

    }

}

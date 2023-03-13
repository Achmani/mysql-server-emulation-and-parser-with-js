package id.mit.chrono.server.service;

import id.mit.chrono.server.database.dao.settings.SettingsDaoImpl;
import id.mit.chrono.server.factory.DaoFactory;
import id.mit.chrono.server.iface.Loader;
import id.mit.chrono.server.iface.Mapper;
import id.mit.chrono.server.iface.ParserGroupCallback;
import id.mit.chrono.server.obj.ChronoContext;
import id.mit.chrono.server.obj.DrillCl;
import id.mit.chrono.server.obj.HDFSCl;
import id.mit.chrono.server.obj.PreparatorResultGroup;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LoaderService {

    private Logger logger = LoggerFactory.getLogger(LoaderService.class);

    private List<PreparatorResultGroup> resultGroups;
    private SettingsDaoImpl settingsDao;
    private String HDFS_BASE_DIR;
    private ChronoContext context;
    private DrillCl drillCl;

    private ParserGroupCallback pgc;

    private HDFSCl dfs;

    public LoaderService(ChronoContext context, List<PreparatorResultGroup> resultGroups, HDFSCl dfs, DrillCl drillCl, ParserGroupCallback pgc) {

        this.resultGroups = resultGroups;
        this.dfs = dfs;
        this.settingsDao = DaoFactory.createSettingsDaoImpl();
        this.context = context;
        this.drillCl = drillCl;

        this.pgc = pgc;


        String currentDate = context.getTIMEGROUP().substring(0, context.getTIMEGROUP().length()-4);

        this.HDFS_BASE_DIR = settingsDao.getSingleSettings("HDFS", "HDFS_BASE_DIR").getSettingsValue() + currentDate;

    }


    public void process() {

        logger.debug("LoaderService.process()");

        resultGroups.forEach(result -> {

            String entityGroup = result.getEntityGroup();
            String loaderClass = DaoFactory.getWorkflowDaoImpl().getWorkflowByEntity(entityGroup, 4).getWorkflowClass();

            Loader loader = getLoaderByClassName(loaderClass);

            if (loader != null) {
                loader.setDrillClient(drillCl);
//                loader.setQueries(result.getQueryEntity());
                loader.setResultGroup(result);
                loader.setContext(context);
                loader.setParserGroupCallback(pgc);
                loader.start();
            }

        });
    }

    private Loader getLoaderByClassName(String className) {

        System.out.println("try to get Loader: " + className);

        try {
            Class cls = Class.forName(className);
            return (Loader) cls.newInstance();
        } catch (Exception e) {
            logger.debug(e.getLocalizedMessage());
            e.printStackTrace();
        }


        return null;
    }
}

package id.mit.chrono.server.main;

import id.mit.chrono.server.base.BaseMain;
import id.mit.chrono.server.database.DatabaseHelper;
import id.mit.chrono.server.model.tables.records.CrdatasourceRecord;
import id.mit.chrono.server.model.tables.records.CrdatasourceRecord;
import id.mit.chrono.server.model.tables.records.ErgcellmapRecord;
import id.mit.chrono.server.obj.DownloadGroup;
import id.mit.chrono.server.util.SystemUtils;
import org.apache.commons.cli.*;
import org.apache.commons.lang3.StringUtils;
import org.jooq.DSLContext;
import org.jooq.Result;
import org.jooq.SelectConditionStep;

import java.util.Arrays;

import static id.mit.chrono.server.model.Tables.*;

public class Collector extends BaseMain {

    private boolean REPLACE = false;
    private DSLContext db;

    public Collector(String[] args){

        logger.info("new instance initiated with param: " + StringUtils.join(args, " "));

        boolean argIsOk = this.parseArguments(args);

        if(!argIsOk){

            logger.debug("exiting with -1 status..");
            System.exit(-1);
        }

        db = DatabaseHelper.connectDB();

        SystemUtils.logSystemInfo(logger);

        getTask();

        getDataSources();
    }

    public static void main(String[] args){
        new Collector(args);
    }

    private boolean parseArguments(String[] args) {

        // sample arguments: -g CM_RAN -tg 201804300900 -r

        // help
        options.addOption("h", "help", false, "show help.");

        // group
        options.addOption("g", "group", true, "groups: CM_RAN|CM_CORE|CM_TRANSPORT|INVENTORY_RAN");

        // time group
        options.addOption("tg", "time group", true, "time group (yyyyMMddHHmm)");

        // replace raw file if exist
        options.addOption("r", "replace", false, "replace old file if exist");

        options.addOption("t", "timeout", true, "timeout in ms");

        Option dsOption = new Option("ds", "data-source", true, "specified data source name(s) , ex: \"OSSSVR1 OSSSVR2\"");
        dsOption.setArgs(10);
        options.addOption(dsOption);

        CommandLineParser parser = new GnuParser();

        try {

            CommandLine cmd = parser.parse(options, args);

            if(cmd.getOptions().length==0){
                showHelp();
            }

            if(cmd.hasOption("h")){
                showHelp();
            }

            if(cmd.hasOption("g")){

                logger.debug("found 'g': " + cmd.getOptionValue("g", null));
                context.setGROUP(cmd.getOptionValue("g", null));

                if(context.getGROUP() != null && !Arrays.asList(new String[]{"CM_RAN","CM_CORE","CM_TRANSPORT", "INVENTORY_RAN"}).contains(context.getGROUP())){

                    throw new ParseException("invalid group: " + context.getGROUP());
                }
            }

            if(cmd.hasOption("tg")){

                logger.debug("found 'tg': " + cmd.getOptionValue("tg", null));
                context.setTIMEGROUP(cmd.getOptionValue("tg", null));

                context.setGroupDate(dValidator.validate(context.getTIMEGROUP(), "yyyyMMddHHmm"));

                if(context.getGroupDate() == null){
                    throw new ParseException("invalid yyyyMMddHHmm format: " + context.getTIMEGROUP());
                }
            }

            if(cmd.hasOption("r")){

                logger.debug("found 'r'");
                REPLACE = true;
            }

            if(cmd.hasOption("t")){

                logger.debug("found 't': " + cmd.getOptionValue("t", null));

                try{
                    int x = Integer.parseInt(cmd.getOptionValue("g", "0"));
                    TIMEOUT = x;
                }
                catch(Exception e){

                }
            }

            if(cmd.hasOption("ds")){
                dataSources = cmd.getOptionValues("ds");
                if(dataSources.length==0){
                    dataSources = null;
                }
            }

        } catch (ParseException e) {
            logger.error(e.getMessage());
            e.printStackTrace();
            return false;
        }

        if(context.getGROUP() == null || context.getTIMEGROUP() == null){

            showHelp();

            return false;
        }

        return true;
    }

    private void getDataSources(){

        SelectConditionStep select = db.selectFrom(CRDATASOURCE)
                .where(CRDATASOURCE.DATASOURCE_DATAGROUP.equal(context.getDATAGROUP_ID()))
                .and(CRDATASOURCE.DATASOURCE_ENABLED.isTrue());

        if(dataSources != null && dataSources.length > 0){
            select.and(CRDATASOURCE.DATASOURCE_NAME.in(dataSources));
        }

        Result<CrdatasourceRecord> result = select.fetch();

        if(result.size() > 0){

            DownloadGroup dg = new DownloadGroup(db, context, REPLACE);
            dg.process(result, TIMEOUT);
        }
    }
}

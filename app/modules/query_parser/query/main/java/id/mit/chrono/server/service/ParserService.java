package id.mit.chrono.server.service;

import id.mit.chrono.server.base.BaseFileExtractor;
import id.mit.chrono.server.database.DatabaseHelper;
import id.mit.chrono.server.factory.DaoFactory;
import id.mit.chrono.server.database.dao.mapparser.MapParserDaoImpl;
import id.mit.chrono.server.database.dao.timecatalog.TimeCatalogDaoImpl;
import id.mit.chrono.server.factory.ExtractorFactory;
import id.mit.chrono.server.factory.ParserGroupFactory;
import id.mit.chrono.server.iface.FileParser;
import id.mit.chrono.server.iface.FileParserCallback;
import id.mit.chrono.server.iface.Parser;
import id.mit.chrono.server.iface.ParserGroupCallback;
import id.mit.chrono.server.model.tables.Crmapparser;
import id.mit.chrono.server.model.tables.records.CrmapparserRecord;
import id.mit.chrono.server.model.tables.records.CrtimecatalogRecord;
import id.mit.chrono.server.obj.ChronoContext;
import id.mit.chrono.server.obj.HDFSCl;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static id.mit.chrono.server.model.Tables.*;

public class ParserService {

    private ChronoContext context;
    private Result<Record> files;
    private ParserGroupCallback pgc;

    private MapParserDaoImpl mapParserDao;
    private Logger logger = LoggerFactory.getLogger(ParserService.class);
    private int maxParallelPerParser = 50;
    private int poolSize = 10;
    private boolean reProcess = false;

    private HDFSCl dfs;

    private int jobs = 50;

    private ArrayList<String> listVendor = new ArrayList<>();

    public ParserService(ChronoContext context, Result<Record> files, ParserGroupCallback pgc, int poolSize, boolean reProcess) {

        this.reProcess = reProcess;
        this.context = context;
        this.files = files;
        this.pgc = pgc;
        this.poolSize = poolSize;

        mapParserDao = DaoFactory.createMapParserDaoImpl();
    }

    public void setMaxParallelPerParser(int maxParallelPerParser) {

        this.maxParallelPerParser = maxParallelPerParser;
    }

    public ParserService(ChronoContext context, Result<Record> files, boolean reProcess, int jobs, HDFSCl dfs) {

        this.context = context;
        this.files = files;
        this.reProcess = reProcess;
        this.jobs = jobs;
        this.dfs = dfs;
    }

    public void process() {

        setupTimeCatalog();

        int totalSkip = 0;

        for (Record file: files) {

            if (!reProcess &&
                    file.getValue(CRCOLLECTORTASKFILES.COLLECTORTASKFILES_PROCESSTIME) != null &&
                    file.getValue(CRCOLLECTORTASKFILES.COLLECTORTASKFILES_PROCESSTIME, Integer.class) != 0) {

                totalSkip++;

                continue;
            }

            int vendorId = file.getValue(CRVENDOR.VENDOR_ID);
            String vendorCode = file.getValue(CRVENDOR.VENDOR_CODE);

            if (!listVendor.contains(vendorCode)) {
                logger.debug("added id.mit.chrono.server.parser with new group: " + vendorCode);
                listVendor.add(vendorCode);
            }

            // looking for vendor-level group object
            Parser vendorParserGroup = findParserGroup(vendorId, vendorCode);
            vendorParserGroup.setParserGroupCallback(pgc);

            long fileSize = file.getValue(CRCOLLECTORTASKFILES.COLLECTORTASKFILES_SIZE);
            long fileId = file.getValue(CRCOLLECTORTASKFILES.COLLECTORTASKFILES_ID);

            if (fileSize > 0) {

                String fileName = file.getValue(CRCOLLECTORTASKFILES.COLLECTORTASKFILES_LOCALFILENAME);
                String filePath = file.getValue(CRCOLLECTORTASKFILES.COLLECTORTASKFILES_LOCALDIR) + File.separator + fileName;
                String fileChecksum = file.getValue(CRCOLLECTORTASKFILES.COLLECTORTASKFILES_CHECKSUM);

                logger.debug("processing file id: " + fileId);

                vendorParserGroup.addFile(fileId, fileName, filePath, fileSize, fileChecksum);

            } else {
                logger.debug("found empty file: "+ fileId);
            }
        }

        logger.debug("total skipped file(s): " + totalSkip);

        logger.debug("Vendor parse order: " + listVendor);
        ParserGroupFactory.startParse(listVendor);

    }

    private List<CrmapparserRecord> getVendorMapParsers(int vendorId) {
        return mapParserDao.getMapParsersById(vendorId);
    }

    // TODO: create unit test for findParserGroup
    private Parser findParserGroup(int vendorId, String vendorCode) {

        return ParserGroupFactory.createParserGroup(context, vendorCode, vendorId, maxParallelPerParser, poolSize);

    }

    private void setupTimeCatalog() {
        if(context.getDATAGROUP_ID() == 1){

            // store first for monitoring purpose (admin only item)
            TimeCatalogDaoImpl timeCatalogDao = DaoFactory.createTimeCatalogDaoImpl();

            CrtimecatalogRecord tcr = timeCatalogDao.getSingleTimeCatalog(context.getDATAGROUP_ID(), context.getEpochTime());

            if (tcr == null) {
                tcr = timeCatalogDao.insertTimeCatalog(context.getEpochTime(), context.getDATAGROUP_ID());
                logger.debug("preparing new time catalog: " + tcr.getTimecatalogId() + "|" + tcr.getTimecatalogDate());
            }

        }
    }
}

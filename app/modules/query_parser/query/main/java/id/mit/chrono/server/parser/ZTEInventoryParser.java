package id.mit.chrono.server.parser;

import id.mit.chrono.server.base.BaseFileParser;
import id.mit.chrono.server.iface.FileParser;
import id.mit.chrono.server.obj.HuaweiBasicKeyParamsObj;
import id.mit.chrono.server.obj.ZteBasicKeyParamsObj;
import id.mit.chrono.server.var.Vars;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ZTEInventoryParser extends BaseFileParser implements FileParser {

    @Override
    protected void parseLocal() {

        prepareBase();

        if (files.size() == 1) {

            String file = this.files.get(0).getAbsolutePath();

            logger.debug("processing: " + file);

            this.sourceFile.setKey("minos-inventory");

            try {
                Reader reader = Files.newBufferedReader(Paths.get(file));
                CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT
                        .withFirstRecordAsHeader()
                        .withIgnoreHeaderCase()
                        .withTrim());

                Set<String> headers = csvParser.getHeaderMap().keySet();

                for (CSVRecord csvRecord : csvParser) {

                    HashMap<String, String> params = new HashMap<String, String>();

                    for (String header : headers) {
                        params.put(header, csvRecord.get(header));
                    }

                    this.sourceFile.addResult(new ZteBasicKeyParamsObj("Inventory_minos", params));
                }

                updateFileProcessTime(1, null);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}


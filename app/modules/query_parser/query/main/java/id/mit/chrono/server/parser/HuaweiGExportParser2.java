package id.mit.chrono.server.parser;

import id.mit.chrono.server.base.BaseFileParser;
import id.mit.chrono.server.iface.FileParser;
import id.mit.chrono.server.obj.HuaweiBasicKeyParamsObj;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class HuaweiGExportParser2 {

    private File inputFile;
    protected Logger logger = LoggerFactory.getLogger(this.getClass());
    private Map<String, List<HuaweiBasicKeyParamsObj>> groupHwKeyParams;

    public HuaweiGExportParser2(File inputFile) {

        this.inputFile = inputFile;

    }

    public Map<String, List<HuaweiBasicKeyParamsObj>> parse() {

        logger.debug("parsing file: " + inputFile.getName());

        try {

            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();
            HuaweiGExportHandler userHandler = new HuaweiGExportHandler();
            saxParser.parse(inputFile, userHandler);

            // get result from GExport Handler and group it
            this.groupHwKeyParams = userHandler.hwKeyParams.stream().collect(Collectors.groupingBy(o -> o.command));


        } catch (Exception e) {

            logger.debug("parse failed: " + e.getMessage() + inputFile.getName());

            e.printStackTrace();
        }

        return this.groupHwKeyParams;

    }

    class HuaweiGExportHandler extends DefaultHandler {

        ArrayList<String> paths = new ArrayList<>();
        String pathString = "";

        String command;
        HashMap<String, String> params = new HashMap<String, String>();

        String keyName= "name";
        String keyValue= "value";
        String keyEnbFunc = "ENODEBFUNCTION_BTS3900";
        String keyEnbId = "ENODEBID";
        String keyPath = "bulkCmConfigDataFile.configData.class.object.class.object.parameter";
        String keyPath2 = "bulkCmConfigDataFile.configData.class.object.class";

        List<HuaweiBasicKeyParamsObj> hwKeyParams = new ArrayList<>();


        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

            paths.add(qName);

            if (!pathString.isEmpty()) {
                pathString += ".";
            }

            pathString += qName;

            if (pathString.equals(keyPath2)) {
                command = attributes.getValue("name");
            }

            if (pathString.equals(keyPath)) {

                params.put(attributes.getValue(keyName), attributes.getValue(keyValue));
            }

        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {


            paths.remove(paths.size()-1);
            if(pathString.contains(".")){
                pathString = pathString.substring(0, pathString.lastIndexOf('.'));
            }
            else{
                pathString = "";
            }

            if(pathString.equals("bulkCmConfigDataFile.configData.class.object.class")){

                if(command != null && params.size() != 0){

                    this.hwKeyParams.add(new HuaweiBasicKeyParamsObj(command, params));

                }

                params = new HashMap<>();
            }
            else if(pathString.equals("bulkCmConfigDataFile.configData.class.object")){

                command = null;
            }

        }
    }


}

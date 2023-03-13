package id.mit.chrono.server.parser;

import id.mit.chrono.server.base.BaseFileParser;
import id.mit.chrono.server.iface.FileParser;
import id.mit.chrono.server.obj.HuaweiBasicKeyParamsObj;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

public class HuaweiGExportParser extends BaseFileParser implements FileParser {

    @Override
    protected void parseLocal(){

        prepareBase();

        if(files.size() == 1){

            String file = this.files.get(0).getAbsolutePath();

            System.out.println("---->>> " + file);

            try {
//                File inputFile = new File("/Users/affan/GExport_SPN068MM1_TSEL_SubBOSungaiPenuh_10.156.6.122_20210211013412.xml.gz");
                File inputFile = new File(file);
                SAXParserFactory factory = SAXParserFactory.newInstance();
                SAXParser saxParser = factory.newSAXParser();
                HuaweiGExportHandler userhandler = new HuaweiGExportHandler();
                saxParser.parse(inputFile, userhandler);

//                System.out.println("Size: " + result.size());
//
//                for (int i = 0; i < result.size(); i++) {
//
//                    HuaweiBasicKeyParamsObj obj = (HuaweiBasicKeyParamsObj) result.get(i);
//
//                    System.out.print(obj.command + " -> " + obj.params.size() + " ==> ");
//
//                    for (String key: obj.params.keySet()){
//                        System.out.print(key + ":" + obj.params.get(key) + " | ");
//                    }
//
//                    System.out.println();
//
//                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args){

        new HuaweiGExportParser().parseLocal();
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

        String filter = "CELLLTEFLEXBW_BTS3900";
        String filter2 = "CELLLTEFLEXBW_BTS5900";

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

            paths.add(qName);
            if(!pathString.isEmpty()){
                pathString += ".";
            }
            pathString += qName;

//            System.out.println("-> " + pathString);

            if(pathString.equals(keyPath2)){
                command = attributes.getValue("name");
            }

            if(pathString.equals(keyPath)){

                // apply specific filter
                if (command.equals(filter) || command.equals(filter2)) {
                    params.put(attributes.getValue(keyName), attributes.getValue(keyValue));
                }

                if(command.equalsIgnoreCase(keyEnbFunc) && attributes.getValue(keyName).equalsIgnoreCase(keyEnbId)){

                    String key = attributes.getValue("value");
                    logger.debug("found key: " + key);
                    HuaweiGExportParser.this.sourceFile.setKey(key);
                }
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {

            paths.remove(paths.size()-1);
            if(pathString.indexOf(".") != -1){
                pathString = pathString.substring(0, pathString.lastIndexOf('.'));
            }
            else{
                pathString = "";
            }

//            System.out.println("-> " + pathString);

            if(pathString.equals("bulkCmConfigDataFile.configData.class.object.class")){

                if(command != null && params.size() != 0){

                    HuaweiGExportParser.this.sourceFile.addResult(new HuaweiBasicKeyParamsObj(command, params));
//                    System.out.println("command: " + command + " -> " + params);
//                    System.out.println("_... > " + result.size());
                }

                params = new HashMap<>();
            }
            else if(pathString.equals("bulkCmConfigDataFile.configData.class.object")){

                command = null;
            }
        }

        @Override
        public void characters(char ch[], int start, int length) throws SAXException {}
    }
}

package id.mit.chrono.server.parser;

import id.mit.chrono.server.base.BaseFileParser;
import id.mit.chrono.server.iface.FileParser;
import id.mit.chrono.server.obj.NokBasicTagParamsObj;
import org.xml.sax.Attributes;
import org.xml.sax.EntityResolver;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.HashMap;

public class NokiaInventorySbtsParser extends BaseFileParser implements FileParser {
    boolean timeToCapture = false;

    String className;
    String propertyName = null;
    HashMap<String, String> params = new HashMap<>();

    StringBuffer buff = new StringBuffer();

    @Override
    protected void parseLocal() {

        prepareBase();
        this.sourceFile.setKey("INVT_NOKIA");

//        files.add(new File("/Users/wildan/Projects/Chrono/Chrono-Server/data/raw/CM_RAN/201806120900/CM_RAN_NOK_10.53.201.148/d/oss/global/var/racops/export/hirarki_bsc_rc14_211433_120618.xml"));

        if (files.size() == 1) {

            String file = this.files.get(0).getAbsolutePath();

//            System.out.println("Processing yyy : " + file);

            try {

                File inputFile = new File(file);
                SAXParserFactory factory = SAXParserFactory.newInstance();
                factory.setValidating(false);
                SAXParser saxParser = factory.newSAXParser();
                NokiaInventorySbtsParser.NokiaRacopsHandler userhandler = new NokiaInventorySbtsParser.NokiaRacopsHandler();
                saxParser.parse(inputFile, userhandler);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {

        new NokiaInventorySbtsParser().parseLocal();
    }

    class DummyEntityResolver implements EntityResolver {

        public InputSource resolveEntity(String publicID, String systemID) throws SAXException {
            return new InputSource(new StringReader(""));
        }
    }

    class NokiaRacopsHandler extends DefaultHandler {

        ArrayList<String> paths = new ArrayList<>();
        String pathString = "";

        String command;
        HashMap<String, String> params = new HashMap<String, String>();

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

            paths.add(qName);
            if (!pathString.isEmpty()) {
                pathString += ".";
            }
            pathString += qName;

            if (pathString.equals("Inventory.InventoryUnitHw.managedObject")) {

                className = attributes.getValue("class");

                params = new HashMap<>();

                for (int i = 0; i < attributes.getLength(); i++) {

                    if (!attributes.getQName(i).equals("class")) {

                        params.put(attributes.getQName(i), attributes.getValue(i));
                    }
                }
            } else if (pathString.equals("Inventory.InventoryUnitHw.managedObject.p")) {

                propertyName = attributes.getValue("name");
                buff = new StringBuffer();
                timeToCapture = true;
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {

            paths.remove(paths.size() - 1);
            if (pathString.indexOf(".") != -1) {
                pathString = pathString.substring(0, pathString.lastIndexOf('.'));
            } else {
                pathString = "";
            }

            if (timeToCapture && pathString.equals("Inventory.InventoryUnitHw.managedObject")) {

                timeToCapture = false;

                params.put(propertyName, buff.toString());

                propertyName = null;
            }

            if (pathString.equals("Inventory.InventoryUnitHw")) {

                if (className != null) {

                    sourceFile.addResult(new NokBasicTagParamsObj(className, params));
                }
            }
        }

        @Override
        public void characters(char ch[], int start, int length) throws SAXException {

            if (timeToCapture) {
                buff.append(ch, start, length);
            }
        }

        @Override
        public InputSource resolveEntity(String publicId, String systemId) throws IOException, SAXException {

            return new InputSource(new StringReader(""));

        }
    }
}


package id.mit.chrono.server.test;

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

public class XmlParser {


    StringBuffer buff = new StringBuffer();

    protected void parseLocal(String[] args){

//        String file = "/Users/wildan/Projects/Chrono/Chrono-Server/data/raw/CM_RAN/201806120900/CM_RAN_ER_10.164.118.196/var/opt/ericsson/clarity/arne/ARNE_ran6adm2_20180612_060000.xml";
//        String file = "/Users/wildan/Projects/Chrono/Chrono-Server/data/raw/CM_RAN/201806120900/CM_RAN_ER_10.2.81.203/var/opt/ericsson/clarity/xml/3g_ran1admbld01_RNDUM04_20180612_040735.xml";
//        String file = "/Users/wildan/Projects/Chrono/Chrono-Server/data/raw/CM_RAN/201806120900/CM_RAN_HW_10.52.204.81/opt/oss/server/var/fileint/cm/GExport/GExport_MBSC_Bawen_10.5.148.194_20180612051434.xml";
//        String file = "/Users/wildan/Projects/Chrono/Chrono-Server/data/raw/CM_RAN/201806120900/CM_RAN_ER_10.164.118.196/home/nmsadm/dataCM/log_lte/LTE_Padang_20180612.xml.1528790678217";
//        String file = "/Users/wildan/Projects/Chrono/TestData/Ericsson/ENM/CM_3GPP.xml";
        String file = "/Users/wildan/Projects/Chrono/TestData/Ericsson/20190517/LTE_EnodeB_20190517_04.xml";

        if(args.length > 0){
            file = args[0];
        }

//        String file = "/Users/wildan/Projects/Chrono/TestData/Ericsson/RNGST01.xml";

        try {

            File inputFile = new File(file);
            SAXParserFactory factory = SAXParserFactory.newInstance();
            factory.setValidating(false);
            SAXParser saxParser = factory.newSAXParser();
            MyHandler userhandler = new MyHandler();
            saxParser.parse(inputFile, userhandler);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args){

        new XmlParser().parseLocal(args);
    }

    class DummyEntityResolver implements EntityResolver {

        public InputSource resolveEntity(String publicID, String systemID) throws SAXException {
            return new InputSource(new StringReader(""));
        }
    }

    class MyHandler extends DefaultHandler {

        ArrayList<String> paths = new ArrayList<>();
        String pathString = "";

        String command;
        HashMap<String, String> params = new HashMap<String, String>();

        boolean captureData = false;

        long level = -1;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

            paths.add(qName);
            if(!pathString.isEmpty()){
                pathString += ".";
            }
            pathString += qName;
            level++;

            String toPrint = "";

            for (int i = 0; i < attributes.getLength(); i++) {

                if(i>0){
                    toPrint += ",";
                }

                toPrint += attributes.getLocalName(i) + "(" + attributes.getValue(i) + ")";
            }

            System.out.print("\n+[" + level + "] " + pathString + " -> " + toPrint);

            buff = new StringBuffer();
            captureData = true;
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
            level--;

            System.out.print(buff.toString());

            captureData = false;


            System.out.print("\n-[" + level + "] " + pathString);
        }

        @Override
        public void characters(char ch[], int start, int length) throws SAXException {

            if(captureData){
                buff.append(ch, start, length);
            }
        }

        @Override
        public InputSource resolveEntity(String publicId, String systemId) throws IOException, SAXException {

            return new InputSource(new StringReader(""));
        }
    }
}

package id.mit.chrono.server.parser;

import id.mit.chrono.server.base.BaseFileParser;
import id.mit.chrono.server.iface.FileParser;
import id.mit.chrono.server.obj.ErBasicTagParamsObj;
import id.mit.chrono.server.obj.SourceFile;
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

public class Ericsson3gRncParser extends BaseFileParser implements FileParser {

    boolean timeToCapture = false;

    String rncName;
    String propertyName = null;
    String vsDataType;
    HashMap<String, String> params = new HashMap<>();

    StringBuffer buff = new StringBuffer();

    @Override
    protected void parseLocal(){

        prepareBase();

        this.sourceFile.setKey("3GRNC_ERICSSON");

//        this.sourceFile = new SourceFile(0L, 0, null, 0, null);
//        files.add(new File("/Users/wildan/Projects/Chrono/TestData/Ericsson/RNGST01.xml"));

        if(files.size() == 1){

            String file = this.files.get(0).getAbsolutePath();

            System.out.println("Processing: " + file);

            try {

                File inputFile = new File(file);
                SAXParserFactory factory = SAXParserFactory.newInstance();
                factory.setValidating(false);
                SAXParser saxParser = factory.newSAXParser();
                Ericsson3gBulkCmHandler userhandler = new Ericsson3gBulkCmHandler();
                saxParser.parse(inputFile, userhandler);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args){

        new Ericsson3gRncParser().parseLocal();
    }

    class DummyEntityResolver implements EntityResolver {

        public InputSource resolveEntity(String publicID, String systemID) throws SAXException {
            return new InputSource(new StringReader(""));
        }
    }

    class Ericsson3gBulkCmHandler extends DefaultHandler {

        ArrayList<String> paths = new ArrayList<>();
        String pathString = "";

        String command;
        HashMap<String, String> params = new HashMap<String, String>();

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

            paths.add(qName);
            if(!pathString.isEmpty()){
                pathString += ".";
            }
            pathString += qName;

            if(pathString.equals("bulkCmConfigDataFile.configData.xn:SubNetwork.xn:SubNetwork.xn:MeContext")){

                rncName = attributes.getValue("id");

                sourceFile.setKey(rncName);
                logger.debug("found key: " + rncName);
//                System.out.println("set rnc name");
            }
            else if(pathString.equals("bulkCmConfigDataFile.configData.xn:SubNetwork.xn:SubNetwork.xn:MeContext.xn:VsDataContainer.xn:attributes.es:vsDataMeContext") ||
                    pathString.equals("bulkCmConfigDataFile.configData.xn:SubNetwork.xn:SubNetwork.xn:MeContext.xn:ManagedElement") ||
                    pathString.equals("bulkCmConfigDataFile.configData.xn:SubNetwork.xn:SubNetwork.xn:MeContext.xn:ManagedElement.un:RncFunction.un:UtranCell") ||
                    pathString.equals("bulkCmConfigDataFile.configData.xn:SubNetwork.xn:SubNetwork.xn:MeContext.xn:ManagedElement.un:RncFunction.un:IubLink")){

                // put here since new object/MO contained in "MEContext"
                params = new HashMap<>();
                params.put("id", attributes.getValue("id"));

//                System.out.println("init params: " + pathString);
            }
            else if(pathString.startsWith("bulkCmConfigDataFile.configData.xn:SubNetwork.xn:SubNetwork.xn:MeContext.xn:VsDataContainer.xn:attributes.es:vsDataMeContext.") ||
                    pathString.startsWith("bulkCmConfigDataFile.configData.xn:SubNetwork.xn:SubNetwork.xn:MeContext.xn:ManagedElement.xn:attributes.")){

                propertyName = qName;
                buff = new StringBuffer();
                timeToCapture = true;
            }
            else if(pathString.startsWith("bulkCmConfigDataFile.configData.xn:SubNetwork.xn:SubNetwork.xn:MeContext.xn:ManagedElement.un:RncFunction.un:UtranCell.un:attributes.") ||
                    pathString.startsWith("bulkCmConfigDataFile.configData.xn:SubNetwork.xn:SubNetwork.xn:MeContext.xn:ManagedElement.un:RncFunction.un:IubLink.un:attributes.")){

                propertyName = qName;
                buff = new StringBuffer();
                timeToCapture = true;
            }
            else if(pathString.startsWith("bulkCmConfigDataFile.configData.xn:SubNetwork.xn:SubNetwork.xn:MeContext.xn:ManagedElement.un:RncFunction.un:attributes.")){

                propertyName = qName;
                buff = new StringBuffer();
                timeToCapture = true;
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

            // to capture
            if(timeToCapture && (pathString.equals("bulkCmConfigDataFile.configData.xn:SubNetwork.xn:SubNetwork.xn:MeContext.xn:VsDataContainer.xn:attributes.es:vsDataMeContext") ||
                                 pathString.equals("bulkCmConfigDataFile.configData.xn:SubNetwork.xn:SubNetwork.xn:MeContext.xn:ManagedElement.xn:attributes") ||
                                 pathString.equals("bulkCmConfigDataFile.configData.xn:SubNetwork.xn:SubNetwork.xn:MeContext.xn:ManagedElement.un:RncFunction.un:UtranCell.un:attributes") ||
                                 pathString.equals("bulkCmConfigDataFile.configData.xn:SubNetwork.xn:SubNetwork.xn:MeContext.xn:ManagedElement.un:RncFunction.un:IubLink.un:attributes") ||
                                 pathString.equals("bulkCmConfigDataFile.configData.xn:SubNetwork.xn:SubNetwork.xn:MeContext.xn:ManagedElement.un:RncFunction.un:attributes"))){

//                System.out.println("saving to params: " + pathString);
                timeToCapture = false;

                params.put(propertyName, buff.toString());

                propertyName = null;
            }

            // to close the deal
            if(pathString.equals("bulkCmConfigDataFile.configData.xn:SubNetwork.xn:SubNetwork.xn:MeContext.xn:VsDataContainer") ||
                    pathString.equals("bulkCmConfigDataFile.configData.xn:SubNetwork.xn:SubNetwork.xn:MeContext.xn:ManagedElement") ||
                    pathString.equals("bulkCmConfigDataFile.configData.xn:SubNetwork.xn:SubNetwork.xn:MeContext.xn:ManagedElement.un:RncFunction.un:UtranCell") ||
                    pathString.equals("bulkCmConfigDataFile.configData.xn:SubNetwork.xn:SubNetwork.xn:MeContext.xn:ManagedElement.un:RncFunction.un:IubLink") ||
                    pathString.equals("bulkCmConfigDataFile.configData.xn:SubNetwork.xn:SubNetwork.xn:MeContext.xn:ManagedElement.un:RncFunction")){

                if(rncName != null){

                    sourceFile.addResult(new ErBasicTagParamsObj("xn:MeContext", params));

//                    System.out.println("rncName: " + rncName + ", params (" + params.size() + "): ");

                    for(String key: params.keySet()){

                        System.out.println("\t" + key + " -> " + params.get(key));
                    }
                    System.out.println();
                }
            }
        }

        @Override
        public void characters(char ch[], int start, int length) throws SAXException {

            if(timeToCapture){
                buff.append(ch, start, length);
            }
        }

        @Override
        public InputSource resolveEntity(String publicId, String systemId) throws IOException, SAXException {

            return new InputSource(new StringReader(""));

        }
    }
}


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

public class Ericsson3gBulkCmParser extends BaseFileParser implements FileParser {

    boolean timeToCapture = false;

    String subNetworkId;
    String meContextId;
    String IubLinkId;
    String UtranCellId;
    String propertyName = null;
    String vsDataType;
    HashMap<String, String> params = new HashMap<>();

    StringBuffer buff = new StringBuffer();

    @Override
    protected void parseLocal(){

        prepareBase();
        this.sourceFile.setKey("3GBULKCM_ERICSSON");

//        this.sourceFile = new SourceFile(0L, 0, null, 0, null);
//        files.add(new File("/Users/wildan/Projects/Chrono/TestData/Ericsson/LTE/log_lte/LTE_Aceh_20190313.xml"));

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

        new Ericsson3gBulkCmParser().parseLocal();
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
        HashMap<String, String> params2 = new HashMap<String, String>();
        HashMap<String, String> params3 = new HashMap<String, String>();

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

            paths.add(qName);
            if(!pathString.isEmpty()){
                pathString += ".";
            }
            pathString += qName;

            if(pathString.equals("bulkCmConfigDataFile.configData.xn:SubNetwork.xn:SubNetwork.xn:MeContext.xn:ManagedElement.xn:VsDataContainer.xn:VsDataContainer.xn:attributes.es:vsDataEUtranCellFDD")){

                // put here since new object/MO contained in "MEContext"
                params2 = new HashMap<>();
                params2.put("xn:SubNetwork", subNetworkId);
                params2.put("xn:MeContext", meContextId);
            }
            else if(pathString.equals("bulkCmConfigDataFile.configData.xn:SubNetwork.xn:SubNetwork.xn:MeContext.xn:ManagedElement.un:RncFunction.un:UtranCell")){

                UtranCellId = attributes.getValue("id");

                // put here since new object/MO contained in "MEContext"
                params2 = new HashMap<>();
                params2.put("un:UtranCell", UtranCellId);
                params2.put("xn:SubNetwork", subNetworkId);
                params2.put("xn:MeContext", meContextId);
            }
            else if(qName.equals("un:iubLinkUtranCell")){

                // since it is a multi-value thing
                // put here since new object/MO contained in "MEContext"
                params3 = new HashMap<>();
                params3.put("un:IubLink", IubLinkId);
                params3.put("xn:SubNetwork", subNetworkId);
                params3.put("xn:MeContext", meContextId);

                propertyName = qName;
                buff = new StringBuffer();
                timeToCapture = true;
            }
            else if(pathString.equals("bulkCmConfigDataFile.configData.xn:SubNetwork.xn:SubNetwork.xn:MeContext.xn:ManagedElement.un:RncFunction.un:IubLink")){

                IubLinkId = attributes.getValue("id");

                // put here since new object/MO contained in "MEContext"
                params2 = new HashMap<>();
                params2.put("un:IubLink", IubLinkId);
                params2.put("xn:SubNetwork", subNetworkId);
                params2.put("xn:MeContext", meContextId);
            }
            else if(pathString.startsWith("bulkCmConfigDataFile.configData.xn:SubNetwork.xn:SubNetwork.xn:MeContext.xn:ManagedElement.xn:VsDataContainer.xn:VsDataContainer.xn:attributes.es:vsDataEUtranCellFDD.")){

                propertyName = qName;
                buff = new StringBuffer();
                timeToCapture = true;
            }
            else if(pathString.startsWith("bulkCmConfigDataFile.configData.xn:SubNetwork.xn:SubNetwork.xn:MeContext.xn:ManagedElement.un:RncFunction.un:IubLink.")){

                propertyName = qName;
                buff = new StringBuffer();
                timeToCapture = true;
            }
            else if(pathString.equals("bulkCmConfigDataFile.configData.xn:SubNetwork.xn:SubNetwork.xn:MeContext")){

                //pathString.equals("bulkCmConfigDataFile.configData.xn:SubNetwork.xn:SubNetwork.xn:MeContext.xn:ManagedElement.un:RncFunction.un:UtranCell")

                // get MeContextId
                meContextId = attributes.getValue("id");

                // put here since new object/MO contained in "MEContext"
                params = new HashMap<>();
                params.put("xn:SubNetwork", subNetworkId);
                params.put("xn:MeContext", meContextId);
            }
            else if(pathString.startsWith("bulkCmConfigDataFile.configData.xn:SubNetwork.xn:SubNetwork.xn:MeContext.")){

                propertyName = qName;
                buff = new StringBuffer();
                timeToCapture = true;
            }
            else if(pathString.equals("bulkCmConfigDataFile.configData.xn:SubNetwork.xn:SubNetwork")){

                // get SubNetwork
                subNetworkId = attributes.getValue("id");
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

            // for param capture
            if(timeToCapture && qName.equals("un:iubLinkUtranCell")){

                timeToCapture = false;

                if(!buff.toString().isEmpty()){

                    params3.put(propertyName, buff.toString());
                }

                propertyName = null;


                sourceFile.addResult(new ErBasicTagParamsObj("un:iubLinkUtranCell", params2));

//                System.out.println("++ un:iubLinkUtranCell: " + meContextId + ", params3 (" + params3.size() + "): ");
//
//                for(String key: params3.keySet()){
//
//                    System.out.println("\t" + key + " -> " + params3.get(key));
//                }
//                System.out.println();

            }
            else if(timeToCapture && qName.equals("es:vsDataEUtranCellFDD")){

                timeToCapture = false;

                if(!buff.toString().isEmpty()){

                    params3.put(propertyName, buff.toString());
                }

                propertyName = null;


                sourceFile.addResult(new ErBasicTagParamsObj("es:vsDataEUtranCellFDD", params2));

//                System.out.println("++ un:iubLinkUtranCell: " + meContextId + ", params3 (" + params3.size() + "): ");
//
//                for(String key: params3.keySet()){
//
//                    System.out.println("\t" + key + " -> " + params3.get(key));
//                }
//                System.out.println();

            }
            else if(timeToCapture && (pathString.startsWith("bulkCmConfigDataFile.configData.xn:SubNetwork.xn:SubNetwork.xn:MeContext.xn:ManagedElement.un:RncFunction.un:UtranCell."))){

                timeToCapture = false;

                if(!buff.toString().isEmpty()){

                    params2.put(propertyName, buff.toString());
                }

                propertyName = null;
            }
            else if(timeToCapture && (pathString.startsWith("bulkCmConfigDataFile.configData.xn:SubNetwork.xn:SubNetwork.xn:MeContext.xn:ManagedElement.un:RncFunction.un:IubLink."))){

                timeToCapture = false;

                if(!buff.toString().isEmpty()){

                    params2.put(propertyName, buff.toString());
                }

                propertyName = null;
            }

            else if(timeToCapture && (pathString.startsWith("bulkCmConfigDataFile.configData.xn:SubNetwork.xn:SubNetwork.xn:MeContext."))){

                timeToCapture = false;

                if(!buff.toString().isEmpty()){

                    params.put(propertyName, buff.toString());
                }

                propertyName = null;
            }


            // for closing
            if(pathString.equals("bulkCmConfigDataFile.configData.xn:SubNetwork.xn:SubNetwork.xn:MeContext.xn:ManagedElement.un:RncFunction.un:UtranCell")){

                if(params2.size() > 0){

                    sourceFile.addResult(new ErBasicTagParamsObj("un:UtranCell", params2));

//                    System.out.println("++ un:UtranCell: " + UtranCellId + ", params2 (" + params2.size() + "): ");
//
//                    for(String key: params2.keySet()){
//
//                        System.out.println("\t" + key + " -> " + params2.get(key));
//                    }
//                    System.out.println();
                }
            }
            else if(pathString.equals("bulkCmConfigDataFile.configData.xn:SubNetwork.xn:SubNetwork.xn:MeContext.xn:ManagedElement.un:RncFunction.un:IubLink.un:iubLinkUtranCell")){

                if(params3.size() > 0){

                    sourceFile.addResult(new ErBasicTagParamsObj("un:iubLinkUtranCell", params3));

//                    System.out.println("++ un:IubLink: " + meContextId + ", params3 (" + params3.size() + "): ");
//
//                    for(String key: params3.keySet()){
//
//                        System.out.println("\t" + key + " -> " + params3.get(key));
//                    }
//                    System.out.println();
                }
            }
            else if(pathString.equals("bulkCmConfigDataFile.configData.xn:SubNetwork.xn:SubNetwork.xn:MeContext.xn:ManagedElement.un:RncFunction.un:IubLink")){


                if(params.size() > 0){

                    sourceFile.addResult(new ErBasicTagParamsObj("un:IubLink", params2));

//                    System.out.println("++ un:IubLink: " + meContextId + ", params2 (" + params2.size() + "): ");
//
//                    for(String key: params2.keySet()){
//
//                        System.out.println("\t" + key + " -> " + params2.get(key));
//                    }
//                    System.out.println();
                }
            }
            else if(pathString.equals("bulkCmConfigDataFile.configData.xn:SubNetwork.xn:SubNetwork")){


                if(params.size() > 0){

                    sourceFile.addResult(new ErBasicTagParamsObj("xn:MeContext", params));

//                    System.out.println("++ xn:MeContext: " + meContextId + ", params (" + params.size() + "): ");
//
//                    for(String key: params.keySet()){
//
//                        System.out.println("\t" + key + " -> " + params.get(key));
//                    }
//                    System.out.println();
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


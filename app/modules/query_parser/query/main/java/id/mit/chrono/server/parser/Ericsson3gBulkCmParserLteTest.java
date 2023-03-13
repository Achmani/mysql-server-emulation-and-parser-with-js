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

public class Ericsson3gBulkCmParserLteTest extends BaseFileParser implements FileParser {

    boolean timeToCapture = false;

    String subNetworkId;
    String meContextId;
    String propertyName = null;
    String dataContainerId = null;
    String vsDataType;
    HashMap<String, String> params = new HashMap<>();
    HashMap<String, String> params2 = new HashMap<>();
    HashMap<String, String> params3 = new HashMap<>();
    HashMap<String, String> params4 = new HashMap<>();

    StringBuffer buff = new StringBuffer();

    HashMap<String, String> lastVsDataType = new HashMap<String, String>();

    @Override
    protected void parseLocal(){

        if(!true){

            prepareBase();
            this.sourceFile.setKey("3GBULKCM_ERICSSON");
        }
        else{

            this.sourceFile = new SourceFile(0L, 0, null, 0, null);
            files.add(new File("/Users/wildan/Projects/Chrono/TestData/Ericsson/20190517/LTE_EnodeB_20190517_04.xml"));
        }

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

        new Ericsson3gBulkCmParserLteTest().parseLocal();
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

        long level = 0;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

            paths.add(qName);
            if(!pathString.isEmpty()){
                pathString += ".";
            }
            pathString += qName;
            level++;

            if(pathString.startsWith("bulkCmConfigDataFile.configData.xn:SubNetwork.xn:SubNetwork.xn:MeContext.xn:ManagedElement.xn:VsDataContainer.xn:VsDataContainer.xn:attributes.")){

                propertyName = qName;
                buff = new StringBuffer();
                timeToCapture = true;
            }
            else if(pathString.equals("bulkCmConfigDataFile.configData.xn:SubNetwork.xn:SubNetwork.xn:MeContext.xn:ManagedElement.xn:VsDataContainer.xn:VsDataContainer.xn:attributes")){

                String id = attributes.getValue("id");

                // put here since new object/MO contained in "MEContext"
                params4 = new HashMap<>();
                params4.put("xn:SubNetwork", subNetworkId);
                params4.put("xn:MeContext", meContextId);
                params4.put("vsDataContainerId", dataContainerId);
            }
            else if(pathString.equals("bulkCmConfigDataFile.configData.xn:SubNetwork.xn:SubNetwork.xn:MeContext.xn:ManagedElement.xn:VsDataContainer.xn:VsDataContainer")){

                dataContainerId = attributes.getValue("id");
            }
            else if(pathString.startsWith("bulkCmConfigDataFile.configData.xn:SubNetwork.xn:SubNetwork.xn:MeContext.xn:ManagedElement.xn:VsDataContainer.xn:attributes.")){

                propertyName = qName;
                buff = new StringBuffer();
                timeToCapture = true;
            }
            else if(pathString.equals("bulkCmConfigDataFile.configData.xn:SubNetwork.xn:SubNetwork.xn:MeContext.xn:ManagedElement.xn:VsDataContainer.xn:attributes")){

                // put here since new object/MO contained in "MEContext"
                params3 = new HashMap<>();
                params3.put("xn:SubNetwork", subNetworkId);
                params3.put("xn:MeContext", meContextId);
            }
            else if(pathString.startsWith("bulkCmConfigDataFile.configData.xn:SubNetwork.xn:SubNetwork.xn:MeContext.xn:ManagedElement.xn:attributes.")){

                propertyName = qName;
                buff = new StringBuffer();
                timeToCapture = true;
            }
            else if(pathString.equals("bulkCmConfigDataFile.configData.xn:SubNetwork.xn:SubNetwork.xn:MeContext.xn:ManagedElement")){

                // put here since new object/MO contained in "MEContext"
                params2 = new HashMap<>();
                params2.put("xn:SubNetwork", subNetworkId);
                params2.put("xn:MeContext", meContextId);
            }
            else if(pathString.startsWith("bulkCmConfigDataFile.configData.xn:SubNetwork.xn:SubNetwork.xn:MeContext.xn:attributes.")){

                propertyName = qName;
                buff = new StringBuffer();
                timeToCapture = true;
            }
            else if(pathString.equals("bulkCmConfigDataFile.configData.xn:SubNetwork.xn:SubNetwork.xn:MeContext")){

                // get MeContextId
                meContextId = attributes.getValue("id");

                // put here since new object/MO contained in "MEContext"
                params = new HashMap<>();
                params.put("xn:SubNetwork", subNetworkId);
                params.put("xn:MeContext", meContextId);
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

            level++;

            if(timeToCapture && propertyName.equals("xn:vsDataType")){

                lastVsDataType.put(pathString, buff.toString());

            }

            if(timeToCapture && (pathString.startsWith("bulkCmConfigDataFile.configData.xn:SubNetwork.xn:SubNetwork.xn:MeContext.xn:ManagedElement.xn:VsDataContainer.xn:VsDataContainer.xn:attributes."))){
                timeToCapture = false;

                if(!buff.toString().isEmpty() && !pathString.contains("es:additionalPlmnList")){

                    params4.put(propertyName, buff.toString());
                }

                propertyName = null;
            }
            else if(timeToCapture && (pathString.startsWith("bulkCmConfigDataFile.configData.xn:SubNetwork.xn:SubNetwork.xn:MeContext.xn:ManagedElement.xn:VsDataContainer.xn:attributes."))){

                timeToCapture = false;

                if(!buff.toString().isEmpty()){

                    params3.put(propertyName, buff.toString());
                }

                propertyName = null;
            }
            else if(timeToCapture && (pathString.equals("bulkCmConfigDataFile.configData.xn:SubNetwork.xn:SubNetwork.xn:MeContext.xn:ManagedElement.xn:attributes"))){

                timeToCapture = false;

                if(!buff.toString().isEmpty()){

                    params2.put(propertyName, buff.toString());
                }

                propertyName = null;
            }
            else if(timeToCapture && (pathString.equals("bulkCmConfigDataFile.configData.xn:SubNetwork.xn:SubNetwork.xn:MeContext.xn:attributes"))){

                timeToCapture = false;

                if(!buff.toString().isEmpty()){

                    params.put(propertyName, buff.toString());
                }

                propertyName = null;
            }

            // for closing
            if(pathString.equals("bulkCmConfigDataFile.configData.xn:SubNetwork.xn:SubNetwork.xn:MeContext.xn:ManagedElement.xn:VsDataContainer.xn:VsDataContainer.xn:attributes")){

                if(params4.size() > 5){

                    String vsDataType = lastVsDataType.get(pathString);
                    params4.put("xn:vsDataType", vsDataType);

                    final HashMap<String, String> params = new HashMap<>();
                    params.putAll(params4);

                    sourceFile.addResult(new ErBasicTagParamsObj(vsDataType, params));

//                    System.out.println("++ "+vsDataType+": " + meContextId + ", params4 (" + params4.size() + "): ");
//
//                    for(String key: params4.keySet()){
//
//                        System.out.println("\t" + key + " -> " + params4.get(key));
//                    }
//                    System.out.println();

                    params4.clear();
                }
            }
            else if(pathString.equals("bulkCmConfigDataFile.configData.xn:SubNetwork.xn:SubNetwork.xn:MeContext.xn:ManagedElement.xn:VsDataContainer.xn:attributes")){

                if(params3.size() > 5){

                    String vsDataType = lastVsDataType.get(pathString);
                    params3.put("xn:vsDataType", vsDataType);

//                    System.out.println("params3.size(): " + params3.size());

                    final HashMap<String, String> params = new HashMap<>();
                    params.putAll(params3);

                    sourceFile.addResult(new ErBasicTagParamsObj(vsDataType, params));

//                    System.out.println("++ "+vsDataType+": " + meContextId + ", params3 (" + params3.size() + "): ");
//
//                    for(String key: params3.keySet()){
//
//                        System.out.println("\t" + key + " -> " + params3.get(key));
//                    }
//                    System.out.println();

                    params3.clear();
                }
            }
            else if(pathString.equals("bulkCmConfigDataFile.configData.xn:SubNetwork.xn:SubNetwork.xn:MeContext.xn:ManagedElement")){

                if(params2.size() > 2){

                    final HashMap<String, String> params = new HashMap<>();
                    params.putAll(params2);

                    sourceFile.addResult(new ErBasicTagParamsObj("ManagedElement", params));

//                    System.out.println("++ ManagedElement: " + meContextId + ", params2 (" + params2.size() + "): ");
//
//                    for(String key: params2.keySet()){
//
//                        System.out.println("\t" + key + " -> " + params2.get(key));
//                    }
//                    System.out.println();

                    params2.clear();
                }
            }
            else if(pathString.equals("bulkCmConfigDataFile.configData.xn:SubNetwork.xn:SubNetwork.xn:MeContext")){

                if(params.size() > 2){

//                    final HashMap<String, String> params = new HashMap<>();
//                    params.putAll(this.params);

                    sourceFile.addResult(new ErBasicTagParamsObj("MeContext", params));

                    System.out.println("MeContext: " + meContextId + ", params (" + params.size() + "): ");

                    for(String key: params.keySet()){

                        System.out.println("\t" + key + " -> " + params.get(key));
                    }
                    System.out.println();

//                    params.clear();
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


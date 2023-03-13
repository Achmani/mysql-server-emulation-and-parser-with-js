package id.mit.chrono.server.parser;

import id.mit.chrono.server.base.BaseFileParser;
import id.mit.chrono.server.iface.FileParser;
import id.mit.chrono.server.obj.ErBasicTagParamsObj;
import id.mit.chrono.server.obj.HuaweiBasicKeyParamsObj;
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

public class EricssonArneParser extends BaseFileParser implements FileParser {

    String rootEntity1 = "Model.Create.SubNetwork.ManagedElement";
    String rootEntity1Attr = "sourceType";
    int rootEntity1Length;
    HashMap<String, String> rootEntity1Attrs = new HashMap<>();
    boolean rootEntity1Started = false;

    String rootEntity2 = "ManagedElementId";
    String rootEntity2Attr = "string";
    boolean rootEntity2Started = false;

    String rootEntityCanceler = "Model.Create.SubNetwork";
    @Override
    protected void parseLocal(){

        rootEntity1Length = rootEntity1.length();

        prepareBase();

//        files.add(new File("/Users/wildan/Projects/Chrono/Chrono-Server/data/raw/CM_RAN/201806120900/CM_RAN_ER_10.164.118.196/var/opt/ericsson/clarity/arne/ARNE_ran6adm2_20180612_060000.xml"));

        if(files.size() == 1){

            String file = this.files.get(0).getAbsolutePath();

            try {

                File inputFile = new File(file);
                SAXParserFactory factory = SAXParserFactory.newInstance();
                factory.setValidating(false);
                SAXParser saxParser = factory.newSAXParser();
                EricssonArneHandler userhandler = new EricssonArneHandler();
                saxParser.parse(inputFile, userhandler);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args){

        new EricssonArneParser().parseLocal();
    }

    class DummyEntityResolver implements EntityResolver {

        public InputSource resolveEntity(String publicID, String systemID) throws SAXException {
            return new InputSource(new StringReader(""));
        }
    }

    class EricssonArneHandler extends DefaultHandler {

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

//            System.out.println("-> " + pathString);

            if(pathString.equals(rootEntity1)){

                rootEntity1Started = true;

                // loop search for attribute
                for (int i = 0; i < attributes.getLength(); i++) {
                    rootEntity1Attrs.put(qName + "." + attributes.getLocalName(i), attributes.getValue(i));
                }

                return;
            }

            if(rootEntity1Started && qName.equals(rootEntity2)){

                rootEntity2Started = true;

                for (int i = 0; i < attributes.getLength(); i++) {
                    rootEntity1Attrs.put(qName + "." + attributes.getLocalName(i), attributes.getValue(i));
                }

                return;
            }

            if(!rootEntity2Started){

                return;
            }

            // no need to keep tag without attribute(s)
            if(attributes.getLength() == 0){
                return;
            }

            String tag = pathString.substring(rootEntity1Length + 1); //
//            String tag = pathString;

            if(usedSourceGroups.contains(tag)){

                HashMap<String, String> params = new HashMap<>();

                // copy from the "parent"
                params.putAll(rootEntity1Attrs);

                for (int i = 0; i < attributes.getLength(); i++) {
                    params.put(attributes.getLocalName(i), attributes.getValue(i));
                }

                String attr = "";

                for(String key: params.keySet()){

                    if(!attr.isEmpty()){

                        attr += " ~ ";
                    }

                    attr += key + ":" + params.get(key);
                }

                //                System.out.println("adding: " + tag +  " >> " + params.size() + " ~~~ " + attr);
                sourceFile.addResult(new ErBasicTagParamsObj(tag, params));
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

            if(pathString.equals(rootEntityCanceler)){
                rootEntity2Started = false;
                rootEntity1Started = false;

                // clear saved keys;
                rootEntity1Attrs.clear();

//                System.out.println("---------------------------------------------");
            }

//            if(pathString.equals("bulkCmConfigDataFile.configData.class.object.class")){
//
//                if(command != null && params.size() != 0){
//
//                    EricssonArneParser.this.sourceFile.addResult(new HuaweiBasicKeyParamsObj(command, params));
////                    System.out.println("_... > " + result.size());
//                }
//
//                params = new HashMap<>();
//            }
//            else if(pathString.equals("bulkCmConfigDataFile.configData.class.object")){
//
//                command = null;
//            }
        }

        @Override
        public void characters(char ch[], int start, int length) throws SAXException {}

        @Override
        public InputSource resolveEntity(String publicId, String systemId) throws IOException, SAXException {

            return new InputSource(new StringReader(""));

//            if (systemId.contains("arne17_0.dtd")) {
//                return new InputSource(new StringReader(""));
//            } else {
//                return null;
//            }
        }
    }
}

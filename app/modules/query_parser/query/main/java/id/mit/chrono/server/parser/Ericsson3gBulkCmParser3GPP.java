package id.mit.chrono.server.parser;

import id.mit.chrono.server.base.BaseFileParser;
import id.mit.chrono.server.iface.EricssonCallBack;
import id.mit.chrono.server.iface.FileParser;
import id.mit.chrono.server.obj.BodaBulkCMParser;
import id.mit.chrono.server.obj.ErBasicTagParamsObj;
import id.mit.chrono.server.obj.SourceFile;
import org.xml.sax.EntityResolver;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.HashMap;

public class Ericsson3gBulkCmParser3GPP extends BaseFileParser implements FileParser, EricssonCallBack {

    boolean timeToCapture = false;

    String subNetworkId;
    String meContextId;
    String IubLinkId;
    String UtranCellId;
    String propertyName = null;
    String vsDataType;
    HashMap<String, String> params = new HashMap<>();

    private ArrayList<String> printedMos = new ArrayList<String>();

    @Override
    protected void parseLocal(){

        prepareBase();
        this.sourceFile.setKey("3GBULKCM_ERICSSON");

//        this.sourceFile = new SourceFile(0L, 0, null, 0, null);
//        files.add(new File("/Users/wildan/Projects/Chrono/TestData/Ericsson/20190517/RNNAD06_20190520_04.xml"));
//        files.add(new File("/Users/wildan/Projects/Chrono/TestData/Ericsson/20190517/RNGST01.xml"));
//        files.add(new File("/Users/wildan/Projects/Chrono/TestData/Ericsson/ENM/CM_3GPP.xml"));
//        files.add(new File("/Users/wildan/Projects/Chrono/TO CHECK/20210818/CM_3gpp_BSC.xml"));

        if(files.size() == 1){

            String file = this.files.get(0).getAbsolutePath();

            System.out.println("Processing: " + file);

            try{

                BodaBulkCMParser cmParser = new BodaBulkCMParser(this);

                cmParser.setDataSource(file);

                cmParser.parse();

                cmParser.closeMOPWMap();

                cmParser = null;

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void newErBasicTagParamsObj(ErBasicTagParamsObj obj){

//        System.out.println("get: " + obj.tag);

        if(usedSourceGroups.contains(obj.tag)){

            sourceFile.addResult(obj);
        }

//        if(!printedMos.contains(obj.tag)){
//
//            printedMos.add(obj.tag);
//
//            System.out.println("++ mo: " + obj.tag + ", params (" + obj.params.size() + "): ");
//
//            for(String key: obj.params.keySet()){
//
//                System.out.println("\t" + key + " -> " + obj.params.get(key));
//            }
//            System.out.println();
//        }
    }

    public static void main(String[] args){

        new Ericsson3gBulkCmParser3GPP().parseLocal();
    }

    class DummyEntityResolver implements EntityResolver {

        public InputSource resolveEntity(String publicID, String systemID) throws SAXException {
            return new InputSource(new StringReader(""));
        }
    }


}


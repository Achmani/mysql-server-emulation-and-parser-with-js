package id.mit.chrono.server.parser;

import id.mit.chrono.server.base.BaseFileParser;
import id.mit.chrono.server.iface.FileParser;
import id.mit.chrono.server.obj.ErBasicTagParamsObj;
import id.mit.chrono.server.obj.HuaweiBasicKeyParamsObj;
import id.mit.chrono.server.util.StringUtils;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ericsson2gMmlParser extends BaseFileParser implements FileParser {

    private ArrayList<String> supportedCommands = new ArrayList<>();

    private HashMap<String, String> mmlData = new HashMap<>();

    private String CMD_RXMOP_MOTY_RXOTG = "RXMOP:MOTY=RXOTG;";
    private String CMD_RXTCP_MOTY_RXOTG = "RXTCP:MOTY=RXOTG;";

    private String CMD_RXMOP_MOTY_RXSTG = "RXMOP:MOTY=RXSTG;";
    private String CMD_RXTCP_MOTY_RXSTG = "RXTCP:MOTY=RXSTG;";

    private String CMD_RLDEP_CELL_ALL = "RLDEP:CELL=ALL;";

    private String CMD_RXMOP_MOTY_RXOTRX = "RXMOP:MOTY=RXOTRX;";

    @Override
    protected void parseLocal(){

        prepareBase();

        // RSITEs
        supportedCommands.add(CMD_RXMOP_MOTY_RXOTG);
        // RSITE to CELLs
        supportedCommands.add(CMD_RXTCP_MOTY_RXOTG);
        // new RSITEs
        supportedCommands.add(CMD_RXMOP_MOTY_RXSTG);
        // new RSITE to CELLs
        supportedCommands.add(CMD_RXTCP_MOTY_RXSTG);

        supportedCommands.add(CMD_RLDEP_CELL_ALL);

        // cell to TRX
        supportedCommands.add(CMD_RXMOP_MOTY_RXOTRX);

        logger.debug("files size: " + files.size());

        String commandPattern = "^[<](.*[;])$";
        Pattern p = Pattern.compile(commandPattern);

        String line, command = null, data = null;

        String endCommandPattern = "^END$";

        String identityHeader = "IDENTITY";

        boolean identityFound = false;

        if(files.size() == 1){

            try (BufferedReader br = new BufferedReader(new FileReader(files.get(0)))) {

                while ((line = br.readLine()) != null) {

                    if(!identityFound && line.equals(identityHeader)){

                        line = br.readLine();

                        if(line != null && line.contains("_")){

                            String[] el = line.split("_");

                            if(el.length == 3){

                                this.sourceFile.setKey(el[0]);
                                identityFound = true;
                            }
                        }
                    }
                    else if(line.matches(commandPattern)){

                        command = line.substring(1);

                        if(!supportedCommands.contains(command) || !usedSourceGroups.contains(command)){
                            command = null;
                        }

                        data = "";
                    }
                    else if(line.matches(endCommandPattern) && command != null){

                        logger.debug("add command: " + command + " with result: " + data.length() + " char(s)");
//                        mmlData.put(command, data);

                        if(command.equalsIgnoreCase(CMD_RXMOP_MOTY_RXOTG)){
                            this.process_CMD_RXMOP_MOTY_RXOTG(data);
                        }
                        else if(command.equalsIgnoreCase(CMD_RXMOP_MOTY_RXSTG)){
                            this.process_CMD_RXMOP_MOTY_RXSTG(data);
                        }
                        else if(command.equalsIgnoreCase(CMD_RLDEP_CELL_ALL)){
                            this.process_CMD_RLDEP_CELL_ALL(data);
                        }
                        else if(command.equalsIgnoreCase(CMD_RXTCP_MOTY_RXOTG)){
                            this.process_CMD_RXTCP_MOTY_RXOTG(data);
                        }
                        else if(command.equalsIgnoreCase(CMD_RXTCP_MOTY_RXSTG)){
                            this.process_CMD_RXTCP_MOTY_RXSTG(data);
                        }
                        else if(command.equalsIgnoreCase(CMD_RXMOP_MOTY_RXOTRX)){
                            this.process_CMD_RXMOP_MOTY_RXOTRX(data);
                        }

                        command = null;
                        data = null;
                    }
                    else if(command != null){

                        data += "\n" + line;
                    }
                }
                updateFileProcessTime(1, null);
            } catch (Exception e) {
                updateFileProcessTime(3, e.getMessage());
                logger.debug("parse failed: "  + e.getMessage() + ": " + sourceFile.getFilePath());
                e.printStackTrace();
            }

        }
    }

    private void process_CMD_RXMOP_MOTY_RXOTG(String data){

        String[] headerSet = {"MO RSITE COMB FHOP MODEL",
                "SWVERREPL SWVERDLD SWVERACT TMODE",
                "CONFMD CONFACT TRACO ABISALLOC CLUSTERID SCGR",
                "DAMRCR CLTGINST CCCHCMD",
                "PTA JBSDL PAL JBPTA",
                "TGFID SIGDEL BSSWANTED PACKALG"
        };

        Scanner scanner = new Scanner(data);
        String line;

        HashMap<String, String> params = new HashMap<>();
        String[] temp;
        ArrayList<ArrayList<String>> tempRes;

        while (scanner.hasNextLine()) {

            line = scanner.nextLine();

            for (int i = 0; i < headerSet.length; i++) {

                if(StringUtils.removeDoubleSpace(line.trim()).equals(headerSet[i])){

                    temp = headerSet[i].split(" ");

                    String send = line + "\n" + scanner.nextLine();

//                 System.out.println("+++++++++++++++++");
//                 System.out.println(send);
//                 System.out.println("+++++++++++++++++");

                    tempRes = StringUtils.getTabData(temp, send);

//                    System.out.println("tempRes: " + tempRes.size());

                    if(tempRes.size() > 0){

                        for (int j = 0; j < temp.length; j++) {

//                            System.out.println(temp[j] + " -> " + tempRes.get(0).get(j).trim());
                            params.put(temp[j], tempRes.get(0).get(j).trim());
                        }
                    }

                    if(i == headerSet.length - 1 && !params.isEmpty()){

//                        System.out.println("Adding with " + params.size());

                        // add BSC filter
                        params.put("bscName", this.sourceFile.getKey());
                        sourceFile.addResult(new ErBasicTagParamsObj(CMD_RXMOP_MOTY_RXOTG, params));

                        params = new HashMap<>();
                    }
                }
            }
        }
        scanner.close();
    }

    private void process_CMD_RXMOP_MOTY_RXSTG(String data){

        String[] headerSet = {"MO SECTOR RSITE MODEL",
                "CONFMD CCCHCMD BSSWANTED IMBVAMOS"
        };

        Scanner scanner = new Scanner(data);
        String line;

        HashMap<String, String> params = new HashMap<>();
        String[] temp;
        ArrayList<ArrayList<String>> tempRes;

        while (scanner.hasNextLine()) {

            line = scanner.nextLine();

            for (int i = 0; i < headerSet.length; i++) {

                if(StringUtils.removeDoubleSpace(line.trim()).equals(headerSet[i])){

                    temp = headerSet[i].split(" ");

                    String send = line + "\n" + scanner.nextLine();

//                 System.out.println("+++++++++++++++++");
//                 System.out.println(send);
//                 System.out.println("+++++++++++++++++");

                    tempRes = StringUtils.getTabData(temp, send);

//                    System.out.println("tempRes: " + tempRes.size());

                    if(tempRes.size() > 0){

                        for (int j = 0; j < temp.length; j++) {

//                            System.out.println(temp[j] + " -> " + tempRes.get(0).get(j).trim());
                            params.put(temp[j], tempRes.get(0).get(j).trim());
                        }
                    }

                    if(i == headerSet.length - 1 && !params.isEmpty()){

//                        System.out.println("Adding with " + params.size());

                        // add BSC filter
                        params.put("bscName", this.sourceFile.getKey());
                        sourceFile.addResult(new ErBasicTagParamsObj(CMD_RXMOP_MOTY_RXSTG, params));

                        params = new HashMap<>();
                    }
                }
            }
        }
        scanner.close();
    }

    private void process_CMD_RLDEP_CELL_ALL(String data){

        String[] headerSet = {"CELL CGI BSIC BCCHNO AGBLK MFRMS IRC",
                "TYPE BCCHTYPE FNOFFSET XRANGE CSYSTYPE",
                "CELLIND RAC RIMNACC GAN DFI"
        };

        Scanner scanner = new Scanner(data);
        String line;

        String[] temp;
        ArrayList<ArrayList<String>> tempRes;

        HashMap<String, String> params = new HashMap<>();

        while (scanner.hasNextLine()) {

            line = scanner.nextLine();

            for (int i = 0; i < headerSet.length; i++) {

                if(StringUtils.removeDoubleSpace(line.trim()).equals(headerSet[i])){

                    temp = headerSet[i].split(" ");

                    String send = line + "\n" + scanner.nextLine();

//                 System.out.println("+++++++++++++++++");
//                 System.out.println(send);
//                 System.out.println("+++++++++++++++++");

                    tempRes = StringUtils.getTabData(temp, send);

//                    System.out.println("tempRes: " + tempRes.size());

                    if(tempRes.size() > 0){

                        for (int j = 0; j < temp.length; j++) {

//                            System.out.println(temp[j] + " -> " + tempRes.get(0).get(j).trim());
                            params.put(temp[j], tempRes.get(0).get(j).trim());
                        }
                    }

                    if(i == headerSet.length - 1 && !params.isEmpty()){

//                        System.out.println("Adding with " + params.size());

                        // add BSC filter
                        params.put("bscName", this.sourceFile.getKey());
                        sourceFile.addResult(new ErBasicTagParamsObj(CMD_RLDEP_CELL_ALL, params));

                        params = new HashMap<>();
                    }
                }
            }
        }
        scanner.close();
    }

    private void process_CMD_RXTCP_MOTY_RXOTG(String data){

        String[] headerSet = {"MO CELL CHGR"};

        Scanner scanner = new Scanner(data);
        String line;

        String[] temp;
        ArrayList<ArrayList<String>> tempRes;

        HashMap<String, String> params = new HashMap<>();

        String tempStr;

        while (scanner.hasNextLine()) {

            line = scanner.nextLine();

            for (int i = 0; i < headerSet.length; i++) {

                if(StringUtils.removeDoubleSpace(line.trim()).equals(headerSet[i])){

                    temp = headerSet[i].split(" ");

                    String send = line;

                    // clean data to be processed
                    while (scanner.hasNextLine()){

                        tempStr = scanner.nextLine();

                        if(tempStr.isEmpty()){
                            break;
                        }

                        send += "\n" + tempStr;
                    }

                    tempRes = StringUtils.getTabData(temp, send);

//                    System.out.println("tempRes: " + tempRes.size());

                    if(tempRes.size() > 0){

                        String tempMo = "";

                        for (int j = 0; j < tempRes.size(); j++) {

                            params.clear();

                            for (int k = 0; k < temp.length; k++) {

                                if(temp[k].equals("MO")){

                                    // keep last MO information
                                    if(!tempRes.get(j).get(k).trim().isEmpty()){
                                        tempMo = tempRes.get(j).get(k).trim();
                                    }
                                    else{
                                        tempRes.get(j).set(k, tempMo);
                                    }
                                }

//                                System.out.println(this.sourceFile.getKey() + " >> " + temp[k] + " -> " + tempRes.get(j).get(k).trim());
                                params.put(temp[k], tempRes.get(j).get(k).trim());
                            }

                            // add BSC filter
                            params.put("bscName", this.sourceFile.getKey());
                            sourceFile.addResult(new ErBasicTagParamsObj(CMD_RXTCP_MOTY_RXOTG, params));

                            params = new HashMap<>();
                        }
                    }
                }
            }
        }
        scanner.close();
    }

    private void process_CMD_RXTCP_MOTY_RXSTG(String data){

        String[] headerSet = {"MO CELL CHGR"};

        Scanner scanner = new Scanner(data);
        String line;

        String[] temp;
        ArrayList<ArrayList<String>> tempRes;

        HashMap<String, String> params = new HashMap<>();

        String tempStr;

        while (scanner.hasNextLine()) {

            line = scanner.nextLine();

            for (int i = 0; i < headerSet.length; i++) {

                if(StringUtils.removeDoubleSpace(line.trim()).equals(headerSet[i])){

                    temp = headerSet[i].split(" ");

                    String send = line;

                    // clean data to be processed
                    while (scanner.hasNextLine()){

                        tempStr = scanner.nextLine();

                        if(tempStr.isEmpty()){
                            break;
                        }

                        send += "\n" + tempStr;
                    }

                    tempRes = StringUtils.getTabData(temp, send);

//                    System.out.println("tempRes: " + tempRes.size());

                    if(tempRes.size() > 0){

                        String tempMo = "";

                        for (int j = 0; j < tempRes.size(); j++) {

                            params.clear();

                            for (int k = 0; k < temp.length; k++) {

                                if(temp[k].equals("MO")){

                                    // keep last MO information
                                    if(!tempRes.get(j).get(k).trim().isEmpty()){
                                        tempMo = tempRes.get(j).get(k).trim();
                                    }
                                    else{
                                        tempRes.get(j).set(k, tempMo);
                                    }
                                }

//                                System.out.println(temp[k] + " -> " + tempRes.get(j).get(k).trim());
                                params.put(temp[k], tempRes.get(j).get(k).trim());
                            }

                            // add BSC filter
                            params.put("bscName", this.sourceFile.getKey());
                            sourceFile.addResult(new ErBasicTagParamsObj(CMD_RXTCP_MOTY_RXSTG, params));

                            params = new HashMap<>();
                        }
                    }
                }
            }
        }
        scanner.close();
    }

    private void process_CMD_RXMOP_MOTY_RXOTRX(String data){

        String[] headerSet = {"MO CELL CHGR TEI SIG MCTRI DCP1 SC"};

        Scanner scanner = new Scanner(data);
        String line;

        String[] temp;
        ArrayList<ArrayList<String>> tempRes;

        HashMap<String, String> params = new HashMap<>();

        String tempStr;

        while (scanner.hasNextLine()) {

            line = scanner.nextLine();

            for (int i = 0; i < headerSet.length; i++) {

                if(StringUtils.removeDoubleSpace(line.trim()).equals(headerSet[i])){

                    temp = headerSet[i].split(" ");

                    String send = line;

                    // clean data to be processed
                    while (scanner.hasNextLine()){

                        tempStr = scanner.nextLine();

                        if(tempStr.isEmpty()){
                            break;
                        }

                        send += "\n" + tempStr;
                    }

                    tempRes = StringUtils.getTabData(temp, send);

//                    System.out.println("tempRes: " + tempRes.size());

                    if(tempRes.size() > 0){

                        String tempMo = "";

                        for (int j = 0; j < tempRes.size(); j++) {

                            params.clear();

                            for (int k = 0; k < temp.length; k++) {

                                if(temp[k].equals("MO")){

                                    // keep last MO information
                                    if(!tempRes.get(j).get(k).trim().isEmpty()){
                                        tempMo = tempRes.get(j).get(k).trim();
                                    }
                                    else{
                                        tempRes.get(j).set(k, tempMo);
                                    }
                                }

//                                System.out.println(temp[k] + " -> " + tempRes.get(j).get(k).trim());
                                params.put(temp[k], tempRes.get(j).get(k).trim());
                            }

                            // add BSC filter
                            params.put("bscName", this.sourceFile.getKey());
                            sourceFile.addResult(new ErBasicTagParamsObj(CMD_RXMOP_MOTY_RXOTRX, params));

                            params = new HashMap<>();
                        }
                    }
                }
            }
        }
        scanner.close();
    }
}

package id.mit.chrono.server.parser;

import id.mit.chrono.server.base.BaseFileParser;
import id.mit.chrono.server.iface.FileParser;
import id.mit.chrono.server.obj.HuaweiBasicKeyParamsObj;
import id.mit.chrono.server.var.Vars;

import java.io.*;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HuaweiCfgMmlParser extends BaseFileParser implements FileParser {

    @Override
    protected void parseLocal(){

        prepareBase();

        if(files.size() == 1){

            String file = this.files.get(0).getAbsolutePath();
            String fileName = this.files.get(0).getName();

            String key;

//            logger.debug("processing: " + file);

            Pattern cmfMmlNotePattern = Pattern.compile(Vars.prop.getProperty("id.mit.chrono.server.parser.huawei.cfgmml.patternnote"));
            Pattern cmfMmlPattern = Pattern.compile(Vars.prop.getProperty("id.mit.chrono.server.parser.huawei.cfgmml.patterncmd"));
            Pattern cfgMmlParamPattern = Pattern.compile(Vars.prop.getProperty("id.mit.chrono.server.parser.huawei.cfgmml.patternparam"));
            Matcher matcher;

            String line;
            String command, params;
            String paramName, paramVal;

            try (BufferedReader br = new BufferedReader(new FileReader(new File(file)))) {

                while ((line = br.readLine()) != null) {

//                    System.out.println(line);

                    matcher = cmfMmlPattern.matcher(line);

                    if(matcher.find()){

                        command = matcher.group(1);

                        if(usedSourceGroups.contains(command)){

                            params = matcher.group(2);

                            matcher = cfgMmlParamPattern.matcher(params);

                            HashMap<String, String> tempParam = new HashMap<>();

                            while(matcher.find()){

                                paramName = matcher.group(1);
                                paramVal = matcher.group(2);

                                // for CFG MML, the key is below
                                if(paramName.equals("SYSOBJECTID")){

                                    key = paramVal;
                                    logger.debug("found key: " + key);
                                    this.sourceFile.setKey(key);
                                }

                                if(paramVal.equals("<NULL>") || paramVal.equals("NULL")){
                                    paramVal = null;
                                }

                                tempParam.put(paramName.toUpperCase(), paramVal);
                            }

                            HuaweiBasicKeyParamsObj o = new HuaweiBasicKeyParamsObj(command, tempParam);

                            this.sourceFile.addResult(o);
                        }
                    }else{

                        // try for the note
                        matcher = cmfMmlNotePattern.matcher(line);

                        if(matcher.find()){

                            command = matcher.group(1);

                            if(usedSourceGroups.contains(command)){

                                paramName = "VALUE";
                                paramVal = matcher.group(2);

                                if(paramVal.equals("<NULL>") || paramVal.equals("NULL")){
                                    paramVal = null;
                                }

                                HashMap<String, String> tempParam = new HashMap<>();

                                tempParam.put(paramName, paramVal);

//                            System.out.println("Added -> " + command + ":" + paramVal);

                                HuaweiBasicKeyParamsObj o = new HuaweiBasicKeyParamsObj(command, tempParam);
                                this.sourceFile.addResult(o);
                            }
                        }
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
}

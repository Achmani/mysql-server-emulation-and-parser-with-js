package id.mit.chrono.server.test;


import id.mit.chrono.server.base.BaseFileParser;
import id.mit.chrono.server.obj.HuaweiBasicKeyParamsObj;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.IOException;

public class HuaweiCfgMmlParser extends BaseFileParser {

    protected void parseLocal()  {

        String filePath = this.files.get(0).getPath();

        System.out.println("Parsing: " + filePath);

        Pattern mmlPattern = Pattern.compile("^(.*)[:](.*)[;]$");
        Pattern paramPattern = Pattern.compile("(\\w+)[=][\"]{0,1}(\\w+)[\"]{0,1}");
        Matcher matcher;

        try {

            File f = new File(filePath);

            BufferedReader b = new BufferedReader(new FileReader(f));

            String readLine = "";

            System.out.println("Reading file using Buffered Reader");

            String command, paramString;
            String paramName, paramVal;

            ArrayList<HuaweiBasicKeyParamsObj> mmlObjs = new ArrayList<HuaweiBasicKeyParamsObj>();

            while ((readLine = b.readLine()) != null) {

                matcher = mmlPattern.matcher(readLine);

                if(matcher.find()){

                    command = matcher.group(1);
                    paramString = matcher.group(2);

                    HashMap<String, String> params = new HashMap<String, String>();

//                    System.out.println("Command: " + command + " -> " + paramString);

                    matcher = paramPattern.matcher(paramString);

                    while(matcher.find()){

                        paramName = matcher.group(1);
                        paramVal = matcher.group(2);

                        params.put(paramName, paramVal);
                    }

                    mmlObjs.add(new HuaweiBasicKeyParamsObj(command, params));
                }
            }

            for (int i = 0; i < mmlObjs.size(); i++) {

                System.out.println(mmlObjs.get(i));
            }

            System.out.println("total collected command: " + mmlObjs.size());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
package id.mit.chrono.server.var;

import id.mit.chrono.server.crypt.MCrypt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Properties;

public class Vars {

    public static Properties prop;
//    public static Logger logger;

    static{

//        logger = LoggerFactory.getLogger(Vars.this.getClass());

        prop = new Properties();

        InputStream input = null;

        try {

            input = new FileInputStream(System.getProperty("user.dir") + File.separator + "chrono.properties");

            // load a properties file
            prop.load(input);

            // decrypt data from crono.properties
            MCrypt mc = new MCrypt();

            // encoded properties
            String[] keys = new String[]{"id.mit.chrono.server.db.url","id.mit.chrono.server.db.username","id.mit.chrono.server.db.password"};

            String val;
            for(String s: prop.stringPropertyNames()){

                if(Arrays.asList(keys).contains(s)){

                    val = new String(mc.decrypt(prop.getProperty(s)));
                    prop.setProperty(s, val);
                }
            }

        } catch (Exception e) {
//            logger.error("error reading chrono.properties: " + e.getMessage());
            e.printStackTrace();
            System.exit(-2);
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

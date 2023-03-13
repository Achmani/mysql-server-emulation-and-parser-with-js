package id.mit.chrono.server.obj;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;

public class HDFSCl {

    protected FileSystem fileSystem;

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    protected Configuration conf;

    public HDFSCl(Configuration conf) {
        this.conf = conf;
    }

    public boolean connect() {

        try {

            fileSystem = FileSystem.get(conf);

            logger.debug("connected to DFS: " + conf);

            return true;
        } catch (IOException e) {
            fileSystem = null;
            e.printStackTrace();
        }

        logger.debug("failed connect to DFS: " + conf);

        return false;
    }

    public boolean disconnect(){

        try {

            fileSystem.close();

            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return false;
    }

    public synchronized boolean createDir(String dirPath){

        try {

            Path path = new Path(dirPath);
            fileSystem.mkdirs(path);

            logger.debug("success create dir: " + dirPath);

            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }

        logger.debug("failed create dir: " + dirPath);

        return false;
    }

    public synchronized boolean checkDir(String dirPath) {

        try {
            Path path = new Path(dirPath);
            if (fileSystem.exists(path)) {
                logger.debug("found: " + path);
                return true;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        logger.debug("path not found: " + dirPath);

        return false;
    }

    public synchronized boolean writeFile(String path, String fileName, String content){

        try {

            Path hdfsWritePath = new Path(path + File.separator + fileName);

            FSDataOutputStream fsDataOutputStream = fileSystem.create(hdfsWritePath,true);

            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(fsDataOutputStream, StandardCharsets.UTF_8));
            bufferedWriter.write(content);
            bufferedWriter.newLine();
            bufferedWriter.close();

            logger.debug("success write file: " + path + File.separator + fileName);

            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }

        logger.debug("failed write file: " + path + File.separator + fileName);

        return false;
    }

    public synchronized HashMap<String, Object> writefile(String path, String fileName, File inputFile) {

        HashMap<String, Object> result = new HashMap<>();

        try {
            Path hdfsWritePath = new Path(path + File.separator + fileName);

            FSDataOutputStream fsDataOutputStream = fileSystem.create(hdfsWritePath,true);

            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(fsDataOutputStream, StandardCharsets.UTF_8));

            String line;
            try(BufferedReader br = new BufferedReader(new FileReader(inputFile))) {

                while((line = br.readLine()) != null) {
                    bufferedWriter.write(line);
                    bufferedWriter.newLine();
                }

            } catch (IOException e) {
                e.printStackTrace();
            }

            bufferedWriter.close();
            logger.debug("success write file: " + path + File.separator + fileName);

            result.put("path", hdfsWritePath);
            result.put("processStatus", 1);
            result.put("failedReason", null);

        } catch (IOException e) {
            logger.debug("failed write file: " + path + File.separator + fileName);
            result.put("processStatus", 3);
            result.put("failedReason", e.getLocalizedMessage());

            e.printStackTrace();
        }

        return result;
    }
}

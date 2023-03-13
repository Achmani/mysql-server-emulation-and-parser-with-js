package id.mit.chrono.server.test;

import id.mit.chrono.server.base.BaseMain;

public class HdfsTest extends BaseMain {

    public HdfsTest() {

        if(dfs == null){

            logger.debug("failed to connect to DFS.");
        }
        else{

            logger.debug("successfully connected to DFS.");


//            dfs.createDir("/test/test2");
//            dfs.writeFile("/test/test2", "hallo.txt", "Java API to write data in HDFS");

            dfs.checkDir("/test/test2");

        }
    }

    public static void main(String[] args) {

        HdfsTest dfs = new HdfsTest();

    }
}

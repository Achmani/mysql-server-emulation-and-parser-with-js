package id.mit.chrono.server.obj;

import java.sql.*;

public class DrillCl {

    private String className;
    private String connectionString;

    private Connection connection;
    private Statement st;


    public DrillCl(String className, String connectionString) {

        this.className = className;
        this.connectionString = connectionString;

        this.connect();
    }

    public boolean connect(){

        try {
            Class.forName(className);

            connection = DriverManager.getConnection(connectionString);
            st = connection.createStatement();

            return true;

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


    public void test(){

        try {
            ResultSet rs = st.executeQuery("SELECT * FROM TABLE(hdfs.`/drill_data/LACIMA/2020121109_DataOSS_3G.csv`(type => 'text', fieldDelimiter => ';'))");

            while(rs.next()){
                System.out.println(rs.getString(1));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet execQuery(String query) {

        try {

            ResultSet rs;

            // create new Statement object to prevent query canceled due to overriden object.
//            Statement st = connection.createStatement();

            rs = st.executeQuery(query);

            return rs;


        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

}

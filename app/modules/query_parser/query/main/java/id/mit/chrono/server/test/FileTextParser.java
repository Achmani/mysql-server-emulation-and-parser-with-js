package id.mit.chrono.server.test;

import java.io.*;

public class FileTextParser {


    public FileTextParser() {
        System.out.println("Hello world");
        File file = new File("/Users/irwinferdiansyah/Documents/document kantor/chrono/2g_ran1adm02bld_20190126_060001.txt");

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String st;
            while ((st = br.readLine()) != null) {
                System.out.println(st);
//                String[] split = st.split(" ");
//                System.out.println("count : "+split.length);
            }


        } catch (
                FileNotFoundException e)

        {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        new FileTextParser();
    }
}

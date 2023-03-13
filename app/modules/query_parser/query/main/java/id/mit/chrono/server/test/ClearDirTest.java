package id.mit.chrono.server.test;

import id.mit.chrono.server.util.FileUtils;

import java.io.File;
import java.util.Scanner;

public class ClearDirTest {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter directory to clean (if more than 1 separate with ','): ");
        String[] dirs = {scanner.nextLine()};

        if (dirs[0].contains(",")) {
            dirs = dirs[0].split(",");
        }

//        File[] files = {
//                new File("../production/data/tmp"),
//                new File("../production/data/tmp2"),
//                new File("../production/data/tmp3")
//        };

        String basePath = "../production/data";
        for (int i = 0; i < dirs.length; i++) {
            File toDelete = new File(basePath + File.separator + dirs[i]);
            rmdir2(toDelete);
        }
    }

    private static void rmdir2(File toDelete) {

        System.out.println("removing: "+toDelete.getAbsolutePath());

        if (toDelete != null) {

            File[] allContent = toDelete.listFiles();
            if (allContent != null) {

                for (File file: allContent) {
                    rmdir2(file);
                }

            }

            if (toDelete.isDirectory()) {
                FileUtils.removeDirectory(toDelete);
            } else {
                toDelete.delete();
            }

        }

    }
}

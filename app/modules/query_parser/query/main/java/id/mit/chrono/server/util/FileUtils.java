package id.mit.chrono.server.util;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileUtils {

    private static Logger logger = LoggerFactory.getLogger(FileUtils.class);

    public static String getMd5(File file){

        String result = SystemUtils.executeCli("md5sum " + file.getPath());
        return result.split(" ")[0];
    }

    public static String getMd52(File file){

        FileInputStream fileInputStream = null;

        String md5 = null;

        //calculate hash
        try {

            Path path = file.toPath();
            System.out.println(">" + file.getPath());
            byte[] data = Files.readAllBytes(path);

            md5 = DigestUtils.md5Hex(data);

        } catch (Exception e) {
            logger.debug("md5 failed: " + e.getMessage());
            e.printStackTrace();
        } finally {

            if(fileInputStream != null){

                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return md5;
    }

    public static File copyFile(File file, File targetDir) {

        String newPath = targetDir.getAbsolutePath() + File.separator + file.getName();

        File targetFile = new File(newPath);

        if (targetFile.exists()) {
            return targetFile;
        }

        try {

            Path result = null;

            result = Files.copy(Paths.get(file.getAbsolutePath()), Paths.get(newPath));

            if (result != null) {
                return result.toFile();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static File moveFile(File file, File targetDir) {

        String newPath = targetDir.getAbsolutePath() + File.separator + file.getName();

        File targetFile = new File(newPath);

        if (targetFile.exists()) {
            return targetFile;
        }

        try {

            Path result = null;

            result = Files.move(Paths.get(file.getAbsolutePath()), Paths.get(newPath));

            if (result != null) {
                return result.toFile();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static String extensionDetector(String fileName) {

        String extension = fileName.substring(fileName.lastIndexOf(".") + 1);

        if (StringUtils.isNumeric(extension)) {
            extensionDetector(fileName.substring(0, fileName.lastIndexOf(".")+1));
        }

        return extension;

    }

    public static boolean removeDirectory(File dir) {
        System.out.println("dir: " + dir.getAbsolutePath());
        try {
            org.apache.commons.io.FileUtils.deleteDirectory(dir);

            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return false;
    }

    public static File createTmpDir(String basePath, String dirName) {

        File outputDir = new File(basePath + File.separator + dirName);
        System.out.println("outputPath: " + outputDir.getAbsolutePath());

        if (!outputDir.exists()) {

            if (outputDir.mkdirs()) {
                logger.debug("created tmp directory: " + outputDir.getAbsolutePath());
                return outputDir;
            } else {
                logger.debug("failed to create tmp directory: " + outputDir.getAbsolutePath());
                return null;
            }
        } else {
            return outputDir;
        }
    }

}

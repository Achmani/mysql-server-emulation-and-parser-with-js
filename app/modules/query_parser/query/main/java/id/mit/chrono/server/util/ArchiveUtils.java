package id.mit.chrono.server.util;

import org.apache.commons.compress.compressors.gzip.GzipCompressorInputStream;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.io.LineIterator;

import java.io.*;
import java.util.ArrayList;
import java.util.zip.GZIPInputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class ArchiveUtils {

    private static final int BUFFER_SIZE = 4096;

    public static ArrayList<String> extractZip(File zipfile, File outdir) {

        ArrayList<String> results = new ArrayList<>();

        try {
            ZipInputStream is = new ZipInputStream(new BufferedInputStream(new FileInputStream(zipfile)));
            ZipEntry entry;

            while ((entry = is.getNextEntry()) != null) {

//                String name = entry.getName() + "." + System.currentTimeMillis();
                String name = entry.getName();
//                System.out.println("found entry: " + name);

                if (entry.isDirectory()) {

                    mkDirs(outdir, name);
                    results.add(outdir + File.separator + name);

                } else {

                    String dir = directoryPart(name);

                    if (dir != null) {
                        mkDirs(outdir, dir);
                    }

                    if(extractFile(is, outdir, name)){
                        results.add(outdir + File.separator + name);
                    }
                }
            }
            is.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return results;
    }

    private static boolean extractFile(InputStream inputStream, File outDir, String name) throws IOException {

        int count = -1;
        byte buffer[] = new byte[BUFFER_SIZE];
        BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(new File(outDir, name)), BUFFER_SIZE);
        while ((count = inputStream.read(buffer, 0, BUFFER_SIZE)) != -1) {
            out.write(buffer, 0, count);
        }
        out.close();

        // check
        File f = new File(outDir + File.separator + name);

//        System.out.println("extractFile exist: " + f.exists());

        return f.exists() && f.length()>0;
    }

    private static void mkDirs(File outdir, String path) {
//        System.out.println("found directory: " + path);
        File d = new File(outdir, path);
        if (!d.exists()) {
            d.mkdirs();
        }
    }

    private static String directoryPart(String name) {
        int s = name.lastIndexOf(File.separatorChar);
        return s == -1 ? null : name.substring(0, s);
    }

    public static ArrayList<String> decompressGZIP(File input, File outDir) {

        ArrayList<String> results = new ArrayList<String>();

        try (GZIPInputStream in = new GZIPInputStream(new FileInputStream(input))) {

//            String outputName = input.getName().substring(0, input.getName().lastIndexOf(".")) + "." + System.currentTimeMillis();
            String outputName = input.getName().substring(0, input.getName().lastIndexOf("."));

            File out = new File(outDir.getAbsolutePath() + File.separator + outputName);

            FileOutputStream output = new FileOutputStream(out);
            byte[] buffer = new byte[1024];
            int len;
            while ((len=in.read(buffer)) != -1) {
                output.write(buffer, 0, len);
            }

            if (out.exists()) {
                System.out.println(out.getAbsolutePath());
                results.add(out.getAbsolutePath());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return results;
    }

}

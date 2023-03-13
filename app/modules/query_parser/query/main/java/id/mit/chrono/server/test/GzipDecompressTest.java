package id.mit.chrono.server.test;

import id.mit.chrono.server.util.ArchiveUtils;

import oadd.org.apache.commons.compress.compressors.gzip.GzipCompressorInputStream;
import org.apache.commons.compress.utils.IOUtils;

import java.io.*;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class GzipDecompressTest {

    public static void main(String[] args) throws IOException {

        String path = "/storage/chrono/app/collector/development/CFGDATA.XML.gz";

        File file = new File(path);
        File tempDir = new File("/storage/chrono/app/collector/development/tmp/CFGDATA.XML.gz");

        List<String> decompress =  ArchiveUtils.decompressGZIP(file, tempDir);
        decompress.forEach(System.out::println);

        try {
            InputStream inputStream = new FileInputStream(decompress.get(0));
            BufferedReader buff = new BufferedReader(new InputStreamReader(inputStream));
            Stream<String> lineStream = buff.lines();

//            lineStream.forEach(System.out::println);

            List<String> candidates =  lineStream
                    .filter(line -> line.contains("<NENAME>") || line.contains("<eNodeBFunctionName>") || line.contains("<LOCATIONNAME>"))
                    .map(String::trim)
                    .collect(Collectors.toList());

            candidates.forEach(System.out::println);

            inputStream.close();

        } catch (Exception e) {
            e.printStackTrace();
        }


//        decompressGZIPApache(file, tempDir);

    }

    public static void compressGZIP(File input, File output) throws IOException {
        try (GZIPOutputStream out = new GZIPOutputStream(new FileOutputStream(output))){
            try (FileInputStream in = new FileInputStream(input)){
                byte[] buffer = new byte[1024];
                int len;
                while((len=in.read(buffer)) != -1){
                    out.write(buffer, 0, len);
                }
            }
        }
    }

    public static void decompressGzip(File input, File output) throws IOException {
        try (GZIPInputStream in = new GZIPInputStream(new FileInputStream(input))){
            try (FileOutputStream out = new FileOutputStream(output)){
                byte[] buffer = new byte[1024];
                int len;
                while((len = in.read(buffer)) != -1){
                    out.write(buffer, 0, len);
                }
            }
        }
    }

    public static void decompressGZIPApache(File input, File output) throws IOException {
        try (GzipCompressorInputStream in = new GzipCompressorInputStream(new FileInputStream(input))){
            IOUtils.copy(in, new FileOutputStream(output));
        }
    }
}

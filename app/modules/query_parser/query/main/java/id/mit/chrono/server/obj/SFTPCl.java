package id.mit.chrono.server.obj;

import com.jcraft.jsch.*;
import id.mit.chrono.server.base.BaseFileDownloader;
import id.mit.chrono.server.iface.FileDownloader;
import id.mit.chrono.server.util.ArchiveUtils;
import id.mit.chrono.server.util.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SFTPCl extends BaseFileDownloader implements FileDownloader {

    private Session session = null;
    private Channel channel = null;
    private ChannelSftp channelSftp = null;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public SFTPCl(String host, int port, String user, String password){

        super(host, port, user,password);
    }

    @Override
    public boolean connect(){

        try {
            JSch jsch = new JSch();

            session = jsch.getSession(user, host, port);
            session.setPassword(password);
            java.util.Properties config = new java.util.Properties();
            config.put("StrictHostKeyChecking", "no");
            session.setConfig(config);
            session.connect(15000);
            channel = session.openChannel("sftp");
            channel.connect();
            channelSftp = (ChannelSftp) channel;
//            channelSftp.cd(dir);

            logger.error(this.host + ":" + this.port + " connected");
            return true;
        } catch (Exception ex) {
            logger.error(this.host + ":" + this.port + " failed to connect -> " + ex.getMessage());
            ex.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean isConnected(){

        return this.channelSftp != null && this.channelSftp.isConnected();
    }

    @Override
    public boolean disconnect(){

        channelSftp.disconnect();
        session.disconnect();
        logger.info(this.host + ":" + this.port + " disconnected");

        return true;
    }

    @Override
    public ArrayList<RemoteFile> getListPath(String targetDir, boolean recursively){

        ArrayList<RemoteFile> remoteFiles = new ArrayList<RemoteFile>();

        String[] exclude = new String[]{".",".."};

        try {

            Vector<ChannelSftp.LsEntry> localResult = (Vector<ChannelSftp.LsEntry>) channelSftp.ls(targetDir);

            for (int i = 0; i < localResult.size(); i++) {

                if(!localResult.get(i).getAttrs().isDir() && !localResult.get(i).getFilename().startsWith(".")){

                    remoteFiles.add(new RemoteFile(targetDir, localResult.get(i).getFilename(), localResult.get(i).getAttrs().getMTime(), localResult.get(i).getAttrs().getSize()));
                }

                if(recursively && localResult.get(i).getAttrs().isDir() && !Arrays.asList(exclude).contains(localResult.get(i).getFilename())){

                    ArrayList<RemoteFile> recursiveResult = this.getListPath(targetDir + "/" + localResult.get(i).getFilename(), recursively);

                    remoteFiles.addAll(recursiveResult);
                }
            }

        } catch (SftpException e) {
            logger.error(this.host + ":" + this.port + " unable to ls : " + targetDir + ". Reason: " + e.getLocalizedMessage());
//            e.printStackTrace();
        }

        return remoteFiles;
    }

    @Override
    public ArrayList<RemoteFile> getListPath(String targetDir, String[] excludeDirs, boolean recursively){

        ArrayList<RemoteFile> remoteFiles = new ArrayList<RemoteFile>();

        List<String> exclude = new ArrayList<>(Arrays.asList(".",".."));
        if (excludeDirs != null) {
            exclude.addAll(Arrays.asList(excludeDirs));
        }

        try {

            Vector<ChannelSftp.LsEntry> localResult = (Vector<ChannelSftp.LsEntry>) channelSftp.ls(targetDir);

            for (int i = 0; i < localResult.size(); i++) {

                if(!localResult.get(i).getAttrs().isDir() && !localResult.get(i).getFilename().startsWith(".")){

                    String fileName = localResult.get(i).getFilename();

                    if (fileName.equals("CFGDATA.XML.gz")) {
                        fileName = getFilename(targetDir + File.separator + fileName);
                        fileName = fileName.substring(fileName.lastIndexOf("/")+1);
                    }

//                    remoteFiles.add(new RemoteFile(targetDir, localResult.get(i).getFilename(), localResult.get(i).getAttrs().getMTime(), localResult.get(i).getAttrs().getSize()));
                    remoteFiles.add(new RemoteFile(targetDir, fileName, localResult.get(i).getAttrs().getMTime(), localResult.get(i).getAttrs().getSize()));
                }

                if(recursively && localResult.get(i).getAttrs().isDir() && !exclude.contains(localResult.get(i).getFilename()) && !exclude.contains(localResult.get(i).getFilename().replaceAll("[^A-z]", ""))){

                    ArrayList<RemoteFile> recursiveResult = this.getListPath(targetDir + "/" + localResult.get(i).getFilename(), excludeDirs, recursively);

                    remoteFiles.addAll(recursiveResult);
                }
            }

        } catch (SftpException e) {
            logger.error(this.host + ":" + this.port + " unable to ls : " + targetDir);
            e.printStackTrace();
        }

        return remoteFiles;
    }

    @Override
    public boolean getRemoteFile(RemoteFile remoteFile, final File targetFile) {

        String remoteFilePath = remoteFile.dirPath + "/" + remoteFile.fileName;

        if (remoteFile.fileName.matches("^CFGDATA.XML.gz.*") && remoteFile.fileName.indexOf("_") > 0) {
            remoteFilePath = remoteFile.dirPath + "/" + remoteFile.fileName.substring(0, remoteFile.fileName.indexOf("_"));
        }

        try {

            BufferedInputStream bis = new BufferedInputStream(channelSftp.get(remoteFilePath));
            OutputStream os = new FileOutputStream(targetFile.getPath());
            BufferedOutputStream bos = new BufferedOutputStream(os);
            int readCount;
            byte[] buffer = new byte[1024];
            while ((readCount = bis.read(buffer)) > 0) {
                bos.write(buffer, 0, readCount);
            }
            bis.close();
            bos.close();

            logger.info(this.host + " success write: " + ":" + remoteFilePath + " -> " + targetFile.getPath());
        } catch (Exception e) {
            logger.error(this.host + " failed to write: " + ":" + remoteFilePath + " -> " + targetFile.getPath());
            e.printStackTrace();
            return false;
        }

        return true;
    }

    private String getFilename(String fileName) {

        // alt text to grep
        String[] alternatives = {"\"<NENAME>\"", "\"<eNodeBFunctionName>\"", "\"<LOCATIONNAME>\""};

        // trim text command
        String trimCommand = " | awk '{gsub(/^[ \\t]+| [ \\t]+$/,\"\"); print $0}'";

        String output = "";

        for (String alt: alternatives) {

            String command = "zgrep " + alt + " " + fileName + trimCommand;

            // open channel to execute command line
            try {

                ChannelExec channel = (ChannelExec) session.openChannel("exec");
                channel.setCommand(command);

                StringBuilder outputBuffer = new StringBuilder();
                StringBuilder errorBuffer = new StringBuilder();


                InputStream in = channel.getInputStream();
                InputStream err = channel.getExtInputStream();
                channel.connect();

                byte[] tmp = new byte[1024];
                while (true) {
                    while (in.available() > 0) {
                        int i = in.read(tmp, 0, 1024);
                        if (i < 0) break;
                        outputBuffer.append(new String(tmp, 0, i));
                    }
                    while (err.available() > 0) {
                        int i = err.read(tmp, 0, 1024);
                        if (i < 0) break;
                        errorBuffer.append(new String(tmp, 0, i));
                    }
                    if (channel.isClosed()) {
                        if (in.available() > 0) continue;
                        break;
                    }
                }

                output = outputBuffer.toString();
                output = output.substring(0, output.lastIndexOf("\n"));

//                System.out.println(output);

                if (output.equals("This service allows sftp connections only.")) {
                    // write data as temp file
                    File tempDir = new File("data/tmp/" + fileName.substring(fileName.lastIndexOf("/")));

                    if (!tempDir.exists()) {
                        tempDir.mkdirs();
                    }

                    BufferedInputStream bis = new BufferedInputStream(channelSftp.get(fileName));
                    OutputStream os = new FileOutputStream(tempDir.getPath() + File.separator + fileName.substring(fileName.lastIndexOf("/")));
                    BufferedOutputStream bos = new BufferedOutputStream(os);
                    int readCount;
                    byte[] buffer = new byte[1024];
                    while ((readCount = bis.read(buffer)) > 0) {
                        bos.write(buffer, 0, readCount);
                    }
                    bis.close();
                    bos.close();

                    String tmpOutputPath = ArchiveUtils.decompressGZIP(new File(tempDir.getPath() + "/" + fileName.substring(fileName.lastIndexOf("/"))), tempDir).get(0);

                    InputStream inputStream = new FileInputStream(tmpOutputPath);
                    BufferedReader buff = new BufferedReader(new InputStreamReader(inputStream));
                    Stream<String> lineStream = buff.lines();

                    List<String> candidates =  lineStream
                            .filter(line -> line.contains("<NENAME>"))
                            .map(String::trim)
                            .collect(Collectors.toList());

                    for (String candidate: candidates) {
                        String name = candidate.indexOf(">") > 0 ? candidate.substring(candidate.indexOf(">")+1, candidate.lastIndexOf("</")) : candidate;

                        if (!name.isEmpty()) {
                            output = name;
                            break;
                        }
                    }

                    inputStream.close();

                    // clean temp directory
                    if (tempDir.listFiles() != null && tempDir.listFiles().length > 0) {
                        Arrays.stream(tempDir.listFiles()).forEach(file -> {
                            if (file.isDirectory()) {
                                FileUtils.removeDirectory(file);
                            }

                            file.delete();
                        });
                    }

                    if (tempDir.listFiles() == null || tempDir.listFiles().length <= 0) {
                        FileUtils.removeDirectory(tempDir);
                    }
                }

//                System.out.println("alternative: " + alt + ", output: " + output + ", host: " + this.host);

                else if (!output.isEmpty()) {

                    String[] candidates = {output};

                    // split candidate if contains enter
                    if (output.contains("\n")) {
                        candidates = output.split("\n");
                    }

                    for (String candidate : candidates) {
//                        System.out.println("candidate: "+candidate);
                        // clean candidate string
                        String name = candidate.indexOf(">") > 0 ? candidate.substring(candidate.indexOf(">")+1, candidate.lastIndexOf("</")) : candidate;
//                        System.out.println("name: " + name + " -> " + !name.isEmpty());
                        // TODO: Need to validate match candidate name and master name (CMExport/GExport)

                        if (!name.isEmpty()) {
                            output = name;
                            break;
                        }
                    }

                }

                channel.disconnect();

            } catch (JSchException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (SftpException e) {
                e.printStackTrace();
            }

            if (!output.isEmpty()) {
                break;
            }

        }

        // fileName example: CFGDATA.XML.gz
        String extension = fileName.substring(fileName.indexOf("."));

        return fileName + "_x_" + output + extension;
    }

    public static void main(String[] args){

        SFTPCl c = new SFTPCl("10.53.201.148", 22, "omc", "Nokia-123");

        c.connect();

        ArrayList<RemoteFile> remoteFiles = c.getListPath("/d/oss/global/var/racops/export", true);

        File localDir = new File("/Users/wildan/Chrono");

        for (int i = 0; i < remoteFiles.size(); i++) {

            System.out.println(remoteFiles.get(i).dirPath + "/" + remoteFiles.get(i).fileName);

            System.out.println(">>" + remoteFiles.get(i).epochCreatedTime);

//            if(remoteFiles.get(i).fileName.contains("cnai")){
//
//
//                c.getRemoteFile(remoteFiles.get(i), localDir);
//            }
        }

        c.disconnect();

    }
}

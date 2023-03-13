package id.mit.chrono.server.obj;

import id.mit.chrono.server.base.BaseFileDownloader;
import id.mit.chrono.server.iface.FileDownloader;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Arrays;

public class FTPCl extends BaseFileDownloader implements FileDownloader {

    private FTPClient ftp = null;

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    private InputStream is = null;
    private OutputStream os = null;

    public FTPCl(String host, int port, String user, String password){

        super(host, port, user,password);
    }

    @Override
    public boolean connect() {

        this.ftp = new FTPClient();

        ftp.setDefaultTimeout(15000);
        try {

            ftp.connect(this.host, this.port);

            if(!ftp.login(this.user, this.password))
            {
                ftp.logout();
                ftp = null;

                logger.error(this.host + ":" + this.port + "failed to connect");
                return false;
            }

            ftp.setFileType(FTP.BINARY_FILE_TYPE);

            int reply = ftp.getReplyCode();
            //FTPReply stores a set of constants for FTP reply codes.
            if (!FTPReply.isPositiveCompletion(reply))
            {
                ftp.disconnect();
                logger.error(this.host + ":" + this.port + "failed to connect");
                return false;
            }

            logger.debug(this.host + ":" + this.port + " connected");

            //enter passive mode
            ftp.enterLocalPassiveMode();
            //get system name
            logger.debug(this.host + ": Remote system is " + ftp.getSystemType());
            //change current directory
//            ftp.changeWorkingDirectory(remoteDirectory);
            logger.debug(this.host + ": Current directory is " + ftp.printWorkingDirectory());

            return true;
        } catch (SocketException e) {
            logger.error(this.host + ":" + this.port  + " failed to connect: " + " -> " + e.getMessage());
            e.printStackTrace();
        } catch (IOException e) {
            logger.error(this.host + ":" + this.port  + " failed to connect: " + " -> " + e.getMessage());
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean isConnected() {
        return this.ftp!=null && this.ftp.isConnected();
    }

    @Override
    public boolean disconnect() {

        if(this.ftp==null || !this.ftp.isConnected()){
            return false;
        }

        try {
            this.ftp.disconnect();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public ArrayList<RemoteFile> getListPath(String targetDir, boolean recursively) {

        ArrayList<RemoteFile> localResult = new ArrayList<RemoteFile>();
        String[] exclude = new String[]{".",".."};

        try {

            ftp.changeWorkingDirectory(targetDir);

            FTPFile[] remoteFiles = ftp.listFiles();

            for (int i = 0; i < remoteFiles.length; i++) {

                if(remoteFiles[i].isFile() && !remoteFiles[i].getName().startsWith(".")){

                    RemoteFile r = new RemoteFile(targetDir, remoteFiles[i].getName(), (int)(remoteFiles[i].getTimestamp().getTimeInMillis()/1000), remoteFiles[i].getSize());
                    localResult.add(r);
                }

                if(recursively && !remoteFiles[i].isFile() && !Arrays.asList(exclude).contains(remoteFiles[i].getName())){

//                    System.out.println("Get Recursive: " + targetDir + "/" + remoteFiles[i].getName());

                    ArrayList<RemoteFile> recursiveResult = this.getListPath(targetDir + "/" + remoteFiles[i].getName(), recursively);

                    localResult.addAll(recursiveResult);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return localResult;
    }

    @Override
    public ArrayList<RemoteFile> getListPath(String targetDir, String[] excludeDirs, boolean recursively) {

        ArrayList<RemoteFile> localResult = new ArrayList<RemoteFile>();
        String[] exclude = new String[]{".",".."};

        try {

            ftp.changeWorkingDirectory(targetDir);

            FTPFile[] remoteFiles = ftp.listFiles();

            for (int i = 0; i < remoteFiles.length; i++) {

                if(remoteFiles[i].isFile() && !remoteFiles[i].getName().startsWith(".")){

                    RemoteFile r = new RemoteFile(targetDir, remoteFiles[i].getName(), (int)(remoteFiles[i].getTimestamp().getTimeInMillis()/1000), remoteFiles[i].getSize());
                    localResult.add(r);
                }

                if(recursively && !remoteFiles[i].isFile() && !Arrays.asList(exclude).contains(remoteFiles[i].getName())){

//                    System.out.println("Get Recursive: " + targetDir + "/" + remoteFiles[i].getName());

                    ArrayList<RemoteFile> recursiveResult = this.getListPath(targetDir + "/" + remoteFiles[i].getName(), excludeDirs, recursively);

                    localResult.addAll(recursiveResult);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return localResult;
    }

    @Override
    public boolean getRemoteFile(RemoteFile remoteFile, File targetFile) {

        String remoteFilePath = remoteFile.dirPath + "/" + remoteFile.fileName;

        OutputStream output;

        try {

            ftp.changeWorkingDirectory(remoteFile.dirPath);
            output = new FileOutputStream(targetFile.getPath());

            //get the file from the remote system
            ftp.retrieveFile(remoteFile.fileName, output);
            //close output stream
            output.close();

            logger.info(this.host + " success write: " + ":" + remoteFilePath + " -> " + targetFile.getPath());

            return true;
        } catch (IOException e) {
            logger.error(this.host + " failed to write: " + ":" + remoteFilePath + " -> " + targetFile.getPath());
            e.printStackTrace();
        }

        return false;
    }

    public static void main(String[] args){

        FTPCl c = new FTPCl("127.0.0.1", 20002, "sysbak", "SysBak-123");
        c.connect();

        ArrayList<RemoteFile> remoteFiles = c.getListPath("/ppus/minos.ppu/minos-naf.pmu/nop", true);

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

package id.mit.chrono.server.obj;

import com.jcraft.jsch.ChannelSftp;

public class RemoteFile {

    public String dirPath;
    public String fileName;
    public int epochCreatedTime;
    public long size;
    public String checksum;
    public String localDirPath;

    RemoteFile(String dirPath, String fileName, int epochCreatedTime, long size){
        this.dirPath = dirPath;
        this.fileName = fileName;
        this.epochCreatedTime = epochCreatedTime;
        this.size = size;
    }
}

package id.mit.chrono.server.iface;

import id.mit.chrono.server.obj.RemoteFile;

import java.io.File;
import java.util.ArrayList;

public interface FileDownloader {

    public boolean connect();

    public boolean isConnected();

    public boolean disconnect();

    public ArrayList<RemoteFile> getListPath(String targetDir, boolean recursively);

    public ArrayList<RemoteFile> getListPath(String targetDir, String[] excludeDirs, boolean recursively);

    public boolean getRemoteFile(RemoteFile remoteFile, final File targetFile);

}

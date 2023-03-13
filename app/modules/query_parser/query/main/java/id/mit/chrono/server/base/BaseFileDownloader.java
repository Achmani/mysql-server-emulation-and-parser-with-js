package id.mit.chrono.server.base;

public class BaseFileDownloader {

    protected String host;
    protected int port;
    protected String user;
    protected String password;

    public BaseFileDownloader(String host, int port, String user, String password){

        this.host = host;
        this.port = port;
        this.user = user;
        this.password = password;
    }
}

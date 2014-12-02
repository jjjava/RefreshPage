package br.com.schumaker.model;

import com.sun.jmx.snmp.BerDecoder;

/**
 *
 * @author hudson.sales
 */
public class HsProxy {

    private String path;
    private String port;
    private String user;
    private String pass;

    private static final HsProxy ISNTANCE = new HsProxy();

    private HsProxy() {
    }

    public static HsProxy getInstance() {
        return ISNTANCE;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public int getPort() {
        return Integer.parseInt(port);
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}

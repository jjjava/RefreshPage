package br.com.schumaker.core;

import br.com.schumaker.model.HsProxy;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Authenticator;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.PasswordAuthentication;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;

/**
 *
 * @author hudson.sales
 */
public class Engine implements Runnable {

    private String url;
    private int priority;
    private int times;
    private boolean bProxy;
    private int[] aPriorities;

    public Engine(String url, int times, boolean proxy, int priority) {
        this.url = url;
        this.times = times;
        this.bProxy = proxy;
        this.priority = priority;
        this.setPriorities();
    }

    private void setPriorities() {
        aPriorities = new int[5];
        aPriorities[0] = 1;
        aPriorities[1] = 3;
        aPriorities[2] = 5;
        aPriorities[3] = 8;
        aPriorities[4] = 10;
    }

    public void start() {
        Thread t = new Thread(this);
        t.setPriority(aPriorities[priority]);
        t.start();
    }

    private void refresh() {
        try {
            for (int k = 0; k < times; k++) {
                URL path = new URL(url);
                BufferedReader br = new BufferedReader(new InputStreamReader(path.openStream()));
                String s = null;
                while ((s = br.readLine()) != null) {
                    System.out.println(s);
                }
                br.close();
            }
        } catch (FileNotFoundException e) {
            System.err.println(e);
        } catch (MalformedURLException e) {
            System.err.println(e);
        } catch (IOException e) {
            System.err.println(e);
        }
    }

    private void refreshProxy() {
        final HsProxy hsProxy = HsProxy.getInstance();
        Authenticator authenticator = new Authenticator() {
            @Override
            public PasswordAuthentication getPasswordAuthentication() {
                return (new PasswordAuthentication(hsProxy.getUser(),
                        hsProxy.getPass().toCharArray()));
            }
        };
        Authenticator.setDefault(authenticator);
        Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(hsProxy.getPath(), hsProxy.getPort()));
        for (int k = 0; k < times; k++) {
            try {
                URLConnection conn = new URL(url).openConnection(proxy);
                InputStream is = conn.getInputStream();
                int umByte = 0;
                while ((umByte = is.read()) != -1) {
                }
                is.close();
            } catch (IOException e) {
                System.err.println(e);
            }
            System.out.println("done: " + k + 1);
        }
    }

    @Override
    public void run() {
        if (bProxy) {
            refreshProxy();
        } else {
            refresh();
        }
    }
}

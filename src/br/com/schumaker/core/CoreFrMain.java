package br.com.schumaker.core;

import br.com.schumaker.gfx.FrProxy;

/**
 *
 * @author hudson.sales
 */
public class CoreFrMain {

    private static final CoreFrMain INSTANCE = new CoreFrMain();

    private CoreFrMain() {
    }

    public static CoreFrMain getInstance() {
        return INSTANCE;
    }

    public void exit() {
        System.exit(0);
    }

    public void setPoxy() {
        FrProxy.getInstance().setVisible(true);
    }

    public void refresh(String url, int times, boolean proxy, int priority) {
        Engine engine = new Engine(url, times, proxy, priority);
        engine.start();
    }
}

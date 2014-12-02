package br.com.schumaker.run;

import br.com.schumaker.gfx.FrMain;

/**
 *
 * @author hudson.sales
 */
public class RefreshPage {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                FrMain frMain = new FrMain();
                frMain.setVisible(true);
            }
        });
    }
}

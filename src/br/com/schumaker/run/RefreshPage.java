package br.com.schumaker.run;

import br.com.schumaker.gfx.FrMain;

/**
 *
 * @author hudson.sales
 */
public class RefreshPage {

    public RefreshPage() {

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                laf();
                FrMain frMain = new FrMain();
                frMain.setVisible(true);
            }
        });
    }
    
    private static void laf(){
        System.out.println(System.getProperty("os.name"));
        if(System.getProperty("os.name").startsWith("Win")){
            
        }else if(System.getProperty("os.name").startsWith("Mac")){
            
        }
    }
}

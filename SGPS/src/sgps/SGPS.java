/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sgps;

import InterfazGrafica.LoginScreen;
import javax.swing.UIManager;

/**
 *
 * @author Juan
 */
public class SGPS {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try{
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }
        catch(Exception e){
            e.printStackTrace();
        }
        LoginScreen loginScreen = new LoginScreen();
        loginScreen.setVisible(true);
    }
}

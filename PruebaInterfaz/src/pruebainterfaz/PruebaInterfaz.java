/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebainterfaz;

import InterfazGrafica.PantallaPrincipal;
import javax.swing.UIManager;

/**
 *
 * @author Juan
 */
public class PruebaInterfaz {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        try{
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        PantallaPrincipal pantalla = new PantallaPrincipal();
        pantalla.setVisible(true);
    }
}

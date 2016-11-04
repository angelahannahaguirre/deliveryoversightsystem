/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package deliveryoversightsystem;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import others.Configurations;


/**
 *
 * @author Aimee
 */
public class DeliveryOversightSystem {
    
    private static loginModule LM;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Configurations.getInstance().checkMyConfigs();
        LM = new loginModule();
        LM.setVisible(true);
        
        try { 
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException ex) { 
        }
        
    }
    
    
}

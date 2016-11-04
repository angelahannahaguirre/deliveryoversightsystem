/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package view;


import deliveryoversightsystem.loginModule;
import javax.swing.JOptionPane;

/**
 *
 * @author Administrator
 */
public class OptionPane {
    /**
     * prompts error
     * @param msg 
     */
    public static void error(String msg){
        JOptionPane.showMessageDialog(loginModule.instance, msg, "Error", JOptionPane.ERROR_MESSAGE);
    }
    
    /**
     * prompts message
     * @param msg 
     */
    public static void message(String msg){
        JOptionPane.showMessageDialog(loginModule.instance, msg, "Message", JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * prompts confirmation dialog
     */
    public static int confirmationDialog(String msg) {
        return JOptionPane.showConfirmDialog(loginModule.instance, msg, "Confirm", JOptionPane.YES_NO_OPTION);
    }
    
}  
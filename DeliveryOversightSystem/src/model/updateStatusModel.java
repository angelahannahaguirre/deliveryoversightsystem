/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import connection.AccessLayer;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import view.OptionPane;

/**
 *
 * @author Angela
 */
public class updateStatusModel {
    
     private String employeeID;
     
      /**
     * Constructor
     * @param employeeID
     */
     
     public updateStatusModel(String employeeID) {
        
        this.employeeID = employeeID;
       
    }
     
    /**Getters and Setters**/
     
    /**
     * @return
     */
     
    public String getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

    
     /**
     * update the user's account status info in the database
     * @return true if successful else false
     */
    public boolean updateStatusToDB() {
        
        if(AccessLayer.getInstance().updateAccountStatusInDB(employeeID)){
            OptionPane.message("Account "+employeeID+"'s status has been updated!");
            return true;
        }
        else
            OptionPane.error("An error occurred, failed to update Account#"+employeeID+"'s status.");
        return false;
    }
     
    
}

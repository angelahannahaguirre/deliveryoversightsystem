/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import connection.AccessLayer;
import view.OptionPane;

/**
 *
 * @author Aimee
 */
public class UpdateUserAccountModel {
    
    private String employeeID, firstName, lastName, emPword;
    
    /**
     * Constructor
     * @param employeeID
     * @param firstName
     * @param lastName
     * @param emPword
     */
    
    public UpdateUserAccountModel(String employeeID, String firstName, String lastName, String emPword) {
        
        this.employeeID = employeeID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.emPword = emPword;
       
    }
    
    /**Getters and Setters**/
    public String getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmPword() {
        return emPword;
    }

    public void setEmPword(String emPword) {
        this.emPword = emPword;
    }

    
     /**
     * update the user_account info in the database
     * @return true if successful else false
     */
    public boolean updateUserAccount() {
        
        if(AccessLayer.getInstance().updateUserAccountInDB(employeeID, firstName, lastName, emPword)){
            OptionPane.message("Account "+employeeID+"'s information has been successfully updated!");
                //AddDependents.getInstance().updateDependentTable(getAllDependents());
            return true;
        }
        else
            OptionPane.error("An error occurred, failed to update Account#"+employeeID+"'s information!");
        return false;
    }
    
}

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
public class createUserAcctModel {
    
    private String empID, firstName, lastName, empPword, birthDate, position, status;
    
    /**
     * Constructor
     * @param empID
     * @param firstName
     * @param lastName
     * @param empPword
     * @param birthDate
     * @param position
     * @param status
     */
    
    public createUserAcctModel(String empID, String firstName, String lastName, String empPword, String birthDate, 
            String position, String status) {
        
        this.empID = empID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.empPword = empPword;
        this.birthDate = birthDate; 
        this.position = position; 
        this.status = status; 
       
    }

    
    /** Getters and Setters **/
    /***
     * 
     * @return 
     */
    
    public String getEmpID() {
        return empID;
    }

    public void setEmpID(String empID) {
        this.empID = empID;
    }

    public String getEmpPword() {
        return empPword;
    }

    public void setEmpPword(String empPword) {
        this.empPword = empPword;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    
    
    /**
     * addCreateUserAcctToDB is used when the user adds a new set of details to make a new user account
     * @param b
     */
    
    public boolean addCreateUserAcctToDB(boolean b) {
       
        
        if(AccessLayer.getInstance().addNewUser(empID, firstName, lastName, empPword, birthDate, 
            position, status)){
            OptionPane.message("New User Account details for "+empID+" has been successfully added!");
                return true;
        }else
            OptionPane.error("An error occurred, failed to add  Employee "+empID+"'s account details!");
                    return false;
    }
    
    /**
     * get all the users in the database
     * @return an arraylist of Users
     */
    public static ArrayList<createUserAcctModel> getAllUsers(){
        ArrayList<createUserAcctModel> users = new ArrayList<>();
        ResultSet rs = AccessLayer.getInstance().getAllUsers();
        try {
            while(rs.next())
                users.add(new createUserAcctModel(rs.getString("employeeID"), rs.getString("firstName"), 
                        rs.getString("lastName"), rs.getString("employeePword"), rs.getString("birthDate"),
                        rs.getString("userType"), rs.getString("userStatus")));
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"SQLException inside getAllUsers in createUserAcctModel...");
        }
        return users;
    }
    
    
    /**
     * 
     * @param optionValue
     * @param searchData
     * @return 
     */
    public static ArrayList<createUserAcctModel> getUsersWithSearch(String optionValue, String searchData){
        
        //JOptionPane.showMessageDialog(null,optionValue+" and "+searchData);
        
        ArrayList<createUserAcctModel> userList = new ArrayList<>();
        ResultSet rs = AccessLayer.getInstance().getAllUsersWithSearch(optionValue, searchData);
        try {
            while(rs.next())
                userList.add(new createUserAcctModel(rs.getString("employeeID"), rs.getString("firstName"), rs.getString("lastName"), rs.getString("employeePword"), rs.getString("birthDate"),rs.getString("userType"), rs.getString("userStatus")));
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"After catch... Error inside getUsersWithSearch..."); //error prompt to be changed
        }
        return userList;
    }

    
}

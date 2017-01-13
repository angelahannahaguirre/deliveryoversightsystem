/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import connection.AccessLayer;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author suguspnk
 */
public class LogDetails {

    public String employeeID, logActivity, logDate, logTime, empID, fName, lName, ePword, bDate, uType, uStatus;
    
    /**
     * Constructor
     * @param employeeID
     * @param logActivity
     * @param logDate
     * @param logTime 
     * 
     * @param empID
     * @param fName
     * @param lName
     * @param ePword 
     * @param bDate
     * @param uType
     * @param uStatus
     */
    public LogDetails(String employeeID, String logActivity, String logDate, String logTime, String empID, String fName, 
            String lName, String ePword, String bDate, String uType, String uStatus){
        
        this.employeeID = employeeID;
        this.logActivity = logActivity;
        this.logDate = logDate;
        this.logTime = logTime;
        this.empID = empID;
        this.fName = fName;
        this.lName = lName;
        this.ePword = ePword;
        this.bDate = bDate;
        this.uType = uType;
        this.uStatus = uStatus;
    }
    
    /**
     * Getters and Setters
     * @return
     */
    
    public String getFullname(){
        return getlName()+", "+getfName();
    }
    
    public String getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

    public String getLogActivity() {
        return logActivity;
    }

    public void setLogActivity(String logActivity) {
        this.logActivity = logActivity;
    }

    public String getLogDate() {
        return logDate;
    }

    public void setLogDate(String logDate) {
        this.logDate = logDate;
    }

    public String getLogTime() {
        return logTime;
    }

    public void setLogTime(String logTime) {
        this.logTime = logTime;
    }

    public String getEmpID() {
        return empID;
    }

    public void setEmpID(String empID) {
        this.empID = empID;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getePword() {
        return ePword;
    }

    public void setePword(String ePword) {
        this.ePword = ePword;
    }

    public String getbDate() {
        return bDate;
    }

    public void setbDate(String bDate) {
        this.bDate = bDate;
    }

    public String getuType() {
        return uType;
    }

    public void setuType(String uType) {
        this.uType = uType;
    }

    public String getuStatus() {
        return uStatus;
    }

    public void setuStatus(String uStatus) {
        this.uStatus = uStatus;
    }

    
    
    
    
    
    /**
     * add the log to the database
     * @param employeeID
     * @param logActivity
     */
    public static void addToDatabase(String employeeID, String logActivity){
        
        Date date = new Date(); //Getting the current date and time
        Format dateFormat = new SimpleDateFormat("yyyy-MM-dd"); //formtat for date
        Format timeFormat = new SimpleDateFormat("HH:mm:ss"); //format for time
        String curDate = dateFormat.format(date);
        String curTime = timeFormat.format(date);
        
        AccessLayer.getInstance().addLog(curDate, curTime, employeeID, logActivity);
        
    }

    /**
     * get all log details in the database
     * @return an arraylist of LogDetails
     */
    public static ArrayList<LogDetails> getAllLogs() {
        ArrayList<LogDetails> logs = new ArrayList<>();
        ResultSet rs = AccessLayer.getInstance().getAllLogs();
        try {
            while(rs.next())
                logs.add(new LogDetails(rs.getString("employeeID"), rs.getString("logActivity"), rs.getString("logDate"), rs.getString("logTime"),
                                        rs.getString("employeeID"), rs.getString("firstName"), rs.getString("lastName"), rs.getString("employeePword"),
                                        rs.getString("birthDate"), rs.getString("userType"), rs.getString("userStatus")));
        } catch (SQLException ex) {
            Logger.getLogger(BackupDetails.class.getName()).log(Level.SEVERE, null, ex);
        }
        return logs;
    }
    
    /**
     * search for the log details that satisfies the condition
     * @param condition
     * @return an arrayList of LogDetails
     */
    public static ArrayList<LogDetails> search(String condition) {
        ArrayList<LogDetails> logs = new ArrayList<>();
        ResultSet rs = AccessLayer.getInstance().searchLogs(condition);
        try {
            while(rs.next())
                logs.add(new LogDetails(rs.getString("employeeID"), rs.getString("logActivity"), rs.getString("logDate"), rs.getString("logTime"),
                                        rs.getString("employeeID"), rs.getString("firstName"), rs.getString("lastName"), rs.getString("employeePword"),
                                        rs.getString("birthDate"), rs.getString("userType"), rs.getString("userStatus")));
        } catch (SQLException ex) {
            Logger.getLogger(BackupDetails.class.getName()).log(Level.SEVERE, null, ex);
        }
        return logs;
    }
    
    /**
     * get all log details in the database
     * @return an arraylist of LogDetails
     * @param optionValue
     * @param searchData
     */
    public static ArrayList<LogDetails> getAllLogsWithSearch(String optionValue, String searchData) {
        ArrayList<LogDetails> logs = new ArrayList<>();
        ResultSet rs = AccessLayer.getInstance().getAllLogsWithSearchInDB(optionValue,searchData);
        try {
            while(rs.next())
                logs.add(new LogDetails(rs.getString("employeeID"), rs.getString("logActivity"), rs.getString("logDate"), rs.getString("logTime"),
                                        rs.getString("employeeID"), rs.getString("firstName"), rs.getString("lastName"), rs.getString("employeePword"),
                                        rs.getString("birthDate"), rs.getString("userType"), rs.getString("userStatus")));
        } catch (SQLException ex) {
            Logger.getLogger(BackupDetails.class.getName()).log(Level.SEVERE, null, ex);
        }
        return logs;
    }
    
}

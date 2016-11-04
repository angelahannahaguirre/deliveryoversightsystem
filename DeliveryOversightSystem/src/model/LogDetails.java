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

    public String date, time, log;
    
    /**
     * Constructor
     * @param date
     * @param time
     * @param log 
     */
    public LogDetails(String date, String time, String log){
        this.date = date;
        this.time = time;
        this.log = log;
    }
    
    /**
     * add the log to the database
     * @param log 
     */
    public static void addToDatabase(String log){
        Date date = new Date();
        Format dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Format timeFormat = new SimpleDateFormat("HH:mm:ss");
        String curDate = dateFormat.format(date);
        String curTime = timeFormat.format(date);
        AccessLayer.getInstance().addLog(curDate, curTime, log);
    }

    /**
     * get all log details in the database
     * @return an arralist of LogDetails
     */
    public static ArrayList<LogDetails> getAllLogs() {
        ArrayList<LogDetails> logs = new ArrayList<>();
        ResultSet rs = AccessLayer.getInstance().getAllLogs();
        try {
            while(rs.next())
                logs.add(new LogDetails(rs.getString("date"), rs.getString("time"), rs.getString("log")));
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
                logs.add(new LogDetails(rs.getString("date"), rs.getString("time"), rs.getString("log")));
        } catch (SQLException ex) {
            Logger.getLogger(BackupDetails.class.getName()).log(Level.SEVERE, null, ex);
        }
        return logs;
    }
}

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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author suguspnk
 */
public class BackupDetails {

    public String date, time, path;
    
    /**
     * Constructor
     * @param date
     * @param time
     * @param path 
     */
    public BackupDetails(String date, String time, String path){
        this.date = date;
        this.time = time;
        this.path = path;
    }
    
    /**
     * add to database the backup details
     */
    public void addToDatabase(){
        AccessLayer.getInstance().addBackup(date, time, path);
    }
    
    /**
     * get all the backup details from the database
     * @return an ArrayList of BackupDetails from the database
     */
    public static ArrayList<BackupDetails> getAllBackups(){
        ArrayList<BackupDetails> backups = new ArrayList<>();
        ResultSet rs = AccessLayer.getInstance().getAllBackups();
        try {
            while(rs.next())
                backups.add(new BackupDetails(rs.getString("backup_date"), rs.getString("time"), rs.getString("path")));
        } catch (SQLException ex) {
            Logger.getLogger(BackupDetails.class.getName()).log(Level.SEVERE, null, ex);
        }
        return backups;
    }
    
    /**
     * search for the backup details that satisfies the condition
     * @param condition
     * @return an ArrayList of BackupDetails that satisfies the condition
     */
    public static ArrayList<BackupDetails> search(String condition) {
        ArrayList<BackupDetails> backups = new ArrayList<>();
        ResultSet rs = AccessLayer.getInstance().searchBackups(condition);
        try {
            while(rs.next())
                backups.add(new BackupDetails(rs.getString("backup_date"), rs.getString("time"), rs.getString("path")));
        } catch (SQLException ex) {
            Logger.getLogger(BackupDetails.class.getName()).log(Level.SEVERE, null, ex);
        }
        return backups;
    }
}

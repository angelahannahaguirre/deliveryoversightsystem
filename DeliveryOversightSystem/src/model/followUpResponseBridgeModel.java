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

/**
 *
 * @author Aimee
 */
public class followUpResponseBridgeModel {
    
     private String purchaseNo, purchaserName, suppName, faxedDate, deliveryStat, purchaseNum, followUpFlag, dateFollowedUp;
    
     /**
     * Constructor
     * @param purchaseNo
     * @param purchaserName
     * @param suppName
     * @param faxedDate
     * @param deliveryStat
     * @param purchaseNum
     * @param followUpFlag
     * @param dateFollowedUp
     */
     
     public followUpResponseBridgeModel(String purchaseNo, String purchaserName, String suppName, String faxedDate, 
            String deliveryStat, String purchaseNum, String followUpFlag, String dateFollowedUp) {
        
        this.purchaseNo = purchaseNo;
        this.purchaserName = purchaserName;
        this.suppName = suppName;
        this.faxedDate = faxedDate;
        this.deliveryStat = deliveryStat;
        
        this.purchaseNum = purchaseNum;
        this.followUpFlag = followUpFlag;
        this.dateFollowedUp = dateFollowedUp;
        
    }
     
    /**
     * Getters and Setters
     * @return
     */
    public String getPurchaseNo() {
        return purchaseNo;
    }

    public void setPurchaseNo(String purchaseNo) {
        this.purchaseNo = purchaseNo;
    }

    public String getPurchaserName() {
        return purchaserName;
    }

    public void setPurchaserName(String purchaserName) {
        this.purchaserName = purchaserName;
    }

    public String getSuppName() {
        return suppName;
    }

    public void setSuppName(String suppName) {
        this.suppName = suppName;
    }

    public String getFaxedDate() {
        return faxedDate;
    }

    public void setFaxedDate(String faxedDate) {
        this.faxedDate = faxedDate;
    }

    public String getDeliveryStat() {
        return deliveryStat;
    }

    public void setDeliveryStat(String deliveryStat) {
        this.deliveryStat = deliveryStat;
    }

    public String getFollowUpFlag() {
        return followUpFlag;
    }

    public void setFollowUpFlag(String followUpFlag) {
        this.followUpFlag = followUpFlag;
    }

    public String getDateFollowedUp() {
        return dateFollowedUp;
    }

    public void setDateFollowedUp(String dateFollowedUp) {
        this.dateFollowedUp = dateFollowedUp;
    }

    public String getPurchaseNum() {
        return purchaseNum;
    }

    public void setPurchaseNum(String purchaseNum) {
        this.purchaseNum = purchaseNum;
    }

    
     
     /**
     * get all the details inside the delivery table JOIN response table from the database
     * this function is called for the Answer Follow-Up List table
     * @return an arraylist of delivery and response details
     */
    public static ArrayList<followUpResponseBridgeModel> getFollowUpAndResponseList(){      
        ArrayList<followUpResponseBridgeModel> answerList = new ArrayList<>();    
        ResultSet rs = AccessLayer.getInstance().getFollowUpAndResponseListInDB();
        //JOptionPane.showMessageDialog(null, "Inside newItemsModel getAnswerFollowUpList...");
        try {
            while(rs.next())
                answerList.add(new followUpResponseBridgeModel(rs.getString("purchaseOrderNo"), rs.getString("purchaser"), 
                        rs.getString("supplierName"), rs.getString("dateFaxed"), rs.getString("deliveryStatus"),
                        rs.getString("purchaseOrderNo"), rs.getString("followUpFlag"), rs.getString("dateFollowedUp")));
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"SQLException inside getAllNewItems in getFollowUpAndResponseList...");
        }
        return answerList;
    }
    
    /**
     * get the details inside the delivery table JOIN response table from the database using SEARCH
     * this function is called for the Answer Follow-Up List table
     * @param searchVal
     * @return an arraylist of delivery and response details
     */
    public static ArrayList<followUpResponseBridgeModel> getFollowUpAndResponseListWithSearch(String searchVal){      
        ArrayList<followUpResponseBridgeModel> aList = new ArrayList<>();    
        ResultSet rs = AccessLayer.getInstance().getFollowUpAndResponseListInDBWithSearch(searchVal);
        //JOptionPane.showMessageDialog(null, "Inside newItemsModel getAnswerFollowUpList...");
        try {
            while(rs.next())
                aList.add(new followUpResponseBridgeModel(rs.getString("purchaseOrderNo"), rs.getString("purchaser"), 
                        rs.getString("supplierName"), rs.getString("dateFaxed"), rs.getString("deliveryStatus"),
                        rs.getString("purchaseOrderNo"), rs.getString("followUpFlag"), rs.getString("dateFollowedUp")));
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"SQLException inside getAllNewItems in getFollowUpAndResponseListWithSearch...");
        }
        return aList;
    }
     
    
}

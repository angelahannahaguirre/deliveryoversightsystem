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
    
     private String purchaseNo, purchaserName, suppName, faxedDate, deliveryStat, followUpFlag, dateFollowedUp, purchaseOrderNo, choiceValue, shortMsg,
             currDate, responseStatus;
    
     /**
     * Constructor
     * @param purchaseNo
     * @param purchaserName
     * @param suppName
     * @param faxedDate
     * @param deliveryStat
     * @param followUpFlag
     * @param dateFollowedUp
     * @param purchaseOrderNo
     * @param choiceValue
     * @param shortMsg
     * @param currDate
     * @param responseStatus
     */
     
     public followUpResponseBridgeModel(String purchaseNo, String purchaserName, String suppName, String faxedDate, 
            String deliveryStat, String followUpFlag, String dateFollowedUp, String purchaseOrderNo, String choiceValue, String shortMsg,
            String currDate, String responseStatus) {
        
        this.purchaseNo = purchaseNo;
        this.purchaserName = purchaserName;
        this.suppName = suppName;
        this.faxedDate = faxedDate;
        this.deliveryStat = deliveryStat;
        this.followUpFlag = followUpFlag;
        this.dateFollowedUp = dateFollowedUp;
        
        this.purchaseOrderNo = purchaseOrderNo;
        this.choiceValue = choiceValue;
        this.shortMsg = shortMsg;
        this.currDate = currDate;
        this.responseStatus = responseStatus;
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

    public String getPurchaseOrderNo() {
        return purchaseOrderNo;
    }

    public void setPurchaseOrderNo(String purchaseOrderNo) {
        this.purchaseOrderNo = purchaseOrderNo;
    }

    public String getChoiceValue() {
        return choiceValue;
    }

    public void setChoiceValue(String choiceValue) {
        this.choiceValue = choiceValue;
    }

    public String getShortMsg() {
        return shortMsg;
    }

    public void setShortMsg(String shortMsg) {
        this.shortMsg = shortMsg;
    }

    public String getCurrDate() {
        return currDate;
    }

    public void setCurrDate(String currDate) {
        this.currDate = currDate;
    }

    public String getResponseStatus() {
        return responseStatus;
    }

    public void setResponseStatus(String responseStatus) {
        this.responseStatus = responseStatus;
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
                        rs.getString("followUpFlag"), rs.getString("dateFollowedUp"), rs.getString("purchaseOrderNo"), 
                        rs.getString("choiceValue"), rs.getString("shortMsg"),rs.getString("currDate"), 
                        rs.getString("responseStatus")));
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"SQLException inside getAllNewItems in newItemsModel...");
        }
        return answerList;
    }
     
    
}

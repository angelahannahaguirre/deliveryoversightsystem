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
public class responseListModel {
    
    private String purchaseNo, purchaser, supplierName, dateFaxed, delStatus, 
            purchaseOrderNo, choiceVal, shortMsg, currentDate, responseStatus;
    
    /**
     * Constructor
     * @param purchaseNo
     * @param purchaser
     * @param supplierName
     * @param dateFaxed
     * @param delStatus
     * @param purchaseOrderNo
     * @param choiceVal
     * @param shortMsg
     * @param currentDate
     * @param responseStatus
     */
    
    public responseListModel(String purchaseNo, String purchaser, String supplierName, String dateFaxed, 
            String delStatus, String purchaseOrderNo, String choiceVal, String shortMsg, 
            String currentDate, String responseStatus) {
        
        this.purchaseNo = purchaseNo;
        this.purchaser = purchaser;
        this.supplierName = supplierName;
        this.dateFaxed = dateFaxed;
        this.delStatus = delStatus;
        this.purchaseOrderNo = purchaseOrderNo;
        this.choiceVal = choiceVal;
        this.shortMsg = shortMsg;
        this.currentDate = currentDate;
        this.responseStatus = responseStatus;
       
    }
    
    /***
     * Getters and Setters
     * @return
     */
    public String getPurchaseNo() {
        return purchaseNo;
    }

    public void setPurchaseNo(String purchaseNo) {
        this.purchaseNo = purchaseNo;
    }

    public String getPurchaser() {
        return purchaser;
    }

    public void setPurchaser(String purchaser) {
        this.purchaser = purchaser;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getDateFaxed() {
        return dateFaxed;
    }

    public void setDateFaxed(String dateFaxed) {
        this.dateFaxed = dateFaxed;
    }

    public String getDelStatus() {
        return delStatus;
    }

    public void setDelStatus(String delStatus) {
        this.delStatus = delStatus;
    }

    public String getResponseStatus() {
        return responseStatus;
    }

    public void setResponseStatus(String responseStatus) {
        this.responseStatus = responseStatus;
    }

    public String getPurchaseOrderNo() {
        return purchaseOrderNo;
    }

    public void setPurchaseOrderNo(String purchaseOrderNo) {
        this.purchaseOrderNo = purchaseOrderNo;
    }

    public String getChoiceVal() {
        return choiceVal;
    }

    public void setChoiceVal(String choiceVal) {
        this.choiceVal = choiceVal;
    }

    public String getShortMsg() {
        return shortMsg;
    }

    public void setShortMsg(String shortMsg) {
        this.shortMsg = shortMsg;
    }

    public String getCurrentDate() {
        return currentDate;
    }

    public void setCurrentDate(String currentDate) {
        this.currentDate = currentDate;
    }
    
    
   
    /**
     * get all the details inside the delivery table and responses status from the database
     * this function is called for the View Response List table
     * @return an arraylist of delivery details
     */
    public static ArrayList<responseListModel> getAllResponses(){      
        ArrayList<responseListModel> responseList = new ArrayList<>();    
        ResultSet rs = AccessLayer.getInstance().getAllResponsesInDB();
        //JOptionPane.showMessageDialog(null, "Inside newItemsModel getAllNewItems...");
        try {
            while(rs.next())
                responseList.add(new responseListModel(rs.getString("purchaseOrderNo"), rs.getString("purchaser"), 
                        rs.getString("supplierName"), rs.getString("dateFaxed"), rs.getString("deliveryStatus"),
                        rs.getString("purchaseOrderNo"), rs.getString("choiceValue"), rs.getString("shortMsg"),
                        rs.getString("currDate"), rs.getString("responseStatus")));
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"SQLException inside getAllResponses in responseListModel...");
        }
        return responseList;
    }

  
    /**
     * 
     * @param optionValue
     * @param searchData
     * @return 
     */
    public static ArrayList<responseListModel> getResponseWithSearch(String optionValue, String searchData){ //this has an issue
        
        //JOptionPane.showMessageDialog(null,optionValue+" and "+searchData);
        
        ArrayList<responseListModel> rList = new ArrayList<>();
        ResultSet rs = AccessLayer.getInstance().getAllResponseUpdatesWithSearch(optionValue,searchData);
        try {
            while(rs.next())
                rList.add(new responseListModel(rs.getString("purchaseOrderNo"), rs.getString("purchaser"), 
                        rs.getString("supplierName"), rs.getString("dateFaxed"), rs.getString("deliveryStatus"),
                        rs.getString("purchaseOrderNo"), rs.getString("choiceValue"), rs.getString("shortMsg"),
                        rs.getString("currDate"), rs.getString("responseStatus")));
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"After catch... Error inside getResponseWithSearch..."); //error prompt to be changed
        }
        return rList;
    }
    
    
}

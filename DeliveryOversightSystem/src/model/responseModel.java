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
public class responseModel {
    
    private String purchaseNo, choiceValue, shortMsg, currentDate, responseStatus;
    
    /**
     * Constructor
     * @param purchaseNo
     * @param choiceValue
     * @param shortMsg
     * @param currentDate
     * @param responseStatus
     */
    
    public responseModel(String purchaseNo, String choiceValue, String shortMsg, String currentDate, 
            String responseStatus) {
        
        this.purchaseNo = purchaseNo;
        this.choiceValue = choiceValue;
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

    public String getCurrentDate() {
        return currentDate;
    }

    public void setCurrentDate(String currentDate) {
        this.currentDate = currentDate;
    }

    public String getResponseStatus() {
        return responseStatus;
    }

    public void setResponseStatus(String responseStatus) {
        this.responseStatus = responseStatus;
    }

    
    /**
     * addResponseToDB is used when the the WM sends a response to the item followed-up by PH
     * @param b
     * @return 
     */
    
    public boolean addResponseToDB(boolean b) {
       
        
        if(AccessLayer.getInstance().addNewResponse(purchaseNo, choiceValue, shortMsg, currentDate, responseStatus)){
            //OptionPane.message("Item: "+purchaseNo+" has been successfully added to Delivery List!");
                return true;
        }else
            OptionPane.error("An error occurred. Failed to add the response for delivery#"+purchaseNo+"!");
                    return false;
    }
    
}

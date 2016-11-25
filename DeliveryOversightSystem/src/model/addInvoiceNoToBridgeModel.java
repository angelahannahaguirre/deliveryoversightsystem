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
 * @author Aimee
 */
public class addInvoiceNoToBridgeModel {
    
     private String purchaseOrderNo, invoiceNo;
    
     /**
     * Constructor
     * @param purchaseOrderNo
     * @param invoiceNo
     */
    
    public addInvoiceNoToBridgeModel(String purchaseOrderNo, String invoiceNo) {
        
        this.purchaseOrderNo = purchaseOrderNo;
        this.invoiceNo = invoiceNo;
       
    }
    
    /**Getters and Setters**/
    /**
     * @return
     */
    public String getPurchaseOrderNo() {
        return purchaseOrderNo;
    }

    public void setPurchaseOrderNo(String purchaseOrderNo) {
        this.purchaseOrderNo = purchaseOrderNo;
    }

    public String getInvoiceNo() {
        return invoiceNo;
    }

    public void setInvoiceNo(String invoiceNo) {
        this.invoiceNo = invoiceNo;
    }

    
    /**
     * addBridgeToDB is used when the PH accepts item/s to the Delivery List
     * @param b
     * @return 
     */
    
    public boolean addBridgeToDB(boolean b) {
       
        
        if(AccessLayer.getInstance().addNewBridge(purchaseOrderNo, invoiceNo)){
            //OptionPane.message("Item: "+purchaseNo+" has been successfully added to Delivery List!");
                return true;
        }else
            OptionPane.error("An error occurred. Failed to add Invoice#"+invoiceNo+" to Bridge List!");
                    return false;
    }
    
}

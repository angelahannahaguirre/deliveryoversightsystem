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
public class addItemModel {
    
    private String purchaseNo, purchaserName, suppName, faxedDate, deliveryStat, followUpFlag;
    
     /**
     * Constructor
     * @param purchaseNo
     * @param purchaserName
     * @param suppName
     * @param faxedDate
     * @param deliveryStat
     * @param followUpFlag
     */
    
    public addItemModel(String purchaseNo, String purchaserName, String suppName, String faxedDate, String deliveryStat, 
            String followUpFlag) {
        
        this.purchaseNo = purchaseNo;
        this.purchaserName = purchaserName;
        this.suppName = suppName;
        this.faxedDate = faxedDate;
        this.deliveryStat = deliveryStat; 
        this.followUpFlag = followUpFlag;
       
    }
    
    
    
    /**Getters and Setters**/
    
    /**
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

    
    /**
     * addItemToDB is used when the PH adds a new set of item to the Delivery List
     * @param b
     */
    
    public boolean addItemToDB(boolean b) {
       
        
        if(AccessLayer.getInstance().addNewItem(purchaseNo, purchaserName, suppName, faxedDate, deliveryStat, followUpFlag)){
            //OptionPane.message("Item: "+purchaseNo+" has been successfully added to Delivery List!");
                return true;
        }else
            OptionPane.error("An error occurred. Failed to add: Item#"+purchaseNo+" to Delivery List!");
                    return false;
    }
    
    
    /**
     * get all the invoice in the database
     * @return an arraylist of invoice
     */
    public static ArrayList<addItemModel> getAllInvoice(){
        ArrayList<addItemModel> invoice = new ArrayList<>();
        ResultSet rs = AccessLayer.getInstance().getAllInvoiceInDB();
        try {
            while(rs.next())
                invoice.add(new addItemModel(rs.getString("purchaseOrderNo"), rs.getString("purchaser"), 
                        rs.getString("supplierName"), rs.getString("dateFaxed"), rs.getString("deliveryStatus"),
                        rs.getString("followUpFlag")));
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"SQLException inside getAllUsers in createUserAcctModel...");
        }
        return invoice;
    }
    
    
}

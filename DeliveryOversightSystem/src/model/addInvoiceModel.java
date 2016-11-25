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
public class addInvoiceModel {
    
    private String invoiceNo, invoiceDate, dateDelivered, manualDate, 
                    electronicDate, referenceRRNo, dateForwarded;
    
     /**
     * Constructor
     * @param invoiceNo
     * @param invoiceDate
     * @param dateDelivered
     * @param manualDate
     * @param electronicDate
     * @param referenceRRNo
     * @param dateForwarded
     */
    
    public addInvoiceModel(String invoiceNo, String invoiceDate, String dateDelivered, String manualDate, 
            String electronicDate, String referenceRRNo, String dateForwarded) {
        
        this.invoiceNo = invoiceNo;
        this.invoiceDate = invoiceDate;
        this.dateDelivered = dateDelivered;
        this.manualDate = manualDate; 
        this.electronicDate = electronicDate;
        this.referenceRRNo = referenceRRNo;
        this.dateForwarded = dateForwarded;
       
    }
    
    /**Getters and Setters**/
    
    /**
     * @return
     */
    

    public String getInvoiceNo() {
        return invoiceNo;
    }

    public void setInvoiceNo(String invoiceNo) {
        this.invoiceNo = invoiceNo;
    }

    public String getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(String invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public String getDateDelivered() {
        return dateDelivered;
    }

    public void setDateDelivered(String dateDelivered) {
        this.dateDelivered = dateDelivered;
    }

    public String getManualDate() {
        return manualDate;
    }

    public void setManualDate(String manualDate) {
        this.manualDate = manualDate;
    }

    public String getElectronicDate() {
        return electronicDate;
    }

    public void setElectronicDate(String electronicDate) {
        this.electronicDate = electronicDate;
    }

    public String getReferenceRRNo() {
        return referenceRRNo;
    }

    public void setReferenceRRNo(String referenceRRNo) {
        this.referenceRRNo = referenceRRNo;
    }

    public String getDateForwarded() {
        return dateForwarded;
    }

    public void setDateForwarded(String dateForwarded) {
        this.dateForwarded = dateForwarded;
    }

    

    
    /**
     * addItemToDB is used when the PH adds a new set of item to the Delivery List
     * @param b
     */
    
    public boolean addInvoiceToDB(boolean b) {
       
        
        if(AccessLayer.getInstance().addNewInvoice(invoiceNo, invoiceDate, dateDelivered, manualDate, 
                    electronicDate, referenceRRNo, dateForwarded)){
            //OptionPane.message("Item: "+purchaseNo+" has been successfully added to Delivery List!");
                return true;
        }else
            OptionPane.error("An error occurred. Failed to add and accept item with Invoice#"+invoiceNo+" to Delivery List!");
                    return false;
    }
    
    
    /**
     * get all the details inside the delivery and invoice tables from the database
     * @return an arraylist of delivery and invoice details
     */
    public static ArrayList<addItemModel> getAllInvoice(){      //currently here this function is just copied.. 
        ArrayList<addItemModel> invoice = new ArrayList<>();    //to be edited
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

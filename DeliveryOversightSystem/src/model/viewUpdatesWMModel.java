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
public class viewUpdatesWMModel { //this is a trial code for View Updates WM Table
    
    private String purchaseOrderNo, purchaser, supplierName, dateFaxed, invoiceNo, invoiceDate, 
            dateDelivered, manualDate, electronicDate, referenceRRNo, dateForwarded;
    
    /**
     * Constructor
     * @param purchaseOrderNo
     * @param purchaser
     * @param supplierName
     * @param dateFaxed
     * @param invoiceNo
     * @param invoiceDate
     * @param dateDelivered
     * @param manualDate
     * @param electronicDate
     * @param referenceRRNo
     * @param dateForwarded
     */
    
    
    public viewUpdatesWMModel(String purchaseOrderNo, String purchaser, String supplierName, String dateFaxed, 
            String invoiceNo, String invoiceDate, String dateDelivered, String manualDate, 
            String electronicDate, String referenceRRNo, String dateForwarded) {
        
        this.purchaseOrderNo = purchaseOrderNo;
        this.purchaser = purchaser;
        this.supplierName = supplierName;
        this.dateFaxed = dateFaxed; 
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
    public String getPurchaseOrderNo() {
        return purchaseOrderNo;
    }

    public void setPurchaseOrderNo(String purchaseOrderNo) {
        this.purchaseOrderNo = purchaseOrderNo;
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
     * get all the delivery and invoice data in the database
     * @return an arraylist of delivery and invoice
     */
    public static ArrayList<viewUpdatesWMModel> getAllUpdates(){
        ArrayList<viewUpdatesWMModel> updates = new ArrayList<>();
        ResultSet rs = AccessLayer.getInstance().getAllUpdatesInDB();
        try {
            while(rs.next())
                updates.add(new viewUpdatesWMModel(rs.getString("purchaseOrderNo"), rs.getString("purchaser"), 
                        rs.getString("supplierName"), rs.getString("dateFaxed"), rs.getString("invoiceNo"),
                        rs.getString("invoiceDate"), rs.getString("dateDelivered"), rs.getString("manualDate"),
                        rs.getString("electronicDate"), rs.getString("referenceRRNo"), rs.getString("dateForwarded")));
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"SQLException inside getAllUsers in createUserAcctModel...");
        }
        return updates;
    }
    
}

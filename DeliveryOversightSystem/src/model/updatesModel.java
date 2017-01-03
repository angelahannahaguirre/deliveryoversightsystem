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
public class updatesModel {
    
    private String purchaseNo, purchaserName, suppName, faxedDate, deliveryStat, followUpFlag, invoiceNo, invoiceDate, dateDelivered, manualDate, 
                    electronicDate, referenceRRNo, dateForwarded;
    
     /**
     * Constructor
     * @param purchaseNo
     * @param purchaserName
     * @param suppName
     * @param faxedDate
     * @param deliveryStat
     * @param followUpFlag
     * @param invoiceNo
     * @param invoiceDate
     * @param dateDelivered
     * @param manualDate
     * @param electronicDate
     * @param referenceRRNo
     * @param dateForwarded
     */
    
    public updatesModel(String purchaseNo, String purchaserName, String suppName, String faxedDate, 
            String invoiceNo, String invoiceDate, String dateDelivered, String manualDate, 
            String electronicDate, String referenceRRNo, String dateForwarded) {
        
        this.purchaseNo = purchaseNo;
        this.purchaserName = purchaserName;
        this.suppName = suppName;
        this.faxedDate = faxedDate;
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

  
    
    
    /**
     * get all the details inside the delivery and invoice tables from the database
     * @return an arraylist of delivery and invoice details
     */
    public static ArrayList<updatesModel> getAllUpdates(){      
        ArrayList<updatesModel> invoice = new ArrayList<>();    
        ResultSet rs = AccessLayer.getInstance().getAllUpdatesInDB();
        //JOptionPane.showMessageDialog(null, "Inside updatesModel getAllUpdates...");
        try {
            while(rs.next())
                invoice.add(new updatesModel(rs.getString("purchaseOrderNo"), rs.getString("purchaser"), 
                        rs.getString("supplierName"), rs.getString("dateFaxed"), rs.getString("invoiceNo"),
                        rs.getString("invoiceDate"), rs.getString("dateDelivered"), rs.getString("manualDate"),
                        rs.getString("electronicDate"), rs.getString("referenceRRNo"), rs.getString("dateForwarded")));
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"SQLException inside getAllUpdates in updatesModel...");
        }
        return invoice;
    }
    
    /**
     * 
     * @param optionValue
     * @param searchData
     * @return 
     */
    public static ArrayList<updatesModel> getInvoiceWithSearch(String optionValue, String searchData){
        
        //JOptionPane.showMessageDialog(null,optionValue+" and "+searchData);
        
        ArrayList<updatesModel> invoiceList = new ArrayList<>();
        ResultSet rs = AccessLayer.getInstance().getAllInvoiceUpdatesWithSearch(optionValue,searchData);
        try {
            while(rs.next())
                invoiceList.add(new updatesModel(rs.getString("purchaseOrderNo"), rs.getString("purchaser"), 
                        rs.getString("supplierName"), rs.getString("dateFaxed"), rs.getString("invoiceNo"),
                        rs.getString("invoiceDate"), rs.getString("dateDelivered"), rs.getString("manualDate"),
                        rs.getString("electronicDate"), rs.getString("referenceRRNo"), rs.getString("dateForwarded")));
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"After catch... Error inside getUsersWithSearch..."); //error prompt to be changed
        }
        return invoiceList;
    }
    
}

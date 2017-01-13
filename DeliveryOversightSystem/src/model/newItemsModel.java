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
 * @author Angela
 */
public class newItemsModel {
    
    private String purchaseNo, purchaserName, suppName, faxedDate, deliveryStat;
    
     /**
     * Constructor
     * @param purchaseNo
     * @param purchaserName
     * @param suppName
     * @param faxedDate
     * @param deliveryStat
     */
     
     public newItemsModel(String purchaseNo, String purchaserName, String suppName, String faxedDate, 
            String deliveryStat) {
        
        this.purchaseNo = purchaseNo;
        this.purchaserName = purchaserName;
        this.suppName = suppName;
        this.faxedDate = faxedDate;
        this.deliveryStat = deliveryStat;
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

   
     
     /**
     * get all the details inside the delivery table from the database
     * this function is called for the PH Home table
     * @return an arraylist of delivery details
     */
    public static ArrayList<newItemsModel> getAllNewItems(){      
        ArrayList<newItemsModel> newList = new ArrayList<>();    
        ResultSet rs = AccessLayer.getInstance().getAllItemsToFollowUpInDB();
        //JOptionPane.showMessageDialog(null, "Inside newItemsModel getAllNewItems...");
        try {
            while(rs.next())
                newList.add(new newItemsModel(rs.getString("purchaseOrderNo"), rs.getString("purchaser"), 
                        rs.getString("supplierName"), rs.getString("dateFaxed"), rs.getString("deliveryStatus")));
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"SQLException inside getAllNewItems in newItemsModel...");
        }
        return newList;
    }
    
    /**
     * get all the details inside the delivery table from the database
     * this function is called for the Weekly Order List table
     * @return an arraylist of delivery details
     */
    public static ArrayList<newItemsModel> getAllNewItemList(){      
        ArrayList<newItemsModel> newOrderList = new ArrayList<>();    
        ResultSet rs = AccessLayer.getInstance().getAllNewItemOrderListInDB();
        //JOptionPane.showMessageDialog(null, "Inside newItemsModel getAllNewItemList...");
        try {
            while(rs.next())
                newOrderList.add(new newItemsModel(rs.getString("purchaseOrderNo"), rs.getString("purchaser"), 
                        rs.getString("supplierName"), rs.getString("dateFaxed"), rs.getString("deliveryStatus")));
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"SQLException inside getAllNewItemList in newItemsModel...");
        }
        return newOrderList;
    }
    

    /**
     * Search func
     * For the Daily Follow-Up table
     * @param optionValue
     * @param searchData
     * @return 
     */
    public static ArrayList<newItemsModel> getNewItemsWithSearch(String optionValue, String searchData){
        
        //JOptionPane.showMessageDialog(null,optionValue+" and "+searchData);
        
        ArrayList<newItemsModel> newItemList = new ArrayList<>();
        ResultSet rs = AccessLayer.getInstance().getAllNewItemUpdatesWithSearch(optionValue,searchData);
        try {
            while(rs.next())
                newItemList.add(new newItemsModel(rs.getString("purchaseOrderNo"), rs.getString("purchaser"), 
                        rs.getString("supplierName"), rs.getString("dateFaxed"), rs.getString("deliveryStatus")));
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"After catch... Error inside getNewItemsWithSearch..."); //error prompt to be changed
        }
        return newItemList;
    }
    
    
    /**
     * Search func
     * For the Weekly Order List table
     * get all the details inside the delivery table from the database
     * this function is called for the Weekly Order List table
     * @return an arraylist of delivery details
     * @param searchVal
     */
    public static ArrayList<newItemsModel> getAllNewOrderList(String searchVal){      
        ArrayList<newItemsModel> allNewOrderList = new ArrayList<>();    
        ResultSet rs = AccessLayer.getInstance().getNewOrderWithSearchInDB(searchVal);
        //JOptionPane.showMessageDialog(null, "Inside newItemsModel getAllNewItemList...");
        try {
            while(rs.next())
                allNewOrderList.add(new newItemsModel(rs.getString("purchaseOrderNo"), rs.getString("purchaser"), 
                        rs.getString("supplierName"), rs.getString("dateFaxed"), rs.getString("deliveryStatus")));
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"SQLException inside getAllNewOrderList in newItemsModel...");
        }
        return allNewOrderList;
    }
    
}

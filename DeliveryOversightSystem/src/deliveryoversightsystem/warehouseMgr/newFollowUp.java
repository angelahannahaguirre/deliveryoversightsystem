/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package deliveryoversightsystem.warehouseMgr;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import model.followUpResponseBridgeModel;
import model.newItemsModel;

/**
 *
 * @author Aimee
 */
public class newFollowUp extends javax.swing.JFrame {

    public static newFollowUp instance;
    
    public static void setInstance(newFollowUp aInstance) {
      instance = aInstance;
    }
    
    /**
     * Creates new form newFollowUp
     */
    public newFollowUp() {
        initComponents();
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
    }
    
    public static newFollowUp getInstance(){
        if(instance == null)
            instance = new newFollowUp();
        return instance;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        dosLabel = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        dailyFollowUpLabel = new javax.swing.JLabel();
        refreshBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        dailyFollowUpTable = new javax.swing.JTable();
        goBtn = new javax.swing.JButton();
        dailyFollowUpSearchField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        respondBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 153, 204));
        jPanel1.setPreferredSize(new java.awt.Dimension(764, 450));

        dosLabel.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        dosLabel.setForeground(new java.awt.Color(255, 255, 255));
        dosLabel.setText("Delivery Oversight System");

        dailyFollowUpLabel.setBackground(new java.awt.Color(255, 255, 255));
        dailyFollowUpLabel.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        dailyFollowUpLabel.setForeground(new java.awt.Color(255, 255, 255));
        dailyFollowUpLabel.setText("Daily Follow-Up");

        refreshBtn.setBackground(new java.awt.Color(255, 255, 255));
        refreshBtn.setForeground(new java.awt.Color(0, 153, 255));
        refreshBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/refreshBtn.png"))); // NOI18N
        refreshBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshBtnjButton1ActionPerformed(evt);
            }
        });

        dailyFollowUpTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Purchase Order No.", "Purchaser", "Supplier Name", "Date Faxed", "Delivery Status", "Follow-Up Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        dailyFollowUpTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dailyFollowUpTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(dailyFollowUpTable);

        goBtn.setBackground(new java.awt.Color(255, 255, 255));
        goBtn.setForeground(new java.awt.Color(0, 153, 255));
        goBtn.setText("GO");
        goBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                goBtnActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Purchase Order No.");

        respondBtn.setBackground(new java.awt.Color(255, 255, 255));
        respondBtn.setForeground(new java.awt.Color(0, 153, 255));
        respondBtn.setText("Respond To Follow-Up");
        respondBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                respondBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(308, 308, 308)
                .addComponent(respondBtn)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 719, Short.MAX_VALUE)
                            .addComponent(jSeparator3, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(dailyFollowUpSearchField, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(goBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(refreshBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(25, 25, 25))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dailyFollowUpLabel)
                            .addComponent(dosLabel))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(dosLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dailyFollowUpLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(dailyFollowUpSearchField, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)
                            .addComponent(goBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(refreshBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(respondBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 769, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 436, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void refreshBtnjButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshBtnjButton1ActionPerformed
        // TODO add your handling code here:
        updateFollowUpListTable(followUpResponseBridgeModel.getFollowUpAndResponseList());
    }//GEN-LAST:event_refreshBtnjButton1ActionPerformed

    private void goBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_goBtnActionPerformed
        // TODO add your handling code here:
        String searchVal = getDailyFollowUpSearchField().getText().trim();
        
        updateFollowUpListTable(followUpResponseBridgeModel.getFollowUpAndResponseListWithSearch(searchVal));  
           
        System.gc();
    }//GEN-LAST:event_goBtnActionPerformed

    private RespondToFollowUp_WM respondToBtn;
    
    private void respondBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_respondBtnActionPerformed
        // TODO add your handling code here:
        
        String followUpStats = fStatus;
        
        if(followUpStats.equalsIgnoreCase("Waiting for Response")){
            respondToBtn = new RespondToFollowUp_WM(purchaseNoID);
            respondToBtn.setVisible(true);
            //newFollowUp.instance.setEnabled(false);
        }else{
            JOptionPane.showMessageDialog(null, "Response for this follow-up has been sent.");
        }
        
        
        System.gc();
    }//GEN-LAST:event_respondBtnActionPerformed

//    /**
//     * get the data from the table at row i
//     * @param i row
//     * @return a String from row i
//     */
//    private String getResponseStatus(int i){
//        responseStatus = getDailyFollowUpTable().getValueAt(i, 5).toString();
//        return responseStatus;
//    }
    
    
//    public String response;
//    public String responseStatus;
    
    public String purchaseNoID;
    public String fStatus;
    
    private void dailyFollowUpTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dailyFollowUpTableMouseClicked
        // TODO add your handling code here:
        int i = evt.getY()/getDailyFollowUpTable().getRowHeight();
        if(evt.getClickCount() == 2 && i < getDailyFollowUpTable().getRowCount()){
            //setUpdateDependentOK(true);
            //setUpdateEmployeePanelValues(getDependentFromTable(i));
            purchaseNoID = getPurchaseOrderNo(i);
            fStatus = getFollowUpStatus(i);
            //response = getResponseStatus(i);
            System.gc();
        }
    }//GEN-LAST:event_dailyFollowUpTableMouseClicked

    /**
     * get the data from the table at row i
     * @param i row
     * @return a String from row i
     */
    private String getPurchaseOrderNo(int i){
        String purchaseNo = getDailyFollowUpTable().getValueAt(i, 0).toString();
        return purchaseNo;
    }
    
    /**
     * get the data from the table at row i
     * @param i row
     * @return a String from row i
     */
    private String getFollowUpStatus(int i){
        String fStats = getDailyFollowUpTable().getValueAt(i, 5).toString();
        return fStats;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(newFollowUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(newFollowUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(newFollowUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(newFollowUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new newFollowUp().setVisible(true);
            }
        });
    }

    private void showExitDialog(){
            warehouseManagerHome.instance.setEnabled(true);
            setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
    }
    
    private void formWindowClosing(java.awt.event.WindowEvent evt){
        showExitDialog();
    }
    
    /**
     * Getters and Setters
     * @return
     */
    
    public JTable getDailyFollowUpTable() {
        return dailyFollowUpTable;
    }

    public void setDailyFollowUpTable(JTable dailyFollowUpTable) {
        this.dailyFollowUpTable = dailyFollowUpTable;
    }

    public JTextField getDailyFollowUpSearchField() {
        return dailyFollowUpSearchField;
    }

    public void setDailyFollowUpSearchField(JTextField dailyFollowUpSearchField) {
        this.dailyFollowUpSearchField = dailyFollowUpSearchField;
    }

    
    
    /**
     * added by angela 12/30/16
     * @param newFollowUpList 
     * retrieves a new or a waiting follow-up delivery
     */
    public void updateFollowUpListTable(ArrayList<followUpResponseBridgeModel> newFollowUpList){ 
        
        //JOptionPane.showMessageDialog(null,"Getting table results...");
        if(newFollowUpList == null)
            return;
        DefaultTableModel model = (DefaultTableModel) getDailyFollowUpTable().getModel();
        int size = newFollowUpList.size(), modelRows = model.getRowCount();
        if(size > modelRows){
            for(int i = size-modelRows; i > 0; i--)
                model.addRow(new String[model.getColumnCount()]);
        }
        else if(modelRows > size){
            for(int i = modelRows-size; i > 0; i--)
                model.removeRow(0);
        }
        for(int i = 0; i < newFollowUpList.size(); i++){
            followUpResponseBridgeModel m = newFollowUpList.get(i);
            
            model.setValueAt(m.getPurchaseNo(),i,0);
            model.setValueAt(m.getPurchaserName(),i,1);
            model.setValueAt(m.getSuppName(),i,2);
            model.setValueAt(m.getFaxedDate(),i,3);
            model.setValueAt(m.getDeliveryStat(),i,4);
            model.setValueAt(m.getFollowUpFlag(),i,5);
            
        
        }
        System.gc();
    }
  
   
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel dailyFollowUpLabel;
    private javax.swing.JTextField dailyFollowUpSearchField;
    private javax.swing.JTable dailyFollowUpTable;
    private javax.swing.JLabel dosLabel;
    private javax.swing.JButton goBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JButton refreshBtn;
    private javax.swing.JButton respondBtn;
    // End of variables declaration//GEN-END:variables
}

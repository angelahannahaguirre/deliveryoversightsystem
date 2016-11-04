/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package deliveryoversightsystem.warehouseMgr;

import deliveryoversightsystem.warehouseMgr.warehouseManagerHome;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Aimee
 */
public class ViewUpdatesForWM extends javax.swing.JFrame {

    private static ViewUpdatesForWM instance;
    
    public static void setInstance(ViewUpdatesForWM aInstance) {
      instance = aInstance;
    }
    
    /**
     * Creates new form ViewUpdates
     */
    public ViewUpdatesForWM() {
        initComponents();
        instance = this;
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
    }
    
    public static ViewUpdatesForWM getInstance(){
        if(instance == null)
            instance = new ViewUpdatesForWM();
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
        jScrollPane1 = new javax.swing.JScrollPane();
        viewUpdatesTable = new javax.swing.JTable();
        dosLabel = new javax.swing.JLabel();
        searchField = new javax.swing.JTextField();
        goBtn = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        invoiceLabel = new javax.swing.JLabel();
        invoiceField = new javax.swing.JTextField();
        invoiceDateLabel = new javax.swing.JLabel();
        dateDeliveredLabel = new javax.swing.JLabel();
        manualDateLabel = new javax.swing.JLabel();
        manualDateField = new javax.swing.JTextField();
        electronicLabel = new javax.swing.JLabel();
        electronicField = new javax.swing.JTextField();
        referenceLabel = new javax.swing.JLabel();
        referenceField = new javax.swing.JTextField();
        dateForwardedLabel = new javax.swing.JLabel();
        dateForwardedField = new javax.swing.JTextField();
        dateDeliveredField = new javax.swing.JTextField();
        invoiceDateField = new javax.swing.JTextField();
        acceptItemLabel = new javax.swing.JLabel();
        enterBtn = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        refreshBtn = new javax.swing.JButton();
        viewUpdatesCB = new javax.swing.JComboBox();
        homeBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 153, 204));

        viewUpdatesTable.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        viewUpdatesTable.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        viewUpdatesTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Purchaser", "Purchase Order No.", "Supplier Name", "Data Faxed ", "Invoice No.", "Invoice Date", "Date Delivered", "Manual RR Date", "Electronic RR Date", "Reference RR No.", "Date Forwarded"
            }
        ));
        viewUpdatesTable.setGridColor(new java.awt.Color(153, 153, 153));
        viewUpdatesTable.setSelectionBackground(new java.awt.Color(0, 51, 102));
        jScrollPane1.setViewportView(viewUpdatesTable);

        dosLabel.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        dosLabel.setForeground(new java.awt.Color(255, 255, 255));
        dosLabel.setText("Delivery Oversight System");

        searchField.setText("1149283");
        searchField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchFieldActionPerformed(evt);
            }
        });

        goBtn.setBackground(new java.awt.Color(255, 255, 255));
        goBtn.setForeground(new java.awt.Color(0, 153, 255));
        goBtn.setText("GO");

        invoiceLabel.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        invoiceLabel.setForeground(new java.awt.Color(255, 255, 255));
        invoiceLabel.setText("Invoice No.");

        invoiceDateLabel.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        invoiceDateLabel.setForeground(new java.awt.Color(255, 255, 255));
        invoiceDateLabel.setText("Invoice Date");

        dateDeliveredLabel.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        dateDeliveredLabel.setForeground(new java.awt.Color(255, 255, 255));
        dateDeliveredLabel.setText("Date Delivered");

        manualDateLabel.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        manualDateLabel.setForeground(new java.awt.Color(255, 255, 255));
        manualDateLabel.setText("Manual RR Date");

        electronicLabel.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        electronicLabel.setForeground(new java.awt.Color(255, 255, 255));
        electronicLabel.setText("Electronic RR Date");

        referenceLabel.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        referenceLabel.setForeground(new java.awt.Color(255, 255, 255));
        referenceLabel.setText("Reference RR No.");

        dateForwardedLabel.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        dateForwardedLabel.setForeground(new java.awt.Color(255, 255, 255));
        dateForwardedLabel.setText("Date Forwarded");

        invoiceDateField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                invoiceDateFieldActionPerformed(evt);
            }
        });

        acceptItemLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        acceptItemLabel.setForeground(new java.awt.Color(255, 255, 255));
        acceptItemLabel.setText("Accept Item Delivery");

        enterBtn.setBackground(new java.awt.Color(255, 255, 255));
        enterBtn.setForeground(new java.awt.Color(0, 153, 255));
        enterBtn.setText("ENTER");
        enterBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enterBtnActionPerformed(evt);
            }
        });

        refreshBtn.setBackground(new java.awt.Color(255, 255, 255));
        refreshBtn.setForeground(new java.awt.Color(0, 153, 255));
        refreshBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/refreshBtn.png"))); // NOI18N
        refreshBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshBtnjButton1ActionPerformed(evt);
            }
        });

        viewUpdatesCB.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Purchase Order No.", "Purchaser", "Date", "Item 4" }));
        viewUpdatesCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewUpdatesCBActionPerformed(evt);
            }
        });

        homeBtn.setBackground(new java.awt.Color(255, 255, 255));
        homeBtn.setForeground(new java.awt.Color(0, 153, 255));
        homeBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/home_25.png"))); // NOI18N
        homeBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homeBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(dosLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 182, Short.MAX_VALUE)
                                .addComponent(homeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(viewUpdatesCB, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(goBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(refreshBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jSeparator1)
                            .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(25, 25, 25))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(134, 134, 134)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(dateDeliveredLabel)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                                        .addComponent(dateDeliveredField, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(invoiceLabel)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(invoiceField, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addComponent(electronicLabel)
                                                .addGap(18, 18, 18))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(dateForwardedLabel)
                                                .addGap(31, 31, 31)))
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(electronicField, javax.swing.GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)
                                            .addComponent(dateForwardedField))))
                                .addGap(89, 89, 89)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(invoiceDateLabel)
                                                .addComponent(manualDateLabel))
                                            .addGap(26, 26, 26)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(manualDateField, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(invoiceDateField, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(referenceLabel)
                                            .addGap(18, 18, 18)
                                            .addComponent(referenceField)))
                                    .addComponent(enterBtn)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(84, 84, 84)
                                .addComponent(acceptItemLabel)))
                        .addContainerGap(175, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(dosLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(viewUpdatesCB, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(goBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(refreshBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(homeBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(acceptItemLabel)
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(invoiceLabel)
                    .addComponent(invoiceField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(invoiceDateLabel)
                    .addComponent(invoiceDateField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dateDeliveredLabel)
                    .addComponent(dateDeliveredField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(manualDateLabel)
                    .addComponent(manualDateField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(electronicField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(electronicLabel)
                    .addComponent(referenceLabel)
                    .addComponent(referenceField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dateForwardedLabel)
                    .addComponent(dateForwardedField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(enterBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void refreshBtnjButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshBtnjButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_refreshBtnjButton1ActionPerformed

    private warehouseManagerHome WM;
    private void homeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homeBtnActionPerformed
        // TODO add your handling code here:
        WM = new warehouseManagerHome();
        WM.setVisible(true);
    }//GEN-LAST:event_homeBtnActionPerformed

    private void enterBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enterBtnActionPerformed
        // TODO add your handling code here:
        JFrame frame = new JFrame();
        
        int dialogResult = JOptionPane.showConfirmDialog (null, "Would You Like to Accept the Item Delivered?","Confirmation",0);
        if(dialogResult == JOptionPane.YES_OPTION){
            JOptionPane.showMessageDialog(frame,"Successfully Accepted the Item!");
        }else{
            JOptionPane.showMessageDialog(frame,"Cancelled!");
        }
    }//GEN-LAST:event_enterBtnActionPerformed

    private void searchFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchFieldActionPerformed

    private void viewUpdatesCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewUpdatesCBActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_viewUpdatesCBActionPerformed

    private void invoiceDateFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_invoiceDateFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_invoiceDateFieldActionPerformed

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
            java.util.logging.Logger.getLogger(ViewUpdatesForWM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewUpdatesForWM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewUpdatesForWM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewUpdatesForWM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewUpdatesForWM().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel acceptItemLabel;
    private javax.swing.JTextField dateDeliveredField;
    private javax.swing.JLabel dateDeliveredLabel;
    private javax.swing.JTextField dateForwardedField;
    private javax.swing.JLabel dateForwardedLabel;
    private javax.swing.JLabel dosLabel;
    private javax.swing.JTextField electronicField;
    private javax.swing.JLabel electronicLabel;
    private javax.swing.JButton enterBtn;
    private javax.swing.JButton goBtn;
    private javax.swing.JButton homeBtn;
    private javax.swing.JTextField invoiceDateField;
    private javax.swing.JLabel invoiceDateLabel;
    private javax.swing.JTextField invoiceField;
    private javax.swing.JLabel invoiceLabel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextField manualDateField;
    private javax.swing.JLabel manualDateLabel;
    private javax.swing.JTextField referenceField;
    private javax.swing.JLabel referenceLabel;
    private javax.swing.JButton refreshBtn;
    private javax.swing.JTextField searchField;
    private javax.swing.JComboBox viewUpdatesCB;
    private javax.swing.JTable viewUpdatesTable;
    // End of variables declaration//GEN-END:variables
}

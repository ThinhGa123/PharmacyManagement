package com.mycompany.pharmacymanagementproject.view;

import com.mycompany.pharmacymanagementproject.controller.BillController;
import com.mycompany.pharmacymanagementproject.controller.MedicineController;
import com.mycompany.pharmacymanagementproject.controller.UserController;
import com.mycompany.pharmacymanagementproject.dto.BillDTO;
import com.mycompany.pharmacymanagementproject.model.Bill;
import com.mycompany.pharmacymanagementproject.model.BillDetail;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextArea;

/**
 *
 * @author nhut0
 */
public class ConfirmBill extends javax.swing.JDialog {

    private static BillDTO billDTO;
    private static Bill bill = new Bill();
    private MedicineController medicineController = new MedicineController();
    private BillController billController = new BillController();
    private UserController userController = new UserController();

    public ConfirmBill(java.awt.Frame parent, boolean modal, BillDTO billDTO) {
        super(parent, modal);
        this.billDTO = billDTO;
        setLocationRelativeTo(null);
        initComponents();
        try {
            showInfoBill(billDTO);
        } catch (SQLException ex) {
            Logger.getLogger(ConfirmBill.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void showInfoBill(BillDTO billDTO) throws SQLException {
        txtInfoBill.append("==================THÔNG TIN HÓA ĐƠN======================\n\n");
        txtInfoBill.append("STT\tTên\tSố lượng\tThành tiền\n");
       

//        bill.setUpdateTime((java.sql.Date) Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()));
        int count = 1;
        double sum = 0;
        for (BillDetail billDetail : billDTO.getBilldetails()) {
            sum += billDetail.getTotalPrice();
            txtInfoBill.append(String.valueOf(count++) + "\t" + medicineController.getById(billDetail.getIdMedicine()).getName() + "\t" + billDetail.getQuantity() + "\t" + billDetail.getTotalPrice() + "  VND\n");
            txtInfoBill.append("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -\n");

        }

        bill.setIdBill(billDTO.getIdBill());
        bill.setTotalMoney(sum);
        bill.setStatus(true);
        bill.setUpdateTime(LocalDateTime.now().toString());
        System.out.println(bill);

        txtInfoBill.append("\n========================================Tổng tiền: " + sum + " VND===============");
        txtInfoBill.append("\nNgày lập: " + billDTO.getCreationTime());
        txtInfoBill.append("\nTên khách hàng: " + userController.getById(billDTO.getIDUser()).getFullName());
        txtInfoBill.append("\nMã nhân viên: " + billDTO.getIDUser());

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnConfirm = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtInfoBill = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Xác nhận hóa đơn");

        btnConfirm.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/pharmacymanagementproject/img/Actions-document-edit-icon-16.png"))); // NOI18N
        btnConfirm.setText("Xác nhận thanh toán");
        btnConfirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmActionPerformed(evt);
            }
        });
        btnConfirm.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnConfirmKeyPressed(evt);
            }
        });

        txtInfoBill.setEditable(false);
        txtInfoBill.setColumns(20);
        txtInfoBill.setRows(5);
        jScrollPane2.setViewportView(txtInfoBill);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 449, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnConfirm, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 282, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnConfirm)
                .addGap(4, 4, 4))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnConfirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmActionPerformed
        try {
            //update Bill (status, and total money)
            billController.save(bill);
            setVisible(false);

        } catch (SQLException ex) {
            Logger.getLogger(ConfirmBill.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnConfirmActionPerformed

    private void btnConfirmKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnConfirmKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            try {
                //update Bill (status, and total money)
                billController.save(bill);
                setVisible(false);
            } catch (SQLException ex) {
                Logger.getLogger(ConfirmBill.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnConfirmKeyPressed

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
            java.util.logging.Logger.getLogger(ConfirmBill.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConfirmBill.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConfirmBill.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConfirmBill.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ConfirmBill dialog = new ConfirmBill(new javax.swing.JFrame(), true, billDTO);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setLocationRelativeTo(null);
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConfirm;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea txtInfoBill;
    // End of variables declaration//GEN-END:variables
}

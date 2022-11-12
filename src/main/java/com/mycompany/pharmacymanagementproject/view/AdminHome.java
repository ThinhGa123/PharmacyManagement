package com.mycompany.pharmacymanagementproject.view;

import com.mycompany.pharmacymanagementproject.controller.UserController;
import com.mycompany.pharmacymanagementproject.dto.UserDTO;
import java.awt.CardLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class AdminHome extends javax.swing.JFrame {

    private UserDTO userDTO;

    private HomePanel jpanelHome = new HomePanel();
    private CardLayout cardLayout = new CardLayout();
    private UserManagementPanel jpanelUserManagement = new UserManagementPanel();

    public AdminHome(UserDTO userDTO) {
        initComponents();
        this.userDTO = userDTO;

        setInforUser(userDTO);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setVisible(true);

        jpanelCon.setLayout(cardLayout);

        jpanelCon.add(jpanelHome, "1");
        jpanelCon.add(new MedicinePanel(userDTO), "3");
        jpanelCon.add(new MedicineUpdatePanel(userDTO), "4");
        jpanelCon.add(jpanelUserManagement, "5");
        cardLayout.show(jpanelCon, "1");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jtbTabar = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jToolBar1 = new javax.swing.JToolBar();
        btnLogin = new javax.swing.JButton();
        jSeparator6 = new javax.swing.JToolBar.Separator();
        btnBuyMedicine = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JToolBar.Separator();
        btnCategoryMedicien3 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jToolBar2 = new javax.swing.JToolBar();
        btnUserMan = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        btnCategoryMedicien = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lableFullname = new javax.swing.JLabel();
        lableRole = new javax.swing.JLabel();
        btnLogout = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jpanelCon = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Quản lý nhà thuốc");

        jtbTabar.setToolTipText("");
        jtbTabar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jtbTabar.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentHidden(java.awt.event.ComponentEvent evt) {
                jtbTabarComponentHidden(evt);
            }
        });

        jToolBar1.setRollover(true);

        btnLogin.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/pharmacymanagementproject/img/10207-man-student-light-skin-tone-icon-24.png"))); // NOI18N
        btnLogin.setText("Đăng nhập ");
        btnLogin.setFocusable(false);
        btnLogin.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnLogin.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnLogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnLoginMouseClicked(evt);
            }
        });
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });
        jToolBar1.add(btnLogin);
        jToolBar1.add(jSeparator6);

        btnBuyMedicine.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnBuyMedicine.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/pharmacymanagementproject/img/740pill_100923.png"))); // NOI18N
        btnBuyMedicine.setText("Bán thuốc");
        btnBuyMedicine.setFocusable(false);
        btnBuyMedicine.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnBuyMedicine.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnBuyMedicine.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuyMedicineActionPerformed(evt);
            }
        });
        jToolBar1.add(btnBuyMedicine);
        jToolBar1.add(jSeparator3);

        btnCategoryMedicien3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnCategoryMedicien3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/pharmacymanagementproject/img/Actions-view-choose-icon-24.png"))); // NOI18N
        btnCategoryMedicien3.setText("Hóa đơn bán thuốc");
        btnCategoryMedicien3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnCategoryMedicien3.setBorderPainted(false);
        btnCategoryMedicien3.setFocusable(false);
        btnCategoryMedicien3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCategoryMedicien3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnCategoryMedicien3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCategoryMedicien3ActionPerformed(evt);
            }
        });
        jToolBar1.add(btnCategoryMedicien3);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 765, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jtbTabar.addTab("Hệ thống", jPanel1);

        jToolBar2.setRollover(true);

        btnUserMan.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnUserMan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/pharmacymanagementproject/img/10207-man-student-light-skin-tone-icon-24.png"))); // NOI18N
        btnUserMan.setText("Hồ sơ nhân viên");
        btnUserMan.setFocusable(false);
        btnUserMan.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnUserMan.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnUserMan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnUserManMouseClicked(evt);
            }
        });
        btnUserMan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUserManActionPerformed(evt);
            }
        });
        jToolBar2.add(btnUserMan);
        jToolBar2.add(jSeparator1);

        btnCategoryMedicien.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnCategoryMedicien.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/pharmacymanagementproject/img/medicine_pill_tablet_care_icon_143450.png"))); // NOI18N
        btnCategoryMedicien.setText("Cập nhật thuốc");
        btnCategoryMedicien.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnCategoryMedicien.setBorderPainted(false);
        btnCategoryMedicien.setFocusable(false);
        btnCategoryMedicien.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCategoryMedicien.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnCategoryMedicien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCategoryMedicienActionPerformed(evt);
            }
        });
        jToolBar2.add(btnCategoryMedicien);
        jToolBar2.add(jSeparator2);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar2, javax.swing.GroupLayout.DEFAULT_SIZE, 765, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jtbTabar.addTab("Quản lý", jPanel2);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 765, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 60, Short.MAX_VALUE)
        );

        jtbTabar.addTab("Tìm kiếm", jPanel3);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 765, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 60, Short.MAX_VALUE)
        );

        jtbTabar.addTab("Thống kê", jPanel4);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 765, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 60, Short.MAX_VALUE)
        );

        jtbTabar.addTab("Trợ giúp", jPanel5);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Wellcome:");

        lableFullname.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lableFullname.setForeground(new java.awt.Color(51, 102, 255));
        lableFullname.setText("Nguyễn Văn A");
        lableFullname.setOpaque(true);

        lableRole.setForeground(new java.awt.Color(51, 51, 255));

        btnLogout.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnLogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/pharmacymanagementproject/img/logout-icon-16.png"))); // NOI18N
        btnLogout.setText("Đăng xuất");
        btnLogout.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnLogout.setName(""); // NOI18N
        btnLogout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnLogoutMouseClicked(evt);
            }
        });
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 102, 102));
        jLabel2.setText("Thay đổi mật khẩu");
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnLogout, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lableFullname, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lableRole, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel2))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lableRole))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lableFullname, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel7.setBackground(new java.awt.Color(0, 204, 255));
        jPanel7.setPreferredSize(new java.awt.Dimension(5, 0));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jpanelConLayout = new javax.swing.GroupLayout(jpanelCon);
        jpanelCon.setLayout(jpanelConLayout);
        jpanelConLayout.setHorizontalGroup(
            jpanelConLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jpanelConLayout.setVerticalGroup(
            jpanelConLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 388, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jpanelCon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jtbTabar))
                .addGap(4, 4, 4))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jtbTabar, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE)
                    .addComponent(jpanelCon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(4, 4, 4))
        );

        jtbTabar.getAccessibleContext().setAccessibleName("c");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void setInforUser(UserDTO user) {
        lableFullname.setText(user.getFullName());
        lableRole.setText(userDTO.getRole());

    }

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed

    }//GEN-LAST:event_btnLoginActionPerformed

    private void btnBuyMedicineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuyMedicineActionPerformed
        cardLayout.show(jpanelCon, "3");

    }//GEN-LAST:event_btnBuyMedicineActionPerformed

    private void btnCategoryMedicien3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCategoryMedicien3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCategoryMedicien3ActionPerformed

    private void btnCategoryMedicienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCategoryMedicienActionPerformed
        cardLayout.show(jpanelCon, "4");
    }//GEN-LAST:event_btnCategoryMedicienActionPerformed

    private void jtbTabarComponentHidden(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jtbTabarComponentHidden
        // TODO add your handling code here:
    }//GEN-LAST:event_jtbTabarComponentHidden

    private void btnLoginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLoginMouseClicked
        this.setVisible(false);
        LoginDialog dialog = new LoginDialog(this, true);
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
    }//GEN-LAST:event_btnLoginMouseClicked

    private void btnLogoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLogoutMouseClicked
        this.setVisible(false);
        LoginDialog dialog = new LoginDialog(this, true);
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
    }//GEN-LAST:event_btnLogoutMouseClicked

    private void btnUserManActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUserManActionPerformed
        cardLayout.show(jpanelCon, "5");
    }//GEN-LAST:event_btnUserManActionPerformed

    private void btnUserManMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUserManMouseClicked
        cardLayout.show(jpanelCon, "5");

    }//GEN-LAST:event_btnUserManMouseClicked

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnLogoutActionPerformed

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        // change password:
       ChangePass changePass = new ChangePass(userDTO); 
       changePass.setVisible(true);
       changePass.setLocationRelativeTo(null);
       
        
    }//GEN-LAST:event_jLabel2MouseClicked

//    public static void main(String args[]) {
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new AdminHome(userDTO).setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuyMedicine;
    private javax.swing.JButton btnCategoryMedicien;
    private javax.swing.JButton btnCategoryMedicien3;
    private javax.swing.JButton btnLogin;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnUserMan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JToolBar.Separator jSeparator3;
    private javax.swing.JToolBar.Separator jSeparator6;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JToolBar jToolBar2;
    private javax.swing.JPanel jpanelCon;
    private javax.swing.JTabbedPane jtbTabar;
    private javax.swing.JLabel lableFullname;
    private javax.swing.JLabel lableRole;
    // End of variables declaration//GEN-END:variables
}

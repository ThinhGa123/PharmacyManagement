/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pharmacymanagementproject.controller;

import com.mycompany.pharmacymanagementproject.dao.UserDAO;
import com.mycompany.pharmacymanagementproject.model.User;
import com.mycompany.pharmacymanagementproject.view.ChangePass;
import com.mycompany.pharmacymanagementproject.view.LoginDialog;
import java.awt.Dialog;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author nhut0
 */
public class ChangePassController {

    private final UserDAO userDAO = new UserDAO();

    public void changePass(ChangePass changePass, int userId) {
        try {
            User user = userDAO.getUserById(userId);
            String passCurr = String.valueOf(changePass.getPassCurr().getText());
            String passNew = String.valueOf(changePass.getPassNew().getText());
            System.out.println(passCurr);
            System.out.println(passNew);
            if (user.getPassword().equals(passCurr)) {
                user.setPassword(passNew);
                userDAO.updateUser(user);
                JOptionPane.showMessageDialog(changePass, "Update thành công!!");
               
//                changePass.setVisible(false);
//                LoginDialog dialog = new LoginDialog(new javax.swing.JFrame(), true);
//                dialog.setLocationRelativeTo(null);
//                dialog.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(changePass, "Kiểm tra mật khâu hiện tại!!");
            }

        } catch (SQLException ex) {
            Logger.getLogger(ChangePassController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

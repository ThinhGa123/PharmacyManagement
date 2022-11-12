package com.mycompany.pharmacymanagementproject.controller;

import com.mycompany.pharmacymanagementproject.dao.UserDAO;
import com.mycompany.pharmacymanagementproject.dto.UserDTO;
import com.mycompany.pharmacymanagementproject.view.AdminHome;
import com.mycompany.pharmacymanagementproject.view.LoginDialog;
import com.mycompany.pharmacymanagementproject.view.UserHome;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class LoginController {

    private LoginDialog dialog;
    public static UserDTO userDTO;
    private final UserDAO userDAO;

    public LoginController(LoginDialog dialog) {
        this.userDAO = new UserDAO();
        this.dialog = dialog;
        this.userDTO = userDTO;
    }

    public UserDTO checkLogin(String userName, String pass) throws SQLException {
        System.out.println("username: " + userName);
        System.out.println("pass: " + pass);

        if (userName.isEmpty() || pass.isEmpty()) {
            JOptionPane.showMessageDialog(dialog, "Vui lòng nhập thông tin đăng nhập!!");

        } else {
            userDTO = userDAO.getUser(userName, pass);
            System.out.println(userDTO);
            if (userDTO == null) {
                JOptionPane.showMessageDialog(dialog, "Login thất bại. Vui lòng kiểm tra lại thông tin đăng nhập!!");

            } else {
                if (userDTO.getRole().equals("admin")) {
                    dialog.setVisible(false);
                    System.out.println(userDTO);
                    AdminHome homePage = new AdminHome(userDTO);
                    homePage.setVisible(true);
                } else if (userDTO.getRole().equals("user")) {
                    System.out.println(userDTO);
                    dialog.setVisible(false);
                    UserHome homePage = new UserHome(userDTO);
                    homePage.setVisible(true);
                }
            }
            return userDTO;
        }
        return userDTO;
    }

}

package com.mycompany.pharmacymanagementproject;


import com.mycompany.pharmacymanagementproject.view.LoginDialog;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author nhut0
 */
public class Main {

    public static void main(String[] args) {

        LoginDialog dialog = new LoginDialog(new javax.swing.JFrame(), true);
//        dialog.addWindowListener(new java.awt.event.WindowAdapter() {
//            @Override
//            public void windowClosing(java.awt.event.WindowEvent e) {
//                System.exit(0);
//            }
//        });
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);

    }

}

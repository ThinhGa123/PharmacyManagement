/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pharmacymanagementproject.controller;

import com.mycompany.pharmacymanagementproject.dao.CustomerDAO;
import com.mycompany.pharmacymanagementproject.dao.UserDAO;
import com.mycompany.pharmacymanagementproject.model.Customer;
import com.mycompany.pharmacymanagementproject.view.MedicinePanel;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author nhut0
 */
public class CustomerController {

    private final CustomerDAO customerDAO = new CustomerDAO();

    public void searchByPhoneCustomer(MedicinePanel medicinePanel, String phone) throws SQLException {
        Customer customer = customerDAO.getByPhone(phone);

        //customer = customerController.getByPhone(phone);
        if (customer == null) {
            medicinePanel.getNameCustomer().setText("");
            medicinePanel.getIdCus().setText("");
        } else {
            medicinePanel.getNameCustomer().setText(customer.getName());
            medicinePanel.getIdCus().setText(String.valueOf(customer.getIdCustomer()));
        }

    }
    public void addCustomer(MedicinePanel medicinePanel) {                                             
        String phone = medicinePanel.getPhoneCus().getText().toString();
        String fullName = medicinePanel.getNameCustomer().getText().toString();
        if (phone.isEmpty() || fullName.isEmpty()) {
            JOptionPane.showMessageDialog(medicinePanel, "Vui lòng điền đầy đủ thông tin");
        } else {
            try {
                Customer cus = new Customer();
                cus.setName(fullName);
                cus.setPhone(phone);
                cus = customerDAO.post(cus);
                System.out.println(cus);
                medicinePanel.getIdCus().setText(String.valueOf(cus.getIdCustomer()));
                JOptionPane.showMessageDialog(medicinePanel, "Thêm mới khách hàng thành công!");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(medicinePanel, "Vui lòng thử lại với số điện thoại mới!");
            }
        }

    }     

    public Customer getById(int id) throws SQLException {
        return customerDAO.getById(id);
    }

    public List<Customer> get() throws SQLException {
        return customerDAO.get();
    }

    public Customer getByPhone(String phone) throws SQLException {
        return customerDAO.getByPhone(phone);
    }

    public Customer postCustomer(Customer cus) throws SQLException {
        return customerDAO.post(cus);
    }

}

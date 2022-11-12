/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pharmacymanagementproject.dao;

import com.mycompany.pharmacymanagementproject.dto.UserDTO;
import com.mycompany.pharmacymanagementproject.model.Customer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author nhut0
 */
public class CustomerDAO {

    private final MyConnection connection = new MyConnection();

    public List<Customer> get() throws SQLException {
        List<Customer> customers = new ArrayList();
        Connection conn = connection.getSqlConnection();
        String sql = "select * from customers";
        PreparedStatement ptsm = conn.prepareStatement(sql);
        ResultSet rs = ptsm.executeQuery();
        while (rs.next()) {
            Customer customer = new Customer();
            customer.setIdCustomer(rs.getInt("idcustomer"));
            customer.setName(rs.getString("fullname"));
            customer.setPhone(rs.getString("phone"));

            customers.add(customer);
        }
        return customers;
    }

    public Customer getByPhone(String phone) throws SQLException {
        Customer customer = null;
        Connection conn = connection.getSqlConnection();
        String sql = "select * from customers where phone = ?";
        PreparedStatement ptsm = conn.prepareStatement(sql);
        ptsm.setString(1, phone);
        ResultSet rs = ptsm.executeQuery();
        while (rs.next()) {
            customer = new Customer();
            customer.setIdCustomer(rs.getInt("idcustomer"));
            customer.setName(rs.getString("fullname"));
            customer.setPhone(rs.getString("phone"));
        }
        System.out.println(customer);
        return customer;
    }

    public Customer getById(int id) throws SQLException {
        Customer customer = null;
        Connection conn = connection.getSqlConnection();
        String sql = "select * from customers where idcustomer = ?";
        PreparedStatement ptsm = conn.prepareStatement(sql);
        ptsm.setInt(1, id);
        ResultSet rs = ptsm.executeQuery();
        while (rs.next()) {
            customer = new Customer();
            customer.setIdCustomer(rs.getInt("idcustomer"));
            customer.setName(rs.getString("fullname"));
            customer.setPhone(rs.getString("phone"));
            ;
        }
        return customer;
    }

    public Customer post(Customer cus) throws SQLException {
        Connection conn = connection.getSqlConnection();
        String sql = "INSERT INTO `customers`(`phone`, `fullname`)\n"
                + "VALUES(?, ?)";

        PreparedStatement ptsm = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ptsm.setString(1, cus.getPhone());
        ptsm.setString(2, cus.getName());

        ptsm.executeUpdate();
        ResultSet rs = ptsm.getGeneratedKeys();
        if (rs.next()) {
            System.out.println("create_customer_success : " + getById(rs.getInt(1)));
        }
        return getById(rs.getInt(1));
    }
}

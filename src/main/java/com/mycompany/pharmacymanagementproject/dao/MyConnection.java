package com.mycompany.pharmacymanagementproject.dao;

import com.google.inject.Inject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Class connect database
 */

public class MyConnection {

    public Connection getSqlConnection() {
        try {
            //Connect DB 
            Connection connection = (Connection) DriverManager
                    .getConnection("jdbc:mysql://localhost:3306/phramacy_management_db", "root", "");

            System.out.println("Success");

            return connection;
        } catch (SQLException e) {
            System.out.println("login fail");
            e.printStackTrace();
            return null;
        }
    }
}

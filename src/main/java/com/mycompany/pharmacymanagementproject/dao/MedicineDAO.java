/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pharmacymanagementproject.dao;

import com.mycompany.pharmacymanagementproject.dto.UserDTO;
import com.mycompany.pharmacymanagementproject.model.Medicine;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author nhut0
 */
public class MedicineDAO {

    private final MyConnection connection = new MyConnection();

    public List<Medicine> getAll() throws SQLException {
        List<Medicine> medicines = new ArrayList();
        Connection conn = connection.getSqlConnection();
        String sql = "select * from medicines";
        PreparedStatement ptsm = conn.prepareStatement(sql);
        ResultSet rs = ptsm.executeQuery();
        while (rs.next()) {
            Medicine medicine = new Medicine();
            medicine.setIdMedicine(rs.getInt("idmedicine"));
            medicine.setName(rs.getString("namemedicine"));
            medicine.setElement(rs.getString("element"));
            medicine.setImage(rs.getString("image"));
            medicine.setProvider(rs.getString("provider"));
            medicine.setAmountInventory(rs.getInt("amountinventory"));
            medicine.setPrice(rs.getLong("price"));
            medicine.setExpirationDate(rs.getString("expirationdate"));
            medicine.setUnit(rs.getString("unit"));
            medicine.setUses(rs.getString("uses"));
            medicines.add(medicine);
        }
        System.out.println(medicines);
        return medicines;
    }

    public Medicine getById(int id) throws SQLException {
        Medicine medicine = null;
        Connection conn = connection.getSqlConnection();
        String sql = "select * from medicines where idmedicine =  " + id;
        PreparedStatement ptsm = conn.prepareStatement(sql);
        ResultSet rs = ptsm.executeQuery();

        if (rs.next()) {
            medicine = new Medicine();
            medicine.setIdMedicine(rs.getInt("idmedicine"));
            medicine.setName(rs.getString("namemedicine"));
            medicine.setElement(rs.getString("element"));
            medicine.setImage(rs.getString("image"));
            medicine.setProvider(rs.getString("provider"));
            medicine.setAmountInventory(rs.getInt("amountinventory"));
            medicine.setPrice(rs.getLong("price"));
            medicine.setExpirationDate(rs.getString("expirationdate"));
            medicine.setUnit(rs.getString("unit"));
            medicine.setUnit(rs.getString("uses"));

        } else {
            System.out.println("khong tim thay");
        }
        conn.close();
        System.out.println(medicine);
        return medicine;
    }

    public Medicine create(Medicine medicine) throws SQLException {
        Connection conn = connection.getSqlConnection();

        String sql
                = "INSERT INTO `medicines`(\n"
                + "    `namemedicine`,\n"
                + "    `element`,\n"
                + "    `image`,\n"
                + "    `provider`,\n"
                + "    `amountinventory`,\n"
                + "    `price`,\n"
                + "    `expirationdate`,\n"
                + "    `iduser`,\n"
                + "    `unit`,\n"
                + "    `uses`\n"
                + ")\n"
                + "VALUES(\n"
                + "    ?,\n"
                + "    ?,\n"
                + "    ?,\n"
                + "    ?,\n"
                + "    ?,\n"
                + "    ?,\n"
                + "    ?,\n"
                + "    ?,\n"
                + "    ?,\n"
                + "   ?\n"
                + ")";
        PreparedStatement pstm = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        pstm.setString(1, medicine.getName());
        pstm.setString(2, medicine.getElement());
        pstm.setString(3, medicine.getImage());
        pstm.setString(4, medicine.getProvider());
        pstm.setInt(5, medicine.getAmountInventory());
        pstm.setDouble(6, medicine.getPrice());
        pstm.setString(7, medicine.getExpirationDate());
        pstm.setInt(8, medicine.getIdUser());
        pstm.setString(9, medicine.getUnit());
        pstm.setString(10, medicine.getUses());
        pstm.executeUpdate();
        ResultSet rs = pstm.getGeneratedKeys();
        if (rs.next()) {
            System.out.println("create_medicine_success : " + getById(rs.getInt(1)));
        }
        return getById(rs.getInt(1));

    }

    public void update(Medicine medicine) throws SQLException {
        Connection conn = connection.getSqlConnection();
        String sql
                = "UPDATE\n"
                + "    `medicines`\n"
                + "SET\n"
                + "    `namemedicine` = ?,\n"
                + "    `element` = ?,\n"
                + //  "    `image` = ?,\n" +
                "    `provider` = ?,\n"
                + "    `amountinventory` = ?,\n"
                + "    `price` = ?,\n"
                + "    `expirationdate` = ?,\n"
                + "    `unit` = ?,\n"
                + "    `uses` = ?\n"
                + "WHERE\n"
                + "    idmedicine = ?";
        PreparedStatement ptsm = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ptsm.setString(1, medicine.getName());
        ptsm.setString(2, medicine.getElement());
        // ptsm.setString(3, medicine.getImage());
        ptsm.setString(3, medicine.getProvider());
        ptsm.setInt(4, medicine.getAmountInventory());
        ptsm.setDouble(5, medicine.getPrice());
        ptsm.setString(6, medicine.getExpirationDate());
        ptsm.setString(7, medicine.getUnit());

        ptsm.setString(8, medicine.getUses());
        ptsm.setInt(9, medicine.getIdMedicine());

        ptsm.executeUpdate();
        ResultSet rs = ptsm.getGeneratedKeys();
        if (rs.next()) {
            //System.out.println("Update_user_success : " + getById(rs.getInt(1)));
        }
        // return getById(rs.getInt(1));
    }

    public boolean delete(int idMedicine) throws SQLException {

        boolean check = false;
        try {
            Connection conn = connection.getSqlConnection();
            String sql = "DELETE FROM `medicines` WHERE idmedicine = ?";
            PreparedStatement pstm = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pstm.setInt(1, idMedicine);
            pstm.executeUpdate();
            System.out.println("Delete_user_success : " + idMedicine);
            check = true;
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return check;
    }
}

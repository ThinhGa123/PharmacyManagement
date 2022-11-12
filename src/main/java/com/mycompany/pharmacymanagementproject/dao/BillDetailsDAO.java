/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pharmacymanagementproject.dao;

import com.mycompany.pharmacymanagementproject.dto.BillDTO;
import com.mycompany.pharmacymanagementproject.model.Bill;
import com.mycompany.pharmacymanagementproject.model.BillDetail;
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
public class BillDetailsDAO {

    private final MyConnection connection = new MyConnection();

//    public booelean addListBillDetail(List<BillDetail> billDetails){
//        Connection conn = connection.getSqlConnection();
//    }
    public void addBillDetail(BillDetail billDetail) throws SQLException {
        Connection conn = connection.getSqlConnection();
        String sql
                = "INSERT INTO `billdetails`(\n"
                + "    `idbill`,"
                + "    `idmedicine`,"
                + "    `quantity`,"
                + "    `totalprice`,"
                + "    `price`"
                + ")"
                + "VALUES("
                + "    ?,"
                + "    ?,"
                + "    ?,"
                + "    ?,"
                + "    ?"
                + ")";
        PreparedStatement pstm = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        pstm.setInt(1, billDetail.getIdBill());
        pstm.setInt(2, billDetail.getIdMedicine());
        pstm.setInt(3, billDetail.getQuantity());
        pstm.setDouble(4, billDetail.getTotalPrice());
        pstm.setDouble(5, billDetail.getPrice());
        pstm.executeUpdate();
        ResultSet rs = pstm.getGeneratedKeys();
        if (rs.next()) {
            System.out.println("Update_user_success : " + (rs.getInt(1)));
            // System.out.println("create_user_success : " + getBillDetails(rs.getInt(1)));
        }
        // return userDTO;
    }

    public List<BillDetail> getByIdBill(int idBill) throws SQLException {
        List<BillDetail> billDetails = new ArrayList();
        Connection conn = connection.getSqlConnection();
        String sql = "select * from billdetails where idbill = " + idBill;
        PreparedStatement ptsm = conn.prepareStatement(sql);
        ResultSet rs = ptsm.executeQuery();
        while (rs.next()) {
            BillDetail detail = new BillDetail();
            detail.setIdBill(rs.getInt("idbill"));
            detail.setIdMedicine(rs.getInt("idmedicine"));
            detail.setPrice(rs.getDouble("price"));
            detail.setQuantity(rs.getInt("quantity"));
            detail.setTotalPrice(rs.getDouble("totalprice"));
            billDetails.add(detail);
        }
        System.out.println(billDetails);
        return billDetails;
    }
//    public BillDTO getByIdBill(int idBill) throws SQLException {
//        BillDTO billDTO = new BillDTO();
//        List<BillDetail> billDetails = new ArrayList();
//        Connection conn = connection.getSqlConnection();
//        String sql = "select * from billdetails where idbill = " + idBill;
//        PreparedStatement ptsm = conn.prepareStatement(sql);
//        ResultSet rs = ptsm.executeQuery();
//        while (rs.next()) {
//            BillDetail detail = new BillDetail();
//            detail.setIdBill(rs.getInt("idbill"));
//            detail.setIdMedicine(rs.getInt("idmedicine"));
//            detail.setPrice(rs.getDouble("price"));
//            detail.setQuantity(rs.getInt("quantity"));
//            detail.setTotalPrice(rs.getDouble("totalprice"));
//            billDetails.add(detail);
//        }
//        conn.close();
//        billDTO.setBilldetails(billDetails);  
//        return billDetails;
//    }

    public void deleteByIdBill(int idBill) throws SQLException {
        Connection conn = connection.getSqlConnection();
        String sql = "DELETE FROM `billdetails` WHERE idbill = ?";
        PreparedStatement pstm = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        pstm.setInt(1, idBill);
        pstm.executeUpdate();
        
        Connection conn1 = connection.getSqlConnection();
        String sql1 = "DELETE FROM `bills` WHERE idbill = ?";
        PreparedStatement pstm1 = conn.prepareStatement(sql1, Statement.RETURN_GENERATED_KEYS);
        pstm1.setInt(1, idBill);
        pstm1.executeUpdate();
    }
}

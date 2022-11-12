
package com.mycompany.pharmacymanagementproject.dao;

import com.mycompany.pharmacymanagementproject.dto.UserDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.mycompany.pharmacymanagementproject.model.Bill;
import java.sql.Statement;
import java.time.LocalDateTime;

public class BillDAO {

    private final MyConnection myConnection = new MyConnection();

    public List<Bill> getAllBill() throws SQLException {
        List<Bill> bills = new ArrayList();
        Connection conn = myConnection.getSqlConnection();
        String sql = "select * from bills";
        PreparedStatement ptsm = conn.prepareStatement(sql);
        ResultSet rs = ptsm.executeQuery();
        while (rs.next()) {
            Bill bill = new Bill();
            bill.setIdBill(rs.getInt("idbill"));
            bill.setCreationTime(rs.getString("createtime"));
            bill.setTotalMoney(rs.getInt("totalmoney"));
            bill.setUpdateTime(rs.getString("updatetime"));
            bill.setStatus(rs.getBoolean("status"));
            bill.setIDUser(rs.getInt("iduser"));
            bills.add(bill);
        }
        System.out.println(bills);
        return bills;
    }

    public List<Bill> getBillByIdUser(int idUser) throws SQLException {
        List<Bill> bills = new ArrayList();
        Connection conn = myConnection.getSqlConnection();
        String sql = "select * from bills where iduser = " + idUser;
        PreparedStatement ptsm = conn.prepareStatement(sql);
        ResultSet rs = ptsm.executeQuery();
        while (rs.next()) {
            Bill bill = new Bill();
            bill.setIdBill(rs.getInt("idbill"));
            bill.setCreationTime(rs.getString("createtime"));
            bill.setTotalMoney(rs.getInt("totalmoney"));
            bill.setUpdateTime(rs.getString("updatetime"));
            bill.setStatus(rs.getBoolean("status"));
            bill.setIDUser(rs.getInt("iduser"));
            bills.add(bill);
        }
        return bills;
    }

    public Bill getBillByIdBill(int idBill) throws SQLException {
        Bill bill = new Bill();
        Connection conn = myConnection.getSqlConnection();
        String sql = "select * from bills where idbill = " + idBill;
        PreparedStatement ptsm = conn.prepareStatement(sql);
        ResultSet rs = ptsm.executeQuery();
        while (rs.next()) {
            bill = new Bill();
            bill.setIdBill(rs.getInt("idbill"));
            bill.setCreationTime(rs.getString("createtime"));
            bill.setTotalMoney(rs.getInt("totalmoney"));
            bill.setUpdateTime(rs.getString("updatetime"));
            bill.setStatus(rs.getBoolean("status"));
            bill.setIDUser(rs.getInt("iduser"));
        }
        System.out.println(bill);
        return bill;
    }

    public int addBill(int idUser, int idCustomer) throws SQLException {
        Connection conn = myConnection.getSqlConnection();
        String sql = "INSERT INTO `bills`(`idbill`, `createtime`, `totalmoney`, `iduser`, `updatetime`, `status`, `idcustomer`)"
                + "VALUES (null,?,null,'" + idUser + "',?,'0',?)";

        PreparedStatement ptsm = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ptsm.setString(1, LocalDateTime.now().toString());
        ptsm.setString(2, LocalDateTime.now().toString());
        ptsm.setInt(3, idCustomer);
        ptsm.executeUpdate();
        ResultSet rs = ptsm.getGeneratedKeys();
        if (rs.next()) {
            System.out.println("create_bill_success : " + getBillByIdBill(rs.getInt(1)));
        }
        System.out.println("id bill " + rs.getInt(1));
        return rs.getInt(1);

    }

    public void saveBill(Bill bill) throws SQLException {
        System.out.println(bill);
        Connection conn = myConnection.getSqlConnection();
        String sql
                = "UPDATE\n"
                + "    `bills`\n"
                + "SET\n"
                + "    `totalmoney` = ?,\n"
                + "    `updatetime` = ?,\n"
                + "    `status` = ?\n"
                + "WHERE\n"
                + "    idbill = ?";

        PreparedStatement pstm = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        pstm.setDouble(1, bill.getTotalMoney());
        pstm.setString(2, bill.getUpdateTime());
        pstm.setBoolean(3, bill.isStatus());
        pstm.setInt(4, bill.getIdBill());

        pstm.executeUpdate();

    }

}

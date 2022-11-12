package com.mycompany.pharmacymanagementproject.dao;

import com.mycompany.pharmacymanagementproject.dto.UserDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.mycompany.pharmacymanagementproject.model.User;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserDAO {

    private final MyConnection connection = new MyConnection();

    public List<UserDTO> getAll() throws SQLException {
        List<UserDTO> users = new ArrayList();
        Connection conn = connection.getSqlConnection();
        String sql = "select * from users";
        PreparedStatement ptsm = conn.prepareStatement(sql);
        ResultSet rs = ptsm.executeQuery();
        while (rs.next()) {
            UserDTO userDTO = new UserDTO();
            userDTO.setIdUser(rs.getInt("iduser"));
            userDTO.setFullName(rs.getString("fullname"));
            userDTO.setCreationTime(rs.getString("createtime"));
            userDTO.setUpdateTime(rs.getString("updatetime"));
            userDTO.setAddress(rs.getString("address"));
            userDTO.setPhone(rs.getString("phone"));
            userDTO.setImage(rs.getString("image"));
            userDTO.setEmpCode(rs.getString("empcode"));
            users.add(userDTO);
        }
        return users;
    }

    public List<User> getAllUser() throws SQLException {
        List<User> users = new ArrayList();
        Connection conn = connection.getSqlConnection();
        String sql = "select * from users";
        PreparedStatement ptsm = conn.prepareStatement(sql);
        ResultSet rs = ptsm.executeQuery();
        while (rs.next()) {
            User user = new User();
            user.setUserName(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setIdUser(rs.getInt("iduser"));
            user.setFullName(rs.getString("fullname"));
            user.setCreationTime(rs.getString("createtime"));
            user.setUpdateTime(rs.getString("updatetime"));
            user.setBirthOfDay(rs.getString("birthofday"));
            user.setAddress(rs.getString("address"));
            user.setPhone(rs.getString("phone"));
            user.setImage(rs.getString("image"));
            user.setEmpCode(rs.getString("empcode"));
            user.setRole(rs.getString("role"));
            user.setGender(rs.getString("gender"));
            users.add(user);
        }
        return users;
    }

    public User getUserById(int idUser) throws SQLException {
        User user = null;
        Connection conn = connection.getSqlConnection();
        String sql = "select * from users where iduser =  " + idUser;
        PreparedStatement ptsm = conn.prepareStatement(sql);
        ResultSet rs = ptsm.executeQuery();

        if (rs.next()) {
            user = new User();
            user.setUserName(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setIdUser(rs.getInt("iduser"));
            user.setFullName(rs.getString("fullname"));
            user.setCreationTime(rs.getString("createtime"));
            user.setUpdateTime(rs.getString("updatetime"));
            user.setBirthOfDay(rs.getString("birthofday"));
            user.setAddress(rs.getString("address"));
            user.setPhone(rs.getString("phone"));
            user.setImage(rs.getString("image"));
            user.setEmpCode(rs.getString("empcode"));
            user.setRole(rs.getString("role"));
            user.setGender(rs.getString("gender"));
        } else {
            System.out.println("khong tim thay");
        }
        conn.close();
        System.out.println(user);
        return user;
    }

    public UserDTO getUser(String useName, String password) throws SQLException {
        UserDTO userDTO = null;
        try (Connection conn = connection.getSqlConnection()) {

            String sql = "select * from users where username= '" + useName + "' and password='" + password + "'";

            PreparedStatement ptsm = conn.prepareStatement(sql);
            ResultSet rs = ptsm.executeQuery();

            if (rs.next()) {
                userDTO = new UserDTO();
                userDTO.setIdUser(rs.getInt("iduser"));
                userDTO.setFullName(rs.getString("fullname"));
                userDTO.setCreationTime(rs.getString("createtime"));
                userDTO.setUpdateTime(rs.getString("updatetime"));
                userDTO.setAddress(rs.getString("address"));
                userDTO.setPhone(rs.getString("phone"));
                userDTO.setImage(rs.getString("image"));
                userDTO.setEmpCode(rs.getString("empcode"));
                userDTO.setRole(rs.getString("role"));
                userDTO.setBirthOfDay(rs.getString("birthofday"));
                System.out.println(userDTO);
            } else {
                System.out.println("khong tim thay");
            }
        }
        return userDTO;
    }

    public UserDTO addUser(User user) throws SQLException {
        UserDTO userDTO = null;
        Connection conn = connection.getSqlConnection();
//        String sql = "INSERT INTO users (username, password, fullname, role , creationtime, updatetime, birthofday, phone, address, image, empcode)VALUES ( '" + user.getUserName() + "', '" + user.getPassword() + "', '"
//                + user.getFullName() + "','', '" + user.getCreationTime() + "', '" + user.getBirthOfDay() + "', '" + user.getPhone() + "')";
//
//        String sq1 = "INSERT INTO users(`username`, `password`, `role`,  `fullname`, `empcode`, `phone`, `address`,  `image`) VALUES ( '','','','','','','', '')";
//        PreparedStatement ptsm = conn.prepareStatement("insert into users(username, password, role, iduser, brithofday , fullname, empcode, phone, address, createtime, updatetime. image) values(?,?,?,?,?,?,?,?,?,?)");
//        //ptsm.execute(sql);
//        ptsm.setString(1, user.getUserName());
//        ptsm.setString (2, user.getPassword());
//          ptsm.executeUpdate();
//        

        String sql
                = "INSERT INTO `users`("
                + "    `username`,"
                + "    `password`,"
                + "    `role`,"
                //+ "    `iduser`,"
                + "    `birthofday`,"
                + "    `fullname`,"
                + "    `empcode`,"
                + "    `phone`,"
                + "    `address`,"
                + "    `createtime`,"
                + "    `updatetime`,"
                + "    `image`,"
                + "    `gender`"
                + ")"
                + "VALUES("
                + "    ?,"
                + "    ?,"
                + "    ?,"
                //+ "    '?',"
                + "    ?,"
                + "    ?,"
                + "    ?,"
                + "    ?,"
                + "    ?,"
                + "    ?,"
                + "    ?,"
                + "    ?,"
                + "    ?"
                + ")";
        PreparedStatement pstm = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        pstm.setString(1, user.getUserName());
        pstm.setString(2, user.getPassword());
        pstm.setString(3, user.getRole());
        pstm.setString(4, user.getBirthOfDay());
        pstm.setString(5, user.getFullName());
        pstm.setString(6, user.getEmpCode());
        pstm.setString(7, user.getPhone());
        pstm.setString(8, user.getAddress());
        pstm.setString(9, user.getCreationTime());
        pstm.setString(10, user.getUpdateTime());
        pstm.setString(11, user.getImage());
        pstm.setString(12, user.getGender());
        pstm.executeUpdate();
        ResultSet rs = pstm.getGeneratedKeys();
        if (rs.next()) {
            System.out.println("create_user_success : " + getUserById(rs.getInt(1)));
        }
        return userDTO;
    }

    public void updateUser(User user) throws SQLException {
        
        Connection conn = connection.getSqlConnection();
       
        
        String sql = 
                "UPDATE\n" +
                    "    `users`\n" +
                    "SET\n" +
                    "    `username` = ?,\n" +
                    "    `password` = ?,\n" +
                    "    `fullname` = ?,\n" +
                    "    `birthofday` = ?,\n" +
                    "    `address` = ?,\n" +
                    "    `phone` = ?,\n" +
                    "    `empcode` = ?,\n" +
                    "    `role` = ?,\n" +
                    "    `image` = ?,\n" +
                   
                    "    `updatetime` = ?,\n" +
                    "    `gender` = ?\n" +
                    "WHERE\n" +
                    "    `iduser` = ?";
        PreparedStatement pstm = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        pstm.setString(1, user.getUserName());
        pstm.setString(2, user.getPassword());
        pstm.setString(8, user.getRole());
        pstm.setString(4, user.getBirthOfDay());
        pstm.setString(3, user.getFullName());
        pstm.setString(7, user.getEmpCode());
        pstm.setString(6, user.getPhone());
        pstm.setString(5, user.getAddress());
        pstm.setString(10, user.getUpdateTime());
        pstm.setString(9, user.getImage());
          pstm.setString(11, user.getGender());
       pstm.setInt(12, user.getIdUser());

        pstm.executeUpdate();
        ResultSet rs = pstm.getGeneratedKeys();
        if (rs.next()) {
            System.out.println("Update_user_success : " + getUserById(rs.getInt(1)));
        }
        
    }

    public boolean deleteUser(int idUser) {
        boolean check = false;
        try {
            Connection conn = connection.getSqlConnection();
            String sql = "DELETE FROM `users` WHERE iduser = ?";
            PreparedStatement pstm = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pstm.setInt(1, idUser);
            pstm.executeUpdate();
            System.out.println("Delete_user_success : " + idUser);
            check = true;
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return check;
    }

}

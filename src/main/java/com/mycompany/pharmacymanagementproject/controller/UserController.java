
package com.mycompany.pharmacymanagementproject.controller;

import com.mycompany.pharmacymanagementproject.dao.UserDAO;
import com.mycompany.pharmacymanagementproject.dto.UserDTO;
import java.sql.SQLException;
import java.util.List;
import com.mycompany.pharmacymanagementproject.model.User;
import com.mycompany.pharmacymanagementproject.view.CreateUser;
import com.mycompany.pharmacymanagementproject.view.UpdateUser;
import com.mycompany.pharmacymanagementproject.view.UserManagementPanel;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class UserController {

    private final UserDAO userDAO = new UserDAO();
    private DefaultTableModel modelUser;

    public void showUsersModel(UserManagementPanel managementPanel) throws SQLException, SQLException {
        modelUser = (DefaultTableModel) managementPanel.getModelUser().getModel();
        Object[] row;
        row = new Object[10];
        for (User user : userDAO.getAllUser()) {
            row[0] = user.getEmpCode();
            row[1] = user.getUserName();
            row[2] = user.getPassword();
            row[3] = user.getFullName();
            row[4] = user.getBirthOfDay();
            row[5] = user.getAddress();
            row[6] = user.getPhone();
            row[7] = user.getRole();
            row[8] = user.getGender();
            row[9] = user.getIdUser();
            modelUser.addRow(row);
        }
    }

    public void searchTableModel(UserManagementPanel userManagementPanel) throws SQLException {
        String str = userManagementPanel.getTxtSearch().getText();
        modelUser = (DefaultTableModel) userManagementPanel.getModelUser().getModel();
        TableRowSorter<DefaultTableModel> trs = new TableRowSorter<>(modelUser);
        userManagementPanel.getModelUser().setRowSorter(trs);
        trs.setRowFilter(RowFilter.regexFilter(str));
    }

    public void selectRowUser(UserManagementPanel userManagementPanel) throws ParseException {
        User user = new User();
        int row = userManagementPanel.getModelUser().getSelectedRow();
        int modelRow = userManagementPanel.getModelUser().convertRowIndexToModel(row);
        user.setUserName(modelUser.getValueAt(modelRow, 1).toString());
        user.setFullName(modelUser.getValueAt(modelRow, 3).toString());
        user.setPassword(modelUser.getValueAt(modelRow, 2).toString());
        user.setBirthOfDay(modelUser.getValueAt(modelRow, 4).toString());
        user.setEmpCode(modelUser.getValueAt(modelRow, 0).toString());
        user.setAddress(modelUser.getValueAt(modelRow, 5).toString());
        user.setPhone(modelUser.getValueAt(modelRow, 6).toString());
        user.setRole(modelUser.getValueAt(modelRow, 7).toString());
        user.setGender(modelUser.getValueAt(modelRow, 8).toString());
        user.setIdUser(Integer.parseInt(modelUser.getValueAt(modelRow, 9).toString()));
        UpdateUser dialog = new UpdateUser(user);
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
    }

    public void addUser(CreateUser createUser) {
        try {
            User user = new User();
            String userName = createUser.getTxtUserName().getText();
            String empCode = createUser.getTxtEmpCode().getText();
            String fullName = createUser.getTxtFullName().getText();
            String phone = createUser.getTxtPhone().getText();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String birthday = sdf.format(createUser.getDateBirthday().getDate());
            String pass = createUser.getTxtPass().getText();
            String role = null;
            String gender = null;
            if (createUser.getRaCheckUser().isSelected()) {
                role = "user";
            }
            if (createUser.getRaCheckAdmin().isSelected()) {
                role = "admin";
            }
            if (createUser.getRaCheckMale().isSelected()) {
                gender = "nam";
            }
            if (createUser.getRaCheckFemale().isSelected()) {
                gender = "nữ";
            }
            String address = createUser.getTxtAddress().getText();

            user.setUserName(userName);
            user.setPassword(pass);
            user.setPhone(phone);
            user.setEmpCode(empCode);
            user.setBirthOfDay(birthday);
            user.setFullName(fullName);
            user.setCreationTime(LocalDateTime.now().toString());
            user.setUpdateTime(LocalDateTime.now().toString());
            user.setPhone(phone);
            user.setRole(role);
            user.setAddress(address);

            user.setGender(gender);
            userDAO.addUser(user);
            JOptionPane.showMessageDialog(createUser, "Thêm thành công!!");
            reset(createUser);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(createUser, "Lỗi thêm user");
        }
    }

    public void reset(CreateUser createUser) {
        createUser.getTxtUserName().setText("");
        createUser.getTxtEmpCode().setText("");
        createUser.getTxtFullName().setText("");
        createUser.getTxtPhone().setText("");
        createUser.getTxtAddress().setText("");
        createUser.getTxtPass().setText("");
    }

    public void updateModelUser(UserManagementPanel userManagementPanel) throws SQLException {
        DefaultTableModel modelBillDetail = (DefaultTableModel) userManagementPanel.getModelUser().getModel();
        modelBillDetail.setRowCount(0);
        showUsersModel(userManagementPanel);

    }

    public void updateUser(UpdateUser updateUser, User user) throws SQLException {
        String userName = updateUser.getTxtUserName().getText();
        String empCode = updateUser.getTxtEmpCode().getText();
        String fullName = updateUser.getTxtFullName().getText();
        String phone = updateUser.getTxtPhone().getText();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String birthday = sdf.format(updateUser.getDateBirthday().getDate());
        String pass = updateUser.getTxtPass().getText();
        String role = null;
        String gender = null;
        if (updateUser.getRaCheckUser().isSelected()) {
            role = "user";
        }
        if (updateUser.getRaCheckAdmin().isSelected()) {
            role = "admin";
        }
        if (updateUser.getRaCheckMale().isSelected()) {
            gender = "nam";
        }
        if (updateUser.getRaCheckFemale().isSelected()) {
            gender = "nữ";
        }
        String address = updateUser.getTxtAddress().getText();
        user = userDAO.getUserById(user.getIdUser());
        user.setUserName(userName);
        user.setPassword(pass);
        user.setPhone(phone);
        user.setEmpCode(empCode);
        user.setBirthOfDay(birthday);
        user.setFullName(fullName);
        user.setCreationTime(LocalDateTime.now().toString());
        user.setUpdateTime(LocalDateTime.now().toString());
        user.setPhone(phone);
        user.setRole(role);
        user.setAddress(address);
        user.setGender(gender);
        userDAO.updateUser(user);
        JOptionPane.showMessageDialog(updateUser, "Update thành công!!");
    }

    public UserDTO getUser(String userName, String password) throws SQLException {
        return userDAO.getUser(userName, password);
    }

    public List<UserDTO> getAll() throws SQLException {
        return userDAO.getAll();
    }

    public List<User> getAllUser() throws SQLException {
        return userDAO.getAllUser();
    }

    public User getById(int idUser) throws SQLException {
        return userDAO.getUserById(idUser);
    }
    public void deleteUser(UpdateUser updateUser, int idUser) {
        if (userDAO.deleteUser(idUser) == true) {
            JOptionPane.showMessageDialog(updateUser, "Xóa thành công!!");
        } else {
            JOptionPane.showMessageDialog(updateUser, "Lỗi không xóa được!!");
        }
    }

//    public UserDTO updateUser(User user) throws SQLException {
//        return userDAO.updateUser(user);
//    }
}

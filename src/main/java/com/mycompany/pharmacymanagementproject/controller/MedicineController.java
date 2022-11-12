/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pharmacymanagementproject.controller;

import com.mycompany.pharmacymanagementproject.dao.MedicineDAO;
import com.mycompany.pharmacymanagementproject.dao.UserDAO;
import com.mycompany.pharmacymanagementproject.dto.UserDTO;
import com.mycompany.pharmacymanagementproject.model.Medicine;
import com.mycompany.pharmacymanagementproject.model.User;
import com.mycompany.pharmacymanagementproject.view.MedicinePanel;
import com.mycompany.pharmacymanagementproject.view.MedicineUpdatePanel;
import com.mycompany.pharmacymanagementproject.view.UpdateUser;
import com.mycompany.pharmacymanagementproject.view.UserManagementPanel;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import org.springframework.cglib.core.Local;

/**
 *
 * @author nhut0
 */
public class MedicineController {

    private final MedicineDAO medicineDAO = new MedicineDAO();
    private DefaultTableModel modelMedicine;
    private DefaultTableModel modelBillDetail;

    public void showMedicines(MedicinePanel medicinePanel) throws SQLException {
        
        modelMedicine = (DefaultTableModel) medicinePanel.getModelMedicine().getModel();
        
        Object[] row;
        row = new Object[9];
        for (Medicine medicine : medicineDAO.getAll()) {
            row[0] = medicine.getIdMedicine();
            row[1] = medicine.getName();
            row[2] = medicine.getImage();
            row[3] = medicine.getProvider();
            row[4] = medicine.getAmountInventory();
            row[5] = medicine.getPrice();
            row[6] = medicine.getExpirationDate();
            row[7] = medicine.getUnit();
            row[8] = medicine.getUses();
            modelMedicine.addRow(row);
        }
    }

     public void updateModelMedicine(MedicinePanel medicinePanel) throws SQLException {
        DefaultTableModel modelBillDetail = (DefaultTableModel) medicinePanel.getModelMedicine().getModel();
        modelBillDetail.setRowCount(0);
        showMedicines(medicinePanel);

    }
    public void searchTableModel(MedicinePanel medicinePanel, String str) throws SQLException {
        modelMedicine = (DefaultTableModel) medicinePanel.getModelMedicine().getModel();
        TableRowSorter<DefaultTableModel> trs = new TableRowSorter<>(modelMedicine);
        medicinePanel.getModelMedicine().setRowSorter(trs);
        trs.setRowFilter(RowFilter.regexFilter(str));
    }

    public void searchTableModelUpdate(MedicineUpdatePanel medicinePanel) throws SQLException {
        String str = medicinePanel.getTxtSearch().getText();
        modelMedicine = (DefaultTableModel) medicinePanel.getModelMed().getModel();
        TableRowSorter<DefaultTableModel> trs = new TableRowSorter<>(modelMedicine);
        medicinePanel.getModelMed().setRowSorter(trs);
        trs.setRowFilter(RowFilter.regexFilter(str));
    }

    public void clearTextMedicinePanel(MedicinePanel medicinePanel) {
        medicinePanel.getIdMe().setText("");
        medicinePanel.getNameMedicine().setText("");
        medicinePanel.getPrice().setText("");
        medicinePanel.getSLT().setText("");
        medicinePanel.getUnit().setText("");
        medicinePanel.getDateHH().setText("");
        medicinePanel.getCmbQuantity().setValue(0);
        medicinePanel.getTotalPrice().setText("");

    }

    public void clearTextMedicinePanelUpdate(MedicineUpdatePanel medicineUpdatePanel) {
        medicineUpdatePanel.getTxtID().setText("");
        medicineUpdatePanel.getTxtName().setText("");
        medicineUpdatePanel.getTxtPrice().setText("");
        medicineUpdatePanel.getTxtElement().setText("");
        medicineUpdatePanel.getTxtProvider().setText("");
        medicineUpdatePanel.getJSpinnerQuantity().setValue(0);
        medicineUpdatePanel.getTxtUse().setText("");
    }

    public void searchById(MedicinePanel medicinePanel, int idMe) throws SQLException {
        List<Medicine> medicines = medicineDAO.getAll();
        for (Medicine medicine : medicines) {
            if (medicine.getIdMedicine() == idMe) {
                medicinePanel.getNameMedicine().setText(medicine.getName());
                medicinePanel.getDateHH().setText(medicine.getExpirationDate().toString());
                medicinePanel.getSLT().setText(String.valueOf(medicine.getAmountInventory()));
                medicinePanel.getUnit().setText(medicine.getUnit());
                medicinePanel.getPrice().setText(String.valueOf(medicine.getPrice()));
            }
        }
    }

    public void addMedicien(MedicineUpdatePanel medicineUpdatePanel, UserDTO userDTO) throws SQLException {
        try {
            String name = medicineUpdatePanel.getTxtName().getText();
            String price = medicineUpdatePanel.getTxtPrice().getText();
            String provider = medicineUpdatePanel.getTxtProvider().getText();
            String element = medicineUpdatePanel.getTxtElement().getText();
            String unit = medicineUpdatePanel.getCmbUnit().getSelectedItem().toString();
            String use = medicineUpdatePanel.getTxtUse().getText();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            //String birthday = sdf.format(createUser.getDateBirthday().getDate());
            String expirationDate = sdf.format(medicineUpdatePanel.getDataChoose().getDate());
            int quantity = Integer.parseInt(medicineUpdatePanel.getJSpinnerQuantity().getValue().toString());

            if (name.isEmpty() || price.isEmpty() || provider.isEmpty() || unit.isEmpty() || element.isEmpty() || expirationDate.isEmpty() || quantity == 0) {
                JOptionPane.showMessageDialog(medicineUpdatePanel, "Vui lòng điền đầy đủ thông tin!!");
            }
            Medicine medicine = new Medicine();
            medicine.setElement(element);
            medicine.setAmountInventory(quantity);
            medicine.setExpirationDate(expirationDate);
//        medicine.setImage(name);
            medicine.setPrice(Integer.parseInt(price));
            medicine.setIdUser(userDTO.getIdUser());
            medicine.setUses(use);
            medicine.setProvider(provider);
            medicine.setUnit(unit);
            medicine.setName(name);
            System.out.println(medicine);
            medicineDAO.create(medicine);
            JOptionPane.showMessageDialog(medicineUpdatePanel, "Thêm thành công!!");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(medicineUpdatePanel, "Vui lòng điền đầy đủ thông tin!!");

        }

    }

    public void showMedicinesUpdate(MedicineUpdatePanel medicineUpdatePanel) throws SQLException {
        modelMedicine = (DefaultTableModel) medicineUpdatePanel.getModelMed().getModel();
        Object[] row;
        row = new Object[9];
        for (Medicine medicine : medicineDAO.getAll()) {
            row[0] = medicine.getIdMedicine();
            row[1] = medicine.getName();
            row[2] = medicine.getElement();
            row[3] = medicine.getProvider();
            row[4] = medicine.getAmountInventory();
            row[5] = medicine.getPrice();
            row[6] = medicine.getExpirationDate();
            row[7] = medicine.getUnit();
            row[8] = medicine.getUses();

            modelMedicine.addRow(row);
        }
    }

    public void selectRowMedicinetUpdate(MedicineUpdatePanel medicineUpdatePanel, UserDTO userDTO) throws ParseException {
        Medicine medicine = new Medicine();
        int row = medicineUpdatePanel.getModelMed().getSelectedRow();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        int modelRow = medicineUpdatePanel.getModelMed().convertRowIndexToModel(row);
        medicine.setElement(modelMedicine.getValueAt(modelRow, 2).toString());
        medicine.setAmountInventory(Integer.parseInt(modelMedicine.getValueAt(modelRow, 4).toString()));
        medicine.setExpirationDate(modelMedicine.getValueAt(modelRow, 6).toString());
//        medicine.setImage(name);
        medicine.setIdMedicine(Integer.parseInt(modelMedicine.getValueAt(modelRow, 0).toString()));
        medicine.setPrice(Integer.parseInt(modelMedicine.getValueAt(modelRow, 5).toString()));
        medicine.setIdUser(userDTO.getIdUser());
        medicine.setUses(modelMedicine.getValueAt(modelRow, 8).toString());
        medicine.setProvider(modelMedicine.getValueAt(modelRow, 3).toString());
        medicine.setUnit(modelMedicine.getValueAt(modelRow, 7).toString());
        medicine.setName(modelMedicine.getValueAt(modelRow, 1).toString());

        medicineUpdatePanel.getTxtID().setText(modelMedicine.getValueAt(modelRow, 0).toString());
        medicineUpdatePanel.getTxtName().setText(modelMedicine.getValueAt(modelRow, 1).toString());
        medicineUpdatePanel.getTxtPrice().setText(modelMedicine.getValueAt(modelRow, 5).toString());
        medicineUpdatePanel.getTxtElement().setText(modelMedicine.getValueAt(modelRow, 2).toString());
        medicineUpdatePanel.getTxtProvider().setText(modelMedicine.getValueAt(modelRow, 3).toString());
        medicineUpdatePanel.getTxtUse().setText(modelMedicine.getValueAt(modelRow, 8).toString());
        medicineUpdatePanel.getJSpinnerQuantity().setValue(Integer.parseInt(modelMedicine.getValueAt(modelRow, 4).toString()));
        medicineUpdatePanel.getCmbUnit().setSelectedItem(modelMedicine.getValueAt(modelRow, 7).toString());
        medicineUpdatePanel.getDataChoose().setDate(sdf.parse(modelMedicine.getValueAt(modelRow, 6).toString()));
        //medicine.setIdMedicine(Integer.parseInt(modelMedicine.getValueAt(modelRow, 0).toString()));
        medicineUpdatePanel.getMedicineCurr(medicine);
    }

    public void selectRowMedicine(MedicinePanel medicinePanel) {
        int row = medicinePanel.getModelMedicine().getSelectedRow();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        int modelRow = medicinePanel.getModelMedicine().convertRowIndexToModel(row);

        medicinePanel.getIdMe().setText(modelMedicine.getValueAt(modelRow, 0).toString());
        medicinePanel.getNameMedicine().setText(modelMedicine.getValueAt(modelRow, 1).toString());
        medicinePanel.getPrice().setText(modelMedicine.getValueAt(modelRow, 5).toString());
        medicinePanel.getUnit().setText(modelMedicine.getValueAt(modelRow, 7).toString());
        medicinePanel.getDateHH().setText(modelMedicine.getValueAt(modelRow, 6).toString());
        medicinePanel.getSLT().setText(modelMedicine.getValueAt(modelRow, 4).toString());

    }

    public void updateMedicine(MedicineUpdatePanel medicineUpdatePanel, Medicine medicine) {
        try {
            String name = medicineUpdatePanel.getTxtName().getText();
            String price = medicineUpdatePanel.getTxtPrice().getText();
            String provider = medicineUpdatePanel.getTxtProvider().getText();
            String element = medicineUpdatePanel.getTxtElement().getText();
            String unit = medicineUpdatePanel.getCmbUnit().getSelectedItem().toString();
            String use = medicineUpdatePanel.getTxtUse().getText();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            //String birthday = sdf.format(createUser.getDateBirthday().getDate());
            String expirationDate = sdf.format(medicineUpdatePanel.getDataChoose().getDate());
            int quantity = Integer.parseInt(medicineUpdatePanel.getJSpinnerQuantity().getValue().toString());

            if (name.isEmpty() || price.isEmpty() || provider.isEmpty() || unit.isEmpty() || element.isEmpty() || expirationDate.isEmpty() || quantity == 0) {
                JOptionPane.showMessageDialog(medicineUpdatePanel, "Vui lòng điền đầy đủ thông tin!!");
            }
            medicine = medicineDAO.getById(medicine.getIdMedicine());
            medicine.setElement(element);
            medicine.setAmountInventory(quantity);
            medicine.setExpirationDate(expirationDate);
//        medicine.setImage(name);
            medicine.setPrice(Integer.parseInt(price));
            // medicine.setIdUser(userDTO.getIdUser());
            medicine.setUses(use);
            medicine.setProvider(provider);
            medicine.setUnit(unit);
            medicine.setName(name);
            System.out.println(medicine);
            medicineDAO.update(medicine);
            JOptionPane.showMessageDialog(medicineUpdatePanel, "Update thành công!!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(medicineUpdatePanel, "Lỗi!!");

            Logger.getLogger(MedicineController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Medicine> getAll() throws SQLException {
        return medicineDAO.getAll();
    }

    public Medicine getById(int id) throws SQLException {
        return medicineDAO.getById(id);
    }

    public Medicine create(Medicine medicine) throws SQLException {
        return medicineDAO.create(medicine);
    }

    public void delete(MedicineUpdatePanel medicineUpdatePanel, int idMedicine) throws SQLException {
        if (medicineDAO.delete(idMedicine) == true) {
            JOptionPane.showMessageDialog(medicineUpdatePanel, "Xóa thành công!!");
        } else {
            JOptionPane.showMessageDialog(medicineUpdatePanel, "Thuốc đã được mua không thể xóa!!");
        }
    }
}

package com.mycompany.pharmacymanagementproject.controller;

import com.mycompany.pharmacymanagementproject.dao.BillDAO;
import com.mycompany.pharmacymanagementproject.dao.BillDetailsDAO;
import com.mycompany.pharmacymanagementproject.dao.MedicineDAO;
import com.mycompany.pharmacymanagementproject.dto.BillDTO;
import com.mycompany.pharmacymanagementproject.dto.UserDTO;
import com.mycompany.pharmacymanagementproject.model.Bill;
import com.mycompany.pharmacymanagementproject.model.BillDetail;
import com.mycompany.pharmacymanagementproject.model.Customer;
import com.mycompany.pharmacymanagementproject.view.AdminHome;
import com.mycompany.pharmacymanagementproject.view.ConfirmBill;
import com.mycompany.pharmacymanagementproject.view.MedicinePanel;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

public class BillController {

    private final MedicineController medicineController = new MedicineController();
    private final BillDetailsDAO billDetailsDAO = new BillDetailsDAO();
    private final MedicineDAO medicineDAO = new MedicineDAO();
    private final BillDAO billDAO = new BillDAO();

    private DefaultTableModel modelBillDetail;

    public void checkIdCus(MedicinePanel medicinePanel) {
        if (medicinePanel.getIdCus().getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn khách hàng!!!");
        }
    }

    public int createBill(MedicinePanel medicinePanel, UserDTO userDTO, Customer customer) throws SQLException {
        System.out.println(userDTO);
        return billDAO.addBill(userDTO.getIdUser(), customer.getIdCustomer());
    }

    public void addBillDetails(MedicinePanel medicinePanel) {
        int idBill = Integer.parseInt(medicinePanel.getIdBilll().getText());
        int idMedicine = Integer.parseInt(medicinePanel.getIdMe().getText());
        double price = Double.parseDouble(medicinePanel.getPrice().getText());
        double totalPrice = Double.parseDouble(medicinePanel.getTotalPrice().getText());
        int slt = Integer.parseInt(medicinePanel.getSLT().getText());
        int quantity = Integer.parseInt(medicinePanel.getCmbQuantity().getValue().toString());

        Date time = Date.valueOf(LocalDate.now());

        if (quantity > slt) {
            JOptionPane.showMessageDialog(null, "Số lượng không đủ để bán!!!");
        } else {
            try {
                BillDetail billDetail = new BillDetail();
                billDetail.setIdBill(idBill);
                billDetail.setIdMedicine(idMedicine);
                billDetail.setPrice(price);
                billDetail.setQuantity(quantity);
                billDetail.setTotalPrice(totalPrice);
                billDetailsDAO.addBillDetail(billDetail);
                DefaultTableModel modelBillDetail = (DefaultTableModel) medicinePanel.getModelBillDetails().getModel();
                modelBillDetail.setRowCount(0);

                showBillDetail(medicinePanel, idBill);
              
            } catch (SQLException ex) {
                Logger.getLogger(MedicinePanel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void showBillDetail(MedicinePanel medicinePanel, int idBill) throws SQLException {
        modelBillDetail = (DefaultTableModel) medicinePanel.getModelBillDetails().getModel();
        Object[] row;
        row = new Object[7];
        int count = 1;

        for (BillDetail billDetail : billDetailsDAO.getByIdBill(idBill)) {

            try {
                row[0] = count++;
                row[1] = billDetail.getIdMedicine();
                row[2] = medicineDAO.getById(billDetail.getIdMedicine()).getName();
                row[3] = billDetail.getPrice();
                row[4] = billDetail.getQuantity();
                row[5] = billDetail.getTotalPrice();
                row[6] = LocalDate.now().toString();

                modelBillDetail.addRow(row);
            } catch (SQLException ex) {
                Logger.getLogger(MedicinePanel.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

    //tao bill rong
//    public int addBill(int idUser, int idCustomer) throws SQLException {
//        return billDAO.addBill(idUser, idCustomer);
//    }
//
//    public void addBillDetail(BillDetail billDetail) throws SQLException {
//        billDetailsDAO.addBillDetail(billDetail);
//    }

//    public List<BillDetail> getListBillDetailByIdBill(int idBill) throws SQLException {
//        return billDetailsDAO.getByIdBill(idBill);
//    }

    public BillDTO getByIdBill(int idBill) throws SQLException {
        BillDTO billDTO = new BillDTO();
        Bill bill = billDAO.getBillByIdBill(idBill);
        billDTO.setIdBill(bill.getIdBill());
        billDTO.setIDUser(bill.getIDUser());
        billDTO.setCreationTime(bill.getCreationTime());
        billDTO.setStatusBill(bill.isStatus());
        billDTO.setUpdateTime(bill.getUpdateTime());
        billDTO.setTotalMoney(bill.getTotalMoney());
        billDTO.setBilldetails(billDetailsDAO.getByIdBill(idBill));
        return billDTO;
    }

    public void save(Bill bill) throws SQLException {
        billDAO.saveBill(bill);
    }

    public void delete(int idBill) throws SQLException {
        billDetailsDAO.deleteByIdBill(idBill);
    }
}

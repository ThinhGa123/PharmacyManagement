package com.mycompany.pharmacymanagementproject.view;

import com.mycompany.pharmacymanagementproject.controller.BillController;
import com.mycompany.pharmacymanagementproject.controller.CustomerController;
import com.mycompany.pharmacymanagementproject.controller.MedicineController;
import com.mycompany.pharmacymanagementproject.dto.BillDTO;
import com.mycompany.pharmacymanagementproject.dto.UserDTO;
import com.mycompany.pharmacymanagementproject.model.BillDetail;
import com.mycompany.pharmacymanagementproject.model.Customer;
import com.mycompany.pharmacymanagementproject.model.Medicine;
import java.sql.Date;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public final class MedicinePanel extends javax.swing.JPanel {

    private final MedicineController medicineController;
    private final BillController billController;
    private final CustomerController customerController;

    private final UserDTO userDTO;
    private BillDTO billDTO;
    private Customer customer;
    private DefaultTableModel modelMedicine;
    private DefaultTableModel modelBillDetail;

    public MedicinePanel(UserDTO userDTO) {

        initComponents();
        this.userDTO = userDTO;
        this.medicineController = new MedicineController();
        this.billController = new BillController();
        this.customerController = new CustomerController();
        try {
            medicineController.showMedicines(this);
        } catch (SQLException ex) {
            Logger.getLogger(MedicinePanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

//    public void showBillDetail(List<BillDetail> details) {
//        modelBillDetail = (DefaultTableModel) tbl_Display_BillDetail.getModel();
//        Object[] row;
//        row = new Object[7];
//        int count = 1;
//        for (BillDetail billDetail : details) {
//
//            try {
//                row[0] = count++;
//                row[1] = billDetail.getIdMedicine();
//                row[2] = medicineController.getById(billDetail.getIdMedicine()).getName();
//                row[3] = billDetail.getPrice();
//                row[4] = billDetail.getQuantity();
//                row[5] = billDetail.getTotalPrice();
//                row[6] = LocalDate.now().toString();
//
//                modelBillDetail.addRow(row);
//            } catch (SQLException ex) {
//                Logger.getLogger(MedicinePanel.class.getName()).log(Level.SEVERE, null, ex);
//            }
//
//        }
//    }
    public JTable getModelMedicine() {
        return tbl_Display_Medicine;
    }

    public JTextField getStringSearchMedicine() {
        return txtSearch;
    }

    public JTextField getPhoneCus() {
        return txtPhoneCus;
    }

    public JTextField getIdMe() {
        return txtIdMe;
    }

    public JTextField getNameMedicine() {
        return txtNameMedicine;
    }

    public JTextField getPrice() {
        return txtPrice;
    }

    public JTextField getSLT() {
        return txtSLT;
    }

    public JTextField getUnit() {
        return txtUnit;
    }

    public JTextField getDateHH() {
        return txtDateHH;
    }

    public JTextField getTotalPrice() {
        return txtTotalPrice;
    }

    public JSpinner getCmbQuantity() {
        return txtQuantity;
    }

    public JTextField getIdBilll() {
        return txtIdBill;
    }

    public JTable getModelBillDetails() {
        return tbl_Display_BillDetail;
    }

//    private void searchById(int idMe) throws SQLException {
//        List<Medicine> medicines = medicineController.getAll();
//        for (Medicine medicine : medicines) {
//            if (medicine.getIdMedicine() == idMe) {
//                txtNameMedicine.setText(medicine.getName());
//                txtDateHH.setText(medicine.getExpirationDate().toString());
//                txtSLT.setText(String.valueOf(medicine.getAmountInventory()));
//                txtUnit.setText(medicine.getUnit());
//                txtPrice.setText(String.valueOf(medicine.getPrice()));
//            }
//        }
//    }
//    private void searchByPhoneCustomer(String phone) throws SQLException {
//        customer = customerController.getByPhone(phone);
//
//        if (customer == null) {
//            txtNameCustomer.setText("");
//            txtIdCus.setText("");
//        } else {
//            txtNameCustomer.setText(customer.getName());
//            txtIdCus.setText(String.valueOf(customer.getIdCustomer()));
//        }
//
//    }
    public JTextField getNameCustomer() {
        return txtNameCustomer;
    }

    public JTextField getIdCus() {
        return txtIdCus;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_Display_BillDetail = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtNameMedicine = new javax.swing.JTextField();
        txtUnit = new javax.swing.JTextField();
        txtSLT = new javax.swing.JTextField();
        txtPrice = new javax.swing.JTextField();
        txtDateHH = new javax.swing.JTextField();
        txtQuantity = new javax.swing.JSpinner();
        jButton2 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        txtTotalPrice = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_Display_Medicine = new javax.swing.JTable();
        jLabel18 = new javax.swing.JLabel();
        txtIdMe = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txtIdBill = new javax.swing.JTextField();
        txtPhoneCus = new javax.swing.JTextField();
        txtNameCustomer = new javax.swing.JTextField();
        btnCreateBill = new javax.swing.JButton();
        btnCreateCus = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        txtIdCus = new javax.swing.JTextField();
        btnUpdate1 = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();

        tbl_Display_BillDetail.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tbl_Display_BillDetail.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã thuốc", "Tên thuốc", "Giá", "Số lượng", "Thành tiền", "Thời gian lập"
            }
        ));
        jScrollPane1.setViewportView(tbl_Display_BillDetail);

        jPanel3.setBackground(new java.awt.Color(204, 204, 204));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Hiển thị thông tin thuốc", javax.swing.border.TitledBorder.LEADING, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Chọn thuốc");

        txtSearch.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchActionPerformed(evt);
            }
        });
        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKeyReleased(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Giá bán: ");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Số lượng tồn: ");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Số lượng:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Đơn vị tính: ");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Tên thuốc: ");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("Ngày hết hạn");

        txtNameMedicine.setEditable(false);
        txtNameMedicine.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtNameMedicine.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNameMedicineActionPerformed(evt);
            }
        });
        txtNameMedicine.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNameMedicineKeyReleased(evt);
            }
        });

        txtUnit.setEditable(false);
        txtUnit.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        txtSLT.setEditable(false);
        txtSLT.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        txtPrice.setEditable(false);
        txtPrice.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        txtDateHH.setEditable(false);
        txtDateHH.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtDateHH.setText("09-11-2000");

        txtQuantity.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtQuantity.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                txtQuantityStateChanged(evt);
            }
        });
        txtQuantity.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtQuantityMouseClicked(evt);
            }
        });
        txtQuantity.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtQuantityKeyReleased(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/pharmacymanagementproject/img/search-icon-16.png"))); // NOI18N
        jButton2.setText("Search");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setText("Thành tiền: ");

        txtTotalPrice.setEditable(false);
        txtTotalPrice.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtTotalPrice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTotalPriceActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/pharmacymanagementproject/img/Actions-view-choose-icon-24.png"))); // NOI18N
        jButton1.setText("Add");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/pharmacymanagementproject/img/Actions-edit-delete-icon-16.png"))); // NOI18N
        jButton3.setText("Reset");
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton3MouseClicked(evt);
            }
        });
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 51, 0));
        jLabel17.setText("VND");

        tbl_Display_Medicine.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Tên thuốc", "Hình ảnh", "Nhà sản xuất", "Số lượng tồn", "Giá", "Ngày hết hạn", "Đơn vị tính", "Công dụng"
            }
        ));
        tbl_Display_Medicine.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_Display_MedicineMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_Display_Medicine);

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel18.setText("Mã thuốc: ");

        txtIdMe.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtIdMe.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtIdMeKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel18)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel10))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(txtNameMedicine, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)
                                                    .addComponent(txtIdMe)
                                                    .addComponent(txtQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(32, 32, 32))
                                            .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addComponent(txtSLT)
                                                .addGap(58, 58, 58)))
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel4)
                                            .addComponent(jLabel7)))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(txtTotalPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel17))))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(283, 283, 283)
                                .addComponent(jLabel9)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtUnit, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDateHH, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)))
                .addComponent(jScrollPane2))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(jButton2))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel2)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(txtIdMe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(txtNameMedicine, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel7)
                    .addComponent(txtUnit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel4)
                    .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSLT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel9)
                    .addComponent(jLabel6)
                    .addComponent(txtQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDateHH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel17)
                    .addComponent(txtTotalPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addGap(8, 8, 8)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addContainerGap(14, Short.MAX_VALUE))
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED), "Thông tin khách hàng"));

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 51, 51));
        jLabel11.setText("ID: ");

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel12.setText("Số điện thoại: ");

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel14.setText("Khách hàng:");

        txtIdBill.setEditable(false);
        txtIdBill.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtIdBill.setEnabled(false);

        txtPhoneCus.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtPhoneCus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPhoneCusActionPerformed(evt);
            }
        });
        txtPhoneCus.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPhoneCusKeyReleased(evt);
            }
        });

        txtNameCustomer.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        btnCreateBill.setBackground(new java.awt.Color(102, 204, 255));
        btnCreateBill.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnCreateBill.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/pharmacymanagementproject/img/icons8_Plus_16.png"))); // NOI18N
        btnCreateBill.setText("Tạo Hóa đơn mới ");
        btnCreateBill.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCreateBillMouseClicked(evt);
            }
        });
        btnCreateBill.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateBillActionPerformed(evt);
            }
        });

        btnCreateCus.setBackground(new java.awt.Color(102, 204, 255));
        btnCreateCus.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnCreateCus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/pharmacymanagementproject/img/Person-Male-Light-icon-16.png"))); // NOI18N
        btnCreateCus.setText("Tạo KH mới");
        btnCreateCus.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCreateCusMouseClicked(evt);
            }
        });
        btnCreateCus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateCusActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel15.setText("ID:");

        txtIdCus.setEditable(false);
        txtIdCus.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        btnUpdate1.setBackground(new java.awt.Color(102, 204, 255));
        btnUpdate1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnUpdate1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/pharmacymanagementproject/img/Help-icon-16.png"))); // NOI18N
        btnUpdate1.setText("Tải lại");
        btnUpdate1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdate1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtIdBill, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPhoneCus, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtNameCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtIdCus, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnUpdate1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCreateCus, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCreateBill, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(btnUpdate1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCreateCus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCreateBill, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtIdCus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15)
                    .addComponent(txtNameCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14)
                    .addComponent(txtPhoneCus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.CENTER, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(txtIdBill, javax.swing.GroupLayout.Alignment.CENTER, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        btnSave.setBackground(new java.awt.Color(51, 102, 255));
        btnSave.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnSave.setForeground(new java.awt.Color(255, 255, 255));
        btnSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/pharmacymanagementproject/img/Save-icon.png"))); // NOI18N
        btnSave.setText("Lưu");
        btnSave.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSaveMouseClicked(evt);
            }
        });
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        jButton7.setBackground(new java.awt.Color(255, 102, 102));
        jButton7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton7.setForeground(new java.awt.Color(255, 255, 255));
        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/pharmacymanagementproject/img/Actions-edit-delete-icon-16.png"))); // NOI18N
        jButton7.setText("Hủy");
        jButton7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton7MouseClicked(evt);
            }
        });
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtTotalPriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTotalPriceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTotalPriceActionPerformed

    private void txtPhoneCusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPhoneCusActionPerformed

    }//GEN-LAST:event_txtPhoneCusActionPerformed

    private void txtNameMedicineKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNameMedicineKeyReleased

    }//GEN-LAST:event_txtNameMedicineKeyReleased


    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased
        try {
            String searchString = txtSearch.getText();
            medicineController.searchTableModel(this, searchString);
        } catch (SQLException ex) {
            Logger.getLogger(MedicinePanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_txtSearchKeyReleased

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {
            String searchString = txtSearch.getText();
            medicineController.searchTableModel(this, searchString);
        } catch (SQLException ex) {
            Logger.getLogger(MedicinePanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void tbl_Display_MedicineMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_Display_MedicineMouseClicked

        medicineController.selectRowMedicine(this);
    }//GEN-LAST:event_tbl_Display_MedicineMouseClicked

    private void txtSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearchActionPerformed

    private void txtIdMeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIdMeKeyReleased
        try {
            medicineController.searchById(this, Integer.parseInt(txtIdMe.getText()));
        } catch (SQLException ex) {
            Logger.getLogger(MedicinePanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_txtIdMeKeyReleased

    private void txtQuantityKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtQuantityKeyReleased

    }//GEN-LAST:event_txtQuantityKeyReleased

    private void txtQuantityMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtQuantityMouseClicked

    }//GEN-LAST:event_txtQuantityMouseClicked

    private void txtQuantityStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_txtQuantityStateChanged

        if ((int) txtQuantity.getValue() != 0 || (int) txtQuantity.getValue() > 0) {
            int quantity = (int) (txtQuantity.getValue());
            int price = Integer.parseInt(txtPrice.getText());
            txtTotalPrice.setText(String.valueOf(quantity * price));
        }
    }//GEN-LAST:event_txtQuantityStateChanged

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        billController.addBillDetails(this);
        medicineController.clearTextMedicinePanel(this);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtNameMedicineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNameMedicineActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNameMedicineActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
//        try {
//            billDTO = billController.getByIdBill(Integer.parseInt(txtIdBill.getText()));
//            ConfirmBill confirmBill = new ConfirmBill(new javax.swing.JFrame(), true, billDTO);
//            confirmBill.setLocationRelativeTo(this);
//            confirmBill.setVisible(true);
//            DefaultTableModel modelBillDetail = (DefaultTableModel) tbl_Display_BillDetail.getModel();
//            modelBillDetail.setRowCount(0);
//        } catch (SQLException ex) {
//            Logger.getLogger(MedicinePanel.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnSaveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSaveMouseClicked
        try {
            billDTO = billController.getByIdBill(Integer.parseInt(txtIdBill.getText()));
            ConfirmBill confirmBill = new ConfirmBill(new javax.swing.JFrame(), true, billDTO);
            confirmBill.setLocationRelativeTo(this);
            confirmBill.setVisible(true);
            DefaultTableModel modelBillDetail = (DefaultTableModel) tbl_Display_BillDetail.getModel();
            modelBillDetail.setRowCount(0);
            //txtIdBill.setText(String.valueOf(createBill(userDTO)));
            medicineController.clearTextMedicinePanel(this);

        } catch (SQLException ex) {
            Logger.getLogger(MedicinePanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnSaveMouseClicked

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed

    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton7MouseClicked

        try {
            JOptionPane.showConfirmDialog(this, "Bạn có chắc là muốn hủy thao tác");
            billController.delete(Integer.parseInt(txtIdBill.getText()));
            DefaultTableModel modelBillDetail = (DefaultTableModel) tbl_Display_BillDetail.getModel();
            modelBillDetail.setRowCount(0);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Bạn vui lòng tạo hóa đơn");
            Logger.getLogger(MedicinePanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton7MouseClicked

    private void btnCreateBillMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCreateBillMouseClicked

    }//GEN-LAST:event_btnCreateBillMouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        medicineController.clearTextMedicinePanel(this);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseClicked

    }//GEN-LAST:event_jButton3MouseClicked

    private void txtPhoneCusKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPhoneCusKeyReleased
        try {
            customerController.searchByPhoneCustomer(this, txtPhoneCus.getText());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Khách hàng mới!!");
        }
    }//GEN-LAST:event_txtPhoneCusKeyReleased

    private void btnCreateCusMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCreateCusMouseClicked

    }//GEN-LAST:event_btnCreateCusMouseClicked

    private void btnCreateCusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateCusActionPerformed
        customerController.addCustomer(this);
    }//GEN-LAST:event_btnCreateCusActionPerformed

    private void btnCreateBillActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateBillActionPerformed
        try {
            billController.checkIdCus(this);
            System.out.println(customerController.getById(Integer.parseInt(txtIdCus.getText())));
            txtIdBill.setText(String.valueOf(billController.createBill(this, userDTO, customerController.getById(Integer.parseInt(txtIdCus.getText())))));
            JOptionPane.showMessageDialog(this, "Bất đầu tạo Hóa đơn!!");
        } catch (SQLException ex) {
            Logger.getLogger(MedicinePanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnCreateBillActionPerformed

    private void btnUpdate1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdate1ActionPerformed
        try {

            medicineController.updateModelMedicine(this);        // TODO add your handling code here:
        } catch (SQLException ex) {
            Logger.getLogger(MedicinePanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnUpdate1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCreateBill;
    private javax.swing.JButton btnCreateCus;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnUpdate1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tbl_Display_BillDetail;
    private javax.swing.JTable tbl_Display_Medicine;
    private javax.swing.JTextField txtDateHH;
    private javax.swing.JTextField txtIdBill;
    private javax.swing.JTextField txtIdCus;
    private javax.swing.JTextField txtIdMe;
    private javax.swing.JTextField txtNameCustomer;
    private javax.swing.JTextField txtNameMedicine;
    private javax.swing.JTextField txtPhoneCus;
    private javax.swing.JTextField txtPrice;
    private javax.swing.JSpinner txtQuantity;
    private javax.swing.JTextField txtSLT;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtTotalPrice;
    private javax.swing.JTextField txtUnit;
    // End of variables declaration//GEN-END:variables
}

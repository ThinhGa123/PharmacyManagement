/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pharmacymanagementproject.dto;

import com.mycompany.pharmacymanagementproject.model.BillDetail;
import java.sql.Date;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BillDTO {

    private int idBill;
    private String creationTime;
    private double totalMoney;
    private int IDUser;
    private String updateTime;
    private boolean statusBill;
    private List<BillDetail> billdetails;

    @Override
    public String toString() {
        return "BillDTO{" + "idBill=" + idBill + ", creationTime=" + creationTime + ", totalMoney=" + totalMoney + ", IDUser=" + IDUser + ", updateTime=" + updateTime + ", statusBill=" + statusBill + ", billdetails=" + billdetails + '}';
    }

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pharmacymanagementproject.model;


import java.sql.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Bill {

    private int idBill;
    private String creationTime;
    private double totalMoney;
    private int IDUser;
    private String updateTime;
    private boolean status;
    private int idCustomer;

    @Override
    public String toString() {
        return "Bill{" + "idBill=" + idBill + ", creationTime=" + creationTime + ", totalMoney=" + totalMoney + ", IDUser=" + IDUser + ", updateTime=" + updateTime + ", status=" + status + ", idCustomer=" + idCustomer + '}';
    }

}

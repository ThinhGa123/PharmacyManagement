/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pharmacymanagementproject.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BillDetail {

    private int idBill;
    private int idMedicine;
    private double totalPrice;
    private int quantity;
    private double price;

    @Override
    public String toString() {
        return "BillDetail{" + "idBill=" + idBill + ", idMedicine=" + idMedicine + ", totalPrice=" + totalPrice + ", quantity=" + quantity + ", price=" + price + '}';
    }

}

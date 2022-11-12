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
public class Customer {
    private int IdCustomer;
    private String phone;
    private String name;

    @Override
    public String toString() {
        return "Customer{" + "IdCustomer=" + IdCustomer + ", phone=" + phone + ", name=" + name + '}';
    }
    
}

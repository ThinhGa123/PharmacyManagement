package com.mycompany.pharmacymanagementproject.model;

import java.sql.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Medicine {

    private int IdMedicine;
    private String name;
    private String element;
    private String image;
    private String provider;
    private String expirationDate;
    private int amountInventory;
    private long price;
    private String unit;
    private int idUser;
    private String uses;

    @Override
    public String toString() {
        return "Medicine{" + "IdMedicine=" + IdMedicine + ", name=" + name + ", element=" + element + ", image=" + image + ", provider=" + provider + ", expirationDate=" + expirationDate + ", amountInventory=" + amountInventory + ", price=" + price + ", unit=" + unit + ", idUser=" + idUser + ", use=" + uses + '}';
    }

}

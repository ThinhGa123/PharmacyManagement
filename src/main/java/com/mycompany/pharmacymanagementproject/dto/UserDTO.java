/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pharmacymanagementproject.dto;

import java.sql.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDTO {

    private int IdUser;

    private String fullName;
    private String creationTime;
    private String updateTime;
    private String birthOfDay;
    private String phone;
    private String address;
    private String image;
    private String empCode;
    private String role;

    @Override
    public String toString() {
        return "UserDTO{" + "IdUser=" + IdUser + ", fullName=" + fullName + ", creationTime=" + creationTime + ", updateTime=" + updateTime + ", birthOfDay=" + birthOfDay + ", phone=" + phone + ", address=" + address + ", image=" + image + ", empCode=" + empCode + ", role=" + role + '}';
    }

}

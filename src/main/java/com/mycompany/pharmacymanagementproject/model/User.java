package com.mycompany.pharmacymanagementproject.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {

    private int IdUser;
    private String userName;
    private String password;
    private String fullName;
    private String creationTime;
    private String updateTime;
    private String birthOfDay;
    private String phone;
    private String address;
    private String image;
    private String empCode;
    private String role;
    private String gender;

    @Override
    public String toString() {
        return "User{" + "IdUser=" + IdUser + ", userName=" + userName + ", password=" + password + ", fullName=" + fullName + ", creationTime=" + creationTime + ", updateTime=" + updateTime + ", birthOfDay=" + birthOfDay + ", phone=" + phone + ", address=" + address + ", image=" + image + ", empCode=" + empCode + ", role=" + role + ", gender=" + gender + '}';
    }

}

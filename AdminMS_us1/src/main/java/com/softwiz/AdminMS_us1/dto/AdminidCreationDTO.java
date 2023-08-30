package com.softwiz.AdminMS_us1.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AdminidCreationDTO {


    private String adminName;
    private String password;
    @Override
    public String toString() {
        return "AdminidCreationDTO{" +
                "adminName='" + adminName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }


}

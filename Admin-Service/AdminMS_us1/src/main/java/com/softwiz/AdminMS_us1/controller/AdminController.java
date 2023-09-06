package com.softwiz.AdminMS_us1.controller;

import com.softwiz.AdminMS_us1.dto.AdminDTO;
import com.softwiz.AdminMS_us1.entity.Admin;
import com.softwiz.AdminMS_us1.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;

/*Create the Admin account*/
    @PostMapping("/adminaccount")
    public Admin createAdmin(@RequestBody AdminDTO admin) {
        return adminService.saveAdmin(admin);
    }



}

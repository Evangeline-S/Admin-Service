package com.swiz.bcs.controller;

import com.swiz.bcs.dto.UserDTO;
import com.swiz.bcs.entity.UserAccount;
import com.swiz.bcs.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin/createUser")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping
    public UserAccount createUser(@RequestBody UserDTO userDTO) {
        return adminService.saveUser(userDTO);
    }

    @GetMapping
    public List<UserAccount> getAlluser() {
        return adminService.findAlluser();
    }

    @GetMapping("/{id}")
    public UserAccount getUserById(@PathVariable Long id) {
        return adminService.getUserById(id);
    }
//    @DeleteMapping("/deleteUser/{id}")
//    public AddResponse deleteUser(@PathVariable(value="id") int id)//addresponse class is there to metion the message
//    {
//        return adminService.deleteUser(id);
//
//    }
    // Other endpoints related to admin
}


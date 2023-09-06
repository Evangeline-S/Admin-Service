package com.swiz.bcs.controller;

import com.swiz.bcs.dto.UserDTO;
import com.swiz.bcs.entity.UserAccount;
import com.swiz.bcs.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;
/* Create user by admin */
//    @PostMapping("/createUser")
//    public UserAccount createUser(@RequestBody UserDTO userDTO) {
//        return adminService.saveUser(userDTO);
//    }
/* Get al the user*/
    @GetMapping
    public List<UserAccount> getAlluser() {
        return adminService.findAlluser();
    }
/* Get the user details based on ID*/
    @GetMapping("/{id}")
    public UserAccount getUserById(@PathVariable Integer id) {
        return adminService.getUserById(id);
    }

    /*Delete the user using Id*/
//    @DeleteMapping("user/{id}")
//    public ResponseEntity<String> deleteUser(@PathVariable Integer id)
//    {
//        adminService.deleteUserById(id);
//        return ResponseEntity.ok("User deleted successfully");
//    }
    // Endpoint to disable a user account
    @PostMapping("/disable/{Id}")
    public ResponseEntity<String> disableUserAccount(@PathVariable Integer Id) {
        adminService.disableUserAccount(Id);
        return ResponseEntity.ok("User account disabled successfully.");
    }

    // Endpoint to enable a user account
    @PostMapping("/enable/{Id}")
    public ResponseEntity<String> enableUserAccount(@PathVariable Integer Id) {
        adminService.enableUserAccount(Id);
        return ResponseEntity.ok("User account enabled successfully.");
    }
}



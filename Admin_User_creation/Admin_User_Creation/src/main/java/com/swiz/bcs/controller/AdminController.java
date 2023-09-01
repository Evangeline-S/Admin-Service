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
    @PostMapping("/createUser")
    public UserAccount createUser(@RequestBody UserDTO userDTO) {
        return adminService.saveUser(userDTO);
    }
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

/*Set user Status*/
    @PutMapping("/users/{id}/enable")
    public ResponseEntity<String> enableUser(@PathVariable Integer Id){
        adminService.enableUser(Id);
        return ResponseEntity.ok("User enabled");
    }
/*Set the user Status*/
    @PutMapping("/users/{id}/disable")
    public ResponseEntity<String> disableUser(Integer Id){
        adminService.disableUser(Id);
        return ResponseEntity.ok("User disabled");
    }
    /*Delete the user using Id*/
    @DeleteMapping("user/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Integer id)
    {
        adminService.deleteUserById(id);
        return ResponseEntity.ok("User deleted successfully");
    }
//    @DeleteMapping("/users/{userId}")
//    public ResponseEntity<String> deleteUser(@PathVariable Integer Id) {
//        try {
//            adminService.deleteUserById(Id);
//            return ResponseEntity.ok("User deleted successfully.");
//        } catch (EmptyResultDataAccessException e) {
//            return ResponseEntity.notFound().build();
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
//                    .body("An error occurred while deleting the user.");
//        }
//    }
}


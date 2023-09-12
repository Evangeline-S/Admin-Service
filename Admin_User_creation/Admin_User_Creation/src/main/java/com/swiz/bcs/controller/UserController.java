package com.swiz.bcs.controller;

import com.swiz.bcs.entity.User;
import com.swiz.bcs.entity.UserAccount;
import com.swiz.bcs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {


        private final UserService userService;

        @Autowired
        public UserController(UserService userService) {
            this.userService = userService;
        }

    @PostMapping
    public User createUser(@RequestBody User user, @RequestParam String adminUsername) {
        return userService.createUser(user, adminUsername);
    }

    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable Integer userId, @RequestParam String adminUsername) {
        userService.deleteUser(userId, adminUsername);
    }

    @PutMapping("/{userId}")
    public User updateUser(@PathVariable Integer userId, @RequestBody User updatedUser, @RequestParam String adminUsername) {
        return userService.updateUser(userId, updatedUser, adminUsername);
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping("/{userId}/enable")
    public void enableUser(@PathVariable Integer userId, @RequestParam String adminUsername) {
        userService.enableUser(userId, adminUsername);
    }

    @PostMapping("/{userId}/disable")
    public void disableUser(@PathVariable Integer userId, @RequestParam String adminUsername) {
        userService.disableUser(userId, adminUsername);
    }

//        @PostMapping
//        public User createUser(@RequestBody User user, @RequestParam String adminUsername) {
//            return userService.createUser(user, adminUsername);
//        }
//
//        @PutMapping("/{userId}")
//        public void updateUser(@PathVariable Integer userId, @RequestBody User user, @RequestParam String adminUsername,String objectType) {
//            user.setId(userId);
//            userService.updateUser(user, adminUsername,objectType);
//        }
//
//        @DeleteMapping("/{userId}")
//        public void deleteUser(@PathVariable Integer userId, @RequestParam String adminUsername,String objectType) {
//            userService.deleteUser(userId, adminUsername,objectType);
//        }
    }


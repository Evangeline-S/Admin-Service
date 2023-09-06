package com.swiz.bcs.controller;

import com.swiz.bcs.entity.User;
import com.swiz.bcs.entity.UserAccount;
import com.swiz.bcs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

        @PutMapping("/{userId}")
        public void updateUser(@PathVariable Integer userId, @RequestBody User user, @RequestParam String adminUsername) {
            user.setId(userId);
            userService.updateUser(user, adminUsername);
        }

        @DeleteMapping("/{userId}")
        public void deleteUser(@PathVariable Integer userId, @RequestParam String adminUsername) {
            userService.deleteUser(userId, adminUsername);
        }
    }


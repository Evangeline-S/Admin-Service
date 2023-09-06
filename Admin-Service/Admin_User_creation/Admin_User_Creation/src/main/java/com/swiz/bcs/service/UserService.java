package com.swiz.bcs.service;

import com.swiz.bcs.entity.User;
import com.swiz.bcs.entity.UserAccount;
import com.swiz.bcs.repository.AdminRepository;
import com.swiz.bcs.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final AuditLogService auditLogService;

    @Autowired
    public UserService(UserRepository userRepository, AuditLogService auditLogService) {
        this.userRepository = userRepository;
        this.auditLogService = auditLogService;
    }


    public User createUser(User user, String adminUsername) {
        User createdUser = userRepository.save(user);

        // Log the user creation action
        auditLogService.logAdminAction(adminUsername, "Create User", user.getId());

        return createdUser;
    }


    public void updateUser(User user, String adminUsername) {
        userRepository.save(user);

        // Log the user update action
        auditLogService.logAdminAction(adminUsername, "Update User", user.getId());
    }


    public void deleteUser(Integer userId, String adminUsername) {
        userRepository.deleteById(userId);

        // Log the user deletion action
        auditLogService.logAdminAction(adminUsername, "Delete User", userId);
    }
}


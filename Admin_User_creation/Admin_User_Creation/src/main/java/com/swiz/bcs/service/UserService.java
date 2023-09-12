package com.swiz.bcs.service;

import com.swiz.bcs.entity.User;
import com.swiz.bcs.entity.UserAccount;
import com.swiz.bcs.repository.AdminRepository;
import com.swiz.bcs.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

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
        auditLogService.logAdminAction(adminUsername, "Create User", createdUser.getId(), "user");

        return createdUser;
    }


    public void deleteUser(Integer userId, String adminUsername) {
        userRepository.deleteById(userId);

        // Log the user deletion action
        auditLogService.logAdminAction(adminUsername, "Delete User", userId, "user");
    }

    public User updateUser(Integer userId, User updatedUser, String adminUsername) {
        // Check if the user with the specified ID exists
        if (!userRepository.existsById(userId)) {
            throw new EntityNotFoundException("User not found with ID: " + userId);
        }

        updatedUser.setId(userId);
        User savedUser = userRepository.save(updatedUser);

        // Log the user update action
        auditLogService.logAdminAction(adminUsername, "Update User", savedUser.getId(), "user");

        return savedUser;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }


    public void enableUser(Integer userId, String adminUsername) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("User not found with ID: " + userId));

        user.setEnabled(true);
        userRepository.save(user);

        // Log the user enable action
        auditLogService.logAdminAction(adminUsername, "Enable User", userId, "user");
    }


    public void disableUser(Integer userId, String adminUsername) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("User not found with ID: " + userId));

        user.setEnabled(false);
        userRepository.save(user);

        // Log the user disable action
        auditLogService.logAdminAction(adminUsername, "Disable User", userId, "user");
    }
}


//    public User createUser(User user, String adminUsername) {
//        User createdUser = userRepository.save(user);
//
//        // Log the user creation action
//        auditLogService.logAdminAction(adminUsername, "Create User", user.getId());
//
//        return createdUser;
//    }
//
//
//    public void updateUser(User user, String adminUsername,String objectType) {
//        userRepository.save(user);
//
//        // Log the user update action
//        auditLogService.logAdminAction(adminUsername, "Update User", user.getId(),objectType);
//    }
//
//
//    public void deleteUser(Integer userId, String adminUsername,String objectType) {
//        userRepository.deleteById(userId);
//
//        // Log the user deletion action
//        auditLogService.logAdminAction(adminUsername, "Delete User", userId,objectType);
//    }



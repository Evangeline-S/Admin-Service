package com.swiz.bcs.service;



import com.swiz.bcs.dto.UserDTO;
import com.swiz.bcs.entity.UserAccount;
import com.swiz.bcs.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;


    public UserAccount saveUser(UserDTO userDTO) {
        UserAccount userAccount = new UserAccount();
        userAccount.setUserName(userDTO.getUserName());
        userAccount.setPassword(userDTO.getPassword());
        userAccount.setEmail(userDTO.getEmail());
        userAccount.setEnabled(userDTO.getEnabled());
        return adminRepository.save(userAccount);
    }

    public List<UserAccount> findAlluser() {
        return adminRepository.findAll();
    }

    public UserAccount getUserById(Integer id) {
        return adminRepository.findById(id).orElse(null);
    }

    /*Enable/Disable user*/
//    @Transactional
    public void enableUser(Integer Id) {
        UserAccount user = adminRepository.findById(Id).orElse(null);
        if (user != null) {
            user.setEnabled(true);
            adminRepository.save(user);
        }
    }

    public void disableUser(Integer Id) {
        UserAccount user = adminRepository.findById(Id).orElse(null);
        if (user != null) {
            user.setEnabled(false);
            adminRepository.save(user);
        }
    }
    public void deleteUserById(Integer id)
    {
        adminRepository.deleteById(id);
    }
}

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
        return adminRepository.save(userAccount);
    }

    public List<UserAccount> findAlluser() {
        return adminRepository.findAll();
    }

    public UserAccount getUserById(Long id) {
        return adminRepository.findById(id).orElse(null);
    }
//    public AddResponse deleteUser(int id)
//    {
//        adminRepository.deleteById(id);
//        AddResponse res=new AddResponse();
//        res.setMsg("User deleted!");
//        res.setId(id);
//        return res;
//    }
    // Other author-related operations
}


package com.swiz.bcs.service;



import com.swiz.bcs.dto.UserDTO;
import com.swiz.bcs.entity.UserAccount;
import com.swiz.bcs.repository.AdminRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;



//    public UserAccount saveUser(UserDTO userDTO) {
//        UserAccount userAccount = new UserAccount();
//        userAccount.setUserName(userDTO.getUserName());
//        userAccount.setPassword(userDTO.getPassword());
//        userAccount.setEmail(userDTO.getEmail());
//       userAccount.setIsactive(userDTO.getIsactive());
//        return adminRepository.save(userAccount);
//    }

    public List<UserAccount> findAlluser() {
        return adminRepository.findAll();
    }

    public UserAccount getUserById(Integer id)
    {
        return adminRepository.findById(id).orElse(null);
    }
    /*Set user Status as Disabled*/
          public void disableUserAccount(Integer Id) {
            UserAccount user = adminRepository.findById(Id).orElse(null);

            user.setIsactive(false);
            adminRepository.save(user);
        }
    /*Set user Status as enabled*/
        public void enableUserAccount(Integer Id) {
            UserAccount user = adminRepository.findById(Id).orElse(null);

            user.setIsactive(true);
            adminRepository.save(user);
        }


  //  public void deleteUserById(Integer id)
//    {
//        adminRepository.deleteById(id);
//    }
}

package com.softwiz.AdminMS_us1.service;

import com.softwiz.AdminMS_us1.dto.AdminDTO;
import com.softwiz.AdminMS_us1.dto.AdminidCreationDTO;
import com.softwiz.AdminMS_us1.entity.Admin;
import com.softwiz.AdminMS_us1.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {
    @Autowired
    private AdminRepository adminRepository;
    private AdminidCreationDTO adminidCreationDTO;
    public Admin saveAdmin(AdminDTO admin) {
        Admin adminDetails = new Admin();
        adminDetails.setAdminName(admin.getAdminName());
        adminDetails.setPassword(admin.getPassword());
        return adminRepository.save(adminDetails);

    }
    public void validatepassword(AdminidCreationDTO adminidCreationDTO)
    {
        if(adminidCreationDTO.getPassword().length()<8)
        {
            throw new IllegalArgumentException(("password  must be at least 8 characters"));
        }
    }
//    public void registerUser(UserRegistrationRequest registrationRequest) {
//        // Validate the request
//        if (registrationRequest.getPassword().length() < 8) {
//            throw new IllegalArgumentException("Password must be at least 8 characters");
//        }

}

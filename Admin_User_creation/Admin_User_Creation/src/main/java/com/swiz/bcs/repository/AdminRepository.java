package com.swiz.bcs.repository;

import com.swiz.bcs.entity.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<UserAccount,Integer> {
}
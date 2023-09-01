package com.swiz.bcs.repository;

import com.swiz.bcs.entity.Loan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LoanRepository extends JpaRepository<Loan,Integer> {
    List<Loan> findByReturnedFalse();//Quesry to get ongoing loans
    List<Loan> findByStatus(Loan.LoanStatus status);//Query to get oan by status
}

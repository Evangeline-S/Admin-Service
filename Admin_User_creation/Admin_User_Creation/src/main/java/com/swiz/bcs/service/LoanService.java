package com.swiz.bcs.service;

import com.swiz.bcs.dto.LoanDTO;
import com.swiz.bcs.dto.UserDTO;
import com.swiz.bcs.entity.Loan;
import com.swiz.bcs.entity.UserAccount;
import com.swiz.bcs.repository.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoanService {
    @Autowired
    private LoanRepository loanRepository;
    public List<Loan> getAllOngoingLoans(){
        return loanRepository.findByReturnedFalse();
    }

    public List<Loan> getAllPastLoans(){
        return loanRepository.findByStatus(Loan.LoanStatus.PAST);
    }
/*Create loan Details*/
    public Loan saveLoan(LoanDTO loanDTO) {
        Loan loanDetails = new Loan();
        loanDetails.setIssuedate(loanDTO.getIssuedate());
        loanDetails.setDuedate(loanDTO.getDuedate());
        loanDetails.setReturned(loanDTO.getReturned());
        loanDetails.setReturnDate(loanDTO.getReturnDate());
//        loanDetails.setStatus(loanDTO.getStatus());
        return loanRepository.save(loanDetails);
    }
}

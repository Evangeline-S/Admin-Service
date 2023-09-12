package com.swiz.bcs.service;

import com.swiz.bcs.dto.BookDTO;
import com.swiz.bcs.dto.LoanDTO;
import com.swiz.bcs.dto.UserDTO;
import com.swiz.bcs.entity.Book;
import com.swiz.bcs.entity.Loan;
import com.swiz.bcs.entity.UserAccount;
import com.swiz.bcs.repository.AdminRepository;
import com.swiz.bcs.repository.BookRepository;
import com.swiz.bcs.repository.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LoanService {
    private final LoanRepository loanRepository;
    private final AuditLogService auditLogService;

    @Autowired
    public LoanService(LoanRepository loanRepository, AuditLogService auditLogService) {
        this.loanRepository = loanRepository;
        this.auditLogService = auditLogService;
    }


    public Loan createLoan(Loan loan, String adminUsername) {
        Loan createdLoan = loanRepository.save(loan);

        // Log the loan creation action
        auditLogService.logAdminAction(adminUsername, "Create Loan", createdLoan.getId(), "loan");

        return createdLoan;
    }


    public Loan updateLoan(Integer loanId, Loan updatedLoan, String adminUsername) {
        // Check if the loan with the specified ID exists
        if (!loanRepository.existsById(loanId)) {
            throw new EntityNotFoundException("Loan not found with ID: " + loanId);
        }

        updatedLoan.setId(loanId);
        Loan savedLoan = loanRepository.save(updatedLoan);

        // Log the loan update action
        auditLogService.logAdminAction(adminUsername, "Update Loan", savedLoan.getId(), "loan");

        return savedLoan;
    }


    public void deleteLoan(Integer loanId, String adminUsername) {
        loanRepository.deleteById(loanId);

        // Log the loan deletion action
        auditLogService.logAdminAction(adminUsername, "Delete Loan", loanId, "loan");
    }

    public List<Loan> getAllOngoingLoans() {
        return loanRepository.findByReturnedFalse();
        // Implement logic to retrieve ongoing loans
    }

    public List<Loan> getAllPastLoans() {
        return loanRepository.findByStatus(Loan.LoanStatus.PAST);
        // Implement logic to retrieve past loans
    }


//    @Autowired
//    private LoanRepository loanRepository;
//    private BookRepository bookRepository;
//    private AdminRepository adminRepository;
//   public List<Loan> getAllOngoingLoans(){
//        return loanRepository.findByReturnedFalse();}
//
//
//    public List<Loan> getAllPastLoans(){
//        return loanRepository.findByStatus(Loan.LoanStatus.PAST);
//    }
///*Create loan Details*/
//    public Loan saveLoan(LoanDTO loanDTO) {
//        Loan loanDetails = new Loan();
//        loanDetails.setIssuedate(loanDTO.getIssuedate());
//        loanDetails.setDuedate(loanDTO.getDuedate());
//        loanDetails.setReturned(loanDTO.getReturned());
//        loanDetails.setReturnDate(loanDTO.getReturnDate());
////        loanDetails.setStatus(loanDTO.getStatus());
//        return loanRepository.save(loanDetails);
//    }

}

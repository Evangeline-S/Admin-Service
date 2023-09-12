package com.swiz.bcs.controller;

import com.swiz.bcs.dto.LoanDTO;
import com.swiz.bcs.entity.Book;
import com.swiz.bcs.entity.Loan;
import com.swiz.bcs.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequestMapping("/api/loans")
@RestController
public class AdminLoanController {
    @Autowired
    private LoanService loanService;

    @PostMapping
    public Loan createLoan(@RequestBody Loan loan, @RequestParam String adminUsername) {
        return loanService.createLoan(loan, adminUsername);
    }

    @PutMapping("/{loanId}")
    public Loan updateLoan(@PathVariable Integer loanId, @RequestBody Loan updatedLoan, @RequestParam String adminUsername) {
        return loanService.updateLoan(loanId, updatedLoan, adminUsername);
    }

    @DeleteMapping("/{loanId}")
    public void deleteLoan(@PathVariable Integer loanId, @RequestParam String adminUsername) {
        loanService.deleteLoan(loanId, adminUsername);
    }

    @GetMapping("/ongoing")
    public List<Loan> getAllOngoingLoans() {
        return loanService.getAllOngoingLoans();
    }

    @GetMapping("/past")
    public List<Loan> getAllPastLoans() {
        return loanService.getAllPastLoans();
    }

//    @GetMapping("/loans/ongoing")
//    public ResponseEntity<List<Loan>> getOngoingLoans(){
//        List<Loan> ongoingLoans=loanService.getAllOngoingLoans();
//        return ResponseEntity.ok(ongoingLoans);
//    }
// Endpoint to get a list of all ongoing loans with associated Book and UserAccount details
//@GetMapping("/loans/ongoing")
//public ResponseEntity<List<Loan>> getOngoingLoans(){
//    List<Loan> ongoingLoans=loanService.getAllOngoingLoans();
//    return ResponseEntity.ok(ongoingLoans);
//}
//
//    @GetMapping("/loans/past")
//    public ResponseEntity<List<Loan>> getPastLoans(){
//        List<Loan> pastLoans = loanService.getAllPastLoans();
//        return ResponseEntity.ok(pastLoans);
//    }
//    @PostMapping("/loanDetails")
//    public Loan createBook(@RequestBody LoanDTO loanDTO) {
//        return loanService.saveLoan(loanDTO);
//    }

}


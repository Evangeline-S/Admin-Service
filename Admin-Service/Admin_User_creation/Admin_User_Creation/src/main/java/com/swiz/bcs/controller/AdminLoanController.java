package com.swiz.bcs.controller;

import com.swiz.bcs.dto.LoanDTO;
import com.swiz.bcs.entity.Book;
import com.swiz.bcs.entity.Loan;
import com.swiz.bcs.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AdminLoanController {
    @Autowired
    private LoanService loanService;

//    @GetMapping("/loans/ongoing")
//    public ResponseEntity<List<Loan>> getOngoingLoans(){
//        List<Loan> ongoingLoans=loanService.getAllOngoingLoans();
//        return ResponseEntity.ok(ongoingLoans);
//    }
// Endpoint to get a list of all ongoing loans with associated Book and UserAccount details
@GetMapping("/loans/ongoing")
public ResponseEntity<List<Loan>> getOngoingLoans(){
    List<Loan> ongoingLoans=loanService.getAllOngoingLoans();
    return ResponseEntity.ok(ongoingLoans);
}

    @GetMapping("/loans/past")
    public ResponseEntity<List<Loan>> getPastLoans(){
        List<Loan> pastLoans = loanService.getAllPastLoans();
        return ResponseEntity.ok(pastLoans);
    }
    @PostMapping("/loanDetails")
    public Loan createBook(@RequestBody LoanDTO loanDTO) {
        return loanService.saveLoan(loanDTO);
    }

}


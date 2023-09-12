package com.swiz.bcs.dto;

import com.swiz.bcs.entity.Loan;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.time.LocalDate;

@Getter
@Setter
public class LoanDTO {
    int id;
    private LocalDate issuedate;
    private LocalDate duedate;
    private LocalDate returnDate;
    private Boolean returned;
    private Double lateFee;

    //private LoanStatus status;
    private BookDTO book;
    private UserDTO userAccount;



    private Loan.LoanStatus status;

  //  public void setStatus(Loan.LoanStatus status) {
   // }



    @Override
    public String toString() {
        return "LoanDTO{" +
                "issuedate=" + issuedate +
                ", duedate=" + duedate +
                ", returnDate=" + returnDate +
                ", returned=" + returned +
                ", lateFee=" + lateFee +
                '}';

    }
}

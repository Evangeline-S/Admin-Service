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

    private LocalDate issuedate;

    private LocalDate duedate;


    private LocalDate returnDate;

    //  private Status loanStatus;
    private Boolean returned;

    private Double lateFee;

//    @Enumerated(EnumType.STRING)
//    private Loan.LoanStatus status;

//    public enum LoanStatus{
//        ONGOING,
//        PAST
//    }

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

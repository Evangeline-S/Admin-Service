package com.swiz.bcs.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.transaction.Status;
import java.time.LocalDate;

@Entity
@Setter
@Getter
public class Loan {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_account_id")
    private UserAccount userAccount;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "book_id")
    private Book book;

    private LocalDate issuedate;

    private LocalDate duedate;

    private LocalDate returnDate;

  //  private Status loanStatus;
    private Boolean returned;

    private Double lateFee;

    @Enumerated(EnumType.STRING)
    private LoanStatus status;

    public enum LoanStatus{
        ONGOING,
        PAST
    }

}

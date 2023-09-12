package com.swiz.bcs.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "audit_logs")
@Getter
@Setter
public class AuditLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private Date timestamp;
    private String adminUsername;
    private String action;
   // private int targetUserId;
    private String objectType; // Indicates whether it's related to a book or a loan
    private int objectId;// ID of the book or loan

}

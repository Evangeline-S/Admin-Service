package com.swiz.bcs.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "UserAccount")
@Getter
@Setter
public class UserAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    private String userName;


    private String password;


    private String email;

    private Boolean enabled;

    // Getters and Setters

    // Equals and HashCode

    // Other methods and logic
}

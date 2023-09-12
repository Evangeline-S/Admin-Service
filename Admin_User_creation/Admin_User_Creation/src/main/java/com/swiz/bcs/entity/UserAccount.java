package com.swiz.bcs.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "UserAccount")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    private String userName;


    private String password;


    private String email;

    @Column(nullable = false)
    private boolean isactive;

    // Getters and Setters

    // Equals and HashCode

    // Other methods and logic
}

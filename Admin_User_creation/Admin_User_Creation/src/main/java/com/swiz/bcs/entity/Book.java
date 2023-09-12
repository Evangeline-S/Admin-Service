package com.swiz.bcs.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(nullable = false, unique = true)
    private String title;
    private String author;
    @Column(nullable = false)
    private String genre;
    @Column(nullable = false, unique = true)
    private String isbn;
    private Boolean isAvailable;
}

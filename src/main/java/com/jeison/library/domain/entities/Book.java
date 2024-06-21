package com.jeison.library.domain.entities;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 100)
    private String title;
    @Column(nullable = false, length = 100)
    private String author;
    @Column(nullable = false)
    private int publicationYear;
    @Column(nullable = false, length = 50)
    private String genre;
    @Column(nullable = false, length = 20)
    private String isbn;
    @OneToMany(mappedBy = "book",
    fetch = FetchType.LAZY,
    cascade = CascadeType.ALL,
    orphanRemoval = false)
    private List<Loan> loans;
    @OneToMany(mappedBy = "book",
    fetch = FetchType.LAZY,
    cascade = CascadeType.ALL,
    orphanRemoval = false)
    private List<Reservation> reservations;
}

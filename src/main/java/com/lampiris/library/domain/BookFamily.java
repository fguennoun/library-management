package com.lampiris.library.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "book_family")
public class BookFamily {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String label;

    @ManyToOne
    // @JsonIgnore
    // @JsonIgnoreProperties(value = "library", allowSetters = true)
    @JsonBackReference
    private Library library;

    @OneToMany(mappedBy = "bookFamily")
    @JsonIgnore
    private Set<Book> books = new HashSet<>();
}

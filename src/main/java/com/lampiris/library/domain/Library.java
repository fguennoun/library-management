package com.lampiris.library.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "library")
public class Library {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String label;

    @OneToMany(mappedBy = "library")
    @JsonIgnore
    private Set<BookFamily> bookFamilies = new HashSet<>();
}

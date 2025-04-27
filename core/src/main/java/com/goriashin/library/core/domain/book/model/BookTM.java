package com.goriashin.library.core.domain.book.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="books")
@Data
public class BookTM {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "author")
    private String author;
    @Column(name = "genre")
    private String genre;
    @Column(name = "description")
    private String description;

}

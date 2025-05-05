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
    @Column
    private String title;
    @Column
    private String author;
    @Column
    private String genre;
    @Column
    private String description;

}

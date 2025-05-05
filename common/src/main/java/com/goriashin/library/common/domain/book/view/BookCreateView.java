package com.goriashin.library.common.domain.book.view;

import lombok.Data;

@Data
public class BookCreateView {

    private Long id;
    private String title;
    private String author;
    private String genre;
    private String description;

}
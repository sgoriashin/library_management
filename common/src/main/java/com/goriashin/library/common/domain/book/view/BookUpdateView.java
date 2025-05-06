package com.goriashin.library.common.domain.book.view;

import lombok.Data;

@Data
public class BookUpdateView {

    private String title;
    private String author;
    private String genre;
    private String description;

}
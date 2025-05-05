package com.goriashin.library.common.domain.book.view;

import lombok.Data;

@Data
public class BookUpdateView {

    private String name;
    private String author;
    private String genre;
    private String description;

}
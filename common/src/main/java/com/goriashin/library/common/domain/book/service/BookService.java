package com.goriashin.library.common.domain.book.service;

import com.goriashin.library.common.domain.book.view.BookRefView;
import com.goriashin.library.common.domain.book.view.BookCreateView;
import com.goriashin.library.common.domain.book.view.BookUpdateView;

public interface BookService {

    BookRefView addBook(BookCreateView createView);
    BookRefView updateBook(Long id, BookUpdateView updateView);
    void deleteBook(Long id);

}

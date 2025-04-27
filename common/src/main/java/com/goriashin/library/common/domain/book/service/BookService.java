package com.goriashin.library.common.domain.book.service;

import com.goriashin.library.common.domain.book.view.BookRefView;
import com.goriashin.library.common.domain.book.view.BookCreateView;

public interface BookService {

    BookRefView addBook(BookCreateView createView);

}

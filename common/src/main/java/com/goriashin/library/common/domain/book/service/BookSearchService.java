package com.goriashin.library.common.domain.book.service;

import com.goriashin.library.common.domain.book.view.BookFullView;

import java.util.List;

public interface BookSearchService {

    List<BookFullView> findBooksByFilter(String title, String author, String genre);

}

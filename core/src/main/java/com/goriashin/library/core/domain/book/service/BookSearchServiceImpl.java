package com.goriashin.library.core.domain.book.service;

import com.goriashin.library.common.domain.book.service.BookSearchService;
import com.goriashin.library.common.domain.book.view.BookFullView;
import com.goriashin.library.core.domain.book.converter.BookConverter;
import com.goriashin.library.core.domain.book.model.BookTM;
import com.goriashin.library.core.domain.book.repository.BookRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BookSearchServiceImpl implements BookSearchService {

    private final BookRepository repository;
    private final BookConverter converter;

    @Override
    public List<BookFullView> findBooksByFilter(String title, String author, String genre) {
        List<BookTM> books = repository.findBooksByFilters(title, author, genre);
        return converter.toView(books);
    }

}

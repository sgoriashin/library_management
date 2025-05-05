package com.goriashin.library.core.domain.book.service;

import com.goriashin.library.common.domain.book.service.BookSearchService;
import com.goriashin.library.common.domain.book.view.BookFullView;
import com.goriashin.library.core.utils.SecurityUtils;
import com.goriashin.library.core.domain.book.converter.BookViewConverter;
import com.goriashin.library.core.domain.book.model.BookTM;
import com.goriashin.library.core.domain.book.repository.BookRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class BookSearchServiceImpl implements BookSearchService {

    private final BookRepository repository;
    private final BookViewConverter converter;

    @Override
    public List<BookFullView> findBooksByFilter(String title, String author, String genre) {
        List<BookTM> books = repository.findBooksByFilters(title, author, genre);
        log.info("User " + SecurityUtils.getCurrentUsername() + " found books with title " + title + " and author " + author + " and genre " + genre);
        return converter.toView(books);
    }

}

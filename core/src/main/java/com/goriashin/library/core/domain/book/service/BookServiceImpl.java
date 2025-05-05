package com.goriashin.library.core.domain.book.service;

import com.goriashin.library.common.domain.book.service.BookService;
import com.goriashin.library.common.domain.book.view.BookRefView;
import com.goriashin.library.common.domain.book.view.BookUpdateView;
import com.goriashin.library.core.domain.book.converter.BookUpdateViewConverter;
import com.goriashin.library.core.utils.SecurityUtils;
import com.goriashin.library.core.domain.book.converter.BookCreateViewConverter;
import com.goriashin.library.common.domain.book.view.BookCreateView;
import com.goriashin.library.core.domain.book.model.BookTM;
import com.goriashin.library.core.domain.book.repository.BookRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class BookServiceImpl implements BookService {

    private final BookRepository repository;
    private final BookCreateViewConverter createViewConverter;
    private final BookUpdateViewConverter updateViewConverter;


    @Override
    public BookRefView addBook(BookCreateView createView) {
        BookTM bookTM = createViewConverter.fromView(createView);
        repository.saveAndFlush(bookTM);
        log.info("User " + SecurityUtils.getCurrentUsername() + " created a book with id " + bookTM.getId());
        return BookRefView.builder()
                .id(bookTM.getId())
                .build();
    }

    @Override
    public BookRefView updateBook(Long id, BookUpdateView updateView) {
        BookTM bookTM = updateViewConverter.mutate(repository.getReferenceById(id), updateView);
        repository.saveAndFlush(bookTM);
        log.info("User " + SecurityUtils.getCurrentUsername() + " updated a book with id " + bookTM.getId());
        return BookRefView.builder()
                .id(bookTM.getId())
                .build();
    }

    @Override
    public void deleteBook(Long id) {
        repository.deleteById(id);
        log.info("User " + SecurityUtils.getCurrentUsername() + " deleted a book with id " + id);
    }

}

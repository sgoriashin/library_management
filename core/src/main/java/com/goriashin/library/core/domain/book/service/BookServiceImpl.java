package com.goriashin.library.core.domain.book.service;

import com.goriashin.library.common.domain.book.service.BookService;
import com.goriashin.library.common.domain.book.view.BookRefView;
import com.goriashin.library.common.domain.book.view.BookUpdateView;
import com.goriashin.library.core.domain.SecurityUtils;
import com.goriashin.library.core.domain.book.converter.BookConverter;
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

    private final BookConverter bookConverter;
    private final BookRepository repository;

    @Override
    public BookRefView addBook(BookCreateView createView) {
        BookTM bookTM = bookConverter.fromView(createView);
        repository.saveAndFlush(bookTM);
        log.info("User " + SecurityUtils.getCurrentUsername() + " created a book with id " + bookTM.getId());
        return BookRefView.builder()
                .id(bookTM.getId())
                .build();
    }

    @Override
    public BookRefView updateBook(Long id, BookUpdateView updateView) {
        BookTM bookTM = bookConverter.mutateView(repository.getReferenceById(id), updateView);
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

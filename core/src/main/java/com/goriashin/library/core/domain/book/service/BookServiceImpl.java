package com.goriashin.library.core.domain.book.service;

import com.goriashin.library.common.domain.book.service.BookService;
import com.goriashin.library.common.domain.book.view.BookRefView;
import com.goriashin.library.core.domain.book.converter.BookConverter;
import com.goriashin.library.common.domain.book.view.BookCreateView;
import com.goriashin.library.core.domain.book.model.BookTM;
import com.goriashin.library.core.domain.book.repository.BookRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookConverter bookConverter;
    private final BookRepository repository;

    @Override
    public BookRefView addBook(BookCreateView createView) {
        BookTM bookTM = bookConverter.fromView(createView);
        repository.save(bookTM);
        return BookRefView.builder()
                .id(bookTM.getId())
                .build();
    }

}

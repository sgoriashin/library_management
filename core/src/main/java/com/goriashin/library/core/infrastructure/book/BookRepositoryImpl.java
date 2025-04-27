package com.goriashin.library.core.infrastructure.book;

import com.goriashin.library.core.domain.book.model.BookTM;
import com.goriashin.library.core.domain.book.repository.BookRepository;
import org.springframework.stereotype.Repository;

@Repository
public abstract class BookRepositoryImpl implements BookRepository {

    @Override
    public BookTM save(BookTM book) {
        saveAndFlush(book);
        return saveAndFlush(book);
    }
}

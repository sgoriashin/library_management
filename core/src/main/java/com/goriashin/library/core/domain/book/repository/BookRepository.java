package com.goriashin.library.core.domain.book.repository;

import com.goriashin.library.core.domain.book.model.BookTM;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<BookTM, Long> {

     BookTM save(BookTM book);

}

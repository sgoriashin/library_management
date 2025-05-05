package com.goriashin.library.core.domain.book.repository;

import com.goriashin.library.core.domain.book.model.BookTM;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BookRepository extends JpaRepository<BookTM, Long> {

    @Query("SELECT b FROM BookTM b " +
            "WHERE (:title IS NULL OR b.title ILIKE %:title%)" +
            "AND (:author IS NULL OR b.author ILIKE %:author%)" +
            "AND (:genre IS NULL OR b.genre ILIKE %:genre%)")
    List<BookTM> findBooksByFilters(@Param("title") String title,
                                    @Param("author") String author,
                                    @Param("genre") String genre);

}

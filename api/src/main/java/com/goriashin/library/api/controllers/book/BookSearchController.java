package com.goriashin.library.api.controllers.book;


import com.goriashin.library.common.domain.book.service.BookSearchService;
import com.goriashin.library.common.domain.book.view.BookFullView;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/books")
@AllArgsConstructor
public class BookSearchController {

    private final BookSearchService searchService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Найти книги по фильтру")
    public List<BookFullView> findBooksByFilter(@Parameter(description = "Название книги", required = true)
                                                @RequestParam(name = "title", required = false) String title,
                                                @Parameter(description = "Автор книги", required = true)
                                                @RequestParam(name = "author", required = false) String author,
                                                @Parameter(description = "Жанр книги", required = true)
                                                @RequestParam(name = "genre", required = false) String genre) {
        return searchService.findBooksByFilter(title, author, genre);
    }

}

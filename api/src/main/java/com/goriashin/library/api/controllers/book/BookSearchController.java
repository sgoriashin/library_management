package com.goriashin.library.api.controllers.book;


import com.goriashin.library.common.domain.book.service.BookSearchService;
import com.goriashin.library.common.domain.book.view.BookFullView;
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
    public List<BookFullView> findBooksByFilter(@RequestParam(name = "title", required = false) String title,
                                                @RequestParam(name = "author", required = false) String author,
                                                @RequestParam(name = "genre", required = false) String genre) {
        return searchService.findBooksByFilter(title, author, genre);
    }

}

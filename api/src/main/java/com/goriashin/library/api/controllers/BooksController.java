package com.goriashin.library.api.controllers;


import com.goriashin.library.common.domain.book.view.BookRefView;
import com.goriashin.library.common.domain.book.view.BookCreateView;
import com.goriashin.library.common.domain.book.service.BookService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/books")
@AllArgsConstructor
public class BooksController {

    private final BookService bookService;

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public BookRefView addBook(@RequestBody BookCreateView body) {
        return bookService.addBook(body);
    }

    @DeleteMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBook(@PathVariable("id") Long id) {
        bookService.deleteBook(id);
    }

}

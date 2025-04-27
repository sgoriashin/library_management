package com.goriashin.library.api.controllers;


import com.goriashin.library.common.domain.book.view.BookRefView;
import com.goriashin.library.common.domain.book.view.BookCreateView;
import com.goriashin.library.common.domain.book.service.BookService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/books")
@AllArgsConstructor
public class BooksController {

    private final BookService bookService;

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public BookRefView addBook(@RequestBody BookCreateView body) {
        return bookService.addBook(body);
    }
}

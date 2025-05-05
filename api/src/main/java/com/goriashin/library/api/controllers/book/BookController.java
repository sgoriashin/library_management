package com.goriashin.library.api.controllers.book;


import com.goriashin.library.common.domain.book.view.BookRefView;
import com.goriashin.library.common.domain.book.view.BookCreateView;
import com.goriashin.library.common.domain.book.service.BookService;
import com.goriashin.library.common.domain.book.view.BookUpdateView;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/books")
@AllArgsConstructor
public class BookController {

    private final BookService bookService;

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public BookRefView addBook(@RequestBody BookCreateView body) {
        return bookService.addBook(body);
    }

    @PutMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public BookRefView updateBook(@PathVariable("id") Long id, @RequestBody BookUpdateView body) {
        return bookService.updateBook(id, body);
    }

    @DeleteMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBook(@PathVariable("id") Long id) {
        bookService.deleteBook(id);
    }

}

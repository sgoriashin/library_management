package com.goriashin.library.api.controllers.book;


import com.goriashin.library.common.domain.book.view.BookRefView;
import com.goriashin.library.common.domain.book.view.BookCreateView;
import com.goriashin.library.common.domain.book.service.BookService;
import com.goriashin.library.common.domain.book.view.BookUpdateView;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/books")
@AllArgsConstructor
@Tag(name = "Книги", description = "Операции с книгами")
public class BookController {

    private final BookService bookService;

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Добавить книгу в библиотеку")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Книга добавлена в библиотеку"),
    })
    public BookRefView addBook(@Parameter(description = "Идентификатор книги", required = true)
                               @RequestBody BookCreateView body) {
        return bookService.addBook(body);
    }

    @PutMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Изменить параметры книги")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Параметры книги изменены"),
    })
    public BookRefView updateBook(@Parameter(description = "Идентификатор книги", required = true)
                                  @PathVariable("id") Long id,
                                  @RequestBody BookUpdateView body) {
        return bookService.updateBook(id, body);
    }

    @DeleteMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Удалить книгу из библиотеки")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Книга удалена из библиотеки"),
    })
    public void deleteBook(@Parameter(description = "Идентификатор книги", required = true)
                           @PathVariable("id") Long id) {
        bookService.deleteBook(id);
    }

}

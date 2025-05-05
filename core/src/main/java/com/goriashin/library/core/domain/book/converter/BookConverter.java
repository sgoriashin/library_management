package com.goriashin.library.core.domain.book.converter;

import com.goriashin.library.common.domain.book.view.BookCreateView;
import com.goriashin.library.common.domain.book.view.BookUpdateView;
import com.goriashin.library.core.domain.book.model.BookTM;
import org.springframework.stereotype.Service;

@Service
public class BookConverter {

    public BookTM fromView(BookCreateView view) {
        BookTM bookTM = new BookTM();
        bookTM.setName(view.getName());
        bookTM.setAuthor(view.getAuthor());
        bookTM.setGenre(view.getGenre());
        bookTM.setDescription(bookTM.getDescription());
        return bookTM;
    }

    public BookTM mutateView(BookTM bookTM, BookUpdateView view) {
        if (view == null) {
            return bookTM;
        }

        if (view.getName() != null) {
            bookTM.setName(view.getName());
        }
        if (view.getAuthor() != null) {
            bookTM.setAuthor(view.getAuthor());
        }
        if (view.getGenre() != null) {
            bookTM.setGenre(view.getGenre());
        }
        if (view.getDescription() != null) {
            bookTM.setDescription(view.getDescription());
        }
        return bookTM;
    }

}

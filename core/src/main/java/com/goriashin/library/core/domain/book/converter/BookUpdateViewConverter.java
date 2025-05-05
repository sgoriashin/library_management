package com.goriashin.library.core.domain.book.converter;


import com.goriashin.library.common.domain.book.view.BookUpdateView;
import com.goriashin.library.core.domain.book.model.BookTM;
import org.springframework.stereotype.Service;


@Service
public class BookUpdateViewConverter {

    public BookTM mutate(BookTM bookTM, BookUpdateView view) {
        if (view == null) {
            return bookTM;
        }

        if (view.getTitle() != null) {
            bookTM.setTitle(view.getTitle());
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

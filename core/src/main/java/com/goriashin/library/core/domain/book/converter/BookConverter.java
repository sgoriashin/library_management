package com.goriashin.library.core.domain.book.converter;

import com.goriashin.library.common.domain.book.view.BookCreateView;
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

}

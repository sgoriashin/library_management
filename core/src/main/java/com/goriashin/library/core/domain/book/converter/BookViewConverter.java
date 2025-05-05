package com.goriashin.library.core.domain.book.converter;

import com.goriashin.library.common.domain.book.view.BookCreateView;
import com.goriashin.library.common.domain.book.view.BookFullView;
import com.goriashin.library.common.domain.book.view.BookUpdateView;
import com.goriashin.library.core.domain.book.model.BookTM;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookViewConverter {

    public BookTM fromView(BookCreateView view) {
        BookTM bookTM = new BookTM();
        bookTM.setTitle(view.getTitle());
        bookTM.setAuthor(view.getAuthor());
        bookTM.setGenre(view.getGenre());
        bookTM.setDescription(bookTM.getDescription());
        return bookTM;
    }

    public List<BookFullView> toView(List<BookTM> tmsList) {
        List<BookFullView> result = new ArrayList<>();
        if (tmsList == null || tmsList.isEmpty()) {
            return result;
        }

        tmsList.forEach(bookTM -> result.add(toView(bookTM)));
        return result;
    }

    public BookFullView toView(BookTM tm) {
        BookFullView view = new BookFullView();
        view.setId(tm.getId());
        view.setTitle(tm.getTitle());
        view.setAuthor(tm.getAuthor());
        view.setGenre(tm.getGenre());
        view.setDescription(tm.getDescription());
        return view;
    }

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

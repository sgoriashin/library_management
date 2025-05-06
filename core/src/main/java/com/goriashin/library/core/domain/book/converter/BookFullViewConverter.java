package com.goriashin.library.core.domain.book.converter;

import com.goriashin.library.common.domain.book.view.BookFullView;
import com.goriashin.library.core.domain.book.model.BookTM;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookFullViewConverter {

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

}

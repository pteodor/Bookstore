package pl.first.project.book.store.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.first.project.book.store.database.IBookDAO;
import pl.first.project.book.store.model.Book;
import pl.first.project.book.store.services.IBookService;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

@Service
public class BookService implements IBookService {

    @Autowired
    IBookDAO bookDAO;

    public List<Book> getAllBooks() {
        return this.bookDAO.getBooks();
    }

    //metoda wyszukiwania książek (po autorze i po tytule, po malych literach, duze nie maja znaczenia)
    //i wyświetlania wyniku
    @Override
    public List<Book> getFilteredBooks(String pattern) {
        return this.bookDAO.getFilteredBooks(pattern);
       /*for (Book book : books) {
           if ((book.getTitle().toLowerCase().contains(pattern.toLowerCase())) ||
                   (book.getAuthor().toLowerCase().contains(pattern.toLowerCase()))) {
               result.add(book);
           }
        }*/
        /*Iterator<Book> iterator = books.iterator();
        while (iterator.hasNext()) {
            Book book = iterator.next();
            if (!book.getTitle().toLowerCase().contains(pattern.toLowerCase()) &&
                    !book.getAuthor().toLowerCase().contains(pattern.toLowerCase())) {
                iterator.remove();
            }
        }

        return books;*/
    }
}

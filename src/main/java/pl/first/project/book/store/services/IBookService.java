package pl.first.project.book.store.services;

import pl.first.project.book.store.model.Book;

import java.util.List;

public interface IBookService {
    List<Book> getAllBooks();
    List<Book> getFilteredBooks(String pattern);
}

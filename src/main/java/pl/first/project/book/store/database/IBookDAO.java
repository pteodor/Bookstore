package pl.first.project.book.store.database;

import pl.first.project.book.store.model.Book;

import java.util.List;
import java.util.Optional;

public interface IBookDAO {
    List<Book> getBooks();
    List<Book> getFilteredBooks(String pattern);
    Optional<Book> getBookById(int id);
    void updateBook(Book book);
}

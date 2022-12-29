package pl.first.project.book.store.model.dto;

import io.swagger.annotations.ApiModel;
import pl.first.project.book.store.model.Book;

import java.util.ArrayList;
import java.util.List;

//jakby przesloniecie klas w bookstore api swagger. Do dokumentacji.
@ApiModel(value = "BookList", description = "Object to handle list of books")
public class BookResponse {

    private List<Book> books = new ArrayList<>();

    public BookResponse(List<Book> books) {
        this.books = books;
    }

    public BookResponse() {
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}

package pl.first.project.book.store.controllers.rest.api;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.first.project.book.store.database.IBookDAO;
import pl.first.project.book.store.model.Book;
import pl.first.project.book.store.model.dto.BookResponse;
import pl.first.project.book.store.services.IBookService;

import java.util.Optional;

@RestController
@RequestMapping(value = "/api/book")
public class BookRestController {

    @Autowired
    IBookService bookService;

    @Autowired
    IBookDAO bookDAO;

    @ApiOperation(value = "Find books", notes = "Return all books or books matching to pattern")
    @RequestMapping(value = "", method = RequestMethod.GET)
    public BookResponse getBooks(
            @ApiParam(value = "Pattern to find in title or author", example = "Java")
            @RequestParam(required = false)
            String pattern) {
        BookResponse bookResponse = new BookResponse();
        if(pattern == null) {
            bookResponse.setBooks(this.bookService.getAllBooks());
        } else {
            bookResponse.setBooks(this.bookService.getFilteredBooks(pattern));
        }
        return bookResponse;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Book> getBookById(@RequestParam int id) {
        Optional<Book> bookBox = this.bookDAO.getBookById(id);
        if(bookBox.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(bookBox.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Book updateBook(@RequestBody Book book, @PathVariable int id) {
        book.setId(id);
        this.bookDAO.updateBook(book);
        return book;
    }
}

package pl.first.project.book.store.database.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pl.first.project.book.store.database.IBookDAO;
import pl.first.project.book.store.model.Book;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BookDAOImpl implements IBookDAO {

    @Autowired
    Connection connection;
    @Override
    public List<Book> getBooks() {
        List<Book> books = new ArrayList<>();
        try {
            String sql = "SELECT * FROM tbook;";
            PreparedStatement ps = this.connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                books.add(new Book(rs.getInt("id"),
                        rs.getString("title"),
                        rs.getString("author"),
                        rs.getString("publishingHouse"),
                        rs.getString("description"),
                        rs.getDouble("price"),
                        rs.getString("isbn"),
                        rs.getString("availability"),
                        rs.getInt("quantity")));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return books;
    }

    //Filtorwanie ksiazek przez baze danych, a nie przez kod
    @Override
    public List<Book> getFilteredBooks(String pattern) {
        List<Book> books = new ArrayList<>();
        try {
            String sql = "SELECT * FROM tbook WHERE title like ? OR author like ?;";
            PreparedStatement ps = this.connection.prepareStatement(sql);
            ps.setString(1, "%" + pattern + "%");
            ps.setString(2, "%" + pattern + "%");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                books.add(new Book(rs.getInt("id"),
                        rs.getString("title"),
                        rs.getString("author"),
                        rs.getString("publishingHouse"),
                        rs.getString("description"),
                        rs.getDouble("price"),
                        rs.getString("isbn"),
                        rs.getString("availability"),
                        rs.getInt("quantity")));
            }

        } catch (SQLException e) {
            System.out.println("Problem z baza !!");
        }
        return books;
    }

    @Override
    public Optional<Book> getBookById(int id) {
        try {
            String sql = "SELECT * FROM tbook WHERE id = ?;";
            PreparedStatement ps = this.connection.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return Optional.of(new Book(rs.getInt("id"),
                        rs.getString("title"),
                        rs.getString("author"),
                        rs.getString("publishingHouse"),
                        rs.getString("description"),
                        rs.getDouble("price"),
                        rs.getString("isbn"),
                        rs.getString("availability"),
                        rs.getInt("quantity")));
            }
        } catch (SQLException e) {
            System.out.println("Problem z baza !!");
        }
        return Optional.empty();
    }

    @Override
    public void updateBook(Book book) {
        try {
            String sql = "UPDATE tbook SET title = ?, author = ?, publishingHouse = ?, description = ?, price = ?, isbn = ?, availability = ?, quantity = ? WHERE id = ?";
            PreparedStatement ps = this.connection.prepareStatement(sql);
            ps.setString(1, book.getTitle());
            ps.setString(2, book.getAuthor());
            ps.setString(3, book.getPublishingHouse());
            ps.setString(4, book.getDescription());
            ps.setDouble(5, book.getPrice());
            ps.setString(6, book.getIsbn());
            ps.setString(7, book.getAvailability());
            ps.setInt(8, book.getQuantity());
            ps.setInt(9, book.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Problem z baza !!");
        }
    }
}

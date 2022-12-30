package pl.first.project.book.store.database.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pl.first.project.book.store.database.IUserDAO;
import pl.first.project.book.store.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserDAOImpl implements IUserDAO {

    @Autowired
    Connection connection;

    @Override
    public List<User> getUsers() {
        List<User> users = new ArrayList<>();
        try {
            String sql = "SELECT * FROM tuser;";
            PreparedStatement ps = this.connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                users.add(new User(rs.getInt("id"),
                        rs.getString("login"),
                        rs.getString("password")));
            }
        } catch (SQLException e) {
            System.out.println("Problem z baza !!");
        }
        return users;
    }

    @Override
    public Optional<User> getUserByLogin(String login) {
        try {
            String sql = "SELECT * FROM tuser WHERE login = ?;";
            PreparedStatement ps = this.connection.prepareStatement(sql);
            ps.setString(1, login);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return Optional.of(new User(rs.getInt("id"),
                        rs.getString("login"),
                        rs.getString("password")));
            }
        } catch (SQLException e) {
            System.out.println("Problem z baza !!");
        }
        return Optional.empty();
    }

    @Override
    public boolean isLoginExist(String login) {
        return this.getUserByLogin(login).isPresent();
    }

    @Override
    public void addUser(User user) {
        try {
            String sql = "INSERT INTO tuser (login, password) VALUES (?,?)";
            PreparedStatement ps = this.connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, user.getLogin());
            ps.setString(2, user.getPassword());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
            user.setId(rs.getInt(1));
        } catch (SQLException e) {
            System.out.println("Problem z baza !!");
        }
    }
}

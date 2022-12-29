package pl.first.project.book.store.database.hibernate;

import org.apache.commons.codec.digest.DigestUtils;
import pl.first.project.book.store.database.IUserDAO;
import pl.first.project.book.store.model.User;

import java.util.List;
import java.util.Optional;

public class UserDAOStub implements IUserDAO {
    @Override
    public List<User> getUsers() {
        return null;
    }

    @Override
    public Optional<User> getUserByLogin(String login) {
        if (login.equals("admin")) {
            User user = new User();
            user.setLogin("admin");
            user.setPassword(DigestUtils.md5Hex("admin"));
            user.setId(1);

            return Optional.of(user);
        } else if(login.equals("jakisLoginKtoregoNieMaWBazie")){
            return Optional.empty();
        }
        return Optional.empty();
    }

    @Override
    public boolean isLoginExist(String login) {
        if(login.equals("user123")) {
            return false;
        } else if(login.equals("admin")) {
            return true;
        }
        return false;
    }

        @Override
    public void addUser(User user) {

    }
}

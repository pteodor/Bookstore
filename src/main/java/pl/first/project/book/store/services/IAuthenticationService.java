package pl.first.project.book.store.services;

import org.springframework.ui.Model;
import pl.first.project.book.store.model.User;

public interface IAuthenticationService {
    void authenticate(User user);
    void register(User user);
    void logout();
    void addCommonInfoToModel(Model model);
}

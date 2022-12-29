package pl.first.project.book.store.session;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;
import pl.first.project.book.store.model.Book;
import pl.first.project.book.store.model.OrderPosition;
import pl.first.project.book.store.model.User;

import java.util.HashSet;
import java.util.Set;

@Component
@SessionScope
public class SessionObject {
    private User user = null;
    private String pattern = null;

    private Set<OrderPosition> basket = new HashSet<>();

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public boolean isLogged() {
        return this.user != null;
    }

    public String getPattern() {
        return pattern;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

    public Set<OrderPosition> getBasket() {
        return basket;
    }

    public void setBasket(Set<OrderPosition> basket) {
        this.basket = basket;
    }
}

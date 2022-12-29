package pl.first.project.book.store.model.dto;

import pl.first.project.book.store.model.User;

public class UserDTO {
    private int id;
    private String login;

    public UserDTO(User user) {
        this.login = user.getLogin();
        this.id = user.getId();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
}

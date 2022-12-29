package pl.first.project.book.store.model.dto;

import pl.first.project.book.store.model.User;

import java.util.ArrayList;
import java.util.List;

public class UsersResponse {
    private List<UserDTO> users = new ArrayList<>();

    public UsersResponse(List<UserDTO> users) {
        this.users = users;
    }

    public UsersResponse() {
    }

    public List<UserDTO> getUsers() {
        return users;
    }

    public void setUsers(List<UserDTO> users) {
        this.users = users;
    }
}

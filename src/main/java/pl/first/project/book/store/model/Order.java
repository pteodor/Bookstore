package pl.first.project.book.store.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "torder")
public class Order implements Writable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne(fetch = FetchType.EAGER)
    private User user;
    @Enumerated(EnumType.STRING)
    private Status status;
    private LocalDateTime date;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<OrderPosition> orderPositions = new HashSet<>();

    public Order(int id, User user, Status status, LocalDateTime date) {
        this.id = id;
        this.user = user;
        this.status = status;
        this.date = date;
    }

    public Order() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public Set<OrderPosition> getOrderPositions() {
        return orderPositions;
    }

    public void setOrderPositions(Set<OrderPosition> orderPositions) {
        this.orderPositions = orderPositions;
    }

    public enum Status {
        NEW("Nowy"),
        PAID("Opłacony"),
        CONFIRMED("Potwierdzony"),
        SENT("Wysłany"),
        DONE("Zakończony");

        private String textValue;

        Status(String textValue) {
            this.textValue = textValue;
        }

        public String getTextValue() {
            return textValue;
        }
    }
}

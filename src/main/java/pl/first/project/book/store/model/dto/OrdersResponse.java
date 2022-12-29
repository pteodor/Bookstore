package pl.first.project.book.store.model.dto;

import pl.first.project.book.store.model.Order;

import java.util.ArrayList;
import java.util.List;

public class OrdersResponse {
    private List<OrderDTO> orders = new ArrayList<>();

    public OrdersResponse(List<OrderDTO> orders) {
        this.orders = orders;
    }

    public OrdersResponse() {
    }

    public List<OrderDTO> getOrders() {
        return orders;
    }

    public void setOrders(List<OrderDTO> orders) {
        this.orders = orders;
    }
}

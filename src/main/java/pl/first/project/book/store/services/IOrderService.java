package pl.first.project.book.store.services;

import pl.first.project.book.store.model.Order;
import pl.first.project.book.store.model.OrderPosition;

import java.util.List;
import java.util.Optional;

public interface IOrderService {
    void confirmOrder();
    List<Order> getOrderForCurrentUser();
    Optional<Order> getOrderById(int id);
    List<OrderPosition> getOrderPositionsByOrderId(int id);
    double calculateOrderSum(List<OrderPosition> orderPositions);
}

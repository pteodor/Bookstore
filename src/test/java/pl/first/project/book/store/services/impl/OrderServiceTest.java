package pl.first.project.book.store.services.impl;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import pl.first.project.book.store.model.Book;
import pl.first.project.book.store.model.OrderPosition;
import pl.first.project.book.store.services.IOrderService;
import pl.first.project.book.store.session.SessionObject;

import javax.annotation.Resource;
import java.util.Optional;

public class OrderServiceTest extends GenericServiceTest {

    @Resource
    SessionObject sessionObject;

    @Autowired
    IOrderService orderService;

    @Test
    public void toBigQuantityInPosition() {
        OrderPosition orderPosition1 = new OrderPosition();
        orderPosition1.setQuantity(1);
        orderPosition1.setBook(
                new Book(1, "abcd", "Abcd", "abcd",
                        "abcd", 23.423, "abcd", "abcd", 34545));

        OrderPosition orderPosition2 = new OrderPosition();
        orderPosition2.setQuantity(100);
        orderPosition2.setBook(
                new Book(2, "abcd", "Abcd", "abcd",
                        "abcd", 123.23, "abcd", "abcd", 10));

        this.sessionObject.getBasket().add(orderPosition1);
        this.sessionObject.getBasket().add(orderPosition2);
        int expectedBasketSize = 1;

        this.orderService.confirmOrder();

        Assert.assertEquals(expectedBasketSize, this.sessionObject.getBasket().size());
        Assert.assertTrue(this.sessionObject.getBasket()
                .stream().noneMatch(op -> op.getBook().getId() == 2));
        Mockito.verify(this.entitySever, Mockito.never()).persistEntity(Mockito.any());
        Mockito.verify(this.entitySever, Mockito.never()).updateEntity(Mockito.any());
    }

    @Test
    public void confirmCorrectBasket() {
        Mockito
                .when(this.bookDAO.getBookById(1))
                .thenReturn(Optional.of(new Book(1, "abcd", "Abcd", "abcd",
                        "abcd", 23.423, "abcd", "abcd", 10)));
        Mockito
                .when(this.bookDAO.getBookById(2))
                .thenReturn(Optional.of(new Book(2, "abcd", "Abcd", "abcd",
                        "abcd", 123.23, "abcd", "abcd", 10)));
        OrderPosition orderPosition1 = new OrderPosition();
        orderPosition1.setQuantity(1);
        orderPosition1.setBook(
                new Book(1, "abcd", "Abcd", "abcd",
                        "abcd", 23.423, "abcd", "abcd", 10));

        OrderPosition orderPosition2 = new OrderPosition();
        orderPosition2.setQuantity(1);
        orderPosition2.setBook(
                new Book(2, "abcd", "Abcd", "abcd",
                        "abcd", 123.23, "abcd", "abcd", 10));

        this.sessionObject.getBasket().add(orderPosition1);
        this.sessionObject.getBasket().add(orderPosition2);
        int positionCount = 2;
        int expectedBasketSize = 0;

        this.orderService.confirmOrder();

        Mockito.verify(this.entitySever, Mockito.times(1))
                .persistEntity(Mockito.any());
        Mockito.verify(this.entitySever, Mockito.times(positionCount))
                .updateEntity(Mockito.any());
        Assert.assertEquals(expectedBasketSize, this.sessionObject.getBasket().size());
    }
}

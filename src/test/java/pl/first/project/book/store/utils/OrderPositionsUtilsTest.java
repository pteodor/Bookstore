package pl.first.project.book.store.utils;

import org.junit.Assert;
import org.junit.Test;
import pl.first.project.book.store.model.Book;
import pl.first.project.book.store.model.OrderPosition;

import java.util.ArrayList;
import java.util.List;

public class OrderPositionsUtilsTest {

    @Test
    public void singlePositionsSumTest() {
        List<OrderPosition> orderPositions = new ArrayList<>();

        OrderPosition orderPosition1 = new OrderPosition();
        orderPosition1.setQuantity(1);
        orderPosition1.setBook(
                new Book(563464, "abcd", "Abcd", "abcd",
                        "abcd", 15.10, "abcd", "abcd", 34545));

        OrderPosition orderPosition2 = new OrderPosition();
        orderPosition2.setQuantity(1);
        orderPosition2.setBook(
                new Book(563464, "abcd", "Abcd", "abcd",
                        "abcd", 20.30, "abcd", "abcd", 34545));

        OrderPosition orderPosition3 = new OrderPosition();
        orderPosition3.setQuantity(1);
        orderPosition3.setBook(
                new Book(563464, "abcd", "Abcd", "abcd",
                        "abcd", 30.50, "abcd", "abcd", 34545));

        orderPositions.add(orderPosition1);
        orderPositions.add(orderPosition2);
        orderPositions.add(orderPosition3);

        double expectedResult = 65.90;

        double actual = OrderPositionsUtils.calculateOrderPositionsSum(orderPositions);

        Assert.assertEquals(expectedResult, actual, 0.001);
    }

    @Test
    public  void multiplePositionsSumTest() {
        List<OrderPosition> orderPositions = new ArrayList<>();

        OrderPosition orderPosition1 = new OrderPosition();
        orderPosition1.setQuantity(2);
        orderPosition1.setBook(
                new Book(563464, "abcd", "Abcd", "abcd",
                        "abcd", 30.20, "abcd", "abcd", 34545));

        OrderPosition orderPosition2 = new OrderPosition();
        orderPosition2.setQuantity(5);
        orderPosition2.setBook(
                new Book(563464, "abcd", "Abcd", "abcd",
                        "abcd", 101.50, "abcd", "abcd", 34545));

        OrderPosition orderPosition3 = new OrderPosition();
        orderPosition3.setQuantity(1);
        orderPosition3.setBook(
                new Book(563464, "abcd", "Abcd", "abcd",
                        "abcd", 30.50, "abcd", "abcd", 34545));

        orderPositions.add(orderPosition1);
        orderPositions.add(orderPosition2);
        orderPositions.add(orderPosition3);

        double expectedResult = 162.20;

        double actual = OrderPositionsUtils.calculateOrderPositionsSum(orderPositions);

        Assert.assertEquals(expectedResult, actual, 0.001);
    }

    @Test
    public void emptyListSumTest() {
        double expectedResult = 0.0;

        double result = OrderPositionsUtils.calculateOrderPositionsSum(new ArrayList<>());

        Assert.assertEquals(expectedResult, result, 0.001);
    }
}

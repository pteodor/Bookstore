package pl.first.project.book.store.services;

public interface IBasketService {
    void addBookToBasket(int id);
    double calculateBasketSum();
}

package Interfaces;

public interface IOrderManager {
    boolean addToCart(IMenuItem menuItem);
    void listAllOrderedItems();
    double getTotal();
}

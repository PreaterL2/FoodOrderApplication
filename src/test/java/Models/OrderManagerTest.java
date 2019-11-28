package Models;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import sun.security.krb5.internal.crypto.Des;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OrderManagerTest {

    private List orderedItems;
    private Dessert dessert;
    private Dessert dessert1;

    @BeforeEach
    public void setUp() {
        orderedItems = new ArrayList();
        dessert = new Dessert("Sorbet", 6.50);
        dessert1 = new Dessert("Creeps", 12.50);
    }

    @Test
    @DisplayName("return true if when we will check if desser is added")
    void shouldCheckIfAddedToCart() {
        orderedItems.add(dessert);
        assertTrue(orderedItems.contains(dessert));
    }

    @Test
    @DisplayName("return 19.00 when we sum our ordered items")
    void shouldSumTotalPriceOfOrders() {
        double total;
        orderedItems.add(dessert);
        orderedItems.add(dessert1);
        total = dessert.getPrice() + dessert1.getPrice();
        assertEquals(19.00, total);
    }

    @Test
    @DisplayName("return 0 when we are not add/order nothing")
    void shouldPrint0WhenNoAdded() {

        Assert.assertEquals(0, orderedItems.size());
    }

    @Test
    @DisplayName("return names of ordered items")
    void shouldListAllOrderedItems() {
        String allOrdered;
        orderedItems.add(dessert);
        orderedItems.add(dessert1);
        allOrdered = dessert.getName() + " " + dessert1.getName();
        assertEquals("Sorbet Creeps", allOrdered);
    }

    @Test
    @DisplayName("return 4 when we added 4 items")
    void checkIfWeCanOrderThisSameItem() {
        int allOrdered;
        orderedItems.add(dessert);
        orderedItems.add(dessert1);
        orderedItems.add(dessert);
        orderedItems.add(dessert1);
        allOrdered = orderedItems.size();
        assertEquals(4, allOrdered);


    }

}
package Models;

import Enums.MenuItemType;
import Interfaces.IMenuItem;

public class Dessert implements IMenuItem {
    private String Name;
    private Double Price;

    public Dessert(String name, double price) {
        Name = name;
        Price = price;
    }

    public String getName() {
        return Name;
    }

    public double getPrice() {
        return Price;
    }

    public MenuItemType getItemType() {
        return MenuItemType.Dessert;
    }
}

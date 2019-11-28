package Models;

import Enums.MenuItemType;
import Interfaces.IMenuItem;

public class Drink implements IMenuItem {
    private String name;
    private double price;

    public Drink(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName(){
        return name;
    }

    public double getPrice(){
        return price;
    }

    public MenuItemType getItemType() {
        return MenuItemType.Drink;
    }

}

package Models;

import Enums.MenuItemType;
import Interfaces.IMenuItem;

public class DrinkExtras implements IMenuItem {
    private String name;

    public DrinkExtras(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) { }
    public double getPrice() { return 0;}

    public MenuItemType getItemType() {
        return MenuItemType.DrinkExtras;
    }
}

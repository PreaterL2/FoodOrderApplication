package Models;

import Enums.CuisineType;
import Enums.MenuItemType;
import Interfaces.IMenuItem;

public class Dish implements IMenuItem {
    private String name;
    private double price;
    private CuisineType cuisineType;

    public Dish(String name, Double price, CuisineType cuisineType) {
        this.name = name;
        this.price = price;
        this.cuisineType = cuisineType;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public MenuItemType getItemType() {
        return MenuItemType.MainCourse;
    }

    public CuisineType getCuisineType() {
        return cuisineType;
    }
}

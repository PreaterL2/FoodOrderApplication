package Interfaces;

import Enums.MenuItemType;

public interface IMenuItem {
    String getName();
    double getPrice();
    MenuItemType getItemType();
}

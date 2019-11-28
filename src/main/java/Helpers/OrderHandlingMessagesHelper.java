package Helpers;

import Enums.CuisineType;
import Enums.MenuItemType;
import Interfaces.IIOManager;
import Interfaces.IMenuItem;
import Models.Dish;
import com.sun.istack.internal.Nullable;

import java.util.ArrayList;

public class OrderHandlingMessagesHelper {
    private IIOManager ioManager;
    public String greeting = "Hi, what would you like to order? ";

    public OrderHandlingMessagesHelper(IIOManager ioManager) {
        this.ioManager = ioManager;
    }

    public String menuPresentation(ArrayList<IMenuItem> menuItems){
        int counter = 1;
        String previousType = "";

        for(IMenuItem item : menuItems){
            if(item.getItemType().equals(MenuItemType.DrinkExtras) || item.getItemType().toString().equals(previousType))
                continue;

            ioManager.printMessage(counter + " - " + item.getItemType().toString());
            previousType = item.getItemType().toString();
            counter ++;
        }

        ioManager.printMessage(counter++ + " - Get Order Summary");
        ioManager.printMessage(counter++ + " - Get Order Total");
        ioManager.printMessage(counter++ + " - Quit");

        return ioManager.readInput();
    }

    public String cuisinesPresentation(ArrayList<IMenuItem> menuItems){
        int counter = 1;
        String previousCuisine = "";

        ioManager.printMessage("Which cuisine are you interested in? ");

        for(IMenuItem item : menuItems) {
            if (item instanceof Dish) {
                Dish dishItem = (Dish) item;
                String menuItemPresentation = counter + " - " + dishItem.getCuisineType().toString();

                if (!previousCuisine.equals(dishItem.getCuisineType().toString())) {
                    ioManager.printMessage(menuItemPresentation);
                    counter++;
                }

                previousCuisine = dishItem.getCuisineType().toString();
            }
        }

        return ioManager.readInput();
    }

    public String menuItemPresentation(ArrayList<IMenuItem> menuItems, MenuItemType menuItemType, @Nullable CuisineType cuisineType) {
        for(IMenuItem item : menuItems){
            if(item.getItemType() == menuItemType){
                if(cuisineType != null && ((Dish)item).getCuisineType() != cuisineType)
                    continue;

                ioManager.printMessage(menuItems.indexOf(item) + " - Name: " + item.getName() + " Price: " + item.getPrice());
            }
        }

        return ioManager.readInput();
    }
}

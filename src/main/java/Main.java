import Enums.CuisineType;
import Enums.TransactionStates;
import Helpers.OrderHandlingMessagesHelper;
import Interfaces.IIOManager;
import Interfaces.IMenuItem;
import Interfaces.IOrderManager;
import Models.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ArrayList<IMenuItem> menuItems = new ArrayList<IMenuItem>();
        populateMenu(menuItems);

        IIOManager ioManager = new IOManager(scanner);
        OrderHandlingMessagesHelper orderHandlingMessagesHelper = new OrderHandlingMessagesHelper(ioManager);
        IOrderManager orderManager = new OrderManager(ioManager);


        TransactionRunner tr = new TransactionRunner(TransactionStates.MenuItemTypes, ioManager, orderHandlingMessagesHelper,
                orderManager, menuItems);
        tr.StartTransaction();
    }

    public static void populateMenu(ArrayList<IMenuItem> menuItems){  //our menu where we can add our items
        menuItems.add(new Dish("Pizza", 15.50, CuisineType.Italian));
        menuItems.add(new Dish("Spaghetti", 20.00, CuisineType.Italian));
        menuItems.add(new Dish("Calzone", 25.50, CuisineType.Italian));

        menuItems.add(new Dish("Pierogi", 13.00, CuisineType.Polish));
        menuItems.add(new Dish("Bigos", 30.00, CuisineType.Polish));
        menuItems.add(new Dish("Golabki", 25.00, CuisineType.Polish));

        menuItems.add(new Dish("Fajita", 25.00, CuisineType.Mexican));
        menuItems.add(new Dish("Tacos", 15.00, CuisineType.Mexican));
        menuItems.add(new Dish("Burito", 35.00, CuisineType.Mexican));

        menuItems.add(new Dessert("Cheesecake", 6.00));
        menuItems.add(new Dessert("Applecake", 6.00));
        menuItems.add(new Dessert("Icecreams", 7.00));
        menuItems.add(new Dessert("Muffin", 4.00));

        menuItems.add(new Drink("Cola", 5.00));
        menuItems.add(new Drink("Tea", 7.00));
        menuItems.add(new Drink("Coffee", 10.00));
        menuItems.add(new Drink("Water", 4.00));

        menuItems.add(new DrinkExtras("Lemon"));
        menuItems.add(new DrinkExtras("Ice Cube"));
        menuItems.add(new DrinkExtras("Milk"));

    }
}

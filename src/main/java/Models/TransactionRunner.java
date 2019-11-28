package Models;

import Enums.CuisineType;
import Enums.MenuItemType;
import Enums.TransactionStates;
import Helpers.OrderHandlingMessagesHelper;
import Interfaces.IIOManager;
import Interfaces.IMenuItem;
import Interfaces.IOrderManager;

import java.util.ArrayList;

public class TransactionRunner {
    private TransactionStates currentState;
    private boolean exit = false;

    private IIOManager ioManager;
    private OrderHandlingMessagesHelper orderHandlingMessagesHelper;
    private IOrderManager orderManager;
    private ArrayList<IMenuItem> menuItems;


    public TransactionRunner(TransactionStates currentState, IIOManager ioManager,
                             OrderHandlingMessagesHelper orderHandlingMessagesHelper, IOrderManager orderManager,
                             ArrayList<IMenuItem> menuItems) {
        this.currentState = currentState;
        this.ioManager = ioManager;
        this.orderHandlingMessagesHelper = orderHandlingMessagesHelper;
        this.orderManager = orderManager;
        this.menuItems = menuItems;
    }

    public void StartTransaction(){ //method it is a option in our application where we can choose what we want for example drinks and than we want to check what we ordered and than how much we have to pay
        int chosenOption = 0;

        ioManager.printMessage(orderHandlingMessagesHelper.greeting);


        while(!exit){

            switch(currentState){
                case MenuItemTypes:
                    chosenOption = Integer.parseInt(orderHandlingMessagesHelper.menuPresentation(menuItems));
                    MenuItemType chosenType = MenuItemType.values()[chosenOption - 1];
                    currentState = getNextTransactionState(chosenType);
                    break;

                case MenuItemTypesFood:
                    chosenOption = Integer.parseInt(orderHandlingMessagesHelper.cuisinesPresentation(menuItems));
                    CuisineType cuisineType = CuisineType.values()[chosenOption - 1];
                    chosenOption = Integer.parseInt(
                            orderHandlingMessagesHelper.menuItemPresentation(menuItems, MenuItemType.MainCourse, cuisineType));
                    orderManager.addToCart(menuItems.get(chosenOption));
                    currentState = TransactionStates.MenuItemTypes;
                    break;

                case MenuItemTypesDessert:
                    chosenOption = Integer.parseInt(
                            orderHandlingMessagesHelper.menuItemPresentation(menuItems, MenuItemType.Dessert,null));
                    orderManager.addToCart(menuItems.get(chosenOption));
                    currentState = TransactionStates.MenuItemTypes;
                    break;

                case MenuItemTypesDrink:
                    chosenOption = Integer.parseInt(
                            orderHandlingMessagesHelper.menuItemPresentation(menuItems, MenuItemType.Drink, null));
                    orderManager.addToCart(menuItems.get(chosenOption));
                    ioManager.printMessage("Would you like some extras with your drink? ");
                    chosenOption = Integer.parseInt(
                            orderHandlingMessagesHelper.menuItemPresentation(menuItems, MenuItemType.DrinkExtras, null));
                    orderManager.addToCart(menuItems.get(chosenOption));
                    currentState = TransactionStates.MenuItemTypes;
                    break;

                case OrderSummary:
                    orderManager.listAllOrderedItems();
                    currentState = TransactionStates.MenuItemTypes;
                    break;

                case OrderTotal:
                    orderManager.getTotal();
                    currentState = TransactionStates.MenuItemTypes;
                    break;

                case Quit:
                    exit = true;
                    break;
            }
        }
    }

    public TransactionStates getNextTransactionState(MenuItemType type){
        if(type == MenuItemType.MainCourse)
            return TransactionStates.MenuItemTypesFood;
        if(type == MenuItemType.Dessert)
            return TransactionStates.MenuItemTypesDessert;
        if(type == MenuItemType.Drink)
            return TransactionStates.MenuItemTypesDrink;
        if(type == MenuItemType.GetSummary)
            return TransactionStates.OrderSummary;
        if(type == MenuItemType.GetTotal)
            return TransactionStates.OrderTotal;
        if(type == MenuItemType.Exit)
            return TransactionStates.Quit;
        return null;
    }
}

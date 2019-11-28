package Models;

import Interfaces.IIOManager;
import Interfaces.IMenuItem;
import Interfaces.IOrderManager;

import java.util.ArrayList;

public class OrderManager implements IOrderManager {

    private IIOManager ioManager;
    private ArrayList<IMenuItem> orderedItems;

    public OrderManager(IIOManager ioManager) {
        this.ioManager = ioManager;

        orderedItems = new ArrayList<IMenuItem>();
    }

    public boolean addToCart(IMenuItem menuItem) { //method addToCard is printing message when you order something
        if(orderedItems.add(menuItem)); {
            ioManager.printMessage(menuItem.getName() + " has been added to the cart!");
        }
        return true;
    }

    public void listAllOrderedItems() {  //method listAllOrderedItems is printing name of every ordered item
        if(orderedItems.size() > 0){
            ioManager.printMessage(" Your ordered items are: ");
            for(IMenuItem item : orderedItems){
                ioManager.printMessage(item.getName());
            }
        }
        else {
            ioManager.printMessage(" You have not ordered anything!");
        }
    }

    public double getTotal() { //method getTotal it is a sum prices of the every order
        double total = 0;
        for(IMenuItem item : orderedItems){
            total += item.getPrice();
        }
        System.out.println("You have to pay for everything: ");
        System.out.println(total);

        return total;
    }

}

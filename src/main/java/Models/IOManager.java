package Models;

import Interfaces.IIOManager;
import java.util.Scanner;

public class IOManager implements IIOManager {

    private Scanner scanner;

    public IOManager(Scanner scanner) {
        this.scanner = scanner;
    }

    public void printMessage(String message) { //method printMessage is printing message instead of System.out.Println();
        System.out.println(message);
    }

    public String readInput() {
        return scanner.nextLine();
    }
}

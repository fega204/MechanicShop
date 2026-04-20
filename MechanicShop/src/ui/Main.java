package ui;

import java.util.Scanner;
import database.DatabaseManager;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int choice = 0;

        System.out.println("Program Starting...");

        DatabaseManager.getInstance();

        while (choice != 3) {
            System.out.println("\n1 Vehicle Management");
            System.out.println("2 Inventory / Invoice Management");
            System.out.println("3 Exit");
            System.out.print("Choice: ");

            try {
                choice = Integer.parseInt(input.nextLine());

                if (choice == 1) {
                    VehicleMenu vehicleMenu = new VehicleMenu();
                    vehicleMenu.start();
                }

                else if (choice == 2) {
                    InventoryMenu inventoryMenu = new InventoryMenu();
                    inventoryMenu.start();
                }

                else if (choice == 3) {
                    System.out.println("Goodbye");
                }

                else {
                    System.out.println("Wrong choice");
                }
            }

            catch (NumberFormatException exception) {
                System.out.println("Please enter a valid number.");
            }
        }

        DatabaseManager.getInstance().closeConnection();
        input.close();

        System.out.println("Program Ended.");
    }
}

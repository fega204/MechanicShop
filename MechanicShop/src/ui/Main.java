package ui;

import database.DatabaseManager;

public class Main {

    public static void main(String[] args) {

        System.out.println("Program Starting...");

        DatabaseManager.getInstance();

        VehicleMenu menu = new VehicleMenu();
        menu.start();

        DatabaseManager.getInstance().closeConnection();

        System.out.println("Program Ended.");
    }
}

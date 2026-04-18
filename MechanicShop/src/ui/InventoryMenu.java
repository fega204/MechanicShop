package ui;

import database.InvoiceDAO;
import database.PartDAO;
import exceptions.InsufficientPartsException;
import exceptions.InvalidInputException;
import java.util.ArrayList;
import java.util.Scanner;
import models.Inventory;
import models.Invoice;
import models.Part;

public class InventoryMenu {
   
    Scanner input = new Scanner(System.in);
    PartDAO partDataAccessObject = new PartDAO();
    InvoiceDAO invoiceDataAccessObject = new InvoiceDAO();

    public void start() {
        int choice = 0;

        while (choice != 6) {
            
            System.out.println("\n1 Add Part");
            System.out.println("2 Show Parts");
            System.out.println("3 Update Part Quantity");
            System.out.println("4 Delete Part");
            System.out.println("5 Generate Invoice");
            System.out.println("6 Return to Main Menu");
            System.out.print("Choice: ");

            try {
                
                choice = Integer.parseInt(input.nextLine());

                if (choice == 1) {addPart();}
                else if (choice == 2) {showInventory();}
                else if (choice == 3) {updatePartQuantity();}
                else if (choice == 4) {deletePart();}
                else if (choice == 5) {generateInvoice();}
                else if (choice == 6) {System.out.println("Returning to main menu.");}
                else {System.out.println("Wrong choice");}
            }

            catch (NumberFormatException exception) {
                System.out.println("Please enter a valid number.");
            }

            catch (InvalidInputException exception) {
                System.out.println(exception.getMessage());
            }

            catch (InsufficientPartsException exception) {
                System.out.println(exception.getMessage());
            }
        }
    }

    private void addPart() throws InvalidInputException {
        
        System.out.print("Part ID: ");
        int partId = Integer.parseInt(input.nextLine());
        checkPositive(partId, "Part ID");

        System.out.print("Part name: ");
        String partName = input.nextLine();
        checkText(partName, "Part name");

        System.out.print("Quantity: ");
        int quantity = Integer.parseInt(input.nextLine());
        checkNotNegative(quantity, "Quantity");

        System.out.print("Unit price: ");
        double unitPrice = Double.parseDouble(input.nextLine());
        checkNotNegative(unitPrice, "Unit price");

        Part part = new Part(partId, partName, quantity, unitPrice);
        partDataAccessObject.addPart(part);
    }

    private void showInventory() {
        ArrayList<Part> parts = partDataAccessObject.getAllParts();
        Inventory inventory = new Inventory(parts);

        if (inventory.getParts().size() == 0) {
            System.out.println("No parts found.");
        }

        else {
            for (Part part : inventory.getParts()) {
                System.out.println(part);
            }

            System.out.println("Total quantity: " + inventory.getTotalQuantity());
        }
    }

    private void updatePartQuantity() throws InvalidInputException {
        
        System.out.print("Part ID: ");
        int partId = Integer.parseInt(input.nextLine());
        checkPositive(partId, "Part ID");

        System.out.print("New quantity: ");
        int quantity = Integer.parseInt(input.nextLine());
        checkNotNegative(quantity, "Quantity");

        partDataAccessObject.updatePartQuantity(partId, quantity);
    }

    private void deletePart() throws InvalidInputException {
        
        System.out.print("Part ID: ");
        int partId = Integer.parseInt(input.nextLine());
        checkPositive(partId, "Part ID");

        partDataAccessObject.deletePart(partId);
    }

    private void generateInvoice() throws InvalidInputException, InsufficientPartsException {
        
        System.out.print("Invoice ID: ");
        int invoiceId = Integer.parseInt(input.nextLine());
        checkPositive(invoiceId, "Invoice ID");

        System.out.print("Part ID: ");
        int partId = Integer.parseInt(input.nextLine());
        checkPositive(partId, "Part ID");

        System.out.print("Quantity used: ");
        int quantityUsed = Integer.parseInt(input.nextLine());
        checkPositive(quantityUsed, "Quantity used");

        System.out.print("Service description: ");
        String serviceDescription = input.nextLine();
        checkText(serviceDescription, "Service description");

        System.out.print("Labor cost: ");
        double laborCost = Double.parseDouble(input.nextLine());
        checkNotNegative(laborCost, "Labor cost");

        Part part = partDataAccessObject.getPartById(partId);

        if (part == null) {
            throw new InvalidInputException("Part not found.");
        }

        if (quantityUsed > part.getQuantity()) {
            throw new InsufficientPartsException("Not enough parts in stock.");
        }

        double totalCost = (quantityUsed * part.getUnitPrice()) + laborCost;
        Invoice invoice = new Invoice(invoiceId, partId, quantityUsed, serviceDescription, laborCost, totalCost);

        boolean invoiceAdded = invoiceDataAccessObject.addInvoice(invoice);

        if (invoiceAdded) {
            int newQuantity = part.getQuantity() - quantityUsed;
            partDataAccessObject.updatePartQuantity(partId, newQuantity);
            System.out.println(invoice);
        }
    }

    private void checkPositive(int number, String fieldName) throws InvalidInputException {
        
        if (number <= 0) {
            throw new InvalidInputException(fieldName + " must be greater than zero.");
        }
    }

    private void checkNotNegative(int number, String fieldName) throws InvalidInputException {
        
        if (number < 0) {
            throw new InvalidInputException(fieldName + " cannot be negative.");
        }
    }

    private void checkNotNegative(double number, String fieldName) throws InvalidInputException {
        
        if (number < 0) {
            throw new InvalidInputException(fieldName + " cannot be negative.");
        }
    }

    private void checkText(String text, String fieldName) throws InvalidInputException {
        
        if (text.trim().length() == 0) {
            throw new InvalidInputException(fieldName + " cannot be empty.");
        }
    }
}

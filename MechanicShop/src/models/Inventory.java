package models;
import java.util.ArrayList;

public class Inventory {
    
    private ArrayList<Part> parts;

    // creates fresh inventory
    public Inventory() {
        parts = new ArrayList<Part>();
    }

    // creates inventory from existing part list
    public Inventory(ArrayList<Part> parts) {
        this.parts = parts;
    }

    public void addPart(Part part) {
        parts.add(part);
    }

    public ArrayList<Part> getParts() {
        return parts;
    }

    public void setParts(ArrayList<Part> parts) {
        this.parts = parts;
    }

    public int getTotalQuantity() {
        int total = 0;

        for (Part part : parts) {
            total += part.getQuantity();
        }

        return total;
    }

    @Override
    public String toString() {
        return "Inventory has " + parts.size() + " parts.";
    }
}

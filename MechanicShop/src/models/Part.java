package models;

public class Part {
    private int partId;
    private String partName;
    private int quantity;
    private double unitPrice;

    public Part(int partId, String partName, int quantity, double unitPrice) {
        this.partId = partId;
        this.partName = partName;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
    }

    public int getPartId() {
        return partId;
    }

    public void setPartId(int partId) {
        this.partId = partId;
    }

    public String getPartName() {
        return partName;
    }

    public void setPartName(String partName) {
        this.partName = partName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    @Override
    public String toString() {
        return partId + " " + partName + " " + quantity + " $" + unitPrice;
    }
}

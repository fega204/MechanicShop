package models;

public class Invoice {
    private int invoiceId;
    private int partId;
    private int quantityUsed;
    private String serviceDescription;
    private double laborCost;
    private double totalCost;

    public Invoice(int invoiceId, int partId, int quantityUsed, String serviceDescription, double laborCost, double totalCost) {
        this.invoiceId = invoiceId;
        this.partId = partId;
        this.quantityUsed = quantityUsed;
        this.serviceDescription = serviceDescription;
        this.laborCost = laborCost;
        this.totalCost = totalCost;
    }

    public int getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(int invoiceId) {
        this.invoiceId = invoiceId;
    }

    public int getPartId() {
        return partId;
    }

    public void setPartId(int partId) {
        this.partId = partId;
    }

    public int getQuantityUsed() {
        return quantityUsed;
    }

    public void setQuantityUsed(int quantityUsed) {
        this.quantityUsed = quantityUsed;
    }

    public String getServiceDescription() {
        return serviceDescription;
    }

    public void setServiceDescription(String serviceDescription) {
        this.serviceDescription = serviceDescription;
    }

    public double getLaborCost() {
        return laborCost;
    }

    public void setLaborCost(double laborCost) {
        this.laborCost = laborCost;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    @Override
    public String toString() {
        return invoiceId + " " + partId + " " + quantityUsed + " "
            + serviceDescription + " $" + laborCost + " $" + totalCost;
    }
}

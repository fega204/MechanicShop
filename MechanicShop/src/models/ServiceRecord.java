package models;

public class ServiceRecord {

    private int recordId;
    private int vehicleId;
    private String serviceDate;
    private String description;
    private double cost;
    private String mechanicName;
    private String status;

    public ServiceRecord() {
    }

    public ServiceRecord(int vehicleId, String serviceDate, String description,
                         double cost, String mechanicName, String status) {
        this.vehicleId = vehicleId;
        this.serviceDate = serviceDate;
        this.description = description;
        this.cost = cost;
        this.mechanicName = mechanicName;
        this.status = status;
    }

    public ServiceRecord(int recordId, int vehicleId, String serviceDate,
                         String description, double cost,
                         String mechanicName, String status) {
        this.recordId = recordId;
        this.vehicleId = vehicleId;
        this.serviceDate = serviceDate;
        this.description = description;
        this.cost = cost;
        this.mechanicName = mechanicName;
        this.status = status;
    }

    @Override
    public String toString() {
        return "Record ID: " + recordId +
               " | Vehicle ID: " + vehicleId +
               " | Date: " + serviceDate +
               " | Service: " + description +
               " | Cost: $" + cost +
               " | Mechanic: " + mechanicName +
               " | Status: " + status;
    }

    public int getRecordId() {
        return recordId;
    }

    public void setRecordId(int recordId) {
        this.recordId = recordId;
    }

    public int getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(int vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getServiceDate() {
        return serviceDate;
    }

    public void setServiceDate(String serviceDate) {
        this.serviceDate = serviceDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getMechanicName() {
        return mechanicName;
    }

    public void setMechanicName(String mechanicName) {
        this.mechanicName = mechanicName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
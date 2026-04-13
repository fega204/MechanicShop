// ============================================================
// File:        ServiceRecord.java
// Author:      [Your Name]
// Date:        2025
// Program:     Mechanic Shop Management System
// Description: Represents a service record linked to a vehicle.
//              Stores details of a specific service event
//              including date, description, cost, and status.
//              Each record is tied to a vehicle by vehicleId.
// Inputs:      Service record ID, vehicle ID, service date,
//              description, cost, mechanic name, status
// Processing:  Stores service event data; provides formatted
//              display; supports CRUD via ServiceRecordDAO
// Outputs:     Formatted service record string
// ============================================================

package models;

/**
 * Represents a single service event performed on a vehicle.
 * Linked to a Vehicle by vehicleId (foreign key relationship).
 */
public class ServiceRecord {

    // ---- Attributes ----
    private int    recordId;
    private int    vehicleId;       // FK -> vehicles table
    private String serviceDate;     // format: YYYY-MM-DD
    private String description;     // work performed
    private double cost;
    private String mechanicName;
    private String status;          // "Scheduled", "In Progress", "Completed"

    // ---- Constructors ----

    /**
     * Default constructor.
     */
    public ServiceRecord() {}

    /**
     * Constructor for creating a new service record (no ID yet).
     * @param vehicleId    ID of the vehicle being serviced
     * @param serviceDate  date of the service
     * @param description  description of the work
     * @param cost         total cost of the service
     * @param mechanicName name of the assigned mechanic
     * @param status       current status of the service
     */
    public ServiceRecord(int vehicleId, String serviceDate, String description,
                         double cost, String mechanicName, String status) {
        this.vehicleId    = vehicleId;
        this.serviceDate  = serviceDate;
        this.description  = description;
        this.cost         = cost;
        this.mechanicName = mechanicName;
        this.status       = status;
    }

    /**
     * Full constructor including recordId (used when loading from DB).
     */
    public ServiceRecord(int recordId, int vehicleId, String serviceDate,
                         String description, double cost,
                         String mechanicName, String status) {
        this.recordId     = recordId;
        this.vehicleId    = vehicleId;
        this.serviceDate  = serviceDate;
        this.description  = description;
        this.cost         = cost;
        this.mechanicName = mechanicName;
        this.status       = status;
    }

    // ---- Display ----

    /**
     * Returns a formatted summary of this service record.
     * @return multi-line service record string
     */
    @Override
    public String toString() {
        return String.format(
            "Record #%-4d | Vehicle ID: %-4d | Date: %-12s | %-30s | $%7.2f | Mechanic: %-20s | %s",
            recordId, vehicleId, serviceDate, description, cost, mechanicName, status
        );
    }

    // ---- Getters and Setters ----

    public int    getRecordId()              { return recordId; }
    public void   setRecordId(int recordId)  { this.recordId = recordId; }

    public int    getVehicleId()               { return vehicleId; }
    public void   setVehicleId(int vehicleId)  { this.vehicleId = vehicleId; }

    public String getServiceDate()                     { return serviceDate; }
    public void   setServiceDate(String serviceDate)   { this.serviceDate = serviceDate; }

    public String getDescription()                       { return description; }
    public void   setDescription(String description)     { this.description = description; }

    public double getCost()            { return cost; }
    public void   setCost(double cost) { this.cost = cost; }

    public String getMechanicName()                        { return mechanicName; }
    public void   setMechanicName(String mechanicName)     { this.mechanicName = mechanicName; }

    public String getStatus()                  { return status; }
    public void   setStatus(String status)     { this.status = status; }
}
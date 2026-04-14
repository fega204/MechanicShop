package com.mechanicshop.model;

public class Appointment {

    private int id;
    private int customerId;
    private int mechanicId;
    private int vehicleId;
    private String appointmentDate;
    private String appointmentTime;
    private String status;
    private String notes;

    public Appointment(int id, int customerId, int mechanicId, int vehicleId, String appointmentDate, String appointmentTime, String status, String notes) {
        this.id = id;
        this.customerId = customerId;
        this.mechanicId = mechanicId;
        this.vehicleId = vehicleId;
        this.appointmentDate = appointmentDate;
        this.appointmentTime = appointmentTime;
        this.status = status;
        this.notes = notes;
    }

    public Appointment(int customerId, int mechanicId, int vehicleId, String appointmentDate, String appointmentTime, String status, String notes) {
        this.customerId = customerId;
        this.mechanicId = mechanicId;
        this.vehicleId = vehicleId;
        this.appointmentDate = appointmentDate;
        this.appointmentTime = appointmentTime;
        this.status = status;
        this.notes = notes;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getCustomerId() { return customerId; }
    public void setCustomerId(int customerId) { this.customerId = customerId; }

    public int getMechanicId() { return mechanicId; }
    public void setMechanicId(int mechanicId) { this.mechanicId = mechanicId; }

    public int getVehicleId() { return vehicleId; }
    public void setVehicleId(int vehicleId) { this.vehicleId = vehicleId; }

    public String getAppointmentDate() { return appointmentDate; }
    public void setAppointmentDate(String appointmentDate) { this.appointmentDate = appointmentDate; }

    public String getAppointmentTime() { return appointmentTime; }
    public void setAppointmentTime(String appointmentTime) { this.appointmentTime = appointmentTime; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getNotes() { return notes; }
    public void setNotes(String notes) { this.notes = notes; }

    @Override
    public String toString() {
        return "Appointment #" + id +
               " | Customer ID: " + customerId +
               " | Mechanic ID: " + mechanicId +
               " | Vehicle ID: " + vehicleId +
               " | Date: " + appointmentDate +
               " | Time: " + appointmentTime +
               " | Status: " + status +
               " | Notes: " + notes;
    }
}

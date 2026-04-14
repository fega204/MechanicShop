package mechanic.model;

public class Appointment {
    private int id;
    private int customerId;
    private int mechanicId;
    private String date;
    private String time;
    private String description;
    private String status; // BOOKED, CANCELLED, COMPLETED

    public Appointment() {}

    public Appointment(int id, int customerId, int mechanicId, String date, String time,
                       String description, String status) {
        this.id = id;
        this.customerId = customerId;
        this.mechanicId = mechanicId;
        this.date = date;
        this.time = time;
        this.description = description;
        this.status = status;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getCustomerId() { return customerId; }
    public void setCustomerId(int customerId) { this.customerId = customerId; }

    public int getMechanicId() { return mechanicId; }
    public void setMechanicId(int mechanicId) { this.mechanicId = mechanicId; }

    public String getDate() { return date; }
    public void setDate(String date) { this.date = date; }

    public String getTime() { return time; }
    public void setTime(String time) { this.time = time; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    @Override
    public String toString() {
        return String.format("[#%d] Date: %s at %s | Customer ID: %d | Mechanic ID: %d | Status: %s | Notes: %s",
                id, date, time, customerId, mechanicId, status, description);
    }
}

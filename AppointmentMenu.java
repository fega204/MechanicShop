package mechanic.model;

public class Customer extends Person implements Schedulable {
    private String address;

    public Customer() {}

    public Customer(int id, String firstName, String lastName, String phone, String email, String address) {
        super(id, firstName, lastName, phone, email);
        this.address = address;
    }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    @Override
    public String getRole() { return "Customer"; }

    @Override
    public String book(String date, String time) {
        return "Appointment booked for " + getFullName() + " on " + date + " at " + time;
    }

    @Override
    public String cancel(int appointmentId) {
        return "Appointment #" + appointmentId + " cancelled for " + getFullName();
    }

    @Override
    public String reschedule(int appointmentId, String newDate, String newTime) {
        return "Appointment #" + appointmentId + " rescheduled to " + newDate + " at " + newTime + " for " + getFullName();
    }

    @Override
    public String toString() {
        return super.toString() + " | Address: " + address;
    }
}

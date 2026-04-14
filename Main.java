package mechanic.model;

public class Mechanic extends Person {
    private String specialty;
    private double hourlyRate;

    public Mechanic() {}

    public Mechanic(int id, String firstName, String lastName, String phone, String email,
                    String specialty, double hourlyRate) {
        super(id, firstName, lastName, phone, email);
        this.specialty = specialty;
        this.hourlyRate = hourlyRate;
    }

    public String getSpecialty() { return specialty; }
    public void setSpecialty(String specialty) { this.specialty = specialty; }

    public double getHourlyRate() { return hourlyRate; }
    public void setHourlyRate(double hourlyRate) { this.hourlyRate = hourlyRate; }

    @Override
    public String getRole() { return "Mechanic"; }

    @Override
    public String toString() {
        return super.toString() + String.format(" | Specialty: %s | Rate: $%.2f/hr", specialty, hourlyRate);
    }
}

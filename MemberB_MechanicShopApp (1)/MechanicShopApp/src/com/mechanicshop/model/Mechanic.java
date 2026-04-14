package com.mechanicshop.model;

public class Mechanic extends Person implements Schedulable {

    private String specialization;
    private double hourlyRate;

    public Mechanic(int id, String firstName, String lastName, String email, String phone, String specialization, double hourlyRate) {
        super(id, firstName, lastName, email, phone);
        this.specialization = specialization;
        this.hourlyRate = hourlyRate;
    }

    public Mechanic(String firstName, String lastName, String email, String phone, String specialization, double hourlyRate) {
        super(firstName, lastName, email, phone);
        this.specialization = specialization;
        this.hourlyRate = hourlyRate;
    }

    public String getSpecialization() { return specialization; }
    public void setSpecialization(String specialization) { this.specialization = specialization; }

    public double getHourlyRate() { return hourlyRate; }
    public void setHourlyRate(double hourlyRate) { this.hourlyRate = hourlyRate; }

    @Override
    public boolean book(int appointmentId) {
        System.out.println("Mechanic " + getFullName() + " assigned to appointment #" + appointmentId);
        return true;
    }

    @Override
    public boolean cancel(int appointmentId) {
        System.out.println("Mechanic " + getFullName() + " unassigned from appointment #" + appointmentId);
        return true;
    }

    @Override
    public boolean reschedule(int appointmentId, String newDate, String newTime) {
        System.out.println("Mechanic " + getFullName() + " rescheduled appointment #" + appointmentId + " to " + newDate + " at " + newTime);
        return true;
    }

    @Override
    public String toString() {
        return super.toString() + " | Specialization: " + specialization + " | Hourly Rate: $" + String.format("%.2f", hourlyRate);
    }
}

package com.mechanicshop.model;

public class Customer extends Person implements Schedulable {

    private String address;
    private String membershipType;

    public Customer(int id, String firstName, String lastName, String email, String phone, String address, String membershipType) {
        super(id, firstName, lastName, email, phone);
        this.address = address;
        this.membershipType = membershipType;
    }

    public Customer(String firstName, String lastName, String email, String phone, String address, String membershipType) {
        super(firstName, lastName, email, phone);
        this.address = address;
        this.membershipType = membershipType;
    }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public String getMembershipType() { return membershipType; }
    public void setMembershipType(String membershipType) { this.membershipType = membershipType; }

    @Override
    public boolean book(int appointmentId) {
        System.out.println("Customer " + getFullName() + " booked appointment #" + appointmentId);
        return true;
    }

    @Override
    public boolean cancel(int appointmentId) {
        System.out.println("Customer " + getFullName() + " cancelled appointment #" + appointmentId);
        return true;
    }

    @Override
    public boolean reschedule(int appointmentId, String newDate, String newTime) {
        System.out.println("Customer " + getFullName() + " rescheduled appointment #" + appointmentId + " to " + newDate + " at " + newTime);
        return true;
    }

    @Override
    public String toString() {
        return super.toString() + " | Address: " + address + " | Membership: " + membershipType;
    }
}

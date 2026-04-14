package com.mechanicshop.model;

public interface Schedulable {

    boolean book(int appointmentId);
    boolean cancel(int appointmentId);
    boolean reschedule(int appointmentId, String newDate, String newTime);
}

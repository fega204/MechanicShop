package mechanic.model;

public interface Schedulable {
    String book(String date, String time);
    String cancel(int appointmentId);
    String reschedule(int appointmentId, String newDate, String newTime);
}

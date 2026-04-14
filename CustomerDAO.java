package mechanic.exception;

public class AppointmentConflictException extends Exception {
    public AppointmentConflictException(int mechanicId, String date, String time) {
        super("Mechanic ID " + mechanicId + " already has an appointment on " + date + " at " + time + ".");
    }

    public AppointmentConflictException(String message) {
        super(message);
    }
}

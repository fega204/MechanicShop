package exceptions;

/*
 * This exception happens when trying to add a vehicle
 * that already exists in the system.
 * Example: same license plate entered twice.
 */
public class DuplicateVehicleException extends Exception {

    private String licensePlate;

    // constructor with default message
    public DuplicateVehicleException(String licensePlate) {
        super("Vehicle with plate " + licensePlate + " already exists.");
        this.licensePlate = licensePlate;
    }

    // constructor with custom message
    public DuplicateVehicleException(String licensePlate, String message) {
        super(message);
        this.licensePlate = licensePlate;
    }

    // returns duplicate plate
    public String getLicensePlate() {
        return licensePlate;
    }
}
package exceptions;

/*
 * This exception happens when a vehicle
 * cannot be found in the system.
 * It can happen when searching by ID or plate.
 */
public class VehicleNotFoundException extends Exception {

    private String searchValue;

    // constructor with default message
    public VehicleNotFoundException(String searchValue) {
        super("Vehicle not found: " + searchValue);
        this.searchValue = searchValue;
    }

    // constructor with custom message
    public VehicleNotFoundException(String searchValue, String message) {
        super(message);
        this.searchValue = searchValue;
    }

    // returns searched value
    public String getSearchValue() {
        return searchValue;
    }
}
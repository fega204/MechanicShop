// ============================================================
// File:        VehicleNotFoundException.java
// Author:      [Your Name]
// Date:        2025
// Program:     Mechanic Shop Management System
// Description: Custom exception thrown when a vehicle lookup
//              fails to find a matching record in the database.
//              Used in CRUD read, update, and delete operations.
// Inputs:      Vehicle ID or license plate that was not found
// Processing:  Extends Exception with a descriptive message
// Outputs:     Exception message with the missing vehicle info
// ============================================================

package exceptions;

/**
 * Thrown when a vehicle cannot be found in the database.
 */
public class VehicleNotFoundException extends Exception {

    private String searchValue;

    /**
     * Constructs exception with a descriptive message.
     * @param searchValue the ID or plate that was searched
     */
    public VehicleNotFoundException(String searchValue) {
        super("Vehicle not found: '" + searchValue + "'. "
            + "Please verify the vehicle ID or license plate and try again.");
        this.searchValue = searchValue;
    }

    /**
     * Constructs exception with a custom message.
     * @param searchValue the ID or plate that was searched
     * @param message     custom error message
     */
    public VehicleNotFoundException(String searchValue, String message) {
        super(message);
        this.searchValue = searchValue;
    }

    /**
     * Returns the value that was searched but not found.
     * @return the search value string
     */
    public String getSearchValue() {
        return searchValue;
    }
}
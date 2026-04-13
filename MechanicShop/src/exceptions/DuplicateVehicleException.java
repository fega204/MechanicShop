// ============================================================
// File:        DuplicateVehicleException.java
// Author:      [Your Name]
// Date:        2025
// Program:     Mechanic Shop Management System
// Description: Custom exception thrown when attempting to add
//              a vehicle whose license plate already exists in
//              the database. Prevents duplicate data entries.
// Inputs:      License plate of the duplicate vehicle
// Processing:  Extends Exception with a descriptive message
// Outputs:     Exception message identifying the duplicate plate
// ============================================================

package exceptions;

/**
 * Thrown when a vehicle with the same license plate already exists.
 */
public class DuplicateVehicleException extends Exception {

    private String licensePlate;

    /**
     * Constructs exception with the duplicate license plate.
     * @param licensePlate the plate that caused the conflict
     */
    public DuplicateVehicleException(String licensePlate) {
        super("A vehicle with license plate '" + licensePlate
            + "' already exists in the system. "
            + "Please check the license plate and try again.");
        this.licensePlate = licensePlate;
    }

    /**
     * Constructs exception with a custom message.
     * @param licensePlate the plate that caused the conflict
     * @param message      custom error message
     */
    public DuplicateVehicleException(String licensePlate, String message) {
        super(message);
        this.licensePlate = licensePlate;
    }

    /**
     * Returns the license plate that caused the duplicate conflict.
     * @return the license plate string
     */
    public String getLicensePlate() {
        return licensePlate;
    }
}
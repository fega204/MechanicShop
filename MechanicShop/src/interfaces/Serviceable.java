// ============================================================
// File:        Serviceable.java
// Author:      [Your Name]
// Date:        2025
// Program:     Mechanic Shop Management System
// Description: Interface defining service-related operations
//              that any serviceable vehicle must implement.
//              Provides contract for service cost calculation
//              and service scheduling across all vehicle types.
// Inputs:      N/A (interface only)
// Processing:  Defines method signatures for implementors
// Outputs:     N/A (interface only)
// ============================================================

package interfaces;

/**
 * Serviceable interface defines the contract for all vehicles
 * that can be serviced at the mechanic shop.
 */
public interface Serviceable {

    /**
     * Calculates the service cost for this vehicle.
     * @return the cost of service as a double
     */
    double getServiceCost();

    /**
     * Schedules a service for this vehicle.
     * @param serviceDate the date for the service (format: YYYY-MM-DD)
     * @param description a description of the service to be performed
     */
    void scheduleService(String serviceDate, String description);

    /**
     * Returns a summary of the vehicle's service status.
     * @return formatted string describing current service status
     */
    String getServiceStatus();
}
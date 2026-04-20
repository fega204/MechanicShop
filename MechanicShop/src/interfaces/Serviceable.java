package interfaces;

/*
 * This interface is used for vehicles
 * that can receive service.
 * Any class that uses this must
 * create these methods.
 */
public interface Serviceable {

    // returns the cost of the service
    double getServiceCost();

    // used to schedule a service date
    void scheduleService(String serviceDate, String description);

    // returns current service info
    String getServiceStatus();
}
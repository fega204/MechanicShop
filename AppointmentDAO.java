package mechanic.exception;

public class CustomerNotFoundException extends Exception {
    public CustomerNotFoundException(int id) {
        super("Customer with ID " + id + " was not found.");
    }

    public CustomerNotFoundException(String name) {
        super("Customer '" + name + "' was not found.");
    }
}

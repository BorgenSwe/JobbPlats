
package Controller;

/**
 * Thrown if an availability was invalid. 
 * @author 573w3
 */
public class InvalidAvailabilityException extends Exception {

    /**
     * Creates a new instance of
     * <code>InvalidAvailabilityException</code> without detail message.
     */
    public InvalidAvailabilityException() {
    }

    /**
     * Constructs an instance of
     * <code>InvalidAvailabilityException</code> with the specified detail
     * message.
     *
     * @param msg the detail message.
     */
    public InvalidAvailabilityException(String msg) {
        super(msg);
    }
}

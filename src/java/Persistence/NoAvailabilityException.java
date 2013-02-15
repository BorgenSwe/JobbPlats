
package Persistence;

/**
 * This exception is thrown when a registration DTO contains no availabilities.
 * @author Joakim
 */
public class NoAvailabilityException extends Exception {

    /**
     * Creates a new instance of
     * <code>NoAvailabilityException</code> without detail message.
     */
    public NoAvailabilityException() {
    }

    /**
     * Constructs an instance of
     * <code>NoAvailabilityException</code> with the specified detail message.
     *
     * @param msg the detail message.
     */
    public NoAvailabilityException(String msg) {
        super(msg);
    }
}

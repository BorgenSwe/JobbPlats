
package Persistence;

/**
 * Is thrown when the data in the RegistrationDTO object is not valid.
 * @author Joakim Borgström
 */
public class RegistrationNotValidException extends Exception {

    /**
     * Creates a new instance of
     * <code>RegistrationNotValidException</code> without detail message.
     */
    public RegistrationNotValidException() {
    }

    /**
     * Constructs an instance of
     * <code>RegistrationNotValidException</code> with the specified detail
     * message.
     *
     * @param msg the detail message.
     */
    public RegistrationNotValidException(String msg) {
        super(msg);
    }
}


package Controller;

/**
 * Thrown in case a registration could not be registered in the database
 * @author Joakim
 */
public class RegistrationUnsuccessfulException extends Exception {

    /**
     * Creates a new instance of
     * <code>RegistrationDataInvalid</code> without detail message.
     */
    public RegistrationUnsuccessfulException() {
    }

    /**
     * Constructs an instance of
     * <code>RegistrationDataInvalid</code> with the specified detail message.
     *
     * @param msg the detail message.
     */
    public RegistrationUnsuccessfulException(String msg) {
        super(msg);
    }
}


package Controller;

/**
 *
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

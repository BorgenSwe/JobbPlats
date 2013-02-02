
package Persistence;

/**
 * This exception is thrown when a competence id does not match with any 
 * competence in the database
 * @author Jocke
 */
public class InvalidCompetenceException extends Exception {

    /**
     * Creates a new instance of
     * <code>InvalidCompetenceException</code> without detail message.
     */
    public InvalidCompetenceException() {
    }

    /**
     * Constructs an instance of
     * <code>InvalidCompetenceException</code> with the specified detail
     * message.
     *
     * @param msg the detail message.
     */
    public InvalidCompetenceException(String msg) {
        super(msg);
    }
}

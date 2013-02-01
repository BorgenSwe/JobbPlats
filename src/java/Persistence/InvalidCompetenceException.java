/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistence;

/**
 *
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

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

/**
 *
 * @author 573w3
 */
@Named(value = "registrationManager")
@SessionScoped
public class RegistrationManager implements Serializable {

    /**
     * Creates a new instance of RegistrationManager
     */
    public RegistrationManager() {
    }
}

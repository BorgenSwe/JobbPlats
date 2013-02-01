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

    @EJB
    RegistrationBean registrationBean;
    
    RegistrationDTOImpl registrationDTO;
    
    /**
     * Creates a new instance of RegistrationManager
     */
    public RegistrationManager() {
        
    }
    
    public String getSurname() {
        return registrationDTO.surname;
    }
    public void setSurname(String surname) {
        registrationDTO.surname = surname;
    }
}

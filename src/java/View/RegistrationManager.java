/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.RegistrationBean;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;

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
    List competenceNames;
    
    /**
     * Creates a new instance of RegistrationManager
     */
    public RegistrationManager() {
        registrationDTO = new RegistrationDTOImpl();
        competenceNames = registrationBean.getAllCompetences();
    }
    
    public String getName() {
        return registrationDTO.getName();
    }
    public void setName(String name) {
        registrationDTO.setName(name);
    }
    
    public String getSurname() {
        return registrationDTO.getSurname();
    }
    public void setSurname(String surname) {
        registrationDTO.setSurname(surname);
    }
    
    public String getSsn() {
        return registrationDTO.getSsn();
    }
    public void setSsn(String ssn) {
        registrationDTO.setSsn(ssn);
    }
    
    public String getEmail() {
        return registrationDTO.getEmail();
    }
    public void setEmail(String email) {
        registrationDTO.setEmail(email);
    }
    
    public void getCompetence() {}
    public void setCompetenc() {
        registrationDTO.addCompetence();
    }
    
    //public String getCompetenceNames
}

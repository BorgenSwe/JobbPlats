
package View;

import Controller.RegistrationBean;
import Persistence.CompetenceDTO;
import java.io.Serializable;
import java.util.List;
import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 * This managed bean represents the view for the registration.
 * It serves requests coming from index.xhtml
 * @author 573w3
 */
@Named(value = "registrationManager")
@ManagedBean
@RequestScoped
public class RegistrationManager implements Serializable {

    @EJB
    private RegistrationBean registrationBean;
    
    private RegistrationDTOImpl registrationDTO;
    private List<CompetenceDTO> competenceNames;
    
    /**
     * Creates a new instance of RegistrationManager
     */ 
    public RegistrationManager() {
    }
    
    @PostConstruct
    private void init() {
        registrationDTO = new RegistrationDTOImpl();
        competenceNames = registrationBean.getAllCompetences();
    }
    
    /***************
     * GET and SET * 
     ***************/
    public String getSurname() {
        return registrationDTO.getSurname();
    }
    public void setSurname(String surname) {
        registrationDTO.setSurname(surname);
    }
    
    public String getName() {
        return registrationDTO.getName();
    }
    public void setName(String name) {
        registrationDTO.setName(name);
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
    
    public CompetenceProfileDTO[] getCompetenceProfileDTO() {
        return registrationDTO.getCompetence();
    }
    
    public AvailabilityDTO[] getAvailabilityDTO() {
        return registrationDTO.getAvailabilty();
    }
    
    public List<CompetenceDTO> getCompetenceNames() {
        return competenceNames;
    }
}

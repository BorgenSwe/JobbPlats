
package View;

import Controller.RegistrationBean;
import Controller.RegistrationUnsuccessfulException;
import Persistence.CompetenceDTO;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    public RegistrationDTOImpl getRegistrationDTO(){
        return registrationDTO;
    }
    public void setRegistrationDTO(RegistrationDTOImpl registrationDTO){
        this.registrationDTO = registrationDTO;
    }
    
    /**
     * Gets all the competence options available
     * @return competence options
     */
    public List<CompetenceDTO> getCompetenceNames() {
        return competenceNames;
    }
    
    /**
     * Registers the job application
     */
    public String register() {
        String result = "failure";
        try {
            result = registrationBean.register(registrationDTO);
        } catch (RegistrationUnsuccessfulException ex) {
            Logger.getLogger(RegistrationManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
}

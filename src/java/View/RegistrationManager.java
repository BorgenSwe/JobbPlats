
package View;

import Controller.RegistrationBean;
import Persistence.CompetenceDTO;
import java.io.Serializable;
import java.util.List;
import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Named;

/**
 * This managed bean represents the view for the registration.
 * It serves requests coming from index.xhtml
 * @author 573w3
 */
@Named(value = "registrationManager")
@ManagedBean
@SessionScoped
public class RegistrationManager implements Serializable {

    @EJB
    private RegistrationBean registrationBean;
    
    private String surname;
    
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
        System.out.println("GGGGGG surname");
        return "hej";
    }
    
    public void setSurname(String surname) {
        System.out.println("setting surname");
        this.surname = surname;
        //registrationDTO.setSurname(surname);
    }
    
    public String getName() {
        return null;
    }
    public void setName(String name) {
        registrationDTO.setName(name);
    }
    
    public String getSsn() {
        return null;
    }
    public void setSsn(String ssn) {
        registrationDTO.setSsn(ssn);
    }
    
    public String getEmail() {
        return null;
    }
    public void setEmail(String email) {
        registrationDTO.setEmail(email);
    }
    
    public CompetenceProfileDTOImpl[] getCompetenceProfileDTOImpl() {
        return registrationDTO.getCompetence();
    }
    
    public AvailabilityDTOImpl[] getAvailabilityDTOImpl() {
        return registrationDTO.getAvailabilty();
    }
    
    public List<CompetenceDTO> getCompetenceNames() {
        System.out.println("comp managed");
        return competenceNames;
    }
    
    public void register() {
        System.out.println("reg from managed");
        registrationBean.register(registrationDTO);
    }
    
    
}

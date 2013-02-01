/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Persistence.Competence;
import Controller.RegistrationBean;
import Persistence.CompetenceDTO;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.Iterator;
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
    List<CompetenceDTO> competenceNames;
    Competence competence;
    float competenceYears;
    
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
    
    public CompetenceProfileDTO[] getCompetenceProfileDTO() {
        return registrationDTO.getCompetence();
    }
    
    public void getSelectedCompetence() {}
    public void setSelectedCompetence(long id) {
        Iterator<CompetenceDTO> iterator = competenceNames.iterator();
        
        while (iterator.hasNext()) {
            CompetenceDTO c = iterator.next();
            if (c.getId() == id) {
                //competence = c;
            }
        }
    }
    
    public void setYears() {}
    public void setYear(float years) {
        this.competenceYears = years;
    }
    
    public void getCompetence(){}
    public void setCompetence() {
        //registrationDTO.setCompetence(0, competence, competenceYears);
    }
    
    public List<CompetenceDTO> getCompetenceNames() {
        return competenceNames;
    }
}


package Controller;

import Persistence.CompetenceDTO;
import Persistence.InvalidCompetenceException;
import Persistence.RegistrationDOA;
import View.AvailabilityDTOImpl;
import View.RegistrationDTOImpl;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 * EJB that operates in the applications business layer. 
 * The RegistrationManager class injects this EJB and uses it to process 
 * business logic and communicate with the persistence layer. 
 * @author 573w3
 */
@Stateless
public class RegistrationBean {

    @Inject
    private RegistrationDOA persistence;
    
    /**
     * Retrieves all possible types of competences from the persistence
     * @return All competence types
     */
    public List<CompetenceDTO> getAllCompetences() {
        return persistence.getAllComptences();
    }
    
    /**
     * Registers a job application 
     * @param registration 
     */
    public String register(RegistrationDTOImpl registration) throws RegistrationUnsuccessfulException {
        try {
            View.CompetenceProfileDTO[] comps = registration.getCompetence();
            List<View.CompetenceProfileDTO> newComps = new LinkedList<View.CompetenceProfileDTO>();
            for (int i = 0; i < comps.length; i++) {
                if (comps[i].getYears() > 0) {
                    newComps.add(comps[i]);
                }
            }
            registration.setCompetence(newComps.toArray(
                    new View.CompetenceProfileDTOImpl[newComps.size()]));
            
            AvailabilityDTOImpl[] avails = registration.getAvailability();
            List<View.AvailabilityDTOImpl> newAvails = new LinkedList<View.AvailabilityDTOImpl>();
            for (int i = 0; i < avails.length; i++) {
                if (avails[i].getFrom() != null) {
                    newAvails.add(avails[i]);
                }
            }
            registration.setAvailability(newAvails.toArray(
                    new View.AvailabilityDTOImpl[newAvails.size()]));
            
            persistence.register(registration);
        } catch (InvalidCompetenceException ex) {
            Logger.getLogger(RegistrationBean.class.getName()).log(Level.SEVERE, null, ex);
            throw new RegistrationUnsuccessfulException("The registration data is invalid. Caused by:" + ex.getMessage());
        }
        return "success";
    }
}

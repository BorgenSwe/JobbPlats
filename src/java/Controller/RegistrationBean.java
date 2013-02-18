
package Controller;

import Persistence.CompetenceDTO;
import Persistence.InvalidCompetenceException;
import Persistence.NoAvailabilityException;
import Persistence.RegistrationDOA;
import Persistence.RegistrationNotValidException;
import View.AvailabilityDTOImpl;
import View.RegistrationDTOImpl;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import javax.annotation.PostConstruct;
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
    
    private static final Logger LOGGER = Logger.getLogger(
                                              RegistrationBean.class.getName());
    
    @Inject
    private RegistrationDOA persistence;
    
    @PostConstruct
    void initilize() {
        try {
                FileHandler fileHandler = new FileHandler("%h/log.txt");
                fileHandler.setFormatter(new SimpleFormatter());
                RegistrationBean.LOGGER.addHandler(fileHandler);
            } catch (IOException ex) {
                System.err.println(ex);
            } catch (SecurityException ex) {
                System.err.println(ex);
            }
    }
    
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
    public String register(RegistrationDTOImpl registration) {
        if (registration.getSsn().length() == 13) {
            registration.setSsn(registration.getSsn().substring(0, 8) + 
                                        registration.getSsn().substring(9, 13));
        }
        
        try {
            View.CompetenceProfileDTO[] comps = registration.getCompetence();
            List<View.CompetenceProfileDTO> newComps = 
                                    new LinkedList<View.CompetenceProfileDTO>();
            for (int i = 0; i < comps.length; i++) {
                if (comps[i].getYears() > 0) {
                    newComps.add(comps[i]);
                }
            }
            registration.setCompetence(newComps.toArray(
                    new View.CompetenceProfileDTOImpl[newComps.size()]));
            
            AvailabilityDTOImpl[] avails = registration.getAvailability();
            List<View.AvailabilityDTOImpl> newAvails = 
                                    new LinkedList<View.AvailabilityDTOImpl>();
            for (int i = 0; i < avails.length; i++) {
                if (avails[i].getFrom() != null) {
                    if (avails[i].getTo() != null) {
                        if (avails[i].getFrom().compareTo(avails[i]
                                                               .getTo()) >= 0) {
                            throw new InvalidAvailabilityException(
                                    "The 'from date': " + 
                                    avails[i].getStringFrom() + 
                                    " must occur before the 'to date': " + 
                                    avails[i].getStringTo());
                        }
                    }
                    
                    newAvails.add(avails[i]);
                }
            }
            registration.setAvailability(newAvails.toArray(
                    new View.AvailabilityDTOImpl[newAvails.size()]));
            
            persistence.register(registration);
        } catch (InvalidCompetenceException ex) {
            RegistrationBean.LOGGER.log(Level.SEVERE, ex.toString());
            return "failure";
        } catch (NoAvailabilityException ex) {
            RegistrationBean.LOGGER.log(Level.SEVERE, ex.toString());
            return "failure";
        } catch (RegistrationNotValidException ex) {
           RegistrationBean.LOGGER.log(Level.SEVERE, ex.toString());
            return "failure";
        } catch (InvalidAvailabilityException ex) {
            RegistrationBean.LOGGER.log(Level.SEVERE, ex.toString());
            return "failure";
        } catch(Exception ex) {
            RegistrationBean.LOGGER.log(Level.SEVERE, ex.toString());
            return "failure";
        }
        return "success";
    }
}


package Persistence;

import Controller.RegistrationBean;
import View.RegistrationDTO;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 * Implementation of the RegistrationDOA. This will handle all transactions made 
 * during the registration of an application by a user.
 * @author Jocke
 */
public class RegistrationDOAImpl implements RegistrationDOA{
    
    private static final Logger LOGGER = Logger.getLogger(
                                              RegistrationBean.class.getName());

    @PersistenceContext(unitName = "JobbPlatsPU")
    private EntityManager em;
    
    @PostConstruct
    void initilize() {
        try {
                FileHandler fileHandler = new FileHandler("%h/log.txt");
                fileHandler.setFormatter(new SimpleFormatter());
                RegistrationDOAImpl.LOGGER.addHandler(fileHandler);
            } catch (IOException ex) {
                System.err.println(ex);
            } catch (SecurityException ex) {
                System.err.println(ex);
            }
    }
    
    /**
     * Register the applicant in the RegistrationDTO object and stores it in the 
     * data base. 
     * @param registration The registration to store.
     * @throws InvalidCompetenceException If the registration contains invalid 
     * competences.
     * @throws NoAvailabilityException If the registration contains no 
     * availabilities.
     * @throws RegistrationNotValidException The data in the registration 
     * parameter is not valid. At least one of the fields in the RegistrationDTO
     * is null.
     */
    @Override
    public void register(RegistrationDTO registration) throws 
            InvalidCompetenceException, NoAvailabilityException, 
            RegistrationNotValidException{
        
        if(registration.getName() == null 
                || registration.getSurname() == null 
                || registration.getSsn() == null
                || registration.getEmail() == null
                || registration.getCompetence() == null
                || registration.getAvailability() == null){
            throw new RegistrationNotValidException("At least one field in the "
                    + "RegistrationDTO is null. Cannot continue task!");
        }
        
        if(registration.getAvailability().length < 1){
            throw new NoAvailabilityException("Applicant does not have any "
                    + "availabilities. Cannot continue task!");
        }
        
        Applicant applicant = new Applicant();
        applicant.setName(registration.getName());
        applicant.setSurname(registration.getSurname());
        applicant.setSsn(registration.getSsn());
        applicant.setEmail(registration.getEmail());
        
        List<CompetenceProfile> competences = new ArrayList();
        List<Availability> availabilities = new ArrayList();
        
        for(View.CompetenceProfileDTO tempComptenceProfile : registration.getCompetence()){
            CompetenceProfile newCompetenceProfile = new CompetenceProfile();
            newCompetenceProfile.setYears(tempComptenceProfile.getYears());
            Competence realCompetence = 
                    (Competence) tempComptenceProfile.getCompetenceDTO();
            if(realCompetence == null) {
                throw new InvalidCompetenceException("One or more of the "
                        + "competences id does not correspond with the "
                        + "Database. Cannot continue task!");
            }
            newCompetenceProfile.setCompetenceType(realCompetence);
            newCompetenceProfile.setApplicant(applicant);
            competences.add(newCompetenceProfile);
        }
        
        for(View.AvailabilityDTO tempAvailability : registration.getAvailability()){
            Availability newAvailability = new Availability();
            newAvailability.setDatefrom(tempAvailability.getFrom());
            newAvailability.setDateto(tempAvailability.getTo());
            newAvailability.setApplicant(applicant);
            availabilities.add(newAvailability);
        }
        
        applicant.setAvailability(availabilities);
        applicant.setCompetence(competences);
        
        em.persist(applicant);
        RegistrationDOAImpl.LOGGER.log(Level.INFO, 
                "Applicant stored in persistent context: " + applicant, this);
    }

    /**
     * Retrieves and returns all competence types from storage.
     * @return List of competences.
     */
    @Override
    public List<CompetenceDTO> getAllComptences() {
        Query query = em.createQuery(
           "select c from Competence c");
        return query.getResultList(); 
    }
}

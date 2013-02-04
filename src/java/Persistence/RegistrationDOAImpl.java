
package Persistence;

import View.RegistrationDTO;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 * Implementation of the RegistrationDOA. This will handle all transactions made 
 * during the registration of an application by a user.
 * @author Jocke
 */
//@Stateless
public class RegistrationDOAImpl implements RegistrationDOA{

    @PersistenceContext(unitName = "JobbPlatsPU")
    private EntityManager em;
    
    /**
     * Register the applicant in the RegistrationDTO object and stores it in the 
     * data base. 
     * @param registration The registration to store.
     * @throws InvalidCompetenceException If the registration contains invalid 
     * competences.
     */
    @Override
    public void register(RegistrationDTO registration) throws InvalidCompetenceException{
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
            Competence realCompetence = em.find(Competence.class, tempComptenceProfile.getCompetenceDTO().getId());
            if(realCompetence == null) {
                throw new InvalidCompetenceException("One or more of the competences id does not correspond with the Database");
            }
            newCompetenceProfile.setCompetenceType(realCompetence);
            competences.add(newCompetenceProfile);
        }
        for(View.AvailabilityDTO tempAvailability : registration.getAvailabilty()){
            Availability newAvailability = new Availability();
            newAvailability.setDatefrom(tempAvailability.getFrom());
            newAvailability.setDateto(tempAvailability.getTo());
            availabilities.add(newAvailability);
        }
        
        applicant.setAvailability(availabilities);
        applicant.setCompetence(competences);
        
        em.persist(applicant);
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

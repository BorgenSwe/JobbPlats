
package Persistence;

import View.RegistrationDTO;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Jocke
 */
public class RegistrationDOAImpl implements RegistrationDOA{

    @PersistenceContext(unitName = "JobbPlatsPU")
    private EntityManager em;
    
    @Override
    public void register(RegistrationDTO registration) {
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
            Competence realCompetence = em.find(Competence.class, tempComptenceProfile.getId());
            //if(realCompetence == null)
                //Throw exception
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

    @Override
    public List<Competence> getAllComptences() {
        return (List)new ArrayList<CompetenceDTO>();
    }
}

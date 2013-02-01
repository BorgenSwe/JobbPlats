
package Persistence;

import View.RegistrationDTO;
import java.util.List;

/**
 * Public interface for the registration in the Persistance layer
 * @author Jocke
 */
public interface RegistrationDOA{
    /**
     * Register the applicant in the RegistrationDTO object and stores it in the 
     * data base. 
     * @param registration The registration to store.
     * @throws InvalidCompetenceException If the registration contains invalid 
     * competences.
     */
    public void register(RegistrationDTO registration) throws InvalidCompetenceException;
    
    /**
     * Retrieves and returns all competence types from storage.
     * @return List of competences.
     */
    public List<CompetenceDTO> getAllComptences();
}

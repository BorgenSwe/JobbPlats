
package Persistence;

import View.RegistrationDTO;
import java.util.List;

/**
 * Public interface for the registration in the persistence layer
 * @author Jocke
 */
public interface RegistrationDOA{
    /**
     * Register the applicant in the RegistrationDTO object and stores it in the 
     * data base. 
     * @param registration The registration to store.
     * @throws InvalidCompetenceException If the registration contains invalid 
     * competences.
     * @throws NoAvailabilityException If the registration contains no 
     * availabilities.
     * @throws RegistrationNotValidException The data in the registration 
     * parameter is not valid.
     */
    public void register(RegistrationDTO registration) throws 
            InvalidCompetenceException, NoAvailabilityException, 
            RegistrationNotValidException;
    
    /**
     * Retrieves and returns all competence types from storage.
     * @return List of competences.
     */
    public List<CompetenceDTO> getAllComptences();
}

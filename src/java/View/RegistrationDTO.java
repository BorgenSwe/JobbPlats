
package View;

/**
 * DTO for the data necessary to make a job application registration
 * @author Jocke
 */
public interface RegistrationDTO {
    /***************
     * GET and SET * 
     ***************/
    public String getName();
    public String getSurname();
    public String getSsn();
    public String getEmail();
    public CompetenceProfileDTO[] getCompetence();
    public AvailabilityDTO[] getAvailability();
}

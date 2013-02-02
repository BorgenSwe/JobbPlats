
package Persistence;

import java.util.List;

/**
 * DTO of applicant
 * @author Joakim
 */
public interface ApplicantDTO extends PersonDTO{
    /***************
     * GET and SET * 
     ***************/
    public String getSsn();
    public String getEmail();
    public List<AvailabilityDTO> getAvailabilityDTO();
    public List<CompetenceProfileDTO> getCompetenceDTO();
}

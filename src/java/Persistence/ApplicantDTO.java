
package Persistence;

import java.util.List;

/**
 *
 * @author Joakim
 */
public interface ApplicantDTO extends PersonDTO{
    /***************
     * GET and SET * 
     ***************/
    public Long getId();
    public String getSsn();
    public String getEmail();
    public List<AvailabilityDTO> getAvailabilityDTO();
    public List<CompetenceProfileDTO> getCompetenceDTO();
}

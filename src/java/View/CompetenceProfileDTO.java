
package View;

import Persistence.CompetenceDTO;

/**
 * DTO of a CompetenceProfile used in registration
 * @author Jocke
 */
public interface CompetenceProfileDTO {
    /***************
     * GET and SET * 
     ***************/
    public CompetenceDTO getCompetenceDTO();
    public float getYears();
}

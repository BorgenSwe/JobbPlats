
package View;

import Persistence.CompetenceDTO;

/**
 * DTO used for holding a given competence profile coming from the view going 
 * down towards the persistence layer. 
 * @author 573w3
 */
public class CompetenceProfileDTOImpl implements CompetenceProfileDTO {

    private CompetenceDTO compDTO;
    private float years;
    
    /***************
     * GET and SET * 
     ***************/
    @Override
    public CompetenceDTO getCompetenceDTO() {
        return compDTO;
    }
    public void setCompetenceDTO(CompetenceDTO compDTO) {
        this.compDTO = compDTO;
    }

    @Override
    public float getYears() {
        return years;
    }
    public void setYears(float years) {
        this.years = years;
    }
}

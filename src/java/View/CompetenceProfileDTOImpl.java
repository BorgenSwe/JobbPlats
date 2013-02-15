
package View;

import Persistence.CompetenceDTO;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;

/**
 * DTO used for holding a given competence profile coming from the view going 
 * down towards the persistence layer. 
 * @author 573w3
 */
public class CompetenceProfileDTOImpl implements CompetenceProfileDTO {

    private CompetenceDTO compDTO;
    @DecimalMin("0.00")
    @DecimalMax("100.00")
    @Digits(integer=3, fraction=2)
    private float years;
    
    public CompetenceProfileDTOImpl(){
        years = 0;
    }
    
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

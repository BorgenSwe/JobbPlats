
package View;

/**
 * DTO used for holding a given competence profile coming from the view going 
 * down towards the persistence layer. 
 * @author 573w3
 */
public class CompetenceProfileDTOImpl implements CompetenceProfileDTO {

    private int id;
    private float years;
    
    /***************
     * GET and SET * 
     ***************/
    @Override
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public float getYears() {
        return years;
    }
    public void setYears(float years) {
        this.years = years;
    }
}

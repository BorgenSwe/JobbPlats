/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

/**
 *
 * @author 573w3
 */
public class CompetenceProfileDTOImpl implements CompetenceProfileDTO {

    private int id;
    private float years;
    
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

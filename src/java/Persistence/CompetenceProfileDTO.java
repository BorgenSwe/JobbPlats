
package Persistence;

/**
 * DTO of CompetenceProfile
 * @author Joakim
 */
public interface CompetenceProfileDTO {
    /***************
     * GET and SET * 
     ***************/
    public Long getId();
    public float getYears();
    public Competence getCompetenceType();
}

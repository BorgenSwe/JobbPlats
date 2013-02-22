
package Persistence;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * An object of this class functions as a filter when retrieving applicants from
 * the persistence layer.
 * @author Joakim Borgström
 */
public class ApplicantFilter {
    /**
     * Constant used to signal the filter to include applicants that have 
     * available time after the filter time.
     */
    public final static int BEFORE = 1;
    /**
     * Constant used to signal the filter to include applicants that have 
     * available time before the filter time.
     */
    public final static int AFTER = 2;
    /**
     * Constant used to signal the filter to include applicants that have 
     * the specified competence
     */
    public final static int INCLUDE = 1;
    /**
     * Constant used to signal the filter to include applicants that don't 
     * have the specified competence
     */
    public final static int EXCLUDE = 2;
    
    private List<Filter> filters;
    
    /**
     * Constructor
     */
    public ApplicantFilter(){
        filters = new ArrayList();
    }
    
    /**
     * Adds a time filter to this filter. The option parameter can be 
     * <code>BEFORE</code> or <code>AFTER</code> which are statics in the
     * ApplicantFilter class.<br/><br/>
     * 
     * <code>BEFORE</code> - Constant used to signal the filter to include applicants that have 
     * available time after the filter time.<br/><br/>
     *
     * <code>AFTER</code> - Constant used to signal the filter to include applicants that have 
     * available time before the filter time.
     * 
     * @param time The time to filter
     * @param option The option
     */
    public void addTimeFilter(Date time, int option){
        if((option == BEFORE || option == AFTER) && time != null) {
            filters.add(new TimeFilter(time, option));
        }
        else {
            throw new RuntimeException("The time is null or the option"
                    + " is illegal");
        }
    }
    
    /**
     * Adds a competence filter to this filter. The option parameter can be 
     * <code>INCLUDE</code> or <code>EXCLUDE</code> which are statics in the
     * ApplicantFilter class.<br/><br/>
     * 
     * <code>INCLUDE</code> - Constant used to signal the filter to include applicants that have 
     * the specified competence<br/><br/>
     * 
     * <code>EXCLUDE</code> - Constant used to signal the filter to include applicants that don't 
     * have the specified competence
     * 
     * @param competence The competence to filter
     * @param option The option
     */
    public void addCompetenceFilter(CompetenceDTO competence, int option){
        if((option == EXCLUDE || option == INCLUDE) && competence != null) {
            filters.add(new CompetenceFilter(competence, option));
        }
        else {
            throw new RuntimeException("The competence is null or the option"
                    + " is illegal");
        }
    }
    
    /**
     * Filter the list of applicants and returns a new list of accepted 
     * applicants
     * @param applicants the unfiltered input list
     * @return the filtered list
     */
    protected List<ApplicantDTO> filter(List<ApplicantDTO> applicants){
        List<ApplicantDTO> accepted = new ArrayList();
        for(ApplicantDTO applicant : applicants){
            boolean success = true;
            for(int t = 0 ; t < filters.size() && success ; t++){
                success = filters.get(t).checkFilter(applicant);
            }
            if(success){
                accepted.add(applicant);
            }
        }
        return accepted;
    }
    
    private interface Filter{
        public boolean checkFilter(ApplicantDTO applicant);
    }
    private class TimeFilter implements Filter{
        public Date time;
        public int option;
        public TimeFilter(Date time, int option){
            this.option = option;
            this.time = time;
        }
        @Override
        public boolean checkFilter(ApplicantDTO applicant){
            for(AvailabilityDTO availability : applicant.getAvailabilityDTO()){
                if(option == ApplicantFilter.AFTER 
                        && availability.getDateto().getTime() >= time.getTime()){
                    return true;
                }
                if(option == ApplicantFilter.BEFORE 
                        && availability.getDatefrom().getTime() <= time.getTime()){
                    return true;
                }
            }
            return false;
        }
    }
    private class CompetenceFilter implements Filter{
        public CompetenceDTO competence;
        public int option;
        public CompetenceFilter(CompetenceDTO competence, int option){
            this.option = option;
            this.competence = competence;
        }
        @Override
        public boolean checkFilter(ApplicantDTO applicant){
            for(CompetenceProfileDTO competenceProfile : applicant.getCompetenceDTO()){
                if(competenceProfile.getCompetenceType().equals(competence)){
                    if(option == ApplicantFilter.EXCLUDE) {
                        return false;
                    }
                    else if(option == ApplicantFilter.INCLUDE) {
                        return true;
                    }
                }
            }
            if(option == ApplicantFilter.EXCLUDE) {
                return true;
            }
            else if(option == ApplicantFilter.INCLUDE) {
                return false;
            }
            
            return false;
        }
    }   
}

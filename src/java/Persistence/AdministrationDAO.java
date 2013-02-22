
package Persistence;

import java.util.List;

/**
 * This DAO interface handles the data in and out to the database concerning the
 * administration view.
 * @author Joakim Borgström
 */
public interface AdministrationDAO {
    
    /**
     * Get a list of applicants matching the given filter. 
     * If the filter parameter equals <code>null</code> all applicants are 
     * returned.
     * @param filter The filter to be used when getting the applicants
     * @return A list of applicants
     */
    public List<ApplicantDTO> getApplicants(ApplicantFilter filter);
}

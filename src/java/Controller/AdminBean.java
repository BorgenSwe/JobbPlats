
package Controller;

import Persistence.AdministrationDAO;
import Persistence.ApplicantDTO;
import Persistence.ApplicantFilter;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.inject.Inject;

/**
 * Business logic for the AdminManager
 * @author 573w3
 */
@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class AdminBean {
    
    @Inject
    private AdministrationDAO persistence;
    
    /**
     * Retrieves a list of applicants filtered by the filter
     * @param filter Optional filtering of applicants
     * @return list of applicants
     */
    public List<ApplicantDTO> getApplicants(ApplicantFilter filter) {
        return persistence.getApplicants(filter);
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
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
 *
 * @author 573w3
 */
@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class AdminBean {
    
    @Inject
    private AdministrationDAO persistence;
    
    public List<ApplicantDTO> getApplicants(ApplicantFilter filter) {
        return persistence.getApplicants(filter);
    }
}

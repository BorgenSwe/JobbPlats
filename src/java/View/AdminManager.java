package View;

import Controller.AdminBean;
import Persistence.ApplicantDTO;
import java.util.List;
import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 * View for administration. 
 * @author 573w3
 */
@Named(value = "adminManager")
@ManagedBean
@RequestScoped
public class AdminManager {

    @EJB
    private AdminBean adminBean;
    
    private List<ApplicantDTO> applicants;
    
    /**
     * Creates a new instance of AdminManager
     */
    public AdminManager() {}
    
    @PostConstruct
    void init() {
        applicants = adminBean.getApplicants(null);
    }
    
    /**
     * Asks the EJB to fetch a list of applicants
     * @return a list of all applicants
     */
    public List<ApplicantDTO> getApplicants() {
        applicants.get(0).getName();
        return applicants;
    }
}

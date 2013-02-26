/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
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
        //FacesContext.getCurrentInstance().getExternalContext().getSession(true);
    }
    
    public List<ApplicantDTO> getApplicants() {
        return applicants;
    }
}

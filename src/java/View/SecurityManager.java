
package View;

import Controller.SecurityBean;
import javax.annotation.ManagedBean;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 * Uses an EJB to log out a logged in user
 * @author 573w3
 */
@Named(value = "securityManager")
@ManagedBean
@RequestScoped
public class SecurityManager {

    @EJB
    SecurityBean securityBean;
    
    /**
     * Creates a new instance of SecurityManager
     */
    public String logout() {        
        return securityBean.logout();
    }
}

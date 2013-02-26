/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.SecurityBean;
import javax.annotation.ManagedBean;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
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

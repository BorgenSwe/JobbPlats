/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author 573w3
 */
@Stateless
public class SecurityBean {
    
    private static final Logger LOGGER = Logger.getLogger(
                                                  SecurityBean.class.getName());
    
    @PostConstruct
    void initilize() {
        try {
                FileHandler fileHandler = new FileHandler("%h/log.txt");
                fileHandler.setFormatter(new SimpleFormatter());
                SecurityBean.LOGGER.addHandler(fileHandler);
            } catch (IOException ex) {
                System.err.println(ex);
            } catch (SecurityException ex) {
                System.err.println(ex);
            }
    }

    public String logout() {
        String result = "/admin/admin?faces-redirect=true";
        
        FacesContext context = FacesContext.getCurrentInstance();
        HttpServletRequest request = (HttpServletRequest)context.getExternalContext().getRequest();
        
        try {
            request.logout();
        } catch (Exception ex) {
            SecurityBean.LOGGER.log(Level.SEVERE, ex.toString());
            result = "/error?faces-redirect=true";
        }
        
        return result;
    }
}

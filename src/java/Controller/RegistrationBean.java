/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Persistence.RegistrationDOA;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author 573w3
 */
@Stateless
public class RegistrationBean {

    @EJB
    RegistrationDOA persistence;
    
    public List getAllCompetences() {
        return null;
    }
}

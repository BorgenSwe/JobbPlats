
package Controller;

import Persistence.CompetenceDTO;
import Persistence.InvalidCompetenceException;
import Persistence.RegistrationDOA;
import View.RegistrationDTO;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 * EJB that operates in the applications business layer. 
 * The RegistrationManager class injects this EJB and uses it to process 
 * business logic and communicate with the persistence layer. 
 * @author 573w3
 */
@Stateless
public class RegistrationBean {

    @Inject
    private RegistrationDOA persistence;
    
    public List<CompetenceDTO> getAllCompetences() {
        System.out.println("return comps");
        return persistence.getAllComptences();
    }
    
    public void register(RegistrationDTO registration) {
        try {
            System.out.println("reg from EJB");
            persistence.register(registration);
        } catch (InvalidCompetenceException ex) {
            System.out.println("kan inte registrera");
            Logger.getLogger(RegistrationBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
